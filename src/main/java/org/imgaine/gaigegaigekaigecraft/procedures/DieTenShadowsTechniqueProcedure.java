package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DieTenShadowsTechniqueProcedure {
   public DieTenShadowsTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double NUM_RabbitEscape = 0.0;
         Entity entity_a = null;
         if (!entity.getPersistentData().getBoolean("domain_entity") && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num") || entity.getPersistentData().getDouble("friend_num2") != 0.0 && entity.getPersistentData().getDouble("friend_num2") == entity_a.getPersistentData().getDouble("friend_num")) {
               NUM1 = ReturnTenShadowsNumProcedure.execute(entity);
               if (entity.getPersistentData().getBoolean("Ambush")) {
                  NUM2 = -2.0;
                  if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity && entity_a instanceof SukunaFushiguroEntity && entity_a instanceof SukunaFushiguroEntity) {
                     SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity_a;
                     _datEntSetL.getEntityData().set(SukunaFushiguroEntity.DATA_world_cut, true);
                  }
               } else if (entity.getPersistentData().getBoolean("failed_adjustment")) {
                  NUM2 = 0.0;
               } else if (entity.getPersistentData().getBoolean("Despawn")) {
                  if (entity_a instanceof Player) {
                     double var10000 = ((JujutsucraftModVariables.PlayerVariables)GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
                     double var10001 = entity.getPersistentData().getDouble("BaseCursePower") * 0.5;
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getHealth();
                     } else {
                        var10002 = -1.0F;
                     }

                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.getMaxHealth();
                     } else {
                        var10003 = -1.0F;
                     }

                     double _setval = var10000 + var10001 * (double)(var10002 / Math.max(var10003, 1.0F));
                     GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")));
                     });
                  }

                  NUM2 = entity.getPersistentData().getDouble("Ambush_Number");
                  if (entity instanceof DivineDogTotalityEntity) {
                     if (entity_a.getPersistentData().getDouble("TenShadowsTechnique1") > -2.0) {
                        entity_a.getPersistentData().putDouble("TenShadowsTechnique1", 1.0);
                     }

                     if (entity_a.getPersistentData().getDouble("TenShadowsTechnique2") > -2.0) {
                        entity_a.getPersistentData().putDouble("TenShadowsTechnique2", 1.0);
                     }
                  }

                  if (entity instanceof MergedBeastAgitoEntity && entity_a.getPersistentData().getDouble("TenShadowsTechnique4") > -2.0) {
                     entity_a.getPersistentData().putDouble("TenShadowsTechnique4", 1.0);
                  }
               } else {
                  NUM2 = 1.0;
                  if (NUM1 == 4.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_nue"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 5.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_great_serpent"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 6.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_toad"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 7.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_max_elephant"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 8.0 && entity_a instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity_a;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_rabbit_escape"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }

                  if (NUM1 == 9.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_round_deer"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 10.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_piercing_ox"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 11.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_tiger_funeral"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 14.0 && entity_a instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity_a;
                     Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_mahoraga"));
                     AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                     if (!_ap.isDone()) {
                        for(String criteria : _ap.getRemainingCriteria()) {
                           _player.getAdvancements().award(_adv, criteria);
                        }
                     }
                  }
               }

               entity_a.getPersistentData().putDouble("TenShadowsTechnique" + Math.round(NUM1), (double)Math.round(NUM2));
            }
         }

      }
   }
}
