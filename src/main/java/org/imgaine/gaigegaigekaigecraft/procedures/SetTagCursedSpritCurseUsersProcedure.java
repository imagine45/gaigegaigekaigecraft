package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SetTagCursedSpritCurseUsersProcedure {
   public SetTagCursedSpritCurseUsersProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("CurseUser", true);
         SetTagProcedure.execute(world, entity);
      }
   }
}
