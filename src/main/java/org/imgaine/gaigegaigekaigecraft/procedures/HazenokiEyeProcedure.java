package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletEyeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.BulletToothEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class HazenokiEyeProcedure {
   public HazenokiEyeProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

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

            double var20 = ((Entity)var10000).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            y_pos = var20 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var21;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var21 = _mobEnt.getTarget();
            } else {
               var21 = null;
            }

            z_pos = ((Entity)var21).getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         Level projectileLevel = entity.level();
         if (!projectileLevel.isClientSide()) {
            Projectile _entityToSpawn = entity.getPersistentData().getDouble("skill") == 4510.0 ? ((new InlineMethodHandler() {
               public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new BulletEyeEntity((EntityType)JujutsucraftModEntities.BULLET_EYE.get(), level);
                  entityToSpawn.setOwner(shooter);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setCritArrow(true);
                  return entityToSpawn;
               }
            })).getArrowO(projectileLevel, entity, 0.0F, 0) : ((new InlineMethodHandler() {
               public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new BulletToothEntity((EntityType)JujutsucraftModEntities.BULLET_TOOTH.get(), level);
                  entityToSpawn.setOwner(shooter);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setCritArrow(true);
                  return entityToSpawn;
               }
            })).getArrowO(projectileLevel, entity, 0.0F, 0);
            _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.0F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
