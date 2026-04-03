package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AIMahoragaDogFrogProcedure {
   public AIMahoragaDogFrogProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") > 10.0 && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:0b}");
         }

         if (entity.getPersistentData().getDouble("cnt1") > 100.0) {
            entity.teleportTo(x, y - 0.5, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(x, y - 0.5, z, entity.getYRot(), entity.getXRot());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 10, 0.25, 0.5, 0.25, 0.0);
            }

            if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 2.0, z)).canOcclude()) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 20, 0.25, 0.5, 0.25, 0.0);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 110.0 && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
