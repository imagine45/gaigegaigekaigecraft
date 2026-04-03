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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIHouseProcedure {
   public AIHouseProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double rad = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double width = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double height = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         height = (double)entity.getBbHeight();
         width = (double)entity.getBbWidth();
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         x_power = entity.getDeltaMovement().x();
         y_power = entity.getDeltaMovement().y();
         z_power = entity.getDeltaMovement().z();
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (dis > 0.25) {
            entity.getPersistentData().putDouble("cnt4", 0.0);
            entity.getPersistentData().putDouble("cnt5", dis);
            if (dis != 0.0) {
               entity.getPersistentData().putDouble("Damage", 24.0 * CNT6 * Math.min(dis, 2.0));
               entity.getPersistentData().putDouble("Range", (double)(4.0F + 1.0F * entity.getBbWidth()));
               entity.getPersistentData().putDouble("knockback", 0.25 * Math.min(dis, 2.0));
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();

               for(int index0 = 0; index0 < (int)(dis + 1.0); ++index0) {
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
                  if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                     for(int index1 = 0; index1 < 6; ++index1) {
                        entity.getPersistentData().putDouble("BlockDamage", 100.0);
                        entity.getPersistentData().putDouble("BlockRange", 4.0 + 0.5 * (double)entity.getBbWidth());
                        entity.getPersistentData().putBoolean("noParticle", true);
                        entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos + x_power, y_pos + y_power, z_pos + z_power, entity);
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                           break;
                        }
                     }

                     if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                        break;
                     }
                  }
               }

               if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, height, width)) {
                  dis = 0.0;
                  entity.teleportTo(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                  }
               }
            }
         }

         if (dis < 0.25 && (entity.getPersistentData().getDouble("cnt4") > 0.0 || entity.getPersistentData().getDouble("cnt5") > 0.0)) {
            entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
            entity.getPersistentData().putDouble("cnt5", 0.0);
            if (entity.getPersistentData().getDouble("cnt4") <= Math.max(range * 4.0, 1.0)) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * 2.0), 0.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * 2.0), 0.5F, false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt4") == 1.0) {
                  entity.getPersistentData().putDouble("BlockRange", 4.0 + 0.75 * (double)entity.getBbWidth());
                  entity.getPersistentData().putDouble("BlockDamage", 1.0);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (entity.getPersistentData().getDouble("cnt4") % 5.0 == 1.0) {
                  entity.getPersistentData().putDouble("Damage", 30.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", 4.0 + 1.25 * (double)entity.getBbWidth());
                  entity.getPersistentData().putDouble("knockback", 2.5);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("Range", 4.0 + 1.25 * (double)entity.getBbWidth());
                  entity.getPersistentData().putDouble("knockback", 1.25);
                  KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt4") < Math.max(range * 6.0, 1.0)) {
               ParticleGeneratorCircleProcedure.execute(world, 4.0 * range, 90.0, 0.0 * range, 4.0 * range, 2.0, x_pos, x_pos, entity.getY(), entity.getY() + range * 1.0 * Math.random(), 0.0, z_pos, z_pos, "gaigegaigekaigecraft:particle_big_smoke");
            }
         }

         if ((entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 || !entity.isAlive()) && (entity.getPersistentData().getDouble("cnt4") > range * 6.0 + 20.0 || !entity.isAlive())) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_big_smoke ~ ~ ~ " + range * 2.0 + " " + range * 2.0 + " " + range * 2.0 + " 2 " + Math.round(25.0 * range) + " force");
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
