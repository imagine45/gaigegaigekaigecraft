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
            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label77;
               }
            }

            var10000 = 0;
         }

         double var42 = (double)Math.min(var10000, 50) * CNT6;
         double var45 = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
            double var44 = entity.getPersistentData().m_128459_("skill");
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity4.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-7.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity5.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
               }
            }

            AttackWeakProcedure.execute(world, x, y, z, entity);
            if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity7.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(0.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity8 = (LivingEntity)entity;
               if (_livingEntity8.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity8.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               entity.getPersistentData().m_128347_("skill", var44);
               entity.getPersistentData().m_128347_("cnt7", 1.0);
               entity.getPersistentData().m_128347_("cnt1", 0.0);
               entity.getPersistentData().m_128379_("attack", false);
               double var51 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var48 = Math.toRadians((double)entity.m_146909_());
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var51) * Math.cos(var48) * 0.0);
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(var48) * -1.0 * 0.0);
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var51) * Math.cos(var48) * 0.0);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 0.5 * var45);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 0.5 * var45);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 0.5 * var45);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt31 = (LivingEntity)entity;
               if (_livEnt31.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
                  return;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 0.0) {
               label65: {
                  CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.2;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label65;
                     }
                  }

                  var10000 = 0;
               }

               var42 = (double)Math.min(var10000, 50) * CNT6;
               var45 = Math.pow(ReturnEntitySizeProcedure.execute(entity), 2.0);
               double var52 = 11.0;

               for(int index0 = 0; index0 < (int)var52; ++index0) {
                  entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"));
                  double var47 = entity.getPersistentData().m_128459_("x_pos");
                  double var49 = entity.getPersistentData().m_128459_("y_pos");
                  double var50 = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128347_("Damage", 12.0 * CNT6);
                  entity.getPersistentData().m_128347_("knockback", 0.25 * CNT6);
                  entity.getPersistentData().m_128347_("Range", 4.0 * var45);
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, var47, var49, var50, entity);
               }

               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
