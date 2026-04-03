package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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

public class TechniqueSmallpoxDeityBreathProcedure {
   public TechniqueSmallpoxDeityBreathProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double Damage = 0.0;
         double Effect = 0.0;
         double Knockback = 0.0;
         double CNT6 = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double range = 0.0;
         double strength = 0.0;
         double old_skill = 0.0;
         double loop_num = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(1.0F + entity.getBbWidth());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt2") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity9 = (LivingEntity)entity;
               if (_livingEntity9.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity9.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-19.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity10 = (LivingEntity)entity;
               if (_livingEntity10.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity10.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceProcedure.execute(entity) > 8.0) {
                  label161: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label162: {
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
                                 break label162;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label161;
                           }
                        }
                     }

                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt2", Math.min(entity.getPersistentData().getDouble("cnt2"), 8.0));
               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }

                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               ChargeParticleProcedure.execute(world, entity, 10.0);
            } else {
               ChargeParticleProcedure.execute(world, entity, 0.0);
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity46 = (LivingEntity)entity;
                  if (_livingEntity46.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity46.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-19.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity47 = (LivingEntity)entity;
                  if (_livingEntity47.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity47.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, (float)(2.0 * range * CNT6), 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, (float)(2.0 * range * CNT6), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, (float)(2.0 * range * CNT6), 0.9F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, (float)(2.0 * range * CNT6), 0.9F, false);
                  }
               }
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            x_power = entity.getPersistentData().getDouble("x_power");
            y_power = entity.getPersistentData().getDouble("y_power");
            z_power = entity.getPersistentData().getDouble("z_power");
            rad_now = Math.toRadians(entity.getPersistentData().getDouble("yaw") + 90.0);
            loop_num = 0.0;
            dis = 3.0;
            logic_a = false;

            for(int index0 = 0; index0 < (int)(20.0 * CNT6); ++index0) {
               dis += 0.15;
               entity.getPersistentData().putDouble("Damage", (13.0 + entity.getPersistentData().getDouble("cnt1") * 0.05) * CNT6);
               entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * Math.pow(0.985, loop_num));
               entity.getPersistentData().putDouble("Range", dis * range * CNT6);
               entity.getPersistentData().putDouble("knockback", 0.5);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.WHITE_ASH, x_pos, y_pos, z_pos, (int)Math.ceil(dis * 0.25), dis * 0.25, dis * 0.25, dis * 0.25, 0.25);
               }

               x_pos += x_power * 0.33;
               y_pos += y_power * 0.33;
               z_pos += z_power * 0.33;
               ++loop_num;
            }

            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = 0.5 * (double)entity.getBbWidth();
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            ParticleGeneratorProcedure.execute(world, range * 0.5, 12.0 * range * CNT6, 45.0, 1.0 * CNT6, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "minecraft:cloud");
            if (entity.getPersistentData().getDouble("cnt1") > 16.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
