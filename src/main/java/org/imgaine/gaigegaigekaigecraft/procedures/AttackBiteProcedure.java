package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackBiteProcedure {
   public AttackBiteProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double level_jump = 0.0;
         double level = 0.0;
         double level_speed = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt_target", 1.0);
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            if (OnGroundProcedure.execute(world, entity)) {
               world.levelEvent(2001, BlockPos.containing(x, y - 1.0, z), Block.getId(world.getBlockState(BlockPos.containing(x, y - 1.0, z))));
               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putDouble("cnt2", 1.0);
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  x_pos = ((Entity)var10000).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  double var61 = ((Entity)var10000).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var61 + (double)((Entity)var10001).getBbHeight() * 0.5;
                  LivingEntity var62;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var62 = _mobEnt.getTarget();
                  } else {
                     var62 = null;
                  }

                  z_pos = ((Entity)var62).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               GetPowerFixProcedure.execute(entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 10, 0.2, 0.0, 0.2, 0.5);
               }
            } else if (entity.getPersistentData().getDouble("cnt1") > 200.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         } else {
            if (entity.getPersistentData().getDouble("cnt1") >= 5.0) {
               if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
                  if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 0.2, 0.0, 0.2, 0.5);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
                        }
                     }
                  } else {
                     RotateEntityProcedure.execute((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + entity.getDeltaMovement().x() * 16.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + entity.getDeltaMovement().y() * 16.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + entity.getDeltaMovement().z() * 16.0, entity);
                  }

                  if (entity.onGround()) {
                     entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, Math.min(Math.max(entity.getPersistentData().getDouble("y_power") * 0.75, 0.5), 1.5), entity.getPersistentData().getDouble("z_power") * 0.75));
                  } else {
                     entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, Math.min(entity.getPersistentData().getDouble("y_power") * 0.75, 1.5), entity.getPersistentData().getDouble("z_power") * 0.75));
                  }
               } else if (entity.onGround()) {
                  entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.5, entity.getDeltaMovement().y(), entity.getPersistentData().getDouble("z_power") * 0.5));
               }

               x_pos = entity.getPersistentData().getDouble("old_x");
               y_pos = entity.getPersistentData().getDouble("old_y");
               z_pos = entity.getPersistentData().getDouble("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
                  entity.getPersistentData().putDouble("cnt_target", 10.0);

                  for(int index0 = 0; index0 < (int)Math.round(dis); ++index0) {
                     entity.getPersistentData().putDouble("Damage", 14.0);
                     entity.getPersistentData().putDouble("Range", (double)(3.0F + entity.getBbHeight()));
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                     x_pos += x_power * 1.0;
                     y_pos += y_power * 1.0;
                     z_pos += z_power * 1.0;
                  }

                  entity.getPersistentData().putDouble("cnt_target", 1.0);
               }

               entity.getPersistentData().putDouble("old_x", x);
               entity.getPersistentData().putDouble("old_y", y);
               entity.getPersistentData().putDouble("old_z", z);
               if (entity.getPersistentData().getDouble("cnt1") > 40.0 || entity.getPersistentData().getDouble("cnt1") > 25.0 && entity.onGround()) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }

            entity.getPersistentData().putBoolean("attack", true);
         }

      }
   }
}
