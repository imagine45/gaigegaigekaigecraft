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

public class SelectOgiProcedure {
   public SelectOgiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         label62: {
            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.m_150110_().f_35937_) {
                  break label62;
               }
            }

            label52: {
               if (entity instanceof Player) {
                  Player _playerHasItem = (Player)entity;
                  if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get()))) {
                     break label52;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            label47: {
               if (entity instanceof Player) {
                  Player _playerHasItem = (Player)entity;
                  if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get()))) {
                     break label47;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            label42: {
               if (entity instanceof Player) {
                  Player _playerHasItem = (Player)entity;
                  if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()))) {
                     break label42;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof Player) {
               Player _playerHasItem = (Player)entity;
               if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OGI.get()))) {
                  break label62;
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OGI.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
         }

         double _setval = 26.0;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity, guistate);
         OgiZeninPassiveSkillProcedure.execute(entity);
      }
   }
}
