package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EntityActiveProcedure {
   public EntityActiveProcedure() {
   }

   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      execute(event, event.getEntity().m_9236_(), event.getEntity().m_20185_(), event.getEntity().m_20186_(), event.getEntity().m_20189_(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double old_num = 0.0;
         Entity entity_a = null;
         String STR1 = "";
         String old_UUID = "";
         boolean logic_adaptation = false;
         boolean mahorage = false;
         boolean logic_adaptation_start = false;
         boolean slow_adaptation = false;
         boolean target_reset = false;
         if (entity instanceof LivingEntity && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_target", entity.getPersistentData().m_128459_("cnt_target") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_target") == 7.0) {
                  LivingEntity var10002;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.m_5448_();
                  } else {
                     var10002 = null;
                  }

                  if (!LogicAttackProcedure.execute(world, entity, var10002)) {
                     target_reset = true;
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_target", 0.0);
            }

            if (entity.f_19797_ % 10 == 0) {
               if (JujutsucraftModVariables.MapVariables.get(world).BlastGame && (!(entity instanceof Player) || ((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.f_8941_.m_9290_() == GameType.SURVIVAL;
                     } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                        return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SURVIVAL;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entity) || ((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.f_8941_.m_9290_() == GameType.ADVENTURE;
                     } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                        return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.ADVENTURE;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entity)) && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                  NUM1 = JujutsucraftModVariables.MapVariables.get(world).BlastGameDistance * 0.5;
                  if (Math.abs(entity.m_20185_() - JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter) + (double)entity.m_20205_() * 0.5 > NUM1 || Math.abs(entity.m_20186_() - JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter) > NUM1 || Math.abs(entity.m_20189_() - JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter) + (double)entity.m_20205_() * 0.5 > NUM1) {
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                     }

                     entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), Math.max(entity.m_20184_().m_7098_(), 8.0), entity.m_20184_().m_7094_()));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y, z, 4.0F, ExplosionInteraction.MOB);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 99.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 99.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 99.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 99.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle jujutsucraft:particle_thunder_blue ~ ~ ~ 1 1 1 4 50 force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle jujutsucraft:particle_broken_glass ~ ~ ~ 1 1 1 4 100 force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle flash ~ ~ ~ 2 2 2 4 100 force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle end_rod ~ ~ ~ 1 1 1 4 100 force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle cloud ~ ~ ~ 1 1 1 4 100 force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle jujutsucraft:particle_broken_glass ~ ~ ~ 1 1 1 4 100 force");
                     }
                  }
               }

               if (!(entity instanceof Player) && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                  if (entity.getPersistentData().m_128459_("friend_num_worker") != 0.0) {
                     entity.getPersistentData().m_128347_("cnt_settarget", entity.getPersistentData().m_128459_("cnt_settarget") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt_settarget") > 0.0) {
                        entity.getPersistentData().m_128347_("cnt_settarget", -3.0);
                        if (entity.getPersistentData().m_128459_("cnt_target") < 6.0 && !entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
                           entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                              public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                 if (levelAccessor instanceof ServerLevel serverLevel) {
                                    try {
                                       return serverLevel.m_8791_(UUID.fromString(uuid));
                                    } catch (Exception var5) {
                                    }
                                 }

                                 return null;
                              }
                           }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                           if (entity_a instanceof LivingEntity) {
                              if (GetDistanceIteratorProcedure.execute(entity, entity_a) > 5.0 && entity instanceof Mob) {
                                 Mob _entity = (Mob)entity;
                                 _entity.m_21573_().m_26519_(entity_a.m_20185_(), entity_a.m_20186_(), entity_a.m_20189_(), 1.25);
                              }
                           } else {
                              entity.getPersistentData().m_128359_("OWNER_UUID", "");
                           }
                        }

                        SetTargetProcedure.execute(world, x, y, z, entity);
                     }
                  }

                  if (!entity.getPersistentData().m_128461_("TARGET_UUID").isEmpty()) {
                     entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("TARGET_UUID"));
                     if (entity_a != null) {
                        if (entity_a instanceof LivingEntity && entity_a.m_6084_()) {
                           label508: {
                              label543: {
                                 if (entity_a instanceof Player) {
                                    if (entity_a instanceof Player) {
                                       Player _plr = (Player)entity_a;
                                       if (_plr.m_150110_().f_35937_) {
                                          break label543;
                                       }
                                    }

                                    if (((<undefinedtype>)(new Object() {
                                       public boolean checkGamemode(Entity _ent) {
                                          if (_ent instanceof ServerPlayer _serverPlayer) {
                                             return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                                          } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                             return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                                          } else {
                                             return false;
                                          }
                                       }
                                    })).checkGamemode(entity_a)) {
                                       break label543;
                                    }
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (var10000 != entity_a) {
                                    if (entity instanceof Mob) {
                                       Mob _entity = (Mob)entity;
                                       _entity.m_21573_().m_26573_();
                                    }

                                    entity.getPersistentData().m_128347_("cnt_target", Math.max(entity.getPersistentData().m_128459_("cnt_target"), 20.0));
                                    if (entity instanceof Mob) {
                                       Mob _entity = (Mob)entity;
                                       if (entity_a instanceof LivingEntity) {
                                          LivingEntity _ent = (LivingEntity)entity_a;
                                          _entity.m_6710_(_ent);
                                       }
                                    }

                                    if (entity instanceof PathfinderMob) {
                                       PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                                       _pathfinderMob.f_21346_.m_25352_(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                                    }

                                    if (!LogicAttackProcedure.execute(world, entity, entity_a)) {
                                       target_reset = true;
                                    }
                                 }
                                 break label508;
                              }

                              target_reset = true;
                           }
                        } else {
                           target_reset = true;
                        }
                     } else {
                        target_reset = true;
                     }
                  }
               }

               if (target_reset) {
                  entity.getPersistentData().m_128359_("TARGET_UUID", "");
                  entity.getPersistentData().m_128347_("cnt_target", 0.0);
                  if (entity instanceof Mob) {
                     Mob _entity = (Mob)entity;
                     _entity.m_6710_((LivingEntity)null);
                     if (entity instanceof PathfinderMob) {
                        PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                        _pathfinderMob.f_21346_.m_25352_(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                     }
                  }
               }
            }

            if (entity.f_19797_ % 20 == 0) {
               if (entity instanceof Player && entity instanceof Player) {
                  Player _plrCldCheck73 = (Player)entity;
                  ItemCooldowns var104 = _plrCldCheck73.m_36335_();
                  ItemStack var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10001 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  if (var104.m_41519_(var10001.m_41720_())) {
                     return;
                  }
               }

               ItemStack var105;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var105 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var105 = ItemStack.f_41583_;
               }

               if (var105.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var105 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var105 = ItemStack.f_41583_;
                  }

                  if (var105.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                     return;
                  }
               }

               if (entity.m_6084_()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var105 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var105 = ItemStack.f_41583_;
                  }

                  CompoundTag var108 = var105.m_41784_();
                  ItemStack var136;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var136 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var136 = ItemStack.f_41583_;
                  }

                  var108.m_128347_("cnt_adaptation", var136.m_41784_().m_128459_("cnt_adaptation") + 1.0);
                  mahorage = entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 16.0 : entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity || entity instanceof CursedSpiritGrade010Entity;
                  logic_adaptation = false;
                  logic_adaptation_start = false;
                  NUM1 = 1.0;
                  NUM2 = 0.0;
                  NUM3 = 0.0;
                  ItemStack var109;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var109 = ItemStack.f_41583_;
                  }

                  if (var109.m_41784_().m_128459_("cnt_adaptation") >= 6.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var109 = ItemStack.f_41583_;
                     }

                     var109.m_41784_().m_128347_("cnt_adaptation", 0.0);
                     logic_adaptation_start = true;
                     if (mahorage) {
                        float var111;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var111 = _livEnt.m_21223_();
                        } else {
                           var111 = -1.0F;
                        }

                        float var133;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var133 = _livEnt.m_21233_();
                        } else {
                           var133 = -1.0F;
                        }

                        if (var111 < var133) {
                           ItemStack var112;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var112 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var112 = ItemStack.f_41583_;
                           }

                           CompoundTag var113 = var112.m_41784_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var136 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var136 = ItemStack.f_41583_;
                           }

                           var113.m_128347_("cnt_heal", var136.m_41784_().m_128459_("cnt_heal") + 1.0);
                           ItemStack var114;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var114 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var114 = ItemStack.f_41583_;
                           }

                           if (var114.m_41784_().m_128459_("cnt_heal") >= 2.0) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var114 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var114 = ItemStack.f_41583_;
                              }

                              var114.m_41784_().m_128347_("cnt_heal", 0.0);
                              NUM3 = Math.max(NUM3, entity instanceof Player ? 0.2 : 0.1);
                              logic_adaptation = true;
                           }
                        } else {
                           ItemStack var116;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var116 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var116 = ItemStack.f_41583_;
                           }

                           var116.m_41784_().m_128347_("cnt_heal", 0.0);
                        }
                     }
                  }

                  for(int index0 = 0; index0 < 800; ++index0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var109 = ItemStack.f_41583_;
                     }

                     STR1 = var109.m_41784_().m_128461_("DATA" + Math.round(NUM1));
                     if (STR1.equals("")) {
                        break;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var109 = ItemStack.f_41583_;
                     }

                     if (var109.m_41784_().m_128459_(STR1) > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var109 = ItemStack.f_41583_;
                        }

                        if (var109.m_41784_().m_128459_(STR1) < 1000.0) {
                           label574: {
                              slow_adaptation = ((<undefinedtype>)(new Object() {
                                 double convert(String s) {
                                    try {
                                       return Double.parseDouble(s.trim());
                                    } catch (Exception var3) {
                                       return 0.0;
                                    }
                                 }
                              })).convert(STR1.replace("skill", "")) >= 205.0 && ((<undefinedtype>)(new Object() {
                                 double convert(String s) {
                                    try {
                                       return Double.parseDouble(s.trim());
                                    } catch (Exception var3) {
                                       return 0.0;
                                    }
                                 }
                              })).convert(STR1.replace("skill", "")) <= 220.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var109 = ItemStack.f_41583_;
                              }

                              old_num = var109.m_41784_().m_128459_(STR1);
                              NUM2 = !slow_adaptation && !STR1.contains("domain") ? 20.0 : 4.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var109 = ItemStack.f_41583_;
                              }

                              if (var109.m_41784_().m_128459_(STR1) >= 100.0) {
                                 NUM2 = (double)Math.round(NUM2 * 0.5);
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var109 = ItemStack.f_41583_;
                              }

                              CompoundTag var123 = var109.m_41784_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var136 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var136 = ItemStack.f_41583_;
                              }

                              var123.m_128347_(STR1, (double)Math.round(var136.m_41784_().m_128459_(STR1) + NUM2));
                              if (old_num < 100.0) {
                                 ItemStack var124;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var124 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                 } else {
                                    var124 = ItemStack.f_41583_;
                                 }

                                 if (var124.m_41784_().m_128459_(STR1) >= 100.0) {
                                    if (logic_adaptation_start) {
                                       if (entity instanceof Player) {
                                          Player _player = (Player)entity;
                                          if (!_player.m_9236_().m_5776_()) {
                                             _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.adaptation_complete").getString()), false);
                                          }
                                       }

                                       NUM3 = Math.max(NUM3, 0.2);
                                       logic_adaptation = true;
                                    } else {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entGetArmor = (LivingEntity)entity;
                                          var124 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                       } else {
                                          var124 = ItemStack.f_41583_;
                                       }

                                       var124.m_41784_().m_128347_(STR1, (double)Math.round(99.0F));
                                    }
                                    break label574;
                                 }
                              }

                              ItemStack var125;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity;
                                 var125 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var125 = ItemStack.f_41583_;
                              }

                              if (var125.m_41784_().m_128459_(STR1) >= 1000.0) {
                                 if (logic_adaptation_start) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entity;
                                       var125 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                    } else {
                                       var125 = ItemStack.f_41583_;
                                    }

                                    var125.m_41784_().m_128347_(STR1, (double)Math.round(1000.0F));
                                    logic_adaptation = true;
                                 } else {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entity;
                                       var125 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                    } else {
                                       var125 = ItemStack.f_41583_;
                                    }

                                    var125.m_41784_().m_128347_(STR1, (double)Math.round(999.0F));
                                 }
                              } else {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var125 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                 } else {
                                    var125 = ItemStack.f_41583_;
                                 }

                                 if (Math.floor(var125.m_41784_().m_128459_(STR1) / 100.0) > Math.floor(old_num / 100.0)) {
                                    if (logic_adaptation_start) {
                                       logic_adaptation = true;
                                    } else {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entGetArmor = (LivingEntity)entity;
                                          var125 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                       } else {
                                          var125 = ItemStack.f_41583_;
                                       }

                                       var125.m_41784_().m_128347_(STR1, old_num);
                                    }
                                 } else if (slow_adaptation) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entity;
                                       var125 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                    } else {
                                       var125 = ItemStack.f_41583_;
                                    }

                                    logic_adaptation = (var125.m_41784_().m_128459_(STR1) - 1.0) % 20.0 == 0.0;
                                 }
                              }
                           }
                        }
                     }

                     ++NUM1;
                  }

                  if (logic_adaptation) {
                     if (!(entity instanceof CursedSpiritGrade010Entity) && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                        }
                     }

                     if (mahorage && logic_adaptation_start && NUM3 > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           float var134;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var134 = _livEnt.m_21223_();
                           } else {
                              var134 = -1.0F;
                           }

                           double var135 = (double)var134;
                           float var139;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var139 = _livEnt.m_21233_();
                           } else {
                              var139 = -1.0F;
                           }

                           _entity.m_21153_((float)(var135 + (double)var139 * NUM3));
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19597_);
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var109 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var109 = ItemStack.f_41583_;
                        }

                        if (var109.m_41784_().m_128459_("skill205") >= 1000.0 && entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_cut_the_world"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
