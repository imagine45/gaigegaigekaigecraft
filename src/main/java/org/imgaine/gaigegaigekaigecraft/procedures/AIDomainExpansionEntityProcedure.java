package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class AIDomainExpansionEntityProcedure {
   public AIDomainExpansionEntityProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState blockstate1 = Blocks.f_50016_.m_49966_();
         String outside = "";
         String inside = "";
         String floor = "";
         String old_block = "";
         boolean logic_a = false;
         boolean failed = false;
         boolean noBarrier = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double range = 0.0;
         double dis = 0.0;
         double loop_num = 0.0;
         double x_dis = 0.0;
         double y_dis = 0.0;
         double z_dis = 0.0;
         double domain_num = 0.0;
         double cnt1 = 0.0;
         double y_floor = 0.0;
         double x_dis_p = 0.0;
         double y_dis_p = 0.0;
         double z_dis_p = 0.0;
         double cnt2 = 0.0;
         double dis_p = 0.0;
         range = (double)Math.round(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius + 1.0);
         entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
         entity.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
         if (entity instanceof ServerPlayer) {
            ServerPlayer _serverPlayer = (ServerPlayer)entity;
            _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19619_, 60, 0, false, false));
            }
         }

         if (!entity.getPersistentData().m_128471_("Break")) {
            label88: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     break label88;
                  }
               }

               entity.getPersistentData().m_128347_("cnt_life2", entity.getPersistentData().m_128459_("cnt_life2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_life2") > Math.max(60.0, range * 2.0 + 5.0)) {
                  entity.getPersistentData().m_128379_("Break", true);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt12 = (LivingEntity)entity;
               if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  entity.getPersistentData().m_128379_("Break", false);
                  entity.getPersistentData().m_128347_("cnt_life2", 0.0);
               }
            }
         }

         if (entity.getPersistentData().m_128471_("Break")) {
            entity.getPersistentData().m_128347_("cnt_break", entity.getPersistentData().m_128459_("cnt_break") + 1.0);
            loop_num = (double)Math.round(range * 2.0 + 1.0);
            cnt2 = entity.getPersistentData().m_128459_("cnt_break");
            y_floor = (double)(Math.round(y) - 1L);
            x_pos = (double)Math.round(x) - range;

            for(int index0 = 0; index0 < (int)loop_num; ++index0) {
               x_dis = Math.pow(x_pos - (double)Math.round(x), 2.0);
               x_dis_p = Math.pow(x_pos - (double)Math.round((float)Math.round(x)), 2.0);
               if (Math.sqrt(x_dis_p) <= cnt2) {
                  y_pos = (double)Math.round(y) - range;

                  for(int index1 = 0; index1 < (int)loop_num; ++index1) {
                     y_dis = Math.pow(y_pos - (double)Math.round(y), 2.0);
                     y_dis_p = Math.pow(y_pos - (double)Math.round(y), 2.0);
                     if (Math.sqrt(y_dis_p) <= cnt2 && y_pos >= -64.0 && y_pos <= 319.0) {
                        z_pos = (double)Math.round(z) - range;

                        for(int index2 = 0; index2 < (int)loop_num; ++index2) {
                           z_dis = Math.pow(z_pos - (double)Math.round(z), 2.0);
                           z_dis_p = Math.pow(z_pos - (double)Math.round(z), 2.0);
                           if (Math.sqrt(z_dis_p) <= cnt2) {
                              dis_p = Math.sqrt(x_dis_p + y_dis_p + z_dis_p);
                              if (dis_p <= cnt2 + 0.0 && dis_p >= cnt2 - 1.0) {
                                 dis = Math.sqrt(x_dis + z_dis + y_dis);
                                 if (dis < range + 1.0) {
                                    blockstate1 = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                                    if (blockstate1.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                                       JujutsuBarrierUpdateTickProcedure.execute(world, x_pos, y_pos, z_pos);
                                    }
                                 }
                              }
                           }

                           ++z_pos;
                        }
                     }

                     ++y_pos;
                  }
               }

               ++x_pos;
            }

            if (entity.getPersistentData().m_128459_("cnt_break") >= (double)Math.round(range * 2.0 + 2.0) && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
