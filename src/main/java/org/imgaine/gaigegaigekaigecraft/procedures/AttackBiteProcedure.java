package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackBiteProcedure {
   public AttackBiteProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double level_jump = 0.0;
         double level = 0.0;
         double level_speed = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.getPersistentData().m_128347_("cnt_target", 1.0);
         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            if (OnGroundProcedure.execute(world, entity)) {
               world.m_46796_(2001, BlockPos.m_274561_(x, y - 1.0, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y - 1.0, z))));
               entity.getPersistentData().m_128347_("cnt1", 0.0);
               entity.getPersistentData().m_128347_("cnt2", 1.0);
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

                  x_pos = ((Entity)var10000).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  double var61 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var61 + (double)((Entity)var10001).m_20206_() * 0.5;
                  LivingEntity var62;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var62 = _mobEnt.m_5448_();
                  } else {
                     var62 = null;
                  }

                  z_pos = ((Entity)var62).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               GetPowerFixProcedure.execute(entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 10, 0.2, 0.0, 0.2, 0.5);
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") > 200.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") >= 5.0) {
               if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
                  if (entity.getPersistentData().m_128459_("cnt1") == 5.0) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 20, 0.2, 0.0, 0.2, 0.5);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
                        }
                     }
                  } else {
                     RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * 16.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * 16.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * 16.0, entity);
                  }

                  if (entity.m_20096_()) {
                     entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, Math.min(Math.max(entity.getPersistentData().m_128459_("y_power") * 0.75, 0.5), 1.5), entity.getPersistentData().m_128459_("z_power") * 0.75));
                  } else {
                     entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, Math.min(entity.getPersistentData().m_128459_("y_power") * 0.75, 1.5), entity.getPersistentData().m_128459_("z_power") * 0.75));
                  }
               } else if (entity.m_20096_()) {
                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.5, entity.m_20184_().m_7098_(), entity.getPersistentData().m_128459_("z_power") * 0.5));
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
                  entity.getPersistentData().m_128347_("cnt_target", 10.0);

                  for(int index0 = 0; index0 < (int)Math.round(dis); ++index0) {
                     entity.getPersistentData().m_128347_("Damage", 14.0);
                     entity.getPersistentData().m_128347_("Range", (double)(3.0F + entity.m_20206_()));
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos, entity);
                     x_pos += x_power * 1.0;
                     y_pos += y_power * 1.0;
                     z_pos += z_power * 1.0;
                  }

                  entity.getPersistentData().m_128347_("cnt_target", 1.0);
               }

               entity.getPersistentData().m_128347_("old_x", x);
               entity.getPersistentData().m_128347_("old_y", y);
               entity.getPersistentData().m_128347_("old_z", z);
               if (entity.getPersistentData().m_128459_("cnt1") > 40.0 || entity.getPersistentData().m_128459_("cnt1") > 25.0 && entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
