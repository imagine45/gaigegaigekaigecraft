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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DeathPaintingBloodEffectStartedappliedProcedure {
   public DeathPaintingBloodEffectStartedappliedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         double num_level = 0.0;
         if (amplifier > 0.0 && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0 || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity2 = (LivingEntity)entity;
               if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22281_)) {
                  AttributeInstance var10000;
                  double var10001;
                  label44: {
                     var10000 = _livingEntity2.getAttribute_(Attributes.f_22281_);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity1 = (LivingEntity)entity;
                        if (_livingEntity1.m_21204_().m_22171_(Attributes.f_22281_)) {
                           var10001 = _livingEntity1.getAttribute_(Attributes.f_22281_).m_22115_();
                           break label44;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var10000.m_22100_(var10001 + amplifier * 0.6);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.m_21204_().m_22171_(Attributes.f_22284_)) {
                  AttributeInstance var17;
                  double var18;
                  label33: {
                     var17 = _livingEntity4.getAttribute_(Attributes.f_22284_);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity3 = (LivingEntity)entity;
                        if (_livingEntity3.m_21204_().m_22171_(Attributes.f_22284_)) {
                           var18 = _livingEntity3.getAttribute_(Attributes.f_22284_).m_22115_();
                           break label33;
                        }
                     }

                     var18 = 0.0;
                  }

                  var17.m_22100_(var18 + 10.0);
               }
            }
         }

         if (entity instanceof Player) {
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
