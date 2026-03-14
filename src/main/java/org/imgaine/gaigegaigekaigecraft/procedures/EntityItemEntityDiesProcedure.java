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
            ItemEntity var10000 = new ItemEntity;
            ItemStack var10006;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10006 = _livEnt.m_21205_();
            } else {
               var10006 = ItemStack.f_41583_;
            }

            var10000.<init>(_level, x, y, z, var10006);
            ItemEntity entityToSpawn = var10000;
            entityToSpawn.m_32010_(10);
            _level.m_7967_(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var26 = new ItemEntity;
            ItemStack var31;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var31 = _livEnt.m_21206_();
            } else {
               var31 = ItemStack.f_41583_;
            }

            var26.<init>(_level, x, y, z, var31);
            ItemEntity entityToSpawn = var26;
            entityToSpawn.m_32010_(10);
            _level.m_7967_(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var27 = new ItemEntity;
            ItemStack var32;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var32 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var32 = ItemStack.f_41583_;
            }

            var27.<init>(_level, x, y, z, var32);
            ItemEntity entityToSpawn = var27;
            entityToSpawn.m_32010_(10);
            _level.m_7967_(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var28 = new ItemEntity;
            ItemStack var33;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var33 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var33 = ItemStack.f_41583_;
            }

            var28.<init>(_level, x, y, z, var33);
            ItemEntity entityToSpawn = var28;
            entityToSpawn.m_32010_(10);
            _level.m_7967_(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var29 = new ItemEntity;
            ItemStack var34;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var34 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
            } else {
               var34 = ItemStack.f_41583_;
            }

            var29.<init>(_level, x, y, z, var34);
            ItemEntity entityToSpawn = var29;
            entityToSpawn.m_32010_(10);
            _level.m_7967_(entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity var30 = new ItemEntity;
            ItemStack var35;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var35 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
            } else {
               var35 = ItemStack.f_41583_;
            }

            var30.<init>(_level, x, y, z, var35);
            ItemEntity entityToSpawn = var30;
            entityToSpawn.m_32010_(10);
            _level.m_7967_(entityToSpawn);
         }

         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
