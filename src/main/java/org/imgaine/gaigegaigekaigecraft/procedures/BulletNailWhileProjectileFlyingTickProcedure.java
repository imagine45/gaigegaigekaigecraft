package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletNailWhileProjectileFlyingTickProcedure {
   public BulletNailWhileProjectileFlyingTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double y_power = 0.0;
         double z_power = 0.0;
         double old_skill = 0.0;
         double num = 0.0;
         double x_power = 0.0;
         double old_cooldown = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().m_128347_("Nail", 1.0);
            immediatesourceentity.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
            num = entity.getPersistentData().m_128459_("Damage");
            immediatesourceentity.getPersistentData().m_128347_("Damage", 6.0 * (1.0 + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1));
            entity.getPersistentData().m_128347_("Damage", 6.0 * (1.0 + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1));
            DamageFixProcedure.execute(entity);
            immediatesourceentity.getPersistentData().m_128347_("bullet_power", entity.getPersistentData().m_128459_("Damage"));
            entity.getPersistentData().m_128347_("Damage", num);
         }

         if (Math.random() < 0.25 && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, 0, 0.0, 0.0, 0.0, 0.0);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > 600.0 && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
