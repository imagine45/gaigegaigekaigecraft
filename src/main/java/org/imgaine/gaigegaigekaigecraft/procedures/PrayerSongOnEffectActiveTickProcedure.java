package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PrayerSongOnEffectActiveTickProcedure {
   public PrayerSongOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double tick = 0.0;
         double level = 0.0;
         if (entity.isAlive()) {
            label111: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                     double var30 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get()).getAmplifier();
                     break label111;
                  }
               }

               double var10000 = 0.0;
            }

            double var31;
            label106: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                     var31 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get()).getDuration();
                     break label106;
                  }
               }

               var31 = 0.0;
            }

            label101: {
               tick = var31;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                     break label101;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 5, 0, false, false));
                  }
               }
            }

            if (entity.onGround()) {
               label122: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label122;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt7 = (LivingEntity)entity;
                     if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label122;
                     }
                  }

                  if (tick % 3.0 == 0.0 && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
                     }
                  }

                  if (tick % 5.0 == 0.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity9 = (LivingEntity)entity;
                        if (_livingEntity9.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity9.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-15.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            }

            if (tick % 5.0 == 0.0) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(12.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 0));
                     }
                  }
               }
            }

            label120: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt13 = (LivingEntity)entity;
                  if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label120;
                  }
               }

               if (!(entity instanceof LivingEntity)) {
                  return;
               }

               LivingEntity _livEnt14 = (LivingEntity)entity;
               if (!_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get());
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get());
         }

      }
   }
}
