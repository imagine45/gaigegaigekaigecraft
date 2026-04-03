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
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_simple_domain"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               for(String criteria : _ap.getRemainingCriteria()) {
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

      }
   }
}
