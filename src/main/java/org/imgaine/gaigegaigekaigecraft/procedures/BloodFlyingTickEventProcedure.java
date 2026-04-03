package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BloodFlyingTickEventProcedure {
   public BloodFlyingTickEventProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double power = 0.0;
         double repeat_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double old_skill = 0.0;
         double old_cooldown = 0.0;
         double damage = 0.0;
         double num = 0.0;
         BulletDomainHitProcedure.execute(world, entity, immediatesourceentity);
         immediatesourceentity.getPersistentData().putDouble("cnt_life", immediatesourceentity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
            immediatesourceentity.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
            immediatesourceentity.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().putDouble("old_x", x - immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("old_y", y - immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("old_z", z - immediatesourceentity.getDeltaMovement().z());
            immediatesourceentity.getPersistentData().putDouble("speed", Math.sqrt(immediatesourceentity.getDeltaMovement().x() * immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getDeltaMovement().y() * immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getDeltaMovement().z() * immediatesourceentity.getDeltaMovement().z()));
            immediatesourceentity.getPersistentData().putDouble("Damage", 15.0 * (1.0 + immediatesourceentity.getPersistentData().getDouble("cnt6") * 0.1));
            immediatesourceentity.setNoGravity(true);
         }

         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") < 20.0) {
            if (immediatesourceentity.getPersistentData().getDouble("cnt_life") < 5.0 && immediatesourceentity.getPersistentData().getDouble("skill") == 1018.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y, z, 5, 0.1, 0.1, 0.1, 0.5);
            }

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

               Level var81 = ((Entity)var10000).level();
               ClipContext var10001;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.getTarget();
               } else {
                  var10003 = null;
               }

               Vec3 var88 = ((Entity)var10003).getEyePosition(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               Vec3 var93 = ((Entity)var10004).getEyePosition(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               var93 = var93.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var101 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var88, var93, var101, var10006, var10007);
               x_power = (double)var81.clip(var10001).getBlockPos().getX() - x;
               LivingEntity var82;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var82 = _mobEnt.getTarget();
               } else {
                  var82 = null;
               }

               Level var83 = ((Entity)var82).level();
               LivingEntity var89;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var89 = _mobEnt.getTarget();
               } else {
                  var89 = null;
               }

               Vec3 var90 = ((Entity)var89).getEyePosition(1.0F);
               LivingEntity var95;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var95 = _mobEnt.getTarget();
               } else {
                  var95 = null;
               }

               Vec3 var96 = ((Entity)var95).getEyePosition(1.0F);
               LivingEntity var102;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var102 = _mobEnt.getTarget();
               } else {
                  var102 = null;
               }

               var96 = var96.add(((Entity)var102).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var103 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var90, var96, var103, var10006, var10007);
               y_power = (double)var83.clip(var10001).getBlockPos().getY() - y;
               LivingEntity var84;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.getTarget();
               } else {
                  var84 = null;
               }

               Level var85 = ((Entity)var84).level();
               LivingEntity var91;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.getTarget();
               } else {
                  var91 = null;
               }

               Vec3 var92 = ((Entity)var91).getEyePosition(1.0F);
               LivingEntity var98;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var98 = _mobEnt.getTarget();
               } else {
                  var98 = null;
               }

               Vec3 var99 = ((Entity)var98).getEyePosition(1.0F);
               LivingEntity var104;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var104 = _mobEnt.getTarget();
               } else {
                  var104 = null;
               }

               var99 = var99.add(((Entity)var104).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var105 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var92, var99, var105, var10006, var10007);
               z_power = (double)var85.clip(var10001).getBlockPos().getZ() - z;
            } else {
               x_power = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() - x;
               y_power = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() - y;
               z_power = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() - z;
            }

            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis != 0.0) {
               x_power = x_power / dis * 3.0;
               y_power = y_power / dis * 3.0;
               z_power = z_power / dis * 3.0;
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
         if (dis > 0.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         damage = immediatesourceentity.getPersistentData().getDouble("Damage");
         repeat_num = (double)Math.round(Math.max(dis * 5.0, 1.0));

         for(int index0 = 0; index0 < (int)repeat_num; ++index0) {
            ++dis;
            if (immediatesourceentity.getPersistentData().getDouble("skill") == 1018.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.471 0.000 0.000 1 ~ ~ ~ 0 0 0 1 1 force");
               }
            } else if (immediatesourceentity.getPersistentData().getDouble("skill") == 2307.0) {
               if (immediatesourceentity.getPersistentData().getDouble("cnt_life") > 2.0) {
                  ParticleGeneratorProcedure.execute(world, 0.1, 1.0, 25.0, 0.5, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, Math.random() < 0.25 ? "minecraft:squid_ink" : "gaigegaigekaigecraft:particle_cockroach");
               }
            } else if (immediatesourceentity.getPersistentData().getDouble("skill") == 3912.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.000 0.000 0.000 1 ~ ~ ~ 0 0 0 1 1 force");
            }

            if (dis > 0.0) {
               dis = -5.0;
               entity.getPersistentData().putDouble("Damage", damage);
               entity.getPersistentData().putDouble("knockback", 0.5);
               if (immediatesourceentity.getPersistentData().getDouble("skill") == 1018.0) {
                  entity.getPersistentData().putDouble("Range", 0.0);
                  entity.getPersistentData().putDouble("effect", 11.0);
               } else if (immediatesourceentity.getPersistentData().getDouble("skill") == 2307.0) {
                  entity.getPersistentData().putDouble("Range", 4.0);
                  entity.getPersistentData().putDouble("effect", 1.0);
               } else {
                  entity.getPersistentData().putDouble("Range", 0.0);
                  entity.getPersistentData().putDouble("effect", 0.0);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               AIBulletProcedure.execute();
            }

            x_pos += x_power * 0.2;
            y_pos += y_power * 0.2;
            z_pos += z_power * 0.2;
         }

         immediatesourceentity.getPersistentData().putDouble("old_x", x);
         immediatesourceentity.getPersistentData().putDouble("old_y", y);
         immediatesourceentity.getPersistentData().putDouble("old_z", z);
         entity.getPersistentData().putDouble("skill", old_skill);
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
         immediatesourceentity.getPersistentData().putDouble("Damage", Math.max(immediatesourceentity.getPersistentData().getDouble("Damage") * 0.99, 9.0));
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") > 80.0 && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
