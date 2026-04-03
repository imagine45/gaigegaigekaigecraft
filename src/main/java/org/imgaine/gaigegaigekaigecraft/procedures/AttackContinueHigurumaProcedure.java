package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AttackContinueHigurumaProcedure {
   public AttackContinueHigurumaProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean sword = false;
         boolean attack = false;
         boolean keep = false;
         double old_cnt1 = 0.0;
         double old_skill = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         sword = LogicSwordProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
               }
            }

            entity.getPersistentData().putDouble("Damage", 4.0);
            DamageFixProcedure.execute(entity);
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
               }
            }

            entity.getPersistentData().putDouble("cnt2", 0.0);
            old_cnt1 = entity.getPersistentData().getDouble("cnt1");
            old_skill = entity.getPersistentData().getDouble("skill");
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75;
            z_pos = entity.getZ();
            if (entity.getPersistentData().getDouble("cnt5") <= 100.0) {
               if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
                  if (entity.getPersistentData().getDouble("cnt5") > 40.0) {
                     keep = false;
                  } else {
                     keep = true;
                  }

                  if (!keep) {
                     entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
                  }
               }

               attack = entity.getPersistentData().getDouble("cnt5") % 2.0 == 1.0;
               if (attack || entity.getPersistentData().getDouble("cnt5") >= 100.0) {
                  if (entity.getPersistentData().getDouble("cnt5") >= 100.0) {
                     entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), 2.5));
                  } else {
                     entity.getPersistentData().putDouble("cnt6", -0.1 + entity.getPersistentData().getDouble("cnt5") * 0.01);
                  }

                  if (entity.getPersistentData().getDouble("cnt5") >= 100.0) {
                     AttackStrongProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  } else {
                     AttackWeakProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }

               entity.getPersistentData().putDouble("cnt1", old_cnt1);
               entity.getPersistentData().putDouble("skill", old_skill);
            } else if (entity.getPersistentData().getDouble("cnt5") > 110.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
