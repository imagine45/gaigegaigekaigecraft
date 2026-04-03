package org.imgaine.gaigegaigekaigecraft.procedures;

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
            entity.setInvisible(true);
            int var10000;
            if (entity instanceof EntityProjectionSorceryEntity) {
               EntityProjectionSorceryEntity _datEntI = (EntityProjectionSorceryEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(EntityProjectionSorceryEntity.DATA_cnt_skin);
            } else {
               var10000 = 0;
            }

            if (var10000 < 3) {
               if (entity instanceof EntityProjectionSorceryEntity) {
                  EntityProjectionSorceryEntity _datEntSetI = (EntityProjectionSorceryEntity)entity;
                  SynchedEntityData var67 = _datEntSetI.getEntityData();
                  EntityDataAccessor var10001 = EntityProjectionSorceryEntity.DATA_cnt_skin;
                  int var10002;
                  if (entity instanceof EntityProjectionSorceryEntity) {
                     EntityProjectionSorceryEntity _datEntI = (EntityProjectionSorceryEntity)entity;
                     var10002 = (Integer)_datEntI.getEntityData().get(EntityProjectionSorceryEntity.DATA_cnt_skin);
                  } else {
                     var10002 = 0;
                  }

                  var67.set(var10001, var10002 + 1);
               }
            } else if (entity instanceof EntityProjectionSorceryEntity) {
               EntityProjectionSorceryEntity animatable = (EntityProjectionSorceryEntity)entity;
               animatable.setTexture("entity_projection_sorcery");
            }

            owner_exist = LogicOwnerExistProcedure.execute(world, entity);
            if (owner_exist) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                  owner_exist = true;
               } else {
                  owner_exist = false;
               }
            }

            if (entity.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
               break;
            }

            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  entity.getPersistentData().putDouble("x_pos2", (entity.getPersistentData().getDouble("x_pos") - entity.getX()) * 1.0);
                  entity.getPersistentData().putDouble("y_pos2", (entity.getPersistentData().getDouble("y_pos") - entity.getY()) * 1.0);
                  entity.getPersistentData().putDouble("z_pos2", (entity.getPersistentData().getDouble("z_pos") - entity.getZ()) * 1.0);
                  entity.getPersistentData().putDouble("speed", Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_pos2"), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_pos2"), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_pos2"), 2.0)));
               }

               if (entity.getPersistentData().getDouble("speed") > 0.0) {
                  if (entity.getPersistentData().getDouble("speed") >= 1.0) {
                     x_power = entity.getPersistentData().getDouble("x_pos2") / entity.getPersistentData().getDouble("speed") * 0.2;
                     y_power = entity.getPersistentData().getDouble("y_pos2") / entity.getPersistentData().getDouble("speed") * 0.2;
                     z_power = entity.getPersistentData().getDouble("z_pos2") / entity.getPersistentData().getDouble("speed") * 0.2;
                  } else {
                     x_power = entity.getPersistentData().getDouble("x_pos2") * 0.2;
                     y_power = entity.getPersistentData().getDouble("y_pos2") * 0.2;
                     z_power = entity.getPersistentData().getDouble("z_pos2") * 0.2;
                  }

                  for(int index1 = 0; index1 < (int)Math.round(Math.max(entity.getPersistentData().getDouble("speed"), 1.0) * 5.0) && !world.getBlockState(BlockPos.containing(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power)).canOcclude(); ++index1) {
                     entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") % 20.0 == 19.0) {
               logic_a = false;
               if (owner_exist && entity_a.getPersistentData().getDouble("skill") > 0.0) {
                  logic_a = true;
               }

               if (!logic_a) {
                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
                  break;
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               entity.getPersistentData().putDouble("cnt2", 1.0);
               if (entity.getPersistentData().getDouble("cnt5") < 20.0) {
                  logic_a = false;
                  if (owner_exist) {
                     logic_a = true;
                     if (entity_a.getPersistentData().getDouble("cnt3") != 0.0) {
                        logic_a = false;
                     }

                     x_pos = entity_a.getPersistentData().getDouble("x_pos");
                     y_pos = entity_a.getPersistentData().getDouble("y_pos");
                     z_pos = entity_a.getPersistentData().getDouble("z_pos");
                  }

                  if (!logic_a) {
                     if (!entity.level().isClientSide()) {
                        entity.discard();
                     }
                     break;
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  loop_num = 0.0;
                  x_spawn = entity.getX();
                  y_spawn = entity.getY();
                  z_spawn = entity.getZ();
                  CNT5 = entity.getPersistentData().getDouble("cnt5") + 1.0 + loop_num;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_spawn, y_spawn, z_spawn), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "summon gaigegaigekaigecraft:entity_projection_sorcery ~ ~ ~ {Invulnerable:1b,Team:\"" + entity.getPersistentData().getString("owner_name") + "\",NoAI:1b,Rotation:[" + yaw + "F," + pitch + "F],CustomName:'{\"text\":\"FRAME" + Math.round(CNT5) + "\"}',ActiveEffects:[{Id:14b,Amplifier:0b,Duration:100000,ShowParticles:0b}]}");
                  }

                  Vec3 _center = new Vec3(x_spawn, y_spawn, z_spawn);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                     if (entityiterator instanceof EntityProjectionSorceryEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                        entityiterator.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged_ranged"));
                        entityiterator.getPersistentData().putDouble("cnt5", (double)Math.round(CNT5));
                        entityiterator.getPersistentData().putDouble("x_pos", x_pos);
                        entityiterator.getPersistentData().putDouble("y_pos", y_pos);
                        entityiterator.getPersistentData().putDouble("z_pos", z_pos);
                        entityiterator.getPersistentData().putString("owner_name", entity.getPersistentData().getString("owner_name"));
                        entityiterator.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                        entityiterator.setInvisible(true);
                        break;
                     }
                  }

                  ++loop_num;
               }
            } else if (owner_exist && entity_a.getPersistentData().getDouble("cnt3") > 0.0 && entity.getPersistentData().getDouble("cnt5") <= entity_a.getPersistentData().getDouble("cnt5")) {
               x_power = entity.getX() - entity_a.getX();
               y_power = entity.getY() - entity_a.getY();
               z_power = entity.getZ() - entity_a.getZ();
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis < entity.getPersistentData().getDouble("cnt4") * 4.0 + 16.0) {
                  entity_a.teleportTo(entity.getX(), entity.getY(), entity.getZ());
                  if (entity_a instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ(), entity_a.getYRot(), entity_a.getXRot());
                  }
               } else {
                  entity_a.getPersistentData().putDouble("cnt7", 1.0);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
               break;
            }
         }

      }
   }
}
