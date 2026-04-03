package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.PandaNormalEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIPandaProcedure {
   public AIPandaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double strength = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            int var10000;
            if (entity instanceof PandaNormalEntity) {
               PandaNormalEntity _datEntI = (PandaNormalEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(PandaNormalEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               strength = 8.0;
            } else {
               strength = 6.0;
            }

            label134: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label134;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)strength, false, false));
                  }
               }
            }

            label129: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label129;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 2, false, false));
                  }
               }
            }

            LivingEntity var38;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var38 = _mobEnt.getTarget();
            } else {
               var38 = null;
            }

            if (var38 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  int var39;
                  if (entity instanceof PandaNormalEntity) {
                     PandaNormalEntity _datEntI = (PandaNormalEntity)entity;
                     var39 = (Integer)_datEntI.getEntityData().get(PandaNormalEntity.DATA_form);
                  } else {
                     var39 = 0;
                  }

                  if (var39 == 0) {
                     float var40;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var40 = _livEnt.getHealth();
                     } else {
                        var40 = -1.0F;
                     }

                     double var41 = (double)var40;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMaxHealth();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var41 < (double)var10001 * 0.5) {
                        if (entity instanceof PandaNormalEntity) {
                           PandaNormalEntity _datEntSetI = (PandaNormalEntity)entity;
                           _datEntSetI.getEntityData().set(PandaNormalEntity.DATA_form, 1);
                        }

                        if (entity instanceof PandaNormalEntity) {
                           PandaNormalEntity animatable = (PandaNormalEntity)entity;
                           animatable.setTexture("panda_gorilla");
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMaxHealth();
                           } else {
                              var10001 = -1.0F;
                           }

                           _entity.setHealth(var10001);
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.removeEffect(MobEffects.DAMAGE_BOOST);
                        }
                     }
                  }

                  label145: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt21 = (LivingEntity)entity;
                        if (_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label145;
                        }
                     }

                     if (entity instanceof PandaNormalEntity) {
                        PandaNormalEntity _datEntI = (PandaNormalEntity)entity;
                        var39 = (Integer)_datEntI.getEntityData().get(PandaNormalEntity.DATA_form);
                     } else {
                        var39 = 0;
                     }

                     if (var39 > 0 && distance < 6.0 && Math.random() < 0.15) {
                        rnd = 1606.0;
                        level = 1.0;
                        tick = 50.0;
                     }
                  }

                  if (rnd > 0.0) {
                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().putDouble("skill", rnd);
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
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
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
