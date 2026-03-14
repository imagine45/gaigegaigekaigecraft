package org.imgaine.gaigegaigekaigecraft.entity;

import java.util.EnumSet;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AICrowProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.CrowRightClickedOnEntityProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAIProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class CrowEntity extends TamableAnimal {
   public CrowEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.CROW.get(), world);
   }

   public CrowEntity(EntityType<CrowEntity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 1;
      this.m_21557_(false);
      this.f_21342_ = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation m_6037_(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new FollowOwnerGoal(this, 1.0, 32.0F, 16.0F, false) {
         public boolean m_8036_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8036_() && LogicAIProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8045_() && LogicAIProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(2, new Goal() {
         {
            this.m_7021_(EnumSet.of(Flag.MOVE));
         }

         public boolean m_8036_() {
            if (CrowEntity.this.m_5448_() != null && !CrowEntity.this.m_21566_().m_24995_()) {
               double x = CrowEntity.this.m_20185_();
               double y = CrowEntity.this.m_20186_();
               double z = CrowEntity.this.m_20189_();
               Entity entity = CrowEntity.this;
               Level world = CrowEntity.this.m_9236_();
               return LogicAIProcedure.execute(entity);
            } else {
               return false;
            }
         }

         public boolean m_8045_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return LogicAIProcedure.execute(entity) && CrowEntity.this.m_21566_().m_24995_() && CrowEntity.this.m_5448_() != null && CrowEntity.this.m_5448_().m_6084_();
         }

         public void m_8056_() {
            LivingEntity livingentity = CrowEntity.this.m_5448_();
            Vec3 vec3d = livingentity.m_20299_(1.0F);
            CrowEntity.this.f_21342_.m_6849_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 1.0);
         }

         public void m_8037_() {
            LivingEntity livingentity = CrowEntity.this.m_5448_();
            if (CrowEntity.this.m_20191_().m_82381_(livingentity.m_20191_())) {
               CrowEntity.this.m_7327_(livingentity);
            } else {
               double d0 = CrowEntity.this.m_20280_(livingentity);
               if (d0 < 16.0) {
                  Vec3 vec3d = livingentity.m_20299_(1.0F);
                  CrowEntity.this.f_21342_.m_6849_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 1.0);
               }
            }

         }
      });
      this.f_21346_.m_25352_(3, (new HurtByTargetGoal(this, new Class[0]) {
         public boolean m_8036_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8036_() && LogicAIProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8045_() && LogicAIProcedure.execute(entity);
         }
      }).m_26044_(new Class[0]));
      this.f_21345_.m_25352_(4, new RandomStrollGoal(this, 1.0, 20) {
         protected Vec3 m_7037_() {
            RandomSource random = CrowEntity.this.m_217043_();
            double dir_x = CrowEntity.this.m_20185_() + (double)((random.m_188501_() * 2.0F - 1.0F) * 16.0F);
            double dir_y = CrowEntity.this.m_20186_() + (double)((random.m_188501_() * 2.0F - 1.0F) * 16.0F);
            double dir_z = CrowEntity.this.m_20189_() + (double)((random.m_188501_() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }

         public boolean m_8036_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8036_() && LogicAIProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8045_() && LogicAIProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(5, new RandomLookAroundGoal(this) {
         public boolean m_8036_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8036_() && LogicAIProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8045_() && LogicAIProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(6, new FloatGoal(this) {
         public boolean m_8036_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8036_() && LogicAIProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8045_() && LogicAIProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(7, new LeapAtTargetGoal(this, 0.5F) {
         public boolean m_8036_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8036_() && LogicAIProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CrowEntity.this.m_20185_();
            double y = CrowEntity.this.m_20186_();
            double z = CrowEntity.this.m_20189_();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.m_9236_();
            return super.m_8045_() && LogicAIProcedure.execute(entity);
         }
      });
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

   public boolean m_142535_(float l, float d, DamageSource source) {
      return false;
   }

   public boolean m_6469_(DamageSource damagesource, float amount) {
      return damagesource.m_276093_(DamageTypes.f_268671_) ? false : super.m_6469_(damagesource, amount);
   }

   public InteractionResult m_6071_(Player sourceentity, InteractionHand hand) {
      ItemStack itemstack = sourceentity.m_21120_(hand);
      InteractionResult retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
      Item item = itemstack.m_41720_();
      if (itemstack.m_41720_() instanceof SpawnEggItem) {
         retval = super.m_6071_(sourceentity, hand);
      } else if (this.m_9236_().m_5776_()) {
         retval = (!this.m_21824_() || !this.m_21830_(sourceentity)) && !this.m_6898_(itemstack) ? InteractionResult.PASS : InteractionResult.m_19078_(this.m_9236_().m_5776_());
      } else if (this.m_21824_()) {
         if (this.m_21830_(sourceentity)) {
            if (item.m_41472_() && this.m_6898_(itemstack) && this.m_21223_() < this.m_21233_()) {
               this.m_142075_(sourceentity, hand, itemstack);
               this.m_5634_((float)item.m_41473_().m_38744_());
               retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
            } else if (this.m_6898_(itemstack) && this.m_21223_() < this.m_21233_()) {
               this.m_142075_(sourceentity, hand, itemstack);
               this.m_5634_(4.0F);
               retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
            } else {
               retval = super.m_6071_(sourceentity, hand);
            }
         }
      } else if (this.m_6898_(itemstack)) {
         this.m_142075_(sourceentity, hand, itemstack);
         if (this.f_19796_.m_188503_(3) == 0 && !ForgeEventFactory.onAnimalTame(this, sourceentity)) {
            this.m_21828_(sourceentity);
            this.m_9236_().m_7605_(this, (byte)7);
         } else {
            this.m_9236_().m_7605_(this, (byte)6);
         }

         this.m_21530_();
         retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
      } else {
         retval = super.m_6071_(sourceentity, hand);
         if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
            this.m_21530_();
         }
      }

      double x = this.m_20185_();
      double y = this.m_20186_();
      double z = this.m_20189_();
      Level world = this.m_9236_();
      CrowRightClickedOnEntityProcedure.execute(world, x, y, z, this, sourceentity);
      return retval;
   }

   public void m_6075_() {
      super.m_6075_();
      AICrowProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
   }

   public AgeableMob m_142606_(ServerLevel serverWorld, AgeableMob ageable) {
      CrowEntity retval = (CrowEntity)((EntityType)JujutsucraftModEntities.CROW.get()).m_20615_(serverWorld);
      retval.m_6518_(serverWorld, serverWorld.m_6436_(retval.m_20183_()), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
      return retval;
   }

   public boolean m_6898_(ItemStack stack) {
      return Ingredient.m_43927_(new ItemStack[]{new ItemStack(Items.f_42404_), new ItemStack(Items.f_42577_), new ItemStack(Items.f_42578_), new ItemStack(Items.f_42733_), new ItemStack(Items.f_42410_), new ItemStack(Items.f_42687_), new ItemStack(Items.f_42572_), new ItemStack(Items.f_42575_), new ItemStack(Items.f_42780_), new ItemStack(Items.f_42526_), new ItemStack(Items.f_42527_), new ItemStack(Items.f_42485_), new ItemStack(Items.f_42579_), new ItemStack(Items.f_42581_), new ItemStack(Items.f_42697_), new ItemStack(Items.f_42658_)}).test(stack);
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
      SpawnPlacements.m_21754_((EntityType)JujutsucraftModEntities.CROW.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> world.m_8055_(pos.m_7495_()).m_204336_(BlockTags.f_184228_) && world.m_45524_(pos, 0) > 8);
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, 6.0);
      builder = builder.m_22268_(Attributes.f_22284_, 0.0);
      builder = builder.m_22268_(Attributes.f_22281_, 2.0);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0);
      builder = builder.m_22268_(Attributes.f_22280_, 0.3);
      return builder;
   }
}
