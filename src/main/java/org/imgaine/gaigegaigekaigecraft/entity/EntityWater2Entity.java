package org.imgaine.gaigegaigekaigecraft.entity;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIWater2Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityWater2Entity extends PathfinderMob {
   public EntityWater2Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.ENTITY_WATER_2.get(), world);
   }

   public EntityWater2Entity(EntityType<EntityWater2Entity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 0;
      this.m_21557_(false);
      this.m_21530_();
      this.m_6210_();
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new FloatGoal(this));
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public boolean m_6785_(double distanceToClosestPlayer) {
      return false;
   }

   public void m_7355_(BlockPos pos, BlockState blockIn) {
      this.m_5496_((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.swim")), 0.15F, 1.0F);
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash"));
   }

   public boolean m_6469_(DamageSource damagesource, float amount) {
      if (damagesource.m_276093_(DamageTypes.f_268631_)) {
         return false;
      } else if (damagesource.m_7640_() instanceof AbstractArrow) {
         return false;
      } else if (damagesource.m_7640_() instanceof Player) {
         return false;
      } else if (!(damagesource.m_7640_() instanceof ThrownPotion) && !(damagesource.m_7640_() instanceof AreaEffectCloud)) {
         if (damagesource.m_276093_(DamageTypes.f_268671_)) {
            return false;
         } else if (damagesource.m_276093_(DamageTypes.f_268585_)) {
            return false;
         } else if (damagesource.m_276093_(DamageTypes.f_268722_)) {
            return false;
         } else if (damagesource.m_276093_(DamageTypes.f_268714_)) {
            return false;
         } else if (damagesource.m_276093_(DamageTypes.f_268526_)) {
            return false;
         } else if (damagesource.m_276093_(DamageTypes.f_268482_)) {
            return false;
         } else {
            return !damagesource.m_276093_(DamageTypes.f_268493_) && !damagesource.m_276093_(DamageTypes.f_268641_) ? super.m_6469_(damagesource, amount) : false;
         }
      } else {
         return false;
      }
   }

   public boolean m_5825_() {
      return true;
   }

   public void m_6075_() {
      super.m_6075_();
      AIWater2Procedure.execute(this.m_9236_(), this);
   }

   public boolean m_6094_() {
      return false;
   }

   protected void m_7324_(Entity entityIn) {
   }

   protected void m_6138_() {
   }

   public EntityDimensions m_6972_(Pose pose) {
      return super.m_6972_(pose).m_20388_(5.0F);
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.35);
      builder = builder.m_22268_(Attributes.f_22276_, 100.0);
      builder = builder.m_22268_(Attributes.f_22284_, 0.0);
      builder = builder.m_22268_(Attributes.f_22281_, 0.0);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0);
      builder = builder.m_22268_(Attributes.f_22278_, 1.0);
      builder = builder.m_22268_(Attributes.f_22282_, 1.0);
      return builder;
   }
}
