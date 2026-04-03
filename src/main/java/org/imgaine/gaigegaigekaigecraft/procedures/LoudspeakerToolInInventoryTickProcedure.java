package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class LoudspeakerToolInInventoryTickProcedure {
   public LoudspeakerToolInInventoryTickProcedure() {
   }

   public static void execute(LevelAccessor world, ItemStack itemstack) {
      if (itemstack.getOrCreateTag().getBoolean("Used") && itemstack.hurt(1, RandomSource.create(), (ServerPlayer)null)) {
         itemstack.shrink(1);
         itemstack.setDamageValue(0);
      }

   }
}
