package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class TechniqueTamamonomae2Procedure {
   public TechniqueTamamonomae2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean tamamo_no_mae = false;
         double damage = 0.0;
         double z_power = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         if (entity.getPersistentData().getDouble("cnt5") == 0.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y + (double)entity.getBbHeight() * 0.5, z, 20, 0.2, 0.2, 0.2, 0.0);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               Level var84 = ((Entity)var10000).level();
               ClipContext var10001;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.getTarget();
               } else {
                  var10003 = null;
               }

               Vec3 var108 = ((Entity)var10003).getEyePosition(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               Vec3 var119 = ((Entity)var10004).getEyePosition(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               var119 = var119.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var140 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var108, var119, var140, var10006, var10007);
               x_pos = (double)var84.clip(var10001).getBlockPos().getX();
               LivingEntity var85;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var85 = _mobEnt.getTarget();
               } else {
                  var85 = null;
               }

               Level var86 = ((Entity)var85).level();
               LivingEntity var109;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var109 = _mobEnt.getTarget();
               } else {
                  var109 = null;
               }

               Vec3 var110 = ((Entity)var109).getEyePosition(1.0F);
               LivingEntity var121;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var121 = _mobEnt.getTarget();
               } else {
                  var121 = null;
               }

               Vec3 var122 = ((Entity)var121).getEyePosition(1.0F);
               LivingEntity var141;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var141 = _mobEnt.getTarget();
               } else {
                  var141 = null;
               }

               var122 = var122.add(((Entity)var141).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var142 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var110, var122, var142, var10006, var10007);
               y_pos = (double)var86.clip(var10001).getBlockPos().getY();
               LivingEntity var87;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var87 = _mobEnt.getTarget();
               } else {
                  var87 = null;
               }

               Level var88 = ((Entity)var87).level();
               LivingEntity var111;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var111 = _mobEnt.getTarget();
               } else {
                  var111 = null;
               }

               Vec3 var112 = ((Entity)var111).getEyePosition(1.0F);
               LivingEntity var124;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var124 = _mobEnt.getTarget();
               } else {
                  var124 = null;
               }

               Vec3 var125 = ((Entity)var124).getEyePosition(1.0F);
               LivingEntity var143;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var143 = _mobEnt.getTarget();
               } else {
                  var143 = null;
               }

               var125 = var125.add(((Entity)var143).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var144 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var112, var125, var144, var10006, var10007);
               z_pos = (double)var88.clip(var10001).getBlockPos().getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               Level var91 = ((Entity)var10000).level();
               ClipContext var100;
               LivingEntity var113;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var113 = _mobEnt.getTarget();
               } else {
                  var113 = null;
               }

               Vec3 var114 = ((Entity)var113).getEyePosition(1.0F);
               LivingEntity var127;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var127 = _mobEnt.getTarget();
               } else {
                  var127 = null;
               }

               Vec3 var128 = ((Entity)var127).getEyePosition(1.0F);
               LivingEntity var145;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var145 = _mobEnt.getTarget();
               } else {
                  var145 = null;
               }

               var128 = var128.add(((Entity)var145).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var146 = Block.OUTLINE;
               ClipContext.Fluid var159 = Fluid.NONE;
               LivingEntity var168;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var168 = _mobEnt.getTarget();
               } else {
                  var168 = null;
               }

               var100 = new ClipContext(var114, var128, var146, var159, var168);
               x_pos = (double)var91.clip(var100).getBlockPos().getX();
               LivingEntity var92;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var92 = _mobEnt.getTarget();
               } else {
                  var92 = null;
               }

               Level var93 = ((Entity)var92).level();
               LivingEntity var115;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var115 = _mobEnt.getTarget();
               } else {
                  var115 = null;
               }

               Vec3 var116 = ((Entity)var115).getEyePosition(1.0F);
               LivingEntity var130;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var130 = _mobEnt.getTarget();
               } else {
                  var130 = null;
               }

               Vec3 var131 = ((Entity)var130).getEyePosition(1.0F);
               LivingEntity var147;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var147 = _mobEnt.getTarget();
               } else {
                  var147 = null;
               }

               var131 = var131.add(((Entity)var147).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var148 = Block.OUTLINE;
               var159 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var168 = _mobEnt.getTarget();
               } else {
                  var168 = null;
               }

               var100 = new ClipContext(var116, var131, var148, var159, var168);
               y_pos = (double)var93.clip(var100).getBlockPos().getY();
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.getTarget();
               } else {
                  var94 = null;
               }

               Level var95 = ((Entity)var94).level();
               LivingEntity var117;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var117 = _mobEnt.getTarget();
               } else {
                  var117 = null;
               }

               Vec3 var118 = ((Entity)var117).getEyePosition(1.0F);
               LivingEntity var133;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var133 = _mobEnt.getTarget();
               } else {
                  var133 = null;
               }

               Vec3 var134 = ((Entity)var133).getEyePosition(1.0F);
               LivingEntity var149;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var149 = _mobEnt.getTarget();
               } else {
                  var149 = null;
               }

               var134 = var134.add(((Entity)var149).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var150 = Block.OUTLINE;
               var159 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var168 = _mobEnt.getTarget();
               } else {
                  var168 = null;
               }

               var100 = new ClipContext(var118, var134, var150, var159, var168);
               z_pos = (double)var95.clip(var100).getBlockPos().getZ();
               entity.getPersistentData().putBoolean("canFly", true);
               GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               dis = GetDistanceProcedure.execute(entity);
               if (!(dis < 7.0) && !(dis > 9.0)) {
                  entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 15.0));
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               } else {
                  if (dis < 7.0) {
                     x_power = entity.getPersistentData().getDouble("x_power") * -0.25;
                     z_power = entity.getPersistentData().getDouble("x_power") * -0.25;
                  } else if (dis > 9.0) {
                     x_power = entity.getPersistentData().getDouble("x_power") * 0.25;
                     z_power = entity.getPersistentData().getDouble("x_power") * 0.25;
                  }

                  double var96 = entity.getY();
                  LivingEntity var103;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var103 = _mobEnt.getTarget();
                  } else {
                     var103 = null;
                  }

                  Level var104 = ((Entity)var103).level();
                  ClipContext var10002;
                  LivingEntity var136;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var136 = _mobEnt.getTarget();
                  } else {
                     var136 = null;
                  }

                  Vec3 var137 = ((Entity)var136).getEyePosition(1.0F);
                  LivingEntity var151;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var151 = _mobEnt.getTarget();
                  } else {
                     var151 = null;
                  }

                  Vec3 var152 = ((Entity)var151).getEyePosition(1.0F);
                  LivingEntity var162;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var162 = _mobEnt.getTarget();
                  } else {
                     var162 = null;
                  }

                  var152 = var152.add(((Entity)var162).getViewVector(1.0F).scale(0.0));
                  ClipContext.Block var163 = Block.OUTLINE;
                  ClipContext.Fluid var171 = Fluid.NONE;
                  LivingEntity var10008;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10008 = _mobEnt.getTarget();
                  } else {
                     var10008 = null;
                  }

                  var10002 = new ClipContext(var137, var152, var163, var171, var10008);
                  if (var96 > (double)(var104.clip(var10002).getBlockPos().getY() + 8)) {
                     y_power = -0.25;
                  } else {
                     var96 = entity.getY();
                     LivingEntity var105;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var105 = _mobEnt.getTarget();
                     } else {
                        var105 = null;
                     }

                     Level var106 = ((Entity)var105).level();
                     LivingEntity var138;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var138 = _mobEnt.getTarget();
                     } else {
                        var138 = null;
                     }

                     Vec3 var139 = ((Entity)var138).getEyePosition(1.0F);
                     LivingEntity var154;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var154 = _mobEnt.getTarget();
                     } else {
                        var154 = null;
                     }

                     Vec3 var155 = ((Entity)var154).getEyePosition(1.0F);
                     LivingEntity var164;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var164 = _mobEnt.getTarget();
                     } else {
                        var164 = null;
                     }

                     var155 = var155.add(((Entity)var164).getViewVector(1.0F).scale(0.0));
                     ClipContext.Block var165 = Block.OUTLINE;
                     var171 = Fluid.NONE;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10008 = _mobEnt.getTarget();
                     } else {
                        var10008 = null;
                     }

                     var10002 = new ClipContext(var139, var155, var165, var171, var10008);
                     if (var96 < (double)(var106.clip(var10002).getBlockPos().getY() + 6)) {
                        y_power = 0.25;
                     } else {
                        y_power = 0.0;
                     }
                  }

                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 3, 0, false, false));
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 15.0));
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }

            if (entity.getPersistentData().getDouble("cnt1") > 30.0) {
               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putDouble("cnt5", 1.0);
            }
         } else {
            WingKingAttackProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
