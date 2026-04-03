package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BlackHoleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FlameArrowEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone1Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone3Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone4Entity;
import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PureLoveCannonEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PurpleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UzumakiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockDestroyAllDirectionProcedure {
   public BlockDestroyAllDirectionProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState block_a = Blocks.AIR.defaultBlockState();
         boolean insideBarrier = false;
         boolean type_flame = false;
         boolean logic_success = false;
         boolean rock = false;
         boolean wood = false;
         boolean logic_water = false;
         boolean glass = false;
         boolean logic_a = false;
         boolean water = false;
         Entity entity_a = null;
         double x_dis = 0.0;
         double damage = 0.0;
         double distance = 0.0;
         double cnt_x = 0.0;
         double x_pos = 0.0;
         double knockback = 0.0;
         double speed = 0.0;
         double num1 = 0.0;
         double y_pos = 0.0;
         double y_dis = 0.0;
         double z_dis = 0.0;
         double z_pos = 0.0;
         double hardness = 0.0;
         double RANGE = 0.0;
         String destroy_type = "";
         String old_block = "";
         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
               logic_a = true;
               ((GameRules.BooleanValue)world.getLevelData().getGameRules().getRule(GameRules.RULE_DOBLOCKDROPS)).set(false, world.getServer());
            }

            logic_water = true;
            if (entity instanceof Gravestone1Entity || entity instanceof Gravestone2Entity || entity instanceof Gravestone3Entity || entity instanceof Gravestone4Entity) {
               logic_water = false;
            }

            if (entity instanceof RockFragmentEntity) {
               logic_water = false;
            }

            if (entity.getPersistentData().getDouble("effect") == 3.0) {
               type_flame = true;
            }

            label419: {
               label437: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt9 = (LivingEntity)entity;
                     if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label437;
                     }
                  }

                  int var10000;
                  label413: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                           break label413;
                        }
                     }

                     var10000 = 0;
                  }

                  if (var10000 < 10) {
                     break label419;
                  }
               }

               insideBarrier = true;
            }

            if (!insideBarrier) {
               label453: {
                  if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  }

                  if (!(entity_a instanceof LivingEntity)) {
                     entity_a = entity;
                  }

                  label439: {
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _livEnt16 = (LivingEntity)entity_a;
                        if (_livEnt16.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break label439;
                        }
                     }

                     int var98;
                     label396: {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity_a;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var98 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                              break label396;
                           }
                        }

                        var98 = 0;
                     }

                     if (var98 < 10) {
                        break label453;
                     }
                  }

                  insideBarrier = true;
               }
            }

            if (insideBarrier) {
               label386: {
                  if (!(entity instanceof PurpleEntity) && !(entity instanceof FlameArrowEntity)) {
                     label383: {
                        if (entity instanceof ProjectileSlashEntity) {
                           int var99;
                           if (entity instanceof ProjectileSlashEntity) {
                              ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                              var99 = (Integer)_datEntI.getEntityData().get(ProjectileSlashEntity.DATA_mode);
                           } else {
                              var99 = 0;
                           }

                           if (var99 == 1) {
                              break label383;
                           }
                        }

                        if (!(entity instanceof PureLoveCannonEntity) && !(entity instanceof UzumakiEntity) && !(entity instanceof MeteorEntity)) {
                           break label386;
                        }
                     }
                  }

                  insideBarrier = false;
               }

               if (entity instanceof BlackHoleEntity) {
                  insideBarrier = false;
               }
            }

            knockback = entity.getPersistentData().getDouble("knockback");
            damage = entity.getPersistentData().getDouble("BlockDamage");
            RANGE = entity.getPersistentData().getDouble("BlockRange");
            RANGE = (double)Math.round(RANGE >= 1.0 ? RANGE * 2.0 : 1.0);
            if (!entity.getPersistentData().getBoolean("noParticle") && !(RANGE >= 6.0)) {
               String var101 = "destroy";
            } else {
               String var100 = "replace";
            }

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
                     BlockPos currentPos = BlockPos.containing(x_pos, y_pos, z_pos);
                     if (!world.isEmptyBlock(currentPos)) {
                        block_a = world.getBlockState(currentPos);
                        hardness = (double)block_a.getDestroySpeed(world, currentPos);
                        z_dis = z_pos - z;
                        z_dis *= z_dis;
                        distance = x_dis + y_dis + z_dis;
                        if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:logs"))) || block_a.is(BlockTags.create(new ResourceLocation("minecraft:planks")))) {
                           hardness *= 0.5;
                        }

                        label348: {
                           logic_success = false;
                           if (!(block_a.getBlock() instanceof LiquidBlock)) {
                              Property var55 = block_a.getBlock().getStateDefinition().getProperty("waterlogged");
                              if (!(var55 instanceof BooleanProperty)) {
                                 break label348;
                              }

                              BooleanProperty _getbp33 = (BooleanProperty)var55;
                              if (!(Boolean)block_a.getValue(_getbp33)) {
                                 break label348;
                              }
                           }

                           logic_success = true;
                        }

                        if (hardness >= 0.0 && hardness < damage) {
                           logic_success = true;
                        }

                        if (block_a.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                           if (insideBarrier) {
                              logic_success = false;
                           } else if (damage >= 1.5) {
                              logic_success = true;
                           }
                        }

                        if (logic_success && distance <= Math.max(RANGE * 0.5, 1.0) * Math.max(RANGE * 0.5, 1.0)) {
                           distance = Math.sqrt(distance);
                           cnt_x = 0.0;
                           if (world.getBlockState(currentPos.east()).canOcclude() || world.getBlockState(currentPos.east()).getFluidState().isSource()) {
                              cnt_x += 2.0;
                           }

                           if (world.getBlockState(currentPos.west()).canOcclude() || world.getBlockState(currentPos.west()).getFluidState().isSource()) {
                              cnt_x += 2.0;
                           }

                           if (world.getBlockState(currentPos.south()).canOcclude() || world.getBlockState(currentPos.south()).getFluidState().isSource()) {
                              cnt_x += 2.0;
                           }

                           if (world.getBlockState(currentPos.north()).canOcclude() || world.getBlockState(currentPos.north()).getFluidState().isSource()) {
                              cnt_x += 2.0;
                           }

                           if (!block_a.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                              if (world.getBlockState(currentPos.above()).canOcclude() || world.getBlockState(currentPos.above()).getFluidState().isSource()) {
                                 ++cnt_x;
                              }

                              if (world.getBlockState(currentPos.below()).canOcclude() || world.getBlockState(currentPos.below()).getFluidState().isSource()) {
                                 ++cnt_x;
                              }
                           }

                           if (block_a.getBlock() == Blocks.WATER && cnt_x < 10.0) {
                              if (knockback >= 0.0) {
                                 ParticleGeneratorProcedure.execute(world, 1.0, 4.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.5, 5.0) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + Math.abs(y_pos - y), z_pos, z_pos + z_pos - z, "gaigegaigekaigecraft:particle_water");
                              } else if (knockback < 0.0) {
                                 ParticleGeneratorProcedure.execute(world, 1.0, 4.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.05, 0.5) * distance, x_pos, x, y_pos, y, z_pos, z, "gaigegaigekaigecraft:particle_water");
                              }

                              if (knockback >= 1.0) {
                                 water = true;
                              }
                           }

                           if (cnt_x < 8.0) {
                              label460: {
                                 if (!(block_a.getBlock() instanceof LiquidBlock)) {
                                    label461: {
                                       Property var95 = block_a.getBlock().getStateDefinition().getProperty("waterlogged");
                                       if (var95 instanceof BooleanProperty) {
                                          BooleanProperty _getbp39 = (BooleanProperty)var95;
                                          if ((Boolean)block_a.getValue(_getbp39)) {
                                             break label461;
                                          }
                                       }

                                       if (!block_a.is(BlockTags.create(new ResourceLocation("minecraft:impermeable"))) && type_flame) {
                                          if (knockback >= 0.0) {
                                             ParticleGeneratorProcedure.execute(world, 1.0, 1.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.5, 5.0) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + y_pos - y, z_pos, z_pos + z_pos - z, "gaigegaigekaigecraft:particle_magma");
                                          } else if (knockback < 0.0) {
                                             ParticleGeneratorProcedure.execute(world, 1.0, 1.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.2, 2.0) * distance, x_pos, x, y_pos, y, z_pos, z, "gaigegaigekaigecraft:particle_magma");
                                          }
                                       }

                                       if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))) {
                                          if (knockback >= 0.0) {
                                             ParticleGeneratorProcedure.execute(world, 1.0, 1.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.1, 1.0) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + y_pos - y, z_pos, z_pos + z_pos - z, "gaigegaigekaigecraft:particle_big_smoke");
                                          } else if (knockback < 0.0) {
                                             ParticleGeneratorProcedure.execute(world, 1.0, 1.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.01, 0.1) * distance, x_pos, x, y_pos, y, z_pos, z, "gaigegaigekaigecraft:particle_big_smoke");
                                          }

                                          rock = true;
                                       } else if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:mineable/axe"))) && hardness > 0.0) {
                                          wood = true;
                                       } else if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:impermeable"))) || block_a.getBlock() == JujutsucraftModBlocks.JUJUTSU_BARRIER.get()) {
                                          if (knockback >= 0.0) {
                                             ParticleGeneratorProcedure.execute(world, 1.0, 4.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.2, 2.0) * knockback, x_pos, x_pos + x_pos - x, y_pos, y_pos + y_pos - y, z_pos, z_pos + z_pos - z, "gaigegaigekaigecraft:particle_broken_glass_small");
                                          } else if (knockback < 0.0) {
                                             ParticleGeneratorProcedure.execute(world, 1.0, 4.0, 10.0, Mth.nextDouble(RandomSource.create(), 0.025, 0.25) * distance, x_pos, x, y_pos, y, z_pos, z, "gaigegaigekaigecraft:particle_broken_glass_small");
                                          }

                                          glass = true;
                                       }

                                       if (block_a.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                                          if (!world.isClientSide()) {
                                             BlockEntity be = world.getBlockEntity(currentPos);
                                             old_block = be != null ? be.getPersistentData().getString("old_block") : "";
                                             world.setBlock(currentPos, ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("gaigegaigekaigecraft:domain_hole"))).defaultBlockState(), 3);
                                             BlockEntity newBe = world.getBlockEntity(currentPos);
                                             if (newBe != null) {
                                                newBe.getPersistentData().putString("old_block", old_block);
                                                newBe.getPersistentData().putString("old_barrier", ("" + String.valueOf(block_a)).replace("}", "").replace("Block{", ""));
                                                newBe.getPersistentData().putDouble("delay_time", distance);
                                             }
                                          }
                                       } else if (!world.isClientSide()) {
                                          world.setBlock(currentPos, Blocks.AIR.defaultBlockState(), 3);
                                       }

                                       if (!entity.getPersistentData().getBoolean("ExtinctionBlock")) {
                                          double spawnChance = 0.0;
                                          if (type_flame && Math.random() < 0.1 + spawnChance) {
                                             block_a = Blocks.FIRE.defaultBlockState();
                                          } else if (!block_a.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))) && Math.random() < 0.1 + spawnChance) {
                                             block_a = block_a;
                                          } else {
                                             block_a = Blocks.AIR.defaultBlockState();
                                          }

                                          if (!block_a.isAir() && !block_a.is(BlockTags.create(new ResourceLocation("minecraft:impermeable")))) {
                                             speed = Mth.nextDouble(RandomSource.create(), 0.1, 1.0) * Math.min(knockback * 1.0, 3.0);
                                             if (world instanceof ServerLevel) {
                                                ServerLevel _serverLevel = (ServerLevel)world;
                                                Entity entityinstance = EntityType.FALLING_BLOCK.create(_serverLevel);
                                                if (entityinstance != null) {
                                                   CompoundTag _compoundTag = entityinstance.saveWithoutId(new CompoundTag());
                                                   _compoundTag.put("BlockState", NbtUtils.writeBlockState(block_a));
                                                   entityinstance.load(_compoundTag);
                                                   entityinstance.setPos((double)Math.round(x_pos) + 0.5, (double)Math.round(y_pos), (double)Math.round(z_pos) + 0.5);
                                                   if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                                                      entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Time:560,DropItem:0b,HurtEntities:0b}");
                                                   }

                                                   if (distance != 0.0) {
                                                      entityinstance.setDeltaMovement(new Vec3((x_pos - x) / distance * speed + entity.getPersistentData().getDouble("x_knockback"), (y_pos - y) / distance * speed + entity.getPersistentData().getDouble("y_knockback"), (z_pos - z) / distance * speed + entity.getPersistentData().getDouble("z_knockback")));
                                                   }

                                                   _serverLevel.addFreshEntity(entityinstance);
                                                }
                                             }
                                          }
                                       }
                                       break label460;
                                    }
                                 }

                                 if (logic_water) {
                                    if (!world.isClientSide()) {
                                       world.setBlock(currentPos, Blocks.AIR.defaultBlockState(), 3);
                                    }

                                    water = true;
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
               float pitch = (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1);
               if (rock && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:stone_crash")), SoundSource.NEUTRAL, 1.0F, pitch);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:stone_crash")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                  }
               }

               if (wood && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, pitch);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                  }
               }

               if (glass && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, pitch);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                  }
               }

               if (water && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:water_splash")), SoundSource.NEUTRAL, 1.0F, pitch);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:water_splash")), SoundSource.NEUTRAL, 1.0F, pitch, false);
                  }
               }
            }

            if (logic_a) {
               ((GameRules.BooleanValue)world.getLevelData().getGameRules().getRule(GameRules.RULE_DOBLOCKDROPS)).set(true, world.getServer());
            }
         }

         entity.getPersistentData().putDouble("BlockRange", 0.0);
         entity.getPersistentData().putDouble("BlockDamage", 0.0);
         entity.getPersistentData().putDouble("effect", 0.0);
         entity.getPersistentData().putBoolean("noParticle", false);
         entity.getPersistentData().putBoolean("noEffect", false);
         entity.getPersistentData().putBoolean("ExtinctionBlock", false);
      }
   }
}
