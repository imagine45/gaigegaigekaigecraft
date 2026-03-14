package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.LiquidMetalEntity;
import net.minecraft.server.level.ServerLevel;
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
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("LIQUID_METAL_UUID"));
            if (entity_a instanceof LiquidMetalEntity && entity.getPersistentData().m_128459_("NameRanged") == entity_a.getPersistentData().m_128459_("NameRanged_ranged")) {
               entity_a.getPersistentData().m_128347_("move", 1.0);
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               dis = 5.0;
               height = 1.0;
               x_target = entity.m_20185_() + Math.cos(Math.toRadians(yaw + 90.0 + degree)) * dis;
               y_target = entity.m_20186_() + (double)entity.m_20206_() * 0.25 + height;
               z_target = entity.m_20189_() + Math.sin(Math.toRadians(yaw + 90.0 + degree)) * dis;
               entity_a.m_6021_(x_target, y_target, z_target);
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.f_8906_.m_9774_(x_target, y_target, z_target, entity_a.m_146908_(), entity_a.m_146909_());
               }
            }
         }

         entity.getPersistentData().m_128347_("skill", 0.0);
      }
   }
}
