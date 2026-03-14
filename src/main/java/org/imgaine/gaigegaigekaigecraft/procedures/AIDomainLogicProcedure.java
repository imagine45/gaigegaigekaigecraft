package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIDomainLogicProcedure {
   public AIDomainLogicProcedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean cancel = false;
         cancel = false;
         double var10000 = Math.random();
         float var10002;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10002 = _livEnt.m_21223_();
         } else {
            var10002 = -1.0F;
         }

         var10002 = Math.max(var10002, 1.0F);
         float var10003;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10003 = _livEnt.m_21233_();
         } else {
            var10003 = -1.0F;
         }

         if (var10000 > (double)(1.0F - var10002 / Math.max(var10003, 1.0F)) * 0.75) {
            cancel = true;
            LivingEntity var27;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var27 = _mobEnt.m_5448_();
            } else {
               var27 = null;
            }

            label120: {
               label130: {
                  LivingEntity var15 = var27;
                  if (var15 instanceof LivingEntity) {
                     LivingEntity _livEnt3 = var15;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label130;
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var27 = _mobEnt.m_5448_();
                  } else {
                     var27 = null;
                  }

                  var15 = var27;
                  if (!(var15 instanceof LivingEntity)) {
                     break label120;
                  }

                  LivingEntity _livEnt5 = var15;
                  if (!_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     break label120;
                  }
               }

               cancel = false;
            }

            label109: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var29 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                     break label109;
                  }
               }

               var29 = 0;
            }

            if (var29 > 0) {
               cancel = false;
            }
         }

         if (entity.getPersistentData().m_128459_("cnt_target") < 200.0) {
            cancel = true;
         }

         if (GetDistanceProcedure.execute(entity) > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
            cancel = true;
         }

         label101: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                  var30 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                  break label101;
               }
            }

            var30 = 0;
         }

         if (var30 >= 2) {
            cancel = true;
         }

         label95: {
            label131: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     break label131;
                  }
               }

               if (!(entity instanceof LivingEntity)) {
                  break label95;
               }

               LivingEntity _livEnt10 = (LivingEntity)entity;
               if (!_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  break label95;
               }
            }

            cancel = true;
         }

         if (!cancel && entity.getPersistentData().m_128459_("friend_num") != 0.0) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList();
            Iterator var23 = _entfound.iterator();

            while(true) {
               if (!var23.hasNext()) {
                  return cancel;
               }

               Entity entityiterator = (Entity)var23.next();
               if (entity != entityiterator && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt15 = (LivingEntity)entityiterator;
                     if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break;
                     }
                  }

                  if (entityiterator.getPersistentData().m_128459_("select") != 0.0) {
                     break;
                  }
               }
            }

            cancel = true;
         }

         return cancel;
      }
   }
}
