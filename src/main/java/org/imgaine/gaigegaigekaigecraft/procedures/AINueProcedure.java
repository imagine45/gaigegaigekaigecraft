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
         if (entity.m_6084_()) {
            double var10001;
            label134: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               NUM1 = (double)Math.round((double)(entity.getPersistentData().m_128471_("Giant") ? 9 : 5) + entity.getPersistentData().m_128459_("Strength") * 0.5);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity3 = (LivingEntity)entity;
                  if (_livingEntity3.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity3.getAttribute_(Attributes.f_22281_).m_22115_();
                     break label134;
                  }
               }

               var10001 = 0.0;
            }

            label129: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label129;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label124: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label124;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)NUM2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 1.0) {
               AttackNueProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("skill") == 2.0) {
               AttackNue2Procedure.execute(world, entity);
            } else {
               LivingEntity var32;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var32 = _mobEnt.m_5448_();
               } else {
                  var32 = null;
               }

               if (var32 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  entity.getPersistentData().m_128347_("cnt_x2", 0.0);
                  if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     label151: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt18 = (LivingEntity)entity;
                           if (_livEnt18.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              entity.getPersistentData().m_128347_("cnt_x", 0.0);
                              break label151;
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_x", -60.0);
                        ResetCounterProcedure.execute(entity);
                        if (entity.getPersistentData().m_128471_("Giant")) {
                           rnd = 2.0;
                           tick = 150.0;
                        } else {
                           rnd = 1.0;
                           tick = (double)(50L + Math.round(Math.random() * 20.0));
                        }

                        entity.getPersistentData().m_128347_("skill", rnd);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + 1.0);
                  if (entity.getPersistentData().m_128471_("Giant") && entity.getPersistentData().m_128459_("cnt_x2") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     label150: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt31 = (LivingEntity)entity;
                           if (_livEnt31.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              entity.getPersistentData().m_128347_("cnt_x2", 0.0);
                              break label150;
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_x", -60.0);
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", 2.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 150, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  }
               }

               if (GetHeightFromGroundProcedure.execute(world, entity) > 8.0) {
                  if (entity.m_20184_().m_7098_() > -0.5) {
                     entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() - 0.05, entity.m_20184_().m_7094_()));
                  }
               } else if (GetHeightFromGroundProcedure.execute(world, entity) < 4.0 && entity.m_20184_().m_7098_() < 0.25) {
                  entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() + 0.025, entity.m_20184_().m_7094_()));
               }
            }
         }

      }
   }
}
