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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class KugisakiDomainExpansionProcedure {
   public KugisakiDomainExpansionProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double pitch_s = 0.0;
         double yaw_s = 0.0;
         double num1 = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("select", 34.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 4.0F, 0.8F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 4.0F, 0.8F, false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 40, 3.0, 0.0, 3.0, 0.05);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 33.0 && entity.getPersistentData().getDouble("cnt1") == 34.0) {
               dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 4.0F, 0.8F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 4.0F, 0.8F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 40, 3.0, 0.0, 3.0, 0.25);
               }

               yaw_s = (double)entity.getYRot();
               pitch_s = (double)entity.getXRot();
               RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
               entity.setYRot(entity.getYRot());
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

               num1 = 0.0;
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                  entity.getPersistentData().putDouble("NameRanged", Math.random());
               }

               for(int index0 = 0; index0 < 8; ++index0) {
                  x_pos = entity.getPersistentData().getDouble("x_pos_doma") - Math.cos(yaw) * Math.cos(pitch) * (dis - 8.0);
                  y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                  z_pos = entity.getPersistentData().getDouble("z_pos_doma") - Math.sin(yaw) * Math.cos(pitch) * (dis - 8.0);
                  if (num1 % 2.0 == 0.0) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOMAIN_KUGISAKI.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                              entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                           }

                           entityinstance.setYRot((float)(Math.toDegrees(yaw) - 90.0));
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
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                        }

                        entityinstance.setYRot((float)(Math.toDegrees(yaw) - 90.0));
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

                        entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity46 = (LivingEntity)entityinstance;
                           if (_livingEntity46.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity46.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.5);
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  yaw += Math.toRadians(45.0);
                  ++num1;
               }

               entity.setYRot((float)yaw_s);
               entity.setXRot((float)pitch_s);
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
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
