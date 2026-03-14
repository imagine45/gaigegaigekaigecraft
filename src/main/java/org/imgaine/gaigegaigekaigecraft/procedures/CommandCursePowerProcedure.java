package org.imgaine.gaigegaigekaigecraft.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class CommandCursePowerProcedure {
   public CommandCursePowerProcedure() {
   }

   public static void execute(CommandContext<CommandSourceStack> arguments) {
      try {
         for(Entity entityiterator : EntityArgument.m_91461_(arguments, "target")) {
            double _setval = ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + DoubleArgumentType.getDouble(arguments, "amount");
            entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePower = _setval;
               capability.syncPlayerVariables(entityiterator);
            });
         }
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

   }
}
