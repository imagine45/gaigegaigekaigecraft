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
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") == 4.0) {
            entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
            BulletDomainHit2Procedure.execute(world, entity);
         }

         if (entity instanceof HanakoHandEntity && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, (int)Math.max(entity.getBbWidth() * 2.0F, 1.0F), (double)entity.getBbWidth() * 0.5, 0.0, (double)entity.getBbWidth() * 0.5, 0.0);
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 5.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
               if (entity instanceof NeedleEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "attack");
               }

               if (entity instanceof HanakoHandEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "attack");
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 7.0) {
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               x_power = 0.0;
               y_power = 1.0;
               z_power = 0.0;

               for(int index0 = 0; index0 < (int)Math.ceil((double)entity.getBbHeight()); ++index0) {
                  entity.getPersistentData().putDouble("Damage", 10.0 * CNT6);
                  if (entity instanceof NeedleEntity) {
                     entity.getPersistentData().putDouble("effect", 1.0);
                     entity.getPersistentData().putDouble("knockback", 0.01);
                     entity.getPersistentData().putDouble("Range", 2.5 + (double)(entity.getBbWidth() * 2.0F));
                  } else if (entity instanceof HanakoHandEntity) {
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putDouble("knockback", Math.min(Math.max(0.5 * Math.max(CNT6 * CNT6, 1.0), 0.1), 1.5));
                     entity.getPersistentData().putDouble("Range", (double)(4.0F + entity.getBbWidth() * 2.0F));
                  }

                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 35.0 && !entity.level().isClientSide()) {
               entity.discard();
            }

            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         }

      }
   }
}
