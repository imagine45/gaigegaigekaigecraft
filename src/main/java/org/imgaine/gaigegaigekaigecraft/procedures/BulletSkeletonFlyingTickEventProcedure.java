package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class BulletSkeletonFlyingTickEventProcedure {
   public BulletSkeletonFlyingTickEventProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double power = 0.0;
         double repeat_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double max_power = 0.0;
         double energy = 0.0;
         double old_skill = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         immediatesourceentity.getPersistentData().putDouble("cnt_life", immediatesourceentity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
            immediatesourceentity.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
            immediatesourceentity.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().putDouble("old_x", x - immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("old_y", y - immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("old_z", z - immediatesourceentity.getDeltaMovement().z());
            immediatesourceentity.getPersistentData().putDouble("Damage", 15.0);
            immediatesourceentity.setNoGravity(true);
         }

         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") < 20.0) {
            x_power = entity.getX() - x;
            y_power = entity.getY() - y;
            z_power = entity.getZ() - z;
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               Level var86 = ((Entity)var10000).level();
               ClipContext var10001;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.getTarget();
               } else {
                  var10003 = null;
               }

               Vec3 var93 = ((Entity)var10003).getEyePosition(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               Vec3 var98 = ((Entity)var10004).getEyePosition(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               var98 = var98.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var106 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var93, var98, var106, var10006, var10007);
               x_power = (double)var86.clip(var10001).getBlockPos().getX() - x;
               LivingEntity var87;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var87 = _mobEnt.getTarget();
               } else {
                  var87 = null;
               }

               Level var88 = ((Entity)var87).level();
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.getTarget();
               } else {
                  var94 = null;
               }

               Vec3 var95 = ((Entity)var94).getEyePosition(1.0F);
               LivingEntity var100;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var100 = _mobEnt.getTarget();
               } else {
                  var100 = null;
               }

               Vec3 var101 = ((Entity)var100).getEyePosition(1.0F);
               LivingEntity var107;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var107 = _mobEnt.getTarget();
               } else {
                  var107 = null;
               }

               var101 = var101.add(((Entity)var107).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var108 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var95, var101, var108, var10006, var10007);
               y_power = (double)var88.clip(var10001).getBlockPos().getY() - y;
               LivingEntity var89;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var89 = _mobEnt.getTarget();
               } else {
                  var89 = null;
               }

               Level var90 = ((Entity)var89).level();
               LivingEntity var96;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.getTarget();
               } else {
                  var96 = null;
               }

               Vec3 var97 = ((Entity)var96).getEyePosition(1.0F);
               LivingEntity var103;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var103 = _mobEnt.getTarget();
               } else {
                  var103 = null;
               }

               Vec3 var104 = ((Entity)var103).getEyePosition(1.0F);
               LivingEntity var109;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var109 = _mobEnt.getTarget();
               } else {
                  var109 = null;
               }

               var104 = var104.add(((Entity)var109).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var110 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var97, var104, var110, var10006, var10007);
               z_power = (double)var90.clip(var10001).getBlockPos().getZ() - z;
            } else {
               x_power = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() - x;
               y_power = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() - y;
               z_power = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() - z;
            }

            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis != 0.0) {
               x_power = x_power / dis * 1.25;
               y_power = y_power / dis * 1.25;
               z_power = z_power / dis * 1.25;
               if (immediatesourceentity.getDeltaMovement().x() > x_power) {
                  x_power = immediatesourceentity.getDeltaMovement().x() - 0.15;
               } else {
                  x_power = immediatesourceentity.getDeltaMovement().x() + 0.15;
               }

               if (immediatesourceentity.getDeltaMovement().y() > y_power) {
                  y_power = immediatesourceentity.getDeltaMovement().y() - 0.15;
               } else {
                  y_power = immediatesourceentity.getDeltaMovement().y() + 0.15;
               }

               if (immediatesourceentity.getDeltaMovement().z() > z_power) {
                  z_power = immediatesourceentity.getDeltaMovement().z() - 0.15;
               } else {
                  z_power = immediatesourceentity.getDeltaMovement().z() + 0.15;
               }

               immediatesourceentity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
            }
         }

         old_skill = entity.getPersistentData().getDouble("skill");
         old_cooldown = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
         entity.getPersistentData().putDouble("skill", immediatesourceentity.getPersistentData().getDouble("skill"));
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().getDouble("COOLDOWN_TICKS"));
         x_pos = immediatesourceentity.getPersistentData().getDouble("old_x");
         y_pos = immediatesourceentity.getPersistentData().getDouble("old_y");
         z_pos = immediatesourceentity.getPersistentData().getDouble("old_z");
         x_power = x - x_pos;
         y_power = y - y_pos;
         z_power = z - z_pos;
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > 1.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         for(int index0 = 0; index0 < (int)Math.round(Math.max(dis * 2.0, 1.0)); ++index0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SOUL, x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.1);
            }

            entity.getPersistentData().putDouble("Damage", immediatesourceentity.getPersistentData().getDouble("Damage"));
            entity.getPersistentData().putDouble("Range", 3.0);
            entity.getPersistentData().putDouble("knockback", 0.25);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            AIBulletProcedure.execute();
            x_pos += x_power * 0.5;
            y_pos += y_power * 0.5;
            z_pos += z_power * 0.5;
         }

         immediatesourceentity.getPersistentData().putDouble("old_x", x);
         immediatesourceentity.getPersistentData().putDouble("old_y", y);
         immediatesourceentity.getPersistentData().putDouble("old_z", z);
         entity.getPersistentData().putDouble("skill", old_skill);
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
         immediatesourceentity.getPersistentData().putDouble("Damage", Math.max(immediatesourceentity.getPersistentData().getDouble("Damage") * 0.99, 10.0));
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") > 40.0 && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
