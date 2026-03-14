package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Effect16Procedure {
   public Effect16Procedure() {
   }

   public static void execute(Entity entityiterator) {
      if (entityiterator != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         double CNT6 = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double yaw = 0.0;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
         z_pos = entityiterator.m_20189_();
         if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               MobEffectInstance var10001;
               MobEffect var10003;
               int var10004;
               label55: {
                  var10001 = new MobEffectInstance;
                  var10003 = (MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                        var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).m_19557_();
                        break label55;
                     }
                  }

                  var10004 = 0;
               }

               int var10005;
               label50: {
                  var10004 = Math.min(var10004 + 400, 1800);
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entityiterator;
                     if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                        label46: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                                 var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).m_19564_();
                                 break label46;
                              }
                           }

                           var10005 = 0;
                        }

                        var10005 = Math.min(var10005 + 1, 4);
                        break label50;
                     }
                  }

                  var10005 = 0;
               }

               var10001.<init>(var10003, var10004, var10005);
               _entity.m_7292_(var10001);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 10, 4, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 200, 0, false, false));
            }
         }

      }
   }
}
