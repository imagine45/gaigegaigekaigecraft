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

public class BulletDomainHit2Procedure {
   public BulletDomainHit2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double range = 0.0;
         double dis = 0.0;
         Entity entity_a = null;
         entity.getPersistentData().putDouble("cnt_bullet_hit", entity.getPersistentData().getDouble("cnt_bullet_hit") + 1.0);
         if (entity.getPersistentData().getDouble("cnt_bullet_hit") > 1.0) {
            entity.getPersistentData().putDouble("cnt_bullet_hit", -15.0);
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && !entity_a.getPersistentData().getBoolean("Failed") && entity_a instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity_a;
                  if (_livEnt10.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     AABB var10002;
                     double var10003;
                     int var10004;
                     label46: {
                        Vec3 _center = new Vec3(entity_a.getPersistentData().getDouble("x_pos_doma"), entity_a.getPersistentData().getDouble("y_pos_doma"), entity_a.getPersistentData().getDouble("z_pos_doma"));
                        var10002 = new AABB(_center, _center);
                        var10003 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity_a;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                              break label46;
                           }
                        }

                        var10004 = 0;
                     }

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, var10002.inflate(var10003 * (double)(var10004 > 0 ? 6 : 2) / 2.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                           x_pos = entityiterator.getX() + (double)entityiterator.getBbWidth() * Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
                           y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * Mth.nextDouble(RandomSource.create(), 0.0, 1.0);
                           z_pos = entityiterator.getZ() + (double)entityiterator.getBbWidth() * Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
                           entity.teleportTo(x_pos - entity.getDeltaMovement().x(), y_pos - entity.getDeltaMovement().y(), z_pos - entity.getDeltaMovement().z());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(x_pos - entity.getDeltaMovement().x(), y_pos - entity.getDeltaMovement().y(), z_pos - entity.getDeltaMovement().z(), entity.getYRot(), entity.getXRot());
                           }

                           entity.lookAt(Anchor.EYES, new Vec3(x_pos, y_pos, z_pos));
                           break;
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
