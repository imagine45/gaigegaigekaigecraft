package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class AIWitnessStandProcedure {
   public AIWitnessStandProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_target = null;
         Entity entity_owner = null;
         boolean flag_kill = false;
         entity_owner = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         entity_target = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("TARGET"));
         flag_kill = true;
         if (entity.m_6084_()) {
            if (entity_target instanceof LivingEntity) {
               flag_kill = false;
               if (entity_owner instanceof LivingEntity && entity_owner instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity_owner;
                  if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity_owner.getPersistentData().m_128471_("Failed")) {
                     flag_kill = false;
                     if (!(entity_target instanceof Player)) {
                        entity_target.getPersistentData().m_128347_("cnt_x", 0.0);
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                           }
                        }

                        entity_target.m_146922_(entity.m_146908_());
                        entity_target.m_146926_(entity.m_146909_());
                        entity_target.m_5618_(entity_target.m_146908_());
                        entity_target.m_5616_(entity_target.m_146908_());
                        entity_target.f_19859_ = entity_target.m_146908_();
                        entity_target.f_19860_ = entity_target.m_146909_();
                        if (entity_target instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_target;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entity_target.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
                        if (entity_target instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity_target.m_146908_(), entity_target.m_146909_());
                        }
                     } else if (Math.sqrt(Math.pow(entity.m_20185_() - entity_target.m_20185_(), 2.0) + Math.pow(entity.m_20186_() - entity_target.m_20186_(), 2.0) + Math.pow(entity.m_20189_() - entity_target.m_20189_(), 2.0)) > (double)entity_target.m_20205_() + 0.5) {
                        entity_target.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
                        if (entity_target instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                           _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity_target.m_146908_(), entity_target.m_146909_());
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 20, 0, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20, 1, false, false));
                        }
                     }

                     if (entity_target instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_target;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 20, 1, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity36 = (LivingEntity)entity;
                        if (_livingEntity36.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity36.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(((double)entity_target.m_20205_() + 1.5) * 0.5);
                        }
                     }
                  }
               }
            }

            if (entity_owner instanceof LivingEntity) {
               label90: {
                  if (entity_owner instanceof LivingEntity) {
                     LivingEntity _livEnt38 = (LivingEntity)entity_owner;
                     if (_livEnt38.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label90;
                     }
                  }

                  flag_kill = true;
               }
            } else {
               flag_kill = true;
            }
         }

         if (flag_kill && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
