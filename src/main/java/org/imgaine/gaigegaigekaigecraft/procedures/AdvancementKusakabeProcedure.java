package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AdvancementKusakabeProcedure {
   public AdvancementKusakabeProcedure() {
   }

   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 31.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 31.0) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr1 = (ServerPlayer)entity;
               if (_plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style"))).isDone()) {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_1"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr3 = (ServerPlayer)entity;
                     if (_plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_3"))).isDone()) {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_2"));
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for(String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }

                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr5 = (ServerPlayer)entity;
                           if (_plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2"))).isDone()) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _player = (ServerPlayer)entity;
                                 Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_3"));
                                 AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                 if (!_ap.isDone()) {
                                    for(String criteria : _ap.getRemainingCriteria()) {
                                       _player.getAdvancements().award(_adv, criteria);
                                    }
                                 }
                              }

                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr7 = (ServerPlayer)entity;
                                 if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1"))).isDone() && entity instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entity;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_4"));
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
                  }
               }
            }
         }

      }
   }
}
