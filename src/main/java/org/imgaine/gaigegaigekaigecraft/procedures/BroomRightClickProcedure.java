package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BroomRightClickProcedure {
   public BroomRightClickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double size = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         if (itemstack.getItem() == JujutsucraftModItems.BROOM.get()) {
            SummonBroomProcedure.execute(world, x, y, z, entity);
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.getCooldowns().addCooldown(itemstack.getItem(), 3);
            }

            itemstack.shrink(1);
         }

      }
   }
}
