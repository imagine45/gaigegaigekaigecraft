package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UraumeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class LogicAttackProcedure {
   public LogicAttackProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null && entity != entityiterator) {
         if (!(entityiterator instanceof LivingEntity)) {
            return false;
         } else {
            Entity attacker_owner = entity;
            Entity iterator_owner = entityiterator;
            int safeCount = 0;

            for(String aOwnerUUID = entity.getPersistentData().getString("OWNER_UUID"); !aOwnerUUID.isEmpty() && safeCount < 5; ++safeCount) {
               Entity found = GetEntityFromUUIDProcedure.execute(world, aOwnerUUID);
               if (!(found instanceof LivingEntity)) {
                  break;
               }

               attacker_owner = found;
               aOwnerUUID = found.getPersistentData().getString("OWNER_UUID");
            }

            safeCount = 0;

            for(String iOwnerUUID = entityiterator.getPersistentData().getString("OWNER_UUID"); !iOwnerUUID.isEmpty() && safeCount < 5; ++safeCount) {
               Entity found = GetEntityFromUUIDProcedure.execute(world, iOwnerUUID);
               if (!(found instanceof LivingEntity)) {
                  break;
               }

               iterator_owner = found;
               iOwnerUUID = found.getPersistentData().getString("OWNER_UUID");
            }

            if (entity.getPersistentData().getBoolean("onlyLiving") && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
               return false;
            } else if (entity.getPersistentData().getBoolean("onlyRanged") && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               return false;
            } else if (entityiterator.isInvulnerable()) {
               return false;
            } else {
               if (entityiterator instanceof Player) {
                  Player p = (Player)entityiterator;
                  if (p.getAbilities().instabuild || p.isSpectator()) {
                     return false;
                  }
               }

               if ((!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) || entity.getFirstPassenger() != entityiterator) && (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) || entityiterator.getFirstPassenger() != entity)) {
                  boolean logic_attack = true;
                  boolean pTarget = attacker_owner instanceof Player;
                  boolean pIterator = iterator_owner instanceof Player;
                  if (pTarget && pIterator) {
                     if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                        logic_attack = false;
                     }
                  } else if (!attacker_owner.getPersistentData().getBoolean("JujutsuSorcerer") && !entity.getPersistentData().getBoolean("JujutsuSorcerer") || !iterator_owner.getPersistentData().getBoolean("JujutsuSorcerer") && !entityiterator.getPersistentData().getBoolean("JujutsuSorcerer")) {
                     if (!attacker_owner.getPersistentData().getBoolean("CursedSpirit") && !entity.getPersistentData().getBoolean("CursedSpirit") || !iterator_owner.getPersistentData().getBoolean("CursedSpirit") && !entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                        if ((attacker_owner.getPersistentData().getBoolean("CurseUser") || entity.getPersistentData().getBoolean("CurseUser")) && (iterator_owner.getPersistentData().getBoolean("CurseUser") || entityiterator.getPersistentData().getBoolean("CurseUser"))) {
                           logic_attack = false;
                        }
                     } else {
                        logic_attack = false;
                     }
                  } else {
                     logic_attack = false;
                  }

                  label368: {
                     label460: {
                        if (attacker_owner instanceof LivingEntity) {
                           LivingEntity le = (LivingEntity)attacker_owner;
                           if (le.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label460;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity le2 = (LivingEntity)entity;
                           if (le2.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label460;
                           }
                        }

                        if (iterator_owner instanceof LivingEntity) {
                           LivingEntity le3 = (LivingEntity)iterator_owner;
                           if (le3.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label460;
                           }
                        }

                        if (!(entityiterator instanceof LivingEntity)) {
                           break label368;
                        }

                        LivingEntity le4 = (LivingEntity)entityiterator;
                        if (!le4.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label368;
                        }
                     }

                     logic_attack = true;
                  }

                  if (logic_attack) {
                     if (attacker_owner instanceof UraumeEntity) {
                        label469: {
                           if (ReturnInsideItemProcedure.execute(iterator_owner).getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                              if (!(iterator_owner instanceof LivingEntity)) {
                                 break label469;
                              }

                              LivingEntity le = (LivingEntity)iterator_owner;
                              if (!le.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label469;
                              }
                           }

                           logic_attack = false;
                        }
                     }

                     if (iterator_owner instanceof UraumeEntity) {
                        label470: {
                           if (ReturnInsideItemProcedure.execute(attacker_owner).getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                              if (!(attacker_owner instanceof LivingEntity)) {
                                 break label470;
                              }

                              LivingEntity le = (LivingEntity)attacker_owner;
                              if (!le.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label470;
                              }
                           }

                           logic_attack = false;
                        }
                     }

                     if ((attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_1"))) || attacker_owner instanceof Player && attacker_owner.getPersistentData().getBoolean("CurseUser")) && (iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_1"))) || iterator_owner instanceof Player && iterator_owner.getPersistentData().getBoolean("CurseUser")) || attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_2"))) && iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_2"))) || attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_3"))) && iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_3"))) || attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_4"))) && iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_4"))) || attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_5"))) && iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_5")))) {
                        logic_attack = false;
                     }
                  }

                  if (!logic_attack) {
                     if (pTarget && entityiterator instanceof Mob) {
                        Mob m = (Mob)entityiterator;
                        if (m.getTarget() instanceof LivingEntity && entityiterator.getPersistentData().getDouble("cnt_target") > 6.0 && (m.getTarget() instanceof Player || m.getTarget().getPersistentData().getBoolean("Player"))) {
                           logic_attack = true;
                        }
                     }

                     if (pIterator && entity instanceof Mob) {
                        Mob m = (Mob)entity;
                        if (m.getTarget() instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0 && (m.getTarget() instanceof Player || m.getTarget().getPersistentData().getBoolean("Player"))) {
                           logic_attack = true;
                        }
                     }
                  }

                  if (entity instanceof CrowEntity && entityiterator instanceof CrowEntity) {
                     logic_attack = false;
                  }

                  boolean targeting;
                  label467: {
                     targeting = false;
                     if (entity instanceof Mob) {
                        Mob m = (Mob)entity;
                        if (m.getTarget() == entityiterator && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                           targeting = true;
                           break label467;
                        }
                     }

                     if (entityiterator instanceof Mob) {
                        Mob m = (Mob)entityiterator;
                        if (m.getTarget() == entity && entityiterator.getPersistentData().getDouble("cnt_target") > 6.0) {
                           targeting = true;
                           break label467;
                        }
                     }

                     if (attacker_owner instanceof Mob) {
                        Mob m = (Mob)attacker_owner;
                        if (m.getTarget() == entityiterator && attacker_owner.getPersistentData().getDouble("cnt_target") > 6.0) {
                           targeting = true;
                           break label467;
                        }
                     }

                     if (iterator_owner instanceof Mob) {
                        Mob m = (Mob)iterator_owner;
                        if (m.getTarget() == entity && iterator_owner.getPersistentData().getDouble("cnt_target") > 6.0) {
                           targeting = true;
                           break label467;
                        }
                     }

                     if (attacker_owner instanceof Mob) {
                        Mob m = (Mob)attacker_owner;
                        if (m.getTarget() == iterator_owner && attacker_owner.getPersistentData().getDouble("cnt_target") > 6.0) {
                           targeting = true;
                           break label467;
                        }
                     }

                     if (iterator_owner instanceof Mob) {
                        Mob m = (Mob)iterator_owner;
                        if (m.getTarget() == attacker_owner && iterator_owner.getPersistentData().getDouble("cnt_target") > 6.0) {
                           targeting = true;
                        }
                     }
                  }

                  if (targeting) {
                     logic_attack = true;
                  }

                  if (attacker_owner == iterator_owner) {
                     logic_attack = false;
                  }

                  if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique"))) && !entity.getPersistentData().getBoolean("Ambush") || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique"))) && !entityiterator.getPersistentData().getBoolean("Ambush")) {
                     logic_attack = true;
                  }

                  if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                     logic_attack = false;
                  }

                  double myRanged = entity.getPersistentData().getDouble("NameRanged_ranged");
                  double myName = entity.getPersistentData().getDouble("NameRanged");
                  double targetName = entityiterator.getPersistentData().getDouble("NameRanged");
                  double targetRanged = entityiterator.getPersistentData().getDouble("NameRanged_ranged");
                  if (myRanged != 0.0) {
                     if (myRanged == targetName || myRanged == targetRanged) {
                        logic_attack = false;
                     }

                     if (entity.getPersistentData().getBoolean("betrayal")) {
                        if (!iterator_owner.getStringUUID().equals(entity.getStringUUID()) && !entity.getStringUUID().equals(iterator_owner.getStringUUID())) {
                           if (myRanged != targetRanged) {
                              return true;
                           }
                        } else {
                           logic_attack = false;
                        }
                     }
                  }

                  if (myName != 0.0 && (myName == targetName || myName == targetRanged)) {
                     logic_attack = false;
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)entityiterator;
                     if (le.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get()) && le.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()) && le.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier() > 0) {
                        double s = entity.getPersistentData().getDouble("skill");
                        if ((!(s >= 305.0) || !(s <= 310.0)) && s != 205.0 && s != 705.0) {
                           logic_attack = false;
                        }
                     }
                  }

                  if (!logic_attack) {
                     return false;
                  } else if (entity.getPersistentData().getBoolean("DomainAttack") && !LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                     return false;
                  } else {
                     double targetType = entity.getPersistentData().getDouble("target_type");
                     if (targetType != 0.0) {
                        double dx = entityiterator.getDeltaMovement().x();
                        double dy = entityiterator.getDeltaMovement().y();
                        double dz = entityiterator.getDeltaMovement().z();
                        double vSq = dx * dx + dy * dy + dz * dz;
                        if (targetType == 1.0) {
                           if (vSq <= 1.0) {
                              return false;
                           }
                        } else if (targetType == 2.0 && vSq < 0.01 && !entityiterator.isSprinting()) {
                           return false;
                        }
                     }

                     return true;
                  }
               } else {
                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }
}
