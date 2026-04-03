package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIStandIceSpearProcedure {
   public AIStandIceSpearProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         if (entity.getPersistentData().getDouble("move") == 1.0) {
            AIStandIceSpear2Procedure.execute(world, x, y, z, entity);
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.onGround()) {
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
               entity.getPersistentData().putDouble("cnt4", 0.0);
               if (entity.getPersistentData().getDouble("cnt3") > 20.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }

               entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
               if (entity.getPersistentData().getDouble("cnt2") > 10.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 8, 0.2, 0.2, 0.2, 0.2);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x, y, z, 4, 0.2, 0.2, 0.2, 0.2);
                  }

                  entity.getPersistentData().putDouble("Damage", 20.0);
                  entity.getPersistentData().putDouble("Range", 5.0 * ReturnEntitySizeProcedure.execute(entity));
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("effect", 14.0);
                  RangeAttackProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().putDouble("BlockRange", 2.0);
                  entity.getPersistentData().putDouble("BlockDamage", 4.0);
                  BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               }

               entity.getPersistentData().putDouble("cnt2", 0.0);
            } else {
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               entity.getPersistentData().putDouble("cnt3", 0.0);
               entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
               if (entity.getPersistentData().getDouble("cnt4") > 100.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }

               if (entity.getPersistentData().getDouble("cnt2") > 10.0) {
                  BulletDomainHit2Procedure.execute(world, entity);
                  entity.getPersistentData().putDouble("Damage", 20.0);
                  entity.getPersistentData().putDouble("Range", 5.0 * ReturnEntitySizeProcedure.execute(entity));
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("effect", 14.0);
                  RangeAttackProcedure.execute(world, x, entity.getY() + (double)entity.getBbHeight() * 0.5, z, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 200.0 && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }
         }

      }
   }
}
