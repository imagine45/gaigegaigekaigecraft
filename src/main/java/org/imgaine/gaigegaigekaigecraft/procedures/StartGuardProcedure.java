package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class StartGuardProcedure {
   public StartGuardProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double animation_num = 0.0;
         double tick = 0.0;
         if (!(entity instanceof Player) || !InlineMethodHandler.checkGamemodeCreative(entity) && !InlineMethodHandler.checkGamemodeSpectator(entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()) && entity.getPersistentData().getBoolean("PRESS_M")) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                     return;
                  }
               }

               label97: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                        break label97;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt9 = (LivingEntity)entity;
                     if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get())) {
                        break label97;
                     }
                  }

                  label66: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt10 = (LivingEntity)entity;
                        if (_livEnt10.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                           tick = 15.0;
                           animation_num = (double)Math.round(-15.0 + Math.ceil(Math.random() * 4.0));
                           break label66;
                        }
                     }

                     tick = 10.0;
                  }

                  if (animation_num != 0.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity11 = (LivingEntity)entity;
                        if (_livingEntity11.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity11.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(animation_num);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity12 = (LivingEntity)entity;
                        if (_livingEntity12.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity12.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), (int)tick, 1, false, false));
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 40, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 10, 0, false, false));
                  }
               }
            }
         }

      }
   }
}
