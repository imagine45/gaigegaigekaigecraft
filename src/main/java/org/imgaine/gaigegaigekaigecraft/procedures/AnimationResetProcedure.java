package org.imgaine.gaigegaigekaigecraft.procedures;

import java.lang.reflect.Method;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.animatable.GeoEntity;

public class AnimationResetProcedure {
   public AnimationResetProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof GeoEntity) {
            try {
               Method setAnimationMethod = entity.getClass().getMethod("setAnimation", String.class);
               setAnimationMethod.invoke(entity, "empty");
            } catch (NoSuchMethodException var2) {
            } catch (Exception var3) {
            }
         }

      }
   }
}
