package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class LogicRifleProcedure {
   public LogicRifleProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (!var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (!var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:bow")))) {
               return logic_a;
            }
         }

         if (entity instanceof Player) {
            logic_a = entity.m_6144_();
         } else {
            logic_a = GetDistanceProcedure.execute(entity) > 8.0;
         }

         return logic_a;
      }
   }
}
