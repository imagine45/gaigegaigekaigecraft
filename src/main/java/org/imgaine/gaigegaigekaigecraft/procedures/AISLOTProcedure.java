package org.imgaine.gaigegaigekaigecraft.procedures;

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
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
               x_pos = entity.getX();
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
               z_pos = entity.getZ();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                     var10000 = 2;
                     break label709;
                  }
               }

               var10000 = 1;
            }

            speed = (double)var10000;
            if (entity_a instanceof LivingEntity) {
               LivingEntity _livEnt7 = (LivingEntity)entity_a;
               if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  if (!entity_a.getPersistentData().getBoolean("Failed")) {
                     entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                     entity_1 = GetEntityFromUUIDProcedure.execute(world, entity_a.getPersistentData().getString("SLOT1"));
                     entity_2 = GetEntityFromUUIDProcedure.execute(world, entity_a.getPersistentData().getString("SLOT2"));
                     entity_3 = GetEntityFromUUIDProcedure.execute(world, entity_a.getPersistentData().getString("SLOT3"));
                     if (!(entity_1 instanceof SlotEntity) && !entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (!(entity_2 instanceof SlotEntity) && !entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (!(entity_3 instanceof SlotEntity) && !entity.level().isClientSide()) {
                        entity.discard();
                     }

                     if (entity instanceof SlotEntity) {
                        SlotEntity _datEntSetS = (SlotEntity)entity;
                        _datEntSetS.getEntityData().set(SlotEntity.DATA_ANIMATION_NAME, ((SlotEntity)entity).getSyncedAnimation());
                     }

                     String var139;
                     if (entity instanceof SlotEntity) {
                        SlotEntity _datEntS = (SlotEntity)entity;
                        var139 = (String)_datEntS.getEntityData().get(SlotEntity.DATA_ANIMATION_NAME);
                     } else {
                        var139 = "";
                     }

                     if (!var139.contains("slot")) {
                        int var140;
                        if (entity instanceof SlotEntity) {
                           SlotEntity _datEntI = (SlotEntity)entity;
                           var140 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                        } else {
                           var140 = 0;
                        }

                        if (var140 == 1) {
                           if (entity.getPersistentData().getDouble("cnt1") >= 20.0 / speed) {
                              decide = true;
                           }
                        } else {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var140 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var140 = 0;
                           }

                           if (var140 == 2) {
                              if (entity.getPersistentData().getDouble("cnt1") >= 30.0 / speed) {
                                 decide = true;
                              }
                           } else {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var140 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                              } else {
                                 var140 = 0;
                              }

                              if (var140 == 3) {
                                 if (entity.getPersistentData().getDouble("cnt1") >= 30.0 / speed) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, 5, 1.0, 2.0, 1.0, 0.5);
                                    }

                                    for(int index0 = 0; index0 < 72; ++index0) {
                                       if (Math.random() < 0.2) {
                                          if (entity.getPersistentData().getDouble("reach_action") == 1.0) {
                                             if (world instanceof ServerLevel) {
                                                ServerLevel _level = (ServerLevel)world;
                                                _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity_a.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range * 0.5 - 4.0), y_pos + (Math.random() - 0.5) * 5.0, entity_a.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range * 0.5 - 4.0), 1, 0.1, 0.1, 0.1, 0.0);
                                             }
                                          } else if (entity.getPersistentData().getDouble("reach_action") == 2.0 && world instanceof ServerLevel) {
                                             ServerLevel _level = (ServerLevel)world;
                                             _level.sendParticles(ParticleTypes.HAPPY_VILLAGER, entity_a.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range * 0.5 - 4.0), y_pos + (Math.random() - 0.5) * 5.0, entity_a.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range * 0.5 - 4.0), 1, 0.1, 0.1, 0.1, 0.0);
                                          }
                                       }

                                       num1 += Math.toRadians(10.0 * Math.random());
                                    }
                                 }

                                 if (entity.getPersistentData().getDouble("cnt1") >= 60.0 / speed) {
                                    decide = true;
                                 }
                              }
                           }
                        }
                     }

                     if (decide) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.END_ROD, x_pos, y_pos, z_pos, 25, 1.0, 2.0, 1.0, 0.05);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 25, 1.0, 2.0, 1.0, 0.05);
                        }

                        int var143;
                        if (entity instanceof SlotEntity) {
                           SlotEntity _datEntI = (SlotEntity)entity;
                           var143 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
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
                              _datEntSetI.getEntityData().set(SlotEntity.DATA_SLOT_NUM, (int)num1);
                           }
                        } else {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var143 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var143 = 0;
                           }

                           if (var143 == 2) {
                              label618: {
                                 if (entity_1 instanceof SlotEntity) {
                                    if (entity_1 instanceof SlotEntity) {
                                       SlotEntity _datEntI = (SlotEntity)entity_1;
                                       var143 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                    } else {
                                       var143 = 0;
                                    }

                                    if (var143 > 0) {
                                       float var146;
                                       if (entity_1 instanceof SlotEntity) {
                                          SlotEntity _datEntI = (SlotEntity)entity_1;
                                          var146 = (float)(Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                       } else {
                                          var146 = 0.0F;
                                       }

                                       animation = "slot" + Math.round(var146);
                                       if (entity instanceof SlotEntity) {
                                          SlotEntity _datEntSetI = (SlotEntity)entity;
                                          SynchedEntityData var147 = _datEntSetI.getEntityData();
                                          EntityDataAccessor var10001 = SlotEntity.DATA_SLOT_NUM;
                                          int var10002;
                                          if (entity_1 instanceof SlotEntity) {
                                             SlotEntity _datEntI = (SlotEntity)entity_1;
                                             var10002 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                          } else {
                                             var10002 = 0;
                                          }

                                          var147.set(var10001, var10002);
                                       }
                                       break label618;
                                    }
                                 }

                                 num1 = Math.ceil(Math.random() * 7.0);
                                 animation = "slot" + Math.round(num1);
                                 if (entity instanceof SlotEntity) {
                                    SlotEntity _datEntSetI = (SlotEntity)entity;
                                    _datEntSetI.getEntityData().set(SlotEntity.DATA_SLOT_NUM, (int)num1);
                                 }
                              }

                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var143 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var143 = 0;
                              }

                              int var168;
                              if (entity_1 instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity_1;
                                 var168 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var168 = 0;
                              }

                              if (var143 == var168) {
                                 Vec3 _center = new Vec3(entity_a.getPersistentData().getDouble("x_pos_doma"), entity_a.getPersistentData().getDouble("y_pos_doma"), entity_a.getPersistentData().getDouble("z_pos_doma"));

                                 for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s actionbar {\"text\":\"REACH\",\"color\":\"light_purple\",\"bold\":true}");
                                    }
                                 }

                                 if (Math.random() < 0.3) {
                                    entity_3.getPersistentData().putDouble("reach_action", 1.0);
                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ(), 50, 2.0, 2.0, 2.0, 1.0);
                                    }
                                 } else {
                                    entity_3.getPersistentData().putDouble("reach_action", 2.0);
                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                       } else {
                                          _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.sendParticles(ParticleTypes.HAPPY_VILLAGER, entity_3.getX(), entity_3.getY() + (double)entity_3.getBbHeight() * 0.5, entity_3.getZ(), 50, 2.0, 2.0, 2.0, 1.0);
                                    }
                                 }
                              }
                           } else {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var143 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                              } else {
                                 var143 = 0;
                              }

                              if (var143 == 3) {
                                 if (entity_1 instanceof SlotEntity) {
                                    float var150;
                                    if (entity_1 instanceof SlotEntity) {
                                       SlotEntity _datEntI = (SlotEntity)entity_1;
                                       var150 = (float)(Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                    } else {
                                       var150 = 0.0F;
                                    }

                                    num2 = (double)Math.round(var150);
                                 }

                                 label654: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                          var143 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
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
                                          if (_livEnt.hasEffect(MobEffects.LUCK)) {
                                             var143 = _livEnt.getEffect(MobEffects.LUCK).getAmplifier();
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
                                                if (_livEnt101.hasEffect(MobEffects.LUCK)) {
                                                   label636: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.hasEffect(MobEffects.LUCK)) {
                                                            var169 = _livEnt.getEffect(MobEffects.LUCK).getAmplifier();
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
                                             if (!_livEnt103.hasEffect(MobEffects.LUCK)) {
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
                                    _datEntSetI.getEntityData().set(SlotEntity.DATA_SLOT_NUM, (int)num1);
                                 }
                              }
                           }
                        }

                        if (entity instanceof SlotEntity) {
                           PlayAnimationEntity2Procedure.execute(entity, animation);
                        }
                     }

                     int var153;
                     if (entity instanceof SlotEntity) {
                        SlotEntity _datEntI = (SlotEntity)entity;
                        var153 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                     } else {
                        var153 = 0;
                     }

                     if (var153 == 3 && entity.getPersistentData().getDouble("cnt1") == 80.0 / speed) {
                        num1 = 0.0;
                        SUCCESS = false;
                        if (entity_1 instanceof SlotEntity) {
                           double var154;
                           if (entity_1 instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity_1;
                              var154 = (double)(Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
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
                                 var171 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
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
                                 var172 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
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
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:hakari1")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                              } else {
                                 _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:hakari1")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                              }
                           }

                           entity_1.getPersistentData().putDouble("cnt2", 1.0);
                           entity_2.getPersistentData().putDouble("cnt2", 1.0);
                           entity_3.getPersistentData().putDouble("cnt2", 1.0);
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
                        entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.END_ROD, x_pos, y_pos, z_pos, 10, 1.0, 1.0, 1.0, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 1, 1.0, 1.0, 1.0, 0.5);
                        }

                        if (entity instanceof SlotEntity) {
                           SlotEntity _datEntI = (SlotEntity)entity;
                           var153 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                        } else {
                           var153 = 0;
                        }

                        if (var153 == 3 && entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           if (!_entity.level().isClientSide()) {
                              MobEffectInstance var173;
                              MobEffect var10003;
                              int var10005;
                              label549: {
                                 var10003 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity_a;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var10005 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                       break label549;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var173 = new MobEffectInstance(var10003, 1200, var10005, true, true);
                              _entity.addEffect(var173);
                           }
                        }

                        if (Math.random() < 0.05) {
                           range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
                           num1 = Math.toRadians(Math.random() * 360.0);
                           num2 = Math.random() * range - range / 2.0;
                           x_pos = entity_a.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
                           y_pos = entity_a.getPersistentData().getDouble("y_pos_doma") + 5.0;
                           z_pos = entity_a.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;
                           if (Math.random() < 0.25) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 Commands var156 = _level.getServer().getCommands();
                                 CommandSourceStack var174 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                                 double var183 = Math.random();
                                 var156.performPrefixedCommand(var174, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var183 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16711680],FadeColors:[I;16711680]}]}}}}");
                              }
                           } else if (Math.random() < 0.25) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 Commands var157 = _level.getServer().getCommands();
                                 CommandSourceStack var175 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                                 double var184 = Math.random();
                                 var157.performPrefixedCommand(var175, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var184 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16774912],FadeColors:[I;16774912]}]}}}}");
                              }
                           } else if (Math.random() < 0.25) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 Commands var158 = _level.getServer().getCommands();
                                 CommandSourceStack var176 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                                 double var185 = Math.random();
                                 var158.performPrefixedCommand(var176, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var185 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;43775],FadeColors:[I;43775]}]}}}}");
                              }
                           } else if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              Commands var159 = _level.getServer().getCommands();
                              CommandSourceStack var177 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                              double var186 = Math.random();
                              var159.performPrefixedCommand(var177, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var186 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;65442],FadeColors:[I;65442]}]}}}}");
                           }
                        }

                        if (entity.getPersistentData().getDouble("cnt2") >= 50.0) {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var153 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var153 = 0;
                           }

                           if (var153 == 3) {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var153 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                              } else {
                                 var153 = 0;
                              }

                              if (var153 % 2 == 1) {
                                 entity_a.getPersistentData().putDouble("mode_hakari", 2.0);
                              } else if (Math.random() < 0.5) {
                                 entity_a.getPersistentData().putDouble("mode_hakari", 1.0);
                              } else {
                                 entity_a.getPersistentData().putDouble("mode_hakari", 40.0);
                              }

                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity_a;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.JACKPOT.get(), 1800, 0, true, true));
                                 }
                              }

                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity_a;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                              }
                           }

                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }

                           return;
                        }
                     } else if (entity.getPersistentData().getDouble("cnt1") >= Math.max(80.0 / speed, 50.0)) {
                        label598: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                 var153 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                 break label598;
                              }
                           }

                           var153 = 0;
                        }

                        if (var153 >= 9 && Math.random() > 0.0) {
                           if (entity.getPersistentData().getDouble("cnt1") >= Math.max(100.0 / speed, 50.0)) {
                              if (entity instanceof SlotEntity) {
                                 SlotEntity _datEntI = (SlotEntity)entity;
                                 var153 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                              } else {
                                 var153 = 0;
                              }

                              if (var153 == 3 && entity_a.isAlive()) {
                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5, entity_a.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                       _level.playLocalSound(entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5, entity_a.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5, entity_a.getZ(), 50, 2.0, 2.0, 2.0, 0.25);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5, entity_a.getZ(), 50, 1.0, 1.0, 1.0, 0.25);
                                 }

                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity_a;
                                    float var178;
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       var178 = _livEnt.getHealth();
                                    } else {
                                       var178 = -1.0F;
                                    }

                                    double var179 = (double)var178;
                                    float var187;
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       var187 = _livEnt.getMaxHealth();
                                    } else {
                                       var187 = -1.0F;
                                    }

                                    _entity.setHealth((float)(var179 + (double)var187 * 0.5));
                                 }
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x_pos, y_pos, z_pos, 20, 1.0, 2.0, 1.0, 0.25);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x_pos, y_pos, z_pos, 40, 1.0, 2.0, 1.0, 0.25);
                              }

                              x_pos = entity.getX();
                              y_pos = entity.getY();
                              z_pos = entity.getZ();
                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                 } else {
                                    _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                 } else {
                                    _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                 }
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _serverLevel = (ServerLevel)world;
                                 Entity entityinstance = ((EntityType)JujutsucraftModEntities.SLOT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                                 if (entityinstance != null) {
                                    entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                                    if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                                       entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                                    }

                                    entityinstance.setYRot(entity.getYRot());
                                    entityinstance.setXRot(0.0F);
                                    entityinstance.setYBodyRot(entityinstance.getYRot());
                                    entityinstance.setYHeadRot(entityinstance.getYRot());
                                    entityinstance.yRotO = entityinstance.getYRot();
                                    entityinstance.xRotO = entityinstance.getXRot();
                                    if (entityinstance instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityinstance;
                                       _entity.yBodyRotO = _entity.getYRot();
                                       _entity.yHeadRotO = _entity.getYRot();
                                    }

                                    entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged_ranged"));
                                    entityinstance.getPersistentData().putDouble("cnt1", -20.0);
                                    entityinstance.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                                    if (entityinstance instanceof SlotEntity) {
                                       SlotEntity _datEntSetI = (SlotEntity)entityinstance;
                                       SynchedEntityData var165 = _datEntSetI.getEntityData();
                                       EntityDataAccessor var180 = SlotEntity.DATA_SLOT_MODE;
                                       int var188;
                                       if (entity instanceof SlotEntity) {
                                          SlotEntity _datEntI = (SlotEntity)entity;
                                          var188 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                       } else {
                                          var188 = 0;
                                       }

                                       var165.set(var180, var188);
                                    }

                                    CompoundTag var166 = entity_a.getPersistentData();
                                    float var181;
                                    if (entity instanceof SlotEntity) {
                                       SlotEntity _datEntI = (SlotEntity)entity;
                                       var181 = (float)(Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                    } else {
                                       var181 = 0.0F;
                                    }
                                    int var167;
                                    MobEffectInstance var182;
                                    label573: {
                                       var166.putString("SLOT" + Math.round(var181), entityinstance.getStringUUID());
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                             var167 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                             break label573;
                                          }
                                       }

                                       var167 = 0;
                                    }

                                    if (var167 > 9) {
                                       if (entityinstance instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityinstance;
                                          if (!_entity.level().isClientSide()) {
                                             MobEffect var189;
                                             int var190;
                                             label564: {
                                                var189 = MobEffects.UNLUCK;
                                                if (entity instanceof LivingEntity) {
                                                   LivingEntity _livEnt = (LivingEntity)entity;
                                                   if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                                      var190 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                                      break label564;
                                                   }
                                                }

                                                var190 = 0;
                                             }

                                             var182 = new MobEffectInstance(var189, 2147483647, var190 - 1, false, false);
                                             _entity.addEffect(var182);
                                          }
                                       }
                                    } else if (entityinstance instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityinstance;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 2147483647, 29, false, false));
                                       }
                                    }

                                    _serverLevel.addFreshEntity(entityinstance);
                                 }
                              }

                              if (!entity.level().isClientSide()) {
                                 entity.discard();
                              }

                              return;
                           }
                        } else {
                           if (entity instanceof SlotEntity) {
                              SlotEntity _datEntI = (SlotEntity)entity;
                              var153 = (Integer)_datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                           } else {
                              var153 = 0;
                           }

                           if (var153 == 3 && entity_a.getPersistentData().getDouble("mode_hakari") > 10.0) {
                              entity_a.getPersistentData().putDouble("mode_hakari", entity_a.getPersistentData().getDouble("mode_hakari") - 1.0);
                              if (entity_a.getPersistentData().getDouble("mode_hakari") <= 10.0) {
                                 entity_a.getPersistentData().putDouble("mode_hakari", 0.0);
                              }
                           }

                           if (!entity.level().isClientSide()) {
                              entity.discard();
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

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
