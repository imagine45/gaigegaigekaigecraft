package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AILiquidMetalProcedure {
   public AILiquidMetalProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean LogicOwner = false;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_target = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double degree = 0.0;
         double height = 0.0;
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 60, 3, false, false));
               }
            }

            LogicOwner = LogicOwnerExistProcedure.execute(world, entity);
            if (!LogicOwner) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else {
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
                  float var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21223_();
                  } else {
                     var10000 = -1.0F;
                  }

                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21233_();
                  } else {
                     var10001 = -1.0F;
                  }

                  if (var10000 < var10001) {
                     label190: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt9 = (LivingEntity)entity;
                           if (_livEnt9.m_21023_(MobEffects.f_19605_)) {
                              break label190;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 51, 0, false, false));
                           }
                        }
                     }
                  }

                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity_a;
                     if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                     }
                  }

                  if (entity_a instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 1.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)(entity.m_20206_() * 0.0F);
               z_pos = entity.m_20189_();
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
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
                     logic_a = true;
                     yaw = (double)entity_a.m_146908_();
                     pitch = (double)entity_a.m_146909_();
                     x_power = entity.m_20185_();
                     y_power = entity.m_20186_();
                     z_power = entity.m_20189_();
                     if (entity.getPersistentData().m_128459_("move") == 0.0) {
                        dis = 3.0;
                        degree = 60.0;
                        height = 0.0;
                     } else if (entity.getPersistentData().m_128459_("move") == 1.0) {
                        dis = 5.0;
                        degree = 0.0;
                        height = 1.0;
                     }

                     if (entity.getPersistentData().m_128459_("move") != 1.0) {
                        x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + 90.0 + degree)) * dis;
                        y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.25 + height;
                        z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + 90.0 + degree)) * dis;
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
               }

               if (!logic_a && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }

            if (entity.getPersistentData().m_128459_("move") == 1.0) {
               AILiquidArrowProcedure.execute(world, x, y, z, entity);
            } else {
               logic_a = true;
               if (entity_a instanceof LivingEntity && entity_a.getPersistentData().m_128459_("skill") == 3910.0) {
                  logic_a = false;
               }

               if (logic_a && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), x, y + (double)entity.m_20206_() * 0.5, z, (int)(ReturnEntitySizeProcedure.execute(entity) * 5.0), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
               }

               ResetCounterProcedure.execute(entity);
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), x, y + (double)entity.m_20206_() * 0.5, z, (int)(ReturnEntitySizeProcedure.execute(entity) * 25.0), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 1.0);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
