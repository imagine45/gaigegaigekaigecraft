package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class GetWeaponSizeProcedure {
   public GetWeaponSizeProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double attack_reach = 0.0;
         ItemStack item_a = ItemStack.f_41583_;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         item_a = var10000.m_41777_();
         attack_reach = 1.0;
         if (item_a.m_41784_().m_128459_("Range") != 0.0) {
            attack_reach = 1.0 + item_a.m_41784_().m_128459_("Range");
         }

         return attack_reach;
      }
   }
}
