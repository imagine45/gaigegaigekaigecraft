package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class CoffinoftheIronMountainActiveProcedure {
   public CoffinoftheIronMountainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label100: {
            double old_skill = 0.0;
            double z_center = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double tick = 0.0;
            double y_center = 0.0;
            double z_pos = 0.0;
            double x_center = 0.0;
            double num1 = 0.0;
            double y_pos = 0.0;
            double num3 = 0.0;
            double num2 = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label100;
               }
            }

            var10000 = 0.0;
         }

         double var38 = var10000;
         double var43 = entity.getPersistentData().getDouble("x_pos_doma");
         double var39 = entity.getPersistentData().getDouble("y_pos_doma");
         double var32 = entity.getPersistentData().getDouble("z_pos_doma");
         if (var38 % 10.0 == 0.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, var43, var39, var32, 15, range * 0.25, range * 0.25, range * 0.25, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIMSON_SPORE, var43, var39, var32, 40, range * 0.25, range * 0.25, range * 0.25, 0.1);
            }

            if (Math.random() < 0.5) {
               double var44 = Math.toRadians(Math.random() * 360.0);
               double var49 = Math.random() * range - range / 2.0;
               double var35 = var43 + Math.sin(var44) * var49;
               double var40 = var32 + Math.cos(var44) * var49;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var35, var39, var40), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                  } else {
                     _level.playLocalSound(var35, var39, var40, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                  }
               }

               if (Math.random() < 0.3 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.LAVA, var35, var39, var40, 30, 0.25, 4.0, 0.25, 0.0);
               }
            }

            if (var38 % 20.0 == 0.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
               entity.getPersistentData().putBoolean("StartDomainAttack", false);
               double var31 = entity.getPersistentData().getDouble("skill");
               double var34 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", 60.0);
               entity.getPersistentData().putDouble("skill", 406.0);
               entity.getPersistentData().putDouble("Damage", 9.0);
               entity.getPersistentData().putDouble("Range", range);
               entity.getPersistentData().putDouble("effect", 6.0);
               entity.getPersistentData().putDouble("knockback", 0.0);
               entity.getPersistentData().putBoolean("swing", false);
               entity.getPersistentData().putBoolean("attack", false);
               entity.getPersistentData().putBoolean("DomainAttack", true);
               RangeAttackProcedure.execute(world, var43, var39, var32, entity);
               entity.getPersistentData().putDouble("skill", var31);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", var34);
            }
         }

         if (var38 % 5.0 == 0.0 && var38 % 10.0 == 0.0) {
            double var45 = Math.toRadians(Math.random() * 720.0);
            double var36 = var43 + Math.sin(var45) * (range / 2.0 - 5.0);
            double var41 = var32 + Math.cos(var45) * (range / 2.0 - 5.0);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.LAVA, var36, var39, var41, 20, 0.1, 4.0, 0.1, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), var36, var39, var41, 40, 0.1, 4.0, 0.1, 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt2_forDomain") > 20.0) {
            entity.getPersistentData().putDouble("cnt2_forDomain", 0.0);
         }

         double var46 = entity.getPersistentData().getDouble("cnt1_forDomain");
         double var50 = entity.getPersistentData().getDouble("cnt2_forDomain");

         for(int index0 = 0; index0 < 40; ++index0) {
            double var48 = var46;

            for(int index1 = 0; index1 < 4; ++index1) {
               double var37 = var43 + Math.sin(var46) * var50;
               double var47 = var39 + 0.0;
               double var42 = var32 + Math.cos(var46) * var50;
               if (Math.random() < 0.25 + var50 / (range * 0.5) && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLAME, var37, var47, var42, 1, 0.0, 0.05, 0.0, 0.0);
               }

               if (var50 + 0.1 > range * 0.5 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLAME, var37, var47, var42, 20, 0.1, 4.0, 0.1, 0.1);
               }

               var46 += Math.toRadians(90.0);
            }

            var46 = var48 + Math.toRadians((Math.random() - 0.5) * 10.0);
            var50 += 0.1;
            if (var50 > range * 0.5 - 4.0) {
               var46 = Math.toRadians(Math.random() * 720.0);
               var50 = 0.0;
            }
         }

         entity.getPersistentData().putDouble("cnt1_forDomain", var46);
         entity.getPersistentData().putDouble("cnt2_forDomain", var50);
      }
   }
}
