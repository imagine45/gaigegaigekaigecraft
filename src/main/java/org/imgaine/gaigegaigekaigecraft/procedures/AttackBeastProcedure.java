package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") % 20.0 == 5.0 && GetDistanceProcedure.execute(entity) > 6.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var50 = ((Entity)var10000).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var50 + (double)((Entity)var10001).m_20206_() * 0.5;
               LivingEntity var51;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var51 = _mobEnt.m_5448_();
               } else {
                  var51 = null;
               }

               z_pos = ((Entity)var51).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            } else if (!(entity instanceof Player)) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(16.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     rotate = true;
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                     z_pos = entityiterator.m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     break;
                  }
               }
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
            GetPowerFixProcedure.execute(entity);
            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, entity.getPersistentData().m_128459_("y_power") * 0.75 + 0.25, entity.getPersistentData().m_128459_("z_power") * 0.75));
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 5, 0.1, 0.0, 0.1, 0.25);
            }
         }

         entity.getPersistentData().m_128347_("Damage", 9.0);
         entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20206_()));
         entity.getPersistentData().m_128347_("knockback", Math.random() * 1.25);
         entity.getPersistentData().m_128347_("effect", 8.0);
         entity.getPersistentData().m_128379_("swing", true);
         entity.getPersistentData().m_128379_("attack", true);
         RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * 0.5, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > 40.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
