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
      execute(event, event.getEntity().level(), event.getEntity());
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
         if ((!player || OverlayHaveTechniqueProcedure.execute(entity)) && entity.getPersistentData().getBoolean("PRESS_S")) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                  return;
               }
            }

            int var10000;
            label96: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                     var10000 = _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
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
                     if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                        label86: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                                 var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).getAmplifier();
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
                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  if (player) {
                     entity.setYRot(entity.getYRot());
                     entity.setXRot(0.0F);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  } else {
                     entity.setYRot((float)((double)entity.getYRot() + (Math.random() - 0.5) * 145.0));
                     entity.setXRot(11.25F);
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

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * -3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * -3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * -3.0);
                  GetPowerFixProcedure.execute(entity);
                  y_power = player ? entity.getDeltaMovement().y() : entity.getPersistentData().getDouble("y_power") * 0.5;
                  power = 0.5;
                  EntityVectorProcedure.execute(entity, entity.getDeltaMovement().x() + entity.getPersistentData().getDouble("x_power") * power, y_power, entity.getDeltaMovement().z() + entity.getPersistentData().getDouble("z_power") * power);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 100, (int)Math.round(level), level >= LIMIT_NUM - 1.0, level >= LIMIT_NUM - 1.0));
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

                  animation_num = -1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt27 = (LivingEntity)entity;
                     if (_livEnt27.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                        animation_num = (double)Math.round(-15.0 + Math.ceil(Math.random() * 4.0));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 15, 1, false, false));
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity29 = (LivingEntity)entity;
                     if (_livingEntity29.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity29.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(animation_num);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }
         }

      }
   }
}
