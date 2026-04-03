package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.HakariKinjiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIKashimoHajimeProcedure {
   public AIKashimoHajimeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean vsSukuna = false;
         boolean MythicalBeastAmber = false;
         Entity target_entity = null;
         double rnd = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double level = 0.0;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var30 = var10000;
         if (entity.isAlive()) {
            label204: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label204;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 19, false, false));
                  }
               }
            }

            label199: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label199;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            if (var30 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  boolean var42;
                  label191: {
                     entity.getPersistentData().putDouble("cnt_x", 5.0);
                     ResetCounterProcedure.execute(entity);
                     if (var30 instanceof LivingEntity) {
                        LivingEntity _livEnt12 = (LivingEntity)var30;
                        if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           var42 = true;
                           break label191;
                        }
                     }

                     var42 = false;
                  }
                  boolean var43;
                  label186: {
                     vsSukuna = var42;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           var43 = true;
                           break label186;
                        }
                     }

                     var43 = false;
                  }

                  MythicalBeastAmber = var43;
                  distance = GetDistanceProcedure.execute(entity);
                  if (MythicalBeastAmber && LogicStartProcedure.execute(entity)) {
                     if (distance < 16.0 && Math.random() < 0.25) {
                        rnd = 16.0;
                        level = 0.0;
                        tick = 50.0;
                     }

                     if (distance > 6.0 && Math.random() < 0.25) {
                        rnd = 17.0;
                        level = 0.0;
                        tick = 125.0;
                     }
                  }

                  if (rnd == 0.0) {
                     label221: {
                        if (distance < 16.0 && Math.random() < 0.1) {
                           rnd = 3.0;
                           level = 1.0;
                           tick = 25.0;
                        }

                        label224: {
                           if (!MythicalBeastAmber) {
                              if (vsSukuna) {
                                 break label224;
                              }
                              int var44;
                              label175: {
                                 if (var30 instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)var30;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var44 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label175;
                                    }
                                 }

                                 var44 = 0;
                              }

                              int var10001;
                              label170: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label170;
                                    }
                                 }

                                 var10001 = 0;
                              }

                              if (var44 >= var10001 * 2) {
                                 break label224;
                              }
                           }

                           label227: {
                              label218: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt16 = (LivingEntity)entity;
                                    if (_livEnt16.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       break label218;
                                    }
                                 }

                                 float var45;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var45 = _livEnt.getHealth();
                                 } else {
                                    var45 = -1.0F;
                                 }

                                 double var46 = (double)var45;
                                 float var47;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var47 = _livEnt.getMaxHealth();
                                 } else {
                                    var47 = -1.0F;
                                 }

                                 if (var46 < (double)var47 * 0.5) {
                                    break label227;
                                 }

                                 if (var30 instanceof LivingEntity) {
                                    LivingEntity _livEnt19 = (LivingEntity)var30;
                                    if (_livEnt19.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       if (!(var30 instanceof LivingEntity)) {
                                          break label227;
                                       }

                                       LivingEntity _livEnt20 = (LivingEntity)var30;
                                       if (!_livEnt20.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label227;
                                       }
                                    }
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt21 = (LivingEntity)entity;
                                 if (_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label221;
                                 }
                              }

                              if ((!(((Entity)var30).getPersistentData().getDouble("Thunder") >= 5.0) && !entity.isInWater() || !(Math.random() > 0.5) && !(distance > 6.0)) && !(((Entity)var30).getPersistentData().getDouble("Thunder") >= 15.0)) {
                                 break label221;
                              }

                              if (var30 instanceof HakariKinjiEntity && var30 instanceof LivingEntity) {
                                 LivingEntity _livEnt26 = (LivingEntity)var30;
                                 if (_livEnt26.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    break label221;
                                 }
                              }

                              rnd = 5.0;
                              level = 1.0;
                              tick = 10.0;
                              break label221;
                           }

                           rnd = 10.0;
                           level = 1.0;
                           tick = 10.0;
                           break label221;
                        }

                        rnd = 15.0;
                        level = 1.0;
                        tick = 10.0;
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().putDouble("skill", 700.0 + rnd);
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
