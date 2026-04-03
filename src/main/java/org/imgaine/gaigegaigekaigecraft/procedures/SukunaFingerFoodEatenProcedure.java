package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;

public class SukunaFingerFoodEatenProcedure {
   public SukunaFingerFoodEatenProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = 0.0;
         double cursed_technique = 0.0;
         double num2 = 0.0;
         double level_control = 0.0;
         double tick = 0.0;
         double cursed_technique2 = 0.0;
         boolean success = false;
         boolean sukuna = false;
         boolean logic_unluck = false;
         if (entity.getPersistentData().getBoolean("CursedSpirit")) {
            success = true;
         } else {
            cursed_technique = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            cursed_technique2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 0.0) {
               success = true;
               level_control = 2.0;
            } else if (cursed_technique != 21.0 && cursed_technique2 != 21.0) {
               label314: {
                  label313: {
                     if (entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.getAbilities().instabuild) {
                           break label313;
                        }
                     }

                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getItem() != JujutsucraftModItems.SUKUNA_FINGER.get() && cursed_technique != 1.0 && cursed_technique2 != 1.0 && cursed_technique != 6.0 && cursed_technique2 != 6.0) {
                        success = false;
                        level_control = 0.0;
                        break label314;
                     }
                  }

                  success = true;
                  level_control = 0.0;
               }
            } else {
               success = true;
               level_control = 1.0;
            }

            if (!success) {
               label300: {
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.getAbilities().instabuild) {
                        break label300;
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).copy();
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

         if (entity.isAlive()) {
            if (level_control < 2.0) {
               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getItem() == JujutsucraftModItems.DEATH_PAINTING.get() && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.death_painting").getString()), false);
                  }
               }

               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getItem() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
                  ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.setCount(Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() + 1, 20));
               } else {
                  ItemStack _setval = new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get());
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.BodyItem = _setval.copy();
                     capability.syncPlayerVariables(entity);
                  });
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     String var10001 = Component.translatable("item.gaigegaigekaigecraft.sukuna_finger").getString();
                     _player.displayClientMessage(Component.literal(var10001 + ": " + Math.round((float)((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount())), false);
                  }
               }

               num1 = (double)((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount();
            }

            if (num1 > 0.0) {
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement revoke @s only gaigegaigekaigecraft:update");
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:update"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }

               if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 1000.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               } else {
                  label329: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt22 = (LivingEntity)entity;
                        if (_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label329;
                        }
                     }

                     int var70;
                     label276: {
                        logic_unluck = true;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt23 = (LivingEntity)entity;
                           if (_livEnt23.hasEffect(MobEffects.UNLUCK)) {
                              label272: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                       var70 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                       break label272;
                                    }
                                 }

                                 var70 = 0;
                              }

                              ++var70;
                              break label276;
                           }
                        }

                        var70 = 0;
                     }

                     num2 = (double)var70;
                     num2 = Math.min(num2, 9.0);
                  }

                  if (level_control == 2.0) {
                     sukuna = false;
                     tick = 300.0;
                  } else if (level_control != 1.0) {
                     if (level_control == 0.0) {
                        sukuna = true;
                        tick = 1000000.0;
                     }
                  } else {
                     label337: {
                        label263: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt25 = (LivingEntity)entity;
                              if (_livEnt25.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label263;
                              }
                           }

                           if (num1 != 1.0 && !(num2 >= 9.0)) {
                              break label337;
                           }
                        }

                        sukuna = true;
                        tick = 300.0;
                     }
                  }
               }
            }

            num1 = -300.0 - Math.random();
            if (sukuna && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.PIG.spawn(_level, BlockPos.containing(entity.getX(), num1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }

            sukuna = false;
            Vec3 _center = new Vec3(entity.getX(), num1, entity.getZ());

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
               if (entityiterator instanceof Pig && entityiterator.isAlive()) {
                  sukuna = true;
                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                  }

                  if (!entityiterator.level().isClientSide()) {
                     entityiterator.discard();
                  }
                  break;
               }
            }

            if (sukuna) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.UNLUCK);
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  Commands var71 = entity.getServer().getCommands();
                  CommandSourceStack var72 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                  Object var10002;
                  if (tick > 10000.0) {
                     var10002 = "infinite";
                  } else {
                     int var10003;
                     label239: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              var10003 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier();
                              break label239;
                           }
                        }

                        var10003 = 0;
                     }

                     var10002 = Math.round(Math.max(tick, (double)Math.round(Math.floor((double)(var10003 / 20)))));
                  }

                  String var73 = String.valueOf(var10002);
                  var71.performPrefixedCommand(var72, "effect give @s gaigegaigekaigecraft:sukuna_effect " + var73 + " " + Math.round(Math.min(Math.max(GetSukunaLevelProcedure.execute(entity), 1.0), 20.0) - 1.0) + " true");
               }
            }

            if (logic_unluck && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.COW.spawn(_level, BlockPos.containing(entity.getX(), num1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }

            logic_unluck = false;
            _center = new Vec3(entity.getX(), num1, entity.getZ());

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
               if (entityiterator instanceof Cow && entityiterator.isAlive()) {
                  logic_unluck = true;
                  if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                  }

                  if (!entityiterator.level().isClientSide()) {
                     entityiterator.discard();
                  }
                  break;
               }
            }

            if (logic_unluck && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:unluck 180 " + Math.round(num2) + " true");
            }

            if (!entity.getPersistentData().getBoolean("CursedSpirit")) {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:observation_of_the_soul"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }

               if (level_control == 0.0) {
                  boolean _setval = true;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.flag_sukuna = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            WhenRespawnProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
