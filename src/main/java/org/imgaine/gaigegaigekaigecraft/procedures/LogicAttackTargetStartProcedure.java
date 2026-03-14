package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UraumeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.scores.Scoreboard;

public class LogicAttackTargetStartProcedure {
   public LogicAttackTargetStartProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         Entity event_owner = null;
         Entity target_owner = null;
         Entity entity_a = null;
         logic_a = true;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
               double var56 = entity.getPersistentData().m_128459_("friend_num");
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               if (var56 == ((Entity)var10001).getPersistentData().m_128459_("friend_num")) {
                  return false;
               }
            }

            String var57 = entity.getPersistentData().m_128461_("TARGET_UUID");
            LivingEntity var78;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var78 = _mobEnt.m_5448_();
            } else {
               var78 = null;
            }

            if (var57.equals(((Entity)var78).m_20149_())) {
               return true;
            }

            event_owner = entity;

            for(int index0 = 0; index0 < 100 && !event_owner.getPersistentData().m_128461_("OWNER_UUID").isEmpty(); ++index0) {
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
               }).apply(world, event_owner.getPersistentData().m_128461_("OWNER_UUID"));
               if (!(entity_a instanceof LivingEntity)) {
                  break;
               }

               event_owner = entity_a;
            }

            LivingEntity var58;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var58 = _mobEnt.m_5448_();
            } else {
               var58 = null;
            }

            Entity var26 = var58;

            for(int index1 = 0; index1 < 100 && !((Entity)var26).getPersistentData().m_128461_("OWNER_UUID").isEmpty(); ++index1) {
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
               }).apply(world, ((Entity)var26).getPersistentData().m_128461_("OWNER_UUID"));
               if (!(entity_a instanceof LivingEntity)) {
                  break;
               }

               var26 = entity_a;
            }

            if (!(event_owner instanceof Player) && !event_owner.getPersistentData().m_128471_("Player") || !(var26 instanceof Player) && !((Entity)var26).getPersistentData().m_128471_("Player")) {
               if (!event_owner.getPersistentData().m_128471_("JujutsuSorcerer") && !entity.getPersistentData().m_128471_("JujutsuSorcerer")) {
                  if (!event_owner.getPersistentData().m_128471_("CursedSpirit") && !event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:transfigured_human")))) {
                     if ((event_owner.getPersistentData().m_128471_("CurseUser") || entity.getPersistentData().m_128471_("CurseUser")) && !((Entity)var26).getPersistentData().m_128471_("JujutsuSorcerer") && !((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("curseuser"))) && !((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("cursedspirit")))) {
                        logic_a = false;
                     }
                  } else if (((Entity)var26).getPersistentData().m_128471_("CursedSpirit") || ((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:transfigured_human")))) {
                     logic_a = false;
                  }
               } else {
                  label453: {
                     if (!((Entity)var26).getPersistentData().m_128471_("JujutsuSorcerer")) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var58 = _mobEnt.m_5448_();
                        } else {
                           var58 = null;
                        }

                        if (!((Entity)var58).getPersistentData().m_128471_("JujutsuSorcerer")) {
                           break label453;
                        }
                     }

                     logic_a = false;
                  }
               }
            } else if (!world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP)) {
               logic_a = false;
            }

            label370: {
               label432: {
                  if (event_owner instanceof LivingEntity) {
                     LivingEntity _livEnt37 = (LivingEntity)event_owner;
                     if (_livEnt37.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label432;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt38 = (LivingEntity)entity;
                     if (_livEnt38.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label432;
                     }
                  }

                  if (var26 instanceof LivingEntity) {
                     LivingEntity _livEnt39 = (LivingEntity)var26;
                     if (_livEnt39.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label432;
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var58 = _mobEnt.m_5448_();
                  } else {
                     var58 = null;
                  }

                  LivingEntity var13 = var58;
                  if (!(var13 instanceof LivingEntity)) {
                     break label370;
                  }

                  LivingEntity _livEnt41 = var13;
                  if (!_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     break label370;
                  }
               }

               logic_a = true;
            }

            if (event_owner instanceof UraumeEntity) {
               label443: {
                  if (ReturnInsideItemProcedure.execute((Entity)var26).m_41720_() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                     if (!(var26 instanceof LivingEntity)) {
                        break label443;
                     }

                     LivingEntity _livEnt44 = (LivingEntity)var26;
                     if (!_livEnt44.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label443;
                     }
                  }

                  logic_a = false;
               }
            }

            if (event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) {
               label444: {
                  if (var26 instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)((Entity)var26).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 21.0 && ((JujutsucraftModVariables.PlayerVariables)((Entity)var26).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 21.0) {
                        break label444;
                     }
                  } else if (!((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) {
                     break label444;
                  }

                  logic_a = false;
               }
            }

            label333: {
               label435: {
                  label436: {
                     if (!event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_1")))) {
                        if (!(event_owner instanceof Player) || !event_owner.getPersistentData().m_128471_("CurseUser")) {
                           break label436;
                        }

                        if (event_owner instanceof LivingEntity) {
                           LivingEntity _livEnt51 = (LivingEntity)event_owner;
                           if (_livEnt51.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label436;
                           }
                        }
                     }

                     if (((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_1")))) {
                        break label435;
                     }

                     if (var26 instanceof Player && ((Entity)var26).getPersistentData().m_128471_("CurseUser")) {
                        if (!(var26 instanceof LivingEntity)) {
                           break label435;
                        }

                        LivingEntity _livEnt55 = (LivingEntity)var26;
                        if (!_livEnt55.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label435;
                        }
                     }
                  }

                  if ((!event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_2"))) || !((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_2")))) && (!event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_3"))) || !((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_3")))) && (!event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_4"))) || !((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_4")))) && (!event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_5"))) || !((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_5")))) && (!event_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:zenin"))) || !((Entity)var26).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:zenin"))))) {
                     break label333;
                  }
               }

               logic_a = false;
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var58 = _mobEnt.m_5448_();
            } else {
               var58 = null;
            }

            LivingEntity _teamEnt = var58;
            if (_teamEnt instanceof Mob) {
               Mob _mobEnt = (Mob)_teamEnt;
               var58 = _mobEnt.m_5448_();
            } else {
               var58 = null;
            }

            if (var58 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var58 = _mobEnt.m_5448_();
               } else {
                  var58 = null;
               }

               if (((Entity)var58).getPersistentData().m_128459_("cnt_target") > 6.0) {
                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                     double var64 = entity.getPersistentData().m_128459_("friend_num");
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var78 = _mobEnt.m_5448_();
                     } else {
                        var78 = null;
                     }

                     LivingEntity var53 = var78;
                     if (var53 instanceof Mob) {
                        Mob _mobEnt = (Mob)var53;
                        var78 = _mobEnt.m_5448_();
                     } else {
                        var78 = null;
                     }

                     if (var64 == ((Entity)var78).getPersistentData().m_128459_("friend_num")) {
                        logic_a = true;
                     }
                  }

                  label290: {
                     if (event_owner instanceof LivingEntity) {
                        _teamEnt = (LivingEntity)event_owner;
                        Scoreboard var65 = _teamEnt.m_9236_().m_6188_();
                        String var81;
                        if (_teamEnt instanceof Player) {
                           Player _pl = (Player)_teamEnt;
                           var81 = _pl.m_36316_().getName();
                        } else {
                           var81 = _teamEnt.m_20149_();
                        }

                        if (var65.m_83500_(var81) != null) {
                           var65 = _teamEnt.m_9236_().m_6188_();
                           if (_teamEnt instanceof Player) {
                              Player _pl = (Player)_teamEnt;
                              var81 = _pl.m_36316_().getName();
                           } else {
                              var81 = _teamEnt.m_20149_();
                           }

                           var66 = var65.m_83500_(var81).m_5758_();
                           break label290;
                        }
                     }

                     var66 = "";
                  }

                  if (!var66.isEmpty()) {
                     label283: {
                        if (event_owner instanceof LivingEntity) {
                           LivingEntity _teamEnt = (LivingEntity)event_owner;
                           Scoreboard var68 = _teamEnt.m_9236_().m_6188_();
                           String var83;
                           if (_teamEnt instanceof Player) {
                              Player _pl = (Player)_teamEnt;
                              var83 = _pl.m_36316_().getName();
                           } else {
                              var83 = _teamEnt.m_20149_();
                           }

                           if (var68.m_83500_(var83) != null) {
                              var68 = _teamEnt.m_9236_().m_6188_();
                              if (_teamEnt instanceof Player) {
                                 Player _pl = (Player)_teamEnt;
                                 var83 = _pl.m_36316_().getName();
                              } else {
                                 var83 = _teamEnt.m_20149_();
                              }

                              var69 = var68.m_83500_(var83).m_5758_();
                              break label283;
                           }
                        }

                        var69 = "";
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var78 = _mobEnt.m_5448_();
                     } else {
                        var78 = null;
                     }

                     LivingEntity var23 = var78;
                     if (var23 instanceof Mob) {
                        Mob _mobEnt = (Mob)var23;
                        var78 = _mobEnt.m_5448_();
                     } else {
                        var78 = null;
                     }

                     label276: {
                        LivingEntity var22 = var78;
                        if (var22 instanceof LivingEntity) {
                           LivingEntity _teamEnt = var22;
                           Scoreboard var87 = _teamEnt.m_9236_().m_6188_();
                           String var10002;
                           if (_teamEnt instanceof Player) {
                              Player _pl = (Player)_teamEnt;
                              var10002 = _pl.m_36316_().getName();
                           } else {
                              var10002 = _teamEnt.m_20149_();
                           }

                           if (var87.m_83500_(var10002) != null) {
                              var87 = _teamEnt.m_9236_().m_6188_();
                              if (_teamEnt instanceof Player) {
                                 Player _pl = (Player)_teamEnt;
                                 var10002 = _pl.m_36316_().getName();
                              } else {
                                 var10002 = _teamEnt.m_20149_();
                              }

                              var88 = var87.m_83500_(var10002).m_5758_();
                              break label276;
                           }
                        }

                        var88 = "";
                     }

                     if (var69.equals(var88)) {
                        logic_a = true;
                     }
                  }
               }
            }

            if (event_owner == var26) {
               logic_a = false;
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entity.getPersistentData().m_128471_("Ambush")) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var58 = _mobEnt.m_5448_();
               } else {
                  var58 = null;
               }

               if (!((Entity)var58).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) {
                  logic_a = true;
               }

               if (entity instanceof RabbitEscapeEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var58 = _mobEnt.m_5448_();
                  } else {
                     var58 = null;
                  }

                  if (var58 instanceof RabbitEscapeEntity) {
                     logic_a = false;
                  }
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var58 = _mobEnt.m_5448_();
            } else {
               var58 = null;
            }

            _teamEnt = var58;
            if (_teamEnt instanceof Mob) {
               Mob _mobEnt = (Mob)_teamEnt;
               var58 = _mobEnt.m_5448_();
            } else {
               var58 = null;
            }

            if (var58 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var58 = _mobEnt.m_5448_();
               } else {
                  var58 = null;
               }

               if (((Entity)var58).getPersistentData().m_128459_("cnt_target") > 6.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var58 = _mobEnt.m_5448_();
                  } else {
                     var58 = null;
                  }

                  LivingEntity var55 = var58;
                  if (var55 instanceof Mob) {
                     Mob _mobEnt = (Mob)var55;
                     var58 = _mobEnt.m_5448_();
                  } else {
                     var58 = null;
                  }

                  if (var58 == entity) {
                     logic_a = true;
                  }
               }
            }
         }

         return logic_a;
      }
   }
}
