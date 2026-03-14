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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
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
         execute(event, event.getEntity().m_9236_(), event.getEntity(), (double)event.getDistance());
      }

   }

   public static void execute(LevelAccessor world, Entity entity, double distance) {
      execute((Event)null, world, entity, distance);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double distance) {
      if (entity != null) {
         double distance_power = 0.0;
         double curse_energy_color = 0.0;
         boolean logic_fall = false;
         distance_power = distance - 8.0;
         if (entity instanceof Player) {
            logic_fall = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX >= 6000.0 && entity.m_6144_();
         } else {
            logic_fall = entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt4 = (LivingEntity)entity;
            if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               logic_fall = logic_fall || !(entity instanceof Player) || entity.m_6144_();
            }
         }

         boolean var10000;
         label221: {
            if (!logic_fall) {
               label218: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt7 = (LivingEntity)entity;
                     if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                        break label218;
                     }
                  }

                  var10000 = false;
                  break label221;
               }
            }

            var10000 = true;
         }

         logic_fall = var10000;
         if (distance_power > 0.0) {
            distance_power = Math.sqrt(distance_power + 1.0);
            curse_energy_color = ReturnEnergyColorProcedure.execute(entity);
            if (distance_power > 4.0 || curse_energy_color > 0.0) {
               entity.getPersistentData().m_128347_("BlockRange", Math.min(distance_power, 4.0) + (double)entity.m_20205_());
               entity.getPersistentData().m_128347_("BlockDamage", (curse_energy_color > 0.0 ? 1.0 : 0.25) * distance_power);
               BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 15, 6, false, false));
               }
            }

            label215: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label215;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity16.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-10.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (logic_fall) {
               if (curse_energy_color == 1.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.m_20205_() * 0.25, 0.0, (double)entity.m_20205_() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                  }
               } else if (curse_energy_color == 2.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.m_20205_() * 0.25, 0.0, (double)entity.m_20205_() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                  }
               } else if (curse_energy_color == 3.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.m_20205_() * 0.25, 0.0, (double)entity.m_20205_() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                  }
               } else if (curse_energy_color == 4.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.m_20205_() * 0.25, 0.0, (double)entity.m_20205_() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                  }
               } else {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0) * 0.25), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0) * 0.25), (double)entity.m_20205_() * 0.25, 0.0, (double)entity.m_20205_() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                  }
               }

               if (curse_energy_color > 0.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, 0.5F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, 0.5F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }
         }

         if (logic_fall && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

         int var10001;
         label164: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt83 = (LivingEntity)entity;
               if (_livEnt83.m_21023_(MobEffects.f_19600_)) {
                  label159: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label159;
                        }
                     }

                     var10001 = 0;
                  }

                  var10001 += 5;
                  break label164;
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
