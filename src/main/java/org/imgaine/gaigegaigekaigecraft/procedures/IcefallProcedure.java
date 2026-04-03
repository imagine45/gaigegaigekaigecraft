package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.IceSpearEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IcefallProcedure {
   public IcefallProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double CNT6 = 0.0;
         double range_2 = 0.0;
         double HP = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         picth = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX();
         y_pos = entity.getY();
         z_pos = entity.getZ();
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
               }
            }

            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.getTarget();
            } else {
               var10004 = null;
            }

            double var110 = ((Entity)var10004).getX();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.getTarget();
            } else {
               var10005 = null;
            }

            double var111 = ((Entity)var10005).getY() + (double)entity.getBbHeight() * 0.5;
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var10002 = new Vec3(var110, var111, ((Entity)var10006).getZ());
            entity.lookAt(var10001, var10002);
         }

         if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 10, 5.0, 0.1, 5.0, 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 2, 5.0, 0.1, 5.0, 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 2.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 1.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 18.0 && entity.getPersistentData().getDouble("cnt5") < 60.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) < 5.0 || GetDistanceProcedure.execute(entity) > 16.0) {
                     label421: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label389: {
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
                                    break label389;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label421;
                              }
                           }
                        }

                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 18.0));
               }

               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 3.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            entity.getPersistentData().putDouble("Damage", 3.0);
            entity.getPersistentData().putDouble("Range", Math.min(24.0, entity.getPersistentData().getDouble("cnt5") * 2.0));
            entity.getPersistentData().putDouble("knockback", 0.01);
            entity.getPersistentData().putDouble("effect", 14.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().putDouble("Damage", 6.0);
            entity.getPersistentData().putDouble("Range", Math.min(12.0, entity.getPersistentData().getDouble("cnt5") * 2.0));
            entity.getPersistentData().putDouble("knockback", 0.01);
            entity.getPersistentData().putDouble("effect", 14.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().putDouble("BlockRange", Math.min(12.0, entity.getPersistentData().getDouble("cnt5") * 1.0));
            BlockToIceProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().getDouble("cnt5") % 2.0 == 1.0 && entity.getPersistentData().getDouble("cnt5") < 20.0) {
               range = Math.min(16.0, 6.0 + entity.getPersistentData().getDouble("cnt5") * 2.0);
               num1 = Math.toRadians(entity.getPersistentData().getDouble("cnt5") * 20.0);
               x_pos += Math.cos(num1) * range;
               z_pos += Math.sin(num1) * range;

               for(int index0 = 0; index0 < (int)range; ++index0) {
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     ++y_pos;
                  } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                        break;
                     }

                     --y_pos;
                  }
               }

               int var108;
               label330: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var108 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label330;
                     }
                  }

                  var108 = 0;
               }

               HP = (double)(20 + var108 * 4);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ICE_SPEAR_2.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.setYRot((float)Math.toDegrees(num1 + 90.0));
                     entityinstance.setXRot(-45.0F);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity73 = (LivingEntity)entityinstance;
                        if (_livingEntity73.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity73.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity77 = (LivingEntity)entityinstance;
                        if (_livingEntity77.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity77.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(0.1);
                        }
                     }

                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

                     entityinstance.getPersistentData().putDouble("y_power", 1.0);
                     entityinstance.getPersistentData().putDouble("move", 0.0);
                     entityinstance.getPersistentData().putDouble("cnt6", 0.0);
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }

            entity.getPersistentData().putDouble("x_pos", entity.getX());
            entity.getPersistentData().putDouble("y_pos", entity.getY());
            entity.getPersistentData().putDouble("z_pos", entity.getZ());
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().putDouble("cnt3", (double)entity.getYRot());
               dis = 6.0;
               SUCCESS = false;

               for(int index1 = 0; index1 < 8; ++index1) {
                  x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
                  y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
                  z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        SUCCESS = true;
                        x_pos = entityiterator.getX();
                        y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                        z_pos = entityiterator.getZ();
                        break;
                     }
                  }

                  if (SUCCESS) {
                     break;
                  }

                  dis += 6.0;
               }

               entity.getPersistentData().putDouble("x_power", x_pos);
               entity.getPersistentData().putDouble("y_power", y_pos);
               entity.getPersistentData().putDouble("z_power", z_pos);
            }

            if (entity.getPersistentData().getDouble("cnt2") <= 15.0) {
               num2 = (double)(entity.getBbWidth() + 4.0F);

               for(int index2 = 0; index2 < 12; ++index2) {
                  num1 = Math.toRadians(entity.getPersistentData().getDouble("cnt3"));
                  x_pos = entity.getPersistentData().getDouble("x_pos") + Math.sin(num1) * num2;
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos") + Math.cos(num1) * num2;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.0);
                  }

                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 10.0 * Math.random());
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + 0.1);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") >= 10.0) {
               entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);

               for(int index3 = 0; index3 < 2; ++index3) {
                  num1 = Math.toRadians(720.0 * Math.random());
                  num2 = 10.0 * Math.random();
                  x_pos = entity.getPersistentData().getDouble("x_power") + Math.sin(num1) * num2;
                  y_pos = entity.getPersistentData().getDouble("y_power");
                  z_pos = entity.getPersistentData().getDouble("z_power") + Math.cos(num1) * num2;
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     for(int index4 = 0; index4 < 16; ++index4) {
                        ++y_pos;
                        if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                           break;
                        }
                     }
                  }

                  for(int index5 = 0; index5 < 16 && !world.getBlockState(BlockPos.containing(x_pos, y_pos + 1.0, z_pos)).canOcclude(); ++index5) {
                     ++y_pos;
                  }

                  int var109;
                  label281: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var109 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label281;
                        }
                     }

                     var109 = 0;
                  }

                  HP = (double)(80 + var109 * 16);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ICE_SPEAR.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.setYRot(entity.getYRot());
                        entityinstance.setXRot(entity.getXRot());
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity143 = (LivingEntity)entityinstance;
                           if (_livingEntity143.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity143.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        entityinstance.getPersistentData().putDouble("move", 0.0);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity149 = (LivingEntity)entityinstance;
                           if (_livingEntity149.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity149.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(3.0);
                           }
                        }

                        if (entityinstance instanceof IceSpearEntity) {
                           PlayAnimationEntity2Procedure.execute(entityinstance, "fall");
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 4, 1.0, 1.0, 1.0, 0.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt4") > 12.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

      }
   }
}
