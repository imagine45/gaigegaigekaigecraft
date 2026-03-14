package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBlackFlashProcedure {
   public AIBlackFlashProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rad = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double soundPitch = 0.0;
         double rad_now = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double pitch = 0.0;
         double loop_num = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               soundPitch = 0.75;

               for(int index0 = 0; index0 < 3; ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                     }
                  }

                  soundPitch += 0.25;
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123747_, x, y + 1.0, z, 10, 0.5, 0.5, 0.5, 0.0);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x, y + 1.0, z, 3, 0.5, 1.0, 0.5, 0.0);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < 17.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 10.0) {
               soundPitch = 0.75;

               for(int index1 = 0; index1 < 3; ++index1) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                     }
                  }

                  soundPitch += 0.25;
               }

               entity.getPersistentData().m_128347_("BlockRange", 8.0);
               entity.getPersistentData().m_128347_("BlockDamage", 0.25);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            }

            loop_num = 5.0 + entity.getPersistentData().m_128459_("cnt1") * 2.0;

            for(int index2 = 0; index2 < 2; ++index2) {
               rad_now = Math.toRadians(Math.random() * 360.0);
               pitch = Math.toRadians(0.0);
               num1 = (Math.random() - 0.5) * 1.6;
               num2 = (Math.random() - 0.5) * 1.6;
               num3 = (Math.random() - 0.5) * 1.6;
               entity.getPersistentData().m_128347_("x_pos", x);
               entity.getPersistentData().m_128347_("y_pos", y + 1.0);
               entity.getPersistentData().m_128347_("z_pos", z);
               entity.getPersistentData().m_128347_("cnt2", 0.0);

               for(int index3 = 0; index3 < (int)loop_num; ++index3) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad_now) * (Math.cos(pitch) + Math.abs(Math.sin(rad_now) * Math.sin(pitch))) * (entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  y_pos = entity.getPersistentData().m_128459_("y_pos") + Math.sin(pitch) * (entity.getPersistentData().m_128459_("cnt2") + 1.0) * -1.0;
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad_now) * (Math.cos(pitch) + Math.abs(Math.cos(rad_now) * Math.sin(pitch))) * (entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                  }

                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     if (!world.m_8055_(BlockPos.m_274561_(x_pos + 1.0, y_pos + 0.0, z_pos + 0.0)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + -1.0, y_pos + 0.0, z_pos + 0.0)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + 0.0, y_pos + 1.0, z_pos + 0.0)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + 0.0, y_pos + -1.0, z_pos + 0.0)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + 0.0, y_pos + 0.0, z_pos + 1.0)).m_60815_() || !world.m_8055_(BlockPos.m_274561_(x_pos + 0.0, y_pos + 0.0, z_pos + -1.0)).m_60815_()) {
                        world.m_46796_(2001, BlockPos.m_274561_(x_pos, y_pos, z_pos), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 0.25);
                  if (entity.getPersistentData().m_128459_("cnt2") % 4.0 < 2.0) {
                     entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + num1);
                     entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + num2);
                     entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + num3);
                  } else {
                     entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") - num1);
                     entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - num2);
                     entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") - num3);
                  }
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > 20.0) {
            x_pos = x + Math.random() * 16.0 - 8.0;
            z_pos = z + Math.random() * 16.0 - 8.0;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y, z_pos, 40, 0.1, 2.0, 0.1, 0.1);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.25F, 1.25F);
               } else {
                  _level.m_7785_(x_pos, y, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 25.0 && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
