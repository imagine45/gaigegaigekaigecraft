package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KenjakuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DomainExpansionCreateBarrierProcedure {
   public DomainExpansionCreateBarrierProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double x_dis = 0.0;
         double loop_num = 0.0;
         double x_pos = 0.0;
         double z_dis = 0.0;
         double domainRadius = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double y_dis = 0.0;
         double dis = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double power = 0.0;
         boolean reStart = false;
         boolean update_pos = false;
         boolean old_failed = false;
         if (entity.getPersistentData().m_128459_("cnt3") < 20.0) {
            int var154;
            CompoundTag var10000;
            double var10002;
            label358: {
               label538: {
                  entity.getPersistentData().m_128347_("select", 0.0);
                  var10000 = entity.getPersistentData();
                  var10002 = entity.getPersistentData().m_128459_("cnt3");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        break label538;
                     }
                  }

                  label352: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           var154 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                           break label352;
                        }
                     }

                     var154 = 0;
                  }

                  if (var154 <= 0) {
                     var154 = 1;
                     break label358;
                  }
               }

               var154 = 2;
            }

            var10000.m_128347_("cnt3", var10002 + (double)var154);
            LivingEntity var135;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var135 = _mobEnt.m_5448_();
            } else {
               var135 = null;
            }

            if (var135 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt3", 20.0);
            } else if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               power = (double)Math.round((20.0 - entity.getPersistentData().m_128459_("cnt3")) * 0.25);
               STR1 = Component.m_237115_("jujutsu.message.long_press").getString();

               for(int index0 = 0; index0 < (int)power; ++index0) {
                  STR1 = "■" + STR1 + "■";
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(STR1), true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt3") >= 20.0 && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(""), true);
                  }
               }
            } else {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + entity.getPersistentData().m_128459_("used_technique_cost");
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(""), true);
                  }
               }

               entity.getPersistentData().m_128347_("select", 0.0);
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         } else {
            domainRadius = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            entity.m_20256_(new Vec3(0.0, Math.min(entity.m_20184_().m_7098_(), 0.0), 0.0));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
               entity.getPersistentData().m_128347_("cnt7", 1.0);
               if (entity instanceof Player && Math.random() < 0.01 && entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_open_barrier_type_domain"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }

               LivingEntity var136;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var136 = _mobEnt.m_5448_();
               } else {
                  var136 = null;
               }

               if (var136 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var136 = _mobEnt.m_5448_();
                  } else {
                     var136 = null;
                  }

                  Level var138 = ((Entity)var136).m_9236_();
                  ClipContext var10001 = new ClipContext;
                  LivingEntity var155;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var155 = _mobEnt.m_5448_();
                  } else {
                     var155 = null;
                  }

                  Vec3 var156 = ((Entity)var155).m_20299_(1.0F);
                  LivingEntity var10004;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10004 = _mobEnt.m_5448_();
                  } else {
                     var10004 = null;
                  }

                  Vec3 var159 = ((Entity)var10004).m_20299_(1.0F);
                  LivingEntity var10005;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10005 = _mobEnt.m_5448_();
                  } else {
                     var10005 = null;
                  }

                  var159 = var159.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var163 = Block.OUTLINE;
                  ClipContext.Fluid var10006 = Fluid.NONE;
                  LivingEntity var10007;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var10001.<init>(var156, var159, var163, var10006, var10007);
                  double var139 = (double)var138.m_45547_(var10001).m_82425_().m_123341_();
                  LivingEntity var145;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var145 = _mobEnt.m_5448_();
                  } else {
                     var145 = null;
                  }

                  Level var146 = ((Entity)var145).m_9236_();
                  ClipContext var148 = new ClipContext;
                  LivingEntity var161;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var161 = _mobEnt.m_5448_();
                  } else {
                     var161 = null;
                  }

                  Vec3 var162 = ((Entity)var161).m_20299_(1.0F);
                  LivingEntity var164;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var164 = _mobEnt.m_5448_();
                  } else {
                     var164 = null;
                  }

                  Vec3 var165 = ((Entity)var164).m_20299_(1.0F);
                  LivingEntity var169;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var169 = _mobEnt.m_5448_();
                  } else {
                     var169 = null;
                  }

                  var165 = var165.m_82549_(((Entity)var169).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var170 = Block.OUTLINE;
                  ClipContext.Fluid var174 = Fluid.NONE;
                  LivingEntity var10008;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10008 = _mobEnt.m_5448_();
                  } else {
                     var10008 = null;
                  }

                  var148.<init>(var162, var165, var170, var174, var10008);
                  double var147 = (double)var146.m_45547_(var148).m_82425_().m_123342_();
                  LivingEntity var149;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var149 = _mobEnt.m_5448_();
                  } else {
                     var149 = null;
                  }

                  Level var150 = ((Entity)var149).m_9236_();
                  ClipContext var157 = new ClipContext;
                  LivingEntity var167;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var167 = _mobEnt.m_5448_();
                  } else {
                     var167 = null;
                  }

                  Vec3 var168 = ((Entity)var167).m_20299_(1.0F);
                  LivingEntity var171;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var171 = _mobEnt.m_5448_();
                  } else {
                     var171 = null;
                  }

                  Vec3 var172 = ((Entity)var171).m_20299_(1.0F);
                  LivingEntity var175;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var175 = _mobEnt.m_5448_();
                  } else {
                     var175 = null;
                  }

                  var172 = var172.m_82549_(((Entity)var175).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var176 = Block.OUTLINE;
                  ClipContext.Fluid var177 = Fluid.NONE;
                  LivingEntity var10009;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10009 = _mobEnt.m_5448_();
                  } else {
                     var10009 = null;
                  }

                  var157.<init>(var168, var172, var176, var177, var10009);
                  RotateEntityProcedure.execute(var139, var147, (double)var150.m_45547_(var157).m_82425_().m_123343_(), entity);
               }

               label543: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt36 = (LivingEntity)entity;
                     if (_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label543;
                     }
                  }

                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
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

                  entity.getPersistentData().m_128347_("x_pos_doma", (double)Math.round(entity.m_20185_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * domainRadius * 0.5));
                  CompoundTag var140 = entity.getPersistentData();
                  LivingEntity var151;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var151 = _mobEnt.m_5448_();
                  } else {
                     var151 = null;
                  }

                  double var153;
                  if (var151 instanceof LivingEntity) {
                     var153 = entity.m_20186_();
                     LivingEntity var158;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var158 = _mobEnt.m_5448_();
                     } else {
                        var158 = null;
                     }

                     var153 = Math.min(var153, ((Entity)var158).m_20186_());
                  } else {
                     var153 = entity.m_20186_();
                  }

                  var140.m_128347_("y_pos_doma", (double)Math.round(var153));
                  entity.getPersistentData().m_128347_("z_pos_doma", (double)Math.round(entity.m_20189_() + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * domainRadius * 0.5));
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

               label512: {
                  label571: {
                     if (entity.getPersistentData().m_128459_("select") == 1.0 || entity.getPersistentData().m_128459_("select") == 18.0) {
                        if (!(entity instanceof Player)) {
                           if (entity instanceof KenjakuEntity) {
                              break label571;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt62 = (LivingEntity)entity;
                              if (_livEnt62.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label571;
                              }
                           }
                        } else {
                           label559: {
                              label546: {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr58 = (ServerPlayer)entity;
                                    if (_plr58.m_9236_() instanceof ServerLevel && _plr58.m_8960_().m_135996_(_plr58.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_open_barrier_type_domain"))).m_8193_()) {
                                       break label546;
                                    }
                                 }

                                 if (!(entity instanceof LivingEntity)) {
                                    break label559;
                                 }

                                 LivingEntity _livEnt59 = (LivingEntity)entity;
                                 if (!_livEnt59.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label559;
                                 }
                              }

                              if (!entity.m_6144_()) {
                                 break label571;
                              }
                           }
                        }
                     }

                     if (!(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
                        entity.getPersistentData().m_128347_("cnt2", 0.0);
                        break label512;
                     }

                     entity.getPersistentData().m_128347_("cnt2", -1.0);
                     break label512;
                  }

                  entity.getPersistentData().m_128347_("cnt2", 1.0);
               }

               reStart = false;
               update_pos = false;
               entity.getPersistentData().m_128379_("Failed", false);
               entity.getPersistentData().m_128379_("Cover", false);

               for(int index1 = 0; index1 < 2; ++index1) {
                  entity.getPersistentData().m_128347_("x_pos_doma2", (double)Math.round((float)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_()));
                  entity.getPersistentData().m_128347_("y_pos_doma2", (double)Math.round((float)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_()));
                  entity.getPersistentData().m_128347_("z_pos_doma2", (double)Math.round((float)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_()));
                  Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(domainRadius * 2.0 * 2.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     x_dis = entity.m_20185_() - entityiterator.m_20185_();
                     y_dis = entity.m_20186_() - entityiterator.m_20186_();
                     z_dis = entity.m_20189_() - entityiterator.m_20189_();
                     dis = Math.sqrt(x_dis * x_dis + y_dis * y_dis + z_dis * z_dis);
                     if (dis < domainRadius) {
                        label550: {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)(domainRadius * 2.0 + 1.0), 9, false, false));
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt87 = (LivingEntity)entityiterator;
                              if (_livEnt87.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break label550;
                              }
                           }

                           if (entityiterator.getPersistentData().m_128459_("select") == 0.0 && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), (int)(domainRadius * 2.0 + 20.0), (int)(entity.getPersistentData().m_128459_("select") + 10.0), false, false));
                              }
                           }
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt91 = (LivingEntity)entity;
                        if (_livEnt91.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                           continue;
                        }
                     }

                     label468: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt92 = (LivingEntity)entityiterator;
                           if (_livEnt92.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              break label468;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") == 0.0) {
                           continue;
                        }
                     }

                     x_dis = entity.m_20185_() - entityiterator.getPersistentData().m_128459_("x_pos_doma");
                     y_dis = entity.m_20186_() - entityiterator.getPersistentData().m_128459_("y_pos_doma");
                     z_dis = entity.m_20189_() - entityiterator.getPersistentData().m_128459_("z_pos_doma");
                     dis = Math.sqrt(x_dis * x_dis + y_dis * y_dis + z_dis * z_dis);
                     if (dis < domainRadius - 1.0) {
                        if (entity != entityiterator) {
                           label449: {
                              label448: {
                                 label552: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt101 = (LivingEntity)entityiterator;
                                       if (_livEnt101.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          label442: {
                                             if (entityiterator instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   var142 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                                   break label442;
                                                }
                                             }

                                             var142 = 0;
                                          }

                                          if (var142 <= 0) {
                                             break label448;
                                          }
                                          break label552;
                                       }
                                    }

                                    if (entityiterator.getPersistentData().m_128459_("select") == 0.0 || !(entityiterator.getPersistentData().m_128459_("cnt2") > 0.0)) {
                                       break label448;
                                    }
                                 }

                                 if (!update_pos) {
                                    entityiterator.getPersistentData().m_128347_("x_pos_doma", entity.getPersistentData().m_128459_("x_pos_doma"));
                                    entityiterator.getPersistentData().m_128347_("y_pos_doma", entity.getPersistentData().m_128459_("y_pos_doma"));
                                    entityiterator.getPersistentData().m_128347_("z_pos_doma", entity.getPersistentData().m_128459_("z_pos_doma"));
                                    update_pos = true;
                                    break label449;
                                 }
                              }

                              entity.getPersistentData().m_128347_("x_pos_doma", entityiterator.getPersistentData().m_128459_("x_pos_doma"));
                              entity.getPersistentData().m_128347_("y_pos_doma", entityiterator.getPersistentData().m_128459_("y_pos_doma"));
                              entity.getPersistentData().m_128347_("z_pos_doma", entityiterator.getPersistentData().m_128459_("z_pos_doma"));
                              update_pos = true;
                           }
                        }

                        if (entity != entityiterator) {
                           entity.getPersistentData().m_128379_("Failed", true);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt119 = (LivingEntity)entityiterator;
                              if (_livEnt119.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label426: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var143 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label426;
                                       }
                                    }

                                    var143 = 0;
                                 }

                                 if (var143 == 0) {
                                    entity.getPersistentData().m_128347_("cnt5", 1.0);
                                 }
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt122 = (LivingEntity)entityiterator;
                              if (_livEnt122.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entityiterator.getPersistentData().m_128471_("Cover")) {
                                 entityiterator.getPersistentData().m_128379_("Failed", true);
                              }
                           }
                        }
                     } else if (dis < domainRadius * 2.0 && !reStart && entity != entityiterator) {
                        label553: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt126 = (LivingEntity)entityiterator;
                              if (_livEnt126.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label455: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var141 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label455;
                                       }
                                    }

                                    var141 = 0;
                                 }

                                 if (var141 != 0) {
                                    continue;
                                 }
                                 break label553;
                              }
                           }

                           if (entityiterator.getPersistentData().m_128459_("select") == 0.0 || !(entityiterator.getPersistentData().m_128459_("cnt2") <= 0.0)) {
                              continue;
                           }
                        }

                        reStart = true;
                        x_pos = entityiterator.getPersistentData().m_128459_("x_pos_doma");
                        y_pos = entityiterator.getPersistentData().m_128459_("y_pos_doma");
                        z_pos = entityiterator.getPersistentData().m_128459_("z_pos_doma");
                     }
                  }

                  if (!reStart || entity.getPersistentData().m_128471_("Failed") || update_pos) {
                     break;
                  }

                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }

                  entity.getPersistentData().m_128347_("x_pos_doma", x_pos);
                  entity.getPersistentData().m_128347_("y_pos_doma", y_pos);
                  entity.getPersistentData().m_128347_("z_pos_doma", z_pos);
                  update_pos = true;
               }

               Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(10.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && !entityiterator.m_20147_()) {
                     x_dis = entityiterator.m_20185_() - entity.m_20185_();
                     y_dis = entityiterator.m_20186_() - entity.m_20186_();
                     z_dis = entityiterator.m_20189_() - entity.m_20189_();
                     dis = Math.sqrt(x_dis * x_dis + z_dis * z_dis);
                     if (dis > 0.0 && dis < 10.0) {
                        x_dis /= dis;
                        double var144 = y_dis / dis;
                        z_dis /= dis;
                        x_pos = entityiterator.m_20185_();
                        y_pos = entityiterator.m_20186_();
                        z_pos = entityiterator.m_20189_();
                        loop_num = Math.ceil(10.0 - dis);

                        for(int index2 = 0; index2 < (int)Math.round(loop_num); ++index2) {
                           dis = Math.sqrt((x_pos - entity.getPersistentData().m_128459_("x_pos_doma")) * (x_pos - entity.getPersistentData().m_128459_("x_pos_doma")) + (y_pos - entity.getPersistentData().m_128459_("y_pos_doma")) * (y_pos - entity.getPersistentData().m_128459_("y_pos_doma")) + (z_pos - entity.getPersistentData().m_128459_("z_pos_doma")) * (z_pos - entity.getPersistentData().m_128459_("z_pos_doma")));
                           if (dis > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 3.0) {
                              break;
                           }

                           x_pos += x_dis;
                           z_pos += z_dis;
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              ++y_pos;
                           }
                        }

                        entityiterator.m_6021_(x_pos, y_pos, z_pos);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityiterator.m_146908_(), entityiterator.m_146909_());
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt162 = (LivingEntity)entity;
               if (_livEnt162.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                  if (entity.getPersistentData().m_128459_("cnt1") >= 5.0) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.5)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.5)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.5)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_(), 5, 0.1, 0.1, 0.1, 0.1);
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") >= 20.0) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.1F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.1F, false);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 2, false, false));
                           }
                        }

                        entity.getPersistentData().m_128347_("select", 0.0);
                        entity.getPersistentData().m_128347_("skill", 0.0);
                        return;
                     }
                  }

                  return;
               }
            }

            if (entity.getPersistentData().m_128471_("Failed") && entity.getPersistentData().m_128459_("cnt5") > 0.0) {
               if (entity.getPersistentData().m_128459_("cnt1") > 1.0) {
                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") < 34.0 ? 34.0 : Math.max(50.0, domainRadius * 2.0) + 5.0);
               }
            } else {
               old_failed = entity.getPersistentData().m_128471_("Failed");
               entity.getPersistentData().m_128379_("Failed", false);
               x_pos = entity.getPersistentData().m_128459_("x_pos_doma");
               y_pos = entity.getPersistentData().m_128459_("y_pos_doma");
               z_pos = entity.getPersistentData().m_128459_("z_pos_doma");
               entity.getPersistentData().m_128347_("cnt_cover", entity.getPersistentData().m_128459_("cnt1"));
               DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128379_("Failed", old_failed);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= Math.max(34.0, domainRadius * 2.0 + 1.0)) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 200.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               entity.getPersistentData().m_128379_("StartDomainAttack", true);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), entity.getPersistentData().m_128459_("select") == 29.0 ? 3600 : 1200, (int)entity.getPersistentData().m_128459_("cnt2"), true, false));
                  }
               }

               entity.getPersistentData().m_128347_("skill", 0.0);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
