package org.imgaine.gaigegaigekaigecraft.entity;

import net.minecraft.world.entity.*;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIFlameArrowProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class FlameArrowEntity extends PathfinderMob {
   public static final EntityDataAccessor<Boolean> DATA_sync;
   public static final EntityDataAccessor<Boolean> DATA_sync2;

   public FlameArrowEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.FLAME_ARROW.get(), world);
   }

   public FlameArrowEntity(EntityType<? extends FlameArrowEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 0;
      this.setNoAi(true);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }


   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(DATA_sync, false);
      this.entityData.define(DATA_sync2, false);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
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
      } else if (!(damagesource.getDirectEntity() instanceof ThrownPotion) && !(damagesource.getDirectEntity() instanceof AreaEffectCloud)) {
         if (damagesource.is(DamageTypes.FALL)) {
            return false;
         } else {
            return damagesource.is(DamageTypes.CACTUS) ? false : super.hurt(damagesource, amount);
         }
      } else {
         return false;
      }
   }

   public boolean fireImmune() {
      return true;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putBoolean("Datasync", (Boolean)this.entityData.get(DATA_sync));
      compound.putBoolean("Datasync2", (Boolean)this.entityData.get(DATA_sync2));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Datasync")) {
         this.entityData.set(DATA_sync, compound.getBoolean("Datasync"));
      }

      if (compound.contains("Datasync2")) {
         this.entityData.set(DATA_sync2, compound.getBoolean("Datasync2"));
      }

   }

   public void baseTick() {
      super.baseTick();
      AIFlameArrowProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 400.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 5.0);
      builder = builder.add(Attributes.FLYING_SPEED, 0.3);
      return builder;
   }

   static {
      DATA_sync = SynchedEntityData.defineId(FlameArrowEntity.class, EntityDataSerializers.BOOLEAN);
      DATA_sync2 = SynchedEntityData.defineId(FlameArrowEntity.class, EntityDataSerializers.BOOLEAN);
   }
}
