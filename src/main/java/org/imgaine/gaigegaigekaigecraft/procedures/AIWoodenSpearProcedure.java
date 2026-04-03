package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.IceSpear2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.IceSpearEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWoodenSpearProcedure {
   public AIWoodenSpearProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean attack = false;
         boolean logic_a = false;
         boolean ice = false;
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
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            WoodenSpear2OnInitialEntitySpawnProcedure.execute(entity);
         }

         ice = entity instanceof IceSpearEntity || entity instanceof IceSpear2Entity;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = (double)(2.0F + (entity.getBbHeight() + entity.getBbWidth()) * 1.0F);
         attack = false;
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
            if (entity.getPersistentData().getDouble("cnt1") == 1.0 && !ice) {
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
            if (!ice && range > 18.0) {
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
               entity.getPersistentData().putDouble("knockback", ice ? 0.01 : 0.25 * Math.pow(CNT6, 2.0));
               entity.getPersistentData().putDouble("Range", range);
               entity.getPersistentData().putDouble("effect", (double)(ice ? 14 : 1));
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
               if (!ice) {
                  entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                  }
               }

               entity.getPersistentData().putDouble("movement_amount", entity.getPersistentData().getDouble("movement_amount") + 1.0);
               if ((entity.getPersistentData().getDouble("movement_amount") >= 0.4 * range || ice) && (!world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).canOcclude() || ice)) {
                  double var10000;
                  label225: {
                     logic_a = true;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity52 = (LivingEntity)entity;
                        if (_livingEntity52.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity52.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label225;
                        }
                     }

                     var10000 = 0.0;
                  }

                  if (var10000 < 1.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2) && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity55 = (LivingEntity)entity;
                     if (_livingEntity55.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity55.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2));
                     }
                  }

                  entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                  BulletDomainHit2Procedure.execute(world, entity);
                  entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", ice ? 0.01 : 0.25 * Math.pow(CNT6, 2.0));
                  entity.getPersistentData().putDouble("Range", range);
                  entity.getPersistentData().putDouble("effect", (double)(ice ? 14 : 1));
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  break;
               }
            }

            if (logic_a) {
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               if (ice) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.4F, 1.1F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:ice_generate")), SoundSource.NEUTRAL, 0.4F, 1.1F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                  }
               } else {
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
               }

               entity.getPersistentData().putDouble("cnt2", 1.0);
            }

            attack = true;
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("move") == 0.0) {
               if (ice) {
                  if (entity.getPersistentData().getDouble("cnt3") > 20.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }
               } else if (entity.getPersistentData().getDouble("cnt3") > 60.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else {
               AIWoodenSpear2Procedure.execute(world, x, y, z, entity);
            }
         }

         if (entity.getPersistentData().getDouble("move") == 0.0) {
            if (attack) {
               entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
               entity.getPersistentData().putDouble("effect", (double)(ice ? 14 : 1));
               entity.getPersistentData().putDouble("knockback", ice ? 1.0 : 0.01);
               entity.getPersistentData().putDouble("Range", range);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
            }

            if (ice && entity.getPersistentData().getDouble("cnt1") % 20.0 == 10.0) {
               entity.getPersistentData().putDouble("Damage", 1.0 * CNT6);
               entity.getPersistentData().putDouble("Range", range);
               entity.getPersistentData().putDouble("knockback", 0.01);
               entity.getPersistentData().putDouble("effect", 14.0);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
            }
         }

         if (!ice) {
            if (!entity.isAlive()) {
               world.levelEvent(2001, BlockPos.containing(x, y + (double)entity.getBbHeight() * 0.5, z), Block.getId(WoodenSpear1DisplayConditionProcedure.execute(entity) ? Blocks.COBBLESTONE.defaultBlockState() : Blocks.OAK_WOOD.defaultBlockState()));
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else {
            if (Math.random() < 0.5 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x, y, z, 1, 1.5, 0.25, 1.5, 0.0);
            }

            if (Math.random() < 0.1 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 1, 1.5, 1.0, 1.5, 0.0);
            }
         }

      }
   }
}
