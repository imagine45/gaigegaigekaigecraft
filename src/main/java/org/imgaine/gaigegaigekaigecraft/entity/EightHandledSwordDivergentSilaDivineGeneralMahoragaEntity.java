package org.imgaine.gaigegaigekaigecraft.entity;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.procedures.AIEightHandledSwordDivergentSilaDivineGeneralMahoragaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DieTenShadowsTechniqueProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.TenShadowsTechniqueProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
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

public class EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.EIGHT_HANDLED_SWORD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get(), world);
   }

   public EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity(EntityType<EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.xpReward = 0;
      this.setNoAi(false);
      this.setMaxUpStep(1.6F);
      this.setPersistenceRequired();
      this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OF_EXTERMINATION.get()));
      this.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()));
      this.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_BODY_CHESTPLATE.get()));
      this.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_BODY_LEGGINGS.get()));
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "mahoraga");
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.4, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 0.0;
         }

         public boolean canUse() {
            double x = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getX();
            double y = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getY();
            double z = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getZ();
            Entity entity = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this;
            Level world = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.level();
            return super.canUse() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean canUse() {
            double x = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getX();
            double y = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getY();
            double z = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getZ();
            Entity entity = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this;
            Level world = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getX();
            double y = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getY();
            double z = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getZ();
            Entity entity = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this;
            Level world = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean canUse() {
            double x = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getX();
            double y = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getY();
            double z = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getZ();
            Entity entity = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this;
            Level world = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getX();
            double y = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getY();
            double z = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.getZ();
            Entity entity = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this;
            Level world = EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
      this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public void die(DamageSource source) {
      super.die(source);
      DieTenShadowsTechniqueProcedure.execute(this.level(), this);
   }

   public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SetTagProcedure.execute(world, this);
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

   public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
      sourceentity.getItemInHand(hand);
      InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
      super.mobInteract(sourceentity, hand);
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      Level world = this.level();
      TenShadowsTechniqueProcedure.execute(world, x, y, z, this, sourceentity);
      return retval;
   }

   public void baseTick() {
      super.baseTick();
      AIEightHandledSwordDivergentSilaDivineGeneralMahoragaProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
      builder = builder.add(Attributes.MAX_HEALTH, 480.0);
      builder = builder.add(Attributes.ARMOR, 10.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 40.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && !this.isAggressive() && !this.isShiftKeyDown()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
      } else if (this.isDeadOrDying()) {
         return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
      } else if (this.isShiftKeyDown()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
      } else {
         return this.isAggressive() && event.isMoving() ? event.setAndContinue(RawAnimation.begin().thenLoop("sprint")) : event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
      }
   }

   private PlayState attackingPredicate(AnimationState event) {
      double d1 = this.getX() - this.xOld;
      double d0 = this.getZ() - this.zOld;
      float velocity = (float)Math.sqrt(d1 * d1 + d0 * d0);
      if (this.getAttackAnim(event.getPartialTick()) > 0.0F && !this.swinging) {
         this.swinging = true;
         this.lastSwing = this.level().getGameTime();
      }

      if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime()) {
         this.swinging = false;
      }

      if (this.swinging && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         return event.setAndContinue(RawAnimation.begin().thenPlay("sword_to_right"));
      } else {
         return PlayState.CONTINUE;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == State.STOPPED || !this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty")) {
         if (!this.animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
         }

         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }
      } else if (this.animationprocedure.equals("empty")) {
         this.prevAnim = "empty";
         return PlayState.STOP;
      }

      this.prevAnim = this.animationprocedure;
      return PlayState.CONTINUE;
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
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 1, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 1, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.defineId(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.class, EntityDataSerializers.BOOLEAN);
      ANIMATION = SynchedEntityData.defineId(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.class, EntityDataSerializers.STRING);
      TEXTURE = SynchedEntityData.defineId(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity.class, EntityDataSerializers.STRING);
   }
}
