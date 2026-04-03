package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class CeremonialSeaOfLightProcedure {
   public CeremonialSeaOfLightProcedure() {
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
         double yaw = 0.0;
         double dis = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().putDouble("select", 14.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            x_center = entity.getPersistentData().getDouble("x_pos_doma");
            y_center = entity.getPersistentData().getDouble("y_pos_doma");
            z_center = entity.getPersistentData().getDouble("z_pos_doma");
            y_pos = y_center;
            if (entity.getPersistentData().getDouble("cnt1") <= JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
               num1 = Math.toRadians(Math.random() * 720.0);
               num2 = entity.getPersistentData().getDouble("cnt1") / 2.0;
               num3 = Math.toRadians(8.0);

               for(int index0 = 0; index0 < 90; ++index0) {
                  x_pos = x_center + Math.sin(num1) * num2;
                  z_pos = z_center + Math.cos(num1) * num2;
                  if (Math.random() < 0.25 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get(), x_pos, y_pos, z_pos, 1, 0.25, Math.max(num2 / 10.0, 0.25), 0.25, 0.05);
                  }

                  num1 += Math.random() * num3;
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 34.0) {
               for(int index1 = 0; index1 < 8; ++index1) {
                  x_pos = x_center + Math.cos(Math.toRadians(yaw)) * (dis - 6.0);
                  z_pos = z_center + Math.sin(Math.toRadians(yaw)) * (dis - 6.0);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TREE_HANAMI.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                        }

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

                        entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  yaw += 45.0;
               }
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
