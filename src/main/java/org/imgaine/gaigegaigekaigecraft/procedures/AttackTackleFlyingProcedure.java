package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiRikaDhruvEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaCursedSpiritEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackTackleFlyingProcedure {
   public AttackTackleFlyingProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean berserker = false;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         boolean projection_sorcery = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_skill = 0.0;
         double dis = 0.0;
         double speed = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix = 0.0;
         double rnd = 0.0;
         double y_fix_height = 0.0;
         double test_x = 0.0;
         double test_y = 0.0;
         double test_z = 0.0;
         double old_mode = 0.0;
         double distance = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.fallDistance = 0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         targeting = var10000 instanceof LivingEntity;
         if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
            int var110;
            if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
               ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
               var110 = (Integer)_datEntI.getEntityData().get(ZeninNaoyaCursedSpiritEntity.DATA_form);
            } else {
               var110 = 0;
            }

            label242: {
               if (var110 != 0) {
                  if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                     ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
                     var110 = (Integer)_datEntI.getEntityData().get(ZeninNaoyaCursedSpiritEntity.DATA_form);
                  } else {
                     var110 = 0;
                  }

                  if (var110 != 2) {
                     var110 = 0;
                     break label242;
                  }
               }

               var110 = 1;
            }

            projection_sorcery = var110 != 0;
            if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "fly");
            }
         }

         speed = projection_sorcery ? 2.0 : 1.0;
         int var113;
         if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
            ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
            var113 = (Integer)_datEntI.getEntityData().get(ZeninNaoyaCursedSpiritEntity.DATA_form);
         } else {
            var113 = 0;
         }

         if (var113 == 2) {
            speed = 3.0;
         }

         dis = GetDistanceProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt1") > 10.0 && projection_sorcery && Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().y(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0)) > 3.0 && Math.sqrt(Math.pow(entity.getX() - entity.getPersistentData().getDouble("old_x"), 2.0) + Math.pow(entity.getY() - entity.getPersistentData().getDouble("old_y"), 2.0) + Math.pow(entity.getZ() - entity.getPersistentData().getDouble("old_z"), 2.0)) > 1.0) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y + (double)entity.getBbHeight() * 0.5, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
               } else {
                  _level.playLocalSound(x, y + (double)entity.getBbHeight() * 0.5, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x, y + (double)entity.getBbHeight() * 0.5, z, 5, 1.0, 1.0, 1.0, 1.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.EXPLOSION, x, y + (double)entity.getBbHeight() * 0.5, z, 5, 1.0, 1.0, 1.0, 1.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") % 2.0 == 1.0) {
               entity.getPersistentData().putDouble("BlockRange", 8.0);
               entity.getPersistentData().putDouble("BlockDamage", 0.33);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x, y + (double)entity.getBbHeight() * 0.5, z, entity);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            entity.getPersistentData().putDouble("cnt4", (double)(Math.random() < 0.5 ? 1 : -1));
            if (targeting) {
               if (dis < 32.0) {
                  LivingEntity var114;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var114 = _mobEnt.getTarget();
                  } else {
                     var114 = null;
                  }

                  x_pos = ((Entity)var114).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var114 = _mobEnt.getTarget();
                  } else {
                     var114 = null;
                  }

                  double var116 = ((Entity)var114).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var116 + (double)((Entity)var10001).getBbHeight() * 0.9;
                  LivingEntity var117;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var117 = _mobEnt.getTarget();
                  } else {
                     var117 = null;
                  }

                  z_pos = ((Entity)var117).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               } else {
                  entity.getPersistentData().putDouble("cnt1", 10.0);
               }
            }

            entity.setYRot(entity.getYRot());
            entity.setXRot(45.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putBoolean("canFly", true);
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * -3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * -3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * -3.0);
            GetPowerFixProcedure.execute(entity);
            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * speed, entity.getPersistentData().getDouble("y_power") * speed, entity.getPersistentData().getDouble("z_power") * speed));
            distance = (double)(-16.0F - entity.getBbWidth());
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance);
            entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance);
            entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance);
         } else if (entity.getPersistentData().getDouble("cnt1") <= 50.0) {
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               entity.getPersistentData().putDouble("cnt2", 1.0);
               x_pos = entity.getPersistentData().getDouble("x_pos");
               y_pos = entity.getPersistentData().getDouble("y_pos");
               z_pos = entity.getPersistentData().getDouble("z_pos");
               y_fix = 0.0;

               for(int index0 = 0; index0 < 255 && world.isEmptyBlock(BlockPos.containing(x_pos, y_pos - y_fix, z_pos)); ++index0) {
                  if (y_pos - y_fix < 0.0) {
                     y_fix = 255.0;
                     break;
                  }

                  ++y_fix;
               }

               if (y_fix > 24.0) {
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - (y_fix - 24.0));
               } else if (y_fix < 16.0) {
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + 16.0 - y_fix);
               }

               if (targeting) {
                  CompoundTag var118 = entity.getPersistentData();
                  double var10002 = entity.getPersistentData().getDouble("y_pos");
                  LivingEntity var10003;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10003 = _mobEnt.getTarget();
                  } else {
                     var10003 = null;
                  }

                  double var124 = ((Entity)var10003).getY();
                  LivingEntity var10004;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10004 = _mobEnt.getTarget();
                  } else {
                     var10004 = null;
                  }

                  var118.putDouble("y_pos", Math.max(var10002, var124 + (double)((Entity)var10004).getBbHeight() * 0.9 + 8.0));
               }
            }

            if (!projection_sorcery) {
               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 30.0));
            }

            if (dis > 64.0) {
               entity.getPersistentData().putDouble("cnt1", 50.0);
            } else {
               RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
               dis = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_pos") - entity.getX(), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_pos") - (entity.getY() + (double)entity.getBbHeight() * 0.9), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_pos") - entity.getZ(), 2.0));
               entity.setYRot((float)((double)entity.getYRot() + 100.0 * (1.0 - Math.min(Math.max(dis - 16.0, 0.0), 16.0) / 16.0) * entity.getPersistentData().getDouble("cnt4")));
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

               distance = (double)(64.0F + entity.getBbWidth());
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
               entity.getPersistentData().putBoolean("canFly", true);
               GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * speed, entity.getPersistentData().getDouble("y_power") * speed, entity.getPersistentData().getDouble("z_power") * speed));
            }
         } else {
            if (entity.getPersistentData().getDouble("cnt2") != 2.0) {
               entity.getPersistentData().putDouble("cnt2", 2.0);
               if (entity instanceof ShikigamiRikaDhruvEntity) {
                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.5);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.5);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.5);
               } else {
                  if (targeting) {
                     LivingEntity var119;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var119 = _mobEnt.getTarget();
                     } else {
                        var119 = null;
                     }

                     x_pos = ((Entity)var119).getX();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var119 = _mobEnt.getTarget();
                     } else {
                        var119 = null;
                     }

                     double var121 = ((Entity)var119).getY();
                     LivingEntity var123;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var123 = _mobEnt.getTarget();
                     } else {
                        var123 = null;
                     }

                     y_pos = var121 + (double)((Entity)var123).getBbHeight() * 0.75;
                     LivingEntity var122;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var122 = _mobEnt.getTarget();
                     } else {
                        var122 = null;
                     }

                     z_pos = ((Entity)var122).getZ();
                  } else {
                     distance = (double)(64.0F + entity.getBbWidth());
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     pitch = Math.toRadians((double)entity.getXRot());
                     x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
                     z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  }

                  entity.getPersistentData().putBoolean("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * speed, entity.getPersistentData().getDouble("y_power") * speed, entity.getPersistentData().getDouble("z_power") * speed));
            RotateEntityProcedure.execute(entity.getX() + entity.getPersistentData().getDouble("x_power") * 16.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getPersistentData().getDouble("y_power") * 16.0, entity.getZ() + entity.getPersistentData().getDouble("z_power") * 16.0, entity);
            x_pos = entity.getPersistentData().getDouble("old_x");
            y_pos = entity.getPersistentData().getDouble("old_y");
            z_pos = entity.getPersistentData().getDouble("old_z");
            vx = x_pos - x;
            vy = y_pos - y;
            vz = z_pos - z;
            dis = Math.sqrt(Math.pow(vx, 2.0) + Math.pow(vy, 2.0) + Math.pow(vz, 2.0));
            if (entity instanceof ShikigamiRikaDhruvEntity) {
               if (entity.getPersistentData().getDouble("cnt1") > 80.0) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            } else {
               if (dis > 0.0) {
                  vx /= dis;
                  vy /= dis;
                  vz /= dis;
                  entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power") * speed);
                  entity.getPersistentData().putDouble("y_knockback", 0.5);
                  entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power") * speed);

                  for(int index1 = 0; index1 < (int)Math.round(dis); ++index1) {
                     entity.getPersistentData().putDouble("Damage", 16.0 + Math.pow(speed, 2.0) * 2.0);
                     entity.getPersistentData().putDouble("Range", (double)(4.0F + entity.getBbHeight()));
                     entity.getPersistentData().putDouble("knockback", 0.1 * speed);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                     x_pos += vx * 1.0;
                     y_pos += vy * 1.0;
                     z_pos += vz * 1.0;
                  }

                  entity.getPersistentData().putDouble("x_knockback", 0.0);
                  entity.getPersistentData().putDouble("y_knockback", 0.0);
                  entity.getPersistentData().putDouble("z_knockback", 0.0);
               }

               if (dis < 24.0 && entity.getPersistentData().getDouble("cnt3") == 0.0) {
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt1"));
               }

               if (projection_sorcery) {
                  if (entity.getPersistentData().getDouble("cnt1") >= entity.getPersistentData().getDouble("cnt3") + 24.0 / Math.max(speed, 1.0) || entity.getPersistentData().getDouble("cnt1") > 80.0 + 24.0 / Math.max(speed, 1.0)) {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     entity.getPersistentData().putDouble("skill", 0.0);
                  }
               } else if (entity.getPersistentData().getDouble("cnt1") >= entity.getPersistentData().getDouble("cnt3") + 20.0 + 24.0 / Math.max(speed, 1.0) || entity.getPersistentData().getDouble("cnt1") > 115.0 + 24.0 / Math.max(speed, 1.0)) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

         entity.getPersistentData().putDouble("old_x", x);
         entity.getPersistentData().putDouble("old_y", y);
         entity.getPersistentData().putDouble("old_z", z);
      }
   }
}
