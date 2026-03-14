package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class SelectYagaProcedure {
   public SelectYagaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         label17: {
            double _setval = 33.0;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCurseTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.m_150110_().f_35937_) {
                  break label17;
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.ITEM_DOLL.get())).m_41777_();
               _setstack.m_41764_(2);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
         }

         SelectedProcedure.execute(world, x, y, z, entity, guistate);
      }
   }
}
