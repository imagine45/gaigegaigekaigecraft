package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityImpactWaveEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CrystalSelfExplosionProcedure {
   public CrystalSelfExplosionProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double cnt6 = 0.0;
         double x_target = 0.0;
         double distance = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw = 0.0;
         double speed = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double range = 0.0;
         double pitch = 0.0;
         double power = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, 0, false, false));
            }
         }

         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         range = ReturnEntitySizeProcedure.execute(entity);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (((Entity)var10000).isAlive()) {
               entity.getPersistentData().putBoolean("PRESS_Z", true);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
            if (entity.getPersistentData().getDouble("cnt1") <= 1.0 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)(1.0 * range), 0.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)(1.0 * range), 0.5F, false);
               }
            }

            entity.getPersistentData().putDouble("Damage", 6.0);
            DamageFixProcedure.execute(entity);
            if (!entity.getPersistentData().getBoolean("PRESS_Z")) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(""), true);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
               }

               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + entity.getPersistentData().getDouble("used_technique_cost");
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               entity.getPersistentData().putDouble("skill", 0.0);
            } else {
               power = (double)Math.round((20.0 - entity.getPersistentData().getDouble("cnt1")) * 0.25);
               STR1 = Component.translatable("jujutsu.message.long_press").getString();

               for(int index0 = 0; index0 < (int)power; ++index0) {
                  STR1 = "■" + STR1 + "■";
                  x_pos = entity.getX();
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                  z_pos = entity.getZ();
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(STR1), true);
                  }
               }
            }

            distance = (double)(3.0F + entity.getBbWidth());

            for(int index1 = 0; index1 < (int)(8.0 * range); ++index1) {
               yaw = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               pitch = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, distance, x_pos + Math.cos(yaw) * Math.cos(pitch) * distance, x_pos, y_pos + Math.sin(pitch) * -1.0 * distance, y_pos, z_pos + Math.sin(yaw) * Math.cos(pitch) * distance, z_pos, "minecraft:crit");
            }
         } else {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            cnt6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            range = (1.0 + ReturnEntitySizeProcedure.execute(entity)) * cnt6;
            HP = 40.0;
            if (entity.getPersistentData().getDouble("cnt1") <= 35.0) {
               if (entity.getPersistentData().getDouble("cnt1") <= 21.0) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(""), true);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(2.0 * cnt6), 0.8F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(2.0 * cnt6), 0.8F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * cnt6), 0.8F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * cnt6), 0.8F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_IMPACT_WAVE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.setYRot(entity.getYRot());
                        entityinstance.setXRot(entity.getXRot());
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity45 = (LivingEntity)entityinstance;
                           if (_livingEntity45.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity45.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        entityinstance.getPersistentData().putDouble("cnt6", 10.0 + entity.getPersistentData().getDouble("cnt6"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity52 = (LivingEntity)entityinstance;
                           if (_livingEntity52.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity52.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(0.1);
                           }
                        }

                        if (entityinstance instanceof EntityImpactWaveEntity) {
                           EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entityinstance;
                           animatable.setTexture("flame_tiger");
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  DamageSource var10001 = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC));
                  float var10002;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.getHealth();
                  } else {
                     var10002 = -1.0F;
                  }

                  double var10003;
                  double var81;
                  label156: {
                     var81 = (double)var10002 * 0.99;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt57 = (LivingEntity)entity;
                        if (_livEnt57.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                           int var10006;
                           label152: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                    var10006 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                    break label152;
                                 }
                              }

                              var10006 = 0;
                           }

                           var10003 = 5.0 / Math.max((double)(5 - (1 + var10006)), 0.1);
                           break label156;
                        }
                     }

                     var10003 = 1.0;
                  }

                  entity.hurt(var10001, (float)(var81 * var10003));
               }

               if (entity.getPersistentData().getDouble("cnt1") % 4.0 == 1.0) {
                  entity.getPersistentData().putDouble("BlockDamage", 6.0 * cnt6);
                  entity.getPersistentData().putDouble("BlockRange", 12.0 * range);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("Damage", 50.0 * cnt6);
                  entity.getPersistentData().putDouble("knockback", 0.5 * cnt6);
                  entity.getPersistentData().putDouble("Range", 24.0 * range);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               cnt6 = 2.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:explosion ~ ~ ~ " + range * 2.0 + " " + range * 2.0 + " " + range * 2.0 + " " + 1.0 * cnt6 + " " + Math.round(10.0 * cnt6 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_big_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 1.0 * cnt6 + " " + Math.round(4.0 * cnt6 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:cloud ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 1.0 * cnt6 + " " + Math.round(10.0 * cnt6 * range) + " force");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:large_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 1.0 * cnt6 + " " + Math.round(10.0 * cnt6 * range) + " force");
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 45.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
