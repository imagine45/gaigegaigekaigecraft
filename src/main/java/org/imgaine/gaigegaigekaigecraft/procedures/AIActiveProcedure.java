package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIActiveProcedure {
   public AIActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         double level_jump_set = 0.0;
         double distance = 0.0;
         double level = 0.0;
         double level_speed_set = 0.0;
         double level_speed = 0.0;
         double skill = 0.0;
         double level_jump = 0.0;
         boolean hasCooldown = false;
         boolean logic_run = false;
         boolean simpleDomainning = false;
         boolean simpleDomain = false;
         boolean canFallingBlossomEmotion = false;
         boolean hasFallingBlossom = false;
         boolean canSimpleDomain = false;
         ItemStack item_mainHand = ItemStack.EMPTY;
         ItemStack item_offHand = ItemStack.EMPTY;
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            skill = entity.getPersistentData().getDouble("skill");
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            Entity var38 = var10000;
            if (skill == 0.0 && entity.tickCount % 12 == 0) {
               canSimpleDomain = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_simple_domain")));
               canFallingBlossomEmotion = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_falling_blossom_emotion")));
               if (canSimpleDomain || canFallingBlossomEmotion) {
                  hasFallingBlossom = livingEntity.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
                  int simpleDomainAmp = livingEntity.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) ? livingEntity.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier() : -1;
                  simpleDomainning = simpleDomainAmp > 0 || hasFallingBlossom;
                  simpleDomain = false;
                  hasCooldown = livingEntity.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get());
                  MobEffectInstance neutralEffect = livingEntity.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get());
                  int neutralAmp = neutralEffect != null ? neutralEffect.getAmplifier() : -1;
                  int neutralDur = neutralEffect != null ? neutralEffect.getDuration() : 0;
                  int unstableAmp = livingEntity.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) ? livingEntity.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier() : -1;
                  if (!livingEntity.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && neutralAmp > 0 && (neutralAmp != 37 || unstableAmp <= 0) && neutralAmp != 39 && neutralDur >= 5) {
                     if (simpleDomainning) {
                        if (hasFallingBlossom && canSimpleDomain && !hasCooldown) {
                           simpleDomain = true;
                        }
                     } else if (canFallingBlossomEmotion || !hasCooldown) {
                        entity.getPersistentData().putDouble("cnt_simpleDomain_spread", entity.getPersistentData().getDouble("cnt_simpleDomain_spread") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_simpleDomain_spread") > 2.0) {
                           simpleDomain = true;
                        }
                     }
                  } else if (simpleDomainning) {
                     simpleDomain = true;
                  }

                  if (simpleDomain) {
                     KeySimpleDomainOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().putDouble("cnt_simpleDomain_spread", 0.0);
                  }
               }
            }

            if (var38 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 10.0) {
               int var65;
               label198: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var65 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label198;
                     }
                  }

                  var65 = 0;
               }

               level = (double)Math.min(var65, 30);
               distance = GetDistanceProcedure.execute(entity);
               logic_run = false;
               if (distance > 32.0) {
                  logic_run = true;
               }

               if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:combat_type")))) {
                  if (distance > 2.0) {
                     logic_run = true;
                  }
               } else {
                  if (((Entity)var38).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:combat_type")))) {
                     logic_run = false;
                  }

                  if (distance > 4.0) {
                     int var66;
                     label188: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                              var66 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                              break label188;
                           }
                        }

                        var66 = 0;
                     }

                     if ((double)var66 > distance * 2.0) {
                        logic_run = true;
                     }
                  }
               }

               if (distance < 12.0) {
                  MobEffectInstance combatCool = livingEntity.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
                  if (combatCool != null && combatCool.getAmplifier() > 0 && combatCool.getDuration() > 15 && ((Entity)var38).getPersistentData().getDouble("skill") != 0.0 && ((Entity)var38).getPersistentData().getDouble("Damage") > 0.0 && ((Entity)var38).getPersistentData().getBoolean("attack")) {
                     logic_run = false;
                  }
               }

               MobEffectInstance speedEffect = livingEntity.getEffect(MobEffects.MOVEMENT_SPEED);
               int speedAmp = speedEffect != null ? speedEffect.getAmplifier() : 0;
               if (!logic_run) {
                  entity.setSprinting(false);
               } else {
                  level_speed = (double)Math.round(Math.min(level / 4.0, 6.0));
                  level_speed_set = (double)speedAmp;
                  if (speedEffect != null || entity.onGround()) {
                     level_speed = (double)Math.min(Math.round(level / 4.0), 3L);
                     level_speed_set = speedEffect != null ? (double)(speedAmp + 1) : 0.0;
                     int speedDur = speedEffect != null ? speedEffect.getDuration() : 0;
                     if (speedDur <= 2 && !entity.level().isClientSide()) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, (int)Math.min(level_speed_set, level_speed), false, false));
                     }
                  }

                  int slowAmp = livingEntity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? livingEntity.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : -1;
                  if (slowAmp < 6) {
                     if (entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z() > 0.04) {
                        entity.setSprinting(true);
                        if (skill == 0.0) {
                           item_mainHand = livingEntity.getMainHandItem();
                           item_offHand = livingEntity.getOffhandItem();
                           PlayAnimationItemProcedure.execute(entity, item_mainHand, "sprint");
                           PlayAnimationItemProcedure.execute(entity, item_offHand, "sprint");
                        }
                     } else {
                        entity.setSprinting(false);
                     }
                  } else {
                     entity.setSprinting(false);
                  }
               }

               if (distance > 12.0 || !entity.onGround()) {
                  level_jump = (double)Math.round(Math.min(level / 4.0, 6.0));
                  MobEffectInstance jumpEffect = livingEntity.getEffect(MobEffects.JUMP);
                  if (!entity.onGround()) {
                     level_jump_set = jumpEffect != null ? (double)(jumpEffect.getAmplifier() + 1) : 0.0;
                  } else {
                     level_jump_set = (double)Math.round(Math.min(level_speed_set / 4.0, level / 4.0));
                  }

                  int jumpDur = jumpEffect != null ? jumpEffect.getDuration() : 0;
                  if (jumpDur < 2 && !entity.level().isClientSide()) {
                     livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 8, (int)Math.min(level_jump, level_jump_set), false, false));
                  }
               }
            } else {
               entity.setSprinting(false);
            }

            AIActive2Procedure.execute(world, x, y, z, entity);
         }
      }
   }
}
