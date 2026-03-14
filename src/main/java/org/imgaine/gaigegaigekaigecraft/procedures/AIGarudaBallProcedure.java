package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIGarudaBallProcedure {
   public AIGarudaBallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_attack = false;
         boolean big = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double dis = 0.0;
         double z_power = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double power = 0.0;
         double entity_size = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75;
         z_pos = entity.m_20189_();
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get(), 5, 9, false, false));
            }
         }

         power = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt6") > 0.0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") <= 3.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 4.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 4.0F, 1.5F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)(25.0 * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)(25.0 * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, 1.0);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().m_128471_("Stop")) {
               entity.getPersistentData().m_128379_("Stop", true);
            } else {
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 2.0, entity.getPersistentData().m_128459_("y_power") * 2.0, entity.getPersistentData().m_128459_("z_power") * 2.0));
               entity.getPersistentData().m_128347_("BlockRange", 4.0 * power * entity_size);
               entity.getPersistentData().m_128347_("BlockDamage", 18.0 * power);
               entity.getPersistentData().m_128379_("noParticle", true);
               entity.getPersistentData().m_128379_("ExtinctionBlock", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("Range", 8.0 * power * entity_size);
               entity.getPersistentData().m_128347_("knockback", 1.0);
               KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               BulletDomainHit2Procedure.execute(world, entity);
               dis = ReturnEntitySizeProcedure.execute(entity);
               entity.getPersistentData().m_128347_("Damage", 30.0);
               if (entity.getPersistentData().m_128459_("cnt_life") > 0.0) {
                  for(int index0 = 0; index0 < (int)Math.round(entity.getPersistentData().m_128459_("cnt_life")); ++index0) {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
                     if (entity.getPersistentData().m_128459_("Damage") < 24.0) {
                        entity.getPersistentData().m_128347_("Damage", 24.0);
                        break;
                     }
                  }
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * power);
               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
               entity.getPersistentData().m_128347_("Range", 8.0 * entity_size);
               entity.getPersistentData().m_128347_("knockback", 0.5);
               entity.getPersistentData().m_128347_("effect", 1.0);
               entity.getPersistentData().m_128347_("effectConfirm", 2.0);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 15.0) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().m_128347_("despawn_flag", 1.0);
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
