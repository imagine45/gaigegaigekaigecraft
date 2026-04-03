package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
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
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         Entity entity_a = null;
         Entity target = null;
         double old_num = 0.0;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double NUM1 = 0.0;
         boolean logic_adaptation = false;
         boolean logic_adaptation_start = false;
         boolean target_reset = false;
         boolean mahorage = false;
         boolean slow_adaptation = false;
         boolean isValidGamemode = false;
         ItemStack equipment_item_orgin = ItemStack.EMPTY;
         if (entity instanceof LivingEntity && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            Entity var37 = var10000;
            if (var37 instanceof LivingEntity) {
               NUM1 = entity.getPersistentData().getDouble("cnt_target") + 1.0;
               entity.getPersistentData().putDouble("cnt_target", NUM1);
               if (NUM1 == 7.0 && !LogicAttackProcedure.execute(world, entity, var37)) {
                  target_reset = true;
               }
            } else {
               entity.getPersistentData().putDouble("cnt_target", 0.0);
            }

            if (entity.tickCount % 11 == 0) {
               if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
                  isValidGamemode = true;
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer sp = (ServerPlayer)entity;
                     isValidGamemode = sp.gameMode.getGameModeForPlayer() == GameType.SURVIVAL || sp.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                  }

                  if (isValidGamemode && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
                     NUM1 = JujutsucraftModVariables.MapVariables.get(world).BlastGameDistance * 0.5;
                     if (Math.abs(entity.getX() - JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter) + (double)entity.getBbWidth() * 0.5 > NUM1 || Math.abs(entity.getY() - JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter) > NUM1 || Math.abs(entity.getZ() - JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter) + (double)entity.getBbWidth() * 0.5 > NUM1) {
                        entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), Math.max(entity.getDeltaMovement().y(), 8.0), entity.getDeltaMovement().z()));
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x, y, z, 4.0F, ExplosionInteraction.MOB);
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           CommandSourceStack source = (new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                           _level.getServer().getCommands().performPrefixedCommand(source, "particle gaigegaigekaigecraft:particle_thunder_blue ~ ~ ~ 1 1 1 4 50 force");
                           _level.getServer().getCommands().performPrefixedCommand(source, "particle gaigegaigekaigecraft:particle_broken_glass ~ ~ ~ 1 1 1 4 100 force");
                           _level.getServer().getCommands().performPrefixedCommand(source, "particle flash ~ ~ ~ 2 2 2 4 100 force");
                        }

                        entity.kill();
                     }
                  }
               }

               if (!(entity instanceof Player) && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
                  if (entity.getPersistentData().getDouble("friend_num_worker") != 0.0) {
                     entity.getPersistentData().putDouble("cnt_settarget", entity.getPersistentData().getDouble("cnt_settarget") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_settarget") > 0.0) {
                        entity.getPersistentData().putDouble("cnt_settarget", -3.0);
                        if (entity.getPersistentData().getDouble("cnt_target") < 6.0 && !entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                           entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                           if (entity_a instanceof LivingEntity) {
                              if (GetDistanceIteratorProcedure.execute(entity, entity_a) > 5.0 && entity instanceof Mob) {
                                 Mob _entity = (Mob)entity;
                                 _entity.getNavigation().moveTo(entity_a.getX(), entity_a.getY(), entity_a.getZ(), 1.25);
                              }
                           } else {
                              entity.getPersistentData().putString("OWNER_UUID", "");
                           }
                        }

                        SetTargetProcedure.execute(world, x, y, z, entity);
                     }
                  }

                  if (!entity.getPersistentData().getString("TARGET_UUID").isEmpty()) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("TARGET_UUID"));
                     if (entity_a == null) {
                        target_reset = true;
                     } else if (entity_a instanceof LivingEntity && entity_a.isAlive()) {
                        isValidGamemode = true;
                        if (entity_a instanceof ServerPlayer) {
                           ServerPlayer sp = (ServerPlayer)entity_a;
                           isValidGamemode = sp.gameMode.getGameModeForPlayer() == GameType.SURVIVAL || sp.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                        }

                        if (isValidGamemode) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 != entity_a) {
                              if (entity instanceof Mob) {
                                 Mob _entity = (Mob)entity;
                                 _entity.getNavigation().stop();
                              }

                              entity.getPersistentData().putDouble("cnt_target", Math.max(entity.getPersistentData().getDouble("cnt_target"), 20.0));
                              if (entity instanceof Mob) {
                                 Mob _entity = (Mob)entity;
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _ent = (LivingEntity)entity_a;
                                    _entity.setTarget(_ent);
                                 }
                              }

                              if (entity instanceof PathfinderMob) {
                                 PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                                 _pathfinderMob.targetSelector.addGoal(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                              }

                              if (!LogicAttackProcedure.execute(world, entity, entity_a)) {
                                 target_reset = true;
                              }
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
                  entity.getPersistentData().putString("TARGET_UUID", "");
                  entity.getPersistentData().putDouble("cnt_target", 0.0);
                  if (entity instanceof Mob) {
                     Mob _entity = (Mob)entity;
                     _entity.setTarget((LivingEntity)null);
                     if (entity instanceof PathfinderMob) {
                        PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                        _pathfinderMob.targetSelector.addGoal(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                     }
                  }
               }
            }

            if (entity.isAlive() && entity.tickCount % 20 == 0) {
               ItemStack var77;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var77 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var77 = ItemStack.EMPTY;
               }

               equipment_item_orgin = var77;
               if (equipment_item_orgin.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item_orgin.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  if (entity instanceof Player && entity instanceof Player) {
                     Player _plrCldCheck56 = (Player)entity;
                     if (_plrCldCheck56.getCooldowns().isOnCooldown(equipment_item_orgin.getItem())) {
                        return;
                     }
                  }

                  equipment_item_orgin.getOrCreateTag().putDouble("cnt_adaptation", equipment_item_orgin.getOrCreateTag().getDouble("cnt_adaptation") + 1.0);
                  JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                  mahorage = entity instanceof Player ? playerVars.PlayerCurseTechnique == 16.0 || playerVars.PlayerCurseTechnique2 == 16.0 : entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity || entity instanceof CursedSpiritGrade010Entity;
                  logic_adaptation = false;
                  logic_adaptation_start = false;
                  NUM1 = 1.0;
                  NUM2 = 0.0;
                  NUM3 = 0.0;
                  if (equipment_item_orgin.getOrCreateTag().getDouble("cnt_adaptation") >= 6.0) {
                     equipment_item_orgin.getOrCreateTag().putDouble("cnt_adaptation", 0.0);
                     logic_adaptation_start = true;
                     if (mahorage) {
                        float var78;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var78 = _livEnt.getHealth();
                        } else {
                           var78 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var78 < var10001) {
                           equipment_item_orgin.getOrCreateTag().putDouble("cnt_heal", equipment_item_orgin.getOrCreateTag().getDouble("cnt_heal") + 1.0);
                           if (equipment_item_orgin.getOrCreateTag().getDouble("cnt_heal") >= 2.0) {
                              equipment_item_orgin.getOrCreateTag().putDouble("cnt_heal", 0.0);
                              NUM3 = Math.max(NUM3, entity instanceof Player ? 0.2 : 0.1);
                              logic_adaptation = true;
                           }
                        } else {
                           equipment_item_orgin.getOrCreateTag().putDouble("cnt_heal", 0.0);
                        }
                     }
                  }

                  for(int index0 = 0; index0 < 800; ++index0) {
                     STR1 = equipment_item_orgin.getOrCreateTag().getString("DATA" + Math.round(NUM1));
                     if (STR1.equals("")) {
                        break;
                     }

                     if (equipment_item_orgin.getOrCreateTag().getDouble(STR1) > 0.0 && equipment_item_orgin.getOrCreateTag().getDouble(STR1) < 1000.0) {
                        slow_adaptation = ((new InlineMethodHandler() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return 0.0;
                              }
                           }
                        })).convert(STR1.replace("skill", "")) >= 205.0 && ((new InlineMethodHandler() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return 0.0;
                              }
                           }
                        })).convert(STR1.replace("skill", "")) <= 220.0;
                        old_num = equipment_item_orgin.getOrCreateTag().getDouble(STR1);
                        NUM2 = !slow_adaptation && !STR1.contains("domain") ? 20.0 : 4.0;
                        if (equipment_item_orgin.getOrCreateTag().getDouble(STR1) >= 100.0) {
                           NUM2 = (double)Math.round(NUM2 * 0.5);
                        }

                        equipment_item_orgin.getOrCreateTag().putDouble(STR1, (double)Math.round(equipment_item_orgin.getOrCreateTag().getDouble(STR1) + NUM2));
                        if (old_num < 100.0 && equipment_item_orgin.getOrCreateTag().getDouble(STR1) >= 100.0) {
                           if (logic_adaptation_start) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.adaptation_complete").getString()), false);
                                 }
                              }

                              NUM3 = Math.max(NUM3, 0.2);
                              logic_adaptation = true;
                           } else {
                              equipment_item_orgin.getOrCreateTag().putDouble(STR1, (double)Math.round(99.0F));
                           }
                        } else if (equipment_item_orgin.getOrCreateTag().getDouble(STR1) >= 1000.0) {
                           if (logic_adaptation_start) {
                              equipment_item_orgin.getOrCreateTag().putDouble(STR1, (double)Math.round(1000.0F));
                              logic_adaptation = true;
                           } else {
                              equipment_item_orgin.getOrCreateTag().putDouble(STR1, (double)Math.round(999.0F));
                           }
                        } else if (Math.floor(equipment_item_orgin.getOrCreateTag().getDouble(STR1) / 100.0) > Math.floor(old_num / 100.0)) {
                           if (logic_adaptation_start) {
                              logic_adaptation = true;
                           } else {
                              equipment_item_orgin.getOrCreateTag().putDouble(STR1, old_num);
                           }
                        } else if (slow_adaptation) {
                           logic_adaptation = (equipment_item_orgin.getOrCreateTag().getDouble(STR1) - 1.0) % 20.0 == 0.0;
                        }
                     }

                     ++NUM1;
                  }

                  if (logic_adaptation) {
                     if (!(entity instanceof CursedSpiritGrade010Entity) && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                        }
                     }

                     if (mahorage && logic_adaptation_start && NUM3 > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           float var79;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var79 = _livEnt.getHealth();
                           } else {
                              var79 = -1.0F;
                           }

                           double var80 = (double)var79;
                           float var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMaxHealth();
                           } else {
                              var10002 = -1.0F;
                           }

                           _entity.setHealth((float)(var80 + (double)var10002 * NUM3));
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                        }

                        if (equipment_item_orgin.getOrCreateTag().getDouble("skill205") >= 1000.0 && entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_dismantle_cut_the_world"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
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
