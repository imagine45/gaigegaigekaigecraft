package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiBugEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class HighSpeedOnEffectActiveTickProcedure {
   public HighSpeedOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         Entity target_entity = null;
         boolean stopHighSpeed = false;
         boolean logic_a = false;
         boolean move_avoid = false;
         boolean move_attack = false;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double speed = 0.0;
         double bbHeight = 0.0;
         double num1 = 0.0;
         double y_fix = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double bbWidth = 0.0;
         if (amplifier > 0.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            target_entity = var10000;
            if (target_entity instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                     return;
                  }
               }

               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  _entity.m_21573_().m_26573_();
               }

               bbHeight = (double)entity.m_20206_();
               bbWidth = (double)entity.m_20205_();
               range = ReturnEntitySizeProcedure.execute(entity);
               if (OnGroundProcedure.execute(world, entity)) {
                  x_pos = target_entity.m_20185_();
                  y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * 0.75;
                  z_pos = target_entity.m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  num1 = GetDistanceProcedure.execute(entity);
                  if (!(entity instanceof FushiguroTojiBugEntity) && !(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) && !(range > 1.5)) {
                     if (target_entity.getPersistentData().m_128459_("skill") == 0.0) {
                        label364: {
                           label316: {
                              if (target_entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)target_entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var113 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                    break label316;
                                 }
                              }

                              var113 = 0;
                           }

                           if (var113 <= 10) {
                              label309: {
                                 if (target_entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)target_entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var114 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                       break label309;
                                    }
                                 }

                                 var114 = 0;
                              }

                              if (var114 <= 10) {
                                 break label364;
                              }
                           }

                           move_attack = true;
                        }
                     }

                     if (num1 > 32.0) {
                        move_attack = true;
                     }

                     label300: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var115 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label300;
                           }
                        }

                        var115 = 0;
                     }

                     int var10001;
                     label295: {
                        var116 = (double)var115 * 0.5;
                        if (target_entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)target_entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label295;
                           }
                        }

                        var10001 = 0;
                     }

                     if (var116 >= (double)var10001) {
                        move_attack = true;
                     }

                     if (entity.getPersistentData().m_128459_("cnt_backstep") > 10.0) {
                        move_avoid = true;
                     }
                  } else {
                     move_attack = true;
                  }

                  logic_a = false;
                  if (move_attack) {
                     for(int index0 = 0; index0 < 32; ++index0) {
                        entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 90.0 * (num1 > 32.0 ? (32.0 - (Math.min(num1, 64.0) - 32.0)) / 32.0 : Math.min(num1, 32.0) / 32.0)));
                        entity.m_146926_((float)pitch);
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        for(int index1 = 0; index1 < 4; ++index1) {
                           if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(3.0 * range)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                              logic_a = true;
                              break;
                           }

                           if (entity.m_146909_() >= 90.0F) {
                              break;
                           }

                           entity.m_146922_(entity.m_146908_());
                           entity.m_146926_(Math.max(entity.m_146909_() - 10.0F, 90.0F));
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }
                        }

                        if (logic_a) {
                           break;
                        }
                     }
                  }

                  if (!logic_a || move_avoid) {
                     for(int index2 = 0; index2 < 32; ++index2) {
                        if (num1 < 8.0) {
                           entity.m_146922_((float)(yaw + 180.0 + (Math.random() - 0.5) * 180.0));
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
                        } else {
                           entity.m_146922_((float)(yaw + (double)(entity.getPersistentData().m_128459_("cnt_target") % 100.0 < 50.0 ? 90 : -90) + (Math.random() - 0.5) * 90.0));
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
                        }

                        for(int index3 = 0; index3 < 4; ++index3) {
                           if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(3.0 * range)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                              logic_a = true;
                              break;
                           }

                           if (entity.m_146909_() >= 90.0F) {
                              break;
                           }

                           entity.m_146922_(entity.m_146908_());
                           entity.m_146926_(Math.max(entity.m_146909_() - 10.0F, 90.0F));
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }
                        }

                        if (logic_a) {
                           break;
                        }
                     }
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0 * range);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0 * range);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0 * range);
                  GetPowerFixProcedure.execute(entity);
                  speed = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
                  speed *= 2.0;
                  if (speed > 0.0) {
                     entity.m_6858_(true);
                     vx = entity.getPersistentData().m_128459_("x_power") / (speed * 1.0);
                     vy = entity.getPersistentData().m_128459_("y_power") / (speed * 1.0);
                     vz = entity.getPersistentData().m_128459_("z_power") / (speed * 1.0);
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();
                     num1 = 0.0;

                     for(int index4 = 0; index4 < (int)Math.round(Math.max(speed, 1.0)); ++index4) {
                        ++num1;
                        logic_a = true;
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy, z_pos + vz, bbHeight, bbWidth)) {
                           x_pos += vx;
                           y_pos += vy;
                           z_pos += vz;
                        } else {
                           y_fix = 0.0;
                           logic_a = false;

                           for(int index5 = 0; index5 < (int)Math.round(num1 * 1.0); ++index5) {
                              ++y_fix;
                              if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy + y_fix, z_pos + vz, bbHeight, bbWidth) && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + vy + y_fix, z_pos, bbHeight, bbWidth)) {
                                 logic_a = true;
                                 x_pos += vx;
                                 y_pos = y_pos + vy + y_fix;
                                 z_pos += vz;
                                 break;
                              }
                           }

                           if (!logic_a) {
                              break;
                           }
                        }
                     }

                     if (!logic_a && !(num1 >= speed * 0.5)) {
                        logic_a = true;
                     } else {
                        logic_a = false;
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     }

                     if (logic_a) {
                        entity.m_146922_((float)((double)(entity.m_146908_() + 180.0F) + Mth.m_216263_(RandomSource.m_216327_(), -90.0, 90.0)));
                        entity.m_146926_((float)Math.max((double)(-1.0F * entity.m_146909_()), 22.5));
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }
                     }
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0 * range);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0 * range);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0 * range);
                  GetPowerFixProcedure.execute(entity);
                  speed = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
                  speed *= 2.0;
                  if (speed > 0.0) {
                     vx = entity.getPersistentData().m_128459_("x_power") / (speed * 1.0);
                     vy = entity.getPersistentData().m_128459_("y_power") / (speed * 1.0);
                     vz = entity.getPersistentData().m_128459_("z_power") / (speed * 1.0);

                     for(int index6 = 0; index6 < (int)Math.round(Math.max(speed * 1.0, 1.0)); ++index6) {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                        logic_a = true;
                        y_fix = 0.0;
                        if (InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy, z_pos + vz, bbHeight, bbWidth)) {
                           logic_a = false;

                           for(int index7 = 0; index7 < (int)Math.round(Math.max(speed * 1.0, 1.0)); ++index7) {
                              ++y_fix;
                              if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy + y_fix, z_pos + vz, bbHeight, bbWidth) && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + vy + y_fix, z_pos, bbHeight, bbWidth)) {
                                 logic_a = true;
                                 break;
                              }
                           }
                        }

                        if (!logic_a) {
                           break;
                        }

                        y_pos = y_pos + vy + y_fix;
                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           y_pos -= vy + y_fix;
                           entity.m_6021_(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                           }
                        }

                        z_pos += vz;
                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           z_pos -= vz;
                           entity.m_6021_(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                           }
                        }

                        x_pos += vx;
                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           x_pos -= vx;
                           entity.m_6021_(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                           }
                        }

                        if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 3.0) {
                           stopHighSpeed = true;
                           break;
                        }
                     }
                  }

                  if (entity.m_20096_()) {
                     entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), 0.0) + 0.05);
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)(2.0 * range), 0.1 * range, 0.1, 0.1 * range, 0.25);
                     }
                  }

                  vx = entity.getPersistentData().m_128459_("x_power");
                  vy = entity.getPersistentData().m_128459_("y_power");
                  vz = entity.getPersistentData().m_128459_("z_power");
                  StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, vx, vy, vz);
                  entity.m_20256_(new Vec3(vx, Math.min(vy, 1.5 * range), vz));
                  entity.f_19789_ = 0.0F;
               }

               if (stopHighSpeed) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get());
                  }

                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               }
            }
         }

      }
   }
}
