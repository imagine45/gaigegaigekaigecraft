package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade03Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade04Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade05Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade06Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade07Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade08Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade11Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade12Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade13Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade14Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade15Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade16Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade18Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade19Entity;
import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruCurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KenjakuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIGetoSchoolDaysProcedure {
   public AIGetoSchoolDaysProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean domain = false;
         boolean StrongEnemy = false;
         boolean uzumaki = false;
         double num_spirit = 0.0;
         double distance = 0.0;
         double count_spirit = 0.0;
         double rnd = 0.0;
         double tick = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof GetoSuguruCurseUserEntity && !entity.getPersistentData().getBoolean("flag_start")) {
               entity.getPersistentData().putBoolean("flag_start", true);
               entity.getPersistentData().putBoolean("HasWeapon1", true);
            }

            if (!(entity instanceof GetoSuguruCurseUserEntity) && !(entity instanceof KenjakuEntity)) {
               lv_st = 13.0;
               lv_df = 3.0;
            } else {
               lv_st = 20.0;
               lv_df = 3.0;
            }

            label404: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label404;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label399: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label399;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)lv_df, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            Entity var31 = var10000;
            if (var31 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               entity.getPersistentData().putDouble("cnt_x2", 0.0);
               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  int var67;
                  label388: {
                     if (var31 instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)var31;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var67 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label388;
                        }
                     }

                     var67 = 0;
                  }

                  int var10001;
                  double var68;
                  label383: {
                     var68 = (double)var67;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label383;
                        }
                     }

                     var10001 = 0;
                  }

                  StrongEnemy = var68 >= (double)var10001 * 0.5 || entity.getPersistentData().getDouble("cnt_target") > 600.0;
                  if ((entity instanceof GetoSuguruCurseUserEntity || entity instanceof KenjakuEntity) && LogicStartProcedure.execute(entity)) {
                     boolean var71;
                     label367: {
                        label366: {
                           if (!entity.getPersistentData().getBoolean("use_uzumaki")) {
                              if (entity instanceof GetoSuguruCurseUserEntity) {
                                 float var69;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var69 = _livEnt.getHealth();
                                 } else {
                                    var69 = -1.0F;
                                 }

                                 double var70 = (double)var69;
                                 float var75;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var75 = _livEnt.getMaxHealth();
                                 } else {
                                    var75 = -1.0F;
                                 }

                                 if (var70 <= (double)var75 * 0.2) {
                                    break label366;
                                 }
                              }

                              if (((Entity)var31).getPersistentData().getDouble("skill") == 515.0) {
                                 break label366;
                              }
                           }

                           var71 = false;
                           break label367;
                        }

                        var71 = true;
                     }

                     uzumaki = var71;
                     if (uzumaki) {
                        entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 20.0));
                        entity.getPersistentData().putBoolean("uzumaki", true);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     if (entity instanceof KenjakuEntity) {
                        domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     }

                     ResetCounterProcedure.execute(entity);
                     count_spirit = 0.0;
                     num_spirit = 0.0;
                     if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                        entity.getPersistentData().putDouble("num_grade3", 0.0);
                        entity.getPersistentData().putDouble("num_grade2", 0.0);
                        entity.getPersistentData().putDouble("num_grade1", 0.0);
                        entity.getPersistentData().putDouble("num_grade0", 0.0);
                        Vec3 _center = new Vec3(x, y, z);

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(64.0), (e) -> true)) {
                           if (entity != entityiterator && !(entityiterator instanceof RikaEntity) && !(entityiterator instanceof Rika2Entity) && entityiterator.getPersistentData().getBoolean("CursedSpirit") && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker") && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID())) {
                              double var72;
                              label344: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var72 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label344;
                                    }
                                 }

                                 var72 = 0.0;
                              }

                              lv_st = var72;
                              ++num_spirit;
                              count_spirit += lv_st;
                              if (lv_st >= 10.0) {
                                 entity.getPersistentData().putDouble("num_grade0", entity.getPersistentData().getDouble("num_grade0") + 1.0);
                              } else if (lv_st >= 6.0) {
                                 entity.getPersistentData().putDouble("num_grade1", entity.getPersistentData().getDouble("num_grade1") + 1.0);
                              } else if (lv_st >= 3.0) {
                                 entity.getPersistentData().putDouble("num_grade2", entity.getPersistentData().getDouble("num_grade2") + 1.0);
                              } else {
                                 entity.getPersistentData().putDouble("num_grade3", entity.getPersistentData().getDouble("num_grade3") + 1.0);
                              }
                           }
                        }
                     }

                     distance = GetDistanceProcedure.execute(entity);
                     if (!(entity instanceof KenjakuEntity) || !domain && (AIDomainLogicProcedure.execute(world, x, y, z, entity) || !(Math.random() < 0.1))) {
                        label443: {
                           if (entity instanceof GetoSuguruCurseUserEntity) {
                              GetoSuguruCurseUserEntity _datEntL58 = (GetoSuguruCurseUserEntity)entity;
                              if ((Boolean)_datEntL58.getEntityData().get(GetoSuguruCurseUserEntity.DATA_rika) && LogicStartProcedure.execute(entity) && !LocateRikaProcedure.execute(world, entity) && StrongEnemy) {
                                 rnd = -1290.0;
                                 tick = 75.0;
                                 break label443;
                              }
                           }

                           if (!entity.getPersistentData().getBoolean("use_uzumaki")) {
                              if ((uzumaki || entity instanceof KenjakuEntity && Math.random() < 0.1 && distance < 10.0) && (LogicStartProcedure.execute(entity) || uzumaki)) {
                                 rnd = 15.0;
                                 tick = 150.0;
                                 if (entity instanceof GetoSuguruCurseUserEntity) {
                                    ItemStack var73;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var73 = _livEnt.getMainHandItem();
                                    } else {
                                       var73 = ItemStack.EMPTY;
                                    }

                                    if (var73.getItem() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                                       entity.getPersistentData().putBoolean("HasWeapon1", true);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          ItemStack _setstack = ItemStack.EMPTY.copy();
                                          _setstack.setCount(1);
                                          _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                          if (_entity instanceof Player) {
                                             Player _player = (Player)_entity;
                                             _player.getInventory().setChanged();
                                          }
                                       }
                                    }
                                 }
                              } else if (distance > 6.0 && num_spirit < 8.0 && LogicStartPassiveProcedure.execute(entity) && Math.random() < 0.5) {
                                 rnd = 11.0;
                                 tick = 5.0;
                              }
                           }

                           if (entity instanceof KenjakuEntity && LogicStartProcedure.execute(entity) && !uzumaki) {
                              distance = GetDistanceNearestEnemyProcedure.execute(world, entity);
                              if (distance < 10.0 && Math.random() < 0.1) {
                                 rnd = 2310.0;
                                 tick = 150.0;
                              }
                           }
                        }
                     } else {
                        rnd = 20.0;
                        tick = 20.0;
                     }

                     if (rnd != 0.0) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(1800.0 + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                        if (entity instanceof GetoSuguruCurseUserEntity) {
                           ItemStack var74;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var74 = _livEnt.getMainHandItem();
                           } else {
                              var74 = ItemStack.EMPTY;
                           }

                           if (var74.getItem() == ItemStack.EMPTY.getItem() && entity.getPersistentData().getBoolean("HasWeapon1")) {
                              entity.getPersistentData().putBoolean("HasWeapon1", false);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x2") % 200.0 == 190.0 && entity instanceof GetoSuguruCurseUserEntity) {
                  GetoSuguruCurseUserEntity _datEntL83 = (GetoSuguruCurseUserEntity)entity;
                  if ((Boolean)_datEntL83.getEntityData().get(GetoSuguruCurseUserEntity.DATA_rika) && LocateRikaProcedure.execute(world, entity)) {
                     entity.getPersistentData().putDouble("cnt1", 20.0);
                     TechniqueRika2Procedure.execute(world, x, y, z, entity);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt_x2") % 100.0 == 80.0 && entity.getPersistentData().getDouble("friend_num") != 0.0) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(64.0), (e) -> true)) {
                     if (entity != entityiterator && !(entityiterator instanceof RikaEntity) && !(entityiterator instanceof Rika2Entity) && entityiterator.getPersistentData().getBoolean("CursedSpirit") && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker") && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID())) {
                        if (entityiterator instanceof CursedSpiritGrade03Entity) {
                           entity.getPersistentData().putDouble("grade03", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade04Entity) {
                           entity.getPersistentData().putDouble("grade04", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade05Entity) {
                           entity.getPersistentData().putDouble("grade05", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade06Entity) {
                           entity.getPersistentData().putDouble("grade06", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade07Entity) {
                           entity.getPersistentData().putDouble("grade07", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade08Entity) {
                           entity.getPersistentData().putDouble("grade08", 0.0);
                        }

                        if (entityiterator instanceof CursedSpiritGrade11Entity) {
                           entity.getPersistentData().putDouble("grade11", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade12Entity) {
                           entity.getPersistentData().putDouble("grade12", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade13Entity) {
                           entity.getPersistentData().putDouble("grade13", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade14Entity) {
                           entity.getPersistentData().putDouble("grade14", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade15Entity) {
                           entity.getPersistentData().putDouble("grade15", 0.0);
                        }

                        if (entityiterator instanceof CursedSpiritGrade16Entity) {
                           entity.getPersistentData().putDouble("grade16", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade16Entity) {
                           entity.getPersistentData().putDouble("grade17", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade18Entity) {
                           entity.getPersistentData().putDouble("grade18", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade19Entity) {
                           entity.getPersistentData().putDouble("grade19", 0.0);
                        }

                        if (!entityiterator.level().isClientSide()) {
                           entityiterator.discard();
                        }
                     }
                  }
               }
            }

            if (entity instanceof GetoSuguruCurseUserEntity && var31 instanceof LivingEntity && (var31 instanceof RikaEntity && !(GetEntityFromUUIDProcedure.execute(world, ((Entity)var31).getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity) || var31 instanceof OkkotsuYutaEntity && !(GetEntityFromUUIDProcedure.execute(world, ((Entity)var31).getPersistentData().getString("RIKA_UUID")) instanceof LivingEntity)) && !((Entity)var31).isAlive() && entity instanceof GetoSuguruCurseUserEntity) {
               GetoSuguruCurseUserEntity _datEntSetL = (GetoSuguruCurseUserEntity)entity;
               _datEntSetL.getEntityData().set(GetoSuguruCurseUserEntity.DATA_rika, true);
            }
         }

      }
   }
}
