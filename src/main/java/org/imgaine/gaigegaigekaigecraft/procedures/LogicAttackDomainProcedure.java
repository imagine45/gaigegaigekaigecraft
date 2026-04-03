package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class LogicAttackDomainProcedure {
   public LogicAttackDomainProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         if (!(entityiterator instanceof LivingEntity)) {
            return false;
         } else {
            LivingEntity target = (LivingEntity)entityiterator;
            if (target instanceof Player) {
               Player p = (Player)target;
               if (p.getAbilities().instabuild || p.isSpectator()) {
                  return false;
               }
            }

            if (target instanceof DomainExpansionEntityEntity) {
               return false;
            } else {
               boolean isZeroCursePower = false;
               if (target instanceof Player) {
                  Player pTarget = (Player)target;
                  isZeroCursePower = ((JujutsucraftModVariables.PlayerVariables)pTarget.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 0.0;
               } else {
                  isZeroCursePower = target.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")));
               }

               if (isZeroCursePower) {
                  MobEffectInstance var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)entity;
                     var10000 = le.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  } else {
                     var10000 = null;
                  }

                  MobEffectInstance domainEffect = var10000;
                  if (domainEffect == null || domainEffect.getAmplifier() == 0) {
                     return false;
                  }
               }

               if (!target.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && target.getPersistentData().getDouble("select") == 0.0) {
                  MobEffectInstance var29;
                  if (entity instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)entity;
                     var29 = le.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  } else {
                     var29 = null;
                  }

                  MobEffectInstance attackerDomain = var29;
                  if (target.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) && LogicSimpleDomainProcedure.execute() && attackerDomain != null && attackerDomain.getAmplifier() >= 0) {
                     return false;
                  } else if (!target.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     return false;
                  } else if (!entity.getPersistentData().getBoolean("Failed") && !entity.getPersistentData().getBoolean("Cover")) {
                     if (entity.getPersistentData().getBoolean("onlyLiving") && target.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                        return false;
                     } else {
                        double friendNum = entity.getPersistentData().getDouble("friend_num");
                        if (friendNum != 0.0 && friendNum == target.getPersistentData().getDouble("friend_num")) {
                           return false;
                        } else {
                           double myRanged = entity.getPersistentData().getDouble("NameRanged_ranged");
                           double myName = entity.getPersistentData().getDouble("NameRanged");
                           double targetName = target.getPersistentData().getDouble("NameRanged");
                           double targetRanged = target.getPersistentData().getDouble("NameRanged_ranged");
                           if (myRanged == 0.0 || myRanged != targetName && myRanged != targetRanged) {
                              if (myName == 0.0 || myName != targetName && myName != targetRanged) {
                                 ItemStack helmet = target.getItemBySlot(EquipmentSlot.HEAD);
                                 if (helmet.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || helmet.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                                    boolean isMahoraga = false;
                                    if (!(target instanceof Player)) {
                                       isMahoraga = target instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
                                    } else {
                                       Player pTarget = (Player)target;
                                       JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)pTarget.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                                       isMahoraga = pVars.PlayerCurseTechnique == 16.0 || pVars.PlayerCurseTechnique2 == 16.0;
                                    }

                                    if (isMahoraga) {
                                       CompoundTag var30 = helmet.getOrCreateTag();
                                       CompoundTag var10001 = entity.getPersistentData();
                                       if (var30.getDouble("domain" + Math.round(var10001.getDouble("skill_domain"))) >= 100.0) {
                                          return false;
                                       }
                                    }
                                 }

                                 if (entity instanceof OkkotsuYutaCullingGameEntity) {
                                    boolean old_domainAttack = entity.getPersistentData().getBoolean("DomainAttack");
                                    entity.getPersistentData().putBoolean("DomainAttack", false);
                                    boolean canAttack = LogicAttackProcedure.execute(world, entity, entityiterator);
                                    entity.getPersistentData().putBoolean("DomainAttack", old_domainAttack);
                                    if (!canAttack) {
                                       return false;
                                    }
                                 }

                                 return true;
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        }
                     }
                  } else {
                     return false;
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
