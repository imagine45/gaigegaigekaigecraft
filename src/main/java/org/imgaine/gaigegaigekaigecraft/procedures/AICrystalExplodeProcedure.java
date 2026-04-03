package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AICrystalExplodeProcedure {
   public AICrystalExplodeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean attack = false;
         boolean logic_a = false;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         entity.fallDistance = 0.0F;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = (double)(2.0F + (entity.getBbHeight() + entity.getBbWidth()) * 1.0F);
         speed = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_power"), 2.0));
         if (speed > 0.0) {
            x_power = entity.getPersistentData().getDouble("x_power") / speed;
            y_power = entity.getPersistentData().getDouble("y_power") / speed;
            z_power = entity.getPersistentData().getDouble("z_power") / speed;
         } else {
            speed = 1.0;
            x_power = 0.0;
            y_power = 1.0;
            z_power = 0.0;
         }

         if (entity.getPersistentData().getDouble("cnt1") < 8.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();

               for(int index0 = 0; index0 < (int)(4.0 + range * 0.5); ++index0) {
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && !world.getBlockState(BlockPos.containing(x_pos + x_power, y_pos + y_power, z_pos + z_power)).canOcclude()) {
                     world.levelEvent(2001, BlockPos.containing(x_pos + x_power, y_pos + y_power, z_pos + z_power), Block.getId(world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos))));
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            logic_a = false;
            if (range > 18.0) {
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();

               for(int index1 = 0; index1 < (int)(4.0 + range * 0.5); ++index1) {
                  if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && world.getBlockState(BlockPos.containing(x_pos - x_power, y_pos - y_power, z_pos - z_power)).canOcclude()) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)range, range, range, range, 1.0);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)range, range, range, range, 1.0);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }
            }

            for(int index2 = 0; index2 < (int)Math.max(speed * 3.0, 1.0); ++index2) {
               entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
               entity.getPersistentData().putDouble("knockback", 0.25 * Math.pow(CNT6, 2.0));
               entity.getPersistentData().putDouble("Range", range);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
               entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
               }

               entity.getPersistentData().putDouble("movement_amount", entity.getPersistentData().getDouble("movement_amount") + 1.0);
               if (entity.getPersistentData().getDouble("movement_amount") >= 0.4 * range && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).canOcclude()) {
                  double var10000;
                  label165: {
                     logic_a = true;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity48 = (LivingEntity)entity;
                        if (_livingEntity48.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity48.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label165;
                        }
                     }

                     var10000 = 0.0;
                  }

                  if (var10000 < 1.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2) && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity51 = (LivingEntity)entity;
                     if (_livingEntity51.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity51.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2));
                     }
                  }

                  entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                  BulletDomainHit2Procedure.execute(world, entity);
                  entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", 0.25 * Math.pow(CNT6, 2.0));
                  entity.getPersistentData().putDouble("Range", range);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  break;
               }
            }

            if (logic_a) {
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();

               for(int index3 = 0; index3 < (int)(range * 0.5); ++index3) {
                  x_pos -= x_power;
                  y_pos -= y_power;
                  z_pos -= z_power;
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                     }

                     world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId(world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos))));
                     break;
                  }
               }

               entity.getPersistentData().putDouble("cnt2", 1.0);
            }

            attack = true;
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (!entity.isAlive()) {
               entity.getPersistentData().putDouble("cnt3", Math.max(entity.getPersistentData().getDouble("cnt3"), 30.0));
            }

            range = (1.0 + ReturnEntitySizeProcedure.execute(entity)) * CNT6;
            if (entity.getPersistentData().getDouble("cnt3") >= 30.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
                  }
               }

               if (entity.getPersistentData().getDouble("cnt3") == 30.0) {
                  entity.getPersistentData().putDouble("BlockDamage", 6.0 * CNT6);
                  entity.getPersistentData().putDouble("BlockRange", 3.5 * range);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", 0.5 * CNT6);
                  entity.getPersistentData().putDouble("Range", 7.0 * range);
                  RangeAttackProcedure.execute(world, x, y, z, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.8F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.8F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.9F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.9F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:explosion ~ ~ ~ " + range * 2.0 + " " + range * 2.0 + " " + range * 2.0 + " " + 1.0 * CNT6 + " " + Math.round(20.0 * CNT6 * range) + " force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:cloud ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 1.25 * CNT6 + " " + Math.round(15.0 * CNT6 * range) + " force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:large_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 1.25 * CNT6 + " " + Math.round(15.0 * CNT6 * range) + " force");
                  }
               }

               if (entity.getPersistentData().getDouble("cnt3") >= 30.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            }
         }

         if (attack) {
            entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
            entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
            entity.getPersistentData().putDouble("knockback", 1.0);
            entity.getPersistentData().putDouble("Range", range);
            RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
         }

      }
   }
}
