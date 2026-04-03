package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.BloodBallEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ChosoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade015Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ConvergenceEffectStartedappliedProcedure {
   public ConvergenceEffectStartedappliedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         label90: {
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double num1 = 0.0;
            double num2 = 0.0;
            double num_blood = 0.0;
            num1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            num2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            if (entity instanceof Player) {
               if (num1 != 10.0 && num2 != 10.0 && num1 != 803.0 && num2 != 803.0) {
                  break label90;
               }
            } else if (!(entity instanceof ChosoEntity) && !(entity instanceof CursedSpiritGrade015Entity)) {
               break label90;
            }

            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            x_pos = entity.getX() + Math.cos(Math.toRadians(yaw + 90.0)) * Math.cos(Math.toRadians(pitch)) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(Math.toRadians(pitch)) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(Math.toRadians(yaw + 90.0)) * Math.cos(Math.toRadians(pitch)) * (double)(1.0F + entity.getBbWidth());
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(32.0), (e) -> true)) {
               if (entityiterator instanceof BloodBallEntity && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID())) {
                  ++num_blood;
                  if (num_blood > 3.0 && !entityiterator.level().isClientSide()) {
                     entityiterator.discard();
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLOOD_BALL.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                     }
                  }

                  entityinstance.getPersistentData().putBoolean("death_painting", num1 == 10.0 || num2 == 10.0 || num1 == 803.0 || num2 == 803.0 || entity.getPersistentData().getBoolean("CursedSpirit") || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting"))));
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            entity.setYRot((float)yaw);
            entity.setXRot((float)pitch);
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

         if (entity instanceof Player) {
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
