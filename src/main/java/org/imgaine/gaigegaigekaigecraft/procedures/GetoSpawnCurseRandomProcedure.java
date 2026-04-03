package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade13Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade23Entity;
import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KenjakuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
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

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean haveGrade0 = false;
         boolean haveGrade1 = false;
         boolean target = false;
         boolean strong_enemy = false;
         boolean schoolDays = false;
         boolean Kenjaku = false;
         boolean player = false;
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
         double count_spirit = 0.0;
         double speed = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         double var10000;
         label721: {
            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label721;
               }
            }

            var10000 = 0.0;
         }

         strength = var10000;
         player = entity instanceof Player;
         schoolDays = entity instanceof GetoSuguruEntity;
         Kenjaku = entity instanceof KenjakuEntity;
         LivingEntity var123;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var123 = _mobEnt.getTarget();
         } else {
            var123 = null;
         }

         target = var123 instanceof LivingEntity;
         if (target) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var123 = _mobEnt.getTarget();
            } else {
               var123 = null;
            }
            int var125;
            label712: {
               LivingEntity var49 = var123;
               if (var49 instanceof LivingEntity) {
                  LivingEntity _livEnt = var49;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var125 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label712;
                  }
               }

               var125 = 0;
            }

            strong_enemy = (double)var125 >= strength * 0.5 || entity.getPersistentData().getDouble("cnt_target") > 400.0;
         }

         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            entity.getPersistentData().putDouble("cnt2", 1.0);
            if (entity.getPersistentData().getDouble("skill") == 1815.0) {
               if (entity.getPersistentData().getDouble("grade03") >= 0.0) {
                  entity.getPersistentData().putDouble("grade03", -1.0);
                  grade = 0.0;
                  kind = 3.0;
                  amount = 1.0;
                  spawnType = 1.0;
                  loop_num = 0.0;
               }
            } else {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(64.0), (e) -> true)) {
                  if (entity != entityiterator && !(entityiterator instanceof RikaEntity) && !(entityiterator instanceof Rika2Entity) && entityiterator.getPersistentData().getBoolean("CursedSpirit") && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker") && entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID())) {
                     int var10001;
                     label689: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label689;
                           }
                        }

                        var10001 = 0;
                     }

                     count_spirit += (double)var10001;
                  }
               }

               loop_num = 1.0;
               haveGrade0 = false;
               haveGrade1 = false;
               num1 = 0.0;
               int index0 = 0;

               label680: {
                  while(true) {
                     if (index0 >= 10) {
                        break label680;
                     }

                     ++num1;
                     if (!(num1 <= 9.0)) {
                        break label680;
                     }

                     if (entity.getPersistentData().getDouble("grade1" + Math.round(num1)) >= 0.0) {
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
                  label750: {
                     num1 = 2.0;
                     index0 = 0;

                     while(true) {
                        if (index0 >= 10) {
                           break label750;
                        }

                        ++num1;
                        if (!(num1 <= 8.0)) {
                           break label750;
                        }

                        if (entity.getPersistentData().getDouble("grade0" + Math.round(num1)) >= 0.0) {
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

               label758: {
                  if ((Math.random() < 0.2 || strong_enemy) && haveGrade1 && (entity.getPersistentData().getDouble("num_grade1") == 0.0 || Math.random() > 0.5 + entity.getPersistentData().getDouble("num_grade1") * 0.2)) {
                     LivingEntity var138;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var138 = _mobEnt.getTarget();
                     } else {
                        var138 = null;
                     }
                     int var139;
                     label629: {
                        LivingEntity _mobEnt = var138;
                        if (_mobEnt instanceof LivingEntity) {
                           LivingEntity _livEnt = _mobEnt;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var139 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label629;
                           }
                        }

                        var139 = 0;
                     }

                     if (count_spirit < (double)(var139 * 1)) {
                        grade = 1.0;
                        break label758;
                     }
                  }

                  if ((Math.random() < 0.1 || strong_enemy) && haveGrade0 && (entity.getPersistentData().getDouble("num_grade0") == 0.0 || Math.random() > 0.5 + entity.getPersistentData().getDouble("num_grade0") * 0.2)) {
                     LivingEntity var140;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var140 = _mobEnt.getTarget();
                     } else {
                        var140 = null;
                     }
                     int var141;
                     label613: {
                        LivingEntity _mobEnt = var140;
                        if (_mobEnt instanceof LivingEntity) {
                           LivingEntity _livEnt = _mobEnt;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var141 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label613;
                           }
                        }

                        var141 = 0;
                     }

                     if (count_spirit < (double)(var141 * 1)) {
                        grade = 0.0;
                        break label758;
                     }
                  }

                  if (Math.random() < 0.3) {
                     grade = 2.0;
                  } else {
                     grade = 3.0;
                  }
               }

               if (grade != 3.0) {
                  if (grade == 2.0) {
                     for(int index3 = 0; index3 < 256; ++index3) {
                        kind = Math.ceil(Math.random() * 17.0);
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

                              if (kind == 13.0) {
                                 amount = 1.0;
                                 spawnType = 0.0;
                                 break;
                              }

                              if (kind == 14.0) {
                                 amount = 1.0;
                                 spawnType = 0.0;
                                 break;
                              }

                              if (kind != 15.0) {
                                 if (kind == 16.0) {
                                    amount = 1.0;
                                    spawnType = 0.0;
                                    break;
                                 }

                                 if (kind == 17.0) {
                                    amount = 1.0;
                                    spawnType = 0.0;
                                    break;
                                 }
                              }
                           }
                        }
                     }
                  } else if (grade == 1.0) {
                     for(int index4 = 0; index4 < 256; ++index4) {
                        kind = (double)Math.round(Math.ceil(Math.random() * 9.0));
                        if (kind == 1.0 && entity.getPersistentData().getDouble("grade11") >= 0.0) {
                           amount = 1.0;
                           spawnType = 0.0;
                           entity.getPersistentData().putDouble("grade11", -1.0);
                           break;
                        }

                        if (kind == 2.0 && entity.getPersistentData().getDouble("grade12") >= 0.0) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade12", -1.0);
                           break;
                        }

                        if (kind == 3.0 && entity.getPersistentData().getDouble("grade13") >= 0.0 && schoolDays) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade13", -1.0);
                           break;
                        }

                        if (kind == 4.0 && entity.getPersistentData().getDouble("grade14") >= 0.0) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade14", -1.0);
                           break;
                        }

                        if (kind == 5.0 && entity.getPersistentData().getDouble("grade15") >= 0.0) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade15", -1.0);
                           break;
                        }

                        if (kind == 6.0 && entity.getPersistentData().getDouble("grade16") >= 0.0) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade16", -1.0);
                           break;
                        }

                        if (kind == 7.0 && entity.getPersistentData().getDouble("grade17") >= 0.0) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade17", -1.0);
                           break;
                        }

                        if (kind == 8.0 && entity.getPersistentData().getDouble("grade18") >= 0.0) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade18", -1.0);
                           break;
                        }

                        if (kind == 9.0 && entity.getPersistentData().getDouble("grade19") >= 0.0 && schoolDays) {
                           amount = 1.0;
                           spawnType = 1.0;
                           entity.getPersistentData().putDouble("grade19", -1.0);
                           break;
                        }
                     }
                  } else if (grade == 0.0) {
                     for(int index5 = 0; index5 < 256; ++index5) {
                        kind = (double)Math.round(Math.ceil(Math.random() * 9.0));
                        if (kind != 1.0 && kind != 2.0 && kind != 9.0) {
                           if (kind == 3.0 && entity.getPersistentData().getDouble("grade03") >= 0.0 && !Kenjaku) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var123 = _mobEnt.getTarget();
                              } else {
                                 var123 = null;
                              }

                              if (!(var123 instanceof OkkotsuYutaEntity)) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var123 = _mobEnt.getTarget();
                                 } else {
                                    var123 = null;
                                 }

                                 if (!(var123 instanceof OkkotsuYutaCullingGameEntity)) {
                                    amount = 1.0;
                                    spawnType = 1.0;
                                    entity.getPersistentData().putDouble("grade03", -1.0);
                                    break;
                                 }
                              }
                           }

                           if (kind == 4.0 && entity.getPersistentData().getDouble("grade04") >= 0.0 && Kenjaku) {
                              amount = 1.0;
                              spawnType = 1.0;
                              entity.getPersistentData().putDouble("grade04", -1.0);
                              break;
                           }

                           if (kind == 5.0 && entity.getPersistentData().getDouble("grade05") >= 0.0 && Kenjaku) {
                              amount = 1.0;
                              spawnType = 1.0;
                              entity.getPersistentData().putDouble("grade05", -1.0);
                              break;
                           }

                           if (kind == 6.0 && entity.getPersistentData().getDouble("grade06") >= 0.0 && Kenjaku) {
                              amount = 1.0;
                              spawnType = 1.0;
                              entity.getPersistentData().putDouble("grade06", -1.0);
                              break;
                           }

                           if (kind == 7.0 && entity.getPersistentData().getDouble("grade07") >= 0.0 && Kenjaku) {
                              amount = 1.0;
                              spawnType = 1.0;
                              entity.getPersistentData().putDouble("grade07", -1.0);
                              break;
                           }

                           if (kind == 8.0 && entity.getPersistentData().getDouble("grade08") >= 0.0 && !Kenjaku) {
                              amount = 1.0;
                              spawnType = 1.0;
                              entity.getPersistentData().putDouble("grade08", -1.0);
                              break;
                           }
                        }
                     }
                  }
               } else {
                  index0 = 0;

                  while(index0 < 256) {
                     kind = Math.ceil(Math.random() * 22.0);
                     if (kind == 4.0) {
                        amount = 6.0;
                        spawnType = 2.0;
                        break;
                     }

                     if (kind != 6.0 && kind != 14.0 && kind != 15.0 && kind != 17.0) {
                        if (kind != 8.0 && kind != 10.0 && kind != 13.0 && kind != 22.0) {
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

               entity.getPersistentData().putDouble("cnt3", grade);
               entity.getPersistentData().putDouble("cnt4", kind);
               entity.getPersistentData().putDouble("cnt5", amount);
               entity.getPersistentData().putDouble("cnt7", spawnType);
               entity.getPersistentData().putDouble("cnt8", loop_num);
            }
         } else {
            grade = entity.getPersistentData().getDouble("cnt3");
            kind = entity.getPersistentData().getDouble("cnt4");
            amount = entity.getPersistentData().getDouble("cnt5");
            spawnType = entity.getPersistentData().getDouble("cnt7");
            loop_num = entity.getPersistentData().getDouble("cnt8");
         }

         speed = 6.5;

         for(int index6 = 0; index6 < (int)Math.round(amount); ++index6) {
            if (spawnType == 1.0) {
               entity.setYRot((float)(yaw + (Math.random() - 0.5) * 90.0));
               entity.setXRot((float)Math.min(pitch, 0.0));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            } else if (spawnType == 2.0) {
               if (target) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var123 = _mobEnt.getTarget();
                  } else {
                     var123 = null;
                  }

                  Level var129 = ((Entity)var123).level();
                  ClipContext var142;
                  LivingEntity var10003;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10003 = _mobEnt.getTarget();
                  } else {
                     var10003 = null;
                  }

                  Vec3 var147 = ((Entity)var10003).getEyePosition(1.0F);
                  LivingEntity var10004;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10004 = _mobEnt.getTarget();
                  } else {
                     var10004 = null;
                  }

                  Vec3 var152 = ((Entity)var10004).getEyePosition(1.0F);
                  LivingEntity var10005;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10005 = _mobEnt.getTarget();
                  } else {
                     var10005 = null;
                  }

                  var152 = var152.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
                  ClipContext.Block var160 = Block.OUTLINE;
                  ClipContext.Fluid var10006 = Fluid.NONE;
                  LivingEntity var10007;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.getTarget();
                  } else {
                     var10007 = null;
                  }

                  var142 = new ClipContext(var147, var152, var160, var10006, var10007);
                  x_pos = (double)var129.clip(var142).getBlockPos().getX() + (Math.random() - 0.5) * 12.0;
                  LivingEntity var130;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var130 = _mobEnt.getTarget();
                  } else {
                     var130 = null;
                  }

                  Level var131 = ((Entity)var130).level();
                  LivingEntity var148;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var148 = _mobEnt.getTarget();
                  } else {
                     var148 = null;
                  }

                  Vec3 var149 = ((Entity)var148).getEyePosition(1.0F);
                  LivingEntity var154;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var154 = _mobEnt.getTarget();
                  } else {
                     var154 = null;
                  }

                  Vec3 var155 = ((Entity)var154).getEyePosition(1.0F);
                  LivingEntity var161;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var161 = _mobEnt.getTarget();
                  } else {
                     var161 = null;
                  }

                  var155 = var155.add(((Entity)var161).getViewVector(1.0F).scale(0.0));
                  ClipContext.Block var162 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.getTarget();
                  } else {
                     var10007 = null;
                  }

                  var142= new ClipContext(var149, var155, var162, var10006, var10007);
                  y_pos = (double)var131.clip(var142).getBlockPos().getY();
                  LivingEntity var132;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var132 = _mobEnt.getTarget();
                  } else {
                     var132 = null;
                  }

                  Level var133 = ((Entity)var132).level();
                  LivingEntity var150;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var150 = _mobEnt.getTarget();
                  } else {
                     var150 = null;
                  }

                  Vec3 var151 = ((Entity)var150).getEyePosition(1.0F);
                  LivingEntity var157;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var157 = _mobEnt.getTarget();
                  } else {
                     var157 = null;
                  }

                  Vec3 var158 = ((Entity)var157).getEyePosition(1.0F);
                  LivingEntity var163;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var163 = _mobEnt.getTarget();
                  } else {
                     var163 = null;
                  }

                  var158 = var158.add(((Entity)var163).getViewVector(1.0F).scale(0.0));
                  ClipContext.Block var164 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10007 = _mobEnt.getTarget();
                  } else {
                     var10007 = null;
                  }

                  var142 = new ClipContext(var151, var158, var164, var10006, var10007);
                  z_pos = (double)var133.clip(var142).getBlockPos().getZ() + (Math.random() - 0.5) * 12.0;
               } else {
                  x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + (Math.random() - 0.5) * 12.0;
                  y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
                  z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + (Math.random() - 0.5) * 12.0;
               }
            } else {
               entity.setYRot((float)(yaw + (Math.random() - 0.5) * 180.0));
               entity.setXRot((float)Math.min(pitch, 0.0));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            }

            y_pos += Math.random() * 0.1;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var134 = _level.getServer().getCommands();
               CommandSourceStack var145 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
               long var10002 = Math.round(grade);
               var134.performPrefixedCommand(var145, "summon gaigegaigekaigecraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
            }

            if (entity.isAlive()) {
               int var136;
               label463: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt103 = (LivingEntity)entity;
                     if (_livEnt103.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        label458: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var136 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label458;
                              }
                           }

                           var136 = 0;
                        }

                        ++var136;
                        break label463;
                     }
                  }

                  var136 = 0;
               }

               level_strength = (double)var136;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                  if (entityiterator.getPersistentData().getDouble("friend_num") == 0.0) {
                     entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                     entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     entityiterator.setYRot((float)yaw);
                     entityiterator.setXRot((float)pitch);
                     entityiterator.setYBodyRot(entityiterator.getYRot());
                     entityiterator.setYHeadRot(entityiterator.getYRot());
                     entityiterator.yRotO = entityiterator.getYRot();
                     entityiterator.xRotO = entityiterator.getXRot();
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity114 = (LivingEntity)entity;
                        if (_livingEntity114.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
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
                              LivingEntity _livingEntity116 = (LivingEntity)entityiterator;
                              if (_livingEntity116.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 double var146;
                                 AttributeInstance var137;
                                 label440: {
                                    var137 = _livingEntity116.getAttribute(Attributes.ATTACK_DAMAGE);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livingEntity115 = (LivingEntity)entityiterator;
                                       if (_livingEntity115.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                          var146 = _livingEntity115.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                          break label440;
                                       }
                                    }

                                    var146 = 0.0;
                                 }

                                 var137.setBaseValue(Math.max(var146, level_strength * 3.0 * 0.5 * ((Math.max(level_strength * 3.0, 1.0) - Math.max(level_strength2 * 3.0, 1.0)) / Math.max(level_strength * 3.0, 1.0))));
                              }
                           }
                        }
                     }

                     entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                     entityiterator.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                     entityiterator.getPersistentData().putBoolean("Player", player);
                     if (!(entityiterator instanceof CursedSpiritGrade13Entity) && !(entityiterator instanceof CursedSpiritGrade23Entity)) {
                        break;
                     }

                     entityiterator.push(entityiterator.getLookAngle().x * speed, entityiterator.getLookAngle().y * speed, entityiterator.getLookAngle().z * speed);
                     entityiterator.setDeltaMovement(new Vec3(entityiterator.getLookAngle().x * speed, entityiterator.getLookAngle().y * speed, entityiterator.getLookAngle().z * speed));
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     entityiterator.getPersistentData().putDouble("skill", 1706.0);
                     entityiterator.getPersistentData().putDouble("cnt1", 6.0);
                     entityiterator.getPersistentData().putDouble("cnt6", -2.5);
                     entityiterator.getPersistentData().putDouble("yaw", (double)entityiterator.getYRot());
                     entityiterator.getPersistentData().putDouble("pitch", (double)entityiterator.getXRot());
                     entityiterator.getPersistentData().putDouble("x_power", entityiterator.getLookAngle().x * speed * 0.5);
                     entityiterator.getPersistentData().putDouble("y_power", entityiterator.getLookAngle().y * speed * 0.5);
                     entityiterator.getPersistentData().putDouble("z_power", entityiterator.getLookAngle().z * speed * 0.5);
                     break;
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 25, 0.5, 0.5, 0.5, 0.0);
            }
         }

         entity.setYRot((float)yaw);
         entity.setXRot((float)pitch);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         if (entity.getPersistentData().getDouble("cnt1") >= loop_num) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
