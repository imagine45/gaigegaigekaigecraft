package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class EntityItemEntityDiesProcedure {
   public EntityItemEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var10000;
            ItemStack var10006;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10006 = _livEnt.getMainHandItem();
            } else {
               var10006 = ItemStack.EMPTY;
            }

            var10000 = new ItemEntity(_level, x, y, z, var10006);
            ItemEntity entityToSpawn = var10000;
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var26;
            ItemStack var31;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var31 = _livEnt.getOffhandItem();
            } else {
               var31 = ItemStack.EMPTY;
            }

            var26 = new ItemEntity(_level, x, y, z, var31);
            ItemEntity entityToSpawn = var26;
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var27;
            ItemStack var32;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var32 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var32 = ItemStack.EMPTY;
            }

            var27 = new ItemEntity(_level, x, y, z, var32);
            ItemEntity entityToSpawn = var27;
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var28;
            ItemStack var33;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var33 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var33 = ItemStack.EMPTY;
            }

            var28 = new ItemEntity(_level, x, y, z, var33);
            ItemEntity entityToSpawn = var28;
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var29;
            ItemStack var34;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var34 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
            } else {
               var34 = ItemStack.EMPTY;
            }

            var29 = new ItemEntity(_level, x, y, z, var34);
            ItemEntity entityToSpawn = var29;
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var30;
            ItemStack var35;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var35 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
            } else {
               var35 = ItemStack.EMPTY;
            }

            var30 = new ItemEntity(_level, x, y, z, var35);
            ItemEntity entityToSpawn = var30;
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
