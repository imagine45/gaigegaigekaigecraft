package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UraumeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class LogicAttackProcedure {
   public LogicAttackProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double velocity = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         boolean logic_attack = false;
         boolean player_iterator = false;
         boolean player_target = false;
         Entity entity_iterator = null;
         Entity entity_attacker_owner = null;
         Entity entity_iterator_owner = null;
         Entity entity_attacker = null;
         Entity entity_a = null;
         logic_attack = false;
         if (entity != entityiterator && entityiterator instanceof LivingEntity) {
            entity_iterator = entityiterator;

            for(int index0 = 0; index0 < 100 && !entity_iterator.getPersistentData().m_128461_("OWNER_UUID").isEmpty() && entity_iterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))); ++index0) {
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
               }).apply(world, entity_iterator.getPersistentData().m_128461_("OWNER_UUID"));
               if (!(entity_a instanceof LivingEntity)) {
                  break;
               }

               entity_iterator = entity_a;
            }

            entity_attacker = entity;

            for(int index1 = 0; index1 < 100 && !entity_attacker.getPersistentData().m_128461_("OWNER_UUID").isEmpty() && entity_attacker.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))); ++index1) {
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
               }).apply(world, entity_attacker.getPersistentData().m_128461_("OWNER_UUID"));
               if (!(entity_a instanceof LivingEntity)) {
                  break;
               }

               entity_attacker = entity_a;
            }

            entity_iterator_owner = entity_iterator;

            for(int index2 = 0; index2 < 100 && !entity_iterator_owner.getPersistentData().m_128461_("OWNER_UUID").isEmpty(); ++index2) {
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
               }).apply(world, entity_iterator_owner.getPersistentData().m_128461_("OWNER_UUID"));
               if (!(entity_a instanceof LivingEntity)) {
                  break;
               }

               entity_iterator_owner = entity_a;
            }

            entity_attacker_owner = entity;
            int index3 = 0;

            while(true) {
               if (index3 < 100 && !entity_attacker_owner.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
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
                  }).apply(world, entity_attacker_owner.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity_a instanceof LivingEntity) {
                     entity_attacker_owner = entity_a;
                     ++index3;
                     continue;
                  }
               }

               if (entity.getPersistentData().m_128471_("onlyLiving") && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                  return false;
               }

               if (entity.getPersistentData().m_128471_("onlyRanged") && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                  return false;
               }

               if (entityiterator instanceof Player) {
                  Player _plr = (Player)entityiterator;
                  if (_plr.m_150110_().f_35937_) {
                     return false;
                  }
               }

               if (((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                     } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                        return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entityiterator) || entityiterator.m_20147_()) {
                  return false;
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && entity.m_146895_() == entityiterator || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && entityiterator.m_146895_() == entity) {
                  return false;
               }

               logic_attack = true;
               player_target = entity_attacker_owner instanceof Player || entity_attacker_owner.getPersistentData().m_128471_("Player");
               player_iterator = entity_iterator_owner instanceof Player || entity_iterator_owner.getPersistentData().m_128471_("Player");
               if (player_target && player_iterator) {
                  if (!world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP)) {
                     logic_attack = false;
                  }
               } else if (!entity_attacker_owner.getPersistentData().m_128471_("JujutsuSorcerer") && !entity_attacker.getPersistentData().m_128471_("JujutsuSorcerer")) {
                  if (!entity_attacker_owner.getPersistentData().m_128471_("CursedSpirit") && !entity_attacker.getPersistentData().m_128471_("CursedSpirit")) {
                     if ((entity_attacker_owner.getPersistentData().m_128471_("CurseUser") || entity_attacker.getPersistentData().m_128471_("CurseUser")) && (entity_iterator_owner.getPersistentData().m_128471_("CurseUser") || entity_iterator.getPersistentData().m_128471_("CurseUser"))) {
                        logic_attack = false;
                     }
                  } else if (entity_iterator_owner.getPersistentData().m_128471_("CursedSpirit") || entity_iterator.getPersistentData().m_128471_("CursedSpirit")) {
                     logic_attack = false;
                  }
               } else if (entity_iterator_owner.getPersistentData().m_128471_("JujutsuSorcerer") || entity_iterator.getPersistentData().m_128471_("JujutsuSorcerer")) {
                  logic_attack = false;
               }

               label452: {
                  label566: {
                     if (entity_attacker_owner instanceof LivingEntity) {
                        LivingEntity _livEnt50 = (LivingEntity)entity_attacker_owner;
                        if (_livEnt50.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label566;
                        }
                     }

                     if (entity_attacker instanceof LivingEntity) {
                        LivingEntity _livEnt51 = (LivingEntity)entity_attacker;
                        if (_livEnt51.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label566;
                        }
                     }

                     if (entity_iterator_owner instanceof LivingEntity) {
                        LivingEntity _livEnt52 = (LivingEntity)entity_iterator_owner;
                        if (_livEnt52.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label566;
                        }
                     }

                     if (!(entity_iterator instanceof LivingEntity)) {
                        break label452;
                     }

                     LivingEntity _livEnt53 = (LivingEntity)entity_iterator;
                     if (!_livEnt53.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label452;
                     }
                  }

                  logic_attack = true;
               }

               if (logic_attack) {
                  label432: {
                     label568: {
                        if (entity_attacker_owner instanceof UraumeEntity) {
                           if (ReturnInsideItemProcedure.execute(entity_iterator_owner).m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
                              break label568;
                           }

                           if (entity_iterator_owner instanceof LivingEntity) {
                              LivingEntity _livEnt56 = (LivingEntity)entity_iterator_owner;
                              if (_livEnt56.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label568;
                              }
                           }
                        }

                        if (!(entity_iterator_owner instanceof UraumeEntity)) {
                           break label432;
                        }

                        if (ReturnInsideItemProcedure.execute(entity_attacker_owner).m_41720_() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                           if (!(entity_attacker_owner instanceof LivingEntity)) {
                              break label432;
                           }

                           LivingEntity _livEnt59 = (LivingEntity)entity_attacker_owner;
                           if (!_livEnt59.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label432;
                           }
                        }
                     }

                     logic_attack = false;
                  }

                  if ((entity_attacker_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_1"))) || entity_attacker_owner instanceof Player && entity_attacker_owner.getPersistentData().m_128471_("CurseUser")) && (entity_iterator_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_1"))) || entity_iterator_owner instanceof Player && entity_iterator_owner.getPersistentData().m_128471_("CurseUser")) || entity_attacker_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_2"))) && entity_iterator_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_2"))) || entity_attacker_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_3"))) && entity_iterator_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_3"))) || entity_attacker_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_4"))) && entity_iterator_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_4"))) || entity_attacker_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_5"))) && entity_iterator_owner.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_5")))) {
                     logic_attack = false;
                  }
               }

               if (!logic_attack) {
                  if (player_target) {
                     LivingEntity var10000;
                     if (entity_iterator instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_iterator;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity && entity_iterator.getPersistentData().m_128459_("cnt_target") > 6.0) {
                        label572: {
                           if (entity_iterator instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_iterator;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (!(var10000 instanceof Player)) {
                              if (entity_iterator instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_iterator;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (!((Entity)var10000).getPersistentData().m_128471_("Player")) {
                                 break label572;
                              }
                           }

                           logic_attack = true;
                        }
                     }
                  }

                  if (player_iterator) {
                     LivingEntity var60;
                     if (entity_attacker instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_attacker;
                        var60 = _mobEnt.m_5448_();
                     } else {
                        var60 = null;
                     }

                     if (var60 instanceof LivingEntity && entity_attacker.getPersistentData().m_128459_("cnt_target") > 6.0) {
                        label586: {
                           if (entity_attacker instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_attacker;
                              var60 = _mobEnt.m_5448_();
                           } else {
                              var60 = null;
                           }

                           if (!(var60 instanceof Player)) {
                              if (entity_attacker instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_attacker;
                                 var60 = _mobEnt.m_5448_();
                              } else {
                                 var60 = null;
                              }

                              if (!((Entity)var60).getPersistentData().m_128471_("Player")) {
                                 break label586;
                              }
                           }

                           logic_attack = true;
                        }
                     }
                  }
               }

               if (entity instanceof CrowEntity && entityiterator instanceof CrowEntity) {
                  logic_attack = false;
               }

               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged") || entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged")) {
                     logic_attack = false;
                  }

                  if (entity.getPersistentData().m_128471_("betrayal")) {
                     if (!entity_iterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_()) && !entity.getPersistentData().m_128461_("OWNER_UUID").equals(entity_iterator.m_20149_())) {
                        if (entity.getPersistentData().m_128459_("NameRanged_ranged") != entityiterator.getPersistentData().m_128459_("NameRanged_ranged")) {
                           return true;
                        }
                     } else {
                        logic_attack = false;
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("NameRanged") != 0.0 && (entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged") || entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged"))) {
                  logic_attack = false;
               }

               if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                  LivingEntity var63;
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var63 = _mobEnt.m_5448_();
                  } else {
                     var63 = null;
                  }

                  if (var63 instanceof LivingEntity && entityiterator.getPersistentData().m_128459_("cnt_target") > 6.0) {
                     double var64 = entity.getPersistentData().m_128459_("friend_num");
                     LivingEntity var10001;
                     if (entityiterator instanceof Mob) {
                        Mob _mobEnt = (Mob)entityiterator;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     if (var64 == ((Entity)var10001).getPersistentData().m_128459_("friend_num")) {
                        logic_attack = true;
                     }
                  }
               }

               LivingEntity var65;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var65 = _mobEnt.m_5448_();
               } else {
                  var65 = null;
               }

               label611: {
                  if (var65 != entityiterator || !(entity.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                     if (entityiterator instanceof Mob) {
                        Mob _mobEnt = (Mob)entityiterator;
                        var65 = _mobEnt.m_5448_();
                     } else {
                        var65 = null;
                     }

                     if (var65 != entity || !(entityiterator.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                        if (entity_attacker_owner instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_attacker_owner;
                           var65 = _mobEnt.m_5448_();
                        } else {
                           var65 = null;
                        }

                        if (var65 != entityiterator || !(entity_attacker_owner.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                           if (entity_iterator_owner instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_iterator_owner;
                              var65 = _mobEnt.m_5448_();
                           } else {
                              var65 = null;
                           }

                           if (var65 != entity || !(entity_iterator_owner.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                              if (entity_attacker_owner instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_attacker_owner;
                                 var65 = _mobEnt.m_5448_();
                              } else {
                                 var65 = null;
                              }

                              if (var65 != entity_iterator_owner || !(entity_attacker_owner.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                                 if (entity_iterator_owner instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity_iterator_owner;
                                    var65 = _mobEnt.m_5448_();
                                 } else {
                                    var65 = null;
                                 }

                                 if (var65 != entity_attacker_owner || !(entity_iterator_owner.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                                    break label611;
                                 }
                              }

                              logic_attack = true;
                              break label611;
                           }
                        }

                        logic_attack = true;
                        break label611;
                     }
                  }

                  logic_attack = true;
               }

               if (entity_attacker_owner == entity_iterator_owner) {
                  logic_attack = false;
               }

               if (entity_attacker.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entity_attacker.getPersistentData().m_128471_("Ambush") || entity_iterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entity_iterator.getPersistentData().m_128471_("Ambush")) {
                  logic_attack = true;
               }

               if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                  logic_attack = false;
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt140 = (LivingEntity)entityiterator;
                  if (_livEnt140.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                     label288: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              var71 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                              break label288;
                           }
                        }

                        var71 = 0;
                     }

                     if (var71 > 0 && (!(entity.getPersistentData().m_128459_("skill") >= 305.0) || !(entity.getPersistentData().m_128459_("skill") <= 310.0)) && entity.getPersistentData().m_128459_("skill") != 205.0 && entity.getPersistentData().m_128459_("skill") != 705.0) {
                        logic_attack = false;
                     }
                  }
               }

               if (entity.getPersistentData().m_128471_("DomainAttack")) {
                  logic_attack = LogicAttackDomainProcedure.execute(world, entity, entityiterator);
               }

               if (entity.getPersistentData().m_128459_("target_type") != 0.0) {
                  velocity = Math.sqrt(Math.pow(entityiterator.m_20184_().m_7096_(), 2.0) + Math.pow(entityiterator.m_20184_().m_7098_(), 2.0) + Math.pow(entityiterator.m_20184_().m_7094_(), 2.0));
                  if (entity.getPersistentData().m_128459_("target_type") == 1.0) {
                     logic_attack = velocity > 1.0;
                  } else if (entity.getPersistentData().m_128459_("target_type") == 2.0 && velocity < 0.1 && !entityiterator.m_20142_()) {
                     logic_attack = false;
                  }
               }
               break;
            }
         }

         return logic_attack;
      } else {
         return false;
      }
   }
}
