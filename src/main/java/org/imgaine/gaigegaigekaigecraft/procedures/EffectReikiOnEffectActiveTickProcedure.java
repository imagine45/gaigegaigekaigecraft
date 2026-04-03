package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class EffectReikiOnEffectActiveTickProcedure {
   public EffectReikiOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean kashimo = false;
         ItemStack item_a = ItemStack.EMPTY;
         double amount = 0.0;
         double x_pos = 0.0;
         double tick = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double yaw_fix = 0.0;
         double loop_num = 0.0;
         double width = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double height = 0.0;
         if (entity.isAlive()) {
            label54: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label54;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     break label54;
                  }
               }

               label34: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label34;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 2, false, false));
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.BUBBLE_POP, entity.getX(), entity.getY(), entity.getZ(), (int)(entity.getBbHeight() + entity.getBbWidth()), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.05, (double)entity.getBbWidth() * 0.25, 0.0);
               }

               return;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get());
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get());
         }

      }
   }
}
