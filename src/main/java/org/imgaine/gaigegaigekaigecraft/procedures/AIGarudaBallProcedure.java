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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIGarudaBallProcedure {
   public AIGarudaBallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_attack = false;
         boolean big = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double dis = 0.0;
         double z_power = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double power = 0.0;
         double entity_size = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         double range = 0.0;
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75;
         z_pos = entity.getZ();
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get(), 5, 9, false, false));
            }
         }

         power = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt6") > 0.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") <= 3.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 4.0F, 1.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 4.0F, 1.5F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(25.0 * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(25.0 * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, 1.0);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 0.75F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().getBoolean("Stop")) {
               entity.getPersistentData().putBoolean("Stop", true);
            } else {
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 2.0, entity.getPersistentData().getDouble("y_power") * 2.0, entity.getPersistentData().getDouble("z_power") * 2.0));
               entity.getPersistentData().putDouble("BlockRange", 4.0 * power * entity_size);
               entity.getPersistentData().putDouble("BlockDamage", 18.0 * power);
               entity.getPersistentData().putDouble("knockback", 1.5);
               entity.getPersistentData().putBoolean("noParticle", true);
               entity.getPersistentData().putBoolean("ExtinctionBlock", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               dis = ReturnEntitySizeProcedure.execute(entity);
               entity.getPersistentData().putDouble("Damage", 30.0);
               if (entity.getPersistentData().getDouble("cnt_life") > 0.0) {
                  for(int index0 = 0; index0 < (int)Math.round(entity.getPersistentData().getDouble("cnt_life")); ++index0) {
                     entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 0.99);
                     if (entity.getPersistentData().getDouble("Damage") < 24.0) {
                        entity.getPersistentData().putDouble("Damage", 24.0);
                        break;
                     }
                  }
               }

               entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * power);
               entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
               entity.getPersistentData().putDouble("Range", 8.0 * entity_size);
               entity.getPersistentData().putDouble("knockback", 0.5);
               entity.getPersistentData().putDouble("effect", 1.0);
               entity.getPersistentData().putDouble("effectConfirm", 2.0);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               ParticleGeneratorProcedure.execute(world, entity_size * 1.0, 16.0 * entity_size, 45.0, 16.0, x_pos, x_pos - entity.getPersistentData().getDouble("x_power"), y_pos, y_pos - entity.getPersistentData().getDouble("y_power"), z_pos, z_pos - entity.getPersistentData().getDouble("z_power"), "minecraft:crit");
            }

            if (entity.getPersistentData().getDouble("cnt1") > 15.0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().putDouble("despawn_flag", 1.0);
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
