package org.imgaine.gaigegaigekaigecraft.entity;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIHumanCarProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.ShikigamiRightClickedOnEntityProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class HumanCarEntity extends Monster {
   public HumanCarEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.HUMAN_CAR.get(), world);
   }

   public HumanCarEntity(EntityType<HumanCarEntity> type, Level world) {
      super(type, world);
      this.m_274367_(1.5F);
      this.f_21364_ = 0;
      this.m_21557_(false);
      this.m_21530_();
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21346_.m_25352_(1, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(2, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = HumanCarEntity.this.m_20185_();
            double y = HumanCarEntity.this.m_20186_();
            double z = HumanCarEntity.this.m_20189_();
            Entity entity = HumanCarEntity.this;
            Level world = HumanCarEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = HumanCarEntity.this.m_20185_();
            double y = HumanCarEntity.this.m_20186_();
            double z = HumanCarEntity.this.m_20189_();
            Entity entity = HumanCarEntity.this;
            Level world = HumanCarEntity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = HumanCarEntity.this.m_20185_();
            double y = HumanCarEntity.this.m_20186_();
            double z = HumanCarEntity.this.m_20189_();
            Entity entity = HumanCarEntity.this;
            Level world = HumanCarEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = HumanCarEntity.this.m_20185_();
            double y = HumanCarEntity.this.m_20186_();
            double z = HumanCarEntity.this.m_20189_();
            Entity entity = HumanCarEntity.this;
            Level world = HumanCarEntity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public boolean m_6785_(double distanceToClosestPlayer) {
      return false;
   }

   public double m_6048_() {
      return super.m_6048_() + -0.7;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean m_6469_(DamageSource damagesource, float amount) {
      if (!(damagesource.m_7640_() instanceof ThrownPotion) && !(damagesource.m_7640_() instanceof AreaEffectCloud)) {
         return damagesource.m_276093_(DamageTypes.f_268722_) ? false : super.m_6469_(damagesource, amount);
      } else {
         return false;
      }
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      SetTagProcedure.execute(world, this);
      return retval;
   }

   public InteractionResult m_6071_(Player sourceentity, InteractionHand hand) {
      sourceentity.m_21120_(hand);
      InteractionResult retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
      super.m_6071_(sourceentity, hand);
      sourceentity.m_20329_(this);
      double x = this.m_20185_();
      double y = this.m_20186_();
      double z = this.m_20189_();
      Level world = this.m_9236_();
      ShikigamiRightClickedOnEntityProcedure.execute(world, this, sourceentity);
      return retval;
   }

   public void m_6075_() {
      super.m_6075_();
      AIHumanCarProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
   }

   public boolean m_7337_(Entity entity) {
      return true;
   }

   public boolean m_5829_() {
      return true;
   }

   public void m_7023_(Vec3 dir) {
      Entity entity = this.m_20197_().isEmpty() ? null : (Entity)this.m_20197_().get(0);
      if (this.m_20160_()) {
         this.m_146922_(entity.m_146908_());
         this.f_19859_ = this.m_146908_();
         this.m_146926_(entity.m_146909_() * 0.5F);
         this.m_19915_(this.m_146908_(), this.m_146909_());
         this.f_20883_ = entity.m_146908_();
         this.f_20885_ = entity.m_146908_();
         if (entity instanceof LivingEntity) {
            LivingEntity passenger = (LivingEntity)entity;
            this.m_7910_((float)this.m_21133_(Attributes.f_22279_));
            float forward = passenger.f_20902_;
            float strafe = 0.0F;
            super.m_7023_(new Vec3((double)strafe, 0.0, (double)forward));
         }

         double d1 = this.m_20185_() - this.f_19854_;
         double d0 = this.m_20189_() - this.f_19856_;
         float f1 = (float)Math.sqrt(d1 * d1 + d0 * d0) * 4.0F;
         if (f1 > 1.0F) {
            f1 = 1.0F;
         }

         this.f_267362_.m_267771_(this.f_267362_.m_267731_() + (f1 - this.f_267362_.m_267731_()) * 0.4F);
         this.f_267362_.m_267590_(this.f_267362_.m_267756_() + this.f_267362_.m_267731_());
         this.m_267651_(true);
      } else {
         super.m_7023_(dir);
      }
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, 70.0);
      builder = builder.m_22268_(Attributes.f_22284_, 4.0);
      builder = builder.m_22268_(Attributes.f_22281_, 1.0);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0);
      builder = builder.m_22268_(Attributes.f_22278_, 3.0);
      builder = builder.m_22268_(Attributes.f_22282_, 1.0);
      return builder;
   }
}
