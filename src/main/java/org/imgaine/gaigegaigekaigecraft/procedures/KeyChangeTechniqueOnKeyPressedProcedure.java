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
            JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
            p_skill1 = playerVars.SecondTechnique ? playerVars.PlayerCurseTechnique2 : playerVars.PlayerCurseTechnique;
            p_selectNumber = playerVars.PlayerSelectCurseTechnique;
            if (!playerVars.noChangeTechnique) {
               p_selectNumber += (double)(entity.isShiftKeyDown() ? -1 : 1);
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
                        name = Component.translatable("jujutsu.technique.attack7").getString();
                     } else if (p_selectNumber == 6.0) {
                        p_physical = true;
                        cost = 0.0;
                        name = Component.translatable("jujutsu.technique.attack4").getString();
                     } else if (p_selectNumber == 7.0) {
                        p_physical = true;
                        cost = 0.0;
                        name = Component.translatable("jujutsu.technique.attack5").getString();
                     }
                  } else if (p_skill1 == 1.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.translatable("jujutsu.technique.dismantle").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("jujutsu.technique.cleave").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.translatable("jujutsu.technique.open").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("jujutsu.technique.malevolent_shrine").getString();
                        cost = 1250.0;
                     }

                     if (p_selectNumber == 11.0) {
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.dismantle1").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 12.0) {
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.dismantle2").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 13.0) {
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.dismantle3").getString();
                        cost = 100.0;
                     }
                  } else if (p_skill1 == 2.0) {
                     if (p_selectNumber == 5.0) {
                        p_passive = true;
                        name = Component.translatable("jujutsu.technique.infinity").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("jujutsu.technique.blue").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.translatable("jujutsu.technique.red").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.translatable("jujutsu.technique.gojo1").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.translatable("jujutsu.technique.purple").getString();
                        cost = 1000.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("jujutsu.technique.unlimited_void").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 3.0) {
                     if (p_selectNumber == 4.0) {
                     }

                     if (p_selectNumber == 5.0) {
                        name = Component.translatable("jujutsu.technique.explode").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("jujutsu.technique.get_crushed").getString();
                        cost = 250.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.translatable("jujutsu.technique.crumble_away").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.translatable("jujutsu.technique.dont_move").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 9.0) {
                        name = Component.translatable("jujutsu.technique.blast_away").getString();
                        cost = 300.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("effect.domain_expansion").getString();
                        cost = 1000.0;
                     }
                  } else if (p_skill1 == 4.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.translatable("jujutsu.technique.flame_fire").getString();
                        cost = 180.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("jujutsu.technique.flame_fire2").getString();
                        cost = 120.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.translatable("jujutsu.technique.ember_insects").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.translatable("jujutsu.technique.flame_fire3").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 9.0) {
                        name = Component.translatable("jujutsu.technique.flame_fire4").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.translatable("jujutsu.technique.meteor").getString();
                        cost = 1250.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("jujutsu.technique.coffinofthe_iron_mountain").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 5.0) {
                     if (p_selectNumber == 3.0) {
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.attack6").getString();
                        cost = 50.0;
                     } else if (p_selectNumber == 5.0) {
                        name = Component.translatable("jujutsu.technique.copy1").getString();
                        cost = 500.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("advancements.skill_copy_dhruv_lakdawalla.title").getString();
                        cost = 300.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.translatable("advancements.skill_copy_takako_uro.title").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 10.0) {
                        String var10000;
                        label456: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr36 = (ServerPlayer)entity;
                              if (_plr36.level() instanceof ServerLevel && _plr36.getAdvancements().getOrStartProgress(_plr36.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_curseis_lifted"))).isDone()) {
                                 var10000 = "entity.gaigegaigekaigecraft.rika_2";
                                 break label456;
                              }
                           }

                           var10000 = "entity.gaigegaigekaigecraft.rika";
                        }

                        name = Component.translatable(var10000).getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.pure_love_cannon").getString();
                        cost = 1000.0;
                     } else if (p_selectNumber == 19.0) {
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.rika2").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("jujutsu.technique.okkotsu20").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 6.0) {
                     if (p_selectNumber == 4.0) {
                        p_passive = true;
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.cancel").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 5.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.divine_dog_white").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.divine_dog_black").getString();
                        cost = 100.0;
                     } else if (p_selectNumber != 8.0) {
                        if (p_selectNumber == 9.0) {
                           name = Component.translatable("entity.gaigegaigekaigecraft.great_serpent").getString();
                           cost = 300.0;
                        } else if (p_selectNumber == 10.0) {
                           name = Component.translatable("entity.gaigegaigekaigecraft.toad").getString();
                           cost = 150.0;
                        } else if (p_selectNumber == 7.0) {
                           name = Component.translatable("entity.gaigegaigekaigecraft.divine_dog_totality").getString();
                           cost = 400.0;
                        }
                     } else {
                        label494: {
                           label442: {
                              if (entity.isShiftKeyDown()) {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr45 = (ServerPlayer)entity;
                                    if (_plr45.level() instanceof ServerLevel && _plr45.getAdvancements().getOrStartProgress(_plr45.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_nue_titan"))).isDone()) {
                                       break label442;
                                    }
                                 }

                                 if (entity instanceof Player) {
                                    Player _plr = (Player)entity;
                                    if (_plr.getAbilities().instabuild) {
                                       break label442;
                                    }
                                 }
                              }

                              name = Component.translatable("entity.gaigegaigekaigecraft.nue").getString();
                              cost = 250.0;
                              break label494;
                           }

                           name = Component.translatable("entity.gaigegaigekaigecraft.nue_totality").getString();
                           cost = 500.0;
                        }
                     }

                     if (p_selectNumber == 11.0) {
                        label428: {
                           label500: {
                              if (entity.isShiftKeyDown()) {
                                 label424: {
                                    label423: {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr53 = (ServerPlayer)entity;
                                          if (_plr53.level() instanceof ServerLevel && _plr53.getAdvancements().getOrStartProgress(_plr53.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_max_elephant"))).isDone() && entity.getPersistentData().getDouble("TenShadowsTechnique7") >= 0.0) {
                                             break label423;
                                          }
                                       }

                                       if (!(entity.getPersistentData().getDouble("TenShadowsTechnique7") > 0.0)) {
                                          break label424;
                                       }
                                    }

                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _plr56 = (ServerPlayer)entity;
                                       if (_plr56.level() instanceof ServerLevel && _plr56.getAdvancements().getOrStartProgress(_plr56.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_max_elephant_piercing_blood"))).isDone()) {
                                          break label500;
                                       }
                                    }
                                 }

                                 if (entity instanceof Player) {
                                    Player _plr = (Player)entity;
                                    if (_plr.getAbilities().instabuild) {
                                       break label500;
                                    }
                                 }
                              }

                              name = Component.translatable("entity.gaigegaigekaigecraft.max_elephant").getString();
                              cost = 750.0;
                              break label428;
                           }

                           name = Component.translatable("jujutsu.technique.choso3").getString();
                           cost = 200.0;
                        }
                     } else if (p_selectNumber == 12.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.rabbit_escape").getString();
                        cost = 125.0;
                     } else if (p_selectNumber == 13.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.round_deer").getString();
                        cost = 600.0;
                     } else if (p_selectNumber == 14.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.piercing_ox").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 15.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.tiger_funeral").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 17.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.merged_beast_agito").getString();
                        cost = 600.0;
                     } else if (p_selectNumber == 18.0) {
                        ItemStack var35;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var35 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        if (var35.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           p_passive = true;
                           name = Component.translatable("entity.gaigegaigekaigecraft.eight_handled_sword_divergent_sila_divine_general_mahoraga").getString();
                           cost = 0.0;
                        } else {
                           label397: {
                              label501: {
                                 if (entity.isShiftKeyDown()) {
                                    label393: {
                                       label392: {
                                          if (entity instanceof ServerPlayer) {
                                             ServerPlayer _plr69 = (ServerPlayer)entity;
                                             if (_plr69.level() instanceof ServerLevel && _plr69.getAdvancements().getOrStartProgress(_plr69.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_mahoraga"))).isDone() && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 0.0) {
                                                break label392;
                                             }
                                          }

                                          if (!(entity.getPersistentData().getDouble("TenShadowsTechnique14") > 0.0)) {
                                             break label393;
                                          }
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr72 = (ServerPlayer)entity;
                                          if (_plr72.level() instanceof ServerLevel && _plr72.getAdvancements().getOrStartProgress(_plr72.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_mahoraga_wheel"))).isDone()) {
                                             break label501;
                                          }
                                       }
                                    }

                                    if (entity instanceof Player) {
                                       Player _plr = (Player)entity;
                                       if (_plr.getAbilities().instabuild) {
                                          break label501;
                                       }
                                    }
                                 }

                                 name = Component.translatable("entity.gaigegaigekaigecraft.eight_handled_sword_divergent_sila_divine_general_mahoraga").getString();
                                 cost = 1000.0;
                                 break label397;
                              }

                              p_passive = true;
                              name = Component.translatable("item.gaigegaigekaigecraft.mahoraga_wheel_helmet").getString();
                              cost = 1000.0;
                           }
                        }
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("jujutsu.technique.chimera_shadow_garden").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 7.0) {
                     if (p_selectNumber == 3.0) {
                        p_physical = true;
                        cost = 50.0;
                        name = Component.translatable("jujutsu.technique.kick").getString();
                     } else if (p_selectNumber == 4.0) {
                        p_physical = true;
                        cost = 50.0;
                        name = Component.translatable("jujutsu.technique.attack4").getString();
                     } else if (p_selectNumber == 5.0) {
                        p_physical = true;
                        p_passive = true;
                        name = Component.translatable("jujutsu.technique.kashimo1").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 10.0) {
                        p_passive = true;
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.kashimo2").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 15.0) {
                        p_passive = true;
                        name = Component.translatable("effect.mythical_beast_amber_effect").getString();
                        cost = 0.0;
                     }

                     if (p_selectNumber == 16.0) {
                        name = Component.translatable("jujutsu.technique.kashimo_ah").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 17.0) {
                        name = Component.translatable("jujutsu.technique.kashimo_energy_wave").getString();
                        cost = 250.0;
                     } else if (p_selectNumber == 19.0) {
                        p_physical = true;
                        name = Component.translatable("jujutsu.technique.flying_kick").getString();
                        cost = 400.0;
                     }

                     if (p_selectNumber == 20.0) {
                        name = Component.translatable("effect.domain_expansion").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 8.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.translatable("jujutsu.technique.dagon1").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("jujutsu.technique.dagon2").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.translatable("jujutsu.technique.dagon3").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 9.0) {
                        name = Component.translatable("jujutsu.technique.dagon5").getString();
                        cost = 250.0;
                     } else if (p_selectNumber == 10.0) {
                        name = Component.translatable("entity.gaigegaigekaigecraft.bathynomus_giganteus").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("jujutsu.technique.dagon20").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 9.0) {
                     label487: {
                        if (p_selectNumber == 4.0) {
                           ItemStack var36;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var36 = _livEnt.getMainHandItem();
                           } else {
                              var36 = ItemStack.EMPTY;
                           }

                           if (var36.getItem() == JujutsucraftModItems.GARUDA_ITEM.get()) {
                              p_physical = true;
                              name = Component.translatable("jujutsu.technique.attack7").getString();
                              cost = 50.0;
                              break label487;
                           }
                        }

                        if (p_selectNumber == 5.0) {
                           ItemStack var37;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var37 = _livEnt.getMainHandItem();
                           } else {
                              var37 = ItemStack.EMPTY;
                           }

                           if (var37.getItem() == JujutsucraftModItems.GARUDA_ITEM_BALL.get()) {
                              name = Component.translatable("jujutsu.technique.shoot").getString();
                              cost = 500.0;
                              break label487;
                           }
                        }

                        if (p_selectNumber == 6.0) {
                           name = Component.translatable("entity.gaigegaigekaigecraft.garuda").getString();
                           cost = 75.0;
                        } else if (p_selectNumber == 10.0) {
                           p_passive = true;
                           name = Component.translatable("effect.star_rage").getString();
                           cost = 0.0;
                        } else if (p_selectNumber == 20.0) {
                           name = Component.translatable("jujutsu.technique.tsukumo_domain").getString();
                           cost = 1250.0;
                        }
                     }
                  } else if (p_skill1 == 10.0) {
                     if (p_selectNumber == 5.0) {
                        name = Component.translatable("jujutsu.technique.choso1").getString();
                        cost = 120.0;
                     } else if (p_selectNumber == 6.0) {
                        name = Component.translatable("jujutsu.technique.choso2").getString();
                        cost = 25.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.translatable("jujutsu.technique.choso3").getString();
                        cost = 200.0;
                     } else if (p_selectNumber == 8.0) {
                        name = Component.translatable("jujutsu.technique.choso4").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 9.0) {
                        byte var38;
                        label354: {
                           p_passive = true;
                           name = Component.translatable("jujutsu.technique.choso5").getString();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt106 = (LivingEntity)entity;
                              if (_livEnt106.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                                 var38 = 0;
                                 break label354;
                              }
                           }

                           var38 = 100;
                        }

                        cost = (double)var38;
                     } else if (p_selectNumber == 16.0) {
                        name = Component.translatable("jujutsu.technique.choso6").getString();
                        cost = 400.0;
                     } else if (p_selectNumber == 18.0) {
                        name = Component.translatable("item.gaigegaigekaigecraft.wing_king_chestplate").getString();
                        cost = 150.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.translatable("effect.domain_expansion").getString();
                        cost = 1250.0;
                     }
                  }

                  if (p_selectNumber >= 0.0 && p_selectNumber <= 2.0) {
                     name = Component.translatable("jujutsu.technique.attack" + Math.round(p_selectNumber + 1.0)).getString();
                     p_physical = true;
                     cost = 0.0;
                  } else if (p_selectNumber == 21.0) {
                     name = Component.translatable("jujutsu.technique.cancel_domain").getString();
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

                  p_selectNumber += (double)(entity.isShiftKeyDown() ? -1 : 1);
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
