package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIWoodenSpear2Procedure {
   public AIWoodenSpear2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
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
         double CNT6 = 0.0;
         double distance = 0.0;
         attack = false;
         x_power = entity.getPersistentData().m_128459_("x_power");
         y_power = entity.getPersistentData().m_128459_("y_power");
         z_power = entity.getPersistentData().m_128459_("z_power");
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
            yaw = (double)(entity.m_146908_() % 360.0F);
            pitch = (double)entity.m_146909_();
            if (LogicOwnerExistProcedure.execute(world, entity)) {
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
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     double var81 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var81 + (double)((Entity)var10001).m_20206_() * 0.5;
                     LivingEntity var82;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var82 = _mobEnt.m_5448_();
                     } else {
                        var82 = null;
                     }

                     z_pos = ((Entity)var82).m_20189_();
                  } else {
                     x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                     y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                     z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                  }
               }
            }

            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
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

            move_power = entity.getPersistentData().m_128459_("cnt3") < 20.0 ? 8.0 : 16.0;
            yaw_cal = (double)entity.m_146908_() - yaw;
            if ((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0))) {
               yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / move_power;
            } else {
               yaw -= Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / move_power;
            }

            pitch_cal = Math.abs(pitch - (double)entity.m_146909_());
            if (pitch > (double)entity.m_146909_()) {
               pitch -= pitch_cal / move_power;
            } else {
               pitch += pitch_cal / move_power;
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

         yaw = (double)entity.m_146908_();
         pitch = (double)entity.m_146909_();
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

         entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 1.0);
         entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 1.0);
         entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 1.0);
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

         if (entity.getPersistentData().m_128459_("cnt3") < 20.0) {
            attack = false;
         } else {
            if (entity.getPersistentData().m_128459_("cnt4") == 0.0) {
               entity.getPersistentData().m_128347_("cnt4", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            attack = true;

            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("Damage", 15.0);
               entity.getPersistentData().m_128347_("knockback", 1.0);
               entity.getPersistentData().m_128347_("Range", 3.0);
               entity.getPersistentData().m_128347_("effect", 1.0);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               if (entity.getPersistentData().m_128471_("Stop")) {
                  entity.getPersistentData().m_128379_("Stop", false);
                  attack = false;
                  break;
               }

               if (entity.m_5830_()) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 2.0);
                  attack = false;
                  break;
               }

               entity.m_6021_(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
               }

               if (entity.m_5830_()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                  }

                  world.m_46796_(2001, BlockPos.m_274561_(x_pos, y_pos, z_pos), net.minecraft.world.level.block.Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                  entity.getPersistentData().m_128347_("BlockRange", (double)(1.0F * entity.m_20205_()));
                  entity.getPersistentData().m_128347_("BlockDamage", (double)(entity.m_20205_() * 1.0F) * CNT6);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            BulletDomainHit2Procedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt3") > 60.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

         if (attack) {
            entity.m_20256_(new Vec3(x_power, y_power, z_power));
            entity.getPersistentData().m_128347_("knockback", 0.5);
         } else {
            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            entity.getPersistentData().m_128347_("knockback", 0.1);
            entity.getPersistentData().m_128347_("target_type", 1.0);
         }

         entity.getPersistentData().m_128347_("Damage", 15.0);
         entity.getPersistentData().m_128347_("Range", 3.0);
         entity.getPersistentData().m_128347_("effect", 1.0);
         RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
         entity.getPersistentData().m_128347_("target_type", 0.0);
         entity.getPersistentData().m_128347_("Damage", 0.0);
      }
   }
}
