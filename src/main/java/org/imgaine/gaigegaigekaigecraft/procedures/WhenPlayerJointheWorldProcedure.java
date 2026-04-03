package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenPlayerJointheWorldProcedure {
   public WhenPlayerJointheWorldProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         WhenRespawnProcedure.execute(world, x, y, z, entity);
         JujutsucraftModVariables.MapVariables.get(world).config_doVanillaMobSpawning = ReturnConfigDoVanillaMobSpawningProcedure.execute();
         JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      }
   }
}
