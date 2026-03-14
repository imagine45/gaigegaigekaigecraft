package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
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
      execute(event, event.getEntity().m_9236_(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean cancel = false;
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double x_pos = 0.0;
         double velocity = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double bbHeight = 0.0;
         double SPEED_VELOCITY = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double bbWidth = 0.0;
         if ((entity instanceof LivingEntity || entity instanceof RockFragmentEntity) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
            cancel = false;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get())) {
                  cancel = true;
               }
            }

            if (!cancel) {
               velocity = Math.sqrt(entity.m_20184_().m_7096_() * entity.m_20184_().m_7096_() + entity.m_20184_().m_7098_() * entity.m_20184_().m_7098_() + entity.m_20184_().m_7094_() * entity.m_20184_().m_7094_());
               SPEED_VELOCITY = velocity * Math.min(ReturnEntitySizeProcedure.execute(entity), 1.0);
               if (SPEED_VELOCITY > 2.2) {
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  x_power = x_pos - entity.getPersistentData().m_128459_("old_x_position");
                  y_power = y_pos - entity.getPersistentData().m_128459_("old_y_position");
                  z_power = z_pos - entity.getPersistentData().m_128459_("old_z_position");
                  if (Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power) > 1.0) {
                     if (velocity != 0.0) {
                        x_power = entity.m_20184_().m_7096_() / velocity;
                        y_power = entity.m_20184_().m_7098_() / velocity;
                        z_power = entity.m_20184_().m_7094_() / velocity;
                     }

                     bbHeight = (double)entity.m_20206_();
                     bbWidth = (double)entity.m_20205_();

                     for(int index0 = 0; index0 < (int)Math.round(SPEED_VELOCITY); ++index0) {
                        if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos, bbHeight, bbWidth) || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60734_() == Blocks.f_49990_) {
                           entity.getPersistentData().m_128347_("BlockDamage", SPEED_VELOCITY * 0.5);
                           entity.getPersistentData().m_128347_("BlockRange", Math.min(bbWidth * SPEED_VELOCITY, Math.max(4.0, bbWidth)));
                           NUM1 = (double)Math.round(SPEED_VELOCITY * 10.0);
                           NUM2 = SPEED_VELOCITY / 4.0;
                           NUM3 = SPEED_VELOCITY / 8.0;
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)NUM1, NUM2, NUM2, NUM2, NUM3);
                           }

                           if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60734_() == Blocks.f_49990_) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)NUM1, NUM2, NUM2, NUM2, NUM3);
                              }

                              entity.getPersistentData().m_128347_("BlockDamage", 0.0);
                              entity.getPersistentData().m_128347_("BlockRange", 0.0);
                           } else {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)NUM1, NUM2, NUM2, NUM2, NUM3);
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                                 }
                              }
                           }

                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                           entity.getPersistentData().m_128347_("BlockRange", entity.getPersistentData().m_128459_("BlockRange") * 2.5);
                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           entity.getPersistentData().m_128347_("knockback", velocity * 0.5);
                           entity.getPersistentData().m_128347_("Range", entity.getPersistentData().m_128459_("BlockRange") * 2.0);
                           KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           break;
                        }

                        x_pos += x_power;
                        y_pos += y_power;
                        z_pos += z_power;
                     }
                  }
               }
            }
         }

         entity.getPersistentData().m_128347_("old_x_position", entity.m_20185_());
         entity.getPersistentData().m_128347_("old_y_position", entity.m_20186_());
         entity.getPersistentData().m_128347_("old_z_position", entity.m_20189_());
      }
   }
}
