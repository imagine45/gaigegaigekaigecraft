package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         if (!entity.m_6084_() && entity.getPersistentData().m_128459_("skill") == -999.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.JOGO_HEAD.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(entity.m_146908_());
                  entityToSpawn.m_5618_(entity.m_146908_());
                  entityToSpawn.m_5616_(entity.m_146908_());
                  entityToSpawn.m_146926_(entity.m_146909_());
                  entityToSpawn.m_20334_(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_(), entity.m_20184_().m_7094_());
               }
            }

            if (!world.m_6443_(JogoHeadEntity.class, AABB.m_165882_(new Vec3(x, y, z), 4.0, 4.0, 4.0), (e) -> true).isEmpty()) {
               Entity var11 = (Entity)world.m_6443_(JogoHeadEntity.class, AABB.m_165882_(new Vec3(x, y, z), 4.0, 4.0, 4.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                  }
               })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
               if (var11 instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)var11;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 30, 10, false, false));
                  }
               }
            }
         }

      }
   }
}
