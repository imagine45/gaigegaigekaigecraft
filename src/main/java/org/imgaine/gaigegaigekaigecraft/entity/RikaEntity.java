package org.imgaine.gaigegaigekaigecraft.entity;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIRikaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DieRikaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAIProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagCursedSpritProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class RikaEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public RikaEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.RIKA.get(), world);
   }

   public RikaEntity(EntityType<RikaEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.xpReward = 0;
      this.setNoAi(false);
      this.setMaxUpStep(2.4F);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "rika");
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 0.0;
         }

         public boolean canUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canUse() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean canUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean canUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false) {
         public boolean canUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.5) {
         public boolean canUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = RikaEntity.this.getX();
            double y = RikaEntity.this.getY();
            double z = RikaEntity.this.getZ();
            Entity entity = RikaEntity.this;
            Level world = RikaEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(8, new FloatGoal(this));
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean hurt(DamageSource source, float amount) {
      return source.is(DamageTypes.FALL) ? false : super.hurt(source, amount);
   }

   public void die(DamageSource source) {
      super.die(source);
      DieRikaProcedure.execute(this.level(), this);
   }

   public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SetTagCursedSpritProcedure.execute(world, this);
      return retval;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

   }

   public void baseTick() {
      super.baseTick();
      AIRikaProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      Level world = this.level();
      double x = this.getX();
      double y = ((Entity)this).getY();
      double z = ((Entity)this).getZ();
      return super.getDimensions(p_33597_).scale((float)SizeByNBTProcedure.execute(this));
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 600.0);
      builder = builder.add(Attributes.ARMOR, 20.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 1.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && !this.isAggressive() && !this.isSprinting()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
      } else if (this.isDeadOrDying()) {
         return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
      } else if (this.isSprinting()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
      } else {
         return this.isAggressive() && event.isMoving() ? event.setAndContinue(RawAnimation.begin().thenLoop("sprint")) : event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      String syncedAnim = (String)this.entityData.get(ANIMATION);
      if (!syncedAnim.equals("undefined")) {
         this.animationprocedure = syncedAnim;
         this.entityData.set(ANIMATION, "undefined");
      }

      if (!this.animationprocedure.equals("empty") && !this.animationprocedure.equals("undefined")) {
         if (!this.animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            this.prevAnim = this.animationprocedure;
            return PlayState.CONTINUE;
         } else if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            this.prevAnim = "empty";
            return PlayState.STOP;
         } else {
            return PlayState.CONTINUE;
         }
      } else {
         this.prevAnim = "empty";
         return PlayState.STOP;
      }
   }

   protected void tickDeath() {
      ++this.deathTime;
      if (this.deathTime == 20) {
         this.remove(RemovalReason.KILLED);
         this.dropExperience();
      }

   }

   public String getSyncedAnimation() {
      return (String)this.entityData.get(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.entityData.set(ANIMATION, animation);
      this.animationprocedure = animation;
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 1, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.defineId(RikaEntity.class, EntityDataSerializers.BOOLEAN);
      ANIMATION = SynchedEntityData.defineId(RikaEntity.class, EntityDataSerializers.STRING);
      TEXTURE = SynchedEntityData.defineId(RikaEntity.class, EntityDataSerializers.STRING);
   }
}
