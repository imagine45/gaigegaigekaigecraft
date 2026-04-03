package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AISlicingExorcismProcedure {
   public AISlicingExorcismProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double loop_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
            }
         }

         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
               if (LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     if (entity_a.getPersistentData().getDouble("skill") > 0.0) {
                        entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.onGround() ? 0.0 : entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
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

                        yaw = Math.toRadians((double)(entity_a.getYRot() + 90.0F));
                        pitch = Math.toRadians((double)entity_a.getXRot());
                        entity.teleportTo(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.getBbWidth()), entity_a.getY() + (double)entity_a.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity_a.getBbWidth()), entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.getBbWidth()));
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.getBbWidth()), entity_a.getY() + (double)entity_a.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity_a.getBbWidth()), entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity_a.getBbWidth()), entity.getYRot(), entity.getXRot());
                        }

                        entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), entity_a.getPersistentData().getDouble("cnt6")));
                        entity.getPersistentData().putDouble("cnt1", 0.0);
                     } else {
                        LivingEntity var10000;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity) {
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           Level var75 = ((Entity)var10000).level();
                           ClipContext var10001;
                           LivingEntity var10003;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10003 = _mobEnt.getTarget();
                           } else {
                              var10003 = null;
                           }

                           Vec3 var82 = ((Entity)var10003).getEyePosition(1.0F);
                           LivingEntity var10004;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10004 = _mobEnt.getTarget();
                           } else {
                              var10004 = null;
                           }

                           Vec3 var87 = ((Entity)var10004).getEyePosition(1.0F);
                           LivingEntity var10005;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10005 = _mobEnt.getTarget();
                           } else {
                              var10005 = null;
                           }

                           var87 = var87.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
                           ClipContext.Block var95 = Block.OUTLINE;
                           ClipContext.Fluid var10006 = Fluid.NONE;
                           LivingEntity var10007;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.getTarget();
                           } else {
                              var10007 = null;
                           }

                           var10001 = new ClipContext(var82, var87, var95, var10006, var10007);
                           x_pos = (double)var75.clip(var10001).getBlockPos().getX();
                           LivingEntity var76;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var76 = _mobEnt.getTarget();
                           } else {
                              var76 = null;
                           }

                           Level var77 = ((Entity)var76).level();

                           LivingEntity var83;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var83 = _mobEnt.getTarget();
                           } else {
                              var83 = null;
                           }

                           Vec3 var84 = ((Entity)var83).getEyePosition(1.0F);
                           LivingEntity var89;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var89 = _mobEnt.getTarget();
                           } else {
                              var89 = null;
                           }

                           Vec3 var90 = ((Entity)var89).getEyePosition(1.0F);
                           LivingEntity var96;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var96 = _mobEnt.getTarget();
                           } else {
                              var96 = null;
                           }

                           var90 = var90.add(((Entity)var96).getViewVector(1.0F).scale(0.0));
                           ClipContext.Block var97 = Block.OUTLINE;
                           var10006 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.getTarget();
                           } else {
                              var10007 = null;
                           }

                           var10001 = new ClipContext(var84, var90, var97, var10006, var10007);
                           y_pos = (double)var77.clip(var10001).getBlockPos().getY();
                           LivingEntity var78;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var78 = _mobEnt.getTarget();
                           } else {
                              var78 = null;
                           }

                           Level var79 = ((Entity)var78).level();
                           LivingEntity var85;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var85 = _mobEnt.getTarget();
                           } else {
                              var85 = null;
                           }

                           Vec3 var86 = ((Entity)var85).getEyePosition(1.0F);
                           LivingEntity var92;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var92 = _mobEnt.getTarget();
                           } else {
                              var92 = null;
                           }

                           Vec3 var93 = ((Entity)var92).getEyePosition(1.0F);
                           LivingEntity var98;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var98 = _mobEnt.getTarget();
                           } else {
                              var98 = null;
                           }

                           var93 = var93.add(((Entity)var98).getViewVector(1.0F).scale(0.0));
                           ClipContext.Block var99 = Block.OUTLINE;
                           var10006 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.getTarget();
                           } else {
                              var10007 = null;
                           }

                           var10001 = new ClipContext(var86, var93, var99, var10006, var10007);
                           z_pos = (double)var79.clip(var10001).getBlockPos().getZ();
                        } else {
                           x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                           y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                           z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                        }

                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                        entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                        entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
                        entity.getPersistentData().putDouble("yaw_fix", 0.0);
                        entity.getPersistentData().putDouble("pitch_fix", 0.0);
                        entity.getPersistentData().putDouble("old_x", x);
                        entity.getPersistentData().putDouble("old_y", y);
                        entity.getPersistentData().putDouble("old_z", z);
                        entity.getPersistentData().putDouble("cnt1", 14.0);
                        entity.getPersistentData().putDouble("cnt2", 1.0);
                     }
                  } else {
                     entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 9999.0F);
                  }
               } else {
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 9999.0F);
               }
            } else {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 9999.0F);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") >= 15.0) {
            if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt2") > 1.0) {
                  entity.getPersistentData().putDouble("cnt2", 1.0);
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                  if (entity.getPersistentData().getDouble("move") == 0.0) {
                     if (entity.getPersistentData().getDouble("cnt3") % 2.0 == 1.0) {
                        entity.getPersistentData().putDouble("yaw_fix", 30.0 + Math.random() * 22.5);
                     } else {
                        entity.getPersistentData().putDouble("yaw_fix", (30.0 + Math.random() * 22.5) * -1.0);
                     }

                     if (entity.getPersistentData().getDouble("cnt3") % 6.0 <= 2.0) {
                        entity.getPersistentData().putDouble("pitch_fix", 20.0 + Math.random() * 10.0);
                     } else {
                        entity.getPersistentData().putDouble("pitch_fix", (20.0 + Math.random() * 10.0) * -1.0);
                     }
                  }
               }

               x_pos = entity.getPersistentData().getDouble("old_x");
               y_pos = entity.getPersistentData().getDouble("old_y");
               z_pos = entity.getPersistentData().getDouble("old_z");
               x_power = x - x_pos;
               y_power = y - y_pos;
               z_power = z - z_pos;
               loop_num = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (loop_num > 0.0) {
                  x_power /= loop_num;
                  y_power /= loop_num;
                  z_power /= loop_num;

                  for(int index0 = 0; index0 < (int)Math.ceil(loop_num * 10.0); ++index0) {
                     if (Math.abs(entity.getDeltaMovement().x()) > Math.abs(entity.getDeltaMovement().z())) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.471 0.000 0.000 1 ~ ~ ~ 0.0 0.0 0.2 1 1 force");
                        }
                     } else if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.471 0.000 0.000 1 ~ ~ ~ 0.2 0.0 0.0 1 1 force");
                     }

                     x_pos += x_power * 0.1;
                     y_pos += y_power * 0.1;
                     z_pos += z_power * 0.1;
                  }
               }

               entity.getPersistentData().putDouble("old_x", x);
               entity.getPersistentData().putDouble("old_y", y);
               entity.getPersistentData().putDouble("old_z", z);
               if (!entity.getPersistentData().getBoolean("Stop")) {
                  entity.setYRot((float)(entity.getPersistentData().getDouble("yaw") + entity.getPersistentData().getDouble("yaw_fix")));
                  entity.setXRot((float)(entity.getPersistentData().getDouble("pitch") + entity.getPersistentData().getDouble("pitch_fix")));
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                  entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, entity.getPersistentData().getDouble("y_power") * 0.75, entity.getPersistentData().getDouble("z_power") * 0.75));
                  BulletDomainHit2Procedure.execute(world, entity);
               } else {
                  entity.getPersistentData().putBoolean("Stop", false);
               }
            }

            entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
            entity.getPersistentData().putDouble("Range", 4.0);
            entity.getPersistentData().putDouble("knockback", 1.0);
            entity.getPersistentData().putDouble("effect", 11.0);
            RangeAttackProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("BlockRange", 1.0);
            entity.getPersistentData().putDouble("BlockDamage", 1.0 * CNT6);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         }

         if (entity.isInWaterRainOrBubble()) {
            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 9999.0F);
         }

         if (!entity.isAlive() || entity.getPersistentData().getDouble("cnt1") > 45.0) {
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, 10, 0.2, 0.2, 0.2, 0.1);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
