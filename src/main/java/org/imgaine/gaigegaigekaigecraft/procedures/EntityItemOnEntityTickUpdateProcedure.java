package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class EntityItemOnEntityTickUpdateProcedure {
   public EntityItemOnEntityTickUpdateProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         if (entity instanceof EntityItemEntity) {
            EntityItemEntity _datEntL0 = (EntityItemEntity)entity;
            if ((Boolean)_datEntL0.getEntityData().get(EntityItemEntity.DATA_domain_decoration)) {
               AIGravestoneProcedure.execute(world, x, y, z, entity);
            }
         }

         logic_a = true;
         if (logic_a) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var17;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var17 = _livEnt.getOffhandItem();
            } else {
               var17 = ItemStack.EMPTY;
            }

            if (var17.getItem() != ItemStack.EMPTY.getItem()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var18;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var18 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var18 = ItemStack.EMPTY;
            }

            if (var18.getItem() != ItemStack.EMPTY.getItem()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var19;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var19 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var19 = ItemStack.EMPTY;
            }

            if (var19.getItem() != ItemStack.EMPTY.getItem()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var20;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var20 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
            } else {
               var20 = ItemStack.EMPTY;
            }

            if (var20.getItem() != ItemStack.EMPTY.getItem()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var21;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var21 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
            } else {
               var21 = ItemStack.EMPTY;
            }

            if (var21.getItem() != ItemStack.EMPTY.getItem()) {
               logic_a = false;
            }
         }

         if (logic_a && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
