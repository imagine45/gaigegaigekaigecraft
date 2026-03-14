package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class FinishBlastGameProcedure {
   public FinishBlastGameProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "worldborder center 0 0");
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "worldborder set 59999968");
      }

      JujutsucraftModVariables.MapVariables.get(world).BlastGame = false;
      JujutsucraftModVariables.MapVariables.get(world).syncData(world);
      if (!world.m_5776_() && world.m_7654_() != null) {
         world.m_7654_().m_6846_().m_240416_(Component.m_237113_("\"Blast Game\" has switched to " + JujutsucraftModVariables.MapVariables.get(world).BlastGame), false);
      }

   }
}
