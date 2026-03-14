package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class ItadoriDomainActiveProcedure {
   public ItadoriDomainActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label23: {
            double old_skill = 0.0;
            double ticks = 0.0;
            range = 0.0;
            double old_cooldown = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label23;
               }
            }

            var10000 = 0.0;
         }

         double var12 = var10000;
         if (var12 % 20.0 <= 5.0 || entity.getPersistentData().m_128471_("StartDomainAttack")) {
            entity.getPersistentData().m_128379_("StartDomainAttack", false);
            double var11 = entity.getPersistentData().m_128459_("skill");
            double var14 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", 60.0);
            entity.getPersistentData().m_128347_("skill", 2108.0);
            entity.getPersistentData().m_128347_("Damage", 15.0 + var12 % 20.0);
            entity.getPersistentData().m_128347_("Range", range);
            entity.getPersistentData().m_128347_("effect", 4.0);
            entity.getPersistentData().m_128379_("swing", false);
            entity.getPersistentData().m_128379_("attack", false);
            entity.getPersistentData().m_128379_("DomainAttack", true);
            RangeAttackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
            entity.getPersistentData().m_128347_("skill", var11);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var14);
         }

      }
   }
}
