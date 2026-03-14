package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.JujutsucraftConfig;

public class ReturnConfigDoVanillaMobSpawningProcedure {
   public ReturnConfigDoVanillaMobSpawningProcedure() {
   }

   public static boolean execute() {
      try {
         try {
            return (Boolean)JujutsucraftConfig.doVanillaMobSpawning.get();
         } catch (NullPointerException var1) {
            return false;
         }
      } catch (IllegalStateException var2) {
         return false;
      }
   }
}
