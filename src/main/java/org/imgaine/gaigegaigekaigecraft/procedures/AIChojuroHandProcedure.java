package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityHandEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIChojuroHandProcedure {
   public AIChojuroHandProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         double HP = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double rad = 0.0;
         double x_power = 0.0;
         double entity_size = 0.0;
         double y_pos = 0.0;
         entity.fallDistance = 0.0F;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0 && entity.getPersistentData().getDouble("skill") >= 400.0 && entity.getPersistentData().getDouble("skill") < 500.0) {
            if (entity instanceof EntityHandEntity) {
               EntityHandEntity animatable = (EntityHandEntity)entity;
               animatable.setTexture("ball_maximum");
            }

            if (entity instanceof EntityHandEntity) {
               EntityHandEntity _datEntSetL = (EntityHandEntity)entity;
               _datEntSetL.getEntityData().set(EntityHandEntity.DATA_Magma, true);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         attack = false;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = (double)(2.0F + (entity.getBbHeight() + entity.getBbWidth()) * 1.0F);
         speed = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_power"), 2.0));
         entity.getPersistentData().putDouble("y_knockback", 0.5);
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

                     label329: {
                        if (entity instanceof EntityHandEntity) {
                           EntityHandEntity _datEntL35 = (EntityHandEntity)entity;
                           if ((Boolean)_datEntL35.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)range, range, range, range, 1.0);
                              }
                              break label329;
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)range, range, range, range, 1.0);
                        }
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

            for(int index2 = 0; index2 < (int)(speed * 3.0); ++index2) {
               CompoundTag var10000;
               byte var10002;
               label316: {
                  entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", 0.25 * Math.pow(CNT6, 2.0));
                  entity.getPersistentData().putDouble("Range", range);
                  var10000 = entity.getPersistentData();
                  if (entity instanceof EntityHandEntity) {
                     EntityHandEntity _datEntL42 = (EntityHandEntity)entity;
                     if ((Boolean)_datEntL42.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                        var10002 = 10;
                        break label316;
                     }
                  }

                  var10002 = 1;
               }

               var10000.putDouble("effect", (double)var10002);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
               entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
               }

               entity.getPersistentData().putDouble("movement_amount", entity.getPersistentData().getDouble("movement_amount") + 1.0);
               if (entity.getPersistentData().getDouble("movement_amount") >= 1.0 * range && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).canOcclude()) {
                  label306: {
                     logic_a = true;
                     entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                     BulletDomainHit2Procedure.execute(world, entity);
                     entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 0.25 * Math.pow(CNT6, 2.0));
                     entity.getPersistentData().putDouble("Range", range);
                     var10000 = entity.getPersistentData();
                     if (entity instanceof EntityHandEntity) {
                        EntityHandEntity _datEntL63 = (EntityHandEntity)entity;
                        if ((Boolean)_datEntL63.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                           var10002 = 10;
                           break label306;
                        }
                     }

                     var10002 = 1;
                  }

                  var10000.putDouble("effect", (double)var10002);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  break;
               }
            }

            if (logic_a) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

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

                     label287: {
                        if (entity instanceof EntityHandEntity) {
                           EntityHandEntity _datEntL76 = (EntityHandEntity)entity;
                           if ((Boolean)_datEntL76.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                              }
                              break label287;
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                        }
                     }

                     world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId(world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos))));
                     break;
                  }
               }

               entity.getPersistentData().putDouble("x_pos", x_pos);
               entity.getPersistentData().putDouble("y_pos", y_pos);
               entity.getPersistentData().putDouble("z_pos", z_pos);

               for(int index4 = 0; index4 < 10; ++index4) {
                  int var10001;
                  label263: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label263;
                        }
                     }

                     var10001 = 0;
                  }

                  HP = (double)(40 + var10001 * 8);
                  rad = Math.toRadians(Math.random() * 720.0);
                  dis = range * 0.3;
                  x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(rad) * dis;
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(rad) * dis;

                  for(int index5 = 0; index5 < (int)(range * 0.5); ++index5) {
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        ++y_pos;
                     } else {
                        if (world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                           break;
                        }

                        --y_pos;
                     }
                  }

                  if (entity instanceof EntityHandEntity) {
                     EntityHandEntity _datEntL90 = (EntityHandEntity)entity;
                     if ((Boolean)_datEntL90.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                        continue;
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROCK_FRAGMENT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity93 = (LivingEntity)entityinstance;
                           if (_livingEntity93.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity93.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        if (GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity) {
                           entityinstance.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                           entity.getPersistentData().putDouble("NameRanged", 0.0);
                           entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged_ranged"));
                        }

                        entityinstance.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
                        entityinstance.setDeltaMovement(new Vec3((Math.random() - 0.5) * 3.0, Math.random() * 1.5 + 0.75, (Math.random() - 0.5) * 3.0));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity112 = (LivingEntity)entityinstance;
                           if (_livingEntity112.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity112.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.0 + Math.random());
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }

               entity.getPersistentData().putDouble("cnt2", 1.0);
            }

            attack = true;
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") > 120.0 && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }

            if (entity instanceof EntityHandEntity) {
               EntityHandEntity _datEntL121 = (EntityHandEntity)entity;
               if ((Boolean)_datEntL121.getEntityData().get(EntityHandEntity.DATA_Magma) && entity.getPersistentData().getDouble("cnt3") > 20.0) {
                  entity.teleportTo(entity.getX() + 0.0, entity.getY() - 0.5, entity.getZ() + 0.0);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX() + 0.0, entity.getY() - 0.5, entity.getZ() + 0.0, entity.getYRot(), entity.getXRot());
                  }

                  if (entity.getPersistentData().getDouble("cnt3") > 60.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("move") == 0.0 && attack) {
            CompoundTag var103;
            byte var105;
            label251: {
               entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
               var103 = entity.getPersistentData();
               if (entity instanceof EntityHandEntity) {
                  EntityHandEntity _datEntL132 = (EntityHandEntity)entity;
                  if ((Boolean)_datEntL132.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                     var105 = 10;
                     break label251;
                  }
               }

               var105 = 1;
            }

            var103.putDouble("effect", (double)var105);
            entity.getPersistentData().putDouble("knockback", 0.01);
            entity.getPersistentData().putDouble("Range", range);
            RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
            entity.getPersistentData().putDouble("BlockDamage", 6.0 * CNT6);
            entity.getPersistentData().putDouble("BlockRange", 0.5 * range);
            if (entity instanceof EntityHandEntity) {
               EntityHandEntity _datEntL142 = (EntityHandEntity)entity;
               if ((Boolean)_datEntL142.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                  entity.getPersistentData().putDouble("effect", 3.0);
               }
            }

            entity.getPersistentData().putBoolean("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
         }

         if (!entity.isAlive()) {
            BlockPos var106;
            BlockState var10003;
            label244: {
               entity_size = ReturnEntitySizeProcedure.execute(entity);
               x_pos = entity.getX();
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
               z_pos = entity.getZ();
               var106 = BlockPos.containing(x_pos, y_pos, z_pos);
               if (entity instanceof EntityHandEntity) {
                  EntityHandEntity _datEntL154 = (EntityHandEntity)entity;
                  if ((Boolean)_datEntL154.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                     var10003 = Blocks.MAGMA_BLOCK.defaultBlockState();
                     break label244;
                  }
               }

               var10003 = Blocks.COBBLESTONE.defaultBlockState();
            }

            world.levelEvent(2001, var106, Block.getId(var10003));
            if (!entity.isAlive()) {
               label237: {
                  if (entity instanceof EntityHandEntity) {
                     EntityHandEntity _datEntL157 = (EntityHandEntity)entity;
                     if ((Boolean)_datEntL157.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, (int)(10.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
                        }
                        break label237;
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(20.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)(20.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
               }
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
