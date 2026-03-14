package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIZeninOgiProcedure {
   public AIZeninOgiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double distance = 0.0;
         double health = 0.0;
         double tick = 0.0;
         if (entity.m_6084_()) {
            label170: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label170;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 10, false, false));
                  }
               }
            }

            label165: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label165;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
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
                  ItemStack var35;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.m_21205_();
                  } else {
                     var35 = ItemStack.f_41583_;
                  }

                  label192: {
                     if (var35.m_41720_() == JujutsucraftModItems.SWORD_OGI.get() && LogicStartProcedure.execute(entity)) {
                        LivingEntity var36;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var36 = _mobEnt.m_5448_();
                        } else {
                           var36 = null;
                        }

                        label152: {
                           LivingEntity var24 = var36;
                           if (var24 instanceof LivingEntity) {
                              LivingEntity _livEnt = var24;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var37 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label152;
                              }
                           }

                           var37 = 0;
                        }

                        int var10001;
                        label147: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label147;
                              }
                           }

                           var10001 = 0;
                        }

                        if (var37 - var10001 >= -2) {
                           break label192;
                        }

                        float var38;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var38 = _livEnt.m_21223_();
                        } else {
                           var38 = -1.0F;
                        }

                        double var39 = (double)var38;
                        float var41;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var41 = _livEnt.m_21233_();
                        } else {
                           var41 = -1.0F;
                        }

                        if (var39 < (double)var41 * 0.5) {
                           break label192;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21205_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     if (var35.m_41720_() == JujutsucraftModItems.BLAZING_COURAGE.get() && LogicStartProcedure.execute(entity) && Math.random() < 0.75) {
                        distance = GetDistanceProcedure.execute(entity);

                        for(int index0 = 0; index0 < 128; ++index0) {
                           rnd = (double)(10L + Math.round(Math.random() * 6.0));
                           if (rnd == 11.0) {
                              tick = 50.0;
                              if (!(distance < 6.0)) {
                                 break;
                              }
                           } else if (rnd == 12.0) {
                              tick = 25.0;
                              if (!(distance > 6.0)) {
                                 break;
                              }
                           } else if (rnd == 13.0) {
                              tick = 63.0;
                              if (!(distance > 16.0)) {
                                 break;
                              }
                           } else if (rnd == 14.0) {
                              tick = 75.0;
                              if (!(distance > 8.0)) {
                                 break;
                              }
                           } else if (rnd == 15.0) {
                              tick = 100.0;
                              if (!(distance > 12.0)) {
                                 break;
                              }
                           }
                        }

                        entity.getPersistentData().m_128347_("skill", (double)Math.round(2600.0 + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                              return;
                           }
                        }

                        return;
                     }

                     CalculateAttackProcedure.execute(world, entity);
                     return;
                  }

                  entity.getPersistentData().m_128347_("skill", (double)Math.round(2605.0F));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 50, 0, false, false));
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
