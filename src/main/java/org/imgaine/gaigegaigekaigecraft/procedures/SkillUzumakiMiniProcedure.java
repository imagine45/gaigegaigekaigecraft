package org.imgaine.gaigegaigekaigecraft.procedures;

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
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
               }
            }

            num1 = entity.getPersistentData().getDouble("cnt1") / 19.5;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SOUL, x_pos, y_pos, z_pos, (int)(1.0 * num1), 0.1 * num1, 0.1 * num1, 0.1 * num1, 0.1 * num1);
            }

            y_pos = -200.0 - Math.random();
            if (entity.getPersistentData().getDouble("cnt2") == 0.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.CHICKEN.spawn(_level, BlockPos.containing(entity.getX(), y_pos, entity.getZ()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }

            reChange = false;
            Vec3 _center = new Vec3(entity.getX(), y_pos, entity.getZ());

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.05), (e) -> true)) {
               if (entityiterator instanceof Chicken && y_pos == entityiterator.getY()) {
                  if (!entityiterator.level().isClientSide()) {
                     entityiterator.discard();
                  }

                  reChange = true;
                  break;
               }
            }

            if (reChange) {
               entity.getPersistentData().putDouble("cnt2", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 0.5F, 0.25F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 0.5F, 0.25F, false);
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().getDouble("skill") == 0.0) {
                  if (GetDistanceProcedure.execute(entity) >= 10.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().getDouble("skill") > 0.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().getBoolean("PRESS_Z")) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt4") >= 200.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var100 = ((Entity)var10000).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var100 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var101;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var101 = _mobEnt.getTarget();
               } else {
                  var101 = null;
               }

               z_pos = ((Entity)var101).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 19.0));
               entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
            }
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") == 1.0) {
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("x_pos"));
               entity.getPersistentData().putDouble("cnt7", entity.getPersistentData().getDouble("y_pos"));
               entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("z_pos"));
            }

            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            x_dis = entity.getPersistentData().getDouble("x_power") * 0.02;
            y_dis = entity.getPersistentData().getDouble("y_power") * 0.02;
            z_dis = entity.getPersistentData().getDouble("z_power") * 0.02;
            distance = 0.0;
            range = 5.0 + Math.min(rnd / 10.0, 10.0);
            rnd = 1.0;

            for(int index0 = 0; index0 < 45; ++index0) {
               ++distance;
               if (distance > 0.0) {
                  distance = -5.0;
                  entity.getPersistentData().putDouble("Damage", 24.0);
                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * Math.pow(0.98, Math.max(entity.getPersistentData().getDouble("cnt3") - 2.0, 0.0)));
                  entity.getPersistentData().putDouble("Range", 3.0);
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SOUL, x_pos, y_pos, z_pos, 2, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.min(Math.sqrt(rnd) * 0.5, 10.0));
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.sqrt(rnd) * 0.1, Math.min(Math.sqrt(rnd) * 0.5, 10.0));
                  }

                  entity.getPersistentData().putDouble("Damage", 24.0);
                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * Math.pow(0.98, Math.max(entity.getPersistentData().getDouble("cnt3") - 2.0, 0.0)));
                  entity.getPersistentData().putDouble("Range", 3.0);
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("BlockRange", 3.0);
                  entity.getPersistentData().putDouble("BlockDamage", 3.0);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 2.0);
                  break;
               }

               x_pos += x_dis;
               y_pos += y_dis;
               z_pos += z_dis;
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            ParticleGeneratorProcedure.execute(world, Math.sqrt(rnd) * 0.1, 2.0 * range, 5.0, 4.0, entity.getPersistentData().getDouble("cnt5"), entity.getPersistentData().getDouble("cnt5") + entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("cnt7"), entity.getPersistentData().getDouble("cnt7") + entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("cnt8"), entity.getPersistentData().getDouble("cnt8") + entity.getPersistentData().getDouble("z_power"), "minecraft:soul");
            if (entity.getPersistentData().getDouble("cnt2") > 20.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
