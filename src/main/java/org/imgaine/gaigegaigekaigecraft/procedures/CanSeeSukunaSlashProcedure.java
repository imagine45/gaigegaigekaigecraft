package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CanSeeSukunaSlashProcedure {
   public CanSeeSukunaSlashProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity, Entity player) {
      if (entity != null && player != null) {
         if (GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) == player) {
            return true;
         } else {
            ItemStack var10000;
            if (player instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)player;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            label57: {
               if (var10000.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                  if (player instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)player;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                     break label57;
                  }
               }

               if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16.0 || ((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 16.0) {
                  if (player instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)player;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getOrCreateTag().getDouble("skill105") >= 100.0) {
                     return true;
                  }
               }
            }

            if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 1.0 && ((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 1.0) {
               return ((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX == 0.0;
            } else {
               return true;
            }
         }
      } else {
         return false;
      }
   }
}
