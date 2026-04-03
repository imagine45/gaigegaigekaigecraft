package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DomainExpansionCreateBarrierProcedure {
   public DomainExpansionCreateBarrierProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         Entity target_entity = null;
         double x_dis = 0.0;
         double distance = 0.0;
         double z_dis = 0.0;
         double x_pos = 0.0;
         double domainRadius = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double loop_num = 0.0;
         double power = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double y_dis = 0.0;
         boolean old_failed = false;
         boolean reStart = false;
         boolean update_pos = false;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var49 = var10000;
         if (entity.getPersistentData().getDouble("cnt3") < 20.0) {
            entity.getPersistentData().putDouble("select", 0.0);
            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               ChangeCurseEnergyProcedure.execute(entity, entity.getPersistentData().getDouble("used_technique_cost"));
            }

            int var133;
            double var10002;
            CompoundTag var128;
            label278: {
               label463: {
                  var128 = entity.getPersistentData();
                  var10002 = entity.getPersistentData().getDouble("cnt3");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        break label463;
                     }
                  }

                  label272: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           var133 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                           break label272;
                        }
                     }

                     var133 = 0;
                  }

                  if (var133 <= 0) {
                     var133 = 1;
                     break label278;
                  }
               }

               var133 = 2;
            }

            var128.putDouble("cnt3", var10002 + (double)var133);
            if (entity instanceof Player) {
               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  power = (double)Math.round((20.0 - entity.getPersistentData().getDouble("cnt3")) * 0.25);
                  STR1 = Component.translatable("jujutsu.message.long_press").getString();

                  for(int index0 = 0; index0 < (int)power; ++index0) {
                     STR1 = "■" + STR1 + "■";
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(STR1), true);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt3") >= 20.0 && entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(""), true);
                     }
                  }
               } else {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(""), true);
                     }
                  }

                  entity.getPersistentData().putDouble("select", 0.0);
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
               }
            }
         } else {
            domainRadius = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.setDeltaMovement(new Vec3(0.0, Math.min(entity.getDeltaMovement().y(), 0.0), 0.0));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, 9, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
               entity.getPersistentData().putDouble("cnt7", 1.0);
               ChangeCurseEnergyProcedure.execute(entity, entity.getPersistentData().getDouble("used_technique_cost") * -1.0);
               if (entity instanceof Player && Math.random() < 0.01 && entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_open_barrier_type_domain"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }

               if (var49 instanceof LivingEntity) {
                  RotateEntityProcedure.execute(((Entity)var49).getX(), ((Entity)var49).getY() + (double)((Entity)var49).getBbHeight() * 0.5, ((Entity)var49).getZ(), entity);
               }

               label467: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt36 = (LivingEntity)entity;
                     if (_livEnt36.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label467;
                     }
                  }

                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  entity.setYRot(entity.getYRot());
                  entity.setXRot(0.0F);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity.getPersistentData().putDouble("x_pos_doma", (double)Math.round(entity.getX() + Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * domainRadius * 0.5));
                  entity.getPersistentData().putDouble("y_pos_doma", (double)Math.round(var49 instanceof LivingEntity ? Math.min(entity.getY(), ((Entity)var49).getY()) : entity.getY()));
                  entity.getPersistentData().putDouble("z_pos_doma", (double)Math.round(entity.getZ() + Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * domainRadius * 0.5));
                  entity.setYRot((float)yaw);
                  entity.setXRot((float)pitch);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }

               label433: {
                  label497: {
                     if (entity.getPersistentData().getDouble("select") == 1.0 || entity.getPersistentData().getDouble("select") == 18.0) {
                        if (!(entity instanceof Player)) {
                           if (entity instanceof KenjakuEntity) {
                              break label497;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt60 = (LivingEntity)entity;
                              if (_livEnt60.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label497;
                              }
                           }
                        } else {
                           label483: {
                              label470: {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr56 = (ServerPlayer)entity;
                                    if (_plr56.level() instanceof ServerLevel && _plr56.getAdvancements().getOrStartProgress(_plr56.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_open_barrier_type_domain"))).isDone()) {
                                       break label470;
                                    }
                                 }

                                 if (!(entity instanceof LivingEntity)) {
                                    break label483;
                                 }

                                 LivingEntity _livEnt57 = (LivingEntity)entity;
                                 if (!_livEnt57.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label483;
                                 }
                              }

                              if (!entity.isShiftKeyDown()) {
                                 break label497;
                              }
                           }
                        }
                     }

                     if (!(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
                        entity.getPersistentData().putDouble("cnt2", 0.0);
                        break label433;
                     }

                     entity.getPersistentData().putDouble("cnt2", -1.0);
                     break label433;
                  }

                  entity.getPersistentData().putDouble("cnt2", 1.0);
               }

               reStart = false;
               update_pos = false;
               entity.getPersistentData().putBoolean("Failed", false);
               entity.getPersistentData().putBoolean("Cover", false);

               for(int index1 = 0; index1 < 2; ++index1) {
                  entity.getPersistentData().putDouble("x_pos_doma2", (double)Math.round(entity.getX()));
                  entity.getPersistentData().putDouble("y_pos_doma2", (double)Math.round(entity.getY()));
                  entity.getPersistentData().putDouble("z_pos_doma2", (double)Math.round(entity.getZ()));
                  Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(domainRadius * 2.0 * 2.0 / 2.0), (e) -> true)) {
                     x_dis = entity.getX() - entityiterator.getX();
                     y_dis = entity.getY() - entityiterator.getY();
                     z_dis = entity.getZ() - entityiterator.getZ();
                     dis = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (dis < domainRadius * domainRadius) {
                        label474: {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)(domainRadius * 2.0 + 1.0), 9, false, false));
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt85 = (LivingEntity)entityiterator;
                              if (_livEnt85.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break label474;
                              }
                           }

                           if (entityiterator.getPersistentData().getDouble("select") == 0.0 && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), (int)(domainRadius * 2.0 + 20.0), (int)(entity.getPersistentData().getDouble("select") + 10.0), false, false));
                              }
                           }
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt89 = (LivingEntity)entity;
                        if (_livEnt89.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                           continue;
                        }
                     }

                     label389: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt90 = (LivingEntity)entityiterator;
                           if (_livEnt90.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              break label389;
                           }
                        }

                        if (entityiterator.getPersistentData().getDouble("select") == 0.0) {
                           continue;
                        }
                     }

                     x_dis = entity.getX() - entityiterator.getPersistentData().getDouble("x_pos_doma");
                     y_dis = entity.getY() - entityiterator.getPersistentData().getDouble("y_pos_doma");
                     z_dis = entity.getZ() - entityiterator.getPersistentData().getDouble("z_pos_doma");
                     dis = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (dis < (domainRadius - 1.0) * (domainRadius - 1.0)) {
                        if (entity != entityiterator) {
                           int var130;
                           label370: {
                              label369: {
                                 label476: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt99 = (LivingEntity)entityiterator;
                                       if (_livEnt99.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          label363: {
                                             if (entityiterator instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   var130 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                   break label363;
                                                }
                                             }

                                             var130 = 0;
                                          }

                                          if (var130 <= 0) {
                                             break label369;
                                          }
                                          break label476;
                                       }
                                    }

                                    if (entityiterator.getPersistentData().getDouble("select") == 0.0 || !(entityiterator.getPersistentData().getDouble("cnt2") > 0.0)) {
                                       break label369;
                                    }
                                 }

                                 if (!update_pos) {
                                    entityiterator.getPersistentData().putDouble("x_pos_doma", entity.getPersistentData().getDouble("x_pos_doma"));
                                    entityiterator.getPersistentData().putDouble("y_pos_doma", entity.getPersistentData().getDouble("y_pos_doma"));
                                    entityiterator.getPersistentData().putDouble("z_pos_doma", entity.getPersistentData().getDouble("z_pos_doma"));
                                    update_pos = true;
                                    break label370;
                                 }
                              }

                              entity.getPersistentData().putDouble("x_pos_doma", entityiterator.getPersistentData().getDouble("x_pos_doma"));
                              entity.getPersistentData().putDouble("y_pos_doma", entityiterator.getPersistentData().getDouble("y_pos_doma"));
                              entity.getPersistentData().putDouble("z_pos_doma", entityiterator.getPersistentData().getDouble("z_pos_doma"));
                              update_pos = true;
                           }
                        }

                        if (entity != entityiterator) {
                           entity.getPersistentData().putBoolean("Failed", true);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt117 = (LivingEntity)entityiterator;
                              if (_livEnt117.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 int var131;
                                 label347: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var131 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                          break label347;
                                       }
                                    }

                                    var131 = 0;
                                 }

                                 if (var131 == 0) {
                                    entity.getPersistentData().putDouble("cnt5", 1.0);
                                 }
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt120 = (LivingEntity)entityiterator;
                              if (_livEnt120.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entityiterator.getPersistentData().getBoolean("Cover")) {
                                 entityiterator.getPersistentData().putBoolean("Failed", true);
                              }
                           }
                        }
                     } else if (dis < domainRadius * 2.0 * domainRadius * 2.0 && !reStart && entity != entityiterator) {
                        int var129;
                        label477: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt124 = (LivingEntity)entityiterator;
                              if (_livEnt124.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label376: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var129 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                          break label376;
                                       }
                                    }

                                    var129 = 0;
                                 }

                                 if (var129 != 0) {
                                    continue;
                                 }
                                 break label477;
                              }
                           }

                           if (entityiterator.getPersistentData().getDouble("select") == 0.0 || !(entityiterator.getPersistentData().getDouble("cnt2") <= 0.0)) {
                              continue;
                           }
                        }

                        reStart = true;
                        x_pos = entityiterator.getPersistentData().getDouble("x_pos_doma");
                        y_pos = entityiterator.getPersistentData().getDouble("y_pos_doma");
                        z_pos = entityiterator.getPersistentData().getDouble("z_pos_doma");
                     }
                  }

                  if (!reStart || entity.getPersistentData().getBoolean("Failed") || update_pos) {
                     break;
                  }

                  entity.teleportTo(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                  }

                  entity.getPersistentData().putDouble("x_pos_doma", x_pos);
                  entity.getPersistentData().putDouble("y_pos_doma", y_pos);
                  entity.getPersistentData().putDouble("z_pos_doma", z_pos);
                  update_pos = true;
               }

               Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(10.0), (e) -> true)) {
                  if (entity != entityiterator && !entityiterator.isInvulnerable()) {
                     x_dis = entityiterator.getX() - entity.getX();
                     y_dis = entityiterator.getY() - entity.getY();
                     z_dis = entityiterator.getZ() - entity.getZ();
                     dis = x_dis * x_dis + z_dis * z_dis;
                     if (dis > 0.0 && dis < 100.0) {
                        x_dis /= dis;
                        double var132 = y_dis / dis;
                        z_dis /= dis;
                        x_pos = entityiterator.getX();
                        y_pos = entityiterator.getY();
                        z_pos = entityiterator.getZ();
                        loop_num = Math.ceil(10.0 - dis);

                        for(int index2 = 0; index2 < (int)Math.round(loop_num); ++index2) {
                           dis = (x_pos - entity.getPersistentData().getDouble("x_pos_doma")) * (x_pos - entity.getPersistentData().getDouble("x_pos_doma")) + (y_pos - entity.getPersistentData().getDouble("y_pos_doma")) * (y_pos - entity.getPersistentData().getDouble("y_pos_doma")) + (z_pos - entity.getPersistentData().getDouble("z_pos_doma")) * (z_pos - entity.getPersistentData().getDouble("z_pos_doma"));
                           if (dis > (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 3.0) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 3.0)) {
                              break;
                           }

                           x_pos += x_dis;
                           z_pos += z_dis;
                           if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                              ++y_pos;
                           }
                        }

                        entityiterator.teleportTo(x_pos, y_pos, z_pos);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityiterator.getYRot(), entityiterator.getXRot());
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt160 = (LivingEntity)entity;
               if (_livEnt160.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                  if (entity.getPersistentData().getDouble("cnt1") >= 5.0) {
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     pitch = Math.toRadians((double)entity.getXRot());
                     distance = 0.5 * (double)entity.getBbWidth();
                     x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
                     z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(2.0 + distance), 0.1 * distance, 0.1 * distance, 0.1 * distance, 0.1);
                     }

                     if (entity.getPersistentData().getDouble("cnt1") >= 20.0) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, (float)(0.5 * (1.0 + distance)), 1.1F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, (float)(0.5 * (1.0 + distance)), 1.1F, false);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get(), 6000, 2, false, false));
                           }
                        }

                        entity.getPersistentData().putDouble("select", 0.0);
                        entity.getPersistentData().putDouble("skill", 0.0);
                        return;
                     }
                  }

                  return;
               }
            }

            if (entity.getPersistentData().getBoolean("Failed") && entity.getPersistentData().getDouble("cnt5") > 0.0) {
               if (entity.getPersistentData().getDouble("cnt1") > 1.0) {
                  entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") < 34.0 ? 34.0 : Math.max(50.0, domainRadius * 2.0) + 5.0);
               }
            } else {
               old_failed = entity.getPersistentData().getBoolean("Failed");
               entity.getPersistentData().putBoolean("Failed", false);
               x_pos = entity.getPersistentData().getDouble("x_pos_doma");
               y_pos = entity.getPersistentData().getDouble("y_pos_doma");
               z_pos = entity.getPersistentData().getDouble("z_pos_doma");
               entity.getPersistentData().putDouble("cnt_cover", entity.getPersistentData().getDouble("cnt1"));
               DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putBoolean("Failed", old_failed);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= Math.max(34.0, domainRadius * 2.0 + 1.0)) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 200.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               entity.getPersistentData().putBoolean("StartDomainAttack", true);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), entity.getPersistentData().getDouble("select") == 29.0 ? 3600 : 1200, (int)entity.getPersistentData().getDouble("cnt2"), true, false));
                  }
               }

               entity.getPersistentData().putDouble("skill", 0.0);
               boolean _boolsetval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _boolsetval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
