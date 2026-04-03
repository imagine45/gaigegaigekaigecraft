package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HumanCarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TruckEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIHumanCarProcedure {
   public AIHumanCarProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_move = false;
         boolean logic_autoMoving = false;
         String ridingUUID = "";
         Entity entity_a = null;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double power = 0.0;
         double boost = 0.0;
         double old_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double old_skill = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double dis = 0.0;
         double old_dis = 0.0;
         double entity_size = 0.0;
         double distance = 0.0;
         double CNT6 = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if ((entity instanceof TruckEntity || entity instanceof CarEntity) && entity.getPersistentData().getBoolean("Shikigami") && !entity.level().isClientSide()) {
               entity.discard();
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            logic_move = var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0;
            logic_autoMoving = logic_move;
            if (logic_move) {
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

               y_pos = ((Entity)var10000).getY();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               z_pos = ((Entity)var10000).getZ();
            }

            if (entity.isVehicle()) {
               logic_move = true;
               if (entity.getFirstPassenger() instanceof LivingEntity) {
                  if (entity.getFirstPassenger() instanceof Player) {
                     logic_autoMoving = false;
                     entity.getPersistentData().putDouble("cnt_target", 0.0);
                  } else {
                     Entity var52 = entity.getFirstPassenger();
                     if (var52 instanceof Mob) {
                        Mob _mobEnt = (Mob)var52;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity && entity.getFirstPassenger().getPersistentData().getDouble("cnt_target") > 6.0) {
                        logic_autoMoving = true;
                        Entity var53 = entity.getFirstPassenger();
                        if (var53 instanceof Mob) {
                           Mob _mobEnt = (Mob)var53;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        x_pos = ((Entity)var10000).getX();
                        var53 = entity.getFirstPassenger();
                        if (var53 instanceof Mob) {
                           Mob _mobEnt = (Mob)var53;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        y_pos = ((Entity)var10000).getY();
                        var53 = entity.getFirstPassenger();
                        if (var53 instanceof Mob) {
                           Mob _mobEnt = (Mob)var53;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        z_pos = ((Entity)var10000).getZ();
                        entity_a = entity.getFirstPassenger();
                     }
                  }
               }
            }

            if (logic_autoMoving && entity.onGround()) {
               power = (double)Math.round(Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z()) * 72.0);
               if (power >= 0.2) {
                  yaw = (double)(entity.getYRot() % 360.0F);
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.setYRot(entity.getYRot() % 360.0F);
                  entity.setXRot(0.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  yaw_cal = (double)entity.getYRot() - yaw;
                  if ((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0))) {
                     yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 16.0;
                  } else {
                     yaw -= Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 16.0;
                  }

                  entity.setYRot((float)yaw);
                  entity.setXRot(0.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               old_dis = Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z()) + 0.4;
               if (entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * 3.0) {
                  x_power = entity.getDeltaMovement().x() - 0.2;
               } else {
                  x_power = entity.getDeltaMovement().x() + 0.2;
               }

               if (entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * 3.0) {
                  z_power = entity.getDeltaMovement().z() - 0.2;
               } else {
                  z_power = entity.getDeltaMovement().z() + 0.2;
               }

               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 0.0 && dis < old_dis) {
                  x_power *= old_dis / dis;
                  z_power *= old_dis / dis;
               }

               entity.setDeltaMovement(new Vec3(x_power, entity.getDeltaMovement().y(), z_power));
               if (entity_a instanceof LivingEntity) {
                  entity_a.setYRot((float)yaw);
                  entity_a.setXRot(0.0F);
                  entity_a.setYBodyRot(entity_a.getYRot());
                  entity_a.setYHeadRot(entity_a.getYRot());
                  entity_a.yRotO = entity_a.getYRot();
                  entity_a.xRotO = entity_a.getXRot();
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity_a.setDeltaMovement(new Vec3(x_power, entity_a.getDeltaMovement().y(), z_power));
               }
            }

            if (logic_move) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               power = (double)Math.round(Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z()) * 72.0);
               if (entity.getPersistentData().getDouble("old_power") - power > 8.0 && entity.getPersistentData().getDouble("old_power") > 40.0 && entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.onGround()) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
                     }
                  }
               }

               label247: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt83 = (LivingEntity)entity;
                     if (_livEnt83.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                        break label247;
                     }
                  }

                  boost = (double)Math.round(power / 4.0 - 4.0);
                  if (boost > 5.0) {
                     boost = 5.0;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, (int)boost, false, false));
                     }
                  }
               }

               if (power > 1.0) {
                  if (!entity.getPersistentData().getBoolean("start")) {
                     entity.getPersistentData().putBoolean("start", true);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, entity.getX() + entity.getLookAngle().x * -3.0 * entity_size, entity.getY() + 0.3 * entity_size, entity.getZ() + entity.getLookAngle().z * -3.0 * entity_size, 1, 0.1, 0.1, 0.1, 0.03);
                  }

                  old_skill = 0.0;
                  entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.5);
                  entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.5);
                  entity.getPersistentData().putDouble("skill", 1.0);
                  entity.getPersistentData().putDouble("Damage", Math.min(power * 0.2, 24.0));
                  entity.getPersistentData().putDouble("Range", (double)(3.0F + entity.getBbWidth()));
                  entity.getPersistentData().putDouble("knockback", 0.5 + Math.min(power * 0.2, 4.0));
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  entity.getPersistentData().putDouble("skill", old_skill);
               } else {
                  entity.getPersistentData().putBoolean("start", false);
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }

            entity.getPersistentData().putDouble("old_power", power);
         } else {
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            if (entity instanceof HumanCarEntity) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(2.0 * entity_size), (double)entity.getBbWidth() * 0.2, (double)entity.getBbHeight() * 0.2, (double)entity.getBbWidth() * 0.2, 1.0);
               }

               if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                  entity.getPersistentData().putDouble("cnt3", 1.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()));
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()), false);
                     }
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(2.0 * entity_size), (double)entity.getBbWidth() * 0.2, (double)entity.getBbHeight() * 0.2, (double)entity.getBbWidth() * 0.2, 1.0);
               }

               if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                  entity.getPersistentData().putDouble("cnt3", 1.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, (float)(0.5 + Math.random()));
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, (float)(0.5 + Math.random()), false);
                     }
                  }
               }
            }
         }

      }
   }
}
