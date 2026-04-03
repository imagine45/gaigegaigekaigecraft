package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AvoidanceProcedure {
   public AvoidanceProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double distance = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double CNT6 = 0.0;
         double degree = 0.0;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         } else {
            if (entity.getPersistentData().getDouble("cnt2") == 0.0 && entity.onGround()) {
               entity.getPersistentData().putDouble("cnt1", 3.0);
               entity.getPersistentData().putDouble("cnt2", 1.0);
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity11 = (LivingEntity)entity;
                  if (_livingEntity11.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity11.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-20.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity12 = (LivingEntity)entity;
                  if (_livingEntity12.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity12.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               if (!entity.getPersistentData().getBoolean("PRESS_A") && entity.getPersistentData().getBoolean("PRESS_D")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entity;
                     if (_livingEntity15.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                     }
                  }
               } else if (entity.getPersistentData().getBoolean("PRESS_A") && !entity.getPersistentData().getBoolean("PRESS_D") && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity18 = (LivingEntity)entity;
                  if (_livingEntity18.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity18.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(2.0);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_W")) {
                  degree = Math.toRadians(0.0);
                  if (!entity.getPersistentData().getBoolean("PRESS_A") && entity.getPersistentData().getBoolean("PRESS_D")) {
                     degree += Math.toRadians(45.0);
                  } else if (entity.getPersistentData().getBoolean("PRESS_A") && !entity.getPersistentData().getBoolean("PRESS_D")) {
                     degree -= Math.toRadians(45.0);
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entity;
                     if (_livingEntity24.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity24.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(3.0);
                     }
                  }
               } else if (entity.getPersistentData().getBoolean("PRESS_S")) {
                  degree = Math.toRadians(180.0);
                  if (!entity.getPersistentData().getBoolean("PRESS_A") && entity.getPersistentData().getBoolean("PRESS_D")) {
                     degree -= Math.toRadians(45.0);
                  } else if (entity.getPersistentData().getBoolean("PRESS_A") && !entity.getPersistentData().getBoolean("PRESS_D")) {
                     degree += Math.toRadians(45.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt3", 1.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity31 = (LivingEntity)entity;
                        if (_livingEntity31.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity31.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                        }
                     }
                  }
               } else if (!entity.getPersistentData().getBoolean("PRESS_A") && entity.getPersistentData().getBoolean("PRESS_D")) {
                  degree += Math.toRadians(90.0);
               } else if (entity.getPersistentData().getBoolean("PRESS_A") && !entity.getPersistentData().getBoolean("PRESS_D")) {
                  degree -= Math.toRadians(90.0);
               } else {
                  degree = Math.toRadians(180.0);
               }

               yaw += degree;
               PlayAnimationProcedure.execute(world, entity);
               pitch = Math.toRadians(0.0);
               distance = 999.0;
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
               GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(10.0 * range), range * 0.25, 0.1, range * 0.25, 0.5);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
               if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.6F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.6F, false);
                     }
                  }
               } else if (entity.getPersistentData().getDouble("cnt2") >= 7.0) {
                  if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 0.6F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.step")), SoundSource.NEUTRAL, 2.0F, 0.6F, false);
                        }
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(1.0 * range), range * 0.1, 0.1, range * 0.1, 0.2);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
                  }
               }

               x_power = entity.getPersistentData().getDouble("x_power") * 0.75;
               y_power = entity.getPersistentData().getDouble("y_power") * 0.75;
               z_power = entity.getPersistentData().getDouble("z_power") * 0.75;
               if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               entity.getPersistentData().putDouble("cnt6", -1.0);

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  entity.getPersistentData().putDouble("Damage", 9.0);
                  entity.getPersistentData().putDouble("Range", 4.0 * range);
                  entity.getPersistentData().putDouble("knockback", 0.75);
                  entity.getPersistentData().putDouble("effect", 5.0);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().putBoolean("attack", true);
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            }
         }

      }
   }
}
