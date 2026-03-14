package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class StartCursedTechniqueProcedure {
   public StartCursedTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         boolean logic_a = false;
         boolean CREATIVE = false;
         boolean item_use = false;
         boolean noUseCursePower = false;
         ItemStack item_a = ItemStack.f_41583_;
         double Level = 0.0;
         double Tick = 0.0;
         double NUM1 = 0.0;
         double skill = 0.0;
         double T1 = 0.0;
         double S1 = 0.0;
         double cost = 0.0;
         double T2 = 0.0;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41784_().m_128441_("used_item")) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41784_().m_128471_("used_item")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128379_("used_item", false);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               item_a = var10000.m_41777_();
               item_use = true;
            }
         }

         if (item_use) {
            STR1 = item_a.m_41611_().getString();
            skill = item_a.m_41784_().m_128459_("skill");
            cost = item_a.m_41784_().m_128459_("COOLDOWN_TICKS");
            if (item_a.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
               noUseCursePower = true;
            }
         } else {
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         label359: {
            if (item_use) {
               label370: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label359;
                     }
                  }

                  label371: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt12 = (LivingEntity)entity;
                        if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           break label371;
                        }
                     }

                     if (!(entity instanceof LivingEntity)) {
                        break label370;
                     }

                     LivingEntity _livEnt13 = (LivingEntity)entity;
                     if (!_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label370;
                     }
                  }

                  if (!noUseCursePower) {
                     break label359;
                  }
               }
            } else if (!LogicStartProcedure.execute(entity)) {
               break label359;
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
            })).checkGamemode(entity)) {
               CREATIVE = ((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                     } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                        return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entity);
               if (noUseCursePower) {
                  NUM1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 0.0;
               } else {
                  NUM1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - (item_use ? cost : ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
               }

               if (!(NUM1 >= 0.0) && !CREATIVE) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), true);
                     }

                     return;
                  }

                  return;
               } else {
                  if (!CREATIVE) {
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePower = NUM1;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (item_use) {
                     T1 = (double)Math.round(Math.floor(skill / 100.0));
                     S1 = (double)Math.round(Math.floor(skill % 100.0));
                  } else {
                     STR1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                     T1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 : ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                     S1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
                  }

                  entity.getPersistentData().m_128347_("skill", item_use ? skill : T1 * 100.0 + S1);
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity = (LivingEntity)entity;
                     _livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                  }

                  if ((T1 != 2.0 || S1 != 5.0) && (T1 != 9.0 || S1 != 10.0) && (T1 != 18.0 || !(S1 >= 10.0) || !(S1 < 15.0)) && !CREATIVE) {
                     if (S1 == 20.0) {
                        Tick = 20.0;
                     } else {
                        Tick = Math.max((item_use ? cost : ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCostOrgin) / 2.0, 20.0);
                        if (STR1.equals(Component.m_237115_("jujutsu.technique.attack1").getString())) {
                           Tick = 5.0;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack2").getString())) {
                           Tick = 15.0;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack3").getString())) {
                           Tick = 20.0;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack4").getString())) {
                           Tick = 100.0;
                        } else if (STR1.equals(Component.m_237115_("jujutsu.technique.attack5").getString())) {
                           Tick = 200.0;
                        } else if (!STR1.equals(Component.m_237115_("jujutsu.technique.attack6").getString()) && !STR1.equals(Component.m_237115_("jujutsu.technique.flying_kick").getString())) {
                           if (STR1.equals(Component.m_237115_("jujutsu.technique.attack7").getString())) {
                              Tick = 100.0;
                           }
                        } else {
                           Tick = 100.0;
                        }

                        if (T1 == 5.0 && S1 == 5.0) {
                           Tick = 20.0;
                        }

                        if (T1 == 6.0 && S1 >= 5.0 && S1 < 20.0 && !STR1.equals(Component.m_237115_("jujutsu.technique.choso3").getString())) {
                           Tick = 5.0;
                        }

                        if (T1 == 7.0 && (S1 == 5.0 || S1 == 10.0)) {
                           Tick = 20.0;
                        }

                        if (T1 == 19.0 && S1 < 5.0 && LogicStartPassiveProcedure.execute(entity)) {
                           Tick = 5.0;
                        }

                        if (T1 == 39.0 && S1 >= 8.0) {
                           Tick = 20.0;
                        }

                        if (T1 == 40.0 && (S1 == 6.0 || S1 == 7.0)) {
                           Tick = 20.0;
                        }
                     }
                  } else {
                     Tick = 1.0;
                  }

                  if (world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber + (double)Math.round(Tick);
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerTechniqueUsedNumber = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber > (double)((T1 != 27.0 && T2 != 27.0 ? 4000 : 2000) * (1 + world.m_6106_().m_5470_().m_46215_(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_simple_domain"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }

                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber > (double)((T1 != 27.0 && T2 != 27.0 ? 12000 : 100) * (1 + world.m_6106_().m_5470_().m_46215_(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128379_("Used", true);
                  }

                  if (!noUseCursePower) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PhysicalAttack && !item_use) {
                        if (S1 >= 0.0 && S1 <= 2.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              Tick *= 0.5;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity40 = (LivingEntity)entity;
                              if (_livingEntity40.m_21204_().m_22171_(Attributes.f_22283_)) {
                                 double var10003;
                                 label235: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity41 = (LivingEntity)entity;
                                       if (_livingEntity41.m_21204_().m_22171_(Attributes.f_22283_)) {
                                          var10003 = _livingEntity41.getAttribute_(Attributes.f_22283_).m_22135_();
                                          break label235;
                                       }
                                    }

                                    var10003 = 0.0;
                                 }

                                 Tick += 20.0 * Math.max(1.7 - var10003, 0.0);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(Tick), 1, false, false));
                              }

                              return;
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(Tick), 0, false, false));
                           }

                           return;
                        }

                        return;
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(Tick), 0, false, false));
                           }

                           return;
                        }

                        return;
                     }
                  } else {
                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", Math.max(entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), (double)Math.round(Tick)));
                     return;
                  }
               }
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), true);
            }
         }

      }
   }
}
