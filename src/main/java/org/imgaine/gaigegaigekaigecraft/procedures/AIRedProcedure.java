package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIRedProcedure {
   public AIRedProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double z_pos = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double distance = 0.0;
         double CNT6 = 0.0;
         double power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         AIBlueRedProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128471_("flag_start")) {
            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               entity.getPersistentData().m_128347_("cnt_bullet_hit", 15.0);
               BulletDomainHit2Procedure.execute(world, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.75F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
                  }
               }

               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
            }

            for(int index0 = 0; index0 < 2; ++index0) {
               entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"));
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"));
               entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"));
               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               entity.getPersistentData().m_128347_("Damage", 34.0);
               entity.getPersistentData().m_128347_("Damage", Math.max(entity.getPersistentData().m_128459_("Damage") * Math.pow(0.99, entity.getPersistentData().m_128459_("cnt_life")), 28.0));
               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * CNT6);
               entity.getPersistentData().m_128347_("Range", 10.0 * CNT6);
               entity.getPersistentData().m_128347_("knockback", 2.0 * CNT6);
               entity.getPersistentData().m_128347_("effect", 0.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("BlockRange", 10.0);
               entity.getPersistentData().m_128347_("BlockDamage", 0.33);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("BlockRange", 4.0 * CNT6);
               entity.getPersistentData().m_128347_("BlockDamage", 4.0 * CNT6);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("Range", 10.0 * CNT6);
               entity.getPersistentData().m_128347_("knockback", 2.0 * CNT6);
               KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") == 3.0) {
               entity.getPersistentData().m_128347_("BlockRange", 16.0 * CNT6);
               entity.getPersistentData().m_128347_("BlockDamage", 0.33);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            range = ReturnEntitySizeProcedure.execute(entity);
            ParticleGeneratorProcedure.execute(world, range * 0.1, 40.0 * range, 30.0, 8.0, entity.m_20185_(), entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"), "minecraft:cloud");
            if (entity.getPersistentData().m_128459_("cnt1") < 6.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123747_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(30.0 * CNT6), 4.0, 4.0, 4.0, 1.0);
               }

               entity.getPersistentData().m_128347_("Damage", 34.0 * CNT6);
               entity.getPersistentData().m_128347_("Range", 16.0 * CNT6);
               entity.getPersistentData().m_128347_("knockback", 4.0 * CNT6);
               entity.getPersistentData().m_128347_("effect", 0.0);
               entity.getPersistentData().m_128347_("y_knockback", 0.65);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() - 1.5, entity.m_20189_(), entity);
               entity.getPersistentData().m_128347_("Range", 16.0 * CNT6);
               entity.getPersistentData().m_128347_("knockback", 4.0 * CNT6);
               entity.getPersistentData().m_128347_("effect", 1.0);
               KnockbackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() - 1.5, entity.m_20189_(), entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 8.0 * CNT6 && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
