package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class NanamiDomainExpansionActiveProcedure {
   public NanamiDomainExpansionActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range = 0.0;
         double dis = 0.0;
         range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.ENCHANT, entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), 2, dis * 0.25, dis * 0.25, dis * 0.25, 0.0);
         }

         int var10000;
         label56: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label56;
               }
            }

            var10000 = 0;
         }

         if (var10000 % 5 == 0) {
            Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator instanceof LivingEntity && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 10, 0, false, false));
                     }
                  }

                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     Commands var15 = entity.getServer().getCommands();
                     CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                     double var10002 = entityiterator.getX();
                     var15.performPrefixedCommand(var10001, "particle gaigegaigekaigecraft:particle_nanami_1 " + var10002 + " " + (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5) + " " + entityiterator.getZ() + " " + (double)entityiterator.getBbWidth() * 0.5 + " " + (double)entityiterator.getBbHeight() * 0.5 + " " + (double)entityiterator.getBbWidth() * 0.5 + " 0 " + Math.round(Math.sqrt((double)(entityiterator.getBbWidth() + entityiterator.getBbHeight()))) + " force @s");
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 10, 1, false, false));
               }
            }
         }

      }
   }
}
