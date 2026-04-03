package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.List;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

public class DomainExpansionBattleProcedure {
   public DomainExpansionBattleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a;
         double domain_num;
         double var10000;
         label411: {
            logic_a = false;
            boolean failed = false;
            boolean noBarrier = false;
            Entity entity_a = null;
            double x_dis = 0.0;
            double x_dis_p = 0.0;
            double cnt2 = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double z_dis = 0.0;
            domain_num = 0.0;
            double z_pos = 0.0;
            double dis_p = 0.0;
            double dis = 0.0;
            double loop_num = 0.0;
            double y_floor = 0.0;
            double y_dis_p = 0.0;
            double y_pos = 0.0;
            double y_dis = 0.0;
            double z_dis_p = 0.0;
            double close_type = 0.0;
            double speed = 0.0;
            String inside = "";
            String outside = "";
            String old_block = "";
            String floor = "";
            String cnt_type = "";
            BlockState blockstate1 = Blocks.AIR.defaultBlockState();
            domain_num = entity.getPersistentData().getDouble("skill_domain") > 0.0 ? entity.getPersistentData().getDouble("skill_domain") : entity.getPersistentData().getDouble("select");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                        break label411;
                     }
                  }

                  var10000 = 0.0;
                  break label411;
               }
            }

            var10000 = entity.getPersistentData().getDouble("cnt2");
         }

         double var101 = var10000;
         GetDomainBlockProcedure.execute(entity);
         String var104 = entity.getPersistentData().getString("domain_outside");
         String var103 = entity.getPersistentData().getString("domain_inside");
         String var107 = entity.getPersistentData().getString("domain_floor");
         boolean var65 = var101 > 0.0;
         boolean var64 = entity.getPersistentData().getBoolean("Failed") && !entity.getPersistentData().getBoolean("Cover");
         if (var64 && entity instanceof LivingEntity) {
            LivingEntity _livEnt11 = (LivingEntity)entity;
            if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
               double var73 = 5.0;
               double var75 = (double)Math.round(x - var73);

               for(int index0 = 0; index0 < (int)Math.round(var73 * 2.0); ++index0) {
                  double var66 = (double)Math.round(x) - var75;
                  var66 *= var66;
                  double var92 = (double)Math.round(y - var73);

                  for(int index1 = 0; index1 < (int)Math.round(var73 * 2.0); ++index1) {
                     double var95 = (double)Math.round(y) - var92;
                     var95 *= var95;
                     double var83 = (double)Math.round(z - var73);

                     for(int index2 = 0; index2 < (int)Math.round(var73 * 2.0); ++index2) {
                        double var78 = (double)Math.round(z) - var83;
                        var78 *= var78;
                        if (Math.random() < 0.1) {
                           BlockPos currentPos = BlockPos.containing(var75, var92, var83);
                           BlockState var109 = world.getBlockState(currentPos);
                           if (var109.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))) && var109.getBlock() != JujutsucraftModBlocks.IN_BARRIER.get() && var109.getBlock() != JujutsucraftModBlocks.JUJUTSU_BARRIER.get()) {
                              var104 = ("" + String.valueOf(var109)).replace("}", "").replace("Block{", "");
                              if (!var107.equals(var104)) {
                                 logic_a = true;
                                 if (!world.isClientSide()) {
                                    BlockEntity be = world.getBlockEntity(currentPos);
                                    String var105 = be != null ? be.getPersistentData().getString("old_block") : "";
                                    placeBlockSafe(world, currentPos, var107);
                                    BlockEntity newBe = world.getBlockEntity(currentPos);
                                    if (newBe != null) {
                                       newBe.getPersistentData().putString("old_block", var105);
                                    }
                                 }
                                 break;
                              }
                           }
                        }

                        ++var83;
                     }

                     ++var92;
                     if (logic_a) {
                        break;
                     }
                  }

                  ++var75;
                  if (logic_a) {
                     break;
                  }
               }
            }
         }

         if (!var64) {
            double var76 = entity.getPersistentData().getDouble("x_pos_doma");
            double var93 = entity.getPersistentData().getDouble("y_pos_doma");
            double var84 = entity.getPersistentData().getDouble("z_pos_doma");
            if (var101 <= 0.0 && (entity.getPersistentData().getDouble("cnt1") <= 1.0 || entity.getPersistentData().getDouble("cnt_cover") <= 1.0)) {
               List<DomainExpansionEntityEntity> domainEntities = world.getEntitiesOfClass(DomainExpansionEntityEntity.class, new AABB(var76 - 0.1, var93 - 0.1, var84 - 0.1, var76 + 0.1, var93 + 0.1, var84 + 0.1), (e) -> true);
               if (!domainEntities.isEmpty()) {
                  DomainExpansionEntityEntity d_ent = (DomainExpansionEntityEntity)domainEntities.get(0);
                  if (!d_ent.getPersistentData().getBoolean("Break") && !d_ent.level().isClientSide()) {
                     d_ent.discard();
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.DOMAIN_EXPANSION_ENTITY.get()).spawn(_level, BlockPos.containing(var76, var93, var84), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                  }
               }
            }

            byte var126;
            if (domain_num == 29.0) {
               var126 = 10;
            } else {
               label432: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)entity;
                     if (le.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        var126 = 3;
                        break label432;
                     }
                  }

                  var126 = 1;
               }
            }

            double var102 = (double)var126;
            double var74 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            double var88 = (double)Math.round(var74 * 2.0 + 1.0);
            String var108 = entity.getPersistentData().getBoolean("Cover") ? "cnt_cover" : "cnt1";
            double var72 = entity.getPersistentData().getDouble(var108) * var102;
            if (var72 - var102 + 1.0 <= var88) {
               double var89 = entity.getPersistentData().getDouble("y_pos_doma") - 1.0;
               var76 = (double)Math.round(x) - var74;

               for(int index3 = 0; index3 < (int)var88; ++index3) {
                  double var68 = (double)Math.round(x) - var76;
                  var68 *= var68;
                  double var70 = var76 - (double)Math.round(entity.getPersistentData().getDouble("x_pos_doma2"));
                  var70 *= var70;
                  if (var70 <= var72 * var72) {
                     var93 = (double)Math.round(y) - var74;

                     for(int index4 = 0; index4 < (int)var88; ++index4) {
                        double var97 = (double)Math.round(y) - var93;
                        var97 *= var97;
                        double var90 = var93 - (double)Math.round(entity.getPersistentData().getDouble("y_pos_doma2"));
                        var90 *= var90;
                        if (var90 <= var72 * var72 && var93 >= -64.0 && var93 <= 319.0) {
                           var84 = (double)Math.round(z) - var74;

                           for(int index5 = 0; index5 < (int)var88; ++index5) {
                              double var80 = (double)Math.round(z) - var84;
                              var80 *= var80;
                              double var99 = var84 - (double)Math.round(entity.getPersistentData().getDouble("z_pos_doma2"));
                              var99 *= var99;
                              if (var99 <= var72 * var72) {
                                 double var86 = var70 + var90 + var99;
                                 if (var86 <= var72 * var72 && var86 >= (var72 - var102) * (var72 - var102)) {
                                    double var87 = var68 + var80 + var97;
                                    if (var87 < (var74 + 0.5) * (var74 + 0.5)) {
                                       BlockPos currentPos = BlockPos.containing(var76, var93, var84);
                                       BlockState var110 = world.getBlockState(currentPos);
                                       String var106;
                                       if (var110.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                                          BlockEntity be = world.getBlockEntity(currentPos);
                                          var106 = be != null ? be.getPersistentData().getString("old_block") : "";
                                       } else {
                                          var106 = ("" + String.valueOf(var110)).replace("}", "").replace("Block{", "");
                                       }

                                       if (var65) {
                                          if (entity.getPersistentData().getBoolean("Cover") && var110.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                                             placeBlockSafe(world, currentPos, var93 <= var89 ? var106 : var103);
                                          }
                                       } else {
                                          logic_a = false;
                                          if (var110.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                                             logic_a = true;
                                          } else if (!(var93 > var89 - (double)(domain_num != 8.0 && domain_num != 21.0 ? 1 : 2)) && (!(var87 < (var74 + 0.0) * (var74 + 0.0)) || !(var87 >= (var74 - 1.0) * (var74 - 1.0)))) {
                                             if (!var110.canOcclude()) {
                                                logic_a = true;
                                             } else if (world.getBlockState(currentPos.east()).canOcclude() && world.getBlockState(currentPos.west()).canOcclude()) {
                                                if (world.getBlockState(currentPos.above()).canOcclude() && world.getBlockState(currentPos.below()).canOcclude()) {
                                                   if (!world.getBlockState(currentPos.south()).canOcclude() || !world.getBlockState(currentPos.north()).canOcclude()) {
                                                      logic_a = true;
                                                   }
                                                } else {
                                                   logic_a = true;
                                                }
                                             } else {
                                                logic_a = true;
                                             }
                                          } else {
                                             logic_a = true;
                                          }

                                          if (logic_a) {
                                             if (var87 < var74 * var74) {
                                                if (var87 >= (var74 - 1.0) * (var74 - 1.0)) {
                                                   placeBlockSafe(world, currentPos, var104);
                                                } else if (var87 >= (var74 - 2.0) * (var74 - 2.0)) {
                                                   if (domain_num == 1.0) {
                                                      if (var93 != var89 && Math.abs(var76 - (double)Math.round(x)) % 5.0 != 2.0) {
                                                         placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:in_barrier");
                                                      } else {
                                                         placeBlockSafe(world, currentPos, var103);
                                                      }
                                                   } else if (domain_num == 15.0) {
                                                      if (var93 != var89 && Math.abs(var76 - (double)Math.round(x)) % 5.0 != 2.0 && Math.abs(var93 - (double)Math.round(y)) % 5.0 != 2.0 && Math.abs(var84 - (double)Math.round(z)) % 5.0 != 4.0) {
                                                         placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:in_barrier");
                                                      } else {
                                                         placeBlockSafe(world, currentPos, var103);
                                                      }
                                                   } else {
                                                      placeBlockSafe(world, currentPos, var103);
                                                   }
                                                } else if (var93 <= var89) {
                                                   if (var93 >= var89 - 4.0) {
                                                      if (domain_num == 8.0) {
                                                         if (var86 < var74 * 0.675 * var74 * 0.675) {
                                                            placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:domain_grass");
                                                         } else if (!(var86 < var74 * 0.9 * var74 * 0.9) && !(var93 < var89 - 0.5)) {
                                                            placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:domain_water");
                                                         } else {
                                                            placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:domain_sand");
                                                         }
                                                      } else if (domain_num == 21.0) {
                                                         if (var93 < var89 - 0.5) {
                                                            if (var76 > x + var74 * 0.5 && var93 >= var89 - 1.5) {
                                                               placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:domain_water");
                                                            } else {
                                                               placeBlockSafe(world, currentPos, var107);
                                                            }
                                                         } else if (var76 < x + var74 * 0.5 - 0.0 && var76 >= x + var74 * 0.5 - 1.0) {
                                                            placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:domain_fence");
                                                         } else {
                                                            placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:in_barrier");
                                                         }
                                                      } else if (domain_num == 27.0) {
                                                         placeBlockSafe(world, currentPos, var87 < var74 * 0.5 * var74 * 0.5 ? var107 : "gaigegaigekaigecraft:domain_stone_bricks");
                                                      } else {
                                                         placeBlockSafe(world, currentPos, var107);
                                                      }
                                                   } else {
                                                      logic_a = false;
                                                   }
                                                } else if (!world.isEmptyBlock(currentPos)) {
                                                   if (var101 < 0.0 && !entity.getPersistentData().getBoolean("Cover") && !entity.getPersistentData().getBoolean("Failed")) {
                                                      placeBlockSafe(world, currentPos, var107);
                                                   } else {
                                                      placeBlockSafe(world, currentPos, "gaigegaigekaigecraft:in_barrier");
                                                   }
                                                } else {
                                                   logic_a = false;
                                                }
                                             } else {
                                                logic_a = false;
                                             }
                                          }

                                          if ((var93 <= var89 || var87 < var74 * var74 && var87 >= (var74 - 2.0) * (var74 - 2.0)) && !world.isClientSide()) {
                                             for(Entity ent : world.getEntitiesOfClass(Entity.class, new AABB(var76, var93, var84, var76 + 1.0, var93 + 1.0, var84 + 1.0), (e) -> true)) {
                                                if (!ent.isInvulnerable() && !ent.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                                                   ent.teleportTo(ent.getX(), var89 + 1.0, ent.getZ());
                                                   if (ent instanceof ServerPlayer) {
                                                      ServerPlayer _serverPlayer = (ServerPlayer)ent;
                                                      _serverPlayer.connection.teleport(ent.getX(), var89 + 1.0, ent.getZ(), ent.getYRot(), ent.getXRot());
                                                   }
                                                }
                                             }
                                          }

                                          if (logic_a && world.getBlockState(currentPos).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))) && !world.isClientSide()) {
                                             BlockEntity _blockEntity = world.getBlockEntity(currentPos);
                                             if (_blockEntity != null) {
                                                _blockEntity.getPersistentData().putString("old_block", var106);
                                             }
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var84;
                           }
                        }

                        ++var93;
                     }
                  }

                  ++var76;
               }
            } else {
               entity.getPersistentData().putDouble(var108, entity.getPersistentData().getDouble(var108) < 34.0 ? 34.0 : Math.max(entity.getPersistentData().getDouble(var108), var88));
            }
         }

      }
   }

   private static void placeBlockSafe(LevelAccessor world, BlockPos pos, String blockName) {
      if (!world.isClientSide() && blockName != null && !blockName.isEmpty()) {
         try {
            BlockStateParser.BlockResult result = BlockStateParser.parseForBlock(world.holderLookup(Registries.BLOCK), blockName, true);
            world.setBlock(pos, result.blockState(), 3);
         } catch (Exception var7) {
            String cleanName = blockName.contains("[") ? blockName.substring(0, blockName.indexOf("[")) : blockName;
            ResourceLocation res = new ResourceLocation(cleanName.contains(":") ? cleanName : "minecraft:" + cleanName);
            Block block = (Block)ForgeRegistries.BLOCKS.getValue(res);
            if (block != null) {
               world.setBlock(pos, block.defaultBlockState(), 3);
            }
         }
      }

   }
}
