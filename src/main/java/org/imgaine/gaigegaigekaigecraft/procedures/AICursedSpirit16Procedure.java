package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit16Procedure {
   public AICursedSpirit16Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_noSkill = false;
         double rnd = 0.0;
         double tick = 0.0;
         double skill_num = 0.0;
         double distance = 0.0;
         if (entity.isAlive()) {
            label108: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                     break label108;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 2147483647, 9, false, false));
                  }
               }
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
            }

            label102: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label102;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 9, false, false));
                  }
               }
            }

            label97: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label97;
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
               if (entity.getPersistentData().getDouble("cnt_target") % 5.0 == 4.0) {
                  boolean var29;
                  label85: {
                     label84: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt12 = (LivingEntity)entity;
                           if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                              break label84;
                           }
                        }

                        if (entity.getPersistentData().getDouble("skill") == 0.0) {
                           var29 = true;
                           break label85;
                        }
                     }

                     var29 = false;
                  }

                  logic_noSkill = var29;
                  if (logic_noSkill) {
                     distance = GetDistanceProcedure.execute(entity);
                     if (distance > 24.0) {
                        if (Math.random() < 0.75) {
                           entity.getPersistentData().putBoolean("PRESS_W", true);
                           entity.getPersistentData().putBoolean("PRESS_S", false);
                           skill_num = 1930.0;
                        }
                     } else if (distance > 5.0 && Math.random() < 0.25) {
                        entity.getPersistentData().putBoolean("PRESS_W", true);
                        entity.getPersistentData().putBoolean("PRESS_S", false);
                        skill_num = 1930.0;
                     }

                     if (entity.getPersistentData().getDouble("cnt_backstep") > 10.0 && Math.random() < 0.75) {
                        entity.getPersistentData().putBoolean("PRESS_W", false);
                        entity.getPersistentData().putBoolean("PRESS_S", true);
                        skill_num = 1930.0;
                     }
                  }

                  if (skill_num != 0.0) {
                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().putDouble("skill", skill_num);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  }
               }

               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
