package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi1Procedure {
   public TechniqueOgi1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         double dis = 0.0;
         double rad = 0.0;
         double tsuki7_mode = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos2 = 0.0;
         double y_pos2 = 0.0;
         double z_pos2 = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double x_center = 0.0;
         double y_center = 0.0;
         double z_center = 0.0;
         double CNT6 = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 8, 4, false, false));
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
                     label243: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           label234: {
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
                                    break label234;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                 break label243;
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

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.5);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, x_pos, entity.m_20186_(), z_pos, 5, 0.25, 0.1, 0.25, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, entity.m_20186_(), z_pos, 2, 0.25, 0.1, 0.25, 0.5);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x_pos, entity.m_20186_(), z_pos, 5, 0.25, 0.25, 0.25, CNT6 * 0.1);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 10.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19597_);
               }

               if (OnGroundProcedure.execute(world, entity)) {
                  entity.getPersistentData().m_128347_("cnt1", 0.0);
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
                  LivingEntity var91;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.m_5448_();
                  } else {
                     var91 = null;
                  }

                  if (var91 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var91 = _mobEnt.m_5448_();
                     } else {
                        var91 = null;
                     }

                     x_pos = ((Entity)var91).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var91 = _mobEnt.m_5448_();
                     } else {
                        var91 = null;
                     }

                     double var94 = ((Entity)var91).m_20186_();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var94 + (double)((Entity)var10001).m_20206_() * 0.5;
                     LivingEntity var95;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var95 = _mobEnt.m_5448_();
                     } else {
                        var95 = null;
                     }

                     z_pos = ((Entity)var95).m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
                  GetPowerFixProcedure.execute(entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)(CNT6 * 10.0), 0.1, 0.1, 0.1, CNT6 * 0.25);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= 2.5) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, x, y, z, (int)(CNT6 * 10.0), 0.1, 0.1, 0.1, CNT6 * 0.25);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)(CNT6 * 10.0), 0.1, 0.1, 0.1, CNT6 * 0.25);
                     }
                  }

                  entity.getPersistentData().m_128347_("x_pos", x);
                  entity.getPersistentData().m_128347_("y_pos", y + 0.1);
                  entity.getPersistentData().m_128347_("z_pos", z);
                  entity.getPersistentData().m_128347_("old_x", x);
                  entity.getPersistentData().m_128347_("old_y", y + (double)entity.m_20206_() * 0.5);
                  entity.getPersistentData().m_128347_("old_z", z);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity80 = (LivingEntity)entity;
                     if (_livingEntity80.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity80.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-5.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               } else if (entity.getPersistentData().m_128459_("cnt1") >= 120.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") >= 6.0) {
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 10.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") <= 4.0) {
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 1.2 * CNT6, entity.getPersistentData().m_128459_("y_power") * 1.2 * CNT6, entity.getPersistentData().m_128459_("z_power") * 1.2 * CNT6));
            }

            rad_now = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            x_pos = x - entity.getPersistentData().m_128459_("old_x");
            y_pos = y + (double)entity.m_20206_() * 0.5 - entity.getPersistentData().m_128459_("old_y");
            z_pos = z - entity.getPersistentData().m_128459_("old_z");
            dis = Math.sqrt(Math.pow(x_pos, 2.0) + Math.pow(y_pos, 2.0) + Math.pow(z_pos, 2.0));
            if (dis != 0.0) {
               entity.getPersistentData().m_128347_("x_pos", x_pos / (dis * 5.0));
               entity.getPersistentData().m_128347_("y_pos", y_pos / (dis * 5.0));
               entity.getPersistentData().m_128347_("z_pos", z_pos / (dis * 5.0));
            }

            x_pos = x;
            y_pos = y + (double)entity.m_20206_() * 0.5;
            z_pos = z;

            for(int index0 = 0; index0 < (int)Math.max(Math.round(dis * 5.0), 1L); ++index0) {
               entity.getPersistentData().m_128347_("Damage", 15.0 * CNT6);
               entity.getPersistentData().m_128347_("Range", 3.0);
               entity.getPersistentData().m_128347_("knockback", 0.6);
               entity.getPersistentData().m_128347_("effect", 5.0);
               entity.getPersistentData().m_128347_("projectile_type", 1.0);
               entity.getPersistentData().m_128379_("swing", true);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               rad = Math.toRadians(entity.getPersistentData().m_128459_("cnt2"));

               for(int index1 = 0; index1 < 2; ++index1) {
                  x_pos2 = x_pos + (Math.cos(rad_now) - Math.sin(rad) * Math.sin(rad_now)) * 1.25;
                  z_pos2 = z_pos + (Math.sin(rad_now) + Math.sin(rad) * Math.cos(rad_now)) * 1.25;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, x_pos2, y_pos, z_pos2, 1, 0.0, 0.0, 0.0, 0.0);
                  }

                  rad += Math.toRadians(180.0);
               }

               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 5.0);
               x_pos += entity.getPersistentData().m_128459_("x_pos");
               y_pos += entity.getPersistentData().m_128459_("y_pos");
               z_pos += entity.getPersistentData().m_128459_("z_pos");
            }

            entity.getPersistentData().m_128347_("old_x", x);
            entity.getPersistentData().m_128347_("old_y", y + (double)entity.m_20206_() * 0.5);
            entity.getPersistentData().m_128347_("old_z", z);
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
