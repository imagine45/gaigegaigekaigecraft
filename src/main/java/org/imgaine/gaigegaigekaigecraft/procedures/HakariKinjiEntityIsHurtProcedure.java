package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class HakariKinjiEntityIsHurtProcedure {
   public HakariKinjiEntityIsHurtProcedure() {
   }

   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (sourceentity instanceof LivingEntity) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.CLOTHES_HAKARI_KINJI_CHESTPLATE.get()) {
               if (!(entity.getPersistentData().getDouble("cnt_target") > 1200.0)) {
                  float var8;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var8 = _livEnt.getHealth();
                  } else {
                     var8 = -1.0F;
                  }

                  double var9 = (double)var8;
                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMaxHealth();
                  } else {
                     var10001 = -1.0F;
                  }

                  if (!(var9 <= (double)var10001 * 0.5)) {
                     return;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(2, ItemStack.EMPTY);
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
               }
            }
         }

      }
   }
}
