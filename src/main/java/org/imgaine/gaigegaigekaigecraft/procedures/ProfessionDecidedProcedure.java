package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameType;

public class ProfessionDecidedProcedure {
   public ProfessionDecidedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (!InlineMethodHandler.checkGamemodeCreative(entity) && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:profession_changer 1");
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.getCooldowns().addCooldown((Item)JujutsucraftModItems.PROFESSION_CHANGER.get(), 10);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.closeContainer();
         }

      }
   }
}
