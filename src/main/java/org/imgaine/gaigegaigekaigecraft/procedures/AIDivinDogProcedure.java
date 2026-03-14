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
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            FollowEntityProcedure.execute(world, entity);
            if (entity instanceof DivineDogTotalityEntity) {
               NUM1 = (double)(6L + Math.round(entity.getPersistentData().m_128459_("Strength") * 0.5));
               NUM2 = 2.0;
               NUM3 = -60.0;
            } else {
               NUM1 = (double)(3L + Math.round(entity.getPersistentData().m_128459_("Strength") * 0.5));
               NUM2 = 1.0;
               NUM3 = -60.0;
               if (entity.getPersistentData().m_128459_("cnt_howl") < 0.0) {
                  entity.getPersistentData().m_128347_("cnt_howl", entity.getPersistentData().m_128459_("cnt_howl") + 1.0);
               }
            }

            double var10001;
            label79: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity7 = (LivingEntity)entity;
                  if (_livingEntity7.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity7.getAttribute_(Attributes.f_22281_).m_22115_();
                     break label79;
                  }
               }

               var10001 = 0.0;
            }

            label74: {
               level_resistance = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19600_)) {
                     break label74;
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
            label69: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label69;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < level_resistance && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)level_resistance, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 1.0) {
               AttackBeastProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var30;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var30 = _mobEnt.m_5448_();
               } else {
                  var30 = null;
               }

               if (!(var30 instanceof LivingEntity) && !(entity.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     ResetCounterProcedure.execute(entity);
                     if (entity instanceof DivineDogTotalityEntity) {
                        entity.getPersistentData().m_128347_("cnt_x", 0.0);
                        CalculateAttackProcedure.execute(world, entity);
                     } else {
                        entity.getPersistentData().m_128347_("cnt_x", NUM3 + (double)Math.round(NUM3 / 2.0 * Math.random()));
                        entity.getPersistentData().m_128347_("skill", 1.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
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
