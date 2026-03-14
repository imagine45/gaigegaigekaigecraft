package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         boolean sukuna_target;
         boolean gojo_target;
         boolean use;
         boolean var10000;
         label253: {
            use = false;
            boolean sukuna = false;
            sukuna_target = false;
            boolean gojo = false;
            gojo_target = false;
            use = false;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                  var10000 = true;
                  break label253;
               }
            }

            var10000 = false;
         }

         boolean var25 = var10000;
         boolean var26 = entity instanceof GojoSatoruEntity;
         LivingEntity var49;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var49 = _mobEnt.m_5448_();
         } else {
            var49 = null;
         }

         if (var49 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var49 = _mobEnt.m_5448_();
            } else {
               var49 = null;
            }

            label244: {
               LivingEntity var16 = var49;
               if (var16 instanceof LivingEntity) {
                  LivingEntity _livEnt5 = var16;
                  if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     var51 = true;
                     break label244;
                  }
               }

               var51 = false;
            }

            sukuna_target = var51;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var49 = _mobEnt.m_5448_();
            } else {
               var49 = null;
            }

            gojo_target = var49 instanceof GojoSatoruEntity;
         }

         if (var25 && gojo_target || sukuna_target && var26) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var49 = _mobEnt.m_5448_();
            } else {
               var49 = null;
            }

            if (var49 instanceof LivingEntity) {
               label261: {
                  if (!(entity.getPersistentData().m_128459_("cnt_target") > 600.0)) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var49 = _mobEnt.m_5448_();
                     } else {
                        var49 = null;
                     }

                     if (!(((Entity)var49).getPersistentData().m_128459_("cnt_target") > 600.0)) {
                        break label261;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt13 = (LivingEntity)entity;
                     if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label261;
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var49 = _mobEnt.m_5448_();
                  } else {
                     var49 = null;
                  }

                  LivingEntity var18 = var49;
                  if (var18 instanceof LivingEntity) {
                     LivingEntity _livEnt15 = var18;
                     if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label261;
                     }
                  }

                  if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var49 = _mobEnt.m_5448_();
                     } else {
                        var49 = null;
                     }

                     if (((Entity)var49).getPersistentData().m_128459_("skill") == 0.0) {
                        label262: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var49 = _mobEnt.m_5448_();
                           } else {
                              var49 = null;
                           }

                           LivingEntity var23 = var49;
                           if (var23 instanceof LivingEntity) {
                              LivingEntity _livEnt20 = var23;
                              if (_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var49 = _mobEnt.m_5448_();
                                 } else {
                                    var49 = null;
                                 }

                                 label203: {
                                    var23 = var49;
                                    if (var23 instanceof LivingEntity) {
                                       LivingEntity _livEnt = var23;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var60 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                          break label203;
                                       }
                                    }

                                    var60 = 0;
                                 }

                                 if (var60 <= 1000) {
                                    break label262;
                                 }
                              }
                           }

                           use = true;
                        }
                     }
                  }
               }
            }
         } else {
            label196: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var53 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                     break label196;
                  }
               }

               var53 = 0;
            }

            if (var53 > 0) {
               use = true;
            }
         }

         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var49 = _mobEnt.m_5448_();
         } else {
            var49 = null;
         }

         if (var49 instanceof LivingEntity) {
            label264: {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.m_5448_();
               } else {
                  var49 = null;
               }

               label187: {
                  LivingEntity _livEnt38 = var49;
                  if (_livEnt38 instanceof LivingEntity) {
                     LivingEntity _livEnt = _livEnt38;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var63 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                        break label187;
                     }
                  }

                  var63 = 0;
               }

               if (var63 <= 1000) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var49 = _mobEnt.m_5448_();
                  } else {
                     var49 = null;
                  }

                  if (((Entity)var49).getPersistentData().m_128459_("select") == 0.0) {
                     break label264;
                  }
               }

               use = true;
            }
         }

         if (entity.getPersistentData().m_128471_("flag_domain")) {
            use = true;
         }

         if (GetDistanceProcedure.execute(entity) > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 4.0) {
            use = false;
         }

         label174: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                  var65 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                  break label174;
               }
            }

            var65 = 0;
         }

         if (var65 >= 2) {
            use = false;
         }

         label168: {
            label265: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt32 = (LivingEntity)entity;
                  if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     break label265;
                  }
               }

               if (!(entity instanceof LivingEntity)) {
                  break label168;
               }

               LivingEntity _livEnt33 = (LivingEntity)entity;
               if (!_livEnt33.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  break label168;
               }
            }

            use = false;
         }

         if (use && entity.getPersistentData().m_128459_("friend_num") != 0.0) {
            label266: {
               Vec3 _center = new Vec3(x, y, z);
               List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList();
               Iterator var41 = _entfound.iterator();

               while(true) {
                  if (!var41.hasNext()) {
                     break label266;
                  }

                  Entity entityiterator = (Entity)var41.next();
                  if (entity != entityiterator && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt38 = (LivingEntity)entityiterator;
                        if (_livEnt38.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break;
                        }
                     }

                     if (entityiterator.getPersistentData().m_128459_("skill") != 0.0 && entityiterator.getPersistentData().m_128459_("select") != 0.0) {
                        break;
                     }
                  }
               }

               use = false;
            }
         }

         if (use) {
            entity.getPersistentData().m_128379_("flag_domain", false);
         }

         return use;
      }
   }
}
