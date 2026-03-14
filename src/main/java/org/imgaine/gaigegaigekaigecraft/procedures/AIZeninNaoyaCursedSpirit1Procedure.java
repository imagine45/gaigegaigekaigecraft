package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaCursedSpiritEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIZeninNaoyaCursedSpirit1Procedure {
   public AIZeninNaoyaCursedSpirit1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double rnd = 0.0;
         double level_strength = 0.0;
         double form = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double y_pos = 0.0;
         double CNT6 = 0.0;
         double dis = 0.0;
         if (entity.m_6084_()) {
            int var10000;
            if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
               ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                  }
               }

               if (!((ZeninNaoyaCursedSpiritEntity)entity).animationprocedure.equals("transform") && entity instanceof ZeninNaoyaCursedSpiritEntity) {
                  ((ZeninNaoyaCursedSpiritEntity)entity).setAnimation("transform");
               }

               if (GetHeightFromGroundProcedure.execute(world, entity) < 24.0) {
                  if (entity.m_20184_().m_7098_() < 0.74) {
                     entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() + 0.2, entity.m_20184_().m_7094_()));
                  }
               } else {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               }

               entity.getPersistentData().m_128347_("cnt_transform", entity.getPersistentData().m_128459_("cnt_transform") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_transform") > 100.0) {
                  entity.getPersistentData().m_128347_("cnt_transform", 0.0);
                  AnimationResetProcedure.execute(entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19600_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     _entity.m_21153_(var10001);
                  }

                  if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                     ZeninNaoyaCursedSpiritEntity _datEntSetI = (ZeninNaoyaCursedSpiritEntity)entity;
                     _datEntSetI.m_20088_().m_135381_(ZeninNaoyaCursedSpiritEntity.DATA_form, 2);
                  }

                  if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                     ZeninNaoyaCursedSpiritEntity animatable = (ZeninNaoyaCursedSpiritEntity)entity;
                     animatable.setTexture("naoya_cursed_spirit2");
                  }
               } else if (entity.getPersistentData().m_128459_("cnt_transform") < 40.0 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(5.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * 0.25, (double)entity.m_20206_() * 0.25, (double)entity.m_20205_() * 0.25, 0.1);
               }
            } else {
               if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                  ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
                  var10000 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
               } else {
                  var10000 = 0;
               }

               if (var10000 == 0) {
                  float var64;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var64 = _livEnt.m_21223_();
                  } else {
                     var64 = -1.0F;
                  }

                  double var65 = (double)var64;
                  float var72;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var72 = _livEnt.m_21233_();
                  } else {
                     var72 = -1.0F;
                  }

                  if (var65 < (double)var72 * 0.5 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }

                     if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                        ZeninNaoyaCursedSpiritEntity _datEntSetI = (ZeninNaoyaCursedSpiritEntity)entity;
                        _datEntSetI.m_20088_().m_135381_(ZeninNaoyaCursedSpiritEntity.DATA_form, 1);
                     }

                     if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                        ((ZeninNaoyaCursedSpiritEntity)entity).setAnimation("transform");
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.death")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.death")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }

                        return;
                     }

                     return;
                  }
               }

               if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                  ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
                  var10000 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
               } else {
                  var10000 = 0;
               }

               if (var10000 == 2) {
                  float var67;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var67 = _livEnt.m_21223_();
                  } else {
                     var67 = -1.0F;
                  }

                  double var68 = (double)var67;
                  float var73;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var73 = _livEnt.m_21233_();
                  } else {
                     var73 = -1.0F;
                  }

                  if ((var68 < (double)var73 * 0.5 || entity.getPersistentData().m_128459_("cnt_transform") > 0.0) && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     if (!((ZeninNaoyaCursedSpiritEntity)entity).animationprocedure.equals("death") && entity instanceof ZeninNaoyaCursedSpiritEntity) {
                        ((ZeninNaoyaCursedSpiritEntity)entity).setAnimation("death");
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }

                     if (Math.random() < 0.3 && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(4.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * 0.25, (double)entity.m_20206_() * 0.25, (double)entity.m_20205_() * 0.25, 0.5);
                     }

                     entity.getPersistentData().m_128347_("cnt_transform", entity.getPersistentData().m_128459_("cnt_transform") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt_transform") > 20.0) {
                        entity.getPersistentData().m_128347_("cnt_transform", 0.0);
                        AnimationResetProcedure.execute(entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19600_);
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var73 = _livEnt.m_21233_();
                           } else {
                              var73 = -1.0F;
                           }

                           _entity.m_21153_(var73);
                        }

                        if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                           ZeninNaoyaCursedSpiritEntity _datEntSetI = (ZeninNaoyaCursedSpiritEntity)entity;
                           _datEntSetI.m_20088_().m_135381_(ZeninNaoyaCursedSpiritEntity.DATA_form, 3);
                        }

                        if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                           ZeninNaoyaCursedSpiritEntity animatable = (ZeninNaoyaCursedSpiritEntity)entity;
                           animatable.setTexture("naoya_cursed_spirit3");
                        }

                        entity.getPersistentData().m_128379_("flag_domain", true);
                     }

                     return;
                  }
               }

               AIActiveProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("cnt_special", entity.getPersistentData().m_128459_("cnt_special") + 1.0);
               if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                  ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
                  var10000 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
               } else {
                  var10000 = 0;
               }

               if (var10000 == 3) {
                  form = 3.0;
                  level_strength = 14.0;
               } else {
                  if (entity instanceof ZeninNaoyaCursedSpiritEntity) {
                     ZeninNaoyaCursedSpiritEntity _datEntI = (ZeninNaoyaCursedSpiritEntity)entity;
                     var10000 = (Integer)_datEntI.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 == 2) {
                     form = 2.0;
                     level_strength = 14.0;
                  } else {
                     form = 1.0;
                     level_strength = 10.0;
                  }
               }

               label301: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt68 = (LivingEntity)entity;
                     if (_livEnt68.m_21023_(MobEffects.f_19600_)) {
                        break label301;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)level_strength, false, false));
                     }
                  }
               }

               label296: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt70 = (LivingEntity)entity;
                     if (_livEnt70.m_21023_(MobEffects.f_19606_)) {
                        break label296;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                     }
                  }
               }

               LivingEntity var71;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var71 = _mobEnt.m_5448_();
               } else {
                  var71 = null;
               }

               if (var71 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 8.0) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  if (form >= 2.0 && entity.getPersistentData().m_128459_("cnt_x") == 5.0 && entity.getPersistentData().m_128459_("cnt_special") > 0.0) {
                     entity.getPersistentData().m_128347_("cnt_special", -40.0);
                     EntityUseProjectionSorceryProcedure.execute(entity);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                     if (form >= 3.0) {
                        domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     }

                     if (domain) {
                        tick = 20.0;
                        rnd = 20.0;
                     } else if (LogicStartProcedure.execute(entity)) {
                        distance = GetDistanceProcedure.execute(entity);

                        for(int index0 = 0; index0 < 256; ++index0) {
                           rnd = (double)Math.round(9.0 + Math.random() * 11.0);
                           if (rnd == 10.0) {
                              tick = 75.0;
                              if (!(form <= 1.0) && !(distance > 16.0)) {
                                 break;
                              }
                           } else if (rnd == 15.0) {
                              tick = 240.0;
                              if (!(form <= 2.0) || !(Math.random() < 0.75)) {
                                 break;
                              }
                           } else if (rnd == 16.0) {
                              tick = 140.0;
                              if (!(form >= 3.0)) {
                                 break;
                              }
                           } else if (rnd == 20.0) {
                              tick = 20.0;
                              if (!(form <= 2.0) && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                 break;
                              }
                           } else {
                              rnd = 0.0;
                           }
                        }
                     }

                     if (rnd > 0.0) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", 1900.0 + rnd);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
               }

               if (form <= 2.0 && !entity.m_20096_()) {
                  if (entity.m_20184_().m_7098_() < -0.26) {
                     entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() + 0.025, entity.m_20184_().m_7094_()));
                  } else if (entity.m_20184_().m_7098_() > -0.24) {
                     entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_() - 0.025, entity.m_20184_().m_7094_()));
                  }
               }
            }
         }

      }
   }
}
