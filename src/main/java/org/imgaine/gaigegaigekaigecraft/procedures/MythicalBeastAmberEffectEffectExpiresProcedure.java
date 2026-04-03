package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class MythicalBeastAmberEffectEffectExpiresProcedure {
   public MythicalBeastAmberEffectEffectExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, double amplifier) {
      if (entity != null) {
         double num_level = 0.0;
         num_level = amplifier + 1.0;
         if (num_level > 0.0 && entity instanceof LivingEntity) {
            LivingEntity _livingEntity1 = (LivingEntity)entity;
            if (_livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
               AttributeInstance var10000;
               double var10001;
               label19: {
                  var10000 = _livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity0 = (LivingEntity)entity;
                     if (_livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var10001 = _livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                        break label19;
                     }
                  }

                  var10001 = 0.0;
               }

               var10000.setBaseValue(var10001 - num_level * 1.0);
            }
         }

         Gaigegaigekaigecraft.queueServerWork(1, () -> {
            if (entity instanceof LivingEntity _livEnt2) {
               if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                  return;
               }
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:mythical_beast_amber_head");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:mythical_beast_amber_helmet");
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.setHealth(0.0F);
            }

            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
         });
      }
   }
}
