package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIMaxElephantProcedure {
   public AIMaxElephantProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double rnd = 0.0;
         double NUM1 = 0.0;
         if (entity.isAlive()) {
            double var10001;
            label77: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               MaxElephantFallProcedure.execute(world, x, y, z, entity);
               NUM1 = (double)(7L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     var10001 = _livingEntity2.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                     break label77;
                  }
               }

               var10001 = 0.0;
            }

            label72: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label72;
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
            label67: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label67;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
               }
            }

            LivingEntity var25;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var25 = _mobEnt.getTarget();
            } else {
               var25 = null;
            }

            if (var25 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  if (LogicStartProcedure.execute(entity)) {
                     if (entity.getPersistentData().getBoolean("domain_entity")) {
                        if (entity.onGround()) {
                           entity.getPersistentData().putBoolean("flag_despawn", true);
                        }
                     } else {
                        entity.getPersistentData().putDouble("cnt_x", -60.0);
                        ResetCounterProcedure.execute(entity);
                        rnd = 5.0;
                        entity.getPersistentData().putDouble("skill", (double)Math.round(800.0 + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  } else {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
