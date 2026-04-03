package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade01Entity;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RoundDeerEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVesselEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SixEyesOnEffectActiveTickProcedure {
   public SixEyesOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String color_name = "";
         ItemStack item_inside = ItemStack.EMPTY;
         boolean logic_a = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double distance = 0.0;
         double level_strength = 0.0;
         double color = 0.0;
         double num_loop = 0.0;
         double speed = 0.0;
         double amount = 0.0;
         double CT1 = 0.0;
         double CT2 = 0.0;
         double dis = 0.0;
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 219, 0, false, false));
               }
            }

            if (entity instanceof Player) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (!var10000.is(ItemTags.create(new ResourceLocation("forge:blindfold")))) {
                  if (Math.random() < 0.25) {
                     Vec3 _center = new Vec3(x, y, z);
                     List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true);
                     Iterator var39 = _entfound.iterator();

                     while(true) {
                        Entity entityiterator;
                        while(true) {
                           if (!var39.hasNext()) {
                              return;
                           }

                           entityiterator = (Entity)var39.next();
                           if (entity != entityiterator) {
                              int var88;
                              label345: {
                                 color = 0.0;
                                 amount = 1.0;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                                    if (_livEnt6.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       label341: {
                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entityiterator;
                                             if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                var88 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                break label341;
                                             }
                                          }

                                          var88 = 0;
                                       }

                                       ++var88;
                                       break label345;
                                    }
                                 }

                                 var88 = 0;
                              }

                              level_strength = (double)var88;
                              CT1 = ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                              CT2 = ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt8 = (LivingEntity)entityiterator;
                                 if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    color = 2.0;
                                    amount = 4.0;
                                    break;
                                 }
                              }

                              label441: {
                                 if (entityiterator instanceof Player) {
                                    if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0.0) {
                                       break label441;
                                    }
                                 } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                                    break label441;
                                 }

                                 if (entityiterator instanceof ItemEntity) {
                                    if (entityiterator instanceof ItemEntity) {
                                       ItemEntity _itemEnt = (ItemEntity)entityiterator;
                                       var10000 = _itemEnt.getItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    if (!var10000.is(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                                       break label441;
                                    }
                                 }

                                 label442: {
                                    if (entityiterator instanceof Player) {
                                       if (CT1 == 5.0 || CT2 == 5.0) {
                                          break label442;
                                       }
                                    } else if (entityiterator instanceof OkkotsuYutaEntity || entityiterator instanceof RikaEntity || entityiterator instanceof OkkotsuYutaCullingGameEntity || entityiterator instanceof Rika2Entity) {
                                       break label442;
                                    }

                                    label444: {
                                       if (entityiterator instanceof Player) {
                                          if (CT1 == 7.0 || CT2 == 7.0) {
                                             break label444;
                                          }
                                       } else if (entityiterator instanceof KashimoHajimeEntity || entityiterator instanceof NueEntity || entityiterator instanceof MergedBeastAgitoEntity) {
                                          break label444;
                                       }

                                       label376: {
                                          if (entityiterator instanceof Player) {
                                             if (CT1 == 4.0 || CT2 == 4.0 || CT1 == 15.0 || CT2 == 15.0 || CT1 == 43.0 || CT2 == 43.0) {
                                                break label376;
                                             }
                                          } else if (entityiterator instanceof RozetsuEntity || entityiterator instanceof RozetsuShikigamiEntity || entityiterator instanceof RozetsuShikigamiVessel2Entity || entityiterator instanceof RozetsuShikigamiVesselEntity || entityiterator instanceof JogoEntity || entityiterator instanceof MahitoEntity) {
                                             break label376;
                                          }

                                          if (entityiterator instanceof CursedSpiritGrade01Entity) {
                                             color = 2.0;
                                          } else if (entityiterator instanceof RoundDeerEntity) {
                                             color = 4.0;
                                          }
                                          break;
                                       }

                                       color = 5.0;
                                       break;
                                    }

                                    color = 3.0;
                                    break;
                                 }

                                 color = 1.0;
                                 amount = 2.0;
                                 break;
                              }

                              color = -1.0;
                              amount = 0.0;
                              break;
                           }
                        }

                        if (amount > 0.0) {
                           num_loop = (double)Math.max(Math.round(level_strength / 16.0), 1L) * amount;
                           item_inside = ReturnInsideItemProcedure.execute(entityiterator).copy();

                           for(int index0 = 0; index0 < (int)Math.max(num_loop, 1.0); ++index0) {
                              x_pos = entityiterator.getX() + (double)entityiterator.getBbWidth() * (Math.random() - 0.5);
                              y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * Math.random();
                              z_pos = entityiterator.getZ() + (double)entityiterator.getBbWidth() * (Math.random() - 0.5);
                              speed = level_strength / 64.0 * amount * Math.random();
                              if (color == 1.0) {
                                 color_name = "gaigegaigekaigecraft:particle_curse_power_red";
                              } else if (color == 2.0) {
                                 color_name = "gaigegaigekaigecraft:particle_curse_power_orange";
                              } else if (color == 3.0) {
                                 color_name = "gaigegaigekaigecraft:particle_thunder_blue";
                                 if (entityiterator instanceof MergedBeastAgitoEntity) {
                                    if (Math.random() < 0.2) {
                                       color_name = "gaigegaigekaigecraft:particle_curse_power_blue";
                                    }

                                    if (Math.random() < 0.2) {
                                       color_name = "minecraft:happy_villager";
                                    }
                                 }
                              } else if (color == 4.0) {
                                 color_name = "minecraft:happy_villager";
                              } else if (color == 5.0) {
                                 color_name = "gaigegaigekaigecraft:particle_curse_power_purple";
                              } else {
                                 color_name = "gaigegaigekaigecraft:particle_curse_power_blue";
                              }

                              if (item_inside.getItem() == JujutsucraftModItems.SUKUNA_FINGER.get() && Math.random() < 0.1) {
                                 color_name = "gaigegaigekaigecraft:particle_curse_power_orange";
                              }

                              if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting"))) && Math.random() < 0.1) {
                                 color_name = "gaigegaigekaigecraft:particle_blood_red";
                              }

                              if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique"))) && Math.random() < 0.1) {
                                 color_name = "minecraft:squid_ink";
                              }

                              if (!entity.level().isClientSide() && entity.getServer() != null) {
                                 entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle " + color_name + " " + x_pos + " " + y_pos + " " + z_pos + " 0.1 0.1 0.1 " + speed + " 2 normal @s");
                              }
                           }
                        }
                     }
                  } else {
                     for(int index1 = 0; index1 < 8; ++index1) {
                        distance += 2.0;
                        x_pos = entity.getX() + entity.getLookAngle().x * distance;
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getLookAngle().y * distance;
                        z_pos = entity.getZ() + entity.getLookAngle().z * distance;
                        logic_a = false;
                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(2.0), (e) -> true)) {
                           if (entityiterator != entity && (entityiterator == (Entity)world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 4.0, 4.0, 4.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((LivingEntity)null) || entityiterator == (Entity)world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 4.0, 4.0, 4.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((ItemEntity) null))) {
                              logic_a = true;
                              entity.getPersistentData().putBoolean("flag_sixEyes", true);
                              if (!entity.getPersistentData().getString("DataNameOld").equals(entityiterator.getStringUUID())) {
                                 entity.getPersistentData().putString("DataNameOld", entityiterator.getStringUUID());
                                 entity.getPersistentData().putDouble("cnt_sixEyes", 0.0);
                              }

                              entity.getPersistentData().putString("DataSixEyes1", entityiterator.getDisplayName().getString());
                              CompoundTag var90 = entity.getPersistentData();
                              String var99;
                              if (entityiterator instanceof LivingEntity) {
                                 float var10002;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10002 = _livEnt.getHealth();
                                 } else {
                                    var10002 = -1.0F;
                                 }

                                 int var98 = Math.round(var10002);
                                 float var10003;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10003 = _livEnt.getMaxHealth();
                                 } else {
                                    var10003 = -1.0F;
                                 }

                                 var99 = "Health: " + var98 + "/" + Math.round(var10003);
                              } else {
                                 var99 = "";
                              }

                              var90.putString("DataSixEyes2", var99);
                              var90 = entity.getPersistentData();
                              ItemStack var100;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var100 = _livEnt.getMainHandItem();
                              } else {
                                 var100 = ItemStack.EMPTY;
                              }

                              String var101;
                              if (var100.getItem() == ItemStack.EMPTY.getItem()) {
                                 var101 = "";
                              } else {
                                 ItemStack var102;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var102 = _livEnt.getMainHandItem();
                                 } else {
                                    var102 = ItemStack.EMPTY;
                                 }

                                 var101 = "Main Hand: " + var102.getDisplayName().getString();
                              }

                              var90.putString("DataSixEyes4", var101);
                              var90 = entity.getPersistentData();
                              ItemStack var103;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var103 = _livEnt.getOffhandItem();
                              } else {
                                 var103 = ItemStack.EMPTY;
                              }

                              String var104;
                              if (var103.getItem() == ItemStack.EMPTY.getItem()) {
                                 var104 = "";
                              } else {
                                 ItemStack var105;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var105 = _livEnt.getOffhandItem();
                                 } else {
                                    var105 = ItemStack.EMPTY;
                                 }

                                 var104 = "Off Hand: " + var105.getDisplayName().getString();
                              }

                              var90.putString("DataSixEyes5", var104);
                              num_loop = 0.0;

                              for(int index2 = 0; index2 < 4; ++index2) {
                                 var90 = entity.getPersistentData();
                                 String var10001 = "DataSixEyes" + Math.round(num_loop + 6.0);
                                 ItemStack var106;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                    var106 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(Type.ARMOR, (int)(3.0 - num_loop)));
                                 } else {
                                    var106 = ItemStack.EMPTY;
                                 }

                                 String var107;
                                 if (var106.getItem() == ItemStack.EMPTY.getItem()) {
                                    var107 = "";
                                 } else {
                                    long var108 = Math.round(num_loop + 1.0);
                                    ItemStack var112;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                       var112 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(Type.ARMOR, (int)(3.0 - num_loop)));
                                    } else {
                                       var112 = ItemStack.EMPTY;
                                    }

                                    var107 = "Armor" + var108 + ": " + var112.getDisplayName().getString();
                                 }

                                 var90.putString(var10001, var107);
                                 ++num_loop;
                              }

                              ItemStack var94;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var94 = _livEnt.getMainHandItem();
                              } else {
                                 var94 = ItemStack.EMPTY;
                              }

                              if (var94.getItem() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                                 CompoundTag var95 = entity.getPersistentData();
                                 CompoundTag var109 = entity.getPersistentData();
                                 var95.putString("DataSixEyes4", "§c" + var109.getString("DataSixEyes4"));
                              }

                              entity.getPersistentData().putString("DataSixEyes10", "");
                              if (entityiterator instanceof DivineDogTotalityEntity) {
                                 CompoundTag var96 = entity.getPersistentData();
                                 var104 = Component.translatable("entity.gaigegaigekaigecraft.divine_dog_white").getString();
                                 var96.putString("DataSixEyes10", "§7" + var104 + ", " + Component.translatable("entity.gaigegaigekaigecraft.divine_dog_black").getString());
                              } else if (entityiterator instanceof MergedBeastAgitoEntity) {
                                 CompoundTag var97 = entity.getPersistentData();
                                 var104 = Component.translatable("entity.gaigegaigekaigecraft.nue").getString();
                                 var97.putString("DataSixEyes10", "§7" + var104 + ", " + Component.translatable("entity.gaigegaigekaigecraft.great_serpent").getString() + ", " + Component.translatable("entity.gaigegaigekaigecraft.round_deer").getString() + ", " + Component.translatable("entity.gaigegaigekaigecraft.tiger_funeral").getString());
                              }

                              if (entityiterator instanceof SukunaEntity) {
                                 entity.getPersistentData().putString("DataSixEyes10", "§7" + Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_itadori1").getString());
                              } else if (entityiterator instanceof SukunaFushiguroEntity || entityiterator instanceof SukunaPerfectEntity) {
                                 entity.getPersistentData().putString("DataSixEyes10", "§7" + Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_megumi_fushiguro1").getString());
                              }
                              break;
                           }
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     if (entity.getPersistentData().getBoolean("flag_sixEyes")) {
                        entity.getPersistentData().putDouble("cnt_sixEyes", Math.max(entity.getPersistentData().getDouble("cnt_sixEyes"), 0.0) + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_sixEyes") > 3.0) {
                           entity.getPersistentData().putBoolean("flag_sixEyes", false);
                        } else {
                           num_loop = 0.0;

                           for(int index3 = 0; index3 < 11; ++index3) {
                              if (!entity.getPersistentData().getString("DataSixEyes" + Math.round(num_loop)).contains("§k")) {
                                 entity.getPersistentData().putString("DataSixEyes" + Math.round(num_loop), "§k" + entity.getPersistentData().getString("DataSixEyes" + Math.round(num_loop)));
                              }

                              ++num_loop;
                           }
                        }
                     } else {
                        entity.getPersistentData().putDouble("cnt_sixEyes", Math.min(entity.getPersistentData().getDouble("cnt_sixEyes"), 0.0) - 1.0);
                        if (entity.getPersistentData().getDouble("cnt_sixEyes") < -15.0) {
                           num_loop = 0.0;
                           entity.getPersistentData().putString("DataNameOld", "");

                           for(int index4 = 0; index4 < 11; ++index4) {
                              entity.getPersistentData().putString("DataSixEyes" + Math.round(num_loop), "");
                              ++num_loop;
                           }
                        } else if (entity.getPersistentData().getDouble("cnt_sixEyes") < -12.0) {
                           num_loop = 0.0;

                           for(int index5 = 0; index5 < 11; ++index5) {
                              if (!entity.getPersistentData().getString("DataSixEyes" + Math.round(num_loop)).contains("§k")) {
                                 entity.getPersistentData().putString("DataSixEyes" + Math.round(num_loop), "§k" + entity.getPersistentData().getString("DataSixEyes" + Math.round(num_loop)));
                              }

                              ++num_loop;
                           }
                        }
                     }
                  }
               } else {
                  num_loop = 0.0;
                  if (!entity.getPersistentData().getString("DataNameOld").equals("")) {
                     entity.getPersistentData().putString("DataNameOld", "");

                     for(int index6 = 0; index6 < 11; ++index6) {
                        entity.getPersistentData().putString("DataSixEyes" + Math.round(num_loop), "");
                        ++num_loop;
                     }
                  }
               }
            }
         }

      }
   }
}
