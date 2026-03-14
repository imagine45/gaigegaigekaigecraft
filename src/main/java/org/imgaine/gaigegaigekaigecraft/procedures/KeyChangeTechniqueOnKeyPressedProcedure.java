package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressedProcedure {
   public KeyChangeTechniqueOnKeyPressedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String name = "";
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = 0.0;
         double p_skill1 = 0.0;
         double p_selectNumber = 0.0;
         if (entity instanceof Player) {
            p_skill1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 : ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            p_selectNumber = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
            if (!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).noChangeTechnique) {
               p_selectNumber += (double)(entity.m_6144_() ? -1 : 1);
            }

            if (p_skill1 <= 10.0) {
               name = "-----";

               for(int index0 = 0; index0 < 25; ++index0) {
                  p_passive = false;
                  p_physical = false;
                  if (p_skill1 == -1.0) {
                     if (p_selectNumber == 5.0) {
                        p_physical = true;
                        cost = 0.0;
                        name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     } else if (p_selectNumber == 6.0) {
                        p_physical = true;
                        cost = 0.0;
                        name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     } else if (p_selectNumber == 7.0) {
                        p_physical = true;
                        cost = 0.0;
                        name = Component.m_237115_("jujutsu.technique.attack5").getString();
                     }
                  } else if (p_skill1 == 1.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.m_237115_("jujutsu.technique.dismantle").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("jujutsu.technique.cleave").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("jujutsu.technique.open").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("jujutsu.technique.malevolent_shrine").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 2.0) {
                     if (p_selectNumber == 5.0) {
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.infinity").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("jujutsu.technique.blue").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("jujutsu.technique.red").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.m_237115_("jujutsu.technique.gojo1").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.m_237115_("jujutsu.technique.purple").getString();
                        cost = 1000.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("jujutsu.technique.unlimited_void").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 3.0) {
                     if (p_selectNumber == 4.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.cursed_speech_step").getString();
                        cost = 0.0;
                     }

                     if (p_selectNumber == 5.0) {
                        name = Component.m_237115_("jujutsu.technique.explode").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("jujutsu.technique.get_crushed").getString();
                        cost = 250.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("jujutsu.technique.crumble_away").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.m_237115_("jujutsu.technique.dont_move").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 9.0) {
                        name = Component.m_237115_("jujutsu.technique.blast_away").getString();
                        cost = 300.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = 1000.0;
                     }
                  } else if (p_skill1 == 4.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire").getString();
                        cost = 180.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire2").getString();
                        cost = 120.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("jujutsu.technique.ember_insects").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire3").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 9.0) {
                        name = Component.m_237115_("jujutsu.technique.flame_fire4").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.m_237115_("jujutsu.technique.meteor").getString();
                        cost = 1250.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("jujutsu.technique.coffinofthe_iron_mountain").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 5.0) {
                     if (p_selectNumber == 3.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack6").getString();
                        cost = 50.0;
                     } else if (p_selectNumber == 5.0) {
                        name = Component.m_237115_("jujutsu.technique.copy1").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("advancements.skill_copy_dhruv_lakdawalla.title").getString();
                        cost = 300.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("advancements.skill_copy_takako_uro.title").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 10.0) {
                        String var10000;
                        label441: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr33 = (ServerPlayer)entity;
                              if (_plr33.m_9236_() instanceof ServerLevel && _plr33.m_8960_().m_135996_(_plr33.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_curseis_lifted"))).m_8193_()) {
                                 var10000 = "entity.jujutsucraft.rika_2";
                                 break label441;
                              }
                           }

                           var10000 = "entity.jujutsucraft.rika";
                        }

                        name = Component.m_237115_(var10000).getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.m_237115_("entity.jujutsucraft.pure_love_cannon").getString();
                        cost = 1000.0;
                     } else if (p_selectNumber == 19.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.rika2").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("jujutsu.technique.okkotsu20").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 6.0) {
                     if (p_selectNumber == 4.0) {
                        p_passive = true;
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.cancel").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 5.0) {
                        name = Component.m_237115_("entity.jujutsucraft.divine_dog_white").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("entity.jujutsucraft.divine_dog_black").getString();
                        cost = 100.0;
                     } else if (p_selectNumber != 8.0) {
                        if (p_selectNumber == 9.0) {
                           name = Component.m_237115_("entity.jujutsucraft.great_serpent").getString();
                           cost = 300.0;
                        } else if (p_selectNumber == 10.0) {
                           name = Component.m_237115_("entity.jujutsucraft.toad").getString();
                           cost = 150.0;
                        } else if (p_selectNumber == 7.0) {
                           name = Component.m_237115_("entity.jujutsucraft.divine_dog_totality").getString();
                           cost = 400.0;
                        }
                     } else {
                        label479: {
                           label427: {
                              if (entity.m_6144_()) {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr42 = (ServerPlayer)entity;
                                    if (_plr42.m_9236_() instanceof ServerLevel && _plr42.m_8960_().m_135996_(_plr42.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_nue_titan"))).m_8193_()) {
                                       break label427;
                                    }
                                 }

                                 if (entity instanceof Player) {
                                    Player _plr = (Player)entity;
                                    if (_plr.m_150110_().f_35937_) {
                                       break label427;
                                    }
                                 }
                              }

                              name = Component.m_237115_("entity.jujutsucraft.nue").getString();
                              cost = 250.0;
                              break label479;
                           }

                           name = Component.m_237115_("entity.jujutsucraft.nue_totality").getString();
                           cost = 500.0;
                        }
                     }

                     if (p_selectNumber == 11.0) {
                        label413: {
                           label485: {
                              if (entity.m_6144_()) {
                                 label409: {
                                    label408: {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr50 = (ServerPlayer)entity;
                                          if (_plr50.m_9236_() instanceof ServerLevel && _plr50.m_8960_().m_135996_(_plr50.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_max_elephant"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique7") >= 0.0) {
                                             break label408;
                                          }
                                       }

                                       if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique7") > 0.0)) {
                                          break label409;
                                       }
                                    }

                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _plr53 = (ServerPlayer)entity;
                                       if (_plr53.m_9236_() instanceof ServerLevel && _plr53.m_8960_().m_135996_(_plr53.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_max_elephant_piercing_blood"))).m_8193_()) {
                                          break label485;
                                       }
                                    }
                                 }

                                 if (entity instanceof Player) {
                                    Player _plr = (Player)entity;
                                    if (_plr.m_150110_().f_35937_) {
                                       break label485;
                                    }
                                 }
                              }

                              name = Component.m_237115_("entity.jujutsucraft.max_elephant").getString();
                              cost = 750.0;
                              break label413;
                           }

                           name = Component.m_237115_("jujutsu.technique.choso3").getString();
                           cost = 200.0;
                        }
                     } else if (p_selectNumber == 12.0) {
                        name = Component.m_237115_("entity.jujutsucraft.rabbit_escape").getString();
                        cost = 125.0;
                     } else if (p_selectNumber == 13.0) {
                        name = Component.m_237115_("entity.jujutsucraft.round_deer").getString();
                        cost = 600.0;
                     } else if (p_selectNumber == 14.0) {
                        name = Component.m_237115_("entity.jujutsucraft.piercing_ox").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.m_237115_("entity.jujutsucraft.tiger_funeral").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 17.0) {
                        name = Component.m_237115_("entity.jujutsucraft.merged_beast_agito").getString();
                        cost = 600.0;
                     } else if (p_selectNumber == 18.0) {
                        ItemStack var34;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var34 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var34 = ItemStack.f_41583_;
                        }

                        if (var34.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           p_passive = true;
                           name = Component.m_237115_("entity.jujutsucraft.eight_handled_swrod_divergent_sila_divine_general_mahoraga").getString();
                           cost = 0.0;
                        } else {
                           label382: {
                              label486: {
                                 if (entity.m_6144_()) {
                                    label378: {
                                       label377: {
                                          if (entity instanceof ServerPlayer) {
                                             ServerPlayer _plr66 = (ServerPlayer)entity;
                                             if (_plr66.m_9236_() instanceof ServerLevel && _plr66.m_8960_().m_135996_(_plr66.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= 0.0) {
                                                break label377;
                                             }
                                          }

                                          if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique14") > 0.0)) {
                                             break label378;
                                          }
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr69 = (ServerPlayer)entity;
                                          if (_plr69.m_9236_() instanceof ServerLevel && _plr69.m_8960_().m_135996_(_plr69.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga_wheel"))).m_8193_()) {
                                             break label486;
                                          }
                                       }
                                    }

                                    if (entity instanceof Player) {
                                       Player _plr = (Player)entity;
                                       if (_plr.m_150110_().f_35937_) {
                                          break label486;
                                       }
                                    }
                                 }

                                 name = Component.m_237115_("entity.jujutsucraft.eight_handled_swrod_divergent_sila_divine_general_mahoraga").getString();
                                 cost = 1000.0;
                                 break label382;
                              }

                              p_passive = true;
                              name = Component.m_237115_("item.jujutsucraft.mahoraga_wheel_helmet").getString();
                              cost = 1000.0;
                           }
                        }
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("jujutsu.technique.chimera_shadow_garden").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 7.0) {
                     if (p_selectNumber == 5.0) {
                        p_physical = true;
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.kashimo1").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 10.0) {
                        p_passive = true;
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.kashimo2").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 15.0) {
                        p_passive = true;
                        name = Component.m_237115_("effect.mythical_beast_amber_effect").getString();
                        cost = 0.0;
                     }

                     if (p_selectNumber == 16.0) {
                        name = Component.m_237115_("jujutsu.technique.kashimo_ah").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 17.0) {
                        name = Component.m_237115_("jujutsu.technique.kashimo_energy_wave").getString();
                        cost = 250.0;
                     } else if (p_selectNumber == 19.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.flying_kick").getString();
                        cost = 400.0;
                     }

                     if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 8.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.m_237115_("jujutsu.technique.dagon1").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("jujutsu.technique.dagon2").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("jujutsu.technique.dagon3").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 9.0) {
                        name = Component.m_237115_("jujutsu.technique.dagon5").getString();
                        cost = 250.0;
                     } else if (p_selectNumber == 10.0) {
                        name = Component.m_237115_("entity.jujutsucraft.bathynomus_giganteus").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("jujutsu.technique.dagon20").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 9.0) {
                     label472: {
                        if (p_selectNumber == 4.0) {
                           ItemStack var35;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21205_();
                           } else {
                              var35 = ItemStack.f_41583_;
                           }

                           if (var35.m_41720_() == JujutsucraftModItems.GARUDA_ITEM.get()) {
                              p_physical = true;
                              name = Component.m_237115_("jujutsu.technique.attack7").getString();
                              cost = 50.0;
                              break label472;
                           }
                        }

                        if (p_selectNumber == 5.0) {
                           ItemStack var36;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var36 = _livEnt.m_21205_();
                           } else {
                              var36 = ItemStack.f_41583_;
                           }

                           if (var36.m_41720_() == JujutsucraftModItems.GARUDA_ITEM_BALL.get()) {
                              name = Component.m_237115_("jujutsu.technique.shoot").getString();
                              cost = 500.0;
                              break label472;
                           }
                        }

                        if (p_selectNumber == 6.0) {
                           name = Component.m_237115_("entity.jujutsucraft.garuda").getString();
                           cost = 75.0;
                        } else if (p_selectNumber == 10.0) {
                           p_passive = true;
                           name = Component.m_237115_("effect.star_rage").getString();
                           cost = 0.0;
                        } else if (p_selectNumber == 20.0) {
                           name = Component.m_237115_("jujutsu.technique.tsukumo_domain").getString();
                           cost = 1250.0;
                        }
                     }
                  } else if (p_skill1 == 10.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.m_237115_("jujutsu.technique.choso1").getString();
                        cost = 120.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.m_237115_("jujutsu.technique.choso2").getString();
                        cost = 25.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("jujutsu.technique.choso3").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.m_237115_("jujutsu.technique.choso4").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 9.0) {
                        byte var37;
                        label339: {
                           p_passive = true;
                           name = Component.m_237115_("jujutsu.technique.choso5").getString();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt101 = (LivingEntity)entity;
                              if (_livEnt101.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                                 var37 = 0;
                                 break label339;
                              }
                           }

                           var37 = 100;
                        }

                        cost = (double)var37;
                     } else if (p_selectNumber == 16.0) {
                        name = Component.m_237115_("jujutsu.technique.choso6").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 18.0) {
                        name = Component.m_237115_("item.jujutsucraft.wing_king_chestplate").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = 1250.0;
                     }
                  }

                  if (p_selectNumber >= 0.0 && p_selectNumber <= 2.0) {
                     name = Component.m_237115_("jujutsu.technique.attack" + Math.round(p_selectNumber + 1.0)).getString();
                     p_physical = true;
                     cost = 0.0;
                  } else if (p_selectNumber == 21.0) {
                     name = Component.m_237115_("jujutsu.technique.cancel_domain").getString();
                     p_physical = true;
                     p_passive = true;
                     cost = 0.0;
                  }

                  if (!name.equals("-----")) {
                     if (!ChangeTechniqueTestProcedure.execute(world, x, y, z, entity, p_skill1, p_selectNumber)) {
                        break;
                     }

                     name = "-----";
                  }

                  p_selectNumber += (double)(entity.m_6144_() ? -1 : 1);
                  if (p_selectNumber < 0.0) {
                     p_selectNumber = 21.0;
                  } else if (p_selectNumber > 21.0) {
                     p_selectNumber = 0.0;
                  }
               }

               TechniqueDecideProcedure.execute(entity, p_passive, p_physical, cost, p_skill1, p_selectNumber, name);
            } else {
               KeyChangeTechniqueOnKeyPressed2Procedure.execute(world, x, y, z, entity, p_skill1, p_selectNumber);
            }
         }

      }
   }
}
