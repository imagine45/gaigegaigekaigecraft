package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class ChimeraShadowGardenSetProcedure {
   public ChimeraShadowGardenSetProcedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livingEntity5 = (LivingEntity)entityiterator;
            if (_livingEntity5.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
               AttributeInstance var10000;
               double var10001;
               label60: {
                  var10000 = _livingEntity5.getAttribute(Attributes.ATTACK_DAMAGE);
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entityiterator;
                     if (_livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var10001 = _livingEntity2.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                        break label60;
                     }
                  }

                  var10001 = 0.0;
               }

               double var10002;
               label55: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity3 = (LivingEntity)entity;
                     if (_livingEntity3.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var10002 = _livingEntity3.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                        break label55;
                     }
                  }

                  var10002 = 0.0;
               }

               int var10003;
               label50: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label50;
                     }
                  }

                  var10003 = 0;
               }

               var10000.setBaseValue(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               MobEffectInstance var8;
               MobEffect var9;
               int var10005;
               label42: {
                  var9 = MobEffects.DAMAGE_RESISTANCE;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                        break label42;
                     }
                  }

                  var10005 = 0;
               }

               var8 = new MobEffectInstance(var9, 2147483647, Math.max(var10005, 0), false, false);
               _entity.addEffect(var8);
            }
         }

         entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
         entityiterator.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
         entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
         entityiterator.getPersistentData().putBoolean("Ambush", true);
         entityiterator.getPersistentData().putBoolean("domain_entity", true);
         entityiterator.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
      }
   }
}
