package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Test2Procedure {
   public Test2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean logic_b = false;
         boolean logic_a = false;
         double SpawnedStrength = 0.0;
         double NUM2 = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double spawn_z = 0.0;
         double yaw = 0.0;
         double spawn_x = 0.0;
         double NUM1 = 0.0;
         double spawn_y = 0.0;
         double level_strength = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double level_strength2 = 0.0;
         String STR2 = "";
         String STR1 = "";
         String DimensionID = "";
         if (entity.getPersistentData().m_128459_("data_cursed_spirit_manipulation1") != 0.0 && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") > 0.0) {
               entity.getPersistentData().m_128347_("cnt1", 0.0);
               if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               x_pos = 0.0;
               z_pos = 0.0;
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  Commands var10000 = entity.m_20194_().m_129892_();
                  CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                  long var10002 = Math.round(x_pos);
                  var10000.m_230957_(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
               }

               DimensionID = ("" + String.valueOf(entity.m_9236_().m_46472_())).replace("ResourceKey[minecraft:dimension / ", "").replace("]", "");
               Player = entity instanceof Player;
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               NUM1 = 0.0;
               entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 45.0));
               entity.m_146926_((float)Math.min(pitch, 0.0));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (entity.m_6144_()) {
                  spawn_x = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                  spawn_y = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  spawn_z = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               } else {
                  spawn_x = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(5.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                  spawn_y = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(5.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  spawn_z = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(5.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               }

               for(int index0 = 0; index0 < 10000; ++index0) {
                  ++NUM1;
                  STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                  SpawnedStrength = 0.0;
                  if (entity.getPersistentData().m_128459_(STR1) == 0.0) {
                     break;
                  }

                  String var83 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                  String var91 = entity.getPersistentData().m_128461_(STR1 + "_name");
                  if (var83.equals(var91 + " ×" + Math.round(entity.getPersistentData().m_128459_(STR1 + "_num")))) {
                     label212: {
                        y_pos = entity.getPersistentData().m_128459_(STR1);
                        logic_a = false;
                        logic_b = false;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt28 = (LivingEntity)entity;
                           if (_livEnt28.m_21023_(MobEffects.f_19600_)) {
                              label207: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var85 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label207;
                                    }
                                 }

                                 var85 = 0;
                              }

                              ++var85;
                              break label212;
                           }
                        }

                        var85 = 0;
                     }

                     level_strength = (double)var85;
                     if (world instanceof ServerLevel) {
                        ServerLevel _origLevel = (ServerLevel)world;
                        LevelAccessor var50 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                        if (var50 != null) {
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : var50.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                              if (entity != entityiterator && entity.getPersistentData().m_128461_(STR1 + "_name").equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                                 if (!logic_a) {
                                    logic_a = true;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity36 = (LivingEntity)entity;
                                       if (_livingEntity36.m_21204_().m_22171_(Attributes.f_22281_)) {
                                          label188: {
                                             if (entityiterator instanceof LivingEntity) {
                                                LivingEntity _livEnt37 = (LivingEntity)entityiterator;
                                                if (_livEnt37.m_21023_(MobEffects.f_19600_)) {
                                                   label184: {
                                                      if (entityiterator instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                         if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                            var87 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                            break label184;
                                                         }
                                                      }

                                                      var87 = 0;
                                                   }

                                                   ++var87;
                                                   break label188;
                                                }
                                             }

                                             var87 = 0;
                                          }

                                          level_strength2 = (double)var87;
                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livingEntity40 = (LivingEntity)entityiterator;
                                             if (_livingEntity40.m_21204_().m_22171_(Attributes.f_22281_)) {
                                                label176: {
                                                   var88 = _livingEntity40.getAttribute_(Attributes.f_22281_);
                                                   if (entityiterator instanceof LivingEntity) {
                                                      LivingEntity _livingEntity39 = (LivingEntity)entityiterator;
                                                      if (_livingEntity39.m_21204_().m_22171_(Attributes.f_22281_)) {
                                                         var92 = _livingEntity39.getAttribute_(Attributes.f_22281_).m_22115_();
                                                         break label176;
                                                      }
                                                   }

                                                   var92 = 0.0;
                                                }

                                                var88.m_22100_(Math.max(var92, level_strength * 3.0 * 0.5 * ((Math.max(level_strength * 3.0, 1.0) - Math.max(level_strength2 * 3.0, 1.0)) / Math.max(level_strength * 3.0, 1.0))));
                                             }
                                          }
                                       }
                                    }

                                    label171: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var89 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label171;
                                          }
                                       }

                                       var89 = 0;
                                    }

                                    if (var89 >= 8) {
                                       entity.getPersistentData().m_128347_("cnt1", -5.0);
                                    }

                                    entityiterator.getPersistentData().m_128347_("cnt_target", 0.0);
                                    entityiterator.getPersistentData().m_128347_("modement_mode", 0.0);
                                    entityiterator.getPersistentData().m_128347_("cnt_settarget", 0.0);
                                    entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                                    entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                                    entityiterator.getPersistentData().m_128379_("Player", Player);
                                    entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                                    entityiterator.getPersistentData().m_128359_("TARGET_UUID", "");
                                    entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                                    entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "data merge entity @s {Invulnerable:0b,NoAI:0b}");
                                    }

                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "execute in " + DimensionID + " run tp @s " + spawn_x + " " + spawn_y + " " + spawn_z);
                                    }

                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "execute in " + DimensionID + " run particle squid_ink " + spawn_x + " " + spawn_y + " " + spawn_z + " 0.5 0.5 0.5 0 25 normal");
                                    }

                                    entityiterator.m_146922_((float)yaw);
                                    entityiterator.m_146926_((float)pitch);
                                    entityiterator.m_5618_(entityiterator.m_146908_());
                                    entityiterator.m_5616_(entityiterator.m_146908_());
                                    entityiterator.f_19859_ = entityiterator.m_146908_();
                                    entityiterator.f_19860_ = entityiterator.m_146909_();
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       _entity.f_20884_ = _entity.m_146908_();
                                       _entity.f_20886_ = _entity.m_146908_();
                                    }

                                    label159: {
                                       entityiterator.m_20256_(new Vec3(0.0, 0.0, 0.0));
                                       entity.getPersistentData().m_128347_(STR1 + "_num", 0.0);
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var90 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label159;
                                          }
                                       }

                                       var90 = 0.0;
                                    }

                                    SpawnedStrength = var90;
                                 } else {
                                    entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR1 + "_num") + 1.0);
                                 }
                              }
                           }
                        }

                        world = world;
                     }

                     if (entity.getPersistentData().m_128459_(STR1 + "_num") == 0.0) {
                        NUM2 = NUM1;

                        for(int index1 = 0; index1 < 10000; ++index1) {
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM2);
                           STR2 = "data_cursed_spirit_manipulation" + Math.round(NUM2 + 1.0);
                           entity.getPersistentData().m_128347_(STR1, entity.getPersistentData().m_128459_(STR2));
                           entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR2 + "_num"));
                           entity.getPersistentData().m_128359_(STR1 + "_name", entity.getPersistentData().m_128461_(STR2 + "_name"));
                           if (entity.getPersistentData().m_128459_(STR2) == 0.0) {
                              break;
                           }

                           ++NUM2;
                        }

                        entity.getPersistentData().m_128347_("skill", 0.0);
                     }

                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - Math.max(SpawnedStrength * 5.0, 5.0);
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     break;
                  }
               }

               entity.m_146922_((float)yaw);
               entity.m_146926_((float)pitch);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            }
         } else {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

         if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
