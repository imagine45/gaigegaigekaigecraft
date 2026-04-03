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
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenEntityTakesDamageNoSourceProcedure {
   public WhenEntityTakesDamageNoSourceProcedure() {
   }

   @SubscribeEvent(
      priority = EventPriority.LOW
   )
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().level(), event.getSource(), event.getEntity());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
      execute((Event)null, world, damagesource, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:animation")))) {
            label120: {
               if (!damagesource.is(DamageTypes.GENERIC_KILL) && entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     label119: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt3 = (LivingEntity)entity;
                           if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
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

               if (entity.level().dimension() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")) && event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            }
         }

         if (damagesource.is(DamageTypes.IN_WALL)) {
            if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && !(entity instanceof Killer1Entity) && !(entity instanceof GreatSerpentEntity)) {
               label89: {
                  label88: {
                     if (!(entity instanceof CursedSpiritGrade15Entity) && !(entity instanceof CursedSpiritGrade23Entity)) {
                        if (!entity.getPersistentData().getBoolean("CursedSpirit")) {
                           break label88;
                        }

                        int var10000;
                        label83: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
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

                  if (!world.getEntitiesOfClass(CoffinEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY(), entity.getZ()), 0.1, 0.1, 0.1), (e) -> true).isEmpty() && event != null && event.isCancelable()) {
                     event.setCanceled(true);
                  }
               }
            } else if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         }

         if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && (damagesource.is(DamageTypes.FREEZE) || damagesource.is(DamageTypes.SWEET_BERRY_BUSH) || damagesource.is(DamageTypes.CACTUS) || damagesource.is(DamageTypes.DROWN) || damagesource.is(DamageTypes.WITHER)) && event != null && event.isCancelable()) {
            event.setCanceled(true);
         }

      }
   }
}
