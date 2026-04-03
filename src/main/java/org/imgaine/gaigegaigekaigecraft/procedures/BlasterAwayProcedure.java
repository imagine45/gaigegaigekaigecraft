package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.EntityCrystalEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class BlasterAwayProcedure {
   public BlasterAwayProcedure() {
   }

   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      execute(event, event.getEntity().level(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean inWater = false;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double x_step = 0.0;
         double x_pos = 0.0;
         double velocity = 0.0;
         double z_pos = 0.0;
         double speedVel = 0.0;
         double z_step = 0.0;
         double spread = 0.0;
         double pSpeed = 0.0;
         double size = 0.0;
         double bbHeight = 0.0;
         double vSq = 0.0;
         double y_step = 0.0;
         double y_pos = 0.0;
         double bbWidth = 0.0;
         if (entity instanceof LivingEntity) {
            if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || entity instanceof EntityCrystalEntity || entity instanceof RockFragmentEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get())) {
                     return;
                  }
               }

               vx = entity.getDeltaMovement().x();
               vy = entity.getDeltaMovement().y();
               vz = entity.getDeltaMovement().z();
               vSq = vx * vx + vy * vy + vz * vz;
               if (!(vSq < 4.8)) {
                  size = Math.min(ReturnEntitySizeProcedure.execute(entity), 1.0);
                  if (!(vSq * size < 4.8)) {
                     velocity = Math.sqrt(vSq);
                     speedVel = velocity * size;
                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();
                     x_step = vx / velocity;
                     y_step = vy / velocity;
                     z_step = vz / velocity;
                     bbHeight = (double)entity.getBbHeight();
                     bbWidth = (double)entity.getBbWidth();
                     CompoundTag data = entity.getPersistentData();
                     int particleCount = (int)Math.round(speedVel * 10.0);
                     spread = speedVel / 4.0;
                     pSpeed = speedVel / 8.0;
                     int loopCount = (int)Math.round(velocity);

                     for(int index0 = 0; index0 < loopCount; ++index0) {
                        BlockPos pos = BlockPos.containing(x_pos, y_pos, z_pos);
                        inWater = world.getBlockState(pos).getBlock() == Blocks.WATER;
                        if (inWater || InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, bbHeight, bbWidth)) {
                           data.putDouble("knockback", speedVel - 2.0);
                           if (inWater) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel sl = (ServerLevel)world;
                                 sl.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, particleCount, spread, spread, spread, pSpeed);
                                 sl.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, particleCount, spread, spread, spread, pSpeed);
                              }

                              data.putDouble("BlockDamage", 0.0);
                              data.putDouble("BlockRange", 0.0);
                           } else {
                              if (world instanceof ServerLevel) {
                                 ServerLevel sl = (ServerLevel)world;
                                 sl.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, particleCount, spread, spread, spread, pSpeed);
                              }

                              if (world instanceof Level) {
                                 Level lvl = (Level)world;
                                 if (!lvl.isClientSide()) {
                                    lvl.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                                 }
                              }

                              data.putDouble("BlockDamage", speedVel * 0.5);
                              data.putDouble("BlockRange", Math.min(bbWidth * speedVel, Math.max(4.0, bbWidth)));
                           }

                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           data.putBoolean("noEffect", true);
                           if (inWater || InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, bbHeight, bbWidth)) {
                              break;
                           }
                        }

                        x_pos += x_step;
                        y_pos += y_step;
                        z_pos += z_step;
                     }

                     data.putBoolean("noEffect", false);
                  }
               }
            }
         }
      }
   }
}
