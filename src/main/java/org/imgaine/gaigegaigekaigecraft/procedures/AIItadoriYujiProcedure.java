package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
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

public class AIItadoriYujiProcedure {
   public AIItadoriYujiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double distance = 0.0;
         double tick = 0.0;
         double level = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof ItadoriYujiShinjukuEntity) {
               lv_st = 18.0;
               lv_df = 3.0;
            } else if (entity instanceof ItadoriYujiShibuyaEntity) {
               lv_st = 10.0;
               lv_df = 3.0;
            } else {
               lv_st = 7.0;
               lv_df = 2.0;
            }

            label212: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label212;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label207: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label207;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)lv_df, false, false));
                  }
               }
            }

            if (entity instanceof ItadoriYujiEntity) {
               label226: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.hasEffect(MobEffects.INVISIBILITY)) {
                        ItemStack var54;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var54 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var54 = ItemStack.EMPTY;
                        }

                        if (var54.getItem() != JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()) {
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s invisibility 1000000 0 true");
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()));
                              _player.getInventory().setChanged();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()));
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.getInventory().armor.set(2, ItemStack.EMPTY);
                              _player.getInventory().setChanged();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.getInventory().armor.set(1, ItemStack.EMPTY);
                              _player.getInventory().setChanged();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.getInventory().armor.set(0, ItemStack.EMPTY);
                              _player.getInventory().setChanged();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.EMPTY.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.EMPTY.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }
                        break label226;
                     }
                  }

                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getInventory().armor.set(3, ItemStack.EMPTY);
                        _player.getInventory().setChanged();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                     }
                  }
               }
            }

            LivingEntity var55;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var55 = _mobEnt.getTarget();
            } else {
               var55 = null;
            }

            if (var55 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  distance = GetDistanceProcedure.execute(entity);
                  if (LogicStartProcedure.execute(entity) && entity instanceof ItadoriYujiShinjukuEntity && distance < 6.0 && Math.random() < 0.1) {
                     level = 0.0;
                     rnd = 2108.0;
                     tick = 100.0;
                  }

                  label231: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt35 = (LivingEntity)entity;
                        if (_livEnt35.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label231;
                        }
                     }

                     if (entity instanceof ItadoriYujiShibuyaEntity || entity instanceof ItadoriYujiShinjukuEntity) {
                        float var56;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var56 = _livEnt.getHealth();
                        } else {
                           var56 = -1.0F;
                        }

                        double var57 = (double)var56;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var57 < (double)var10001 * 0.75 || entity.getPersistentData().getDouble("cnt_target") > 1200.0) {
                           label232: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt41 = (LivingEntity)entity;
                                 if (_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                                    break label232;
                                 }
                              }

                              level = 1.0;
                              rnd = 2118.0;
                              tick = 50.0;
                           }
                        }
                     }

                     if (distance < 8.0 && Math.random() < 0.2) {
                        level = 1.0;
                        rnd = 2105.0;
                        tick = 25.0;
                     }

                     if (Math.random() < 0.2 && distance < 8.0) {
                        level = 1.0;
                        rnd = 2106.0;
                        tick = 50.0;
                     }
                  }

                  if (rnd > 0.0) {
                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().putDouble("skill", (double)Math.round(rnd));
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
