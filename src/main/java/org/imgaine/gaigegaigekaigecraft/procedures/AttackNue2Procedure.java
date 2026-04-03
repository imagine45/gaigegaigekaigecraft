package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackNue2Procedure {
   public AttackNue2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack item_a = ItemStack.EMPTY;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos = 0.0;
         double dis = 0.0;
         double picth = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity.getPersistentData().getDouble("cnt2") % 3.0 == 1.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            dis = 0.0;

            for(int index0 = 0; index0 < 32; ++index0) {
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               logic_a = false;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(Math.min(4.0 + dis, 16.0) / 2.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     x_pos = (double)entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1.0F), entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).getBlockPos().getX();
                     y_pos = (double)entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1.0F), entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).getBlockPos().getY();
                     z_pos = (double)entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1.0F), entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).getBlockPos().getZ();
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }

               dis += 2.0;
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
         } else if (entity.getPersistentData().getDouble("cnt1") <= 3.0) {
            x_pos = entity.getPersistentData().getDouble("x_pos") + (Math.random() - 0.5) * 48.0;
            y_pos = entity.getPersistentData().getDouble("y_pos") + (Math.random() - 0.5) * 48.0;
            z_pos = entity.getPersistentData().getDouble("z_pos") + (Math.random() - 0.5) * 48.0;
         } else if (entity.getPersistentData().getDouble("cnt1") <= 6.0) {
            x_pos = entity.getX() + (Math.random() - 0.5) * 64.0;
            y_pos = entity.getY() + (Math.random() - 0.5) * 64.0;
            z_pos = entity.getZ() + (Math.random() - 0.5) * 64.0;
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 6.0) {
            if (entity.getPersistentData().getDouble("cnt1") > 3.0 && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
               for(int index1 = 0; index1 < 16 && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude(); ++index1) {
                  --y_pos;
               }
            }

            if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
               for(int index2 = 0; index2 < 16 && world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude(); ++index2) {
                  ++y_pos;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THUNDER_IMPACT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt1") > 25.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
