package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class Rika2Model extends GeoModel<Rika2Entity> {
   public Rika2Model() {
   }

   public ResourceLocation getAnimationResource(Rika2Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/rika2.animation.json");
   }

   public ResourceLocation getModelResource(Rika2Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/rika2.geo.json");
   }

   public ResourceLocation getTextureResource(Rika2Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(Rika2Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
