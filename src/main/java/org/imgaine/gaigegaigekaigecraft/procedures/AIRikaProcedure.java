package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class AIRikaProcedure {
   public AIRikaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
         double rnd = 0.0;
         double dis = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double tick = 0.0;
         double setItem = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof Rika2Entity) {
               entity.getPersistentData().putDouble("cnt_connect", entity.getPersistentData().getDouble("cnt_connect") + 1.0);
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label173;
                  }
               }

               entity.setMaxUpStep((float)Math.max((double)entity.getStepHeight(), 2.4));
               if (entity instanceof RikaEntity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 20, false, false));
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 16, false, false));
                  }
               }
            }

            label168: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label168;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (entity instanceof Rika2Entity && entity.getPersistentData().getDouble("cnt_connect") > 3600.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity.getPersistentData().putDouble("despawn_flag", 1.0);
               }

               if (entity.getPersistentData().getDouble("despawn_flag") > 0.0 && entity.getPersistentData().getDouble("friend_num_worker") != 0.0) {
                  entity.getPersistentData().putDouble("cnt_target", 0.0);
                  entity.getPersistentData().putDouble("cnt_die", entity.getPersistentData().getDouble("cnt_die") + 1.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.ASH, x, y + (double)entity.getBbHeight() * 0.5, z, (int)(20.0 * ReturnEntitySizeProcedure.execute(entity)), 0.25 * (double)entity.getBbWidth(), 0.25 * (double)entity.getBbHeight(), 0.25 * (double)entity.getBbWidth(), 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y + (double)entity.getBbHeight() * 0.5, z, (int)(5.0 * ReturnEntitySizeProcedure.execute(entity)), 0.25 * (double)entity.getBbWidth(), 0.25 * (double)entity.getBbHeight(), 0.25 * (double)entity.getBbWidth(), 0.0);
                  }

                  if (entity.getPersistentData().getDouble("cnt_die") > (double)(entity.getPersistentData().getDouble("despawn_flag") == 1.0 ? 60 : 5)) {
                     DieRikaProcedure.execute(world, entity);
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               } else {
                  attack = entity.getPersistentData().getBoolean("flag_attack");
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if ((!(var10000 instanceof LivingEntity) || !(entity.getPersistentData().getDouble("cnt_target") > 6.0)) && !attack) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_x") > 10.0 || attack) {
                        label192: {
                           label184: {
                              entity.getPersistentData().putBoolean("flag_attack", false);
                              if (!attack) {
                                 if (!(Math.random() < 0.2)) {
                                    break label184;
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt42 = (LivingEntity)entity;
                                    if (_livEnt42.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       break label184;
                                    }
                                 }
                              }

                              entity.getPersistentData().putDouble("cnt_x", 0.0);
                              ResetCounterProcedure.execute(entity);
                              rnd = (double)Math.abs(Math.round(Math.random() * 50.0) + (long)(entity.getPersistentData().getDouble("friend_num_worker") == 0.0 ? 20 : 100));
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(rnd), 0, false, false));
                                 }
                              }

                              if (entity.getPersistentData().getDouble("friend_num_worker") == 0.0) {
                                 entity.getPersistentData().putDouble("skill_num", entity.getPersistentData().getDouble("skill_num") + 1.0);
                              }

                              if (entity.getPersistentData().getDouble("skill_num") < 8.0) {
                                 entity.getPersistentData().putDouble("skill", (double)(Math.random() < 0.75 ? 11 : 13));
                              } else {
                                 entity.getPersistentData().putDouble("skill", 12.0);
                                 entity.getPersistentData().putDouble("skill_num", 0.0);
                              }
                              break label192;
                           }

                           entity.getPersistentData().putDouble("cnt_x", 0.0);
                           CalculateAttackProcedure.execute(world, entity);
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
                     if (LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                        if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                           if (entity_a.isAlive()) {
                              dis = Math.sqrt(Math.pow(entity_a.getX() - entity.getX(), 2.0) + Math.pow(entity_a.getY() - entity.getY(), 2.0) + Math.pow(entity_a.getZ() - entity.getZ(), 2.0));
                              if (dis > 24.0) {
                                 entity.getPersistentData().putBoolean("canFly", true);
                                 GetPowerForwardProcedure.execute((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity);
                                 entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.5, entity.getPersistentData().getDouble("y_power") * 0.5, entity.getPersistentData().getDouble("z_power") * 0.5));
                                 if (dis > 36.0) {
                                    entity.teleportTo((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());
                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                       _serverPlayer.connection.teleport((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity.getYRot(), entity.getXRot());
                                    }

                                    entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                                    entity.setYRot(entity_a.getYRot());
                                    entity.setXRot(entity_a.getXRot());
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
                              }
                           } else {
                              entity.getPersistentData().putDouble("friend_num", 0.0);
                              entity.getPersistentData().putDouble("friend_num_worker", 0.0);
                              entity.getPersistentData().putString("OWNER_UUID", "");
                           }
                        }
                     } else {
                        entity.getPersistentData().putDouble("friend_num", 0.0);
                        entity.getPersistentData().putDouble("friend_num_worker", 0.0);
                        entity.getPersistentData().putString("OWNER_UUID", "");
                     }
                  }
               }
            } else {
               if (entity.getPersistentData().getDouble("skill") == 11.0) {
                  AIRika1Procedure.execute(world, x, y, z, entity);
               } else if (entity.getPersistentData().getDouble("skill") == 12.0) {
                  AIRika3Procedure.execute(world, x, y, z, entity);
               } else if (entity.getPersistentData().getDouble("skill") == 13.0) {
                  RikaBlastProcedure.execute(world, x, y, z, entity);
               }

               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
               }
            }
         }

      }
   }
}
