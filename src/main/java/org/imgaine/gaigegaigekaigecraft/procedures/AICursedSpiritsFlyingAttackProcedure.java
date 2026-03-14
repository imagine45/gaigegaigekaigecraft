package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AICursedSpiritsFlyingAttackProcedure {
   public AICursedSpiritsFlyingAttackProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double NUM1 = 0.0;
         String STR1 = "";
         Entity owner_entity = null;
         boolean logic_a = false;
         boolean ownerExist = false;
         boolean teleported = false;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            ownerExist = true;
            owner_entity = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         }

         if (entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")) && entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("modement_mode") == 0.0) {
               if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
                  entity.getPersistentData().m_128347_("cnt1", 0.0);
                  if (ownerExist && entity.getPersistentData().m_128459_("friend_num_worker") != 0.0 && entity.getPersistentData().m_128459_("friend_num_worker") == owner_entity.getPersistentData().m_128459_("friend_num") && entity.getPersistentData().m_128459_("friend_num_worker") != owner_entity.getPersistentData().m_128459_("friend_num_worker")) {
                     if (!(owner_entity instanceof Player) || !owner_entity.m_6144_()) {
                        LivingEntity var10000;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (!(var10000 instanceof LivingEntity) || !(owner_entity.getPersistentData().m_128459_("cnt_target") > 6.0)) {
                           return;
                        }
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:1b}");
                     }

                     entity.getPersistentData().m_128347_("modement_mode", 1.0);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_settarget", 0.0);
               if (entity.getPersistentData().m_128459_("cnt1") > 1.0) {
                  if (entity.getPersistentData().m_128459_("cnt1") > 2.0) {
                     yaw = (double)(entity.m_146908_() % 360.0F);
                     pitch = (double)entity.m_146909_();
                     RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * 10.0, entity);
                     entity.m_146922_(entity.m_146908_() % 360.0F);
                     entity.m_146926_(entity.m_146909_());
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     yaw_cal = (double)entity.m_146908_() - yaw;
                     yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0)) ? 5 : -5);
                     pitch_cal = Math.abs((double)entity.m_146909_() - pitch);
                     pitch += pitch_cal / (double)(pitch > (double)entity.m_146909_() ? -5 : 5);
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

                  LivingEntity var96;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var96 = _mobEnt.m_5448_();
                  } else {
                     var96 = null;
                  }

                  if (var96 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var96 = _mobEnt.m_5448_();
                     } else {
                        var96 = null;
                     }

                     Level var105 = ((Entity)var96).m_9236_();
                     ClipContext var113 = new ClipContext;
                     LivingEntity var122;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var122 = _mobEnt.m_5448_();
                     } else {
                        var122 = null;
                     }

                     Vec3 var123 = ((Entity)var122).m_20299_(1.0F);
                     LivingEntity var136;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var136 = _mobEnt.m_5448_();
                     } else {
                        var136 = null;
                     }

                     Vec3 var137 = ((Entity)var136).m_20299_(1.0F);
                     LivingEntity var150;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var150 = _mobEnt.m_5448_();
                     } else {
                        var150 = null;
                     }

                     var137 = var137.m_82549_(((Entity)var150).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var151 = Block.OUTLINE;
                     ClipContext.Fluid var158 = Fluid.NONE;
                     LivingEntity var163;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var163 = _mobEnt.m_5448_();
                     } else {
                        var163 = null;
                     }

                     var113.<init>(var123, var137, var151, var158, var163);
                     x_pos = (double)var105.m_45547_(var113).m_82425_().m_123341_();
                     LivingEntity var106;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var106 = _mobEnt.m_5448_();
                     } else {
                        var106 = null;
                     }

                     Level var107 = ((Entity)var106).m_9236_();
                     var113 = new ClipContext;
                     LivingEntity var124;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var124 = _mobEnt.m_5448_();
                     } else {
                        var124 = null;
                     }

                     Vec3 var125 = ((Entity)var124).m_20299_(1.0F);
                     LivingEntity var139;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var139 = _mobEnt.m_5448_();
                     } else {
                        var139 = null;
                     }

                     Vec3 var140 = ((Entity)var139).m_20299_(1.0F);
                     LivingEntity var152;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var152 = _mobEnt.m_5448_();
                     } else {
                        var152 = null;
                     }

                     var140 = var140.m_82549_(((Entity)var152).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var153 = Block.OUTLINE;
                     var158 = Fluid.NONE;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var163 = _mobEnt.m_5448_();
                     } else {
                        var163 = null;
                     }

                     var113.<init>(var125, var140, var153, var158, var163);
                     y_pos = (double)var107.m_45547_(var113).m_82425_().m_123342_();
                     LivingEntity var108;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var108 = _mobEnt.m_5448_();
                     } else {
                        var108 = null;
                     }

                     Level var109 = ((Entity)var108).m_9236_();
                     var113 = new ClipContext;
                     LivingEntity var126;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var126 = _mobEnt.m_5448_();
                     } else {
                        var126 = null;
                     }

                     Vec3 var127 = ((Entity)var126).m_20299_(1.0F);
                     LivingEntity var142;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var142 = _mobEnt.m_5448_();
                     } else {
                        var142 = null;
                     }

                     Vec3 var143 = ((Entity)var142).m_20299_(1.0F);
                     LivingEntity var154;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var154 = _mobEnt.m_5448_();
                     } else {
                        var154 = null;
                     }

                     var143 = var143.m_82549_(((Entity)var154).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var155 = Block.OUTLINE;
                     var158 = Fluid.NONE;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var163 = _mobEnt.m_5448_();
                     } else {
                        var163 = null;
                     }

                     var113.<init>(var127, var143, var155, var158, var163);
                     z_pos = (double)var109.m_45547_(var113).m_82425_().m_123343_();
                  } else {
                     entity.getPersistentData().m_128347_("cnt_target", 0.0);
                     if (entity.getPersistentData().m_128459_("friend_num_worker") != 0.0) {
                        logic_a = false;
                        Vec3 _center = new Vec3(x, y, z);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              logic_a = true;
                              x_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123341_();
                              y_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123342_();
                              z_pos = (double)entityiterator.m_9236_().m_45547_(new ClipContext(entityiterator.m_20299_(1.0F), entityiterator.m_20299_(1.0F).m_82549_(entityiterator.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).m_82425_().m_123343_();
                              break;
                           }
                        }

                        if (!logic_a && ownerExist && entity.getPersistentData().m_128459_("friend_num_worker") == owner_entity.getPersistentData().m_128459_("friend_num") && entity.getPersistentData().m_128459_("friend_num_worker") != owner_entity.getPersistentData().m_128459_("friend_num_worker")) {
                           if (owner_entity instanceof Mob) {
                              Mob _mobEnt = (Mob)owner_entity;
                              var96 = _mobEnt.m_5448_();
                           } else {
                              var96 = null;
                           }

                           if (var96 instanceof LivingEntity) {
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var96 = _mobEnt.m_5448_();
                              } else {
                                 var96 = null;
                              }

                              Level var99 = ((Entity)var96).m_9236_();
                              ClipContext var10001 = new ClipContext;
                              LivingEntity var10003;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10003 = _mobEnt.m_5448_();
                              } else {
                                 var10003 = null;
                              }

                              Vec3 var117 = ((Entity)var10003).m_20299_(1.0F);
                              LivingEntity var10004;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10004 = _mobEnt.m_5448_();
                              } else {
                                 var10004 = null;
                              }

                              Vec3 var128 = ((Entity)var10004).m_20299_(1.0F);
                              LivingEntity var10005;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10005 = _mobEnt.m_5448_();
                              } else {
                                 var10005 = null;
                              }

                              var128 = var128.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                              ClipContext.Block var145 = Block.COLLIDER;
                              ClipContext.Fluid var10006 = Fluid.NONE;
                              LivingEntity var10007;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10007 = _mobEnt.m_5448_();
                              } else {
                                 var10007 = null;
                              }

                              var10001.<init>(var117, var128, var145, var10006, var10007);
                              x_pos = (double)var99.m_45547_(var10001).m_82425_().m_123341_();
                              LivingEntity var100;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var100 = _mobEnt.m_5448_();
                              } else {
                                 var100 = null;
                              }

                              Level var101 = ((Entity)var100).m_9236_();
                              var10001 = new ClipContext;
                              LivingEntity var118;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var118 = _mobEnt.m_5448_();
                              } else {
                                 var118 = null;
                              }

                              Vec3 var119 = ((Entity)var118).m_20299_(1.0F);
                              LivingEntity var130;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var130 = _mobEnt.m_5448_();
                              } else {
                                 var130 = null;
                              }

                              Vec3 var131 = ((Entity)var130).m_20299_(1.0F);
                              LivingEntity var146;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var146 = _mobEnt.m_5448_();
                              } else {
                                 var146 = null;
                              }

                              var131 = var131.m_82549_(((Entity)var146).m_20252_(1.0F).m_82490_(0.0));
                              ClipContext.Block var147 = Block.COLLIDER;
                              var10006 = Fluid.NONE;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10007 = _mobEnt.m_5448_();
                              } else {
                                 var10007 = null;
                              }

                              var10001.<init>(var119, var131, var147, var10006, var10007);
                              y_pos = (double)var101.m_45547_(var10001).m_82425_().m_123342_();
                              LivingEntity var102;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var102 = _mobEnt.m_5448_();
                              } else {
                                 var102 = null;
                              }

                              Level var103 = ((Entity)var102).m_9236_();
                              var10001 = new ClipContext;
                              LivingEntity var120;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var120 = _mobEnt.m_5448_();
                              } else {
                                 var120 = null;
                              }

                              Vec3 var121 = ((Entity)var120).m_20299_(1.0F);
                              LivingEntity var133;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var133 = _mobEnt.m_5448_();
                              } else {
                                 var133 = null;
                              }

                              Vec3 var134 = ((Entity)var133).m_20299_(1.0F);
                              LivingEntity var148;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var148 = _mobEnt.m_5448_();
                              } else {
                                 var148 = null;
                              }

                              var134 = var134.m_82549_(((Entity)var148).m_20252_(1.0F).m_82490_(0.0));
                              ClipContext.Block var149 = Block.COLLIDER;
                              var10006 = Fluid.NONE;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10007 = _mobEnt.m_5448_();
                              } else {
                                 var10007 = null;
                              }

                              var10001.<init>(var121, var134, var149, var10006, var10007);
                              z_pos = (double)var103.m_45547_(var10001).m_82425_().m_123343_();
                           } else {
                              x_pos = (double)owner_entity.m_9236_().m_45547_(new ClipContext(owner_entity.m_20299_(1.0F), owner_entity.m_20299_(1.0F).m_82549_(owner_entity.m_20252_(1.0F).m_82490_(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).m_82425_().m_123341_();
                              y_pos = (double)owner_entity.m_9236_().m_45547_(new ClipContext(owner_entity.m_20299_(1.0F), owner_entity.m_20299_(1.0F).m_82549_(owner_entity.m_20252_(1.0F).m_82490_(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).m_82425_().m_123342_();
                              z_pos = (double)owner_entity.m_9236_().m_45547_(new ClipContext(owner_entity.m_20299_(1.0F), owner_entity.m_20299_(1.0F).m_82549_(owner_entity.m_20252_(1.0F).m_82490_(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).m_82425_().m_123343_();
                           }
                        }
                     }
                  }

                  entity.getPersistentData().m_128379_("free", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                  x_power = entity.m_20184_().m_7096_() + (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * 0.4 ? -0.075 : 0.075);
                  y_power = entity.m_20184_().m_7098_() + (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * 0.4 ? -0.075 : 0.075);
                  z_power = entity.m_20184_().m_7094_() + (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * 0.4 ? -0.075 : 0.075);
                  if (entity.getPersistentData().m_128471_("Stop")) {
                     entity.getPersistentData().m_128379_("Stop", false);
                  } else {
                     entity.m_20256_(new Vec3(x_power, y_power, z_power));
                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
                  z_pos = entity.m_20189_();
                  entity.getPersistentData().m_128347_("Damage", 9.0);
                  entity.getPersistentData().m_128347_("knockback", Math.random() * 1.0);
                  entity.getPersistentData().m_128347_("Range", (double)(entity.m_20205_() * 2.0F));
                  entity.getPersistentData().m_128347_("effect", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (entity.getPersistentData().m_128459_("cnt1") >= 50.0) {
                     teleported = false;
                     entity.getPersistentData().m_128347_("cnt1", 0.0);
                     entity.getPersistentData().m_128347_("cnt2", 0.0);
                     entity.getPersistentData().m_128347_("modement_mode", 0.0);
                     if (entity.getPersistentData().m_128459_("friend_num_worker") != 0.0 && ownerExist && owner_entity instanceof Player) {
                        teleported = true;
                        x_pos = 0.0;
                        y_pos = 64.0 + Math.random();
                        z_pos = 0.0;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           Commands var110 = entity.m_20194_().m_129892_();
                           CommandSourceStack var116 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                           long var10002 = Math.round(x_pos);
                           var110.m_230957_(var116, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                        }

                        NUM1 = 0.0;

                        for(int index0 = 0; index0 < 10000; ++index0) {
                           ++NUM1;
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                           if (owner_entity.getPersistentData().m_128461_(STR1 + "_name").equals(entity.m_5446_().getString())) {
                              y_pos = owner_entity.getPersistentData().m_128459_(STR1);
                              break;
                           }

                           if (owner_entity.getPersistentData().m_128459_(STR1) == 0.0) {
                              owner_entity.getPersistentData().m_128347_(STR1, y_pos);
                              owner_entity.getPersistentData().m_128359_(STR1 + "_name", entity.m_5446_().getString());
                              break;
                           }
                        }

                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                        }

                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "execute in jujutsucraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                        }

                        owner_entity.getPersistentData().m_128347_(STR1 + "_num", owner_entity.getPersistentData().m_128459_(STR1 + "_num") + 1.0);
                        owner_entity.getPersistentData().m_128379_("UpdateSkills", true);
                     }

                     if (!teleported && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               }
            }
         }

      }
   }
}
