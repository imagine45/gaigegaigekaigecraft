package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Iterator;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LogicConfilmDomainProcedure {
   public LogicConfilmDomainProcedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean use = false;
         Entity target_entity = null;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }
         LivingEntity var16;
         label197: {
            label190: {
               label198: {
                  var16 = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt1 = (LivingEntity)entity;
                     if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) && var16 instanceof GojoSatoruEntity) {
                        break label198;
                     }
                  }

                  if (!(var16 instanceof LivingEntity)) {
                     break label190;
                  }

                  LivingEntity _livEnt3 = var16;
                  if (!_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || !(entity instanceof GojoSatoruEntity)) {
                     break label190;
                  }
               }

               if (var16 instanceof LivingEntity && (entity.getPersistentData().getDouble("cnt_target") > 600.0 || ((Entity)var16).getPersistentData().getDouble("cnt_target") > 600.0)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label197;
                     }
                  }

                  if (var16 instanceof LivingEntity) {
                     LivingEntity _livEnt9 = var16;
                     if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label197;
                     }
                  }

                  if (entity.getPersistentData().getDouble("skill") == 0.0 && ((Entity)var16).getPersistentData().getDouble("skill") == 0.0) {
                     if (var16 instanceof LivingEntity) {
                        LivingEntity _livEnt12 = var16;
                        if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           int var29;
                           label158: {
                              if (var16 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var16;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var29 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                    break label158;
                                 }
                              }

                              var29 = 0;
                           }

                           if (var29 <= 1000) {
                              break label197;
                           }
                        }
                     }

                     use = true;
                  }
               }
               break label197;
            }
            int var28;
            label151: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var28 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                     break label151;
                  }
               }

               var28 = 0;
            }

            if (var28 > 0) {
               use = true;
            }
         }

         if (!use) {
            if (var16 instanceof LivingEntity) {
               int var30;
               label142: {
                  if (var16 instanceof LivingEntity) {
                     LivingEntity _livEnt = var16;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var30 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                        break label142;
                     }
                  }

                  var30 = 0;
               }

               if (var30 > 1000 || ((Entity)var16).getPersistentData().getDouble("select") != 0.0 || ((Entity)var16).getPersistentData().getDouble("skill") % 100.0 == 20.0) {
                  use = true;
               }
            }

            if (entity.getPersistentData().getBoolean("flag_domain")) {
               use = true;
            }
         }

         if (use) {
            int var31;
            label201: {
               label129: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                        var31 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getAmplifier();
                        break label129;
                     }
                  }

                  var31 = 0;
               }

               if (var31 >= 2) {
                  use = false;
               }

               label202: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt21 = (LivingEntity)entity;
                     if (_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        break label202;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label201;
                  }

                  LivingEntity _livEnt22 = (LivingEntity)entity;
                  if (!_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label201;
                  }
               }

               use = false;
            }
         }

         if (use && GetDistanceProcedure.execute(entity) > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 4.0) {
            use = false;
         }

         if (use && entity.getPersistentData().getDouble("friend_num") != 0.0) {
            label203: {
               Vec3 _center = new Vec3(x, y, z);
               List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 / 2.0), (e) -> true);
               Iterator var25 = _entfound.iterator();

               while(true) {
                  if (!var25.hasNext()) {
                     break label203;
                  }

                  Entity entityiterator = (Entity)var25.next();
                  if (entity != entityiterator && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt27 = (LivingEntity)entityiterator;
                        if (_livEnt27.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break;
                        }
                     }

                     if (entityiterator.getPersistentData().getDouble("skill") != 0.0 && (entityiterator.getPersistentData().getDouble("select") != 0.0 || entityiterator.getPersistentData().getDouble("skill") % 100.0 == 20.0)) {
                        break;
                     }
                  }
               }

               use = false;
            }
         }

         if (use) {
            entity.getPersistentData().putBoolean("flag_domain", false);
         }

         return use;
      }
   }
}
