package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.EntityProjectionSorceryEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AIProjectionSorceryProcedure {
   public AIProjectionSorceryProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean owner_exist = false;
         boolean move_flag = false;
         boolean SUCCESS = false;
         String STR1 = "";
         double y_spawn = 0.0;
         double x_spawn = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double z_spawn = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double CNT5 = 0.0;
         double x_power = 0.0;
         double loop_num = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double dis = 0.0;

         for(int index0 = 0; index0 < 2; ++index0) {
            entity.m_6842_(true);
            int var10000;
            if (entity instanceof EntityProjectionSorceryEntity) {
               EntityProjectionSorceryEntity _datEntI = (EntityProjectionSorceryEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityProjectionSorceryEntity.DATA_cnt_skin);
            } else {
               var10000 = 0;
            }

            if (var10000 < 3) {
               if (entity instanceof EntityProjectionSorceryEntity) {
                  EntityProjectionSorceryEntity _datEntSetI = (EntityProjectionSorceryEntity)entity;
                  SynchedEntityData var67 = _datEntSetI.m_20088_();
                  EntityDataAccessor var10001 = EntityProjectionSorceryEntity.DATA_cnt_skin;
                  int var10002;
                  if (entity instanceof EntityProjectionSorceryEntity) {
                     EntityProjectionSorceryEntity _datEntI = (EntityProjectionSorceryEntity)entity;
                     var10002 = (Integer)_datEntI.m_20088_().m_135370_(EntityProjectionSorceryEntity.DATA_cnt_skin);
                  } else {
                     var10002 = 0;
                  }

                  var67.m_135381_(var10001, var10002 + 1);
               }
            } else if (entity instanceof EntityProjectionSorceryEntity) {
               EntityProjectionSorceryEntity animatable = (EntityProjectionSorceryEntity)entity;
               animatable.setTexture("entity_projection_sorcery");
            }

            owner_exist = LogicOwnerExistProcedure.execute(world, entity);
            if (owner_exist) {
               entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
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
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                  owner_exist = true;
               } else {
                  owner_exist = false;
               }
            }

            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == 0.0) {
               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
               break;
            }

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") <= 1.0) {
               if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                  entity.getPersistentData().m_128347_("x_pos2", (entity.getPersistentData().m_128459_("x_pos") - entity.m_20185_()) * 1.0);
                  entity.getPersistentData().m_128347_("y_pos2", (entity.getPersistentData().m_128459_("y_pos") - entity.m_20186_()) * 1.0);
                  entity.getPersistentData().m_128347_("z_pos2", (entity.getPersistentData().m_128459_("z_pos") - entity.m_20189_()) * 1.0);
                  entity.getPersistentData().m_128347_("speed", Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_pos2"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("y_pos2"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("z_pos2"), 2.0)));
               }

               if (entity.getPersistentData().m_128459_("speed") > 0.0) {
                  if (entity.getPersistentData().m_128459_("speed") >= 1.0) {
                     x_power = entity.getPersistentData().m_128459_("x_pos2") / entity.getPersistentData().m_128459_("speed") * 0.2;
                     y_power = entity.getPersistentData().m_128459_("y_pos2") / entity.getPersistentData().m_128459_("speed") * 0.2;
                     z_power = entity.getPersistentData().m_128459_("z_pos2") / entity.getPersistentData().m_128459_("speed") * 0.2;
                  } else {
                     x_power = entity.getPersistentData().m_128459_("x_pos2") * 0.2;
                     y_power = entity.getPersistentData().m_128459_("y_pos2") * 0.2;
                     z_power = entity.getPersistentData().m_128459_("z_pos2") * 0.2;
                  }

                  for(int index1 = 0; index1 < (int)Math.round(Math.max(entity.getPersistentData().m_128459_("speed"), 1.0) * 5.0) && !world.m_8055_(BlockPos.m_274561_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power)).m_60815_(); ++index1) {
                     entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_() + y_power, entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") % 20.0 == 19.0) {
               logic_a = false;
               if (owner_exist && entity_a.getPersistentData().m_128459_("skill") > 0.0) {
                  logic_a = true;
               }

               if (!logic_a) {
                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
                  break;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               if (entity.getPersistentData().m_128459_("cnt5") < 20.0) {
                  logic_a = false;
                  if (owner_exist) {
                     logic_a = true;
                     if (entity_a.getPersistentData().m_128459_("cnt3") != 0.0) {
                        logic_a = false;
                     }

                     x_pos = entity_a.getPersistentData().m_128459_("x_pos");
                     y_pos = entity_a.getPersistentData().m_128459_("y_pos");
                     z_pos = entity_a.getPersistentData().m_128459_("z_pos");
                  }

                  if (!logic_a) {
                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                     break;
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  loop_num = 0.0;
                  x_spawn = entity.m_20185_();
                  y_spawn = entity.m_20186_();
                  z_spawn = entity.m_20189_();
                  CNT5 = entity.getPersistentData().m_128459_("cnt5") + 1.0 + loop_num;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_spawn, y_spawn, z_spawn), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "summon jujutsucraft:entity_projection_sorcery ~ ~ ~ {Invulnerable:1b,Team:\"" + entity.getPersistentData().m_128461_("owner_name") + "\",NoAI:1b,Rotation:[" + yaw + "F," + pitch + "F],CustomName:'{\"text\":\"FRAME" + Math.round(CNT5) + "\"}',ActiveEffects:[{Id:14b,Amplifier:0b,Duration:100000,ShowParticles:0b}]}");
                  }

                  Vec3 _center = new Vec3(x_spawn, y_spawn, z_spawn);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entityiterator instanceof EntityProjectionSorceryEntity && entityiterator.getPersistentData().m_128459_("NameRanged_ranged") == 0.0) {
                        entityiterator.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged_ranged"));
                        entityiterator.getPersistentData().m_128347_("cnt5", (double)Math.round(CNT5));
                        entityiterator.getPersistentData().m_128347_("x_pos", x_pos);
                        entityiterator.getPersistentData().m_128347_("y_pos", y_pos);
                        entityiterator.getPersistentData().m_128347_("z_pos", z_pos);
                        entityiterator.getPersistentData().m_128359_("owner_name", entity.getPersistentData().m_128461_("owner_name"));
                        entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                        entityiterator.m_6842_(true);
                        break;
                     }
                  }

                  ++loop_num;
               }
            } else if (owner_exist && entity_a.getPersistentData().m_128459_("cnt3") > 0.0 && entity.getPersistentData().m_128459_("cnt5") <= entity_a.getPersistentData().m_128459_("cnt5")) {
               x_power = entity.m_20185_() - entity_a.m_20185_();
               y_power = entity.m_20186_() - entity_a.m_20186_();
               z_power = entity.m_20189_() - entity_a.m_20189_();
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis < entity.getPersistentData().m_128459_("cnt4") * 4.0 + 16.0) {
                  entity_a.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
                  if (entity_a instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity_a.m_146908_(), entity_a.m_146909_());
                  }
               } else {
                  entity_a.getPersistentData().m_128347_("cnt7", 1.0);
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
               break;
            }
         }

      }
   }
}
