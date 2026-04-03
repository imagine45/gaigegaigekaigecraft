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
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         x_center = entity.getX();
         y_center = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_center = entity.getZ();
         dis = 2.25 * range;
         if (entity.getPersistentData().getDouble("cnt1") >= 10.0) {
            dis += 1.0 * range * (entity.getPersistentData().getDouble("cnt1") - 9.0);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 2.0F, 0.9F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 2.0F, 0.9F, false);
            }
         }

         entity.getPersistentData().putDouble("Damage", 15.0);
         entity.getPersistentData().putDouble("Range", 6.0 + dis);
         entity.getPersistentData().putDouble("knockback", 1.0);
         RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         entity.getPersistentData().putDouble("BlockRange", (6.0 + dis) * 0.5);
         entity.getPersistentData().putDouble("BlockDamage", 0.2);
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:soul_fire_flame ~ ~ ~ " + range * 0.5 + " " + range * 0.5 + " " + range * 0.5 + " 0.3 " + Math.round(15.0 * range) + " force");
         }

         for(int index0 = 0; index0 < 2; ++index0) {
            rad = (Math.random() - 0.5) * 180.0;
            rad_now = Math.toRadians((double)entity.getXRot() + (Math.random() - 0.5) * 180.0);
            yaw_now = Math.toRadians((double)entity.getYRot() + rad);
            num1 = (double)entity.getYRot() - rad;

            for(int index1 = 0; index1 < 72; ++index1) {
               rad = Math.toRadians(num1 + entity.getPersistentData().getDouble("cnt3"));
               x_pos = x_center + Math.cos(rad) * (Math.cos(rad_now) + Math.abs(Math.sin(yaw_now) * Math.sin(rad_now))) * dis;
               y_pos = y_center + Math.sin(Math.toRadians(entity.getPersistentData().getDouble("cnt3"))) * Math.sin(rad_now) * -1.0 * dis;
               z_pos = z_center + Math.sin(rad) * (Math.cos(rad_now) + Math.abs(Math.cos(yaw_now) * Math.sin(rad_now))) * dis;
               if (Math.random() < 0.5) {
                  if (Math.random() < 0.5) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.3 0.3 1.0 1 ~ ~ ~ 0.05 0.05 0.05 0 1 force");
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.6 0.6 1.0 1 ~ ~ ~ 0.05 0.05 0.05 0 1 force");
                  }
               }

               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 6.0 * Math.random());
            }

            entity.getPersistentData().putDouble("cnt3", 0.0);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 15.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
