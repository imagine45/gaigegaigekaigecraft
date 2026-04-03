package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.NanamiKentoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class Attack4ConsecutiveAttacksProcedure {
   public Attack4ConsecutiveAttacksProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.EMPTY;
         double strength = 0.0;
         double d = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double weapon_size = 0.0;
         double attack_reach = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double old_skill = 0.0;
         double distance = 0.0;
         double old_cnt1 = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         boolean sword = false;
         boolean attack = false;
         boolean keep = false;
         boolean attack_last = false;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         range = ReturnEntitySizeProcedure.execute(entity);
         sword = LogicSwordProcedure.execute(entity);
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.5, Math.min(entity.getDeltaMovement().y() * 0.5, Math.min(entity.getDeltaMovement().y(), 0.1)), entity.getDeltaMovement().z() * 0.5));
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", 0.0);
         old_cnt1 = entity.getPersistentData().getDouble("cnt1");
         old_skill = entity.getPersistentData().getDouble("skill");
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(0.0F + entity.getBbWidth());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().getDouble("cnt5") <= 100.0) {
            attack_last = entity.getPersistentData().getDouble("cnt5") == 20.0;
            attack = entity.getPersistentData().getDouble("cnt5") == 1.0 || entity.getPersistentData().getDouble("cnt5") == 5.0 || entity.getPersistentData().getDouble("cnt5") == 9.0 || attack_last;
            if (attack || attack_last) {
               if (attack_last) {
                  entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
                  entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), 3.5));
               } else {
                  entity.getPersistentData().putDouble("cnt6", 1.5 + entity.getPersistentData().getDouble("cnt5") * 0.05);
               }

               if (!attack_last) {
                  AttackWeakProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               } else {
                  if (LogicStartPassiveProcedure.execute(entity)) {
                     label57: {
                        if (entity instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 13.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 13.0) {
                              break label57;
                           }
                        } else if (!(entity instanceof NanamiKentoEntity)) {
                           break label57;
                        }

                        WeaponNanamiRightClickedInAirProcedure.execute(world, entity);
                     }
                  }

                  AttackStrongProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            entity.getPersistentData().putDouble("cnt1", old_cnt1);
            entity.getPersistentData().putDouble("skill", old_skill);
         } else if (entity.getPersistentData().getDouble("cnt5") > 110.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
