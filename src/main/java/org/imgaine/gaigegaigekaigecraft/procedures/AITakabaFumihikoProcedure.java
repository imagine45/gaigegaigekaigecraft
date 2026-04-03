package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AITakabaFumihikoProcedure {
   public AITakabaFumihikoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  MobEffectInstance var10001;
                  MobEffect var10003 = MobEffects.DAMAGE_BOOST;
                  LivingEntity var10005;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10005 = _mobEnt.getTarget();
                  } else {
                     var10005 = null;
                  }
                  int var49;
                  label166: {
                     LivingEntity var20 = var10005;
                     if (var20 instanceof LivingEntity) {
                        LivingEntity _livEnt = var20;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var49 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label166;
                        }
                     }

                     var49 = 0;
                  }

                  var10001 = new MobEffectInstance(var10003, 20, var49, false, false);
                  _entity.addEffect(var10001);
               }
            }

            label154: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label154;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               entity.getPersistentData().putDouble("cnt_x2", Math.max(entity.getPersistentData().getDouble("cnt_x2"), 20.0) + 1.0);
               if (entity.getPersistentData().getDouble("skill") == 0.0 && entity.getPersistentData().getDouble("cnt_x2") > 30.0) {
                  ItemStack var46;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var46 = _livEnt.getMainHandItem();
                  } else {
                     var46 = ItemStack.EMPTY;
                  }

                  if (var46.getItem() != JujutsucraftModItems.HARISEN.get() && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.HARISEN.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  rnd = 0.0;
                  level = 0.0;
                  tick = 0.0;
                  if (LogicStartProcedure.execute(entity)) {
                     label186: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt22 = (LivingEntity)entity;
                           if (_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                              if (distance > 4.0 && distance < 24.0 && Math.random() < 0.25) {
                                 rnd = 10.0;
                                 level = 0.0;
                                 tick = 200.0;
                              }
                              break label186;
                           }
                        }

                        rnd = 15.0;
                        level = 0.0;
                        tick = 100.0;
                     }
                  }

                  if (rnd != 15.0) {
                     label187: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt23 = (LivingEntity)entity;
                           if (_livEnt23.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label187;
                           }
                        }

                        if (distance > 4.0 && distance < 16.0 && Math.random() < 0.25) {
                           rnd = 6.0;
                           level = 1.0;
                           tick = 50.0;
                        }
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().putDouble("skill", 1700.0 + rnd);
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

                     ItemStack var47;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var47 = _livEnt.getMainHandItem();
                     } else {
                        var47 = ItemStack.EMPTY;
                     }

                     if (var47.getItem() == JujutsucraftModItems.HARISEN.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = ItemStack.EMPTY.copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               if (entity.getPersistentData().getDouble("cnt_x2") > 0.0) {
                  entity.getPersistentData().putDouble("cnt_x2", Math.min(entity.getPersistentData().getDouble("cnt_x2"), 20.0) - 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x2") <= 0.0) {
                     ItemStack var48;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var48 = _livEnt.getMainHandItem();
                     } else {
                        var48 = ItemStack.EMPTY;
                     }

                     if (var48.getItem() == JujutsucraftModItems.HARISEN.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = ItemStack.EMPTY.copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }

                     entity.getPersistentData().putDouble("cnt_x2", 0.0);
                  }
               }

               entity.getPersistentData().putBoolean("flag1", false);
            }
         }

      }
   }
}
