package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillWiFiProcedure {
   public SkillWiFiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double tick = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)(5.0 + CNT6), 0.5, 0.5, 0.5, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(5.0 * CNT6), 0.5, 0.5, 0.5, 0.05);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 8.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label367: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           label357: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                    break label357;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                 break label367;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 8.0));
                  if (entity.getPersistentData().m_128459_("cnt6") > 5.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                  } else if (entity.getPersistentData().m_128459_("cnt6") == 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") == 5.0) {
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                     }
                  }
               }
            }

            LivingEntity var89;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var89 = _mobEnt.m_5448_();
            } else {
               var89 = null;
            }

            if (var89 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var89 = _mobEnt.m_5448_();
               } else {
                  var89 = null;
               }

               Level var91 = ((Entity)var89).m_9236_();
               ClipContext var10001 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var104 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var106 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var106 = var106.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var110 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var104, var106, var110, var10006, var10007);
               double var92 = (double)var91.m_45547_(var10001).m_82425_().m_123341_();
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               Level var95 = ((Entity)var94).m_9236_();
               ClipContext var10002 = new ClipContext;
               LivingEntity var108;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var108 = _mobEnt.m_5448_();
               } else {
                  var108 = null;
               }

               Vec3 var109 = ((Entity)var108).m_20299_(1.0F);
               LivingEntity var111;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var111 = _mobEnt.m_5448_();
               } else {
                  var111 = null;
               }

               Vec3 var112 = ((Entity)var111).m_20299_(1.0F);
               LivingEntity var116;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var116 = _mobEnt.m_5448_();
               } else {
                  var116 = null;
               }

               var112 = var112.m_82549_(((Entity)var116).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var117 = Block.OUTLINE;
               ClipContext.Fluid var121 = Fluid.NONE;
               LivingEntity var10008;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10008 = _mobEnt.m_5448_();
               } else {
                  var10008 = null;
               }

               var10002.<init>(var109, var112, var117, var121, var10008);
               double var96 = (double)var95.m_45547_(var10002).m_82425_().m_123342_();
               LivingEntity var100;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var100 = _mobEnt.m_5448_();
               } else {
                  var100 = null;
               }

               Level var101 = ((Entity)var100).m_9236_();
               ClipContext var105 = new ClipContext;
               LivingEntity var114;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var114 = _mobEnt.m_5448_();
               } else {
                  var114 = null;
               }

               Vec3 var115 = ((Entity)var114).m_20299_(1.0F);
               LivingEntity var118;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var118 = _mobEnt.m_5448_();
               } else {
                  var118 = null;
               }

               Vec3 var119 = ((Entity)var118).m_20299_(1.0F);
               LivingEntity var122;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var122 = _mobEnt.m_5448_();
               } else {
                  var122 = null;
               }

               var119 = var119.m_82549_(((Entity)var122).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var123 = Block.OUTLINE;
               ClipContext.Fluid var124 = Fluid.NONE;
               LivingEntity var10009;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10009 = _mobEnt.m_5448_();
               } else {
                  var10009 = null;
               }

               var105.<init>(var115, var119, var123, var124, var10009);
               RotateEntityProcedure.execute(var92, var96, (double)var101.m_45547_(var105).m_82425_().m_123343_(), entity);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               entity.getPersistentData().m_128347_("cnt3", 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               yaw = (double)entity.m_146908_();
               picth = (double)entity.m_146909_();
               entity.m_146922_((float)yaw);
               entity.m_146926_(0.0F);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + 1);
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               tick = 80.0 * CNT6;
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("§l" + Component.m_237115_("jujutsu.message.takaba1").getString()), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WI_FI.get(), x_pos, y_pos, z_pos, 1, 0.0, 0.0, 0.0, 0.0);
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(24.0 * CNT6 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, (int)tick, 99, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)tick, 99, false, false));
                        }
                     }

                     entityiterator.m_20256_(new Vec3(0.0, 0.0, 0.0));
                     if (entityiterator.getPersistentData().m_128459_("skill") == 0.0 || entityiterator.getPersistentData().m_128459_("select") == 0.0) {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                        }

                        entityiterator.getPersistentData().m_128347_("skill", -1000.0);
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (int)tick, 0, false, false));
                           }
                        }
                     }

                     if (entityiterator instanceof Player && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        Commands var93 = entity.m_20194_().m_129892_();
                        CommandSourceStack var97 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        String var102 = entityiterator.m_5446_().getString();
                        var93.m_230957_(var97, "tell " + var102 + " §l" + Component.m_237115_("jujutsu.message.takaba1").getString());
                     }

                     EffectCharactorProcedure.execute(world, entity, entityiterator);
                     if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "stopsound @s");
                     }
                  }
               }

               entity.m_146922_((float)yaw);
               entity.m_146926_((float)picth);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F, false);
                  }
               }

               if (entity.m_6084_() && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  float var98;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var98 = _livEnt.m_21223_();
                  } else {
                     var98 = -1.0F;
                  }

                  double var99 = (double)var98;
                  float var103;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var103 = _livEnt.m_21233_();
                  } else {
                     var103 = -1.0F;
                  }

                  _entity.m_21153_((float)(var99 + (double)var103 * 0.5));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") < 10.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123815_, x, y, z, (int)(8.0 * CNT6), 0.5 * CNT6, 0.5 * CNT6, 0.5 * CNT6, 0.5 * CNT6);
            }

            if (entity.getPersistentData().m_128459_("cnt2") > 60.0) {
               entity.getPersistentData().m_128347_("skill", 1705.0);
            }

            if (entity.getPersistentData().m_128459_("cnt2") < 55.0) {
               PlayAnimationProcedure.execute(world, entity);
            }
         }

      }
   }
}
