package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade04Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade12Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class Cockroach1Procedure {
   public Cockroach1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
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
         double CNT6 = 0.0;
         double y_velocity = 0.0;
         boolean logic_a = false;
         boolean pitch = false;
         boolean cockroach = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
         entity.f_19789_ = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            int var10001;
            label167: {
               yaw = (double)entity.m_146908_();
               dis = 0.0;
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + -6.0;
               z_pos = entity.m_20189_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label167;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(50 + var10001 * 10);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TORNADO.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.m_146922_((float)yaw);
                  entityinstance.m_146926_((float)dis);
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
                     LivingEntity _livingEntity18 = (LivingEntity)entityinstance;
                     if (_livingEntity18.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity18.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity22 = (LivingEntity)entityinstance;
                     if (_livingEntity22.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity22.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(6.0);
                     }
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            entity.getPersistentData().m_128379_("PRESS_Z", true);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 12.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (!(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt2") >= 80.0) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 40.0));
            if (entity.getPersistentData().m_128459_("cnt2") >= 40.0 && entity instanceof Player) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }
         }

         y_velocity = Math.min(Math.max(y_velocity, -0.5), 0.5);
         if (GetHeightFromGroundProcedure.execute(world, entity) < 6.0) {
            y_velocity = entity.m_20184_().m_7098_() + 0.1;
         } else if (GetHeightFromGroundProcedure.execute(world, entity) > 8.0) {
            y_velocity = entity.m_20184_().m_7098_() - 0.1;
         } else {
            y_velocity = 0.0;
         }

         if (!(entity instanceof Player) && !(entity instanceof CursedSpiritGrade12Entity)) {
            entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * 0.3, y_velocity, entity.m_20154_().f_82481_ * 0.3));
         } else {
            entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), y_velocity, entity.m_20184_().m_7094_()));
         }

         num1 = Math.toRadians(entity.getPersistentData().m_128459_("cnt3"));
         num2 = (double)entity.m_20205_() + Math.min(0.1 * entity.getPersistentData().m_128459_("cnt1"), 4.0);
         y_pos = y;
         cockroach = entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 23.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 23.0 : entity instanceof CursedSpiritGrade04Entity;
         entity.getPersistentData().m_128347_("y_knockback", 0.2);

         for(int index0 = 0; index0 < 4; ++index0) {
            for(int index1 = 0; index1 < 15; ++index1) {
               x_pos = x + Math.sin(num1) * num2;
               z_pos = z + Math.cos(num1) * num2;
               if (Math.random() < 0.5) {
                  if (cockroach) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get(), x_pos, y_pos, z_pos, 1, 1.0, 1.0, 1.0, 0.1);
                     }
                  } else {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, 1, 0.5, 0.5, 0.5, 0.1);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 1, 0.5, 0.5, 0.5, 0.1);
                     }
                  }
               }

               num1 += Math.toRadians(Math.random() * 10.0);
            }

            entity.getPersistentData().m_128347_("BlockRange", 1.5 + num2);
            entity.getPersistentData().m_128347_("BlockDamage", 0.2);
            entity.getPersistentData().m_128379_("noEffect", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            num1 += Math.toRadians(90.0);
            num2 = Math.max(num2 - (double)(entity.m_20205_() * 2.0F), 1.0);
            --y_pos;
         }

         entity.getPersistentData().m_128347_("y_knockback", 0.0);
         entity.getPersistentData().m_128347_("cnt3", Math.toDegrees(num1));
         if (cockroach) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.2F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > 80.0 || entity.getPersistentData().m_128459_("cnt1") > 40.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
