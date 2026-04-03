package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityEyeRantaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIZeninJinichiProcedure {
   public AIZeninJinichiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         Entity entity_target = null;
         if (entity.isAlive()) {
            label114: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label114;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 11, false, false));
                  }
               }
            }

            label109: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label109;
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

            Entity var20 = var10000;
            if (var20 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  if (LogicStartProcedure.execute(entity) && Math.random() < 0.75) {
                     int var29;
                     label96: {
                        distance = GetDistanceProcedure.execute(entity);
                        if (var20 instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)var20;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              var29 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                              break label96;
                           }
                        }

                        var29 = 0;
                     }
                     label91: {
                        if (var29 < 1) {
                           if (!(var20 instanceof LivingEntity)) {
                              break label91;
                           }

                           LivingEntity _livEnt13 = (LivingEntity)var20;
                           if (!_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                              break label91;
                           }
                        }

                        if (!world.getEntitiesOfClass(EntityEyeRantaEntity.class, AABB.ofSize(new Vec3(((Entity)var20).getX(), ((Entity)var20).getY(), ((Entity)var20).getZ()), 2.0, 2.0, 2.0), (e) -> true).isEmpty()) {
                           rnd = 7.0;
                           tick = 250.0;
                        }
                     }

                     if (rnd == 0.0) {
                        for(int index0 = 0; index0 < 256; ++index0) {
                           rnd = (double)Math.round(4.0 + Math.ceil(Math.random() * 7.0));
                           level = 0.0;
                           if (rnd == 5.0) {
                              tick = 50.0;
                              break;
                           }

                           if (rnd == 6.0) {
                              tick = 50.0;
                              break;
                           }

                           if (rnd == 7.0) {
                              tick = 250.0;
                              if (!(distance > 32.0)) {
                                 break;
                              }
                           } else if (rnd == 8.0) {
                              tick = 100.0;
                              if (!(distance > 12.0)) {
                                 break;
                              }
                           }
                        }
                     }

                     entity.getPersistentData().putDouble("skill", (double)Math.round(2200.0 + rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, (int)level, false, false));
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
