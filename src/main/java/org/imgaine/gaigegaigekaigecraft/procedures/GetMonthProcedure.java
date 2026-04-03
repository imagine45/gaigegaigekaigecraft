package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.network.chat.Component;

public class GetMonthProcedure {
   public GetMonthProcedure() {
   }

   public static String execute(String month) {
      return month == null ? "" : Component.translatable("text.month." + month).getString();
   }
}
