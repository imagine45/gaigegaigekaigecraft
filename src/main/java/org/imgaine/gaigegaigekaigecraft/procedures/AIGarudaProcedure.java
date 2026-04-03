package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaBallEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class AIGarudaProcedure {
   public AIGarudaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         boolean ball = false;
         Entity entity_a = null;
         double rnd = 0.0;
         double dis = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double HP = 0.0;
         if (entity.isAlive()) {
            ball = entity instanceof GarudaBallEntity;
            if (!ball) {
               AIActiveProcedure.execute(world, x, y, z, entity);
            }

            label206: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label206;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)entity.getPersistentData().getDouble("Strength"), false, false));
                  }
               }
            }

            label201: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label201;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)Math.round(Math.min(entity.getPersistentData().getDouble("Strength") / 4.0, 3.0)), false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
               if (LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (!entity_a.isAlive()) {
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  } else if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                     label216: {
                        if (!ball) {
                           dis = Math.sqrt(Math.pow(entity_a.getX() - entity.getX(), 2.0) + Math.pow(entity_a.getY() - entity.getY(), 2.0) + Math.pow(entity_a.getZ() - entity.getZ(), 2.0));
                           if (dis > 8.0) {
                              entity.getPersistentData().putBoolean("canFly", true);
                              GetPowerForwardProcedure.execute((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity);
                              entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.5, entity.getPersistentData().getDouble("y_power") * 0.5, entity.getPersistentData().getDouble("z_power") * 0.5));
                              if (dis > 16.0) {
                                 entity.teleportTo((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                    _serverPlayer.connection.teleport((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity.getYRot(), entity.getXRot());
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
                        }

                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt39 = (LivingEntity)entity_a;
                           if (_livEnt39.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt41 = (LivingEntity)entity;
                                 if (_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                    int var10000;
                                    label182: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                             var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                                             break label182;
                                          }
                                       }

                                       var10000 = 0;
                                    }

                                    int var10001;
                                    label177: {
                                       if (entity_a instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity_a;
                                          if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                             var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                                             break label177;
                                          }
                                       }

                                       var10001 = 0;
                                    }

                                    if (var10000 == var10001) {
                                       break label216;
                                    }
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                              }

                              if (!(entity instanceof LivingEntity)) {
                                 break label216;
                              }

                              LivingEntity _entity = (LivingEntity)entity;
                              if (_entity.level().isClientSide()) {
                                 break label216;
                              }

                              MobEffectInstance var57;
                              MobEffect var10003;
                              int var10005;
                              label171: {
                                 var10003 = (MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get();
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity_a;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                       var10005 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                                       break label171;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var57 = new MobEffectInstance(var10003, 200, var10005, false, false);
                              _entity.addEffect(var57);
                              break label216;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                        }
                     }
                  } else if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else {
                  entity.getPersistentData().putDouble("despawn_flag", 1.0);
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (entity.getPersistentData().getDouble("despawn_flag") > 0.0 && entity.getPersistentData().getDouble("friend_num") != 0.0) {
                  entity.getPersistentData().putDouble("cnt_target", 0.0);
                  entity.getPersistentData().putDouble("cnt_die", entity.getPersistentData().getDouble("cnt_die") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_die") > 5.0) {
                     DieRikaProcedure.execute(world, entity);
                     if (entity instanceof GarudaBallEntity) {
                        x_pos = entity.getX();
                        y_pos = entity.getY();
                        z_pos = entity.getZ();
                        yaw = (double)entity.getYRot();
                        rnd = 0.0;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.GARUDA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              entityinstance.setYRot((float)yaw);
                              entityinstance.setXRot((float)rnd);
                              entityinstance.setYBodyRot(entityinstance.getYRot());
                              entityinstance.setYHeadRot(entityinstance.getYRot());
                              entityinstance.yRotO = entityinstance.getYRot();
                              entityinstance.xRotO = entityinstance.getXRot();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.yBodyRotO = _entity.getYRot();
                                 _entity.yHeadRotO = _entity.getYRot();
                              }

                              if (entity_a instanceof LivingEntity) {
                                 entity_a.getPersistentData().putString("GARUDA_UUID", entityinstance.getStringUUID());
                              }

                              CompoundTag var56;
                              double var10002;
                              label137: {
                                 entityinstance.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                                 entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                                 entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                                 var56 = entityinstance.getPersistentData();
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var10002 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label137;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              var56.putDouble("Strength", var10002);
                              entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                              entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                              entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                              entityinstance.getPersistentData().putBoolean("Shikigami", true);
                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               } else if (!ball) {
                  attack = entity.getPersistentData().getBoolean("flag_attack");
                  LivingEntity var55;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var55 = _mobEnt.getTarget();
                  } else {
                     var55 = null;
                  }

                  if (!(var55 instanceof LivingEntity) && !attack) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_x") > 200.0 || attack) {
                        entity.getPersistentData().putBoolean("flag_attack", false);
                        entity.getPersistentData().putDouble("cnt_x", (double)(Math.round(Math.random() * -40.0) - 20L));
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().putDouble("skill", 1.0);
                     }
                  }
               }
            } else {
               if (entity.getPersistentData().getDouble("skill") != 0.0) {
                  if (ball) {
                     AIGarudaBallProcedure.execute(world, x, y, z, entity);
                  } else {
                     AIRika1Procedure.execute(world, x, y, z, entity);
                  }
               }

               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
               }
            }
         }

      }
   }
}
