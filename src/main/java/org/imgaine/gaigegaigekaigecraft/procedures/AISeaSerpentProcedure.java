package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.BathynomusGiganteusEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentMiniEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AISeaSerpentProcedure {
   public AISeaSerpentProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double CNT6 = 0.0;
         double entity_size = 0.0;
         double strength = 0.0;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean logic_c = false;
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.m_6084_()) {
            if ((!(entity.getPersistentData().m_128459_("movement") > 0.0) || !(entity instanceof SeaSerpentEntity)) && (entity.getPersistentData().m_128459_("movement") != 0.0 || entity.getPersistentData().m_128459_("cnt2") != 0.0)) {
               yaw = (double)(entity.m_146908_() % 360.0F);
               pitch = (double)entity.m_146909_();
               RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * 555.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * 555.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * 555.0, entity);
               entity.m_146922_(entity.m_146908_() % 360.0F);
               entity.m_146926_(entity.m_146909_());
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               yaw_cal = (double)entity.m_146908_() - yaw;
               yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0)) ? 8 : -8);
               pitch_cal = Math.abs((double)entity.m_146909_() - pitch);
               pitch += pitch_cal / (double)(pitch > (double)entity.m_146909_() ? -8 : 8);
               entity.m_146922_((float)yaw);
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
            }

            BulletDomainHit2Procedure.execute(world, entity);
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("movement") == 1.0) {
               AISeaSerpent2Procedure.execute(world, x, y, z, entity);
            } else {
               x_power = entity.getPersistentData().m_128459_("x_power");
               y_power = entity.getPersistentData().m_128459_("y_power");
               z_power = entity.getPersistentData().m_128459_("z_power");
               if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
                  logic_a = false;

                  for(int index0 = 0; index0 < 2; ++index0) {
                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") >= 8.0 && (!entity.m_5830_() || entity.getPersistentData().m_128459_("cnt1") >= 16.0)) {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, (float)CNT6);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, (float)CNT6, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, (float)CNT6);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, (float)CNT6, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)((double)(20.0F * entity.m_20205_()) * CNT6), 1.0, 1.0, 1.0, 2.0);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), x_pos, y_pos, z_pos, (int)((double)(20.0F * entity.m_20205_()) * CNT6), 1.0, 1.0, 1.0, 1.0);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)(5.0F * entity.m_20205_()) * CNT6), 0.5, 0.5, 0.5, 0.5);
                        }

                        entity.getPersistentData().m_128347_("cnt1", 0.0);
                        if (entity instanceof BathynomusGiganteusEntity) {
                           entity.getPersistentData().m_128347_("cnt2", 2.0);
                        } else {
                           entity.getPersistentData().m_128347_("cnt2", (double)(Math.random() < 0.3 ? 2 : 1));
                        }
                        break;
                     }
                  }
               } else {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
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

                     double var128 = ((Entity)var10000).m_20186_();
                     LivingEntity var132;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var132 = _mobEnt.m_5448_();
                     } else {
                        var132 = null;
                     }

                     y_pos = var128 + (double)((Entity)var132).m_20206_() * 0.5;
                     LivingEntity var129;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var129 = _mobEnt.m_5448_();
                     } else {
                        var129 = null;
                     }

                     z_pos = ((Entity)var129).m_20189_();
                  } else if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity) {
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           Level var121 = ((Entity)var10000).m_9236_();
                           ClipContext var10001 = new ClipContext;
                           LivingEntity var10003;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10003 = _mobEnt.m_5448_();
                           } else {
                              var10003 = null;
                           }

                           Vec3 var133 = ((Entity)var10003).m_20299_(1.0F);
                           LivingEntity var10004;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10004 = _mobEnt.m_5448_();
                           } else {
                              var10004 = null;
                           }

                           Vec3 var138 = ((Entity)var10004).m_20299_(1.0F);
                           LivingEntity var10005;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10005 = _mobEnt.m_5448_();
                           } else {
                              var10005 = null;
                           }

                           var138 = var138.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var146 = Block.OUTLINE;
                           ClipContext.Fluid var10006 = Fluid.NONE;
                           LivingEntity var10007;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var10001.<init>(var133, var138, var146, var10006, var10007);
                           x_pos = (double)var121.m_45547_(var10001).m_82425_().m_123341_();
                           LivingEntity var122;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var122 = _mobEnt.m_5448_();
                           } else {
                              var122 = null;
                           }

                           Level var123 = ((Entity)var122).m_9236_();
                           var10001 = new ClipContext;
                           LivingEntity var134;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var134 = _mobEnt.m_5448_();
                           } else {
                              var134 = null;
                           }

                           Vec3 var135 = ((Entity)var134).m_20299_(1.0F);
                           LivingEntity var140;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var140 = _mobEnt.m_5448_();
                           } else {
                              var140 = null;
                           }

                           Vec3 var141 = ((Entity)var140).m_20299_(1.0F);
                           LivingEntity var147;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var147 = _mobEnt.m_5448_();
                           } else {
                              var147 = null;
                           }

                           var141 = var141.m_82549_(((Entity)var147).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var148 = Block.OUTLINE;
                           var10006 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var10001.<init>(var135, var141, var148, var10006, var10007);
                           y_pos = (double)var123.m_45547_(var10001).m_82425_().m_123342_();
                           LivingEntity var124;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var124 = _mobEnt.m_5448_();
                           } else {
                              var124 = null;
                           }

                           Level var125 = ((Entity)var124).m_9236_();
                           var10001 = new ClipContext;
                           LivingEntity var136;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var136 = _mobEnt.m_5448_();
                           } else {
                              var136 = null;
                           }

                           Vec3 var137 = ((Entity)var136).m_20299_(1.0F);
                           LivingEntity var143;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var143 = _mobEnt.m_5448_();
                           } else {
                              var143 = null;
                           }

                           Vec3 var144 = ((Entity)var143).m_20299_(1.0F);
                           LivingEntity var149;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var149 = _mobEnt.m_5448_();
                           } else {
                              var149 = null;
                           }

                           var144 = var144.m_82549_(((Entity)var149).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var150 = Block.OUTLINE;
                           var10006 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var10001.<init>(var137, var144, var150, var10006, var10007);
                           z_pos = (double)var125.m_45547_(var10001).m_82425_().m_123343_();
                        } else {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                           dis = 8.0;
                           logic_a = false;

                           for(int index1 = 0; index1 < 8; ++index1) {
                              Vec3 _center = new Vec3((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());

                              for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(8.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                                 if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                    logic_a = true;
                                    x_pos = entityiterator.m_20185_();
                                    y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                                    z_pos = entityiterator.m_20189_();
                                    break;
                                 }
                              }

                              dis += 8.0;
                              if (logic_a) {
                                 break;
                              }
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") == 2.0) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(12.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           x_pos = entityiterator.m_20185_();
                           y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                           z_pos = entityiterator.m_20189_();
                           break;
                        }
                     }
                  }

                  entity.getPersistentData().m_128379_("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                  if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * 0.2) {
                     x_power = entity.m_20184_().m_7096_() - 0.075;
                  } else {
                     x_power = entity.m_20184_().m_7096_() + 0.075;
                  }

                  if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * 0.2) {
                     y_power = entity.m_20184_().m_7098_() - 0.075;
                  } else {
                     y_power = entity.m_20184_().m_7098_() + 0.075;
                  }

                  if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * 0.2) {
                     z_power = entity.m_20184_().m_7094_() - 0.075;
                  } else {
                     z_power = entity.m_20184_().m_7094_() + 0.075;
                  }

                  if (entity.getPersistentData().m_128459_("skill") > -999.0) {
                     entity.m_20256_(new Vec3(x_power, y_power, z_power));
                     dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                     if (dis > 1.0) {
                        x_power /= dis;
                        y_power /= dis;
                        z_power /= dis;
                     }

                     entity.getPersistentData().m_128347_("cnt_attack", entity.getPersistentData().m_128459_("cnt_attack") + 1.0);

                     for(int index2 = 0; index2 < (int)Math.max(dis, 1.0); ++index2) {
                        logic_c = false;
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                        if (entity.getPersistentData().m_128459_("cnt_attack") > 0.0) {
                           entity.getPersistentData().m_128347_("Damage", 9.0 * CNT6);
                           entity.getPersistentData().m_128347_("knockback", 0.25);
                           entity.getPersistentData().m_128347_("Range", 0.5 + (double)entity.m_20205_());
                           entity.getPersistentData().m_128347_("effect", 1.0);
                           entity.getPersistentData().m_128379_("swing", true);
                           RangeAttackProcedure.execute(world, entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * 0.25, entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * 0.25, entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * 0.25, entity);
                           if (entity.getPersistentData().m_128459_("cnt_attack") < 0.0) {
                              logic_c = true;
                           }
                        }

                        if (entity.getPersistentData().m_128471_("Stop")) {
                           entity.getPersistentData().m_128379_("Stop", false);
                           logic_a = false;
                           break;
                        }

                        logic_b = false;
                        if (!entity.m_5830_()) {
                           entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                           }

                           if (entity.m_5830_()) {
                              entity.m_6021_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_());
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                 _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                              }

                              logic_b = true;
                           }

                           entity.m_6021_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                           }

                           if (entity.m_5830_()) {
                              entity.m_6021_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_());
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                 _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                              }

                              logic_b = true;
                           }

                           entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                           }

                           if (entity.m_5830_()) {
                              entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power);
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                 _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power, entity.m_146908_(), entity.m_146909_());
                              }

                              logic_b = true;
                           }
                        }

                        if ((entity.m_5830_() || logic_b) && (entity.getPersistentData().m_128459_("cnt1") % 20.0 == 10.0 || logic_c)) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                           }

                           entity.getPersistentData().m_128347_("BlockRange", (double)(1.0F * entity.m_20205_()));
                           entity.getPersistentData().m_128347_("BlockDamage", Math.max((double)entity.m_20205_() * 0.5 * CNT6, 0.5));
                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= 200.0 && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            entity.getPersistentData().m_128347_("cnt3", 1.0);
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(2.0F * (entity.m_20206_() + entity.m_20205_())), (double)entity.m_20205_() * 0.1, (double)entity.m_20206_() * 0.1, (double)entity.m_20205_() * 0.1, 1.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()));
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()), false);
               }
            }

            if (!(entity instanceof SeaSerpentMiniEntity)) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            }
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * 0.25);
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * 0.25);
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * 0.25);
      }
   }
}
