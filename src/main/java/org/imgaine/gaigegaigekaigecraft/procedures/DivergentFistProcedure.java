package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class DivergentFistProcedure {
   public DivergentFistProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6;
         int var10000;
         label77: {
            CNT6 = 0.0;
            double strength = 0.0;
            double old_skill = 0.0;
            double old_cooldownticks = 0.0;
            double old_level = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double pitch = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double old_tick = 0.0;
            double yaw = 0.0;
            double weapon_size = 0.0;
            double loop_num = 0.0;
            double attack_reach = 0.0;
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label77;
               }
            }

            var10000 = 0;
         }

         double var42 = (double)Math.min(var10000, 50) * CNT6;
         double var45 = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
            double var44 = entity.getPersistentData().getDouble("skill");
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            AttackWeakProcedure.execute(world, x, y, z, entity);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity8 = (LivingEntity)entity;
               if (_livingEntity8.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity8.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               entity.getPersistentData().putDouble("skill", var44);
               entity.getPersistentData().putDouble("cnt7", 1.0);
               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putBoolean("attack", false);
               double var51 = Math.toRadians((double)(entity.getYRot() + 90.0F));
               double var48 = Math.toRadians((double)entity.getXRot());
               entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(var51) * Math.cos(var48) * 0.0);
               entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(var48) * -1.0 * 0.0);
               entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(var51) * Math.cos(var48) * 0.0);
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.5 * var45);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.5 * var45);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.5 * var45);
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt31 = (LivingEntity)entity;
               if (_livEnt31.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  entity.getPersistentData().putDouble("skill", 0.0);
                  return;
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
               label65: {
                  CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label65;
                     }
                  }

                  var10000 = 0;
               }

               var42 = (double)Math.min(var10000, 50) * CNT6;
               var45 = Math.pow(ReturnEntitySizeProcedure.execute(entity), 2.0);
               double var52 = 11.0;

               for(int index0 = 0; index0 < (int)var52; ++index0) {
                  entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"));
                  double var47 = entity.getPersistentData().getDouble("x_pos");
                  double var49 = entity.getPersistentData().getDouble("y_pos");
                  double var50 = entity.getPersistentData().getDouble("z_pos");
                  entity.getPersistentData().putDouble("Damage", 12.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", 0.25 * CNT6);
                  entity.getPersistentData().putDouble("Range", 4.0 * var45);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, var47, var49, var50, entity);
               }

               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
