package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityTreeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityTreeModel extends GeoModel<EntityTreeEntity> {
   public EntityTreeModel() {
   }

   public ResourceLocation getAnimationResource(EntityTreeEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/tree.animation.json");
   }

   public ResourceLocation getModelResource(EntityTreeEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/tree.geo.json");
   }

   public ResourceLocation getTextureResource(EntityTreeEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
