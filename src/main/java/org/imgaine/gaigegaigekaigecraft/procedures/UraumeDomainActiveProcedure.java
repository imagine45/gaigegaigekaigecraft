package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class UraumeDomainActiveProcedure {
   public UraumeDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label37: {
            double old_skill = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double tick = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label37;
               }
            }

            var10000 = 0.0;
         }

         double var21 = var10000;
         double var17 = entity.getPersistentData().getDouble("skill");
         double var19 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
         double var20 = entity.getPersistentData().getDouble("x_pos_doma");
         double var22 = entity.getPersistentData().getDouble("y_pos_doma");
         double var23 = entity.getPersistentData().getDouble("z_pos_doma");
         if (!entity.getPersistentData().getBoolean("Failed")) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), var20, var22 + 0.0, var23, 20, range * 0.175, 0.1, range * 0.175, 0.05);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FIREWORK, var20, var22 + 0.0, var23, 3, range * 0.175, 0.1, range * 0.175, 0.05);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), var20, var22 + range / 2.0 * 0.7, var23, 5, range * 0.125, 0.1, range * 0.125, 0.05);
         }

         if (var21 % 40.0 == 0.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
            entity.getPersistentData().putBoolean("StartDomainAttack", false);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", 25.0);
            entity.getPersistentData().putDouble("skill", 2405.0);
            entity.getPersistentData().putDouble("Damage", 5.0);
            entity.getPersistentData().putDouble("effect", 14.0);
            entity.getPersistentData().putDouble("Range", range);
            entity.getPersistentData().putDouble("knockback", 0.0);
            entity.getPersistentData().putBoolean("swing", false);
            entity.getPersistentData().putBoolean("attack", false);
            entity.getPersistentData().putBoolean("DomainAttack", true);
            RangeAttackProcedure.execute(world, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
         }

         entity.getPersistentData().putDouble("skill", var17);
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", var19);
      }
   }
}
