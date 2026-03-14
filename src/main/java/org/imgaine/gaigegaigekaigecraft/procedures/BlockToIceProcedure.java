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
         BlockState block_a = Blocks.f_50016_.m_49966_();
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
         if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_)) {
            if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46136_)) {
               logic_a = true;
               ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(false, world.m_7654_());
            }

            destroy_type = "replace";
            if (entity.getPersistentData().m_128459_("BlockRange") >= 1.0) {
               RANGE = (double)Math.round(entity.getPersistentData().m_128459_("BlockRange") * 2.0);
            } else {
               entity.getPersistentData().m_128347_("BlockRange", 0.0);
               RANGE = 1.0;
            }

            x_pos = (double)Math.round(x - entity.getPersistentData().m_128459_("BlockRange"));

            for(int index0 = 0; index0 < (int)RANGE; ++index0) {
               x_dis = Math.pow(x_pos - x, 2.0);
               y_pos = (double)Math.round(y - entity.getPersistentData().m_128459_("BlockRange"));

               for(int index1 = 0; index1 < (int)RANGE; ++index1) {
                  y_dis = Math.pow(y_pos - y, 2.0);
                  z_pos = (double)Math.round(z - (double)Math.round(entity.getPersistentData().m_128459_("BlockRange")));

                  for(int index2 = 0; index2 < (int)RANGE; ++index2) {
                     block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                     if (!block_a.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                        label76: {
                           if (!(block_a.m_60734_() instanceof LiquidBlock)) {
                              Property var37 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                              if (!(var37 instanceof BooleanProperty)) {
                                 break label76;
                              }

                              BooleanProperty _getbp12 = (BooleanProperty)var37;
                              if (!(Boolean)block_a.m_61143_(_getbp12)) {
                                 break label76;
                              }
                           }

                           distance = Math.sqrt(x_dis + y_dis + Math.pow(z_pos - z, 2.0));
                           if (distance <= Math.max(entity.getPersistentData().m_128459_("BlockRange"), 1.0)) {
                              label69: {
                                 label68: {
                                    if (block_a.m_60734_() != Blocks.f_49990_) {
                                       Property var38 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                                       if (!(var38 instanceof BooleanProperty)) {
                                          break label68;
                                       }

                                       BooleanProperty _getbp15 = (BooleanProperty)var38;
                                       if (!(Boolean)block_a.m_61143_(_getbp15)) {
                                          break label68;
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ packed_ice replace");
                                    }
                                    break label69;
                                 }

                                 if (block_a.m_60734_() == Blocks.f_49991_) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ stone replace");
                                    }
                                 } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:leaves"))) && world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ packed_ice replace");
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
               ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(true, world.m_7654_());
            }
         }

         entity.getPersistentData().m_128347_("BlockRange", 0.0);
         entity.getPersistentData().m_128347_("BlockDamage", 0.0);
      }
   }
}
