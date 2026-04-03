package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class JogoFlame4Procedure {
   public JogoFlame4Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double old_skill = 0.0;
         double distance = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         old_skill = entity.getPersistentData().getDouble("skill");
         entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
         if (entity.getPersistentData().getDouble("cnt5") == 0.0) {
            ChojuroStoneHandProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("skill") == 0.0) {
            entity.getPersistentData().putDouble("cnt5", 1.0);
         }

         double var10000;
         int var10002;
         label47: {
            var10000 = entity.getPersistentData().getDouble("cnt4");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10002 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label47;
               }
            }

            var10002 = 0;
         }

         if (var10000 <= (double)Math.min(10 + var10002, 20)) {
            entity.getPersistentData().putDouble("skill", old_skill);
            yaw = Math.toRadians((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -90.0, 90.0));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = (double)(1.0F + entity.getBbWidth());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

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

                  entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.25);
                  entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.25);
                  entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.25);
                  entityinstance.setDeltaMovement(new Vec3(entity.getLookAngle().x * 1.25, entity.getLookAngle().y * 1.25, entity.getLookAngle().z * 1.25));
                  if (entityinstance instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntSetI = (EntityWaterEntity)entityinstance;
                     _datEntSetI.getEntityData().set(EntityWaterEntity.DATA_type, 2);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt5") != 0.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
