package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel2Procedure {
   public SpawnLevel2Procedure() {
   }

   public static boolean execute(LevelAccessor world) {
      double NUM1 = 0.0;
      NUM1 = JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER;
      if (NUM1 <= 1.0) {
         NUM1 = 0.04;
      } else if (NUM1 <= 2.0) {
         NUM1 = 0.04;
      } else if (NUM1 <= 4.0) {
         NUM1 = 0.15;
      } else if (NUM1 <= 7.0) {
         NUM1 = 0.3;
      } else if (NUM1 <= 9.0) {
         NUM1 = 0.5;
      } else if (NUM1 <= 11.0) {
         NUM1 = 0.75;
      } else {
         NUM1 = 1.0;
      }

      return Math.random() < NUM1 && SpawnLevel1Procedure.execute();
   }
}
