package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.HanakoHandEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NeedleEntity;
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

public class AINeedleProcedure {
   public AINeedleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") == 4.0) {
            entity.getPersistentData().m_128347_("cnt_bullet_hit", 15.0);
            BulletDomainHit2Procedure.execute(world, entity);
         }

         if (entity instanceof HanakoHandEntity && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123765_, x, y, z, (int)Math.max(entity.m_20205_() * 2.0F, 1.0F), (double)entity.m_20205_() * 0.5, 0.0, (double)entity.m_20205_() * 0.5, 0.0);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= 5.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 5.0) {
               if (entity instanceof NeedleEntity) {
                  ((NeedleEntity)entity).setAnimation("attack");
               }

               if (entity instanceof HanakoHandEntity) {
                  ((HanakoHandEntity)entity).setAnimation("attack");
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == 7.0) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               x_power = 0.0;
               y_power = 1.0;
               z_power = 0.0;

               for(int index0 = 0; index0 < (int)Math.ceil((double)entity.m_20206_()); ++index0) {
                  entity.getPersistentData().m_128347_("Damage", 10.0 * CNT6);
                  if (entity instanceof NeedleEntity) {
                     entity.getPersistentData().m_128347_("effect", 1.0);
                     entity.getPersistentData().m_128347_("knockback", 0.01);
                     entity.getPersistentData().m_128347_("Range", 2.5 + (double)(entity.m_20205_() * 2.0F));
                  } else if (entity instanceof HanakoHandEntity) {
                     entity.getPersistentData().m_128347_("effect", 5.0);
                     entity.getPersistentData().m_128347_("knockback", Math.min(Math.max(0.5 * Math.max(CNT6 * CNT6, 1.0), 0.1), 1.5));
                     entity.getPersistentData().m_128347_("Range", (double)(4.0F + entity.m_20205_() * 2.0F));
                  }

                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 35.0 && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
         }

      }
   }
}
