package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiBugEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackTackleProcedure {
   public AttackTackleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         boolean rotate = false;
         boolean avoidance = false;
         boolean logic_b = false;
         boolean water = false;
         boolean stopHighSpeed = false;
         boolean move_avoid = false;
         boolean move_attack = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double old_skill = 0.0;
         double speed = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_mode = 0.0;
         double y_fix_height = 0.0;
         double num1 = 0.0;
         double cnt8 = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double bbHeight = 0.0;
         double bbWidth = 0.0;
         entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + 1.0);
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         entity.f_19789_ = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19598_, 5, 2, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         targeting = target_entity instanceof LivingEntity;
         bbHeight = (double)entity.m_20206_();
         bbWidth = (double)entity.m_20205_();
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
            entity.getPersistentData().m_128347_("Damage", 8.0);
            entity.getPersistentData().m_128347_("Range", 5.0 * range);
            entity.getPersistentData().m_128347_("knockback", 0.2);
            entity.getPersistentData().m_128347_("effect", 5.0);
            entity.getPersistentData().m_128347_("projectile_type", 1.0);
            entity.getPersistentData().m_128379_("swing", true);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
            danger = false;
            Vec3 _center = new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(3.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(3.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(3.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(3.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator) {
                  if (entityiterator.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().m_128459_("Damage") > entity.getPersistentData().m_128459_("Damage") && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     danger = true;
                     break;
                  }

                  double var153;
                  if (entityiterator instanceof Projectile) {
                     Projectile _projEnt = (Projectile)entityiterator;
                     var153 = _projEnt.m_20184_().m_82553_();
                  } else {
                     var153 = 0.0;
                  }

                  if (var153 > 0.0) {
                     danger = true;
                     break;
                  }
               }
            }

            if (!danger) {
               _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(16.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator) {
                     if (entityiterator.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().m_128459_("Damage") > entity.getPersistentData().m_128459_("Damage") * 0.75 && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        avoidance = true;
                        break;
                     }

                     double var154;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var154 = _projEnt.m_20184_().m_82553_();
                     } else {
                        var154 = 0.0;
                     }

                     if (var154 > 0.0) {
                        avoidance = true;
                        break;
                     }
                  }
               }
            }

            if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 3.0) {
               danger = true;
               if (GetDistanceProcedure.execute(entity) < 3.0) {
                  rotate = true;
                  stop = true;
               }
            }

            if (entity instanceof Player && entity.m_6144_()) {
               rotate = true;
               stop = true;
            }

            label585: {
               label539: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt42 = (LivingEntity)entity;
                     if (_livEnt42.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        break label539;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label585;
                  }

                  LivingEntity _livEnt43 = (LivingEntity)entity;
                  if (!_livEnt43.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     break label585;
                  }
               }

               water = !entity.m_20069_() && world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() - 0.1, entity.m_20189_())).m_60734_() == Blocks.f_49990_;
            }

            if (OnGroundProcedure.execute(world, entity) || water) {
               if (targeting) {
                  label470: {
                     x_pos = target_entity.m_20185_();
                     y_pos = target_entity.m_20186_() + (double)target_entity.m_20206_() * 0.75;
                     z_pos = target_entity.m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     yaw = (double)entity.m_146908_();
                     pitch = (double)entity.m_146909_();
                     num1 = GetDistanceProcedure.execute(entity);
                     if (!(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof FushiguroTojiBugEntity)) {
                        label466: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var155 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label466;
                              }
                           }

                           var155 = 0;
                        }

                        int var10001;
                        label461: {
                           var156 = (double)var155 * 0.5;
                           if (target_entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)target_entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label461;
                              }
                           }

                           var10001 = 0;
                        }

                        if (!(var156 >= (double)var10001) && !(range > 1.5)) {
                           if (entity.getPersistentData().m_128459_("cnt8") > 30.0) {
                              move_attack = true;
                           }

                           if (target_entity.getPersistentData().m_128459_("skill") == 0.0) {
                              label544: {
                                 label451: {
                                    if (target_entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)target_entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                          var157 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                          break label451;
                                       }
                                    }

                                    var157 = 0;
                                 }

                                 if (var157 <= 10) {
                                    label444: {
                                       if (target_entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)target_entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                             var158 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                             break label444;
                                          }
                                       }

                                       var158 = 0;
                                    }

                                    if (var158 <= 10) {
                                       break label544;
                                    }
                                 }

                                 move_attack = true;
                              }
                           }

                           if (!(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) && target_entity.getPersistentData().m_128459_("skill") != 0.0 && entity.getPersistentData().m_128459_("cnt8") < 30.0) {
                              move_attack = false;
                           }
                           break label470;
                        }
                     }

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
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0 * range);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0 * range);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0 * range);
               GetPowerFixProcedure.execute(entity);
               speed = Math.sqrt(entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("x_power") + entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("y_power") + entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("z_power"));
               speed *= 2.0;
               if (targeting) {
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
                           danger = true;
                           rotate = true;
                           stop = true;
                           break;
                        }
                     }
                  }
               }

               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), 0.0) + 0.05);
               }

               if (water) {
                  entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), 0.0) + 0.05);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 2.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x, y, z, (int)(2.0 * range), 0.1 * range, 0.1, 0.1 * range, 0.25);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)(2.0 * range), 0.1 * range, 0.1, 0.1 * range, 0.25);
               }

               vx = entity.getPersistentData().m_128459_("x_power");
               vy = entity.getPersistentData().m_128459_("y_power");
               vz = entity.getPersistentData().m_128459_("z_power");
               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, vx, vy, vz);
               entity.m_20256_(new Vec3(vx, Math.min(vy, 1.5 * range), vz));
               entity.f_19789_ = 0.0F;
            }

            if (!(entity.getPersistentData().m_128459_("cnt8") > 120.0) && (entity instanceof Player || targeting)) {
               if (rotate) {
                  entity.getPersistentData().m_128347_("cnt1", 10.0);
                  if (!(entity.getPersistentData().m_128459_("cnt8") <= 60.0)) {
                     entity.getPersistentData().m_128347_("cnt7", 3.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt7", !(entity instanceof FushiguroTojiEntity) && !(entity instanceof FushiguroTojiBugEntity) ? Math.ceil(3.0 * Math.random()) : (double)(1L + Math.round(Math.random())));
                  }

                  if (stop) {
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  }
               } else if (danger) {
                  entity.getPersistentData().m_128347_("cnt1", 10.0);
                  entity.getPersistentData().m_128347_("cnt7", 2.0);
               }
            } else {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         } else {
            old_skill = entity.getPersistentData().m_128459_("skill");
            cnt8 = entity.getPersistentData().m_128459_("cnt8");
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var162 = ((Entity)var10000).m_20186_();
               LivingEntity var164;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var164 = _mobEnt.m_5448_();
               } else {
                  var164 = null;
               }

               y_pos = var162 + (double)((Entity)var164).m_20206_() * 0.75;
               LivingEntity var163;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var163 = _mobEnt.m_5448_();
               } else {
                  var163 = null;
               }

               z_pos = ((Entity)var163).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt7") == 1.0) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("cnt7") == 2.0) {
               AttackContinueProcedure.execute(world, entity);
            } else if (entity.getPersistentData().m_128459_("cnt7") == 3.0) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().m_128347_("skill", old_skill);
               entity.getPersistentData().m_128347_("cnt8", cnt8);
               if (entity.getPersistentData().m_128459_("cnt8") >= 60.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
