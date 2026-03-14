package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HumanCarEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TruckEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIHumanCarProcedure {
   public AIHumanCarProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_move = false;
         boolean logic_autoMoving = false;
         String ridingUUID = "";
         Entity entity_a = null;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double power = 0.0;
         double boost = 0.0;
         double old_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double old_skill = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double dis = 0.0;
         double old_dis = 0.0;
         double entity_size = 0.0;
         double distance = 0.0;
         double CNT6 = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if ((entity instanceof TruckEntity || entity instanceof CarEntity) && entity.getPersistentData().m_128471_("Shikigami") && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_(MobEffects.f_19597_);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            logic_move = var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0;
            logic_autoMoving = logic_move;
            if (logic_move) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               y_pos = ((Entity)var10000).m_20186_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               z_pos = ((Entity)var10000).m_20189_();
            }

            if (entity.m_20160_()) {
               logic_move = true;
               if (entity.m_146895_() instanceof LivingEntity) {
                  if (entity.m_146895_() instanceof Player) {
                     logic_autoMoving = false;
                     entity.getPersistentData().m_128347_("cnt_target", 0.0);
                  } else {
                     Entity var52 = entity.m_146895_();
                     if (var52 instanceof Mob) {
                        Mob _mobEnt = (Mob)var52;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity && entity.m_146895_().getPersistentData().m_128459_("cnt_target") > 6.0) {
                        logic_autoMoving = true;
                        Entity var53 = entity.m_146895_();
                        if (var53 instanceof Mob) {
                           Mob _mobEnt = (Mob)var53;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        x_pos = ((Entity)var10000).m_20185_();
                        var53 = entity.m_146895_();
                        if (var53 instanceof Mob) {
                           Mob _mobEnt = (Mob)var53;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        y_pos = ((Entity)var10000).m_20186_();
                        var53 = entity.m_146895_();
                        if (var53 instanceof Mob) {
                           Mob _mobEnt = (Mob)var53;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        z_pos = ((Entity)var10000).m_20189_();
                        entity_a = entity.m_146895_();
                     }
                  }
               }
            }

            if (logic_autoMoving && entity.m_20096_()) {
               power = (double)Math.round(Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_()) * 72.0);
               if (power >= 0.2) {
                  yaw = (double)(entity.m_146908_() % 360.0F);
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.m_146922_(entity.m_146908_() % 360.0F);
                  entity.m_146926_(0.0F);
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
                     yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 16.0;
                  } else {
                     yaw -= Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / 16.0;
                  }

                  entity.m_146922_((float)yaw);
                  entity.m_146926_(0.0F);
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

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               old_dis = Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_()) + 0.4;
               if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * 3.0) {
                  x_power = entity.m_20184_().m_7096_() - 0.2;
               } else {
                  x_power = entity.m_20184_().m_7096_() + 0.2;
               }

               if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * 3.0) {
                  z_power = entity.m_20184_().m_7094_() - 0.2;
               } else {
                  z_power = entity.m_20184_().m_7094_() + 0.2;
               }

               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 0.0 && dis < old_dis) {
                  x_power *= old_dis / dis;
                  z_power *= old_dis / dis;
               }

               entity.m_20256_(new Vec3(x_power, entity.m_20184_().m_7098_(), z_power));
               if (entity_a instanceof LivingEntity) {
                  entity_a.m_146922_((float)yaw);
                  entity_a.m_146926_(0.0F);
                  entity_a.m_5618_(entity_a.m_146908_());
                  entity_a.m_5616_(entity_a.m_146908_());
                  entity_a.f_19859_ = entity_a.m_146908_();
                  entity_a.f_19860_ = entity_a.m_146909_();
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity_a.m_20256_(new Vec3(x_power, entity_a.m_20184_().m_7098_(), z_power));
               }
            }

            if (logic_move) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               power = (double)Math.round(Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_()) * 72.0);
               if (entity.getPersistentData().m_128459_("old_power") - power > 8.0 && entity.getPersistentData().m_128459_("old_power") > 40.0 && entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
                     }
                  }
               }

               label247: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt83 = (LivingEntity)entity;
                     if (_livEnt83.m_21023_(MobEffects.f_19596_)) {
                        break label247;
                     }
                  }

                  boost = (double)Math.round(power / 4.0 - 4.0);
                  if (boost > 5.0) {
                     boost = 5.0;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 10, (int)boost, false, false));
                     }
                  }
               }

               if (power > 1.0) {
                  if (!entity.getPersistentData().m_128471_("start")) {
                     entity.getPersistentData().m_128379_("start", true);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_() + entity.m_20154_().f_82479_ * -3.0 * entity_size, entity.m_20186_() + 0.3 * entity_size, entity.m_20189_() + entity.m_20154_().f_82481_ * -3.0 * entity_size, 1, 0.1, 0.1, 0.1, 0.03);
                  }

                  old_skill = 0.0;
                  entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.5);
                  entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.5);
                  entity.getPersistentData().m_128347_("skill", 1.0);
                  entity.getPersistentData().m_128347_("Damage", Math.min(power * 0.2, 24.0));
                  entity.getPersistentData().m_128347_("Range", (double)(3.0F + entity.m_20205_()));
                  entity.getPersistentData().m_128347_("knockback", 0.5 + Math.min(power * 0.2, 4.0));
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                  entity.getPersistentData().m_128347_("skill", old_skill);
               } else {
                  entity.getPersistentData().m_128379_("start", false);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }

            entity.getPersistentData().m_128347_("old_power", power);
         } else {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            if (entity instanceof HumanCarEntity) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * entity_size), (double)entity.m_20205_() * 0.2, (double)entity.m_20206_() * 0.2, (double)entity.m_20205_() * 0.2, 1.0);
               }

               if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()));
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()), false);
                     }
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * entity_size), (double)entity.m_20205_() * 0.2, (double)entity.m_20206_() * 0.2, (double)entity.m_20205_() * 0.2, 1.0);
               }

               if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt3", 1.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, (float)(0.5 + Math.random()));
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, (float)(0.5 + Math.random()), false);
                     }
                  }
               }
            }
         }

      }
   }
}
