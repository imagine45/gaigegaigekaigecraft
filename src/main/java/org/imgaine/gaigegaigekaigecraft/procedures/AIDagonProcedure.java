package org.imgaine.gaigegaigekaigecraft.procedures;

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
         if (entity.m_6084_()) {
            int var10000;
            if (entity instanceof DagonEntity) {
               DagonEntity _datEntI = (DagonEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
            } else {
               var10000 = 0;
            }

            if (var10000 >= 1) {
               label293: {
                  AIActiveProcedure.execute(world, x, y, z, entity);
                  AIActiveFlyingProcedure.execute(world, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19596_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                        break label293;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 13, false, false));
                     }
                  }
               }
            }

            label268: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                     break label268;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 2, false, false));
                  }
               }
            }

            label263: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19593_)) {
                     break label263;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, 2147483647, 4, false, false));
                  }
               }
            }

            label258: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_(MobEffects.f_19608_)) {
                     break label258;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19608_, 2147483647, 0, false, false));
                  }
               }
            }

            LivingEntity var61;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var61 = _mobEnt.m_5448_();
            } else {
               var61 = null;
            }

            if (var61 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  int var62;
                  if (entity instanceof DagonEntity) {
                     DagonEntity _datEntI = (DagonEntity)entity;
                     var62 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
                  } else {
                     var62 = 0;
                  }

                  if (var62 == 0) {
                     float var63;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var63 = _livEnt.m_21223_();
                     } else {
                        var63 = -1.0F;
                     }

                     double var64 = (double)var63;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var64 < (double)var10001 * 0.75 || entity.getPersistentData().m_128459_("cnt_target") > 600.0) {
                        if (entity instanceof DagonEntity) {
                           DagonEntity _datEntSetI = (DagonEntity)entity;
                           _datEntSetI.m_20088_().m_135381_(DagonEntity.DATA_form, 1);
                        }

                        if (entity instanceof DagonEntity) {
                           DagonEntity animatable = (DagonEntity)entity;
                           animatable.setTexture("dagon2");
                        }

                        label243: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity24 = (LivingEntity)entity;
                              if (_livingEntity24.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 var64 = _livingEntity24.getAttribute_(Attributes.f_22276_).m_22115_();
                                 break label243;
                              }
                           }

                           var64 = 0.0;
                        }

                        health = var64 * 2.0;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity26 = (LivingEntity)entity;
                           if (_livingEntity26.m_21204_().m_22171_(Attributes.f_22276_)) {
                              label235: {
                                 var66 = _livingEntity26.getAttribute_(Attributes.f_22276_);
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livingEntity25 = (LivingEntity)entity;
                                    if (_livingEntity25.m_21204_().m_22171_(Attributes.f_22276_)) {
                                       var69 = _livingEntity25.getAttribute_(Attributes.f_22276_).m_22115_();
                                       break label235;
                                    }
                                 }

                                 var69 = 0.0;
                              }

                              var66.m_22100_(var69 + health);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21233_();
                           } else {
                              var10001 = -1.0F;
                           }

                           _entity.m_21153_(var10001);
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19600_);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        entity.m_20256_(new Vec3(0.0, 2.0, 0.0));
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(15.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 1.0);
                        }
                     }
                  }

                  if (entity instanceof DagonEntity) {
                     DagonEntity _datEntI = (DagonEntity)entity;
                     var62 = (Integer)_datEntI.m_20088_().m_135370_(DagonEntity.DATA_form);
                  } else {
                     var62 = 0;
                  }

                  if (var62 >= 1) {
                     CompoundTag var68 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21223_();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var71 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.m_21233_();
                     } else {
                        var10003 = -1.0F;
                     }

                     label221: {
                        if (var71 < (double)var10003 * 0.5) {
                           label218: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var72 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label218;
                                 }
                              }

                              var72 = 0;
                           }

                           int var73 = var72 - 10;
                           LivingEntity var75;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var75 = _mobEnt.m_5448_();
                           } else {
                              var75 = null;
                           }

                           label212: {
                              LivingEntity var31 = var75;
                              if (var31 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var31;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var76 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label212;
                                 }
                              }

                              var76 = 0;
                           }

                           if (var73 <= var76) {
                              var74 = true;
                              break label221;
                           }
                        }

                        var74 = false;
                     }

                     var68.m_128379_("flag_domain", var74);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     ResetCounterProcedure.execute(entity);
                     if ((!LogicStartProcedure.execute(entity) || !(Math.random() > 0.3) && !entity.getPersistentData().m_128471_("UseCursedTechnique")) && !domain) {
                        CalculateAttackProcedure.execute(world, entity);
                     } else {
                        if (domain) {
                           tick = 20.0;
                           rnd = 20.0;
                           entity.getPersistentData().m_128379_("flag_domain", false);
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

                        entity.getPersistentData().m_128347_("skill", (double)Math.round(800.0 + rnd));
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

                        entity.getPersistentData().m_128379_("UseCursedTechnique", false);
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
