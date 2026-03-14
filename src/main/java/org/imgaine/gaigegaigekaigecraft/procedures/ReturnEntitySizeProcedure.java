package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;

public class ReturnEntitySizeProcedure {
   public ReturnEntitySizeProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double size = 0.0;
         size = (double)(entity.m_20206_() + entity.m_20205_()) * 0.42;
         size = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) ? Math.sqrt(size) : Math.cbrt(size);
         return size;
      }
   }
}
