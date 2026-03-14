package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectCursedSpeechCrumbleAwayProcedure {
   public EffectCursedSpeechCrumbleAwayProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos;
         double y_pos;
         double z_pos;
         Entity entity_a;
         double var10000;
         label83: {
            x_pos = 0.0;
            y_pos = 0.0;
            z_pos = 0.0;
            double theta = 0.0;
            double distance = 0.0;
            double range = 0.0;
            double strength = 0.0;
            entity_a = null;
            entity_a = entityiterator;
            EffectCursedSpeech1Procedure.execute(world, entity, entityiterator);
            x_pos = entityiterator.m_20185_();
            y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
            z_pos = entityiterator.m_20189_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label83;
               }
            }

            var10000 = 0.0;
         }

         double var26 = var10000;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 10, false, false));
            }
         }

         entityiterator.m_20256_(new Vec3(0.0, -2.0, 0.0));
         entityiterator.f_19789_ = (float)(10.0 + var26 * 2.0);

         for(int index0 = 0; index0 < 50; ++index0) {
            double var24 = Math.random() * 6.0 - 3.0;
            double var23 = Math.toRadians(Math.random() * 360.0);
            world.m_7106_(ParticleTypes.f_123796_, x_pos + Math.sin(var23) * var24, y_pos + Math.random() * 12.0, z_pos + Math.cos(var23) * var24, 0.0, -1.0, 0.0);
         }

         label72: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var33 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label72;
               }
            }

            var33 = 0;
         }

         var26 = (double)Math.min(var33 + 1, 30) * 0.1;
         double var25 = (double)Math.round((double)(entityiterator.m_20206_() + 1.0F) * Math.min(var26, 1.0));

         for(int index1 = 0; index1 < (int)var25; ++index1) {
            y_pos -= (0.5 + (double)(entity_a.m_20205_() * 1.0F)) * var26;
            entity.getPersistentData().m_128347_("BlockRange", Math.min((double)(1.0F + entity_a.m_20205_() * 2.0F) * var26, (double)(4.0F + entity_a.m_20205_())));
            entity.getPersistentData().m_128347_("BlockDamage", 6.0);
            BlockDestroyUpwardProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)var26, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)var26, 0.5F, false);
               }
            }

            if (y_pos < entity_a.m_20186_() - var25) {
               break;
            }
         }

         if (!entity_a.m_6084_()) {
            if (!entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
               entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "scale delay set pehkui:height 1 @s");
            }

            if (!entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
               entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "scale set pehkui:height 0.01 @s");
            }
         }

      }
   }
}
