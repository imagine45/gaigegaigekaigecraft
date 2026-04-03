package org.imgaine.gaigegaigekaigecraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenEntitySpawnsProcedure {
   public WhenEntitySpawnsProcedure() {
   }

   @SubscribeEvent
   public static void onEntitySpawned(EntityJoinLevelEvent event) {
      execute(event, event.getLevel(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         String dd = "";
         String MM = "";
         String pattern = "";
         String yyyy = "";
         if (!JujutsucraftModVariables.MapVariables.get(world).config_doVanillaMobSpawning && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:vanilla_mob")))) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

         } else {
            if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && (entity.getPersistentData().getString("crime3").isEmpty() || Math.random() < 0.1)) {
               pattern = Component.translatable("jujutsu.message.higuruma_date").getString();
               yyyy = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
               MM = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
               dd = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
               entity.getPersistentData().putString("crime3", Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.translatable("jujutsu.message.higuruma11").getString()).replace("[date]", pattern.replace("yyyy", yyyy).replace("MM", GetMonthProcedure.execute(MM)).replace("dd", dd)));
            }

         }
      }
   }
}
