package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SixEyesOnEffectActiveTickProcedure {
   public SixEyesOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         String color_name = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double distance = 0.0;
         double level_strength = 0.0;
         double color = 0.0;
         double num_loop = 0.0;
         double speed = 0.0;
         double amount = 0.0;
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 219, 0, false, false));
               }
            }

            if (entity instanceof Player) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (!var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:blindfold")))) {
                  if (Math.random() < 0.5) {
                     Vec3 _center = new Vec3(x, y, z);
                     List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(16.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList();
                     Iterator var31 = _entfound.iterator();

                     while(true) {
                        Entity entityiterator;
                        while(true) {
                           if (!var31.hasNext()) {
                              return;
                           }

                           entityiterator = (Entity)var31.next();
                           if (entity != entityiterator) {
                              label345: {
                                 color = 0.0;
                                 amount = 1.0;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                                    if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                                       label341: {
                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entityiterator;
                                             if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                var77 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                break label341;
                                             }
                                          }

                                          var77 = 0;
                                       }

                                       ++var77;
                                       break label345;
                                    }
                                 }

                                 var77 = 0;
                              }

                              level_strength = (double)var77;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt8 = (LivingEntity)entityiterator;
                                 if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
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
                                 } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                                    break label441;
                                 }

                                 if (entityiterator instanceof ItemEntity) {
                                    if (entityiterator instanceof ItemEntity) {
                                       ItemEntity _itemEnt = (ItemEntity)entityiterator;
                                       var10000 = _itemEnt.m_32055_();
                                    } else {
                                       var10000 = ItemStack.f_41583_;
                                    }

                                    if (!var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                                       break label441;
                                    }
                                 }

                                 label442: {
                                    if (entityiterator instanceof Player) {
                                       if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5.0) {
                                          break label442;
                                       }
                                    } else if (entityiterator instanceof OkkotsuYutaEntity || entityiterator instanceof RikaEntity || entityiterator instanceof OkkotsuYutaCullingGameEntity || entityiterator instanceof Rika2Entity) {
                                       break label442;
                                    }

                                    label444: {
                                       if (entityiterator instanceof Player) {
                                          if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7.0) {
                                             break label444;
                                          }
                                       } else if (entityiterator instanceof KashimoHajimeEntity || entityiterator instanceof NueEntity || entityiterator instanceof MergedBeastAgitoEntity) {
                                          break label444;
                                       }

                                       label376: {
                                          if (entityiterator instanceof Player) {
                                             if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 4.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 4.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 15.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 43.0 || ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 43.0) {
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

                           for(int index0 = 0; index0 < (int)Math.max(num_loop, 1.0); ++index0) {
                              x_pos = entityiterator.m_20185_() + (double)entityiterator.m_20205_() * (Math.random() - 0.5);
                              y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * Math.random();
                              z_pos = entityiterator.m_20189_() + (double)entityiterator.m_20205_() * (Math.random() - 0.5);
                              speed = level_strength / 64.0 * amount * Math.random();
                              if (color == 1.0) {
                                 color_name = "jujutsucraft:particle_curse_power_red";
                              } else if (color == 2.0) {
                                 color_name = "jujutsucraft:particle_curse_power_orange";
                              } else if (color == 3.0) {
                                 color_name = "jujutsucraft:particle_thunder_blue";
                                 if (entityiterator instanceof MergedBeastAgitoEntity) {
                                    if (Math.random() < 0.2) {
                                       color_name = "jujutsucraft:particle_curse_power_blue";
                                    }

                                    if (Math.random() < 0.2) {
                                       color_name = "minecraft:happy_villager";
                                    }
                                 }
                              } else if (color == 4.0) {
                                 color_name = "minecraft:happy_villager";
                              } else if (color == 5.0) {
                                 color_name = "jujutsucraft:particle_curse_power_purple";
                              } else {
                                 color_name = "jujutsucraft:particle_curse_power_blue";
                              }

                              if (ReturnInsideItemProcedure.execute(entityiterator).m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get() && Math.random() < 0.1) {
                                 color_name = "jujutsucraft:particle_curse_power_orange";
                              }

                              if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))) && Math.random() < 0.1) {
                                 color_name = "jujutsucraft:particle_blood_red";
                              }

                              if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && Math.random() < 0.1) {
                                 color_name = "minecraft:squid_ink";
                              }

                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle " + color_name + " " + x_pos + " " + y_pos + " " + z_pos + " 0.1 0.1 0.1 " + speed + " 1 normal @s");
                              }
                           }
                        }
                     }
                  } else {
                     for(int index1 = 0; index1 < 8; ++index1) {
                        distance += 2.0;
                        x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
                        y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
                        z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
                        logic_a = false;
                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entityiterator != entity && (entityiterator == (Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), 4.0, 4.0, 4.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                              }
                           })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((Object)null) || entityiterator == (Entity)world.m_6443_(ItemEntity.class, AABB.m_165882_(new Vec3(x_pos, y_pos, z_pos), 4.0, 4.0, 4.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                              }
                           })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((Object)null))) {
                              logic_a = true;
                              entity.getPersistentData().m_128379_("flag_sixEyes", true);
                              if (!entity.getPersistentData().m_128461_("DataNameOld").equals(entityiterator.m_20149_())) {
                                 entity.getPersistentData().m_128359_("DataNameOld", entityiterator.m_20149_());
                                 entity.getPersistentData().m_128347_("cnt_sixEyes", 0.0);
                              }

                              entity.getPersistentData().m_128359_("DataSixEyes1", entityiterator.m_5446_().getString());
                              CompoundTag var79 = entity.getPersistentData();
                              String var88;
                              if (entityiterator instanceof LivingEntity) {
                                 float var10002;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10002 = _livEnt.m_21223_();
                                 } else {
                                    var10002 = -1.0F;
                                 }

                                 int var87 = Math.round(var10002);
                                 float var10003;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10003 = _livEnt.m_21233_();
                                 } else {
                                    var10003 = -1.0F;
                                 }

                                 var88 = "Health: " + var87 + "/" + Math.round(var10003);
                              } else {
                                 var88 = "";
                              }

                              var79.m_128359_("DataSixEyes2", var88);
                              var79 = entity.getPersistentData();
                              ItemStack var89;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var89 = _livEnt.m_21205_();
                              } else {
                                 var89 = ItemStack.f_41583_;
                              }

                              String var90;
                              if (var89.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                                 var90 = "";
                              } else {
                                 ItemStack var91;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var91 = _livEnt.m_21205_();
                                 } else {
                                    var91 = ItemStack.f_41583_;
                                 }

                                 var90 = "Main Hand: " + var91.m_41611_().getString();
                              }

                              var79.m_128359_("DataSixEyes4", var90);
                              var79 = entity.getPersistentData();
                              ItemStack var92;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var92 = _livEnt.m_21206_();
                              } else {
                                 var92 = ItemStack.f_41583_;
                              }

                              String var93;
                              if (var92.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                                 var93 = "";
                              } else {
                                 ItemStack var94;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var94 = _livEnt.m_21206_();
                                 } else {
                                    var94 = ItemStack.f_41583_;
                                 }

                                 var93 = "Off Hand: " + var94.m_41611_().getString();
                              }

                              var79.m_128359_("DataSixEyes5", var93);
                              num_loop = 0.0;

                              for(int index2 = 0; index2 < 4; ++index2) {
                                 var79 = entity.getPersistentData();
                                 String var10001 = "DataSixEyes" + Math.round(num_loop + 6.0);
                                 ItemStack var95;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                    var95 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)(3.0 - num_loop)));
                                 } else {
                                    var95 = ItemStack.f_41583_;
                                 }

                                 String var96;
                                 if (var95.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                                    var96 = "";
                                 } else {
                                    long var97 = Math.round(num_loop + 1.0);
                                    ItemStack var101;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                       var101 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)(3.0 - num_loop)));
                                    } else {
                                       var101 = ItemStack.f_41583_;
                                    }

                                    var96 = "Armor" + var97 + ": " + var101.m_41611_().getString();
                                 }

                                 var79.m_128359_(var10001, var96);
                                 ++num_loop;
                              }

                              ItemStack var83;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var83 = _livEnt.m_21205_();
                              } else {
                                 var83 = ItemStack.f_41583_;
                              }

                              if (var83.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                                 CompoundTag var84 = entity.getPersistentData();
                                 CompoundTag var98 = entity.getPersistentData();
                                 var84.m_128359_("DataSixEyes4", "§c" + var98.m_128461_("DataSixEyes4"));
                              }

                              entity.getPersistentData().m_128359_("DataSixEyes10", "");
                              if (entityiterator instanceof DivineDogTotalityEntity) {
                                 CompoundTag var85 = entity.getPersistentData();
                                 var93 = Component.m_237115_("entity.jujutsucraft.divine_dog_white").getString();
                                 var85.m_128359_("DataSixEyes10", "§7" + var93 + ", " + Component.m_237115_("entity.jujutsucraft.divine_dog_black").getString());
                              } else if (entityiterator instanceof MergedBeastAgitoEntity) {
                                 CompoundTag var86 = entity.getPersistentData();
                                 var93 = Component.m_237115_("entity.jujutsucraft.nue").getString();
                                 var86.m_128359_("DataSixEyes10", "§7" + var93 + ", " + Component.m_237115_("entity.jujutsucraft.great_serpent").getString() + ", " + Component.m_237115_("entity.jujutsucraft.round_deer").getString() + ", " + Component.m_237115_("entity.jujutsucraft.tiger_funeral").getString());
                              }

                              if (entityiterator instanceof SukunaEntity) {
                                 entity.getPersistentData().m_128359_("DataSixEyes10", "§7" + Component.m_237115_("item.jujutsucraft.itadori_yuji_paper").getString());
                              } else if (entityiterator instanceof SukunaFushiguroEntity || entityiterator instanceof SukunaPerfectEntity) {
                                 entity.getPersistentData().m_128359_("DataSixEyes10", "§7" + Component.m_237115_("gui.jujutsucraft.select_technique.button_megumi_fushiguro1").getString());
                              }
                              break;
                           }
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     if (entity.getPersistentData().m_128471_("flag_sixEyes")) {
                        entity.getPersistentData().m_128347_("cnt_sixEyes", Math.max(entity.getPersistentData().m_128459_("cnt_sixEyes"), 0.0) + 1.0);
                        if (entity.getPersistentData().m_128459_("cnt_sixEyes") > 3.0) {
                           entity.getPersistentData().m_128379_("flag_sixEyes", false);
                        } else {
                           num_loop = 0.0;

                           for(int index3 = 0; index3 < 11; ++index3) {
                              if (!entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)).contains("§k")) {
                                 entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "§k" + entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)));
                              }

                              ++num_loop;
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128347_("cnt_sixEyes", Math.min(entity.getPersistentData().m_128459_("cnt_sixEyes"), 0.0) - 1.0);
                        if (entity.getPersistentData().m_128459_("cnt_sixEyes") < -15.0) {
                           num_loop = 0.0;
                           entity.getPersistentData().m_128359_("DataNameOld", "");

                           for(int index4 = 0; index4 < 11; ++index4) {
                              entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "");
                              ++num_loop;
                           }
                        } else if (entity.getPersistentData().m_128459_("cnt_sixEyes") < -12.0) {
                           num_loop = 0.0;

                           for(int index5 = 0; index5 < 11; ++index5) {
                              if (!entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)).contains("§k")) {
                                 entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "§k" + entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)));
                              }

                              ++num_loop;
                           }
                        }
                     }
                  }
               } else {
                  num_loop = 0.0;
                  if (!entity.getPersistentData().m_128461_("DataNameOld").equals("")) {
                     entity.getPersistentData().m_128359_("DataNameOld", "");

                     for(int index6 = 0; index6 < 11; ++index6) {
                        entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "");
                        ++num_loop;
                     }
                  }
               }
            }
         }

      }
   }
}
