package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;

public class PlayAnimationProcedure {
   public PlayAnimationProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player || entity instanceof GeoEntity) {
            double var10000;
            label43: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     var10000 = _livingEntity2.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                     break label43;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity4 = (LivingEntity)entity;
                  if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(entity.getPersistentData().getDouble("skill"));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(entity.getPersistentData().getDouble("cnt5"));
                  }
               }
            }

            label37: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity7 = (LivingEntity)entity;
                  if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     var10000 = _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                     break label37;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 != 0.0) {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:start_animation")))), 1.0F);
            }
         }

      }
   }
}
