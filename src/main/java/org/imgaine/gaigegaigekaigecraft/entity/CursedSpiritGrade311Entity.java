package org.imgaine.gaigegaigekaigecraft.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AICursedSpirit3FishProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagCursedSpritProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SpawnLevel1Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
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
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class CursedSpiritGrade311Entity extends Monster {
   public CursedSpiritGrade311Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_311.get(), world);
   }

   public CursedSpiritGrade311Entity(EntityType<CursedSpiritGrade311Entity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 15;
      this.setNoAi(false);
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new Goal() {
         {
            this.setFlags(EnumSet.of(Flag.MOVE));
         }

         public boolean canUse() {
            if (CursedSpiritGrade311Entity.this.getTarget() != null && !CursedSpiritGrade311Entity.this.getMoveControl().hasWanted()) {
               double x = CursedSpiritGrade311Entity.this.getX();
               double y = CursedSpiritGrade311Entity.this.getY();
               double z = CursedSpiritGrade311Entity.this.getZ();
               Entity entity = CursedSpiritGrade311Entity.this;
               Level world = CursedSpiritGrade311Entity.this.level();
               return LogicAttackTargetProcedure.execute(entity);
            } else {
               return false;
            }
         }

         public boolean canContinueToUse() {
            return CursedSpiritGrade311Entity.this.getMoveControl().hasWanted() && CursedSpiritGrade311Entity.this.getTarget() != null && CursedSpiritGrade311Entity.this.getTarget().isAlive();
         }

         public void start() {
            LivingEntity livingentity = CursedSpiritGrade311Entity.this.getTarget();
            Vec3 vec3d = livingentity.getEyePosition(1.0F);
            CursedSpiritGrade311Entity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 2.0);
         }

         public void tick() {
            LivingEntity livingentity = CursedSpiritGrade311Entity.this.getTarget();
            if (CursedSpiritGrade311Entity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
               CursedSpiritGrade311Entity.this.doHurtTarget(livingentity);
            } else {
               double d0 = CursedSpiritGrade311Entity.this.distanceToSqr(livingentity);
               if (d0 < 32.0) {
                  Vec3 vec3d = livingentity.getEyePosition(1.0F);
                  CursedSpiritGrade311Entity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 2.0);
               }
            }

         }
      });
      this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }

         public boolean canUse() {
            double x = CursedSpiritGrade311Entity.this.getX();
            double y = CursedSpiritGrade311Entity.this.getY();
            double z = CursedSpiritGrade311Entity.this.getZ();
            Entity entity = CursedSpiritGrade311Entity.this;
            Level world = CursedSpiritGrade311Entity.this.level();
            return super.canUse() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(3, new HurtByTargetGoal(this, new Class[0]));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean canUse() {
            double x = CursedSpiritGrade311Entity.this.getX();
            double y = CursedSpiritGrade311Entity.this.getY();
            double z = CursedSpiritGrade311Entity.this.getZ();
            Entity entity = CursedSpiritGrade311Entity.this;
            Level world = CursedSpiritGrade311Entity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = CursedSpiritGrade311Entity.this.getX();
            double y = CursedSpiritGrade311Entity.this.getY();
            double z = CursedSpiritGrade311Entity.this.getZ();
            Entity entity = CursedSpiritGrade311Entity.this;
            Level world = CursedSpiritGrade311Entity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean canUse() {
            double x = CursedSpiritGrade311Entity.this.getX();
            double y = CursedSpiritGrade311Entity.this.getY();
            double z = CursedSpiritGrade311Entity.this.getZ();
            Entity entity = CursedSpiritGrade311Entity.this;
            Level world = CursedSpiritGrade311Entity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = CursedSpiritGrade311Entity.this.getX();
            double y = CursedSpiritGrade311Entity.this.getY();
            double z = CursedSpiritGrade311Entity.this.getZ();
            Entity entity = CursedSpiritGrade311Entity.this;
            Level world = CursedSpiritGrade311Entity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.goalSelector.addGoal(6, new FollowMobGoal(this, 1.5, 16.0F, 8.0F));
      this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0, 20) {
         protected Vec3 getPosition() {
            RandomSource random = CursedSpiritGrade311Entity.this.getRandom();
            double dir_x = CursedSpiritGrade311Entity.this.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_y = CursedSpiritGrade311Entity.this.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double dir_z = CursedSpiritGrade311Entity.this.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
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

   public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SetTagCursedSpritProcedure.execute(world, this);
      return retval;
   }

   public void baseTick() {
      super.baseTick();
      AICursedSpirit3FishProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
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
      SpawnPlacements.register((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_311.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         int x = pos.getX();
         int y = pos.getY();
         int z = pos.getZ();
         return SpawnLevel1Procedure.execute();
      });
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 40.0);
      builder = builder.add(Attributes.ARMOR, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 12.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
      builder = builder.add(Attributes.FLYING_SPEED, 0.3);
      return builder;
   }
}
