package org.imgaine.gaigegaigekaigecraft.procedures;

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
         Entity target_entity = null;
         double var10000 = Math.random();
         float var10002;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10002 = _livEnt.getHealth();
         } else {
            var10002 = -1.0F;
         }

         var10002 = Math.max(var10002, 1.0F);
         float var10003;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10003 = _livEnt.getMaxHealth();
         } else {
            var10003 = -1.0F;
         }

         if (var10000 > (double)(1.0F - var10002 / Math.max(var10003, 1.0F)) * 0.75) {
            cancel = true;
            LivingEntity var25;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var25 = _mobEnt.getTarget();
            } else {
               var25 = null;
            }
            LivingEntity var15;
            label126: {
               label136: {
                  var15 = var25;
                  if (var15 instanceof LivingEntity) {
                     LivingEntity _livEnt3 = var15;
                     if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label136;
                     }
                  }

                  if (!(var15 instanceof LivingEntity)) {
                     break label126;
                  }

                  LivingEntity _livEnt4 = var15;
                  if (!_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     break label126;
                  }
               }

               cancel = false;
            }

            if (((Entity)var15).getPersistentData().getDouble("skill") % 100.0 == 20.0) {
               cancel = false;
            }
            int var26;
            label115: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var26 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                     break label115;
                  }
               }

               var26 = 0;
            }

            if (var26 > 0) {
               cancel = false;
            }
         }

         if (!cancel) {
            label137: {
               if (entity.getPersistentData().getDouble("cnt_target") < 200.0) {
                  cancel = true;
               }
               int var27;
               label107: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                        var27 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getAmplifier();
                        break label107;
                     }
                  }

                  var27 = 0;
               }

               if (var27 >= 2) {
                  cancel = true;
               }

               label138: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt9 = (LivingEntity)entity;
                     if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label138;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label137;
                  }

                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (!_livEnt10.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label137;
                  }
               }

               cancel = true;
            }
         }

         if (!cancel && GetDistanceProcedure.execute(entity) > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
            cancel = true;
         }

         if (!cancel && entity.getPersistentData().getDouble("friend_num") != 0.0) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 / 2.0), (e) -> true);
            Iterator var23 = _entfound.iterator();

            while(true) {
               if (!var23.hasNext()) {
                  return cancel;
               }

               Entity entityiterator = (Entity)var23.next();
               if (entity != entityiterator && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt15 = (LivingEntity)entityiterator;
                     if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break;
                     }
                  }

                  if (entityiterator.getPersistentData().getDouble("select") != 0.0 || entityiterator.getPersistentData().getDouble("skill") % 100.0 == 20.0) {
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
