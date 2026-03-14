package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenBackStepProcedure {
   public WhenBackStepProcedure() {
   }

   @SubscribeEvent
   public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
      execute(event, event.getEntity().m_9236_(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean player = false;
         double y_power = 0.0;
         double level = 0.0;
         double LIMIT_NUM = 0.0;
         double pitch = 0.0;
         double animation_num = 0.0;
         double yaw = 0.0;
         double power = 0.0;
         player = entity instanceof Player;
         if ((!player || OverlayHaveTechniqueProcedure.execute(entity)) && entity.getPersistentData().m_128471_("PRESS_S")) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                  return;
               }
            }

            int var10000;
            label96: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                     break label96;
                  }
               }

               var10000 = 0;
            }

            if (var10000 < 7) {
               label90: {
                  LIMIT_NUM = 5.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entity;
                     if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                        label86: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                                 var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).m_19564_();
                                 break label86;
                              }
                           }

                           var10000 = 0;
                        }

                        ++var10000;
                        break label90;
                     }
                  }

                  var10000 = 0;
               }

               level = (double)var10000;
               if (level < LIMIT_NUM) {
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  if (player) {
                     entity.m_146922_(entity.m_146908_());
                     entity.m_146926_(0.0F);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else {
                     entity.m_146922_((float)((double)entity.m_146908_() + (Math.random() - 0.5) * 145.0));
                     entity.m_146926_(11.25F);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * -3.0);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * -3.0);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * -3.0);
                  GetPowerFixProcedure.execute(entity);
                  y_power = player ? entity.m_20184_().m_7098_() : entity.getPersistentData().m_128459_("y_power") * 0.5;
                  power = 0.5;
                  EntityVectorProcedure.execute(entity, entity.m_20184_().m_7096_() + entity.getPersistentData().m_128459_("x_power") * power, y_power, entity.m_20184_().m_7094_() + entity.getPersistentData().m_128459_("z_power") * power);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 100, (int)Math.round(level), level >= LIMIT_NUM - 1.0, level >= LIMIT_NUM - 1.0));
                     }
                  }

                  entity.m_146922_((float)yaw);
                  entity.m_146926_((float)pitch);
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  animation_num = -1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt27 = (LivingEntity)entity;
                     if (_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                        animation_num = (double)Math.round(-15.0 + Math.ceil(Math.random() * 4.0));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 15, 1, false, false));
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity29 = (LivingEntity)entity;
                     if (_livingEntity29.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity29.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(animation_num);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }
         }

      }
   }
}
