package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class CleaveProcedure {
   public CleaveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_explode = false;
         Entity target_entity = null;
         double distance = 0.0;
         double d = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double rad = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double size_height = 0.0;
         double size_width = 0.0;
         double speed = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 5, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(2.0F + entity.getBbWidth());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var40 = var10000;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            label345: {
               label344: {
                  if (entity instanceof Player) {
                     if (entity.isShiftKeyDown()) {
                        break label344;
                     }
                  } else if (GetDistanceProcedure.execute(entity) > distance * 2.0 || Math.random() < 0.25) {
                     break label344;
                  }

                  entity.getPersistentData().putDouble("cnt1", 6.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  break label345;
               }

               entity.getPersistentData().putDouble("cnt1", 6.0);
               entity.getPersistentData().putDouble("cnt2", 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 5.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (var40 instanceof LivingEntity) {
               entity.lookAt(Anchor.EYES, new Vec3(((Entity)var40).getX(), ((Entity)var40).getY() + (double)((Entity)var40).getBbHeight() * 0.75, ((Entity)var40).getZ()));
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 4.0) {
               entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 4.0));
            }

            ChargeParticleProcedure.execute(world, entity, 0.0);
         }

         CNT6 = 1.0;
         if (entity.getPersistentData().getDouble("cnt1") > 5.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 6.0 && entity.getPersistentData().getDouble("cnt2") == 0.0) {
               label369: {
                  if (entity instanceof Player) {
                     if (!entity.isShiftKeyDown()) {
                        break label369;
                     }
                  } else if (!(GetDistanceProcedure.execute(entity) > distance * 2.0)) {
                     break label369;
                  }

                  entity.getPersistentData().putDouble("cnt2", 1.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               label355: {
                  if (entity.getPersistentData().getDouble("cnt1") <= 16.0) {
                     if (entity.getPersistentData().getDouble("cnt1") % 2.0 != 0.0) {
                        break label355;
                     }
                  } else if (entity.getPersistentData().getDouble("cnt1") != 22.0) {
                     break label355;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity.getPersistentData().getDouble("cnt1") == 22.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity46 = (LivingEntity)entity;
                        if (_livingEntity46.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity46.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
                        }
                     }

                     entity.getPersistentData().putDouble("Damage", 19.0 + entity.getPersistentData().getDouble("cnt1") * 0.1);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity50 = (LivingEntity)entity;
                        if (_livingEntity50.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity50.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(207.0);
                        }
                     }

                     entity.getPersistentData().putDouble("Damage", 17.0 + entity.getPersistentData().getDouble("cnt1") * 0.1);
                     entity.getPersistentData().putDouble("knockback", 0.01);
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  entity.getPersistentData().putDouble("Range", distance * 2.4);
                  entity.getPersistentData().putDouble("effect", 4.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 15, 0.1, 0.1, 0.1, 4.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") > 30.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            } else {
               if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
                  if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                     entity.getPersistentData().putDouble("cnt2", 2.0);
                     entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
                     entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY());
                     entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
                  } else if (entity.onGround()) {
                     entity.getPersistentData().putDouble("cnt2", 2.0);
                     entity.getPersistentData().putDouble("x_pos", entity.getX());
                     entity.getPersistentData().putDouble("y_pos", entity.getY());
                     entity.getPersistentData().putDouble("z_pos", entity.getZ());
                     entity.setYRot(entity.getYRot());
                     entity.setXRot(90.0F);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  } else {
                     entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt3") > 120.0) {
                        entity.getPersistentData().putDouble("skill", 0.0);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt2") >= 2.0) {
                  if (entity.getPersistentData().getDouble("cnt2") == 2.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.25F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity89 = (LivingEntity)entity;
                        if (_livingEntity89.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity89.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                  entity.getPersistentData().putDouble("Damage", 15.0);
                  DamageFixProcedure.execute(entity);
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");
                  d = Math.sqrt(entity.getPersistentData().getDouble("Damage") * 1.0);
                  logic_explode = entity.getPersistentData().getDouble("cnt2") == 8.0;
                  entity.getPersistentData().putDouble("y_knockback", 0.5);
                  if (logic_explode) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                        }
                     }

                     entity.getPersistentData().putDouble("BlockDamage", d * 1.0);
                     entity.getPersistentData().putDouble("BlockRange", 8.0 * d * 0.1);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (entity.getPersistentData().getDouble("cnt2") <= 7.0 || logic_explode) {
                     int var10001;
                     label314: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label314;
                           }
                        }

                        var10001 = 0;
                     }

                     HP = (double)(20 + var10001 * 4);

                     for(int index0 = 0; index0 < 20; ++index0) {
                        dis = logic_explode ? 0.0 : (entity.getPersistentData().getDouble("cnt2") - 3.0) * 3.0;

                        for(int index1 = 0; index1 < (logic_explode ? 15 : 3); ++index1) {
                           logic_a = false;
                           x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(rad) * dis;
                           y_pos = entity.getPersistentData().getDouble("y_pos");
                           z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(rad) * dis;
                           if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                              y_pos = entity.getPersistentData().getDouble("y_pos");

                              for(int index2 = 0; index2 < (int)Math.round(dis * 2.0); ++index2) {
                                 ++y_pos;
                                 if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                                    logic_a = true;
                                    break;
                                 }
                              }
                           } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                              y_pos = entity.getPersistentData().getDouble("y_pos");

                              for(int index3 = 0; index3 < (int)Math.round(dis * 2.0); ++index3) {
                                 --y_pos;
                                 if (world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                                    logic_a = true;
                                    break;
                                 }
                              }
                           } else {
                              logic_a = true;
                           }

                           if (logic_a) {
                              if (logic_explode) {
                                 entity.getPersistentData().putDouble("Damage", 15.0);
                                 entity.getPersistentData().putDouble("Range", 6.0);
                                 entity.getPersistentData().putDouble("knockback", 1.0);
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 2, 1.0, 1.0, 1.0, 0.5);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 2, 1.0, 1.0, 1.0, 0.0);
                                 }

                                 RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                                 if (Math.random() < 0.025 && world instanceof ServerLevel) {
                                    ServerLevel _serverLevel = (ServerLevel)world;
                                    Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROCK_FRAGMENT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                                    if (entityinstance != null) {
                                       entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                                       SetRangedAmmoProcedure.execute(entity, entityinstance);
                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _livingEntity123 = (LivingEntity)entityinstance;
                                          if (_livingEntity123.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                             _livingEntity123.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                                          }
                                       }

                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityinstance;
                                          _entity.setHealth((float)HP);
                                       }

                                       entityinstance.setDeltaMovement(new Vec3((Math.random() - 0.5) * 3.0, (Math.random() * 1.5 + 0.75) * CNT6, (Math.random() - 0.5) * 3.0));
                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _livingEntity129 = (LivingEntity)entityinstance;
                                          if (_livingEntity129.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                             _livingEntity129.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue((Math.random() + 1.0) * CNT6);
                                          }
                                       }

                                       _serverLevel.addFreshEntity(entityinstance);
                                    }
                                 }
                              } else if (entity.getPersistentData().getDouble("skill") != 106.0) {
                                 if (entity.getPersistentData().getDouble("skill") == 2108.0 && world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_DISMANTLE_ITADORI.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                                 }
                              } else {
                                 for(Entity entityiterator : new ArrayList<Entity>(world.players())) {
                                    if (CanSeeSukunaSlashProcedure.execute(world, entity, entityiterator) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "particle gaigegaigekaigecraft:particle_slash " + x_pos + " " + y_pos + " " + z_pos + " 0.1 0.1 0.1 0 " + Math.round(1.0F) + " normal");
                                    }
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                                 }
                              }
                           }

                           ++dis;
                        }

                        rad += Math.toRadians(18.0);
                     }
                  }

                  entity.getPersistentData().putDouble("y_knockback", 0.0);
                  if (entity.getPersistentData().getDouble("cnt2") >= 15.0) {
                     entity.getPersistentData().putDouble("skill", 0.0);
                  }
               }
            }
         }

      }
   }
}
