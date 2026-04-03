package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.PacketHandler;
import org.imgaine.gaigegaigekaigecraft.PlayerVelocityPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PacketDistributor;

public class EntityVectorProcedure {
   public EntityVectorProcedure() {
   }

   public static void execute(Entity entity_a, double vx, double vy, double vz) {
      if (entity_a != null) {
         entity_a.setDeltaMovement(new Vec3(vx, vy, vz));
         if (entity_a instanceof ServerPlayer) {
            Level world = entity_a.level();
            if (!world.isClientSide) {
               PacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)entity_a), new PlayerVelocityPacket(vx, vy, vz));
            }
         }

      }
   }
}
