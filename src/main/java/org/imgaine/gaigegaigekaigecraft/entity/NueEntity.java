package org.imgaine.gaigegaigekaigecraft.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AINueProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DieTenShadowsTechniqueProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.TenShadowsTechniqueProcedure;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
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

public class NueEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public NueEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.NUE.get(), world);
   }

   public NueEntity(EntityType<NueEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.f_21364_ = 0;
      this.m_21557_(false);
      this.m_274367_(0.6F);
      this.m_21530_();
      this.f_21342_ = new FlyingMoveControl(this, 10, true);
   }

   protected void m_8097_() {
      super.m_8097_();
      this.f_19804_.m_135372_(SHOOT, false);
      this.f_19804_.m_135372_(ANIMATION, "undefined");
      this.f_19804_.m_135372_(TEXTURE, "nue");
   }

   public void setTexture(String texture) {
      this.f_19804_.m_135381_(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.f_19804_.m_135370_(TEXTURE);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation m_6037_(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new Goal() {
         {
            this.m_7021_(EnumSet.of(Flag.MOVE));
         }

         public boolean m_8036_() {
            if (NueEntity.this.m_5448_() != null && !NueEntity.this.m_21566_().m_24995_()) {
               double x = NueEntity.this.m_20185_();
               double y = NueEntity.this.m_20186_();
               double z = NueEntity.this.m_20189_();
               Entity entity = NueEntity.this;
               Level world = NueEntity.this.m_9236_();
               return LogicAttackTargetProcedure.execute(entity);
            } else {
               return false;
            }
         }

         public boolean m_8045_() {
            return NueEntity.this.m_21566_().m_24995_() && NueEntity.this.m_5448_() != null && NueEntity.this.m_5448_().m_6084_();
         }

         public void m_8056_() {
            LivingEntity livingentity = NueEntity.this.m_5448_();
            Vec3 vec3d = livingentity.m_20299_(1.0F);
            NueEntity.this.f_21342_.m_6849_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 2.0);
         }

         public void m_8037_() {
            LivingEntity livingentity = NueEntity.this.m_5448_();
            if (NueEntity.this.m_20191_().m_82381_(livingentity.m_20191_())) {
               NueEntity.this.m_7327_(livingentity);
            } else {
               double d0 = NueEntity.this.m_20280_(livingentity);
               if (d0 < 0.0) {
                  Vec3 vec3d = livingentity.m_20299_(1.0F);
                  NueEntity.this.f_21342_.m_6849_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 2.0);
               }
            }

         }
      });
      this.f_21345_.m_25352_(2, new MeleeAttackGoal(this, 1.4, true) {
         protected double m_6639_(LivingEntity entity) {
            return 0.0;
         }

         public boolean m_8036_() {
            double x = NueEntity.this.m_20185_();
            double y = NueEntity.this.m_20186_();
            double z = NueEntity.this.m_20189_();
            Entity entity = NueEntity.this;
            Level world = NueEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.f_21346_.m_25352_(3, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(4, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = NueEntity.this.m_20185_();
            double y = NueEntity.this.m_20186_();
            double z = NueEntity.this.m_20189_();
            Entity entity = NueEntity.this;
            Level world = NueEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = NueEntity.this.m_20185_();
            double y = NueEntity.this.m_20186_();
            double z = NueEntity.this.m_20189_();
            Entity entity = NueEntity.this;
            Level world = NueEntity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(5, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = NueEntity.this.m_20185_();
            double y = NueEntity.this.m_20186_();
            double z = NueEntity.this.m_20189_();
            Entity entity = NueEntity.this;
            Level world = NueEntity.this.m_9236_();
            return super.m_8036_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = NueEntity.this.m_20185_();
            double y = NueEntity.this.m_20186_();
            double z = NueEntity.this.m_20189_();
            Entity entity = NueEntity.this;
            Level world = NueEntity.this.m_9236_();
            return super.m_8045_() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.f_21345_.m_25352_(6, new RandomStrollGoal(this, 1.0));
      this.f_21345_.m_25352_(7, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(8, new FloatGoal(this));
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public boolean m_6785_(double distanceToClosestPlayer) {
      return false;
   }

   public double m_6048_() {
      return super.m_6048_() + -2.5;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean m_142535_(float l, float d, DamageSource source) {
      return false;
   }

   public boolean m_6469_(DamageSource source, float amount) {
      if (source.m_276093_(DamageTypes.f_268671_)) {
         return false;
      } else {
         return source.m_276093_(DamageTypes.f_268450_) ? false : super.m_6469_(source, amount);
      }
   }

   public void m_6667_(DamageSource source) {
      super.m_6667_(source);
      DieTenShadowsTechniqueProcedure.execute(this.m_9236_(), this);
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      SetTagProcedure.execute(world, this);
      return retval;
   }

   public void m_7380_(CompoundTag compound) {
      super.m_7380_(compound);
      compound.m_128359_("Texture", this.getTexture());
   }

   public void m_7378_(CompoundTag compound) {
      super.m_7378_(compound);
      if (compound.m_128441_("Texture")) {
         this.setTexture(compound.m_128461_("Texture"));
      }

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
      TenShadowsTechniqueProcedure.execute(world, x, y, z, this, sourceentity);
      return retval;
   }

   public void m_6075_() {
      super.m_6075_();
      AINueProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      this.m_6210_();
   }

   public EntityDimensions m_6972_(Pose p_33597_) {
      Level world = this.m_9236_();
      double x = this.m_20185_();
      double y = ((Entity)this).m_20186_();
      double z = ((Entity)this).m_20189_();
      return super.m_6972_(p_33597_).m_20388_((float)SizeByNBTProcedure.execute(this));
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
      builder = builder.m_22268_(Attributes.f_22276_, 125.0);
      builder = builder.m_22268_(Attributes.f_22284_, 5.0);
      builder = builder.m_22268_(Attributes.f_22281_, 1.0);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0);
      builder = builder.m_22268_(Attributes.f_22278_, 0.25);
      builder = builder.m_22268_(Attributes.f_22282_, 0.5);
      builder = builder.m_22268_(Attributes.f_22280_, 0.3);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (!event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F) {
            if (this.m_21224_()) {
               return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
            } else {
               return this.m_6144_() ? event.setAndContinue(RawAnimation.begin().thenLoop("guard")) : event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
            }
         } else {
            return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
         }
      } else {
         return PlayState.STOP;
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

   protected void m_6153_() {
      ++this.f_20919_;
      if (this.f_20919_ == 20) {
         this.m_142687_(RemovalReason.KILLED);
         this.m_21226_();
      }

   }

   public String getSyncedAnimation() {
      return (String)this.f_19804_.m_135370_(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.f_19804_.m_135381_(ANIMATION, animation);
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 1, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.m_135353_(NueEntity.class, EntityDataSerializers.f_135035_);
      ANIMATION = SynchedEntityData.m_135353_(NueEntity.class, EntityDataSerializers.f_135030_);
      TEXTURE = SynchedEntityData.m_135353_(NueEntity.class, EntityDataSerializers.f_135030_);
   }
}
