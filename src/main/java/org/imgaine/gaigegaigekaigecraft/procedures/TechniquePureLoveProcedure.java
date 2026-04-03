package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class TechniquePureLoveProcedure {
   public TechniquePureLoveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         boolean logic_a = false;
         boolean noControl = false;
         boolean summon = false;
         Entity entity_rika = null;
         Entity target_entity = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            entity.getPersistentData().putDouble("cnt2", 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 100, 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
               entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("RIKA_UUID"));
               if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
                  entity_rika.setYRot(entity.getYRot());
                  entity_rika.setXRot(entity.getXRot());
                  entity_rika.setYBodyRot(entity_rika.getYRot());
                  entity_rika.setYHeadRot(entity_rika.getYRot());
                  entity_rika.yRotO = entity_rika.getYRot();
                  entity_rika.xRotO = entity_rika.getXRot();
                  if (entity_rika instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_rika;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity_rika.teleportTo((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
                  if (entity_rika instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_rika;
                     _serverPlayer.connection.teleport((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ(), entity_rika.getYRot(), entity_rika.getXRot());
                  }

                  entity_rika.getPersistentData().putDouble("skill", 0.0);
                  entity_rika.getPersistentData().putDouble("skill_num", 10.0);
                  entity_rika.getPersistentData().putBoolean("flag_attack", true);
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var24 = var10000;
         if (entity.getPersistentData().getDouble("cnt1") < 80.0) {
            if (var24 instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 20, false, false));
                  }
               }

               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (((Entity)var24).getPersistentData().getDouble("skill") == 1815.0) {
                  if (((Entity)var24).getPersistentData().getDouble("cnt1") < 80.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  } else {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               } else {
                  if (((Entity)var24).getPersistentData().getDouble("skill") == 0.0) {
                     if (GetDistanceProcedure.execute(entity) >= 10.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     } else {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                     }
                  }

                  if (((Entity)var24).getPersistentData().getDouble("skill") > 0.0) {
                     if (((Entity)var24).getPersistentData().getBoolean("PRESS_Z")) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     } else {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt2") >= 180.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 78.0));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 90.0 && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 100.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
