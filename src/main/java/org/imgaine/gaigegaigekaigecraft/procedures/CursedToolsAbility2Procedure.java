package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CursedToolsAbility2Procedure {
   public CursedToolsAbility2Procedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         ItemStack mainHandItem = ItemStack.EMPTY;
         double power = 0.0;
         double old_reach = 0.0;
         if (entity.getPersistentData().getBoolean("attack")) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
            }

            if (mainHandItem.getItem() != ItemStack.EMPTY.getItem()) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               mainHandItem = var10000.copy();
               if (mainHandItem.getItem() == JujutsucraftModItems.GAVEL_LONG.get()) {
                  old_reach = mainHandItem.getOrCreateTag().getDouble("Reach");
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               SetAttributeMainhandProcedure.execute(var10000);
               if (mainHandItem.getItem() == JujutsucraftModItems.GAVEL_LONG.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Reach", old_reach);
               }

               if (mainHandItem.getOrCreateTag().getDouble("Power") != 0.0) {
                  if (mainHandItem.getOrCreateTag().getDouble("Power") > 0.0) {
                     entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * (1.0 + mainHandItem.getOrCreateTag().getDouble("Power") * Math.max(Math.min(entity.getPersistentData().getDouble("cnt6") * 0.2, 1.0), 0.0)));
                  } else {
                     entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * (1.0 + mainHandItem.getOrCreateTag().getDouble("Power")));
                  }
               }

               if (mainHandItem.getOrCreateTag().getDouble("Knockback") != 0.0) {
                  if (mainHandItem.getOrCreateTag().getDouble("Knockback") > 0.0) {
                     entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * (1.0 + mainHandItem.getOrCreateTag().getDouble("Knockback") * Math.max(Math.min(entity.getPersistentData().getDouble("cnt6") * 0.2, 1.0), 0.0)));
                  } else {
                     entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * (1.0 + mainHandItem.getOrCreateTag().getDouble("Knockback")));
                  }
               }

               if (mainHandItem.is(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                  if (mainHandItem.getItem() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                     entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 1.25);
                     if (entity.getPersistentData().getDouble("knockback") >= 1.0) {
                        entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * 1.25);
                     }
                  }

                  if (mainHandItem.getItem() == JujutsucraftModItems.SPLIT_SOUL_KATANA.get()) {
                     label129: {
                        if (entity instanceof Player) {
                           Player _plrCldCheck36 = (Player)entity;
                           if (_plrCldCheck36.getCooldowns().isOnCooldown(mainHandItem.getItem())) {
                              break label129;
                           }
                        }

                        entity.getPersistentData().putBoolean("ignore", true);
                     }
                  }

                  if (mainHandItem.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     entity.getPersistentData().putDouble("Damage", 1.0);
                     entity.getPersistentData().putDouble("knockback", 0.0);
                  }
               }
            }

            label118: {
               if (entity instanceof Player) {
                  if (pVars.PlayerCurseTechnique != 7.0 && pVars.PlayerCurseTechnique2 != 7.0) {
                     break label118;
                  }
               } else if (!(entity instanceof KashimoHajimeEntity)) {
                  break label118;
               }

               entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 1.05);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt45 = (LivingEntity)entity;
               if (_livEnt45.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                  int var20;
                  label109: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                           var20 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                           break label109;
                        }
                     }

                     var20 = 0;
                  }

                  power = (double)(var20 + 1) * 0.1;
                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * (1.5 + power));
                  if (entity.getPersistentData().getDouble("knockback") >= 0.5) {
                     entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * (1.5 + power));
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt52 = (LivingEntity)entity;
               if (_livEnt52.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 1.2);
                  entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * 1.5);
               }
            }

            if (LogicStartPassiveProcedure.execute(entity)) {
               if (entity instanceof Player) {
                  if (!(entity instanceof ServerPlayer)) {
                     return;
                  }

                  ServerPlayer _plr58 = (ServerPlayer)entity;
                  if (!(_plr58.level() instanceof ServerLevel) || !_plr58.getAdvancements().getOrStartProgress(_plr58.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_strike_strengthening"))).isDone() || pVars.PlayerCurseTechnique != 2.0 && pVars.PlayerCurseTechnique2 != 2.0) {
                     return;
                  }
               } else if (!(entity instanceof GojoSatoruEntity)) {
                  return;
               }

               entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 1.25);
               if (entity.getPersistentData().getDouble("knockback") >= 0.5) {
                  entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * 1.25);
               }
            }
         }

      }
   }
}
