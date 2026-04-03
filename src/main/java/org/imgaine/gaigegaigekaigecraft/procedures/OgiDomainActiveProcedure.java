package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class OgiDomainActiveProcedure {
   public OgiDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label56: {
            double distance = 0.0;
            double old_skill = 0.0;
            range = 0.0;
            double rad1 = 0.0;
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
                  break label56;
               }
            }

            var10000 = 0.0;
         }

         double var35 = var10000;
         if (entity.getPersistentData().getBoolean("Failed")) {
            if (entity.onGround() && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, 20, 1.0, 0.0, 1.0, 0.05);
            }
         } else {
            double var32 = Math.toRadians(90.0 * (var35 % 4.0));
            double var29 = 4.0 * var35 % (range * 0.5 - 5.0);

            for(int index0 = 0; index0 < 5; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.9)) {
                     var32 += Math.toRadians(10.0 * Math.random());
                     double var34 = entity.getPersistentData().getDouble("x_pos_doma") + Math.cos(var32) * var29;
                     double var36 = entity.getPersistentData().getDouble("y_pos_doma") + 0.1;
                     double var37 = entity.getPersistentData().getDouble("z_pos_doma") + Math.sin(var32) * var29;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), var34, var36, var37, 1, 0.2, 0.1, 0.2, 0.05);
                     }
                  }
               }

               ++var29;
            }

            if (var35 % 20.0 == 0.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
               entity.getPersistentData().putBoolean("StartDomainAttack", false);
               double var30 = entity.getPersistentData().getDouble("skill");
               double var33 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", 60.0);
               entity.getPersistentData().putDouble("skill", 406.0);
               entity.getPersistentData().putDouble("Damage", 9.0);
               entity.getPersistentData().putDouble("Range", range);
               entity.getPersistentData().putDouble("effect", 6.0);
               entity.getPersistentData().putBoolean("swing", false);
               entity.getPersistentData().putBoolean("attack", false);
               entity.getPersistentData().putBoolean("DomainAttack", true);
               RangeAttackProcedure.execute(world, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
               entity.getPersistentData().putDouble("skill", var30);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", var33);
            }
         }

      }
   }
}
