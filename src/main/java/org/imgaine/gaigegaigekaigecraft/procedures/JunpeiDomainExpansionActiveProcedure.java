package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class JunpeiDomainExpansionActiveProcedure {
   public JunpeiDomainExpansionActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label50: {
            double distance = 0.0;
            double old_skill = 0.0;
            double ticks = 0.0;
            range = 0.0;
            double rad1 = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double x_center = 0.0;
            double z_center = 0.0;
            double y_center = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label50;
               }
            }

            var10000 = 0.0;
         }

         double var31 = var10000;
         double var38 = entity.getPersistentData().getDouble("x_pos_doma");
         double var40 = entity.getPersistentData().getDouble("y_pos_doma");
         double var39 = entity.getPersistentData().getDouble("z_pos_doma");
         if (!entity.getPersistentData().getBoolean("Failed")) {
            double var33 = Math.toRadians(90.0 * (var31 % 4.0));
            double var29 = 4.0 * var31 % (range * 0.5 - 5.0);

            for(int index0 = 0; index0 < 4; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.8)) {
                     var33 += Math.toRadians(10.0 * Math.random());
                     double var35 = var38 + Math.cos(var33) * var29;
                     double var36 = var40 + 0.1;
                     double var37 = var39 + Math.sin(var33) * var29;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.WITCH, var35, var36, var37, 1, 0.5, 1.0, 0.5, 0.05);
                     }
                  }
               }

               ++var29;
            }

            if (var31 % 40.0 == 0.0 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
               entity.getPersistentData().putBoolean("StartDomainAttack", false);
               double var30 = entity.getPersistentData().getDouble("skill");
               double var34 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", 100.0);
               entity.getPersistentData().putDouble("skill", 3505.0);
               entity.getPersistentData().putDouble("Damage", 3.0);
               entity.getPersistentData().putDouble("Range", range);
               entity.getPersistentData().putDouble("effect", 16.0);
               entity.getPersistentData().putBoolean("swing", false);
               entity.getPersistentData().putBoolean("attack", false);
               entity.getPersistentData().putBoolean("onlyLiving", true);
               entity.getPersistentData().putBoolean("DomainAttack", true);
               RangeAttackProcedure.execute(world, var38, var40, var39, entity);
               entity.getPersistentData().putDouble("skill", var30);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", var34);
            }
         }

      }
   }
}
