package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BlackHoleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PureLoveCannonEntity;
import org.imgaine.gaigegaigekaigecraft.entity.PurpleEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UzumakiEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DespawnRangedAmmoProcedure {
   public DespawnRangedAmmoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
            if (entity != entityiterator && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && (entity.getPersistentData().getDouble("NameRanged") != 0.0 && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged") || entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID()))) {
               logic_a = true;
               if (entityiterator instanceof PurpleEntity || entityiterator instanceof UzumakiEntity || entityiterator instanceof PureLoveCannonEntity || entityiterator instanceof MeteorEntity || entityiterator instanceof BlackHoleEntity) {
                  logic_a = false;
               }

               if (!ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString().contains("gaigegaigekaigecraft:")) {
                  logic_a = false;
               }

               if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_cursed_technique")))) {
                  logic_a = false;
               }

               if (logic_a && !entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }
            }
         }

      }
   }
}
