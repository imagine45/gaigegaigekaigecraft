package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class DeathPaintingPlayerFinishesUsingItemProcedure {
   public DeathPaintingPlayerFinishesUsingItemProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean success = false;
         boolean sukuna = false;
         double cursed_technique2 = 0.0;
         double level_control = 0.0;
         double cursed_technique = 0.0;
         double num1 = 0.0;
         double tick = 0.0;
         double num2 = 0.0;
         cursed_technique = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         cursed_technique2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
         if (entity.getPersistentData().getBoolean("CursedSpirit")) {
            success = true;
         } else {
            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 0.0) {
               success = true;
               level_control = 2.0;
            } else {
               label184: {
                  if (cursed_technique != 21.0 && cursed_technique2 != 21.0) {
                     label167: {
                        if (entity instanceof Player) {
                           Player _plr = (Player)entity;
                           if (_plr.getAbilities().instabuild) {
                              break label167;
                           }
                        }

                        if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                           success = false;
                           level_control = 0.0;
                           break label184;
                        }
                     }
                  }

                  success = true;
                  level_control = 1.0;
               }
            }

            if (!success) {
               label158: {
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.getAbilities().instabuild) {
                        break label158;
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.DEATH_PAINTING.get())).copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            }
         }

         if (success) {
            if (level_control < 2.0) {
               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getItem() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
                  label179: {
                     success = false;
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.death_painting").getString()), false);
                        }
                     }

                     if (entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) {
                           break label179;
                        }
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.DEATH_PAINTING.get())).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }
                  }
               } else {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getItem() == JujutsucraftModItems.DEATH_PAINTING.get()) {
                     ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.setCount(Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() + 1, 9));
                  } else {
                     ItemStack _setval = new ItemStack((ItemLike)JujutsucraftModItems.DEATH_PAINTING.get());
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.BodyItem = _setval.copy();
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        String var10001 = Component.translatable("item.gaigegaigekaigecraft.death_painting").getString();
                        _player.displayClientMessage(Component.literal(var10001 + ": " + Math.round((float)((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount())), false);
                     }
                  }

                  if ((cursed_technique == 21.0 || cursed_technique2 == 21.0) && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 3) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_supernova_itadori"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }

                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 6 && entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_piercing_blood_itadori"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }
            } else {
               success = false;
            }
         }

         if (success) {
            if (entity.isAlive()) {
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound entity.blaze.ambient master @s ~ ~ ~ 1 0.5");
               }

               if (!entity.getPersistentData().getBoolean("CursedSpirit") && entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:observation_of_the_soul"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            }

            WhenRespawnProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
