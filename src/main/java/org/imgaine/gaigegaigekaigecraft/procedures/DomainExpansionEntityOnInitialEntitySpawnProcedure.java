package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class DomainExpansionEntityOnInitialEntitySpawnProcedure {
   public DomainExpansionEntityOnInitialEntitySpawnProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoGravity:1b,Silent:1b,Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
         }

         entity.getPersistentData().putDouble("x_pos", entity.getX());
         entity.getPersistentData().putDouble("y_pos", entity.getY());
         entity.getPersistentData().putDouble("z_pos", entity.getZ());
      }
   }
}
