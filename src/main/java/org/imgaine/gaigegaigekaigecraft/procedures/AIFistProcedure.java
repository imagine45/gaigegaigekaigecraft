package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFistProcedure {
   public AIFistProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double move = 0.0;
         double amount = 0.0;
         double CNT6 = 0.0;
         double entity_size = 0.0;
         double speed = 0.0;
         double distance = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double size = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double damage = 0.0;
         if (entity.isAlive()) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            move = entity.getPersistentData().getDouble("move");
            entity_size = ReturnEntitySizeProcedure.execute(entity) * 1.2;
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (entity.getPersistentData().getDouble("cnt6") >= 10.0) {
               entity_size *= 1.5;
            }

            if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  entity.getPersistentData().putDouble("cnt1", 10.0);
               }

               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
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

                        Level var87 = ((Entity)var10000).level();
                        ClipContext var10001;
                        LivingEntity var10003;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10003 = _mobEnt.getTarget();
                        } else {
                           var10003 = null;
                        }

                        Vec3 var97 = ((Entity)var10003).getEyePosition(1.0F);
                        LivingEntity var10004;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10004 = _mobEnt.getTarget();
                        } else {
                           var10004 = null;
                        }

                        Vec3 var102 = ((Entity)var10004).getEyePosition(1.0F);
                        LivingEntity var10005;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10005 = _mobEnt.getTarget();
                        } else {
                           var10005 = null;
                        }

                        var102 = var102.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var110 = Block.OUTLINE;
                        ClipContext.Fluid var10006 = Fluid.NONE;
                        LivingEntity var10007;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.getTarget();
                        } else {
                           var10007 = null;
                        }

                        var10001 = new ClipContext(var97, var102, var110, var10006, var10007);
                        x_pos = (double)var87.clip(var10001).getBlockPos().getX();
                        LivingEntity var88;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var88 = _mobEnt.getTarget();
                        } else {
                           var88 = null;
                        }

                        Level var89 = ((Entity)var88).level();
                        LivingEntity var98;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var98 = _mobEnt.getTarget();
                        } else {
                           var98 = null;
                        }

                        Vec3 var99 = ((Entity)var98).getEyePosition(1.0F);
                        LivingEntity var104;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var104 = _mobEnt.getTarget();
                        } else {
                           var104 = null;
                        }

                        Vec3 var105 = ((Entity)var104).getEyePosition(1.0F);
                        LivingEntity var111;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var111 = _mobEnt.getTarget();
                        } else {
                           var111 = null;
                        }

                        var105 = var105.add(((Entity)var111).getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var112 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.getTarget();
                        } else {
                           var10007 = null;
                        }

                        var10001 = new ClipContext(var99, var105, var112, var10006, var10007);
                        y_pos = (double)var89.clip(var10001).getBlockPos().getY();
                        LivingEntity var90;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var90 = _mobEnt.getTarget();
                        } else {
                           var90 = null;
                        }

                        Level var91 = ((Entity)var90).level();
                        LivingEntity var100;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var100 = _mobEnt.getTarget();
                        } else {
                           var100 = null;
                        }

                        Vec3 var101 = ((Entity)var100).getEyePosition(1.0F);
                        LivingEntity var107;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var107 = _mobEnt.getTarget();
                        } else {
                           var107 = null;
                        }

                        Vec3 var108 = ((Entity)var107).getEyePosition(1.0F);
                        LivingEntity var113;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var113 = _mobEnt.getTarget();
                        } else {
                           var113 = null;
                        }

                        var108 = var108.add(((Entity)var113).getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var114 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.getTarget();
                        } else {
                           var10007 = null;
                        }

                        var10001 = new ClipContext(var101, var108, var114, var10006, var10007);
                        z_pos = (double)var91.clip(var10001).getBlockPos().getZ();
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     } else {
                        x_pos = entity.getX() + entity_a.getLookAngle().x * 64.0;
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + entity_a.getLookAngle().y * 64.0;
                        z_pos = entity.getZ() + entity_a.getLookAngle().z * 64.0;
                     }

                     double var92 = x_pos + entity.getPersistentData().getDouble("x_pos");
                     var92 = y_pos + entity.getPersistentData().getDouble("y_pos");
                     var92 = z_pos + entity.getPersistentData().getDouble("z_pos");
                  }
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 10.0) {
               amount = move == 2.0 ? 1.0 : 5.0;
               distance = (double)entity.getBbWidth() * 0.5;
               speed = 0.7 + entity.getPersistentData().getDouble("speed");
               x_power = entity.getPersistentData().getDouble("x_power") * speed;
               y_power = entity.getPersistentData().getDouble("y_power") * speed;
               z_power = entity.getPersistentData().getDouble("z_power") * speed;
               x_pos = entity.getX();
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
               z_pos = entity.getZ();
               if (entity.getPersistentData().getDouble("cnt1") == 10.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(0.5 * Math.pow(CNT6, 2.0)), 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(0.5 * Math.pow(CNT6, 2.0)), 0.75F, false);
                  }
               }

               entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               if (!entity.getPersistentData().getBoolean("Stop")) {
                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  if (dis > 1.0) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                  } else {
                     dis = 1.0;
                  }

                  x_pos = entity.getX();
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                  z_pos = entity.getZ();
                  if (move == 0.0) {
                     entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 0.5 * CNT6);
                     if (entity.getPersistentData().getDouble("cnt_life") > 0.0) {
                        for(int index0 = 0; index0 < (int)Math.round(entity.getPersistentData().getDouble("cnt_life")); ++index0) {
                           entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 0.99);
                           if (entity.getPersistentData().getDouble("Damage") < 14.0) {
                              entity.getPersistentData().putDouble("Damage", 14.0);
                              break;
                           }
                        }
                     }
                  } else if (move == 1.0) {
                     entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
                     if (entity.getPersistentData().getDouble("cnt_life") > 0.0) {
                        for(int index1 = 0; index1 < (int)Math.round(entity.getPersistentData().getDouble("cnt_life")); ++index1) {
                           entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 0.99);
                           if (entity.getPersistentData().getDouble("Damage") < 11.0) {
                              entity.getPersistentData().putDouble("Damage", 11.0);
                              break;
                           }
                        }
                     }
                  } else if (move == 2.0) {
                     entity.getPersistentData().putDouble("Damage", 10.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 0.25 * CNT6);
                  }

                  damage = entity.getPersistentData().getDouble("Damage");

                  for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                     entity.getPersistentData().putDouble("Damage", damage);
                     entity.getPersistentData().putDouble("Range", 3.0 * entity_size);
                     entity.getPersistentData().putBoolean("attack", false);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (move == 1.0) {
                        entity.getPersistentData().putDouble("knockback", 1.0);
                        KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!entity.isInWall() && !InsideSolidCalculateProcedure.execute(world, entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                        entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                        }
                     } else if (!InsideSolidCalculateProcedure.execute(world, entity.getX() + x_power, entity.getY(), entity.getZ() + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                        entity.teleportTo(entity.getX() + x_power, entity.getY(), entity.getZ() + z_power);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY(), entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                        }
                     } else {
                        entity.getPersistentData().putDouble("BlockRange", 2.0 * entity_size);
                        entity.getPersistentData().putDouble("BlockDamage", 4.0 * CNT6);
                        entity.getPersistentData().putBoolean("noParticle", true);
                        entity.getPersistentData().putBoolean("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity);
                        if (InsideSolidCalculateProcedure.execute(world, entity.getX() + x_power, entity.getY() + (double)entity.getBbHeight() * 0.25 + y_power, entity.getZ() + z_power, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5)) {
                           break;
                        }
                     }
                  }

                  BulletDomainHit2Procedure.execute(world, entity);
                  if (entity.isInWall() || InsideSolidCalculateProcedure.execute(world, entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth()) || !entity.isAlive()) {
                     distance = (double)entity.getBbWidth() * 0.5;
                     x_pos = entity.getX() + x_power * distance;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + y_power * distance;
                     z_pos = entity.getZ() + z_power * distance;
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(4.0 * CNT6 * entity_size), 1.0 * entity_size, 1.0 * entity_size, 1.0 * entity_size, 0.25 * CNT6);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(2.0 * CNT6 * entity_size), 1.0 * entity_size, 1.0 * entity_size, 1.0 * entity_size, 0.5 * CNT6);
                     }

                     entity.getPersistentData().putDouble("BlockRange", 2.0 * entity_size);
                     entity.getPersistentData().putDouble("BlockDamage", 4.0 * CNT6);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     entity.getPersistentData().putBoolean("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (entity.getPersistentData().getDouble("cnt6") > 5.0 && entity.getPersistentData().getDouble("cnt3") == 0.0) {
                        entity.getPersistentData().putDouble("cnt3", 1.0);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)(25.0 * CNT6 * entity_size), 1.0 * entity_size, 1.0 * entity_size, 1.0 * entity_size, 1.0 * CNT6);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                        entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
                        entity.getPersistentData().putDouble("Range", 6.0 * entity_size);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 2.0);
                  }
               } else {
                  entity.getPersistentData().putBoolean("Stop", false);
               }

               entity.getPersistentData().putDouble("x_knockback", 0.0);
               entity.getPersistentData().putDouble("y_knockback", 0.0);
               entity.getPersistentData().putDouble("z_knockback", 0.0);
               entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 40.0 + entity.getPersistentData().getDouble("cnt6") && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
