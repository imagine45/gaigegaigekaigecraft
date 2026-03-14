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
         BlockState block_a = Blocks.f_50016_.m_49966_();
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
         if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_)) {
            if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46136_)) {
               logic_a = true;
               ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(false, world.m_7654_());
            }

            destroy_type = entity.getPersistentData().m_128471_("noParticle") ? "replace" : "destroy";
            RANGE = (double)Math.round(entity.getPersistentData().m_128459_("BlockRange") >= 1.0 ? entity.getPersistentData().m_128459_("BlockRange") * 2.0 : 1.0);
            damage = entity.getPersistentData().m_128459_("BlockDamage");
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
                     if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                        hardness = (double)world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60800_(world, BlockPos.m_274561_(x_pos, y_pos, z_pos));
                        block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                        z_dis = z_pos - z;
                        z_dis *= z_dis;
                        distance = Math.sqrt(x_dis + y_dis + z_dis);
                        if (y_pos > y) {
                           label174: {
                              if ((!(hardness >= 0.0) || !(hardness < damage)) && !(block_a.m_60734_() instanceof LiquidBlock)) {
                                 Property var41 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                                 if (!(var41 instanceof BooleanProperty)) {
                                    break label174;
                                 }

                                 BooleanProperty _getbp11 = (BooleanProperty)var41;
                                 if (!(Boolean)block_a.m_61143_(_getbp11)) {
                                    break label174;
                                 }
                              }

                              if (distance <= Math.max(RANGE * 0.5, 1.0)) {
                                 label170: {
                                    if (!(block_a.m_60734_() instanceof LiquidBlock)) {
                                       label171: {
                                          Property var42 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                                          if (var42 instanceof BooleanProperty) {
                                             BooleanProperty _getbp13 = (BooleanProperty)var42;
                                             if ((Boolean)block_a.m_61143_(_getbp13)) {
                                                break label171;
                                             }
                                          }

                                          if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))) {
                                             if (Math.random() < 0.25 && world instanceof ServerLevel) {
                                                ServerLevel _level = (ServerLevel)world;
                                                _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.05);
                                             }

                                             rock = true;
                                          } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:mineable/axe"))) && hardness > 0.0) {
                                             wood = true;
                                          } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:impermeable")))) {
                                             if (world instanceof ServerLevel) {
                                                ServerLevel _level = (ServerLevel)world;
                                                _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x_pos, y_pos, z_pos, 4, 0.2, 0.2, 0.2, 0.25);
                                             }

                                             glass = true;
                                          }

                                          if (world instanceof ServerLevel) {
                                             ServerLevel _level = (ServerLevel)world;
                                             _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air " + destroy_type);
                                          }
                                          break label170;
                                       }
                                    }

                                    if (block_a.m_60734_() == Blocks.f_49990_ && world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, 4, 0.2, 0.2, 0.2, 0.25);
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air replace");
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

            if (!entity.getPersistentData().m_128471_("noEffect")) {
               if (rock) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F, false);
                     }
                  }
               } else if (wood) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else if (glass && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 0.4F, 1.0F, false);
                  }
               }
            }

            if (logic_a) {
               ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(true, world.m_7654_());
            }
         }

         entity.getPersistentData().m_128347_("BlockRange", 0.0);
         entity.getPersistentData().m_128347_("BlockDamage", 0.0);
         entity.getPersistentData().m_128379_("noParticle", false);
         entity.getPersistentData().m_128379_("noEffect", false);
         entity.getPersistentData().m_128379_("ExtinctionBlock", false);
      }
   }
}
