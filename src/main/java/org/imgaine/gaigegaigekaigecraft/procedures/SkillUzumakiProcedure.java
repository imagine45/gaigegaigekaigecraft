package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillUzumakiProcedure {
   public SkillUzumakiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         String STR2 = "";
         boolean adult = false;
         boolean reChange = false;
         boolean player = false;
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double count_spirit = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         player = entity instanceof Player;
         if (entity.getPersistentData().m_128459_("cnt9") < 20.0) {
            entity.getPersistentData().m_128347_("cnt9", entity.getPersistentData().m_128459_("cnt9") + 1.0);
            if (player) {
               if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt9", 30.0);
               }
            } else if (!entity.getPersistentData().m_128471_("uzumaki")) {
               entity.getPersistentData().m_128347_("cnt9", 30.0);
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle soul ^ ^ ^3 0.1 0.1 0.1 0 2 normal @s");
            }
         }

         if (entity.getPersistentData().m_128459_("cnt9") >= 30.0 && entity.getPersistentData().m_128459_("cnt9") < 35.0) {
            entity.getPersistentData().m_128347_("skill", 1816.0);
         }

         if (entity.getPersistentData().m_128459_("cnt9") >= 20.0 && entity.getPersistentData().m_128459_("cnt9") < 25.0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians(0.0);
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(-3.0F - entity.m_20205_()));
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (double)(-3.0F - entity.m_20205_()));
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(-3.0F - entity.m_20205_()));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") < 20.0) {
               if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity31 = (LivingEntity)entity;
                  if (_livingEntity31.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity31.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-3.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               num1 = entity.getPersistentData().m_128459_("cnt1") / 19.5;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos + 2.0, z_pos, (int)(50.0 * num1), 1.5 * num1, 1.5 * num1, 1.5 * num1, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos + 2.0, z_pos, (int)(25.0 * num1), 1.5 * num1, 1.5 * num1, 1.5 * num1, 0.0);
               }

               if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt2", 1.0);
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 700.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)(entity.getPersistentData().m_128459_("COOLDOWN_TICKS") * 2.0), 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 100, 0, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 1.0F, 0.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 1.0F, 0.25F, false);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && !player) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(256.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator.getPersistentData().m_128471_("CursedSpirit") && !(entityiterator instanceof Player) && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123746_, entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5, entityiterator.m_20189_(), (int)Math.min(Math.pow((double)(entityiterator.m_20205_() * 2.0F + entityiterator.m_20206_() * 2.0F), 2.0), 100.0), (double)entityiterator.m_20205_() * 0.5, (double)entityiterator.m_20206_() * 0.5, (double)entityiterator.m_20205_() * 0.5, 0.0);
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
                  if (player) {
                     x_pos = 0.0;
                     z_pos = 0.0;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        Commands var10000 = entity.m_20194_().m_129892_();
                        CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        long var10002 = Math.round(x_pos);
                        var10000.m_230957_(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                     }

                     num1 = 0.0;

                     for(int index0 = 0; index0 < 10000; ++index0) {
                        ++num1;
                        STR1 = "data_cursed_spirit_manipulation" + Math.round(num1);
                        if (entity.getPersistentData().m_128459_(STR1) == 0.0) {
                           break;
                        }

                        y_pos = entity.getPersistentData().m_128459_(STR1);
                        if (world instanceof ServerLevel) {
                           ServerLevel _origLevel = (ServerLevel)world;
                           LevelAccessor var45 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                           if (var45 != null) {
                              Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                              for(Entity entityiterator : var45.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                                 if (entity != entityiterator && entity.getPersistentData().m_128461_(STR1 + "_name").equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                                    CompoundTag var112;
                                    double var133;
                                    int var10003;
                                    label423: {
                                       var112 = entity.getPersistentData();
                                       var133 = entity.getPersistentData().m_128459_("cnt6");
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label423;
                                          }
                                       }

                                       var10003 = 0;
                                    }

                                    var112.m_128347_("cnt6", var133 + (double)(var10003 + 1) * 0.1);
                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                                    }

                                    if (!entityiterator.m_9236_().m_5776_()) {
                                       entityiterator.m_146870_();
                                    }
                                 }
                              }
                           }

                           world = world;
                        }

                        entity.getPersistentData().m_128347_(STR1, 0.0);
                        entity.getPersistentData().m_128347_(STR1 + "_num", 0.0);
                        entity.getPersistentData().m_128359_(STR1 + "_name", "");
                     }

                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  } else {
                     entity.getPersistentData().m_128379_("use_uzumaki", true);
                  }

                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && !player) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(256.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator.getPersistentData().m_128471_("CursedSpirit") && !(entityiterator instanceof Player) && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                           CompoundTag var113;
                           double var134;
                           int var135;
                           label398: {
                              var113 = entity.getPersistentData();
                              var134 = entity.getPersistentData().m_128459_("cnt6");
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var135 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label398;
                                 }
                              }

                              var135 = 0;
                           }

                           var113.m_128347_("cnt6", var134 + (double)(var135 + 1) * 0.1);
                           if (!entityiterator.m_9236_().m_5776_()) {
                              entityiterator.m_146870_();
                           }
                        }
                     }
                  }

                  int var130;
                  label390: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var130 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label390;
                        }
                     }

                     var130 = 0;
                  }

                  HP = (double)(400 + var130 * 40);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.UZUMAKI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                           LivingEntity _livingEntity105 = (LivingEntity)entityinstance;
                           if (_livingEntity105.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity105.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity112 = (LivingEntity)entityinstance;
                           if (_livingEntity112.m_21204_().m_22171_(Attributes.f_22281_)) {
                              AttributeInstance var114;
                              label378: {
                                 var114 = _livingEntity112.getAttribute_(Attributes.f_22281_);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity109 = (LivingEntity)entityinstance;
                                    if (_livingEntity109.m_21204_().m_22171_(Attributes.f_22281_)) {
                                       var131 = _livingEntity109.getAttribute_(Attributes.f_22281_).m_22115_();
                                       break label378;
                                    }
                                 }

                                 var131 = 0.0;
                              }

                              var114.m_22100_(var131 + entity.getPersistentData().m_128459_("cnt6"));
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity114 = (LivingEntity)entityinstance;
                           if (_livingEntity114.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity114.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") < 80.0) {
               LivingEntity var115;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var115 = _mobEnt.m_5448_();
               } else {
                  var115 = null;
               }

               if (var115 instanceof LivingEntity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 20, false, false));
                     }
                  }

                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var115 = _mobEnt.m_5448_();
                  } else {
                     var115 = null;
                  }

                  if (((Entity)var115).getPersistentData().m_128459_("skill") == 515.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var115 = _mobEnt.m_5448_();
                     } else {
                        var115 = null;
                     }

                     if (((Entity)var115).getPersistentData().m_128459_("cnt1") < 80.0) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     } else {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  } else {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var115 = _mobEnt.m_5448_();
                     } else {
                        var115 = null;
                     }

                     if (var115 instanceof OkkotsuYutaEntity) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var115 = _mobEnt.m_5448_();
                        } else {
                           var115 = null;
                        }

                        if (((Entity)var115).getPersistentData().m_128459_("skill") == 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var115 = _mobEnt.m_5448_();
                           } else {
                              var115 = null;
                           }

                           label328: {
                              LivingEntity var111 = var115;
                              if (var111 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var111;
                                 if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                    var120 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                                    break label328;
                                 }
                              }

                              var120 = 0;
                           }

                           if (var120 >= 10) {
                              entity.getPersistentData().m_128379_("PRESS_Z", true);
                           } else {
                              entity.getPersistentData().m_128379_("PRESS_Z", false);
                           }
                        }
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var115 = _mobEnt.m_5448_();
                     } else {
                        var115 = null;
                     }

                     if (((Entity)var115).getPersistentData().m_128459_("skill") == 0.0) {
                        if (GetDistanceProcedure.execute(entity) >= 10.0) {
                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().m_128379_("PRESS_Z", false);
                        }
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var115 = _mobEnt.m_5448_();
                     } else {
                        var115 = null;
                     }

                     if (((Entity)var115).getPersistentData().m_128459_("skill") > 0.0) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var115 = _mobEnt.m_5448_();
                        } else {
                           var115 = null;
                        }

                        if (((Entity)var115).getPersistentData().m_128471_("PRESS_Z")) {
                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().m_128379_("PRESS_Z", false);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") >= 200.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 78.0));
               }
            }

            LivingEntity var125;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var125 = _mobEnt.m_5448_();
            } else {
               var125 = null;
            }

            if (var125 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var125 = _mobEnt.m_5448_();
               } else {
                  var125 = null;
               }

               x_pos = ((Entity)var125).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var125 = _mobEnt.m_5448_();
               } else {
                  var125 = null;
               }

               double var128 = ((Entity)var125).m_20186_();
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
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
            if (entity.getPersistentData().m_128459_("cnt1") == 90.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity168 = (LivingEntity)entity;
                  if (_livingEntity168.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity168.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-7.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 100.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
