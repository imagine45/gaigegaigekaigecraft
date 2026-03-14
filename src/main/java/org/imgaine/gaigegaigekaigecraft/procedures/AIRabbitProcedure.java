package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.CockroachesEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AIRabbitProcedure {
   public AIRabbitProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double rnd = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         double speed = 0.0;
         double entity_size = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         speed = entity instanceof CockroachesEntity ? 0.5 : 0.75;
         if (entity.m_6084_()) {
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
            } else {
               AIActiveProcedure.execute(world, x, y, z, entity);
            }

            if (entity instanceof CockroachesEntity) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.1);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.0);
               }

               if (entity.getPersistentData().m_128459_("skill") > -900.0) {
                  entity.getPersistentData().m_128347_("skill", 2306.0);
                  entity.getPersistentData().m_128347_("Damage", 9.0);
                  entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20205_()));
                  entity.getPersistentData().m_128347_("knockback", 0.1);
                  entity.getPersistentData().m_128347_("effect", 1.0);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                  entity.getPersistentData().m_128347_("skill", 0.0);
                  entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_life") > 120.0 && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            } else {
               FollowEntityProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("Range", entity_size);
               entity.getPersistentData().m_128347_("knockback", 0.1);
               KnockbackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
            }

            entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
            if (entity.getPersistentData().m_128459_("skill") > -900.0) {
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("cnt_x", Math.random() * 5.0);
                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                     if (LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                        logic_a = true;
                        if (!(entity instanceof RabbitEscapeEntity) && !(entity instanceof CockroachesEntity)) {
                           entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + entity.m_20154_().f_82479_ * 64.0);
                           entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + entity.m_20154_().f_82480_ * 64.0);
                           entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + entity.m_20154_().f_82481_ * 64.0);
                        } else {
                           LivingEntity var10000;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 instanceof LivingEntity && entity_a.getPersistentData().m_128459_("cnt_target") > 6.0) {
                              CompoundTag var30 = entity.getPersistentData();
                              LivingEntity var10002;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10002 = _mobEnt.m_5448_();
                              } else {
                                 var10002 = null;
                              }

                              var30.m_128347_("x_pos", ((Entity)var10002).m_20185_());
                              var30 = entity.getPersistentData();
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10002 = _mobEnt.m_5448_();
                              } else {
                                 var10002 = null;
                              }

                              var30.m_128347_("y_pos", ((Entity)var10002).m_20186_());
                              var30 = entity.getPersistentData();
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10002 = _mobEnt.m_5448_();
                              } else {
                                 var10002 = null;
                              }

                              var30.m_128347_("z_pos", ((Entity)var10002).m_20189_());
                           } else {
                              entity.getPersistentData().m_128347_("x_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_());
                              entity.getPersistentData().m_128347_("y_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_());
                              entity.getPersistentData().m_128347_("z_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                           }
                        }
                     }

                     if (logic_a) {
                        RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                        GetPowerForwardProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                        if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(4.0)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                           entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), 0.75 * (1.0 / speed)));
                        }

                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, Math.max(entity.getPersistentData().m_128459_("y_power") * speed, entity instanceof CockroachesEntity ? 0.1 : 0.25), entity.getPersistentData().m_128459_("z_power") * speed));
                     }
                  }
               }

               if (entity instanceof RabbitEscapeEntity && !logic_a && entity.m_20096_() && Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0)) > 0.1) {
                  entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), Math.max(entity.m_20184_().m_7098_(), 0.33), entity.m_20184_().m_7094_()));
               }
            }
         }

      }
   }
}
