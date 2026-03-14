package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillUzumakiMiniProcedure {
   public SkillUzumakiMiniProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         String STR2 = "";
         boolean adult = false;
         boolean reChange = false;
         boolean player = false;
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double count_spirit = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         double x_dis = 0.0;
         double y_dis = 0.0;
         double z_dis = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         player = entity instanceof Player;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") <= 10.0) {
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 4, false, false));
               }
            }

            num1 = entity.getPersistentData().m_128459_("cnt1") / 19.5;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, (int)(1.0 * num1), 0.1 * num1, 0.1 * num1, 0.1 * num1, 0.1 * num1);
            }

            y_pos = -200.0 - Math.random();
            if (entity.getPersistentData().m_128459_("cnt2") == 0.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.f_20555_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), y_pos, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            reChange = false;
            Vec3 _center = new Vec3(entity.m_20185_(), y_pos, entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.05), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof Chicken && y_pos == entityiterator.m_20186_()) {
                  if (!entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }

                  reChange = true;
                  break;
               }
            }

            if (reChange) {
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 0.5F, 0.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 0.5F, 0.25F, false);
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
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") == 0.0) {
                  if (GetDistanceProcedure.execute(entity) >= 10.0) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") > 0.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().m_128471_("PRESS_Z")) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") >= 200.0) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }

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

               double var100 = ((Entity)var10000).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var100 + (double)((Entity)var10001).m_20206_() * 0.5;
               LivingEntity var101;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var101 = _mobEnt.m_5448_();
               } else {
                  var101 = null;
               }

               z_pos = ((Entity)var101).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 19.0));
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt3") == 1.0) {
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("x_pos"));
               entity.getPersistentData().m_128347_("cnt7", entity.getPersistentData().m_128459_("y_pos"));
               entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("z_pos"));
            }

            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            x_dis = entity.getPersistentData().m_128459_("x_power") * 0.02;
            y_dis = entity.getPersistentData().m_128459_("y_power") * 0.02;
            z_dis = entity.getPersistentData().m_128459_("z_power") * 0.02;
            distance = 0.0;
            range = 5.0 + Math.min(rnd / 10.0, 10.0);
            rnd = 1.0;

            for(int index0 = 0; index0 < 45; ++index0) {
               ++distance;
               if (distance > 0.0) {
                  distance = -5.0;
                  entity.getPersistentData().m_128347_("Damage", 24.0);
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.pow(0.98, Math.max(entity.getPersistentData().m_128459_("cnt3") - 2.0, 0.0)));
                  entity.getPersistentData().m_128347_("Range", 3.0);
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, 2, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.min(Math.sqrt(rnd) * 0.5, 10.0));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.min(Math.sqrt(rnd) * 0.5, 10.0));
                  }

                  entity.getPersistentData().m_128347_("Damage", 24.0);
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.pow(0.98, Math.max(entity.getPersistentData().m_128459_("cnt3") - 2.0, 0.0)));
                  entity.getPersistentData().m_128347_("Range", 3.0);
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  entity.getPersistentData().m_128347_("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("BlockRange", 3.0);
                  entity.getPersistentData().m_128347_("BlockDamage", 3.0);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 2.0);
                  break;
               }

               x_pos += x_dis;
               y_pos += y_dis;
               z_pos += z_dis;
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            ParticleGeneratorProcedure.execute(world, Math.sqrt(rnd) * 0.1, 2.0 * range, 5.0, 4.0, entity.getPersistentData().m_128459_("cnt5"), entity.getPersistentData().m_128459_("cnt5") + entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("cnt7"), entity.getPersistentData().m_128459_("cnt7") + entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("cnt8"), entity.getPersistentData().m_128459_("cnt8") + entity.getPersistentData().m_128459_("z_power"), "minecraft:soul");
            if (entity.getPersistentData().m_128459_("cnt2") > 20.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
