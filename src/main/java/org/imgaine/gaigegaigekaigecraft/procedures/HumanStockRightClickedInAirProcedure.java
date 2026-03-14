package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class HumanStockRightClickedInAirProcedure {
   public HumanStockRightClickedInAirProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
      if (direction != null && entity != null) {
         double size = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         if (LogicStartPassiveProcedure.execute(entity)) {
            x_pos = x + (double)direction.m_122429_();
            y_pos = y + (double)direction.m_122430_();
            z_pos = z + (double)direction.m_122431_();
            if (itemstack.m_41720_() != JujutsucraftModItems.HUMAN_STOCK.get() && itemstack.m_41720_() != JujutsucraftModItems.HUMAN_STOCK_CAR.get()) {
               if (itemstack.m_41720_() == JujutsucraftModItems.ITEM_DOLL.get() && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 33.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 33.0)) {
                  SummonDollsProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_36335_().m_41524_(itemstack.m_41720_(), 3);
                  }

                  itemstack.m_41774_(1);
               }
            } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 15.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15.0) {
               SummonHumansProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(itemstack.m_41720_(), 3);
               }

               itemstack.m_41774_(1);
            }
         }

      }
   }
}
