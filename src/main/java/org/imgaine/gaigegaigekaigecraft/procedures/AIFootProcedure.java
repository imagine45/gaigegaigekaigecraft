package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFootProcedure {
   public AIFootProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double move = 0.0;
         double amount = 0.0;
         double CNT6 = 0.0;
         entity.f_19789_ = 0.0F;
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            if (entity.getPersistentData().m_128459_("cnt2") < 10.0) {
               if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 10, 1.0, 1.0, 1.0, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 10, 1.0, 1.0, 1.0, 0.5);
                  }
               }

               if (entity.getPersistentData().m_128471_("Stop") && !(entity.getPersistentData().m_128459_("cnt2") > 0.0)) {
                  entity.getPersistentData().m_128379_("Stop", false);
               } else {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 10, 1.0, 1.0, 1.0, 0.25);
                  }

                  entity.m_20256_(new Vec3(0.0, -1.0, 0.0));
                  BulletDomainHit2Procedure.execute(world, entity);
                  y_pos = y + (double)entity.m_20206_() * 0.5;
                  if (!entity.m_20096_() && !(entity.getPersistentData().m_128459_("cnt2") > 0.0)) {
                     entity.getPersistentData().m_128347_("Damage", 17.0 * CNT6);
                     entity.getPersistentData().m_128347_("knockback", 2.0 * CNT6);
                     entity.getPersistentData().m_128347_("Range", 8.0 * ReturnEntitySizeProcedure.execute(entity));
                     entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.25);
                     entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.25);
                     entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.25);
                     RangeAttackProcedure.execute(world, x, y_pos, z, entity);
                     entity.getPersistentData().m_128347_("x_knockback", 0.0);
                     entity.getPersistentData().m_128347_("y_knockback", 0.0);
                     entity.getPersistentData().m_128347_("z_knockback", 0.0);
                     if (entity.getPersistentData().m_128459_("cnt1") > 50.0 && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  } else {
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, entity.m_20186_(), z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, entity.m_20186_(), z, 15, 2.0, 1.0, 2.0, 0.5);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, entity.m_20186_(), z, 15, 2.0, 1.0, 2.0, 0.5);
                     }

                     entity.getPersistentData().m_128347_("Damage", 18.0 * CNT6);
                     entity.getPersistentData().m_128347_("knockback", 2.0 * CNT6);
                     entity.getPersistentData().m_128347_("Range", 10.0 * ReturnEntitySizeProcedure.execute(entity));
                     RangeAttackProcedure.execute(world, x, entity.m_20186_(), z, entity);
                     entity.getPersistentData().m_128347_("BlockRange", 1.0 * ReturnEntitySizeProcedure.execute(entity));
                     entity.getPersistentData().m_128347_("BlockDamage", 2.0 * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y_pos, z, entity);
                     entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  }
               }
            } else {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt2") > 20.0 && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
