package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AICursedSpiritsFlyingAttack2Procedure {
   public AICursedSpiritsFlyingAttack2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double NUM1 = 0.0;
         String STR1 = "";
         Entity owner_entity = null;
         boolean logic_a = false;
         boolean ownerExist = false;
         boolean teleported = false;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            ownerExist = true;
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         }

         if (entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")) && entity.isAlive()) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("modement_mode") == 0.0) {
               if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
                  entity.getPersistentData().putDouble("cnt1", -5.0);
                  if (ownerExist && entity.getPersistentData().getDouble("friend_num_worker") != 0.0 && entity.getPersistentData().getDouble("friend_num_worker") == owner_entity.getPersistentData().getDouble("friend_num") && entity.getPersistentData().getDouble("friend_num_worker") != owner_entity.getPersistentData().getDouble("friend_num_worker")) {
                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:1b}");
                     }

                     entity.getPersistentData().putDouble("modement_mode", 1.0);
                     entity.getPersistentData().putDouble("cnt1", 0.0);
                     LivingEntity var10000;
                     if (owner_entity instanceof Mob) {
                        Mob _mobEnt = (Mob)owner_entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity) {
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        double var69 = ((Entity)var10000).getX();
                        LivingEntity var10001;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10001 = _mobEnt.getTarget();
                        } else {
                           var10001 = null;
                        }

                        x_pos = var69 + (double)((Entity)var10001).getBbWidth() * (Math.random() - 0.5);
                        LivingEntity var70;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var70 = _mobEnt.getTarget();
                        } else {
                           var70 = null;
                        }

                        double var71 = ((Entity)var70).getY();
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10001 = _mobEnt.getTarget();
                        } else {
                           var10001 = null;
                        }

                        y_pos = var71 + (double)((Entity)var10001).getBbHeight() * Math.random();
                        LivingEntity var72;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var72 = _mobEnt.getTarget();
                        } else {
                           var72 = null;
                        }

                        double var73 = ((Entity)var72).getZ();
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10001 = _mobEnt.getTarget();
                        } else {
                           var10001 = null;
                        }

                        z_pos = var73 + (double)((Entity)var10001).getBbWidth() * (Math.random() - 0.5);
                     } else {
                        x_pos = (double)owner_entity.level().clip(new ClipContext(owner_entity.getEyePosition(1.0F), owner_entity.getEyePosition(1.0F).add(owner_entity.getViewVector(1.0F).scale(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).getBlockPos().getX();
                        y_pos = (double)owner_entity.level().clip(new ClipContext(owner_entity.getEyePosition(1.0F), owner_entity.getEyePosition(1.0F).add(owner_entity.getViewVector(1.0F).scale(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).getBlockPos().getY();
                        z_pos = (double)owner_entity.level().clip(new ClipContext(owner_entity.getEyePosition(1.0F), owner_entity.getEyePosition(1.0F).add(owner_entity.getViewVector(1.0F).scale(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).getBlockPos().getZ();
                     }

                     x_pos += (Math.random() - 0.5) * 2.0;
                     y_pos += (Math.random() - 0.5) * 2.0;
                     z_pos += (Math.random() - 0.5) * 2.0;
                     entity.getPersistentData().putBoolean("free", true);
                     GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.lookAt(Anchor.EYES, new Vec3(x_pos, y_pos, z_pos));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 0.5F, 1.25F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
                        }
                     }

                     if (entity.getPersistentData().getBoolean("Stop")) {
                        entity.getPersistentData().putBoolean("Stop", false);
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_settarget", 0.0);
               if (!world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ())).canOcclude()) {
                  x_power = entity.getPersistentData().getDouble("x_power") * 1.2;
                  y_power = entity.getPersistentData().getDouble("y_power") * 1.2;
                  z_power = entity.getPersistentData().getDouble("z_power") * 1.2;
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  dis *= 2.0;
                  if (dis > 1.0) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                  }

                  for(int index0 = 0; index0 < (int)Math.max(Math.floor(dis), 1.0); ++index0) {
                     entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                     }

                     x_pos = entity.getX();
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                     z_pos = entity.getZ();
                     entity.getPersistentData().putDouble("Damage", 9.0);
                     entity.getPersistentData().putDouble("knockback", Math.random() * 1.0);
                     entity.getPersistentData().putDouble("Range", (double)(entity.getBbWidth() * 2.0F));
                     entity.getPersistentData().putDouble("effect", 1.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 20.0));
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }
                        break;
                     }

                     if (entity.getPersistentData().getBoolean("Stop")) {
                        entity.getPersistentData().putBoolean("Stop", false);
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        break;
                     }
                  }
               } else {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }

               if (entity.getPersistentData().getDouble("cnt1") >= 40.0) {
                  teleported = false;
                  entity.getPersistentData().putDouble("cnt1", 0.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("modement_mode", 0.0);
                  if (ownerExist && entity.getPersistentData().getDouble("friend_num_worker") != 0.0 && owner_entity instanceof Player) {
                     teleported = true;
                     x_pos = 0.0;
                     y_pos = 64.0 + Math.random();
                     z_pos = 0.0;
                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        Commands var74 = entity.getServer().getCommands();
                        CommandSourceStack var77 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                        long var10002 = Math.round(x_pos);
                        var74.performPrefixedCommand(var77, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                     }

                     NUM1 = 0.0;

                     for(int index1 = 0; index1 < 10000; ++index1) {
                        ++NUM1;
                        STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                        if (owner_entity.getPersistentData().getString(STR1 + "_name").equals(entity.getDisplayName().getString())) {
                           y_pos = owner_entity.getPersistentData().getDouble(STR1);
                           break;
                        }

                        if (owner_entity.getPersistentData().getDouble(STR1) == 0.0) {
                           owner_entity.getPersistentData().putDouble(STR1, y_pos);
                           owner_entity.getPersistentData().putString(STR1 + "_name", entity.getDisplayName().getString());
                           break;
                        }
                     }

                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                     }

                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                     }

                     owner_entity.getPersistentData().putDouble(STR1 + "_num", owner_entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                     owner_entity.getPersistentData().putBoolean("UpdateSkills", true);
                  }

                  if (!teleported && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }
         }

      }
   }
}
