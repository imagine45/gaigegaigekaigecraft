package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class WhenPlayerActiveTickInfinityProcedure {
   public WhenPlayerActiveTickInfinityProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double strength = 0.0;
         double infinity_level = 0.0;
         if (entity.getPersistentData().getBoolean("infinity") && ActiveTickConditionProcedure.execute(entity) && LogicStartPassiveProcedure.execute(entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  return;
               }
            }

            int var10000;
            label82: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                     break label82;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 0) {
               strength = 0.0;
               infinity_level = -1.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     label74: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label74;
                           }
                        }

                        var10000 = 0;
                     }

                     strength = (double)(var10000 + 1);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     label63: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                              var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).getAmplifier();
                              break label63;
                           }
                        }

                        var10000 = 0;
                     }

                     infinity_level = (double)(var10000 + 0);
                  }
               }

               label54: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).getDuration();
                        break label54;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 < 15) {
                  if (infinity_level < strength) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), 18, (int)Math.round(infinity_level + 1.0)));
                        }
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), 18, (int)infinity_level));
                     }
                  }
               }
            }
         }

      }
   }
}
