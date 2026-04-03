package org.imgaine.gaigegaigekaigecraft.procedures;

import io.netty.buffer.Unpooled;
import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;

public class ChangeCursedTechniqueRightClickedInAirProcedure {
   public ChangeCursedTechniqueRightClickedInAirProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (ReturnConfigForceRandomCursedTechniqueProcedure.execute() && !(InlineMethodHandler.checkGamemodeCreative(entity))) {
            double _doublesetval1 = 0.0;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCurseTechnique = _doublesetval1;
               capability.syncPlayerVariables(entity);
            });
            boolean _setval1 = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerFlag_A = _setval1;
               capability.syncPlayerVariables(entity);
            });
            boolean _setval2 = false;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerFlag_B = _setval2;
               capability.syncPlayerVariables(entity);
            });
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.getCooldowns().addCooldown((Item)JujutsucraftModItems.CURSED_TECHNIQUE_CHANGER.get(), 10);
            }

            if (!InlineMethodHandler.checkGamemodeCreative(entity) && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:cursed_technique_changer 1");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect clear @s");
            }

            entity.getPersistentData().putDouble("select", 0.0);
            entity.getPersistentData().putDouble("skill_domain", 0.0);
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement revoke @s only gaigegaigekaigecraft:update");
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:update"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }

            String _stringsetval1 = "";
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.OVERLAY1 = _stringsetval1;
               capability.syncPlayerVariables(entity);
            });
            String _stringsetval2 = "";
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.OVERLAY2 = _stringsetval2;
               capability.syncPlayerVariables(entity);
            });
            double _doublesetval2 = 0.0;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerProfession = _doublesetval2;
               capability.syncPlayerVariables(entity);
            });
            WhenRespawnProcedure.execute(world, x, y, z, entity);
            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 0.0 && entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:advancement_select_technique"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof ServerPlayer) {
            ServerPlayer _ent = (ServerPlayer)entity;
            final BlockPos _bpos = BlockPos.containing(x, y, z);
            NetworkHooks.openScreen(_ent, new MenuProvider() {
               public Component getDisplayName() {
                  return Component.literal("SelectTechnique");
               }

               public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                  return new SelectTechniqueMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).writeBlockPos(_bpos));
               }
            }, _bpos);
         }

      }
   }
}
