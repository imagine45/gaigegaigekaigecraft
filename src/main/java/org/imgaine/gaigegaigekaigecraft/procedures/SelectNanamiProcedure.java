package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectNanamiProcedure {
   public SelectNanamiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_nanami"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for(String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         double _setval = 13.0;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_CHESTPLATE.get()), new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_HELMET.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_LEGGINGS.get()), new ItemStack((ItemLike)JujutsucraftModItems.CURSED_TECHNIQUE_STARTER.get()), ItemStack.EMPTY, new ItemStack((ItemLike)JujutsucraftModItems.WEAPON_NANAMI.get()), ItemStack.EMPTY);
      }
   }
}
