package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class DeathPaintingBloodEffectExpiresProcedure {
   public DeathPaintingBloodEffectExpiresProcedure() {
   }

   public static void execute(Entity entity, double amplifier) {
      if (entity != null) {
         double num_level = 0.0;
         if (amplifier > 0.0 && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0 || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting")))) && entity instanceof LivingEntity) {
            LivingEntity _livingEntity2 = (LivingEntity)entity;
            if (_livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
               AttributeInstance var10000;
               double var10001;
               label22: {
                  var10000 = _livingEntity2.getAttribute(Attributes.ATTACK_DAMAGE);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity1 = (LivingEntity)entity;
                     if (_livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var10001 = _livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                        break label22;
                     }
                  }

                  var10001 = 0.0;
               }

               var10000.setBaseValue(var10001 - amplifier * 0.6);
            }
         }

      }
   }
}
