package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressed3Procedure {
   public KeyChangeTechniqueOnKeyPressed3Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity != null) {
         String name = "";
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = 0.0;
         double p_skill1 = 0.0;
         double p_selectNumber = 0.0;
         p_skill1 = playerCT;
         p_selectNumber = playerSelect;
         if (playerCT <= 30.0) {
            name = "-----";

            for(int index0 = 0; index0 < 25; ++index0) {
               p_passive = false;
               p_physical = false;
               if (p_skill1 == 21.0) {
                  if (p_selectNumber == 5.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.itadori1").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 6.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 8.0) {
                     name = Component.m_237115_("jujutsu.technique.dismantle").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 13.0) {
                     name = Component.m_237115_("advancements.skill_piercing_blood.title").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 14.0) {
                     name = Component.m_237115_("advancements.skill_supernova.title").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 18.0) {
                     p_physical = true;
                     name = Component.m_237115_("effect.jujutsucraft.deep_concentration").getString();
                     cost = 1000.0;
                  } else if (p_selectNumber == 19.0) {
                     p_passive = true;
                     p_physical = true;
                     name = Component.m_237115_("effect.sukuna_effect").getString();
                     cost = 0.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 22.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.m_237115_("jujutsu.technique.jinichi5").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 7.0) {
                     name = Component.m_237115_("jujutsu.technique.jinichi7").getString();
                     cost = 300.0;
                  } else if (p_selectNumber == 8.0) {
                     name = Component.m_237115_("jujutsu.technique.jinichi8").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.m_237115_("jujutsu.technique.jinichi10").getString();
                     cost = 500.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 23.0) {
                  if (p_selectNumber == 4.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack4").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 5.0) {
                     name = Component.m_237115_("jujutsu.technique.cockroach1").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.m_237115_("jujutsu.technique.cockroach2").getString();
                     cost = 150.0;
                  } else if (p_selectNumber == 7.0) {
                     name = Component.m_237115_("jujutsu.technique.cockroach3").getString();
                     cost = 250.0;
                  } else if (p_selectNumber == 8.0) {
                     name = Component.m_237115_("entity.jujutsucraft.earthen_insect_trance").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 24.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.m_237115_("jujutsu.technique.uraume_5").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.m_237115_("jujutsu.technique.uraume_6").getString();
                     cost = 120.0;
                  } else if (p_selectNumber == 8.0) {
                     name = Component.m_237115_("jujutsu.technique.uraume_8").getString();
                     cost = 250.0;
                  } else if (p_selectNumber == 9.0) {
                     name = Component.m_237115_("jujutsu.technique.uraume_9").getString();
                     cost = 300.0;
                  } else if (p_selectNumber == 10.0) {
                     cost = 800.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 25.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.m_237115_("entity.jujutsucraft.gravestone_3").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.m_237115_("jujutsu.technique.breath").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 26.0) {
                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftModItems.SWORD_OGI.get() && p_selectNumber == 5.0) {
                     name = Component.m_237115_("item.jujutsucraft.blazing_courage").getString();
                     cost = 100.0;
                  }

                  if (p_selectNumber == 11.0) {
                     name = Component.m_237115_("jujutsu.technique.ogi1").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 12.0) {
                     name = Component.m_237115_("jujutsu.technique.ogi2").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 13.0) {
                     name = Component.m_237115_("jujutsu.technique.ogi3").getString();
                     cost = 125.0;
                  } else if (p_selectNumber == 14.0) {
                     name = Component.m_237115_("jujutsu.technique.ogi4").getString();
                     cost = 150.0;
                  } else if (p_selectNumber == 15.0) {
                     name = Component.m_237115_("jujutsu.technique.ogi5").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 19.0) {
                     name = Component.m_237115_("jujutsu.technique.ogi9").getString();
                     cost = 800.0;
                  }

                  if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 27.0) {
                  label249: {
                     if (p_selectNumber == 4.0) {
                        ItemStack var29;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var29 = _livEnt.m_21205_();
                        } else {
                           var29 = ItemStack.f_41583_;
                        }

                        if (var29.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
                           p_physical = true;
                           name = Component.m_237115_("jujutsu.technique.attack7").getString();
                           cost = 50.0;
                           break label249;
                        }
                     }

                     if (p_selectNumber == 5.0) {
                        p_physical = true;
                        p_passive = true;
                        name = Component.m_237115_("item.jujutsucraft.gavel").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 19.0) {
                        p_physical = true;
                        p_passive = true;
                        name = Component.m_237115_("advancements.battle_hiromi_higuruma.title").getString();
                        cost = 0.0;
                     } else if (p_selectNumber == 20.0) {
                        name = Component.m_237115_("jujutsu.technique.higuruma20").getString();
                        cost = 1000.0;
                     }
                  }
               } else if (p_skill1 == 28.0) {
                  if (p_selectNumber == 15.0) {
                     name = Component.m_237115_("entity.jujutsucraft.entity_jacobs_ladder_circle").getString();
                     cost = 700.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 29.0) {
                  if (p_selectNumber == 4.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.flying_kick").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 5.0) {
                     byte var30;
                     label239: {
                        p_passive = true;
                        name = Component.m_237115_("jujutsu.technique.hakari5").getString();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt47 = (LivingEntity)entity;
                           if (_livEnt47.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                              var30 = 0;
                              break label239;
                           }
                        }

                        var30 = 50;
                     }

                     cost = (double)var30;
                  } else if (p_selectNumber == 6.0) {
                     byte var31;
                     label232: {
                        name = Component.m_237115_("jujutsu.technique.hakari6").getString();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt50 = (LivingEntity)entity;
                           if (_livEnt50.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                              var31 = 0;
                              break label232;
                           }
                        }

                        var31 = 50;
                     }

                     cost = (double)var31;
                  } else if (p_selectNumber == 7.0) {
                     name = Component.m_237115_("jujutsu.technique.hakari7").getString();
                     cost = 0.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("jujutsu.technique.hakari20").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 30.0) {
                  if (p_selectNumber == 5.0) {
                     p_passive = true;
                     name = Component.m_237115_("effect.jujutsucraft.prayer_song").getString();
                     cost = 400.0;
                  } else if (p_selectNumber == 6.0) {
                     p_physical = true;
                     name = Component.m_237115_("jujutsu.technique.attack9").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.m_237115_("effect.domain_expansion").getString();
                     cost = 1000.0;
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
            KeyChangeTechniqueOnKeyPressed4Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
         }

      }
   }
}
