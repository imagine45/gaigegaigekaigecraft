package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class ResetCounterProcedure {
   public ResetCounterProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double number = 0.0;
         double Level = 0.0;
         boolean logic_a = false;
         boolean CREATIVE = false;
         entity.getPersistentData().m_128347_("Damage", 0.0);
         entity.getPersistentData().m_128347_("cnt1", 0.0);
         entity.getPersistentData().m_128347_("cnt2", 0.0);
         entity.getPersistentData().m_128347_("cnt3", 0.0);
         entity.getPersistentData().m_128347_("cnt4", 0.0);
         entity.getPersistentData().m_128347_("cnt5", 0.0);
         entity.getPersistentData().m_128347_("cnt6", 0.0);
         entity.getPersistentData().m_128347_("cnt7", 0.0);
         entity.getPersistentData().m_128347_("cnt8", 0.0);
         entity.getPersistentData().m_128347_("cnt9", 0.0);
         entity.getPersistentData().m_128347_("cnt10", 0.0);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", 10.0);
         entity.getPersistentData().m_128379_("attack", false);
         entity.getPersistentData().m_128379_("betrayal", false);
      }
   }
}
