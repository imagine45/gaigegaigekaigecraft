package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class AIWoodenBallProcedure {
   public AIWoodenBallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double move_power = 0.0;
         double tick = 0.0;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("move") == 0.0) {
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
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
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     if (entity.getPersistentData().m_128459_("position_pitch") == 0.0) {
                        entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), 2.0));
                     }

                     if (entity.getPersistentData().m_128459_("cnt_x") == 0.0) {
                        if (entity_a.getPersistentData().m_128459_("skill") != 0.0 && entity_a.getPersistentData().m_128471_("attack")) {
                           entity.getPersistentData().m_128347_("cnt_x", 1.0);
                        }
                     } else if (entity.getPersistentData().m_128459_("cnt_x") == 1.0) {
                        if (entity_a.getPersistentData().m_128459_("skill") == 0.0) {
                           entity.getPersistentData().m_128347_("cnt_x", 2.0);
                        }
                     } else {
                        entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                        if (entity.getPersistentData().m_128459_("cnt_x") > 10.0) {
                           ResetCounterProcedure.execute(entity);
                           entity.getPersistentData().m_128347_("cnt_x", 0.0);
                           entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + 1.0);
                           entity.getPersistentData().m_128347_("move", entity.getPersistentData().m_128459_("cnt_x2"));
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:1b}");
                           }
                        }
                     }

                     logic_a = true;
                     yaw = (double)entity_a.m_146908_();
                     pitch = (double)entity_a.m_146909_();
                     x_power = entity.m_20185_();
                     y_power = entity.m_20186_();
                     z_power = entity.m_20189_();
                     x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + 90.0 + entity.getPersistentData().m_128459_("position_yaw"))) * 5.0;
                     y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5 + entity.getPersistentData().m_128459_("position_pitch");
                     z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + 90.0 + entity.getPersistentData().m_128459_("position_yaw"))) * 5.0;
                     if (Math.abs(x_target - x_power) > 0.5) {
                        x_target = x_power + (x_power > x_target ? -0.5 : 0.5);
                     }

                     if (Math.abs(y_target - y_power) > 0.5) {
                        y_target = y_power + (y_power > y_target ? -0.5 : 0.5);
                     }

                     if (Math.abs(z_target - z_power) > 0.5) {
                        z_target = z_power + (z_power > z_target ? -0.5 : 0.5);
                     }

                     entity.m_6021_(x_target, y_target, z_target);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(x_target, y_target, z_target, entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? 0.0 : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                     entity.m_146922_(entity_a.m_146908_());
                     entity.m_146926_(entity_a.m_146909_());
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
               }

               if (!logic_a && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (entity.getPersistentData().m_128459_("move") < 5.0) {
               AIWoodenBall1Procedure.execute(world, entity);
            } else {
               AIWoodenBall1Procedure.execute(world, entity);
               if (entity.getPersistentData().m_128459_("move") == 0.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }
         } else {
            world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * 0.5, z), Block.m_49956_(Blocks.f_49999_.m_49966_()));
            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
