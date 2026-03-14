package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityMalevolentShrine2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityMalevolentShrine2Model extends GeoModel<EntityMalevolentShrine2Entity> {
   public EntityMalevolentShrine2Model() {
   }

   public ResourceLocation getAnimationResource(EntityMalevolentShrine2Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/malevolent_shrine_incomplete.animation.json");
   }

   public ResourceLocation getModelResource(EntityMalevolentShrine2Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/malevolent_shrine_incomplete.geo.json");
   }

   public ResourceLocation getTextureResource(EntityMalevolentShrine2Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
