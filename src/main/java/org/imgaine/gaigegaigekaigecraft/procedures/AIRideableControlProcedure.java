package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class AIRideableControlProcedure {
   public AIRideableControlProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double speed = 0.0;
         Entity owner_uuid = null;
         owner_uuid = entity.m_146895_();
         if (owner_uuid instanceof LivingEntity) {
            entity.m_146922_(owner_uuid.m_146908_());
            entity.m_146926_(owner_uuid.m_146909_());
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            if (owner_uuid instanceof Player) {
               if (owner_uuid.getPersistentData().m_128471_("PRESS_SPACE") && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19620_, 5, 19, false, false));
                  }
               }

               if (owner_uuid.getPersistentData().m_128471_("PRESS_W")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 9, false, false));
                     }
                  }

                  speed = Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7098_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0));
                  speed = Math.min(speed + 0.2, 1.25);
                  entity.m_20256_(new Vec3(owner_uuid.m_20154_().f_82479_ * speed, owner_uuid.m_20154_().f_82480_ * speed, owner_uuid.m_20154_().f_82481_ * speed));
               }
            }
         }

      }
   }
}
