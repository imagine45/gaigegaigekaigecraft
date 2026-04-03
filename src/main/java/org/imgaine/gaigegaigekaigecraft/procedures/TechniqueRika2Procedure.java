package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TechniqueRika2Procedure {
   public TechniqueRika2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         Entity entity_rika = null;
         String STR1 = "";
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double HP = 0.0;
         double power = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (!(entity instanceof Player)) {
            entity.getPersistentData().putBoolean("PRESS_Z", true);
         }

         if (entity.getPersistentData().getBoolean("PRESS_Z")) {
            power = (double)Math.round((20.0 - entity.getPersistentData().getDouble("cnt1")) * 0.25);
            STR1 = Component.translatable("jujutsu.message.long_press").getString();

            for(int index0 = 0; index0 < (int)power; ++index0) {
               STR1 = "■" + STR1 + "■";
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal(STR1), true);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 20.0) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(""), true);
                  }
               }

               entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("RIKA_UUID"));
               if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
                  entity_rika.getPersistentData().putDouble("despawn_flag", 2.0);
               }

               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal(""), true);
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
