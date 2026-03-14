package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AIResonanceProcedure {
   public AIResonanceProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double CNT6 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double range_fix = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double NUM1 = 0.0;
         Entity entity_a = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("TARGET"));
         if (entity_a instanceof LivingEntity) {
            entity.m_6021_(entity_a.m_20185_() + entity.getPersistentData().m_128459_("x_pos"), entity_a.m_20186_() + entity.getPersistentData().m_128459_("y_pos"), entity_a.m_20189_() + entity.getPersistentData().m_128459_("z_pos"));
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + entity.getPersistentData().m_128459_("x_pos"), entity_a.m_20186_() + entity.getPersistentData().m_128459_("y_pos"), entity_a.m_20189_() + entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
            }

            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 9, false, false));
               }
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            entity.getPersistentData().m_128347_("Damage", 20.0 * CNT6);
            entity.getPersistentData().m_128347_("Range", 1.0 * range_fix);
            entity.getPersistentData().m_128347_("knockback", 0.5);
            entity.getPersistentData().m_128347_("effect", 1.0);
            entity.getPersistentData().m_128347_("effectConfirm", 2.0);
            entity.getPersistentData().m_128379_("ignore", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 20.0 && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
