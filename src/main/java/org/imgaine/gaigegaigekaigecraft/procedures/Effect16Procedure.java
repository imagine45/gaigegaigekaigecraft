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
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               MobEffectInstance var10001;
               MobEffect var10003;
               int var10004;
               label55: {
                  var10003 = (MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                        var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).getDuration();
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
                     if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                        label46: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                                 var10005 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).getAmplifier();
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

               var10001 = new MobEffectInstance(var10003, var10004, var10005);
               _entity.addEffect(var10001);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 4, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0, false, false));
            }
         }

      }
   }
}
