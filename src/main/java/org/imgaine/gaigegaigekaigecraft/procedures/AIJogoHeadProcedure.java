package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIJogoHeadProcedure {
   public AIJogoHeadProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_knockback = 0.0;
         double y_knockback = 0.0;
         double z_knockback = 0.0;
         double dis = 0.0;
         double Power = 0.0;
         double speed = 0.0;
         double y_power = 0.0;
         if (entity.m_20096_()) {
            entity.getPersistentData().m_128347_("yaw", (Math.random() - 0.5) * 2.0);
            entity.getPersistentData().m_128347_("pitch", (Math.random() - 0.5) * 2.0);
         } else if (!entity.getPersistentData().m_128471_("Stop")) {
            speed = Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0));

            for(int index0 = 0; index0 < 45; ++index0) {
               entity.m_146922_((float)((double)entity.m_146908_() + entity.getPersistentData().m_128459_("yaw") * speed));
               entity.m_146926_((float)((double)entity.m_146909_() + entity.getPersistentData().m_128459_("pitch") * speed));
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

         entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt_x") >= 5.0) {
            Vec3 _center = new Vec3(x, y + (double)entity.m_20206_() * 0.5, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)(entity.m_20205_() * 2.0F) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && entityiterator.m_6084_()) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  Power = Math.sqrt(Math.pow(entityiterator.m_20184_().m_7096_(), 2.0) + Math.pow(entityiterator.m_20184_().m_7094_(), 2.0)) * 2.0;
                  if (Power > 0.2 || entityiterator instanceof Player) {
                     if (entityiterator instanceof Player) {
                        Power = Math.max(Power, 0.1);
                     }

                     Power = Math.max(Power * 2.0, 0.5);
                     logic_a = true;
                     if (!entityiterator.m_20096_()) {
                        Power *= 2.0;
                        y_power = 0.6;
                     } else {
                        y_power = 0.3;
                     }

                     x_knockback = entity.m_20185_() - entityiterator.m_20185_();
                     y_knockback = entity.m_20186_() - entityiterator.m_20186_();
                     z_knockback = entity.m_20189_() - entityiterator.m_20189_();
                     dis = Math.abs(x_knockback) + Math.abs(y_knockback) + Math.abs(z_knockback);
                     if (dis != 0.0) {
                        x_knockback = x_knockback / dis * 3.0;
                        y_knockback = y_knockback / dis * 3.0;
                        z_knockback = z_knockback / dis * 3.0;
                     } else {
                        x_knockback = 0.0;
                        y_knockback = 0.0;
                        z_knockback = 0.0;
                     }

                     x_knockback = x_knockback * Power + entityiterator.m_20184_().m_7096_() * 2.0;
                     y_knockback = Math.min((y_knockback + y_power) * Power, 2.0);
                     z_knockback = z_knockback * Power + entityiterator.m_20184_().m_7094_() * 2.0;
                     entity.m_20256_(new Vec3(x_knockback, y_knockback, z_knockback));
                     if (Power > 1.0) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:punch")), SoundSource.NEUTRAL, 0.25F, 0.5F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:punch")), SoundSource.NEUTRAL, 0.25F, 0.5F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), x, y, z, 0, 0.1, 0.1, 0.1, 0.0);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), x, y + 0.25, z, (int)Math.round(Math.min(Power * 2.0, 10.0)), 0.1, 0.1, 0.1, 0.1 + Power * 0.25);
                     }
                  }
                  break;
               }
            }
         }

      }
   }
}
