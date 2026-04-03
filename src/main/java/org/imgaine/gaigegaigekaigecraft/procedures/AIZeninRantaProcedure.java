package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ZeninRantaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIZeninRantaProcedure {
   public AIZeninRantaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            label108: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label108;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 10, false, false));
                  }
               }
            }

            label103: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label103;
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

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  if (LogicStartProcedure.execute(entity) && distance < 32.0) {
                     rnd = 4610.0;
                     tick = 125.0;
                     entity.getPersistentData().putDouble("skill", rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
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

         if (entity instanceof ZeninRantaEntity) {
            ZeninRantaEntity _datEntL16 = (ZeninRantaEntity)entity;
            if ((Boolean)_datEntL16.getEntityData().get(ZeninRantaEntity.DATA_damaged)) {
               float var37;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var37 = _livEnt.getHealth();
               } else {
                  var37 = -1.0F;
               }

               double var38 = (double)var37;
               float var39;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var39 = _livEnt.getMaxHealth();
               } else {
                  var39 = -1.0F;
               }

               if (var38 > (double)var39 * 0.6) {
                  if (entity instanceof ZeninRantaEntity) {
                     ZeninRantaEntity _datEntSetL = (ZeninRantaEntity)entity;
                     _datEntSetL.getEntityData().set(ZeninRantaEntity.DATA_damaged, false);
                  }

                  if (entity instanceof ZeninRantaEntity) {
                     ZeninRantaEntity animatable = (ZeninRantaEntity)entity;
                     animatable.setTexture("zenin_ranta");
                     return;
                  }
               }

               return;
            }
         }

         float var35;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var35 = _livEnt.getHealth();
         } else {
            var35 = -1.0F;
         }

         double var36 = (double)var35;
         float var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMaxHealth();
         } else {
            var10001 = -1.0F;
         }

         if (var36 < (double)var10001 * 0.3) {
            if (entity instanceof ZeninRantaEntity) {
               ZeninRantaEntity _datEntSetL = (ZeninRantaEntity)entity;
               _datEntSetL.getEntityData().set(ZeninRantaEntity.DATA_damaged, true);
            }

            if (entity instanceof ZeninRantaEntity) {
               ZeninRantaEntity animatable = (ZeninRantaEntity)entity;
               animatable.setTexture("zenin_ranta2");
            }
         }

      }
   }
}
