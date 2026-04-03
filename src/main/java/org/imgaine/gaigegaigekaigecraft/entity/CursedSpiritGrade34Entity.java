package org.imgaine.gaigegaigekaigecraft.entity;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AICursedSpirit3Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.CursedSpiritGrade34PlayerCollidesWithThisEntityProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagCursedSpritProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SpawnLevel1Procedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class CursedSpiritGrade34Entity extends Monster {
   public CursedSpiritGrade34Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_34.get(), world);
   }

   public CursedSpiritGrade34Entity(EntityType<CursedSpiritGrade34Entity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 10;
      this.setNoAi(false);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }

         public boolean canUse() {
            double x = CursedSpiritGrade34Entity.this.getX();
            double y = CursedSpiritGrade34Entity.this.getY();
            double z = CursedSpiritGrade34Entity.this.getZ();
            Entity entity = CursedSpiritGrade34Entity.this;
            Level world = CursedSpiritGrade34Entity.this.level();
            return super.canUse() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean canUse() {
            double x = CursedSpiritGrade34Entity.this.getX();
            double y = CursedSpiritGrade34Entity.this.getY();
            double z = CursedSpiritGrade34Entity.this.getZ();
            Entity entity = CursedSpiritGrade34Entity.this;
            Level world = CursedSpiritGrade34Entity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = CursedSpiritGrade34Entity.this.getX();
            double y = CursedSpiritGrade34Entity.this.getY();
            double z = CursedSpiritGrade34Entity.this.getZ();
            Entity entity = CursedSpiritGrade34Entity.this;
            Level world = CursedSpiritGrade34Entity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean canUse() {
            double x = CursedSpiritGrade34Entity.this.getX();
            double y = CursedSpiritGrade34Entity.this.getY();
            double z = CursedSpiritGrade34Entity.this.getZ();
            Entity entity = CursedSpiritGrade34Entity.this;
            Level world = CursedSpiritGrade34Entity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = CursedSpiritGrade34Entity.this.getX();
            double y = CursedSpiritGrade34Entity.this.getY();
            double z = CursedSpiritGrade34Entity.this.getZ();
            Entity entity = CursedSpiritGrade34Entity.this;
            Level world = CursedSpiritGrade34Entity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
      this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(7, new FloatGoal(this));
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

   public boolean hurt(DamageSource damagesource, float amount) {
      return damagesource.is(DamageTypes.FALL) ? false : super.hurt(damagesource, amount);
   }

   public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SetTagCursedSpritProcedure.execute(world, this);
      return retval;
   }

   public void baseTick() {
      super.baseTick();
      AICursedSpirit3Procedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public void playerTouch(Player sourceentity) {
      super.playerTouch(sourceentity);
      CursedSpiritGrade34PlayerCollidesWithThisEntityProcedure.execute(this);
   }

   public static void init() {
      SpawnPlacements.register((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_34.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         int x = pos.getX();
         int y = pos.getY();
         int z = pos.getZ();
         return SpawnLevel1Procedure.execute();
      });
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 30.0);
      builder = builder.add(Attributes.ARMOR, 3.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 6.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
      return builder;
   }
}
