package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBulletSkullProcedure {
   public AIBulletSkullProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_b = false;
         Entity entity_a = null;
         double d = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double range_fix = 0.0;
         double speed = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double speed2 = 0.0;
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.0);
         entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range_fix = 1.0;
         RotateEntityProcedure.execute(entity.getX() + entity.getPersistentData().getDouble("x_power") * 50.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getPersistentData().getDouble("y_power") * 50.0, entity.getZ() + entity.getPersistentData().getDouble("z_power") * 50.0, entity);
         if (entity.getPersistentData().getBoolean("Stop")) {
            entity.getPersistentData().putBoolean("Stop", false);
            speed = 0.0;
            speed2 = 0.0;
         } else {
            speed = 1.25;
            speed2 = 0.25;
            BulletDomainHit2Procedure.execute(world, entity);
         }

         x_power = entity.getPersistentData().getDouble("x_power") * speed;
         y_power = entity.getPersistentData().getDouble("y_power") * speed;
         z_power = entity.getPersistentData().getDouble("z_power") * speed;
         entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > 1.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         } else {
            dis = 1.0;
         }

         for(int index0 = 0; index0 < (int)dis; ++index0) {
            range = ReturnEntitySizeProcedure.execute(entity);
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            entity.getPersistentData().putDouble("Damage", 15.0);
            if (entity.getPersistentData().getDouble("cnt_life") > 0.0) {
               entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * Math.pow(0.99, Math.min(entity.getPersistentData().getDouble("cnt_life"), 25.0)));
            }

            entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * CNT6);
            entity.getPersistentData().putDouble("Range", 3.0 * range_fix);
            entity.getPersistentData().putDouble("knockback", 0.5);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator.isAlive() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  logic_b = true;
                  break;
               }
            }

            d = Math.sqrt(1.0 + entity.getPersistentData().getDouble("Damage"));
            if (logic_b || entity.isInWall() || !entity.isAlive()) {
               entity.getPersistentData().putBoolean("Stop", true);
               range = d * 0.25 + 3.0 * range_fix;
               entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
               entity.getPersistentData().putDouble("Range", range * 2.0);
               entity.getPersistentData().putDouble("knockback", 1.0);
               entity.getPersistentData().putDouble("effect", 0.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("BlockDamage", d * 1.0);
               entity.getPersistentData().putDouble("BlockRange", range);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle soul ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle squid_ink ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle explosion ~ ~ ~ " + range * 0.75 + " " + range * 0.75 + " " + range * 0.75 + " 1 " + Math.round(10.0 * range) + " force");
               }

               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") - 1.0);
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               break;
            }

            entity.teleportTo(entity.getX() + x_power * 1.0, entity.getY() + y_power * 1.0, entity.getZ() + z_power * 1.0);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX() + x_power * 1.0, entity.getY() + y_power * 1.0, entity.getZ() + z_power * 1.0, entity.getYRot(), entity.getXRot());
            }
         }

         if ((entity.getPersistentData().getDouble("cnt1") > 15.0 || entity.getPersistentData().getDouble("cnt2") > 10.0 * CNT6) && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (entity.getPersistentData().getDouble("cnt_life") > 1.0) {
            x_pos = entity.getPersistentData().getDouble("old_x");
            y_pos = entity.getPersistentData().getDouble("old_y");
            z_pos = entity.getPersistentData().getDouble("old_z");
            x_power = entity.getX() - x_pos;
            y_power = entity.getY() - y_pos;
            z_power = entity.getZ() - z_pos;
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis > 1.0) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            }

            range = ReturnEntitySizeProcedure.execute(entity);

            for(int index1 = 0; index1 < (int)Math.max(dis * 4.0, 1.0); ++index1) {
               ParticleGeneratorProcedure.execute(world, range * 1.0, 2.0 * range, 22.5, 4.0, x_pos, x_pos - x_power, y_pos, y_pos - y_power, z_pos, z_pos - z_power, "minecraft:squid_ink");
               x_pos += x_power * 0.25;
               y_pos += y_power * 0.25;
               z_pos += z_power * 0.25;
            }
         }

         entity.getPersistentData().putDouble("old_x", entity.getX());
         entity.getPersistentData().putDouble("old_y", entity.getY());
         entity.getPersistentData().putDouble("old_z", entity.getZ());
      }
   }
}
