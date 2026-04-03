package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BreakDomainProcedure {
   public BreakDomainProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         int var10000;
         label21: {
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double range = 0.0;
            double dis = 0.0;
            double x_dis = 0.0;
            double y_dis = 0.0;
            double z_dis = 0.0;
            double loop_num = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                  break label21;
               }
            }

            var10000 = 0;
         }

         if (var10000 <= 0) {
            double var21 = entity.getPersistentData().getDouble("x_pos_doma");
            double var22 = entity.getPersistentData().getDouble("y_pos_doma");
            double var23 = entity.getPersistentData().getDouble("z_pos_doma");
            if (!world.getEntitiesOfClass(DomainExpansionEntityEntity.class, AABB.ofSize(new Vec3(var21, var22, var23), 0.1, 0.1, 0.1), (e) -> true).isEmpty()) {
               ((Entity)world.getEntitiesOfClass(DomainExpansionEntityEntity.class, AABB.ofSize(new Vec3(var21, var22, var23), 0.1, 0.1, 0.1), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(var21, var22, var23)).findFirst().orElse((DomainExpansionEntityEntity) null)).getPersistentData().putBoolean("Break", true);
            }
         }

      }
   }
}
