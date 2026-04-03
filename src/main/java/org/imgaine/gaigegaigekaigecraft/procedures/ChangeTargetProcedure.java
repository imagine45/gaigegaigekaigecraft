package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerLevel;
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
      execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      execute((Event)null, world, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
      Entity entity_a = null;
      if (event != null && entity != null && sourceentity != null) {
         if (entity != sourceentity) {
            if (!sourceentity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
               entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.getEntity(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, sourceentity.getPersistentData().getString("OWNER_UUID"));
            }

            if (entity_a instanceof LivingEntity) {
               sourceentity = entity_a;
            }

            if (entity.isAlive() && sourceentity.isAlive()) {
               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)sourceentity;
                     _entity.setTarget(_ent);
                     _entity.getPersistentData().putString("TARGET_UUID", "");
                  }
               }

               if (entity instanceof PathfinderMob) {
                  PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)sourceentity;
                     _pathfinderMob.targetSelector.addGoal(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                  }
               }

            }
         }
      }
   }
}
