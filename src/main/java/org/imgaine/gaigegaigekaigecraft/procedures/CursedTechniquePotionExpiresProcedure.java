package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
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
         ItemStack item_a = ItemStack.f_41583_;
         double num1 = 0.0;
         double skill = 0.0;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 0.0 && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity2 = (LivingEntity)entity;
               if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity2.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-49.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity3 = (LivingEntity)entity;
               if (_livingEntity3.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity3.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(1.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            AnimationResetProcedure.execute(entity);
         }

         if (entity instanceof Player) {
            if (entity.getPersistentData().m_128471_("attack") && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer >= 100.0) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41792_()) {
                  num1 = Math.sqrt(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer * ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerLevel) * 0.1;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128459_("CursePower") >= 0.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41784_().m_128459_("CursePower") < num1) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        CompoundTag var40 = var10000.m_41784_();
                        ItemStack var10002;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21205_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        var40.m_128347_("CursePower", Math.min(var10002.m_41784_().m_128459_("CursePower") + num1 * 0.01 * Math.min(1.0 + (entity.getPersistentData().m_128459_("cnt6") + 1.0) * 0.2, 2.2), num1));
                     }
                  }
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _livEnt17 = (LivingEntity)entity;
            if (_livEnt17.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()) && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
               KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
            }
         }

         entity.getPersistentData().m_128379_("attack", false);
         entity.getPersistentData().m_128347_("skill", 0.0);
         ItemStack var41;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var41 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var41 = ItemStack.f_41583_;
         }

         if (var41.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var41 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var41 = ItemStack.f_41583_;
            }

            if (var41.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
               return;
            }
         }

         if (entity instanceof Player) {
            Player _plrCldCheck26 = (Player)entity;
            ItemCooldowns var43 = _plrCldCheck26.m_36335_();
            ItemStack var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10001 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10001 = ItemStack.f_41583_;
            }

            if (var43.m_41519_(var10001.m_41720_())) {
               return;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt27 = (LivingEntity)entity;
            if (_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                     return;
                  }
               } else if (!(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
                  return;
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt31 = (LivingEntity)entityiterator;
                     if (_livEnt31.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var41 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var41 = ItemStack.f_41583_;
                        }

                        CompoundTag var45 = var41.m_41784_();
                        CompoundTag var46 = entityiterator.getPersistentData();
                        if (var45.m_128459_("domain" + Math.round(var46.m_128459_("skill_domain"))) >= 100.0) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
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
