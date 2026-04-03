package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SwordOkkotsuYutaToolInInventoryTickProcedure {
   public SwordOkkotsuYutaToolInInventoryTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.getOrCreateTag().getBoolean("Used")) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (itemstack.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get()) {
                  itemstack.getOrCreateTag().putBoolean("Used", false);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                        return;
                     }
                  }

                  itemstack.shrink(1);
               } else if (itemstack.hurt(9999, RandomSource.create(), (ServerPlayer)null)) {
                  itemstack.shrink(1);
                  itemstack.setDamageValue(0);
               }
            }
         }

      }
   }
}
