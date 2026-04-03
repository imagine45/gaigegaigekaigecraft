package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GraveyardDomainProcedure {
   public GraveyardDomainProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_center = 0.0;
         double z_center = 0.0;
         double num1 = 0.0;
         double x_pos = 0.0;
         double y_center = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num3 = 0.0;
         double dis = 0.0;
         double num2 = 0.0;
         dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
         x_center = entity.getPersistentData().getDouble("x_pos_doma");
         y_center = entity.getPersistentData().getDouble("y_pos_doma");
         z_center = entity.getPersistentData().getDouble("z_pos_doma");
         entity.getPersistentData().putDouble("select", 25.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_center, y_center, z_center), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x_center, y_center, z_center, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_center, y_center, z_center), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x_center, y_center, z_center, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 34.0) {
               if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                  entity.getPersistentData().putDouble("NameRanged", Math.random());
               }

               for(int index0 = 0; index0 < 24; ++index0) {
                  ++num3;
                  num1 = Math.toRadians(Math.random() * 720.0);

                  for(int index1 = 0; index1 < 32; ++index1) {
                     num2 = Math.random();
                     if (num2 > 0.5) {
                        num2 *= dis - 3.0;
                        break;
                     }
                  }

                  x_pos = x_center + Math.sin(num1) * num2;
                  y_pos = y_center + 1.0;
                  z_pos = z_center + Math.cos(num1) * num2;

                  for(int index2 = 0; index2 < 16; ++index2) {
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        ++y_pos;
                     } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                        --y_pos;
                     } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                        y_pos = Math.floor(y_pos);
                        break;
                     }
                  }

                  if (num3 < 16.0) {
                     if (Math.random() < 0.5) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.GRAVESTONE_1.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                                 entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                              }

                              entityinstance.setYRot((float)(Math.random() * 360.0));
                              entityinstance.setXRot((float)((Math.random() - 0.5) * 30.0));
                              entityinstance.setYBodyRot(entityinstance.getYRot());
                              entityinstance.setYHeadRot(entityinstance.getYRot());
                              entityinstance.yRotO = entityinstance.getYRot();
                              entityinstance.xRotO = entityinstance.getXRot();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.yBodyRotO = _entity.getYRot();
                                 _entity.yHeadRotO = _entity.getYRot();
                              }

                              entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                              entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }
                     } else if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.GRAVESTONE_2.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                              entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                           }

                           entityinstance.setYRot((float)(Math.random() * 360.0));
                           entityinstance.setXRot((float)((Math.random() - 0.5) * 30.0));
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                           entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TREE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                        }

                        entityinstance.setYRot((float)(Math.random() * 360.0));
                        entityinstance.setXRot((float)((Math.random() - 0.5) * 30.0));
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity48 = (LivingEntity)entityinstance;
                           if (_livingEntity48.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity48.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0);
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }
            }

            num1 = Math.toRadians(Math.random() * 360.0);
            num2 = entity.getPersistentData().getDouble("cnt1") * 0.5;
            num3 = Math.toRadians(4.0);

            for(int index3 = 0; index3 < 90; ++index3) {
               x_pos = x_center + Math.sin(num1) * num2;
               z_pos = z_center + Math.cos(num1) * num2;
               if (Math.random() < 0.5 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_center, z_pos, 1, 0.25, Math.max(num2 / 10.0, 0.25), 0.25, 0.0);
               }

               if (Math.random() < 0.5 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL, x_pos, y_center, z_pos, 1, 0.25, Math.max(num2 / 10.0, 0.25), 0.25, 0.0);
               }

               num1 += num3;
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
