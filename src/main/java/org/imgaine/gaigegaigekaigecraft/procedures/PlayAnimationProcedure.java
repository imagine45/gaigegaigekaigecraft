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
                  if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     var10000 = _livingEntity2.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                     break label43;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity4 = (LivingEntity)entity;
                  if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity4.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(entity.getPersistentData().m_128459_("skill"));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity6.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(entity.getPersistentData().m_128459_("cnt5"));
                  }
               }
            }

            label37: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity7 = (LivingEntity)entity;
                  if (_livingEntity7.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     var10000 = _livingEntity7.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                     break label37;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 != 0.0) {
               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:start_animation")))), 1.0F);
            }
         }

      }
   }
}
