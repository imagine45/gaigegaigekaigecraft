package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class AITransFiguredHumanProcedure {
   public AITransFiguredHumanProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double y_pos = 0.0;
         double size = 0.0;
         double distance = 0.0;
         double tick = 0.0;
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
               }
            }

            label125: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label125;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19597_);
               }
            }

            int var10000;
            label120: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label120;
                  }
               }

               var10000 = 0;
            }

            if (var10000 < 3 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 3, false, false));
               }
            }

            label114: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label114;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 1, false, false));
                  }
               }
            }

            LivingEntity var34;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var34 = _mobEnt.m_5448_();
            } else {
               var34 = null;
            }

            if (var34 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  CalculateAttackProcedure.execute(world, entity);
               }

               if (entity.getPersistentData().m_128471_("explode") && entity.getPersistentData().m_128459_("cnt_x2") % 40.0 == 20.0 && GetDistanceProcedure.execute(entity) < 3.0 * ReturnEntitySizeProcedure.execute(entity) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
               entity.getPersistentData().m_128347_("cnt_x2", 0.0);
            }
         } else if (entity.getPersistentData().m_128471_("explode")) {
            entity.getPersistentData().m_128347_("cnt_die", entity.getPersistentData().m_128459_("cnt_die") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_die") < 4.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 60, 1, false, false));
                  }
               }

               size = ReturnEntitySizeProcedure.execute(entity);
               y_pos = y + (double)entity.m_20206_() * 0.5;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.5F);
                  } else {
                     _level.m_7785_(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.75F);
                  } else {
                     _level.m_7785_(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 1.0F);
                  } else {
                     _level.m_7785_(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 1.0F, false);
                  }
               }

               world.m_46796_(2001, BlockPos.m_274561_(x, y_pos, z), Block.m_49956_(Blocks.f_50330_.m_49966_()));
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x, y_pos, z, (int)(2.0 * size), 0.5 * (double)entity.m_20205_(), 0.5 * (double)entity.m_20206_() * 0.5, 0.5 * (double)entity.m_20205_(), 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y_pos, z, (int)(40.0 * size), 0.25 * (double)entity.m_20205_(), 0.25 * (double)entity.m_20206_() * 0.5, 0.25 * (double)entity.m_20205_(), 1.0);
               }

               entity.getPersistentData().m_128347_("Damage", 10.0 * size);
               entity.getPersistentData().m_128347_("Range", 8.0 * size);
               entity.getPersistentData().m_128347_("knockback", 0.5 * size);
               entity.getPersistentData().m_128347_("effect", 15.0);
               RangeAttackProcedure.execute(world, x, y_pos, z, entity);
               entity.getPersistentData().m_128347_("BlockRange", Math.min(entity.getPersistentData().m_128459_("cnt_die"), 3.0) * size);
               entity.getPersistentData().m_128347_("BlockDamage", 0.1 * size);
               BlockDestroyAllDirectionProcedure.execute(world, x, y_pos, z, entity);
            } else if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
