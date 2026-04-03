package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ReverseCursedTechniqueOnEffectActiveTickProcedure {
   public ReverseCursedTechniqueOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean using = false;
         boolean heal = false;
         double effectLevel = 0.0;
         double fatigue = 0.0;
         double old_level = 0.0;
         double distance = 0.0;
         double Amount = 0.0;
         double old_tick = 0.0;
         double NUM1 = 0.0;
         if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
            }
         } else {
            int var10001;
            label270: {
               Player = entity instanceof Player;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                     var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getDuration();
                     break label270;
                  }
               }

               var10001 = 0;
            }

            fatigue = 1.0 + (double)Math.min(Math.max(var10001, 0) / 600, 10) * 0.4;
            if (entity.isAlive()) {
               double var10000;
               label264: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier();
                        break label264;
                     }
                  }

                  var10000 = 0.0;
               }

               effectLevel = var10000;
               Amount = 12.5 + Math.abs(effectLevel) * 7.5;
               using = false;
               heal = entity.getPersistentData().getBoolean("CursedSpirit") ? effectLevel < 0.0 : true;
               if (heal) {
                  float var71;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var71 = _livEnt.getHealth();
                  } else {
                     var71 = -1.0F;
                  }

                  float var79;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var79 = _livEnt.getMaxHealth();
                  } else {
                     var79 = -1.0F;
                  }

                  if (var71 < var79) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var71 = _livEnt.getMaxHealth();
                     } else {
                        var71 = -1.0F;
                     }

                     NUM1 = (double)(var71 / 160.0F) * Amount * 0.1;
                     if (entity.getPersistentData().getBoolean("PRESS_M")) {
                        NUM1 /= fatigue;
                     }

                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        Commands var73 = entity.getServer().getCommands();
                        CommandSourceStack var80 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                        double var10002 = Math.abs(NUM1);
                        var73.performPrefixedCommand(var80, "jjc_heal " + var10002 + " " + entity.getStringUUID());
                     }

                     using = true;
                  }
               } else {
                  float var74;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var74 = _livEnt.getMaxHealth();
                  } else {
                     var74 = -1.0F;
                  }

                  NUM1 = (double)var74 * 0.25;
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_combat")))), (float)NUM1);
                  using = true;
                  if (!entity.isAlive()) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x, y + (double)entity.getBbHeight() * 0.5, z, 5, 1.0, 1.0, 1.0, 0.5);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x, y + (double)entity.getBbHeight() * 0.5, z, 5, 1.0, 1.0, 1.0, 0.5);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x, y + (double)entity.getBbHeight() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (!Player && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               }

               if (using) {
                  if (effectLevel >= 0.0 && Math.random() < 1.0 / fatigue && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_WHITE.get(), x, y + (double)entity.getBbHeight() * 0.5, z, 1, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.1);
                  }

                  label256: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                           break label256;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt30 = (LivingEntity)entity;
                        if (_livEnt30.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                           label249: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                                    var10000 = (double)_livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
                                    break label249;
                                 }
                              }

                              var10000 = 0.0;
                           }

                           label244: {
                              old_level = var10000;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                                    var10000 = (double)_livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration();
                                    break label244;
                                 }
                              }

                              var10000 = 0.0;
                           }

                           old_tick = var10000;
                           if (old_tick > 4.0 * Amount * 0.1) {
                              old_tick -= 4.0 * Amount * 0.1;
                           } else {
                              --old_level;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                           }

                           if (Math.ceil(old_tick) > 0.0 && old_level >= 0.0 && entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)Math.ceil(old_tick), (int)Math.round(old_level), false, false));
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt35 = (LivingEntity)entity;
                     if (_livEnt35.hasEffect((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                        label236: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                                 var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STUN.get()).getAmplifier();
                                 break label236;
                              }
                           }

                           var10000 = 0.0;
                        }

                        label231: {
                           old_level = var10000;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                                 var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STUN.get()).getDuration();
                                 break label231;
                              }
                           }

                           var10000 = 0.0;
                        }

                        old_tick = var10000;
                        if (old_tick > 4.0 * Amount * 0.1) {
                           old_tick -= 4.0 * Amount * 0.1;
                        } else {
                           --old_level;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STUN.get());
                        }

                        if (Math.ceil(old_tick) > 0.0 && old_level >= 0.0 && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), (int)Math.ceil(old_tick), (int)Math.round(old_level), false, false));
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().getBoolean("PRESS_M")) {
                     if (Player) {
                        Amount = entity.getPersistentData().getBoolean("CursedSpirit") ? 5.0 : 10.0;
                        Amount /= fatigue;
                        double Amount_new = Amount;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> capability.PlayerCursePowerChange -= Amount_new);
                     }

                     if (!ActiveTickConditionProcedure.execute(entity) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           MobEffect var10003;
                           int var10004;
                           MobEffectInstance var81;
                           label222: {
                              var10003 = (MobEffect)JujutsucraftModMobEffects.FATIGUE.get();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get())) {
                                    var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.FATIGUE.get()).getDuration();
                                    break label222;
                                 }
                              }

                              var10004 = 0;
                           }

                           var81 = new MobEffectInstance(var10003, Math.min(var10004 + 20, 6000), 0, false, false);
                           _entity.addEffect(var81);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_M") && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_reverse_cursed_technique_output")))) {
                  distance = (double)(entity.getBbWidth() * 1.0F);
                  Vec3 _center = new Vec3(entity.getX() + entity.getLookAngle().x * distance, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getLookAngle().y * distance, entity.getZ() + entity.getLookAngle().z * distance);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(distance * 3.0 / 2.0), (e) -> true)) {
                     if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && entity != entityiterator) {
                        using = false;
                        if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                              using = true;
                           }
                        } else if (!entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                           using = true;
                        }

                        if (using && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2, 0));
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
