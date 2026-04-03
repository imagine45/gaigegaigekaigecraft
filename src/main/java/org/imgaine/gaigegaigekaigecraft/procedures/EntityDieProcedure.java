package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityDieProcedure {
   public EntityDieProcedure() {
   }

   @SubscribeEvent
   public static void onEntityDeath(LivingDeathEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity());
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
      execute((Event)null, world, x, y, z, damagesource, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         ItemStack ITEM1 = ItemStack.EMPTY;
         String STR1 = "";
         String DimensionID = "";
         double NUM1 = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double NUM2 = 0.0;
         if (JujutsucraftModVariables.MapVariables.get(world).BlastGame && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !damagesource.is(DamageTypes.GENERIC_KILL)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.setHealth((float)(0.5 + Math.random()));
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity.getPersistentData().getDouble("skill_domain") > 0.0 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
               }
            }

            if (entity instanceof DomainExpansionEntityEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMaxHealth();
                  } else {
                     var10001 = -1.0F;
                  }

                  _entity.setHealth(Math.max(var10001, 1.0F));
               }

               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     double var55;
                     label179: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                              var55 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getAmplifier();
                              break label179;
                           }
                        }

                        var55 = 0.0;
                     }

                     label174: {
                        NUM1 = var55;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                              var55 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).getDuration();
                              break label174;
                           }
                        }

                        var55 = 0.0;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        float var59;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var59 = _livEnt.getMaxHealth();
                        } else {
                           var59 = -1.0F;
                        }

                        _entity.setHealth((float)Math.max((double)var59 * 0.1 * (NUM1 + 1.0), 1.0));
                     }

                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()) && entity.getPersistentData().getDouble("Life") > 0.0) {
                     entity.getPersistentData().putDouble("Life", entity.getPersistentData().getDouble("Life") - 1.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.setHealth((float)(1.0 + Math.random() * 0.1));
                     }

                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     return;
                  }
               }

               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               ITEM1 = var10000;
               if (ITEM1.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || ITEM1.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  NUM1 = 1.0;

                  for(int index0 = 0; index0 < 800; ++index0) {
                     STR1 = "DATA" + Math.round(NUM1);
                     if (!ITEM1.getOrCreateTag().contains(STR1)) {
                        break;
                     }

                     ITEM1.getOrCreateTag().remove(STR1);
                     ++NUM1;
                  }
               }

               if (entity instanceof Player) {
                  x_pos = 0.0;
                  z_pos = 0.0;
                  if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
                     double _setval = entity.getPersistentData().getDouble("friend_num");
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.friend_num_keep = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  } else if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "clear @s gaigegaigekaigecraft:cursed_spirit_ball");
                  }

                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     Commands var54 = entity.getServer().getCommands();
                     CommandSourceStack var58 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                     long var10002 = Math.round(x_pos);
                     var54.performPrefixedCommand(var58, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                  }

                  DimensionID = ("" + String.valueOf(entity.level().dimension())).replace("ResourceKey[minecraft:dimension / ", "").replace("]", "");
                  if (world instanceof ServerLevel) {
                     ServerLevel _origLevel = (ServerLevel)world;
                     LevelAccessor var32 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
                     if (var32 != null) {
                        Vec3 _center = new Vec3(0.0, 128.0, 0.0);

                        for(Entity entityiterator : var32.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
                           if (!(entityiterator instanceof Player) && entityiterator.isAlive() && entity.getDisplayName().getString().equals(entityiterator.getPersistentData().getString("owner_name_data"))) {
                              if (entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker") && entity.getPersistentData().getDouble("friend_num") != 0.0) {
                                 if (!var32.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
                                    entityiterator.setDeltaMovement(new Vec3((Math.random() - 0.5) * 2.0, Math.random() * 1.0, (Math.random() - 0.5) * 2.0));
                                    entityiterator.getPersistentData().putDouble("friend_num", 0.0);
                                    entityiterator.getPersistentData().putDouble("friend_num_worker", 0.0);
                                    entityiterator.getPersistentData().putString("OWNER_UUID", "");
                                    entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", false);
                                    entityiterator.getPersistentData().putBoolean("CurseUser", false);
                                    entityiterator.getPersistentData().putBoolean("Player", false);
                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "data merge entity @s {Invulnerable:0b,PersistenceRequired:0b,NoAI:0b}");
                                    }

                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "execute in " + DimensionID + " run tp @s " + x + " " + y + " " + z);
                                    }
                                 }
                              } else {
                                 if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                                 }

                                 if (!entityiterator.level().isClientSide()) {
                                    entityiterator.discard();
                                 }
                              }
                           }
                        }
                     }

                     world = world;
                  }
               }

               DespawnRangedAmmoProcedure.execute(world, x, y, z, entity);
               WhenEntityDieProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
