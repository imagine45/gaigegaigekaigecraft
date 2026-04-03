package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.LevelAccessor;

public class AIDaidoHaganeProcedure {
   public AIDaidoHaganeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double level = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  MobEffectInstance var10001;
                  MobEffect var10003 = MobEffects.DAMAGE_BOOST;
                  ItemStack var10005;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10005 = _livEnt.getMainHandItem();
                  } else {
                     var10005 = ItemStack.EMPTY;
                  }

                  var10001 = new MobEffectInstance(var10003, 10, var10005.getItem() instanceof SwordItem ? 20 : 0, false, false);
                  _entity.addEffect(var10001);
               }
            }

            label80: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label80;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               MahoragaCutTheWorldProcedure.execute(world, x, y, z, entity);
            } else {
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
                     entity.getPersistentData().putDouble("cnt_x", 5.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     rnd = 0.0;
                     level = 0.0;
                     tick = 0.0;
                     ItemStack var30;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var30 = _livEnt.getMainHandItem();
                     } else {
                        var30 = ItemStack.EMPTY;
                     }

                     if (var30.getItem() instanceof SwordItem) {
                        label94: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt16 = (LivingEntity)entity;
                              if (_livEnt16.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label94;
                              }
                           }

                           level = 1.0;
                           rnd = 1.0;
                           tick = 250.0;
                        }
                     }

                     if (rnd > 0.0) {
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
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
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
}
