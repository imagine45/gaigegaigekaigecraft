package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
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
            entity.getPersistentData().m_128347_("cnt_beat", entity.getPersistentData().m_128459_("cnt_beat") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_beat") > 0.0) {
               entity.getPersistentData().m_128347_("cnt_beat", -5.0);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID_HOLE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 0, 0.0, 0.0, 0.0, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123760_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 10, 2.0, 2.0, 2.0, 0.0);
               }
            }
         }

         if (entity instanceof EntityJupiterEntity) {
            entity.m_146922_((float)((double)entity.m_146908_() + 0.5));
            entity.m_146926_(entity.m_146909_());
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }
         } else if (entity instanceof EntityCockroachEggsEntity) {
            if (Math.random() < 0.025 && entity instanceof EntityCockroachEggsEntity) {
               ((EntityCockroachEggsEntity)entity).setAnimation("shake");
            }
         } else if (entity instanceof EntityHeartEntity) {
            entity.getPersistentData().m_128347_("cnt_beat", entity.getPersistentData().m_128459_("cnt_beat") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_beat") > 22.0) {
               entity.getPersistentData().m_128347_("cnt_beat", 0.0);
               if (entity instanceof EntityHeartEntity) {
                  ((EntityHeartEntity)entity).setAnimation("heart_beat");
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            }
         } else if (entity instanceof EntityGuillotineEntity && entity.getPersistentData().m_128459_("y_offset") < 0.0) {
            entity.m_6021_(x, y - Math.max(-0.5, entity.getPersistentData().m_128459_("y_offset")), z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(x, y - Math.max(-0.5, entity.getPersistentData().m_128459_("y_offset")), z, entity.m_146908_(), entity.m_146909_());
            }

            entity.getPersistentData().m_128347_("y_offset", entity.getPersistentData().m_128459_("y_offset") + 0.5);
         }

         entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
               label83: {
                  flag = true;
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt41 = (LivingEntity)entity_a;
                     if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label83;
                     }
                  }

                  if (entity_a.getPersistentData().m_128459_("select") == 0.0) {
                     entity.getPersistentData().m_128379_("flag", true);
                  }
               }
            }
         }

         if (!flag) {
            entity.getPersistentData().m_128379_("flag", true);
         }

         if (entity.getPersistentData().m_128471_("flag") && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
