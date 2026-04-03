package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedPoisonOnEffectActiveTickProcedure {
   public CursedPoisonOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean damage = false;
         double level = 0.0;
         double tick = 0.0;
         double playerTechnique1 = 0.0;
         double playerTechnique2 = 0.0;
         if (entity.isAlive()) {
            double var10000;
            label78: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).getAmplifier();
                     break label78;
                  }
               }

               var10000 = 0.0;
            }

            label73: {
               level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).getDuration();
                     break label73;
                  }
               }

               var10000 = 0.0;
            }

            tick = var10000;
            if (tick % 10.0 == 0.0) {
               damage = true;
               if (!(entity instanceof Player)) {
                  if (entity instanceof ItadoriYujiEntity || entity instanceof ItadoriYujiShibuyaEntity || entity instanceof ItadoriYujiShinjukuEntity) {
                     damage = false;
                  }
               } else {
                  JujutsucraftModVariables.PlayerVariables cap = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables)null);
                  playerTechnique1 = cap.PlayerCurseTechnique;
                  playerTechnique2 = cap.PlayerCurseTechnique2;
                  if (playerTechnique1 == 21.0 || playerTechnique2 == 21.0) {
                     damage = false;
                  }

                  if (cap.PlayerCursePowerFormer == 0.0) {
                     damage = false;
                  }
               }

               if (damage && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                  damage = false;
               }

               if (damage) {
                  if (tick % 200.0 == 0.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, false, false));
                        }
                     }

                     entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))), (float)(9.0 * (1.0 + level)));
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
               }
            }
         }

      }
   }
}
