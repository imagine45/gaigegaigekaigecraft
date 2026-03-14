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
         ItemStack item_a = ItemStack.f_41583_;
         ItemStack item_b = ItemStack.f_41583_;
         if (entity instanceof Player) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).m_41777_();
            item_a.m_41784_().m_128379_("effect_item", true);
            item_a.m_41784_().m_128379_("hand", true);
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_a.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = item_a.m_41777_().m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_a.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = item_a.m_41777_().m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            item_b = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).m_41777_();
            item_b.m_41784_().m_128379_("effect_item", true);
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var10000.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, item_b.m_41777_());
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, item_b.m_41777_());
               }
            }
         }

         num_level = amplifier + 1.0;
         if (num_level > 0.0 && entity instanceof LivingEntity) {
            LivingEntity _livingEntity26 = (LivingEntity)entity;
            if (_livingEntity26.m_21204_().m_22171_(Attributes.f_22281_)) {
               AttributeInstance var36;
               double var10001;
               label80: {
                  var36 = _livingEntity26.getAttribute_(Attributes.f_22281_);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity25 = (LivingEntity)entity;
                     if (_livingEntity25.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10001 = _livingEntity25.getAttribute_(Attributes.f_22281_).m_22115_();
                        break label80;
                     }
                  }

                  var10001 = 0.0;
               }

               var36.m_22100_(var10001 + num_level * 1.2);
            }
         }

         if (entity instanceof KashimoHajimeEntity) {
            KashimoHajimeEntity animatable = (KashimoHajimeEntity)entity;
            animatable.setTexture("kashimo_hajime_cursedtechnique");
         }

      }
   }
}
