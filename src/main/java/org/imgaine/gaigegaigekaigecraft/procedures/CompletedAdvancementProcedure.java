package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class CompletedAdvancementProcedure {
   public CompletedAdvancementProcedure() {
   }

   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double sukunaLevel = 0.0;
         double pLevel = 0.0;
         double T1 = 0.0;
         double T2 = 0.0;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
         }

         label177: {
            pLevel = pVars.PlayerLevel;
            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr0 = (ServerPlayer)entity;
               if (_plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_special"))).isDone()) {
                  pVars.PlayerLevel = 20.0;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:sorcerer_grade_1");
                  }

                  if (entity instanceof Player) {
                     Player _playerHasItem = (Player)entity;
                     if (_playerHasItem.getInventory().contains(new ItemStack((ItemLike)JujutsucraftModItems.ITEM_MASTER_PHYSICAL_GIFTED.get()))) {
                        break label177;
                     }
                  }

                  T1 = pVars.PlayerCurseTechnique;
                  T2 = pVars.PlayerCurseTechnique2;
                  if ((T1 == -1.0 || T2 == -1.0) && pVars.PlayerCursePower > 0.0 && entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.ITEM_MASTER_PHYSICAL_GIFTED.get())).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr4 = (ServerPlayer)entity;
               if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1"))).isDone()) {
                  pVars.PlayerLevel = 13.0;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:sorcerer_grade_1_semi");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr6 = (ServerPlayer)entity;
               if (_plr6.level() instanceof ServerLevel && _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1_semi"))).isDone()) {
                  pVars.PlayerLevel = 11.0;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:sorcerer_grade_2");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr8 = (ServerPlayer)entity;
               if (_plr8.level() instanceof ServerLevel && _plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2"))).isDone()) {
                  pVars.PlayerLevel = 9.0;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:sorcerer_grade_2_semi");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr10 = (ServerPlayer)entity;
               if (_plr10.level() instanceof ServerLevel && _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2_semi"))).isDone()) {
                  pVars.PlayerLevel = 7.0;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:sorcerer_grade_3");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr12 = (ServerPlayer)entity;
               if (_plr12.level() instanceof ServerLevel && _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_3"))).isDone()) {
                  pVars.PlayerLevel = 4.0;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:sorcerer_grade_4");
                  }
                  break label177;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr14 = (ServerPlayer)entity;
               if (_plr14.level() instanceof ServerLevel && _plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_4"))).isDone()) {
                  pVars.PlayerLevel = 2.0;
                  break label177;
               }
            }

            pVars.PlayerLevel = 1.0;
         }

         if (entity.getPersistentData().getBoolean("CursedSpirit")) {
            sukunaLevel = GetSukunaLevelProcedure.execute(entity);
            if (sukunaLevel > 0.0) {
               pVars.PlayerLevel = (double)Math.round(Math.floor(Math.max(pVars.PlayerLevel, 10.0) + sukunaLevel * 0.5));
            }
         }

         JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER = 0.0;
         JujutsucraftModVariables.MapVariables.get(world).syncData(world);

         for(Entity entityiterator : new ArrayList<Entity>(world.players())) {
            JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER = Math.max(JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER, pVars.PlayerLevel);
            JujutsucraftModVariables.MapVariables.get(world).syncData(world);
         }

         if (pLevel != pVars.PlayerLevel) {
            WhenRespawnProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
