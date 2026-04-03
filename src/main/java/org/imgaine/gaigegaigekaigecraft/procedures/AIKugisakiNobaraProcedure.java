package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIKugisakiNobaraProcedure {
   public AIKugisakiNobaraProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean weapon = false;
         double rnd = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            label95: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label95;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 4, false, false));
                  }
               }
            }

            label90: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label90;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 1, false, false));
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
                  label81: {
                     entity.getPersistentData().putDouble("cnt_x", -10.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt12 = (LivingEntity)entity;
                        if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label81;
                        }
                     }

                     if (distance > 3.0 && distance < 24.0 && entity.getPersistentData().getDouble("cnt_nail") < 5.0 && Math.random() < 0.5) {
                        rnd = 5.0;
                        level = 1.0;
                        tick = 3.0;
                     }
                  }

                  if (LogicStartProcedure.execute(entity) && Math.pow(0.75, entity.getPersistentData().getDouble("cnt_nail")) < Math.random()) {
                     rnd = 6.0;
                     level = 0.0;
                     tick = 50.0;
                  }

                  if (rnd > 0.0) {
                     if (rnd == 5.0) {
                        entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 6.0));
                        entity.getPersistentData().putDouble("cnt_nail", entity.getPersistentData().getDouble("cnt_nail") + 1.0);
                     } else if (rnd == 6.0) {
                        entity.getPersistentData().putDouble("cnt_nail", Math.max(entity.getPersistentData().getDouble("cnt_nail") - 10.0, 0.0));
                     }

                     entity.getPersistentData().putDouble("skill", 3400.0 + rnd);
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
