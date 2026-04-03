package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class ExecutionersSwordItemInInventoryTickProcedure {
   public ExecutionersSwordItemInInventoryTickProcedure() {
   }

   public static void execute(LevelAccessor world, ItemStack itemstack) {
      String STR1 = "";
      Entity ENTITY_A = null;
      STR1 = itemstack.getOrCreateTag().getString("OWNER_UUID");
      if (!STR1.isEmpty()) {
         ENTITY_A = GetEntityFromUUIDProcedure.execute(world, STR1);
         if (ENTITY_A instanceof LivingEntity) {
            if (ENTITY_A instanceof LivingEntity) {
               LivingEntity _livEnt4 = (LivingEntity)ENTITY_A;
               if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  label32: {
                     if (ENTITY_A instanceof Player) {
                        Player _plrCldCheck6 = (Player)ENTITY_A;
                        if (_plrCldCheck6.getCooldowns().isOnCooldown(itemstack.getItem())) {
                           break label32;
                        }
                     }

                     if (ENTITY_A instanceof Player) {
                        Player _player = (Player)ENTITY_A;
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
                     }
                  }
               }
            }

            if (!ENTITY_A.isAlive()) {
               itemstack.shrink(1);
            }
         } else {
            itemstack.getOrCreateTag().putString("OWNER_UUID", "");
         }
      }

   }
}
