package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class AIRikaProcedure {
   public AIRikaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
         double rnd = 0.0;
         double dis = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double tick = 0.0;
         double setItem = 0.0;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof Rika2Entity) {
               entity.getPersistentData().m_128347_("cnt_connect", entity.getPersistentData().m_128459_("cnt_connect") + 1.0);
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label173;
                  }
               }

               entity.m_274367_((float)Math.max((double)entity.getStepHeight(), 2.4));
               if (entity instanceof RikaEntity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 20, false, false));
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 16, false, false));
                  }
               }
            }

            label168: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.m_21023_(MobEffects.f_19606_)) {
                     break label168;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               if (entity instanceof Rika2Entity && entity.getPersistentData().m_128459_("cnt_connect") > 3600.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity.getPersistentData().m_128347_("despawn_flag", 1.0);
               }

               if (entity.getPersistentData().m_128459_("despawn_flag") > 0.0 && entity.getPersistentData().m_128459_("friend_num_worker") != 0.0) {
                  entity.getPersistentData().m_128347_("cnt_target", 0.0);
                  entity.getPersistentData().m_128347_("cnt_die", entity.getPersistentData().m_128459_("cnt_die") + 1.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123783_, x, y + (double)entity.m_20206_() * 0.5, z, (int)(20.0 * ReturnEntitySizeProcedure.execute(entity)), 0.25 * (double)entity.m_20205_(), 0.25 * (double)entity.m_20206_(), 0.25 * (double)entity.m_20205_(), 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123755_, x, y + (double)entity.m_20206_() * 0.5, z, (int)(5.0 * ReturnEntitySizeProcedure.execute(entity)), 0.25 * (double)entity.m_20205_(), 0.25 * (double)entity.m_20206_(), 0.25 * (double)entity.m_20205_(), 0.0);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_die") > (double)(entity.getPersistentData().m_128459_("despawn_flag") == 1.0 ? 60 : 5)) {
                     DieRikaProcedure.execute(world, entity);
                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               } else {
                  attack = entity.getPersistentData().m_128471_("flag_attack");
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if ((!(var10000 instanceof LivingEntity) || !(entity.getPersistentData().m_128459_("cnt_target") > 6.0)) && !attack) {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 || attack) {
                        label192: {
                           label184: {
                              entity.getPersistentData().m_128379_("flag_attack", false);
                              ResetCounterProcedure.execute(entity);
                              if (!attack) {
                                 if (!(Math.random() < 0.2)) {
                                    break label184;
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt42 = (LivingEntity)entity;
                                    if (_livEnt42.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       break label184;
                                    }
                                 }
                              }

                              entity.getPersistentData().m_128347_("cnt_x", 0.0);
                              rnd = (double)Math.abs(Math.round(Math.random() * 50.0) + (long)(entity.getPersistentData().m_128459_("friend_num_worker") == 0.0 ? 20 : 100));
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(rnd), 0, false, false));
                                 }
                              }

                              if (entity.getPersistentData().m_128459_("friend_num_worker") == 0.0) {
                                 entity.getPersistentData().m_128347_("skill_num", entity.getPersistentData().m_128459_("skill_num") + 1.0);
                              }

                              if (entity.getPersistentData().m_128459_("skill_num") < 8.0) {
                                 entity.getPersistentData().m_128347_("skill", (double)(Math.random() < 0.75 ? 11 : 13));
                              } else {
                                 entity.getPersistentData().m_128347_("skill", 12.0);
                                 entity.getPersistentData().m_128347_("skill_num", 0.0);
                              }
                              break label192;
                           }

                           entity.getPersistentData().m_128347_("cnt_x", 0.0);
                           CalculateAttackProcedure.execute(world, entity);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
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
                        if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                           if (entity_a.m_6084_()) {
                              dis = Math.sqrt(Math.pow(entity_a.m_20185_() - entity.m_20185_(), 2.0) + Math.pow(entity_a.m_20186_() - entity.m_20186_(), 2.0) + Math.pow(entity_a.m_20189_() - entity.m_20189_(), 2.0));
                              if (dis > 24.0) {
                                 entity.getPersistentData().m_128379_("canFly", true);
                                 GetPowerForwardProcedure.execute((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity);
                                 entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.5, entity.getPersistentData().m_128459_("y_power") * 0.5, entity.getPersistentData().m_128459_("z_power") * 0.5));
                                 if (dis > 36.0) {
                                    entity.m_6021_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                       _serverPlayer.f_8906_.m_9774_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity.m_146908_(), entity.m_146909_());
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
                           } else {
                              entity.getPersistentData().m_128347_("friend_num", 0.0);
                              entity.getPersistentData().m_128347_("friend_num_worker", 0.0);
                              entity.getPersistentData().m_128359_("OWNER_UUID", "");
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128347_("friend_num", 0.0);
                        entity.getPersistentData().m_128347_("friend_num_worker", 0.0);
                        entity.getPersistentData().m_128359_("OWNER_UUID", "");
                     }
                  }
               }
            } else {
               if (entity.getPersistentData().m_128459_("skill") == 11.0) {
                  AIRika1Procedure.execute(world, x, y, z, entity);
               } else if (entity.getPersistentData().m_128459_("skill") == 12.0) {
                  AIRika3Procedure.execute(world, x, y, z, entity);
               } else if (entity.getPersistentData().m_128459_("skill") == 13.0) {
                  RikaBlastProcedure.execute(world, x, y, z, entity);
               }

               if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                  CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
               }
            }
         }

      }
   }
}
