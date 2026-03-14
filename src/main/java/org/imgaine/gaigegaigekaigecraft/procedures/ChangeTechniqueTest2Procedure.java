package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class ChangeTechniqueTest2Procedure {
   public ChangeTechniqueTest2Procedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity == null) {
         return false;
      } else {
         boolean reChange;
         double NUM1;
         double NUM2;
         label221: {
            label220: {
               reChange = false;
               NUM1 = 0.0;
               NUM2 = 0.0;
               double cost = 0.0;
               reChange = false;
               NUM1 = playerCT;
               NUM2 = playerSelect;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt0 = (LivingEntity)entity;
                  if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     if (playerSelect != 20.0) {
                        break label221;
                     }
                     break label220;
                  }
               }

               if (playerSelect != 21.0) {
                  break label221;
               }
            }

            reChange = true;
         }

         if (playerSelect <= 2.0 || playerSelect >= 20.0) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get()) {
               label226: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128441_("Used")) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41784_().m_128471_("Used")) {
                        break label226;
                     }
                  }

                  reChange = true;
               }
            }
         }

         if (playerCT == -1.0 && playerSelect > 2.0) {
            int var38;
            label196: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     var38 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                     break label196;
                  }
               }

               var38 = 0;
            }

            if (var38 <= 0) {
               reChange = true;
            }
         }

         if (playerCT == 5.0) {
            if (playerSelect != 5.0 && playerSelect != 6.0 && playerSelect != 7.0) {
               if ((playerSelect == 15.0 || playerSelect == 19.0) && !LocateRikaProcedure.execute(world, entity)) {
                  reChange = true;
               }
            } else if (!LocateRikaProcedure.execute(world, entity)) {
               label184: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                        break label184;
                     }
                  }

                  reChange = true;
               }
            }
         } else if (playerCT == 7.0) {
            label174: {
               label227: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                        if (playerSelect != 15.0) {
                           break label174;
                        }
                        break label227;
                     }
                  }

                  if (!(playerSelect > 15.0) || !(playerSelect < 20.0)) {
                     break label174;
                  }
               }

               reChange = true;
            }
         } else if (playerCT == 10.0 && playerSelect == 8.0 && !LocateBloodBallProcedure.execute(world, x, y, z, entity)) {
            reChange = true;
         }

         if (playerCT == 18.0 && (playerSelect >= 11.0 && playerSelect <= 13.0 || playerSelect == 15.0) && entity.getPersistentData().m_128459_("data_cursed_spirit_manipulation1") == 0.0) {
            reChange = true;
         }

         if (playerCT == 21.0) {
            if (playerSelect >= 3.0 && playerSelect <= 20.0 && entity instanceof LivingEntity) {
               LivingEntity _livEnt12 = (LivingEntity)entity;
               if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                  reChange = true;
               }
            }

            if (playerSelect == 18.0 && entity instanceof LivingEntity) {
               LivingEntity _livEnt13 = (LivingEntity)entity;
               if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                  reChange = true;
               }
            }

            if (playerSelect == 19.0 && GetSukunaLevelProcedure.execute(entity) == 0.0) {
               reChange = true;
            }
         } else if (playerCT == 27.0 && playerSelect == 19.0) {
            label151: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt14 = (LivingEntity)entity;
                  if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                     break label151;
                  }
               }

               reChange = true;
            }
         }

         if (playerCT == 39.0 && (playerSelect == 8.0 || playerSelect == 9.0) && !LocateLiquidMetalProcedure.execute(world, entity)) {
            reChange = true;
         }

         if (!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).use_mainSkill) {
            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
            LazyOptional var39 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
            Objects.requireNonNull(_iitemhandlerref);
            var39.ifPresent(_iitemhandlerref::set);
            if (_iitemhandlerref.get() != null) {
               for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                  if (itemstackiterator.m_41720_() == JujutsucraftModItems.CURSED_TECHNIQUE_STARTER.get()) {
                     if (entity instanceof Player) {
                        Player _plrCldCheck19 = (Player)entity;
                        if (_plrCldCheck19.m_36335_().m_41519_(itemstackiterator.m_41720_())) {
                           continue;
                        }
                     }

                     if (NUM1 == itemstackiterator.m_41784_().m_128459_("TechniqueNumber1") && NUM2 == itemstackiterator.m_41784_().m_128459_("TechniqueNumber2")) {
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
