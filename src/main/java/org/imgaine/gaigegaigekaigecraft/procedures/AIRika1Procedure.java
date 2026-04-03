package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GarudaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AIRika1Procedure {
   public AIRika1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean garuda = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double distance = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         garuda = entity instanceof GarudaEntity;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (garuda) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            } else if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         entity.fallDistance = 0.0F;
         logic_a = false;
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(64.0F + entity.getBbWidth());
         if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                  x_pos = entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity_a.getY() + (double)entity_a.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
                  z_pos = entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity && entity_a.getPersistentData().getDouble("cnt_target") > 6.0) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).getX();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     double var86 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var86 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var87;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var87 = _mobEnt.getTarget();
                     } else {
                        var87 = null;
                     }

                     z_pos = ((Entity)var87).getZ();
                  }
               }
            }

            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
               if (entity != entityiterator) {
                  LivingEntity var88;
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var88 = _mobEnt.getTarget();
                  } else {
                     var88 = null;
                  }

                  if (var88 instanceof LivingEntity && entityiterator.getPersistentData().getDouble("cnt_target") > 6.0) {
                     if (entityiterator instanceof Mob) {
                        Mob _mobEnt = (Mob)entityiterator;
                        var88 = _mobEnt.getTarget();
                     } else {
                        var88 = null;
                     }

                     if (((Entity)var88).getPersistentData().getDouble("friend_num") == entity.getPersistentData().getDouble("friend_num")) {
                        x_pos = entityiterator.getX();
                        y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                        z_pos = entityiterator.getZ();
                        break;
                     }
                  }
               }
            }
         } else {
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            LivingEntity var90;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var90 = _mobEnt.getTarget();
            } else {
               var90 = null;
            }

            if (var90 instanceof LivingEntity && (GetDistanceProcedure.execute(entity) > 16.0 || entity.getPersistentData().getDouble("cnt1") > 20.0)) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.getTarget();
               } else {
                  var90 = null;
               }

               x_pos = ((Entity)var90).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.getTarget();
               } else {
                  var90 = null;
               }

               double var93 = ((Entity)var90).getY();
               LivingEntity var96;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.getTarget();
               } else {
                  var96 = null;
               }

               y_pos = var93 + (double)((Entity)var96).getBbHeight() * 0.5;
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.getTarget();
               } else {
                  var94 = null;
               }

               z_pos = ((Entity)var94).getZ();
            }
         }

         entity.getPersistentData().putBoolean("canFly", true);
         GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (garuda) {
               x_power = entity.getPersistentData().getDouble("x_power") * 1.0;
               y_power = entity.getPersistentData().getDouble("y_power") * 1.0;
               z_power = entity.getPersistentData().getDouble("z_power") * 1.0;
            } else {
               x_power = entity.getPersistentData().getDouble("x_power") * 0.5;
               y_power = entity.getPersistentData().getDouble("y_power") * 0.5;
               z_power = entity.getPersistentData().getDouble("z_power") * 0.5;
            }
         } else {
            if (entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * 0.5) {
               x_power = entity.getDeltaMovement().x() - 0.125;
            } else {
               x_power = entity.getDeltaMovement().x() + 0.125;
            }

            if (entity.getDeltaMovement().y() > entity.getPersistentData().getDouble("y_power") * 0.5) {
               y_power = entity.getDeltaMovement().y() - 0.125;
            } else {
               y_power = entity.getDeltaMovement().y() + 0.125;
            }

            if (entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * 0.5) {
               z_power = entity.getDeltaMovement().z() - 0.125;
            } else {
               z_power = entity.getDeltaMovement().z() + 0.125;
            }
         }

         entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
         yaw = (double)(entity.getYRot() % 360.0F);
         pitch = (double)entity.getXRot();
         RotateEntityProcedure.execute(entity.getX() + entity.getDeltaMovement().x() * 32.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getDeltaMovement().y() * 32.0, entity.getZ() + entity.getDeltaMovement().z() * 32.0, entity);
         entity.setYRot(entity.getYRot() % 360.0F);
         entity.setXRot(entity.getXRot());
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         yaw_cal = (double)entity.getYRot() - yaw;
         if ((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0))) {
            yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 5.0;
         } else {
            yaw -= Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 5.0;
         }

         pitch_cal = Math.abs((double)entity.getXRot() - pitch);
         if (pitch > (double)entity.getXRot()) {
            pitch -= pitch_cal / 5.0;
         } else {
            pitch += pitch_cal / 5.0;
         }

         entity.setYRot((float)yaw);
         entity.setXRot((float)pitch);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (!garuda) {
            if (entity.getPersistentData().getDouble("cnt1") < 25.0) {
               entity.getPersistentData().putDouble("Damage", 12.0);
               entity.getPersistentData().putDouble("knockback", 0.75);
            } else {
               entity.getPersistentData().putDouble("Damage", 13.0);
               entity.getPersistentData().putDouble("knockback", 1.5);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            entity.getPersistentData().putDouble("Damage", 6.5);
            entity.getPersistentData().putDouble("knockback", 0.75);
         } else {
            entity.getPersistentData().putDouble("Damage", 9.0);
            entity.getPersistentData().putDouble("knockback", 1.5);
         }

         CompoundTag var95;
         int var10004;
         label222: {
            entity.getPersistentData().putDouble("Range", (double)(entity.getBbHeight() + entity.getBbWidth()));
            entity.getPersistentData().putDouble("effect", 5.0);
            entity.getPersistentData().putBoolean("swing", true);
            entity.getPersistentData().putBoolean("attack", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            var95 = entity.getPersistentData();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10004 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label222;
               }
            }

            var10004 = 0;
         }

         var95.putDouble("BlockDamage", 2.5 + 0.25 * (double)var10004);
         entity.getPersistentData().putDouble("BlockRange", (double)((entity.getBbHeight() + entity.getBbWidth()) / 2.0F));
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().getDouble("cnt1") <= (double)(garuda ? 5 : 20) && entity.getPersistentData().getDouble("cnt1") % 5.0 == 1.0 && (entity instanceof GeoEntity || entity instanceof Player)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity123 = (LivingEntity)entity;
               if (_livingEntity123.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity123.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") > (double)(garuda ? 15 : 30)) {
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                  if (!garuda) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.5);
                     }

                     entity.teleportTo((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity.getYRot(), entity.getXRot());
                     }

                     entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
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

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 50, 1.0, 1.0, 1.0, 0.5);
                     }
                  } else {
                     entity.teleportTo((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity.getYRot(), entity.getXRot());
                     }

                     entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
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
                  }
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
