package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CrowRightClickedOnEntityProcedure {
   public CrowRightClickedOnEntityProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 11.0 || ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11.0) {
            if (sourceentity.getPersistentData().getDouble("friend_num") == 0.0) {
               sourceentity.getPersistentData().putDouble("friend_num", Math.random());
            }

            entity.getPersistentData().putDouble("friend_num", sourceentity.getPersistentData().getDouble("friend_num"));
            if (entity instanceof TamableAnimal) {
               TamableAnimal _toTame = (TamableAnimal)entity;
               if (sourceentity instanceof Player) {
                  Player _owner = (Player)sourceentity;
                  _toTame.tame(_owner);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.HEART, x, y, z, 1, 0.0, 0.0, 0.0, 0.1);
            }
         }

      }
   }
}
