package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LogicBetrayalProcedure {
   public LogicBetrayalProcedure() {
   }

   public static boolean execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         boolean betrayal = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         betrayal = false;
         if (entityiterator instanceof LivingEntity && entity.getPersistentData().m_128471_("betrayal")) {
            if (entity == entityiterator) {
               betrayal = true;
            }

            if (entity.getPersistentData().m_128471_("DomainAttack")) {
               betrayal = false;
            }

            if (entity.getPersistentData().m_128471_("attack")) {
               betrayal = false;
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               betrayal = false;
            }
         }

         return betrayal;
      } else {
         return false;
      }
   }
}
