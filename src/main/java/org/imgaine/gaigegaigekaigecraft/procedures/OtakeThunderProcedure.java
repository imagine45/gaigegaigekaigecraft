package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class OtakeThunderProcedure {
   public OtakeThunderProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double cnt6 = 0.0;
         double x_target = 0.0;
         double distance = 0.0;
         double picth = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double num1 = 0.0;
         double y_pos = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         cnt6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") <= 0.0) {
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            picth = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(picth) * -1.0 * (1.5 + (double)entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.2);
               }
            } else {
               entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.5);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
               }

               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
                  }
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
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0) {
                  label264: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label265: {
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
                                 break label265;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label264;
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
               entity.getPersistentData().putDouble("cnt2", Math.min(entity.getPersistentData().getDouble("cnt2"), 0.0));
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
            entity.getPersistentData().putDouble("cnt2", -3.0);
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().putDouble("x_pos", entity.getX());
               entity.getPersistentData().putDouble("y_pos", entity.getY());
               entity.getPersistentData().putDouble("z_pos", entity.getZ());
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity55 = (LivingEntity)entity;
                  if (_livingEntity55.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity55.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity56 = (LivingEntity)entity;
                  if (_livingEntity56.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity56.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            LivingEntity var84;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var84 = _mobEnt.getTarget();
            } else {
               var84 = null;
            }

            if (var84 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.getTarget();
               } else {
                  var84 = null;
               }

               x_target = ((Entity)var84).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.getTarget();
               } else {
                  var84 = null;
               }

               double var87 = ((Entity)var84).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_target = var87 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var88;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var88 = _mobEnt.getTarget();
               } else {
                  var88 = null;
               }

               z_target = ((Entity)var88).getZ();
            } else {
               x_target = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_target = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_target = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            }

            x_power = x_target - entity.getPersistentData().getDouble("x_pos");
            y_power = y_target - entity.getPersistentData().getDouble("y_pos");
            z_power = z_target - entity.getPersistentData().getDouble("z_pos");
            distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (distance > 0.0) {
               x_power /= distance;
               y_power /= distance;
               z_power /= distance;
            }

            for(int index0 = 0; index0 < (int)(5.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2)); ++index0) {
               entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + x_power);
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + y_power);
               entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + z_power);
            }

            if (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() || world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
               for(int index1 = 0; index1 < 255 && (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() || world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))); ++index1) {
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + 1.0);
               }
            }

            for(int index2 = 0; index2 < 255 && !world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() && !world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))); ++index2) {
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 1.0);
            }

            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos") + 16.0;
            z_pos = entity.getPersistentData().getDouble("z_pos");
            num1 = 0.0;

            for(int index3 = 0; index3 < 160; ++index3) {
               ++num1;
               if (num1 > 0.0) {
                  num1 = -9.0;
                  entity.getPersistentData().putDouble("Damage", 16.0);
                  entity.getPersistentData().putDouble("Range", 5.0);
                  entity.getPersistentData().putDouble("knockback", 0.1);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  entity.getPersistentData().putBoolean("ignore", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (Math.random() < 0.25) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                  }
               }

               x_pos += Mth.nextDouble(RandomSource.create(), -0.1, 0.1);
               y_pos -= 0.1;
               z_pos += Mth.nextDouble(RandomSource.create(), -0.1, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), x_pos, y_pos, z_pos, (int)(20.0 * cnt6), 0.25, 0.25, 0.25, 0.5 * cnt6);
            }

            entity.getPersistentData().putDouble("BlockRange", 1.0 * cnt6);
            entity.getPersistentData().putDouble("BlockDamage", 4.0 * cnt6);
            entity.getPersistentData().putBoolean("noEffect", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, (float)cnt6, 1.5F, false);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 18.0, 90.0, 0.0, 2.0, 1.0, x_pos, x_pos, y_pos, y_pos + 0.5, 0.0, z_pos, z_pos, "gaigegaigekaigecraft:particle_thunder_purple");
            if (entity.getPersistentData().getDouble("cnt1") > 4.0 + entity.getPersistentData().getDouble("cnt6")) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
