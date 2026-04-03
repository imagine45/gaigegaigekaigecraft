package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.JogoHeadEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class JogoEntityDiesProcedure {
   public JogoEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.isAlive() && entity.getPersistentData().getDouble("skill") == -999.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.JOGO_HEAD.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(entity.getYRot());
                  entityToSpawn.setYBodyRot(entity.getYRot());
                  entityToSpawn.setYHeadRot(entity.getYRot());
                  entityToSpawn.setXRot(entity.getXRot());
                  entityToSpawn.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z());
               }
            }

            if (!world.getEntitiesOfClass(JogoHeadEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), (e) -> true).isEmpty()) {
               Entity var11 = (Entity)world.getEntitiesOfClass(JogoHeadEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x, y, z)).findFirst().orElse((JogoHeadEntity) null);
               if (var11 instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)var11;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 10, false, false));
                  }
               }
            }
         }

      }
   }
}
