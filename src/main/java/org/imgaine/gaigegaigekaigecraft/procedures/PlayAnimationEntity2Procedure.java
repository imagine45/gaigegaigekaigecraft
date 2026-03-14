package org.imgaine.gaigegaigekaigecraft.procedures;

import java.lang.reflect.Method;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.animatable.GeoEntity;

public class PlayAnimationEntity2Procedure {
   public PlayAnimationEntity2Procedure() {
   }

   public static void execute(Entity entity, String animation_name) {
      if (entity != null && animation_name != null) {
         String ANIME_NAME = "";
         if (entity instanceof GeoEntity) {
            try {
               Method setAnimationMethod = entity.getClass().getMethod("setAnimation", String.class);
               setAnimationMethod.invoke(entity, animation_name);
            } catch (NoSuchMethodException var4) {
            } catch (Exception var5) {
            }
         }

      }
   }
}
