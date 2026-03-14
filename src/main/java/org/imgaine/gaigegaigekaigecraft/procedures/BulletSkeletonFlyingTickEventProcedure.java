package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class BulletSkeletonFlyingTickEventProcedure {
   public BulletSkeletonFlyingTickEventProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double power = 0.0;
         double repeat_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double max_power = 0.0;
         double energy = 0.0;
         double old_skill = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediatesourceentity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().m_128347_("old_x", entity.m_20185_());
            immediatesourceentity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * 0.5);
            immediatesourceentity.getPersistentData().m_128347_("old_z", entity.m_20189_());
            immediatesourceentity.m_20242_(true);
            entity.getPersistentData().m_128347_("Damage", 12.0);
            DamageFixProcedure.execute(entity);
            immediatesourceentity.getPersistentData().m_128347_("bullet_power", entity.getPersistentData().m_128459_("Damage"));
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") < 20.0) {
            x_power = entity.m_20185_() - x;
            y_power = entity.m_20186_() - y;
            z_power = entity.m_20189_() - z;
            dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
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

               Level var86 = ((Entity)var10000).m_9236_();
               ClipContext var10001 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var93 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var98 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var98 = var98.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var106 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var93, var98, var106, var10006, var10007);
               x_power = (double)var86.m_45547_(var10001).m_82425_().m_123341_() - x;
               LivingEntity var87;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var87 = _mobEnt.m_5448_();
               } else {
                  var87 = null;
               }

               Level var88 = ((Entity)var87).m_9236_();
               var10001 = new ClipContext;
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               Vec3 var95 = ((Entity)var94).m_20299_(1.0F);
               LivingEntity var100;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var100 = _mobEnt.m_5448_();
               } else {
                  var100 = null;
               }

               Vec3 var101 = ((Entity)var100).m_20299_(1.0F);
               LivingEntity var107;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var107 = _mobEnt.m_5448_();
               } else {
                  var107 = null;
               }

               var101 = var101.m_82549_(((Entity)var107).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var108 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var95, var101, var108, var10006, var10007);
               y_power = (double)var88.m_45547_(var10001).m_82425_().m_123342_() - y;
               LivingEntity var89;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var89 = _mobEnt.m_5448_();
               } else {
                  var89 = null;
               }

               Level var90 = ((Entity)var89).m_9236_();
               var10001 = new ClipContext;
               LivingEntity var96;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var96 = _mobEnt.m_5448_();
               } else {
                  var96 = null;
               }

               Vec3 var97 = ((Entity)var96).m_20299_(1.0F);
               LivingEntity var103;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var103 = _mobEnt.m_5448_();
               } else {
                  var103 = null;
               }

               Vec3 var104 = ((Entity)var103).m_20299_(1.0F);
               LivingEntity var109;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var109 = _mobEnt.m_5448_();
               } else {
                  var109 = null;
               }

               var104 = var104.m_82549_(((Entity)var109).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var110 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var97, var104, var110, var10006, var10007);
               z_power = (double)var90.m_45547_(var10001).m_82425_().m_123343_() - z;
            } else {
               x_power = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() - x;
               y_power = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() - y;
               z_power = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis * 1.5)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() - z;
            }

            dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
            if (dis != 0.0) {
               x_power = x_power / dis * 1.25;
               y_power = y_power / dis * 1.25;
               z_power = z_power / dis * 1.25;
               if (immediatesourceentity.m_20184_().m_7096_() > x_power) {
                  x_power = immediatesourceentity.m_20184_().m_7096_() - 0.15;
               } else {
                  x_power = immediatesourceentity.m_20184_().m_7096_() + 0.15;
               }

               if (immediatesourceentity.m_20184_().m_7098_() > y_power) {
                  y_power = immediatesourceentity.m_20184_().m_7098_() - 0.15;
               } else {
                  y_power = immediatesourceentity.m_20184_().m_7098_() + 0.15;
               }

               if (immediatesourceentity.m_20184_().m_7094_() > z_power) {
                  z_power = immediatesourceentity.m_20184_().m_7094_() - 0.15;
               } else {
                  z_power = immediatesourceentity.m_20184_().m_7094_() + 0.15;
               }

               immediatesourceentity.m_20256_(new Vec3(x_power, y_power, z_power));
            }
         }

         old_skill = entity.getPersistentData().m_128459_("skill");
         old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
         entity.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
         x_pos = immediatesourceentity.getPersistentData().m_128459_("old_x");
         y_pos = immediatesourceentity.getPersistentData().m_128459_("old_y");
         z_pos = immediatesourceentity.getPersistentData().m_128459_("old_z");
         x_power = x - x_pos;
         y_power = y - y_pos;
         z_power = z - z_pos;
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > 1.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         for(int index0 = 0; index0 < (int)Math.round(Math.max(dis * 2.0, 1.0)); ++index0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.1);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.1);
            }

            entity.getPersistentData().m_128347_("Damage", 12.0);
            entity.getPersistentData().m_128347_("Range", 2.5);
            entity.getPersistentData().m_128347_("knockback", 0.25);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            AIBulletProcedure.execute();
            x_pos += x_power * 0.5;
            y_pos += y_power * 0.5;
            z_pos += z_power * 0.5;
         }

         immediatesourceentity.getPersistentData().m_128347_("old_x", x);
         immediatesourceentity.getPersistentData().m_128347_("old_y", y);
         immediatesourceentity.getPersistentData().m_128347_("old_z", z);
         entity.getPersistentData().m_128347_("BlockDamage", 1.0);
         entity.getPersistentData().m_128347_("BlockRange", 2.5);
         BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().m_128347_("Damage", 0.0);
         entity.getPersistentData().m_128347_("skill", old_skill);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > 40.0 && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
