package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

public class CursedToolsAbilityProcedure {
   public CursedToolsAbilityProcedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double NUM1 = 0.0;
         boolean logic_a = false;
         boolean mahorage = false;
         String STR1 = "";
         Entity entity_a = null;
         if (entityiterator instanceof LivingEntity) {
            if (entity.getPersistentData().m_128471_("attack")) {
               label296: {
                  if (entity instanceof Player) {
                     Player _plrCldCheck3 = (Player)entity;
                     ItemCooldowns var10000 = _plrCldCheck3.m_36335_();
                     ItemStack var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41519_(var10001.m_41720_())) {
                        break label296;
                     }
                  }

                  ItemStack var45;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var45 = _livEnt.m_21205_();
                  } else {
                     var45 = ItemStack.f_41583_;
                  }

                  if (var45.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                     label297: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var45 = _livEnt.m_21205_();
                        } else {
                           var45 = ItemStack.f_41583_;
                        }

                        if (var45.m_41720_() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var45 = _livEnt.m_21205_();
                           } else {
                              var45 = ItemStack.f_41583_;
                           }

                           if (var45.m_41720_() != JujutsucraftModItems.BLACK_ROPE.get()) {
                              break label297;
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 1, 0));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }

                        if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var63;
                              MobEffect var10003;
                              int var10005;
                              label269: {
                                 var63 = new MobEffectInstance;
                                 var10003 = MobEffects.f_19613_;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label269;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var63.<init>(var10003, 10, var10005, false, false);
                              _entity.m_7292_(var63);
                           }
                        }
                     }
                  }
               }
            }

            if (entity instanceof Player && entity instanceof Player) {
               Player _plrCldCheck18 = (Player)entity;
               ItemCooldowns var48 = _plrCldCheck18.m_36335_();
               ItemStack var64;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var64 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var64 = ItemStack.f_41583_;
               }

               if (var48.m_41519_(var64.m_41720_())) {
                  return;
               }
            }

            ItemStack var49;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var49 = ItemStack.f_41583_;
            }

            if (var49.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var49 = ItemStack.f_41583_;
               }

               if (var49.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  return;
               }
            }

            mahorage = entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 16.0 : entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity || entity instanceof CursedSpiritGrade010Entity;
            NUM1 = 0.0;
            STR1 = "";
            if (NUM1 == 0.0 && entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt26 = (LivingEntity)entityiterator;
               if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && entity.getPersistentData().m_128471_("attack")) {
                  STR1 = "skill205";
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var49 = ItemStack.f_41583_;
                  }

                  if (var49.m_41784_().m_128459_(STR1) == 0.0) {
                     NUM1 = 1.0;
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var49 = ItemStack.f_41583_;
                     }

                     if (var49.m_41784_().m_128459_(STR1) >= 100.0 && mahorage) {
                        STR1 = "";
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 1, 1));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }
                     }
                  }
               }
            }

            if (NUM1 == 0.0 && STR1.equals("") && mahorage) {
               STR1 = "toLiving";
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var49 = ItemStack.f_41583_;
               }

               if (var49.m_41784_().m_128459_(STR1) == 0.0) {
                  NUM1 = 1.0;
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var49 = ItemStack.f_41583_;
                  }

                  if (var49.m_41784_().m_128459_(STR1) >= 100.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var49 = ItemStack.f_41583_;
                     }

                     NUM1 = (double)Math.round(Math.floor(var49.m_41784_().m_128459_(STR1) / 100.0) * 2.5);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var49 = _livEnt.m_21205_();
                     } else {
                        var49 = ItemStack.f_41583_;
                     }

                     if (var49.m_41792_()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var49 = _livEnt.m_21205_();
                        } else {
                           var49 = ItemStack.f_41583_;
                        }

                        double var65;
                        label292: {
                           var58 = var49.m_41784_();
                           if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                              ItemStack var10002;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10002 = _livEnt.m_21205_();
                              } else {
                                 var10002 = ItemStack.f_41583_;
                              }

                              if (var10002.m_41720_() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get()) {
                                 double var66 = NUM1 * -1.0;
                                 ItemStack var68;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var68 = _livEnt.m_21205_();
                                 } else {
                                    var68 = ItemStack.f_41583_;
                                 }

                                 var65 = Math.min(var66, var68.m_41784_().m_128459_("CursePower"));
                                 break label292;
                              }
                           }

                           ItemStack var67;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var67 = _livEnt.m_21205_();
                           } else {
                              var67 = ItemStack.f_41583_;
                           }

                           var65 = Math.max(NUM1, var67.m_41784_().m_128459_("CursePower"));
                        }

                        var58.m_128347_("CursePower", var65);
                     }

                     NUM1 = 0.0;
                  }
               }
            }

            if (NUM1 > 0.0) {
               int index0 = 0;

               label294: {
                  while(true) {
                     if (index0 >= 800) {
                        break label294;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var49 = ItemStack.f_41583_;
                     }

                     if (var49.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals("")) {
                        break;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var49 = ItemStack.f_41583_;
                     }

                     if (var49.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals(STR1)) {
                        break;
                     }

                     ++NUM1;
                     ++index0;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var49 = ItemStack.f_41583_;
                  }

                  var49.m_41784_().m_128359_("DATA" + Math.round(NUM1), STR1);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var49 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var49 = ItemStack.f_41583_;
                  }

                  var49.m_41784_().m_128347_(STR1, 1.0);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.adaptation_start").getString()), false);
                  }
               }
            }
         }

      }
   }
}
