package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.LevelAccessor;

public class AIDaidoHaganeProcedure {
   public AIDaidoHaganeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double level = 0.0;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  MobEffectInstance var10001 = new MobEffectInstance;
                  MobEffect var10003 = MobEffects.f_19600_;
                  ItemStack var10005;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10005 = _livEnt.m_21205_();
                  } else {
                     var10005 = ItemStack.f_41583_;
                  }

                  var10001.<init>(var10003, 10, var10005.m_41720_() instanceof SwordItem ? 20 : 0, false, false);
                  _entity.m_7292_(var10001);
               }
            }

            label80: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label80;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 2, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 1.0) {
               MahoragaCutTheWorldProcedure.execute(world, x, y, z, entity);
            } else {
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
                     distance = GetDistanceProcedure.execute(entity);
                     rnd = 0.0;
                     level = 0.0;
                     tick = 0.0;
                     ItemStack var30;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var30 = _livEnt.m_21205_();
                     } else {
                        var30 = ItemStack.f_41583_;
                     }

                     if (var30.m_41720_() instanceof SwordItem) {
                        label94: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt16 = (LivingEntity)entity;
                              if (_livEnt16.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 break label94;
                              }
                           }

                           level = 1.0;
                           rnd = 1.0;
                           tick = 250.0;
                        }
                     }

                     if (rnd > 0.0) {
                        entity.getPersistentData().m_128347_("skill", rnd);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
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
}
