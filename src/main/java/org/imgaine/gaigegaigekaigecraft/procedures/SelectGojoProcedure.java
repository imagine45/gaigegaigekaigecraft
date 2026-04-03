package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectGojoProcedure {
   public SelectGojoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.EMPTY;
         double rnd1 = 0.0;
         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_gojo"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for(String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

         double _setval = 2.0;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         rnd1 = (double)Mth.nextInt(RandomSource.create(), 1, 3);
         if (rnd1 == 1.0) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get())).copy();
         } else if (rnd1 == 2.0) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get())).copy();
         } else if (rnd1 == 3.0) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get())).copy();
         }

         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()), new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()), item_a, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
      }
   }
}
