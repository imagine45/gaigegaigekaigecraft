package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIInoTakumaProcedure {
   public AIInoTakumaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double skill = 0.0;
         ItemStack item_a = ItemStack.EMPTY;
         if (entity.isAlive()) {
            label182: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label182;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 9, false, false));
                  }
               }
            }

            label177: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label177;
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 8.0) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               entity.getPersistentData().putDouble("cnt_x2", 0.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  if (LogicStartProcedure.execute(entity)) {
                     if (GetDistanceProcedure.execute(entity) > 8.0 && Math.random() < 0.5) {
                        rnd = 5.0;
                        tick = 75.0;
                     } else {
                        label197: {
                           label163: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt14 = (LivingEntity)entity;
                                 if (_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get())) {
                                    break label163;
                                 }
                              }

                              if (Math.random() < 0.25) {
                                 rnd = 6.0;
                                 tick = 20.0;
                                 break label197;
                              }
                           }

                           label158: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt15 = (LivingEntity)entity;
                                 if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                                    break label158;
                                 }
                              }

                              if (Math.random() < 0.25) {
                                 rnd = 7.0;
                                 tick = 20.0;
                                 break label197;
                              }
                           }

                           float var44;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var44 = _livEnt.getHealth();
                           } else {
                              var44 = -1.0F;
                           }

                           double var45 = (double)var44;
                           float var10001;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMaxHealth();
                           } else {
                              var10001 = -1.0F;
                           }

                           if (!(var45 < (double)var10001 * 0.5)) {
                              int var46;
                              label150: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var46 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label150;
                                    }
                                 }

                                 var46 = 0;
                              }

                              var45 = (double)var46;
                              LivingEntity var50;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var50 = _mobEnt.getTarget();
                              } else {
                                 var50 = null;
                              }
                              int var51;
                              label144: {
                                 LivingEntity var23 = var50;
                                 if (var23 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var23;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var51 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label144;
                                    }
                                 }

                                 var51 = 0;
                              }

                              if (!(var45 < (double)var51 * 0.5) && !(entity.getPersistentData().getDouble("cnt_target") > 600.0)) {
                                 break label197;
                              }
                           }

                           if (Math.random() < 0.2) {
                              rnd = 8.0;
                              tick = 400.0;
                           }
                        }
                     }
                  }

                  if (rnd > 0.0) {
                     ItemStack var48;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var48 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var48 = ItemStack.EMPTY;
                     }

                     if (var48.getItem() == JujutsucraftModItems.CLOTHES_INO_TAKUMA_1_HELMET.get()) {
                        item_a = (new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_INO_TAKUMA_2_HELMET.get())).copy();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var48 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var48 = ItemStack.EMPTY;
                        }

                        CompoundTag _nbtTag = var48.getTag();
                        if (_nbtTag != null) {
                           item_a.setTag(_nbtTag.copy());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(3, item_a);
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.HEAD, item_a);
                        }
                     }

                     entity.getPersistentData().putDouble("skill", 4000.0 + rnd);
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
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x2") > 120.0) {
                  entity.getPersistentData().putDouble("cnt_x2", 0.0);
                  ItemStack var42;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var42 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var42 = ItemStack.EMPTY;
                  }

                  if (var42.getItem() == JujutsucraftModItems.CLOTHES_INO_TAKUMA_2_HELMET.get()) {
                     item_a = (new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_INO_TAKUMA_1_HELMET.get())).copy();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var42 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var42 = ItemStack.EMPTY;
                     }

                     CompoundTag _nbtTag = var42.getTag();
                     if (_nbtTag != null) {
                        item_a.setTag(_nbtTag.copy());
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getInventory().armor.set(3, item_a);
                        _player.getInventory().setChanged();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.setItemSlot(EquipmentSlot.HEAD, item_a);
                     }
                  }
               }
            }
         }

      }
   }
}
