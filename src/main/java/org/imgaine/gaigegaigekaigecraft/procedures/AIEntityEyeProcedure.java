package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityEyeRantaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityImpactWaveEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEntityEyeProcedure {
   public AIEntityEyeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_entity = null;
         Entity target_entity = null;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double height = 0.0;
         double cnt_life = 0.0;
         double power = 0.0;
         double distance = 0.0;
         double rnd = 0.0;
         double tick = 0.0;
         double magnification = 0.0;
         double old1 = 0.0;
         double old2 = 0.0;
         range = ReturnEntitySizeProcedure.execute(entity);
         height = (double)entity.getBbHeight() * 0.75;
         x_pos = entity.getX();
         y_pos = entity.getY();
         z_pos = entity.getZ();
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         }

         if (!(owner_entity instanceof LivingEntity)) {
            owner_entity = entity;
         }

         target_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("TARGET"));
         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
         cnt_life = entity.getPersistentData().getDouble("cnt_life");
         entity.fallDistance = 0.0F;
         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         entity.push(0.0, 0.0, 0.0);
         if (Math.random() < 0.25) {
            ParticleGeneratorCircleProcedure.execute(world, 36.0 * range, Mth.nextDouble(RandomSource.create(), 0.0, 360.0), 0.0, 1.0, 4.0, x_pos, x_pos, y_pos + height, y_pos + height, Mth.nextDouble(RandomSource.create(), 0.0, 360.0), z_pos, z_pos, Math.random() < 0.5 ? "enchanted_hit" : "crit");
         }

         if (cnt_life < 10.0) {
            if (cnt_life == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)range, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)range, 0.5F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_IMPACT_WAVE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                     if (entityinstance instanceof EntityImpactWaveEntity) {
                        EntityImpactWaveEntity _datEntSetI = (EntityImpactWaveEntity)entityinstance;
                        _datEntSetI.getEntityData().set(EntityImpactWaveEntity.DATA_mode, 2);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity22 = (LivingEntity)entityinstance;
                        if (_livingEntity22.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity22.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(0.1);
                        }
                     }

                     if (entityinstance instanceof EntityImpactWaveEntity) {
                        EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entityinstance;
                        animatable.setTexture("hanako_hand");
                     }

                     entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") - 0.0);
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }

            for(int index0 = 0; index0 < 8; ++index0) {
               ParticleGeneratorCircleProcedure.execute(world, 4.0 * range, 90.0, 0.0, 1.0, 4.0, x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), 0.0, z_pos, z_pos, "gaigegaigekaigecraft:particle_curse_power_red");
            }
         }

         if (target_entity instanceof LivingEntity) {
            target_entity.teleportTo(entity.getX(), entity.getY(), entity.getZ());
            if (target_entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)target_entity;
               _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ(), target_entity.getYRot(), target_entity.getXRot());
            }

            if (cnt_life % 5.0 == 1.0) {
               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 1, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 10, 0, false, false));
                  }
               }

               if (target_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)target_entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COLOR.get(), 10, 1, false, false));
                  }
               }
            }

            if (cnt_life % 20.0 == 1.0 && LogicOwnerExistProcedure.execute(world, entity) && owner_entity instanceof LivingEntity) {
               int var10000;
               label324: {
                  if (target_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)target_entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label324;
                     }
                  }

                  var10000 = 0;
               }

               int var10001;
               double var89;
               label319: {
                  var89 = (double)Math.max(var10000 - 4, 0) * 1.2;
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)owner_entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label319;
                     }
                  }

                  var10001 = 0;
               }

               power = var89 - (double)Math.max(var10001 - 4, 0);
               if (power >= 0.0) {
                  double var90;
                  label313: {
                     if (owner_entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)owner_entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                           var90 = (double)_livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                           break label313;
                        }
                     }

                     var90 = 0.0;
                  }
                  double var91;
                  label308: {
                     old1 = var90;
                     if (owner_entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)owner_entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                           var91 = (double)_livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getDuration();
                           break label308;
                        }
                     }

                     var91 = 0.0;
                  }

                  old2 = var91;
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_entity;
                     _entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                  }

                  owner_entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse")))), (float)(2.5 + power * 0.625));
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int)old2, (int)old1, false, false));
                     }
                  }

                  if (owner_entity instanceof Player) {
                     magnification = 5.0;
                  } else {
                     magnification = 1.0;
                  }

                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse")))), (float)((2.5 + power * 0.625) * magnification));
                  float var92;
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)owner_entity;
                     var92 = _livEnt.getHealth();
                  } else {
                     var92 = -1.0F;
                  }

                  double var93 = (double)var92 * range;
                  float var98;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var98 = _livEnt.getHealth();
                  } else {
                     var98 = -1.0F;
                  }

                  if (var93 < (double)var98) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (owner_entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)owner_entity;
                           var98 = _livEnt.getHealth();
                        } else {
                           var98 = -1.0F;
                        }

                        _entity.setHealth((float)((double)var98 * range));
                     }

                     if (!owner_entity.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                     }
                  }

                  for(int index1 = 0; index1 < (int)Math.min(power + 1.0, 10.0); ++index1) {
                     Effect1Procedure.execute(world, entity, owner_entity);
                     if (!entity.isAlive()) {
                        break;
                     }
                  }
               }
            }
         }

         if (cnt_life % 10.0 == 1.0) {
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COLOR.get(), 15, 1, false, false));
                  }
               }
            }
         }

         for(int index2 = 0; index2 < (int)(4.0 * range); ++index2) {
            if (Math.random() < 0.2) {
               ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 1.0, 0.5 + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), 0.0, z_pos, z_pos, "cloud");
            } else {
               ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 1.0, 1.5 + Mth.nextDouble(RandomSource.create(), 0.0, 0.75), x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), 0.0, z_pos, z_pos, "gaigegaigekaigecraft:particle_curse_power_red");
            }
         }

         if (cnt_life % 20.0 == 1.0) {
            entity.getPersistentData().putDouble("Damage", 9.0);
            entity.getPersistentData().putDouble("Range", 8.0 * range);
            entity.getPersistentData().putDouble("knockback", 0.5);
            entity.getPersistentData().putDouble("effect", 0.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos + height, z_pos, entity);
            entity.getPersistentData().putDouble("BlockRange", 2.0 * range);
            entity.getPersistentData().putDouble("BlockDamage", 8.0);
            entity.getPersistentData().putBoolean("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + height, z_pos, entity);
         }

         if (LogicOwnerExistProcedure.execute(world, entity)) {
            if (owner_entity instanceof LivingEntity) {
               if (owner_entity.getPersistentData().getDouble("skill") <= 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }

               if (!entity.isAlive() && owner_entity.getPersistentData().getDouble("skill") > 0.0) {
                  owner_entity.getPersistentData().putDouble("skill", 0.0);
               }

               if (!(target_entity instanceof LivingEntity) && !(owner_entity instanceof Player)) {
                  owner_entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         } else if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
         }

         label357: {
            if (entity instanceof EntityEyeRantaEntity) {
               EntityEyeRantaEntity _datEntL84 = (EntityEyeRantaEntity)entity;
               if ((Boolean)_datEntL84.getEntityData().get(EntityEyeRantaEntity.DATA_damage1)) {
                  break label357;
               }
            }

            float var94;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var94 = _livEnt.getHealth();
            } else {
               var94 = -1.0F;
            }

            double var95 = (double)var94;
            float var100;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var100 = _livEnt.getMaxHealth();
            } else {
               var100 = -1.0F;
            }

            if (var95 < (double)var100 * 0.6) {
               if (entity instanceof EntityEyeRantaEntity) {
                  EntityEyeRantaEntity _datEntSetL = (EntityEyeRantaEntity)entity;
                  _datEntSetL.getEntityData().set(EntityEyeRantaEntity.DATA_damage1, true);
               }

               if (entity instanceof EntityEyeRantaEntity) {
                  EntityEyeRantaEntity animatable = (EntityEyeRantaEntity)entity;
                  animatable.setTexture("eye_ranta2");
               }
            }
         }

         if (entity instanceof EntityEyeRantaEntity) {
            EntityEyeRantaEntity _datEntL89 = (EntityEyeRantaEntity)entity;
            if ((Boolean)_datEntL89.getEntityData().get(EntityEyeRantaEntity.DATA_damage2)) {
               return;
            }
         }

         float var96;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var96 = _livEnt.getHealth();
         } else {
            var96 = -1.0F;
         }

         double var97 = (double)var96;
         float var101;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var101 = _livEnt.getMaxHealth();
         } else {
            var101 = -1.0F;
         }

         if (var97 < (double)var101 * 0.3) {
            if (entity instanceof EntityEyeRantaEntity) {
               EntityEyeRantaEntity _datEntSetL = (EntityEyeRantaEntity)entity;
               _datEntSetL.getEntityData().set(EntityEyeRantaEntity.DATA_damage2, true);
            }

            if (entity instanceof EntityEyeRantaEntity) {
               EntityEyeRantaEntity animatable = (EntityEyeRantaEntity)entity;
               animatable.setTexture("eye_ranta3");
            }
         }

      }
   }
}
