package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressed2Procedure {
   public KeyChangeTechniqueOnKeyPressed2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity != null) {
         String name = "";
         String STR1 = "";
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = 0.0;
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double p_skill1 = 0.0;
         double p_selectNumber = 0.0;
         p_skill1 = playerCT;
         p_selectNumber = playerSelect;
         if (playerCT <= 20.0) {
            name = "-----";

            for(int index0 = 0; index0 < 52; ++index0) {
               p_passive = false;
               p_physical = false;
               if (p_skill1 == 11.0) {
                  if (p_selectNumber == 6.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 7.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack8").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 15.0) {
                     name = Component.m_237115_("jujutsu.technique.bird_strike").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 12.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.m_237115_("jujutsu.technique.granite_blast").getString() + "1";
                     cost = 200.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.m_237115_("jujutsu.technique.granite_blast").getString() + "2";
                     cost = 300.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("jujutsu.technique.ishigori_domain").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 13.0) {
                  if (p_selectNumber == 5.0) {
                     p_passive = true;
                     name = Component.m_237115_("jujutsu.technique.nanami1").getString();
                     cost = 25.0;
                  } else if (p_selectNumber == 6.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.m_237115_("jujutsu.technique.nanami2").getString();
                     cost = 300.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("jujutsu.technique.nanami_domain").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 14.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.m_237115_("jujutsu.technique.hanami1").getString();
                     cost = 120.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.m_237115_("jujutsu.technique.hanami2").getString();
                     cost = 80.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.m_237115_("jujutsu.technique.hanami10").getString();
                     cost = 500.0;
                  } else {
                     label381: {
                        label307: {
                           if (p_selectNumber == 15.0) {
                              ItemStack var49;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var49 = _livEnt.m_21205_();
                              } else {
                                 var49 = ItemStack.f_41583_;
                              }

                              if (var49.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                 break label307;
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var49 = _livEnt.m_21206_();
                              } else {
                                 var49 = ItemStack.f_41583_;
                              }

                              if (var49.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                 break label307;
                              }
                           }

                           if (p_selectNumber == 20.0) {
                              name = Component.m_237115_("jujutsu.technique.hanami_domain").getString();
                              cost = 1250.0;
                           }
                           break label381;
                        }

                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.hanami15").getString();
                        cost = 0.0;
                     }
                  }
               } else if (p_skill1 == 15.0) {
                  if (p_selectNumber == 3.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack6").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 4.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     cost = 50.0;
                  }

                  if (p_selectNumber == 5.0) {
                     name = Component.m_237115_("jujutsu.technique.idle_transfiguration").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.m_237115_("entity.jujutsucraft.entity_mahito_hand_3").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 7.0) {
                     name = Component.m_237115_("jujutsu.technique.mahito7").getString();
                     cost = 25.0;
                  } else if (p_selectNumber == 8.0) {
                     String var45 = Component.m_237115_("jujutsu.technique.mahito_soul_multiplicity").getString();
                     name = var45 + ": " + Component.m_237115_("jujutsu.technique.mahito_body_repel1").getString();
                     cost = 150.0;
                  } else if (p_selectNumber == 9.0) {
                     String var46 = Component.m_237115_("jujutsu.technique.mahito_soul_multiplicity").getString();
                     name = var46 + ": " + Component.m_237115_("jujutsu.technique.mahito_body_repel2").getString();
                     cost = 300.0;
                  }

                  if (p_selectNumber == 10.0) {
                     String var47 = Component.m_237115_("jujutsu.technique.mahito_soul_multiplicity").getString();
                     name = var47 + ": " + Component.m_237115_("entity.jujutsucraft.polymorphic_soul_isomer").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 15.0) {
                     String var48 = Component.m_237115_("jujutsu.technique.mahito_idel_mutation").getString();
                     name = var48 + ": " + Component.m_237115_("effect.instant_spirit_bodyof_distorted_killing_effect").getString();
                     cost = 500.0;
                  } else if (p_selectNumber == 16.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack8").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("jujutsu.technique.mahito_domain").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 16.0) {
                  if (p_selectNumber == 5.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack6").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 6.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack7").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 7.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.air_cannon").getString();
                     cost = 250.0;
                  } else if (p_selectNumber == 8.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.mahoraga8").getString();
                     cost = 150.0;
                  } else if (p_selectNumber == 15.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.mahoraga15").getString();
                     cost = 300.0;
                  } else if (p_selectNumber == 19.0) {
                     label389: {
                        ItemStack var10000;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                              break label389;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41784_().m_128459_("skill205") >= 1000.0) {
                           name = Component.m_237115_("jujutsu.technique.mahoraga19").getString();
                           cost = 500.0;
                        }
                     }
                  }
               } else if (p_skill1 == 17.0) {
                  if (p_selectNumber == 5.0) {
                     cost = 50.0;
                  } else if (p_selectNumber == 6.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.flying_kick").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.m_237115_("jujutsu.message.takaba2").getString();
                     cost = 500.0;
                  } else if (p_selectNumber == 15.0) {
                     name = Component.m_237115_("jujutsu.message.takaba1").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 != 18.0) {
                  if (p_skill1 == 19.0) {
                     if (p_selectNumber == 5.0) {
                        p_passive = true;
                        name = Component.m_237115_("effect.projection_sorcery").getString();
                        cost = 40.0;
                     } else if (p_selectNumber == 7.0) {
                        name = Component.m_237115_("jujutsu.technique.top_speed").getString();
                        cost = 300.0;
                     } else if (p_selectNumber == 10.0) {
                        name = Component.m_237115_("jujutsu.technique.air_explode").getString();
                        cost = 125.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("entity.jujutsucraft.entity_time_cell_moon_palace").getString();
                        cost = 1250.0;
                     }
                  } else if (p_skill1 == 20.0) {
                     if (p_selectNumber == 3.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack7").getString();
                        cost = 50.0;
                     } else if (p_selectNumber == 4.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack4").getString();
                        cost = 50.0;
                     } else if (p_selectNumber == 5.0) {
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.boogie_woogie").getString();
                        cost = 10.0;
                     } else if (p_selectNumber == 6.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.todo_lariat").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 7.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.attack9").getString();
                        cost = 100.0;
                     } else if (p_selectNumber == 15.0) {
                        p_physical = true;
                        name = Component.m_237115_("jujutsu.technique.todo_ultra").getString();
                        cost = 600.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("effect.domain_expansion").getString();
                        cost = 1250.0;
                     }
                  }
               } else {
                  label391: {
                     if (p_selectNumber == 17.0 && entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           name = Component.m_237115_("jujutsu.technique.geto_set1").getString();
                           cost = 1500.0;
                           break label391;
                        }
                     }

                     if (p_selectNumber == 18.0 && entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           cost = 1750.0;
                           name = Component.m_237115_("jujutsu.technique.geto_set2").getString();
                           break label391;
                        }
                     }

                     if (p_selectNumber == 19.0 && entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           name = Component.m_237115_("jujutsu.technique.geto_set3").getString();
                           cost = 2000.0;
                           break label391;
                        }
                     }

                     if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("entity.jujutsucraft.entity_womb_profusion").getString();
                        cost = 1250.0;
                     } else if (entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                        if (p_selectNumber == 10.0) {
                           p_passive = true;
                           p_physical = true;
                           name = Component.m_237115_("jujutsu.technique.cancel").getString();
                           cost = 0.0;
                        } else if (p_selectNumber >= 11.0 && p_selectNumber <= 13.0) {
                           p_passive = true;
                           NUM1 = 0.0;
                           NUM2 = -1.0;

                           for(int index1 = 0; index1 < 10000; ++index1) {
                              ++NUM1;
                              STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                              if (entity.getPersistentData().m_128459_(STR1) == 0.0) {
                                 if (p_selectNumber == 11.0) {
                                    NUM2 = 1.0;
                                 } else {
                                    if (p_selectNumber != 13.0) {
                                       break;
                                    }

                                    NUM2 = (double)Math.round(NUM1 - 1.0);
                                 }
                              } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName.contains(entity.getPersistentData().m_128461_(STR1 + "_name") + " ×")) {
                                 if (p_selectNumber == 11.0) {
                                    NUM2 = (double)Math.round(NUM1 - 1.0);
                                 } else if (p_selectNumber == 13.0) {
                                    NUM2 = (double)Math.round(NUM1 + 1.0);
                                 } else {
                                    NUM2 = (double)Math.round(NUM1);
                                 }
                              }

                              if (NUM2 != -1.0) {
                                 name = entity.getPersistentData().m_128461_("data_cursed_spirit_manipulation" + Math.round(NUM2) + "_name");
                                 if (name.equals("")) {
                                    name = "-----";
                                 } else {
                                    name = name + " ×" + Math.round(entity.getPersistentData().m_128459_("data_cursed_spirit_manipulation" + Math.round(NUM2) + "_num"));
                                    p_selectNumber = 12.0;
                                 }
                                 break;
                              }
                           }

                           cost = 0.0;
                        } else if (p_selectNumber == 15.0) {
                           name = Component.m_237115_("jujutsu.technique.uzumaki").getString();
                           cost = 300.0;
                        }
                     } else {
                        p_physical = true;
                        cost = 10.0;
                     }
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
            KeyChangeTechniqueOnKeyPressed3Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
         }

      }
   }
}
