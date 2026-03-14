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
         ItemStack item_a = ItemStack.f_41583_;
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
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         range = ReturnEntitySizeProcedure.execute(entity);
         sword = LogicSwordProcedure.execute(entity);
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.m_20256_(new Vec3(entity.m_20184_().m_7096_() * 0.5, Math.min(entity.m_20184_().m_7098_() * 0.5, Math.min(entity.m_20184_().m_7098_(), 0.1)), entity.m_20184_().m_7094_() * 0.5));
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.getPersistentData().m_128347_("cnt2", 0.0);
         old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
         old_skill = entity.getPersistentData().m_128459_("skill");
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(0.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().m_128459_("cnt5") <= 100.0) {
            attack_last = entity.getPersistentData().m_128459_("cnt5") == 20.0;
            attack = entity.getPersistentData().m_128459_("cnt5") == 1.0 || entity.getPersistentData().m_128459_("cnt5") == 5.0 || entity.getPersistentData().m_128459_("cnt5") == 9.0 || attack_last;
            if (attack || attack_last) {
               if (attack_last) {
                  entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), 100.0));
                  entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), 3.5));
               } else {
                  entity.getPersistentData().m_128347_("cnt6", 1.5 + entity.getPersistentData().m_128459_("cnt5") * 0.05);
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

            entity.getPersistentData().m_128347_("cnt1", old_cnt1);
            entity.getPersistentData().m_128347_("skill", old_skill);
         } else if (entity.getPersistentData().m_128459_("cnt5") > 110.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
