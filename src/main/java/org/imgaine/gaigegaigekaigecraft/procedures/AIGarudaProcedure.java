package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaBallEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class AIGarudaProcedure {
   public AIGarudaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         boolean ball = false;
         Entity entity_a = null;
         double rnd = 0.0;
         double dis = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double HP = 0.0;
         if (entity.m_6084_()) {
            ball = entity instanceof GarudaBallEntity;
            if (!ball) {
               AIActiveProcedure.execute(world, x, y, z, entity);
            }

            label206: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label206;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)entity.getPersistentData().m_128459_("Strength"), false, false));
                  }
               }
            }

            label201: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                     break label201;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)Math.round(Math.min(entity.getPersistentData().m_128459_("Strength") / 4.0, 3.0)), false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
               if (LogicOwnerExistProcedure.execute(world, entity)) {
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
                  if (!entity_a.m_6084_()) {
                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  } else if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                     label216: {
                        if (!ball) {
                           dis = Math.sqrt(Math.pow(entity_a.m_20185_() - entity.m_20185_(), 2.0) + Math.pow(entity_a.m_20186_() - entity.m_20186_(), 2.0) + Math.pow(entity_a.m_20189_() - entity.m_20189_(), 2.0));
                           if (dis > 8.0) {
                              entity.getPersistentData().m_128379_("canFly", true);
                              GetPowerForwardProcedure.execute((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity);
                              entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.5, entity.getPersistentData().m_128459_("y_power") * 0.5, entity.getPersistentData().m_128459_("z_power") * 0.5));
                              if (dis > 16.0) {
                                 entity.m_6021_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                    _serverPlayer.f_8906_.m_9774_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-2.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity.m_146908_(), entity.m_146909_());
                                 }

                                 entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                                 entity.m_146922_(entity_a.m_146908_());
                                 entity.m_146926_(entity_a.m_146909_());
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
                        }

                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt39 = (LivingEntity)entity_a;
                           if (_livEnt39.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt41 = (LivingEntity)entity;
                                 if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                    int var10000;
                                    label182: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                             var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                                             break label182;
                                          }
                                       }

                                       var10000 = 0;
                                    }

                                    int var10001;
                                    label177: {
                                       if (entity_a instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity_a;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                             var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                                             break label177;
                                          }
                                       }

                                       var10001 = 0;
                                    }

                                    if (var10000 == var10001) {
                                       break label216;
                                    }
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                              }

                              if (!(entity instanceof LivingEntity)) {
                                 break label216;
                              }

                              LivingEntity _entity = (LivingEntity)entity;
                              if (_entity.m_9236_().m_5776_()) {
                                 break label216;
                              }

                              MobEffectInstance var57;
                              MobEffect var10003;
                              int var10005;
                              label171: {
                                 var57 = new MobEffectInstance;
                                 var10003 = (MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get();
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity_a;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                       var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                                       break label171;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var57.<init>(var10003, 200, var10005, false, false);
                              _entity.m_7292_(var57);
                              break label216;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
                        }
                     }
                  } else if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               } else {
                  entity.getPersistentData().m_128347_("despawn_flag", 1.0);
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               if (entity.getPersistentData().m_128459_("despawn_flag") > 0.0 && entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                  entity.getPersistentData().m_128347_("cnt_target", 0.0);
                  entity.getPersistentData().m_128347_("cnt_die", entity.getPersistentData().m_128459_("cnt_die") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_die") > 5.0) {
                     DieRikaProcedure.execute(world, entity);
                     if (entity instanceof GarudaBallEntity) {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                        yaw = (double)entity.m_146908_();
                        rnd = 0.0;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.GARUDA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              entityinstance.m_146922_((float)yaw);
                              entityinstance.m_146926_((float)rnd);
                              entityinstance.m_5618_(entityinstance.m_146908_());
                              entityinstance.m_5616_(entityinstance.m_146908_());
                              entityinstance.f_19859_ = entityinstance.m_146908_();
                              entityinstance.f_19860_ = entityinstance.m_146909_();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.f_20884_ = _entity.m_146908_();
                                 _entity.f_20886_ = _entity.m_146908_();
                              }

                              if (entity_a instanceof LivingEntity) {
                                 entity_a.getPersistentData().m_128359_("GARUDA_UUID", entityinstance.m_20149_());
                              }

                              CompoundTag var56;
                              double var10002;
                              label137: {
                                 entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                                 entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                                 entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                                 var56 = entityinstance.getPersistentData();
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10002 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label137;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              var56.m_128347_("Strength", var10002);
                              entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                              entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                              entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                              entityinstance.getPersistentData().m_128379_("Shikigami", true);
                              _serverLevel.m_7967_(entityinstance);
                           }
                        }
                     }

                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               } else if (!ball) {
                  attack = entity.getPersistentData().m_128471_("flag_attack");
                  LivingEntity var55;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var55 = _mobEnt.m_5448_();
                  } else {
                     var55 = null;
                  }

                  if (!(var55 instanceof LivingEntity) && !attack) {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt_x") > 200.0 || attack) {
                        entity.getPersistentData().m_128379_("flag_attack", false);
                        entity.getPersistentData().m_128347_("cnt_x", (double)(Math.round(Math.random() * -40.0) - 20L));
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", 1.0);
                     }
                  }
               }
            } else {
               if (entity.getPersistentData().m_128459_("skill") != 0.0) {
                  if (ball) {
                     AIGarudaBallProcedure.execute(world, x, y, z, entity);
                  } else {
                     AIRika1Procedure.execute(world, x, y, z, entity);
                  }
               }

               if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                  CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
               }
            }
         }

      }
   }
}
