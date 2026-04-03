package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class AIMahitoProcedure {
   public AIMahitoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         boolean infinity = false;
         boolean domain = false;
         boolean success = false;
         boolean phase2 = false;
         boolean Sukuna = false;
         Entity entity_a = null;
         if (entity.isAlive()) {
            boolean var10000;
            label349: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                     var10000 = true;
                     break label349;
                  }
               }

               var10000 = false;
            }

            label344: {
               phase2 = var10000;
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label344;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 16, false, false));
                  }
               }
            }

            label339: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label339;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            LivingEntity var79;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var79 = _mobEnt.getTarget();
            } else {
               var79 = null;
            }

            if (var79 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var79 = _mobEnt.getTarget();
               } else {
                  var79 = null;
               }

               if (((Entity)var79).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:humans")))) {
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
               } else {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var79 = _mobEnt.getTarget();
                     } else {
                        var79 = null;
                     }
                     boolean var82;
                     label373: {
                        Entity var36 = var79;
                        if (ReturnInsideItemProcedure.execute(var36).getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                           label367: {
                              if (var36 instanceof LivingEntity) {
                                 LivingEntity _livEnt20 = (LivingEntity)var36;
                                 if (_livEnt20.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label367;
                                 }
                              }

                              var82 = false;
                              break label373;
                           }
                        }

                        var82 = true;
                     }

                     Sukuna = var82;
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if ((!(Math.random() > 0.7) || !LogicStartProcedure.execute(entity) || phase2) && !domain) {
                        tick = 0.0;
                        if (phase2) {
                           if (tick == 0.0) {
                              label306: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt39 = (LivingEntity)entity;
                                    if (_livEnt39.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       break label306;
                                    }
                                 }

                                 if (distance < 10.0 && Math.random() < 0.5) {
                                    entity.getPersistentData().putDouble("skill", (double)Math.round(1516.0F));
                                    level = 1.0;
                                    tick = 100.0;
                                 }
                              }

                              if (LogicStartProcedure.execute(entity) && distance < 4.0 && !Sukuna) {
                                 entity.getPersistentData().putDouble("skill", (double)Math.round(1505.0F));
                                 level = 0.0;
                                 tick = 50.0;
                              }
                           }

                           if (tick > 0.0) {
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
                           }
                        }

                        if (tick == 0.0) {
                           CalculateAttackProcedure.execute(world, entity);
                           if (LogicStartPassiveProcedure.execute(entity) && !phase2) {
                              if (entity.getPersistentData().getDouble("skill") % 100.0 == 2.0) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    ItemStack _setstack = (Math.random() < 0.5 ? ItemStack.EMPTY : new ItemStack((ItemLike)JujutsucraftModItems.MAHITO_HAND_1.get())).copy();
                                    _setstack.setCount(1);
                                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                    if (_entity instanceof Player) {
                                       Player _player = (Player)_entity;
                                       _player.getInventory().setChanged();
                                    }
                                 }
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (Math.random() < 0.5 ? ItemStack.EMPTY : new ItemStack((ItemLike)JujutsucraftModItems.MAHITO_HAND_2.get())).copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.EMPTY.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }

                        if (phase2) {
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
                     } else {
                        if (domain) {
                           rnd = 20.0;
                           tick = 5.0;
                        } else {
                           label370: {
                              label362: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt22 = (LivingEntity)entity;
                                    if (_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       if (!(entity instanceof LivingEntity)) {
                                          break label362;
                                       }

                                       LivingEntity _livEnt23 = (LivingEntity)entity;
                                       if (!_livEnt23.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label362;
                                       }
                                    }
                                 }

                                 float var83;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var83 = _livEnt.getHealth();
                                 } else {
                                    var83 = -1.0F;
                                 }

                                 double var84 = (double)var83;
                                 float var10001;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.getMaxHealth();
                                 } else {
                                    var10001 = -1.0F;
                                 }

                                 if (!(var84 < (double)var10001 * 0.5)) {
                                    int index0 = 0;

                                    while(true) {
                                       if (index0 >= 256) {
                                          break label370;
                                       }

                                       rnd = 3.0 + Math.ceil((double)Math.round(Math.random() * 17.0));
                                       if (rnd == 4.0) {
                                          tick = 50.0;
                                          if (!(Math.random() > 0.5)) {
                                             break label370;
                                          }
                                       } else if (rnd == 5.0) {
                                          tick = 50.0;
                                          if (!Sukuna && !(distance > 6.0)) {
                                             break label370;
                                          }
                                       } else if (rnd == 6.0) {
                                          tick = 50.0;
                                          if (!(distance > 12.0)) {
                                             break label370;
                                          }
                                       } else if (rnd == 7.0) {
                                          tick = 12.0;
                                          if (!(distance < 6.0)) {
                                             break label370;
                                          }
                                       } else if (rnd == 8.0) {
                                          tick = 75.0;
                                          if (!(distance < 2.0)) {
                                             break label370;
                                          }
                                       } else if (rnd == 9.0) {
                                          tick = 150.0;
                                          if (!(Math.random() > 0.75) && !(distance < 6.0)) {
                                             break label370;
                                          }
                                       } else if (rnd == 10.0) {
                                          tick = 100.0;
                                          if (!(Math.random() > 0.75) && !(distance < 6.0)) {
                                             break label370;
                                          }
                                       } else if (rnd == 15.0) {
                                          label364: {
                                             tick = 250.0;
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt26 = (LivingEntity)entity;
                                                if (_livEnt26.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   break label364;
                                                }
                                             }

                                             float var85;
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                var85 = _livEnt.getHealth();
                                             } else {
                                                var85 = -1.0F;
                                             }

                                             double var86 = (double)var85;
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                var10001 = _livEnt.getMaxHealth();
                                             } else {
                                                var10001 = -1.0F;
                                             }

                                             if (!(var86 >= (double)var10001 * 0.5)) {
                                                break label370;
                                             }
                                          }
                                       } else if (rnd == 20.0) {
                                          tick = 20.0;
                                          if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                             break label370;
                                          }
                                       }

                                       ++index0;
                                    }
                                 }
                              }

                              rnd = 15.0;
                              tick = 250.0;
                           }
                        }

                        if (rnd >= 5.0) {
                           entity.getPersistentData().putDouble("skill", (double)Math.round(1500.0 + rnd));
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
                           for(int index1 = 0; index1 < 3; ++index1) {
                              SummonHumansProcedure.execute(world, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ(), entity);
                           }
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
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
