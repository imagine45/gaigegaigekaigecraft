package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BlockToIceProcedure {
   public BlockToIceProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState block_a = Blocks.AIR.defaultBlockState();
         String destroy_type = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double RANGE = 0.0;
         double hardness = 0.0;
         double x_dis = 0.0;
         double y_dis = 0.0;
         double cnt_x = 0.0;
         double distance = 0.0;
         boolean logic_a = false;
         boolean rock = false;
         boolean wood = false;
         boolean glass = false;
         boolean type_flame = false;
         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
               logic_a = true;
               ((GameRules.BooleanValue)world.getLevelData().getGameRules().getRule(GameRules.RULE_DOBLOCKDROPS)).set(false, world.getServer());
            }

            destroy_type = "replace";
            if (entity.getPersistentData().getDouble("BlockRange") >= 1.0) {
               RANGE = (double)Math.round(entity.getPersistentData().getDouble("BlockRange") * 2.0);
            } else {
               entity.getPersistentData().putDouble("BlockRange", 0.0);
               RANGE = 1.0;
            }

            x_pos = (double)Math.round(x - entity.getPersistentData().getDouble("BlockRange"));

            for(int index0 = 0; index0 < (int)RANGE; ++index0) {
               x_dis = Math.pow(x_pos - x, 2.0);
               y_pos = (double)Math.round(y - entity.getPersistentData().getDouble("BlockRange"));

               for(int index1 = 0; index1 < (int)RANGE; ++index1) {
                  y_dis = Math.pow(y_pos - y, 2.0);
                  z_pos = (double)Math.round(z - (double)Math.round(entity.getPersistentData().getDouble("BlockRange")));

                  for(int index2 = 0; index2 < (int)RANGE; ++index2) {
                     block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                     if (!block_a.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                        label76: {
                           if (!(block_a.getBlock() instanceof LiquidBlock)) {
                              Property var37 = block_a.getBlock().getStateDefinition().getProperty("waterlogged");
                              if (!(var37 instanceof BooleanProperty)) {
                                 break label76;
                              }

                              BooleanProperty _getbp12 = (BooleanProperty)var37;
                              if (!(Boolean)block_a.getValue(_getbp12)) {
                                 break label76;
                              }
                           }

                           distance = Math.sqrt(x_dis + y_dis + Math.pow(z_pos - z, 2.0));
                           if (distance <= Math.max(entity.getPersistentData().getDouble("BlockRange"), 1.0)) {
                              label69: {
                                 label68: {
                                    if (block_a.getBlock() != Blocks.WATER) {
                                       Property var38 = block_a.getBlock().getStateDefinition().getProperty("waterlogged");
                                       if (!(var38 instanceof BooleanProperty)) {
                                          break label68;
                                       }

                                       BooleanProperty _getbp15 = (BooleanProperty)var38;
                                       if (!(Boolean)block_a.getValue(_getbp15)) {
                                          break label68;
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ packed_ice replace");
                                    }
                                    break label69;
                                 }

                                 if (block_a.getBlock() == Blocks.LAVA) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ stone replace");
                                    }
                                 } else if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:leaves"))) && world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ packed_ice replace");
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

            if (logic_a) {
               ((GameRules.BooleanValue)world.getLevelData().getGameRules().getRule(GameRules.RULE_DOBLOCKDROPS)).set(true, world.getServer());
            }
         }

         entity.getPersistentData().putDouble("BlockRange", 0.0);
         entity.getPersistentData().putDouble("BlockDamage", 0.0);
      }
   }
}
