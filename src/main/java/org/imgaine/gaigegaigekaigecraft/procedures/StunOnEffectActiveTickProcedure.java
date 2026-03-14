package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;

public class StunOnEffectActiveTickProcedure {
   public StunOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label75: {
            double e_level = 0.0;
            double e_tick = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                  double var21 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STUN.get()).m_19564_();
                  break label75;
               }
            }

            double var10000 = 0.0;
         }

         label70: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                  double var23 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STUN.get()).m_19557_();
                  break label70;
               }
            }

            double var22 = 0.0;
         }

         if (entity instanceof GeoEntity) {
            StunEffectStartedappliedProcedure.execute(world, x, y, z, entity, 0.0);
         }

         label79: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get())) {
                  int var24;
                  label60: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get())) {
                           var24 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get()).m_19557_();
                           break label60;
                        }
                     }

                     var24 = 0;
                  }

                  if (var24 > 2) {
                     break label79;
                  }
               }
            }

            entity.getPersistentData().m_128347_("skill", -1000.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 4, 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("skill", -1000.0);
            ResetCounterProcedure.execute(entity);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2, 1, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 2, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
         }

      }
   }
}
