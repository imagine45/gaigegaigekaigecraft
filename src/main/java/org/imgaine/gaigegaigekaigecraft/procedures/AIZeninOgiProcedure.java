package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIZeninOgiProcedure {
   public AIZeninOgiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double distance = 0.0;
         double health = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            label170: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label170;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 10, false, false));
                  }
               }
            }

            label165: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label165;
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

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  ItemStack var35;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.getMainHandItem();
                  } else {
                     var35 = ItemStack.EMPTY;
                  }

                  label192: {
                     if (var35.getItem() == JujutsucraftModItems.SWORD_OGI.get() && LogicStartProcedure.execute(entity)) {
                        LivingEntity var36;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var36 = _mobEnt.getTarget();
                        } else {
                           var36 = null;
                        }
                        int var37;
                        label152: {
                           LivingEntity var24 = var36;
                           if (var24 instanceof LivingEntity) {
                              LivingEntity _livEnt = var24;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var37 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label152;
                              }
                           }

                           var37 = 0;
                        }

                        int var10001;
                        label147: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label147;
                              }
                           }

                           var10001 = 0;
                        }

                        if (var37 - var10001 >= -2) {
                           break label192;
                        }

                        float var38;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var38 = _livEnt.getHealth();
                        } else {
                           var38 = -1.0F;
                        }

                        double var39 = (double)var38;
                        float var41;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var41 = _livEnt.getMaxHealth();
                        } else {
                           var41 = -1.0F;
                        }

                        if (var39 < (double)var41 * 0.5) {
                           break label192;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (var35.getItem() == JujutsucraftModItems.BLAZING_COURAGE.get() && LogicStartProcedure.execute(entity) && Math.random() < 0.75) {
                        distance = GetDistanceProcedure.execute(entity);

                        for(int index0 = 0; index0 < 128; ++index0) {
                           rnd = (double)(10L + Math.round(Math.random() * 6.0));
                           if (rnd == 11.0) {
                              tick = 50.0;
                              if (!(distance < 6.0)) {
                                 break;
                              }
                           } else if (rnd == 12.0) {
                              tick = 25.0;
                              if (!(distance > 6.0)) {
                                 break;
                              }
                           } else if (rnd == 13.0) {
                              tick = 63.0;
                              if (!(distance > 16.0)) {
                                 break;
                              }
                           } else if (rnd == 14.0) {
                              tick = 75.0;
                              if (!(distance > 8.0)) {
                                 break;
                              }
                           } else if (rnd == 15.0) {
                              tick = 100.0;
                              if (!(distance > 12.0)) {
                                 break;
                              }
                           }
                        }

                        entity.getPersistentData().putDouble("skill", (double)Math.round(2600.0 + rnd));
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
                              return;
                           }
                        }

                        return;
                     }

                     CalculateAttackProcedure.execute(world, entity);
                     return;
                  }

                  entity.getPersistentData().putDouble("skill", (double)Math.round(2605.0F));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 50, 0, false, false));
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
