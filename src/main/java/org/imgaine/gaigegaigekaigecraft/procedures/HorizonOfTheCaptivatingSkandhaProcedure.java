package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class HorizonOfTheCaptivatingSkandhaProcedure {
   public HorizonOfTheCaptivatingSkandhaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_center = 0.0;
         double num1 = 0.0;
         double z_center = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_center = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().putDouble("select", 8.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 34.0) {
               if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                  entity.getPersistentData().putDouble("NameRanged", Math.random());
               }

               dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               num1 = -80.0;
               RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
               num2 = (double)entity.getYRot();
               x_center = entity.getPersistentData().getDouble("x_pos_doma") + (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() - (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 0.4)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_center = entity.getPersistentData().getDouble("y_pos_doma") + (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() - (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 0.4)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_center = entity.getPersistentData().getDouble("z_pos_doma") + (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() - (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 0.4)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();

               for(int index0 = 0; index0 < 8; ++index0) {
                  entity.setYRot((float)(num2 + num1));
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

                  x_pos = x_center + (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 0.6)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() - (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
                  y_pos = y_center + 2.0;
                  z_pos = z_center + (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis * 0.6)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() - (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();

                  for(int index1 = 0; index1 < 100; ++index1) {
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        ++y_pos;
                     } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                        --y_pos;
                     } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                        ++y_pos;
                        break;
                     }
                  }

                  --y_pos;
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.PALM_TREE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                        }

                        entityinstance.setYRot(entity.getYRot());
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

                  num1 += 22.0;
               }

               entity.setYRot((float)yaw);
               entity.setXRot((float)pitch);
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

            PlayAnimationProcedure.execute(world, entity);
         }

      }
   }
}
