package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class LoudspeakerRightclickedProcedure {
   public LoudspeakerRightclickedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double old_skill = 0.0;
         if (entity instanceof Player) {
            Player _plrCldCheck1 = (Player)entity;
            if (_plrCldCheck1.m_36335_().m_41519_(itemstack.m_41720_())) {
               return;
            }
         }

         StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
      }
   }
}
