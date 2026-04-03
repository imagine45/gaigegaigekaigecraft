package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ToadEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class GetReachProcedure {
   public GetReachProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double attack_reach = 0.0;
         ItemStack item_a = ItemStack.EMPTY;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         item_a = var10000.copy();
         attack_reach = 1.0;
         if (item_a.getOrCreateTag().getDouble("Reach") != 0.0) {
            attack_reach = 1.0 + item_a.getOrCreateTag().getDouble("Reach");
         }

         if (entity instanceof ToadEntity) {
            attack_reach = 1.5;
         }

         return attack_reach;
      }
   }
}
