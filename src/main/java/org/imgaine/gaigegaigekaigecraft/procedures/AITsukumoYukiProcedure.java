package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GarudaBallEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class AITsukumoYukiProcedure {
   public AITsukumoYukiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         double health = 0.0;
         boolean logic_a = false;
         boolean logic_start = false;
         boolean domain = false;
         boolean adult = false;
         Entity entity_rika = null;
         if (entity.isAlive()) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }
               int var63;
               label294: {
                  LivingEntity var27 = var10000;
                  if (var27 instanceof LivingEntity) {
                     LivingEntity _livEnt = var27;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var63 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label294;
                     }
                  }

                  var63 = 0;
               }
               double var64;
               int var10001;
               label289: {
                  var64 = (double)var63 * 0.75;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label289;
                     }
                  }

                  var10001 = 0;
               }

               if (var64 <= (double)var10001 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
                  }
               }
            }

            label281: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label281;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 18, false, false));
                  }
               }
            }

            label276: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label276;
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
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  if (LogicStartPassiveProcedure.execute(entity) && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get(), 2147483647, 9, false, false));
                     }
                  }

                  label320: {
                     label307: {
                        logic_a = LocateGarudaProcedure.execute(world, entity);
                        logic_start = LogicStartProcedure.execute(entity);
                        domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                        distance = GetDistanceProcedure.execute(entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt19 = (LivingEntity)entity;
                           if (_livEnt19.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label307;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        LivingEntity _livEnt = var10000;
                        if (_livEnt instanceof Mob) {
                           Mob _mobEnt = (Mob)_livEnt;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 instanceof GarudaEntity || Math.random() < 0.15 && distance < 8.0) {
                           rnd = 4.0;
                           level = 1.0;
                           tick = 50.0;
                           break label320;
                        }
                     }

                     if (logic_start && (Math.random() > 0.75 || !logic_a) || domain) {
                        if (domain) {
                           level = 0.0;
                           tick = 20.0;
                           rnd = 20.0;
                        } else if (!logic_a && logic_start) {
                           rnd = 6.0;
                           level = 0.0;
                           tick = 38.0;
                        } else {
                           float var68;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var68 = _livEnt.getHealth();
                           } else {
                              var68 = -1.0F;
                           }

                           float var71;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var71 = _livEnt.getMaxHealth();
                           } else {
                              var71 = -1.0F;
                           }

                           health = (double)(var68 / var71);
                           if (health >= 0.3) {
                              entity.getPersistentData().putBoolean("flag1", false);
                           }

                           if (!entity.getPersistentData().getBoolean("flag1") && health < 0.3 && distance < 32.0) {
                              int var69;
                              label238: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var69 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label238;
                                    }
                                 }

                                 var69 = 0;
                              }

                              double var70 = (double)var69 * 0.75;
                              LivingEntity var72;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var72 = _mobEnt.getTarget();
                              } else {
                                 var72 = null;
                              }
                              int var73;
                              label232: {
                                 LivingEntity var30 = var72;
                                 if (var30 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var30;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var73 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label232;
                                    }
                                 }

                                 var73 = 0;
                              }

                              if (var70 <= (double)var73) {
                                 entity.getPersistentData().putBoolean("flag1", true);
                                 level = 0.0;
                                 rnd = 10.0;
                                 tick = 0.0;
                              }
                           }

                           if (rnd == 0.0) {
                              for(int index0 = 0; index0 < 64; ++index0) {
                                 rnd = (double)Mth.nextInt(RandomSource.create(), 5, 7);
                                 if (rnd == 7.0) {
                                    rnd = 20.0;
                                 }

                                 if (rnd == 5.0 && logic_start) {
                                    level = 0.0;
                                    tick = 250.0;
                                    if (!(Math.random() < 0.66) && !(distance < 6.0)) {
                                       break;
                                    }
                                 } else {
                                    if (rnd == 6.0 && logic_start) {
                                       level = 0.0;
                                       tick = 38.0;
                                       break;
                                    }

                                    if (rnd == 20.0) {
                                       level = 0.0;
                                       tick = 20.0;
                                       if (!(Math.random() > 0.075)) {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt32 = (LivingEntity)entity;
                                             if (_livEnt32.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                continue;
                                             }
                                          }

                                          if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                             break;
                                          }
                                       }
                                    } else {
                                       rnd = 0.0;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().putDouble("skill", (double)Math.round(900.0 + rnd));
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

                     if ((rnd == 4.0 || rnd == 5.0) && entity.getPersistentData().getDouble("friend_num") != 0.0) {
                        entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("GARUDA_UUID"));
                        if ((entity_rika instanceof GarudaEntity || entity_rika instanceof GarudaBallEntity) && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num") && !entity_rika.level().isClientSide()) {
                           entity_rika.discard();
                        }
                     }

                     if (rnd == 4.0 && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get())).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }

                     if (rnd == 5.0 && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM_BALL.get())).copy();
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
            }
         }

      }
   }
}
