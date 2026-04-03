package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CursedTechniquePotionExpiresProcedure {
   public CursedTechniquePotionExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack item_a = ItemStack.EMPTY;
         double num1 = 0.0;
         double skill = 0.0;
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }

         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 0.0 && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity3 = (LivingEntity)entity;
               if (_livingEntity3.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity3.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-49.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity4.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            AnimationResetProcedure.execute(entity);
         }

         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
         }

         if (entity instanceof Player) {
            if (entity.getPersistentData().getBoolean("attack") && pVars != null) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               item_a = var10000.copy();
               if (pVars.PlayerCursePowerFormer >= 100.0 && item_a.isEnchantable()) {
                  num1 = Math.sqrt(pVars.PlayerCursePowerFormer * pVars.PlayerLevel) * 0.1;
                  if (item_a.getOrCreateTag().getDouble("CursePower") >= 0.0 && item_a.getOrCreateTag().getDouble("CursePower") < num1) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     item_a = var10000;
                     item_a.getOrCreateTag().putDouble("CursePower", Math.min(item_a.getOrCreateTag().getDouble("CursePower") + num1 * 0.01 * Math.min(1.0 + (entity.getPersistentData().getDouble("cnt6") + 1.0) * 0.2, 2.2), num1));
                  }
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _livEnt14 = (LivingEntity)entity;
            if (_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()) && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_domain_amplification")))) {
               KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
            }
         }

         ResetCounterProcedure.execute(entity);
         entity.getPersistentData().putDouble("skill", 0.0);
         entity.getPersistentData().putBoolean("attack", false);
         ItemStack var37;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var37 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
         } else {
            var37 = ItemStack.EMPTY;
         }

         item_a = var37.copy();
         if (item_a.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_a.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
            if (entity instanceof Player) {
               Player _plrCldCheck21 = (Player)entity;
               if (_plrCldCheck21.getCooldowns().isOnCooldown(item_a.getItem())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt22 = (LivingEntity)entity;
               if (_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  if (entity instanceof Player) {
                     if (pVars.PlayerCurseTechnique != 16.0 && pVars.PlayerCurseTechnique2 != 16.0) {
                        return;
                     }
                  } else if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity)) {
                     return;
                  }

                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 / 2.0), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt26 = (LivingEntity)entityiterator;
                        if (_livEnt26.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           CompoundTag var38 = item_a.getOrCreateTag();
                           CompoundTag var10001 = entityiterator.getPersistentData();
                           if (var38.getDouble("domain" + Math.round(var10001.getDouble("skill_domain"))) >= 100.0) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
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
