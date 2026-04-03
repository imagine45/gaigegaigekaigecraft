package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi2Procedure {
   public TechniqueOgi2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         boolean hitBlock = false;
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
         double CNT6 = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double distance = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + entity.getPersistentData().getDouble("cnt10"));
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4, 3, false, false));
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
               if (GetDistanceProcedure.execute(entity) > 2.0 && GetDistanceProcedure.execute(entity) < 5.0) {
                  label232: {
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

                        if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                           break label232;
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
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 0.0));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
               entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            } else {
               entity.getPersistentData().putDouble("cnt6", 5.0);
               if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                  entity.getPersistentData().putDouble("cnt7", 1.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.5);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.getY(), z_pos, 5, 0.25, 0.1, 0.25, 0.5);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x_pos, entity.getY(), z_pos, 2, 0.25, 0.1, 0.25, 0.5);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 5, 0.25, 0.1, 0.25, CNT6 * 0.1);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 1.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               entity.getPersistentData().putDouble("cnt2", (double)(entity.getXRot() + 90.0F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 10, 0.25, 0.1, 0.25, 0.5);
               }

               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               entity.setYRot(entity.getYRot());
               entity.setXRot(Math.min(entity.getXRot(), -45.0F));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 2.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 2.0);
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power")));
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

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 2.5) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity71 = (LivingEntity)entity;
                  if (_livingEntity71.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity71.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(101.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") <= 8.0) {
               entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power"));
               entity.getPersistentData().putDouble("y_knockback", Math.max(1.0 * CNT6, entity.getPersistentData().getDouble("y_power")));
               entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power"));

               for(int index0 = 0; index0 < 8; ++index0) {
                  dis = 1.5;
                  rad = Math.toRadians(entity.getPersistentData().getDouble("cnt2"));
                  rad_now = Math.toRadians((double)(entity.getYRot() + 90.0F));

                  for(int index1 = 0; index1 < (int)(3.0 * range); ++index1) {
                     for(int index2 = 0; index2 < 2; ++index2) {
                        x_pos = entity.getX() + Math.cos(rad) * Math.cos(rad_now) * dis;
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(rad) * -1.0 * dis;
                        z_pos = entity.getZ() + Math.cos(rad) * Math.sin(rad_now) * dis;
                        ParticleGeneratorProcedure.execute(world, range * 0.1, 1.0 * range, 10.0, 4.0, x_pos, x_pos + 0.0, y_pos, y_pos + 1.0, z_pos, z_pos + 0.0, "gaigegaigekaigecraft:particle_curse_power_blue");
                        dis += 0.6;
                     }

                     entity.getPersistentData().putDouble("Damage", 12.5 * CNT6);
                     entity.getPersistentData().putDouble("Range", 3.0);
                     entity.getPersistentData().putDouble("knockback", 0.5 * CNT6);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putDouble("projectile_type", 1.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        CompoundTag var95;
                        int var10003;
                        label195: {
                           var95 = entity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label195;
                              }
                           }

                           var10003 = 0;
                        }

                        var95.putDouble("BlockDamage", (0.25 + (double)var10003 * 0.5) * CNT6);
                        entity.getPersistentData().putDouble("BlockRange", 1.0);
                        entity.getPersistentData().putBoolean("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        hitBlock = true;
                     }
                  }

                  if (hitBlock) {
                     hitBlock = false;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)(15.0 * range), 0.3 * range, 0.3, 0.3 * range, 1.0);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(4.0 * range), 0.3 * range, 0.3, 0.3 * range, 0.5);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") - 3.0);
               }

               entity.getPersistentData().putDouble("x_knockback", 0.0);
               entity.getPersistentData().putDouble("y_knockback", 0.0);
               entity.getPersistentData().putDouble("z_knockback", 0.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            entity.getPersistentData().putBoolean("attack", true);
         }

      }
   }
}
