package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWater2Procedure {
   public AIWater2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_attack = false;
         boolean type = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double rad = 0.0;
         double tsuki7_mode = 0.0;
         double range = 0.0;
         double cnt1_local = 0.0;
         double rad_now = 0.0;
         double dis = 0.0;
         double cnt2 = 0.0;
         double HP = 0.0;
         double CNT6 = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            logic_attack = false;
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.getPersistentData().getDouble("skill") > 0.0 && entity_a.getPersistentData().getDouble("cnt4") == 0.0) {
                  logic_attack = true;
                  if (!(entity_a instanceof Player)) {
                     entity.getPersistentData().putDouble("x_power", 0.0);
                     entity.getPersistentData().putDouble("y_power", -0.5);
                     entity.getPersistentData().putDouble("z_power", 0.0);
                  } else {
                     entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                     entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                     entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                  }

                  entity.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
                  }

                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), entity_a.getPersistentData().getDouble("cnt6")));
               }
            }

            if (!logic_attack || !entity.isAlive()) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, entity.getPersistentData().getDouble("y_power") * 0.75 + 0.5, entity.getPersistentData().getDouble("z_power") * 0.75));
            }

            for(int index0 = 0; index0 < 2; ++index0) {
               entity.setYRot((float)((double)entity.getYRot() + 22.5 * Math.random()));
               entity.setXRot(0.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               if (entity.getPersistentData().getDouble("cnt1") > 5.0 && entity.onGround() || entity.getPersistentData().getDouble("cnt1") > 100.0 || !entity.isAlive()) {
                  entity.getPersistentData().putDouble("cnt2", 1.0);
               }
            } else {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 0, false, false));
                  }
               }

               double var10000;
               int var10002;
               label97: {
                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                  var10000 = entity.getPersistentData().getDouble("cnt2");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10002 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label97;
                     }
                  }

                  var10002 = 0;
               }

               if (var10000 < (double)(15 + var10002) * CNT6) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 15, 0.25, 0.25, 0.25, 2.0);
                  }

                  entity.getPersistentData().putDouble("NameRanged", entity.getPersistentData().getDouble("NameRanged_ranged"));

                  for(int index1 = 0; index1 < 2; ++index1) {
                     entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                     entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                     entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                     x_pos = entity.getX() + entity.getLookAngle().x * 2.0;
                     y_pos = entity.getY() + entity.getLookAngle().y * 2.0;
                     z_pos = entity.getZ() + entity.getLookAngle().z * 2.0;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           entityinstance.setYRot(entity.getYRot());
                           entityinstance.setXRot(entity.getXRot());
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           entityinstance.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                           entityinstance.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * 0.75);
                           entityinstance.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * 0.75);
                           entityinstance.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * 0.75);
                           entityinstance.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, entity.getPersistentData().getDouble("y_power") * 0.75, entity.getPersistentData().getDouble("z_power") * 0.75));
                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }

                     entity.setYRot((float)((double)entity.getYRot() + 22.5 * Math.random()));
                     entity.setXRot(0.0F);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }
               } else if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
