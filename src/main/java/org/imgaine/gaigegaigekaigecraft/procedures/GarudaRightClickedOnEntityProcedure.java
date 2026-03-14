package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.items.ItemHandlerHelper;

public class GarudaRightClickedOnEntityProcedure {
   public GarudaRightClickedOnEntityProcedure() {
   }

   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && sourceentity.getPersistentData().m_128459_("skill") == 0.0 && entity.getPersistentData().m_128459_("friend_num") == sourceentity.getPersistentData().m_128459_("friend_num")) {
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)sourceentity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            ItemStack var10000;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)sourceentity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get())).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            } else if (sourceentity instanceof Player) {
               Player _player = (Player)sourceentity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (sourceentity instanceof Player) {
               Player _player = (Player)sourceentity;
               _player.m_36335_().m_41524_((Item)JujutsucraftModItems.GARUDA_ITEM.get(), 20);
            }

            if (sourceentity instanceof Player) {
               Player _player = (Player)sourceentity;
               _player.m_36335_().m_41524_((Item)JujutsucraftModItems.GARUDA_ITEM_BALL.get(), 20);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
