package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.Difficulty;
import net.minecraft.world.level.LevelAccessor;

public class GetDifficultyLevelProcedure {
   public GetDifficultyLevelProcedure() {
   }

   public static double execute(LevelAccessor world) {
      double num1 = 0.0;
      if (world.getDifficulty() == Difficulty.HARD) {
         num1 = 0.325;
      } else if (world.getDifficulty() == Difficulty.NORMAL) {
         num1 = 0.3;
      } else {
         num1 = 0.275;
      }

      return num1;
   }
}
