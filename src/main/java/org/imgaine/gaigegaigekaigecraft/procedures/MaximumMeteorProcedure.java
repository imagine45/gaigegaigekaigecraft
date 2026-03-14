package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MaximumMeteorProcedure {
   public MaximumMeteorProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean pitch = false;
         boolean logic_b = false;
         boolean player = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double HP = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double num1 = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double xp2 = 0.0;
         double yp2 = 0.0;
         double zp2 = 0.0;
         double power_attenuation = 0.0;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double z_knockback = 0.0;
         double y_knockback = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               entity.getPersistentData().m_128347_("cnt3", 1.0);
               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), 3.0, entity.m_20184_().m_7094_()));
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 20, 0.0, 0.0, 0.0, 1.0);
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.m_20184_().m_7098_() < 0.1 || entity.getPersistentData().m_128459_("cnt1") > 30.0) {
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                  }
               }
            }

            entity.getPersistentData().m_128347_("BlockRange", 12.0);
            entity.getPersistentData().m_128347_("BlockDamage", 8.0);
            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y + entity.m_20184_().m_7098_(), z, entity);
            entity.getPersistentData().m_128347_("BlockRange", 12.0);
            entity.getPersistentData().m_128347_("BlockDamage", 8.0);
            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            if (entity.getPersistentData().m_128459_("cnt1") > 0.0) {
               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               num1 = Math.toRadians(entity.getPersistentData().m_128459_("cnt3"));
               num2 = Math.min(8.0, entity.getPersistentData().m_128459_("cnt1"));
               dis = Math.min(1.5, entity.getPersistentData().m_128459_("cnt1") / 15.0);

               for(int index0 = 0; index0 < 12; ++index0) {
                  x_pos += x_power / 12.0;
                  y_pos += y_power / 12.0;
                  z_pos += z_power / 12.0;

                  for(int index1 = 0; index1 < 2; ++index1) {
                     logic_a = !logic_a;
                     if (logic_a) {
                        xp2 = x_pos + Math.sin(num1) * num2;
                        yp2 = y_pos;
                        zp2 = z_pos + Math.cos(num1) * num2;
                     } else {
                        xp2 = x_pos - Math.sin(num1) * num2;
                        yp2 = y_pos;
                        zp2 = z_pos - Math.cos(num1) * num2;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, x_pos, y_pos, z_pos, 2, dis, dis, dis, dis * 0.1);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, 2, dis, dis, dis, dis * 0.1);
                  }

                  num1 += Math.toRadians(Math.random() * 10.0);
               }

               entity.getPersistentData().m_128347_("cnt3", Math.toDegrees(num1));
               entity.getPersistentData().m_128347_("old_x", x);
               entity.getPersistentData().m_128347_("old_y", y);
               entity.getPersistentData().m_128347_("old_z", z);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            x_pos = x;
            y_pos = y - 5.0;
            z_pos = z;
            dis = Math.min(entity.getPersistentData().m_128459_("cnt2") * 0.1, 1.5);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x, y_pos, z, 25, dis, dis, dis, dis * 0.1);
            }

            num1 = Math.toRadians(entity.getPersistentData().m_128459_("cnt3"));
            num2 = Math.min(8.0, entity.getPersistentData().m_128459_("cnt2"));
            dis = Math.min(1.5, entity.getPersistentData().m_128459_("cnt2") / 8.0);

            for(int index2 = 0; index2 < 12; ++index2) {
               for(int index3 = 0; index3 < 2; ++index3) {
                  logic_a = !logic_a;
                  if (logic_a) {
                     xp2 = x_pos + Math.sin(num1) * num2;
                     yp2 = y_pos;
                     zp2 = z_pos + Math.cos(num1) * num2;
                  } else {
                     xp2 = x_pos - Math.sin(num1) * num2;
                     yp2 = y_pos;
                     zp2 = z_pos - Math.cos(num1) * num2;
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123744_, xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                  }
               }

               num1 += Math.toRadians(Math.random() * 10.0);
            }

            entity.getPersistentData().m_128347_("cnt3", Math.toDegrees(num1));
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), 0.0, entity.m_20184_().m_7094_()));
            if (entity.getPersistentData().m_128459_("cnt2") > 30.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               int var10001;
               label176: {
                  x_pos = x;
                  y_pos = y + Math.random() * 0.1;
                  z_pos = z;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label176;
                     }
                  }

                  var10001 = 0;
               }

               HP = (double)(400 + var10001 * 40);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.METEOR.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x, y_pos, z), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity58 = (LivingEntity)entityinstance;
                        if (_livingEntity58.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity58.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entity.m_20329_(entityinstance);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y_pos, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 15.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y_pos, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 15.0F, 0.5F, false);
                  }
               }

               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         if (entity.getPersistentData().m_128459_("skill") > 0.0) {
            CNT6 = 1.0;
            power_attenuation = 1.0;
            logic_b = false;
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(22.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof FallingBlockEntity || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_living")))) {
                  x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                  y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                  z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                  dis = Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0));
                  if (dis != 0.0) {
                     x_knockback = x_knockback / dis * -2.4;
                     y_knockback = y_knockback / dis * -2.4;
                     z_knockback = z_knockback / dis * -2.4;
                     if (!(x_knockback * 1.1 < entityiterator.m_20184_().m_7096_()) && !(x_knockback * 0.9 > entityiterator.m_20184_().m_7096_())) {
                        x_knockback = entityiterator.m_20184_().m_7096_();
                     } else {
                        x_knockback = entityiterator.m_20184_().m_7096_() + x_knockback * 0.05;
                     }

                     if (!(y_knockback * 1.1 < entityiterator.m_20184_().m_7098_()) && !(y_knockback * 0.9 > entityiterator.m_20184_().m_7098_())) {
                        y_knockback = entityiterator.m_20184_().m_7098_();
                     } else {
                        y_knockback = entityiterator.m_20184_().m_7098_() + y_knockback * 0.05;
                     }

                     if (!(z_knockback * 1.1 < entityiterator.m_20184_().m_7094_()) && !(z_knockback * 0.9 > entityiterator.m_20184_().m_7094_())) {
                        z_knockback = entityiterator.m_20184_().m_7094_();
                     } else {
                        z_knockback = entityiterator.m_20184_().m_7094_() + z_knockback * 0.05;
                     }

                     if (entityiterator.m_20096_()) {
                        y_knockback = Math.max(y_knockback, 0.5 * (1.2 - power_attenuation) * CNT6);
                     }
                  }

                  entityiterator.m_20256_(new Vec3(x_knockback, y_knockback, z_knockback));
               }
            }
         }

      }
   }
}
