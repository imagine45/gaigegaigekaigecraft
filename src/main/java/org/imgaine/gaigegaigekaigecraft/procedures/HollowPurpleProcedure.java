package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.BlueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RedEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HollowPurpleProcedure {
   public HollowPurpleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double rnd = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double HP = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_pos2 = 0.0;
         double y_pos2 = 0.0;
         double z_pos2 = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         LivingEntity var10000;
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

            double var112 = ((Entity)var10000).m_20185_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            double var121 = ((Entity)var10001).m_20186_();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            var121 += (double)((Entity)var10002).m_20206_() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.m_5448_();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var112, var121, ((Entity)var10002).m_20189_(), entity);
         }

         entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
         entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
         entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 15, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 15, 9, false, false));
               }
            }

            int var123;
            label328: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var123 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label328;
                  }
               }

               var123 = 0;
            }

            HP = (double)(40 + var123 * 20);
            pitch = Math.toRadians((double)entity.m_146909_());
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F - 40.0F));
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double)entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.RED.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity42 = (LivingEntity)entityinstance;
                     if (_livingEntity42.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity42.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  entityinstance.getPersistentData().m_128379_("flag_purple", true);
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F + 40.0F));
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double)entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLUE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                     if (_livingEntity64.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity64.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  entityinstance.getPersistentData().m_128379_("flag_purple", true);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") <= 20.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity71 = (LivingEntity)entity;
                  if (_livingEntity71.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity71.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(20.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") <= 10.0) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(24.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged") && entityiterator.getPersistentData().m_128471_("flag_purple")) {
                     logic_a = true;
                     if (entityiterator instanceof RedEntity) {
                        yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F) + Math.max(40.0 - entity.getPersistentData().m_128459_("cnt1") * 4.0, 0.0));
                     } else if (entityiterator instanceof BlueEntity) {
                        yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F) + Math.max(40.0 - entity.getPersistentData().m_128459_("cnt1") * 4.0, 0.0));
                     } else {
                        logic_a = false;
                     }

                     if (logic_a) {
                        pitch = Math.toRadians((double)entity.m_146909_());
                        x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double)entity.m_20205_());
                        z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
                        entityiterator.m_6021_(x_pos, y_pos, z_pos);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityiterator.m_146908_(), entityiterator.m_146909_());
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == 10.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123747_, x_pos2, y_pos2, z_pos2, 5, 0.25, 0.25, 0.25, 0.0);
                  }
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") <= 20.0) {
               if (entity.getPersistentData().m_128459_("cnt1") >= 19.0) {
                  if (Math.random() < 0.1 && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                     if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 12.0) {
                        label391: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                              label392: {
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
                                       break label392;
                                    }
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                    break label391;
                                 }
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 != entity) {
                              entity.getPersistentData().m_128379_("PRESS_Z", true);
                           }
                        }
                     }

                     if (!(entity instanceof GojoSatoruEntity)) {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  }

                  if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                     entity.getPersistentData().m_128347_("cnt1", 19.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 9, 5, false, false));
                        }
                     }

                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double)entity.m_20205_());
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, (int)(1.0 + entity.getPersistentData().m_128459_("cnt6")), 0.25, 0.25, 0.25, 1.0);
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") < 4.0) {
                        entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
                        if (entity.getPersistentData().m_128459_("cnt5") > 20.0) {
                           entity.getPersistentData().m_128347_("cnt5", 0.0);
                           entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 1.0);
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.m_9236_().m_5776_()) {
                                 CompoundTag var124 = entity.getPersistentData();
                                 _player.m_5661_(Component.m_237113_("§l\"" + Component.m_237115_("chant.jujutsucraft.purple" + Math.round(var124.m_128459_("cnt6"))).getString() + "\""), false);
                              }
                           }

                           if (entity instanceof Player) {
                              double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 50.0;
                              entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 capability.PlayerCursePowerChange = _setval;
                                 capability.syncPlayerVariables(entity);
                              });
                           }
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") >= 4.0 && entity.getPersistentData().m_128459_("cnt6") < 6.0) {
                        entity.getPersistentData().m_128347_("cnt6", 6.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 10, 0.25, 0.25, 0.25, 1.5);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity148 = (LivingEntity)entity;
                  if (_livingEntity148.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity148.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(107.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 9, 20, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
                  int var125;
                  label364: {
                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());
                     x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double)entity.m_20205_());
                     z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double)entity.m_20205_());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var125 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label364;
                        }
                     }

                     var125 = 0;
                  }

                  HP = (double)(400 + var125 * 40);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.PURPLE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(entity.m_146909_());
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity168 = (LivingEntity)entityinstance;
                           if (_livingEntity168.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity168.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                        if (entity.getPersistentData().m_128459_("cnt6") >= 4.0) {
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity177 = (LivingEntity)entityinstance;
                              if (_livingEntity177.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 _livingEntity177.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(8.0 * (0.5 + entity.getPersistentData().m_128459_("cnt6") * 0.5));
                              }
                           }
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity180 = (LivingEntity)entityinstance;
                           if (_livingEntity180.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity180.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(8.0 * (0.5 + entity.getPersistentData().m_128459_("cnt6") * 0.2));
                           }
                        }

                        if (entity instanceof Player) {
                           if (entity.getPersistentData().m_128459_("cnt6") >= 6.0) {
                              entityinstance.getPersistentData().m_128379_("explode", entity.m_6144_());
                           }
                        } else {
                           float var119;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var119 = _livEnt.m_21223_();
                           } else {
                              var119 = -1.0F;
                           }

                           double var120 = (double)var119;
                           float var126;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var126 = _livEnt.m_21233_();
                           } else {
                              var126 = -1.0F;
                           }

                           if (var120 < (double)var126 * 0.4) {
                              entityinstance.getPersistentData().m_128379_("explode", entity instanceof GojoSatoruEntity);
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 40.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

      }
   }
}
