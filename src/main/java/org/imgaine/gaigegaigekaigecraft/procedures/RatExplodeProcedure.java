package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class RatExplodeProcedure {
   public RatExplodeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 10, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < 15.0 && entity.getPersistentData().m_128459_("cnt1") < 10.0 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity8 = (LivingEntity)entity;
            if (_livingEntity8.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity8.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(2015.0);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > 15.0 && entity.getPersistentData().m_128459_("cnt1") < 25.0) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") < 20.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            range = ReturnEntitySizeProcedure.execute(entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)(15.0 * range), 1.5 * range, 1.5 * range, 1.5 * range, 1.0);
            }

            for(int index0 = 0; index0 < (int)(32.0 * range); ++index0) {
               ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0 * range, 2.0 * range, Mth.m_216263_(RandomSource.m_216327_(), 0.0, 4.0) * range, x_pos, x_pos, entity.m_20186_(), entity.m_20186_(), 0.0, z_pos, z_pos, Math.random() < 0.5 ? "jujutsucraft:particle_flame_purple" : "sneeze");
               ParticleGeneratorCircleProcedure.execute(world, 1.0, Mth.m_216263_(RandomSource.m_216327_(), -45.0, 45.0), 0.0 * range, 2.0 * range, Mth.m_216263_(RandomSource.m_216327_(), 0.0, 3.0) * range, x_pos, x_pos, y_pos, y_pos, Mth.m_216263_(RandomSource.m_216327_(), -360.0, 360.0), z_pos, z_pos, Math.random() < 0.5 ? "jujutsucraft:particle_flame_purple" : "sneeze");
            }

            entity.getPersistentData().m_128347_("Damage", 13.0);
            entity.getPersistentData().m_128347_("Range", Math.min(entity.getPersistentData().m_128459_("cnt2") * 6.0, 48.0));
            entity.getPersistentData().m_128347_("knockback", 0.5);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("Damage", 14.0);
            entity.getPersistentData().m_128347_("Range", Math.min(entity.getPersistentData().m_128459_("cnt2") * 6.0, 32.0));
            entity.getPersistentData().m_128347_("knockback", 1.0);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("BlockRange", Math.min(entity.getPersistentData().m_128459_("cnt2") * 6.0, 32.0));
            entity.getPersistentData().m_128347_("BlockDamage", 0.2);
            BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 35.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
