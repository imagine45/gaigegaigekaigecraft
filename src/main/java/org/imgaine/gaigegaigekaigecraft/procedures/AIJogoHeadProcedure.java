package org.imgaine.gaigegaigekaigecraft.procedures;

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
         if (entity.onGround()) {
            entity.getPersistentData().putDouble("yaw", (Math.random() - 0.5) * 2.0);
            entity.getPersistentData().putDouble("pitch", (Math.random() - 0.5) * 2.0);
         } else if (!entity.getPersistentData().getBoolean("Stop")) {
            speed = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0));

            for(int index0 = 0; index0 < 45; ++index0) {
               entity.setYRot((float)((double)entity.getYRot() + entity.getPersistentData().getDouble("yaw") * speed));
               entity.setXRot((float)((double)entity.getXRot() + entity.getPersistentData().getDouble("pitch") * speed));
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
         }

         entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
         if (entity.getPersistentData().getDouble("cnt_x") >= 5.0) {
            Vec3 _center = new Vec3(x, y + (double)entity.getBbHeight() * 0.5, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate((double)(entity.getBbWidth() * 2.0F) / 2.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator.isAlive()) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  Power = Math.sqrt(Math.pow(entityiterator.getDeltaMovement().x(), 2.0) + Math.pow(entityiterator.getDeltaMovement().z(), 2.0)) * 2.0;
                  if (Power > 0.2 || entityiterator instanceof Player) {
                     if (entityiterator instanceof Player) {
                        Power = Math.max(Power, 0.1);
                     }

                     Power = Math.max(Power * 2.0, 0.5);
                     logic_a = true;
                     if (!entityiterator.onGround()) {
                        Power *= 2.0;
                        y_power = 0.6;
                     } else {
                        y_power = 0.3;
                     }

                     x_knockback = entity.getX() - entityiterator.getX();
                     y_knockback = entity.getY() - entityiterator.getY();
                     z_knockback = entity.getZ() - entityiterator.getZ();
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

                     x_knockback = x_knockback * Power + entityiterator.getDeltaMovement().x() * 2.0;
                     y_knockback = Math.min((y_knockback + y_power) * Power, 2.0);
                     z_knockback = z_knockback * Power + entityiterator.getDeltaMovement().z() * 2.0;
                     entity.setDeltaMovement(new Vec3(x_knockback, y_knockback, z_knockback));
                     if (Power > 1.0) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:punch")), SoundSource.NEUTRAL, 0.25F, 0.5F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:punch")), SoundSource.NEUTRAL, 0.25F, 0.5F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), x, y, z, 0, 0.1, 0.1, 0.1, 0.0);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), x, y + 0.25, z, (int)Math.round(Math.min(Power * 2.0, 10.0)), 0.1, 0.1, 0.1, 0.1 + Power * 0.25);
                     }
                  }
                  break;
               }
            }
         }

      }
   }
}
