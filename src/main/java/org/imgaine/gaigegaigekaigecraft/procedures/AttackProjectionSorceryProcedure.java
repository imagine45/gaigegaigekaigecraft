package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.FrameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AttackProjectionSorceryProcedure {
   public AttackProjectionSorceryProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean berserker = false;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_skill = 0.0;
         double dis = 0.0;
         double speed = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix = 0.0;
         double rnd = 0.0;
         double y_fix_height = 0.0;
         double old_mode = 0.0;
         double cnt8 = 0.0;
         double cnt9 = 0.0;
         double dis2 = 0.0;
         double distance = 0.0;
         entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 5, 0, false, false));
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

         targeting = var10000 instanceof LivingEntity;
         if (entity.getPersistentData().m_128459_("cnt7") <= 10.0) {
            if (!targeting) {
               if (!(entity instanceof Player)) {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            } else {
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

               y_pos = ((Entity)var10000).m_20186_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               z_pos = ((Entity)var10000).m_20189_();
               dis = 0.0;

               for(int index0 = 0; index0 < 255 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - dis, z_pos)).m_60815_(); ++index0) {
                  if (y_pos - dis < 0.0) {
                     dis = 255.0;
                     break;
                  }

                  ++dis;
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(9.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator) {
                     if (entityiterator.getPersistentData().m_128459_("Damage") > 0.0 && entityiterator.m_6084_() && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        danger = true;
                        break;
                     }

                     double var146;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var146 = _projEnt.m_20184_().m_82553_();
                     } else {
                        var146 = 0.0;
                     }

                     if (var146 > 0.0) {
                        danger = true;
                        break;
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt7") <= 0.0 && OnGroundProcedure.execute(world, entity)) {
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

                  double var149 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var149 + (double)((Entity)var10001).m_20206_() * 0.75;
                  LivingEntity var150;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var150 = _mobEnt.m_5448_();
                  } else {
                     var150 = null;
                  }

                  z_pos = ((Entity)var150).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  dis2 = GetDistanceProcedure.execute(entity);
                  berserker = false;
                  if (entity.getPersistentData().m_128459_("cnt7") >= 0.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var150 = _mobEnt.m_5448_();
                     } else {
                        var150 = null;
                     }

                     label551: {
                        if (((Entity)var150).getPersistentData().m_128459_("skill") != 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var150 = _mobEnt.m_5448_();
                           } else {
                              var150 = null;
                           }

                           if (((Entity)var150).getPersistentData().m_128459_("skill") == 0.0) {
                              break label551;
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var150 = _mobEnt.m_5448_();
                           } else {
                              var150 = null;
                           }

                           if (((Entity)var150).getPersistentData().m_128459_("Damage") != 0.0) {
                              break label551;
                           }
                        }

                        berserker = true;
                     }

                     label542: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var154 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label542;
                           }
                        }

                        var154 = 0;
                     }

                     double var155 = (double)var154 * 0.75;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     label536: {
                        LivingEntity _mobEnt = var10001;
                        if (_mobEnt instanceof LivingEntity) {
                           LivingEntity _livEnt = _mobEnt;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var170 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label536;
                           }
                        }

                        var170 = 0;
                     }

                     if (var155 > (double)var170) {
                        berserker = true;
                     }
                  }

                  if ((berserker || dis2 > 32.0) && !danger) {
                     entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 90.0 * (Math.min(dis2, 32.0) / 32.0)));
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

                     entity.getPersistentData().m_128347_("cnt7", (double)(dis > 2.0 && dis < 16.0 ? 2 : 1));
                  } else {
                     label651: {
                        if (!(entity.getPersistentData().m_128459_("cnt7") < 0.0)) {
                           label623: {
                              label523: {
                                 if (!(entity.getPersistentData().m_128459_("cnt8") < 10.0)) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var150 = _mobEnt.m_5448_();
                                    } else {
                                       var150 = null;
                                    }

                                    if (((Entity)var150).getPersistentData().m_128459_("skill") == 0.0) {
                                       break label523;
                                    }

                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var150 = _mobEnt.m_5448_();
                                    } else {
                                       var150 = null;
                                    }

                                    if (!(((Entity)var150).getPersistentData().m_128459_("Damage") > 0.0)) {
                                       break label523;
                                    }
                                 }

                                 if (dis2 < 6.0) {
                                    break label623;
                                 }
                              }

                              if (!(entity.getPersistentData().m_128459_("cnt8") < 5.0) || !(dis2 < 3.0)) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var150 = _mobEnt.m_5448_();
                                 } else {
                                    var150 = null;
                                 }

                                 label487: {
                                    if (((Entity)var150).getPersistentData().m_128459_("skill") != 0.0) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var150 = _mobEnt.m_5448_();
                                       } else {
                                          var150 = null;
                                       }

                                       if (((Entity)var150).getPersistentData().m_128459_("Damage") > 0.0) {
                                          if (entity instanceof Mob) {
                                             Mob _mobEnt = (Mob)entity;
                                             var150 = _mobEnt.m_5448_();
                                          } else {
                                             var150 = null;
                                          }

                                          if (!((Entity)var150).getPersistentData().m_128471_("attack")) {
                                             break label487;
                                          }
                                       }
                                    }

                                    if (!(entity.getPersistentData().m_128459_("cnt8") < 10.0)) {
                                       entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 90.0 * (Math.min(dis2, 32.0) / 32.0)));
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

                                       entity.getPersistentData().m_128347_("cnt7", (double)(dis > 2.0 && dis < 16.0 ? 2 : 1));
                                       break label651;
                                    }
                                 }

                                 entity.m_146922_((float)(yaw + (double)(Math.random() < 0.5 ? 90 : -90) + (Math.random() - 0.5) * 90.0));
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

                                 entity.getPersistentData().m_128347_("cnt7", 1.0);
                                 break label651;
                              }
                           }
                        }

                        logic_a = false;

                        for(int index1 = 0; index1 < 64; ++index1) {
                           entity.m_146922_((float)(yaw + 180.0 + (Math.random() - 0.5) * 270.0));
                           entity.m_146926_(-45.0F);
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                              entity.m_146922_(entity.m_146908_());
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

                              logic_a = true;
                              break;
                           }
                        }

                        if (!logic_a) {
                           entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 90.0 * (Math.min(dis2, 32.0) / 32.0)));
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

                           entity.getPersistentData().m_128347_("cnt7", (double)(dis > 2.0 && dis < 16.0 ? 2 : 1));
                        } else {
                           entity.getPersistentData().m_128347_("cnt7", 1.0);
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_(MobEffects.f_19597_);
            }

            entity.f_19789_ = 0.0F;
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
            GetPowerFixProcedure.execute(entity);
            if (targeting && entity.getPersistentData().m_128459_("cnt7") == 2.0 && dis > 2.0 && dis < 16.0 && entity.m_20184_().m_7098_() >= -0.05) {
               entity.getPersistentData().m_128379_("canFly", true);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var162 = ((Entity)var10000).m_20185_();
               LivingEntity var171;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var171 = _mobEnt.m_5448_();
               } else {
                  var171 = null;
               }

               double var172 = ((Entity)var171).m_20186_();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               var172 += (double)(((Entity)var10002).m_20206_() * 1.0F);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               GetPowerForwardProcedure.execute(var162, var172, ((Entity)var10002).m_20189_(), entity);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 1.0, entity.getPersistentData().m_128459_("y_power") * 1.0, entity.getPersistentData().m_128459_("z_power") * 1.0));
            } else if (entity.getPersistentData().m_128459_("cnt8") > 100.0) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().m_128347_("skill", 0.0);
            } else if (OnGroundProcedure.execute(world, entity)) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 2, 0.1, 0.1, 0.1, 0.5);
               }

               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 1.0, entity.getPersistentData().m_128459_("y_power") * 1.0, entity.getPersistentData().m_128459_("z_power") * 1.0));
               entity.getPersistentData().m_128347_("cnt7", 0.0);
            }

            speed = Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7098_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0));
            speed *= 2.0;
            if (speed != 0.0) {
               vx = entity.m_20184_().m_7096_() / speed;
               vy = entity.m_20184_().m_7098_() / speed;
               vz = entity.m_20184_().m_7094_() / speed;

               for(int index2 = 0; index2 < (int)Math.round(Math.max(speed, 1.0)); ++index2) {
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 3.0) {
                     rotate = true;
                     if (GetDistanceProcedure.execute(entity) < 3.0) {
                        stop = true;
                        if (entity.getPersistentData().m_128459_("cnt_special") > 0.0) {
                           entity.getPersistentData().m_128347_("cnt_special", -60.0);
                           EntityUseProjectionSorceryProcedure.execute(entity);
                        }
                     }

                     if (targeting && entity.getPersistentData().m_128459_("cnt7") == 2.0) {
                        double var163 = entity.m_20186_();
                        LivingEntity var174;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var174 = _mobEnt.m_5448_();
                        } else {
                           var174 = null;
                        }

                        if (var163 <= ((Entity)var174).m_20186_() + 1.0) {
                           stop = false;
                           rotate = false;
                        }
                     }

                     if (rotate) {
                        break;
                     }
                  }

                  if (speed == 0.0) {
                     break;
                  }

                  logic_a = true;
                  y_fix_height = 0.0;

                  for(int index3 = 0; index3 < (int)Math.ceil((double)(entity.m_20206_() + 0.0F)); ++index3) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix_height, z_pos)).m_60815_()) {
                        logic_a = false;
                        break;
                     }

                     ++y_fix_height;
                  }

                  if (logic_a) {
                     x_pos += vx;
                     y_pos += vy;
                     z_pos += vz;
                  } else {
                     logic_a = false;
                     y_fix = 0.0;

                     for(int index4 = 0; index4 < (int)Math.round(Math.max(speed * 2.0, 1.0)); ++index4) {
                        if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix, z_pos + vz)).m_60815_()) {
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, Math.max(y_pos + vy, y_pos) + y_fix, z_pos)).m_60815_()) {
                              logic_a = false;
                              break;
                           }

                           y_fix += 0.5;
                        } else {
                           logic_a = true;
                           y_fix_height = 0.0;

                           for(int index5 = 0; index5 < (int)Math.ceil((double)entity.m_20206_()); ++index5) {
                              if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_()) {
                                 logic_a = false;
                                 break;
                              }

                              ++y_fix_height;
                           }

                           if (logic_a) {
                              break;
                           }

                           ++y_fix;
                        }
                     }

                     if (!logic_a) {
                        entity.getPersistentData().m_128347_("cnt7", -1.0);
                        break;
                     }

                     x_pos += vx;
                     y_pos = y_pos + vy + y_fix;
                     z_pos += vz;
                  }

                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }
               }
            }

            if (rotate) {
               entity.getPersistentData().m_128347_("cnt1", 10.0);
               if (world.m_6443_(FrameEntity.class, AABB.m_165882_(new Vec3(x, y, z), 6.0, 6.0, 6.0), (e) -> true).isEmpty() && (!stop || !(entity.getPersistentData().m_128459_("cnt9") > 4.0) && entity.getPersistentData().m_128459_("cnt7") != 2.0)) {
                  entity.getPersistentData().m_128347_("cnt7", (double)(!stop ? 11L : Math.round(10.0 + Math.ceil(Math.random() * 2.0))));
               } else {
                  entity.getPersistentData().m_128347_("cnt7", 12.0);
               }

               if (stop) {
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") > 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19598_, 2, 2, false, false));
               }
            }

            old_skill = entity.getPersistentData().m_128459_("skill");
            old_mode = entity.getPersistentData().m_128459_("mode");
            cnt8 = entity.getPersistentData().m_128459_("cnt8");
            cnt9 = entity.getPersistentData().m_128459_("cnt9");
            if (targeting) {
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

               double var166 = ((Entity)var10000).m_20186_();
               LivingEntity var175;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var175 = _mobEnt.m_5448_();
               } else {
                  var175 = null;
               }

               y_pos = var166 + (double)((Entity)var175).m_20206_() * 0.75;
               LivingEntity var167;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var167 = _mobEnt.m_5448_();
               } else {
                  var167 = null;
               }

               z_pos = ((Entity)var167).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            label372: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     var168 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                     break label372;
                  }
               }

               var168 = 0.0;
            }

            distance = var168;
            if (entity.getPersistentData().m_128459_("cnt7") == 11.0) {
               AttackContinueProcedure.execute(world, entity);
            } else if (entity.getPersistentData().m_128459_("cnt7") == 12.0) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            } else {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
            }

            if (distance > 0.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)distance, 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().m_128347_("skill", old_skill);
               entity.getPersistentData().m_128347_("mode", old_mode);
               entity.getPersistentData().m_128347_("cnt8", cnt8);
               entity.getPersistentData().m_128347_("cnt9", cnt9);
               if (entity.getPersistentData().m_128459_("cnt9") > 4.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }

               entity.getPersistentData().m_128347_("cnt8", Math.min(entity.getPersistentData().m_128459_("cnt8"), 20.0));
               entity.getPersistentData().m_128347_("cnt9", entity.getPersistentData().m_128459_("cnt9") + 1.0);
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
