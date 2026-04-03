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
         String STR1 = "";
         double NUM1 = 0.0;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entityiterator;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
               return;
            }
         }

         if (entityiterator.getPersistentData().getDouble("skill") == 0.0) {
            sword = LogicSwordProcedure.execute(entityiterator);
            if (sword && entity.getPersistentData().getDouble("skill") != 0.0 && !entity.getPersistentData().getBoolean("attack")) {
               int var10000;
               label83: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                        break label83;
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
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }
            } else {
               if (entityiterator instanceof Player && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (sword) {
                  if (entityiterator instanceof GeoEntity) {
                     STR1 = GetEntityAnimationProcedure.execute(entityiterator);
                     if (STR1.contains("_right")) {
                        NUM1 = 4.0;
                     } else if (STR1.contains("_left")) {
                        NUM1 = 1.0;
                     } else {
                        NUM1 = (double)Mth.nextInt(RandomSource.create(), 1, 6);
                     }
                  } else {
                     NUM1 = (double)Mth.nextInt(RandomSource.create(), 1, 6);
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity12 = (LivingEntity)entityiterator;
                     if (_livingEntity12.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity12.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(100.0);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity13 = (LivingEntity)entityiterator;
                     if (_livingEntity13.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity13.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(NUM1);
                     }
                  }
               } else {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entityiterator;
                     if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-9.0);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entityiterator;
                     if (_livingEntity15.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }
               }

               PlayAnimationProcedure.execute(world, entityiterator);
            }
         }

      }
   }
}
