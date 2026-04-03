package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class LogicAttackTargetProcedure {
   public LogicAttackTargetProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean target_reset = false;
         Entity target = null;
         double friend_num = 0.0;
         if (entity instanceof Mob) {
            if (!(entity instanceof Mob)) {
               return false;
            }

            Mob mob = (Mob)entity;
            Entity var7 = mob.getTarget();
            CompoundTag data = mob.getPersistentData();
            if (data.getDouble("skill") <= -999.0) {
               return false;
            }

            if (data.getDouble("cnt_target") <= 6.0) {
               return false;
            }

            if (var7 instanceof LivingEntity) {
               friend_num = data.getDouble("friend_num");
               if (friend_num != 0.0 && friend_num == ((Entity)var7).getPersistentData().getDouble("friend_num")) {
                  target_reset = true;
               }

               if (mob.isAlliedTo(var7)) {
                  target_reset = true;
               }

               if (target_reset) {
                  data.putString("TARGET_UUID", "");
                  data.putDouble("cnt_target", 0.0);
                  mob.setTarget((LivingEntity)null);
                  return false;
               }
            }
         }

         return true;
      }
   }
}
