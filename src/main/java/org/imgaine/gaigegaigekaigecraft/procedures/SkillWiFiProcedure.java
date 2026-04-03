package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillWiFiProcedure {
   public SkillWiFiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double tick = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }
         }

         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(5.0 + CNT6), 0.5, 0.5, 0.5, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(5.0 * CNT6), 0.5, 0.5, 0.5, 0.05);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 8.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label367: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label357: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                    break label357;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label367;
                              }
                           }
                        }

                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 8.0));
                  if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     entity.getPersistentData().putDouble("cnt6", 5.0);
                  } else if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
                     }
                  }
               }
            }

            LivingEntity var89;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var89 = _mobEnt.getTarget();
            } else {
               var89 = null;
            }

            if (var89 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var89 = _mobEnt.getTarget();
               } else {
                  var89 = null;
               }

               Level var91 = ((Entity)var89).level();
               ClipContext var10001;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.getTarget();
               } else {
                  var10003 = null;
               }

               Vec3 var104 = ((Entity)var10003).getEyePosition(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               Vec3 var106 = ((Entity)var10004).getEyePosition(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               var106 = var106.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var110 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var104, var106, var110, var10006, var10007);
               double var92 = (double)var91.clip(var10001).getBlockPos().getX();
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.getTarget();
               } else {
                  var94 = null;
               }

               Level var95 = ((Entity)var94).level();
               ClipContext var10002;
               LivingEntity var108;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var108 = _mobEnt.getTarget();
               } else {
                  var108 = null;
               }

               Vec3 var109 = ((Entity)var108).getEyePosition(1.0F);
               LivingEntity var111;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var111 = _mobEnt.getTarget();
               } else {
                  var111 = null;
               }

               Vec3 var112 = ((Entity)var111).getEyePosition(1.0F);
               LivingEntity var116;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var116 = _mobEnt.getTarget();
               } else {
                  var116 = null;
               }

               var112 = var112.add(((Entity)var116).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var117 = Block.OUTLINE;
               ClipContext.Fluid var121 = Fluid.NONE;
               LivingEntity var10008;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10008 = _mobEnt.getTarget();
               } else {
                  var10008 = null;
               }

               var10002 = new ClipContext(var109, var112, var117, var121, var10008);
               double var96 = (double)var95.clip(var10002).getBlockPos().getY();
               LivingEntity var100;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var100 = _mobEnt.getTarget();
               } else {
                  var100 = null;
               }

               Level var101 = ((Entity)var100).level();
               ClipContext var105;
               LivingEntity var114;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var114 = _mobEnt.getTarget();
               } else {
                  var114 = null;
               }

               Vec3 var115 = ((Entity)var114).getEyePosition(1.0F);
               LivingEntity var118;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var118 = _mobEnt.getTarget();
               } else {
                  var118 = null;
               }

               Vec3 var119 = ((Entity)var118).getEyePosition(1.0F);
               LivingEntity var122;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var122 = _mobEnt.getTarget();
               } else {
                  var122 = null;
               }

               var119 = var119.add(((Entity)var122).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var123 = Block.OUTLINE;
               ClipContext.Fluid var124 = Fluid.NONE;
               LivingEntity var10009;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10009 = _mobEnt.getTarget();
               } else {
                  var10009 = null;
               }

               var105 = new ClipContext(var115, var119, var123, var124, var10009);
               RotateEntityProcedure.execute(var92, var96, (double)var101.clip(var105).getBlockPos().getZ(), entity);
            }
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               yaw = (double)entity.getYRot();
               picth = (double)entity.getXRot();
               entity.setYRot((float)yaw);
               entity.setXRot(0.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + 1);
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               tick = 80.0 * CNT6;
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§l" + Component.translatable("jujutsu.message.takaba1").getString()), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WI_FI.get(), x_pos, y_pos, z_pos, 1, 0.0, 0.0, 0.0, 0.0);
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(24.0 * CNT6 / 2.0), (e) -> true)) {
                  if (entity != entityiterator && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int)tick, 99, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)tick, 99, false, false));
                        }
                     }

                     entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     if (entityiterator.getPersistentData().getDouble("skill") == 0.0 || entityiterator.getPersistentData().getDouble("select") == 0.0) {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                        }

                        entityiterator.getPersistentData().putDouble("skill", -1000.0);
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (int)tick, 0, false, false));
                           }
                        }
                     }

                     if (entityiterator instanceof Player && !entity.level().isClientSide() && entity.getServer() != null) {
                        Commands var93 = entity.getServer().getCommands();
                        CommandSourceStack var97 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                        String var102 = entityiterator.getDisplayName().getString();
                        var93.performPrefixedCommand(var97, "tell " + var102 + " §l" + Component.translatable("jujutsu.message.takaba1").getString());
                     }

                     EffectCharactorProcedure.execute(world, entity, entityiterator);
                     if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "stopsound @s");
                     }
                  }
               }

               entity.setYRot((float)yaw);
               entity.setXRot((float)picth);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F, false);
                  }
               }

               if (entity.isAlive() && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  float var98;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var98 = _livEnt.getHealth();
                  } else {
                     var98 = -1.0F;
                  }

                  double var99 = (double)var98;
                  float var103;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var103 = _livEnt.getMaxHealth();
                  } else {
                     var103 = -1.0F;
                  }

                  _entity.setHealth((float)(var99 + (double)var103 * 0.5));
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") < 10.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FIREWORK, x, y, z, (int)(8.0 * CNT6), 0.5 * CNT6, 0.5 * CNT6, 0.5 * CNT6, 0.5 * CNT6);
            }

            if (entity.getPersistentData().getDouble("cnt2") > 60.0) {
               entity.getPersistentData().putDouble("skill", 1705.0);
            }

            if (entity.getPersistentData().getDouble("cnt2") < 55.0) {
               PlayAnimationProcedure.execute(world, entity);
            }
         }

      }
   }
}
