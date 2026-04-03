package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
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

public class HanamiSpear2Procedure {
   public HanamiSpear2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            entity.getPersistentData().putDouble("cnt2", 2.0);
         }

         yaw = (double)entity.getYRot();
         picth = (double)entity.getXRot();
         entity.setYRot((float)(yaw + entity.getPersistentData().getDouble("cnt1") * (double)(entity.getPersistentData().getDouble("cnt1") % 2.0 == 1.0 ? 9 : -9)));
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

         entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
         entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY());
         entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
         entity.setYRot((float)yaw);
         entity.setXRot((float)picth);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         for(int index0 = 0; index0 < 255; ++index0) {
            if (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() || world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))) || entity.getPersistentData().getDouble("y_pos") < 0.0) {
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 3.0);
               break;
            }

            entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 1.0);
         }

         yaw = (double)entity.getYRot();
         picth = (double)entity.getXRot();
         entity.setYRot((float)yaw);
         entity.setXRot(-45.0F);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.0);
         entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.0);
         entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.0);
         entity.setYRot((float)yaw);
         entity.setXRot((float)picth);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         x_pos = entity.getPersistentData().getDouble("x_pos");
         y_pos = entity.getPersistentData().getDouble("y_pos");
         z_pos = entity.getPersistentData().getDouble("z_pos");
         picth = -45.0;
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.WOODEN_SPEAR_1.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
               SetRangedAmmoProcedure.execute(entity, entityinstance);
               if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                  entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
               }

               entityinstance.setYRot((float)yaw);
               entityinstance.setXRot((float)picth);
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
                     label85: {
                        var10003 = MobEffects.DAMAGE_RESISTANCE;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                              var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                              break label85;
                           }
                        }

                        var10005 = 0;
                     }

                     var10001 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                     _entity.addEffect(var10001);
                  }
               }

               entityinstance.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power"));
               entityinstance.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power"));
               entityinstance.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power"));
               entityinstance.getPersistentData().putDouble("height", entity.getPersistentData().getDouble("cnt2"));
               entityinstance.getPersistentData().putDouble("move", 1.0);
               _serverLevel.addFreshEntity(entityinstance);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") % 2.0 == 0.0) {
            entity.getPersistentData().putDouble("cnt2", Math.max(entity.getPersistentData().getDouble("cnt2") - 0.25, 0.0));
         }

         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
