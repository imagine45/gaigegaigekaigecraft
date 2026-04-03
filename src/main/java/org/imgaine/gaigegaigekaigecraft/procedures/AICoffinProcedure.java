package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class AICoffinProcedure {
   public AICoffinProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double y_pos = 0.0;
         boolean successed = false;
         boolean flag_kill = false;
         Entity entity_target = null;
         Entity entity_stone = null;
         Entity entity_owner = null;
         entity_owner = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         entity_target = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("TARGET"));
         if (entity.isAlive()) {
            successed = false;
            entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_life") == 15.0 && entity_owner instanceof LivingEntity) {
               entity_owner.getPersistentData().putBoolean("StartDomainAttack", true);
            }

            if (entity_target instanceof LivingEntity) {
               if (entity_target.isAlive()) {
                  entity_target.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity_target.teleportTo(entity.getX(), entity.getY() + 0.25, entity.getZ());
                  if (entity_target instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 0.25, entity.getZ(), entity_target.getYRot(), entity_target.getXRot());
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SCALE_CHANGE.get(), 2, 0, false, false));
                     }
                  }

                  y_pos = entity.getY();

                  for(int index0 = 0; index0 < (int)entity.getBbHeight(); ++index0) {
                     if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), y_pos, entity.getZ()))) {
                        successed = true;
                        break;
                     }

                     ++y_pos;
                  }

                  if (successed) {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     entity.getPersistentData().putDouble("death_count1", entity.getPersistentData().getDouble("death_count1") + 1.0);
                     if (entity.getPersistentData().getDouble("death_count1") > 0.0) {
                        entity.getPersistentData().putDouble("death_count1", -20.0);
                        entity.getPersistentData().putDouble("death_count2", entity.getPersistentData().getDouble("death_count2") + 1.0);

                        for(int index1 = 0; index1 < 2; ++index1) {
                           if (!entity_target.level().isClientSide() && entity_target.getServer() != null) {
                              entity_target.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_target.position(), entity_target.getRotationVector(), entity_target.level() instanceof ServerLevel ? (ServerLevel)entity_target.level() : null, 4, entity_target.getName().getString(), entity_target.getDisplayName(), entity_target.level().getServer(), entity_target), "playsound ui.button.click master @s");
                           }
                        }

                        if (entity.getPersistentData().getDouble("death_count2") <= 3.0) {
                           if (!entity_target.level().isClientSide() && entity_target.getServer() != null) {
                              Commands var10000 = entity_target.getServer().getCommands();
                              CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity_target.position(), entity_target.getRotationVector(), entity_target.level() instanceof ServerLevel ? (ServerLevel)entity_target.level() : null, 4, entity_target.getName().getString(), entity_target.getDisplayName(), entity_target.level().getServer(), entity_target);
                              CompoundTag var10003 = entity.getPersistentData();
                              var10000.performPrefixedCommand(var10001, "title @s title {\"text\":\"\\uE11" + Math.round(4.0 - var10003.getDouble("death_count2")) + "\"}");
                           }
                        } else {
                           if (!entity_target.level().isClientSide() && entity_target.getServer() != null) {
                              entity_target.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_target.position(), entity_target.getRotationVector(), entity_target.level() instanceof ServerLevel ? (ServerLevel)entity_target.level() : null, 4, entity_target.getName().getString(), entity_target.getDisplayName(), entity_target.level().getServer(), entity_target), "title @s title {\"text\":\"\"}");
                           }

                           if (!entity_target.level().isClientSide() && entity_target.getServer() != null) {
                              entity_target.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_target.position(), entity_target.getRotationVector(), entity_target.level() instanceof ServerLevel ? (ServerLevel)entity_target.level() : null, 4, entity_target.getName().getString(), entity_target.getDisplayName(), entity_target.level().getServer(), entity_target), "kill @s");
                           }

                           if (!entity.level().isClientSide()) {
                              entity.discard();
                           }

                           flag_kill = true;
                        }
                     }
                  } else {
                     entity.getPersistentData().putDouble("death_count1", 0.0);
                     entity.getPersistentData().putDouble("death_count2", 0.0);
                  }
               } else {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  flag_kill = true;
               }
            } else {
               entity.getPersistentData().putDouble("death_count1", 0.0);
               entity.getPersistentData().putDouble("death_count2", 0.0);
            }
         }

         if (!entity.isAlive() || flag_kill) {
            entity_stone = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("CONNECT_UUID"));

            for(int index2 = 0; index2 < 100; ++index2) {
               y_pos = entity.getY();
               successed = true;

               for(int index3 = 0; index3 < (int)entity.getBbHeight(); ++index3) {
                  if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), y_pos, entity.getZ()))) {
                     successed = false;
                     break;
                  }

                  ++y_pos;
               }

               if (successed) {
                  break;
               }

               entity.teleportTo(entity.getX(), entity.getY() + 1.0, entity.getZ());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
               }
            }

            if (entity_target instanceof LivingEntity) {
               entity_target.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               entity_target.teleportTo(entity.getX(), entity.getY(), entity.getZ());
               if (entity_target instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ(), entity_target.getYRot(), entity_target.getXRot());
               }

               if (!entity_target.level().isClientSide() && entity_target.getServer() != null) {
                  entity_target.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_target.position(), entity_target.getRotationVector(), entity_target.level() instanceof ServerLevel ? (ServerLevel)entity_target.level() : null, 4, entity_target.getName().getString(), entity_target.getDisplayName(), entity_target.level().getServer(), entity_target), "title @s title {\"text\":\"\"}");
               }
            }

            if (entity_stone instanceof LivingEntity) {
               if (flag_kill) {
                  if (!entity_stone.level().isClientSide()) {
                     entity_stone.discard();
                  }
               } else if (!entity_stone.level().isClientSide() && entity_stone.getServer() != null) {
                  entity_stone.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_stone.position(), entity_stone.getRotationVector(), entity_stone.level() instanceof ServerLevel ? (ServerLevel)entity_stone.level() : null, 4, entity_stone.getName().getString(), entity_stone.getDisplayName(), entity_stone.level().getServer(), entity_stone), "kill @s");
               }
            }

            if (!flag_kill) {
               y_pos = entity.getY();

               for(int index4 = 0; index4 < (int)entity.getBbHeight(); ++index4) {
                  world.levelEvent(2001, BlockPos.containing(entity.getX(), y_pos, entity.getZ()), Block.getId(Blocks.STRIPPED_SPRUCE_WOOD.defaultBlockState()));
                  ++y_pos;
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
