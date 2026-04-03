package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class ChangeTechniqueTest2Procedure {
   public ChangeTechniqueTest2Procedure() {
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
         ItemStack item_mainHand = ItemStack.EMPTY;
         if (!(entity instanceof ServerPlayer)) {
            return false;
         } else {
            NUM1 = playerCT;
            NUM2 = playerSelect;
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            label304: {
               label303: {
                  item_mainHand = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt1 = (LivingEntity)entity;
                     if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (playerSelect != 20.0) {
                           break label304;
                        }
                        break label303;
                     }
                  }

                  if (playerSelect != 21.0) {
                     break label304;
                  }
               }

               reChange = true;
            }

            if ((playerSelect <= 2.0 || playerSelect >= 20.0) && item_mainHand.getItem() == JujutsucraftModItems.LOUDSPEAKER.get() && (!item_mainHand.getOrCreateTag().contains("Used") || !item_mainHand.getOrCreateTag().getBoolean("Used"))) {
               reChange = true;
            }

            if (playerCT == -1.0 && playerSelect > 2.0) {
               int var47;
               label282: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var47 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                        break label282;
                     }
                  }

                  var47 = 0;
               }

               if (var47 <= 0) {
                  reChange = true;
               }
            }

            if (playerCT == 1.0 && playerSelect >= 11.0 && playerSelect <= 13.0) {
               label274: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label274;
                     }
                  }

                  reChange = true;
               }
            }

            if (playerCT == 5.0) {
               if (playerSelect != 5.0 && playerSelect != 6.0 && playerSelect != 7.0) {
                  if ((playerSelect == 15.0 || playerSelect == 19.0) && !LocateRikaProcedure.execute(world, entity)) {
                     reChange = true;
                  }
               } else if (!LocateRikaProcedure.execute(world, entity)) {
                  label262: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt7 = (LivingEntity)entity;
                        if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                           break label262;
                        }
                     }

                     reChange = true;
                  }
               }
            } else if (playerCT == 7.0) {
               label252: {
                  label311: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           if (playerSelect != 15.0) {
                              break label252;
                           }
                           break label311;
                        }
                     }

                     if (!(playerSelect > 15.0) || !(playerSelect < 20.0)) {
                        break label252;
                     }
                  }

                  reChange = true;
               }
            } else if (playerCT == 10.0 && playerSelect == 8.0 && !LocateBloodBallProcedure.execute(world, x, y, z, entity)) {
               reChange = true;
            }

            if (playerCT == 18.0 && (playerSelect >= 11.0 && playerSelect <= 13.0 || playerSelect == 15.0) && entity.getPersistentData().getDouble("data_cursed_spirit_manipulation1") == 0.0) {
               reChange = true;
            }

            if (playerCT == 21.0) {
               if (playerSelect >= 3.0 && playerSelect <= 20.0 && entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     reChange = true;
                  }
               }

               if (playerSelect == 18.0 && entity instanceof LivingEntity) {
                  LivingEntity _livEnt12 = (LivingEntity)entity;
                  if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                     reChange = true;
                  }
               }

               if (playerSelect == 19.0 && GetSukunaLevelProcedure.execute(entity) == 0.0) {
                  reChange = true;
               }
            } else if (playerCT == 27.0) {
               if (playerSelect == 5.0) {
                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var48 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var48.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                        if (itemstackiterator.getItem() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_LONG.get()) {
                           reChange = true;
                           break;
                        }
                     }
                  }
               } else if (playerSelect == 19.0) {
                  label212: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt22 = (LivingEntity)entity;
                        if (_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                           break label212;
                        }
                     }

                     reChange = true;
                  }
               }
            } else if (playerCT == 29.0) {
               if (playerSelect == 5.0) {
                  NUM3 = 0.0;
                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var49 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var49.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                        if (itemstackiterator.getItem() == JujutsucraftModItems.BULLET_BALL.get()) {
                           NUM3 += (double)itemstackiterator.getCount();
                           if (NUM3 > 3.0) {
                              reChange = true;
                              break;
                           }
                        }
                     }
                  }
               } else if (playerSelect == 7.0) {
                  label324: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed") && entity.getPersistentData().getDouble("mode_hakari") == 2.0) {
                           break label324;
                        }
                     }

                     reChange = true;
                  }
               }

               if ((playerSelect == 5.0 || playerSelect == 6.0 || playerSelect == 20.0) && entity instanceof LivingEntity) {
                  LivingEntity _livEnt32 = (LivingEntity)entity;
                  if (_livEnt32.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     reChange = true;
                  }
               }
            }

            if (playerCT == 39.0 && (playerSelect == 8.0 || playerSelect == 9.0) && !LocateLiquidMetalProcedure.execute(world, entity)) {
               reChange = true;
            }

            if (!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).use_mainSkill) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var50 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var50.ifPresent(new NonNullConsumer<IItemHandler>() {
                  @Override
                  public void accept(@NotNull IItemHandler o) {
                     _iitemhandlerref.set(o);
                  }
               });
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                     if (itemstackiterator.getItem() == JujutsucraftModItems.CURSED_TECHNIQUE_STARTER.get()) {
                        if (entity instanceof Player) {
                           Player _plrCldCheck36 = (Player)entity;
                           if (_plrCldCheck36.getCooldowns().isOnCooldown(itemstackiterator.getItem())) {
                              continue;
                           }
                        }

                        if (NUM1 == itemstackiterator.getOrCreateTag().getDouble("TechniqueNumber1") && NUM2 == itemstackiterator.getOrCreateTag().getDouble("TechniqueNumber2")) {
                           reChange = true;
                           break;
                        }
                     }
                  }
               }
            }

            return reChange;
         }
      }
   }
}
