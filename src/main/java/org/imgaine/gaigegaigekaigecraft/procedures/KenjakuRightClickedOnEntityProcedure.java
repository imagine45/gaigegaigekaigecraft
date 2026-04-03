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
         if (entity.getPersistentData().getDouble("cnt_target") < 6.0 && sourceentity instanceof ServerPlayer) {
            ServerPlayer _plr1 = (ServerPlayer)sourceentity;
            if (_plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_expansion"))).isDone() && sourceentity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)sourceentity;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_amplification"));
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
}
