package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenEntityFallProcedure {
   public WhenEntityFallProcedure() {
   }

   @SubscribeEvent
   public static void onEntityFall(LivingFallEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().level(), event.getEntity(), (double)event.getDistance());
      }

   }

   public static void execute(LevelAccessor world, Entity entity, double distance) {
      execute((Event)null, world, entity, distance);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double distance) {
      if (entity != null) {
         boolean logic_fall = false;
         double distance_power = 0.0;
         double curse_energy_color = 0.0;
         double particle_amount = 0.0;
         double particle_speed = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         distance_power = distance - 8.0;
         if (entity instanceof Player) {
            logic_fall = entity.isShiftKeyDown() && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX >= 6000.0;
         } else {
            logic_fall = entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt4 = (LivingEntity)entity;
            if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               logic_fall = logic_fall || !(entity instanceof Player) || entity.isShiftKeyDown();
            }
         }

         boolean var10000;
         label195: {
            if (!logic_fall) {
               label192: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt7 = (LivingEntity)entity;
                     if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                        break label192;
                     }
                  }

                  var10000 = false;
                  break label195;
               }
            }

            var10000 = true;
         }

         logic_fall = var10000;
         if (distance_power > 0.0) {
            x_pos = entity.getX();
            y_pos = entity.getY();
            z_pos = entity.getZ();
            distance_power = Math.sqrt(distance_power + 1.0);
            curse_energy_color = ReturnEnergyColorProcedure.execute(entity);
            if (distance_power > 4.0 || curse_energy_color > 0.0) {
               entity.getPersistentData().putDouble("BlockRange", Math.min(distance_power, 4.0) + (double)entity.getBbWidth());
               entity.getPersistentData().putDouble("BlockDamage", (curse_energy_color > 0.0 ? 1.0 : 0.25) * distance_power);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 6, false, false));
               }
            }

            label189: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label189;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity16.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-10.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (logic_fall) {
               particle_amount = Math.min(distance_power * distance_power + 20.0, 100.0);
               particle_speed = 0.5 + Math.min(distance_power * 0.25, 1.5);
               if (curse_energy_color == 1.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, particle_speed);
                  }
               } else if (curse_energy_color == 2.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, particle_speed);
                  }
               } else if (curse_energy_color == 3.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, particle_speed);
                  }
               } else if (curse_energy_color == 4.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, particle_speed);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(particle_amount * 1.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, particle_speed * 2.0);
               }

               if (curse_energy_color > 0.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.nextDouble(RandomSource.create(), 0.5, 0.6));
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.nextDouble(RandomSource.create(), 0.5, 0.6), false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.nextDouble(RandomSource.create(), 0.5, 0.6));
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.nextDouble(RandomSource.create(), 0.5, 0.6), false);
                  }
               }
            }
         }

         if (logic_fall && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         int var10001;
         label138: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt38 = (LivingEntity)entity;
               if (_livEnt38.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  label133: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label133;
                        }
                     }

                     var10001 = 0;
                  }

                  var10001 += 5;
                  break label138;
               }
            }

            var10001 = 0;
         }

         if (distance < (double)var10001 && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

      }
   }
}
