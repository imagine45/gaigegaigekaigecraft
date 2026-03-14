package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi9Procedure {
   public TechniqueOgi9Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean power = false;
         boolean mode_speed = false;
         boolean type = false;
         boolean logic_attack = false;
         boolean oni = false;
         boolean logic_b = false;
         boolean FoxFire = false;
         double dis = 0.0;
         double rad = 0.0;
         double tsuki7_mode = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos2 = 0.0;
         double y_pos2 = 0.0;
         double z_pos2 = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double x_center = 0.0;
         double y_center = 0.0;
         double z_center = 0.0;
         double y_fix = 0.0;
         double y_power = 0.0;
         double z_pwoer = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         double start_time = 0.0;
         double CNT6 = 0.0;
         double z_power = 0.0;
         double range = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < 40.0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 19, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 20.0) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "stopsound @s");
               }

               if (entity.getPersistentData().m_128459_("cnt1") <= 25.0) {
                  if (entity.getPersistentData().m_128459_("cnt1") == 21.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 60, 0, true, true));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity12 = (LivingEntity)entity;
                        if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity12.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-16.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity13 = (LivingEntity)entity;
                        if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity13.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  for(int index0 = 0; index0 < 2; ++index0) {
                     ParticleGeneratorCircleProcedure.execute(world, 9.0, 90.0, 8.0, 0.0, 1.0, entity.m_20185_(), entity.m_20185_(), entity.m_20186_() + Math.random(), entity.m_20186_(), 0.0, entity.m_20189_(), entity.m_20189_(), "minecraft:flame");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 38.0) {
                  if (OnGroundProcedure.execute(world, entity)) {
                     entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 39.0));
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 1.0);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 1.0);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 1.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 38.0));
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(2.0 * range), 0.25 * range, 0.1 * range, 0.25 * range, 0.25);
               }

               if (entity.getPersistentData().m_128459_("cnt1") == 1.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               for(int index1 = 0; index1 < 2; ++index1) {
                  ParticleGeneratorCircleProcedure.execute(world, 9.0, 90.0, 0.0, 16.0, 1.0, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random(), 0.0, entity.m_20189_(), entity.m_20189_(), "minecraft:flame");
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= 19.0) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                     if (GetDistanceProcedure.execute(entity) > 12.0) {
                        label332: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                              label324: {
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
                                       break label324;
                                    }
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                    break label332;
                                 }
                              }
                           }

                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                        entity.getPersistentData().m_128379_("PRESS_Z", false);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") < 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", 5.0);
                     if (entity.getPersistentData().m_128459_("cnt7") == 0.0) {
                        entity.getPersistentData().m_128347_("cnt7", 1.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123744_, x, y, z, 20, 0.5, 0.5, 0.5, 0.5);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                     ParticleGeneratorCircleProcedure.execute(world, 9.0, 90.0, 0.0, 16.0, 1.0, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random(), 0.0, entity.m_20189_(), entity.m_20189_(), "minecraft:cloud");
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 19.0));
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 19, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            if (entity.getPersistentData().m_128459_("cnt3") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity83 = (LivingEntity)entity;
                  if (_livingEntity83.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity83.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(101.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity84 = (LivingEntity)entity;
                  if (_livingEntity84.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity84.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               for(int index2 = 0; index2 < (int)(32.0 * range); ++index2) {
                  if (Math.random() < 0.75 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 0.2);
                  }

                  ++dis;
                  if (dis > 0.0) {
                     entity.getPersistentData().m_128347_("Damage", 40.0 * CNT6);
                     entity.getPersistentData().m_128347_("Range", 5.0 * range);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128347_("effect", 5.0);
                     entity.getPersistentData().m_128347_("projectile_type", 2.0);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                     ParticleGeneratorCircleProcedure.execute(world, 16.0, entity.getPersistentData().m_128459_("pitch"), 0.0, 16.0, 1.0, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_(), entity.getPersistentData().m_128459_("yaw"), entity.m_20189_(), entity.m_20189_(), "minecraft:flame");
                     dis = 5.0 * range * -0.5;
                  }

                  entity.m_6021_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_() - entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - entity.getPersistentData().m_128459_("x_power"), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_() - entity.getPersistentData().m_128459_("y_power"), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - entity.getPersistentData().m_128459_("y_power"), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power"), entity.m_146908_(), entity.m_146909_());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power"), entity.m_146908_(), entity.m_146909_());
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * range), 0.25 * range, 0.25 * range, 0.25 * range, 0.25);
            }

            if (entity.getPersistentData().m_128459_("cnt3") == 7.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity180 = (LivingEntity)entity;
                  if (_livingEntity180.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity180.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-16.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity181 = (LivingEntity)entity;
                  if (_livingEntity181.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity181.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt3") > 30.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
