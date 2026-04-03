package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AIKillerProcedure {
   public AIKillerProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         Entity owner_uuid = null;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               double var53 = ((Entity)var10004).getX();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               double var56 = ((Entity)var10005).getY();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.getTarget();
               } else {
                  var10006 = null;
               }

               var56 += (double)((Entity)var10006).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.getTarget();
               } else {
                  var10006 = null;
               }

               var10002 = new Vec3(var53, var56, ((Entity)var10006).getZ());
               entity.lookAt(var10001, var10002);
            }

            entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_x2") > 100.0 && !entity.level().isClientSide()) {
               entity.discard();
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
               }

               CompoundTag var45 = entity.getPersistentData();
               LivingEntity var49;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.getTarget();
               } else {
                  var49 = null;
               }

               var45.putDouble("x_pos", ((Entity)var49).getX());
               var45 = entity.getPersistentData();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.getTarget();
               } else {
                  var49 = null;
               }

               var45.putDouble("y_pos", ((Entity)var49).getY());
               var45 = entity.getPersistentData();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.getTarget();
               } else {
                  var49 = null;
               }

               var45.putDouble("z_pos", ((Entity)var49).getZ());
               x_pos = entity.getPersistentData().getDouble("x_pos") - x;
               y_pos = entity.getPersistentData().getDouble("y_pos") - y;
               z_pos = entity.getPersistentData().getDouble("z_pos") - z;
               dis = Math.sqrt(Math.pow(x_pos, 2.0) + Math.pow(y_pos, 2.0) + Math.pow(z_pos, 2.0));
               if (dis > 3.0) {
                  x_pos = x_pos / dis * 0.2;
                  y_pos = y_pos / dis * 0.2;
                  z_pos = z_pos / dis * 0.2;
                  entity.teleportTo(entity.getX() + x_pos, entity.getY() + y_pos, entity.getZ() + z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX() + x_pos, entity.getY() + y_pos, entity.getZ() + z_pos, entity.getYRot(), entity.getXRot());
                  }

                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  EntityAnchorArgument.Anchor var48 = Anchor.EYES;
                  Vec3 var52;
                  LivingEntity var54;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var54 = _mobEnt.getTarget();
                  } else {
                     var54 = null;
                  }

                  double var55 = ((Entity)var54).getX();
                  LivingEntity var58;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var58 = _mobEnt.getTarget();
                  } else {
                     var58 = null;
                  }

                  double var59 = ((Entity)var58).getY();
                  LivingEntity var62;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var62 = _mobEnt.getTarget();
                  } else {
                     var62 = null;
                  }

                  var59 += (double)((Entity)var62).getBbHeight() * 0.5;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var62 = _mobEnt.getTarget();
                  } else {
                     var62 = null;
                  }

                  var52 = new Vec3(var55, var59, ((Entity)var62).getZ());
                  entity.lookAt(var48, var52);
               } else {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

         if (entity.getPersistentData().getBoolean("Shikigami")) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }
         }

      }
   }
}
