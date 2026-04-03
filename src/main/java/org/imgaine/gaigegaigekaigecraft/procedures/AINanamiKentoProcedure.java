package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AINanamiKentoProcedure {
   public AINanamiKentoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         if (entity.isAlive()) {
            label131: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().putDouble("cnt_nanami", entity.getPersistentData().getDouble("cnt_nanami") + 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label131;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 10, false, false));
                  }
               }
            }

            label138: {
               if (world instanceof Level) {
                  Level _lvl5 = (Level)world;
                  if (_lvl5.isDay()) {
                     break label138;
                  }
               }

               int var10000;
               label124: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label124;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 <= 11 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 11, false, false));
                  }
               }
            }

            label116: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label116;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            LivingEntity var33;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var33 = _mobEnt.getTarget();
            } else {
               var33 = null;
            }

            if (var33 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  if (LogicStartPassiveProcedure.execute(entity) && entity.getPersistentData().getDouble("cnt_nanami") > 0.0) {
                     entity.getPersistentData().putDouble("cnt_nanami", -60.0);
                     WeaponNanamiRightClickedInAirProcedure.execute(world, entity);
                  }

                  if (LogicStartProcedure.execute(entity) && Math.random() > 0.9 && distance < 36.0 && entity.getPersistentData().getDouble("cnt_target") > 600.0) {
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

                     if (var35 < (double)var10001 * 0.5) {
                        rnd = 10.0;
                        tick = 200.0;
                        entity.getPersistentData().putDouble("skill", 1300.0 + rnd);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                              return;
                           }
                        }

                        return;
                     }
                  }

                  label98: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt25 = (LivingEntity)entity;
                        if (_livEnt25.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label98;
                        }
                     }

                     if (Math.random() < 0.2 && distance < 8.0) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(1307.0F));
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

                  CalculateAttackProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
