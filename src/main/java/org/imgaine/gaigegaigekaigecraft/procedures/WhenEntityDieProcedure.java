package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
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
         boolean killCurse = false;
         boolean logic_a = false;
         String target_jp = "";
         String message = "";
         String MVP_Message = "";
         String str1 = "";
         if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.getPersistentData().m_128471_("Shikigami")) {
            if (entity instanceof Player) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(40.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  LivingEntity var10000;
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 == entity) {
                     NUM1 = 1.0;

                     for(int index0 = 0; index0 < 128; ++index0) {
                        str1 = "pName" + Math.round(NUM1);
                        if (entityiterator.getPersistentData().m_128461_(str1).equals("")) {
                           entityiterator.getPersistentData().m_128359_(str1, entity.m_5446_().getString());
                           break;
                        }

                        ++NUM1;
                     }
                  }
               }
            }

            LivingEntity var132;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var132 = _mobEnt.m_5448_();
            } else {
               var132 = null;
            }

            if (var132 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 3.0) {
               label458: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var133 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label458;
                     }
                  }

                  var133 = 0.0;
               }

               level_strength = var133;
               fame_base = Math.pow(level_strength + 1.0, 2.0) + 1.0;
               if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                  target_jp = Component.m_237115_("jujutsu.message.kill1").getString();
                  killCurse = true;
               } else if (entity.getPersistentData().m_128471_("CurseUser")) {
                  target_jp = Component.m_237115_("jujutsu.message.kill2").getString();
               } else if (entity.getPersistentData().m_128471_("jjkChara")) {
                  target_jp = Component.m_237115_("jujutsu.message.kill3").getString();
               } else {
                  target_jp = "";
               }

               if (!target_jp.equals("")) {
                  Vec3 _center = new Vec3(x, y, z);
                  List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(32.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList();
                  Iterator var66 = _entfound.iterator();

                  while(true) {
                     Entity entityiterator;
                     do {
                        while(true) {
                           while(true) {
                              if (!var66.hasNext()) {
                                 return;
                              }

                              entityiterator = (Entity)var66.next();
                              if (entityiterator instanceof Player) {
                                 if (!(entityiterator instanceof Player)) {
                                    break;
                                 }

                                 Player _plr = (Player)entityiterator;
                                 if (!_plr.m_150110_().f_35937_) {
                                    break;
                                 }
                              }
                           }

                           if (!((<undefinedtype>)(new Object() {
                              public boolean checkGamemode(Entity _ent) {
                                 if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                                 } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                    return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                                 } else {
                                    return false;
                                 }
                              }
                           })).checkGamemode(entityiterator)) {
                              if (!(entityiterator instanceof LivingEntity)) {
                                 break;
                              }

                              LivingEntity _livEnt22 = (LivingEntity)entityiterator;
                              if (!_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break;
                              }
                           }
                        }

                        if (entityiterator.getPersistentData().m_128471_("JujutsuSorcerer")) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var132 = _mobEnt.m_5448_();
                           } else {
                              var132 = null;
                           }

                           if (((Entity)var132).getPersistentData().m_128471_("JujutsuSorcerer")) {
                              break;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128471_("CurseUser")) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var132 = _mobEnt.m_5448_();
                           } else {
                              var132 = null;
                           }

                           if (((Entity)var132).getPersistentData().m_128471_("CurseUser")) {
                              break;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var132 = _mobEnt.m_5448_();
                           } else {
                              var132 = null;
                           }

                           if (((Entity)var132).getPersistentData().m_128471_("CursedSpirit")) {
                              break;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var132 = _mobEnt.m_5448_();
                        } else {
                           var132 = null;
                        }

                        if (var132 instanceof Player) {
                           break;
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var132 = _mobEnt.m_5448_();
                        } else {
                           var132 = null;
                        }
                     } while(!((Entity)var132).getPersistentData().m_128471_("Player"));

                     logic_a = true;
                     NUM1 = 1.0;

                     for(int index1 = 0; index1 < 128; ++index1) {
                        str1 = entity.getPersistentData().m_128461_("pName" + Math.round(NUM1));
                        if (str1.equals("")) {
                           break;
                        }

                        if (str1.equals(entityiterator.m_5446_().getString())) {
                           logic_a = false;
                           break;
                        }

                        ++NUM1;
                     }

                     if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                        logic_a = false;
                     }

                     if (logic_a) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var132 = _mobEnt.m_5448_();
                        } else {
                           var132 = null;
                        }

                        label347: {
                           label504: {
                              if (var132 != entityiterator) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var132 = _mobEnt.m_5448_();
                                 } else {
                                    var132 = null;
                                 }

                                 if (!(var132 instanceof Player)) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var132 = _mobEnt.m_5448_();
                                    } else {
                                       var132 = null;
                                    }

                                    if (!((Entity)var132).getPersistentData().m_128471_("Player")) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var132 = _mobEnt.m_5448_();
                                       } else {
                                          var132 = null;
                                       }

                                       if (((Entity)var132).getPersistentData().m_128459_("friend_num") == 0.0) {
                                          break label504;
                                       }

                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var132 = _mobEnt.m_5448_();
                                       } else {
                                          var132 = null;
                                       }

                                       if (((Entity)var132).getPersistentData().m_128459_("friend_num") != entityiterator.getPersistentData().m_128459_("friend_num")) {
                                          break label504;
                                       }
                                    }
                                 }
                              }

                              MVP_Message = "[MVP]";
                              fame = fame_base;
                              double _setval = Math.max(((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerExperience, level_strength);
                              entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 capability.PlayerExperience = _setval;
                                 capability.syncPlayerVariables(entityiterator);
                              });
                              if (killCurse) {
                                 if (level_strength >= 10.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_special"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= 8.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_1"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= 5.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_2"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (level_strength >= 1.0) {
                                    if (entityiterator instanceof ServerPlayer) {
                                       ServerPlayer _player = (ServerPlayer)entityiterator;
                                       Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_3"));
                                       AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                       if (!_ap.m_8193_()) {
                                          for(String criteria : _ap.m_8219_()) {
                                             _player.m_8960_().m_135988_(_adv, criteria);
                                          }
                                       }
                                    }
                                 } else if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entityiterator;
                                    Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_4"));
                                    AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                    if (!_ap.m_8193_()) {
                                       for(String criteria : _ap.m_8219_()) {
                                          _player.m_8960_().m_135988_(_adv, criteria);
                                       }
                                    }
                                 }
                              }

                              BeatJujutsuSorcererProcedure.execute(entity, entityiterator);
                              BeatEnemyProcedure.execute(entity, entityiterator);
                              BeatOtherProcedure.execute(entity, entityiterator);
                              break label347;
                           }

                           MVP_Message = "";
                           fame = (double)Math.round(fame_base / 10.0);
                        }

                        if (world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                           double _setval = ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame + fame;
                           entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.PlayerFame = _setval;
                              capability.syncPlayerVariables(entityiterator);
                           });
                           message = target_jp.replace("[point]", "§l" + Math.round(fame) + "§r");
                           if (entityiterator instanceof Player) {
                              Player _player = (Player)entityiterator;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_(MVP_Message + message), false);
                              }
                           }

                           label506: {
                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _plr59 = (ServerPlayer)entityiterator;
                                 if (_plr59.m_9236_() instanceof ServerLevel && _plr59.m_8960_().m_135996_(_plr59.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_special"))).m_8193_()) {
                                    FameGrade = 10.0;
                                    break label506;
                                 }
                              }

                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _plr60 = (ServerPlayer)entityiterator;
                                 if (_plr60.m_9236_() instanceof ServerLevel && _plr60.m_8960_().m_135996_(_plr60.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_1"))).m_8193_()) {
                                    FameGrade = 8.0;
                                    break label506;
                                 }
                              }

                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _plr61 = (ServerPlayer)entityiterator;
                                 if (_plr61.m_9236_() instanceof ServerLevel && _plr61.m_8960_().m_135996_(_plr61.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_2"))).m_8193_()) {
                                    FameGrade = 6.0;
                                    break label506;
                                 }
                              }

                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _plr62 = (ServerPlayer)entityiterator;
                                 if (_plr62.m_9236_() instanceof ServerLevel && _plr62.m_8960_().m_135996_(_plr62.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:fame_3"))).m_8193_()) {
                                    FameGrade = 4.0;
                                 }
                              }
                           }

                           difficulty = (double)world.m_6106_().m_5470_().m_46215_(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY);
                           if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 4000.0 * difficulty && FameGrade >= 10.0) {
                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_special"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                           } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 2750.0 * difficulty && FameGrade >= 8.0) {
                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                           } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 1750.0 * difficulty) {
                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                           } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 1000.0 * difficulty && FameGrade >= 6.0) {
                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                           } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 500.0 * difficulty) {
                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                           } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 200.0 * difficulty && FameGrade >= 4.0) {
                              if (entityiterator instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entityiterator;
                                 Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"));
                                 AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                 if (!_ap.m_8193_()) {
                                    for(String criteria : _ap.m_8219_()) {
                                       _player.m_8960_().m_135988_(_adv, criteria);
                                    }
                                 }
                              }
                           } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 50.0 * difficulty && entityiterator instanceof ServerPlayer) {
                              ServerPlayer _player = (ServerPlayer)entityiterator;
                              Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_4"));
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
}
