package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ChosoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIChosoProcedure {
   public AIChosoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean choso = false;
         boolean blood_ball = false;
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double tick = 0.0;
         double NUM1 = 0.0;
         double distance = 0.0;
         double old_cool = 0.0;
         choso = entity instanceof ChosoEntity;
         if (entity.m_6084_()) {
            if (entity.m_20071_()) {
               old_cool = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            if (choso) {
               lv_st = 11.0;
               lv_df = 3.0;
            } else {
               lv_st = 8.0;
               lv_df = 2.0;
            }

            label156: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                     break label156;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label151: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                     break label151;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)lv_df, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  NUM1 = 0.0;
                  distance = GetDistanceProcedure.execute(entity);
                  blood_ball = LocateBloodBallProcedure.execute(world, x, y, z, entity);

                  for(int index0 = 0; index0 < 128; ++index0) {
                     rnd = (double)(4L + Math.round(Math.random() * 15.0));
                     ++NUM1;
                     if (rnd == 5.0) {
                        tick = 60.0;
                        if (!(distance < 8.0)) {
                           break;
                        }
                     } else if (rnd == 6.0) {
                        tick = 10.0;
                        if (choso && !(distance < 5.0) && !blood_ball) {
                           break;
                        }
                     } else if (rnd == 7.0) {
                        tick = 100.0;
                        if (!(distance < 5.0)) {
                           break;
                        }
                     } else if (rnd == 8.0) {
                        tick = 50.0;
                        if (choso && !(distance > 8.0) && blood_ball) {
                           break;
                        }
                     } else if (rnd == 16.0) {
                        tick = 200.0;
                        if (choso && !(Math.random() > 0.25)) {
                           float var44;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var44 = _livEnt.m_21223_();
                           } else {
                              var44 = -1.0F;
                           }

                           double var45 = (double)var44;
                           float var10001;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21233_();
                           } else {
                              var10001 = -1.0F;
                           }

                           if (!(var45 > (double)var10001 * 0.5)) {
                              break;
                           }
                        }
                     } else if (rnd == 18.0) {
                        tick = 75.0;
                        if (choso) {
                           float var46;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var46 = _livEnt.m_21223_();
                           } else {
                              var46 = -1.0F;
                           }

                           double var47 = (double)var46;
                           float var48;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var48 = _livEnt.m_21233_();
                           } else {
                              var48 = -1.0F;
                           }

                           if (!(var47 > (double)var48 * 0.5)) {
                              break;
                           }
                        }
                     }
                  }

                  if (LogicStartProcedure.execute(entity) && Math.random() < 0.5 && NUM1 < 50.0) {
                     entity.getPersistentData().m_128347_("skill", 1000.0 + rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
