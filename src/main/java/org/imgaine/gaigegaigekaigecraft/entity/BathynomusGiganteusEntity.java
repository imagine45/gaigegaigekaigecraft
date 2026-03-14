package org.imgaine.gaigegaigekaigecraft.entity;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AISeaSerpentProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
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
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
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

public class BathynomusGiganteusEntity extends PathfinderMob {
   public BathynomusGiganteusEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.BATHYNOMUS_GIGANTEUS.get(), world);
   }

   public BathynomusGiganteusEntity(EntityType<BathynomusGiganteusEntity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 0;
      this.m_21557_(false);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new MeleeAttackGoal(this, 1.2, false) {
         protected double m_6639_(LivingEntity entity) {
            return 0.0;
         }

         public boolean m_8036_() {
            double x = BathynomusGiganteusEntity.this.m_20185_();
            double y = BathynomusGiganteusEntity.this.m_20186_();
            double z = BathynomusGiganteusEntity.this.m_20189_();
            Entity entity = BathynomusGiganteusEntity.this;
            Level world = BathynomusGiganteusEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.f_21346_.m_25352_(2, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = BathynomusGiganteusEntity.this.m_20185_();
            double y = BathynomusGiganteusEntity.this.m_20186_();
            double z = BathynomusGiganteusEntity.this.m_20189_();
            Entity entity = BathynomusGiganteusEntity.this;
            Level world = BathynomusGiganteusEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = BathynomusGiganteusEntity.this.m_20185_();
            double y = BathynomusGiganteusEntity.this.m_20186_();
            double z = BathynomusGiganteusEntity.this.m_20189_();
            Entity entity = BathynomusGiganteusEntity.this;
            Level world = BathynomusGiganteusEntity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(4, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = BathynomusGiganteusEntity.this.m_20185_();
            double y = BathynomusGiganteusEntity.this.m_20186_();
            double z = BathynomusGiganteusEntity.this.m_20189_();
            Entity entity = BathynomusGiganteusEntity.this;
            Level world = BathynomusGiganteusEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = BathynomusGiganteusEntity.this.m_20185_();
            double y = BathynomusGiganteusEntity.this.m_20186_();
            double z = BathynomusGiganteusEntity.this.m_20189_();
            Entity entity = BathynomusGiganteusEntity.this;
            Level world = BathynomusGiganteusEntity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.f_21345_.m_25352_(5, new RandomStrollGoal(this, 1.0));
      this.f_21345_.m_25352_(6, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(7, new FloatGoal(this));
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean m_6469_(DamageSource damagesource, float amount) {
      return damagesource.m_276093_(DamageTypes.f_268722_) ? false : super.m_6469_(damagesource, amount);
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      SetTagProcedure.execute(world, this);
      return retval;
   }

   public void m_6075_() {
      super.m_6075_();
      AISeaSerpentProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      this.m_6210_();
   }

   public boolean m_6063_() {
      double x = this.m_20185_();
      double y = this.m_20186_();
      double z = this.m_20189_();
      Level world = this.m_9236_();
      return false;
   }

   public EntityDimensions m_6972_(Pose pose) {
      Level world = this.m_9236_();
      double x = this.m_20185_();
      double y = this.m_20186_();
      double z = this.m_20189_();
      return super.m_6972_(pose).m_20388_((float)SizeByNBTProcedure.execute(this));
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, 100.0);
      builder = builder.m_22268_(Attributes.f_22284_, 25.0);
      builder = builder.m_22268_(Attributes.f_22281_, 1.0);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0);
      builder = builder.m_22268_(Attributes.f_22278_, 5.0);
      builder = builder.m_22268_(Attributes.f_22282_, 1.0);
      return builder;
   }
}
