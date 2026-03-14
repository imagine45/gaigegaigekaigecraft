package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(2.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         range = 1.0 + distance * 2.0;
         Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entity != entityiterator && entityiterator.m_6084_() && entityiterator instanceof LivingEntity && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 1, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                  }
               }

               int var10000;
               label87: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                        break label87;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 > 0) {
                  label80: {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var44 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19557_();
                           break label80;
                        }
                     }

                     var44 = 0.0;
                  }

                  old_tick = var44;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), (int)old_tick, 0, false, false));
                     }
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
               }

               distance = 2.0 + 0.5 * (double)(entity.m_20205_() + entityiterator.m_20205_());
               entityiterator.m_6021_(entity.m_20185_() + Math.cos(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance, Math.max(entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance - (double)entityiterator.m_20206_() * 0.9, entity.m_20186_()), entity.m_20189_() + Math.sin(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance);
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + Math.cos(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance, Math.max(entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance - (double)entityiterator.m_20206_() * 0.9, entity.m_20186_()), entity.m_20189_() + Math.sin(yaw) * Math.cos(Math.min(pitch, Math.toRadians(45.0))) * distance, entityiterator.m_146908_(), entityiterator.m_146909_());
               }

               entityiterator.m_146922_(entity.m_146908_() + 180.0F);
               entityiterator.m_146926_(entity.m_146909_() * -1.0F);
               entityiterator.m_5618_(entityiterator.m_146908_());
               entityiterator.m_5616_(entityiterator.m_146908_());
               entityiterator.f_19859_ = entityiterator.m_146908_();
               entityiterator.f_19860_ = entityiterator.m_146909_();
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entityiterator.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_(), entity.m_20184_().m_7094_()));
               break;
            }
         }

      }
   }
}
