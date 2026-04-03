package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade24Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BuildApartmenthouse1Procedure {
   public BuildApartmenthouse1Procedure() {
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
      if (world.getEntitiesOfClass(CursedSpiritGrade24Entity.class, AABB.ofSize(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).isEmpty()) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.SOUL, x, y, z, 25, 0.25, 0.25, 0.25, 0.1);
         }

         boss_flag = false;

         for(int index0 = 0; index0 < 2; ++index0) {
            SUCCESS = false;

            for(int index1 = 0; index1 < 256; ++index1) {
               entity_height = 2.0;
               entity_width = 2.0;
               x_pos = x + (Math.random() - 0.5) * 48.0 * 0.8;
               y_pos = y - 12.0;
               z_pos = z + (Math.random() - 0.5) * 48.0 * 0.8;

               for(int index2 = 0; index2 < 24; ++index2) {
                  if (world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos)) && !world.isEmptyBlock(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)) && Math.random() < 0.5) {
                     SUCCESS = true;
                     sx = x_pos - entity_width * 0.5;

                     for(int index3 = 0; index3 < (int)Math.round(entity_width); ++index3) {
                        sz = z_pos - entity_width * 0.5;

                        for(int index4 = 0; index4 < (int)Math.round(entity_width); ++index4) {
                           sy = y_pos;

                           for(int index5 = 0; index5 < (int)Math.round(entity_height); ++index5) {
                              if (world.getBlockState(BlockPos.containing(sx, sy, sz)).canOcclude()) {
                                 SUCCESS = false;
                                 break;
                              }

                              ++sy;
                           }

                           if (!SUCCESS) {
                              break;
                           }

                           ++sz;
                        }

                        if (!SUCCESS) {
                           break;
                        }

                        ++sx;
                     }

                     if (SUCCESS) {
                        break;
                     }
                  }

                  ++y_pos;
               }

               if (SUCCESS) {
                  break;
               }
            }

            if (Math.random() < 0.5) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_24.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                  }
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_29.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
         }
      }

   }
}
