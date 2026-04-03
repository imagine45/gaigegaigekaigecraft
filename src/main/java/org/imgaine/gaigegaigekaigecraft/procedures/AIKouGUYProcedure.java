package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade212Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade213Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade214Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade215Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade217Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade21Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade22Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade23Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade24Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade25Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade26Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade28Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade29Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIKouGUYProcedure {
   public AIKouGUYProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double lv_resistance = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double lv_strength = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof CursedSpiritGrade29Entity) {
               AIActiveFlyingProcedure.execute(world, entity);
            }

            if (entity instanceof CursedSpiritGrade22Entity) {
               lv_strength = 8.0;
               lv_resistance = 2.0;
            } else if (!(entity instanceof CursedSpiritGrade26Entity) && !(entity instanceof CursedSpiritGrade213Entity)) {
               if (!(entity instanceof CursedSpiritGrade21Entity) && !(entity instanceof CursedSpiritGrade23Entity) && !(entity instanceof CursedSpiritGrade24Entity) && !(entity instanceof CursedSpiritGrade25Entity) && !(entity instanceof CursedSpiritGrade28Entity) && !(entity instanceof CursedSpiritGrade29Entity) && !(entity instanceof CursedSpiritGrade212Entity) && !(entity instanceof CursedSpiritGrade214Entity) && !(entity instanceof CursedSpiritGrade215Entity) && !(entity instanceof CursedSpiritGrade217Entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 10, false, false));
                     }
                  }

                  label132: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt16 = (LivingEntity)entity;
                        if (_livEnt16.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                           break label132;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                     }
                  }

                  lv_strength = 5.0;
                  lv_resistance = 1.0;
               } else {
                  lv_strength = 6.0;
                  lv_resistance = 1.0;
               }
            } else {
               lv_strength = 7.0;
               lv_resistance = 1.0;
            }

            label125: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt18 = (LivingEntity)entity;
                  if (_livEnt18.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label125;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)lv_strength, false, false));
                  }
               }
            }

            label120: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt20 = (LivingEntity)entity;
                  if (_livEnt20.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label120;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)lv_resistance, false, false));
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
                  if (entity instanceof CursedSpiritGrade26Entity) {
                     label164: {
                        distance = GetDistanceProcedure.execute(entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt30 = (LivingEntity)entity;
                           if (_livEnt30.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label164;
                           }
                        }

                        if (distance < 32.0 && Math.random() < 0.5) {
                           entity.getPersistentData().putDouble("skill", (double)Math.round(1615.0F));
                           level = 1.0;
                           tick = 150.0;
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("skill") != 0.0) {
                     label171: {
                        if (level > 0.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt33 = (LivingEntity)entity;
                              if (_livEnt33.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label171;
                              }
                           }
                        } else if (!LogicStartProcedure.execute(entity)) {
                           break label171;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }

                        if (level > 0.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              }

                              return;
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }

                           return;
                        }

                        return;
                     }
                  }

                  CalculateAttackProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
