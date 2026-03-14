package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Effect15Procedure {
   public Effect15Procedure() {
   }

   public static void execute(Entity entityiterator) {
      if (entityiterator != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         double CNT6 = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double yaw = 0.0;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
         z_pos = entityiterator.m_20189_();
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 4, false, false));
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 40, 4, false, false));
            }
         }

         if (entityiterator.getPersistentData().m_128459_("skill") != 0.0 && entityiterator.getPersistentData().m_128471_("attack")) {
            entityiterator.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
