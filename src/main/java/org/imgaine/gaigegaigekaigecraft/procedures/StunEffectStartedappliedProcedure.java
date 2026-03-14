package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class StunEffectStartedappliedProcedure {
   public StunEffectStartedappliedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         double e_level = 0.0;
         double skill = 0.0;
         if (amplifier > 0.0) {
            label48: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
               }

               entity.getPersistentData().m_128347_("skill", 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }
                     break label48;
                  }
               }

               CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
            }
         }

         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 0.0 || skill <= -900.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity5.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-2.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity6.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

      }
   }
}
