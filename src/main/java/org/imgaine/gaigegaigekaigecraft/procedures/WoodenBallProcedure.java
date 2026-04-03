package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.WoodenBall1Entity;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WoodenBallProcedure {
   public WoodenBallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double pitch = 0.0;
         double HP = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(64.0), (e) -> true)) {
            if (entityiterator instanceof WoodenBall1Entity && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID()) && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged") && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
               entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
            }
         }

         yaw = (double)entity.getYRot();
         pitch = (double)entity.getXRot();
         entity.setYRot(entity.getYRot() + 135.0F);
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

         for(int index0 = 0; index0 < 3; ++index0) {
            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.WOODEN_BALL_1.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label77: {
                           var10003 = MobEffects.DAMAGE_RESISTANCE;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label77;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                        _entity.addEffect(var10001);
                     }
                  }

                  if (num1 == 0.0) {
                     entityinstance.getPersistentData().putDouble("position_yaw", 135.0);
                     entityinstance.getPersistentData().putDouble("position_pitch", 1.0);
                  } else if (num1 == 1.0) {
                     entityinstance.getPersistentData().putDouble("position_yaw", 180.0);
                     entityinstance.getPersistentData().putDouble("position_pitch", 3.0);
                  } else {
                     entityinstance.getPersistentData().putDouble("position_yaw", -135.0);
                     entityinstance.getPersistentData().putDouble("position_pitch", 1.0);
                  }

                  entityinstance.getPersistentData().putDouble("cnt_x", 100.0);
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

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
