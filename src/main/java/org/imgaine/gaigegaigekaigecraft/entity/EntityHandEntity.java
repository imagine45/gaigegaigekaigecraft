package org.imgaine.gaigegaigekaigecraft.entity;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIChojuroHandProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.AlwayTrueProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
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

public class EntityHandEntity extends PathfinderMob implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   public static final EntityDataAccessor<Boolean> DATA_Magma;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public EntityHandEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.ENTITY_HAND.get(), world);
   }

   public EntityHandEntity(EntityType<EntityHandEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.xpReward = 0;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "hand");
      this.entityData.define(DATA_Magma, false);
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   public boolean canCollideWith(Entity entity) {
      return true;
   }

   public boolean canBeCollidedWith() {
      Level world = ((Entity)this).level();
      double x = ((Entity)this).getX();
      double y = ((Entity)this).getY();
      double z = ((Entity)this).getZ();
      return AlwayTrueProcedure.execute();
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.break"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.break"));
   }

   public boolean hurt(DamageSource source, float amount) {
      if (source.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (!(source.getDirectEntity() instanceof ThrownPotion) && !(source.getDirectEntity() instanceof AreaEffectCloud)) {
         if (source.is(DamageTypes.FALL)) {
            return false;
         } else if (source.is(DamageTypes.CACTUS)) {
            return false;
         } else if (source.is(DamageTypes.DROWN)) {
            return false;
         } else if (source.is(DamageTypes.WITHER)) {
            return false;
         } else {
            return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
         }
      } else {
         return false;
      }
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
      compound.putBoolean("DataMagma", (Boolean)this.entityData.get(DATA_Magma));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

      if (compound.contains("DataMagma")) {
         this.entityData.set(DATA_Magma, compound.getBoolean("DataMagma"));
      }

   }

   public void baseTick() {
      super.baseTick();
      AIChojuroHandProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      Level world = this.level();
      double x = this.getX();
      double y = ((Entity)this).getY();
      double z = ((Entity)this).getZ();
      return super.getDimensions(p_33597_).scale((float)SizeByNBTProcedure.execute(this));
   }

   public boolean isPushable() {
      return false;
   }

   protected void doPush(Entity entityIn) {
   }

   protected void pushEntities() {
   }

   public void aiStep() {
      super.aiStep();
      this.updateSwingTime();
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.0);
      builder = builder.add(Attributes.MAX_HEALTH, 100.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 8.0);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      return this.animationprocedure.equals("empty") ? event.setAndContinue(RawAnimation.begin().thenLoop("idle")) : PlayState.STOP;
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("attack1"));
      } else {
         return PlayState.CONTINUE;
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
      if (this.deathTime == 1) {
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
      data.add(new AnimationController[]{new AnimationController(this, "movement", 0, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 0, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 0, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.defineId(EntityHandEntity.class, EntityDataSerializers.BOOLEAN);
      ANIMATION = SynchedEntityData.defineId(EntityHandEntity.class, EntityDataSerializers.STRING);
      TEXTURE = SynchedEntityData.defineId(EntityHandEntity.class, EntityDataSerializers.STRING);
      DATA_Magma = SynchedEntityData.defineId(EntityHandEntity.class, EntityDataSerializers.BOOLEAN);
   }
}
