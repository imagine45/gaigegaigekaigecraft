package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.nbt.CompoundTag;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PurpleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class AISukunaProcedure {
   public AISukunaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_head = ItemStack.EMPTY;
         double rnd = 0.0;
         double tick = 0.0;
         double NUM_SUM = 0.0;
         double distance = 0.0;
         boolean domain = false;
         boolean infinity = false;
         boolean fushiguro_body = false;
         boolean mahoraga_exist = false;
         boolean vsMahoraga = false;
         boolean flag_megumiTechnique = false;
         Entity target_entity = null;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var41 = var10000;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            fushiguro_body = entity instanceof SukunaFushiguroEntity;
            ItemStack var97;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var97 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var97 = ItemStack.EMPTY;
            }

            item_head = var97.copy();
            if (fushiguro_body && !entity.getPersistentData().getBoolean("flag_start")) {
               entity.getPersistentData().putBoolean("flag_start", true);
               rnd = 4.0;

               for(int index0 = 0; index0 < 7; ++index0) {
                  entity.getPersistentData().putDouble("TenShadowsTechnique" + Math.round(rnd), 1.0);
                  ++rnd;
               }

               entity.getPersistentData().putDouble("TenShadowsTechnique1", -2.0);
               entity.getPersistentData().putDouble("TenShadowsTechnique5", -2.0);
               entity.getPersistentData().putDouble("TenShadowsTechnique14", 1.0);
            }

            label740: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label740;
                  }
               }

               label789: {
                  if (!(entity instanceof SukunaPerfectEntity)) {
                     label762: {
                        if (entity instanceof SukunaFushiguroEntity) {
                           SukunaFushiguroEntity _datEntL12 = (SukunaFushiguroEntity)entity;
                           if ((Boolean)_datEntL12.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                              break label762;
                           }
                        }

                        if (fushiguro_body) {
                           rnd = 30.0;
                        } else {
                           rnd = 25.0;
                        }
                        break label789;
                     }
                  }

                  rnd = 35.0;
                  entity.getPersistentData().putDouble("KnockbackFix", 1.0);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)Math.round(rnd), false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), 2147483647, (int)Math.round(Math.min(Math.max(rnd - 11.0, 0.0), 19.0)), false, false));
                  }
               }
            }

            label703: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt16 = (LivingEntity)entity;
                  if (_livEnt16.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label703;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            if (entity instanceof SukunaEntity && var41 instanceof JogoEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               if (((Entity)var41).getPersistentData().getDouble("skill") == 415.0) {
                  if (!entity.getPersistentData().getBoolean("flag2")) {
                     entity.getPersistentData().putBoolean("flag2", true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                     }
                  }
               } else if (entity.getPersistentData().getBoolean("flag2")) {
                  distance = GetDistanceProcedure.execute(entity);
                  if (distance < 32.0) {
                     if (distance < 6.0 && entity.onGround()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                        }

                        entity.getPersistentData().putBoolean("PRESS_S", true);
                        WhenBackStepProcedure.execute(world, entity);
                        entity.getPersistentData().putBoolean("PRESS_S", false);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                        }
                     }

                     if (var41 instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)var41;
                        _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                     }

                     if (var41 instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)var41;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                        }
                     }

                     if (var41 instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)var41;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                        }
                     }

                     if (((Entity)var41).onGround()) {
                        int var98;
                        label684: {
                           if (var41 instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)var41;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                 var98 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                 break label684;
                              }
                           }

                           var98 = 0;
                        }

                        if (var98 < 200 && var41 instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)var41;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                        }
                     }
                  }
               }
            }

            if (var41 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               if (fushiguro_body) {
                  label770: {
                     if (entity instanceof SukunaFushiguroEntity) {
                        SukunaFushiguroEntity _datEntL42 = (SukunaFushiguroEntity)entity;
                        if ((Boolean)_datEntL42.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                           break label770;
                        }
                     }

                     if (!(var41 instanceof GojoSatoruEntity) && !(var41 instanceof PurpleEntity)) {
                        float var99;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var99 = _livEnt.getHealth();
                        } else {
                           var99 = -1.0F;
                        }

                        double var100 = (double)var99;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var100 <= (double)var10001 * 0.3) {
                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity;
                              _datEntSetL.getEntityData().set(SukunaFushiguroEntity.DATA_perfect_mode, true);
                           }

                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity animatable = (SukunaFushiguroEntity)entity;
                              animatable.setTexture("sukuna_perfect");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 10, false, false));
                              }
                           }

                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.offhand with gaigegaigekaigecraft:supreme_martial_solution");
                           }

                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.chest with gaigegaigekaigecraft:sukuna_body_chestplate");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.removeEffect(MobEffects.DAMAGE_BOOST);
                           }

                           entity.getPersistentData().putDouble("cnt_reverse_lim", 0.0);
                           entity.getPersistentData().putDouble("skill", 1.0);
                           ReturnShadowProcedure.execute(world, x, y, z, entity);
                           entity.getPersistentData().putDouble("skill", 0.0);
                           if (item_head.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
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
                  }
               }
               boolean var101;
               label656: {
                  if (var41 instanceof LivingEntity) {
                     LivingEntity _livEnt59 = (LivingEntity)var41;
                     if (_livEnt59.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                        var101 = true;
                        break label656;
                     }
                  }

                  var101 = false;
               }

               infinity = var101;
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               entity.getPersistentData().putDouble("cnt_rest", 0.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  label800: {
                     mahoraga_exist = entity.getPersistentData().getDouble("TenShadowsTechnique14") == -1.0;
                     vsMahoraga = var41 instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
                     distance = GetDistanceProcedure.execute(entity);
                     if (vsMahoraga && entity.getPersistentData().getDouble("cnt_target") >= 2400.0 && entity.getPersistentData().getDouble("cnt_target") <= 3600.0) {
                        entity.getPersistentData().putBoolean("flag_domain", true);
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && !mahoraga_exist;
                     ResetCounterProcedure.execute(entity);
                     if (fushiguro_body) {
                        label643: {
                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity _datEntL70 = (SukunaFushiguroEntity)entity;
                              if ((Boolean)_datEntL70.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                 break label643;
                              }
                           }

                           if (entity.getPersistentData().getDouble("cnt_target") > 200.0 && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 1.0 && item_head.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                 _player.getInventory().setChanged();
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _living = (LivingEntity)entity;
                                 _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                              }
                           }
                        }
                     }

                     label638: {
                        label637: {
                           if (!entity.getPersistentData().getBoolean("flag1") && entity instanceof LivingEntity) {
                              LivingEntity _livEnt76 = (LivingEntity)entity;
                              if (_livEnt76.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break label637;
                              }
                           }

                           if (!entity.getPersistentData().getBoolean("flag2")) {
                              break label638;
                           }
                        }

                        if (distance < 48.0 && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 0, false, false));
                           }
                        }
                     }

                     label791: {
                        if (fushiguro_body) {
                           label806: {
                              if (entity instanceof SukunaFushiguroEntity) {
                                 SukunaFushiguroEntity _datEntL79 = (SukunaFushiguroEntity)entity;
                                 if ((Boolean)_datEntL79.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                    break label806;
                                 }
                              }

                              boolean var113;
                              CompoundTag var102;
                              label618: {
                                 entity.getPersistentData().putBoolean("flag_mahoraga", entity.getPersistentData().getDouble("TenShadowsTechnique14") > 0.0);
                                 var102 = entity.getPersistentData();
                                 if (entity.getPersistentData().getBoolean("flag_mahoraga")) {
                                    float var10002;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10002 = _livEnt.getHealth();
                                    } else {
                                       var10002 = -1.0F;
                                    }

                                    double var112 = (double)var10002;
                                    float var10003;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10003 = _livEnt.getMaxHealth();
                                    } else {
                                       var10003 = -1.0F;
                                    }

                                    if (var112 < (double)var10003 * 0.6 || item_head.getOrCreateTag().getDouble("skill205") >= 100.0 && infinity) {
                                       var113 = true;
                                       break label618;
                                    }
                                 }

                                 var113 = false;
                              }

                              var102.putBoolean("flag_mahoraga", var113);
                              float var103;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var103 = _livEnt.getHealth();
                              } else {
                                 var103 = -1.0F;
                              }

                              double var104 = (double)var103;
                              float var111;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var111 = _livEnt.getMaxHealth();
                              } else {
                                 var111 = -1.0F;
                              }

                              if (var104 > (double)var111 * 0.6) {
                                 LivingEntity var105;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var105 = _mobEnt.getTarget();
                                 } else {
                                    var105 = null;
                                 }

                                 if (var105 instanceof GojoSatoruEntity) {
                                    int var106;
                                    label604: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                             var106 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getAmplifier();
                                             break label604;
                                          }
                                       }

                                       var106 = 0;
                                    }

                                    if (var106 < 1) {
                                       entity.getPersistentData().putBoolean("flag_mahoraga", false);
                                    }
                                 }
                              }
                              break label791;
                           }
                        }

                        entity.getPersistentData().putBoolean("flag_mahoraga", false);
                     }
                     boolean var107;
                     label792: {
                        if (fushiguro_body) {
                           label778: {
                              if (entity instanceof SukunaFushiguroEntity) {
                                 SukunaFushiguroEntity _datEntL94 = (SukunaFushiguroEntity)entity;
                                 if ((Boolean)_datEntL94.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                    break label778;
                                 }
                              }

                              label803: {
                                 if (entity.getPersistentData().getBoolean("flag_mahoraga") || Math.random() < 0.2 && !infinity) {
                                    label802: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt96 = (LivingEntity)entity;
                                          if (_livEnt96.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                             break label802;
                                          }
                                       }

                                       if (!domain && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 1.0) {
                                          break label803;
                                       }
                                    }
                                 }

                                 if (!entity.getPersistentData().getBoolean("flag_agito") || !(entity.getPersistentData().getDouble("TenShadowsTechnique13") >= 0.0)) {
                                    var107 = false;
                                    break label792;
                                 }
                              }

                              var107 = true;
                              break label792;
                           }
                        }

                        var107 = false;
                     }

                     label571: {
                        flag_megumiTechnique = var107;
                        if (LogicStartProcedure.execute(entity)) {
                           if (Math.random() > (infinity ? 0.75 : 0.0) && distance < 48.0) {
                              break label571;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt100 = (LivingEntity)entity;
                              if (_livEnt100.hasEffect(MobEffects.HUNGER)) {
                                 break label571;
                              }
                           }

                           if (flag_megumiTechnique) {
                              break label571;
                           }
                        }

                        if (!domain) {
                           entity.getPersistentData().putDouble("cnt_x", 0.0);
                           rnd = 0.0;
                           tick = 0.0;
                           if (!LogicCooldownCombatProcedure.execute(entity) && !infinity) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                              }

                              if (LogicStartPassiveProcedure.execute(entity)) {
                                 if (distance < 16.0 && Math.random() < 0.5) {
                                    rnd = 111.0;
                                    tick = 50.0;
                                 }

                                 if (distance < 10.0 && Math.random() < 0.75) {
                                    rnd = 112.0;
                                    tick = 50.0;
                                 }

                                 if (distance < 48.0 && Math.random() < 0.25) {
                                    rnd = 113.0;
                                    tick = 50.0;
                                 }
                              }
                           }

                           if (rnd != 0.0) {
                              entity.getPersistentData().putDouble("skill", rnd);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
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
                           break label800;
                        }
                     }

                     if (flag_megumiTechnique) {
                        AIFushiguroMegumiProcedure.execute(world, x, y, z, entity);
                     } else {
                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                        if (domain) {
                           rnd = 20.0;
                           tick = 20.0;
                        } else if (entity.getPersistentData().getBoolean("flag2")) {
                           int var108;
                           label489: {
                              if (var41 instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)var41;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var108 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                    break label489;
                                 }
                              }

                              var108 = 0;
                           }

                           if (var108 <= 20) {
                              int var109;
                              label483: {
                                 if (var41 instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)var41;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var109 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getDuration();
                                       break label483;
                                    }
                                 }

                                 var109 = 0;
                              }

                              if (var109 <= 20) {
                                 entity.getPersistentData().putBoolean("flag2", false);
                                 rnd = 7.0;
                                 tick = 250.0;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get());
                                 }
                              }
                           }
                        } else {
                           label807: {
                              if (!entity.getPersistentData().getBoolean("flag1") && (!(var41 instanceof GojoSatoruEntity) || !(entity instanceof SukunaFushiguroEntity)) && entity instanceof LivingEntity) {
                                 LivingEntity _livEnt111 = (LivingEntity)entity;
                                 if (_livEnt111.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed") && entity.getPersistentData().getDouble("dust_amount") > 100.0) {
                                    int var110;
                                    label549: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                             var110 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                             break label549;
                                          }
                                       }

                                       var110 = 0;
                                    }

                                    if (var110 < 1200 || vsMahoraga) {
                                       entity.getPersistentData().putBoolean("flag1", true);
                                       rnd = 7.0;
                                       tick = 250.0;
                                       break label807;
                                    }
                                 }
                              }

                              if (infinity) {
                                 label527: {
                                    if (entity instanceof SukunaFushiguroEntity) {
                                       SukunaFushiguroEntity _datEntL116 = (SukunaFushiguroEntity)entity;
                                       if ((Boolean)_datEntL116.getEntityData().get(SukunaFushiguroEntity.DATA_world_cut)) {
                                          break label527;
                                       }
                                    }

                                    if (!(entity instanceof SukunaPerfectEntity)) {
                                       rnd = 0.0;
                                       break label807;
                                    }
                                 }
                              }

                              for(int index1 = 0; index1 < 256; ++index1) {
                                 rnd = (double)Mth.nextInt(RandomSource.create(), 5, 8);
                                 if (rnd == 5.0) {
                                    tick = 50.0;
                                    break;
                                 }

                                 if (rnd == 6.0) {
                                    rnd = 0.0;
                                    tick = 100.0;
                                    if (!infinity && !vsMahoraga && !(var41 instanceof GojoSatoruEntity) && !(distance > 5.0)) {
                                       rnd = 6.0;
                                       break;
                                    }
                                 } else if (rnd == 7.0) {
                                    rnd = 0.0;
                                    tick = 250.0;
                                    if (!infinity && (!(entity instanceof SukunaFushiguroEntity) || !(var41 instanceof GojoSatoruEntity)) && !(var41 instanceof JogoEntity) && !(entity.getPersistentData().getDouble("cnt_target") <= 1200.0) && (!vsMahoraga || entity.getPersistentData().getBoolean("flag1")) && !(Math.random() < 0.95) && !(distance < 8.0)) {
                                       rnd = 7.0;
                                       break;
                                    }
                                 } else if (rnd == 20.0) {
                                    rnd = 0.0;
                                    tick = 20.0;
                                    if (!mahoraga_exist && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                       rnd = 20.0;
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        if (!(rnd > 0.0)) {
                           CalculateAttackProcedure.execute(world, entity);
                        } else {
                           if (rnd == 20.0) {
                              label476: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt125 = (LivingEntity)entity;
                                    if (_livEnt125.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                       break label476;
                                    }
                                 }

                                 entity.getPersistentData().putDouble("skill", 1.0);
                                 ReturnShadowProcedure.execute(world, x, y, z, entity);
                              }
                           }

                           if (mahoraga_exist && rnd == 7.0) {
                              tick = 100.0;
                              entity.getPersistentData().putDouble("skill", 1007.0);
                           } else {
                              entity.getPersistentData().putDouble("skill", 100.0 + rnd);
                           }

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
                        }
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt136 = (LivingEntity)entity;
                  if (_livEnt136.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt137 = (LivingEntity)entity;
                        if (_livEnt137.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           return;
                        }
                     }

                     entity.getPersistentData().putBoolean("flag1", false);
                  }
               }
            } else {
               entity.getPersistentData().putBoolean("flag2", false);
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_rest", entity.getPersistentData().getDouble("cnt_rest") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_rest") > 120.0) {
                  entity.getPersistentData().putDouble("cnt_rest", 0.0);
                  entity.getPersistentData().putDouble("skill", 1.0);
                  ReturnShadowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

      }
   }
}
