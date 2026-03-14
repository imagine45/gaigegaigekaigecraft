package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DebuggerJrRightClickedInAirProcedure {
   public DebuggerJrRightClickedInAirProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("skill", 2020.0);
         entity.getPersistentData().m_128347_("cnt1", 0.0);
         entity.getPersistentData().m_128347_("cnt2", 0.0);
         entity.getPersistentData().m_128347_("cnt3", 0.0);
         entity.getPersistentData().m_128347_("Damage", 0.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
            }
         }

      }
   }
}
