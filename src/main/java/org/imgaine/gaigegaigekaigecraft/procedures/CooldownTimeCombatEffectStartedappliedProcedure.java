package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

public class CooldownTimeCombatEffectStartedappliedProcedure {
   public CooldownTimeCombatEffectStartedappliedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double var10000;
         label19: {
            double StartTimer = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                  break label19;
               }
            }

            var10000 = 0.0;
         }

         double var4 = var10000;
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_(Items.f_42524_, (int)var4);
         }

         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", Math.max(entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), (double)Math.round(var4)));
      }
   }
}
