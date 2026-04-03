package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EarthenInsectTranceEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TechniqueEarthenInsectTranceProcedure {
   public TechniqueEarthenInsectTranceProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double pitch = 0.0;
         double num3 = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") <= 11.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     String var10001 = Component.translatable("jujutsu.message.kurourushi1").getString();
                     _player.displayClientMessage(Component.literal("「" + var10001 + "」「" + Component.translatable("jujutsu.message.kurourushi1").getString() + "」「" + Component.translatable("jujutsu.message.kurourushi1").getString() + "」"), false);
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(32.0), (e) -> true)) {
               if (entityiterator instanceof EarthenInsectTranceEntity && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID()) && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged") && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                  entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
               }
            }

            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            entity.setYRot(entity.getYRot() + 45.0F);
            entity.setXRot(-22.5F);
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

            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.EARTHEN_INSECT_TRANCE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.setYRot(entity.getYRot());
                     entityinstance.setXRot(entity.getXRot());
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (num1 == 0.0) {
                        entityinstance.getPersistentData().putDouble("position_yaw", -45.0);
                        entityinstance.getPersistentData().putDouble("position_pitch", -0.2);
                     } else if (num1 == 1.0) {
                        entityinstance.getPersistentData().putDouble("position_yaw", 45.0);
                        entityinstance.getPersistentData().putDouble("position_pitch", -0.2);
                     } else {
                        entityinstance.getPersistentData().putDouble("position_yaw", (Math.random() - 0.5) * 360.0);
                        entityinstance.getPersistentData().putDouble("position_pitch", -0.2);
                     }

                     entityinstance.getPersistentData().putDouble("cnt_x", 100.0);
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.setYRot(entity.getYRot() - 90.0F);
               entity.setXRot(-22.5F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               ++num1;
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

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
