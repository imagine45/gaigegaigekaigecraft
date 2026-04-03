package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletBloodProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class WingKingAttackProcedure {
   public WingKingAttackProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double damage = 0.0;
         if (entity.getPersistentData().getDouble("cnt2") <= 3.0) {
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

               double var47 = ((Entity)var10000).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var47 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var48;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var48 = _mobEnt.getTarget();
               } else {
                  var48 = null;
               }

               z_pos = ((Entity)var48).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 3.0 && entity.getPersistentData().getDouble("cnt1") % 3.0 == 1.0) {
               entity.getPersistentData().putDouble("Damage", 1.5);
               DamageFixProcedure.execute(entity);
               damage = entity.getPersistentData().getDouble("Damage");
               yaw = (double)entity.getYRot();
               picth = (double)entity.getXRot();
               if (entity.getPersistentData().getDouble("cnt2") % 2.0 == 1.0) {
                  yaw2 = yaw + 112.5;
               } else {
                  yaw2 = yaw - 112.5;
               }

               pitch2 = entity.getPersistentData().getDouble("cnt2") * -22.5;
               entity.setYRot((float)yaw2);
               entity.setXRot((float)pitch2);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = InlineMethodHandler.getArrowBulletBlood(projectileLevel, entity, (float)damage, 0);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.setYRot((float)yaw);
               entity.setXRot((float)picth);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (entity.getPersistentData().getDouble("cnt1") > 5.0) {
                  entity.getPersistentData().putDouble("cnt1", 2.0);
                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt1") > 15.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         entity.getPersistentData().putDouble("Damage", 9.0);
         DamageFixProcedure.execute(entity);
      }
   }
}
