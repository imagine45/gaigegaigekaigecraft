package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class KenjakuRightClickedOnEntityProcedure {
   public KenjakuRightClickedOnEntityProcedure() {
   }

   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity.getPersistentData().m_128459_("cnt_target") < 6.0 && sourceentity instanceof ServerPlayer) {
            ServerPlayer _plr1 = (ServerPlayer)sourceentity;
            if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).m_8193_() && sourceentity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)sourceentity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_amplification"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         }

      }
   }
}
