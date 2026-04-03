package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityJacobsLadderCircleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ThrowingItemEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class SetNoAIandInvulnerableProcedure {
   public SetNoAIandInvulnerableProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof ThrowingItemEntity) {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Invulnerable:1b}");
            }
         } else if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
         }

         if (entity instanceof EntityJacobsLadderCircleEntity) {
            PlayAnimationEntity2Procedure.execute(entity, "spawned");
         }

      }
   }
}
