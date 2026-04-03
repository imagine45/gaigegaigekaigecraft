package org.imgaine.gaigegaigekaigecraft.entity;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.AIGarudaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DieRikaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.GarudaRightClickedOnEntityProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAIProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicAttackTargetStartProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SetTagProcedure;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class GarudaEntity extends PathfinderMob {
   public GarudaEntity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftModEntities.GARUDA.get(), world);
   }

   public GarudaEntity(EntityType<GarudaEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.6F);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setPersistenceRequired();
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.5, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return 0.0;
         }

         public boolean canUse() {
            double x = GarudaEntity.this.getX();
            double y = GarudaEntity.this.getY();
            double z = GarudaEntity.this.getZ();
            Entity entity = GarudaEntity.this;
            Level world = GarudaEntity.this.level();
            return super.canUse() && LogicAttackTargetProcedure.execute(entity);
         }
      });
      this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean canUse() {
            double x = GarudaEntity.this.getX();
            double y = GarudaEntity.this.getY();
            double z = GarudaEntity.this.getZ();
            Entity entity = GarudaEntity.this;
            Level world = GarudaEntity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = GarudaEntity.this.getX();
            double y = GarudaEntity.this.getY();
            double z = GarudaEntity.this.getZ();
            Entity entity = GarudaEntity.this;
            Level world = GarudaEntity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean canUse() {
            double x = GarudaEntity.this.getX();
            double y = GarudaEntity.this.getY();
            double z = GarudaEntity.this.getZ();
            Entity entity = GarudaEntity.this;
            Level world = GarudaEntity.this.level();
            return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }

         public boolean canContinueToUse() {
            double x = GarudaEntity.this.getX();
            double y = GarudaEntity.this.getY();
            double z = GarudaEntity.this.getZ();
            Entity entity = GarudaEntity.this;
            Level world = GarudaEntity.this.level();
            return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
         }
      });
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false) {
         public boolean canUse() {
            double x = GarudaEntity.this.getX();
            double y = GarudaEntity.this.getY();
            double z = GarudaEntity.this.getZ();
            Entity entity = GarudaEntity.this;
            Level world = GarudaEntity.this.level();
            return super.canUse() && LogicAIProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = GarudaEntity.this.getX();
            double y = GarudaEntity.this.getY();
            double z = GarudaEntity.this.getZ();
            Entity entity = GarudaEntity.this;
            Level world = GarudaEntity.this.level();
            return super.canContinueToUse() && LogicAIProcedure.execute(entity);
         }
      });
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
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

   public void die(DamageSource source) {
      super.die(source);
      DieRikaProcedure.execute(this.level(), this);
   }

   public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
      SetTagProcedure.execute(world, this);
      return retval;
   }

   public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
      sourceentity.getItemInHand(hand);
      InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
      super.mobInteract(sourceentity, hand);
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      Level world = this.level();
      GarudaRightClickedOnEntityProcedure.execute(this, sourceentity);
      return retval;
   }

   public void baseTick() {
      super.baseTick();
      AIGarudaProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
      builder = builder.add(Attributes.MAX_HEALTH, 100.0);
      builder = builder.add(Attributes.ARMOR, 20.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 1.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 5.0);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.0);
      return builder;
   }
}
