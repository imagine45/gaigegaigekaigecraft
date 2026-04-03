package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BulletBallCanUseRangedItemProcedure {
   public BulletBallCanUseRangedItemProcedure() {
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         label32: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  break label32;
               }
            }

            if (!(entity instanceof LivingEntity)) {
               return;
            }

            LivingEntity _livEnt1 = (LivingEntity)entity;
            if (!_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || !entity.getPersistentData().getBoolean("Failed") && entity.getPersistentData().getDouble("Reserve") == 0.0) {
               return;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.getCooldowns().addCooldown(itemstack.getItem(), 5);
         }

      }
   }
}
