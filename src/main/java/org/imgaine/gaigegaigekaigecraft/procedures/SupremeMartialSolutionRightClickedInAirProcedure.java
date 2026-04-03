package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SupremeMartialSolutionRightClickedInAirProcedure {
   public SupremeMartialSolutionRightClickedInAirProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack item_a = ItemStack.EMPTY;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos = 0.0;
         double dis = 0.0;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            item_a = var10000.copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               item_a = var10000.copy();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.OFF_HAND, true);
               }
            }
         }

         if (item_a.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
            label83: {
               if (entity instanceof Player) {
                  Player _plr = (Player)entity;
                  if (_plr.getAbilities().instabuild) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getCooldowns().addCooldown(item_a.getItem(), 20);
                     }
                     break label83;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getCooldowns().addCooldown(item_a.getItem(), 200);
               }
            }

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

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.THUNDER_IMPACT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

      }
   }
}
