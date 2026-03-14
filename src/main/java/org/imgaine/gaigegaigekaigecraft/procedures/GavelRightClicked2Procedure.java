package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class GavelRightClicked2Procedure {
   public GavelRightClicked2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack ITEM_A = ItemStack.f_41583_;
         ItemStack ITEM_REPLACE = ItemStack.f_41583_;
         boolean RIGHT_HAND = false;
         boolean success = false;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         ITEM_A = var10000.m_41777_();
         RIGHT_HAND = true;

         for(int index0 = 0; index0 < 2; ++index0) {
            success = true;
            if (ITEM_A.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
               ITEM_REPLACE = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL_LONG.get())).m_41777_();
            } else if (ITEM_A.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
               ITEM_REPLACE = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL_BIG.get())).m_41777_();
            } else if (ITEM_A.m_41720_() != JujutsucraftModItems.GAVEL_BIG.get() && ITEM_A.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
               success = false;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               ITEM_A = var10000.m_41777_();
               RIGHT_HAND = false;
            } else {
               ITEM_REPLACE = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).m_41777_();
            }

            if (success) {
               if (RIGHT_HAND) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = ITEM_REPLACE.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = ITEM_REPLACE.m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(ITEM_A.m_41720_(), 10);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(ITEM_REPLACE.m_41720_(), 10);
               }
               break;
            }
         }

         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
      }
   }
}
