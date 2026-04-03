package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectKashimoProcedure {
   public SelectKashimoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double _setval = 7.0;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()), ItemStack.EMPTY, ItemStack.EMPTY, new ItemStack((ItemLike)JujutsucraftModItems.NYOI_STAFF.get()), ItemStack.EMPTY);
      }
   }
}
