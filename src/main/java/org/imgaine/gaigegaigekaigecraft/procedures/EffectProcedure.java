package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EffectProcedure {
   public EffectProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double effect = 0.0;
         effect = entity.getPersistentData().m_128459_("effect");
         EffectCharactorProcedure.execute(world, entity, entityiterator);
         if (effect != 0.0) {
            if (effect <= 5.0) {
               if (effect == 1.0) {
                  Effect1Procedure.execute(world, entity, entityiterator);
               } else if (effect == 2.0) {
                  Effect2Procedure.execute(world, entity, entityiterator);
               } else if (effect == 3.0) {
                  Effect3Procedure.execute(world, entity, entityiterator);
               } else if (effect == 4.0) {
                  Effect4Procedure.execute(world, entity, entityiterator);
               } else if (effect == 5.0) {
                  Effect5Procedure.execute(world, entity, entityiterator);
               }
            } else if (effect <= 10.0) {
               if (effect == 6.0) {
                  Effect6Procedure.execute(world, entityiterator);
               } else if (effect == 7.0) {
                  Effect7Procedure.execute(world, x, y, z, entity);
               } else if (effect == 8.0) {
                  Effect8Procedure.execute(world, entityiterator);
               } else if (effect == 9.0) {
                  Effect9Procedure.execute(world, entityiterator);
               } else if (effect == 10.0) {
                  Effect10Procedure.execute(world, entity, entityiterator);
               }
            } else if (effect <= 15.0) {
               if (effect == 11.0) {
                  Effect11Procedure.execute(world, entity, entityiterator);
               } else if (effect == 12.0) {
                  Effect12Procedure.execute(world, entityiterator);
               } else if (effect == 13.0) {
                  Effect13Procedure.execute(world, entity, entityiterator);
               } else if (effect == 14.0) {
                  Effect14Procedure.execute(world, entityiterator);
               } else if (effect == 15.0) {
                  Effect15Procedure.execute(entityiterator);
               }
            } else if (effect <= 20.0) {
               if (effect == 16.0) {
                  Effect16Procedure.execute(entityiterator);
               } else if (effect == 17.0) {
                  Effect17Procedure.execute(world, entity, entityiterator);
               }
            } else if (effect >= 300.0) {
               EffectCursedSpeechProcedure.execute(world, entity, entityiterator);
            }
         }

      }
   }
}
