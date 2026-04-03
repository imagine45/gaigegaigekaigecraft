package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityCockroachEggsEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityGuillotineEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityHeartEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityJupiterEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityUnlimitedVoidEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIGravestoneProcedure {
   public AIGravestoneProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean flag = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double dis = 0.0;
         Entity entity_a = null;
         if (entity instanceof EntityUnlimitedVoidEntity) {
            entity.getPersistentData().putDouble("cnt_beat", entity.getPersistentData().getDouble("cnt_beat") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_beat") > 0.0) {
               entity.getPersistentData().putDouble("cnt_beat", -5.0);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID_HOLE.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 0, 0.0, 0.0, 0.0, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.PORTAL, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 10, 2.0, 2.0, 2.0, 0.0);
               }
            }
         }

         if (entity instanceof EntityJupiterEntity) {
            entity.setYRot((float)((double)entity.getYRot() + 0.5));
            entity.setXRot(entity.getXRot());
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         } else if (entity instanceof EntityCockroachEggsEntity) {
            if (Math.random() < 0.025 && entity instanceof EntityCockroachEggsEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "shake");
            }
         } else if (entity instanceof EntityHeartEntity) {
            entity.getPersistentData().putDouble("cnt_beat", entity.getPersistentData().getDouble("cnt_beat") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_beat") > 22.0) {
               entity.getPersistentData().putDouble("cnt_beat", 0.0);
               if (entity instanceof EntityHeartEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "heart_beat");
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            }
         } else if (entity instanceof EntityGuillotineEntity && entity.getPersistentData().getDouble("y_offset") < 0.0) {
            entity.teleportTo(x, y - Math.max(-0.5, entity.getPersistentData().getDouble("y_offset")), z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(x, y - Math.max(-0.5, entity.getPersistentData().getDouble("y_offset")), z, entity.getYRot(), entity.getXRot());
            }

            entity.getPersistentData().putDouble("y_offset", entity.getPersistentData().getDouble("y_offset") + 0.5);
         }

         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
               label83: {
                  flag = true;
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt41 = (LivingEntity)entity_a;
                     if (_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label83;
                     }
                  }

                  if (entity_a.getPersistentData().getDouble("select") == 0.0) {
                     entity.getPersistentData().putBoolean("flag", true);
                  }
               }
            }
         }

         if (!flag) {
            entity.getPersistentData().putBoolean("flag", true);
         }

         if (entity.getPersistentData().getBoolean("flag") && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
