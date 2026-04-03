package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HarisenEntitySwingsItemProcedure {
   public HarisenEntitySwingsItemProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         Entity entity_a = null;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double velocity = 0.0;
         double damage = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }

               if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                  entity.getPersistentData().putDouble("NameRanged", Math.random());
               }

               logic_a = false;
               Vec3 _center = new Vec3((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate((double)(8.0F + entity.getBbWidth()) / 2.0), (e) -> true)) {
                  if (entity != entityiterator) {
                     if (!LogicAttackProcedure.execute(world, entity, entityiterator) || !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        double var10000;
                        if (entityiterator instanceof Projectile) {
                           Projectile _projEnt = (Projectile)entityiterator;
                           var10000 = _projEnt.getDeltaMovement().length();
                        } else {
                           var10000 = 0.0;
                        }

                        if (!(var10000 > 0.0)) {
                           continue;
                        }
                     }

                     entityiterator.getPersistentData().putString("OWNER_UUID", "");
                     entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                     entityiterator.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                     entityiterator.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                     entityiterator.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                     entityiterator.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                     entityiterator.setDeltaMovement(new Vec3(entityiterator.getPersistentData().getDouble("x_power"), entityiterator.getPersistentData().getDouble("y_power"), entityiterator.getPersistentData().getDouble("z_power")));
                     entityiterator.setYRot(entity.getYRot());
                     entityiterator.setXRot(entity.getXRot());
                     entityiterator.setYBodyRot(entityiterator.getYRot());
                     entityiterator.setYHeadRot(entityiterator.getYRot());
                     entityiterator.yRotO = entityiterator.getYRot();
                     entityiterator.xRotO = entityiterator.getXRot();
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     logic_a = true;
                  }
               }

               if (logic_b && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_just")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_just")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }
            }
         }

      }
   }
}
