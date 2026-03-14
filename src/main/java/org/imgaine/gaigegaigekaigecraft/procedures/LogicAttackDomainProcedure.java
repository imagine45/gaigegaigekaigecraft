package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class LogicAttackDomainProcedure {
   public LogicAttackDomainProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         String STR1 = "";
         ItemStack ITM1 = ItemStack.f_41583_;
         double NUM1 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         boolean logic_attack = false;
         boolean old_domainAttack = false;
         logic_attack = true;
         if (entityiterator instanceof LivingEntity) {
            label170: {
               if (entityiterator instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer != 0.0) {
                     break label170;
                  }
               } else if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                  break label170;
               }

               int var10000;
               label160: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                        break label160;
                     }
                  }

                  var10000 = 0;
               }

               logic_attack = var10000 != 0;
            }

            if (logic_attack) {
               label179: {
                  label149: {
                     label148: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt4 = (LivingEntity)entityiterator;
                           if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              break label148;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") == 0.0) {
                           label143: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                                 if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) && LogicSimpleDomainProcedure.execute()) {
                                    int var26;
                                    label138: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                             var26 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                             break label138;
                                          }
                                       }

                                       var26 = 0;
                                    }

                                    if (var26 >= 0) {
                                       break label143;
                                    }
                                 }
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt8 = (LivingEntity)entityiterator;
                                 if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                    break label149;
                                 }
                              }
                           }
                        }
                     }

                     logic_attack = false;
                  }

                  if (entity.getPersistentData().m_128471_("Failed") || entity.getPersistentData().m_128471_("Cover")) {
                     logic_attack = false;
                  }

                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && (entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged") || entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged"))) {
                     logic_attack = false;
                  }

                  if (entity.getPersistentData().m_128459_("NameRanged") != 0.0 && (entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged") || entity.getPersistentData().m_128459_("NameRanged") == entityiterator.getPersistentData().m_128459_("NameRanged_ranged"))) {
                     logic_attack = false;
                  }

                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                     logic_attack = false;
                  }

                  if (entity.getPersistentData().m_128471_("onlyLiving") && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                     logic_attack = false;
                  }

                  label108: {
                     if (entityiterator instanceof Player) {
                        Player _plr = (Player)entityiterator;
                        if (_plr.m_150110_().f_35937_) {
                           break label108;
                        }
                     }

                     if (!((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entityiterator) && !(entityiterator instanceof DomainExpansionEntityEntity)) {
                        break label179;
                     }
                  }

                  logic_attack = false;
               }
            }

            if (logic_attack) {
               ItemStack var27;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                  var27 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var27 = ItemStack.f_41583_;
               }

               ITM1 = var27;
               if (ITM1.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || ITM1.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  label178: {
                     if (entityiterator instanceof Player) {
                        if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                           break label178;
                        }
                     } else if (!(entityiterator instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
                        break label178;
                     }

                     CompoundTag var28 = ITM1.m_41784_();
                     CompoundTag var10001 = entity.getPersistentData();
                     if (var28.m_128459_("domain" + Math.round(var10001.m_128459_("skill_domain"))) >= 100.0) {
                        logic_attack = false;
                     }
                  }
               }
            }

            if (logic_attack && entity instanceof OkkotsuYutaCullingGameEntity) {
               old_domainAttack = entity.getPersistentData().m_128471_("DomainAttack");
               entity.getPersistentData().m_128379_("DomainAttack", false);
               if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  logic_attack = false;
               }

               entity.getPersistentData().m_128379_("DomainAttack", old_domainAttack);
            }
         }

         return logic_attack;
      } else {
         return false;
      }
   }
}
