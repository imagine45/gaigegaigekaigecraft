package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenRespawnProcedure {
   public WhenRespawnProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
      execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double sukuna_level = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double T1 = 0.0;
         double T2 = 0.0;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
         }

         T1 = pVars.PlayerCurseTechnique;
         T2 = pVars.PlayerCurseTechnique2;
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

         if (pVars.friend_num_keep != 0.0) {
            entity.getPersistentData().putDouble("friend_num", pVars.friend_num_keep);
            x_pos = 0.0;
            z_pos = 0.0;
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               Commands var10000 = entity.getServer().getCommands();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
               long var10002 = Math.round(x_pos);
               var10000.performPrefixedCommand(var10001, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos));
            }

            if (world instanceof ServerLevel) {
               ServerLevel _origLevel = (ServerLevel)world;
               LevelAccessor var30 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
               if (var30 != null) {
                  Vec3 _center = new Vec3(x_pos, 128.0, z_pos);

                  for(Entity entityiterator : var30.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
                     if (entity != entityiterator && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                        NUM1 = 0.0;

                        for(int index0 = 0; index0 < 10000; ++index0) {
                           ++NUM1;
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                           if (entity.getPersistentData().getDouble(STR1) == 0.0 || entity.getPersistentData().getDouble(STR1) == entityiterator.getY() || entity.getPersistentData().getString(STR1 + "_name").equals(entityiterator.getDisplayName().getString())) {
                              entity.getPersistentData().putDouble(STR1, entityiterator.getY());
                              entity.getPersistentData().putString(STR1 + "_name", entityiterator.getDisplayName().getString());
                              entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                              break;
                           }
                        }

                        entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     }
                  }
               }

               world = world;
            }

            pVars.friend_num_keep = 0.0;
         }

         if ((T1 == 11.0 || T2 == 11.0) && world.getEntitiesOfClass(CrowEntity.class, AABB.ofSize(new Vec3(x, y, z), 32.0, 32.0, 32.0), (e) -> true).isEmpty()) {
            SummonCrowProcedure.execute(world, x, y, z, entity);
         }

         if (pVars.PlayerFlag_A) {
            pVars.PlayerFlag_A = false;
            pVars.FlagSixEyes = false;
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity26 = (LivingEntity)entity;
               if (_livingEntity26.getAttributes().hasAttribute(Attributes.ARMOR)) {
                  _livingEntity26.getAttribute(Attributes.ARMOR).setBaseValue(0.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity27 = (LivingEntity)entity;
               if (_livingEntity27.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                  _livingEntity27.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(0.0);
               }
            }

            if (T1 == -99.0) {
               pVars.PlayerCurseTechnique = 0.0;
               pVars.PlayerCursePowerFormer = 5.0;
            } else {
               if (T1 == 0.0) {
                  do {
                     pVars.PlayerCurseTechnique = (double)Mth.nextInt(RandomSource.create(), 1, 47);
                  } while(pVars.PlayerCurseTechnique == 42.0);
               }

               if (pVars.PlayerCurseTechnique <= 0.0) {
                  pVars.PlayerCurseTechnique = -1.0;
                  pVars.PlayerCursePowerFormer = (double)Mth.nextInt(RandomSource.create(), 0, 5);
                  if (pVars.PlayerCursePowerFormer == 0.0) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:completely_physically_gifted"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for(String criteria : _ap.getRemainingCriteria()) {
                              _player.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }

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
                  }
               } else {
                  pVars.PlayerCursePowerFormer = pVars.PlayerCurseTechnique == 5.0 ? 400.0 : 200.0;
               }

               if (pVars.PlayerProfession >= 0.0 && Math.random() < 0.01) {
                  pVars.FlagSixEyes = true;
               }
            }

            pVars.PlayerCurseTechnique = pVars.PlayerCurseTechnique;
            pVars.BodyItem = ItemStack.EMPTY;
            pVars.flag_sukuna = false;
            pVars.noChangeTechnique = true;
            pVars.SecondTechnique = false;
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         pVars.PlayerCursePowerMAX = pVars.PlayerCursePowerFormer * (double)Math.round((2.0 + pVars.PlayerLevel) / 1.1);
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt30 = (LivingEntity)entity;
            if (_livEnt30.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               int var67;
               label168: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        var67 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier();
                        break label168;
                     }
                  }

                  var67 = 0;
               }

               sukuna_level = (double)Math.min(var67 + 1, 20);
               pVars.PlayerCursePowerMAX = Math.max(pVars.PlayerCursePowerMAX, sukuna_level <= 9.0 ? 3000.0 + (sukuna_level - 1.0) * 300.0 : 8000.0 + (sukuna_level - 10.0) * 1000.0);
            }
         }

         if (!pVars.PlayerFlag_B) {
            pVars.PlayerFlag_B = true;
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 10, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity33 = (LivingEntity)entity;
               if (_livingEntity33.getAttributes().hasAttribute(Attributes.ARMOR)) {
                  _livingEntity33.getAttribute(Attributes.ARMOR).setBaseValue(0.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity34 = (LivingEntity)entity;
               if (_livingEntity34.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                  _livingEntity34.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(0.0);
               }
            }

            pVars.PlayerCursePower = pVars.PlayerCursePowerMAX;
            pVars.PlayerSelectCurseTechnique = 0.0;
            entity.getPersistentData().putBoolean("infinity", false);
            entity.getPersistentData().putDouble("brokenBrain", 0.0);
            pVars.noChangeTechnique = true;
            pVars.SecondTechnique = false;
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            PlayerSetProfessionProcedure.execute(entity);
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
         }

         if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               _player.setGameMode(GameType.SPECTATOR);
            }

            entity.teleportTo(JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter, entity.getYRot(), entity.getXRot());
            }
         }

         pVars.syncPlayerVariables(entity);
      }
   }
}
