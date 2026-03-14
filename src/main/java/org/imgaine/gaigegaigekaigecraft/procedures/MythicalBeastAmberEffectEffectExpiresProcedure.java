package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
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
            if (_livingEntity1.m_21204_().m_22171_(Attributes.f_22281_)) {
               AttributeInstance var10000;
               double var10001;
               label19: {
                  var10000 = _livingEntity1.getAttribute_(Attributes.f_22281_);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity0 = (LivingEntity)entity;
                     if (_livingEntity0.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10001 = _livingEntity0.getAttribute_(Attributes.f_22281_).m_22115_();
                        break label19;
                     }
                  }

                  var10001 = 0.0;
               }

               var10000.m_22100_(var10001 - num_level * 1.2);
            }
         }

         JujutsucraftMod.queueServerWork(1, () -> {
            if (entity instanceof LivingEntity _livEnt2) {
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                  return;
               }
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "clear @s jujutsucraft:mythical_beast_amber_head");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "clear @s jujutsucraft:mythical_beast_amber_helmet");
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.m_21153_(0.0F);
            }

            entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 1.0F);
         });
      }
   }
}
