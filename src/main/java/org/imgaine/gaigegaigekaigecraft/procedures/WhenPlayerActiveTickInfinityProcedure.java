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
         double timer = 0.0;
         double strength = 0.0;
         double infinity_level = 0.0;
         boolean old_physical = false;
         if (entity.getPersistentData().m_128471_("infinity") && ActiveTickConditionProcedure.execute(entity) && LogicStartPassiveProcedure.execute(entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  return;
               }
            }

            strength = 0.0;
            infinity_level = -1.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                  int var10000;
                  label69: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label69;
                        }
                     }

                     var10000 = 0;
                  }

                  strength = (double)(var10000 + 1);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt4 = (LivingEntity)entity;
               if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  int var18;
                  label58: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                           var18 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19564_();
                           break label58;
                        }
                     }

                     var18 = 0;
                  }

                  infinity_level = (double)(var18 + 0);
               }
            }

            int var19;
            label49: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     var19 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19557_();
                     break label49;
                  }
               }

               var19 = 0;
            }

            if (var19 < 15) {
               if (infinity_level < strength) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), 18, (int)Math.round(infinity_level + 1.0)));
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), 18, (int)infinity_level));
                  }
               }
            }
         }

      }
   }
}
