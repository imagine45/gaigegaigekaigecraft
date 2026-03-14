package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel3Procedure {
   public SpawnLevel3Procedure() {
   }

   public static boolean execute(LevelAccessor world) {
      double NUM1 = 0.0;
      NUM1 = JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER;
      if (NUM1 <= 1.0) {
         NUM1 = 0.02;
      } else if (NUM1 <= 2.0) {
         NUM1 = 0.02;
      } else if (NUM1 <= 4.0) {
         NUM1 = 0.05;
      } else if (NUM1 <= 7.0) {
         NUM1 = 0.1;
      } else if (NUM1 <= 9.0) {
         NUM1 = 0.1;
      } else if (NUM1 <= 11.0) {
         NUM1 = 0.125;
      } else if (NUM1 <= 13.0) {
         NUM1 = 0.15;
      } else {
         NUM1 = 0.25;
      }

      return Math.random() < NUM1 && SpawnLevel2Procedure.execute(world);
   }
}
