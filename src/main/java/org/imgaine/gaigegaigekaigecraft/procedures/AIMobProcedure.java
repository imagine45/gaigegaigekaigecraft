package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JujutsuSorcererEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KukuruEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIMobProcedure {
   public AIMobProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double level_power = 0.0;
         double level_resistance = 0.0;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof JujutsuSorcererEntity) {
               double var10000;
               if (entity instanceof JujutsuSorcererEntity) {
                  JujutsuSorcererEntity _datEntI = (JujutsuSorcererEntity)entity;
                  var10000 = (double)(Integer)_datEntI.m_20088_().m_135370_(JujutsuSorcererEntity.DATA_power);
               } else {
                  var10000 = 0.0;
               }

               level = var10000;
            } else if (entity instanceof CurseUserEntity) {
               double var28;
               if (entity instanceof CurseUserEntity) {
                  CurseUserEntity _datEntI = (CurseUserEntity)entity;
                  var28 = (double)(Integer)_datEntI.m_20088_().m_135370_(CurseUserEntity.DATA_power);
               } else {
                  var28 = 0.0;
               }

               level = var28;
            } else {
               level = entity instanceof KukuruEntity ? 3.0 : 0.0;
            }

            label76: {
               level_power = level < 3.0 ? Math.min(level, 1.0) : level;
               level_resistance = (double)Math.round(level < 3.0 ? 0.0 : Math.min(level / 4.0, 3.0));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                     break label76;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)level_power, false, false));
                  }
               }
            }

            label71: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                     break label71;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)level_resistance, false, false));
                  }
               }
            }

            LivingEntity var29;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var29 = _mobEnt.m_5448_();
            } else {
               var29 = null;
            }

            if (var29 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
