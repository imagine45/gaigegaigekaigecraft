package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIMoonDregsProcedure {
   public AIMoonDregsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_infinity = false;
         Entity entity_a = null;
         Entity owner_uuid = null;
         double x_target = 0.0;
         double NUM2 = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double velocity = 0.0;
         double yaw = 0.0;
         double NUM1 = 0.0;
         double dis = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity.m_6084_()) {
            label322: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     break label322;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 60, 1, false, false));
                  }
               }
            }

            if (entity.m_20160_() && entity.m_146895_() instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2, 0, false, false));
                  }
               }

               Entity _entity = entity.m_146895_();
               if (_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2, 4, false, false));
                  }
               }

               _entity = entity.m_146895_();
               if (_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
                  }
               }

               _entity = entity.m_146895_();
               if (_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2, 0, false, false));
                  }
               }
            }

            double var10001;
            label316: {
               NUM1 = (double)(2L + Math.round(entity.getPersistentData().m_128459_("Strength") * 0.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity16.getAttribute_(Attributes.f_22281_).m_22115_();
                     break label316;
                  }
               }

               var10001 = 0.0;
            }

            label311: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt17 = (LivingEntity)entity;
                  if (_livEnt17.m_21023_(MobEffects.f_19600_)) {
                     break label311;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label306: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label306;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)NUM2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("skill") > 100.0) {
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
                  LivingEntity var98;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var98 = _mobEnt.m_5448_();
                  } else {
                     var98 = null;
                  }

                  y_pos = var94 + (double)((Entity)var98).m_20206_() * 0.5;
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
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               if (!entity.m_20160_()) {
                  LivingEntity var96;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var96 = _mobEnt.m_5448_();
                  } else {
                     var96 = null;
                  }

                  if (var96 instanceof LivingEntity) {
                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                        entity.getPersistentData().m_128347_("cnt_x", 0.0);
                        ResetCounterProcedure.execute(entity);
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  }

                  if (entity.getPersistentData().m_128459_("skill") == 0.0 && entity.getPersistentData().m_128459_("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
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
                        logic_a = true;
                        yaw = (double)entity_a.m_146908_();
                        pitch = (double)entity_a.m_146909_();
                        x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + (double)(entity_a.m_6144_() ? 90 : 30))) * 3.0 * (double)(entity_a.m_6144_() ? 1 : -1);
                        y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5 + (entity_a.m_6144_() ? Math.sin(pitch) * -1.0 - 0.5 : 0.5);
                        z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + (double)(entity_a.m_6144_() ? 90 : 30))) * 3.0 * (double)(entity_a.m_6144_() ? 1 : -1);
                        if (entity_a.m_6144_()) {
                           Vec3 _center = new Vec3(x, y + (double)(entity.m_20206_() / 2.0F), z);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)(2.0F + entity.m_20205_()) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                              if (entity != entityiterator) {
                                 velocity = 0.0;
                                 x_power = 0.0;
                                 y_power = 0.0;
                                 z_power = 0.0;
                                 logic_infinity = false;
                                 double var97;
                                 if (entityiterator instanceof Projectile) {
                                    Projectile _projEnt = (Projectile)entityiterator;
                                    var97 = _projEnt.m_20184_().m_82553_();
                                 } else {
                                    var97 = 0.0;
                                 }

                                 if (var97 > 0.0) {
                                    logic_infinity = false;
                                    velocity = Math.sqrt(Math.pow(entityiterator.m_20184_().m_7096_(), 2.0) + Math.pow(entityiterator.m_20184_().m_7098_(), 2.0) + Math.pow(entityiterator.m_20184_().m_7094_(), 2.0));
                                    if (velocity > 0.0) {
                                       x_power = entityiterator.m_20184_().m_7096_() / velocity;
                                       y_power = entityiterator.m_20184_().m_7098_() / velocity;
                                       z_power = entityiterator.m_20184_().m_7094_() / velocity;
                                       dis = Math.sqrt(Math.pow(entityiterator.m_20185_() - entity.m_20185_(), 2.0) + Math.pow(entityiterator.m_20186_() - entity.m_20186_(), 2.0) + Math.pow(entityiterator.m_20189_() - entity.m_20189_(), 2.0));
                                       if (dis > Math.sqrt(Math.pow(entityiterator.m_20185_() + x_power * 0.001 - entity.m_20185_(), 2.0) + Math.pow(entityiterator.m_20186_() + y_power * 0.001 - entity.m_20186_(), 2.0) + Math.pow(entityiterator.m_20189_() + z_power * 0.001 - entity.m_20189_(), 2.0))) {
                                          logic_infinity = true;
                                       }
                                    }
                                 }

                                 if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                                    logic_infinity = true;
                                    if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && (entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged") || entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged"))) {
                                       logic_infinity = false;
                                    }

                                    if (entity.getPersistentData().m_128459_("NameRanged") != 0.0 && (entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged") || entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged"))) {
                                       logic_infinity = false;
                                    }
                                 }

                                 if (logic_infinity) {
                                    if (!entity.getPersistentData().m_128471_("Stop")) {
                                       entityiterator.getPersistentData().m_128379_("Stop", true);
                                    }

                                    if (velocity > 0.0) {
                                       entityiterator.m_20256_(new Vec3(x_power * 0.01, 0.0, z_power * 0.01));
                                    } else {
                                       entityiterator.m_20256_(new Vec3(0.0, 0.0, 0.0));
                                    }
                                 }
                              }
                           }
                        }

                        if (Math.abs(x_target - entity.m_20185_()) > 0.5) {
                           x_target = entity.m_20185_() + (entity.m_20185_() > x_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(y_target - entity.m_20186_()) > 0.5) {
                           y_target = entity.m_20186_() + (entity.m_20186_() > y_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(z_target - entity.m_20189_()) > 0.5) {
                           z_target = entity.m_20189_() + (entity.m_20189_() > z_target ? -0.5 : 0.5);
                        }

                        entity.m_6021_(x_target, y_target, z_target);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_target, y_target, z_target, entity.m_146908_(), entity.m_146909_());
                        }

                        entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? 0.0 : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
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
            } else {
               AIMoonDregsMove1Procedure.execute(world, entity);
            }
         }

         if (LogicOwnerExistProcedure.execute(world, entity)) {
            owner_uuid = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         } else if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

      }
   }
}
