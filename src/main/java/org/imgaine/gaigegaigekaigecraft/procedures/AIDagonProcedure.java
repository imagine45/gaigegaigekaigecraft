package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.DagonEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIDagonProcedure {
   public AIDagonProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean infinity = false;
         boolean domain = false;
         double rnd = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double health = 0.0;
         double CNT6 = 0.0;
         double dis = 0.0;
         if (entity.isAlive()) {
            int var10000;
            if (entity instanceof DagonEntity) {
               DagonEntity _datEntI = (DagonEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(DagonEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 >= 1) {
               label296: {
                  AIActiveProcedure.execute(world, x, y, z, entity);
                  AIActiveFlyingProcedure.execute(world, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        break label296;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 13, false, false));
                     }
                  }
               }
            }

            label272: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label272;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 2, false, false));
                  }
               }
            }

            label267: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.hasEffect(MobEffects.DOLPHINS_GRACE)) {
                     break label267;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2147483647, 4, false, false));
                  }
               }
            }

            label262: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.hasEffect(MobEffects.WATER_BREATHING)) {
                     break label262;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2147483647, 0, false, false));
                  }
               }
            }

            if (entity instanceof DagonEntity) {
               DagonEntity _datEntI = (DagonEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(DagonEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 == 0) {
               float var63;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var63 = _livEnt.getHealth();
               } else {
                  var63 = -1.0F;
               }

               double var64 = (double)var63;
               float var10001;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMaxHealth();
               } else {
                  var10001 = -1.0F;
               }

               if (var64 < (double)var10001 * 0.75 || entity.getPersistentData().getDouble("cnt_target") > 600.0) {
                  if (entity instanceof DagonEntity) {
                     DagonEntity _datEntSetI = (DagonEntity)entity;
                     _datEntSetI.getEntityData().set(DagonEntity.DATA_form, 1);
                  }

                  if (entity instanceof DagonEntity) {
                     DagonEntity animatable = (DagonEntity)entity;
                     animatable.setTexture("dagon2");
                  }

                  label251: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity17 = (LivingEntity)entity;
                        if (_livingEntity17.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           var64 = _livingEntity17.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
                           break label251;
                        }
                     }

                     var64 = 0.0;
                  }

                  health = var64 * 2.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity19 = (LivingEntity)entity;
                     if (_livingEntity19.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        AttributeInstance var66;
                        double var70;
                        label243: {
                           var66 = _livingEntity19.getAttribute(Attributes.MAX_HEALTH);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity18 = (LivingEntity)entity;
                              if (_livingEntity18.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                 var70 = _livingEntity18.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
                                 break label243;
                              }
                           }

                           var70 = 0.0;
                        }

                        var66.setBaseValue(var70 + health);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMaxHealth();
                     } else {
                        var10001 = -1.0F;
                     }

                     _entity.setHealth(var10001);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect(MobEffects.DAMAGE_BOOST);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STUN.get());
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  entity.setDeltaMovement(new Vec3(0.0, 2.0, 0.0));
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(15.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 1.0);
                  }
               }
            }

            LivingEntity var67;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var67 = _mobEnt.getTarget();
            } else {
               var67 = null;
            }

            if (var67 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  int var68;
                  if (entity instanceof DagonEntity) {
                     DagonEntity _datEntI = (DagonEntity)entity;
                     var68 = (Integer)_datEntI.getEntityData().get(DagonEntity.DATA_form);
                  } else {
                     var68 = 0;
                  }

                  if (var68 >= 1) {
                     CompoundTag var69 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getHealth();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var72 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.getMaxHealth();
                     } else {
                        var10003 = -1.0F;
                     }
                     boolean var75;
                     label225: {
                        if (var72 < (double)var10003 * 0.5) {
                           int var73;
                           label222: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var73 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label222;
                                 }
                              }

                              var73 = 0;
                           }

                           int var74 = var73 - 10;
                           LivingEntity var76;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var76 = _mobEnt.getTarget();
                           } else {
                              var76 = null;
                           }
                           int var77;
                           label216: {
                              LivingEntity var31 = var76;
                              if (var31 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var31;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var77 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label216;
                                 }
                              }

                              var77 = 0;
                           }

                           if (var74 <= var77) {
                              var75 = true;
                              break label225;
                           }
                        }

                        var75 = false;
                     }

                     var69.putBoolean("flag_domain", var75);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     ResetCounterProcedure.execute(entity);
                     if ((!LogicStartProcedure.execute(entity) || !(Math.random() > 0.3) && !entity.getPersistentData().getBoolean("UseCursedTechnique")) && !domain) {
                        CalculateAttackProcedure.execute(world, entity);
                     } else {
                        if (domain) {
                           tick = 20.0;
                           rnd = 20.0;
                           entity.getPersistentData().putBoolean("flag_domain", false);
                        } else {
                           distance = GetDistanceProcedure.execute(entity);

                           for(int index0 = 0; index0 < 256; ++index0) {
                              rnd = (double)Math.round(Math.ceil(Math.random() * 20.0));
                              if (rnd == 5.0) {
                                 tick = 50.0;
                                 if (!(distance > 16.0)) {
                                    break;
                                 }
                              } else if (rnd == 6.0) {
                                 tick = 75.0;
                                 if (!(distance < 8.0)) {
                                    break;
                                 }
                              } else {
                                 if (rnd == 7.0) {
                                    tick = 75.0;
                                    break;
                                 }

                                 if (rnd == 9.0) {
                                    tick = 125.0;
                                    break;
                                 }

                                 if (rnd == 10.0) {
                                    if (!(Math.random() < 0.5)) {
                                       tick = 200.0;
                                       break;
                                    }
                                 } else if (rnd == 20.0) {
                                    tick = 20.0;
                                    if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        entity.getPersistentData().putDouble("skill", (double)Math.round(800.0 + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }

                        entity.getPersistentData().putBoolean("UseCursedTechnique", false);
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
