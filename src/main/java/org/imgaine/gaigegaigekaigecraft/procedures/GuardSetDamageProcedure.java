package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class GuardSetDamageProcedure {
   public GuardSetDamageProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         CompoundTag var10000;
         int var10003;
         label15: {
            var10000 = entity.getPersistentData();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                  var10003 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                  break label15;
               }
            }

            var10003 = 0;
         }

         var10000.putDouble("Damage", (double)(9 + var10003 * 6));
         entity.getPersistentData().putBoolean("attack", false);
         entity.getPersistentData().putBoolean("swing", true);
         DamageFixProcedure.execute(entity);
         entity.getPersistentData().putBoolean("guard", true);
      }
   }
}
