package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class JogoFlame2Procedure {
   public JogoFlame2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double CNT6 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity target = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }
         }

         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var16 = var10000;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 2.0F, 1.0F);
            } else {
               _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 5.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (var16 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceProcedure.execute(entity) > 12.0 && (((Entity)var16).getPersistentData().getDouble("skill") == 0.0 || ((Entity)var16).getPersistentData().getDouble("skill") != 0.0 && ((Entity)var16).getPersistentData().getBoolean("attack") || ((Entity)var16).getPersistentData().getDouble("Damage") == 0.0)) {
                  entity.getPersistentData().putBoolean("PRESS_Z", true);
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 4.0));
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 4.0) {
               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
               } else {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                     entity.getPersistentData().putDouble("cnt7", 1.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.5);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 5, 0.5, 0.5, 0.5, 0.5);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 5, 4.0, 4.0, 4.0, 0.0);
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") > 5.0) {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") <= 2.0 + entity.getPersistentData().getDouble("cnt6") * 0.5) {
               if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)(20.0 * CNT6), 0.5, 0.5, 0.5, 0.5 * CNT6);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.LARGE_SMOKE, x_pos, y_pos, z_pos, (int)(20.0 * CNT6), 0.5, 0.5, 0.5, 0.5 * CNT6);
               }
            }

            entity.getPersistentData().putDouble("Damage", (15.0 + entity.getPersistentData().getDouble("cnt2") * 0.1) * CNT6);
            entity.getPersistentData().putDouble("Range", Math.min(24.0, entity.getPersistentData().getDouble("cnt2") * 3.0) * CNT6);
            entity.getPersistentData().putDouble("knockback", 0.1 * CNT6);
            entity.getPersistentData().putDouble("effect", 10.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().getDouble("cnt2") % 4.0 == 1.0) {
               entity.getPersistentData().putDouble("BlockRange", Math.min(12.0, entity.getPersistentData().getDouble("cnt2") * 1.5) * CNT6);
               entity.getPersistentData().putDouble("BlockDamage", 2.0 * CNT6 * Math.max(1.0 - entity.getPersistentData().getDouble("cnt2") / (8.0 * CNT6), 0.05));
               entity.getPersistentData().putDouble("effect", 3.0);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().getDouble("cnt2") > 8.0 * CNT6) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
