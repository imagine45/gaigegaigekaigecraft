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
            if (_livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
               double var10001;
               label67: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity1 = (LivingEntity)entity;
                     if (_livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var10001 = _livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
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
            if (_livEnt2.hasEffect(MobEffects.DAMAGE_BOOST)) {
               int var13;
               double var10000;
               label59: {
                  var10000 = strength_level + 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var13 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
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
            if (_livEnt4.hasEffect(MobEffects.WEAKNESS)) {
               int var10002;
               label51: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.WEAKNESS)) {
                        var10002 = _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier();
                        break label51;
                     }
                  }

                  var10002 = 0;
               }

               strength_level -= (double)(1 + var10002);
            }
         }

         entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * (1.0 + strength_level * 0.333));
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)entity;
            if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
               CompoundTag var12;
               double var14;
               int var10005;
               label43: {
                  var12 = entity.getPersistentData();
                  var14 = entity.getPersistentData().getDouble("Damage");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        var10005 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                        break label43;
                     }
                  }

                  var10005 = 0;
               }

               var12.putDouble("Damage", var14 * (1.2 + 0.1 * (double)var10005));
            }
         }

         if (entity.getPersistentData().getBoolean("attack")) {
            entity.getPersistentData().putDouble("knockback", Math.max(entity.getPersistentData().getDouble("knockback") * Math.min(0.2 + strength_level * 0.075, 1.0), 0.15));
            OgiZeninPassiveSkillProcedure.execute(entity);
            entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * (1.0 + entity.getPersistentData().getDouble("PASSIVE_POWERFIX")));
         }

      }
   }
}
