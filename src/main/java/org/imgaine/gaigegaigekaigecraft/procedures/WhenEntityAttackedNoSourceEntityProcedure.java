package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.entity.CoffinEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade15Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade23Entity;
import org.imgaine.gaigegaigekaigecraft.entity.GreatSerpentEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Killer1Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenEntityAttackedNoSourceEntityProcedure {
   public WhenEntityAttackedNoSourceEntityProcedure() {
   }

   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getSource(), event.getEntity());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
      execute((Event)null, world, damagesource, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation")))) {
            label120: {
               if (!damagesource.m_276093_(DamageTypes.f_286979_) && entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     label119: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt3 = (LivingEntity)entity;
                           if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label119;
                           }
                        }

                        if (event != null && event.isCancelable()) {
                           event.setCanceled(true);
                        }
                        break label120;
                     }
                  }
               }

               if (entity.m_9236_().m_46472_() == ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")) && event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            }
         }

         if (damagesource.m_276093_(DamageTypes.f_268612_)) {
            if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && !(entity instanceof Killer1Entity) && !(entity instanceof GreatSerpentEntity)) {
               label89: {
                  label88: {
                     if (!(entity instanceof CursedSpiritGrade15Entity) && !(entity instanceof CursedSpiritGrade23Entity)) {
                        if (!entity.getPersistentData().m_128471_("CursedSpirit")) {
                           break label88;
                        }

                        int var10000;
                        label83: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label83;
                              }
                           }

                           var10000 = 0;
                        }

                        if (var10000 > 3) {
                           break label88;
                        }
                     }

                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }
                     break label89;
                  }

                  if (!world.m_6443_(CoffinEntity.class, AABB.m_165882_(new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), 0.1, 0.1, 0.1), (e) -> true).isEmpty() && event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               }
            } else if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && (damagesource.m_276093_(DamageTypes.f_268444_) || damagesource.m_276093_(DamageTypes.f_268469_) || damagesource.m_276093_(DamageTypes.f_268585_) || damagesource.m_276093_(DamageTypes.f_268722_) || damagesource.m_276093_(DamageTypes.f_268493_)) && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

      }
   }
}
