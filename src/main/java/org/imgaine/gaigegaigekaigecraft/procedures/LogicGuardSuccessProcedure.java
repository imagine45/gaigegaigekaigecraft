package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LogicGuardSuccessProcedure {
   public LogicGuardSuccessProcedure() {
   }

   public static boolean execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean var10000;
         label33: {
            label32: {
               boolean guard = false;
               double skill = 0.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt0 = (LivingEntity)entity;
                  if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     break label32;
                  }
               }

               if (!entity.getPersistentData().getBoolean("guard")) {
                  var10000 = false;
                  break label33;
               }
            }

            var10000 = true;
         }

         boolean var6 = var10000;
         double var7 = entity.getPersistentData().getDouble("skill");
         return !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity != sourceentity && (var7 != 0.0 || var6) && entity.getPersistentData().getDouble("Damage") > 0.0;
      } else {
         return false;
      }
   }
}
