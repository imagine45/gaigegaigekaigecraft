package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIScissorProcedure {
   public AIScissorProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double pitch = 0.0;
         double yaw = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         Entity entity_a = null;
         if (entity.isAlive()) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") < 40.0) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("TARGET"));
               if (entity_a instanceof LivingEntity) {
                  entity.teleportTo(entity_a.getX() + entity.getPersistentData().getDouble("x_pos"), entity_a.getY() + entity.getPersistentData().getDouble("y_pos"), entity_a.getZ() + entity.getPersistentData().getDouble("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getX() + entity.getPersistentData().getDouble("x_pos"), entity_a.getY() + entity.getPersistentData().getDouble("y_pos"), entity_a.getZ() + entity.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 40.0) {
               entity.getPersistentData().putDouble("cnt_bullet_hit", 10.0);
               BulletDomainHit2Procedure.execute(world, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               x_power = entity.getLookAngle().x;
               y_power = entity.getLookAngle().y;
               z_power = entity.getLookAngle().z;

               for(int index0 = 0; index0 < (int)(1.0F + entity.getBbWidth()); ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.25F, 1.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.25F, 1.5F, false);
                     }
                  }

                  entity.getPersistentData().putDouble("Damage", 18.0);
                  entity.getPersistentData().putDouble("Range", 3.0);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("BlockDamage", 1.0);
                  entity.getPersistentData().putDouble("BlockRange", 2.0);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            } else if (entity.getPersistentData().getDouble("cnt1") > 60.0 && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
