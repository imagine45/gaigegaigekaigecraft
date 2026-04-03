package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CompletedAdvancementCursedTechniqueReversalProcedure {
   public CompletedAdvancementCursedTechniqueReversalProcedure() {
   }

   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         label103: {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr0 = (ServerPlayer)entity;
               if (_plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_special"))).isDone()) {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:fame_1");
                  }
                  break label103;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr2 = (ServerPlayer)entity;
               if (_plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_1"))).isDone()) {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:fame_2");
                  }
                  break label103;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr4 = (ServerPlayer)entity;
               if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_2"))).isDone()) {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:fame_3");
                  }
                  break label103;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr6 = (ServerPlayer)entity;
               if (_plr6.level() instanceof ServerLevel && _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:fame_3"))).isDone() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until gaigegaigekaigecraft:fame_4");
               }
            }
         }

         if (entity instanceof ServerPlayer) {
            ServerPlayer _plr8 = (ServerPlayer)entity;
            if (_plr8.level() instanceof ServerLevel && _plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_2"))).isDone() && entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         }

      }
   }
}
