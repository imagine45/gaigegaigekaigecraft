package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KenjakuEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GetoSpawnCurseRandomProcedure {
   public GetoSpawnCurseRandomProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double amount = 0.0;
         double strength = 0.0;
         double kind = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double spawnType = 0.0;
         double grade = 0.0;
         double loop_num = 0.0;
         double num1 = 0.0;
         double level_strength = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double level_strength2 = 0.0;
         boolean haveGrade0 = false;
         boolean haveGrade1 = false;
         boolean target = false;
         boolean strong_enemy = false;
         boolean schoolDays = false;
         boolean Kenjaku = false;
         boolean player = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         double var10000;
         label602: {
            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label602;
               }
            }

            var10000 = 0.0;
         }

         strength = var10000;
         player = entity instanceof Player;
         schoolDays = entity instanceof GetoSuguruEntity;
         Kenjaku = entity instanceof KenjakuEntity;
         LivingEntity var99;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var99 = _mobEnt.m_5448_();
         } else {
            var99 = null;
         }

         target = var99 instanceof LivingEntity;
         if (target) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var99 = _mobEnt.m_5448_();
            } else {
               var99 = null;
            }

            label593: {
               LivingEntity var39 = var99;
               if (var39 instanceof LivingEntity) {
                  LivingEntity _livEnt = var39;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var101 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label593;
                  }
               }

               var101 = 0;
            }

            strong_enemy = (double)var101 >= strength * 0.5 || entity.getPersistentData().m_128459_("cnt_target") > 400.0;
         }

         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            entity.getPersistentData().m_128347_("cnt2", 1.0);
            loop_num = 1.0;
            haveGrade0 = false;
            haveGrade1 = false;
            num1 = 0.0;
            int index0 = 0;

            label580: {
               while(true) {
                  if (index0 >= 10) {
                     break label580;
                  }

                  ++num1;
                  if (!(num1 <= 9.0)) {
                     break label580;
                  }

                  if (entity.getPersistentData().m_128459_("grade1" + Math.round(num1)) >= 0.0) {
                     if (schoolDays) {
                        if (num1 != 6.0) {
                           break;
                        }
                     } else if (num1 != 3.0 && num1 != 9.0 && (!Kenjaku || num1 != 1.0)) {
                        break;
                     }
                  }

                  ++index0;
               }

               haveGrade1 = true;
            }

            if (!schoolDays) {
               label629: {
                  num1 = 2.0;
                  index0 = 0;

                  while(true) {
                     if (index0 >= 10) {
                        break label629;
                     }

                     ++num1;
                     if (!(num1 <= 8.0)) {
                        break label629;
                     }

                     if (entity.getPersistentData().m_128459_("grade0" + Math.round(num1)) >= 0.0) {
                        if (Kenjaku) {
                           if (num1 != 3.0 && num1 != 8.0) {
                              break;
                           }
                        } else if (num1 != 4.0 && num1 != 5.0 && num1 != 6.0 && num1 != 7.0) {
                           break;
                        }
                     }

                     ++index0;
                  }

                  haveGrade0 = true;
               }
            }

            if (!(Math.random() < 0.2) && !strong_enemy || !haveGrade1 || entity.getPersistentData().m_128459_("num_grade1") != 0.0 && !(Math.random() > 0.5 + entity.getPersistentData().m_128459_("num_grade1") * 0.2)) {
               if (!(Math.random() < 0.1) && !strong_enemy || !haveGrade0 || entity.getPersistentData().m_128459_("num_grade0") != 0.0 && !(Math.random() > 0.5 + entity.getPersistentData().m_128459_("num_grade0") * 0.2)) {
                  if (Math.random() < 0.3) {
                     grade = 2.0;
                  } else {
                     grade = 3.0;
                  }
               } else {
                  grade = 0.0;
               }
            } else {
               grade = 1.0;
            }

            if (grade != 3.0) {
               if (grade == 2.0) {
                  for(int index3 = 0; index3 < 256; ++index3) {
                     kind = Math.ceil(Math.random() * 12.0);
                     if (kind == 1.0) {
                        amount = 1.0;
                        spawnType = 0.0;
                        break;
                     }

                     if (kind != 2.0) {
                        if (kind == 3.0) {
                           amount = 1.0;
                           spawnType = 0.0;
                           break;
                        }

                        if (kind == 4.0 && Kenjaku) {
                           amount = 2.0;
                           spawnType = 0.0;
                           break;
                        }

                        if (kind == 5.0) {
                           amount = 1.0;
                           spawnType = 0.0;
                           break;
                        }

                        if (kind == 6.0) {
                           amount = 1.0;
                           spawnType = 0.0;
                           break;
                        }

                        if (kind != 7.0) {
                           if (kind == 8.0) {
                              amount = 1.0;
                              spawnType = 0.0;
                              break;
                           }

                           if (kind == 9.0) {
                              amount = 1.0;
                              spawnType = 0.0;
                              break;
                           }

                           if (kind == 10.0) {
                              amount = 2.0;
                              spawnType = 0.0;
                              break;
                           }

                           if (kind == 11.0) {
                              amount = 1.0;
                              spawnType = 0.0;
                              break;
                           }

                           if (kind == 12.0) {
                              amount = 1.0;
                              spawnType = 0.0;
                              break;
                           }
                        }
                     }
                  }
               } else if (grade == 1.0) {
                  for(int index4 = 0; index4 < 256; ++index4) {
                     kind = (double)Math.round(Math.ceil(Math.random() * 9.0));
                     if (kind == 1.0 && entity.getPersistentData().m_128459_("grade11") >= 0.0) {
                        amount = 1.0;
                        spawnType = 0.0;
                        entity.getPersistentData().m_128347_("grade11", -1.0);
                        break;
                     }

                     if (kind == 2.0 && entity.getPersistentData().m_128459_("grade12") >= 0.0) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade12", -1.0);
                        break;
                     }

                     if (kind == 3.0 && entity.getPersistentData().m_128459_("grade13") >= 0.0 && schoolDays) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade13", -1.0);
                        break;
                     }

                     if (kind == 4.0 && entity.getPersistentData().m_128459_("grade14") >= 0.0) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade14", -1.0);
                        break;
                     }

                     if (kind == 5.0 && entity.getPersistentData().m_128459_("grade15") >= 0.0) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade15", -1.0);
                        break;
                     }

                     if (kind == 6.0 && entity.getPersistentData().m_128459_("grade16") >= 0.0) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade16", -1.0);
                        break;
                     }

                     if (kind == 7.0 && entity.getPersistentData().m_128459_("grade17") >= 0.0) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade17", -1.0);
                        break;
                     }

                     if (kind == 8.0 && entity.getPersistentData().m_128459_("grade18") >= 0.0) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade18", -1.0);
                        break;
                     }

                     if (kind == 9.0 && entity.getPersistentData().m_128459_("grade19") >= 0.0 && schoolDays) {
                        amount = 1.0;
                        spawnType = 1.0;
                        entity.getPersistentData().m_128347_("grade19", -1.0);
                        break;
                     }
                  }
               } else if (grade == 0.0) {
                  for(int index5 = 0; index5 < 256; ++index5) {
                     kind = (double)Math.round(Math.ceil(Math.random() * 9.0));
                     if (kind != 1.0 && kind != 2.0 && kind != 9.0) {
                        if (kind == 3.0 && entity.getPersistentData().m_128459_("grade03") >= 0.0 && !Kenjaku) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().m_128347_("grade03", -1.0);
                           break;
                        }

                        if (kind == 4.0 && entity.getPersistentData().m_128459_("grade04") >= 0.0 && Kenjaku) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().m_128347_("grade04", -1.0);
                           break;
                        }

                        if (kind == 5.0 && entity.getPersistentData().m_128459_("grade05") >= 0.0 && Kenjaku) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().m_128347_("grade05", -1.0);
                           break;
                        }

                        if (kind == 6.0 && entity.getPersistentData().m_128459_("grade06") >= 0.0 && Kenjaku) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().m_128347_("grade06", -1.0);
                           break;
                        }

                        if (kind == 7.0 && entity.getPersistentData().m_128459_("grade07") >= 0.0 && Kenjaku) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().m_128347_("grade07", -1.0);
                           break;
                        }

                        if (kind == 8.0 && entity.getPersistentData().m_128459_("grade08") >= 0.0 && !Kenjaku) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().m_128347_("grade08", -1.0);
                           break;
                        }
                     }
                  }
               }
            } else {
               index0 = 0;

               while(index0 < 256) {
                  kind = Math.ceil(Math.random() * 20.0);
                  if (kind == 4.0) {
                     amount = 6.0;
                     spawnType = 2.0;
                     break;
                  }

                  if (kind != 6.0 && kind != 14.0 && kind != 15.0 && kind != 17.0) {
                     if (kind != 8.0 && kind != 10.0 && kind != 13.0) {
                        if (kind != 11.0 && kind != 12.0) {
                           if (kind != 9.0 && kind != 13.0 && kind != 18.0) {
                              ++index0;
                              continue;
                           }

                           amount = 8.0;
                           spawnType = 0.0;
                           break;
                        }

                        amount = 1.0;
                        spawnType = 0.0;
                        break;
                     }

                     amount = 2.0;
                     spawnType = 0.0;
                     break;
                  }

                  amount = 2.0;
                  spawnType = 0.0;
                  loop_num = 8.0;
                  break;
               }
            }

            entity.getPersistentData().m_128347_("cnt3", grade);
            entity.getPersistentData().m_128347_("cnt4", kind);
            entity.getPersistentData().m_128347_("cnt5", amount);
            entity.getPersistentData().m_128347_("cnt7", spawnType);
            entity.getPersistentData().m_128347_("cnt8", loop_num);
         } else {
            grade = entity.getPersistentData().m_128459_("cnt3");
            kind = entity.getPersistentData().m_128459_("cnt4");
            amount = entity.getPersistentData().m_128459_("cnt5");
            spawnType = entity.getPersistentData().m_128459_("cnt7");
            loop_num = entity.getPersistentData().m_128459_("cnt8");
         }

         for(int index6 = 0; index6 < (int)Math.round(amount); ++index6) {
            if (spawnType == 1.0) {
               entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 90.0));
               entity.m_146926_((float)Math.min(pitch, 0.0));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            } else if (spawnType == 2.0) {
               if (target) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var99 = _mobEnt.m_5448_();
                  } else {
                     var99 = null;
                  }

                  Level var103 = ((Entity)var99).m_9236_();
                  ClipContext var10001 = new ClipContext;
                  LivingEntity var10003;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10003 = _mobEnt.m_5448_();
                  } else {
                     var10003 = null;
                  }

                  Vec3 var116 = ((Entity)var10003).m_20299_(1.0F);
                  LivingEntity var10004;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10004 = _mobEnt.m_5448_();
                  } else {
                     var10004 = null;
                  }

                  Vec3 var121 = ((Entity)var10004).m_20299_(1.0F);
                  LivingEntity var10005;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10005 = _mobEnt.m_5448_();
                  } else {
                     var10005 = null;
                  }

                  var121 = var121.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var129 = Block.OUTLINE;
                  ClipContext.Fluid var10006 = Fluid.NONE;
                  LivingEntity var10007;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var10001.<init>(var116, var121, var129, var10006, var10007);
                  x_pos = (double)var103.m_45547_(var10001).m_82425_().m_123341_() + (Math.random() - 0.5) * 12.0;
                  LivingEntity var104;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var104 = _mobEnt.m_5448_();
                  } else {
                     var104 = null;
                  }

                  Level var105 = ((Entity)var104).m_9236_();
                  var10001 = new ClipContext;
                  LivingEntity var117;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var117 = _mobEnt.m_5448_();
                  } else {
                     var117 = null;
                  }

                  Vec3 var118 = ((Entity)var117).m_20299_(1.0F);
                  LivingEntity var123;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var123 = _mobEnt.m_5448_();
                  } else {
                     var123 = null;
                  }

                  Vec3 var124 = ((Entity)var123).m_20299_(1.0F);
                  LivingEntity var130;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var130 = _mobEnt.m_5448_();
                  } else {
                     var130 = null;
                  }

                  var124 = var124.m_82549_(((Entity)var130).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var131 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var10001.<init>(var118, var124, var131, var10006, var10007);
                  y_pos = (double)var105.m_45547_(var10001).m_82425_().m_123342_();
                  LivingEntity var106;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var106 = _mobEnt.m_5448_();
                  } else {
                     var106 = null;
                  }

                  Level var107 = ((Entity)var106).m_9236_();
                  var10001 = new ClipContext;
                  LivingEntity var119;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var119 = _mobEnt.m_5448_();
                  } else {
                     var119 = null;
                  }

                  Vec3 var120 = ((Entity)var119).m_20299_(1.0F);
                  LivingEntity var126;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var126 = _mobEnt.m_5448_();
                  } else {
                     var126 = null;
                  }

                  Vec3 var127 = ((Entity)var126).m_20299_(1.0F);
                  LivingEntity var132;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var132 = _mobEnt.m_5448_();
                  } else {
                     var132 = null;
                  }

                  var127 = var127.m_82549_(((Entity)var132).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var133 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var10001.<init>(var120, var127, var133, var10006, var10007);
                  z_pos = (double)var107.m_45547_(var10001).m_82425_().m_123343_() + (Math.random() - 0.5) * 12.0;
               } else {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + (Math.random() - 0.5) * 12.0;
                  y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + (Math.random() - 0.5) * 12.0;
               }
            } else {
               entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 180.0));
               entity.m_146926_((float)Math.min(pitch, 0.0));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(4.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            }

            y_pos += Math.random() * 0.1;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var108 = _level.m_7654_().m_129892_();
               CommandSourceStack var114 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
               long var10002 = Math.round(grade);
               var108.m_230957_(var114, "summon jujutsucraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
            }

            if (entity.m_6084_()) {
               label388: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt82 = (LivingEntity)entity;
                     if (_livEnt82.m_21023_(MobEffects.f_19600_)) {
                        label383: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var110 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label383;
                              }
                           }

                           var110 = 0;
                        }

                        ++var110;
                        break label388;
                     }
                  }

                  var110 = 0;
               }

               level_strength = (double)var110;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entityiterator.getPersistentData().m_128459_("friend_num") == 0.0) {
                     entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityiterator.m_146922_((float)yaw);
                     entityiterator.m_146926_((float)pitch);
                     entityiterator.m_5618_(entityiterator.m_146908_());
                     entityiterator.m_5616_(entityiterator.m_146908_());
                     entityiterator.f_19859_ = entityiterator.m_146908_();
                     entityiterator.f_19860_ = entityiterator.m_146909_();
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 1, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity93 = (LivingEntity)entity;
                        if (_livingEntity93.m_21204_().m_22171_(Attributes.f_22281_)) {
                           if (grade == 0.0) {
                              level_strength2 = 13.0;
                           } else if (grade == 1.0) {
                              level_strength2 = 10.0;
                           } else if (grade == 2.0) {
                              level_strength2 = 6.0;
                           } else if (grade == 3.0) {
                              level_strength2 = 2.0;
                           } else {
                              level_strength2 = 0.0;
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity95 = (LivingEntity)entityiterator;
                              if (_livingEntity95.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 double var115;
                                 label365: {
                                    var111 = _livingEntity95.getAttribute_(Attributes.f_22281_);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livingEntity94 = (LivingEntity)entityiterator;
                                       if (_livingEntity94.m_21204_().m_22171_(Attributes.f_22281_)) {
                                          var115 = _livingEntity94.getAttribute_(Attributes.f_22281_).m_22115_();
                                          break label365;
                                       }
                                    }

                                    var115 = 0.0;
                                 }

                                 var111.m_22100_(Math.max(var115, level_strength * 3.0 * 0.5 * ((Math.max(level_strength * 3.0, 1.0) - Math.max(level_strength2 * 3.0, 1.0)) / Math.max(level_strength * 3.0, 1.0))));
                              }
                           }
                        }
                     }

                     entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityiterator.getPersistentData().m_128379_("Player", player);
                     break;
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, 0.5, 0.5, 0.5, 0.0);
            }
         }

         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= loop_num) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
