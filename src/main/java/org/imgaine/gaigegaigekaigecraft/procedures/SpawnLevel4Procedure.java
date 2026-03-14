package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel4Procedure {
   public SpawnLevel4Procedure() {
   }

   public static boolean execute(LevelAccessor world) {
      double NUM1 = 0.0;
      NUM1 = JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER;
      if (NUM1 <= 1.0) {
         NUM1 = 0.01;
      } else if (NUM1 <= 2.0) {
         NUM1 = 0.01;
      } else if (NUM1 <= 4.0) {
         NUM1 = 0.01;
      } else if (NUM1 <= 7.0) {
         NUM1 = 0.01;
      } else if (NUM1 <= 9.0) {
         NUM1 = 0.025;
      } else if (NUM1 <= 11.0) {
         NUM1 = 0.15;
      } else if (NUM1 <= 13.0) {
         NUM1 = 0.25;
      } else {
         NUM1 = 0.25;
      }

      return Math.random() < NUM1 && SpawnLevel3Procedure.execute(world);
   }
}
