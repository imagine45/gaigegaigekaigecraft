package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DivineDogBlackEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogWhiteEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GreatSerpentEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MaxElephantEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PiercingOxEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RoundDeerEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TigerFuneralEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ToadEntity;
import net.minecraft.world.entity.Entity;

public class ReturnTenShadowsNumProcedure {
   public ReturnTenShadowsNumProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double NUM1 = 0.0;
         if (entity instanceof DivineDogWhiteEntity) {
            NUM1 = 1.0;
         } else if (entity instanceof DivineDogBlackEntity) {
            NUM1 = 2.0;
         } else if (entity instanceof DivineDogTotalityEntity) {
            NUM1 = 3.0;
         } else if (entity instanceof NueEntity) {
            NUM1 = 4.0;
         } else if (entity instanceof GreatSerpentEntity) {
            NUM1 = 5.0;
         } else if (entity instanceof ToadEntity) {
            NUM1 = 6.0;
         } else if (entity instanceof MaxElephantEntity) {
            NUM1 = 7.0;
         } else if (entity instanceof RabbitEscapeEntity) {
            NUM1 = 8.0;
         } else if (entity instanceof RoundDeerEntity) {
            NUM1 = 9.0;
         }

         if (entity instanceof PiercingOxEntity) {
            NUM1 = 10.0;
         } else if (entity instanceof TigerFuneralEntity) {
            NUM1 = 11.0;
         } else if (entity instanceof MergedBeastAgitoEntity) {
            NUM1 = 13.0;
         } else if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
            NUM1 = 14.0;
         }

         return NUM1;
      }
   }
}
