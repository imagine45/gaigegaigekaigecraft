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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackJumpProcedure {
   public AttackJumpProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double dis = 0.0;
         double d = 0.0;
         double strength = 0.0;
         double loop_num = 0.0;
         double range = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double distance = 0.0;
         Entity target_entity = null;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.fallDistance = 0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (target_entity instanceof LivingEntity) {
            RotateEntityProcedure.execute(target_entity.getX(), target_entity.getY() + (double)target_entity.getBbHeight() * 0.5, target_entity.getZ(), entity);
         }

         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         if (entity.getPersistentData().getDouble("cnt5") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity13 = (LivingEntity)entity;
               if (_livingEntity13.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity13.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-10.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity14 = (LivingEntity)entity;
               if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt5") >= 10.0) {
            if (entity.getPersistentData().getDouble("cnt5") == 10.0) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
               dis = 6.0;
               if (target_entity instanceof LivingEntity) {
                  x_pos = target_entity.getX();
                  y_pos = target_entity.getY() + (double)(target_entity.getBbHeight() * 0.0F);
                  z_pos = target_entity.getZ();
               } else {
                  for(int index0 = 0; index0 < 6; ++index0) {
                     x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
                     y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
                     z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           x_pos = entityiterator.getX();
                           y_pos = entityiterator.getY() + (double)(entityiterator.getBbHeight() * 0.0F);
                           z_pos = entityiterator.getZ();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     dis += 6.0;
                  }
               }

               x_power = x_pos - entity.getX();
               y_power = y_pos - (entity.getY() + (double)(entity.getBbHeight() * 0.0F));
               z_power = z_pos - entity.getZ();
               distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (distance > 1.0) {
                  x_power /= distance;
                  double var54 = y_power / distance;
                  z_power /= distance;
               }

               entity.getPersistentData().putDouble("x_power", x_power * 1.0);
               entity.getPersistentData().putDouble("z_power", z_power * 1.0);
               entity.getPersistentData().putDouble("cnt7", distance / 2.0);
               entity.getPersistentData().putDouble("cnt9", y_pos - (entity.getY() + (double)(entity.getBbHeight() * 0.0F)));
               entity.getPersistentData().putDouble("cnt10", Math.max(Math.sqrt(distance) * 1.5, 2.0));
            }

            entity.getPersistentData().putDouble("y_power", (entity.getPersistentData().getDouble("cnt9") / entity.getPersistentData().getDouble("cnt7") + entity.getPersistentData().getDouble("cnt10") * 4.0 / entity.getPersistentData().getDouble("cnt7") - entity.getPersistentData().getDouble("cnt10") * 8.0 / (entity.getPersistentData().getDouble("cnt7") * entity.getPersistentData().getDouble("cnt7")) * (entity.getPersistentData().getDouble("cnt5") - 9.0)) * 0.5);
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
