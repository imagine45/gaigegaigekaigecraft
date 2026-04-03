package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.Doll1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class Doll1Model extends GeoModel<Doll1Entity> {
   public Doll1Model() {
   }

   public ResourceLocation getAnimationResource(Doll1Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/doll1.animation.json");
   }

   public ResourceLocation getModelResource(Doll1Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/doll1.geo.json");
   }

   public ResourceLocation getTextureResource(Doll1Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(Doll1Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
