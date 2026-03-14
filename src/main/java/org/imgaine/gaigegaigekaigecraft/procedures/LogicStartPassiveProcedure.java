package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class LogicStartPassiveProcedure {
   public LogicStartPassiveProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a;
         int var10000;
         label44: {
            logic_a = false;
            logic_a = true;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                  break label44;
               }
            }

            var10000 = 0;
         }

         label39: {
            if (var10000 <= 0) {
               label48: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt1 = (LivingEntity)entity;
                     if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                        break label48;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt2 = (LivingEntity)entity;
                     if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                        break label48;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label39;
                  }

                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (!_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label39;
                  }
               }
            }

            logic_a = false;
         }

         if (entity instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique <= 0.0) {
            logic_a = false;
         }

         return logic_a;
      }
   }
}
