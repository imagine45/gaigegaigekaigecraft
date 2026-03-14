package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;

public class PlayAnimationEntityGuardProcedure {
   public PlayAnimationEntityGuardProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         boolean sword = false;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entityiterator;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
               return;
            }
         }

         if (entityiterator.getPersistentData().m_128459_("skill") == 0.0) {
            sword = LogicSwordProcedure.execute(entityiterator);
            if (sword && entity.getPersistentData().m_128459_("skill") != 0.0 && !entity.getPersistentData().m_128471_("attack")) {
               int var10000;
               label72: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                        break label72;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 > 10) {
                  sword = false;
               }
            }

            if (!(entityiterator instanceof Player) && !(entityiterator instanceof GeoEntity)) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            } else {
               if (entityiterator instanceof Player && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (sword) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity9 = (LivingEntity)entityiterator;
                     if (_livingEntity9.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity9.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-5.0);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity11 = (LivingEntity)entityiterator;
                     if (_livingEntity11.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity11.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
                     }
                  }
               } else {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity12 = (LivingEntity)entityiterator;
                     if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity12.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-9.0);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity13 = (LivingEntity)entityiterator;
                     if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity13.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                     }
                  }
               }

               PlayAnimationProcedure.execute(world, entityiterator);
            }
         }

      }
   }
}
