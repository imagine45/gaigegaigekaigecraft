package org.imgaine.gaigegaigekaigecraft.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.imgaine.gaigegaigekaigecraft.procedures.FinishBlastGameProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SwitchBlastGameProcedure;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class BlastGameCommand {
   public BlastGameCommand() {
   }

   @SubscribeEvent
   public static void registerCommand(RegisterCommandsEvent event) {
      event.getDispatcher().register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("blastgame").requires((s) -> s.hasPermission(2))).then(Commands.literal("start").then(Commands.argument("position", BlockPosArgument.blockPos()).then(Commands.argument("distance", DoubleArgumentType.doubleArg(50.0, 500.0)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
         double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
         double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
         Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.getDirection();
         }

         SwitchBlastGameProcedure.execute(world, arguments);
         return 0;
      }))))).then(Commands.literal("finish").executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
         double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
         double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
         Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.getDirection();
         }

         FinishBlastGameProcedure.execute(world, x, y, z);
         return 0;
      })));
   }
}
