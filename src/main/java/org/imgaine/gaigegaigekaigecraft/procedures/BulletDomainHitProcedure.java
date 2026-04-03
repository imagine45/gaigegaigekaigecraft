package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BulletDomainHitProcedure {
   public BulletDomainHitProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed") && entity instanceof LivingEntity) {
               immediatesourceentity.getPersistentData().putDouble("cnt_bullet_hit", immediatesourceentity.getPersistentData().getDouble("cnt_bullet_hit") + 1.0);
               if (immediatesourceentity.getPersistentData().getDouble("cnt_bullet_hit") > 1.0) {
                  AABB var10002;
                  double var10003;
                  int var10004;
                  label44: {
                     immediatesourceentity.getPersistentData().putDouble("cnt_bullet_hit", -15.0);
                     Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                     var10002 = new AABB(_center, _center);
                     var10003 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                           break label44;
                        }
                     }

                     var10004 = 0;
                  }

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, var10002.inflate(var10003 * (double)(var10004 > 0 ? 6 : 2) / 2.0), (e) -> true)) {
                     if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                        x_pos = entityiterator.getX() + (double)entityiterator.getBbWidth() * Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
                        y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * Mth.nextDouble(RandomSource.create(), 0.0, 1.0);
                        z_pos = entityiterator.getZ() + (double)entityiterator.getBbWidth() * Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
                        immediatesourceentity.teleportTo(x_pos - immediatesourceentity.getDeltaMovement().x(), y_pos - immediatesourceentity.getDeltaMovement().y(), z_pos - immediatesourceentity.getDeltaMovement().z());
                        if (immediatesourceentity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)immediatesourceentity;
                           _serverPlayer.connection.teleport(x_pos - immediatesourceentity.getDeltaMovement().x(), y_pos - immediatesourceentity.getDeltaMovement().y(), z_pos - immediatesourceentity.getDeltaMovement().z(), immediatesourceentity.getYRot(), immediatesourceentity.getXRot());
                        }

                        immediatesourceentity.lookAt(Anchor.EYES, new Vec3(x_pos, y_pos, z_pos));
                        break;
                     }
                  }
               }
            }
         }

      }
   }
}
