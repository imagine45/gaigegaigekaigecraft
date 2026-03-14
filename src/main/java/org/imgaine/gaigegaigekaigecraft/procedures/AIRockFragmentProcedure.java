package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.Gravestone3Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIRockFragmentProcedure {
   public AIRockFragmentProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double loop_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         double entity_size = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("skill") != 1706.0) {
            if (entity instanceof Gravestone3Entity && !entity.m_20096_()) {
               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), Math.min(entity.m_20184_().m_7098_(), -0.25), entity.m_20184_().m_7094_()));
            }

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               entity.getPersistentData().m_128347_("yaw_fix", (Math.random() - 0.5) * 2.0);
               entity.getPersistentData().m_128347_("pitch_fix", (Math.random() - 0.5) * 2.0);
               entity.getPersistentData().m_128347_("cnt3", 5.0);
               if (entity.getPersistentData().m_128459_("skill") >= 400.0 && entity.getPersistentData().m_128459_("skill") < 500.0) {
                  if (entity instanceof RockFragmentEntity) {
                     RockFragmentEntity _datEntSetL = (RockFragmentEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(RockFragmentEntity.DATA_Magma, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19607_, 2147483647, 0, false, false));
                     }
                  }

                  entity.m_20254_(30);
               }
            }

            if (entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") > 0.0 ? entity.getPersistentData().m_128459_("cnt3") - 1.0 : 0.0);
               if (entity instanceof Gravestone3Entity) {
                  entity.getPersistentData().m_128347_("cnt_rock", entity.getPersistentData().m_128459_("cnt_rock") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_rock") > 4.0) {
                     entity.getPersistentData().m_128347_("cnt_rock", 0.0);
                     entity.getPersistentData().m_128347_("BlockRange", 3.0 * entity_size);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)(entity.m_20206_() * entity.m_20205_()) * 0.1);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") > 8.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)(4.0 * entity_size * entity_size), 0.25 * entity_size, 0.1 * entity_size, 0.25 * entity_size, 0.1 * entity_size);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)(4.0 * entity_size * entity_size), 0.25 * entity_size, 0.1 * entity_size, 0.25 * entity_size, 0.1 * entity_size);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x, y, z, (int)(4.0 * entity_size * entity_size), 0.25 * entity_size, 0.1 * entity_size, 0.25 * entity_size, 0.1 * entity_size);
                  }

                  entity.getPersistentData().m_128347_("Damage", 10.0 * entity_size);
                  entity.getPersistentData().m_128347_("Range", 3.0 * entity_size);
                  entity.getPersistentData().m_128347_("knockback", 0.2);
                  if (entity instanceof RockFragmentEntity) {
                     RockFragmentEntity _datEntL40 = (RockFragmentEntity)entity;
                     if ((Boolean)_datEntL40.m_20088_().m_135370_(RockFragmentEntity.DATA_Magma)) {
                        entity.getPersistentData().m_128347_("effect", 10.0);
                     }
                  }

                  RangeAttackProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("BlockRange", 3.0 * entity_size);
                  entity.getPersistentData().m_128347_("BlockDamage", 2.0 * entity_size);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("yaw_fix", (Math.random() - 0.5) * 2.0);
                  entity.getPersistentData().m_128347_("pitch_fix", (Math.random() - 0.5) * 2.0);
               } else {
                  entity.getPersistentData().m_128347_("Damage", 0.0);
               }

               entity.getPersistentData().m_128347_("cnt2", 0.0);
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               speed = Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_() + entity.m_20184_().m_7098_() * entity.m_20184_().m_7098_());
               if (!(entity.getPersistentData().m_128459_("cnt2") > 8.0) && !(speed > 1.0)) {
                  entity.getPersistentData().m_128347_("Damage", 0.0);
               } else {
                  entity.getPersistentData().m_128347_("Damage", 10.0 * entity_size);
                  entity.getPersistentData().m_128347_("Range", 3.0 * entity_size);
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  if (entity instanceof RockFragmentEntity) {
                     RockFragmentEntity _datEntL61 = (RockFragmentEntity)entity;
                     if ((Boolean)_datEntL61.m_20088_().m_135370_(RockFragmentEntity.DATA_Magma)) {
                        entity.getPersistentData().m_128347_("effect", 10.0);
                     }
                  }

                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                  if (speed > 1.0) {
                     x_power = entity.m_20184_().m_7096_() / speed;
                     y_power = entity.m_20184_().m_7098_() / speed;
                     z_power = entity.m_20184_().m_7094_() / speed;
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
                     z_pos = entity.m_20189_();

                     for(int index0 = 0; index0 < (int)speed; ++index0) {
                        entity.getPersistentData().m_128347_("Damage", Math.min(10.0 * entity_size * (1.0 + speed * 0.2), 15.0));
                        entity.getPersistentData().m_128347_("Range", 3.0);
                        entity.getPersistentData().m_128347_("knockback", Math.min(0.6 + speed * 0.2, 1.5));
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        x_pos += x_power;
                        y_pos += y_power;
                        z_pos += z_power;
                     }
                  }

                  speed = Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_());
                  if (entity instanceof RockFragmentEntity) {
                     if (!(speed > 0.5) && !(entity.getPersistentData().m_128459_("cnt3") > 0.0)) {
                        BulletDomainHit2Procedure.execute(world, entity);
                     } else if (!entity.getPersistentData().m_128471_("Stop")) {
                        for(int index1 = 0; index1 < 25; ++index1) {
                           entity.m_146922_((float)((double)entity.m_146908_() + entity.getPersistentData().m_128459_("yaw_fix")));
                           entity.m_146926_((float)((double)entity.m_146909_() + entity.getPersistentData().m_128459_("pitch_fix")));
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
                     } else {
                        entity.getPersistentData().m_128379_("Stop", false);
                     }
                  }
               }
            }
         }

         if (!entity.m_6084_() || entity.getPersistentData().m_128459_("cnt1") > 200.0 || entity.getPersistentData().m_128459_("skill") == 0.0) {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            if (!entity.m_6084_()) {
               label133: {
                  if (entity instanceof RockFragmentEntity) {
                     RockFragmentEntity _datEntL99 = (RockFragmentEntity)entity;
                     if ((Boolean)_datEntL99.m_20088_().m_135370_(RockFragmentEntity.DATA_Magma)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, (int)(5.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
                        }
                        break label133;
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)(10.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)(10.0 * entity_size * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size);
               }
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
