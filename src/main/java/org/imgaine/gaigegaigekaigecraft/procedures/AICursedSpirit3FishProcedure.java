package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade311Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade317Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AICursedSpirit3FishProcedure {
   public AICursedSpirit3FishProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity owner_uuid = null;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double y_pos = 0.0;
         double speed = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
               }
            }

            label83: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label83;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 0, false, false));
                  }
               }
            }

            label91: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label91;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
               }

               if (!entity.isVehicle()) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0 && entity.getPersistentData().getDouble("cnt_target") % 10.0 == 7.0 && Math.random() < 0.25) {
                     entity.getPersistentData().putBoolean("canFly", true);
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

                     double var42 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var42 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var43;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var43 = _mobEnt.getTarget();
                     } else {
                        var43 = null;
                     }

                     z_pos = ((Entity)var43).getZ();
                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     x_power = entity.getPersistentData().getDouble("x_power") * 0.6;
                     y_power = entity.getPersistentData().getDouble("y_power") * 0.6;
                     z_power = entity.getPersistentData().getDouble("z_power") * 0.6;
                     entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  }
               }
            }

            if (!entity.isVehicle() && entity.getPersistentData().getDouble("friend_num_worker") != 0.0) {
               if (entity instanceof CursedSpiritGrade317Entity) {
                  AICursedSpiritsFlyingAttack2Procedure.execute(world, x, y, z, entity);
               } else {
                  AICursedSpiritsFlyingAttackProcedure.execute(world, x, y, z, entity);
               }
            }
         }

         if (entity instanceof CursedSpiritGrade311Entity) {
            AIRideableControlProcedure.execute(entity);
         }

      }
   }
}
