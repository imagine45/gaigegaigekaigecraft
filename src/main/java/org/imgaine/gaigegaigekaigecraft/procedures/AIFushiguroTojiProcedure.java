package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.nbt.CompoundTag;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
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

public class AIFushiguroTojiProcedure {
   public AIFushiguroTojiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack setItemA = ItemStack.EMPTY;
         boolean StrongEnemy = false;
         boolean awaked = false;
         double rnd = 0.0;
         double level_strength = 0.0;
         double level_resistance = 0.0;
         double level_physical_gifted = 0.0;
         if (entity.isAlive()) {
            label222: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label222;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 25, false, false));
                  }
               }
            }

            label217: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label217;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            label212: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     break label212;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get(), 2147483647, 4, false, false));
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
                  entity.getPersistentData().putDouble("cnt_x", 5.0);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
                  if (entity instanceof FushiguroTojiEntity) {
                     if (!entity.getPersistentData().getBoolean("Armoury")) {
                        entity.getPersistentData().putBoolean("Armoury", true);
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()));
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()));
                        }

                        entity.getPersistentData().putBoolean("HasWeapon1", true);
                        entity.getPersistentData().putBoolean("HasWeapon2", true);
                        entity.getPersistentData().putBoolean("HasWeapon3", true);
                     }

                     if (entity.getPersistentData().getDouble("skill") != 0.0) {
                        ItemStack var47;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var47 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                        } else {
                           var47 = ItemStack.EMPTY;
                        }

                        if (var47.getItem() == JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()) {
                           boolean var58;
                           CompoundTag var48;
                           label198: {
                              var48 = entity.getPersistentData();
                              if (!entity.getPersistentData().getBoolean("HasWeapon1")) {
                                 ItemStack var10002;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10002 = _livEnt.getMainHandItem();
                                 } else {
                                    var10002 = ItemStack.EMPTY;
                                 }

                                 if (var10002.getItem() != JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                                    var58 = false;
                                    break label198;
                                 }
                              }

                              var58 = true;
                           }
                           CompoundTag var49;
                           label192: {
                              var48.putBoolean("HasWeapon1", var58);
                              var49 = entity.getPersistentData();
                              if (!entity.getPersistentData().getBoolean("HasWeapon2")) {
                                 ItemStack var59;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var59 = _livEnt.getMainHandItem();
                                 } else {
                                    var59 = ItemStack.EMPTY;
                                 }

                                 if (var59.getItem() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                                    var58 = false;
                                    break label192;
                                 }
                              }

                              var58 = true;
                           }
                           CompoundTag var50;
                           label186: {
                              var49.putBoolean("HasWeapon2", var58);
                              var50 = entity.getPersistentData();
                              if (!entity.getPersistentData().getBoolean("HasWeapon3")) {
                                 ItemStack var61;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var61 = _livEnt.getMainHandItem();
                                 } else {
                                    var61 = ItemStack.EMPTY;
                                 }

                                 if (var61.getItem() != JujutsucraftModItems.SPLIT_SOUL_KATANA.get()) {
                                    var58 = false;
                                    break label186;
                                 }
                              }

                              var58 = true;
                           }

                           var50.putBoolean("HasWeapon3", var58);
                           LivingEntity var51;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var51 = _mobEnt.getTarget();
                           } else {
                              var51 = null;
                           }

                           label230: {
                              label231: {
                                 LivingEntity var25 = var51;
                                 if (var25 instanceof LivingEntity) {
                                    LivingEntity _livEnt37 = var25;
                                    if (_livEnt37.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       break label231;
                                    }
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var51 = _mobEnt.getTarget();
                                 } else {
                                    var51 = null;
                                 }

                                 if (!(var51 instanceof GojoSatoruSchoolDaysEntity)) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var51 = _mobEnt.getTarget();
                                    } else {
                                       var51 = null;
                                    }

                                    if (!(var51 instanceof GojoSatoruEntity)) {
                                       setItemA = ItemStack.EMPTY.copy();
                                       int index0 = 0;

                                       while(true) {
                                          if (index0 >= 16) {
                                             break label230;
                                          }

                                          label166: {
                                             rnd = Math.ceil(Math.random() * 3.0);
                                             if (rnd == 1.0) {
                                                if (entity.getPersistentData().getBoolean("HasWeapon1")) {
                                                   entity.getPersistentData().putBoolean("HasWeapon1", false);
                                                   setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).copy();
                                                }
                                             } else if (rnd == 2.0) {
                                                if (entity instanceof Mob) {
                                                   Mob _mobEnt = (Mob)entity;
                                                   var51 = _mobEnt.getTarget();
                                                } else {
                                                   var51 = null;
                                                }

                                                if (((Entity)var51).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                                                   break label166;
                                                }

                                                if (entity instanceof Mob) {
                                                   Mob _mobEnt = (Mob)entity;
                                                   var51 = _mobEnt.getTarget();
                                                } else {
                                                   var51 = null;
                                                }

                                                if (var51 instanceof Player) {
                                                   if (entity instanceof Mob) {
                                                      Mob _mobEnt = (Mob)entity;
                                                      var51 = _mobEnt.getTarget();
                                                   } else {
                                                      var51 = null;
                                                   }

                                                   if (((JujutsucraftModVariables.PlayerVariables)((Entity)var51).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer < 100.0) {
                                                      break label166;
                                                   }
                                                }

                                                if (entity.getPersistentData().getBoolean("HasWeapon2")) {
                                                   entity.getPersistentData().putBoolean("HasWeapon2", false);
                                                   setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())).copy();
                                                }
                                             } else if (rnd == 3.0 && entity.getPersistentData().getBoolean("HasWeapon3")) {
                                                entity.getPersistentData().putBoolean("HasWeapon3", false);
                                                setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.SPLIT_SOUL_KATANA.get())).copy();
                                             }

                                             if (setItemA.getItem() != ItemStack.EMPTY.getItem()) {
                                                break label230;
                                             }
                                          }

                                          ++index0;
                                       }
                                    }
                                 }
                              }

                              ItemStack var57;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var57 = _livEnt.getMainHandItem();
                              } else {
                                 var57 = ItemStack.EMPTY;
                              }

                              if (var57.getItem() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() && entity.getPersistentData().getBoolean("HasWeapon2")) {
                                 entity.getPersistentData().putBoolean("HasWeapon2", false);
                              }

                              setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())).copy();
                           }

                           if (setItemA.getItem() != ItemStack.EMPTY.getItem() && entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = setItemA.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }
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
