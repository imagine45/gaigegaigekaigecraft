package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AIRainbowDragonProcedure {
   public AIRainbowDragonProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double rnd = 0.0;
         double level_strength = 0.0;
         double form = 0.0;
         double tick = 0.0;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            label95: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               level_strength = 9.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label95;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)level_strength, false, false));
                  }
               }
            }

            label90: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label90;
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
               AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("cnt_x", -100.0);
               if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                  if (entity.getPersistentData().m_128459_("continue") > 0.0) {
                     entity.getPersistentData().m_128347_("continue", entity.getPersistentData().m_128459_("continue") - 1.0);
                     entity.getPersistentData().m_128347_("skill", 1.0);
                  }

                  ResetCounterProcedure.execute(entity);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y + (double)entity.m_20206_() * 0.5, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle firework ~ ~ ~ 1 1 1 0 10 force");
               }
            } else if (entity.getPersistentData().m_128459_("skill") == 2.0) {
               AttackBiteProcedure.execute(world, x, y, z, entity);
            } else {
               if (!entity.m_20160_()) {
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
                        ResetCounterProcedure.execute(entity);
                        if (!(Math.random() < 0.5) && !(GetDistanceNearestEnemyProcedure.execute(world, entity) > 10.0)) {
                           entity.getPersistentData().m_128347_("cnt_x", -30.0);
                           entity.getPersistentData().m_128347_("skill", 2.0);
                        } else {
                           entity.getPersistentData().m_128347_("cnt_x", -50.0);
                           entity.getPersistentData().m_128347_("skill", 1.0);
                           entity.getPersistentData().m_128347_("continue", (double)(Math.random() < 0.75 ? 1 : 0));
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  }

                  if (!entity.m_20096_()) {
                     if (entity.m_20184_().m_7098_() < -0.26) {
                        entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() + 0.025, entity.m_20184_().m_7094_()));
                     } else if (entity.m_20184_().m_7098_() > -0.24) {
                        entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() - 0.025, entity.m_20184_().m_7094_()));
                     }
                  }
               }

               AIRideableControlProcedure.execute(entity);
            }
         }

      }
   }
}
