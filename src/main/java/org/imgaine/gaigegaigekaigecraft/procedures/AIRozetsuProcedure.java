package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.RozetsuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIRozetsuProcedure {
   public AIRozetsuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double lv = 0.0;
         double distance = 0.0;
         double skill_num = 0.0;
         double level = 0.0;
         double strength = 0.0;
         double health = 0.0;
         double CNT6 = 0.0;
         double dis = 0.0;
         boolean domain = false;
         if (entity.isAlive()) {
            if (entity.getPersistentData().getDouble("transform") > 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                  }
               }

               entity.getPersistentData().putDouble("transform", entity.getPersistentData().getDouble("transform") + 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity5 = (LivingEntity)entity;
                  if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(2015.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity.getPersistentData().getDouble("transform") < 4.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 9, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.WITCH, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(16.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 1.25);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.DRAGON_BREATH, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(8.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.5);
               }

               if (entity.getPersistentData().getDouble("transform") > 100.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F, false);
                     }
                  }

                  entity.getPersistentData().putDouble("transform", 0.0);
                  if (entity instanceof RozetsuEntity) {
                     RozetsuEntity _datEntSetI = (RozetsuEntity)entity;
                     _datEntSetI.getEntityData().set(RozetsuEntity.DATA_form, 1);
                  }

                  if (entity instanceof RozetsuEntity) {
                     RozetsuEntity animatable = (RozetsuEntity)entity;
                     animatable.setTexture("rozetsu2");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity31 = (LivingEntity)entity;
                     if (_livingEntity31.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        AttributeInstance var10000;
                        double var10001;
                        label262: {
                           var10000 = _livingEntity31.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity30 = (LivingEntity)entity;
                              if (_livingEntity30.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity30.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                                 break label262;
                              }
                           }

                           var10001 = 0.0;
                        }

                        var10000.setBaseValue(var10001 + 1.0);
                     }
                  }

                  double var75;
                  label253: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity32 = (LivingEntity)entity;
                        if (_livingEntity32.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           var75 = _livingEntity32.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
                           break label253;
                        }
                     }

                     var75 = 0.0;
                  }

                  health = var75 * 0.5;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity34 = (LivingEntity)entity;
                     if (_livingEntity34.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        double var88;
                        AttributeInstance var76;
                        label246: {
                           var76 = _livingEntity34.getAttribute(Attributes.MAX_HEALTH);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity33 = (LivingEntity)entity;
                              if (_livingEntity33.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                 var88 = _livingEntity33.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
                                 break label246;
                              }
                           }

                           var88 = 0.0;
                        }

                        var76.setBaseValue(var88 + health);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     float var89;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var89 = _livEnt.getHealth();
                     } else {
                        var89 = -1.0F;
                     }

                     _entity.setHealth((float)((double)var89 + health));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect(MobEffects.DAMAGE_BOOST);
                  }

                  AnimationResetProcedure.execute(entity);
               }
            } else {
               int var77;
               if (entity instanceof RozetsuEntity) {
                  RozetsuEntity _datEntI = (RozetsuEntity)entity;
                  var77 = (Integer)_datEntI.getEntityData().get(RozetsuEntity.DATA_form);
               } else {
                  var77 = 0;
               }

               if (var77 == 1) {
                  label353: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 2147483647, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt40 = (LivingEntity)entity;
                        if (_livEnt40.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           break label353;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 14, false, false));
                        }
                     }
                  }
               } else {
                  label363: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt42 = (LivingEntity)entity;
                        if (_livEnt42.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           break label363;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 10, false, false));
                        }
                     }
                  }
               }

               label328: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt44 = (LivingEntity)entity;
                     if (_livEnt44.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        break label328;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                     }
                  }
               }

               AIActiveProcedure.execute(world, x, y, z, entity);
               LivingEntity var78;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var78 = _mobEnt.getTarget();
               } else {
                  var78 = null;
               }

               if (var78 instanceof LivingEntity) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     int var79;
                     if (entity instanceof RozetsuEntity) {
                        RozetsuEntity _datEntI = (RozetsuEntity)entity;
                        var79 = (Integer)_datEntI.getEntityData().get(RozetsuEntity.DATA_form);
                     } else {
                        var79 = 0;
                     }

                     if (var79 == 0) {
                        float var80;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var80 = _livEnt.getHealth();
                        } else {
                           var80 = -1.0F;
                        }

                        double var81 = (double)var80;
                        float var90;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var90 = _livEnt.getMaxHealth();
                        } else {
                           var90 = -1.0F;
                        }

                        if (var81 < (double)var90 * 0.5) {
                           entity.getPersistentData().putDouble("transform", 1.0);
                           if (world instanceof ServerLevel) {
                              for(Entity entityiterator : ((ServerLevel)world).getAllEntities()) {
                                 if (entityiterator != null && entity != entityiterator && entityiterator instanceof Mob && entityiterator.getPersistentData().getBoolean("CursedSpirit") && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID()) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                                 }
                              }
                           }
                        }
                     }

                     if (entity instanceof RozetsuEntity) {
                        RozetsuEntity _datEntI = (RozetsuEntity)entity;
                        var79 = (Integer)_datEntI.getEntityData().get(RozetsuEntity.DATA_form);
                     } else {
                        var79 = 0;
                     }

                     if (var79 > 0) {
                        float var83;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var83 = _livEnt.getHealth();
                        } else {
                           var83 = -1.0F;
                        }

                        double var84 = (double)var83;
                        float var91;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var91 = _livEnt.getMaxHealth();
                        } else {
                           var91 = -1.0F;
                        }

                        if (var84 < (double)var91 * 0.5) {
                           int var85;
                           label302: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var85 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label302;
                                 }
                              }

                              var85 = 0;
                           }

                           int var86 = var85 - 10;
                           LivingEntity var92;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var92 = _mobEnt.getTarget();
                           } else {
                              var92 = null;
                           }
                           int var93;
                           label296: {
                              LivingEntity var36 = var92;
                              if (var36 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var36;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var93 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label296;
                                 }
                              }

                              var93 = 0;
                           }

                           if (var86 <= var93) {
                              entity.getPersistentData().putBoolean("flag_domain", true);
                           }
                        }
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (domain) {
                        tick = 20.0;
                        rnd = 20.0;
                     } else {
                        if (entity instanceof RozetsuEntity) {
                           RozetsuEntity _datEntI = (RozetsuEntity)entity;
                           var79 = (Integer)_datEntI.getEntityData().get(RozetsuEntity.DATA_form);
                        } else {
                           var79 = 0;
                        }

                        if (var79 > 0) {
                           label281: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt72 = (LivingEntity)entity;
                                 if (_livEnt72.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label281;
                                 }
                              }

                              if (distance < 6.0 && Math.random() < 0.15) {
                                 rnd = 4.0;
                                 level = 1.0;
                                 tick = 50.0;
                              }
                           }
                        } else if (LogicStartProcedure.execute(entity) && Math.random() < 0.5 && !(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("SHIKIGAMI_ROZETSU_UUID")) instanceof LivingEntity)) {
                           rnd = 10.0;
                           level = 0.0;
                           tick = 100.0;
                        }
                     }

                     if (rnd > 0.0) {
                        ResetCounterProcedure.execute(entity);
                        if (rnd == 10.0) {
                           SkillRozetsuShikigamiProcedure.execute(world, x, y, z, entity);
                        } else {
                           entity.getPersistentData().putDouble("skill", 4300.0 + rnd);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                              }
                           }
                        }

                        if (level > 0.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              }
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               }
            }
         }

      }
   }
}
