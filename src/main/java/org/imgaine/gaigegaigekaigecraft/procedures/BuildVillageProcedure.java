package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.JujutsuSorcererEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BuildVillageProcedure {
   public BuildVillageProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean boss_flag = false;
      boolean SUCCESS = false;
      double x_pos = 0.0;
      double y_pos = 0.0;
      double z_pos = 0.0;
      double grade = 0.0;
      double kind = 0.0;
      double entity_height = 0.0;
      double entity_width = 0.0;
      double sx = 0.0;
      double sy = 0.0;
      double sz = 0.0;

      for(int index0 = 0; index0 < 1; ++index0) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.JUJUTSU_SORCERER.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }
      }

      for(int index1 = 0; index1 < 2; ++index1) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }
      }

      Vec3 _center = new Vec3(x, y, z);

      for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
         if (entityiterator instanceof JujutsuSorcererEntity && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
            entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "data merge entity @s {PersistenceRequired:1b}");
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "spreadplayers ~ ~ 4 24 under " + Math.round(y + 8.0) + " false @e[type=minecraft:villager,distance=..1]");
      }

      if (world instanceof ServerLevel _level) {
         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "spreadplayers ~ ~ 4 24 under " + Math.round(y + 8.0) + " false @e[type=gaigegaigekaigecraft:jujutsu_sorcerer,distance=..1]");
      }

      if (world instanceof ServerLevel _level) {
         _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
      }

   }
}
