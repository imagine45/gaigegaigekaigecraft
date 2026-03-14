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
         entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livingEntity5 = (LivingEntity)entityiterator;
            if (_livingEntity5.m_21204_().m_22171_(Attributes.f_22281_)) {
               AttributeInstance var10000;
               double var10001;
               label60: {
                  var10000 = _livingEntity5.getAttribute_(Attributes.f_22281_);
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entityiterator;
                     if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10001 = _livingEntity2.getAttribute_(Attributes.f_22281_).m_22115_();
                        break label60;
                     }
                  }

                  var10001 = 0.0;
               }

               double var10002;
               label55: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity3 = (LivingEntity)entity;
                     if (_livingEntity3.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10002 = _livingEntity3.getAttribute_(Attributes.f_22281_).m_22115_();
                        break label55;
                     }
                  }

                  var10002 = 0.0;
               }

               int var10003;
               label50: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label50;
                     }
                  }

                  var10003 = 0;
               }

               var10000.m_22100_(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               MobEffectInstance var8;
               MobEffect var9;
               int var10005;
               label42: {
                  var8 = new MobEffectInstance;
                  var9 = MobEffects.f_19606_;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                        var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                        break label42;
                     }
                  }

                  var10005 = 0;
               }

               var8.<init>(var9, 2147483647, Math.max(var10005, 0), false, false);
               _entity.m_7292_(var8);
            }
         }

         entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
         entityiterator.getPersistentData().m_128347_("friend_num2", entity.getPersistentData().m_128459_("friend_num"));
         entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
         entityiterator.getPersistentData().m_128379_("Ambush", true);
         entityiterator.getPersistentData().m_128379_("domain_entity", true);
         entityiterator.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
      }
   }
}
