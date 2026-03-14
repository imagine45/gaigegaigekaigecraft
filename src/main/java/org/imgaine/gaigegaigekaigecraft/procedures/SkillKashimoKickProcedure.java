package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillKashimoKickProcedure {
   public SkillKashimoKickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double tick = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double HP = 0.0;
         double rnd = 0.0;
         double strength = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double old_cnt2 = 0.0;
         double old_cnt1 = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") <= 10.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 4, 4, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 9.0 && entity.getPersistentData().m_128459_("cnt1") <= 10.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 12.0) {
                     label311: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           label299: {
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
                                    break label299;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                 break label311;
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
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 9.0));
               }

               if (entity.getPersistentData().m_128459_("cnt6") < 5.0) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt6", 5.0);
                  if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
                     entity.getPersistentData().m_128347_("cnt7", 1.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 4.0 * range, 90.0, 0.5 * range, 0.75 * range, 1.0 * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, 0.0, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_flame_purple");
            if (entity.getPersistentData().m_128459_("cnt1") <= 5.0) {
               ParticleGeneratorCircleProcedure.execute(world, 8.0 * range, 90.0, 0.0 * range, 8.0 * range, 4.0 * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, 0.0, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_thunder_blue");
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
            if (entity.getPersistentData().m_128459_("cnt1") <= 21.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(4.0 * range), 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(4.0 * range), 0.5F, false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == 11.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  LivingEntity var95;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var95 = _mobEnt.m_5448_();
                  } else {
                     var95 = null;
                  }

                  if (var95 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var95 = _mobEnt.m_5448_();
                     } else {
                        var95 = null;
                     }

                     double var97 = ((Entity)var95).m_20185_();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     double var98 = ((Entity)var10001).m_20186_();
                     LivingEntity var10002;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.m_5448_();
                     } else {
                        var10002 = null;
                     }

                     var98 += (double)((Entity)var10002).m_20206_() * 0.5;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.m_5448_();
                     } else {
                        var10002 = null;
                     }

                     RotateEntityProcedure.execute(var97, var98, ((Entity)var10002).m_20189_(), entity);
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0 * CNT6);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0 * CNT6);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0 * CNT6);
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity80 = (LivingEntity)entity;
                     if (_livingEntity80.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity80.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(1706.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * 2.0;
               y_power = entity.getPersistentData().m_128459_("y_power") * 2.0;
               z_power = entity.getPersistentData().m_128459_("z_power") * 2.0;
               if (entity.getPersistentData().m_128459_("cnt1") == 11.0) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * 1.0);
               entity.getPersistentData().m_128347_("y_knockback", entity.getPersistentData().m_128459_("y_power") * 1.0);
               entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * 1.0);

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  for(int index1 = 0; index1 < (int)(6.0 * range); ++index1) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, entity.getPersistentData().m_128459_("pitch"), 0.0 * range, Mth.m_216263_(RandomSource.m_216327_(), 0.0, 2.0) * range, 8.0, entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * range, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.getPersistentData().m_128459_("y_power") * range, entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.getPersistentData().m_128459_("yaw"), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * range, entity.m_20189_(), "jujutsucraft:particle_flame_purple");
                  }

                  if (!logic_a) {
                     entity.getPersistentData().m_128347_("Damage", (25.0 + entity.getPersistentData().m_128459_("cnt1") * 0.01) * CNT6);
                     entity.getPersistentData().m_128347_("Range", 10.0 * range);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128347_("effect", 5.0);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos, entity);
                     entity.getPersistentData().m_128347_("Range", 10.0 * range);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     KnockbackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos, entity);
                  }

                  if (logic_a) {
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().m_128347_("x_knockback", 0.0);
               entity.getPersistentData().m_128347_("y_knockback", 0.0);
               entity.getPersistentData().m_128347_("z_knockback", 0.0);
               entity.getPersistentData().m_128379_("attack", true);
               if (logic_a) {
                  if (Math.round(distance) >= 1L) {
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();

                     for(int index2 = 0; index2 < (int)Math.round(distance); ++index2) {
                        logic_a = true;
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           x_pos += x_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           y_pos += y_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           z_pos += z_power;
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     entity.m_6021_(x_pos, y_pos, z_pos);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  logic_a = true;
               }

               if (logic_a || entity.getPersistentData().m_128459_("cnt1") >= 21.0) {
                  entity.getPersistentData().m_128347_("cnt1", 21.0);
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 5.0);
               }

               ParticleGeneratorCircleProcedure.execute(world, 36.0 * range, entity.getPersistentData().m_128459_("pitch"), 0.0 * range, 2.0 * range, 4.0, entity.m_20185_(), entity.m_20185_() - entity.getPersistentData().m_128459_("x_power") * range, entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20186_() + (double)entity.m_20206_() * 0.5 - entity.getPersistentData().m_128459_("y_power") * range, entity.getPersistentData().m_128459_("yaw"), entity.m_20189_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power") * range, "jujutsucraft:particle_thunder_blue");
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 21.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().m_128459_("cnt1") == 21.0) {
                  old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
                  old_cnt2 = entity.getPersistentData().m_128459_("cnt2");
                  entity.getPersistentData().m_128347_("cnt1", 9.0);
                  entity.getPersistentData().m_128347_("cnt2", 0.0);
                  entity.getPersistentData().m_128347_("x_knockback", entity.getPersistentData().m_128459_("x_power") * 1.0);
                  entity.getPersistentData().m_128347_("y_knockback", entity.getPersistentData().m_128459_("y_power") * 1.0);
                  entity.getPersistentData().m_128347_("z_knockback", entity.getPersistentData().m_128459_("z_power") * 1.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity167 = (LivingEntity)entity;
                     if (_livingEntity167.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity167.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(1.0);
                     }
                  }

                  AttackStrongPunchProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity168 = (LivingEntity)entity;
                     if (_livingEntity168.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity168.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(0.0);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt1", old_cnt1);
                  entity.getPersistentData().m_128347_("cnt2", old_cnt2);
                  entity.getPersistentData().m_128347_("x_knockback", 0.0);
                  entity.getPersistentData().m_128347_("y_knockback", 0.0);
                  entity.getPersistentData().m_128347_("z_knockback", 0.0);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 35.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
