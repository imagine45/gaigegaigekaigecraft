package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KusakabeAtsuyaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueIaiYudukiProcedure {
   public TechniqueIaiYudukiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6 = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double level_newShadowStyle = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof Player) {
            label347: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr4 = (ServerPlayer)entity;
                  if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_4"))).isDone()) {
                     level_newShadowStyle = 4.0;
                     break label347;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr5 = (ServerPlayer)entity;
                  if (_plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_3"))).isDone()) {
                     level_newShadowStyle = 3.0;
                     break label347;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr6 = (ServerPlayer)entity;
                  if (_plr6.level() instanceof ServerLevel && _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_2"))).isDone()) {
                     level_newShadowStyle = 2.0;
                     break label347;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr7 = (ServerPlayer)entity;
                  if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_1"))).isDone()) {
                     level_newShadowStyle = 1.0;
                     break label347;
                  }
               }

               level_newShadowStyle = 1.0;
            }
         } else if (entity instanceof KusakabeAtsuyaEntity) {
            level_newShadowStyle = 4.0;
         } else {
            level_newShadowStyle = 1.0;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 19, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity16.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-16.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity17 = (LivingEntity)entity;
                  if (_livingEntity17.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity17.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 19.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 12.0) {
                     label361: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label351: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                    break label351;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label361;
                              }
                           }
                        }

                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 19.0));
            }

            num1 = entity.getPersistentData().getDouble("cnt8") - 1.0;
            if (!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().getDouble("cnt8") <= 20.0)) {
               num1 = Math.max((num1 - 40.0) * 50.0, 1.0);
               num1 = Math.min(160.0 + num1, 640.0);
            } else {
               num1 = Math.max(num1 * 50.0, 1.0);
               num1 = Math.min(num1, 160.0);
            }

            for(int index0 = 0; index0 < 5; ++index0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)num1, 1, true, true));
                  }
               }

               num1 += 10.0;
               if (num1 > (double)(!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().getDouble("cnt8") <= 40.0) ? 160 : 640)) {
                  break;
               }
            }

            double var71;
            int var10002;
            label274: {
               var71 = (double)entity.getBbWidth();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                     break label274;
                  }
               }

               var10002 = 0;
            }

            dis = Math.min(var71 + 0.025 * (double)var10002, level_newShadowStyle >= 4.0 ? 16.0 : 4.0);
            if (entity.getPersistentData().getDouble("cnt8") > 100.0) {
               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 20.0));
            } else {
               entity.getPersistentData().putString("TARGET", "");
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis * 2.0 / 2.0), (e) -> true)) {
                  if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && entity.getY() + (double)entity.getBbHeight() >= entityiterator.getY() && entity.getY() <= entityiterator.getY() + (double)entityiterator.getBbHeight() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     RotateEntityProcedure.execute(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), entity);
                     entity.getPersistentData().putString("TARGET1", entityiterator.getStringUUID());
                     entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 20.0));
                     break;
                  }
               }
            }

            entity.getPersistentData().putDouble("Damage", 15.0);
            entity.getPersistentData().putDouble("Range", 1.5);
            entity.getPersistentData().putDouble("effect", 5.0);
            entity.getPersistentData().putDouble("projectile_type", 1.0);
            entity.getPersistentData().putBoolean("swing", true);
            DamageFixProcedure.execute(entity);
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.0);
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 19, false, false));
               }
            }

            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity.getPersistentData().getDouble("cnt3") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity81 = (LivingEntity)entity;
                  if (_livingEntity81.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity81.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(101.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity82 = (LivingEntity)entity;
                  if (_livingEntity82.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity82.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(10.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               for(int index1 = 0; index1 < (int)(16.0 * range); ++index1) {
                  if (Math.random() < 0.75 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(1.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 0.2);
                  }

                  ++dis;
                  if (dis > 0.0) {
                     entity.getPersistentData().putDouble("Damage", 24.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 5.0 * range);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putDouble("projectile_type", 2.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                     dis = 5.0 * range * -0.5;
                  }

                  entity.teleportTo(entity.getX() + entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX() + entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.teleportTo(entity.getX() - entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() - entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }

                  entity.teleportTo(entity.getX(), entity.getY() + entity.getPersistentData().getDouble("y_power"), entity.getZ());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + entity.getPersistentData().getDouble("y_power"), entity.getZ(), entity.getYRot(), entity.getXRot());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.teleportTo(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("y_power"), entity.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("y_power"), entity.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }

                  entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() + entity.getPersistentData().getDouble("z_power"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() + entity.getPersistentData().getDouble("z_power"), entity.getYRot(), entity.getXRot());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() - entity.getPersistentData().getDouble("z_power"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() - entity.getPersistentData().getDouble("z_power"), entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(10.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt3") == 7.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity153 = (LivingEntity)entity;
                  if (_livingEntity153.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity153.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-16.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity154 = (LivingEntity)entity;
                  if (_livingEntity154.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity154.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt3") > 20.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
