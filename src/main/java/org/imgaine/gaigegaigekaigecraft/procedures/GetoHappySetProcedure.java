package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GetoHappySetProcedure {
   public GetoHappySetProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack ITEM1 = ItemStack.EMPTY;
         String STR1 = "";
         String Name = "";
         Entity getEntity = null;
         boolean SUCCESS = false;
         boolean Friend = false;
         boolean logic_a = false;
         boolean break_loop = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double mode = 0.0;
         double loop_num = 0.0;
         if (entity instanceof Player && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add 0 0 0 0");
               }

               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }
            } else {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
               mode = entity.getPersistentData().getDouble("skill") - 1816.0;
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt4") == 0.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().getDouble("cnt3") == 6.0 && mode == 2.0) {
                        loop_num = 20.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 8.0 && mode == 1.0) {
                        loop_num = 8.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 10.0 && mode == 1.0) {
                        loop_num = 8.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 11.0 && mode == 2.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") != 12.0 || mode != 1.0 && mode != 3.0) {
                        if (entity.getPersistentData().getDouble("cnt3") != 13.0 || mode != 1.0 && mode != 2.0) {
                           if (entity.getPersistentData().getDouble("cnt3") == 14.0 && mode == 2.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().getDouble("cnt3") == 15.0 && mode == 3.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().getDouble("cnt3") == 17.0 && mode == 1.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().getDouble("cnt3") == 18.0 && mode == 2.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().getDouble("cnt3") > 18.0) {
                              entity.getPersistentData().putDouble("cnt2", 1.0);
                              entity.getPersistentData().putDouble("cnt3", 0.0);
                              entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
                              break;
                           }
                        } else {
                           loop_num = 8.0;
                        }
                     } else {
                        loop_num = 4.0;
                     }

                     if (!(entity.getPersistentData().getDouble("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var10000 = _level.getServer().getCommands();
                           CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                           CompoundTag var10002 = entity.getPersistentData();
                           var10000.performPrefixedCommand(var10001, "summon gaigegaigekaigecraft:cursed_spirit_grade_3" + Math.round(var10002.getDouble("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().putDouble("cnt2", 1.0);
                     entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt4") == 1.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().getDouble("cnt3") == 3.0 && mode == 1.0) {
                        loop_num = 2.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 4.0 && mode == 1.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 5.0 && mode == 3.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 9.0 && mode == 2.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 10.0 && mode == 3.0) {
                        loop_num = 2.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 11.0 && mode == 2.0) {
                        loop_num = 2.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") != 12.0 || mode != 1.0 && mode != 2.0 && mode != 3.0) {
                        if (entity.getPersistentData().getDouble("cnt3") > 12.0) {
                           entity.getPersistentData().putDouble("cnt2", 1.0);
                           entity.getPersistentData().putDouble("cnt3", 0.0);
                           entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
                           break;
                        }
                     } else {
                        loop_num = 4.0;
                     }

                     if (!(entity.getPersistentData().getDouble("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var67 = _level.getServer().getCommands();
                           CommandSourceStack var70 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                           CompoundTag var73 = entity.getPersistentData();
                           var67.performPrefixedCommand(var70, "summon gaigegaigekaigecraft:cursed_spirit_grade_2" + Math.round(var73.getDouble("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().putDouble("cnt2", 1.0);
                     entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt4") == 2.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().getDouble("cnt3") != 1.0 || mode != 1.0 && mode != 2.0) {
                        if (entity.getPersistentData().getDouble("cnt3") == 2.0 && mode == 2.0) {
                           loop_num = 1.0;
                        } else if (entity.getPersistentData().getDouble("cnt3") == 3.0 && mode == 1.0) {
                           loop_num = 1.0;
                        } else if (entity.getPersistentData().getDouble("cnt3") != 5.0 || mode != 1.0 && mode != 2.0) {
                           if (entity.getPersistentData().getDouble("cnt3") == 6.0 && mode == 3.0) {
                              loop_num = 1.0;
                           } else if (entity.getPersistentData().getDouble("cnt3") == 8.0 && mode == 1.0) {
                              loop_num = 1.0;
                           } else if (entity.getPersistentData().getDouble("cnt3") == 9.0 && mode == 1.0) {
                              loop_num = 1.0;
                           } else if (entity.getPersistentData().getDouble("cnt3") > 12.0) {
                              entity.getPersistentData().putDouble("cnt2", 1.0);
                              entity.getPersistentData().putDouble("cnt3", 0.0);
                              entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
                              break;
                           }
                        } else {
                           loop_num = 1.0;
                        }
                     } else {
                        loop_num = 1.0;
                     }

                     if (!(entity.getPersistentData().getDouble("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var68 = _level.getServer().getCommands();
                           CommandSourceStack var71 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                           CompoundTag var74 = entity.getPersistentData();
                           var68.performPrefixedCommand(var71, "summon gaigegaigekaigecraft:cursed_spirit_grade_1" + Math.round(var74.getDouble("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().putDouble("cnt2", 1.0);
                     entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt4") == 3.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().getDouble("cnt3") == 3.0 && mode == 2.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 4.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 5.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 6.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 7.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") == 8.0 && mode == 2.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().getDouble("cnt3") > 12.0) {
                        entity.getPersistentData().putDouble("cnt2", 1.0);
                        entity.getPersistentData().putDouble("cnt3", 0.0);
                        entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
                        break;
                     }

                     if (!(entity.getPersistentData().getDouble("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var69 = _level.getServer().getCommands();
                           CommandSourceStack var72 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                           CompoundTag var75 = entity.getPersistentData();
                           var69.performPrefixedCommand(var72, "summon gaigegaigekaigecraft:cursed_spirit_grade_0" + Math.round(var75.getDouble("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().putDouble("cnt2", 1.0);
                     entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                  }
               }

               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                  if (entity != entityiterator && entityiterator.getPersistentData().getBoolean("CursedSpirit") && entityiterator.getPersistentData().getDouble("friend_num") == 0.0) {
                     getEntity = entityiterator;
                     break;
                  }
               }

               if (getEntity instanceof LivingEntity) {
                  Name = getEntity.getDisplayName().getString().equals("") ? "No Name" : getEntity.getDisplayName().getString();
                  y_pos = 64.0 + Math.random() * 64.0;
                  NUM1 = 0.0;

                  for(int index4 = 0; index4 < 10000; ++index4) {
                     ++NUM1;
                     STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                     if (entity.getPersistentData().getDouble(STR1) == 0.0) {
                        break;
                     }

                     if (entity.getPersistentData().getString(STR1 + "_name").equals(Name)) {
                        y_pos = entity.getPersistentData().getDouble(STR1);
                        break;
                     }
                  }

                  entity.getPersistentData().putDouble(STR1, y_pos);
                  entity.getPersistentData().putString(STR1 + "_name", Name);
                  getEntity.getPersistentData().putString("owner_name_data", entity.getDisplayName().getString());
                  getEntity.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                  getEntity.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  getEntity.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                  if (!getEntity.level().isClientSide() && getEntity.getServer() != null) {
                     getEntity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, getEntity.position(), getEntity.getRotationVector(), getEntity.level() instanceof ServerLevel ? (ServerLevel)getEntity.level() : null, 4, getEntity.getName().getString(), getEntity.getDisplayName(), getEntity.level().getServer(), getEntity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                  }

                  if (!getEntity.level().isClientSide() && getEntity.getServer() != null) {
                     getEntity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, getEntity.position(), getEntity.getRotationVector(), getEntity.level() instanceof ServerLevel ? (ServerLevel)getEntity.level() : null, 4, getEntity.getName().getString(), getEntity.getDisplayName(), getEntity.level().getServer(), getEntity), "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run tp @s 0 " + y_pos + " 0");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _origLevel = (ServerLevel)world;
                     LevelAccessor var42 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
                     if (var42 != null) {
                        entity.getPersistentData().putDouble(STR1 + "_num", 0.0);
                        _center = new Vec3(0.0, y_pos, 0.0);

                        for(Entity entityiterator : var42.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                           if (entity != entityiterator && Name.equals(entityiterator.getDisplayName().getString()) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                              entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                           }
                        }
                     }

                     world = world;
                  }

                  boolean _setval = true;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.noChangeTechnique = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         } else {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
