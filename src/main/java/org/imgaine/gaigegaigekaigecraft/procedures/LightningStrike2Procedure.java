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
         BlockState block_a = Blocks.f_50016_.m_49966_();
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
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 4, (double)entity.m_20205_() * 0.25, (double)entity.m_20206_() * 0.25, (double)entity.m_20205_() * 0.25, 1.5);
         }

         if (entity.getPersistentData().m_128459_("cnt2") == 1.0 && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         logic_attack = entity.getPersistentData().m_128459_("cnt2") > 180.0;
         if (entity.getPersistentData().m_128459_("cnt2") % 10.0 == 1.0) {
            range = Math.min(Math.max(entity.getPersistentData().m_128459_("cnt2") * 0.25, 5.0), 20.0);
            block_num = 0.0;
            x_pos = (double)Math.round(entity.m_20185_() - range);

            for(int index0 = 0; index0 < (int)Math.round(range * 2.0); ++index0) {
               x_dis = Math.pow(x_pos - entity.m_20185_(), 2.0);
               y_pos = (double)Math.round(entity.m_20186_() + (double)entity.m_20206_() * 0.5 + range);

               for(int index1 = 0; index1 < (int)Math.round(range * 2.0); ++index1) {
                  y_dis = Math.pow(y_pos - (entity.m_20186_() + (double)entity.m_20206_() * 0.5), 2.0);
                  z_pos = (double)Math.round(entity.m_20189_() - range);

                  for(int index2 = 0; index2 < (int)Math.round(range * 2.0); ++index2) {
                     z_dis = Math.pow(z_pos - entity.m_20189_(), 2.0);
                     distance = Math.sqrt(x_dis + y_dis + z_dis);
                     if (distance < range) {
                        block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                        if (block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) {
                           ++block_num;
                           entity.getPersistentData().m_128347_("Damage", 10.0);
                           entity.getPersistentData().m_128347_("Range", 1.0);
                           RangeAttackProcedure.execute(world, x_pos + 0.5, y_pos + 0.5, z_pos + 0.5, entity);
                        }

                        if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                           if (Math.random() < 0.05) {
                              block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos));
                              if ((block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) && world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos - 1.0, z_pos, 1, 0.25, 0.25, 0.25, 0.0);
                              }
                           }

                           if (world.m_204166_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_203656_(TagKey.m_203882_(Registries.f_256952_, new ResourceLocation("minecraft:ocean")))) {
                              entity.getPersistentData().m_128347_("Damage", 6.0);
                              entity.getPersistentData().m_128347_("Range", 1.0);
                              entity.getPersistentData().m_128347_("effect", 16.0);
                              entity.getPersistentData().m_128347_("effectConfirm", 2.0);
                              entity.getPersistentData().m_128379_("onlyLiving", true);
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
               entity.getPersistentData().m_128347_("cnt3", Math.sqrt(Math.sqrt(block_num)));
               if (logic_attack) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") * 1.5);
               }
            } else if (!logic_attack) {
               entity.getPersistentData().m_128347_("BlockRange", 6.0);
               entity.getPersistentData().m_128347_("BlockDamage", 0.01);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         if (entity instanceof Player) {
            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - Math.min(Math.max(2.0, entity.getPersistentData().m_128459_("cnt3")), 12.0);
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (!logic_attack && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 20.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }

            if (!logic_attack && !entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         if (logic_attack) {
            entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
            block_num = entity.getPersistentData().m_128459_("cnt3");
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            entity.getPersistentData().m_128347_("Damage", 36.0 + block_num * 1.5);
            entity.getPersistentData().m_128347_("Range", 36.0 + block_num * 1.5);
            entity.getPersistentData().m_128347_("knockback", 0.5);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            range = Math.max(entity.getPersistentData().m_128459_("Range") * 0.2, 10.0);
            if (entity.getPersistentData().m_128459_("cnt4") > 5.0) {
               range = Math.min(range, 8.0);

               for(int index3 = 0; index3 < 64; ++index3) {
                  x_pos += (Math.random() - 0.5) * range * 2.0;
                  y_pos += (Math.random() - 0.5) * range * 2.0;
                  z_pos += (Math.random() - 0.5) * range * 2.0;
                  block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                  if (block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) {
                     break;
                  }
               }

               for(int index4 = 0; index4 < (int)Math.min(entity.getPersistentData().m_128459_("cnt4"), 12.0); ++index4) {
                  block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                  if (!(block_a.m_60734_() instanceof LiquidBlock) && !(block_a.m_60734_() instanceof SimpleWaterloggedBlock) || world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + 1.0, z_pos))) {
                     break;
                  }

                  ++y_pos;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 75.0), 40.0), range, range, range, 1.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 50.0), 25.0), range, range, range, 0.5);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 150.0), 75.0), range, range, range, 1.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), x_pos, y_pos, z_pos, (int)Math.max(Math.min(Math.pow(range, 2.5), 75.0), 40.0), range, range, range, 1.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.75F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
               }
            }

            range = Math.min(range, 8.0);
            block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
            if (!(block_a.m_60734_() instanceof LiquidBlock) && !(block_a.m_60734_() instanceof SimpleWaterloggedBlock)) {
               for(int index5 = 0; index5 < 64; ++index5) {
                  x_pos += (Math.random() - 0.5) * range * 2.0;
                  y_pos += (Math.random() - 0.5) * range * 2.0;
                  z_pos += (Math.random() - 0.5) * range * 2.0;
                  block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                  if (block_a.m_60734_() instanceof LiquidBlock || block_a.m_60734_() instanceof SimpleWaterloggedBlock) {
                     break;
                  }
               }
            }

            entity.getPersistentData().m_128347_("BlockRange", 8.0);
            entity.getPersistentData().m_128347_("BlockDamage", 2.0);
            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt2") > 210.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 400, entity instanceof KashimoHajimeEntity ? 1 : 0, false, false));
               }
            }

            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
