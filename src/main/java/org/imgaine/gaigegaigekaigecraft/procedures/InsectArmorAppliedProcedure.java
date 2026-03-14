package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class InsectArmorAppliedProcedure {
   public InsectArmorAppliedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         double tick = 0.0;
         double num_level = 0.0;
         num_level = amplifier + 1.0;
         if (num_level > 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity1 = (LivingEntity)entity;
               if (_livingEntity1.m_21204_().m_22171_(Attributes.f_22281_)) {
                  AttributeInstance var10000;
                  double var10001;
                  label157: {
                     var10000 = _livingEntity1.getAttribute_(Attributes.f_22281_);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity0 = (LivingEntity)entity;
                        if (_livingEntity0.m_21204_().m_22171_(Attributes.f_22281_)) {
                           var10001 = _livingEntity0.getAttribute_(Attributes.f_22281_).m_22115_();
                           break label157;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var10000.m_22100_(var10001 + num_level * 0.6);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity3 = (LivingEntity)entity;
               if (_livingEntity3.m_21204_().m_22171_(Attributes.f_22278_)) {
                  AttributeInstance var33;
                  double var40;
                  label146: {
                     var33 = _livingEntity3.getAttribute_(Attributes.f_22278_);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity2 = (LivingEntity)entity;
                        if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22278_)) {
                           var40 = _livingEntity2.getAttribute_(Attributes.f_22278_).m_22115_();
                           break label146;
                        }
                     }

                     var40 = 0.0;
                  }

                  var33.m_22100_(var40 + 2.0);
               }
            }
         }

         if (entity instanceof Player) {
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         if (entity instanceof Player) {
            ItemStack var34;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var34 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var34 = ItemStack.f_41583_;
            }

            if (var34.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var34 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var34 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var34.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with jujutsucraft:insect_armor_helmet");
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var34 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var34 = ItemStack.f_41583_;
            }

            if (var34.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var34 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var34 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var34.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.chest with jujutsucraft:insect_armor_chestplate");
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var34 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
            } else {
               var34 = ItemStack.f_41583_;
            }

            if (var34.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var34 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                  } else {
                     var34 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var34.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.legs with jujutsucraft:insect_armor_leggings");
               }
            }
         } else {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with jujutsucraft:insect_armor_helmet");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.chest with jujutsucraft:insect_armor_chestplate");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.legs with jujutsucraft:insect_armor_leggings");
            }
         }

      }
   }
}
