package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class ChangeTechniqueTestProcedure {
   public ChangeTechniqueTestProcedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity == null) {
         return false;
      } else {
         boolean reChange = false;
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double cost = 0.0;
         double NUM3 = 0.0;
         reChange = false;
         if (playerSelect >= 0.0 && playerSelect <= 2.0) {
            return false;
         } else {
            if (!((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity)) {
               if (playerSelect == 20.0) {
                  label979: {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr1 = (ServerPlayer)entity;
                        if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).m_8193_()) {
                           break label979;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt2 = (LivingEntity)entity;
                        if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label979;
                        }
                     }

                     reChange = true;
                  }
               }

               if (playerCT < 10.0) {
                  if (playerCT == 1.0) {
                     label907: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt3 = (LivingEntity)entity;
                           if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label907;
                           }
                        }

                        if (playerSelect == 7.0) {
                           label902: {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr4 = (ServerPlayer)entity;
                                 if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_open"))).m_8193_()) {
                                    break label902;
                                 }
                              }

                              reChange = true;
                           }
                        }
                     }
                  } else if (playerCT == 2.0) {
                     label896: {
                        label928: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label928;
                              }

                              ServerPlayer _plr5 = (ServerPlayer)entity;
                              if (!(_plr5.m_9236_() instanceof ServerLevel) || !_plr5.m_8960_().m_135996_(_plr5.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_infinity"))).m_8193_()) {
                                 break label928;
                              }
                           }

                           if (playerSelect == 7.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label928;
                              }

                              ServerPlayer _plr6 = (ServerPlayer)entity;
                              if (!(_plr6.m_9236_() instanceof ServerLevel) || !_plr6.m_8960_().m_135996_(_plr6.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_cursed_technique_reversal_red"))).m_8193_()) {
                                 break label928;
                              }
                           }

                           if (playerSelect != 15.0) {
                              break label896;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr7 = (ServerPlayer)entity;
                              if (_plr7.m_9236_() instanceof ServerLevel && _plr7.m_8960_().m_135996_(_plr7.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_hollow_technique_purple"))).m_8193_()) {
                                 break label896;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 4.0) {
                     label872: {
                        label931: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label931;
                              }

                              ServerPlayer _plr8 = (ServerPlayer)entity;
                              if (!(_plr8.m_9236_() instanceof ServerLevel) || !_plr8.m_8960_().m_135996_(_plr8.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_disaster_flames"))).m_8193_()) {
                                 break label931;
                              }
                           }

                           if (playerSelect == 8.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label931;
                              }

                              ServerPlayer _plr9 = (ServerPlayer)entity;
                              if (!(_plr9.m_9236_() instanceof ServerLevel) || !_plr9.m_8960_().m_135996_(_plr9.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_flame_laser"))).m_8193_()) {
                                 break label931;
                              }
                           }

                           if (playerSelect == 9.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label931;
                              }

                              ServerPlayer _plr10 = (ServerPlayer)entity;
                              if (!(_plr10.m_9236_() instanceof ServerLevel) || !_plr10.m_8960_().m_135996_(_plr10.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_lava_waves"))).m_8193_()) {
                                 break label931;
                              }
                           }

                           if (playerSelect != 15.0) {
                              break label872;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr11 = (ServerPlayer)entity;
                              if (_plr11.m_9236_() instanceof ServerLevel && _plr11.m_8960_().m_135996_(_plr11.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_maximum_meteor"))).m_8193_()) {
                                 break label872;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 5.0) {
                     label839: {
                        label936: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label936;
                              }

                              ServerPlayer _plr12 = (ServerPlayer)entity;
                              if (!(_plr12.m_9236_() instanceof ServerLevel) || !_plr12.m_8960_().m_135996_(_plr12.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"))).m_8193_()) {
                                 break label936;
                              }

                              if (entity instanceof Player) {
                                 Player _playerHasItem = (Player)entity;
                                 if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)JujutsucraftModItems.LOUDSPEAKER.get()))) {
                                    break label936;
                                 }
                              }
                           }

                           label938: {
                              if (playerSelect == 6.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label938;
                                 }

                                 ServerPlayer _plr14 = (ServerPlayer)entity;
                                 if (!(_plr14.m_9236_() instanceof ServerLevel) || !_plr14.m_8960_().m_135996_(_plr14.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_dhruv_lakdawalla"))).m_8193_()) {
                                    break label938;
                                 }
                              }

                              if (playerSelect != 7.0) {
                                 break label839;
                              }

                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr15 = (ServerPlayer)entity;
                                 if (_plr15.m_9236_() instanceof ServerLevel && _plr15.m_8960_().m_135996_(_plr15.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"))).m_8193_()) {
                                    break label839;
                                 }
                              }

                              reChange = true;
                              break label839;
                           }

                           reChange = true;
                           break label839;
                        }

                        reChange = true;
                     }

                     if (playerSelect == 15.0 || playerSelect == 19.0) {
                        label986: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr16 = (ServerPlayer)entity;
                              if (_plr16.m_9236_() instanceof ServerLevel && _plr16.m_8960_().m_135996_(_plr16.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_rika_control"))).m_8193_()) {
                                 break label986;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 6.0) {
                     if (playerSelect >= 5.0 && playerSelect < 20.0) {
                        if (entity.getPersistentData().m_128459_("TenShadowsTechnique" + Math.round(playerSelect - 4.0)) < 0.0) {
                           reChange = true;
                        }

                        if (playerSelect != 5.0 && playerSelect != 6.0) {
                           if (playerSelect == 7.0 && (entity.getPersistentData().m_128459_("TenShadowsTechnique1") != -2.0 || !(entity.getPersistentData().m_128459_("TenShadowsTechnique2") >= 0.0)) && (!(entity.getPersistentData().m_128459_("TenShadowsTechnique1") >= 0.0) || entity.getPersistentData().m_128459_("TenShadowsTechnique2") != -2.0)) {
                              reChange = true;
                           }
                        } else if (entity.getPersistentData().m_128459_("TenShadowsTechnique3") < 0.0) {
                           reChange = true;
                        }

                        if (playerSelect != 8.0 && playerSelect != 9.0 && playerSelect != 13.0 && playerSelect != 15.0) {
                           if (playerSelect == 17.0) {
                              label777: {
                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr24 = (ServerPlayer)entity;
                                    if (_plr24.m_9236_() instanceof ServerLevel && _plr24.m_8960_().m_135996_(_plr24.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_nue"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique4") >= 0.0 && entity.getPersistentData().m_128459_("TenShadowsTechnique5") <= -2.0 && entity.getPersistentData().m_128459_("TenShadowsTechnique9") <= -2.0 && entity.getPersistentData().m_128459_("TenShadowsTechnique11") <= -2.0) {
                                       break label777;
                                    }
                                 }

                                 reChange = true;
                              }
                           }
                        } else if (entity.getPersistentData().m_128459_("TenShadowsTechnique13") < 0.0) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 7.0) {
                     if (playerSelect == 10.0 && entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 8.0) {
                     label766: {
                        label942: {
                           if (playerSelect == 9.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label942;
                              }

                              ServerPlayer _plr30 = (ServerPlayer)entity;
                              if (!(_plr30.m_9236_() instanceof ServerLevel) || !_plr30.m_8960_().m_135996_(_plr30.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_death_swarm"))).m_8193_()) {
                                 break label942;
                              }
                           }

                           if (playerSelect != 10.0) {
                              break label766;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr31 = (ServerPlayer)entity;
                              if (_plr31.m_9236_() instanceof ServerLevel && _plr31.m_8960_().m_135996_(_plr31.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_bathynomus_giganteus"))).m_8193_()) {
                                 break label766;
                              }
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 9.0) {
                     label750: {
                        label944: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label944;
                              }

                              ServerPlayer _plr32 = (ServerPlayer)entity;
                              if (!(_plr32.m_9236_() instanceof ServerLevel) || !_plr32.m_8960_().m_135996_(_plr32.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_garuda_soccer"))).m_8193_()) {
                                 break label944;
                              }
                           }

                           if (playerSelect != 6.0) {
                              break label750;
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr33 = (ServerPlayer)entity;
                              if (_plr33.m_9236_() instanceof ServerLevel && _plr33.m_8960_().m_135996_(_plr33.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_garuda"))).m_8193_()) {
                                 break label750;
                              }
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < 20.0) {
                  if (playerCT == 10.0) {
                     label483: {
                        label946: {
                           if (playerSelect == 6.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label946;
                              }

                              ServerPlayer _plr34 = (ServerPlayer)entity;
                              if (!(_plr34.m_9236_() instanceof ServerLevel) || !_plr34.m_8960_().m_135996_(_plr34.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_convergence"))).m_8193_()) {
                                 break label946;
                              }
                           }

                           label948: {
                              if (playerSelect == 7.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label948;
                                 }

                                 ServerPlayer _plr35 = (ServerPlayer)entity;
                                 if (!(_plr35.m_9236_() instanceof ServerLevel) || !_plr35.m_8960_().m_135996_(_plr35.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_piercing_blood"))).m_8193_()) {
                                    break label948;
                                 }
                              }

                              label950: {
                                 if (playerSelect == 8.0) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label950;
                                    }

                                    ServerPlayer _plr36 = (ServerPlayer)entity;
                                    if (!(_plr36.m_9236_() instanceof ServerLevel) || !_plr36.m_8960_().m_135996_(_plr36.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_supernova"))).m_8193_()) {
                                       break label950;
                                    }
                                 }

                                 label952: {
                                    if (playerSelect == 9.0) {
                                       if (!(entity instanceof ServerPlayer)) {
                                          break label952;
                                       }

                                       ServerPlayer _plr37 = (ServerPlayer)entity;
                                       if (!(_plr37.m_9236_() instanceof ServerLevel) || !_plr37.m_8960_().m_135996_(_plr37.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_flowing_red_scale"))).m_8193_()) {
                                          break label952;
                                       }
                                    }

                                    label954: {
                                       if (playerSelect == 16.0) {
                                          if (!(entity instanceof ServerPlayer)) {
                                             break label954;
                                          }

                                          ServerPlayer _plr38 = (ServerPlayer)entity;
                                          if (!(_plr38.m_9236_() instanceof ServerLevel) || !_plr38.m_8960_().m_135996_(_plr38.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_blood_wave"))).m_8193_()) {
                                             break label954;
                                          }
                                       }

                                       if (playerSelect != 18.0) {
                                          break label483;
                                       }

                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr39 = (ServerPlayer)entity;
                                          if (_plr39.m_9236_() instanceof ServerLevel && _plr39.m_8960_().m_135996_(_plr39.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_eso"))).m_8193_()) {
                                             break label483;
                                          }
                                       }

                                       reChange = true;
                                       break label483;
                                    }

                                    reChange = true;
                                    break label483;
                                 }

                                 reChange = true;
                                 break label483;
                              }

                              reChange = true;
                              break label483;
                           }

                           reChange = true;
                           break label483;
                        }

                        reChange = true;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt40 = (LivingEntity)entity;
                        if (_livEnt40.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()) && playerSelect != 9.0 && playerSelect >= 5.0 && playerSelect < 20.0) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 11.0) {
                     if (playerSelect == 5.0) {
                        label731: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr41 = (ServerPlayer)entity;
                              if (_plr41.m_9236_() instanceof ServerLevel && _plr41.m_8960_().m_135996_(_plr41.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_bird_strike"))).m_8193_()) {
                                 break label731;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 13.0) {
                     if (playerSelect == 10.0) {
                        label724: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr42 = (ServerPlayer)entity;
                              if (_plr42.m_9236_() instanceof ServerLevel && _plr42.m_8960_().m_135996_(_plr42.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_collapse"))).m_8193_()) {
                                 break label724;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 14.0) {
                     if (playerSelect == 10.0) {
                        label717: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr43 = (ServerPlayer)entity;
                              if (_plr43.m_9236_() instanceof ServerLevel && _plr43.m_8960_().m_135996_(_plr43.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_huge_roots"))).m_8193_()) {
                                 break label717;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 15.0) {
                     label956: {
                        label710: {
                           label994: {
                              if (playerSelect == 8.0 || playerSelect == 9.0 || playerSelect == 10.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label994;
                                 }

                                 ServerPlayer _plr44 = (ServerPlayer)entity;
                                 if (!(_plr44.m_9236_() instanceof ServerLevel) || !_plr44.m_8960_().m_135996_(_plr44.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_soul_multiplicity"))).m_8193_()) {
                                    break label994;
                                 }
                              }

                              label959: {
                                 if (playerSelect == 10.0) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label959;
                                    }

                                    ServerPlayer _plr45 = (ServerPlayer)entity;
                                    if (!(_plr45.m_9236_() instanceof ServerLevel) || !_plr45.m_8960_().m_135996_(_plr45.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_polymorphic_soul_isomer"))).m_8193_()) {
                                       break label959;
                                    }
                                 }

                                 if (playerSelect != 15.0) {
                                    break label710;
                                 }

                                 if (entity instanceof ServerPlayer) {
                                    ServerPlayer _plr46 = (ServerPlayer)entity;
                                    if (_plr46.m_9236_() instanceof ServerLevel && _plr46.m_8960_().m_135996_(_plr46.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_instant_spirit_bodyof_distorted_killing"))).m_8193_()) {
                                       break label710;
                                    }
                                 }

                                 reChange = true;
                                 break label710;
                              }

                              reChange = true;
                              break label710;
                           }

                           reChange = true;
                        }

                        label961: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt47 = (LivingEntity)entity;
                              if (_livEnt47.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                 if (!(playerSelect >= 6.0) || !(playerSelect <= 15.0)) {
                                    break label956;
                                 }
                                 break label961;
                              }
                           }

                           if ((!(playerSelect >= 3.0) || !(playerSelect <= 4.0)) && (!(playerSelect >= 16.0) || !(playerSelect <= 19.0))) {
                              break label956;
                           }
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 17.0) {
                     if (playerSelect == 10.0) {
                        label980: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt48 = (LivingEntity)entity;
                              if (_livEnt48.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                 break label980;
                              }
                           }

                           reChange = true;
                        }
                     }

                     if (playerSelect == 15.0 && entity instanceof LivingEntity) {
                        LivingEntity _livEnt49 = (LivingEntity)entity;
                        if (_livEnt49.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 18.0) {
                     label662: {
                        label661: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label661;
                              }

                              ServerPlayer _plr50 = (ServerPlayer)entity;
                              if (!(_plr50.m_9236_() instanceof ServerLevel) || !_plr50.m_8960_().m_135996_(_plr50.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                                 break label661;
                              }
                           }

                           if (playerSelect == 15.0) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr51 = (ServerPlayer)entity;
                                 if (_plr51.m_9236_() instanceof ServerLevel && _plr51.m_8960_().m_135996_(_plr51.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_maximum_uzumaki"))).m_8193_()) {
                                    break label662;
                                 }
                              }

                              reChange = true;
                           }
                           break label662;
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 19.0 && playerSelect == 10.0) {
                     label644: {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr52 = (ServerPlayer)entity;
                           if (_plr52.m_9236_() instanceof ServerLevel && _plr52.m_8960_().m_135996_(_plr52.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_explodethe_air"))).m_8193_()) {
                              break label644;
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < 30.0) {
                  if (playerCT == 21.0) {
                     label637: {
                        label964: {
                           if (playerSelect == 5.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label964;
                              }

                              ServerPlayer _plr53 = (ServerPlayer)entity;
                              if (!(_plr53.m_9236_() instanceof ServerLevel) || !_plr53.m_8960_().m_135996_(_plr53.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_divergent_fist"))).m_8193_()) {
                                 break label964;
                              }
                           }

                           label966: {
                              if (playerSelect == 8.0) {
                                 if (!(entity instanceof ServerPlayer)) {
                                    break label966;
                                 }

                                 ServerPlayer _plr54 = (ServerPlayer)entity;
                                 if (!(_plr54.m_9236_() instanceof ServerLevel) || !_plr54.m_8960_().m_135996_(_plr54.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_itadori"))).m_8193_()) {
                                    break label966;
                                 }
                              }

                              label968: {
                                 if (playerSelect == 13.0) {
                                    if (!(entity instanceof ServerPlayer)) {
                                       break label968;
                                    }

                                    ServerPlayer _plr55 = (ServerPlayer)entity;
                                    if (!(_plr55.m_9236_() instanceof ServerLevel) || !_plr55.m_8960_().m_135996_(_plr55.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_piercing_blood_itadori"))).m_8193_() || ReturnInsideItemProcedure.execute(entity).m_41720_() != JujutsucraftModItems.DEATH_PAINTING.get()) {
                                       break label968;
                                    }
                                 }

                                 label604: {
                                    if (playerSelect == 14.0) {
                                       if (!(entity instanceof ServerPlayer)) {
                                          break label604;
                                       }

                                       ServerPlayer _plr57 = (ServerPlayer)entity;
                                       if (!(_plr57.m_9236_() instanceof ServerLevel) || !_plr57.m_8960_().m_135996_(_plr57.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_supernova_itadori"))).m_8193_() || ReturnInsideItemProcedure.execute(entity).m_41720_() != JujutsucraftModItems.DEATH_PAINTING.get()) {
                                          break label604;
                                       }
                                    }

                                    if (playerSelect == 18.0) {
                                       if (entity instanceof ServerPlayer) {
                                          ServerPlayer _plr59 = (ServerPlayer)entity;
                                          if (_plr59.m_9236_() instanceof ServerLevel && _plr59.m_8960_().m_135996_(_plr59.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_deep_concentration"))).m_8193_()) {
                                             break label637;
                                          }
                                       }

                                       reChange = true;
                                    }
                                    break label637;
                                 }

                                 reChange = true;
                                 break label637;
                              }

                              reChange = true;
                              break label637;
                           }

                           reChange = true;
                           break label637;
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 24.0) {
                     label586: {
                        label585: {
                           if (playerSelect == 8.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label585;
                              }

                              ServerPlayer _plr60 = (ServerPlayer)entity;
                              if (!(_plr60.m_9236_() instanceof ServerLevel) || !_plr60.m_8960_().m_135996_(_plr60.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_frost_calm"))).m_8193_()) {
                                 break label585;
                              }
                           }

                           if (playerSelect == 9.0) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr61 = (ServerPlayer)entity;
                                 if (_plr61.m_9236_() instanceof ServerLevel && _plr61.m_8960_().m_135996_(_plr61.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_icefall"))).m_8193_()) {
                                    break label586;
                                 }
                              }

                              reChange = true;
                           }
                           break label586;
                        }

                        reChange = true;
                     }
                  } else if (playerCT == 27.0) {
                     if (playerSelect == 5.0) {
                        AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                        LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                        Objects.requireNonNull(_iitemhandlerref);
                        var10000.ifPresent(_iitemhandlerref::set);
                        if (_iitemhandlerref.get() != null) {
                           for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                              ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                              if (itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
                                 reChange = true;
                                 break;
                              }
                           }
                        }
                     }
                  } else if (playerCT == 29.0) {
                     if (playerSelect == 5.0) {
                        NUM3 = 0.0;
                        AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                        LazyOptional var94 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                        Objects.requireNonNull(_iitemhandlerref);
                        var94.ifPresent(_iitemhandlerref::set);
                        if (_iitemhandlerref.get() != null) {
                           for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                              ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                              if (itemstackiterator.m_41720_() == JujutsucraftModItems.BULLET_BALL.get()) {
                                 NUM3 += (double)itemstackiterator.m_41613_();
                                 if (NUM3 > 3.0) {
                                    reChange = true;
                                    break;
                                 }
                              }
                           }
                        }
                     } else if (playerSelect == 7.0) {
                        label540: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt76 = (LivingEntity)entity;
                              if (_livEnt76.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed") && entity.getPersistentData().m_128459_("mode_hakari") == 2.0) {
                                 break label540;
                              }
                           }

                           reChange = true;
                        }
                     }
                  }
               } else if (playerCT < 40.0) {
                  if (playerCT == 30.0) {
                     if (playerSelect == 5.0 && entity instanceof LivingEntity) {
                        LivingEntity _livEnt79 = (LivingEntity)entity;
                        if (_livEnt79.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                           reChange = true;
                        }
                     }
                  } else if (playerCT == 39.0 && (playerSelect == 5.0 || playerSelect == 6.0 || playerSelect == 7.0)) {
                     label990: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt80 = (LivingEntity)entity;
                           if (_livEnt80.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                              break label990;
                           }
                        }

                        reChange = true;
                     }
                  }
               } else if (playerCT < 50.0) {
                  if (playerCT == 40.0) {
                     label520: {
                        if (playerSelect == 6.0 && entity instanceof LivingEntity) {
                           LivingEntity _livEnt81 = (LivingEntity)entity;
                           if (_livEnt81.m_21023_((MobEffect)JujutsucraftModMobEffects.EFFECT_REIKI.get())) {
                              reChange = true;
                              break label520;
                           }
                        }

                        if (playerSelect == 7.0 && entity instanceof LivingEntity) {
                           LivingEntity _livEnt82 = (LivingEntity)entity;
                           if (_livEnt82.m_21023_((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                              reChange = true;
                           }
                        }
                     }
                  } else if (playerCT == 41.0) {
                     if (playerSelect == 10.0) {
                        label513: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr83 = (ServerPlayer)entity;
                              if (_plr83.m_9236_() instanceof ServerLevel && _plr83.m_8960_().m_135996_(_plr83.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                                 break label513;
                              }
                           }

                           reChange = true;
                        }
                     }
                  } else if (playerCT == 43.0 && playerSelect == 7.0) {
                     label506: {
                        label505: {
                           label976: {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr84 = (ServerPlayer)entity;
                                 if (_plr84.m_9236_() instanceof ServerLevel && _plr84.m_8960_().m_135996_(_plr84.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_megumi_fushiguro"))).m_8193_()) {
                                    break label976;
                                 }
                              }

                              if (!(entity instanceof ServerPlayer)) {
                                 break label505;
                              }

                              ServerPlayer _plr85 = (ServerPlayer)entity;
                              if (!(_plr85.m_9236_() instanceof ServerLevel) || !_plr85.m_8960_().m_135996_(_plr85.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_megumi_fushiguro_shibuya"))).m_8193_()) {
                                 break label505;
                              }
                           }

                           if (!((new BiFunction<LevelAccessor, String, Entity>() {
                              public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                 if (levelAccessor instanceof ServerLevel serverLevel) {
                                    try {
                                       return serverLevel.m_8791_(UUID.fromString(uuid));
                                    } catch (Exception var5) {
                                    }
                                 }

                                 return null;
                              }
                           }).apply(world, entity.getPersistentData().m_128461_("SHIKIGAMI_ROZETSU_UUID")) instanceof LivingEntity)) {
                              break label506;
                           }
                        }

                        reChange = true;
                     }
                  }
               }
            }

            reChange = reChange || ChangeTechniqueTest2Procedure.execute(world, x, y, z, entity, playerCT, playerSelect);
            NUM1 = -200.0 - Math.random();
            if (reChange && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.f_20549_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), NUM1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            reChange = false;
            Vec3 _center = new Vec3(entity.m_20185_(), NUM1, entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof Bat && entityiterator.m_6084_()) {
                  reChange = true;
                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                  }

                  if (!entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }
                  break;
               }
            }

            return reChange;
         }
      }
   }
}
