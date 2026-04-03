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
public class AdvancementMegumiProcedure {
   public AdvancementMegumiProcedure() {
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
         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6.0) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_ten_shadows_technique"));
               AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
               if (!_ap.isDone()) {
                  for(String criteria : _ap.getRemainingCriteria()) {
                     _player.getAdvancements().award(_adv, criteria);
                  }
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr1 = (ServerPlayer)entity;
               if (_plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_ten_shadows_technique"))).isDone()) {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_divine_dogs"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr3 = (ServerPlayer)entity;
                     if (_plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_2_semi"))).isDone()) {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr4 = (ServerPlayer)entity;
                           if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_nue"))).isDone() && entity instanceof ServerPlayer) {
                              ServerPlayer _player = (ServerPlayer)entity;
                              Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_nue_titan"));
                              AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                              if (!_ap.isDone()) {
                                 for(String criteria : _ap.getRemainingCriteria()) {
                                    _player.getAdvancements().award(_adv, criteria);
                                 }
                              }
                           }
                        }

                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr6 = (ServerPlayer)entity;
                           if (_plr6.level() instanceof ServerLevel && _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:sorcerer_grade_1_semi"))).isDone()) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr7 = (ServerPlayer)entity;
                                 if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_max_elephant"))).isDone() && entity instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entity;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_max_elephant_piercing_blood"));
                                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                       for(String criteria : _ap.getRemainingCriteria()) {
                                          _player.getAdvancements().award(_adv, criteria);
                                       }
                                    }
                                 }
                              }

                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr9 = (ServerPlayer)entity;
                                 if (_plr9.level() instanceof ServerLevel && _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_mahoraga"))).isDone() && entity instanceof ServerPlayer) {
                                    ServerPlayer _player = (ServerPlayer)entity;
                                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_mahoraga_wheel"));
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
