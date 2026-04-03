package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockDestroyUpwardProcedure {
   public BlockDestroyUpwardProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String destroy_type = "";
         BlockState block_a = Blocks.AIR.defaultBlockState();
         boolean logic_a = false;
         boolean rock = false;
         boolean wood = false;
         boolean glass = false;
         boolean type_flame = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double hardness = 0.0;
         double RANGE = 0.0;
         double x_dis = 0.0;
         double y_dis = 0.0;
         double cnt_x = 0.0;
         double distance = 0.0;
         double damage = 0.0;
         double z_dis = 0.0;
         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
               logic_a = true;
               ((GameRules.BooleanValue)world.getLevelData().getGameRules().getRule(GameRules.RULE_DOBLOCKDROPS)).set(false, world.getServer());
            }

            destroy_type = entity.getPersistentData().getBoolean("noParticle") ? "replace" : "destroy";
            RANGE = (double)Math.round(entity.getPersistentData().getDouble("BlockRange") >= 1.0 ? entity.getPersistentData().getDouble("BlockRange") * 2.0 : 1.0);
            damage = entity.getPersistentData().getDouble("BlockDamage");
            x_pos = (double)Math.round(x - Math.floor(RANGE * 0.5));

            for(int index0 = 0; index0 < (int)RANGE; ++index0) {
               x_dis = x_pos - x;
               x_dis *= x_dis;
               y_pos = (double)Math.round(y - Math.floor(RANGE * 0.5));

               for(int index1 = 0; index1 < (int)RANGE; ++index1) {
                  y_dis = y_pos - y;
                  y_dis *= y_dis;
                  z_pos = (double)Math.round(z - Math.floor(RANGE * 0.5));

                  for(int index2 = 0; index2 < (int)RANGE; ++index2) {
                     if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                        hardness = (double)world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).getDestroySpeed(world, BlockPos.containing(x_pos, y_pos, z_pos));
                        block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                        z_dis = z_pos - z;
                        z_dis *= z_dis;
                        distance = Math.sqrt(x_dis + y_dis + z_dis);
                        if (y_pos > y) {
                           label174: {
                              if ((!(hardness >= 0.0) || !(hardness < damage)) && !(block_a.getBlock() instanceof LiquidBlock)) {
                                 Property var41 = block_a.getBlock().getStateDefinition().getProperty("waterlogged");
                                 if (!(var41 instanceof BooleanProperty)) {
                                    break label174;
                                 }

                                 BooleanProperty _getbp11 = (BooleanProperty)var41;
                                 if (!(Boolean)block_a.getValue(_getbp11)) {
                                    break label174;
                                 }
                              }

                              if (distance <= Math.max(RANGE * 0.5, 1.0)) {
                                 label170: {
                                    if (!(block_a.getBlock() instanceof LiquidBlock)) {
                                       label171: {
                                          Property var42 = block_a.getBlock().getStateDefinition().getProperty("waterlogged");
                                          if (var42 instanceof BooleanProperty) {
                                             BooleanProperty _getbp13 = (BooleanProperty)var42;
                                             if ((Boolean)block_a.getValue(_getbp13)) {
                                                break label171;
                                             }
                                          }

                                          if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))) {
                                             if (Math.random() < 0.25 && world instanceof ServerLevel) {
                                                ServerLevel _level = (ServerLevel)world;
                                                _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.05);
                                             }

                                             rock = true;
                                          } else if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:mineable/axe"))) && hardness > 0.0) {
                                             wood = true;
                                          } else if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:impermeable")))) {
                                             if (world instanceof ServerLevel) {
                                                ServerLevel _level = (ServerLevel)world;
                                                _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x_pos, y_pos, z_pos, 4, 0.2, 0.2, 0.2, 0.25);
                                             }

                                             glass = true;
                                          }

                                          if (world instanceof ServerLevel) {
                                             ServerLevel _level = (ServerLevel)world;
                                             _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air " + destroy_type);
                                          }
                                          break label170;
                                       }
                                    }

                                    if (block_a.getBlock() == Blocks.WATER && world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, 4, 0.2, 0.2, 0.2, 0.25);
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air replace");
                                    }
                                 }
                              }
                           }
                        }
                     }

                     ++z_pos;
                  }

                  ++y_pos;
               }

               ++x_pos;
            }

            if (!entity.getPersistentData().getBoolean("noEffect")) {
               if (rock) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:stone_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:stone_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F, false);
                     }
                  }
               } else if (wood) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else if (glass && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F, false);
                  }
               }
            }

            if (logic_a) {
               ((GameRules.BooleanValue)world.getLevelData().getGameRules().getRule(GameRules.RULE_DOBLOCKDROPS)).set(true, world.getServer());
            }
         }

         entity.getPersistentData().putDouble("BlockRange", 0.0);
         entity.getPersistentData().putDouble("BlockDamage", 0.0);
         entity.getPersistentData().putBoolean("noParticle", false);
         entity.getPersistentData().putBoolean("noEffect", false);
         entity.getPersistentData().putBoolean("ExtinctionBlock", false);
      }
   }
}
