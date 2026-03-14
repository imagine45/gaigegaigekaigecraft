package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class SkillTakabaMove1Procedure {
   public SkillTakabaMove1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double tick = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               Level var73 = ((Entity)var10000).m_9236_();
               ClipContext var10001 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var80 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var85 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var85 = var85.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(8.0));
               ClipContext.Block var93 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var80, var85, var93, var10006, var10007);
               x_pos = (double)var73.m_45547_(var10001).m_82425_().m_123341_();
               LivingEntity var74;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var74 = _mobEnt.m_5448_();
               } else {
                  var74 = null;
               }

               Level var75 = ((Entity)var74).m_9236_();
               var10001 = new ClipContext;
               LivingEntity var81;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var81 = _mobEnt.m_5448_();
               } else {
                  var81 = null;
               }

               Vec3 var82 = ((Entity)var81).m_20299_(1.0F);
               LivingEntity var87;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var87 = _mobEnt.m_5448_();
               } else {
                  var87 = null;
               }

               Vec3 var88 = ((Entity)var87).m_20299_(1.0F);
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               var88 = var88.m_82549_(((Entity)var94).m_20252_(1.0F).m_82490_(8.0));
               ClipContext.Block var95 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var82, var88, var95, var10006, var10007);
               y_pos = (double)var75.m_45547_(var10001).m_82425_().m_123342_();
               LivingEntity var76;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var76 = _mobEnt.m_5448_();
               } else {
                  var76 = null;
               }

               Level var77 = ((Entity)var76).m_9236_();
               var10001 = new ClipContext;
               LivingEntity var83;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var83 = _mobEnt.m_5448_();
               } else {
                  var83 = null;
               }

               Vec3 var84 = ((Entity)var83).m_20299_(1.0F);
               LivingEntity var90;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var90 = _mobEnt.m_5448_();
               } else {
                  var90 = null;
               }

               Vec3 var91 = ((Entity)var90).m_20299_(1.0F);
               LivingEntity var96;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.m_5448_();
               } else {
                  var96 = null;
               }

               var91 = var91.m_82549_(((Entity)var96).m_20252_(1.0F).m_82490_(8.0));
               ClipContext.Block var97 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var84, var91, var97, var10006, var10007);
               z_pos = (double)var77.m_45547_(var10001).m_82425_().m_123343_();
            } else {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            }

            logic_a = false;

            for(int index0 = 0; index0 < 255; ++index0) {
               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                  logic_a = true;
                  break;
               }

               --y_pos;
            }

            y_pos = y_pos - 1.0 - (double)entity.m_20206_();
            if (logic_a) {
               entity.m_6021_(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
               }

               entity.getPersistentData().m_128347_("cnt1", 0.0);
               entity.getPersistentData().m_128347_("cnt2", 1.0);
            } else if (entity.getPersistentData().m_128459_("cnt1") > 20.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
            x_power = 0.0;
            y_power = 0.3;
            z_power = 0.0;
            if (entity.getPersistentData().m_128459_("cnt1") < 5.0) {
               if (entity.getPersistentData().m_128459_("cnt1") == 0.0) {
                  x_pos = x;
                  y_pos = y;
                  z_pos = z;

                  for(int index1 = 0; index1 < 16; ++index1) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x_pos + x_power, y_pos + y_power, z_pos + z_power)).m_60815_()) {
                        world.m_46796_(2001, BlockPos.m_274561_(x_pos + x_power, y_pos + y_power, z_pos + z_power), net.minecraft.world.level.block.Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                        break;
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }
               }
            } else if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
               logic_a = false;
               x_pos = x;
               y_pos = y;
               z_pos = z;

               for(int index2 = 0; index2 < 3; ++index2) {
                  entity.getPersistentData().m_128347_("Damage", 10.0);
                  entity.getPersistentData().m_128347_("knockback", 2.0);
                  entity.getPersistentData().m_128347_("Range", 3.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") >= 9.0 && !world.m_8055_(BlockPos.m_274561_(x_pos - x_power, y_pos - y_power, z_pos - z_power)).m_60815_()) {
                     logic_a = true;
                     break;
                  }
               }

               if (logic_a) {
                  x_pos = x;
                  y_pos = y;
                  z_pos = z;

                  for(int index3 = 0; index3 < 16; ++index3) {
                     x_pos -= x_power;
                     y_pos -= y_power;
                     z_pos -= z_power;
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        world.m_46796_(2001, BlockPos.m_274561_(x_pos, y_pos, z_pos), net.minecraft.world.level.block.Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos))));
                        break;
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt3", 1.0);
               }

               logic_a = true;
            } else {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
