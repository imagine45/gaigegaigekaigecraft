package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIFushiguroTojiProcedure {
   public AIFushiguroTojiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack setItemA = ItemStack.f_41583_;
         boolean StrongEnemy = false;
         boolean awaked = false;
         double rnd = 0.0;
         double level_strength = 0.0;
         double level_resistance = 0.0;
         double level_physical_gifted = 0.0;
         if (entity.m_6084_()) {
            label222: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label222;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 29, false, false));
                  }
               }
            }

            label217: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label217;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                  }
               }
            }

            label212: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     break label212;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get(), 2147483647, 4, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 5.0);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
                  if (entity instanceof FushiguroTojiEntity) {
                     if (!entity.getPersistentData().m_128471_("Armoury")) {
                        entity.getPersistentData().m_128379_("Armoury", true);
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()));
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()));
                        }

                        entity.getPersistentData().m_128379_("HasWeapon1", true);
                        entity.getPersistentData().m_128379_("HasWeapon2", true);
                        entity.getPersistentData().m_128379_("HasWeapon3", true);
                     }

                     if (entity.getPersistentData().m_128459_("skill") != 0.0) {
                        ItemStack var47;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var47 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                        } else {
                           var47 = ItemStack.f_41583_;
                        }

                        if (var47.m_41720_() == JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()) {
                           boolean var58;
                           label198: {
                              var48 = entity.getPersistentData();
                              if (!entity.getPersistentData().m_128471_("HasWeapon1")) {
                                 ItemStack var10002;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10002 = _livEnt.m_21205_();
                                 } else {
                                    var10002 = ItemStack.f_41583_;
                                 }

                                 if (var10002.m_41720_() != JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                                    var58 = false;
                                    break label198;
                                 }
                              }

                              var58 = true;
                           }

                           label192: {
                              var48.m_128379_("HasWeapon1", var58);
                              var49 = entity.getPersistentData();
                              if (!entity.getPersistentData().m_128471_("HasWeapon2")) {
                                 ItemStack var59;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var59 = _livEnt.m_21205_();
                                 } else {
                                    var59 = ItemStack.f_41583_;
                                 }

                                 if (var59.m_41720_() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                                    var58 = false;
                                    break label192;
                                 }
                              }

                              var58 = true;
                           }

                           label186: {
                              var49.m_128379_("HasWeapon2", var58);
                              var50 = entity.getPersistentData();
                              if (!entity.getPersistentData().m_128471_("HasWeapon3")) {
                                 ItemStack var61;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var61 = _livEnt.m_21205_();
                                 } else {
                                    var61 = ItemStack.f_41583_;
                                 }

                                 if (var61.m_41720_() != JujutsucraftModItems.SPLIT_SOUL_KATANA.get()) {
                                    var58 = false;
                                    break label186;
                                 }
                              }

                              var58 = true;
                           }

                           var50.m_128379_("HasWeapon3", var58);
                           LivingEntity var51;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var51 = _mobEnt.m_5448_();
                           } else {
                              var51 = null;
                           }

                           label230: {
                              label231: {
                                 LivingEntity var25 = var51;
                                 if (var25 instanceof LivingEntity) {
                                    LivingEntity _livEnt37 = var25;
                                    if (_livEnt37.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       break label231;
                                    }
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var51 = _mobEnt.m_5448_();
                                 } else {
                                    var51 = null;
                                 }

                                 if (!(var51 instanceof GojoSatoruSchoolDaysEntity)) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var51 = _mobEnt.m_5448_();
                                    } else {
                                       var51 = null;
                                    }

                                    if (!(var51 instanceof GojoSatoruEntity)) {
                                       setItemA = ItemStack.f_41583_.m_41777_();
                                       int index0 = 0;

                                       while(true) {
                                          if (index0 >= 16) {
                                             break label230;
                                          }

                                          label166: {
                                             rnd = Math.ceil(Math.random() * 3.0);
                                             if (rnd == 1.0) {
                                                if (entity.getPersistentData().m_128471_("HasWeapon1")) {
                                                   entity.getPersistentData().m_128379_("HasWeapon1", false);
                                                   setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).m_41777_();
                                                }
                                             } else if (rnd == 2.0) {
                                                if (entity instanceof Mob) {
                                                   Mob _mobEnt = (Mob)entity;
                                                   var51 = _mobEnt.m_5448_();
                                                } else {
                                                   var51 = null;
                                                }

                                                if (((Entity)var51).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                                                   break label166;
                                                }

                                                if (entity instanceof Mob) {
                                                   Mob _mobEnt = (Mob)entity;
                                                   var51 = _mobEnt.m_5448_();
                                                } else {
                                                   var51 = null;
                                                }

                                                if (var51 instanceof Player) {
                                                   if (entity instanceof Mob) {
                                                      Mob _mobEnt = (Mob)entity;
                                                      var51 = _mobEnt.m_5448_();
                                                   } else {
                                                      var51 = null;
                                                   }

                                                   if (((JujutsucraftModVariables.PlayerVariables)((Entity)var51).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer < 100.0) {
                                                      break label166;
                                                   }
                                                }

                                                if (entity.getPersistentData().m_128471_("HasWeapon2")) {
                                                   entity.getPersistentData().m_128379_("HasWeapon2", false);
                                                   setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())).m_41777_();
                                                }
                                             } else if (rnd == 3.0 && entity.getPersistentData().m_128471_("HasWeapon3")) {
                                                entity.getPersistentData().m_128379_("HasWeapon3", false);
                                                setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.SPLIT_SOUL_KATANA.get())).m_41777_();
                                             }

                                             if (setItemA.m_41720_() != ItemStack.f_41583_.m_41720_()) {
                                                break label230;
                                             }
                                          }

                                          ++index0;
                                       }
                                    }
                                 }
                              }

                              ItemStack var57;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var57 = _livEnt.m_21205_();
                              } else {
                                 var57 = ItemStack.f_41583_;
                              }

                              if (var57.m_41720_() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() && entity.getPersistentData().m_128471_("HasWeapon2")) {
                                 entity.getPersistentData().m_128379_("HasWeapon2", false);
                              }

                              setItemA = (new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())).m_41777_();
                           }

                           if (setItemA.m_41720_() != ItemStack.f_41583_.m_41720_() && entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = setItemA.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
