package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class UroCounterProcedure {
   public UroCounterProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         Entity target_entity = null;
         double num1 = 0.0;
         double num2 = 0.0;
         double speed = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num3 = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double counter_radius = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
               return;
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var43 = var10000;
         if (var43 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var43).getX(), ((Entity)var43).getY() + (double)((Entity)var43).getBbHeight() * 0.5, ((Entity)var43).getZ(), entity);
         }

         yaw = (double)entity.getYRot();
         pitch = (double)entity.getXRot();
         dis = 6.0;

         for(int index0 = 0; index0 < 8; ++index0) {
            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
               if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                  SUCCESS = true;
                  x_pos = entityiterator.getX();
                  y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                  z_pos = entityiterator.getZ();
                  break;
               }
            }

            if (SUCCESS) {
               break;
            }

            dis += 6.0;
         }

         logic_a = false;
         counter_radius = (double)(12.0F + Math.max(entity.getBbWidth() * 2.0F, entity.getBbHeight() * 2.0F) * 2.0F);
         Vec3 _center = new Vec3(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ());

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(counter_radius / 2.0), (e) -> true)) {
            if ((entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || entityiterator instanceof Projectile) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move"))) && !(entityiterator.getBbWidth() * entityiterator.getBbWidth() + entityiterator.getBbHeight() > (entity.getBbWidth() * entity.getBbWidth() + entity.getBbHeight()) * 8.0F)) {
               logic_a = true;
               entityiterator.getPersistentData().putBoolean("betrayal", true);
               if (entityiterator instanceof Projectile && entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  if (entity instanceof LivingEntity) {
                     _projEnt.setOwner((LivingEntity)entity);
                  }
               }

               if (entity instanceof Player) {
                  logic_b = entity.isShiftKeyDown();
               } else {
                  int var72;
                  label169: {
                     logic_b = entity.getPersistentData().getDouble("cnt_uro") < 15.0;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var72 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getDuration();
                           break label169;
                        }
                     }

                     var72 = 0;
                  }

                  int var10001;
                  label164: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getDuration();
                           break label164;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var72 < (var10001 > 10 ? 18 : 8)) {
                     logic_b = false;
                  }
               }

               speed = 3.0;
               num1 = (double)(entity.getYRot() % 360.0F);
               num2 = (double)(entityiterator.getYRot() % 360.0F);
               num3 = Math.abs(num1 - num2);
               entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
               if (logic_b || num3 > 135.0 && num3 < 315.0) {
                  RotateEntityProcedure.execute(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.9, entity.getZ(), entityiterator);
                  entityiterator.setYRot(entityiterator.getYRot() + (float)(GetDistanceIteratorProcedure.execute(entity, entityiterator) > 5.0 ? 45 : 90));
                  entityiterator.setXRot(entityiterator.getXRot());
                  entityiterator.setYBodyRot(entityiterator.getYRot());
                  entityiterator.setYHeadRot(entityiterator.getYRot());
                  entityiterator.yRotO = entityiterator.getYRot();
                  entityiterator.xRotO = entityiterator.getXRot();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 20, 0, false, false));
                     }
                  }
               } else {
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entityiterator);
               }

               x_power = entityiterator.getLookAngle().x * speed;
               y_power = entityiterator.getLookAngle().y * speed;
               z_power = entityiterator.getLookAngle().z * speed;
               entityiterator.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               entityiterator.getPersistentData().putDouble("x_power", x_power);
               entityiterator.getPersistentData().putDouble("y_power", y_power);
               entityiterator.getPersistentData().putDouble("z_power", z_power);
            }
         }

         if (entity instanceof Player) {
            entity.getPersistentData().putDouble("cnt_uro", entity.getPersistentData().getDouble("cnt_uro") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_uro") > 0.0) {
               entity.getPersistentData().putDouble("cnt_uro", -5.0);
            } else {
               logic_a = false;
            }
         } else {
            if (logic_a) {
               entity.getPersistentData().putDouble("cnt_uro", Math.max(entity.getPersistentData().getDouble("cnt_uro"), 1.0));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 0));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 5, 9));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
               }
            }

            if (entity.getPersistentData().getDouble("cnt_uro") > 0.0) {
               entity.getPersistentData().putDouble("cnt_uro", entity.getPersistentData().getDouble("cnt_uro") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_uro") > 100.0) {
                  entity.getPersistentData().putDouble("cnt_uro", 0.0);
               }
            }
         }

         if (logic_a) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 9));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity78 = (LivingEntity)entity;
               if (_livingEntity78.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity78.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity79 = (LivingEntity)entity;
               if (_livingEntity79.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity79.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
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

      }
   }
}
