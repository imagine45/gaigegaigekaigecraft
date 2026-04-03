package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChimeraShadowGardenActiveProcedure {
   public ChimeraShadowGardenActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos;
         double z_pos;
         double loop_num;
         double y_pos;
         boolean breakLoop;
         double range;
         double var10000;
         label260: {
            double distance = 0.0;
            double ticks = 0.0;
            double z_center = 0.0;
            range = 0.0;
            double rad1 = 0.0;
            x_pos = 0.0;
            z_pos = 0.0;
            double y_center = 0.0;
            double x_center = 0.0;
            loop_num = 0.0;
            y_pos = 0.0;
            breakLoop = false;
            boolean logic_hit = false;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label260;
               }
            }

            var10000 = 0.0;
         }

         double var39 = var10000;
         double var44 = entity.getPersistentData().getDouble("x_pos_doma");
         double var43 = entity.getPersistentData().getDouble("y_pos_doma");
         double var40 = entity.getPersistentData().getDouble("z_pos_doma");
         if (entity.getPersistentData().getBoolean("Failed")) {
            if (entity.onGround() && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 20, 1.0, 0.0, 1.0, 0.05);
            }
         } else {
            double var42 = Math.toRadians(90.0 * (var39 % 4.0));
            double var38 = 4.0 * var39 % (range * 0.5 - 5.0);

            for(int index0 = 0; index0 < 5; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.7)) {
                     var42 += Math.toRadians(10.0 * Math.random());
                     x_pos = var44 + Math.cos(var42) * var38;
                     y_pos = var43 + 0.25;
                     z_pos = var40 + Math.sin(var42) * var38;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 1, 0.2, 0.0, 0.2, 0.05);
                     }
                  }
               }

               ++var38;
            }
         }

         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         if (!entity.getPersistentData().getBoolean("Failed")) {
            boolean var45 = false;
            Vec3 _center = new Vec3(var44, var43, var40);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.removeEffect(MobEffects.JUMP);
                  }

                  if (world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 0.0, entityiterator.getZ())).getBlock() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get() || world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1.0, entityiterator.getZ())).getBlock() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get() || world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 2.0, entityiterator.getZ())).getBlock() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get() || world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 3.0, entityiterator.getZ())).getBlock() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get()) {
                     entityiterator.setDeltaMovement(new Vec3(0.0, Math.min(entityiterator.getDeltaMovement().y(), 0.0), 0.0));
                     if (!world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 0.5, entityiterator.getZ())).canOcclude()) {
                        entityiterator.teleportTo(entityiterator.getX(), entityiterator.getY() - 0.5, entityiterator.getZ());
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.connection.teleport(entityiterator.getX(), entityiterator.getY() - 0.5, entityiterator.getZ(), entityiterator.getYRot(), entityiterator.getXRot());
                        }
                     }
                  }

                  if (!var45 || Math.random() < 0.5) {
                     var45 = true;
                     var44 = entityiterator.getX();
                     var43 = entityiterator.getY();
                     var40 = entityiterator.getZ();
                  }
               }
            }

            if (var39 % 40.0 == 0.0) {
               for(int index2 = 0; index2 < 2; ++index2) {
                  if (!var45) {
                     var44 = entity.getPersistentData().getDouble("x_pos_doma") + (Math.random() - 0.5) * range * 0.5;
                     var43 = entity.getPersistentData().getDouble("y_pos_doma") + Math.random() * 0.1;
                     var40 = entity.getPersistentData().getDouble("z_pos_doma") + (Math.random() - 0.5) * range * 0.5;
                  }

                  for(int index3 = 0; index3 < 128; ++index3) {
                     x_pos = var44 + (Math.random() - 0.5) * 8.0;
                     y_pos = var43;
                     z_pos = var40 + (Math.random() - 0.5) * 8.0;
                     if (Math.sqrt(Math.pow(x_pos - entity.getPersistentData().getDouble("x_pos_doma"), 2.0) + Math.pow(var43 - entity.getPersistentData().getDouble("y_pos_doma"), 2.0) + Math.pow(z_pos - entity.getPersistentData().getDouble("z_pos_doma"), 2.0)) < range * 0.5 - 4.0) {
                        break;
                     }
                  }

                  if (var39 % 160.0 == 0.0) {
                     x_pos = var44;
                     z_pos = var40;

                     for(int index4 = 0; index4 < (int)(range / 2.0); ++index4) {
                        ++y_pos;
                        if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos, y_pos + 1.0, z_pos)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos + 0.0, y_pos + 1.0, z_pos + 1.0)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos + 1.0, y_pos + 1.0, z_pos + 0.0)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos + 0.0, y_pos + 1.0, z_pos + -1.0)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos + -1.0, y_pos + 1.0, z_pos + 0.0)).canOcclude()) {
                           break;
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.MAX_ELEPHANT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                           entityinstance.setYRot((float)(Math.random() * 360.0));
                           entityinstance.setXRot(0.0F);
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }

                     breakLoop = true;
                  } else if (var39 % 120.0 == 0.0) {
                     for(int index5 = 0; index5 < 128 && !(Math.sqrt(Math.pow(x_pos - entity.getPersistentData().getDouble("x_pos_doma"), 2.0) + Math.pow(y_pos - entity.getPersistentData().getDouble("y_pos_doma"), 2.0) + Math.pow(z_pos - entity.getPersistentData().getDouble("z_pos_doma"), 2.0)) < range * 0.5 - 4.0); ++index5) {
                        x_pos = var44 + (Math.random() - 0.5) * 8.0;
                        y_pos = var43;
                        z_pos = var40 + (Math.random() - 0.5) * 8.0;
                     }

                     if (loop_num == 0.0) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.DIVINE_DOG_BLACK.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                              entityinstance.setYRot((float)(Math.random() * 360.0));
                              entityinstance.setXRot(0.0F);
                              entityinstance.setYBodyRot(entityinstance.getYRot());
                              entityinstance.setYHeadRot(entityinstance.getYRot());
                              entityinstance.yRotO = entityinstance.getYRot();
                              entityinstance.xRotO = entityinstance.getXRot();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.yBodyRotO = _entity.getYRot();
                                 _entity.yHeadRotO = _entity.getYRot();
                              }

                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }
                     } else if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.DIVINE_DOG_WHITE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                           entityinstance.setYRot((float)(Math.random() * 360.0));
                           entityinstance.setXRot(0.0F);
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  } else if (var39 % 80.0 != 0.0) {
                     if (var39 % 40.0 == 0.0) {
                        x_pos = var44;
                        z_pos = var40;
                        breakLoop = true;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.TOAD_2.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var44, y_pos, var40), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                              entityinstance.setYRot((float)(Math.random() * 360.0));
                              entityinstance.setXRot(0.0F);
                              entityinstance.setYBodyRot(entityinstance.getYRot());
                              entityinstance.setYHeadRot(entityinstance.getYRot());
                              entityinstance.yRotO = entityinstance.getYRot();
                              entityinstance.xRotO = entityinstance.getXRot();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.yBodyRotO = _entity.getYRot();
                                 _entity.yHeadRotO = _entity.getYRot();
                              }

                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }
                     }
                  } else {
                     y_pos += 4.0;

                     for(int index6 = 0; index6 < 128 && !(Math.sqrt(Math.pow(x_pos - entity.getPersistentData().getDouble("x_pos_doma"), 2.0) + Math.pow(y_pos - entity.getPersistentData().getDouble("y_pos_doma"), 2.0) + Math.pow(z_pos - entity.getPersistentData().getDouble("z_pos_doma"), 2.0)) < range * 0.5 - 4.0); ++index6) {
                        x_pos = var44 + (Math.random() - 0.5) * 8.0;
                        y_pos = var43;
                        z_pos = var40 + (Math.random() - 0.5) * 8.0;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.NUE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                           entityinstance.setYRot((float)(Math.random() * 360.0));
                           entityinstance.setXRot(0.0F);
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.1);
                  }

                  ++loop_num;
                  if (breakLoop) {
                     break;
                  }
               }
            }
         }

      }
   }
}
