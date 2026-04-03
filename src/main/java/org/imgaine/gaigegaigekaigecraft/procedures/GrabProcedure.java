package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GrabProcedure {
   public GrabProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double distance = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double old_tick = 0.0;
         double yaw = 0.0;
         double range = 0.0;
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(2.0F + entity.getBbWidth());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         range = 1.0 + distance * 2.0;
         Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
            if (entity != entityiterator && entityiterator.isAlive() && entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 1, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                  }
               }

               int var10000;
               label87: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                        break label87;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 > 0) {
                  double var44;
                  label80: {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var44 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getDuration();
                           break label80;
                        }
                     }

                     var44 = 0.0;
                  }

                  old_tick = var44;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), (int)old_tick, 0, false, false));
                     }
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
               }

               distance = 2.0 + 0.5 * (double)(entity.getBbWidth() + entityiterator.getBbWidth());
               entityiterator.teleportTo(entity.getX() + Math.cos(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance, Math.max(entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance - (double)entityiterator.getBbHeight() * 0.9, entity.getY()), entity.getZ() + Math.sin(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance);
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                  _serverPlayer.connection.teleport(entity.getX() + Math.cos(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance, Math.max(entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * distance - (double)entityiterator.getBbHeight() * 0.9, entity.getY()), entity.getZ() + Math.sin(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance, entityiterator.getYRot(), entityiterator.getXRot());
               }

               entityiterator.setYRot(entity.getYRot() + 180.0F);
               entityiterator.setXRot(entity.getXRot() * -1.0F);
               entityiterator.setYBodyRot(entityiterator.getYRot());
               entityiterator.setYHeadRot(entityiterator.getYRot());
               entityiterator.yRotO = entityiterator.getYRot();
               entityiterator.xRotO = entityiterator.getXRot();
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entityiterator.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z()));
               break;
            }
         }

      }
   }
}
