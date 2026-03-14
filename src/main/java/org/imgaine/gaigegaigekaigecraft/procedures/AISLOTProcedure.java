package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.SlotEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AISLOTProcedure {
   public AISLOTProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String animation = "";
         boolean decide = false;
         boolean SUCCESS = false;
         boolean logic_a = false;
         Entity entity_a = null;
         Entity entity_1 = null;
         Entity entity_2 = null;
         Entity entity_3 = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double speed = 0.0;
         double num3 = 0.0;
         double HP = 0.0;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            byte var10000;
            label709: {
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
               range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
               z_pos = entity.m_20189_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19596_)) {
                     var10000 = 2;
                     break label709;
                  }
               }

               var10000 = 1;
            }

            speed = (double)var10000;
            if (entity_a instanceof LivingEntity) {
               LivingEntity _livEnt7 = (LivingEntity)entity_a;
               if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  if (!entity_a.getPersistentData().m_128471_("Failed")) {
                     entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
                     entity_1 = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity_a.getPersistentData().m_128461_("SLOT1"));
                     entity_2 = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity_a.getPersistentData().m_128461_("SLOT2"));
                     entity_3 = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity_a.getPersistentData().m_128461_("SLOT3"));
                     if (!(entity_1 instanceof SlotEntity) && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                     if (!(entity_2 instanceof SlotEntity) && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                     if (!(entity_3 instanceof SlotEntity) && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                     if (entity instanceof SlotEntity) {
                        SlotEntity _datEntSetS = (SlotEntity)entity;
                        _datEntSetS.m_20088_().m_135381_(SlotEntity.DATA_ANIMATION_NAME, ((SlotEntity)entity).animationprocedure);
                     }

                     String var139;
                     if (entity instanceof SlotEntity) {
                        SlotEntity _datEntS = (SlotEntity)entity;
                        var139 = (String)_datEntS.m_20088_().m_135370_(SlotEntity.DATA_ANIMATION_NAME);
                     } else {
                        var139 = "";
                     }

                     if (!var139.contains("slot")) {
                        int var140;
                        if (entity instanceof SlotEntity) {
                           SlotEntity _datEntI = (SlotEntity)entity;
                           var140 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                        } else {
                           var140 = 0;
                        }

                        if (var140 == 1) {
                           if (entity.getPersistentData().m_128459_("cnt1") >= 20.0 / speed) {
                              decide = true;
                           }
                        } else {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var140 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var140 = 0;
                           }

                           if (var140 == 2) {
                              if (entity.getPersistentData().m_128459_("cnt1") >= 30.0 / speed) {
                                 decide = true;
                              }
                           } else {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var140 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                              } else {
                                 var140 = 0;
                              }

                              if (var140 == 3) {
                                 if (entity.getPersistentData().m_128459_("cnt1") >= 30.0 / speed) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, 5, 1.0, 2.0, 1.0, 0.5);
                                    }

                                    for(int index0 = 0; index0 < 72; ++index0) {
                                       if (Math.random() < 0.2) {
                                          if (entity.getPersistentData().m_128459_("reach_action") == 1.0) {
                                             if (world instanceof ServerLevel) {
                                                ServerLevel _level = (ServerLevel)world;
                                                _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity_a.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * (range * 0.5 - 4.0), y_pos + (Math.random() - 0.5) * 5.0, entity_a.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * (range * 0.5 - 4.0), 1, 0.1, 0.1, 0.1, 0.0);
                                             }
                                          } else if (entity.getPersistentData().m_128459_("reach_action") == 2.0 && world instanceof ServerLevel) {
                                             ServerLevel _level = (ServerLevel)world;
                                             _level.m_8767_(ParticleTypes.f_123748_, entity_a.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * (range * 0.5 - 4.0), y_pos + (Math.random() - 0.5) * 5.0, entity_a.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * (range * 0.5 - 4.0), 1, 0.1, 0.1, 0.1, 0.0);
                                          }
                                       }

                                       num1 += Math.toRadians(10.0 * Math.random());
                                    }
                                 }

                                 if (entity.getPersistentData().m_128459_("cnt1") >= 60.0 / speed) {
                                    decide = true;
                                 }
                              }
                           }
                        }
                     }

                     if (decide) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123810_, x_pos, y_pos, z_pos, 25, 1.0, 2.0, 1.0, 0.05);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 25, 1.0, 2.0, 1.0, 0.05);
                        }

                        int var143;
                        if (entity instanceof SlotEntity) {
                           SlotEntity _datEntI = (SlotEntity)entity;
                           var143 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                        } else {
                           var143 = 0;
                        }

                        if (var143 == 1) {
                           num1 = Math.random();
                           if (Math.random() < 0.5) {
                              if (num1 < 0.3) {
                                 num1 = 1.0;
                              } else if (num1 < 0.6) {
                                 num1 = 3.0;
                              } else if (num1 < 0.9) {
                                 num1 = 5.0;
                              } else {
                                 num1 = 7.0;
                              }
                           } else if (num1 < 0.33) {
                              num1 = 2.0;
                           } else if (num1 < 0.66) {
                              num1 = 4.0;
                           } else {
                              num1 = 6.0;
                           }

                           animation = "slot" + Math.round(num1);
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntSetI = (SlotEntity)entity;
                              _datEntSetI.m_20088_().m_135381_(SlotEntity.DATA_SLOT_NUM, (int)num1);
                           }
                        } else {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var143 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var143 = 0;
                           }

                           if (var143 == 2) {
                              label618: {
                                 if (entity_1 instanceof SlotEntity) {
                                    if (entity_1 instanceof SlotEntity) {
                                       SlotEntity _datEntI = (SlotEntity)entity_1;
                                       var143 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                                    } else {
                                       var143 = 0;
                                    }

                                    if (var143 > 0) {
                                       float var146;
                                       if (entity_1 instanceof SlotEntity) {
                                          SlotEntity _datEntI = (SlotEntity)entity_1;
                                          var146 = (float)(Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                                       } else {
                                          var146 = 0.0F;
                                       }

                                       animation = "slot" + Math.round(var146);
                                       if (entity instanceof SlotEntity) {
                                          SlotEntity _datEntSetI = (SlotEntity)entity;
                                          SynchedEntityData var147 = _datEntSetI.m_20088_();
                                          EntityDataAccessor var10001 = SlotEntity.DATA_SLOT_NUM;
                                          int var10002;
                                          if (entity_1 instanceof SlotEntity) {
                                             SlotEntity _datEntI = (SlotEntity)entity_1;
                                             var10002 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                                          } else {
                                             var10002 = 0;
                                          }

                                          var147.m_135381_(var10001, var10002);
                                       }
                                       break label618;
                                    }
                                 }

                                 num1 = Math.ceil(Math.random() * 7.0);
                                 animation = "slot" + Math.round(num1);
                                 if (entity instanceof SlotEntity) {
                                    SlotEntity _datEntSetI = (SlotEntity)entity;
                                    _datEntSetI.m_20088_().m_135381_(SlotEntity.DATA_SLOT_NUM, (int)num1);
                                 }
                              }

                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var143 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var143 = 0;
                              }

                              int var168;
                              if (entity_1 instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity_1;
                                 var168 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var168 = 0;
                              }

                              if (var143 == var168) {
                                 Vec3 _center = new Vec3(entity_a.getPersistentData().m_128459_("x_pos_doma"), entity_a.getPersistentData().m_128459_("y_pos_doma"), entity_a.getPersistentData().m_128459_("z_pos_doma"));

                                 for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s actionbar {\"text\":\"REACH\",\"color\":\"light_purple\",\"bold\":true}");
                                    }
                                 }

                                 if (Math.random() < 0.3) {
                                    entity_3.getPersistentData().m_128347_("reach_action", 1.0);
                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.m_5776_()) {
                                          _level.m_5594_((Player)null, BlockPos.m_274561_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.m_7785_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.m_5776_()) {
                                          _level.m_5594_((Player)null, BlockPos.m_274561_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.m_7785_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_(), 50, 2.0, 2.0, 2.0, 1.0);
                                    }
                                 } else {
                                    entity_3.getPersistentData().m_128347_("reach_action", 2.0);
                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.m_5776_()) {
                                          _level.m_5594_((Player)null, BlockPos.m_274561_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.m_7785_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.m_5776_()) {
                                          _level.m_5594_((Player)null, BlockPos.m_274561_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.m_7785_(entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_8767_(ParticleTypes.f_123748_, entity_3.m_20185_(), entity_3.m_20186_() + (double)entity_3.m_20206_() * 0.5, entity_3.m_20189_(), 50, 2.0, 2.0, 2.0, 1.0);
                                    }
                                 }
                              }
                           } else {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var143 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                              } else {
                                 var143 = 0;
                              }

                              if (var143 == 3) {
                                 if (entity_1 instanceof SlotEntity) {
                                    float var150;
                                    if (entity_1 instanceof SlotEntity) {
                                       SlotEntity _datEntI = (SlotEntity)entity_1;
                                       var150 = (float)(Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                                    } else {
                                       var150 = 0.0F;
                                    }

                                    num2 = (double)Math.round(var150);
                                 }

                                 label654: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19590_)) {
                                          var143 = _livEnt.m_21124_(MobEffects.f_19590_).m_19564_();
                                          break label654;
                                       }
                                    }

                                    var143 = 0;
                                 }

                                 if (var143 >= 9) {
                                    num1 = num2 - 1.0;
                                    if (num2 < 1.0) {
                                       num1 = 7.0;
                                    }
                                 } else {
                                    label647: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19621_)) {
                                             var143 = _livEnt.m_21124_(MobEffects.f_19621_).m_19564_();
                                             break label647;
                                          }
                                       }

                                       var143 = 0;
                                    }

                                    if (var143 >= 9) {
                                       num1 = num2;
                                    } else {
                                       int index1 = 0;

                                       while(true) {
                                          int var169;
                                          label640: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt101 = (LivingEntity)entity;
                                                if (_livEnt101.m_21023_(MobEffects.f_19621_)) {
                                                   label636: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.m_21023_(MobEffects.f_19621_)) {
                                                            var169 = _livEnt.m_21124_(MobEffects.f_19621_).m_19564_();
                                                            break label636;
                                                         }
                                                      }

                                                      var169 = 0;
                                                   }

                                                   var169 = (var169 + 1) * 2;
                                                   break label640;
                                                }
                                             }

                                             var169 = 2;
                                          }

                                          if (index1 >= var169) {
                                             break;
                                          }

                                          num1 = Math.ceil(Math.random() * 7.0);
                                          if (num1 != num2) {
                                             if (!(entity instanceof LivingEntity)) {
                                                break;
                                             }

                                             LivingEntity _livEnt103 = (LivingEntity)entity;
                                             if (!_livEnt103.m_21023_(MobEffects.f_19621_)) {
                                                break;
                                             }
                                          } else if (Math.random() < 0.15) {
                                             break;
                                          }

                                          ++index1;
                                       }
                                    }
                                 }

                                 animation = "slot" + Math.round(num1);
                                 if (entity instanceof SlotEntity) {
                                    SlotEntity _datEntSetI = (SlotEntity)entity;
                                    _datEntSetI.m_20088_().m_135381_(SlotEntity.DATA_SLOT_NUM, (int)num1);
                                 }
                              }
                           }
                        }

                        if (entity instanceof SlotEntity) {
                           ((SlotEntity)entity).setAnimation(animation);
                        }
                     }

                     int var153;
                     if (entity instanceof SlotEntity) {
                        SlotEntity _datEntI = (SlotEntity)entity;
                        var153 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                     } else {
                        var153 = 0;
                     }

                     if (var153 == 3 && entity.getPersistentData().m_128459_("cnt1") == 80.0 / speed) {
                        num1 = 0.0;
                        SUCCESS = false;
                        if (entity_1 instanceof SlotEntity) {
                           double var154;
                           if (entity_1 instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity_1;
                              var154 = (double)(Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                           } else {
                              var154 = 0.0;
                           }

                           num1 = var154;
                           SUCCESS = true;
                        }

                        if (SUCCESS) {
                           SUCCESS = false;
                           if (entity_2 instanceof SlotEntity) {
                              int var171;
                              if (entity_2 instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity_2;
                                 var171 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var171 = 0;
                              }

                              if (num1 == (double)var171) {
                                 SUCCESS = true;
                              }
                           }
                        }

                        if (SUCCESS) {
                           SUCCESS = false;
                           if (entity_3 instanceof SlotEntity) {
                              int var172;
                              if (entity_3 instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity_3;
                                 var172 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var172 = 0;
                              }

                              if (num1 == (double)var172) {
                                 SUCCESS = true;
                              }
                           }
                        }

                        if (SUCCESS) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:hakari1")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                              } else {
                                 _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:hakari1")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                              }
                           }

                           entity_1.getPersistentData().m_128347_("cnt2", 1.0);
                           entity_2.getPersistentData().m_128347_("cnt2", 1.0);
                           entity_3.getPersistentData().m_128347_("cnt2", 1.0);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt2") > 0.0) {
                        entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123810_, x_pos, y_pos, z_pos, 10, 1.0, 1.0, 1.0, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123815_, x_pos, y_pos, z_pos, 1, 1.0, 1.0, 1.0, 0.5);
                        }

                        if (entity instanceof SlotEntity) {
                           SlotEntity _datEntI = (SlotEntity)entity;
                           var153 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                        } else {
                           var153 = 0;
                        }

                        if (var153 == 3 && entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var173;
                              MobEffect var10003;
                              int var10005;
                              label549: {
                                 var173 = new MobEffectInstance;
                                 var10003 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity_a;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                       break label549;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var173.<init>(var10003, 1200, var10005, true, true);
                              _entity.m_7292_(var173);
                           }
                        }

                        if (Math.random() < 0.05) {
                           range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
                           num1 = Math.toRadians(Math.random() * 360.0);
                           num2 = Math.random() * range - range / 2.0;
                           x_pos = entity_a.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * num2;
                           y_pos = entity_a.getPersistentData().m_128459_("y_pos_doma") + 5.0;
                           z_pos = entity_a.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * num2;
                           if (Math.random() < 0.25) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 Commands var156 = _level.m_7654_().m_129892_();
                                 CommandSourceStack var174 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                                 double var183 = Math.random();
                                 var156.m_230957_(var174, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var183 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16711680],FadeColors:[I;16711680]}]}}}}");
                              }
                           } else if (Math.random() < 0.25) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 Commands var157 = _level.m_7654_().m_129892_();
                                 CommandSourceStack var175 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                                 double var184 = Math.random();
                                 var157.m_230957_(var175, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var184 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16774912],FadeColors:[I;16774912]}]}}}}");
                              }
                           } else if (Math.random() < 0.25) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 Commands var158 = _level.m_7654_().m_129892_();
                                 CommandSourceStack var176 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                                 double var185 = Math.random();
                                 var158.m_230957_(var176, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var185 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;43775],FadeColors:[I;43775]}]}}}}");
                              }
                           } else if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              Commands var159 = _level.m_7654_().m_129892_();
                              CommandSourceStack var177 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                              double var186 = Math.random();
                              var159.m_230957_(var177, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var186 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;65442],FadeColors:[I;65442]}]}}}}");
                           }
                        }

                        if (entity.getPersistentData().m_128459_("cnt2") >= 50.0) {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var153 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var153 = 0;
                           }

                           if (var153 == 3) {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var153 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var153 = 0;
                              }

                              if (var153 % 2 == 1) {
                                 entity_a.getPersistentData().m_128347_("mode_hakari", 2.0);
                              } else if (Math.random() < 0.5) {
                                 entity_a.getPersistentData().m_128347_("mode_hakari", 1.0);
                              } else {
                                 entity_a.getPersistentData().m_128347_("mode_hakari", 40.0);
                              }

                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity_a;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.JACKPOT.get(), 1800, 0, true, true));
                                 }
                              }

                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity_a;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                              }
                           }

                           if (!entity.m_9236_().m_5776_()) {
                              entity.m_146870_();
                           }

                           return;
                        }
                     } else if (entity.getPersistentData().m_128459_("cnt1") >= Math.max(80.0 / speed, 50.0)) {
                        label598: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19590_)) {
                                 var153 = _livEnt.m_21124_(MobEffects.f_19590_).m_19564_();
                                 break label598;
                              }
                           }

                           var153 = 0;
                        }

                        if (var153 >= 9 && Math.random() > 0.5) {
                           if (entity.getPersistentData().m_128459_("cnt1") >= Math.max(100.0 / speed, 50.0)) {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var153 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                              } else {
                                 var153 = 0;
                              }

                              if (var153 == 3 && entity_a.m_6084_()) {
                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.m_5776_()) {
                                       _level.m_5594_((Player)null, BlockPos.m_274561_(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5, entity_a.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                       _level.m_7785_(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5, entity_a.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5, entity_a.m_20189_(), 50, 2.0, 2.0, 2.0, 0.25);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5, entity_a.m_20189_(), 50, 1.0, 1.0, 1.0, 0.25);
                                 }

                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity_a;
                                    float var178;
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       var178 = _livEnt.m_21223_();
                                    } else {
                                       var178 = -1.0F;
                                    }

                                    double var179 = (double)var178;
                                    float var187;
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       var187 = _livEnt.m_21233_();
                                    } else {
                                       var187 = -1.0F;
                                    }

                                    _entity.m_21153_((float)(var179 + (double)var187 * 0.5));
                                 }
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x_pos, y_pos, z_pos, 20, 1.0, 2.0, 1.0, 0.25);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x_pos, y_pos, z_pos, 40, 1.0, 2.0, 1.0, 0.25);
                              }

                              x_pos = entity.m_20185_();
                              y_pos = entity.m_20186_();
                              z_pos = entity.m_20189_();
                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                 } else {
                                    _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                 } else {
                                    _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                 }
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _serverLevel = (ServerLevel)world;
                                 Entity entityinstance = ((EntityType)JujutsucraftModEntities.SLOT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                                 if (entityinstance != null) {
                                    entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                                    if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                                       entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                                    }

                                    entityinstance.m_146922_(entity.m_146908_());
                                    entityinstance.m_146926_(0.0F);
                                    entityinstance.m_5618_(entityinstance.m_146908_());
                                    entityinstance.m_5616_(entityinstance.m_146908_());
                                    entityinstance.f_19859_ = entityinstance.m_146908_();
                                    entityinstance.f_19860_ = entityinstance.m_146909_();
                                    if (entityinstance instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityinstance;
                                       _entity.f_20884_ = _entity.m_146908_();
                                       _entity.f_20886_ = _entity.m_146908_();
                                    }

                                    entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged_ranged"));
                                    entityinstance.getPersistentData().m_128347_("cnt1", -20.0);
                                    entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                                    if (entityinstance instanceof SlotEntity) {
                                       SlotEntity _datEntSetI = (SlotEntity)entityinstance;
                                       SynchedEntityData var165 = _datEntSetI.m_20088_();
                                       EntityDataAccessor var180 = SlotEntity.DATA_SLOT_MODE;
                                       int var188;
                                       if (entity instanceof SlotEntity) {
                                          SlotEntity _datEntI = (SlotEntity)entity;
                                          var188 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                                       } else {
                                          var188 = 0;
                                       }

                                       var165.m_135381_(var180, var188);
                                    }

                                    CompoundTag var166 = entity_a.getPersistentData();
                                    float var181;
                                    if (entity instanceof SlotEntity) {
                                       SlotEntity _datEntI = (SlotEntity)entity;
                                       var181 = (float)(Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                                    } else {
                                       var181 = 0.0F;
                                    }

                                    label573: {
                                       var166.m_128359_("SLOT" + Math.round(var181), entityinstance.m_20149_());
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19590_)) {
                                             var167 = _livEnt.m_21124_(MobEffects.f_19590_).m_19564_();
                                             break label573;
                                          }
                                       }

                                       var167 = 0;
                                    }

                                    if (var167 > 9) {
                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityinstance;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             MobEffect var189;
                                             int var190;
                                             label564: {
                                                var182 = new MobEffectInstance;
                                                var189 = MobEffects.f_19590_;
                                                if (entity instanceof LivingEntity) {
                                                   LivingEntity _livEnt = (LivingEntity)entity;
                                                   if (_livEnt.m_21023_(MobEffects.f_19590_)) {
                                                      var190 = _livEnt.m_21124_(MobEffects.f_19590_).m_19564_();
                                                      break label564;
                                                   }
                                                }

                                                var190 = 0;
                                             }

                                             var182.<init>(var189, 2147483647, var190 - 1, false, false);
                                             _entity.m_7292_(var182);
                                          }
                                       }
                                    } else if (entityinstance instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityinstance;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance(MobEffects.f_19621_, 2147483647, 9, false, false));
                                       }
                                    }

                                    _serverLevel.m_7967_(entityinstance);
                                 }
                              }

                              if (!entity.m_9236_().m_5776_()) {
                                 entity.m_146870_();
                              }

                              return;
                           }
                        } else {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var153 = (Integer)_datEntI.m_20088_().m_135370_(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var153 = 0;
                           }

                           if (var153 == 3 && entity_a.getPersistentData().m_128459_("mode_hakari") > 10.0) {
                              entity_a.getPersistentData().m_128347_("mode_hakari", entity_a.getPersistentData().m_128459_("mode_hakari") - 1.0);
                              if (entity_a.getPersistentData().m_128459_("mode_hakari") <= 10.0) {
                                 entity_a.getPersistentData().m_128347_("mode_hakari", 0.0);
                              }
                           }

                           if (!entity.m_9236_().m_5776_()) {
                              entity.m_146870_();
                              return;
                           }
                        }

                        return;
                     }

                     return;
                  }

                  return;
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         } else if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
