package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class DomainExpansionBattleProcedure {
   public DomainExpansionBattleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a;
         double domain_num;
         double var10000;
         label414: {
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
            BlockState blockstate1 = Blocks.f_50016_.m_49966_();
            BlockState blockstate2 = Blocks.f_50016_.m_49966_();
            domain_num = entity.getPersistentData().m_128459_("skill_domain") > 0.0 ? entity.getPersistentData().m_128459_("skill_domain") : entity.getPersistentData().m_128459_("select");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                        break label414;
                     }
                  }

                  var10000 = 0.0;
                  break label414;
               }
            }

            var10000 = entity.getPersistentData().m_128459_("cnt2");
         }

         double var104 = var10000;
         GetDomainBlockProcedure.execute(entity);
         String var107 = entity.getPersistentData().m_128461_("domain_outside");
         String var106 = entity.getPersistentData().m_128461_("domain_inside");
         String var110 = entity.getPersistentData().m_128461_("domain_floor");
         boolean var66 = var104 > 0.0;
         boolean var65 = entity.getPersistentData().m_128471_("Failed") && !entity.getPersistentData().m_128471_("Cover");
         if (var65 && entity instanceof LivingEntity) {
            LivingEntity _livEnt11 = (LivingEntity)entity;
            if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
               double var76 = 5.0;
               double var78 = (double)Math.round(x - var76);

               for(int index0 = 0; index0 < (int)Math.round(var76 * 2.0); ++index0) {
                  double var68 = (double)Math.round(x) - var78;
                  var68 *= var68;
                  double var95 = (double)Math.round(y - var76);

                  for(int index1 = 0; index1 < (int)Math.round(var76 * 2.0); ++index1) {
                     double var98 = (double)Math.round(y) - var95;
                     var98 *= var98;
                     double var86 = (double)Math.round(z - var76);

                     for(int index2 = 0; index2 < (int)Math.round(var76 * 2.0); ++index2) {
                        double var81 = (double)Math.round(z) - var86;
                        var81 *= var81;
                        if (Math.random() < 0.1) {
                           BlockState var112 = world.m_8055_(BlockPos.m_274561_(var78, var95, var86));
                           if (var112.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && var112.m_60734_() != JujutsucraftModBlocks.IN_BARRIER.get() && var112.m_60734_() != JujutsucraftModBlocks.JUJUTSU_BARRIER.get()) {
                              var107 = ("" + String.valueOf(var112)).replace("}", "").replace("Block{", "");
                              if (!var110.equals(var107)) {
                                 logic_a = true;
                                 String var108 = ((<undefinedtype>)(new Object() {
                                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                       BlockEntity blockEntity = world.m_7702_(pos);
                                       return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                                    }
                                 })).getValue(world, BlockPos.m_274561_(var78, var95, var86), "old_block");
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var78, var95, var86), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + var110);
                                 }

                                 if (!world.m_5776_()) {
                                    BlockPos _bp = BlockPos.m_274561_(var78, var95, var86);
                                    BlockEntity _blockEntity = world.m_7702_(_bp);
                                    BlockState _bs = world.m_8055_(_bp);
                                    if (_blockEntity != null) {
                                       _blockEntity.getPersistentData().m_128359_("old_block", var108);
                                    }

                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       _level.m_7260_(_bp, _bs, _bs, 3);
                                    }
                                 }

                                 if (Math.random() < 0.01) {
                                    world.m_46796_(2001, BlockPos.m_274561_(var78, var95, var86), Block.m_49956_(var112));
                                 }
                                 break;
                              }
                           }
                        }

                        ++var86;
                     }

                     ++var95;
                     if (logic_a) {
                        break;
                     }
                  }

                  ++var78;
                  if (logic_a) {
                     break;
                  }
               }
            }
         }

         if (!var65) {
            double var79 = entity.getPersistentData().m_128459_("x_pos_doma");
            double var96 = entity.getPersistentData().m_128459_("y_pos_doma");
            double var87 = entity.getPersistentData().m_128459_("z_pos_doma");
            if (var104 <= 0.0 && (entity.getPersistentData().m_128459_("cnt1") <= 1.0 || entity.getPersistentData().m_128459_("cnt_cover") <= 1.0)) {
               if (!world.m_6443_(DomainExpansionEntityEntity.class, AABB.m_165882_(new Vec3(var79, var96, var87), 0.1, 0.1, 0.1), (e) -> true).isEmpty()) {
                  Entity var67 = (Entity)world.m_6443_(DomainExpansionEntityEntity.class, AABB.m_165882_(new Vec3(var79, var96, var87), 0.1, 0.1, 0.1), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                     Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                     }
                  })).compareDistOf(var79, var96, var87)).findFirst().orElse((Object)null);
                  if (!var67.getPersistentData().m_128471_("Break") && !var67.m_9236_().m_5776_()) {
                     var67.m_146870_();
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.DOMAIN_EXPANSION_ENTITY.get()).m_262496_(_level, BlockPos.m_274561_(var79, var96, var87), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  }
               }
            }

            double var105 = 1.0;
            if (domain_num == 29.0) {
               var105 = 10.0;
            } else if (entity instanceof LivingEntity) {
               LivingEntity _livEnt30 = (LivingEntity)entity;
               if (_livEnt30.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                  var105 = 3.0;
               }
            }

            double var77 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            double var91 = (double)Math.round(var77 * 2.0 + 1.0);
            String var111 = entity.getPersistentData().m_128471_("Cover") ? "cnt_cover" : "cnt1";
            double var74 = entity.getPersistentData().m_128459_(var111);
            var74 *= var105;
            if (var74 - var105 + 1.0 <= var91) {
               double var92 = entity.getPersistentData().m_128459_("y_pos_doma") - 1.0;
               var79 = (double)Math.round(x) - var77;

               for(int index3 = 0; index3 < (int)var91; ++index3) {
                  double var70 = (double)Math.round(x) - var79;
                  var70 *= var70;
                  double var72 = var79 - (double)Math.round(entity.getPersistentData().m_128459_("x_pos_doma2"));
                  var72 *= var72;
                  if (Math.sqrt(var72) <= var74) {
                     var96 = (double)Math.round(y) - var77;

                     for(int index4 = 0; index4 < (int)var91; ++index4) {
                        double var100 = (double)Math.round(y) - var96;
                        var100 *= var100;
                        double var93 = var96 - (double)Math.round(entity.getPersistentData().m_128459_("y_pos_doma2"));
                        var93 *= var93;
                        if (Math.sqrt(var93) <= var74 && var96 >= -64.0 && var96 <= 319.0) {
                           var87 = (double)Math.round(z) - var77;

                           for(int index5 = 0; index5 < (int)var91; ++index5) {
                              double var83 = (double)Math.round(z) - var87;
                              var83 *= var83;
                              double var102 = var87 - (double)Math.round(entity.getPersistentData().m_128459_("z_pos_doma2"));
                              var102 *= var102;
                              if (Math.sqrt(var102) <= var74) {
                                 double var89 = Math.sqrt(var72 + var93 + var102);
                                 if (var89 <= var74 + 0.0 && var89 >= var74 - var105) {
                                    double var90 = Math.sqrt(var70 + var83 + var100);
                                    if (var90 < var77 + 0.5) {
                                       BlockState var113 = world.m_8055_(BlockPos.m_274561_(var79, var96, var87));
                                       String var109 = var113.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) ? ((<undefinedtype>)(new Object() {
                                          public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                             BlockEntity blockEntity = world.m_7702_(pos);
                                             return blockEntity != null ? blockEntity.getPersistentData().m_128461_(tag) : "";
                                          }
                                       })).getValue(world, BlockPos.m_274561_(var79, var96, var87), "old_block") : ("" + String.valueOf(var113)).replace("}", "").replace("Block{", "");
                                       if (var66) {
                                          if (entity.getPersistentData().m_128471_("Cover") && var113.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && world instanceof ServerLevel) {
                                             ServerLevel _level = (ServerLevel)world;
                                             _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + (var96 <= var92 ? var109 : var106));
                                          }
                                       } else {
                                          logic_a = false;
                                          if (var113.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                                             logic_a = true;
                                          } else if (var96 > var92 - 1.0) {
                                             logic_a = true;
                                          } else if (!world.m_8055_(BlockPos.m_274561_(var79, var96, var87)).m_60815_()) {
                                             logic_a = true;
                                          } else if (world.m_8055_(BlockPos.m_274561_(var79 + 1.0, var96, var87)).m_60815_() && world.m_8055_(BlockPos.m_274561_(var79 - 1.0, var96, var87)).m_60815_()) {
                                             if (world.m_8055_(BlockPos.m_274561_(var79, var96 + 1.0, var87)).m_60815_() && world.m_8055_(BlockPos.m_274561_(var79, var96 - 1.0, var87)).m_60815_()) {
                                                if (!world.m_8055_(BlockPos.m_274561_(var79, var96, var87 + 1.0)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(var79, var96, var87 - 1.0)).m_60815_()) {
                                                   logic_a = true;
                                                }
                                             } else {
                                                logic_a = true;
                                             }
                                          } else {
                                             logic_a = true;
                                          }

                                          if (logic_a) {
                                             if (var90 < var77 + 0.0) {
                                                if (var90 >= var77 - 1.0) {
                                                   if (world instanceof ServerLevel) {
                                                      ServerLevel _level = (ServerLevel)world;
                                                      _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + var107);
                                                   }
                                                } else if (var90 >= var77 - 2.0) {
                                                   if (domain_num == 1.0) {
                                                      if (var96 != var92 && Math.abs(var79 - (double)Math.round(x)) % 5.0 != 2.0) {
                                                         if (world instanceof ServerLevel) {
                                                            ServerLevel _level = (ServerLevel)world;
                                                            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ jujutsucraft:in_barrier");
                                                         }
                                                      } else if (world instanceof ServerLevel) {
                                                         ServerLevel _level = (ServerLevel)world;
                                                         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + var106);
                                                      }
                                                   } else if (domain_num == 15.0) {
                                                      if (var96 != var92 && Math.abs(var79 - (double)Math.round(x)) % 5.0 != 2.0 && Math.abs(var96 - (double)Math.round(y)) % 5.0 != 2.0 && Math.abs(var87 - (double)Math.round(z)) % 5.0 != 4.0) {
                                                         if (world instanceof ServerLevel) {
                                                            ServerLevel _level = (ServerLevel)world;
                                                            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ jujutsucraft:in_barrier");
                                                         }
                                                      } else if (world instanceof ServerLevel) {
                                                         ServerLevel _level = (ServerLevel)world;
                                                         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + var106);
                                                      }
                                                   } else if (world instanceof ServerLevel) {
                                                      ServerLevel _level = (ServerLevel)world;
                                                      _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + var106);
                                                   }
                                                } else if (var96 <= var92) {
                                                   if (var96 >= var92 - 4.0) {
                                                      if (domain_num == 8.0) {
                                                         if (var89 < var77 * 0.675) {
                                                            if (world instanceof ServerLevel) {
                                                               ServerLevel _level = (ServerLevel)world;
                                                               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ jujutsucraft:domain_grass");
                                                            }
                                                         } else if (!(var89 < var77 * 0.9) && !(var96 < var92 - 0.5)) {
                                                            if (world instanceof ServerLevel) {
                                                               ServerLevel _level = (ServerLevel)world;
                                                               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ jujutsucraft:domain_water");
                                                            }
                                                         } else if (world instanceof ServerLevel) {
                                                            ServerLevel _level = (ServerLevel)world;
                                                            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ jujutsucraft:domain_sand");
                                                         }
                                                      } else if (domain_num == 27.0) {
                                                         if (world instanceof ServerLevel) {
                                                            ServerLevel _level = (ServerLevel)world;
                                                            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + (var90 < var77 * 0.5 ? var110 : "jujutsucraft:domain_stone_bricks"));
                                                         }
                                                      } else if (world instanceof ServerLevel) {
                                                         ServerLevel _level = (ServerLevel)world;
                                                         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + var110);
                                                      }
                                                   } else {
                                                      logic_a = false;
                                                   }
                                                } else if (!world.m_46859_(BlockPos.m_274561_(var79, var96, var87))) {
                                                   if (var104 < 0.0 && !entity.getPersistentData().m_128471_("Cover") && !entity.getPersistentData().m_128471_("Failed")) {
                                                      if (world instanceof ServerLevel) {
                                                         ServerLevel _level = (ServerLevel)world;
                                                         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ " + var110);
                                                      }
                                                   } else if (world instanceof ServerLevel) {
                                                      ServerLevel _level = (ServerLevel)world;
                                                      _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var79, var96, var87), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ jujutsucraft:in_barrier");
                                                   }
                                                } else {
                                                   logic_a = false;
                                                }
                                             } else {
                                                logic_a = false;
                                             }
                                          }

                                          if (var96 <= var92 || var90 < var77 + 0.0 && var90 >= var77 - 2.0) {
                                             Vec3 _center = new Vec3(var79 + 0.5, var96 + 0.5, var87 + 0.5);

                                             for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                                                if (!entityiterator.m_20147_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                                                   entityiterator.m_6021_(entityiterator.m_20185_(), var92 + 1.0, entityiterator.m_20189_());
                                                   if (entityiterator instanceof ServerPlayer) {
                                                      ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                                                      _serverPlayer.f_8906_.m_9774_(entityiterator.m_20185_(), var92 + 1.0, entityiterator.m_20189_(), entityiterator.m_146908_(), entityiterator.m_146909_());
                                                   }
                                                }
                                             }
                                          }

                                          if (logic_a && world.m_8055_(BlockPos.m_274561_(var79, var96, var87)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && !world.m_5776_()) {
                                             BlockPos _bp = BlockPos.m_274561_(var79, var96, var87);
                                             BlockEntity _blockEntity = world.m_7702_(_bp);
                                             BlockState _bs = world.m_8055_(_bp);
                                             if (_blockEntity != null) {
                                                _blockEntity.getPersistentData().m_128359_("old_block", var109);
                                             }

                                             if (world instanceof Level) {
                                                Level _level = (Level)world;
                                                _level.m_7260_(_bp, _bs, _bs, 3);
                                             }
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var87;
                           }
                        }

                        ++var96;
                     }
                  }

                  ++var79;
               }
            } else {
               entity.getPersistentData().m_128347_(var111, entity.getPersistentData().m_128459_(var111) < 34.0 ? 34.0 : Math.max(entity.getPersistentData().m_128459_(var111), var91));
            }
         }

      }
   }
}
