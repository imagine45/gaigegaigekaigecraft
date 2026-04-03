package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class GetSukunaLevelProcedure {
   public GetSukunaLevelProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double num1 = 0.0;
         double cursed_technique2 = 0.0;
         double cursed_technique = 0.0;
         if (ReturnInsideItemProcedure.execute(entity).getItem() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
            if (entity instanceof Player) {
               num1 = (double)((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount();
            } else {
               if (entity instanceof SukunaEntity) {
                  num1 = 16.0;
               } else if (entity instanceof SukunaFushiguroEntity || entity instanceof SukunaPerfectEntity) {
                  num1 = 20.0;
               }

               if (entity instanceof ItadoriYujiEntity) {
                  num1 = 3.0;
               } else if (entity instanceof ItadoriYujiShibuyaEntity) {
                  num1 = 16.0;
               }
            }
         }

         return num1;
      }
   }
}
