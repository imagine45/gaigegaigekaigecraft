package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MaxElephantEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DagonWaterSkillProcedure {
   public DagonWaterSkillProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         boolean player = false;
         boolean blood = false;
         boolean logic_b = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double strength = 0.0;
         double HP = 0.0;
         double y_velocity = 0.0;
         double y_power = 0.0;
         double level = 0.0;
         double height = 0.0;
         double distance = 0.0;
         double CNT6 = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         dis = ReturnEntitySizeProcedure.execute(entity);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         blood = entity.getPersistentData().getDouble("skill") == 1016.0;
         if (!(entity instanceof MaxElephantEntity) && entity.getPersistentData().getDouble("skill") == 805.0) {
            if (entity.getPersistentData().getDouble("cnt4") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity97 = (LivingEntity)entity;
                  if (_livingEntity97.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity97.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-3.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity98 = (LivingEntity)entity;
                  if (_livingEntity98.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity98.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (!(entity instanceof Player)) {
               entity.fallDistance = 0.0F;
               y_velocity = Math.min(Math.max(y_velocity, -0.5), 0.5);
               if (!entity.isShiftKeyDown()) {
                  height = GetHeightFromGroundProcedure.execute(world, entity);
                  if (height < 10.0) {
                     y_velocity = entity.getDeltaMovement().y() + 0.1;
                  } else if (height > 12.0) {
                     y_velocity = entity.getDeltaMovement().y() - 0.1;
                  } else {
                     y_velocity = 0.0;
                  }
               }

               entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), y_velocity, entity.getDeltaMovement().z()));
            }

            if (entity.getPersistentData().getDouble("cnt1") == 1.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if (!(entity instanceof Player)) {
               entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
            }

            if (entity.getPersistentData().getDouble("cnt5") < 100.0 && (entity.getPersistentData().getBoolean("PRESS_Z") || !(entity instanceof Player) && GetDistanceProcedure.execute(entity) > 24.0)) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 15.0));
               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 1.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") <= 15.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
                  }
               }

               for(int index0 = 0; index0 < (int)(8.0F * entity.getBbHeight()); ++index0) {
                  yaw = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
                  dis = Math.toRadians(0.0);
                  distance = Mth.nextDouble(RandomSource.create(), 0.5, 1.0);
                  x_pos = entity.getX() + Math.cos(yaw) * Math.cos(dis) * distance * (double)entity.getBbWidth();
                  y_pos = entity.getY() + (double)entity.getBbHeight() + 1.5 + Math.sin(dis) * -1.0 * distance * (double)entity.getBbWidth();
                  z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(dis) * distance * (double)entity.getBbWidth();
                  y_pos += (distance - 0.5) * 2.0 * (double)entity.getBbHeight();
                  ParticleGeneratorProcedure.execute(world, (double)entity.getBbWidth() * 0.25, 1.0, 0.0, 2.0, x_pos, x_pos + Math.cos(yaw + Math.toRadians(90.0)) * Math.cos(dis) * distance * (double)entity.getBbWidth(), y_pos, y_pos + Math.sin(dis) * -1.0 * distance * (double)entity.getBbWidth(), z_pos, z_pos + Math.sin(yaw + Math.toRadians(90.0)) * Math.cos(dis) * distance * (double)entity.getBbWidth(), "gaigegaigekaigecraft:particle_water");
               }
            } else {
               entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
               if (entity.getPersistentData().getDouble("cnt4") == 1.0) {
                  entity.getPersistentData().putDouble("cnt5", 0.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity149 = (LivingEntity)entity;
                     if (_livingEntity149.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity149.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity150 = (LivingEntity)entity;
                     if (_livingEntity150.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity150.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (!(entity instanceof Player)) {
                     entity.setYRot(entity.getYRot());
                     entity.setXRot(90.0F);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }

                  yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  dis = Math.toRadians((double)entity.getXRot());
                  entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(dis) * (0.6 + (double)entity.getBbWidth()));
                  entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(dis) * -1.0 * (0.6 + (double)entity.getBbWidth()));
                  entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(dis) * (0.6 + (double)entity.getBbWidth()));
                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z);
                  entity.getPersistentData().putDouble("cnt7", entity.getPersistentData().getDouble("x_pos"));
                  entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("y_pos"));
                  entity.getPersistentData().putDouble("cnt9", entity.getPersistentData().getDouble("z_pos"));
               }

               x_pos = entity.getPersistentData().getDouble("x_pos");
               y_pos = entity.getPersistentData().getDouble("y_pos");
               z_pos = entity.getPersistentData().getDouble("z_pos");
               x_power = entity.getPersistentData().getDouble("x_power") * 0.1;
               y_power = entity.getPersistentData().getDouble("y_power") * 0.1;
               z_power = entity.getPersistentData().getDouble("z_power") * 0.1;
               dis = 0.0;

               for(int index1 = 0; index1 < 35; ++index1) {
                  ++dis;
                  if (dis > 0.0) {
                     dis = -10.0;
                     entity.getPersistentData().putDouble("Damage", 12.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 2.0);
                     entity.getPersistentData().putDouble("knockback", 1.0 - (entity.getPersistentData().getDouble("cnt1") - 20.0) * 0.05);
                     entity.getPersistentData().putDouble("projectile_type", 1.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  logic_a = false;
                  logic_b = false;
                  if ((dis == -10.0 || dis == -5.0) && !world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.5, 0.5, 0.5), (e) -> true).isEmpty() && entity != (Entity)world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.5, 0.5, 0.5), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((LivingEntity) null) && ((Entity)world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.5, 0.5, 0.5), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((LivingEntity) null)).isAlive()) {
                     logic_b = true;
                  }

                  if (world.isEmptyBlock(BlockPos.containing(x_pos + x_power, y_pos, z_pos))) {
                     x_pos += x_power;
                  } else {
                     logic_a = true;
                  }

                  if (world.isEmptyBlock(BlockPos.containing(x_pos, y_pos + y_power, z_pos))) {
                     y_pos += y_power;
                  } else {
                     logic_a = true;
                  }

                  if (world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos + z_power))) {
                     z_pos += z_power;
                  } else {
                     logic_a = true;
                  }

                  if (logic_a || logic_b) {
                     entity.getPersistentData().putDouble("cnt4", Math.max(entity.getPersistentData().getDouble("cnt4") - 1.0, 1.0));
                     entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                     entity.getPersistentData().putDouble("Damage", 9.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 24.0);
                     entity.getPersistentData().putDouble("knockback", 1.0 - (entity.getPersistentData().getDouble("cnt1") - 20.0) * 0.05);
                     entity.getPersistentData().putDouble("projectile_type", 1.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (logic_a) {
                        entity.getPersistentData().putDouble("BlockRange", 4.0);
                        entity.getPersistentData().putDouble("BlockDamage", 2.0 * CNT6);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                        }
                     }

                     for(int index2 = 0; index2 < 36; ++index2) {
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 4.0, Mth.nextDouble(RandomSource.create(), 0.0, 4.0), x_pos, x_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 1.0), 0.0, z_pos, z_pos, "gaigegaigekaigecraft:particle_water_2");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos + 1.0, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           entityinstance.setYRot((float)Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
                           entityinstance.setXRot((float)Mth.nextDouble(RandomSource.create(), -22.5, 0.0));
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           entityinstance.getPersistentData().putDouble("x_power", entityinstance.getLookAngle().x * 6.0);
                           entityinstance.getPersistentData().putDouble("y_power", entityinstance.getLookAngle().y * 6.0);
                           entityinstance.getPersistentData().putDouble("z_power", entityinstance.getLookAngle().z * 6.0);
                           entityinstance.setDeltaMovement(new Vec3(entityinstance.getPersistentData().getDouble("x_power"), entityinstance.getPersistentData().getDouble("y_power"), entityinstance.getPersistentData().getDouble("z_power")));
                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                     break;
                  }
               }

               entity.getPersistentData().putDouble("x_pos", x_pos);
               entity.getPersistentData().putDouble("y_pos", y_pos);
               entity.getPersistentData().putDouble("z_pos", z_pos);
               x_pos = entity.getPersistentData().getDouble("cnt7");
               y_pos = entity.getPersistentData().getDouble("cnt8");
               z_pos = entity.getPersistentData().getDouble("cnt9");

               for(int index3 = 0; index3 < 20; ++index3) {
                  ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 5.0, Mth.nextDouble(RandomSource.create(), 5.0, 10.0), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_water");
               }

               if (entity.getPersistentData().getDouble("cnt5") > 40.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt4") > 15.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
                  }
               }

               if (blood) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(2.0 * dis), 0.1 * dis, 0.1 * dis, 0.1 * dis, 0.0);
                  }
               } else {
                  yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  dis = Math.toRadians((double)entity.getXRot());
                  x_pos = entity.getX() + Math.cos(yaw) * Math.cos(dis) * dis;
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(dis) * -1.0 * dis;
                  z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(dis) * dis;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)(4.0 * dis), 0.1 * dis, 0.1 * dis, 0.1 * dis, 0.0);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z") || !(entity instanceof Player) && GetDistanceProcedure.execute(entity) > 24.0) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 13.0));
                  if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }

                     if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     ChargeParticleProcedure.execute(world, entity, 10.0);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               yaw = (double)(entity.getYRot() % 360.0F);
               picth = (double)entity.getXRot();
               entity.setYRot((float)(yaw + (Math.random() - 0.5) * 90.0));
               entity.setXRot((float)picth);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

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

                  x_pos = ((Entity)var10000).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  double var125 = ((Entity)var10000).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var125 + (double)((Entity)var10001).getBbHeight() * 0.5;
                  LivingEntity var126;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var126 = _mobEnt.getTarget();
                  } else {
                     var126 = null;
                  }

                  z_pos = ((Entity)var126).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               entity.setYRot((float)yaw);
               entity.setXRot((float)picth);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               dis = Math.toRadians((double)entity.getXRot());
               distance = (double)(2.0F + entity.getBbWidth()) * dis;
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(dis) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(dis) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(dis) * distance;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                     entityinstance.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * 0.75 * CNT6);
                     entityinstance.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * 0.75 * CNT6);
                     entityinstance.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * 0.75 * CNT6);
                     entityinstance.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75 * CNT6, entity.getPersistentData().getDouble("y_power") * 0.75 * CNT6, entity.getPersistentData().getDouble("z_power") * 0.75 * CNT6));
                     if (blood) {
                        if (entityinstance instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntSetI = (EntityWaterEntity)entityinstance;
                           _datEntSetI.getEntityData().set(EntityWaterEntity.DATA_type, 1);
                        }

                        entityinstance.getPersistentData().putBoolean("death_painting", entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0 : entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting"))));
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (blood) {
                  double var127;
                  int var10002;
                  label289: {
                     var127 = entity.getPersistentData().getDouble("cnt2");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10002 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label289;
                        }
                     }

                     var10002 = 0;
                  }

                  if (var127 > (double)Math.min(20 + var10002, 35) * CNT6) {
                     entity.getPersistentData().putDouble("skill", 0.0);
                  }
               } else {
                  int var129;
                  double var128;
                  label294: {
                     var128 = entity.getPersistentData().getDouble("cnt2");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var129 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label294;
                        }
                     }

                     var129 = 0;
                  }

                  if (var128 > (double)Math.min(10 + var129, 25) * CNT6) {
                     entity.getPersistentData().putDouble("skill", 0.0);
                  }
               }
            }
         }

      }
   }
}
