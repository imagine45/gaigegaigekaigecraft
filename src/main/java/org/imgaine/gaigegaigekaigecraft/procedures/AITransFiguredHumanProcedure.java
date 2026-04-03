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
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
               }
            }

            label125: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label125;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
               }
            }

            int var10000;
            label120: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label120;
                  }
               }

               var10000 = 0;
            }

            if (var10000 < 3 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 3, false, false));
               }
            }

            label114: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label114;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 1, false, false));
                  }
               }
            }

            LivingEntity var34;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var34 = _mobEnt.getTarget();
            } else {
               var34 = null;
            }

            if (var34 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  CalculateAttackProcedure.execute(world, entity);
               }

               if (entity.getPersistentData().getBoolean("explode") && entity.getPersistentData().getDouble("cnt_x2") % 40.0 == 20.0 && GetDistanceProcedure.execute(entity) < 3.0 * ReturnEntitySizeProcedure.execute(entity) && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_x2", 0.0);
            }
         } else if (entity.getPersistentData().getBoolean("explode")) {
            entity.getPersistentData().putDouble("cnt_die", entity.getPersistentData().getDouble("cnt_die") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_die") < 4.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
                  }
               }

               size = ReturnEntitySizeProcedure.execute(entity);
               y_pos = y + (double)entity.getBbHeight() * 0.5;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.5F);
                  } else {
                     _level.playLocalSound(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.75F);
                  } else {
                     _level.playLocalSound(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 1.0F);
                  } else {
                     _level.playLocalSound(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, (float)(1.5 * size), 1.0F, false);
                  }
               }

               world.levelEvent(2001, BlockPos.containing(x, y_pos, z), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, x, y_pos, z, (int)(2.0 * size), 0.5 * (double)entity.getBbWidth(), 0.5 * (double)entity.getBbHeight() * 0.5, 0.5 * (double)entity.getBbWidth(), 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y_pos, z, (int)(40.0 * size), 0.25 * (double)entity.getBbWidth(), 0.25 * (double)entity.getBbHeight() * 0.5, 0.25 * (double)entity.getBbWidth(), 1.0);
               }

               entity.getPersistentData().putDouble("Damage", 10.0 * size);
               entity.getPersistentData().putDouble("Range", 8.0 * size);
               entity.getPersistentData().putDouble("knockback", 0.5 * size);
               entity.getPersistentData().putDouble("effect", 15.0);
               RangeAttackProcedure.execute(world, x, y_pos, z, entity);
               entity.getPersistentData().putDouble("BlockRange", Math.min(entity.getPersistentData().getDouble("cnt_die"), 3.0) * size);
               entity.getPersistentData().putDouble("BlockDamage", 0.1 * size);
               BlockDestroyAllDirectionProcedure.execute(world, x, y_pos, z, entity);
            } else if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
