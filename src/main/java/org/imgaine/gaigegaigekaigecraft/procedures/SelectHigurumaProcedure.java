package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class SelectHigurumaProcedure {
   public SelectHigurumaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         label76: {
            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.m_150110_().f_35937_) {
                  break label76;
               }
            }

            label65: {
               if (entity instanceof Player) {
                  Player _playerHasItem = (Player)entity;
                  if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get()))) {
                     break label65;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            label60: {
               if (entity instanceof Player) {
                  Player _playerHasItem = (Player)entity;
                  if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_HIGURUMA_CHESTPLATE.get()))) {
                     break label60;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_HIGURUMA_CHESTPLATE.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            label55: {
               if (entity instanceof Player) {
                  Player _playerHasItem = (Player)entity;
                  if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_HIGURUMA_LEGGINGS.get()))) {
                     break label55;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_HIGURUMA_LEGGINGS.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof Player) {
               Player _playerHasItem = (Player)entity;
               if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()))) {
                  break label76;
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
         }

         double _setval = 27.0;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity, guistate);
         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

      }
   }
}
