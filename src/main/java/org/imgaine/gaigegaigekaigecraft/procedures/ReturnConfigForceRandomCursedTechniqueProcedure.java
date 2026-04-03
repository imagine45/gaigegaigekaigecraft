package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.Config;

public class ReturnConfigForceRandomCursedTechniqueProcedure {
   public ReturnConfigForceRandomCursedTechniqueProcedure() {
   }

   public static boolean execute() {
      try {
         try {
            return (Boolean)Config.forceRandomCursedTechnique.get();
         } catch (NullPointerException var1) {
            return false;
         }
      } catch (IllegalStateException var2) {
         return false;
      }
   }
}
