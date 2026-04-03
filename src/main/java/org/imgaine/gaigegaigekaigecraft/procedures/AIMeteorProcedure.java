package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIMeteorProcedure {
   public AIMeteorProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double distance = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double num_a = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double entity_size = 0.0;
         double z_knockback = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double y_knockback = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity) * 2.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
         entity.fallDistance = 0.0F;
         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         int var10000;
         if (entity instanceof MeteorEntity) {
            MeteorEntity _datEntI = (MeteorEntity)entity;
            var10000 = (Integer)_datEntI.getEntityData().get(MeteorEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 == 0) {
            entity.setYRot((float)((double)entity.getYRot() + 22.5));
            entity.setXRot(0.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
            double var119;
            label326: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity9 = (LivingEntity)entity;
                  if (_livingEntity9.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var119 = _livingEntity9.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                     break label326;
                  }
               }

               var119 = 0.0;
            }

            if (var119 < 1.0 && entity instanceof LivingEntity) {
               LivingEntity _livingEntity11 = (LivingEntity)entity;
               if (_livingEntity11.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  AttributeInstance var120;
                  label319: {
                     var120 = _livingEntity11.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity10 = (LivingEntity)entity;
                        if (_livingEntity10.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity10.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label319;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var120.setBaseValue(Math.min(var10001 + 0.01, 1.0));
               }
            }

            logic_a = true;
            entity.getPersistentData().putDouble("x_power", 0.0);
            entity.getPersistentData().putDouble("y_power", -1.5);
            entity.getPersistentData().putDouble("z_power", 0.0);
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity_a instanceof LivingEntity) {
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity_a.getPersistentData().getDouble("NameRanged") == entity.getPersistentData().getDouble("NameRanged_ranged")) {
                  if (entity_a.getPersistentData().getDouble("skill") == 415.0) {
                     entity.teleportTo(entity_a.getX() + 0.0, entity_a.getY() + (double)(entity_a.getBbHeight() * 1.0F) + (double)(entity.getBbHeight() * 1.0F) + 3.0, entity_a.getZ() + 0.0);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity_a.getX() + 0.0, entity_a.getY() + (double)(entity_a.getBbHeight() * 1.0F) + (double)(entity.getBbHeight() * 1.0F) + 3.0, entity_a.getZ() + 0.0, entity.getYRot(), entity.getXRot());
                     }

                     entity.setYRot(entity_a.getYRot());
                     entity.setXRot(entity_a.getXRot());
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (entity_a.getPersistentData().getDouble("cnt1") > 100.0) {
                        logic_a = false;
                        LivingEntity var121;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var121 = _mobEnt.getTarget();
                        } else {
                           var121 = null;
                        }

                        if (var121 instanceof LivingEntity) {
                           EntityAnchorArgument.Anchor var123 = Anchor.EYES;
                           Vec3 var10002;
                           LivingEntity var10004;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10004 = _mobEnt.getTarget();
                           } else {
                              var10004 = null;
                           }

                           double var124 = ((Entity)var10004).getX();
                           LivingEntity var10005;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10005 = _mobEnt.getTarget();
                           } else {
                              var10005 = null;
                           }

                           double var125 = ((Entity)var10005).getY();
                           LivingEntity var10006;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10006 = _mobEnt.getTarget();
                           } else {
                              var10006 = null;
                           }

                           var10002 = new Vec3(var124, var125, ((Entity)var10006).getZ());
                           entity_a.lookAt(var123, var10002);
                        }

                        yaw = (double)entity_a.getYRot();
                        pitch = (double)entity_a.getXRot();
                        entity_a.setYRot((float)yaw);
                        entity_a.setXRot((float)Math.max(pitch, 67.5));
                        entity_a.setYBodyRot(entity_a.getYRot());
                        entity_a.setYHeadRot(entity_a.getYRot());
                        entity_a.yRotO = entity_a.getYRot();
                        entity_a.xRotO = entity_a.getXRot();
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        entity.getPersistentData().putDouble("x_power", entity_a.getLookAngle().x * 1.5);
                        entity.getPersistentData().putDouble("y_power", entity_a.getLookAngle().y * 1.5);
                        entity.getPersistentData().putDouble("z_power", entity_a.getLookAngle().z * 1.5);
                        entity_a.setYRot((float)yaw);
                        entity_a.setXRot((float)pitch);
                        entity_a.setYBodyRot(entity_a.getYRot());
                        entity_a.setYHeadRot(entity_a.getYRot());
                        entity_a.yRotO = entity_a.getYRot();
                        entity_a.xRotO = entity_a.getXRot();
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }
                     }
                  } else {
                     logic_a = false;
                  }
               } else {
                  logic_a = false;
               }
            } else {
               logic_a = false;
            }

            if (!logic_a && entity.getPersistentData().getDouble("cnt_life") > 60.0) {
               entity.getPersistentData().putDouble("cnt_life", 100.0);
               if (entity instanceof MeteorEntity) {
                  MeteorEntity _datEntSetI = (MeteorEntity)entity;
                  _datEntSetI.getEntityData().set(MeteorEntity.DATA_mode, 1);
               }
            }

            if (entity.getPersistentData().getDouble("cnt_life") % 5.0 == 1.0) {
               entity.getPersistentData().putDouble("BlockRange", 24.0);
               entity.getPersistentData().putDouble("BlockDamage", 15.0);
               entity.getPersistentData().putDouble("knockback", -1.0);
               entity.getPersistentData().putDouble("effect", 3.0);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            }

            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(24.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_living")))) {
                  x_knockback = entityiterator.getX() - entity.getX();
                  y_knockback = entityiterator.getY() - entity.getY();
                  z_knockback = entityiterator.getZ() - entity.getZ();
                  dis = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                  if (dis != 0.0) {
                     x_knockback = x_knockback / dis * 3.0;
                     y_knockback = y_knockback / dis * 3.0;
                     z_knockback = z_knockback / dis * 3.0;
                  }

                  entityiterator.setDeltaMovement(new Vec3(x_knockback, y_knockback, z_knockback));
               }
            }

            for(int index0 = 0; index0 < (int)(4.0F * entity.getBbHeight()); ++index0) {
               yaw = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               pitch = Math.toRadians((double)entity.getXRot());
               distance = Mth.nextDouble(RandomSource.create(), 0.5, 1.0);
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               y_pos = entity.getY() + 0.5 * (double)entity.getBbHeight() + Math.sin(pitch) * -1.0 * distance * (double)entity.getBbWidth();
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               y_pos -= (distance - 0.5) * 2.0 * (double)entity.getBbHeight();
               ParticleGeneratorProcedure.execute(world, (double)entity.getBbWidth() * 0.25, 1.0, 0.0, 1.0, x_pos, x_pos + Math.cos(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.getBbWidth(), y_pos, y_pos + Math.sin(pitch) * -1.0 * distance * (double)entity.getBbWidth(), z_pos, z_pos + Math.sin(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.getBbWidth(), "minecraft:flame");
            }

            for(int index1 = 0; index1 < (int)(4.0F * entity.getBbHeight()); ++index1) {
               yaw = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               pitch = Math.toRadians((double)entity.getXRot());
               distance = Mth.nextDouble(RandomSource.create(), 0.5, 1.0);
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               y_pos = entity.getY() - 0.5 * (double)entity.getBbHeight() + Math.sin(pitch) * -1.0 * distance * (double)entity.getBbWidth();
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               y_pos += (distance - 0.5) * 2.0 * (double)entity.getBbHeight();
               ParticleGeneratorProcedure.execute(world, (double)entity.getBbWidth() * 0.25, 1.0, 0.0, 1.0, x_pos, x_pos + Math.cos(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.getBbWidth(), y_pos, y_pos + Math.sin(pitch) * -1.0 * distance * (double)entity.getBbWidth(), z_pos, z_pos + Math.sin(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.getBbWidth(), "minecraft:flame");
            }
         }

         if (entity instanceof MeteorEntity) {
            MeteorEntity _datEntI = (MeteorEntity)entity;
            var10000 = (Integer)_datEntI.getEntityData().get(MeteorEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 != 0) {
            if (22.5 - (entity.getPersistentData().getDouble("cnt_life") - 100.0) > 0.0) {
               entity.setYRot((float)((double)entity.getYRot() + Math.max(0.0, 22.5 - (entity.getPersistentData().getDouble("cnt_life") - 100.0))));
               entity.setXRot(0.0F);
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

            x_power = entity.getPersistentData().getDouble("x_power");
            y_power = entity.getPersistentData().getDouble("y_power");
            z_power = entity.getPersistentData().getDouble("z_power");
            if (entity.getPersistentData().getDouble("cnt_life") < 200.0) {
               entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > 1.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               } else {
                  dis = 1.0;
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();

               for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                  ++num_a;
                  if (num_a > 0.0) {
                     num_a = 3.0 * entity_size * -0.5;
                     entity.getPersistentData().putDouble("Damage", 50.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 3.0 * entity_size);
                     entity.getPersistentData().putDouble("knockback", 2.0);
                     entity.getPersistentData().putDouble("effect", 3.0);
                     entity.getPersistentData().putBoolean("attack", false);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (!entity.isInWall() && !InsideSolidCalculateProcedure.execute(world, entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                     entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                     }
                  } else {
                     entity.getPersistentData().putDouble("BlockRange", Math.min(2.0 * entity_size, 24.0));
                     entity.getPersistentData().putDouble("BlockDamage", 15.0 * CNT6);
                     entity.getPersistentData().putDouble("effect", 3.0);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     entity.getPersistentData().putBoolean("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity);
                     if (InsideSolidCalculateProcedure.execute(world, entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5)) {
                        break;
                     }
                  }
               }

               entity.getPersistentData().putDouble("Damage", 50.0 * CNT6);
               entity.getPersistentData().putDouble("Range", 3.0 * entity_size);
               entity.getPersistentData().putDouble("knockback", 2.0);
               entity.getPersistentData().putDouble("effect", 3.0);
               entity.getPersistentData().putBoolean("attack", false);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);

               for(int index3 = 0; index3 < 36; ++index3) {
                  ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 4.0, Mth.nextDouble(RandomSource.create(), 4.0, 4.0), x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 1.0), 0.0, z_pos, z_pos, "flame");
                  ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 1.0, Mth.nextDouble(RandomSource.create(), 2.0, 4.0), x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.05, 0.25), 0.0, z_pos, z_pos, "gaigegaigekaigecraft:particle_flame");
               }
            }

            if (entity.isInWall() || InsideSolidCalculateProcedure.execute(world, entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth()) || !entity.isAlive() || entity.getPersistentData().getDouble("cnt_life") >= 200.0) {
               entity.getPersistentData().putDouble("cnt_life", Math.max(entity.getPersistentData().getDouble("cnt_life"), 200.0));
               distance = (double)entity.getBbWidth() * 0.5;
               x_pos = entity.getX() + x_power * distance;
               y_pos = entity.getY() + y_power * distance;
               z_pos = entity.getZ() + z_power * distance;
               if (entity.getPersistentData().getDouble("cnt_life") < 240.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)(8.0 * CNT6 * entity_size), 1.0 * entity_size, 1.0 * entity_size, 1.0 * entity_size, 2.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME.get(), x_pos, y_pos, z_pos, (int)(8.0 * CNT6 * entity_size), 1.0 * entity_size, 1.0 * entity_size, 1.0 * entity_size, 2.0);
                  }

                  if (entity.getPersistentData().getDouble("cnt_life") % 10.0 == 0.0) {
                     entity.getPersistentData().putDouble("BlockRange", Math.min(3.0 * entity_size, 32.0));
                     entity.getPersistentData().putDouble("BlockDamage", 20.0 * CNT6);
                     entity.getPersistentData().putDouble("effect", 3.0);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     entity.getPersistentData().putBoolean("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  } else if (entity.getPersistentData().getDouble("cnt_life") <= 208.0) {
                     entity.getPersistentData().putDouble("BlockRange", Math.min(2.0 * entity_size, 24.0));
                     entity.getPersistentData().putDouble("BlockDamage", 20.0 * CNT6);
                     entity.getPersistentData().putDouble("effect", 3.0);
                     entity.getPersistentData().putBoolean("noParticle", true);
                     entity.getPersistentData().putBoolean("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos + Math.sin(Math.toRadians(entity.getPersistentData().getDouble("cnt_life") * 45.0)) * 1.0 * Math.min(3.0 * entity_size, 32.0), y_pos, z_pos + Math.cos(Math.toRadians(entity.getPersistentData().getDouble("cnt_life") * 45.0)) * 1.0 * Math.min(3.0 * entity_size, 32.0), entity);
                  }

                  if (entity.getPersistentData().getDouble("cnt_life") % 10.0 == 0.0) {
                     if (entity.getPersistentData().getDouble("cnt_life") == 200.0) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, (int)(20.0 * CNT6 * entity_size), 2.0 * entity_size, 2.0 * entity_size, 2.0 * entity_size, 2.0);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME.get(), x_pos, y_pos, z_pos, (int)(40.0 * CNT6 * entity_size), 1.0 * entity_size, 1.0 * entity_size, 1.0 * entity_size, 4.0);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.8F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.8F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.9F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 5.0F, 0.9F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.9F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.9F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.8F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 0.8F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.9F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.9F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.8F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 5.0F, 0.8F, false);
                           }
                        }
                     }

                     entity.getPersistentData().putDouble("Damage", 70.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 2.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 6.0 * entity_size);
                     entity.getPersistentData().putDouble("effect", 3.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (entity.getPersistentData().getDouble("cnt_life") <= 208.0) {
                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();

                     for(int index4 = 0; index4 < 36; ++index4) {
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 4.0, Mth.nextDouble(RandomSource.create(), 8.0, 16.0), x_pos, x_pos, y_pos, y_pos + Mth.nextDouble(RandomSource.create(), 0.0, 1.0), 0.0, z_pos, z_pos, "gaigegaigekaigecraft:particle_flame");
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt_life") > 260.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
