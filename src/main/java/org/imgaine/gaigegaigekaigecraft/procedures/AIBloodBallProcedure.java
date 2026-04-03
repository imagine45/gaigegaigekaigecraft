package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBloodBallProcedure {
   public AIBloodBallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double dis = 0.0;
         double yaw_fix = 0.0;
         double old_skill = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         if (entity.getPersistentData().getBoolean("despawn")) {
            logic_a = false;
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.isAlive()) {
                  logic_a = true;
                  entity.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
                  }

                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }

               if (entity_a.getPersistentData().getDouble("skill") <= 0.0) {
                  logic_a = false;
               }

               if (entity_a.getPersistentData().getDouble("cnt1") > 20.0) {
                  logic_a = false;
               }
            }

            if (!logic_a && !entity.level().isClientSide()) {
               entity.discard();
            }
         } else if (entity.isAlive()) {
            logic_a = false;
            if (entity.getPersistentData().getBoolean("explode")) {
               entity.getPersistentData().putDouble("cnt_explode", entity.getPersistentData().getDouble("cnt_explode") + 1.0);
               dis = 0.75 + Math.min(entity.getPersistentData().getDouble("cnt_explode") * 0.5, 4.0);
               entity.getPersistentData().putDouble("yaw", entity.getPersistentData().getDouble("yaw") * 0.75);
               entity.getPersistentData().putDouble("pitch", entity.getPersistentData().getDouble("pitch") * 0.75);
            } else {
               dis = 0.75;
            }

            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               label130: {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity_a instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0) {
                        break label130;
                     }
                  } else if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting")))) {
                     break label130;
                  }

                  entity.getPersistentData().putBoolean("explode", true);
               }

               if (entity.getPersistentData().getDouble("yaw") == 0.0) {
                  entity.getPersistentData().putDouble("distance", Math.random() * 1.0);
                  entity.getPersistentData().putDouble("yaw", 180.0 + (Math.random() - 0.5) * 180.0);
                  entity.getPersistentData().putDouble("pitch", 0.0 + (Math.random() - 0.5) * 90.0);
               }

               dis = dis + (double)entity_a.getBbWidth() * 0.5 + entity.getPersistentData().getDouble("distance");
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.isAlive()) {
                  logic_a = true;
                  yaw = Math.toRadians((double)(entity_a.getYRot() + 90.0F) + entity.getPersistentData().getDouble("yaw"));
                  pitch = Math.toRadians((double)entity_a.getXRot() + entity.getPersistentData().getDouble("pitch"));
                  entity.teleportTo(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.getY() + (double)entity_a.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.getY() + (double)entity_a.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis, entity.getYRot(), entity.getXRot());
                  }

                  if (entity.getPersistentData().getDouble("cnt_explode") < 5.0) {
                     entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                  } else {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  }
               }
            }

            if (!logic_a || entity.getPersistentData().getDouble("cnt_explode") > 10.0) {
               entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
               BulletDomainHit2Procedure.execute(world, entity);
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            }
         } else {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            entity.getPersistentData().putDouble("cnt_die", entity.getPersistentData().getDouble("cnt_die") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_die") < 4.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, 1.5F, 2.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, 1.5F, 2.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 4, 0.5, 0.5, 0.5, 2.0);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y, z, 25, 0.1, 0.1, 0.1, 2.0);
            }

            entity.getPersistentData().putDouble("Damage", 20.0);
            entity.getPersistentData().putDouble("Range", 8.0);
            entity.getPersistentData().putDouble("knockback", 1.5);
            entity.getPersistentData().putDouble("effect", 11.0);
            RangeAttackProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
            entity.getPersistentData().putDouble("Damage", 17.0);
            entity.getPersistentData().putDouble("Range", 12.0);
            entity.getPersistentData().putDouble("knockback", 1.0);
            entity.getPersistentData().putDouble("effect", 11.0);
            RangeAttackProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
            entity.getPersistentData().putDouble("BlockRange", Math.min(entity.getPersistentData().getDouble("cnt_die"), 6.0));
            entity.getPersistentData().putDouble("BlockDamage", 0.3);
            BlockDestroyAllDirectionProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
            if (entity.getPersistentData().getDouble("cnt_die") > 7.0 && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

         if (entity.isInWaterRainOrBubble()) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y, z, 8, 0.1, 0.1, 0.1, 0.0);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
