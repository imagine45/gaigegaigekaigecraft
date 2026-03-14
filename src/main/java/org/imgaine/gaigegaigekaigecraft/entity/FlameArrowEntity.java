package org.imgaine.gaigegaigekaigecraft.entity;

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
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
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

   public FlameArrowEntity(EntityType<FlameArrowEntity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 0;
      this.m_21557_(true);
      this.m_21530_();
      this.f_21342_ = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8097_() {
      super.m_8097_();
      this.f_19804_.m_135372_(DATA_sync, false);
      this.f_19804_.m_135372_(DATA_sync2, false);
   }

   protected PathNavigation m_6037_(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public boolean m_6785_(double distanceToClosestPlayer) {
      return false;
   }

   public boolean m_142535_(float l, float d, DamageSource source) {
      return false;
   }

   public boolean m_6469_(DamageSource damagesource, float amount) {
      if (damagesource.m_276093_(DamageTypes.f_268631_)) {
         return false;
      } else if (!(damagesource.m_7640_() instanceof ThrownPotion) && !(damagesource.m_7640_() instanceof AreaEffectCloud)) {
         if (damagesource.m_276093_(DamageTypes.f_268671_)) {
            return false;
         } else {
            return damagesource.m_276093_(DamageTypes.f_268585_) ? false : super.m_6469_(damagesource, amount);
         }
      } else {
         return false;
      }
   }

   public boolean m_5825_() {
      return true;
   }

   public void m_7380_(CompoundTag compound) {
      super.m_7380_(compound);
      compound.m_128379_("Datasync", (Boolean)this.f_19804_.m_135370_(DATA_sync));
      compound.m_128379_("Datasync2", (Boolean)this.f_19804_.m_135370_(DATA_sync2));
   }

   public void m_7378_(CompoundTag compound) {
      super.m_7378_(compound);
      if (compound.m_128441_("Datasync")) {
         this.f_19804_.m_135381_(DATA_sync, compound.m_128471_("Datasync"));
      }

      if (compound.m_128441_("Datasync2")) {
         this.f_19804_.m_135381_(DATA_sync2, compound.m_128471_("Datasync2"));
      }

   }

   public void m_6075_() {
      super.m_6075_();
      AIFlameArrowProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
   }

   protected void m_7840_(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void m_20242_(boolean ignored) {
      super.m_20242_(true);
   }

   public void m_8107_() {
      super.m_8107_();
      this.m_20242_(true);
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, 400.0);
      builder = builder.m_22268_(Attributes.f_22284_, 0.0);
      builder = builder.m_22268_(Attributes.f_22281_, 0.0);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0);
      builder = builder.m_22268_(Attributes.f_22278_, 5.0);
      builder = builder.m_22268_(Attributes.f_22280_, 0.3);
      return builder;
   }

   static {
      DATA_sync = SynchedEntityData.m_135353_(FlameArrowEntity.class, EntityDataSerializers.f_135035_);
      DATA_sync2 = SynchedEntityData.m_135353_(FlameArrowEntity.class, EntityDataSerializers.f_135035_);
   }
}
