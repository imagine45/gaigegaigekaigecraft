package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackBeastProcedure {
   public AttackBeastProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double level_jump = 0.0;
         double level = 0.0;
         double level_speed = 0.0;
         double dis = 0.0;
         double distance = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") % 20.0 == 5.0 && GetDistanceProcedure.execute(entity) > 6.0) {
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

               x_pos = ((Entity)var10000).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var50 = ((Entity)var10000).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var50 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var51;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var51 = _mobEnt.getTarget();
               } else {
                  var51 = null;
               }

               z_pos = ((Entity)var51).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            } else if (!(entity instanceof Player)) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     rotate = true;
                     x_pos = entityiterator.getX();
                     y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                     z_pos = entityiterator.getZ();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     break;
                  }
               }
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            GetPowerFixProcedure.execute(entity);
            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, entity.getPersistentData().getDouble("y_power") * 0.75 + 0.25, entity.getPersistentData().getDouble("z_power") * 0.75));
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 5, 0.1, 0.0, 0.1, 0.25);
            }
         }

         entity.getPersistentData().putDouble("Damage", 9.0);
         entity.getPersistentData().putDouble("Range", (double)(2.0F + entity.getBbHeight()));
         entity.getPersistentData().putDouble("knockback", Math.random() * 1.25);
         entity.getPersistentData().putDouble("effect", 8.0);
         entity.getPersistentData().putBoolean("swing", true);
         entity.getPersistentData().putBoolean("attack", true);
         RangeAttackProcedure.execute(world, x, y + (double)entity.getBbHeight() * 0.5, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 40.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
