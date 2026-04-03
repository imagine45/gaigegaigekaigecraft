package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit112Procedure {
   public AICursedSpirit112Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logicStart = false;
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double pitch_cal = 0.0;
         double yaw = 0.0;
         double yaw_cal = 0.0;
         if (entity.isAlive()) {
            label131: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label131;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 9, false, false));
                  }
               }
            }

            label126: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label126;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 2, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  logicStart = LogicStartProcedure.execute(entity);
                  if (!LogicCooldownCombatProcedure.execute(entity) && Math.random() < 0.5 && distance < 32.0) {
                     level = 1.0;
                     rnd = 4705.0;
                     tick = 50.0;
                  }

                  if (logicStart) {
                     if (Math.random() < 0.75 && distance > 8.0 && distance < 32.0) {
                        level = 0.0;
                        rnd = 4706.0;
                        tick = 25.0;
                     }

                     if (Math.random() < 0.5 && distance > 4.0 && distance < 32.0) {
                        level = 0.0;
                        rnd = 4707.0;
                        tick = 50.0;
                     }

                     if (Math.random() < 0.25 && distance < 32.0) {
                        level = 0.0;
                        rnd = 4708.0;
                        tick = 200.0;
                     }

                     if (Math.random() < 0.3 && distance < 32.0) {
                        level = 0.0;
                        rnd = 4709.0;
                        tick = 150.0;
                     }

                     if (Math.random() < 0.3 && distance < 12.0) {
                        level = 0.0;
                        rnd = 4710.0;
                        tick = 50.0;
                     }

                     float var37;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var37 = _livEnt.getHealth();
                     } else {
                        var37 = -1.0F;
                     }

                     double var38 = (double)var37;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMaxHealth();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var38 <= (double)var10001 * 0.25) {
                        if (!entity.getPersistentData().getBoolean("flag1")) {
                           entity.getPersistentData().putBoolean("flag1", true);
                           level = 0.0;
                           rnd = 4715.0;
                           tick = 250.0;
                        }
                     } else {
                        entity.getPersistentData().putBoolean("flag1", false);
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().putDouble("skill", (double)Math.round(rnd));
                     if (level > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2147483647, 0, false, false));
                           }
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
