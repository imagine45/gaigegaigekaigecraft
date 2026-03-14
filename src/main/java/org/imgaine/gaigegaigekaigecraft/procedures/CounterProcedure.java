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
         label89: {
            Entity entity_a = null;
            double strength_lv_iterator = 0.0;
            double old_skill = 0.0;
            double old_health = 0.0;
            double old_damage = 0.0;
            double strength_lv = 0.0;
            double NUM1 = 0.0;
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)counter_entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                  if (counter_entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)counter_entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 26.0 || ((JujutsucraftModVariables.PlayerVariables)counter_entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26.0) {
                        break label89;
                     }
                  } else if (counter_entity instanceof ZeninOgiEntity) {
                     break label89;
                  }
               }
            }

            int var10000;
            label73: {
               if (counter_entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)counter_entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                     break label73;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 0) {
               return;
            }

            if (counter_entity instanceof Player) {
               if (((JujutsucraftModVariables.PlayerVariables)counter_entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 31.0 && ((JujutsucraftModVariables.PlayerVariables)counter_entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 31.0) {
                  return;
               }
            } else if (!(counter_entity instanceof KusakabeAtsuyaEntity) && !(counter_entity instanceof MiwaKasumiEntity)) {
               return;
            }
         }

         if (counter_entity instanceof LivingEntity) {
            LivingEntity _livEnt7 = (LivingEntity)counter_entity;
            if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get()) && counter_entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)counter_entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
            }
         }

         int var22;
         label59: {
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)counter_entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var22 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                  break label59;
               }
            }

            var22 = 0;
         }

         if (var22 > 0 && counter_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)counter_entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
         }

         if (counter_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)counter_entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 15, 1, false, false));
            }
         }

         if (counter_entity.getPersistentData().m_128459_("skill") == 0.0) {
            counter_entity.getPersistentData().m_128347_("skill", 101.0);
            counter_entity.getPersistentData().m_128347_("cnt1", 7.0);
            counter_entity.getPersistentData().m_128347_("cnt2", 0.0);
            counter_entity.getPersistentData().m_128347_("cnt3", 0.0);
            counter_entity.getPersistentData().m_128347_("cnt4", 0.0);
            counter_entity.getPersistentData().m_128347_("cnt5", 0.0);
            counter_entity.getPersistentData().m_128347_("cnt6", 1.0);
            counter_entity.getPersistentData().m_128347_("cnt7", 0.0);
            counter_entity.getPersistentData().m_128347_("cnt8", 0.0);
            counter_entity.getPersistentData().m_128347_("cnt9", 0.0);
            counter_entity.getPersistentData().m_128347_("cnt10", 0.0);
            if (counter_entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)counter_entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
               }
            }
         }

      }
   }
}
