package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class KeyChangeTechniqueOnKeyPressed5Procedure {
   public KeyChangeTechniqueOnKeyPressed5Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity != null) {
         String name = "";
         String STR1 = "";
         boolean reChange = false;
         boolean p_passive = false;
         boolean p_physical = false;
         double cost = 0.0;
         double old_select = 0.0;
         double PlayerCurseTechnique = 0.0;
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double p_skill1 = 0.0;
         double p_selectNumber = 0.0;
         p_skill1 = playerCT;
         p_selectNumber = playerSelect;
         if (playerCT <= 50.0) {
            name = "-----";

            for(int index0 = 0; index0 < 25; ++index0) {
               p_passive = false;
               p_physical = false;
               if (p_skill1 == 41.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.translatable("jujutsu.technique.kaori2").getString();
                     cost = 75.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.translatable("jujutsu.technique.kaori1").getString();
                     cost = 150.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.translatable("effect.domain_expansion").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 42.0) {
                  cost = 0.0;
               } else if (p_skill1 == 43.0) {
                  if (p_selectNumber == 3.0) {
                     p_physical = true;
                     name = Component.translatable("jujutsu.technique.attack4").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 4.0) {
                     p_physical = true;
                     name = Component.translatable("jujutsu.technique.attack7").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 5.0) {
                     name = Component.translatable("entity.gaigegaigekaigecraft.rozetsu_shikigami").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.translatable("entity.gaigegaigekaigecraft.rozetsu_shikigami_vessel").getString();
                     cost = 250.0;
                  } else if (p_selectNumber == 7.0) {
                     name = Component.translatable("entity.gaigegaigekaigecraft.rozetsu_shikigami_vessel_2").getString();
                     cost = 400.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.translatable("jujutsu.technique.rozetsu_domain").getString();
                     cost = 1250.0;
                  }
               } else if (p_skill1 == 44.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.translatable("item.gaigegaigekaigecraft.kitchen_knife").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.translatable("entity.gaigegaigekaigecraft.car").getString();
                     cost = 200.0;
                  } else if (p_selectNumber == 11.0) {
                     name = Component.translatable("entity.gaigegaigekaigecraft.truck").getString();
                     cost = 300.0;
                  } else if (p_selectNumber == 15.0) {
                     name = Component.translatable("entity.gaigegaigekaigecraft.entity_house").getString();
                     cost = 600.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.translatable("effect.domain_expansion").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 45.0) {
                  if (p_selectNumber == 5.0) {
                     name = Component.translatable("item.gaigegaigekaigecraft.tooth").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.translatable("item.gaigegaigekaigecraft.eye").getString();
                     cost = 400.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.translatable("effect.domain_expansion").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 46.0) {
                  if (p_selectNumber == 10.0) {
                     name = Component.translatable("entity.gaigegaigekaigecraft.entity_eye_ranta").getString();
                     cost = 250.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.translatable("effect.domain_expansion").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 47.0) {
                  if (p_selectNumber == 4.0) {
                     p_physical = true;
                     name = Component.translatable("jujutsu.technique.attack7").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 5.0) {
                     p_physical = true;
                     name = Component.translatable("jujutsu.technique.crystal1").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 6.0) {
                     name = Component.translatable("jujutsu.technique.crystal2").getString();
                     cost = 50.0;
                  } else if (p_selectNumber == 7.0) {
                     name = Component.translatable("jujutsu.technique.crystal3").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 8.0) {
                     name = Component.translatable("jujutsu.technique.crystal4").getString();
                     cost = 400.0;
                  } else if (p_selectNumber == 9.0) {
                     name = Component.translatable("jujutsu.technique.crystal5").getString();
                     cost = 300.0;
                  } else if (p_selectNumber == 10.0) {
                     name = Component.translatable("jujutsu.technique.crystal6").getString();
                     cost = 100.0;
                  } else if (p_selectNumber == 15.0) {
                     name = Component.translatable("jujutsu.technique.crystal7").getString();
                     cost = 500.0;
                  } else if (p_selectNumber == 20.0) {
                     name = Component.translatable("effect.domain_expansion").getString();
                     cost = 1000.0;
                  }
               } else if (p_skill1 == 48.0) {
                  cost = 0.0;
               } else if (p_skill1 == 49.0) {
                  cost = 0.0;
               } else if (p_skill1 == 50.0) {
                  cost = 0.0;
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
         }

      }
   }
}
