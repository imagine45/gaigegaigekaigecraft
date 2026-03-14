package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AIRika1Procedure {
   public AIRika1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean garuda = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double distance = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         garuda = entity instanceof GarudaEntity;
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (garuda) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            } else if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         entity.f_19789_ = 0.0F;
         logic_a = false;
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(64.0F + entity.m_20205_());
         if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
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
               if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                  x_pos = entity_a.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity_a.m_20186_() + (double)entity_a.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance;
                  z_pos = entity_a.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity && entity_a.getPersistentData().m_128459_("cnt_target") > 6.0) {
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

                     double var86 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var86 + (double)((Entity)var10001).m_20206_() * 0.5;
                     LivingEntity var87;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var87 = _mobEnt.m_5448_();
                     } else {
                        var87 = null;
                     }

                     z_pos = ((Entity)var87).m_20189_();
                  }
               }
            }

            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(16.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator) {
                  LivingEntity var88;
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var88 = _mobEnt.m_5448_();
                  } else {
                     var88 = null;
                  }

                  if (var88 instanceof LivingEntity && entityiterator.getPersistentData().m_128459_("cnt_target") > 6.0) {
                     if (entityiterator instanceof Mob) {
                        Mob _mobEnt = (Mob)entityiterator;
                        var88 = _mobEnt.m_5448_();
                     } else {
                        var88 = null;
                     }

                     if (((Entity)var88).getPersistentData().m_128459_("friend_num") == entity.getPersistentData().m_128459_("friend_num")) {
                        x_pos = entityiterator.m_20185_();
                        y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                        z_pos = entityiterator.m_20189_();
                        break;
                     }
                  }
               }
            }
         } else {
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            LivingEntity var90;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var90 = _mobEnt.m_5448_();
            } else {
               var90 = null;
            }

            if (var90 instanceof LivingEntity && (GetDistanceProcedure.execute(entity) > 16.0 || entity.getPersistentData().m_128459_("cnt1") > 20.0)) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.m_5448_();
               } else {
                  var90 = null;
               }

               x_pos = ((Entity)var90).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.m_5448_();
               } else {
                  var90 = null;
               }

               double var93 = ((Entity)var90).m_20186_();
               LivingEntity var96;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.m_5448_();
               } else {
                  var96 = null;
               }

               y_pos = var93 + (double)((Entity)var96).m_20206_() * 0.5;
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               z_pos = ((Entity)var94).m_20189_();
            }
         }

         entity.getPersistentData().m_128379_("canFly", true);
         GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            if (garuda) {
               x_power = entity.getPersistentData().m_128459_("x_power") * 1.0;
               y_power = entity.getPersistentData().m_128459_("y_power") * 1.0;
               z_power = entity.getPersistentData().m_128459_("z_power") * 1.0;
            } else {
               x_power = entity.getPersistentData().m_128459_("x_power") * 0.5;
               y_power = entity.getPersistentData().m_128459_("y_power") * 0.5;
               z_power = entity.getPersistentData().m_128459_("z_power") * 0.5;
            }
         } else {
            if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * 0.5) {
               x_power = entity.m_20184_().m_7096_() - 0.125;
            } else {
               x_power = entity.m_20184_().m_7096_() + 0.125;
            }

            if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * 0.5) {
               y_power = entity.m_20184_().m_7098_() - 0.125;
            } else {
               y_power = entity.m_20184_().m_7098_() + 0.125;
            }

            if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * 0.5) {
               z_power = entity.m_20184_().m_7094_() - 0.125;
            } else {
               z_power = entity.m_20184_().m_7094_() + 0.125;
            }
         }

         entity.m_20256_(new Vec3(x_power, y_power, z_power));
         yaw = (double)(entity.m_146908_() % 360.0F);
         pitch = (double)entity.m_146909_();
         RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * 32.0, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * 32.0, entity.m_20189_() + entity.m_20184_().m_7094_() * 32.0, entity);
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
         if ((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0))) {
            yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 5.0;
         } else {
            yaw -= Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 5.0;
         }

         pitch_cal = Math.abs((double)entity.m_146909_() - pitch);
         if (pitch > (double)entity.m_146909_()) {
            pitch -= pitch_cal / 5.0;
         } else {
            pitch += pitch_cal / 5.0;
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

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         if (!garuda) {
            if (entity.getPersistentData().m_128459_("cnt1") < 25.0) {
               entity.getPersistentData().m_128347_("Damage", 12.0);
               entity.getPersistentData().m_128347_("knockback", 0.75);
            } else {
               entity.getPersistentData().m_128347_("Damage", 13.0);
               entity.getPersistentData().m_128347_("knockback", 1.5);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
            entity.getPersistentData().m_128347_("Damage", 6.5);
            entity.getPersistentData().m_128347_("knockback", 0.75);
         } else {
            entity.getPersistentData().m_128347_("Damage", 9.0);
            entity.getPersistentData().m_128347_("knockback", 1.5);
         }

         CompoundTag var95;
         int var10004;
         label222: {
            entity.getPersistentData().m_128347_("Range", (double)(entity.m_20206_() + entity.m_20205_()));
            entity.getPersistentData().m_128347_("effect", 1.0);
            entity.getPersistentData().m_128379_("swing", true);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            var95 = entity.getPersistentData();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10004 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label222;
               }
            }

            var10004 = 0;
         }

         var95.m_128347_("BlockDamage", 2.5 + 0.25 * (double)var10004);
         entity.getPersistentData().m_128347_("BlockRange", (double)((entity.m_20206_() + entity.m_20205_()) / 2.0F));
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)(garuda ? 5 : 20) && entity.getPersistentData().m_128459_("cnt1") % 5.0 == 1.0 && (entity instanceof GeoEntity || entity instanceof Player)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity123 = (LivingEntity)entity;
               if (_livingEntity123.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity123.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(1.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)(garuda ? 15 : 30)) {
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
               if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                  if (!garuda) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.5);
                     }

                     entity.m_6021_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-6.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
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

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 50, 1.0, 1.0, 1.0, 0.5);
                     }
                  } else {
                     entity.m_6021_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-1.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
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

            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
