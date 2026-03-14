package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import javax.annotation.Nullable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ChangeTargetProcedure {
   private static LivingDamageEvent _event;

   public ChangeTargetProcedure() {
   }

   @SubscribeEvent
   public static void onLivingDamage(LivingDamageEvent event) {
      _event = event;
      execute(event, event.getEntity().m_9236_(), event.getEntity(), event.getSource().m_7639_());
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      execute((Event)null, world, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
      Entity entity_a = null;
      if (event != null && entity != null && sourceentity != null) {
         if (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !sourceentity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, sourceentity.getPersistentData().m_128461_("OWNER_UUID"));
         }

         if (entity_a instanceof LivingEntity) {
            sourceentity = entity_a;
         }

         if (entity.m_6084_() && sourceentity.m_6084_()) {
            if (entity instanceof Mob) {
               Mob _entity = (Mob)entity;
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _ent = (LivingEntity)sourceentity;
                  _entity.m_6710_(_ent);
                  _entity.getPersistentData().m_128359_("TARGET_UUID", "");
               }
            }

            if (entity instanceof PathfinderMob) {
               PathfinderMob _pathfinderMob = (PathfinderMob)entity;
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _ent = (LivingEntity)sourceentity;
                  _pathfinderMob.f_21346_.m_25352_(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
               }
            }

         }
      }
   }
}
