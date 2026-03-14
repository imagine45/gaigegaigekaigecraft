package org.imgaine.gaigegaigekaigecraft.entity;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIKillerProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class Killer1Entity extends Monster {
   public Killer1Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.KILLER_1.get(), world);
   }

   public Killer1Entity(EntityType<Killer1Entity> type, Level world) {
      super(type, world);
      this.m_274367_(1.0F);
      this.f_21364_ = 0;
      this.m_21557_(false);
      this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack(Items.f_42428_));
      this.m_6210_();
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.m_21573_().m_26575_().m_77355_(true);
      this.f_21345_.m_25352_(1, new MeleeAttackGoal(this, 1.2, false) {
         protected double m_6639_(LivingEntity entity) {
            return (double)(this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + entity.m_20205_());
         }

         public boolean m_8036_() {
            double x = Killer1Entity.this.m_20185_();
            double y = Killer1Entity.this.m_20186_();
            double z = Killer1Entity.this.m_20189_();
            Entity entity = Killer1Entity.this;
            Level world = Killer1Entity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.f_21346_.m_25352_(2, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = Killer1Entity.this.m_20185_();
            double y = Killer1Entity.this.m_20186_();
            double z = Killer1Entity.this.m_20189_();
            Entity entity = Killer1Entity.this;
            Level world = Killer1Entity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = Killer1Entity.this.m_20185_();
            double y = Killer1Entity.this.m_20186_();
            double z = Killer1Entity.this.m_20189_();
            Entity entity = Killer1Entity.this;
            Level world = Killer1Entity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = Killer1Entity.this.m_20185_();
            double y = Killer1Entity.this.m_20186_();
            double z = Killer1Entity.this.m_20189_();
            Entity entity = Killer1Entity.this;
            Level world = Killer1Entity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = Killer1Entity.this.m_20185_();
            double y = Killer1Entity.this.m_20186_();
            double z = Killer1Entity.this.m_20189_();
            Entity entity = Killer1Entity.this;
            Level world = Killer1Entity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.f_21345_.m_25352_(5, new RandomStrollGoal(this, 1.0));
      this.f_21345_.m_25352_(6, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(7, new FloatGoal(this));
      this.f_21345_.m_25352_(8, new MoveBackToVillageGoal(this, 0.6, false));
      this.f_21345_.m_25352_(9, new OpenDoorGoal(this, true));
      this.f_21345_.m_25352_(10, new OpenDoorGoal(this, false));
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public double m_6049_() {
      return -0.35;
   }

   public double m_6048_() {
      return super.m_6048_() + -1.0;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      SetTagProcedure.execute(world, this);
      return retval;
   }

   public void m_6075_() {
      super.m_6075_();
      AIKillerProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
   }

   public EntityDimensions m_6972_(Pose pose) {
      return super.m_6972_(pose).m_20388_(1.5F);
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, 40.0);
      builder = builder.m_22268_(Attributes.f_22284_, 1.0);
      builder = builder.m_22268_(Attributes.f_22281_, 1.0);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0);
      builder = builder.m_22268_(Attributes.f_22278_, 1.0);
      builder = builder.m_22268_(Attributes.f_22282_, 0.5);
      return builder;
   }
}
