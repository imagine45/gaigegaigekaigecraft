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
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
   public static final EntityDataAccessor<Boolean> DATA_object;

   public CrowEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.CROW.get(), world);
   }

   public CrowEntity(EntityType<CrowEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 1;
      this.setNoAi(false);
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(DATA_object, false);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.0, 32.0F, 16.0F, false) {
         public boolean canUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(2, new Goal() {
         {
            this.setFlags(EnumSet.of(Flag.MOVE));
         }

         public boolean canUse() {
            if (CrowEntity.this.getTarget() != null && !CrowEntity.this.getMoveControl().hasWanted()) {
               double x = CrowEntity.this.getX();
               double y = CrowEntity.this.getY();
               double z = CrowEntity.this.getZ();
               Entity entity = CrowEntity.this;
               Level world = CrowEntity.this.level();
               return LogicAIProcedure.execute(entity);
            } else {
               return false;
            }
         }

         public boolean canContinueToUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return LogicAIProcedure.execute(entity) && CrowEntity.this.getMoveControl().hasWanted() && CrowEntity.this.getTarget() != null && CrowEntity.this.getTarget().isAlive();
         }

         public void start() {
            LivingEntity livingentity = CrowEntity.this.getTarget();
            Vec3 vec3d = livingentity.getEyePosition(1.0F);
            CrowEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
         }

         public void tick() {
            LivingEntity livingentity = CrowEntity.this.getTarget();
            if (CrowEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
               CrowEntity.this.doHurtTarget(livingentity);
            } else {
               double d0 = CrowEntity.this.distanceToSqr(livingentity);
               if (d0 < 16.0) {
                  Vec3 vec3d = livingentity.getEyePosition(1.0F);
                  CrowEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
               }
            }

         }
      });
      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this, new Class[0]) {
         public boolean canUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      }).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0, 20) {
         protected Vec3 getPosition() {
            RandomSource random = CrowEntity.this.getRandom();
            double dir_x = CrowEntity.this.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_y = CrowEntity.this.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_z = CrowEntity.this.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }

         public boolean canUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(5, new RandomLookAroundGoal(this) {
         public boolean canUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(6, new FloatGoal(this) {
         public boolean canUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
      this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, 0.5F) {
         public boolean canUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = CrowEntity.this.getX();
            double y = CrowEntity.this.getY();
            double z = CrowEntity.this.getZ();
            Entity entity = CrowEntity.this;
            Level world = CrowEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      return damagesource.is(DamageTypes.FALL) ? false : super.hurt(damagesource, amount);
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putBoolean("Dataobject", (Boolean)this.entityData.get(DATA_object));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Dataobject")) {
         this.entityData.set(DATA_object, compound.getBoolean("Dataobject"));
      }

   }

   public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
      ItemStack itemstack = sourceentity.getItemInHand(hand);
      InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
      Item item = itemstack.getItem();
      if (itemstack.getItem() instanceof SpawnEggItem) {
         retval = super.mobInteract(sourceentity, hand);
      } else if (this.level().isClientSide()) {
         retval = (!this.isTame() || !this.isOwnedBy(sourceentity)) && !this.isFood(itemstack) ? InteractionResult.PASS : InteractionResult.sidedSuccess(this.level().isClientSide());
      } else if (this.isTame()) {
         if (this.isOwnedBy(sourceentity)) {
            if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
               this.usePlayerItem(sourceentity, hand, itemstack);
               this.heal((float)item.getFoodProperties().getNutrition());
               retval = InteractionResult.sidedSuccess(this.level().isClientSide());
            } else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
               this.usePlayerItem(sourceentity, hand, itemstack);
               this.heal(4.0F);
               retval = InteractionResult.sidedSuccess(this.level().isClientSide());
            } else {
               retval = super.mobInteract(sourceentity, hand);
            }
         }
      } else if (this.isFood(itemstack)) {
         this.usePlayerItem(sourceentity, hand, itemstack);
         if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, sourceentity)) {
            this.tame(sourceentity);
            this.level().broadcastEntityEvent(this, (byte)7);
         } else {
            this.level().broadcastEntityEvent(this, (byte)6);
         }

         this.setPersistenceRequired();
         retval = InteractionResult.sidedSuccess(this.level().isClientSide());
      } else {
         retval = super.mobInteract(sourceentity, hand);
         if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
            this.setPersistenceRequired();
         }
      }

      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      Level world = this.level();
      CrowRightClickedOnEntityProcedure.execute(world, x, y, z, this, sourceentity);
      return retval;
   }

   public void baseTick() {
      super.baseTick();
      AICrowProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
      CrowEntity retval = (CrowEntity)((EntityType)JujutsucraftModEntities.CROW.get()).create(serverWorld);
      retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
      return retval;
   }

   public boolean isFood(ItemStack stack) {
      return Ingredient.of(new ItemStack[]{new ItemStack(Items.WHEAT_SEEDS), new ItemStack(Items.PUMPKIN_SEEDS), new ItemStack(Items.MELON_SEEDS), new ItemStack(Items.BEETROOT_SEEDS), new ItemStack(Items.APPLE), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(Items.COOKIE), new ItemStack(Items.MELON_SLICE), new ItemStack(Items.SWEET_BERRIES), new ItemStack(Items.COD), new ItemStack(Items.SALMON), new ItemStack(Items.PORKCHOP), new ItemStack(Items.BEEF), new ItemStack(Items.CHICKEN), new ItemStack(Items.RABBIT), new ItemStack(Items.MUTTON)}).test(stack);
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
      SpawnPlacements.register((EntityType)JujutsucraftModEntities.CROW.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8);
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 6.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 2.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.FLYING_SPEED, 0.3);
      return builder;
   }

   static {
      DATA_object = SynchedEntityData.defineId(CrowEntity.class, EntityDataSerializers.BOOLEAN);
   }
}
