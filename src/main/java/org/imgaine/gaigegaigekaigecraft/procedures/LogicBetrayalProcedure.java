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
         betrayal = false;
         if (entityiterator instanceof LivingEntity && entity.getPersistentData().getBoolean("betrayal")) {
            if (entity == entityiterator) {
               betrayal = true;
            }

            if (entity.getPersistentData().getBoolean("DomainAttack")) {
               betrayal = false;
            }

            if (entity.getPersistentData().getBoolean("attack")) {
               betrayal = false;
            }

            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               betrayal = false;
            }
         }

         return betrayal;
      } else {
         return false;
      }
   }
}
