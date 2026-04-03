package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.LiquidMetalEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class TechniqueLiquidMetalProcedure {
   public TechniqueLiquidMetalProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean strong = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double strength = 0.0;
         Entity entity_a = null;
         if (LocateLiquidMetalProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("LIQUID_METAL_UUID"));
            if (entity_a instanceof LiquidMetalEntity && entity.getPersistentData().getDouble("NameRanged") == entity_a.getPersistentData().getDouble("NameRanged_ranged") && !entity_a.level().isClientSide() && entity_a.getServer() != null) {
               entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.LIQUID_METAL.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                  entity.getPersistentData().putString("LIQUID_METAL_UUID", entityinstance.getStringUUID());
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label58: {
                           var10003 = MobEffects.DAMAGE_RESISTANCE;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label58;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001 = new MobEffectInstance(var10003, 2147483647, Math.min(var10005, 3), false, false);
                        _entity.addEffect(var10001);
                     }
                  }

                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
