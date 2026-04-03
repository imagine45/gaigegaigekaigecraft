package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class ChangeTechniqueTestProcedure {
   public ChangeTechniqueTestProcedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity == null) {
         return false;
      } else {
         boolean isCreative = false;
         boolean reChange = false;
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         if (!(entity instanceof ServerPlayer)) {
            return false;
         } else if (playerSelect >= 0.0 && playerSelect <= 2.0) {
            return false;
         } else {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _servPlayer = (ServerPlayer)entity;
               isCreative = _servPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
            }

            if (!isCreative) {
               if (playerSelect == 20.0) {
                  label900: {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr1 = (ServerPlayer)entity;
                        if (_plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_expansion"))).isDone()) {
                           break label900;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt2 = (LivingEntity)entity;
                        if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label900;
                        }
                     }

                     reChange = true;
                  }
               }

               if (playerCT < 10.0) {
                  if (playerCT == 1.0) {
                     label826: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt3 = (LivingEntity)entity;
                           if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label826;
                           }
                        }

                        if (playerSelect == 7.0) {
                           label821: {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr4 = (ServerPlayer)entity;
                                 if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_open"))).isDone()) {
                                    break label821;
                                 }
                              }

                              reChange = true;
                           }
                        }
                     }
                  } else if (playerCT == 2.0) {
                     label815: {
                        label850: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label850;
                              }

                              ServerPlayer _plr5 = (ServerPlayer)entity;
                              if (!(_plr5.level() instanceof ServerLevel) || !_plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_infinity"))).isDone()) {
                                 break label850;
                              }
                           }

                           if (playerSelect == 7.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label850;
                              }

                              ServerPlayer _plr6 = (ServerPlayer)entity;
                              if (!(_plr6.level() instanceof ServerLevel) || !_plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_cursed_technique_reversal_red"))).isDone()) {
                                 break label850;
                              }
                           }

                           if (playerSelect != 15.0) {
                              break label815;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr7 = (ServerPlayer)entity;
                              if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_hollow_technique_purple"))).isDone()) {
                                 break label815;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 4.0) {
                     label791: {
                        label853: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label853;
                              }

                              ServerPlayer _plr8 = (ServerPlayer)entity;
                              if (!(_plr8.level() instanceof ServerLevel) || !_plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_disaster_flames"))).isDone()) {
                                 break label853;
                              }
                           }

                           if (playerSelect == 8.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label853;
                              }

                              ServerPlayer _plr9 = (ServerPlayer)entity;
                              if (!(_plr9.level() instanceof ServerLevel) || !_plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_flame_laser"))).isDone()) {
                                 break label853;
                              }
                           }

                           if (playerSelect == 9.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label853;
                              }

                              ServerPlayer _plr10 = (ServerPlayer)entity;
                              if (!(_plr10.level() instanceof ServerLevel) || !_plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_lava_waves"))).isDone()) {
                                 break label853;
                              }
                           }

                           if (playerSelect != 15.0) {
                              break label791;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr11 = (ServerPlayer)entity;
                              if (_plr11.level() instanceof ServerLevel && _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_maximum_meteor"))).isDone()) {
                                 break label791;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 5.0) {
                     label758: {
                        label858: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label858;
                              }

                              ServerPlayer _plr12 = (ServerPlayer)entity;
                              if (!(_plr12.level() instanceof ServerLevel) || !_plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_cursed_speech"))).isDone()) {
                                 break label858;
                              }

                              if (entity instanceof Player) {
                                 Player _playerHasItem = (Player)entity;
                                 if (_playerHasItem.getInventory().contains(new ItemStack((ItemLike)JujutsucraftModItems.LOUDSPEAKER.get()))) {
                                    break label858;
                                 }
                              }
                           }

                           label860: {
                              if (playerSelect == 6.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label860;
                                 }

                                 ServerPlayer _plr14 = (ServerPlayer)entity;
                                 if (!(_plr14.level() instanceof ServerLevel) || !_plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_dhruv_lakdawalla"))).isDone()) {
                                    break label860;
                                 }
                              }

                              if (playerSelect != 7.0) {
                                 break label758;
                              }

                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr15 = (ServerPlayer)entity;
                                 if (_plr15.level() instanceof ServerLevel && _plr15.getAdvancements().getOrStartProgress(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_takako_uro"))).isDone()) {
                                    break label758;
                                 }
                              }

                              reChange = true;
                              break label758;
                           }

                           reChange = true;
                           break label758;
                        }

                        reChange = true;
                     }

                     if (playerSelect == 15.0 || playerSelect == 19.0) {
                        label905: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr16 = (ServerPlayer)entity;
                              if (_plr16.level() instanceof ServerLevel && _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_rika_control"))).isDone()) {
                                 break label905;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 6.0) {
                     if (playerSelect >= 5.0 && playerSelect < 20.0) {
                        if (entity.getPersistentData().getDouble("TenShadowsTechnique" + Math.round(playerSelect - 4.0)) < 0.0) {
                           reChange = true;
                        }

                        if (playerSelect != 5.0 && playerSelect != 6.0) {
                           if (playerSelect == 7.0 && (entity.getPersistentData().getDouble("TenShadowsTechnique1") != -2.0 || !(entity.getPersistentData().getDouble("TenShadowsTechnique2") >= 0.0)) && (!(entity.getPersistentData().getDouble("TenShadowsTechnique1") >= 0.0) || entity.getPersistentData().getDouble("TenShadowsTechnique2") != -2.0)) {
                              reChange = true;
                           }
                        } else if (entity.getPersistentData().getDouble("TenShadowsTechnique3") < 0.0) {
                           reChange = true;
                        }

                        if (playerSelect != 8.0 && playerSelect != 9.0 && playerSelect != 13.0 && playerSelect != 15.0) {
                           if (playerSelect == 17.0) {
                              label696: {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr24 = (ServerPlayer)entity;
                                    if (_plr24.level() instanceof ServerLevel && _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_nue"))).isDone() && entity.getPersistentData().getDouble("TenShadowsTechnique4") >= 0.0 && entity.getPersistentData().getDouble("TenShadowsTechnique5") <= -2.0 && entity.getPersistentData().getDouble("TenShadowsTechnique9") <= -2.0 && entity.getPersistentData().getDouble("TenShadowsTechnique11") <= -2.0) {
                                       break label696;
                                    }
                                 }

                                 reChange = true;
                              }
                           }
                        } else if (entity.getPersistentData().getDouble("TenShadowsTechnique13") < 0.0) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 7.0) {
                     if (playerSelect == 10.0 && entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 8.0) {
                     label685: {
                        label864: {
                           if (playerSelect == 9.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label864;
                              }

                              ServerPlayer _plr30 = (ServerPlayer)entity;
                              if (!(_plr30.level() instanceof ServerLevel) || !_plr30.getAdvancements().getOrStartProgress(_plr30.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_death_swarm"))).isDone()) {
                                 break label864;
                              }
                           }

                           if (playerSelect != 10.0) {
                              break label685;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr31 = (ServerPlayer)entity;
                              if (_plr31.level() instanceof ServerLevel && _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_bathynomus_giganteus"))).isDone()) {
                                 break label685;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 9.0) {
                     label669: {
                        label866: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label866;
                              }

                              ServerPlayer _plr32 = (ServerPlayer)entity;
                              if (!(_plr32.level() instanceof ServerLevel) || !_plr32.getAdvancements().getOrStartProgress(_plr32.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_garuda_soccer"))).isDone()) {
                                 break label866;
                              }
                           }

                           if (playerSelect != 6.0) {
                              break label669;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr33 = (ServerPlayer)entity;
                              if (_plr33.level() instanceof ServerLevel && _plr33.getAdvancements().getOrStartProgress(_plr33.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_garuda"))).isDone()) {
                                 break label669;
                              }
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < 20.0) {
                  if (playerCT == 10.0) {
                     label437: {
                        label868: {
                           if (playerSelect == 6.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label868;
                              }

                              ServerPlayer _plr34 = (ServerPlayer)entity;
                              if (!(_plr34.level() instanceof ServerLevel) || !_plr34.getAdvancements().getOrStartProgress(_plr34.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_convergence"))).isDone()) {
                                 break label868;
                              }
                           }

                           label870: {
                              if (playerSelect == 7.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label870;
                                 }

                                 ServerPlayer _plr35 = (ServerPlayer)entity;
                                 if (!(_plr35.level() instanceof ServerLevel) || !_plr35.getAdvancements().getOrStartProgress(_plr35.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_piercing_blood"))).isDone()) {
                                    break label870;
                                 }
                              }

                              label872: {
                                 if (playerSelect == 8.0) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label872;
                                    }

                                    ServerPlayer _plr36 = (ServerPlayer)entity;
                                    if (!(_plr36.level() instanceof ServerLevel) || !_plr36.getAdvancements().getOrStartProgress(_plr36.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_supernova"))).isDone()) {
                                       break label872;
                                    }
                                 }

                                 label874: {
                                    if (playerSelect == 9.0) {
                                       if (!(entity instanceof ServerPlayer)) {
                                          break label874;
                                       }

                                       ServerPlayer _plr37 = (ServerPlayer)entity;
                                       if (!(_plr37.level() instanceof ServerLevel) || !_plr37.getAdvancements().getOrStartProgress(_plr37.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_flowing_red_scale"))).isDone()) {
                                          break label874;
                                       }
                                    }

                                    label876: {
                                       if (playerSelect == 16.0) {
                                          if (!(entity instanceof ServerPlayer)) {
                                             break label876;
                                          }

                                          ServerPlayer _plr38 = (ServerPlayer)entity;
                                          if (!(_plr38.level() instanceof ServerLevel) || !_plr38.getAdvancements().getOrStartProgress(_plr38.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_blood_wave"))).isDone()) {
                                             break label876;
                                          }
                                       }

                                       if (playerSelect != 18.0) {
                                          break label437;
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr39 = (ServerPlayer)entity;
                                          if (_plr39.level() instanceof ServerLevel && _plr39.getAdvancements().getOrStartProgress(_plr39.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_eso"))).isDone()) {
                                             break label437;
                                          }
                                       }

                                       reChange = true;
                                       break label437;
                                    }

                                    reChange = true;
                                    break label437;
                                 }

                                 reChange = true;
                                 break label437;
                              }

                              reChange = true;
                              break label437;
                           }

                           reChange = true;
                           break label437;
                        }

                        reChange = true;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt40 = (LivingEntity)entity;
                        if (_livEnt40.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()) && playerSelect != 9.0 && playerSelect >= 5.0 && playerSelect < 20.0) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 11.0) {
                     if (playerSelect == 5.0) {
                        label650: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr41 = (ServerPlayer)entity;
                              if (_plr41.level() instanceof ServerLevel && _plr41.getAdvancements().getOrStartProgress(_plr41.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_bird_strike"))).isDone()) {
                                 break label650;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 13.0) {
                     if (playerSelect == 10.0) {
                        label643: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr42 = (ServerPlayer)entity;
                              if (_plr42.level() instanceof ServerLevel && _plr42.getAdvancements().getOrStartProgress(_plr42.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_collapse"))).isDone()) {
                                 break label643;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 14.0) {
                     if (playerSelect == 10.0) {
                        label636: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr43 = (ServerPlayer)entity;
                              if (_plr43.level() instanceof ServerLevel && _plr43.getAdvancements().getOrStartProgress(_plr43.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_huge_roots"))).isDone()) {
                                 break label636;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 15.0) {
                     label878: {
                        label629: {
                           label911: {
                              if (playerSelect == 8.0 || playerSelect == 9.0 || playerSelect == 10.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label911;
                                 }

                                 ServerPlayer _plr44 = (ServerPlayer)entity;
                                 if (!(_plr44.level() instanceof ServerLevel) || !_plr44.getAdvancements().getOrStartProgress(_plr44.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_soul_multiplicity"))).isDone()) {
                                    break label911;
                                 }
                              }

                              label881: {
                                 if (playerSelect == 10.0) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label881;
                                    }

                                    ServerPlayer _plr45 = (ServerPlayer)entity;
                                    if (!(_plr45.level() instanceof ServerLevel) || !_plr45.getAdvancements().getOrStartProgress(_plr45.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_polymorphic_soul_isomer"))).isDone()) {
                                       break label881;
                                    }
                                 }

                                 if (playerSelect != 15.0) {
                                    break label629;
                                 }

                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr46 = (ServerPlayer)entity;
                                    if (_plr46.level() instanceof ServerLevel && _plr46.getAdvancements().getOrStartProgress(_plr46.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_instant_spirit_bodyof_distorted_killing"))).isDone()) {
                                       break label629;
                                    }
                                 }

                                 reChange = true;
                                 break label629;
                              }

                              reChange = true;
                              break label629;
                           }

                           reChange = true;
                        }

                        label883: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt47 = (LivingEntity)entity;
                              if (_livEnt47.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                 if (!(playerSelect >= 6.0) || !(playerSelect <= 15.0)) {
                                    break label878;
                                 }
                                 break label883;
                              }
                           }

                           if ((!(playerSelect >= 3.0) || !(playerSelect <= 4.0)) && (!(playerSelect >= 16.0) || !(playerSelect <= 19.0))) {
                              break label878;
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 17.0) {
                     if (playerSelect == 10.0) {
                        label901: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt48 = (LivingEntity)entity;
                              if (_livEnt48.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                 break label901;
                              }
                           }

                           reChange = true;
                        }
                     }

                     if (playerSelect == 15.0 && entity instanceof LivingEntity) {
                        LivingEntity _livEnt49 = (LivingEntity)entity;
                        if (_livEnt49.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 18.0) {
                     label581: {
                        label580: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label580;
                              }

                              ServerPlayer _plr50 = (ServerPlayer)entity;
                              if (!(_plr50.level() instanceof ServerLevel) || !_plr50.getAdvancements().getOrStartProgress(_plr50.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"))).isDone()) {
                                 break label580;
                              }
                           }

                           if (playerSelect == 15.0) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr51 = (ServerPlayer)entity;
                                 if (_plr51.level() instanceof ServerLevel && _plr51.getAdvancements().getOrStartProgress(_plr51.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_maximum_uzumaki"))).isDone()) {
                                    break label581;
                                 }
                              }

                              reChange = true;
                           }
                           break label581;
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 19.0 && playerSelect == 10.0) {
                     label563: {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr52 = (ServerPlayer)entity;
                           if (_plr52.level() instanceof ServerLevel && _plr52.getAdvancements().getOrStartProgress(_plr52.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_explodethe_air"))).isDone()) {
                              break label563;
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < 30.0) {
                  if (playerCT == 20.0) {
                     if (playerSelect == 15.0 && entity instanceof LivingEntity) {
                        LivingEntity _livEnt53 = (LivingEntity)entity;
                        if (_livEnt53.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 21.0) {
                     label555: {
                        label886: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label886;
                              }

                              ServerPlayer _plr54 = (ServerPlayer)entity;
                              if (!(_plr54.level() instanceof ServerLevel) || !_plr54.getAdvancements().getOrStartProgress(_plr54.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_divergent_fist"))).isDone()) {
                                 break label886;
                              }
                           }

                           label888: {
                              if (playerSelect == 8.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label888;
                                 }

                                 ServerPlayer _plr55 = (ServerPlayer)entity;
                                 if (!(_plr55.level() instanceof ServerLevel) || !_plr55.getAdvancements().getOrStartProgress(_plr55.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_dismantle_itadori"))).isDone()) {
                                    break label888;
                                 }
                              }

                              label890: {
                                 if (playerSelect == 13.0) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label890;
                                    }

                                    ServerPlayer _plr56 = (ServerPlayer)entity;
                                    if (!(_plr56.level() instanceof ServerLevel) || !_plr56.getAdvancements().getOrStartProgress(_plr56.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_piercing_blood_itadori"))).isDone() || ReturnInsideItemProcedure.execute(entity).getItem() != JujutsucraftModItems.DEATH_PAINTING.get()) {
                                       break label890;
                                    }
                                 }

                                 label522: {
                                    if (playerSelect == 14.0) {
                                       if (!(entity instanceof ServerPlayer)) {
                                          break label522;
                                       }

                                       ServerPlayer _plr58 = (ServerPlayer)entity;
                                       if (!(_plr58.level() instanceof ServerLevel) || !_plr58.getAdvancements().getOrStartProgress(_plr58.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_supernova_itadori"))).isDone() || ReturnInsideItemProcedure.execute(entity).getItem() != JujutsucraftModItems.DEATH_PAINTING.get()) {
                                          break label522;
                                       }
                                    }

                                    if (playerSelect == 18.0) {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr60 = (ServerPlayer)entity;
                                          if (_plr60.level() instanceof ServerLevel && _plr60.getAdvancements().getOrStartProgress(_plr60.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_deep_concentration"))).isDone()) {
                                             break label555;
                                          }
                                       }

                                       reChange = true;
                                    }
                                    break label555;
                                 }

                                 reChange = true;
                                 break label555;
                              }

                              reChange = true;
                              break label555;
                           }

                           reChange = true;
                           break label555;
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 24.0) {
                     label504: {
                        label503: {
                           if (playerSelect == 8.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label503;
                              }

                              ServerPlayer _plr61 = (ServerPlayer)entity;
                              if (!(_plr61.level() instanceof ServerLevel) || !_plr61.getAdvancements().getOrStartProgress(_plr61.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_frost_calm"))).isDone()) {
                                 break label503;
                              }
                           }

                           if (playerSelect == 9.0) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr62 = (ServerPlayer)entity;
                                 if (_plr62.level() instanceof ServerLevel && _plr62.getAdvancements().getOrStartProgress(_plr62.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_icefall"))).isDone()) {
                                    break label504;
                                 }
                              }

                              reChange = true;
                           }
                           break label504;
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < 40.0) {
                  if (playerCT == 30.0) {
                     if (playerSelect == 5.0 && entity instanceof LivingEntity) {
                        LivingEntity _livEnt63 = (LivingEntity)entity;
                        if (_livEnt63.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 39.0 && (playerSelect == 5.0 || playerSelect == 6.0 || playerSelect == 7.0)) {
                     label909: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt64 = (LivingEntity)entity;
                           if (_livEnt64.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                              break label909;
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < 50.0) {
                  if (playerCT == 40.0) {
                     label474: {
                        if (playerSelect == 6.0 && entity instanceof LivingEntity) {
                           LivingEntity _livEnt65 = (LivingEntity)entity;
                           if (_livEnt65.hasEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get())) {
                              reChange = true;
                              break label474;
                           }
                        }

                        if (playerSelect == 7.0 && entity instanceof LivingEntity) {
                           LivingEntity _livEnt66 = (LivingEntity)entity;
                           if (_livEnt66.hasEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                              reChange = true;
                           }
                        }
                     }
                  } else if (playerCT == 41.0) {
                     if (playerSelect == 10.0) {
                        label467: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr67 = (ServerPlayer)entity;
                              if (_plr67.level() instanceof ServerLevel && _plr67.getAdvancements().getOrStartProgress(_plr67.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"))).isDone()) {
                                 break label467;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 43.0 && playerSelect == 7.0) {
                     label460: {
                        label459: {
                           label895: {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr68 = (ServerPlayer)entity;
                                 if (_plr68.level() instanceof ServerLevel && _plr68.getAdvancements().getOrStartProgress(_plr68.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_megumi_fushiguro"))).isDone()) {
                                    break label895;
                                 }
                              }

                              if (!(entity instanceof ServerPlayer)) {
                                 break label459;
                              }

                              ServerPlayer _plr69 = (ServerPlayer)entity;
                              if (!(_plr69.level() instanceof ServerLevel) || !_plr69.getAdvancements().getOrStartProgress(_plr69.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:battle_megumi_fushiguro_shibuya"))).isDone()) {
                                 break label459;
                              }
                           }

                           if (!(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("SHIKIGAMI_ROZETSU_UUID")) instanceof LivingEntity)) {
                              break label460;
                           }
                        }

                        reChange = true;
                     }
                  }
               }
            }

            reChange = reChange || ChangeTechniqueTest2Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
            return reChange;
         }
      }
   }
}
