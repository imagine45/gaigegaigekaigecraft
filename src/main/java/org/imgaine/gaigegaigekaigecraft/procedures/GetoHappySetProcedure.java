package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         ItemStack ITEM1 = ItemStack.f_41583_;
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
         if (entity instanceof Player && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add 0 0 0 0");
               }

               if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }
            } else {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.m_20205_());
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
               mode = entity.getPersistentData().m_128459_("skill") - 1816.0;
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt4") == 0.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().m_128459_("cnt3") == 6.0 && mode == 2.0) {
                        loop_num = 20.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 8.0 && mode == 1.0) {
                        loop_num = 8.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 10.0 && mode == 1.0) {
                        loop_num = 8.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 11.0 && mode == 2.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") != 12.0 || mode != 1.0 && mode != 3.0) {
                        if (entity.getPersistentData().m_128459_("cnt3") != 13.0 || mode != 1.0 && mode != 2.0) {
                           if (entity.getPersistentData().m_128459_("cnt3") == 14.0 && mode == 2.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().m_128459_("cnt3") == 15.0 && mode == 3.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().m_128459_("cnt3") == 17.0 && mode == 1.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().m_128459_("cnt3") == 18.0 && mode == 2.0) {
                              loop_num = 20.0;
                           } else if (entity.getPersistentData().m_128459_("cnt3") > 18.0) {
                              entity.getPersistentData().m_128347_("cnt2", 1.0);
                              entity.getPersistentData().m_128347_("cnt3", 0.0);
                              entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
                              break;
                           }
                        } else {
                           loop_num = 8.0;
                        }
                     } else {
                        loop_num = 4.0;
                     }

                     if (!(entity.getPersistentData().m_128459_("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var10000 = _level.m_7654_().m_129892_();
                           CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                           CompoundTag var10002 = entity.getPersistentData();
                           var10000.m_230957_(var10001, "summon jujutsucraft:cursed_spirit_grade_3" + Math.round(var10002.m_128459_("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                     entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") == 1.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().m_128459_("cnt3") == 3.0 && mode == 1.0) {
                        loop_num = 2.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 4.0 && mode == 1.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 5.0 && mode == 3.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 9.0 && mode == 2.0) {
                        loop_num = 4.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 10.0 && mode == 3.0) {
                        loop_num = 2.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 11.0 && mode == 2.0) {
                        loop_num = 2.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") != 12.0 || mode != 1.0 && mode != 2.0 && mode != 3.0) {
                        if (entity.getPersistentData().m_128459_("cnt3") > 12.0) {
                           entity.getPersistentData().m_128347_("cnt2", 1.0);
                           entity.getPersistentData().m_128347_("cnt3", 0.0);
                           entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
                           break;
                        }
                     } else {
                        loop_num = 4.0;
                     }

                     if (!(entity.getPersistentData().m_128459_("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var67 = _level.m_7654_().m_129892_();
                           CommandSourceStack var70 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                           CompoundTag var73 = entity.getPersistentData();
                           var67.m_230957_(var70, "summon jujutsucraft:cursed_spirit_grade_2" + Math.round(var73.m_128459_("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                     entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") == 2.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().m_128459_("cnt3") != 1.0 || mode != 1.0 && mode != 2.0) {
                        if (entity.getPersistentData().m_128459_("cnt3") == 2.0 && mode == 2.0) {
                           loop_num = 1.0;
                        } else if (entity.getPersistentData().m_128459_("cnt3") == 3.0 && mode == 1.0) {
                           loop_num = 1.0;
                        } else if (entity.getPersistentData().m_128459_("cnt3") != 5.0 || mode != 1.0 && mode != 2.0) {
                           if (entity.getPersistentData().m_128459_("cnt3") == 6.0 && mode == 3.0) {
                              loop_num = 1.0;
                           } else if (entity.getPersistentData().m_128459_("cnt3") == 8.0 && mode == 1.0) {
                              loop_num = 1.0;
                           } else if (entity.getPersistentData().m_128459_("cnt3") == 9.0 && mode == 1.0) {
                              loop_num = 1.0;
                           } else if (entity.getPersistentData().m_128459_("cnt3") > 12.0) {
                              entity.getPersistentData().m_128347_("cnt2", 1.0);
                              entity.getPersistentData().m_128347_("cnt3", 0.0);
                              entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
                              break;
                           }
                        } else {
                           loop_num = 1.0;
                        }
                     } else {
                        loop_num = 1.0;
                     }

                     if (!(entity.getPersistentData().m_128459_("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var68 = _level.m_7654_().m_129892_();
                           CommandSourceStack var71 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                           CompoundTag var74 = entity.getPersistentData();
                           var68.m_230957_(var71, "summon jujutsucraft:cursed_spirit_grade_1" + Math.round(var74.m_128459_("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                     entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") == 3.0) {
                  while(true) {
                     loop_num = 0.0;
                     if (entity.getPersistentData().m_128459_("cnt3") == 3.0 && mode == 2.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 4.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 5.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 6.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 7.0 && mode == 3.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") == 8.0 && mode == 2.0) {
                        loop_num = 1.0;
                     } else if (entity.getPersistentData().m_128459_("cnt3") > 12.0) {
                        entity.getPersistentData().m_128347_("cnt2", 1.0);
                        entity.getPersistentData().m_128347_("cnt3", 0.0);
                        entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
                        break;
                     }

                     if (!(entity.getPersistentData().m_128459_("cnt2") > loop_num)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Commands var69 = _level.m_7654_().m_129892_();
                           CommandSourceStack var72 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                           CompoundTag var75 = entity.getPersistentData();
                           var69.m_230957_(var72, "summon jujutsucraft:cursed_spirit_grade_0" + Math.round(var75.m_128459_("cnt3")));
                        }
                        break;
                     }

                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                     entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                  }
               }

               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entityiterator.getPersistentData().m_128459_("friend_num") == 0.0) {
                     getEntity = entityiterator;
                     break;
                  }
               }

               if (getEntity instanceof LivingEntity) {
                  Name = getEntity.m_5446_().getString().equals("") ? "No Name" : getEntity.m_5446_().getString();
                  y_pos = 64.0 + Math.random() * 64.0;
                  NUM1 = 0.0;

                  for(int index4 = 0; index4 < 10000; ++index4) {
                     ++NUM1;
                     STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                     if (entity.getPersistentData().m_128459_(STR1) == 0.0) {
                        break;
                     }

                     if (entity.getPersistentData().m_128461_(STR1 + "_name").equals(Name)) {
                        y_pos = entity.getPersistentData().m_128459_(STR1);
                        break;
                     }
                  }

                  entity.getPersistentData().m_128347_(STR1, y_pos);
                  entity.getPersistentData().m_128359_(STR1 + "_name", Name);
                  getEntity.getPersistentData().m_128359_("owner_name_data", entity.m_5446_().getString());
                  getEntity.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  getEntity.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  getEntity.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                  if (!getEntity.m_9236_().m_5776_() && getEntity.m_20194_() != null) {
                     getEntity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, getEntity.m_20182_(), getEntity.m_20155_(), getEntity.m_9236_() instanceof ServerLevel ? (ServerLevel)getEntity.m_9236_() : null, 4, getEntity.m_7755_().getString(), getEntity.m_5446_(), getEntity.m_9236_().m_7654_(), getEntity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                  }

                  if (!getEntity.m_9236_().m_5776_() && getEntity.m_20194_() != null) {
                     getEntity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, getEntity.m_20182_(), getEntity.m_20155_(), getEntity.m_9236_() instanceof ServerLevel ? (ServerLevel)getEntity.m_9236_() : null, 4, getEntity.m_7755_().getString(), getEntity.m_5446_(), getEntity.m_9236_().m_7654_(), getEntity), "execute in jujutsucraft:cursed_spirit_manipulation_dimension run tp @s 0 " + y_pos + " 0");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _origLevel = (ServerLevel)world;
                     LevelAccessor var42 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                     if (var42 != null) {
                        entity.getPersistentData().m_128347_(STR1 + "_num", 0.0);
                        Vec3 _center = new Vec3(0.0, y_pos, 0.0);

                        for(Entity entityiterator : var42.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entity != entityiterator && Name.equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                              entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR1 + "_num") + 1.0);
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
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         } else {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
