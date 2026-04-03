package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Iterator;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WhenEntityDieProcedure {
   public WhenEntityDieProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double fame = 0.0;
         double fame_base = 0.0;
         double EntityType = 0.0;
         double level_strength = 0.0;
         double FameGrade = 0.0;
         double difficulty = 0.0;
         double NUM1 = 0.0;
         String target_jp = "";
         String message = "";
         String MVP_Message = "";
         String str1 = "";
         Entity target_entity = null;
         boolean killCurse = false;
         boolean logic_a = false;
         boolean isValidGamemode = false;
         PlayAnimationEntity2Procedure.execute(entity, "empty");
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var51 = var10000;
         if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity.getPersistentData().getBoolean("Shikigami")) {
            if (entity instanceof Player) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(40.0), (e) -> true)) {
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 == entity) {
                     NUM1 = 1.0;

                     for(int index0 = 0; index0 < 128; ++index0) {
                        str1 = "pName" + Math.round(NUM1);
                        if (entityiterator.getPersistentData().getString(str1).equals("")) {
                           entityiterator.getPersistentData().putString(str1, entity.getDisplayName().getString());
                           break;
                        }

                        ++NUM1;
                     }
                  }
               }
            }

            if (var51 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 3.0) {
               double var127;
               label423: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var127 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label423;
                     }
                  }

                  var127 = 0.0;
               }

               level_strength = var127;
               fame_base = (level_strength + 1.0) * (level_strength + 1.0) + 1.0;
               if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                  target_jp = Component.translatable("jujutsu.message.kill1_1").getString();
                  killCurse = true;
               } else if (entity.getPersistentData().getBoolean("CurseUser")) {
                  target_jp = Component.translatable("jujutsu.message.kill1_2").getString();
               } else if (entity.getPersistentData().getBoolean("JujutsuSorcerer")) {
                  target_jp = Component.translatable("jujutsu.message.kill1_3").getString();
               } else if (entity.getPersistentData().getBoolean("jjkChara")) {
                  target_jp = " ";
               } else {
                  target_jp = "";
               }

               if (!target_jp.equals("")) {
                  JujutsucraftModVariables.PlayerVariables playerVars = null;
                  Vec3 _center = new Vec3(x, y, z);
                  List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(32.0), (e) -> true);
                  Iterator var60 = _entfound.iterator();

                  while(true) {
                     Entity entityiterator;
                     while(true) {
                        if (!var60.hasNext()) {
                           return;
                        }

                        entityiterator = (Entity)var60.next();
                        if (entityiterator instanceof Player) {
                           playerVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
                           isValidGamemode = true;
                           if (entityiterator instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                              isValidGamemode = _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL || _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                           }

                           if (isValidGamemode) {
                              if (!(entityiterator instanceof LivingEntity)) {
                                 break;
                              }

                              LivingEntity _livEnt21 = (LivingEntity)entityiterator;
                              if (!_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break;
                              }
                           }
                        }
                     }

                     if ((entityiterator.getPersistentData().getBoolean("JujutsuSorcerer") && ((Entity)var51).getPersistentData().getBoolean("JujutsuSorcerer") || entityiterator.getPersistentData().getBoolean("CurseUser") && ((Entity)var51).getPersistentData().getBoolean("CurseUser") || entityiterator.getPersistentData().getBoolean("CursedSpirit") && ((Entity)var51).getPersistentData().getBoolean("CursedSpirit") || var51 instanceof Player || ((Entity)var51).getPersistentData().getBoolean("Player")) && (entity.getPersistentData().getDouble("friend_num") == 0.0 || entity.getPersistentData().getDouble("friend_num") != entityiterator.getPersistentData().getDouble("friend_num"))) {
                        logic_a = false;
                        NUM1 = 1.0;

                        for(int index1 = 0; index1 < 128; ++index1) {
                           str1 = entity.getPersistentData().getString("pName" + Math.round(NUM1));
                           if (str1.equals("")) {
                              break;
                           }

                           if (str1.equals(entityiterator.getDisplayName().getString())) {
                              logic_a = true;
                              break;
                           }

                           ++NUM1;
                        }

                        if (!logic_a) {
                           if (var51 == entityiterator || var51 instanceof Player || ((Entity)var51).getPersistentData().getBoolean("Player") || ((Entity)var51).getPersistentData().getDouble("friend_num") != 0.0 && ((Entity)var51).getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                              MVP_Message = "[MVP]";
                              fame = fame_base;
                              playerVars.PlayerExperience = Math.max(playerVars.PlayerExperience, level_strength);
                              if (killCurse) {
                                 if (level_strength >= 10.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_special"));
                                       AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                       if (!_ap.isDone()) {
                                          for(String criteria : _ap.getRemainingCriteria()) {
                                             _player.getAdvancements().award(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= 8.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_1"));
                                       AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                       if (!_ap.isDone()) {
                                          for(String criteria : _ap.getRemainingCriteria()) {
                                             _player.getAdvancements().award(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= 5.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_2"));
                                       AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                       if (!_ap.isDone()) {
                                          for(String criteria : _ap.getRemainingCriteria()) {
                                             _player.getAdvancements().award(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= 1.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_3"));
                                       AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                       if (!_ap.isDone()) {
                                          for(String criteria : _ap.getRemainingCriteria()) {
                                             _player.getAdvancements().award(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_4"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              }

                              BeatJujutsuSorcererProcedure.execute(entity, entityiterator);
                              BeatEnemyProcedure.execute(entity, entityiterator);
                              BeatOtherProcedure.execute(entity, entityiterator);
                           } else {
                              MVP_Message = "";
                              fame = (double)Math.round(fame_base / 10.0);
                           }

                           if (world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                              playerVars.PlayerFame += fame;
                              if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                                 message = target_jp + Component.translatable("jujutsu.message.kill4").getString().replace("[point]", "§l" + Math.round(fame) + "§r");
                              } else {
                                 message = target_jp + Component.translatable("jujutsu.message.kill3").getString().replace("[point]", "§l" + Math.round(fame) + "§r");
                              }

                              if (entityiterator instanceof Player) {
                                 Player _player = (Player)entityiterator;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal(MVP_Message + message), false);
                                 }
                              }

                              label469: {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr51 = (ServerPlayer)entityiterator;
                                    if (_plr51.level() instanceof ServerLevel && _plr51.getAdvancements().getOrStartProgress(_plr51.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_special"))).isDone()) {
                                       FameGrade = 10.0;
                                       break label469;
                                    }
                                 }

                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr52 = (ServerPlayer)entityiterator;
                                    if (_plr52.level() instanceof ServerLevel && _plr52.getAdvancements().getOrStartProgress(_plr52.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_1"))).isDone()) {
                                       FameGrade = 8.0;
                                       break label469;
                                    }
                                 }

                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr53 = (ServerPlayer)entityiterator;
                                    if (_plr53.level() instanceof ServerLevel && _plr53.getAdvancements().getOrStartProgress(_plr53.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_2"))).isDone()) {
                                       FameGrade = 6.0;
                                       break label469;
                                    }
                                 }

                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _plr54 = (ServerPlayer)entityiterator;
                                    if (_plr54.level() instanceof ServerLevel && _plr54.getAdvancements().getOrStartProgress(_plr54.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_3"))).isDone()) {
                                       FameGrade = 4.0;
                                    }
                                 }
                              }

                              difficulty = (double)world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY);
                              if (playerVars.PlayerFame >= 4000.0 * difficulty && FameGrade >= 10.0) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_special"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= 2750.0 * difficulty && FameGrade >= 8.0) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= 1750.0 * difficulty) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1_semi"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= 1000.0 * difficulty && FameGrade >= 6.0) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= 500.0 * difficulty) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2_semi"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= 200.0 * difficulty && FameGrade >= 4.0) {
                                 if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_3"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              } else if (playerVars.PlayerFame >= 50.0 * difficulty && entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_4"));
                                 AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                 if (!_ap.isDone()) {
                                    for(String criteria : _ap.getRemainingCriteria()) {
                                       _player.getAdvancements().award(_adv, criteria);
                                    }
                                 }
                              }
                           }

                           playerVars.syncPlayerVariables(entityiterator);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
