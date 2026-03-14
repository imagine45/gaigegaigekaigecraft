package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BlueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade06Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade18Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone1Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone3Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone4Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
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

public class BlockDestroyAllDirectionProcedure {
   public BlockDestroyAllDirectionProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState block_a = Blocks.f_50016_.m_49966_();
         boolean logic_water = false;
         boolean glass = false;
         boolean logic_a = false;
         boolean type_flame = false;
         boolean rock = false;
         boolean wood = false;
         String destroy_type = "";
         double x_dis = 0.0;
         double damage = 0.0;
         double distance = 0.0;
         double cnt_x = 0.0;
         double x_pos = 0.0;
         double z_dis = 0.0;
         double z_pos = 0.0;
         double hardness = 0.0;
         double num1 = 0.0;
         double y_pos = 0.0;
         double y_dis = 0.0;
         double RANGE = 0.0;
         if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_)) {
            if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46136_)) {
               logic_a = true;
               ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(false, world.m_7654_());
            }

            num1 = entity.getPersistentData().m_128459_("skill");
            if (num1 != 107.0 && (!(num1 >= 405.0) || !(num1 <= 420.0)) && (!(num1 >= 2605.0) || !(num1 <= 2620.0))) {
               if (entity instanceof CursedSpiritGrade18Entity || entity instanceof CursedSpiritGrade06Entity) {
                  type_flame = true;
               }
            } else {
               type_flame = true;
            }

            logic_water = true;
            if (entity instanceof Gravestone1Entity || entity instanceof Gravestone2Entity || entity instanceof Gravestone3Entity || entity instanceof Gravestone4Entity || entity instanceof RockFragmentEntity) {
               logic_water = false;
            }

            RANGE = entity.getPersistentData().m_128459_("BlockRange");
            RANGE = (double)Math.round(RANGE >= 1.0 ? RANGE * 2.0 : 1.0);
            damage = entity.getPersistentData().m_128459_("BlockDamage");
            destroy_type = !entity.getPersistentData().m_128471_("noParticle") && !(RANGE >= 6.0) ? "destroy" : "replace";
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
                        label344: {
                           hardness = (double)world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60800_(world, BlockPos.m_274561_(x_pos, y_pos, z_pos));
                           block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                           z_dis = z_pos - z;
                           z_dis *= z_dis;
                           distance = Math.sqrt(x_dis + y_dis + z_dis);
                           if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:logs"))) || block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:planks")))) {
                              hardness *= 0.5;
                           }

                           if ((!(hardness >= 0.0) || !(hardness < damage)) && !(block_a.m_60734_() instanceof LiquidBlock)) {
                              Property var44 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                              if (!(var44 instanceof BooleanProperty)) {
                                 break label344;
                              }

                              BooleanProperty _getbp20 = (BooleanProperty)var44;
                              if (!(Boolean)block_a.m_61143_(_getbp20)) {
                                 break label344;
                              }
                           }

                           if (distance <= Math.max(RANGE * 0.5, 1.0)) {
                              cnt_x = 0.0;
                              if (world.m_8055_(BlockPos.m_274561_(x_pos + 1.0, y_pos, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos + 1.0, y_pos, z_pos)).m_60819_().m_76170_()) {
                                 cnt_x += 2.0;
                              }

                              if (world.m_8055_(BlockPos.m_274561_(x_pos - 1.0, y_pos, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos - 1.0, y_pos, z_pos)).m_60819_().m_76170_()) {
                                 cnt_x += 2.0;
                              }

                              if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos + 1.0)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos + 1.0)).m_60819_().m_76170_()) {
                                 cnt_x += 2.0;
                              }

                              if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos - 1.0)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos - 1.0)).m_60819_().m_76170_()) {
                                 cnt_x += 2.0;
                              }

                              if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + 1.0, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + 1.0, z_pos)).m_60819_().m_76170_()) {
                                 ++cnt_x;
                              }

                              if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60819_().m_76170_()) {
                                 ++cnt_x;
                              }

                              if (cnt_x < 8.0) {
                                 label333: {
                                    label327: {
                                       if (!(block_a.m_60734_() instanceof LiquidBlock)) {
                                          Property var45 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                                          if (!(var45 instanceof BooleanProperty)) {
                                             break label327;
                                          }

                                          BooleanProperty _getbp40 = (BooleanProperty)var45;
                                          if (!(Boolean)block_a.m_61143_(_getbp40)) {
                                             break label327;
                                          }
                                       }

                                       if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + 1.0, z_pos)) && block_a.m_60734_() == Blocks.f_49990_) {
                                          if (entity instanceof BlueEntity) {
                                             ParticleGeneratorProcedure.execute(world, 0.5, 4.0, 0.0, 0.2 * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_water");
                                          } else if (world instanceof ServerLevel) {
                                             ServerLevel _level = (ServerLevel)world;
                                             _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, 4, 0.2, 0.2, 0.2, 2.0);
                                          }
                                       }

                                       if (logic_water && (world.m_46859_(BlockPos.m_274561_(x_pos + 1.0, y_pos, z_pos + 0.0)) || world.m_46859_(BlockPos.m_274561_(x_pos - 1.0, y_pos, z_pos + 0.0)) || world.m_46859_(BlockPos.m_274561_(x_pos + 0.0, y_pos, z_pos + 1.0)) || world.m_46859_(BlockPos.m_274561_(x_pos + 0.0, y_pos, z_pos - 1.0))) && world instanceof ServerLevel) {
                                          ServerLevel _level = (ServerLevel)world;
                                          _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air replace");
                                       }
                                       break label333;
                                    }

                                    if (!block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:impermeable"))) && type_flame) {
                                       if (entity instanceof BlueEntity) {
                                          ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 0.0, 0.5 * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_magma");
                                       } else if (world instanceof ServerLevel) {
                                          ServerLevel _level = (ServerLevel)world;
                                          _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.25);
                                       }
                                    }

                                    if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))) {
                                       if (Math.random() < 0.33) {
                                          if (entity instanceof BlueEntity) {
                                             ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 0.0, 0.1 * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_big_smoke");
                                          } else if (world instanceof ServerLevel) {
                                             ServerLevel _level = (ServerLevel)world;
                                             _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.25);
                                          }
                                       }

                                       rock = true;
                                    } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:mineable/axe"))) && hardness > 0.0) {
                                       wood = true;
                                    } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:impermeable")))) {
                                       if (entity instanceof BlueEntity) {
                                          ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 0.0, 0.1 * distance, x_pos, x, y_pos, y, z_pos, z, "jujutsucraft:particle_broken_glass_small");
                                       } else if (world instanceof ServerLevel) {
                                          ServerLevel _level = (ServerLevel)world;
                                          _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x_pos, y_pos, z_pos, 4, 0.2, 0.2, 0.2, 0.25);
                                       }

                                       glass = true;
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air " + destroy_type);
                                    }

                                    if (!entity.getPersistentData().m_128471_("ExtinctionBlock")) {
                                       if (Math.random() < 0.1) {
                                          if (world instanceof ServerLevel) {
                                             ServerLevel _serverLevel = (ServerLevel)world;
                                             Entity entityinstance = EntityType.f_20450_.m_20615_(_serverLevel);
                                             if (entityinstance != null) {
                                                CompoundTag _compoundTag = entityinstance.m_20240_(new CompoundTag());
                                                _compoundTag.m_128365_("BlockState", NbtUtils.m_129202_(block_a));
                                                entityinstance.m_20258_(_compoundTag);
                                                entityinstance.m_6034_((double)Math.round(x_pos) + 0.5, (double)Math.round(y_pos), (double)Math.round(z_pos) + 0.5);
                                                if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                                                   entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Time:560,DropItem:0b,HurtEntities:0b}");
                                                }

                                                _serverLevel.m_7967_(entityinstance);
                                             }
                                          }
                                       } else if (type_flame && Math.random() < 0.1 && world instanceof ServerLevel) {
                                          ServerLevel _level = (ServerLevel)world;
                                          FallingBlockEntity.m_201971_(_level, BlockPos.m_274561_((double)Math.round(x_pos) + 0.5, (double)Math.round(y_pos), (double)Math.round(z_pos) + 0.5), Blocks.f_50083_.m_49966_());
                                       }
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
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
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
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
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
