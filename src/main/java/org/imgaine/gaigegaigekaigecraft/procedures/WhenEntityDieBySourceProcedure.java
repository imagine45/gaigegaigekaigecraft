package org.imgaine.gaigegaigekaigecraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenEntityDieBySourceProcedure {
   public WhenEntityDieBySourceProcedure() {
   }

   @SubscribeEvent
   public static void onEntityDeath(LivingDeathEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
      }

   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      execute((Event)null, world, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         String pattern = "";
         String yyyy = "";
         String dd = "";
         String MM = "";
         JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
         if (sourceentity instanceof Player && (playerVars.PlayerCurseTechnique == 15.0 || playerVars.PlayerCurseTechnique2 == 15.0)) {
            MahitoThisEntityKillsAnotherOneProcedure.execute(world, entity, sourceentity);
         }

         if (entity instanceof LivingEntity) {
            if (entity instanceof WaterAnimal || entity instanceof Guardian || entity instanceof Axolotl || entity instanceof Turtle || !(entity instanceof AbstractGolem) && (entity instanceof Animal || entity instanceof Bat || entity instanceof Axolotl) || entity instanceof Spider || entity instanceof TamableAnimal) {
               return;
            }

            if (entity instanceof AmbientCreature || entity instanceof Animal) {
               return;
            }

            if (entity.getPersistentData().getBoolean("CursedSpirit")) {
               return;
            }

            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
               return;
            }

            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:transfigured_human"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique")))) {
               return;
            }

            if (GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity) {
               return;
            }

            yyyy = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
            MM = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
            dd = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
            pattern = Component.translatable("jujutsu.message.higuruma_date").getString();
            pattern = pattern.replace("yyyy", yyyy).replace("MM", GetMonthProcedure.execute(MM)).replace("dd", dd);
            sourceentity.getPersistentData().putDouble("kill_count", sourceentity.getPersistentData().getDouble("kill_count") + 1.0);
            if (sourceentity.getPersistentData().getDouble("kill_count") >= 3.0) {
               sourceentity.getPersistentData().putString("crime1", Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.translatable("jujutsu.message.higuruma15").getString()).replace("[date]", pattern));
            } else {
               sourceentity.getPersistentData().putString("crime1", Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.translatable("jujutsu.message.higuruma14").getString().replace("[entity]", entity.getDisplayName().getString())).replace("[date]", pattern));
            }
         }

      }
   }
}
