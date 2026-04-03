package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityTsuchigumoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityTsuchigumoModel extends GeoModel<EntityTsuchigumoEntity> {
   public EntityTsuchigumoModel() {
   }

   public ResourceLocation getAnimationResource(EntityTsuchigumoEntity entity) {
      if ((Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 1) {
         return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit_tsuchigumo_mini_2.animation.json");
      } else if ((Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 2) {
         return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit_tsuchigumo_mini_3.animation.json");
      } else {
         return (Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 3 ? new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit_tsuchigumo_mini_4.animation.json") : new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit_tsuchigumo_mini_1.animation.json");
      }
   }

   public ResourceLocation getModelResource(EntityTsuchigumoEntity entity) {
      if ((Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 1) {
         return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit_tsuchigumo_mini_2.geo.json");
      } else if ((Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 2) {
         return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit_tsuchigumo_mini_3.geo.json");
      } else {
         return (Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 3 ? new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit_tsuchigumo_mini_4.geo.json") : new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit_tsuchigumo_mini_1.geo.json");
      }
   }

   public ResourceLocation getTextureResource(EntityTsuchigumoEntity entity) {
      if ((Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 1) {
         return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/cursedspirit_tsuchigumo_mini_2.png");
      } else if ((Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 2) {
         return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/cursedspirit_tsuchigumo_mini_3.png");
      } else {
         return (Integer)entity.getEntityData().get(EntityTsuchigumoEntity.DATA_model) == 3 ? new ResourceLocation("gaigegaigekaigecraft", "textures/entities/cursedspirit_tsuchigumo_mini_4.png") : new ResourceLocation("gaigegaigekaigecraft", "textures/entities/cursedspirit_tsuchigumo_mini_1.png");
      }
   }
}
