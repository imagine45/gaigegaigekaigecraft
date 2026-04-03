package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIRyuProcedure {
   public AIRyuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         boolean skull = false;
         boolean logic_a = false;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double loop_num = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double speed = 0.0;
         double size = 0.0;
         double pitch = 0.0;
         double pitch_cal = 0.0;
         double yaw = 0.0;
         double yaw_cal = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (entity.getPersistentData().getDouble("cnt_life") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 25, 0.25, 0.25, 0.25, 0.5);
            }
         }

         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (!entity.getPersistentData().getBoolean("Stop")) {
            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
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

                     Level var93 = ((Entity)var10000).level();
                     ClipContext var10001;
                     LivingEntity var10003;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10003 = _mobEnt.getTarget();
                     } else {
                        var10003 = null;
                     }

                     Vec3 var100 = ((Entity)var10003).getEyePosition(1.0F);
                     LivingEntity var10004;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10004 = _mobEnt.getTarget();
                     } else {
                        var10004 = null;
                     }

                     Vec3 var105 = ((Entity)var10004).getEyePosition(1.0F);
                     LivingEntity var10005;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10005 = _mobEnt.getTarget();
                     } else {
                        var10005 = null;
                     }

                     var105 = var105.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
                     ClipContext.Block var113 = Block.OUTLINE;
                     ClipContext.Fluid var10006 = Fluid.NONE;
                     LivingEntity var10007;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10007 = _mobEnt.getTarget();
                     } else {
                        var10007 = null;
                     }

                     var10001 = new ClipContext(var100, var105, var113, var10006, var10007);
                     x_pos = (double)var93.clip(var10001).getBlockPos().getX();
                     LivingEntity var94;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var94 = _mobEnt.getTarget();
                     } else {
                        var94 = null;
                     }

                     Level var95 = ((Entity)var94).level();
                     LivingEntity var101;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var101 = _mobEnt.getTarget();
                     } else {
                        var101 = null;
                     }

                     Vec3 var102 = ((Entity)var101).getEyePosition(1.0F);
                     LivingEntity var107;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var107 = _mobEnt.getTarget();
                     } else {
                        var107 = null;
                     }

                     Vec3 var108 = ((Entity)var107).getEyePosition(1.0F);
                     LivingEntity var114;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var114 = _mobEnt.getTarget();
                     } else {
                        var114 = null;
                     }

                     var108 = var108.add(((Entity)var114).getViewVector(1.0F).scale(0.0));
                     ClipContext.Block var115 = Block.OUTLINE;
                     var10006 = Fluid.NONE;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10007 = _mobEnt.getTarget();
                     } else {
                        var10007 = null;
                     }

                     var10001 = new ClipContext(var102, var108, var115, var10006, var10007);
                     y_pos = (double)var95.clip(var10001).getBlockPos().getY();
                     LivingEntity var96;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var96 = _mobEnt.getTarget();
                     } else {
                        var96 = null;
                     }

                     Level var97 = ((Entity)var96).level();
                     LivingEntity var103;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var103 = _mobEnt.getTarget();
                     } else {
                        var103 = null;
                     }

                     Vec3 var104 = ((Entity)var103).getEyePosition(1.0F);
                     LivingEntity var110;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var110 = _mobEnt.getTarget();
                     } else {
                        var110 = null;
                     }

                     Vec3 var111 = ((Entity)var110).getEyePosition(1.0F);
                     LivingEntity var116;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var116 = _mobEnt.getTarget();
                     } else {
                        var116 = null;
                     }

                     var111 = var111.add(((Entity)var116).getViewVector(1.0F).scale(0.0));
                     ClipContext.Block var117 = Block.OUTLINE;
                     var10006 = Fluid.NONE;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10007 = _mobEnt.getTarget();
                     } else {
                        var10007 = null;
                     }

                     var10001 = new ClipContext(var104, var111, var117, var10006, var10007);
                     z_pos = (double)var97.clip(var10001).getBlockPos().getZ();
                  } else {
                     dis = 8.0;
                     logic_a = false;

                     for(int index0 = 0; index0 < 8; ++index0) {
                        x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                        y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                        z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(12.0), (e) -> true)) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              logic_a = true;
                              x_pos = entityiterator.getX();
                              y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                              z_pos = entityiterator.getZ();
                              break;
                           }
                        }

                        dis += 8.0;
                        if (logic_a) {
                           break;
                        }
                     }
                  }
               }
            }

            dis = Math.sqrt(Math.pow(entity.getX() - x_pos, 2.0) + Math.pow(entity.getY() - y_pos, 2.0) + Math.pow(entity.getZ() - z_pos, 2.0));
            yaw = (double)(entity.getYRot() % 360.0F);
            pitch = (double)entity.getXRot();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (dis < 0.0 || dis > 14.0) {
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
               yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0)) ? 6 : -6);
               pitch = (double)entity.getXRot();
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
            }

            if (entity.getPersistentData().getDouble("cnt_life") == 1.0) {
               speed = 3.0;
            } else {
               speed = Math.min(3.0, Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().y(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0)) + 0.33);
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * speed);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * speed);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * speed);
            x_power = entity.getPersistentData().getDouble("x_power");
            y_power = entity.getPersistentData().getDouble("y_power");
            z_power = entity.getPersistentData().getDouble("z_power");
            entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
            dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
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
            entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x());
            entity.getPersistentData().putDouble("y_knockback", 0.5);
            entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z());
            speed = Math.min(Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().y(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0)), 3.0);

            for(int index1 = 0; index1 < (int)Math.round(dis); ++index1) {
               entity.getPersistentData().putDouble("Damage", 15.0 + speed * 3.0);
               entity.getPersistentData().putDouble("Range", 3.0 * size);
               entity.getPersistentData().putDouble("knockback", 0.5);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               x_pos -= x_power;
               y_pos -= y_power;
               z_pos -= z_power;
            }

            entity.getPersistentData().putDouble("x_knockback", 0.0);
            entity.getPersistentData().putDouble("y_knockback", 0.0);
            entity.getPersistentData().putDouble("z_knockback", 0.0);
            BulletDomainHit2Procedure.execute(world, entity);
         } else {
            entity.getPersistentData().putBoolean("Stop", true);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 120.0 && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
