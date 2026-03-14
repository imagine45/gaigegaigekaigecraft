package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueTamamonoMae1Procedure {
   public TechniqueTamamonoMae1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean tamamo_no_mae = false;
         double num1 = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_center = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double z_center = 0.0;
         double y_center = 0.0;
         double dis = 0.0;
         double range = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 2.0F, 0.9F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 2.0F, 0.9F, false);
            }
         }

         entity.getPersistentData().m_128347_("Damage", 15.0);
         entity.getPersistentData().m_128347_("Range", 8.0 * range);
         entity.getPersistentData().m_128347_("knockback", 1.0);
         RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         entity.getPersistentData().m_128347_("BlockRange", 5.0 * range);
         entity.getPersistentData().m_128347_("BlockDamage", 0.2);
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:soul_fire_flame ~ ~ ~ " + range * 0.5 + " " + range * 0.5 + " " + range * 0.5 + " 0.3 " + Math.round(15.0 * range) + " force");
         }

         x_center = entity.m_20185_();
         y_center = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_center = entity.m_20189_();
         dis = 2.25 * range;

         for(int index0 = 0; index0 < 2; ++index0) {
            rad = (Math.random() - 0.5) * 180.0;
            rad_now = Math.toRadians((double)entity.m_146909_() + (Math.random() - 0.5) * 180.0);
            yaw_now = Math.toRadians((double)entity.m_146908_() + rad);
            num1 = (double)entity.m_146908_() - rad;

            for(int index1 = 0; index1 < 72; ++index1) {
               rad = Math.toRadians(num1 + entity.getPersistentData().m_128459_("cnt3"));
               x_pos = x_center + Math.cos(rad) * (Math.cos(rad_now) + Math.abs(Math.sin(yaw_now) * Math.sin(rad_now))) * dis;
               y_pos = y_center + Math.sin(Math.toRadians(entity.getPersistentData().m_128459_("cnt3"))) * Math.sin(rad_now) * -1.0 * dis;
               z_pos = z_center + Math.sin(rad) * (Math.cos(rad_now) + Math.abs(Math.cos(yaw_now) * Math.sin(rad_now))) * dis;
               if (Math.random() < 0.5) {
                  if (Math.random() < 0.5) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.3 0.3 1.0 1 ~ ~ ~ 0.05 0.05 0.05 0 1 force");
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.6 0.6 1.0 1 ~ ~ ~ 0.05 0.05 0.05 0 1 force");
                  }
               }

               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 6.0 * Math.random());
            }

            entity.getPersistentData().m_128347_("cnt3", 0.0);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 15.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
