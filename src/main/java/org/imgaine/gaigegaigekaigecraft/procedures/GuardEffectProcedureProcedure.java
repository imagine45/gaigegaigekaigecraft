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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GuardEffectProcedureProcedure {
   public GuardEffectProcedureProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         boolean logic_a = false;
         boolean logic_iron_attack = false;
         boolean logic_iron_guard = false;
         double num1 = 0.0;
         double num2 = 0.0;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entityiterator;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
               PlayAnimationEntityGuardProcedure.execute(world, entity, entityiterator);
            }
         }

         int var10000;
         label189: {
            label188: {
               num1 = entity.getPersistentData().getDouble("skill");
               num2 = entityiterator.getPersistentData().getDouble("skill");
               if (LogicSwordProcedure.execute(entity)) {
                  if (num1 != 0.0 && entity.getPersistentData().getBoolean("attack")) {
                     break label188;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label188;
                     }
                  }

                  if (num1 == 0.0) {
                     break label188;
                  }
               }

               var10000 = 0;
               break label189;
            }

            var10000 = 1;
         }

         label176: {
            label175: {
               logic_iron_attack = var10000 != 0;
               if (LogicSwordProcedure.execute(entityiterator)) {
                  if (num2 != 0.0 && entityiterator.getPersistentData().getBoolean("attack")) {
                     break label175;
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                     if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label175;
                     }
                  }
               }

               var10000 = 0;
               break label176;
            }

            var10000 = 1;
         }

         logic_iron_guard = var10000 != 0;
         if (!logic_iron_attack) {
            if (num1 == 105.0 || num1 == 106.0) {
               logic_iron_attack = true;
            }

            if (num1 >= 806.0 && num1 <= 809.0) {
               logic_iron_attack = true;
            }

            if (num1 >= 1405.0 && num1 <= 1410.0) {
               logic_iron_attack = true;
            }

            if (num1 == 2405.0 || num1 == 2409.0) {
               logic_iron_attack = true;
            }

            if (num1 >= 3205.0 && num1 < 3220.0) {
               logic_iron_attack = true;
            }

            if (num1 == 3908.0 || num1 == 3909.0) {
               logic_iron_attack = true;
            }
         }

         if (logic_iron_guard && num1 != 0.0 && !entity.getPersistentData().getBoolean("attack")) {
            label141: {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entityiterator;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                     break label141;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 10) {
               logic_iron_guard = false;
            }
         }

         if (!logic_iron_guard) {
            if (LogicIronBodyProcedure.execute(entityiterator)) {
               logic_iron_guard = true;
            }

            if (num2 == 105.0 || num2 == 106.0) {
               logic_iron_guard = true;
            }
         }

         if (logic_iron_attack && logic_iron_guard) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), x, y, z, 1, 0.5, 0.5, 0.5, 0.25);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_sword")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_sword")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }

            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
               entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound entity.player.attack.strong master @a ~ ~ ~ 0.5 1 0");
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x, y, z, 1, 0.5, 0.5, 0.5, 0.25);
            }

            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
               entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound entity.player.attack.strong master @a ~ ~ ~ 1 1 0");
            }
         }

         if (logic_iron_guard && GetDistanceIteratorProcedure.execute(entity, entityiterator) < 5.0) {
            logic_a = entityiterator.getPersistentData().getBoolean("attack");
            entityiterator.getPersistentData().putBoolean("attack", true);
            CursedToolsAbilityProcedure.execute(entityiterator, entity);
            entityiterator.getPersistentData().putBoolean("attack", logic_a);
         }

         label123: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                  break label123;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0) {
            JustGuardProcedure.execute(entityiterator);
         }

      }
   }
}
