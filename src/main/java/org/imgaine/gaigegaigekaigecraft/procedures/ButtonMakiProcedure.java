package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.HashMap;
import net.minecraft.client.gui.components.Checkbox;

public class ButtonMakiProcedure {
   public ButtonMakiProcedure() {
   }

   public static boolean execute(HashMap guistate) {
      if (guistate == null) {
         return false;
      } else {
         return !guistate.containsKey("checkbox:cursed_spirit") || !((Checkbox)guistate.get("checkbox:cursed_spirit")).m_93840_();
      }
   }
}
