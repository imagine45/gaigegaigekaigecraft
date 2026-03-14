package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class DamageFixProcedure {
   public DamageFixProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double strength_level = 0.0;
         CursedToolsAbility2Procedure.execute(entity);
         strength_level = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity0 = (LivingEntity)entity;
            if (_livingEntity0.m_21204_().m_22171_(Attributes.f_22281_)) {
               double var10001;
               label67: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity1 = (LivingEntity)entity;
                     if (_livingEntity1.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10001 = _livingEntity1.getAttribute_(Attributes.f_22281_).m_22115_();
                        break label67;
                     }
                  }

                  var10001 = 0.0;
               }

               strength_level += var10001 * 0.333;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt2 = (LivingEntity)entity;
            if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
               int var13;
               double var10000;
               label59: {
                  var10000 = strength_level + 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var13 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label59;
                     }
                  }

                  var13 = 0;
               }

               strength_level = var10000 + (double)var13;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt4 = (LivingEntity)entity;
            if (_livEnt4.m_21023_(MobEffects.f_19613_)) {
               int var10002;
               label51: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19613_)) {
                        var10002 = _livEnt.m_21124_(MobEffects.f_19613_).m_19564_();
                        break label51;
                     }
                  }

                  var10002 = 0;
               }

               strength_level -= (double)(1 + var10002);
            }
         }

         entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * (1.0 + strength_level * 0.333));
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)entity;
            if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
               CompoundTag var12;
               double var14;
               int var10005;
               label43: {
                  var12 = entity.getPersistentData();
                  var14 = entity.getPersistentData().m_128459_("Damage");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
                        break label43;
                     }
                  }

                  var10005 = 0;
               }

               var12.m_128347_("Damage", var14 * (1.2 + 0.1 * (double)var10005));
            }
         }

         if (entity.getPersistentData().m_128471_("attack")) {
            entity.getPersistentData().m_128347_("knockback", Math.max(entity.getPersistentData().m_128459_("knockback") * Math.min(0.2 + strength_level * 0.075, 1.0), 0.15));
            OgiZeninPassiveSkillProcedure.execute(entity);
            entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * (1.0 + entity.getPersistentData().m_128459_("PASSIVE_POWERFIX")));
         }

      }
   }
}
