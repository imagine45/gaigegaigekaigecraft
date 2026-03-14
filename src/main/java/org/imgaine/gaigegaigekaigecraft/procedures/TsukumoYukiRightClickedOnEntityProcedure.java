package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class TsukumoYukiRightClickedOnEntityProcedure {
   public TsukumoYukiRightClickedOnEntityProcedure() {
   }

   public static void execute(Entity sourceentity) {
      if (sourceentity != null) {
         if (sourceentity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)sourceentity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_simple_domain"));
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
