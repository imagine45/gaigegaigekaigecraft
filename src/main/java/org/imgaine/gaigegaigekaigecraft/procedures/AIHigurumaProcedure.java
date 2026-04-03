package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIHigurumaProcedure {
   public AIHigurumaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double tick = 0.0;
         double old_skill = 0.0;
         double distance = 0.0;
         double level = 0.0;
         ItemStack item_mainHand = ItemStack.EMPTY;
         boolean domain = false;
         boolean have_gavel = false;
         Entity target_entity = null;
         if (entity.isAlive()) {
            label313: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               lv_st = 10.0;
               lv_df = 3.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label313;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label308: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label308;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)lv_df, false, false));
                  }
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            item_mainHand = var10000.copy();
            have_gavel = item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get() || item_mainHand.getItem() == JujutsucraftModItems.GAVEL_LONG.get() || item_mainHand.getItem() == JujutsucraftModItems.GAVEL_BIG.get();
            LivingEntity var59;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var59 = _mobEnt.getTarget();
            } else {
               var59 = null;
            }

            Entity var44 = var59;
            if (var44 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               int var60;
               label320: {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  entity.getPersistentData().putDouble("cnt_x4", entity.getPersistentData().getDouble("cnt_x4") + 1.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt16 = (LivingEntity)entity;
                     if (_livEnt16.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        label287: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                 var60 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                 break label287;
                              }
                           }

                           var60 = 0;
                        }

                        if (var60 > 0) {
                           entity.getPersistentData().putDouble("cnt_x3", entity.getPersistentData().getDouble("cnt_x3") + 1.0);
                           if (entity.getPersistentData().getDouble("cnt_x3") > 200.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                              rnd = 2719.0;
                              level = 1.0;
                              tick = 20.0;
                           }
                           break label320;
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     entity.getPersistentData().putDouble("cnt_x2", 0.0);
                     entity.getPersistentData().putDouble("cnt_x3", (double)(var44 instanceof Player ? -400 : 0));
                     distance = GetDistanceProcedure.execute(entity);
                     if (item_mainHand.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                        int var61;
                        label321: {
                           if (var44 instanceof LivingEntity) {
                              LivingEntity _livEnt29 = (LivingEntity)var44;
                              if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                 break label321;
                              }
                           }

                           label275: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var61 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label275;
                                 }
                              }

                              var61 = 0;
                           }

                           int var10001;
                           double var62;
                           label270: {
                              var62 = (double)var61 * 0.8;
                              if (var44 instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)var44;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label270;
                                 }
                              }

                              var10001 = 0;
                           }

                           if (var62 <= (double)var10001) {
                              label322: {
                                 float var63;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var63 = _livEnt.getHealth();
                                 } else {
                                    var63 = -1.0F;
                                 }

                                 double var64 = (double)var63;
                                 float var68;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var68 = _livEnt.getMaxHealth();
                                 } else {
                                    var68 = -1.0F;
                                 }

                                 if (!(var64 <= (double)var68 * 0.7) && !(entity.getPersistentData().getDouble("cnt_target") > 900.0)) {
                                    int var65;
                                    label260: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                             var65 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                             break label260;
                                          }
                                       }

                                       var65 = 0;
                                    }
                                    int var66;
                                    int var69;
                                    label255: {
                                       var66 = var65 * 2;
                                       if (var44 instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)var44;
                                          if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                             var69 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                             break label255;
                                          }
                                       }

                                       var69 = 0;
                                    }

                                    if (var66 > var69) {
                                       break label322;
                                    }
                                 }

                                 entity.getPersistentData().putBoolean("flag_domain", true);
                              }
                           }
                        }
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     ResetCounterProcedure.execute(entity);
                     if (domain) {
                        rnd = 2720.0;
                        level = 0.0;
                        tick = 20.0;
                     }

                     if (rnd == 0.0 && item_mainHand.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get() && !LogicCooldownCombatProcedure.execute(entity)) {
                        if (distance > 6.0 && distance < 24.0 && Math.random() < 0.5) {
                           rnd = 2707.0;
                           level = 1.0;
                           tick = 25.0;
                        }

                        if (distance < 24.0 && Math.random() < 0.5) {
                           rnd = 2708.0;
                           level = 1.0;
                           tick = 50.0;
                        }

                        if (distance < 16.0 && Math.random() < 0.25) {
                           if (Math.random() < 0.5) {
                              rnd = 2710.0;
                              level = 1.0;
                              tick = 50.0;
                           } else {
                              rnd = 2711.0;
                              level = 1.0;
                              tick = 100.0;
                           }
                        }
                     }

                     if (rnd == 0.0) {
                        old_skill = entity.getPersistentData().getDouble("skill");
                        if (entity.getPersistentData().getDouble("skill") == 0.0) {
                           label244: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt41 = (LivingEntity)entity;
                                 if (_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label244;
                                 }
                              }

                              if (item_mainHand.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get() && !have_gavel) {
                                 GetGavelProcedure.execute(world, x, y, z, entity);
                              }
                           }
                        }

                        CalculateAttackProcedure.execute(world, entity);
                        if (entity.getPersistentData().getDouble("skill") == 4203.0) {
                           entity.getPersistentData().putDouble("skill", 2706.0);
                        } else {
                           if (have_gavel && item_mainHand.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get() && entity.getPersistentData().getDouble("skill") != old_skill) {
                              rnd = Math.ceil(Math.random() * 6.0);

                              for(int index0 = 0; index0 < 5; ++index0) {
                                 ItemStack var67;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var67 = _livEnt.getMainHandItem();
                                 } else {
                                    var67 = ItemStack.EMPTY;
                                 }

                                 item_mainHand = var67.copy();
                                 if (rnd != 1.0 && rnd != 2.0 && rnd != 3.0) {
                                    if (rnd != 4.0 && rnd != 5.0) {
                                       if (rnd == 6.0 && item_mainHand.getItem() == JujutsucraftModItems.GAVEL_BIG.get()) {
                                          break;
                                       }
                                    } else if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL_LONG.get()) {
                                       break;
                                    }
                                 } else if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
                                    break;
                                 }

                                 GavelRightClicked2Procedure.execute(world, x, y, z, entity);
                              }
                           }

                           rnd = 0.0;
                        }
                     }
                  }
               }

               if (rnd > 0.0) {
                  entity.getPersistentData().putDouble("skill", rnd);
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

                  if (rnd == 2720.0) {
                     entity.getPersistentData().putDouble("cnt_x3", (double)(var44 instanceof Player ? -400 : 0));
                     entity.getPersistentData().putBoolean("flag_domain", false);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 80, 1, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 80, 1, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x2") % 200.0 == 60.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
               }
            }
         }

      }
   }
}
