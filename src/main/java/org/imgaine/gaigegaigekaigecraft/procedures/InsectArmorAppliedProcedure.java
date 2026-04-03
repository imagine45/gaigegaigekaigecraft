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
         ItemStack item_a = ItemStack.EMPTY;
         double tick = 0.0;
         double num_level = 0.0;
         num_level = amplifier + 1.0;
         if (num_level > 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity1 = (LivingEntity)entity;
               if (_livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                  AttributeInstance var10000;
                  double var10001;
                  label157: {
                     var10000 = _livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity0 = (LivingEntity)entity;
                        if (_livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                           var10001 = _livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                           break label157;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var10000.setBaseValue(var10001 + num_level * 0.6);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity3 = (LivingEntity)entity;
               if (_livingEntity3.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                  AttributeInstance var33;
                  double var40;
                  label146: {
                     var33 = _livingEntity3.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity2 = (LivingEntity)entity;
                        if (_livingEntity2.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                           var40 = _livingEntity2.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue();
                           break label146;
                        }
                     }

                     var40 = 0.0;
                  }

                  var33.setBaseValue(var40 + 2.0);
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
               var34 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var34 = ItemStack.EMPTY;
            }

            if (var34.getItem() != JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var34 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var34 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var34.copy().copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with gaigegaigekaigecraft:insect_armor_helmet");
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var34 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var34 = ItemStack.EMPTY;
            }

            if (var34.getItem() != JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var34 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var34 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var34.copy().copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.chest with gaigegaigekaigecraft:insect_armor_chestplate");
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var34 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
            } else {
               var34 = ItemStack.EMPTY;
            }

            if (var34.getItem() != JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var34 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                  } else {
                     var34 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var34.copy().copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.legs with gaigegaigekaigecraft:insect_armor_leggings");
               }
            }
         } else {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with gaigegaigekaigecraft:insect_armor_helmet");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.chest with gaigegaigekaigecraft:insect_armor_chestplate");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.legs with gaigegaigekaigecraft:insect_armor_leggings");
            }
         }

      }
   }
}
