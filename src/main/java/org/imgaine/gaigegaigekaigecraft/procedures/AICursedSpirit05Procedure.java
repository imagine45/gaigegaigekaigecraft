package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade012Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit05Procedure {
   public AICursedSpirit05Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean tamamo_no_mae = false;
         double rnd = 0.0;
         double tick = 0.0;
         double lv = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof CursedSpiritGrade012Entity && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SOUL, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)ReturnEntitySizeProcedure.execute(entity), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.1);
            }

            label96: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label96;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, entity instanceof CursedSpiritGrade012Entity ? 13 : 12, false, false));
                  }
               }
            }

            label91: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt13 = (LivingEntity)entity;
                  if (_livEnt13.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label91;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                     entity.getPersistentData().putDouble("skill", 2520.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  } else {
                     if (LogicStartProcedure.execute(entity)) {
                        label115: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt25 = (LivingEntity)entity;
                              if (_livEnt25.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break label115;
                              }
                           }

                           entity.getPersistentData().putDouble("skill", (double)(GetDistanceProcedure.execute(entity) < 10.0 ? 2506 : 2505));
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 50, 0, false, false));
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                                 return;
                              }
                           }

                           return;
                        }
                     }

                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
