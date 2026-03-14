package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class GuardSetDamageProcedure {
   public GuardSetDamageProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         CompoundTag var10000;
         int var10003;
         label25: {
            boolean logic_a = false;
            boolean logic_b = false;
            boolean SUCCESS = false;
            double num1 = 0.0;
            double num2 = 0.0;
            double speed = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double num3 = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double dis = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            var10000 = entity.getPersistentData();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                  var10003 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                  break label25;
               }
            }

            var10003 = 0;
         }

         var10000.m_128347_("Damage", (double)(6 + var10003 * 3));
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt2 = (LivingEntity)entity;
            if (_livEnt2.m_21023_(MobEffects.f_19610_)) {
               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.25);
            }
         }

         entity.getPersistentData().m_128379_("attack", false);
         entity.getPersistentData().m_128379_("swing", true);
         DamageFixProcedure.execute(entity);
         entity.getPersistentData().m_128379_("guard", true);
         if (!(entity instanceof Player)) {
            entity.m_20260_(true);
         }

      }
   }
}
