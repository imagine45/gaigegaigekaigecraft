package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GetoCancelTechniqueProcedure {
   public GetoCancelTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double NUM1 = 0.0;
         String STR1 = "";
         String entity_name = "";
         if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
            x_pos = 0.0;
            z_pos = 0.0;
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               Commands var10000 = entity.getServer().getCommands();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
               long var10002 = Math.round(x_pos);
               var10000.performPrefixedCommand(var10001, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
            }

            logic_a = false;
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator.getPersistentData().getBoolean("CursedSpirit") && !(entityiterator instanceof Player) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker") && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID()) && entityiterator.getPersistentData().getDouble("select") == 0.0) {
                  entity_name = entityiterator.getDisplayName().getString();
                  logic_a = true;
                  NUM1 = 0.0;

                  for(int index0 = 0; index0 < 10000; ++index0) {
                     ++NUM1;
                     STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                     if (entity.getPersistentData().getString(STR1 + "_name").equals(entityiterator.getDisplayName().getString())) {
                        y_pos = entity.getPersistentData().getDouble(STR1);
                        break;
                     }

                     if (entity.getPersistentData().getDouble(STR1) == 0.0) {
                        y_pos = 64.0 + 64.0 * Math.random();
                        entity.getPersistentData().putDouble(STR1, y_pos);
                        entity.getPersistentData().putString(STR1 + "_name", entityiterator.getDisplayName().getString());
                        break;
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SQUID_INK, entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), 20, 0.5, 0.5, 0.5, 0.0);
                  }

                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                  }

                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                  }
                  break;
               }
            }

            if (logic_a) {
               entity.getPersistentData().putDouble(STR1 + "_num", 0.0);
               if (world instanceof ServerLevel) {
                  ServerLevel _origLevel = (ServerLevel)world;
                  LevelAccessor var41 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
                  if (var41 != null) {
                     _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : var41.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                        if (entity_name.equals(entityiterator.getDisplayName().getString()) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                           entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                        }
                     }
                  }

                  world = world;
               }

               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            } else {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         } else {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         if (!entity.getPersistentData().getBoolean("PRESS_Z")) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
