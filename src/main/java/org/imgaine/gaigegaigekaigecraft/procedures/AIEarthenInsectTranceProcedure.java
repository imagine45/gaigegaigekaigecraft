package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEarthenInsectTranceProcedure {
   public AIEarthenInsectTranceProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean reverse = false;
         boolean FoxFire = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double CNT6 = 0.0;
         double speed = 0.0;
         double start_time = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("move") == 0.0) {
               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
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
                        }
                     }

                     logic_a = true;
                     yaw = (double)entity_a.m_146908_();
                     pitch = (double)entity_a.m_146909_();
                     x_power = entity.m_20185_();
                     y_power = entity.m_20186_();
                     z_power = entity.m_20189_();
                     x_target = entity_a.m_20185_() + Math.cos(Math.toRadians(yaw + 90.0 + entity.getPersistentData().m_128459_("position_yaw"))) * (2.75 + (double)entity_a.m_20205_());
                     y_target = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.5 + entity.getPersistentData().m_128459_("position_pitch");
                     z_target = entity_a.m_20189_() + Math.sin(Math.toRadians(yaw + 90.0 + entity.getPersistentData().m_128459_("position_yaw"))) * (2.75 + (double)entity_a.m_20205_());
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

               if ((!logic_a || entity.getPersistentData().m_128459_("cnt_life") >= 600.0) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
               start_time = 1.0;
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
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
                     x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                     y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                     z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                     dis = 8.0;
                     logic_a = false;

                     for(int index0 = 0; index0 < 8; ++index0) {
                        Vec3 _center = new Vec3((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(8.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                              logic_a = true;
                              x_pos = entityiterator.m_20185_();
                              y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                              z_pos = entityiterator.m_20189_();
                              break;
                           }
                        }

                        dis += 8.0;
                        if (logic_a) {
                           break;
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") <= start_time) {
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     }
                  }
               }

               CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
               if (entity.getPersistentData().m_128459_("cnt1") >= start_time) {
                  entity.getPersistentData().m_128379_("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                  if (entity.getPersistentData().m_128459_("cnt1") == start_time) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                        }
                     }

                     x_power = entity.getPersistentData().m_128459_("x_power") * (1.0 + entity.getPersistentData().m_128459_("speed"));
                     y_power = entity.getPersistentData().m_128459_("y_power") * (1.0 + entity.getPersistentData().m_128459_("speed"));
                     z_power = entity.getPersistentData().m_128459_("z_power") * (1.0 + entity.getPersistentData().m_128459_("speed"));
                  } else {
                     speed = 0.125;
                     if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * (1.0 + entity.getPersistentData().m_128459_("speed"))) {
                        x_power = entity.m_20184_().m_7096_() - speed;
                     } else {
                        x_power = entity.m_20184_().m_7096_() + speed;
                     }

                     if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * (1.0 + entity.getPersistentData().m_128459_("speed"))) {
                        y_power = entity.m_20184_().m_7098_() - speed;
                     } else {
                        y_power = entity.m_20184_().m_7098_() + speed;
                     }

                     if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * (1.0 + entity.getPersistentData().m_128459_("speed"))) {
                        z_power = entity.m_20184_().m_7094_() - speed;
                     } else {
                        z_power = entity.m_20184_().m_7094_() + speed;
                     }
                  }

                  speed = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                  if (speed < 1.5 * (1.0 + entity.getPersistentData().m_128459_("speed"))) {
                     speed = 1.5 * (1.0 + entity.getPersistentData().m_128459_("speed")) / Math.max(speed, 0.01);
                     x_power *= speed;
                     y_power *= speed;
                     z_power *= speed;
                  }

                  if (!entity.getPersistentData().m_128471_("Stop")) {
                     entity.m_20256_(new Vec3(x_power, y_power, z_power));
                     BulletDomainHit2Procedure.execute(world, entity);
                     RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * 10.0, entity);
                  } else {
                     entity.getPersistentData().m_128379_("Stop", false);
                  }

                  entity.getPersistentData().m_128347_("Damage", 9.0 * Math.max(CNT6, 0.75));
                  entity.getPersistentData().m_128347_("Range", 2.5);
                  entity.getPersistentData().m_128347_("knockback", 0.25 * Math.max(CNT6, 0.75));
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 40.0) {
                  entity.getPersistentData().m_128347_("move", 0.0);
               }
            }
         }

         if (!entity.m_6084_() && !entity.getPersistentData().m_128471_("flag_die")) {
            entity.getPersistentData().m_128379_("flag_die", true);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }

            entity.getPersistentData().m_128347_("Damage", 12.0 * Math.max(CNT6, 0.75));
            entity.getPersistentData().m_128347_("Range", 12.0);
            entity.getPersistentData().m_128347_("knockback", 0.25 * Math.max(CNT6, 0.75));
            entity.getPersistentData().m_128347_("effect", 15.0);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", 50.0);
            entity.getPersistentData().m_128379_("attack", false);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 8, 0.125, 0.125, 0.125, 0.25);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123763_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 32, 0.125, 0.125, 0.125, 0.5);
            }
         }

      }
   }
}
