package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentMiniEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AISeaSerpent2Procedure {
   public AISeaSerpent2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double z_pwoer = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         double CNT6 = 0.0;
         double strength = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("old_x") == 0.0) {
            entity.getPersistentData().putDouble("old_x", entity.getX() + entity.getLookAngle().x * (double)entity.getBbWidth() * 0.25);
            entity.getPersistentData().putDouble("old_y", entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getLookAngle().y * (double)entity.getBbWidth() * 0.25);
            entity.getPersistentData().putDouble("old_z", entity.getZ() + entity.getLookAngle().z * (double)entity.getBbWidth() * 0.25);
         }

         if (entity.isAlive()) {
            if (entity.getPersistentData().getDouble("cnt1") < 12.0) {
               entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * 0.6);
               entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * 0.6);
               entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * 0.6);
               x_power = entity.getPersistentData().getDouble("x_power");
               y_power = entity.getPersistentData().getDouble("y_power");
               z_pwoer = entity.getPersistentData().getDouble("z_power");
               entity.getPersistentData().putDouble("speed", Math.max(0.5, entity.getPersistentData().getDouble("speed")));
               if (entity instanceof SeaSerpentEntity) {
                  entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 11.0));
               }
            } else {
               if (entity.getPersistentData().getDouble("cnt1") == 12.0 && entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     entity.getPersistentData().putDouble("x_power", entity_a.getLookAngle().x * 3.0);
                     entity.getPersistentData().putDouble("y_power", entity_a.getLookAngle().y * 3.0);
                     entity.getPersistentData().putDouble("z_power", entity_a.getLookAngle().z * 3.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") != 12.0 && !(entity instanceof SeaSerpentEntity)) {
                  x_power = entity.getDeltaMovement().x() + (entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * entity.getPersistentData().getDouble("speed") ? -0.1 : 0.1);
                  y_power = entity.getDeltaMovement().y() + (entity.getDeltaMovement().y() > entity.getPersistentData().getDouble("y_power") * entity.getPersistentData().getDouble("speed") ? -0.1 : 0.1);
                  z_pwoer = entity.getDeltaMovement().z() + (entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * entity.getPersistentData().getDouble("speed") ? -0.1 : 0.1);
                  speed = x_power * x_power + y_power * y_power + z_power * z_power;
                  if (speed < 1.5 * entity.getPersistentData().getDouble("speed") * 1.5 * entity.getPersistentData().getDouble("speed")) {
                     speed = 1.5 * entity.getPersistentData().getDouble("speed") / Math.max(Math.sqrt(speed), 0.01);
                     x_power *= speed;
                     y_power *= speed;
                     double var10000 = z_power * speed;
                  }
               } else {
                  if (entity.getPersistentData().getDouble("cnt1") == 12.0) {
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                        }
                     }
                  }

                  x_power = entity.getPersistentData().getDouble("x_power") * entity.getPersistentData().getDouble("speed");
                  y_power = entity.getPersistentData().getDouble("y_power") * entity.getPersistentData().getDouble("speed");
                  z_pwoer = entity.getPersistentData().getDouble("z_power") * entity.getPersistentData().getDouble("speed");
                  entity.getPersistentData().putDouble("movement", 0.0);
                  entity.getPersistentData().putDouble("cnt2", 1.0);
               }
            }

            if (entity.getPersistentData().getDouble("skill") > -999.0) {
               entity.setDeltaMovement(new Vec3(x_power, y_power, z_pwoer));
            }

            if (!entity.isVehicle() && entity.getPersistentData().getDouble("skill") > -999.0) {
               y_power = entity.getX() + entity.getLookAngle().x * (double)entity.getBbWidth() * 0.25 - entity.getPersistentData().getDouble("old_x");
               y_power = entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getLookAngle().y * (double)entity.getBbWidth() * 0.25 - entity.getPersistentData().getDouble("old_y");
               z_power = entity.getZ() + entity.getLookAngle().z * (double)entity.getBbWidth() * 0.25 - entity.getPersistentData().getDouble("old_z");
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > 1.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getPersistentData().getDouble("old_x");
               y_pos = entity.getPersistentData().getDouble("old_y");
               z_pos = entity.getPersistentData().getDouble("old_z");

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  if (entity instanceof SeaSerpentMiniEntity) {
                     entity.getPersistentData().putDouble("Damage", 12.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 0.1);
                  } else {
                     entity.getPersistentData().putDouble("Damage", 14.0 * CNT6);
                     entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.25);
                     entity.getPersistentData().putDouble("y_knockback", entity.getDeltaMovement().y() * 1.25);
                     entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.25);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                  }

                  entity.getPersistentData().putDouble("Range", (double)(2.0F + entity.getBbWidth()));
                  entity.getPersistentData().putDouble("effect", 1.0);
                  entity.getPersistentData().putBoolean("swing", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               x_pos = entity.getX() + entity.getLookAngle().x * (double)entity.getBbWidth() * 0.25;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getLookAngle().y * (double)entity.getBbWidth() * 0.25;
               z_pos = entity.getZ() + entity.getLookAngle().z * (double)entity.getBbWidth() * 0.25;
               if (!(entity instanceof SeaSerpentMiniEntity)) {
                  entity.getPersistentData().putDouble("Range", (double)(1.0F + entity.getBbWidth()));
                  entity.getPersistentData().putDouble("effect", -1.0);
                  entity.getPersistentData().putDouble("knockback", 1.0);
                  KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && entity.getPersistentData().getDouble("cnt1") % 20.0 == 10.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }

                     entity.getPersistentData().putDouble("BlockRange", (double)(1.0F * entity.getBbWidth()));
                     entity.getPersistentData().putDouble("BlockDamage", (double)entity.getBbWidth() * 0.25 * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= (double)(entity instanceof SeaSerpentMiniEntity ? 40 : 80) && !entity.level().isClientSide()) {
            entity.discard();
         }

         entity.getPersistentData().putDouble("old_x", entity.getX() + entity.getLookAngle().x * (double)entity.getBbWidth() * 0.25);
         entity.getPersistentData().putDouble("old_y", entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getLookAngle().y * (double)entity.getBbWidth() * 0.25);
         entity.getPersistentData().putDouble("old_z", entity.getZ() + entity.getLookAngle().z * (double)entity.getBbWidth() * 0.25);
      }
   }
}
