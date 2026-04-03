package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.LiquidMetalEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TechniqueLiquidArrowProcedure {
   public TechniqueLiquidArrowProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean strong = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double strength = 0.0;
         double x_target = 0.0;
         double degree = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double dis = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double height = 0.0;
         if (LocateLiquidMetalProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("LIQUID_METAL_UUID"));
            if (entity_a instanceof LiquidMetalEntity && entity.getPersistentData().getDouble("NameRanged") == entity_a.getPersistentData().getDouble("NameRanged_ranged")) {
               entity_a.getPersistentData().putDouble("move", 1.0);
               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               dis = 5.0;
               height = 1.0;
               x_target = entity.getX() + Math.cos(Math.toRadians(yaw + 90.0 + degree)) * dis;
               y_target = entity.getY() + (double)entity.getBbHeight() * 0.25 + height;
               z_target = entity.getZ() + Math.sin(Math.toRadians(yaw + 90.0 + degree)) * dis;
               entity_a.teleportTo(x_target, y_target, z_target);
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.connection.teleport(x_target, y_target, z_target, entity_a.getYRot(), entity_a.getXRot());
               }
            }
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
