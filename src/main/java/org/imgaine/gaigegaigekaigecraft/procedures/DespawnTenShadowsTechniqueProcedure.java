package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MaxElephantEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DespawnTenShadowsTechniqueProcedure {
   public DespawnTenShadowsTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM1 = 0.0;
         double NUM_SUM = 0.0;
         double NUM_SUM_TRUE = 0.0;
         if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
            if (entity.getPersistentData().getDouble("skill") != 0.0) {
               if (entity.getPersistentData().getDouble("cnt4") == 0.0) {
                  entity.getPersistentData().putDouble("cnt4", 1.0);
               }

               if (entity instanceof RozetsuShikigamiVessel2Entity) {
                  entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") - 8.0);
               }

               NUM_SUM = entity.getPersistentData().getDouble("cnt4");
            }

            NUM_SUM_TRUE = NUM_SUM;
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique"))) && !entityiterator.getPersistentData().getBoolean("domain_entity") && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num") && entityiterator.getPersistentData().getBoolean("Ambush")) {
                  if (entity instanceof FushiguroMegumiEntity && entityiterator instanceof MaxElephantEntity) {
                     NUM1 = 2.0;
                  } else if (entityiterator instanceof RabbitEscapeEntity) {
                     NUM1 = 0.025;
                  } else {
                     NUM1 = 1.0;
                  }

                  if (NUM_SUM + NUM1 > 2.0 && entity.getPersistentData().getDouble("skill") != 0.0) {
                     entityiterator.getPersistentData().putBoolean("flag_despawn", true);
                  } else {
                     NUM_SUM_TRUE += NUM1;
                  }

                  NUM_SUM += NUM1;
               }
            }
         }

         entity.getPersistentData().putDouble("cnt4", 0.0);
         if (!(entity instanceof Player)) {
            if (NUM_SUM_TRUE > 2.0) {
               entity.getPersistentData().putDouble("NUM_TenShadowsTechnique", 0.0);
            } else {
               entity.getPersistentData().putDouble("NUM_TenShadowsTechnique", NUM_SUM_TRUE);
            }
         }

      }
   }
}
