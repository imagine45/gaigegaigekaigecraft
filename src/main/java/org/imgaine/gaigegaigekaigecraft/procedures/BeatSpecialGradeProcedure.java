package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade011Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade012Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade013Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade02Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade03Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade04Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade05Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade06Entity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class BeatSpecialGradeProcedure {
   public BeatSpecialGradeProcedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         if (entity instanceof CursedSpiritGrade010Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_2"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade04Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_3"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade011Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_6"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade02Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_7"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade012Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_9"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade05Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_10"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade013Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_11"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade06Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_13"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if (entity instanceof CursedSpiritGrade03Entity) {
            if (entityiterator instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entityiterator;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_15"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }
         } else if ((entity instanceof RikaEntity || entity instanceof Rika2Entity) && entityiterator instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entityiterator;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_cursed_spirit_grade_special_16"));
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
