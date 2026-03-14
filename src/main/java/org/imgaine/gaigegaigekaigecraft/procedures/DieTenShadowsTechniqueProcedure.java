package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
         if (!entity.getPersistentData().m_128471_("domain_entity") && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num") || entity.getPersistentData().m_128459_("friend_num2") != 0.0 && entity.getPersistentData().m_128459_("friend_num2") == entity_a.getPersistentData().m_128459_("friend_num")) {
               NUM1 = ReturnTenShadowsNumProcedure.execute(entity);
               if (entity.getPersistentData().m_128471_("Ambush")) {
                  NUM2 = -2.0;
                  if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity && entity_a instanceof SukunaFushiguroEntity && entity_a instanceof SukunaFushiguroEntity) {
                     SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity_a;
                     _datEntSetL.m_20088_().m_135381_(SukunaFushiguroEntity.DATA_world_cut, true);
                  }
               } else if (entity.getPersistentData().m_128471_("failed_adjustment")) {
                  NUM2 = 0.0;
               } else if (entity.getPersistentData().m_128471_("Despawn")) {
                  if (entity_a instanceof Player) {
                     double var10000 = ((JujutsucraftModVariables.PlayerVariables)(new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
                     double var10001 = entity.getPersistentData().m_128459_("BaseCursePower");
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21223_();
                     } else {
                        var10002 = -1.0F;
                     }

                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.m_21233_();
                     } else {
                        var10003 = -1.0F;
                     }

                     double _setval = var10000 + var10001 * (double)(var10002 / Math.max(var10003, 1.0F));
                     (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables((new BiFunction<LevelAccessor, String, Entity>() {
                           public Entity apply(LevelAccessor levelAccessor, String uuid) {
                              if (levelAccessor instanceof ServerLevel serverLevel) {
                                 try {
                                    return serverLevel.m_8791_(UUID.fromString(uuid));
                                 } catch (Exception var5) {
                                 }
                              }

                              return null;
                           }
                        }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")));
                     });
                  }

                  NUM2 = entity.getPersistentData().m_128459_("Ambush_Number");
                  if (entity instanceof DivineDogTotalityEntity) {
                     if (entity_a.getPersistentData().m_128459_("TenShadowsTechnique1") > -2.0) {
                        entity_a.getPersistentData().m_128347_("TenShadowsTechnique1", 1.0);
                     }

                     if (entity_a.getPersistentData().m_128459_("TenShadowsTechnique2") > -2.0) {
                        entity_a.getPersistentData().m_128347_("TenShadowsTechnique2", 1.0);
                     }
                  }

                  if (entity instanceof MergedBeastAgitoEntity && entity_a.getPersistentData().m_128459_("TenShadowsTechnique4") > -2.0) {
                     entity_a.getPersistentData().m_128347_("TenShadowsTechnique4", 1.0);
                  }
               } else {
                  NUM2 = 1.0;
                  if (NUM1 == 4.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_nue"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 5.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_great_serpent"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 6.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_toad"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 7.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_max_elephant"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 8.0 && entity_a instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity_a;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_rabbit_escape"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }

                  if (NUM1 == 9.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_round_deer"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 10.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_piercing_ox"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 11.0) {
                     if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity_a;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_tiger_funeral"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (NUM1 == 14.0 && entity_a instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity_a;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
               }

               entity_a.getPersistentData().m_128347_("TenShadowsTechnique" + Math.round(NUM1), (double)Math.round(NUM2));
            }
         }

      }
   }
}
