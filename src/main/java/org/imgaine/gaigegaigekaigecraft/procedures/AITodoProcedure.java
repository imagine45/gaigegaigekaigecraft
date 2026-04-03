package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.TodoAoiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AITodoProcedure {
   public AITodoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof TodoAoiEntity) {
               AIBoogieWoogieActiveProcedure.execute(world, x, y, z, entity);
            }

            label133: {
               lv_st = 11.0;
               lv_df = 3.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label133;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label128: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label128;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)lv_df, false, false));
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
                  label156: {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof TodoAoiEntity) {
                        label145: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt14 = (LivingEntity)entity;
                              if (_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label145;
                              }
                           }

                           if (Math.random() < 0.05) {
                              if (!(entity instanceof LivingEntity)) {
                                 break label156;
                              }

                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (!_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 break label156;
                              }
                           }
                        }
                     }

                     if (entity instanceof TodoAoiEntity) {
                        label104: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt20 = (LivingEntity)entity;
                              if (_livEnt20.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label104;
                              }
                           }

                           if (Math.random() < 0.2 && distance > 8.0 && distance < 24.0) {
                              entity.getPersistentData().putDouble("skill", (double)Math.round(2006.0F));
                              tick = 50.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                                    return;
                                 }
                              }

                              return;
                           }
                        }
                     }

                     if (entity instanceof TodoAoiEntity) {
                        label94: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt25 = (LivingEntity)entity;
                              if (_livEnt25.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label94;
                              }
                           }

                           if (Math.random() < 0.2 && distance < 8.0) {
                              entity.getPersistentData().putDouble("skill", (double)Math.round(2007.0F));
                              tick = 50.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                                    return;
                                 }
                              }

                              return;
                           }
                        }
                     }

                     CalculateAttackProcedure.execute(world, entity);
                     return;
                  }

                  entity.getPersistentData().putDouble("skill", (double)Math.round(2015.0F));
                  tick = 300.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
