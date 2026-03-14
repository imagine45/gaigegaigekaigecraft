package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GetDistanceNearestEnemyProcedure {
   public GetDistanceNearestEnemyProcedure() {
   }

   public static double execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double distance = 0.0;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         distance = var10000 instanceof LivingEntity ? GetDistanceProcedure.execute(entity) : 999.0;
         Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(16.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entity != entityiterator) {
               if (entityiterator instanceof Player) {
                  if (entityiterator instanceof Player) {
                     Player _plr = (Player)entityiterator;
                     if (_plr.m_150110_().f_35937_) {
                        continue;
                     }
                  }

                  if (((<undefinedtype>)(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                        } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                           return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                        } else {
                           return false;
                        }
                     }
                  })).checkGamemode(entityiterator)) {
                     continue;
                  }
               } else {
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if ((!(var10000 instanceof LivingEntity) || !(entityiterator.getPersistentData().m_128459_("cnt_target") > 6.0)) && !(entityiterator.getPersistentData().m_128459_("Damage") > 0.0) && !(entityiterator.getPersistentData().m_128459_("skill") > 0.0)) {
                     continue;
                  }
               }

               double var14;
               if (entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  var14 = _projEnt.m_20184_().m_82553_();
               } else {
                  var14 = 0.0;
               }

               if (var14 > 0.0) {
                  if (entity.m_20149_().equals(entityiterator.m_20149_())) {
                     continue;
                  }
               } else if (!LogicAttackProcedure.execute(world, entity, entityiterator) || !entityiterator.m_6084_()) {
                  continue;
               }

               distance = Math.min(distance, GetDistanceIteratorProcedure.execute(entity, entityiterator));
            }
         }

         return distance;
      }
   }
}
