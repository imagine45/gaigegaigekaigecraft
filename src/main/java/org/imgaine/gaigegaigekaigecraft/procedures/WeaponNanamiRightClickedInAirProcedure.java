package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WeaponNanamiRightClickedInAirProcedure {
   public WeaponNanamiRightClickedInAirProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean success = false;
         Vec3 _center = new Vec3((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(6.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
            if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
               success = true;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 60, 0, false, false));
                  }
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  Commands var10000 = entity.getServer().getCommands();
                  CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                  double var10002 = entityiterator.getX();
                  var10000.performPrefixedCommand(var10001, "particle gaigegaigekaigecraft:particle_nanami_1 " + var10002 + " " + (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5) + " " + entityiterator.getZ() + " " + (double)entityiterator.getBbWidth() * 0.5 + " " + (double)entityiterator.getBbHeight() * 0.5 + " " + (double)entityiterator.getBbWidth() * 0.5 + " 0 " + Math.round(Math.sqrt((double)(entityiterator.getBbWidth() + entityiterator.getBbHeight()))) + " force @s");
               }
            }
         }

         if (success && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 60, 1, false, false));
            }
         }

      }
   }
}
