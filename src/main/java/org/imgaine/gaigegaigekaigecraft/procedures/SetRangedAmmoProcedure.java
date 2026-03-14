package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SetRangedAmmoProcedure {
   public SetRangedAmmoProcedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double str_level = 0.0;
         if (entityiterator instanceof LivingEntity) {
            if (entity.getPersistentData().m_128459_("NameRanged") == 0.0) {
               entity.getPersistentData().m_128347_("NameRanged", Math.random());
            }

            if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            entityiterator.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
            entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
            if (entity instanceof Player || entity.getPersistentData().m_128471_("Player")) {
               entityiterator.getPersistentData().m_128379_("Player", true);
               entityiterator.getPersistentData().m_128359_("PlayerName", entity.m_5446_().getString());
            }

            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               entityiterator.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
               entityiterator.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt19 = (LivingEntity)entity;
               if (_livEnt19.m_21023_(MobEffects.f_19600_)) {
                  double var10000;
                  label54: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label54;
                        }
                     }

                     var10000 = 0.0;
                  }

                  str_level = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt21 = (LivingEntity)entity;
                     if (_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        int var10001;
                        label46: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
                                 break label46;
                              }
                           }

                           var10001 = 0;
                        }

                        str_level = str_level + (double)var10001 + 1.0;
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)str_level, false, false));
                     }
                  }
               }
            }

            entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
         }

      }
   }
}
