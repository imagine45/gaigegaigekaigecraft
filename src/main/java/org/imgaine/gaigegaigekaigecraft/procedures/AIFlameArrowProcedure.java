package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.FlameArrowEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFlameArrowProcedure {
   public AIFlameArrowProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a;
         double DUST_AMOUNT;
         double var10000;
         label268: {
            entity_a = null;
            boolean logic_attack = false;
            double strength = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            DUST_AMOUNT = 0.0;
            double x_power = 0.0;
            double num1 = 0.0;
            double y_pos = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label268;
               }
            }

            var10000 = 0.0;
         }

         label272: {
            double var39 = var10000;
            double var44 = 1.0;
            if (entity instanceof FlameArrowEntity) {
               FlameArrowEntity _datEntL1 = (FlameArrowEntity)entity;
               if ((Boolean)_datEntL1.getEntityData().get(FlameArrowEntity.DATA_sync)) {
                  label289: {
                     entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                     double var48 = x - entity.getPersistentData().getDouble("old_x");
                     double var46 = y - entity.getPersistentData().getDouble("old_y");
                     double var47 = z - entity.getPersistentData().getDouble("old_z");
                     if (entity instanceof FlameArrowEntity) {
                        FlameArrowEntity _datEntL33 = (FlameArrowEntity)entity;
                        if ((Boolean)_datEntL33.getEntityData().get(FlameArrowEntity.DATA_sync2)) {
                           if (LogicOwnerExistProcedure.execute(world, entity)) {
                              entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                              if (entity_a instanceof LivingEntity) {
                                 int var74;
                                 label221: {
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var74 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                          break label221;
                                       }
                                    }

                                    var74 = 0;
                                 }

                                 if (var74 > 0 && !entity_a.getPersistentData().getBoolean("Failed")) {
                                    entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), entity_a.getPersistentData().getDouble("dust_amount")));
                                    entity_a.getPersistentData().putDouble("dust_amount", 0.0);
                                 }
                              }
                           }

                           entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                           DUST_AMOUNT = 0.25 + entity.getPersistentData().getDouble("cnt6") / 75.0;
                           var44 = 1.0 + DUST_AMOUNT * 0.1;
                           entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                           double var40 = 16.0 * var44;
                           double var42 = entity.getPersistentData().getDouble("x_pos");
                           double var43 = entity.getPersistentData().getDouble("z_pos");
                           double var50 = entity.getPersistentData().getDouble("y_pos");

                           for(int index1 = 0; (long)index1 < Math.round(20.0 * DUST_AMOUNT + 20.0); ++index1) {
                              double var49 = 8.399999999999999 * var44 * (DUST_AMOUNT + 0.25) * Math.random() * Math.random();
                              ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, var49 * 1.0, var49 * 1.25, Mth.nextDouble(RandomSource.create(), 0.0, 12.0) * (1.0 + DUST_AMOUNT), var42, var42, var50 - var49, var50 + var49, 0.0, var43, var43, "gaigegaigekaigecraft:particle_flame");
                           }

                           for(int index2 = 0; (long)index2 < Math.round(36.0 * (1.0 + DUST_AMOUNT)); ++index2) {
                              ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 4.0, Mth.nextDouble(RandomSource.create(), 2.0, 2.0) * (1.0 + DUST_AMOUNT), var42, var42, var50, var50 + Mth.nextDouble(RandomSource.create(), 0.0, 1.0), 0.0, var43, var43, Math.random() < 0.5 ? "cloud" : "flame");
                              if (DUST_AMOUNT > 1.0 && entity.getPersistentData().getDouble("cnt2") < (var39 - 5.0) * 2.0 * var44 * DUST_AMOUNT) {
                                 ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 4.0, Mth.nextDouble(RandomSource.create(), 4.0, 4.0) * (1.0 + DUST_AMOUNT), var42, var42, var50, var50 + Mth.nextDouble(RandomSource.create(), 0.0, 1.0), 0.0, var43, var43, "gaigegaigekaigecraft:particle_flame");
                              }
                           }

                           if (DUST_AMOUNT > 1.0 && world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(var42, var50, var43), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_flame ~ ~ ~ " + 5.0 * DUST_AMOUNT + " " + 5.0 * DUST_AMOUNT + " " + 5.0 * DUST_AMOUNT + " " + 2.0 * DUST_AMOUNT + " " + Math.round(10.0 * DUST_AMOUNT) + " force");
                           }

                           if (!(entity.getPersistentData().getDouble("cnt2") < 15.0 * var44 * DUST_AMOUNT + 3.0)) {
                              break label289;
                           }

                           entity.getPersistentData().putDouble("Damage", 46.0);
                           entity.getPersistentData().putDouble("Range", 24.0 * var44 * (DUST_AMOUNT + 0.25));
                           entity.getPersistentData().putDouble("projectile_type", 1.0);
                           entity.getPersistentData().putDouble("knockback", 0.5);
                           entity.getPersistentData().putDouble("effect", 3.0);
                           entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                           RangeAttackProcedure.execute(world, var42, var50, var43, entity);
                           entity.getPersistentData().putBoolean("ExtinctionBlock", false);
                           if (entity.getPersistentData().getDouble("cnt2") < 3.0 * var44 * DUST_AMOUNT + 3.0) {
                              if (entity.getPersistentData().getDouble("cnt5") <= Math.min(DUST_AMOUNT, 2.0)) {
                                 entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                                 entity.getPersistentData().putDouble("BlockRange", Math.min(18.0 * var44 * (DUST_AMOUNT + 0.25), 36.0));
                                 entity.getPersistentData().putDouble("BlockDamage", 24.0 * var44);
                                 entity.getPersistentData().putDouble("effect", 3.0);
                                 entity.getPersistentData().putBoolean("noParticle", true);
                                 entity.getPersistentData().putBoolean("noEffect", true);
                                 entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                                 BlockDestroyAllDirectionProcedure.execute(world, var42, var50, var43, entity);
                              }

                              if (entity_a instanceof LivingEntity) {
                                 int var75;
                                 label198: {
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var75 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                          break label198;
                                       }
                                    }

                                    var75 = 0;
                                 }

                                 if (var75 > 0 && !entity_a.getPersistentData().getBoolean("Failed")) {
                                    entity.getPersistentData().putDouble("Damage", 46.0);
                                    entity.getPersistentData().putDouble("Range", 6.0 * JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius);
                                    entity.getPersistentData().putDouble("projectile_type", 1.0);
                                    entity.getPersistentData().putDouble("knockback", 0.5);
                                    entity.getPersistentData().putDouble("effect", 3.0);
                                    RangeAttackProcedure.execute(world, entity_a.getPersistentData().getDouble("x_pos_doma"), entity_a.getPersistentData().getDouble("y_pos_doma"), entity_a.getPersistentData().getDouble("z_pos_doma"), entity);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(var42, var50, var43), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F);
                                 } else {
                                    _level.playLocalSound(var42, var50, var43, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(var42, var50, var43), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F);
                                 } else {
                                    _level.playLocalSound(var42, var50, var43, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(var42, var50, var43), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.5F);
                                 } else {
                                    _level.playLocalSound(var42, var50, var43, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.5F, false);
                                 }
                              }
                           }

                           var50 = entity.getPersistentData().getDouble("y_pos") + (entity.getPersistentData().getDouble("cnt2") - 2.0) * 2.0;
                           var40 = 5.0 * var44;
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(var42, var50, var43), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F);
                              } else {
                                 _level.playLocalSound(var42, var50, var43, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 1.0F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(var42, var50, var43), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F);
                              } else {
                                 _level.playLocalSound(var42, var50, var43, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.75F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(var42, var50, var43), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.5F);
                              } else {
                                 _level.playLocalSound(var42, var50, var43, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * (DUST_AMOUNT + 0.5)), 0.5F, false);
                              }
                           }
                           break label289;
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.FLAME, x, y, z, 50, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 50, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 0.75F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
                           }
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.FLAME, x, y, z, 3, 0.2, 0.2, 0.2, 0.1);
                     }

                     if (Math.random() < 0.05 && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 1, 0.2, 0.2, 0.2, 0.1);
                     }

                     entity.getPersistentData().putDouble("Damage", 35.0);
                     entity.getPersistentData().putDouble("Range", 5.0);
                     entity.getPersistentData().putDouble("knockback", 0.5);
                     entity.getPersistentData().putDouble("effect", 3.0);
                     entity.getPersistentData().putDouble("effectConfirm", 2.0);
                     entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                     RangeAttackProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().putBoolean("ExtinctionBlock", false);
                     if ((var48 * var48 + var46 * var46 + var47 * var47 < 1.0 || entity.isInWall()) && entity.getPersistentData().getDouble("cnt1") > 5.0 || entity.getPersistentData().getDouble("cnt1") > 60.0 || !entity.isAlive()) {
                        entity.getPersistentData().putDouble("cnt2", 1.0);
                     }

                     if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
                        if (entity instanceof FlameArrowEntity) {
                           FlameArrowEntity _datEntSetL = (FlameArrowEntity)entity;
                           _datEntSetL.getEntityData().set(FlameArrowEntity.DATA_sync2, true);
                        }

                        entity.getPersistentData().putDouble("x_pos", x);
                        entity.getPersistentData().putDouble("y_pos", y);
                        entity.getPersistentData().putDouble("z_pos", z);
                     }

                     if (entity.getPersistentData().getBoolean("Stop")) {
                        entity.getPersistentData().putBoolean("Stop", true);
                     } else {
                        for(int index0 = 0; index0 < 3; ++index0) {
                           entity.teleportTo(entity.getX() + entity.getPersistentData().getDouble("x_power") * 0.2, entity.getY() + entity.getPersistentData().getDouble("y_power") * 0.2, entity.getZ() + entity.getPersistentData().getDouble("z_power") * 0.2);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(entity.getX() + entity.getPersistentData().getDouble("x_power") * 0.2, entity.getY() + entity.getPersistentData().getDouble("y_power") * 0.2, entity.getZ() + entity.getPersistentData().getDouble("z_power") * 0.2, entity.getYRot(), entity.getXRot());
                           }

                           if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).canOcclude()) {
                              entity.getPersistentData().putDouble("cnt2", 1.0);
                              entity.getPersistentData().putDouble("x_pos", entity.getX());
                              entity.getPersistentData().putDouble("y_pos", entity.getY());
                              entity.getPersistentData().putDouble("z_pos", entity.getZ());
                              break;
                           }
                        }

                        entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.0, entity.getPersistentData().getDouble("y_power") * 1.0, entity.getPersistentData().getDouble("z_power") * 1.0));
                        BulletDomainHit2Procedure.execute(world, entity);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt2") >= (15.0 + var39 * 1.0) * (DUST_AMOUNT + 0.5) && !entity.level().isClientSide()) {
                     entity.discard();
                  }
                  break label272;
               }
            }

            entity.getPersistentData().putBoolean("Stop", false);
            entity.getPersistentData().putDouble("cnt1", 0.0);
            entity.getPersistentData().putDouble("cnt2", 0.0);
            boolean var38 = false;
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.getPersistentData().getDouble("skill") > 0.0 && entity_a.getPersistentData().getDouble("cnt1") <= 30.0) {
                  var38 = true;
                  entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                  entity.setYRot(entity_a.getYRot());
                  entity.setXRot(entity_a.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
                  }
               }
            }

            if (!var38 || !entity.isAlive()) {
               if (entity instanceof FlameArrowEntity) {
                  FlameArrowEntity _datEntSetL = (FlameArrowEntity)entity;
                  _datEntSetL.getEntityData().set(FlameArrowEntity.DATA_sync, true);
               }

               entity.getPersistentData().putDouble("cnt3", 1.0);
            }
         }

         entity.getPersistentData().putDouble("old_x", x);
         entity.getPersistentData().putDouble("old_y", y);
         entity.getPersistentData().putDouble("old_z", z);
      }
   }
}
