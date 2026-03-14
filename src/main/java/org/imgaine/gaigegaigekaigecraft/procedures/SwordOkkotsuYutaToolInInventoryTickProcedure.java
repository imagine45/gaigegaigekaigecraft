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
         if (itemstack.m_41784_().m_128471_("Used")) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               if (itemstack.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get()) {
                  itemstack.m_41784_().m_128379_("Used", false);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                        return;
                     }
                  }

                  itemstack.m_41774_(1);
               } else if (itemstack.m_220157_(9999, RandomSource.m_216327_(), (ServerPlayer)null)) {
                  itemstack.m_41774_(1);
                  itemstack.m_41721_(0);
               }
            }
         }

      }
   }
}
