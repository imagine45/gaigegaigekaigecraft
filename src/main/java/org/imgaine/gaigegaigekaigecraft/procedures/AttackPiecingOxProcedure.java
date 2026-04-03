package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.TruckEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackPiecingOxProcedure {
   public AttackPiecingOxProcedure() {
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
         double speed = 0.0;
         Entity entity_a = null;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
            }
         }

         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            if (OnGroundProcedure.execute(world, entity)) {
               world.levelEvent(2001, BlockPos.containing(x, y - 1.0, z), Block.getId(world.getBlockState(BlockPos.containing(x, y - 1.0, z))));
               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putDouble("cnt2", 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 0.1, 0.0, 0.1, 0.5);
               }
            } else if (entity.getPersistentData().getDouble("cnt1") > 200.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         } else {
            if (entity.getPersistentData().getDouble("cnt1") >= 5.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 0.1, 0.0, 0.1, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 20, 1.0, 0.0, 1.0, 0.5);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                     }
                  }

                  entity_a = entity;
                  if (entity.isVehicle() && entity.getFirstPassenger() instanceof LivingEntity) {
                     entity_a = entity.getFirstPassenger();
                  }

                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).getX();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     double var69 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var69 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var70;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var70 = _mobEnt.getTarget();
                     } else {
                        var70 = null;
                     }

                     z_pos = ((Entity)var70).getZ();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity_a.setYRot(entity.getYRot());
                     entity_a.setXRot(entity.getXRot());
                     entity_a.setYBodyRot(entity_a.getYRot());
                     entity_a.setYHeadRot(entity_a.getYRot());
                     entity_a.yRotO = entity_a.getYRot();
                     entity_a.xRotO = entity_a.getXRot();
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_a;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }

                  entity.getPersistentData().putDouble("x_power", entity_a.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity_a.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity_a.getLookAngle().z * 3.0);
                  if (entity instanceof TruckEntity) {
                     entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * 1.5);
                     entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * 1.5);
                     entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * 1.5);
                  }
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
                  entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power") * 1.0);
                  entity.getPersistentData().putDouble("y_knockback", 0.5);
                  entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power") * 1.0);

                  for(int index0 = 0; index0 < (int)Math.round(dis); ++index0) {
                     entity.getPersistentData().putDouble("Damage", 15.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1));
                     entity.getPersistentData().putDouble("Range", (double)(3.0F + entity.getBbHeight()));
                     entity.getPersistentData().putDouble("knockback", 0.1);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                     entity.getPersistentData().putDouble("Range", (double)(3.0F + entity.getBbHeight()));
                     entity.getPersistentData().putDouble("effect", -1.0);
                     entity.getPersistentData().putDouble("knockback", (double)(entity.getPersistentData().getDouble("cnt1") <= 13.0 ? 1 : 2));
                     KnockbackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                     x_pos += x_power * 1.0;
                     y_pos += y_power * 1.0;
                     z_pos += z_power * 1.0;
                  }

                  entity.getPersistentData().putDouble("x_knockback", 0.0);
                  entity.getPersistentData().putDouble("y_knockback", 0.0);
                  entity.getPersistentData().putDouble("z_knockback", 0.0);
               }

               entity.getPersistentData().putDouble("old_x", x);
               entity.getPersistentData().putDouble("old_y", y);
               entity.getPersistentData().putDouble("old_z", z);
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.5, Math.min(entity.getPersistentData().getDouble("y_power") * 1.5, 1.5), entity.getPersistentData().getDouble("z_power") * 1.5));
               if (entity.isVehicle() && entity.getFirstPassenger() instanceof LivingEntity) {
                  entity.getFirstPassenger().setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.5, Math.min(entity.getPersistentData().getDouble("y_power") * 1.5, 1.5), entity.getPersistentData().getDouble("z_power") * 1.5));
               }

               if (entity.getPersistentData().getDouble("cnt1") > 13.0) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  if (entity.getPersistentData().getDouble("cnt1") > 25.0) {
                     entity.getPersistentData().putDouble("skill", 0.0);
                  }
               }
            }

            entity.getPersistentData().putBoolean("attack", true);
         }

      }
   }
}
