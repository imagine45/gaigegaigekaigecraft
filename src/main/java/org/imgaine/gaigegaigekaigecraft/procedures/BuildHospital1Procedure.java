package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BuildHospital1Procedure {
   public BuildHospital1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean boss_flag = false;
      boolean SUCCESS = false;
      double x_pos = 0.0;
      double y_pos = 0.0;
      double z_pos = 0.0;
      double grade = 0.0;
      double kind = 0.0;
      double entity_height = 0.0;
      double entity_width = 0.0;
      double sx = 0.0;
      double sy = 0.0;
      double sz = 0.0;
      if (world instanceof Level _level) {
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F);
         } else {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.m_8767_(ParticleTypes.f_123746_, x, y, z, 25, 0.25, 0.25, 0.25, 0.1);
      }

      boss_flag = false;

      for(int index0 = 0; index0 < 20; ++index0) {
         SUCCESS = false;

         for(int index1 = 0; index1 < 256; ++index1) {
            entity_height = 2.0;
            entity_width = 2.0;
            x_pos = x + (Math.random() - 0.5) * 48.0 * 0.8;
            y_pos = y - 20.0;
            z_pos = z + (Math.random() - 0.5) * 48.0 * 0.8;

            for(int index2 = 0; index2 < 24; ++index2) {
               if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos)) && !world.m_46859_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)) && Math.random() < 0.5) {
                  SUCCESS = true;
                  sx = x_pos - entity_width * 0.5;

                  for(int index3 = 0; index3 < (int)Math.round(entity_width); ++index3) {
                     sz = z_pos - entity_width * 0.5;

                     for(int index4 = 0; index4 < (int)Math.round(entity_width); ++index4) {
                        sy = y_pos;

                        for(int index5 = 0; index5 < (int)Math.round(entity_height); ++index5) {
                           if (world.m_8055_(BlockPos.m_274561_(sx, sy, sz)).m_60815_()) {
                              SUCCESS = false;
                              break;
                           }

                           ++sy;
                        }

                        if (!SUCCESS) {
                           break;
                        }

                        ++sz;
                     }

                     if (!SUCCESS) {
                        break;
                     }

                     ++sx;
                  }

                  if (SUCCESS) {
                     break;
                  }
               }

               ++y_pos;
            }

            if (SUCCESS) {
               break;
            }
         }

         grade = 3.0;

         for(int index6 = 0; index6 < 256; ++index6) {
            kind = (double)Math.round(Math.random() * 19.0);
            if (kind != 7.0) {
               break;
            }
         }

         if (world instanceof ServerLevel _level) {
            Commands var10000 = _level.m_7654_().m_129892_();
            CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
            long var10002 = Math.round(grade);
            var10000.m_230957_(var10001, "summon jujutsucraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air");
      }

   }
}
