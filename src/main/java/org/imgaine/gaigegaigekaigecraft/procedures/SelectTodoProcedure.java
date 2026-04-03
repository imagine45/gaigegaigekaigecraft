package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectTodoProcedure {
   public SelectTodoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double _setval = 20.0;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, new ItemStack((ItemLike)JujutsucraftModItems.MUSCULAR_BODY_CHESTPLATE.get()), new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()), new ItemStack((ItemLike)JujutsucraftModItems.PENDANT_TODO_AOI.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()), new ItemStack((ItemLike)JujutsucraftModItems.CURSED_TECHNIQUE_STARTER.get()), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
      }
   }
}
