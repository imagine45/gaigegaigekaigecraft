package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi4Procedure {
   public TechniqueOgi4Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         boolean type = false;
         boolean logic_a = false;
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
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") <= 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 5, false, false));
               }
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            if (entity.getPersistentData().m_128459_("cnt1") <= 1.0) {
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
                     label212: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           label213: {
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
                                    break label213;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                 break label212;
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
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 0.0));
            }

            if (entity.getPersistentData().m_128459_("cnt1") == 0.0) {
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
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.5);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, x_pos, entity.m_20186_(), z_pos, 5, 0.25, 0.1, 0.25, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, entity.m_20186_(), z_pos, 2, 0.25, 0.1, 0.25, 0.5);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x_pos, entity.m_20186_(), z_pos, 5, 0.25, 0.25, 0.25, CNT6 * 0.1);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= 1.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().m_128347_("cnt4", (double)(entity.m_146908_() + 45.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt1") % 5.0 == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity52 = (LivingEntity)entity;
                  if (_livingEntity52.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity52.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-8.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity53 = (LivingEntity)entity;
                  if (_livingEntity53.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity53.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(1.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") < 22.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               for(int index0 = 0; index0 < 6; ++index0) {
                  type = !type;
                  entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + Math.random() * 20.0);
                  rad = Math.toRadians(entity.getPersistentData().m_128459_("cnt4"));

                  for(int index1 = 0; index1 < 2; ++index1) {
                     y_pos = y + entity.getPersistentData().m_128459_("cnt1") * 0.14 + 0.4;
                     if (type) {
                        dis = Math.min(2.0, entity.getPersistentData().m_128459_("cnt1") * 0.25) * CNT6;
                        x_pos = x + Math.cos(rad) * dis;
                        z_pos = z + Math.sin(rad) * dis;
                        ParticleGeneratorProcedure.execute(world, range * 0.25, 4.0 * range, 5.0, 0.5 * CNT6, x + Math.cos(rad), x + Math.cos(rad) * 4.0, y_pos, y_pos, z + Math.sin(rad), z + Math.sin(rad) * 4.0, "minecraft:flame");
                     } else {
                        dis = Math.min(4.0, entity.getPersistentData().m_128459_("cnt1") * 0.33) * CNT6;
                        x_pos = x + Math.sin(rad) * dis;
                        z_pos = z + Math.cos(rad) * dis;
                        ParticleGeneratorProcedure.execute(world, range * 0.25, 4.0 * range, 5.0, 0.5 * CNT6, x + Math.sin(rad), x + Math.sin(rad) * 4.0, y_pos, y_pos, z + Math.cos(rad), z + Math.cos(rad) * 4.0, "minecraft:flame");
                     }

                     entity.getPersistentData().m_128347_("Damage", 17.0 * CNT6);
                     entity.getPersistentData().m_128347_("Range", 3.0);
                     entity.getPersistentData().m_128347_("effect", 5.0);
                     entity.getPersistentData().m_128347_("knockback", 1.0 * CNT6);
                     entity.getPersistentData().m_128347_("projectile_type", 2.0);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        CompoundTag var90;
                        int var10003;
                        label166: {
                           var90 = entity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label166;
                              }
                           }

                           var10003 = 0;
                        }

                        var90.m_128347_("BlockDamage", (0.25 + (double)var10003 * 0.5) * CNT6);
                        entity.getPersistentData().m_128347_("BlockRange", 2.0);
                        entity.getPersistentData().m_128379_("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 15, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 4, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                           }
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 26.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
