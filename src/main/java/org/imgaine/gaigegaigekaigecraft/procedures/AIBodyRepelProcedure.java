package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
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

public class AIBodyRepelProcedure {
   public AIBodyRepelProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double num1 = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double num4 = 0.0;
         double num3 = 0.0;
         double num2 = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.isAlive()) {
            double var10000;
            label239: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity2.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                     break label239;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 < entity.getPersistentData().getDouble("size") && entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  AttributeInstance var81;
                  label232: {
                     var81 = _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity4 = (LivingEntity)entity;
                        if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label232;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var81.setBaseValue(Math.min(var10001 + 0.2, entity.getPersistentData().getDouble("size")));
               }
            }

            if (entity.getPersistentData().getDouble("move") == 1.0) {
               if (entity.getPersistentData().getDouble("cnt1") < 35.0 * CNT6) {
                  AIFistProcedure.execute(world, entity);
               } else {
                  entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                  entity.setYRot(entity.getYRot());
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

                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:0b}");
                  }

                  if (entity.getPersistentData().getDouble("cnt1") >= 140.0 && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               if (entity.getPersistentData().getDouble("cnt1") <= 40.0) {
                  num1 = (double)(entity.getYRot() % 360.0F);
                  num3 = (double)entity.getXRot();
                  RotateEntityProcedure.execute(entity.getX() + entity.getDeltaMovement().x() * 999.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getDeltaMovement().y() * 999.0, entity.getZ() + entity.getDeltaMovement().z() * 999.0, entity);
                  num2 = num1 - (double)entity.getYRot();
                  num4 = num3 - (double)entity.getXRot();
                  entity.setYRot((float)(num1 + Math.min(8.0, Math.abs(num2)) * (double)((!(Math.abs(num2) > 180.0) || !(num2 < 0.0)) && (!(Math.abs(num2) <= 180.0) || !(num2 > 0.0)) ? 1 : -1)));
                  entity.setXRot((float)(num3 + Math.min(8.0, Math.abs(num4)) * (double)(num4 < 0.0 ? -1 : 1)));
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  BulletDomainHit2Procedure.execute(world, entity);
                  x_power = entity.getPersistentData().getDouble("x_power");
                  y_power = entity.getPersistentData().getDouble("y_power");
                  z_power = entity.getPersistentData().getDouble("z_power");
                  if (!(entity.getPersistentData().getDouble("cnt1") <= 12.0)) {
                     x_power = entity.getPersistentData().getDouble("x_pos") * 1.0;
                     y_power = entity.getPersistentData().getDouble("y_pos") * 1.0;
                     z_power = entity.getPersistentData().getDouble("z_pos") * 1.0;
                  } else {
                     if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                        if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                           LivingEntity var82;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var82 = _mobEnt.getTarget();
                           } else {
                              var82 = null;
                           }

                           if (var82 instanceof LivingEntity) {
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var82 = _mobEnt.getTarget();
                              } else {
                                 var82 = null;
                              }

                              x_pos = ((Entity)var82).getX();
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var82 = _mobEnt.getTarget();
                              } else {
                                 var82 = null;
                              }

                              double var85 = ((Entity)var82).getY();
                              LivingEntity var87;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var87 = _mobEnt.getTarget();
                              } else {
                                 var87 = null;
                              }

                              y_pos = var85 + (double)((Entity)var87).getBbHeight() * 0.75;
                              LivingEntity var86;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var86 = _mobEnt.getTarget();
                              } else {
                                 var86 = null;
                              }

                              z_pos = ((Entity)var86).getZ();
                           } else {
                              x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                              y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                              z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                           }
                        }
                     }

                     distance = 8.0 * ReturnEntitySizeProcedure.execute(entity);
                     Vec3 _center = new Vec3(entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance, entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * distance, entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(2.0 * distance / 2.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           x_pos = entityiterator.getX();
                           y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                           z_pos = entityiterator.getZ();
                           break;
                        }
                     }

                     num1 = (double)(entity.getYRot() % 360.0F);
                     num3 = (double)entity.getXRot();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                     entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                     entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                     entity.setYRot((float)num1);
                     entity.setXRot((float)num3);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * 0.8) {
                        x_power = entity.getDeltaMovement().x() - 0.175;
                     } else {
                        x_power = entity.getDeltaMovement().x() + 0.175;
                     }

                     if (entity.getDeltaMovement().y() > entity.getPersistentData().getDouble("y_power") * 0.8) {
                        y_power = entity.getDeltaMovement().y() - 0.175;
                     } else {
                        y_power = entity.getDeltaMovement().y() + 0.175;
                     }

                     if (entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * 0.8) {
                        z_power = entity.getDeltaMovement().z() - 0.175;
                     } else {
                        z_power = entity.getDeltaMovement().z() + 0.175;
                     }

                     entity.getPersistentData().putDouble("x_pos", x_power);
                     entity.getPersistentData().putDouble("y_pos", y_power);
                     entity.getPersistentData().putDouble("z_pos", z_power);
                  }

                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  if (dis > 0.0 && dis < 0.8) {
                     x_power *= 0.8 / dis;
                     y_power *= 0.8 / dis;
                     z_power *= 0.8 / dis;
                  }

                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  x_pos = entity.getX();
                  y_pos = entity.getY();
                  z_pos = entity.getZ();

                  for(int index0 = 0; index0 < 1; ++index0) {
                     entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putDouble("Range", (double)(1.0F + entity.getBbWidth()));
                     entity.getPersistentData().putDouble("effect", 1.0);
                     if (!entity.getPersistentData().getBoolean("Stop")) {
                        yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                        pitch = Math.toRadians((double)entity.getXRot());
                        distance = (double)entity.getBbWidth() * 0.5;
                        RangeAttackProcedure.execute(world, entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance, entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance, entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance, entity);
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                     if (world.isEmptyBlock(BlockPos.containing(x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos))) {
                        entity.getPersistentData().putBoolean("Stop", false);
                     } else {
                        entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 8.0);
                        if (!entity.getPersistentData().getBoolean("Stop")) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                              }
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                           }

                           entity.getPersistentData().putDouble("BlockRange", 1.5 * ReturnEntitySizeProcedure.execute(entity));
                           entity.getPersistentData().putDouble("BlockDamage", 4.0 * CNT6);
                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                           if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos))) {
                              entity.getPersistentData().putBoolean("Stop", true);
                              break;
                           }
                        }
                     }
                  }
               } else {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:0b}");
                  }

                  if (entity.getPersistentData().getDouble("cnt1") >= 140.0 && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            entity.getPersistentData().putDouble("cnt3", 1.0);
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(4.0F * entity.getBbHeight() * entity.getBbWidth() * entity.getBbWidth()), 0.2 * (double)entity.getBbWidth(), 0.2 * (double)entity.getBbHeight(), 0.2 * (double)entity.getBbWidth(), 1.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()));
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()), false);
               }
            }

            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         }

      }
   }
}
