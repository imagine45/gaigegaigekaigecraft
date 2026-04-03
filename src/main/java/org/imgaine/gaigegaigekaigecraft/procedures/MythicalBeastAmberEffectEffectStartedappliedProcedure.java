package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.items.ItemHandlerHelper;

public class MythicalBeastAmberEffectEffectStartedappliedProcedure {
   public MythicalBeastAmberEffectEffectStartedappliedProcedure() {
   }

   public static void execute(Entity entity, double amplifier) {
      if (entity != null) {
         double tick = 0.0;
         double num_level = 0.0;
         ItemStack item_a = ItemStack.EMPTY;
         ItemStack item_b = ItemStack.EMPTY;
         if (entity instanceof Player) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).copy();
            item_a.getOrCreateTag().putBoolean("effect_item", true);
            item_a.getOrCreateTag().putBoolean("hand", true);
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_a.copy().copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = item_a.copy().copy();
               _setstack.setCount(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_a.copy().copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = item_a.copy().copy();
               _setstack.setCount(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            item_b = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).copy();
            item_b.getOrCreateTag().putBoolean("effect_item", true);
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var10000.copy().copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(3, item_b.copy());
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.HEAD, item_b.copy());
               }
            }
         }

         num_level = amplifier + 1.0;
         if (num_level > 0.0 && entity instanceof LivingEntity) {
            LivingEntity _livingEntity26 = (LivingEntity)entity;
            if (_livingEntity26.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
               AttributeInstance var36;
               double var10001;
               label80: {
                  var36 = _livingEntity26.getAttribute(Attributes.ATTACK_DAMAGE);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity25 = (LivingEntity)entity;
                     if (_livingEntity25.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var10001 = _livingEntity25.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                        break label80;
                     }
                  }

                  var10001 = 0.0;
               }

               var36.setBaseValue(var10001 + num_level * 1.0);
            }
         }

         if (entity instanceof KashimoHajimeEntity) {
            KashimoHajimeEntity animatable = (KashimoHajimeEntity)entity;
            animatable.setTexture("kashimo_hajime_cursedtechnique");
         }

      }
   }
}
