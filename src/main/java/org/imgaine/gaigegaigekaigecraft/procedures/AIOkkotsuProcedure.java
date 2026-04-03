package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruCurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIOkkotsuProcedure {
   public AIOkkotsuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack ITEM1 = ItemStack.EMPTY;
         boolean use_copy = false;
         boolean domain = false;
         boolean PureLoveCannon = false;
         boolean canUseCopy = false;
         boolean StrongEnemy = false;
         boolean logicLocateRika = false;
         Entity target_entity = null;
         Entity entity_rika = null;
         double NUM_COPY = 0.0;
         double distance = 0.0;
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         if (entity.isAlive()) {
            label649: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label649;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, entity instanceof OkkotsuYutaCullingGameEntity ? 20 : 18, false, false));
                  }
               }
            }

            label644: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label644;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
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

            Entity var38 = var10000;
            if (var38 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               entity.getPersistentData().putDouble("cnt_rika", 0.0);
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  boolean var89;
                  label682: {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     logicLocateRika = LocateRikaProcedure.execute(world, entity);
                     if (!logicLocateRika) {

                        label679: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                                 break label679;
                              }
                           }

                           var89 = false;
                           break label682;
                        }
                     }

                     var89 = true;
                  }

                  canUseCopy = var89;
                  if (entity instanceof OkkotsuYutaCullingGameEntity) {
                     CompoundTag var90 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getHealth();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var115 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.getMaxHealth();
                     } else {
                        var10003 = -1.0F;
                     }
                     boolean var118;
                     label620: {
                        label659: {
                           if (!(var115 < (double)var10003 * 0.5)) {
                              if (!(var38 instanceof SukunaPerfectEntity) && !(var38 instanceof SukunaFushiguroEntity) || !(var38 instanceof LivingEntity)) {
                                 break label659;
                              }

                              LivingEntity _livEnt22 = (LivingEntity)var38;
                              if (!_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()) || !(entity.getPersistentData().getDouble("cnt_target") >= 100.0)) {
                                 break label659;
                              }
                           }
                           int var116;
                           label607: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var116 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label607;
                                 }
                              }

                              var116 = 0;
                           }
                           int var117;
                           int var119;
                           label602: {
                              var117 = var116 - 10;
                              if (var38 instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)var38;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var119 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label602;
                                 }
                              }

                              var119 = 0;
                           }

                           if (var117 <= var119) {
                              var118 = true;
                              break label620;
                           }
                        }

                        var118 = false;
                     }

                     var90.putBoolean("flag_domain", var118);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  }

                  if (entity instanceof OkkotsuYutaEntity && LocateRikaProcedure.execute(world, entity)) {
                     float var91;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var91 = _livEnt.getHealth();
                     } else {
                        var91 = -1.0F;
                     }

                     double var92 = (double)var91;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMaxHealth();
                     } else {
                        var10001 = -1.0F;
                     }

                     PureLoveCannon = var92 <= (double)var10001 * 0.2 || ((Entity)var38).getPersistentData().getDouble("skill") % 100.0 == 15.0 && (((Entity)var38).getPersistentData().getDouble("skill") != 1815.0 || ((Entity)var38).getPersistentData().getDouble("cnt9") >= 20.0 && ((Entity)var38).getPersistentData().getDouble("cnt9") <= 25.0);
                  }
                  int var93;
                  label579: {
                     if (var38 instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)var38;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var93 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label579;
                        }
                     }

                     var93 = 0;
                  }

                  int var113;
                  double var94;
                  label574: {
                     var94 = (double)var93;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var113 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label574;
                        }
                     }

                     var113 = 0;
                  }

                  StrongEnemy = var94 >= (double)var113 * 0.5 || entity.getPersistentData().getDouble("cnt_target") > 600.0;
                  ResetCounterProcedure.execute(entity);
                  rnd = 0.0;
                  if (LogicStartProcedure.execute(entity) || domain) {
                     if (domain) {
                        entity.getPersistentData().putBoolean("flag_domain", false);
                        rnd = 20.0;
                        tick = 20.0;
                     } else if ((logicLocateRika || !StrongEnemy) && !PureLoveCannon) {
                        if (Math.random() > 0.75) {
                           rnd = 10.0;
                           tick = 75.0;
                        } else if (!AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() > 0.95 && entity instanceof OkkotsuYutaCullingGameEntity && StrongEnemy) {
                           rnd = 20.0;
                           tick = 20.0;
                        } else {
                           distance = GetDistanceProcedure.execute(entity);
                           if (Math.random() > 0.8) {
                              for(int index0 = 0; index0 < 256; ++index0) {
                                 rnd = (double)Math.round(Math.random() * 10.0);
                                 if (rnd == 3.0) {
                                    tick = 20.0;
                                    if (!(distance < 6.0)) {
                                       break;
                                    }
                                 } else if (rnd == 5.0) {
                                    tick = 250.0;
                                    if (canUseCopy && !(Math.random() < 0.5)) {
                                       break;
                                    }
                                 } else if (rnd == 6.0) {
                                    tick = 150.0;
                                    if (entity instanceof OkkotsuYutaCullingGameEntity && canUseCopy && !(distance < 6.0)) {
                                       break;
                                    }
                                 } else if (rnd == 7.0) {
                                    tick = 100.0;
                                    if (entity instanceof OkkotsuYutaCullingGameEntity && canUseCopy && !(distance > 6.0)) {
                                       break;
                                    }
                                 } else if (rnd == 10.0) {
                                    tick = 10.0;
                                    if (!(Math.random() < 0.5)) {
                                       break;
                                    }
                                 }
                              }
                           } else if (entity instanceof OkkotsuYutaCullingGameEntity && Math.random() > 0.8 && distance < 4.0 && canUseCopy) {
                              use_copy = true;
                              rnd = 106.0;
                              tick = 50.0;
                           } else if ((!(entity instanceof OkkotsuYutaEntity) || !(var38 instanceof GetoSuguruCurseUserEntity)) && canUseCopy) {
                              use_copy = false;
                              NUM_COPY = Math.floor(Math.random() * 4.0);

                              for(int index1 = 0; index1 < 4; ++index1) {
                                 ItemStack var95;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var95 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(Type.ARMOR, (int)NUM_COPY));
                                 } else {
                                    var95 = ItemStack.EMPTY;
                                 }

                                 ITEM1 = var95.copy();
                                 if (ITEM1.getOrCreateTag().getDouble("skill") > 0.0) {
                                    use_copy = true;
                                    rnd = ITEM1.getOrCreateTag().getDouble("skill");
                                    tick = ITEM1.getOrCreateTag().getDouble("COOLDOWN_TICKS");
                                    break;
                                 }

                                 ++NUM_COPY;
                                 if (NUM_COPY > 3.0) {
                                    NUM_COPY = 0.0;
                                 }
                              }
                           }
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 19, false, false));
                           }
                        }

                        if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                           entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("RIKA_UUID"));
                           if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity_rika instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity_rika;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 30, 1, false, false));
                              }
                           }
                        }

                        if (PureLoveCannon) {
                           rnd = 15.0;
                           tick = 500.0;
                        } else {
                           rnd = 10.0;
                           tick = 75.0;
                        }
                     }
                  }

                  ItemStack var96;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var96 = _livEnt.getMainHandItem();
                  } else {
                     var96 = ItemStack.EMPTY;
                  }

                  if (var96.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && !LogicCooldownCombatProcedure.execute(entity)) {
                     float var97;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var97 = _livEnt.getHealth();
                     } else {
                        var97 = -1.0F;
                     }

                     double var98 = (double)var97;
                     float var114;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var114 = _livEnt.getMaxHealth();
                     } else {
                        var114 = -1.0F;
                     }

                     if (var98 <= (double)var114 * 0.5) {
                        if (!entity.getPersistentData().getBoolean("flag1")) {
                           entity.getPersistentData().putBoolean("flag1", true);
                           use_copy = false;
                           rnd = 3704.0;
                           level = 1.0;
                           tick = 100.0;
                           ItemStack var99;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var99 = _livEnt.getMainHandItem();
                           } else {
                              var99 = ItemStack.EMPTY;
                           }

                           if (var99.getItem() == ItemStack.EMPTY.getItem()) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var99 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                              } else {
                                 var99 = ItemStack.EMPTY;
                              }

                              if (var99.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                                 if (!entity.level().isClientSide() && entity.getServer() != null) {
                                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with gaigegaigekaigecraft:sword_okkotsu_yuta");
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var99 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                 } else {
                                    var99 = ItemStack.EMPTY;
                                 }

                                 CompoundTag _nbtTag = var99.getTag();
                                 if (_nbtTag != null) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var99 = _livEnt.getMainHandItem();
                                    } else {
                                       var99 = ItemStack.EMPTY;
                                    }

                                    var99.setTag(_nbtTag.copy());
                                 }

                                 if (!entity.level().isClientSide() && entity.getServer() != null) {
                                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with air");
                                 }
                              }
                           }
                        }
                     } else {
                        entity.getPersistentData().putBoolean("flag1", false);
                     }
                  }

                  if (rnd != 0.0) {
                     entity.getPersistentData().putDouble("skill", (double)Math.round(use_copy ? rnd : 500.0 + rnd));
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

                     if (rnd == 15.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var96 = _livEnt.getMainHandItem();
                        } else {
                           var96 = ItemStack.EMPTY;
                        }

                        if (var96.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var96 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var96 = ItemStack.EMPTY;
                           }

                           if (var96.getItem() == ItemStack.EMPTY.getItem()) {
                              if (!entity.level().isClientSide() && entity.getServer() != null) {
                                 entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with gaigegaigekaigecraft:sword_okkotsu_yuta");
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var96 = _livEnt.getMainHandItem();
                              } else {
                                 var96 = ItemStack.EMPTY;
                              }

                              CompoundTag _nbtTag = var96.getTag();
                              if (_nbtTag != null) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var96 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                 } else {
                                    var96 = ItemStack.EMPTY;
                                 }

                                 var96.setTag(_nbtTag.copy());
                              }

                              if (!entity.level().isClientSide() && entity.getServer() != null) {
                                 entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
                              }
                           }
                        }
                     }
                  } else if (PureLoveCannon) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 19, false, false));
                        }
                     }

                     entity.getPersistentData().putDouble("cnt_x", 5.0);
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var96 = _livEnt.getMainHandItem();
                     } else {
                        var96 = ItemStack.EMPTY;
                     }

                     if (var96.getItem() == ItemStack.EMPTY.getItem()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var96 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var96 = ItemStack.EMPTY;
                        }

                        if (var96.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with gaigegaigekaigecraft:sword_okkotsu_yuta");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var96 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var96 = ItemStack.EMPTY;
                           }

                           CompoundTag _nbtTag = var96.getTag();
                           if (_nbtTag != null) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var96 = _livEnt.getMainHandItem();
                              } else {
                                 var96 = ItemStack.EMPTY;
                              }

                              var96.setTag(_nbtTag.copy());
                           }

                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with air");
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_rika", entity.getPersistentData().getDouble("cnt_rika") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_rika") % 200.0 == 190.0) {
                  if (LocateRikaProcedure.execute(world, entity)) {
                     entity.getPersistentData().putDouble("cnt1", 20.0);
                     TechniqueRika2Procedure.execute(world, x, y, z, entity);
                  }

                  ItemStack var85;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var85 = _livEnt.getMainHandItem();
                  } else {
                     var85 = ItemStack.EMPTY;
                  }

                  if (var85.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var85 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var85 = ItemStack.EMPTY;
                     }

                     if (var85.getItem() == ItemStack.EMPTY.getItem()) {
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with gaigegaigekaigecraft:sword_okkotsu_yuta");
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var85 = _livEnt.getMainHandItem();
                        } else {
                           var85 = ItemStack.EMPTY;
                        }

                        CompoundTag _nbtTag = var85.getTag();
                        if (_nbtTag != null) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var85 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var85 = ItemStack.EMPTY;
                           }

                           var85.setTag(_nbtTag.copy());
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 4204.0) {
               entity.getPersistentData().putBoolean("flag_weapon", true);
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (entity.getPersistentData().getBoolean("flag_weapon")) {
                  entity.getPersistentData().putBoolean("flag_weapon", false);
                  ItemStack var111;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var111 = _livEnt.getMainHandItem();
                  } else {
                     var111 = ItemStack.EMPTY;
                  }

                  if (var111.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
                  }
               }

               ItemStack var112;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var112 = _livEnt.getMainHandItem();
               } else {
                  var112 = ItemStack.EMPTY;
               }

               if (var112.getItem() == JujutsucraftModItems.LOUDSPEAKER.get() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
               }
            }
         }

      }
   }
}
