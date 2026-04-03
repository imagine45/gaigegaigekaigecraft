package org.imgaine.gaigegaigekaigecraft.entity;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIUzumakiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class UzumakiEntity extends PathfinderMob {
   public static final EntityDataAccessor<Boolean> DATA_move;

   public UzumakiEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.UZUMAKI.get(), world);
   }

   public UzumakiEntity(EntityType<UzumakiEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(DATA_move, false);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
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

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      if (damagesource.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (damagesource.getDirectEntity() instanceof AbstractArrow) {
         return false;
      } else if (!(damagesource.getDirectEntity() instanceof ThrownPotion) && !(damagesource.getDirectEntity() instanceof AreaEffectCloud)) {
         if (damagesource.is(DamageTypes.FALL)) {
            return false;
         } else if (damagesource.is(DamageTypes.CACTUS)) {
            return false;
         } else if (damagesource.is(DamageTypes.DROWN)) {
            return false;
         } else if (damagesource.is(DamageTypes.LIGHTNING_BOLT)) {
            return false;
         } else if (!damagesource.is(DamageTypes.EXPLOSION) && !damagesource.is(DamageTypes.PLAYER_EXPLOSION)) {
            if (damagesource.is(DamageTypes.TRIDENT)) {
               return false;
            } else if (damagesource.is(DamageTypes.FALLING_ANVIL)) {
               return false;
            } else if (damagesource.is(DamageTypes.DRAGON_BREATH)) {
               return false;
            } else {
               return !damagesource.is(DamageTypes.WITHER) && !damagesource.is(DamageTypes.WITHER_SKULL) ? super.hurt(damagesource, amount) : false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean ignoreExplosion() {
      return true;
   }

   public boolean fireImmune() {
      return true;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putBoolean("Datamove", (Boolean)this.entityData.get(DATA_move));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Datamove")) {
         this.entityData.set(DATA_move, compound.getBoolean("Datamove"));
      }

   }

   public void baseTick() {
      super.baseTick();
      AIUzumakiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public boolean isPushedByFluid() {
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      Level world = this.level();
      return false;
   }

   public EntityDimensions getDimensions(Pose pose) {
      Level world = this.level();
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      return super.getDimensions(pose).scale((float)SizeByNBTProcedure.execute(this));
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
   }

   public void aiStep() {
      super.aiStep();
      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.1);
      builder = builder.add(Attributes.MAX_HEALTH, 400.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 5.0);
      builder = builder.add(Attributes.FLYING_SPEED, 0.1);
      return builder;
   }

   static {
      DATA_move = SynchedEntityData.defineId(UzumakiEntity.class, EntityDataSerializers.BOOLEAN);
   }
}
