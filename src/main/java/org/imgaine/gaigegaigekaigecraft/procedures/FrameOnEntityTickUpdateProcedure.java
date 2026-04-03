package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class FrameOnEntityTickUpdateProcedure {
   public FrameOnEntityTickUpdateProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double y_pos = 0.0;
         double entity_size = 0.0;
         Entity entity_target = null;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         if (entity.isAlive()) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("NameRanged_ranged_keep") == 0.0 && entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
               entity_target = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("FREEZE_UUID"));
               if (entity_target instanceof LivingEntity && !entity_target.isInvulnerable()) {
                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 20, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10, 20, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 1, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 1, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SCALE_CHANGE.get(), 3, 0, false, false));
                     }
                  }

                  if (entity_target.getPersistentData().getDouble("select") == 0.0 && entity_target.getPersistentData().getDouble("skill") > -1000.0) {
                     label132: {
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _livEnt18 = (LivingEntity)entity_target;
                           if (_livEnt18.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                              break label132;
                           }
                        }

                        entity_target.getPersistentData().putDouble("skill", -1000.0);
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1, 0, false, false));
                           }
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }

                     entity_target.getPersistentData().putDouble("skill", -1000.0);
                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 20, 0, false, false));
                        }
                     }
                  }

                  entity_target.teleportTo(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.25, entity.getZ());
                  if (entity_target instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.25, entity.getZ(), entity_target.getYRot(), entity_target.getXRot());
                  }

                  entity_target.setYRot(entity.getYRot());
                  entity_target.setXRot(entity.getXRot());
                  entity_target.setYBodyRot(entity_target.getYRot());
                  entity_target.setYHeadRot(entity_target.getYRot());
                  entity_target.yRotO = entity_target.getYRot();
                  entity_target.xRotO = entity_target.getXRot();
                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity_target.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 20.0) {
               if (entity.getPersistentData().getDouble("NameRanged_ranged_keep") != 0.0) {
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 99999.0F);
               } else if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt_die", entity.getPersistentData().getDouble("cnt_die") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_die") <= 1.0) {
               world.levelEvent(2001, BlockPos.containing(x, y + (double)(entity.getBbHeight() * 0.0F), z), Block.getId(Blocks.GLASS.defaultBlockState()));
               world.levelEvent(2001, BlockPos.containing(x, y + (double)entity.getBbHeight() * 0.5, z), Block.getId(Blocks.GLASS.defaultBlockState()));
               world.levelEvent(2001, BlockPos.containing(x, y + (double)(entity.getBbHeight() * 1.0F), z), Block.getId(Blocks.GLASS.defaultBlockState()));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 0.5F, 1.25F);
                  } else {
                     _level.playLocalSound(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:glass_crash")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x, y_pos, z, (int)(20.0 * entity_size), 0.2 * entity_size, 0.2 * entity_size, 0.2 * entity_size, 0.25);
               }

               if (entity.getPersistentData().getDouble("NameRanged_ranged_keep") == 0.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            if (entity.getPersistentData().getDouble("NameRanged_ranged_keep") != 0.0) {
               if (entity.getPersistentData().getDouble("cnt_die") <= 2.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x, y_pos, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2.0F, 1.25F);
                     } else {
                        _level.playLocalSound(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
                     }
                  }
               }

               entity.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID_keep"));
               entity.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged_ranged_keep"));
               entity.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num_keep"));
               entity.getPersistentData().putDouble("Damage", 15.0);
               entity.getPersistentData().putDouble("Range", 12.0 * entity_size);
               entity.getPersistentData().putDouble("knockback", 1.5);
               RangeAttackProcedure.execute(world, x, y_pos, z, entity);
               entity.getPersistentData().putDouble("BlockRange", 8.0 * entity_size);
               entity.getPersistentData().putDouble("BlockDamage", 0.33);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x, y_pos, z, entity);
               entity.getPersistentData().putDouble("Range", 12.0 * entity_size);
               entity.getPersistentData().putDouble("knockback", 1.5);
               KnockbackProcedure.execute(world, x, y_pos, z, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x, y_pos, z, (int)(10.0 * entity_size), 0.2 * entity_size, 0.2 * entity_size, 0.2 * entity_size, 0.5);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, x, y_pos, z, (int)(10.0 * entity_size), 1.5 * entity_size, 1.5 * entity_size, 1.5 * entity_size, 0.5);
               }

               if (entity.getPersistentData().getDouble("cnt_die") >= 5.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
