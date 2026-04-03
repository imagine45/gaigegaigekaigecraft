package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIEightHandledSwordDivergentSilaDivineGeneralMahoragaProcedure {
   public AIEightHandledSwordDivergentSilaDivineGeneralMahoragaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         double tick = 0.0;
         double setItem = 0.0;
         double level = 0.0;
         double distance = 0.0;
         boolean StrongEnemy = false;
         boolean cut_the_world = false;
         if (entity.isAlive()) {
            label243: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               entity.getPersistentData().putDouble("KnockbackFix", 2.0);
               NUM1 = (double)(23L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.25));
               NUM2 = Math.min(Math.floor(NUM1 / 4.0), 3.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label243;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            label238: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label238;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
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
                  label267: {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt14 = (LivingEntity)entity;
                        if (_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label267;
                        }
                     }

                     if (distance < 24.0 && Math.random() < 0.5) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(1601.0F));
                        level = 1.0;
                        tick = 20.0;
                     }

                     if (distance < 48.0 && Math.random() < 0.25) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(1607.0F));
                        level = 1.0;
                        tick = 125.0;
                     } else if (distance > 8.0 && Math.random() < 0.25) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(1608.0F));
                        level = 1.0;
                        tick = 75.0;
                     }

                     label220: {
                        if (entity.isInWater()) {
                           if (!(Math.random() < 0.75)) {
                              break label220;
                           }
                        } else if (!(Math.random() < 0.15)) {
                           break label220;
                        }

                        entity.getPersistentData().putDouble("skill", (double)Math.round(1609.0F));
                        level = 1.0;
                        tick = 150.0;
                     }

                     if (distance < 24.0 && Math.random() < 0.1) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(1615.0F));
                        level = 1.0;
                        tick = 150.0;
                     }
                  }

                  if (LogicStartProcedure.execute(entity)) {
                     cut_the_world = false;
                     ItemStack var54;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var54 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var54 = ItemStack.EMPTY;
                     }

                     label253: {
                        if (var54.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var54 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var54 = ItemStack.EMPTY;
                           }

                           if (var54.getItem() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                              break label253;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var54 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var54 = ItemStack.EMPTY;
                        }

                        if (var54.getOrCreateTag().getDouble("skill205") >= 1000.0) {
                           cut_the_world = true;
                        }
                     }

                     if (cut_the_world && distance < 40.0) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(1619.0F));
                        level = 0.0;
                        tick = 250.0;
                     }
                  }

                  label265: {
                     if (entity.getPersistentData().getDouble("skill") != 0.0) {
                        label258: {
                           if (level > 0.0) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt29 = (LivingEntity)entity;
                                 if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label258;
                                 }
                              }
                           } else if (!LogicStartProcedure.execute(entity)) {
                              break label258;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                              }
                           }

                           if (level > 0.0) {
                              setItem = 1.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                                 }
                              }
                           } else {
                              setItem = 2.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                                 }
                              }
                           }
                           break label265;
                        }
                     }

                     CalculateAttackProcedure.execute(world, entity);
                     if (entity.getPersistentData().getDouble("skill") != 0.0) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getBoolean("CursedSpirit")) {
                           setItem = 2.0;
                        } else {
                           setItem = Math.random() < 0.5 ? 2.0 : 1.0;
                        }
                     }
                  }

                  if (setItem == 1.0) {
                     ItemStack var58;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var58 = _livEnt.getMainHandItem();
                     } else {
                        var58 = ItemStack.EMPTY;
                     }

                     if (var58.getItem() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = ItemStack.EMPTY.copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }
                  } else if (setItem == 2.0) {
                     ItemStack var59;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var59 = _livEnt.getMainHandItem();
                     } else {
                        var59 = ItemStack.EMPTY;
                     }

                     if (var59.getItem() != JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OF_EXTERMINATION.get())).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

         if (entity.getPersistentData().getDouble("skill") != entity.getPersistentData().getDouble("old_skill")) {
            if (entity.getPersistentData().getDouble("skill") == 1609.0 && entity instanceof LivingEntity) {
               LivingEntity _livingEntity48 = (LivingEntity)entity;
               if (_livingEntity48.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  AttributeInstance var60;
                  double var10001;
                  label186: {
                     var60 = _livingEntity48.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity47 = (LivingEntity)entity;
                        if (_livingEntity47.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity47.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label186;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var60.setBaseValue(var10001 + 2.0);
               }
            }

            if (entity.getPersistentData().getDouble("old_skill") == 1609.0 && entity instanceof LivingEntity) {
               LivingEntity _livingEntity51 = (LivingEntity)entity;
               if (_livingEntity51.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  AttributeInstance var61;
                  double var62;
                  label172: {
                     var61 = _livingEntity51.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity50 = (LivingEntity)entity;
                        if (_livingEntity50.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var62 = _livingEntity50.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label172;
                        }
                     }

                     var62 = 0.0;
                  }

                  var61.setBaseValue(var62 - 2.0);
               }
            }
         }

         entity.getPersistentData().putDouble("old_skill", entity.getPersistentData().getDouble("skill"));
      }
   }
}
