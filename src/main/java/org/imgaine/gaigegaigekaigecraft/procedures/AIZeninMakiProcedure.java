package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ZeninMakiCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIZeninMakiProcedure {
   public AIZeninMakiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean awaked = false;
         double rnd = 0.0;
         double level_strength = 0.0;
         double level_resistance = 0.0;
         double level_physical_gifted = 0.0;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            awaked = entity instanceof ZeninMakiCullingGameEntity;
            if (awaked) {
               level_strength = 29.0;
               level_resistance = 3.0;
               level_physical_gifted = 4.0;
            } else {
               level_strength = 8.0;
               level_resistance = 2.0;
               level_physical_gifted = 0.0;
               if (!entity.getPersistentData().m_128471_("flag_start")) {
                  entity.getPersistentData().m_128379_("flag_start", true);
                  entity.getPersistentData().m_128379_("HasWeapon1", false);
                  entity.getPersistentData().m_128379_("HasWeapon2", true);
                  entity.getPersistentData().m_128379_("HasWeapon3", true);
               }
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19600_)) {
                     break label173;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)level_strength, false, false));
                  }
               }
            }

            label168: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_(MobEffects.f_19606_)) {
                     break label168;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)level_resistance, false, false));
                  }
               }
            }

            label163: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     break label163;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get(), 2147483647, (int)level_physical_gifted, false, false));
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
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
                  if (!awaked) {
                     boolean var55;
                     label153: {
                        var50 = entity.getPersistentData();
                        if (!entity.getPersistentData().m_128471_("HasWeapon1")) {
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.m_21205_();
                           } else {
                              var10002 = ItemStack.f_41583_;
                           }

                           if (var10002.m_41720_() != JujutsucraftModItems.NAGINATA.get()) {
                              var55 = false;
                              break label153;
                           }
                        }

                        var55 = true;
                     }

                     label147: {
                        var50.m_128379_("HasWeapon1", var55);
                        var51 = entity.getPersistentData();
                        if (!entity.getPersistentData().m_128471_("HasWeapon2")) {
                           ItemStack var56;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var56 = _livEnt.m_21205_();
                           } else {
                              var56 = ItemStack.f_41583_;
                           }

                           if (var56.m_41720_() != JujutsucraftModItems.SLAUGHTER_DEMON.get()) {
                              var55 = false;
                              break label147;
                           }
                        }

                        var55 = true;
                     }

                     label141: {
                        var51.m_128379_("HasWeapon2", var55);
                        var52 = entity.getPersistentData();
                        if (!entity.getPersistentData().m_128471_("HasWeapon3")) {
                           ItemStack var58;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var58 = _livEnt.m_21205_();
                           } else {
                              var58 = ItemStack.f_41583_;
                           }

                           if (var58.m_41720_() != JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                              var55 = false;
                              break label141;
                           }
                        }

                        var55 = true;
                     }

                     var52.m_128379_("HasWeapon3", var55);
                     float var53;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var53 = _livEnt.m_21223_();
                     } else {
                        var53 = -1.0F;
                     }

                     double var54 = (double)var53;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var54 <= (double)var10001 * 0.5) {
                        if (entity.getPersistentData().m_128471_("HasWeapon3")) {
                           entity.getPersistentData().m_128379_("HasWeapon3", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else if (entity.getPersistentData().m_128471_("HasWeapon1")) {
                           entity.getPersistentData().m_128379_("HasWeapon1", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else if (entity.getPersistentData().m_128471_("HasWeapon2")) {
                           entity.getPersistentData().m_128379_("HasWeapon2", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }
                     } else if (Math.random() > 0.5) {
                        for(int index0 = 0; index0 < 5; ++index0) {
                           rnd = (double)Math.round(Math.ceil(Math.random() * 2.0));
                           if (rnd == 1.0) {
                              if (entity.getPersistentData().m_128471_("HasWeapon1")) {
                                 entity.getPersistentData().m_128379_("HasWeapon1", false);
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).m_41777_();
                                    _setstack.m_41764_(1);
                                    _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                    if (_entity instanceof Player) {
                                       Player _player = (Player)_entity;
                                       _player.m_150109_().m_6596_();
                                    }
                                 }
                                 break;
                              }
                           } else if (rnd == 2.0 && entity.getPersistentData().m_128471_("HasWeapon2")) {
                              entity.getPersistentData().m_128379_("HasWeapon2", false);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                              break;
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
