package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit2Procedure {
   public AICursedSpirit2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         if (entity.isAlive()) {
            label59: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label59;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
               }
            }

            int var10000;
            label54: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label54;
                  }
               }

               var10000 = 0;
            }

            if (var10000 < 5 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 5, false, false));
               }
            }

            label48: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label48;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 1, false, false));
                  }
               }
            }

            LivingEntity var17;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var17 = _mobEnt.getTarget();
            } else {
               var17 = null;
            }

            if (var17 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }

            if (entity.getPersistentData().getDouble("skill") != 0.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
