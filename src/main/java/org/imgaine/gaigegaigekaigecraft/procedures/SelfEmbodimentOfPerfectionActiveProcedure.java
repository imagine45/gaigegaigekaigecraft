package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SelfEmbodimentOfPerfectionActiveProcedure {
   public SelfEmbodimentOfPerfectionActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         int var10000;
         label23: {
            double old_skill = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label23;
               }
            }

            var10000 = 0;
         }

         if (var10000 % 40 == 20 || entity.getPersistentData().getBoolean("StartDomainAttack")) {
            entity.getPersistentData().putBoolean("StartDomainAttack", false);
            double var9 = entity.getPersistentData().getDouble("skill");
            double var11 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
            entity.getPersistentData().putDouble("skill", 1505.0);
            entity.getPersistentData().putDouble("Damage", 24.0);
            entity.getPersistentData().putDouble("Range", range);
            entity.getPersistentData().putDouble("effect", 12.0);
            entity.getPersistentData().putDouble("effectConfirm", 2.0);
            entity.getPersistentData().putDouble("knockback", 0.0);
            entity.getPersistentData().putBoolean("swing", false);
            entity.getPersistentData().putBoolean("attack", false);
            entity.getPersistentData().putBoolean("onlyLiving", true);
            entity.getPersistentData().putBoolean("DomainAttack", true);
            RangeAttackProcedure.execute(world, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
            entity.getPersistentData().putDouble("skill", var9);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", var11);
            entity.getPersistentData().putBoolean("onlyLiving", false);
         }

      }
   }
}
