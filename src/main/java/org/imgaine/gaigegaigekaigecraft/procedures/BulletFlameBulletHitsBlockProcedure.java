package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletFlameBulletHitsBlockProcedure {
   public BulletFlameBulletHitsBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double old_skill = 0.0;
         double CNT6 = 0.0;
         CNT6 = 1.0 + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1;
         entity.getPersistentData().m_128347_("BlockDamage", 2.0 * CNT6);
         entity.getPersistentData().m_128347_("BlockRange", 2.0 * CNT6);
         entity.getPersistentData().m_128379_("noParticle", true);
         BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_) && Math.random() < 0.1 && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60815_() && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            FallingBlockEntity.m_201971_(_level, BlockPos.m_274561_(x, y, z), Blocks.f_50083_.m_49966_());
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123744_, x, y, z, (int)(8.0 * CNT6), 0.25, 0.25, 0.25, 0.25 * CNT6);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)(2.0 * CNT6), 0.25, 0.25, 0.25, 0.25 * CNT6);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)(4.0 * CNT6), 0.25, 0.25, 0.25, 0.25 * CNT6);
         }

         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
