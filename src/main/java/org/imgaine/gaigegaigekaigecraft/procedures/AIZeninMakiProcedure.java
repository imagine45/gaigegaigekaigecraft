package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.nbt.CompoundTag;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninMakiCullingGameEntity;
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

public class AIZeninMakiProcedure {
   public AIZeninMakiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean awaked = false;
         double rnd = 0.0;
         double level_strength = 0.0;
         double level_resistance = 0.0;
         double level_physical_gifted = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            awaked = entity instanceof ZeninMakiCullingGameEntity;
            if (awaked) {
               level_strength = 24.0;
               level_resistance = 3.0;
               level_physical_gifted = 4.0;
            } else {
               level_strength = 8.0;
               level_resistance = 2.0;
               level_physical_gifted = 0.0;
               if (!entity.getPersistentData().getBoolean("flag_start")) {
                  entity.getPersistentData().putBoolean("flag_start", true);
                  entity.getPersistentData().putBoolean("HasWeapon1", false);
                  entity.getPersistentData().putBoolean("HasWeapon2", true);
                  entity.getPersistentData().putBoolean("HasWeapon3", true);
               }
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label173;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)level_strength, false, false));
                  }
               }
            }

            label168: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label168;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)level_resistance, false, false));
                  }
               }
            }

            label163: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     break label163;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get(), 2147483647, (int)level_physical_gifted, false, false));
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
                  CalculateAttackProcedure.execute(world, entity);
                  if (!awaked) {
                     boolean var55;
                     CompoundTag var50;
                     label153: {
                        var50 = entity.getPersistentData();
                        if (!entity.getPersistentData().getBoolean("HasWeapon1")) {
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           if (var10002.getItem() != JujutsucraftModItems.NAGINATA.get()) {
                              var55 = false;
                              break label153;
                           }
                        }

                        var55 = true;
                     }
                     CompoundTag var51;
                     label147: {
                        var50.putBoolean("HasWeapon1", var55);
                        var51 = entity.getPersistentData();
                        if (!entity.getPersistentData().getBoolean("HasWeapon2")) {
                           ItemStack var56;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var56 = _livEnt.getMainHandItem();
                           } else {
                              var56 = ItemStack.EMPTY;
                           }

                           if (var56.getItem() != JujutsucraftModItems.SLAUGHTER_DEMON.get()) {
                              var55 = false;
                              break label147;
                           }
                        }

                        var55 = true;
                     }
                     CompoundTag var52;
                     label141: {
                        var51.putBoolean("HasWeapon2", var55);
                        var52 = entity.getPersistentData();
                        if (!entity.getPersistentData().getBoolean("HasWeapon3")) {
                           ItemStack var58;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var58 = _livEnt.getMainHandItem();
                           } else {
                              var58 = ItemStack.EMPTY;
                           }

                           if (var58.getItem() != JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                              var55 = false;
                              break label141;
                           }
                        }

                        var55 = true;
                     }

                     var52.putBoolean("HasWeapon3", var55);
                     float var53;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var53 = _livEnt.getHealth();
                     } else {
                        var53 = -1.0F;
                     }

                     double var54 = (double)var53;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMaxHealth();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var54 <= (double)var10001 * 0.5) {
                        if (entity.getPersistentData().getBoolean("HasWeapon3")) {
                           entity.getPersistentData().putBoolean("HasWeapon3", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        } else if (entity.getPersistentData().getBoolean("HasWeapon1")) {
                           entity.getPersistentData().putBoolean("HasWeapon1", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        } else if (entity.getPersistentData().getBoolean("HasWeapon2")) {
                           entity.getPersistentData().putBoolean("HasWeapon2", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }
                     } else if (Math.random() > 0.5) {
                        for(int index0 = 0; index0 < 5; ++index0) {
                           rnd = (double)Math.round(Math.ceil(Math.random() * 2.0));
                           if (rnd == 1.0) {
                              if (entity.getPersistentData().getBoolean("HasWeapon1")) {
                                 entity.getPersistentData().putBoolean("HasWeapon1", false);
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).copy();
                                    _setstack.setCount(1);
                                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                    if (_entity instanceof Player) {
                                       Player _player = (Player)_entity;
                                       _player.getInventory().setChanged();
                                    }
                                 }
                                 break;
                              }
                           } else if (rnd == 2.0 && entity.getPersistentData().getBoolean("HasWeapon2")) {
                              entity.getPersistentData().putBoolean("HasWeapon2", false);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }
                              break;
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
