package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber
public class Test1Procedure {
   public Test1Procedure() {
   }

   @SubscribeEvent
   public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(event, event.getLevel(), (double)event.getPos().getX(), (double)event.getPos().getY(), (double)event.getPos().getZ(), event.getTarget(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      execute((Event)null, world, x, y, z, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         ItemStack ITEM1 = ItemStack.EMPTY;
         boolean SUCCESS = false;
         boolean Friend = false;
         boolean logic_a = false;
         String STR1 = "";
         String Name = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         if (sourceentity instanceof Player && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
            if (((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 18.0 || ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18.0) {
               label318: {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)sourceentity;
                     if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label318;
                     }
                  }

                  if (!(entity instanceof Player) && entity.isAlive() && entity.getPersistentData().getBoolean("CursedSpirit") && entity.getPersistentData().getDouble("select") == 0.0) {
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)sourceentity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                     }

                     int var10000;
                     label268: {
                        Friend = sourceentity.getStringUUID().equals(entity.getPersistentData().getString("OWNER_UUID")) && sourceentity.getPersistentData().getDouble("friend_num") != 0.0 && sourceentity.getPersistentData().getDouble("friend_num") == entity.getPersistentData().getDouble("friend_num_worker");
                        logic_a = false;
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)sourceentity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label268;
                           }
                        }

                        var10000 = 0;
                     }
                     double var64;
                     label263: {
                        NUM1 = (double)(var10000 + 1);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var64 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label263;
                           }
                        }

                        var64 = 0.0;
                     }

                     NUM2 = var64;
                     if (NUM1 >= 13.0) {
                        NUM1 = 13.0 + (NUM1 - 13.0) * 0.3;
                     }

                     if (NUM1 - 8.0 >= NUM2) {
                        logic_a = true;
                     } else {
                        double var65 = NUM2 + 4.0;
                        double var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = (double)_livEnt.getHealth();
                        } else {
                           var10001 = -1.0;
                        }

                        var10001 = Math.max(var10001, 0.01);
                        double var10002;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10002 = (double)_livEnt.getMaxHealth();
                        } else {
                           var10002 = -1.0;
                        }

                        NUM3 = var65 * (var10001 / Math.max(var10002, 0.01));
                        if (NUM1 * 0.5 >= NUM3) {
                           logic_a = true;
                        }
                     }

                     if (entity.getPersistentData().getDouble("friend_num_worker") != 0.0) {
                        logic_a = false;
                     }

                     if (Friend && !sourceentity.isShiftKeyDown() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:rideable_entity")))) {
                        sourceentity.startRiding(entity);
                     } else {
                        label323: {
                           if (!logic_a) {
                              label254: {
                                 if (sourceentity instanceof Player) {
                                    Player _plr = (Player)sourceentity;
                                    if (_plr.getAbilities().instabuild) {
                                       break label254;
                                    }
                                 }

                                 if (!Friend) {
                                    break label323;
                                 }
                              }
                           }

                           if (sourceentity.getPersistentData().getDouble("friend_num") != entity.getPersistentData().getDouble("friend_num_worker") || sourceentity.getPersistentData().getDouble("friend_num") != entity.getPersistentData().getDouble("friend_num")) {
                              entity.getPersistentData().putDouble("friend_num", 0.0);
                              entity.getPersistentData().putDouble("friend_num_worker", 0.0);
                           }

                           x_pos = 0.0;
                           z_pos = 0.0;
                           if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                              Commands var66 = sourceentity.getServer().getCommands();
                              CommandSourceStack var69 = new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(), sourceentity.level() instanceof ServerLevel ? (ServerLevel)sourceentity.level() : null, 4, sourceentity.getName().getString(), sourceentity.getDisplayName(), sourceentity.level().getServer(), sourceentity);
                              long var71 = Math.round(x_pos);
                              var66.performPrefixedCommand(var69, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var71 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                           }

                           Name = entity.getDisplayName().getString().equals("") ? "No Name" : entity.getDisplayName().getString();
                           y_pos = 64.0 + Math.random() * 64.0;
                           NUM1 = 0.0;

                           for(int index0 = 0; index0 < 10000; ++index0) {
                              ++NUM1;
                              STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                              if (sourceentity.getPersistentData().getDouble(STR1) == 0.0) {
                                 break;
                              }

                              if (sourceentity.getPersistentData().getString(STR1 + "_name").equals(Name)) {
                                 y_pos = sourceentity.getPersistentData().getDouble(STR1);
                                 break;
                              }
                           }

                           if (!Friend) {
                              ITEM1 = (new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_BALL.get())).copy();
                              ITEM1.getOrCreateTag().putString("name_data", Name);
                              ITEM1.getOrCreateTag().putString("owner_name_data", sourceentity.getDisplayName().getString());
                              ITEM1.setHoverName(Component.literal(ITEM1.getOrCreateTag().getString("name_data")));
                              AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                              LazyOptional var67 = sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                              Objects.requireNonNull(_iitemhandlerref);
                              var67.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                              if (_iitemhandlerref.get() != null) {
                                 for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                    ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                    if (ITEM1.getDisplayName().getString().equals(itemstackiterator.getDisplayName().getString()) && ITEM1.getOrCreateTag().getString("name_data").equals(itemstackiterator.getOrCreateTag().getString("name_data")) && ITEM1.getOrCreateTag().getString("owner_name_data").equals(itemstackiterator.getOrCreateTag().getString("owner_name_data"))) {
                                       y_pos = itemstackiterator.getOrCreateTag().getDouble("y_data");
                                       break;
                                    }
                                 }
                              }

                              ITEM1.getOrCreateTag().putDouble("y_data", y_pos);
                              if (sourceentity instanceof Player) {
                                 Player _player = (Player)sourceentity;
                                 ItemStack _setstack = ITEM1.copy();
                                 _setstack.setCount(1);
                                 ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 float var70;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var70 = _livEnt.getMaxHealth();
                                 } else {
                                    var70 = -1.0F;
                                 }

                                 _entity.setHealth(var70);
                              }
                           }

                           entity.getPersistentData().putString("owner_name_data", sourceentity.getDisplayName().getString());
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                           }

                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                           }

                           if (!Friend) {
                              EntityDieProcedure.execute(world, x, y, z, new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), entity);
                           } else {
                              logic_a = false;
                              if (world instanceof ServerLevel) {
                                 ServerLevel _origLevel = (ServerLevel)world;
                                 LevelAccessor var37 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
                                 if (var37 != null) {
                                    Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                                    for(Entity entityiterator : var37.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                                       if (sourceentity != entityiterator && entity.getDisplayName().getString().equals(entityiterator.getDisplayName().getString()) && entityiterator.isAlive() && sourceentity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                                          if (!logic_a) {
                                             logic_a = true;
                                             NUM1 = 0.0;

                                             for(int index1 = 0; index1 < 10000; ++index1) {
                                                ++NUM1;
                                                STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                                                if (sourceentity.getPersistentData().getDouble(STR1) == 0.0 || sourceentity.getPersistentData().getString(STR1 + "_name").equals(entityiterator.getDisplayName().getString())) {
                                                   sourceentity.getPersistentData().putDouble(STR1, y_pos);
                                                   sourceentity.getPersistentData().putString(STR1 + "_name", entityiterator.getDisplayName().getString());
                                                   break;
                                                }
                                             }

                                             sourceentity.getPersistentData().putDouble(STR1 + "_num", 0.0);
                                          }

                                          sourceentity.getPersistentData().putDouble(STR1 + "_num", sourceentity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                                       }
                                    }
                                 }
                              }

                              sourceentity.getPersistentData().putBoolean("UpdateSkills", true);
                           }
                        }
                     }
                  }
               }
            }

            if (SUCCESS && event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

      }
   }
}
