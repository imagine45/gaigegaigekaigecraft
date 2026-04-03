package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class DomainAmplificationOnEffectActiveTickProcedure {
   public DomainAmplificationOnEffectActiveTickProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.EMPTY;
         if (entity.tickCount % 5 == 0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0, false, false));
               }
            }

            if (entity instanceof Player) {
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> capability.PlayerCursePowerChange -= 10.0);
               if (!ActiveTickConditionProcedure.execute(entity) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            item_a = var10000.copy();
            if (item_a.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get() || item_a.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
               if (entity instanceof Player) {
                  Player _plrCldCheck6 = (Player)entity;
                  if (_plrCldCheck6.getCooldowns().isOnCooldown(item_a.getItem())) {
                     return;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getCooldowns().addCooldown(item_a.getItem(), 10);
               }
            }
         }

      }
   }
}
