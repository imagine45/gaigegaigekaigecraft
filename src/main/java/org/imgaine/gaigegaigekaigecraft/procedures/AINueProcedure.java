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
import net.minecraft.world.phys.Vec3;

public class AINueProcedure {
   public AINueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double rnd = 0.0;
         double tick = 0.0;
         double NUM1 = 0.0;
         if (entity.isAlive()) {
            double var10001;
            label134: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               NUM1 = (double)Math.round((double)(entity.getPersistentData().getBoolean("Giant") ? 9 : 5) + entity.getPersistentData().getDouble("Strength") * 0.5);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity3 = (LivingEntity)entity;
                  if (_livingEntity3.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     var10001 = _livingEntity3.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                     break label134;
                  }
               }

               var10001 = 0.0;
            }

            label129: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label129;
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
            label124: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label124;
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

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               AttackNueProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().getDouble("skill") == 2.0) {
               AttackNue2Procedure.execute(world, entity);
            } else {
               LivingEntity var32;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var32 = _mobEnt.getTarget();
               } else {
                  var32 = null;
               }

               if (var32 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  entity.getPersistentData().putDouble("cnt_x2", 0.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     label151: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt18 = (LivingEntity)entity;
                           if (_livEnt18.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              entity.getPersistentData().putDouble("cnt_x", 0.0);
                              break label151;
                           }
                        }

                        entity.getPersistentData().putDouble("cnt_x", -60.0);
                        ResetCounterProcedure.execute(entity);
                        if (entity.getPersistentData().getBoolean("Giant")) {
                           rnd = 2.0;
                           tick = 150.0;
                        } else {
                           rnd = 1.0;
                           tick = (double)(50L + Math.round(Math.random() * 20.0));
                        }

                        entity.getPersistentData().putDouble("skill", rnd);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
                  if (entity.getPersistentData().getBoolean("Giant") && entity.getPersistentData().getDouble("cnt_x2") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     label150: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt31 = (LivingEntity)entity;
                           if (_livEnt31.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              entity.getPersistentData().putDouble("cnt_x2", 0.0);
                              break label150;
                           }
                        }

                        entity.getPersistentData().putDouble("cnt_x", -60.0);
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().putDouble("skill", 2.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 150, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  }
               }

               if (GetHeightFromGroundProcedure.execute(world, entity) > 8.0) {
                  if (entity.getDeltaMovement().y() > -0.5) {
                     entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() - 0.05, entity.getDeltaMovement().z()));
                  }
               } else if (GetHeightFromGroundProcedure.execute(world, entity) < 4.0 && entity.getDeltaMovement().y() < 0.25) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() + 0.025, entity.getDeltaMovement().z()));
               }
            }
         }

      }
   }
}
