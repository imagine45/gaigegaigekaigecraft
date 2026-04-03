package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.YorozuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class InsectArmorExpiresProcedure {
   public InsectArmorExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
      if (entity != null) {
         boolean Player = false;
         double num_level = 0.0;
         num_level = amplifier + 1.0;
         if (num_level > 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity1 = (LivingEntity)entity;
               if (_livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                  AttributeInstance var10000;
                  double var10001;
                  label126: {
                     var10000 = _livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity0 = (LivingEntity)entity;
                        if (_livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                           var10001 = _livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                           break label126;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var10000.setBaseValue(var10001 - num_level * 0.6);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity3 = (LivingEntity)entity;
               if (_livingEntity3.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                  AttributeInstance var21;
                  double var22;
                  label115: {
                     var21 = _livingEntity3.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity2 = (LivingEntity)entity;
                        if (_livingEntity2.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                           var22 = _livingEntity2.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue();
                           break label115;
                        }
                     }

                     var22 = 0.0;
                  }

                  var21.setBaseValue(var22 - 2.0);
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

         Player = entity instanceof Player;
         if (Player) {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:insect_armor_helmet");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:insect_armor_chestplate");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:insect_armor_leggings");
            }
         } else {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.head with air");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.chest with air");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.legs with air");
            }

            if (entity instanceof YorozuEntity && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.chest with gaigegaigekaigecraft:clothes_yorozu_chestplate");
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
         }

         entity.getPersistentData().putBoolean("canFly", false);
      }
   }
}
