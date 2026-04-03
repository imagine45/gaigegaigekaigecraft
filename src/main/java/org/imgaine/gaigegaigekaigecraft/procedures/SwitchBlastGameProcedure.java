package org.imgaine.gaigegaigekaigecraft.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SwitchBlastGameProcedure {
   public SwitchBlastGameProcedure() {
   }

   public static void execute(LevelAccessor world, final CommandContext<CommandSourceStack> arguments) {
      JujutsucraftModVariables.MapVariables.get(world).BlastGameDistance = (double)Math.round(DoubleArgumentType.getDouble(arguments, "distance"));
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter = InlineMethodHandler.getX(arguments);
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter = InlineMethodHandler.getY(arguments);
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter = InlineMethodHandler.getZ(arguments);
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      if (world instanceof ServerLevel _level) {
         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(InlineMethodHandler.getX(arguments), InlineMethodHandler.getY(arguments), InlineMethodHandler.getZ(arguments)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "worldborder center ~ ~");
      }

      if (world instanceof ServerLevel _level) {
         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(InlineMethodHandler.getX(arguments), InlineMethodHandler.getY(arguments), InlineMethodHandler.getZ(arguments)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "worldborder set " + Math.round(DoubleArgumentType.getDouble(arguments, "distance")));
      }

      if (world instanceof ServerLevel _level) {
         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(InlineMethodHandler.getX(arguments), InlineMethodHandler.getY(arguments), InlineMethodHandler.getZ(arguments)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "worldborder add 5");
      }

      JujutsucraftModVariables.MapVariables.get(world).BlastGame = true;
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      if (!world.isClientSide() && world.getServer() != null) {
         world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\"Blast Game\" has switched to " + JujutsucraftModVariables.MapVariables.get(world).BlastGame), false);
      }

   }
}
