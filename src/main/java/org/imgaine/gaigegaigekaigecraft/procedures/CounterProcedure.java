package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KusakabeAtsuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MiwaKasumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninOgiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CounterProcedure {
   public CounterProcedure() {
   }

   public static void execute(Entity counter_entity) {
      if (counter_entity != null) {
         Entity entity_a = null;
         double T1 = 0.0;
         double T2 = 0.0;
         if (counter_entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            pVars = (JujutsucraftModVariables.PlayerVariables)counter_entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables)null);
            T1 = pVars.PlayerCurseTechnique;
            T2 = pVars.PlayerCurseTechnique2;
         }

         label93: {
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)counter_entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                  if (counter_entity instanceof Player) {
                     if (T1 == 26.0 || T2 == 26.0) {
                        break label93;
                     }
                  } else if (counter_entity instanceof ZeninOgiEntity) {
                     break label93;
                  }
               }
            }

            int var10000;
            label75: {
               if (counter_entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)counter_entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                     break label75;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 0) {
               return;
            }

            if (counter_entity instanceof Player) {
               if (T1 != 31.0 && T2 != 31.0) {
                  return;
               }
            } else if (!(counter_entity instanceof KusakabeAtsuyaEntity) && !(counter_entity instanceof MiwaKasumiEntity)) {
               return;
            }
         }

         if (counter_entity instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)counter_entity;
            if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get()) && counter_entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)counter_entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
            }
         }

         int var16;
         label61: {
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)counter_entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var16 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                  break label61;
               }
            }

            var16 = 0;
         }

         if (var16 > 0 && counter_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)counter_entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
         }

         if (counter_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)counter_entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 15, 1, false, false));
            }
         }

         if (counter_entity.getPersistentData().getDouble("skill") == 0.0) {
            counter_entity.getPersistentData().putDouble("skill", 101.0);
            counter_entity.getPersistentData().putDouble("cnt1", 7.0);
            counter_entity.getPersistentData().putDouble("cnt2", 0.0);
            counter_entity.getPersistentData().putDouble("cnt3", 0.0);
            counter_entity.getPersistentData().putDouble("cnt4", 0.0);
            counter_entity.getPersistentData().putDouble("cnt5", 0.0);
            counter_entity.getPersistentData().putDouble("cnt6", 1.0);
            counter_entity.getPersistentData().putDouble("cnt7", 0.0);
            counter_entity.getPersistentData().putDouble("cnt8", 0.0);
            counter_entity.getPersistentData().putDouble("cnt9", 0.0);
            counter_entity.getPersistentData().putDouble("cnt10", 0.0);
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)counter_entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
               }
            }
         }

      }
   }
}
