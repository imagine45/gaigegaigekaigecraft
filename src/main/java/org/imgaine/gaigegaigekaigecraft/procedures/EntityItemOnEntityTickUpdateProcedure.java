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
            if ((Boolean)_datEntL0.m_20088_().m_135370_(EntityItemEntity.DATA_domain_decoration)) {
               AIGravestoneProcedure.execute(world, x, y, z, entity);
            }
         }

         logic_a = true;
         if (logic_a) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var17;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var17 = _livEnt.m_21206_();
            } else {
               var17 = ItemStack.f_41583_;
            }

            if (var17.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var18;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var18 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var18 = ItemStack.f_41583_;
            }

            if (var18.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var19;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var19 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var19 = ItemStack.f_41583_;
            }

            if (var19.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var20;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var20 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
            } else {
               var20 = ItemStack.f_41583_;
            }

            if (var20.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               logic_a = false;
            }
         }

         if (logic_a) {
            ItemStack var21;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var21 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
            } else {
               var21 = ItemStack.f_41583_;
            }

            if (var21.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               logic_a = false;
            }
         }

         if (logic_a && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
