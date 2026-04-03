package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class LightningStrike2Procedure {
   public LightningStrike2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         BlockState block_a = Blocks.AIR.defaultBlockState();
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double power = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_dis = 0.0;
         double damage = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double z_dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double y_dis = 0.0;
         double block_num = 0.0;
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 4, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 1.5);
         }

         if (entity.getPersistentData().getDouble("cnt2") == 1.0 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         logic_attack = entity.getPersistentData().getDouble("cnt2") > 180.0;
         if (entity.getPersistentData().getDouble("cnt2") % 10.0 == 1.0) {
            range = Math.min(Math.max(entity.getPersistentData().getDouble("cnt2") * 0.25, 5.0), 20.0);
            block_num = 0.0;
            x_pos = (double)Math.round(entity.getX() - range);

            for(int index0 = 0; index0 < (int)Math.round(range * 2.0); ++index0) {
               x_dis = Math.pow(x_pos - entity.getX(), 2.0);
               y_pos = (double)Math.round(entity.getY() + (double)entity.getBbHeight() * 0.5 + range);

               for(int index1 = 0; index1 < (int)Math.round(range * 2.0); ++index1) {
                  y_dis = Math.pow(y_pos - (entity.getY() + (double)entity.getBbHeight() * 0.5), 2.0);
                  z_pos = (double)Math.round(entity.getZ() - range);

                  for(int index2 = 0; index2 < (int)Math.round(range * 2.0); ++index2) {
                     z_dis = Math.pow(z_pos - entity.getZ(), 2.0);
                     distance = Math.sqrt(x_dis + y_dis + z_dis);
                     if (distance < range) {
                        block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                        if (block_a.getBlock() instanceof LiquidBlock || block_a.getBlock() instanceof SimpleWaterloggedBlock) {
                           ++block_num;
                           entity.getPersistentData().putDouble("Damage", 10.0);
                           entity.getPersistentData().putDouble("Range", 1.0);
                           RangeAttackProcedure.execute(world, x_pos + 0.5, y_pos + 0.5, z_pos + 0.5, entity);
                        }

                        if (world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                           if (Math.random() < 0.05) {
                              block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos));
                              if ((block_a.getBlock() instanceof LiquidBlock || block_a.getBlock() instanceof SimpleWaterloggedBlock) && world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos - 1.0, z_pos, 1, 0.25, 0.25, 0.25, 0.0);
                              }
                           }

                           if (world.getBiome(BlockPos.containing(x_pos, y_pos, z_pos)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:ocean")))) {
                              entity.getPersistentData().putDouble("Damage", 6.0);
                              entity.getPersistentData().putDouble("Range", 1.0);
                              entity.getPersistentData().putDouble("effect", 16.0);
                              entity.getPersistentData().putDouble("effectConfirm", 2.0);
                              entity.getPersistentData().putBoolean("onlyLiving", true);
                              RangeAttackProcedure.execute(world, x_pos + 0.5, y_pos + 0.5, z_pos + 0.5, entity);
                           }
                        }
                     }

                     z_pos = (double)Math.round(z_pos + 1.0);
                  }

                  y_pos = (double)Math.round(y_pos - 1.0);
               }

               x_pos = (double)Math.round(x_pos + 1.0);
            }

            if (Math.sqrt(block_num) > 15.0 * (range / 20.0)) {
               entity.getPersistentData().putDouble("cnt3", Math.sqrt(Math.sqrt(block_num)));
               if (logic_attack) {
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") * 1.5);
               }
            } else if (!logic_attack) {
               entity.getPersistentData().putDouble("BlockRange", 6.0);
               entity.getPersistentData().putDouble("BlockDamage", 0.01);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         if (entity instanceof Player) {
            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - Math.min(Math.max(2.0, entity.getPersistentData().getDouble("cnt3")), 12.0);
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (!logic_attack && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 20.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            if (!logic_attack && !entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         if (logic_attack) {
            entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
            block_num = entity.getPersistentData().getDouble("cnt3");
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            entity.getPersistentData().putDouble("Damage", 36.0 + block_num * 1.5);
            entity.getPersistentData().putDouble("Range", 36.0 + block_num * 1.5);
            entity.getPersistentData().putDouble("knockback", 0.5);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            range = Math.max(entity.getPersistentData().getDouble("Range") * 0.2, 10.0);
            if (entity.getPersistentData().getDouble("cnt4") > 5.0) {
               range = Math.min(range, 8.0);

               for(int index3 = 0; index3 < 64; ++index3) {
                  x_pos += (Math.random() - 0.5) * range * 2.0;
                  y_pos += (Math.random() - 0.5) * range * 2.0;
                  z_pos += (Math.random() - 0.5) * range * 2.0;
                  block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                  if (block_a.getBlock() instanceof LiquidBlock || block_a.getBlock() instanceof SimpleWaterloggedBlock) {
                     break;
                  }
               }

               for(int index4 = 0; index4 < (int)Math.min(entity.getPersistentData().getDouble("cnt4"), 12.0); ++index4) {
                  block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                  if (!(block_a.getBlock() instanceof LiquidBlock) && !(block_a.getBlock() instanceof SimpleWaterloggedBlock) || world.isEmptyBlock(BlockPos.containing(x_pos, y_pos + 1.0, z_pos))) {
                     break;
                  }

                  ++y_pos;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 75.0), 40.0), range, range, range, 1.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 50.0), 25.0), range, range, range, 0.5);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 150.0), 75.0), range, range, range, 1.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 75.0), 40.0), range, range, range, 1.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.75F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
               }
            }

            range = Math.min(range, 8.0);
            block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
            if (!(block_a.getBlock() instanceof LiquidBlock) && !(block_a.getBlock() instanceof SimpleWaterloggedBlock)) {
               for(int index5 = 0; index5 < 64; ++index5) {
                  x_pos += (Math.random() - 0.5) * range * 2.0;
                  y_pos += (Math.random() - 0.5) * range * 2.0;
                  z_pos += (Math.random() - 0.5) * range * 2.0;
                  block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                  if (block_a.getBlock() instanceof LiquidBlock || block_a.getBlock() instanceof SimpleWaterloggedBlock) {
                     break;
                  }
               }
            }

            entity.getPersistentData().putDouble("BlockRange", 8.0);
            entity.getPersistentData().putDouble("BlockDamage", 2.0);
            entity.getPersistentData().putBoolean("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().getDouble("cnt2") > 210.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 400, entity instanceof KashimoHajimeEntity ? 1 : 0, false, false));
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
