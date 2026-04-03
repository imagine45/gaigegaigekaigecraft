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
         immediatesourceentity.getPersistentData().putDouble("cnt_life", immediatesourceentity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().putDouble("Nail", 1.0);
            immediatesourceentity.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
            immediatesourceentity.getPersistentData().putDouble("Damage", 6.0 * (1.0 + immediatesourceentity.getPersistentData().getDouble("cnt6") * 0.1));
         }

         if (Math.random() < 0.25 && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, 0, 0.0, 0.0, 0.0, 0.0);
         }

         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") > 600.0 && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
