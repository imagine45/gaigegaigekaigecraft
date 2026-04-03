package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIDivinDogProcedure {
   public AIDivinDogProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double rnd = 0.0;
         double level_resistance = 0.0;
         double NUM1 = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            FollowEntityProcedure.execute(world, entity);
            if (entity instanceof DivineDogTotalityEntity) {
               NUM1 = (double)(6L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
               NUM2 = 2.0;
               NUM3 = -60.0;
            } else {
               NUM1 = (double)(3L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
               NUM2 = 1.0;
               NUM3 = -60.0;
               if (entity.getPersistentData().getDouble("cnt_howl") < 0.0) {
                  entity.getPersistentData().putDouble("cnt_howl", entity.getPersistentData().getDouble("cnt_howl") + 1.0);
               }
            }

            double var10001;
            label79: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity7 = (LivingEntity)entity;
                  if (_livingEntity7.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     var10001 = _livingEntity7.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                     break label79;
                  }
               }

               var10001 = 0.0;
            }

            label74: {
               level_resistance = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label74;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label69: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label69;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < level_resistance && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)level_resistance, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               AttackBeastProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var30;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var30 = _mobEnt.getTarget();
               } else {
                  var30 = null;
               }

               if (!(var30 instanceof LivingEntity) && !(entity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               } else {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     ResetCounterProcedure.execute(entity);
                     if (entity instanceof DivineDogTotalityEntity) {
                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                        CalculateAttackProcedure.execute(world, entity);
                     } else {
                        entity.getPersistentData().putDouble("cnt_x", NUM3 + (double)Math.round(NUM3 / 2.0 * Math.random()));
                        entity.getPersistentData().putDouble("skill", 1.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
