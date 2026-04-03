package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEntityJacobsLadderProcedure {
   public AIEntityJacobsLadderProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         double CNT6 = 0.0;
         double distance = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double y_pos_center = 0.0;
         double HP = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         x_pos = entity.getX();
         y_pos = entity.getY();
         z_pos = entity.getZ();
         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            logic_attack = false;
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity_a.getPersistentData().getDouble("skill") > 0.0 && entity_a.getPersistentData().getDouble("cnt1") <= 10.0) {
                  logic_attack = true;
                  entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), entity_a.getPersistentData().getDouble("cnt6")));
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FLASH, entity.getX(), entity.getY(), entity.getZ(), 10, (double)entity.getBbWidth() * 0.1, 0.0, (double)entity.getBbWidth() * 0.1, 0.0);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity22 = (LivingEntity)entity;
                     if (_livingEntity22.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        AttributeInstance var10000;
                        double var10001;
                        label174: {
                           var10000 = _livingEntity22.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity20 = (LivingEntity)entity;
                              if (_livingEntity20.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity20.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                                 break label174;
                              }
                           }

                           var10001 = 0.0;
                        }

                        var10000.setBaseValue(Math.max(var10001, entity.getPersistentData().getDouble("cnt6") + 1.0));
                     }
                  }

                  x_pos = entity.getX();
                  y_pos = entity.getY();
                  z_pos = entity.getZ();
                  x_pos = entity.getX() + Math.min(Math.abs(entity_a.getPersistentData().getDouble("x_pos") - entity.getX()), 0.25) * (double)(entity_a.getPersistentData().getDouble("x_pos") > entity.getX() ? 1 : -1);
                  y_pos = entity.getY() + Math.min(Math.abs(entity_a.getPersistentData().getDouble("y_pos") + 16.0 + 8.0 * CNT6 - entity.getY()), 0.25) * (double)(entity_a.getPersistentData().getDouble("y_pos") + 16.0 + 8.0 * CNT6 > entity.getY() ? 1 : -1);
                  z_pos = entity.getZ() + Math.min(Math.abs(entity_a.getPersistentData().getDouble("z_pos") - entity.getZ()), 0.25) * (double)(entity_a.getPersistentData().getDouble("z_pos") > entity.getZ() ? 1 : -1);
                  entity.teleportTo(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                  }
               }
            }

            if (!logic_attack) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
               BulletDomainHit2Procedure.execute(world, entity);
               if (entity.getX() != x_pos || entity.getY() != y_pos || entity.getZ() != z_pos) {
                  entity.teleportTo(entity.getX(), entity.getY() + 16.0 + 8.0 * CNT6, entity.getZ());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 16.0 + 8.0 * CNT6, entity.getZ(), entity.getYRot(), entity.getXRot());
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            range = (double)entity.getBbWidth() * 0.5;
            if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLASH, entity.getX(), entity.getY(), entity.getZ(), 5, 1.0, 1.0, 1.0, 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt1") <= 7.0) {
                  for(int index0 = 0; index0 < 128 && world.isEmptyBlock(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)); ++index0) {
                     --y_pos;
                  }

                  y_pos_center = y_pos;

                  for(int index1 = 0; index1 < 128; ++index1) {
                     num1 = Math.toRadians(Math.random() * 720.0);
                     distance = (Math.random() - 0.5) * 32.0 * CNT6;
                     x_pos = entity.getX() + Math.sin(num1) * distance;
                     z_pos = entity.getZ() + Math.cos(num1) * distance;
                     y_pos = y_pos_center + Math.random() * (entity.getY() - y_pos_center);
                     if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_JACOBS_LADDER_ANGEL.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              entityinstance.setYRot((float)Math.toDegrees(num1));
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

                              entityinstance.getPersistentData().putDouble("Damage", 1.0);
                              if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                                 entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                              }

                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.END_ROD, x_pos, y_pos, z_pos, 15, 0.25, 0.25, 0.25, 0.1);
                        }
                        break;
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt2") < 25.0) {
                  if (entity.getPersistentData().getDouble("cnt2") <= Math.min(1.0 + entity.getPersistentData().getDouble("cnt6"), 5.0)) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F);
                        } else {
                           _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F);
                        } else {
                           _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 1.0F, false);
                        }
                     }
                  }

                  range = 1.0 * CNT6;

                  for(int index2 = 0; index2 < 8; ++index2) {
                     entity.getPersistentData().putDouble("Damage", (25.0 + entity.getPersistentData().getDouble("cnt2") * 0.01) * CNT6);
                     entity.getPersistentData().putDouble("Range", 16.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 0.25);
                     entity.getPersistentData().putDouble("effectConfirm", 4.0);
                     entity.getPersistentData().putBoolean("ignore", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);

                     for(int index3 = 0; index3 < 4; ++index3) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle flash ~ ~ ~ " + range * 0.5 + " " + range * 0.5 + " " + range * 0.5 + " " + (0.25 + 0.1 * CNT6) + " " + Math.round(20.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.5)) + " force");
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle end_rod ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " " + (0.25 + 0.1 * CNT6) + " " + Math.round(10.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.5)) + " force");
                        }

                        y_pos -= 2.0;
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt2") > 40.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
