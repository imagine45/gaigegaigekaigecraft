package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerLevel;
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
      STR1 = itemstack.m_41784_().m_128461_("OWNER_UUID");
      if (!STR1.isEmpty()) {
         ENTITY_A = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, STR1);
         if (ENTITY_A instanceof LivingEntity) {
            if (ENTITY_A instanceof LivingEntity) {
               LivingEntity _livEnt4 = (LivingEntity)ENTITY_A;
               if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  label32: {
                     if (ENTITY_A instanceof Player) {
                        Player _plrCldCheck6 = (Player)ENTITY_A;
                        if (_plrCldCheck6.m_36335_().m_41519_(itemstack.m_41720_())) {
                           break label32;
                        }
                     }

                     if (ENTITY_A instanceof Player) {
                        Player _player = (Player)ENTITY_A;
                        _player.m_36335_().m_41524_(itemstack.m_41720_(), 10);
                     }
                  }
               }
            }

            if (!ENTITY_A.m_6084_()) {
               itemstack.m_41774_(1);
            }
         } else {
            itemstack.m_41784_().m_128359_("OWNER_UUID", "");
         }
      }

   }
}
