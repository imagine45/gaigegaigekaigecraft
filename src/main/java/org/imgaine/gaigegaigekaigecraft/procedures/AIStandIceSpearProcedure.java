package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.IceSpearEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIStandIceSpearProcedure {
   public AIStandIceSpearProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         if (entity.getPersistentData().m_128459_("move") == 1.0) {
            if (entity instanceof IceSpearEntity) {
               ((IceSpearEntity)entity).setAnimation("spin");
            }

            AIStandIceSpear2Procedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof IceSpearEntity) {
               ((IceSpearEntity)entity).setAnimation("idle_stand");
            }

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.m_20096_()) {
               entity.m_20256_(new Vec3(0.0, entity.m_20184_().m_7098_(), 0.0));
               if (entity.getPersistentData().m_128459_("cnt2") > 10.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123815_, x, y, z, 8, 0.2, 0.2, 0.2, 0.2);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x, y, z, 4, 0.2, 0.2, 0.2, 0.2);
                  }

                  entity.getPersistentData().m_128347_("Damage", 20.0);
                  entity.getPersistentData().m_128347_("Range", 5.0 * ReturnEntitySizeProcedure.execute(entity));
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  entity.getPersistentData().m_128347_("effect", 14.0);
                  RangeAttackProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("BlockRange", 2.0);
                  entity.getPersistentData().m_128347_("BlockDamage", 4.0);
                  BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               }

               entity.getPersistentData().m_128347_("cnt2", 0.0);
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt2") > 10.0) {
                  BulletDomainHit2Procedure.execute(world, entity);
                  entity.getPersistentData().m_128347_("Damage", 20.0);
                  entity.getPersistentData().m_128347_("Range", 5.0 * ReturnEntitySizeProcedure.execute(entity));
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  entity.getPersistentData().m_128347_("effect", 14.0);
                  RangeAttackProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * 0.5, z, entity);
               }
            }

            if ((!entity.m_6084_() || entity.getPersistentData().m_128459_("cnt1") > 200.0) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         }

      }
   }
}
