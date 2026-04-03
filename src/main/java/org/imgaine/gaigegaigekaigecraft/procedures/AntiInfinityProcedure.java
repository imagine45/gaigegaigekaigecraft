package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class AntiInfinityProcedure {
   public AntiInfinityProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         ItemStack item_mainHand = ItemStack.EMPTY;
         ItemStack item_head = ItemStack.EMPTY;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
               return true;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt1 = (LivingEntity)entity;
            if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
               return true;
            }
         }

         if (entity.getPersistentData().getDouble("effectConfirm") != 3.0 && entity.getPersistentData().getDouble("effectConfirm") != 4.0) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            item_mainHand = var10000.copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            item_head = var10000.copy();
            if (item_mainHand.getItem() == ItemStack.EMPTY.getItem() || item_mainHand.getItem() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() && item_mainHand.getItem() != JujutsucraftModItems.BLACK_ROPE.get()) {
               if (entity instanceof Player && entity instanceof Player) {
                  Player _plrCldCheck11 = (Player)entity;
                  if (_plrCldCheck11.getCooldowns().isOnCooldown(item_head.getItem())) {
                     return false;
                  }
               }

               if (item_head.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_head.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  if (entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                        return false;
                     }
                  } else if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof CursedSpiritGrade010Entity)) {
                     return false;
                  }

                  if (item_head.getOrCreateTag().getDouble("skill205") >= 100.0) {
                     return true;
                  }
               }

               return false;
            } else {
               return true;
            }
         } else {
            return true;
         }
      }
   }
}
