package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIYorozuProcedure {
   public AIYorozuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double NUM2 = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                  AIActiveFlyingProcedure.execute(world, entity);
               }
            }

            label126: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label126;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 19, false, false));
                  }
               }
            }

            label121: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label121;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
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

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  rnd = 0.0;
                  level = 0.0;
                  tick = 0.0;
                  if (LogicStartProcedure.execute(entity)) {
                     label110: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt13 = (LivingEntity)entity;
                           if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                              break label110;
                           }
                        }

                        if (entity.getPersistentData().getDouble("cnt_target") > 200.0) {
                           level = 0.0;
                           rnd = 14.0;
                           tick = 20.0;
                        }
                     }

                     if (!LocateTrueSphereProcedure.execute(world, entity)) {
                        float var34;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var34 = _livEnt.getHealth();
                        } else {
                           var34 = -1.0F;
                        }

                        double var35 = (double)var34;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var35 < (double)var10001 * 0.5 && Math.random() < 0.5) {
                           level = 0.0;
                           rnd = 15.0;
                           tick = 20.0;
                        }
                     }

                     if (Math.random() < 0.25) {
                        if (!LocateLiquidMetalProcedure.execute(world, entity)) {
                           level = 0.0;
                           rnd = 12.0;
                           tick = 20.0;
                        } else if (distance > 6.0) {
                           if (Math.random() < 0.5) {
                              level = 0.0;
                              rnd = 8.0;
                              tick = 10.0;
                           } else {
                              level = 0.0;
                              rnd = 9.0;
                              tick = 25.0;
                           }
                        }
                     }
                  }

                  if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity) || !AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() < 0.1) {
                     level = 0.0;
                     rnd = 20.0;
                     tick = 20.0;
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().putDouble("skill", 3900.0 + rnd);
                     if (level > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
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
