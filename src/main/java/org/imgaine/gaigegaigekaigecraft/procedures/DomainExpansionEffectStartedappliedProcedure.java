package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DomainExpansionEffectStartedappliedProcedure {
   public DomainExpansionEffectStartedappliedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double tick = 0.0;
         double level = 0.0;
         entity.getPersistentData().m_128347_("totalDamage", 0.0);
         CompoundTag var10000 = entity.getPersistentData();
         double var10002;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10002 = (double)_livEnt.m_21223_();
         } else {
            var10002 = -1.0;
         }

         var10000.m_128347_("oldHealth", var10002);
      }
   }
}
