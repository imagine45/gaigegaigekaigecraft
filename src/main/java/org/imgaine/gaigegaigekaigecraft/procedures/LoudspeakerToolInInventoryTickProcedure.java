package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class LoudspeakerToolInInventoryTickProcedure {
   public LoudspeakerToolInInventoryTickProcedure() {
   }

   public static void execute(LevelAccessor world, ItemStack itemstack) {
      if (itemstack.m_41784_().m_128471_("Used") && itemstack.m_220157_(1, RandomSource.m_216327_(), (ServerPlayer)null)) {
         itemstack.m_41774_(1);
         itemstack.m_41721_(0);
      }

   }
}
