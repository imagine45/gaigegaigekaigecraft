package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double count_spirit = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double level_strength = 0.0;
         double level_resistance = 0.0;
         double level_physical_gifted = 0.0;
         boolean adult = false;
         boolean uzumaki = false;
         boolean kenjaku = false;
         boolean awaked = false;
         boolean domain = false;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            adult = entity instanceof GetoSuguruCurseUserEntity;
            kenjaku = entity instanceof KenjakuEntity;
            if (adult && !entity.getPersistentData().m_128471_("flag_start")) {
               entity.getPersistentData().m_128379_("flag_start", true);
               entity.getPersistentData().m_128379_("HasWeapon1", true);
            }

            if (!adult && !kenjaku) {
               lv_st = 13.0;
               lv_df = 3.0;
            } else {
               lv_st = 20.0;
               lv_df = 3.0;
            }

            label343: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                     break label343;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label338: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                     break label338;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)lv_df, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               entity.getPersistentData().m_128347_("cnt_x2", 0.0);
               if (adult || kenjaku) {
                  label318: {
                     label317: {
                        if (!entity.getPersistentData().m_128471_("use_uzumaki")) {
                           if (adult) {
                              float var71;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var71 = _livEnt.m_21223_();
                              } else {
                                 var71 = -1.0F;
                              }

                              double var72 = (double)var71;
                              float var10001;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.m_21233_();
                              } else {
                                 var10001 = -1.0F;
                              }

                              if (var72 <= (double)var10001 * 0.2) {
                                 break label317;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("skill") == 515.0) {
                              break label317;
                           }
                        }

                        var74 = false;
                        break label318;
                     }

                     var74 = true;
                  }

                  uzumaki = var74;
                  uzumaki = uzumaki && LogicStartProcedure.execute(entity);
                  if (uzumaki) {
                     entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), 20.0));
                     entity.getPersistentData().m_128379_("uzumaki", true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  if (entity instanceof KenjakuEntity) {
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  }

                  ResetCounterProcedure.execute(entity);
                  count_spirit = 0.0;
                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                     entity.getPersistentData().m_128347_("num_grade3", 0.0);
                     entity.getPersistentData().m_128347_("num_grade2", 0.0);
                     entity.getPersistentData().m_128347_("num_grade1", 0.0);
                     entity.getPersistentData().m_128347_("num_grade0", 0.0);
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(64.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                           label288: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var75 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label288;
                                 }
                              }

                              var75 = 0.0;
                           }

                           lv_st = var75;
                           count_spirit += lv_st;
                           if (lv_st >= 10.0) {
                              entity.getPersistentData().m_128347_("num_grade0", entity.getPersistentData().m_128459_("num_grade0") + 1.0);
                           } else if (lv_st >= 6.0) {
                              entity.getPersistentData().m_128347_("num_grade1", entity.getPersistentData().m_128459_("num_grade1") + 1.0);
                           } else if (lv_st >= 3.0) {
                              entity.getPersistentData().m_128347_("num_grade2", entity.getPersistentData().m_128459_("num_grade2") + 1.0);
                           } else {
                              entity.getPersistentData().m_128347_("num_grade3", entity.getPersistentData().m_128459_("num_grade3") + 1.0);
                           }
                        }
                     }
                  }

                  distance = GetDistanceProcedure.execute(entity);
                  if (!kenjaku || !domain && (AIDomainLogicProcedure.execute(world, x, y, z, entity) || !(Math.random() < 0.1))) {
                     if (!entity.getPersistentData().m_128471_("use_uzumaki")) {
                        if (!uzumaki && (!kenjaku || !(Math.random() < 0.1) || !(distance < 10.0)) || !LogicStartProcedure.execute(entity) && !uzumaki) {
                           if (distance > 6.0) {
                              LivingEntity var78;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var78 = _mobEnt.m_5448_();
                              } else {
                                 var78 = null;
                              }

                              label250: {
                                 LivingEntity var65 = var78;
                                 if (var65 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var65;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var79 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label250;
                                    }
                                 }

                                 var79 = 0;
                              }

                              if (count_spirit < (double)(var79 * 1) && LogicStartPassiveProcedure.execute(entity)) {
                                 rnd = 11.0;
                                 tick = 5.0;
                              }
                           }
                        } else {
                           rnd = 15.0;
                           tick = 150.0;
                           if (adult) {
                              ItemStack var76;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var76 = _livEnt.m_21205_();
                              } else {
                                 var76 = ItemStack.f_41583_;
                              }

                              if (var76.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                                 entity.getPersistentData().m_128379_("HasWeapon1", true);
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                                    _setstack.m_41764_(1);
                                    _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                    if (_entity instanceof Player) {
                                       Player _player = (Player)_entity;
                                       _player.m_150109_().m_6596_();
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if (kenjaku && LogicStartProcedure.execute(entity) && !uzumaki) {
                        distance = GetDistanceNearestEnemyProcedure.execute(world, entity);
                        if (distance < 10.0 && Math.random() < 0.1) {
                           rnd = 2310.0;
                           tick = 150.0;
                        }
                     }
                  } else {
                     rnd = 20.0;
                     tick = 20.0;
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(1800.0 + rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 4, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                     if (adult) {
                        ItemStack var77;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var77 = _livEnt.m_21205_();
                        } else {
                           var77 = ItemStack.f_41583_;
                        }

                        if (var77.m_41720_() == ItemStack.f_41583_.m_41720_() && entity.getPersistentData().m_128471_("HasWeapon1")) {
                           entity.getPersistentData().m_128379_("HasWeapon1", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
               entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x2") % 100.0 == 80.0 && entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(64.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entity != entityiterator && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                        if (entityiterator instanceof CursedSpiritGrade03Entity) {
                           entity.getPersistentData().m_128347_("grade03", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade04Entity) {
                           entity.getPersistentData().m_128347_("grade04", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade05Entity) {
                           entity.getPersistentData().m_128347_("grade05", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade06Entity) {
                           entity.getPersistentData().m_128347_("grade06", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade07Entity) {
                           entity.getPersistentData().m_128347_("grade07", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade08Entity) {
                           entity.getPersistentData().m_128347_("grade08", 0.0);
                        }

                        if (entityiterator instanceof CursedSpiritGrade11Entity) {
                           entity.getPersistentData().m_128347_("grade11", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade12Entity) {
                           entity.getPersistentData().m_128347_("grade12", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade13Entity) {
                           entity.getPersistentData().m_128347_("grade13", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade14Entity) {
                           entity.getPersistentData().m_128347_("grade14", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade15Entity) {
                           entity.getPersistentData().m_128347_("grade15", 0.0);
                        }

                        if (entityiterator instanceof CursedSpiritGrade16Entity) {
                           entity.getPersistentData().m_128347_("grade16", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade16Entity) {
                           entity.getPersistentData().m_128347_("grade17", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade18Entity) {
                           entity.getPersistentData().m_128347_("grade18", 0.0);
                        } else if (entityiterator instanceof CursedSpiritGrade19Entity) {
                           entity.getPersistentData().m_128347_("grade19", 0.0);
                        }

                        if (!entityiterator.m_9236_().m_5776_()) {
                           entityiterator.m_146870_();
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
