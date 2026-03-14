package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SeaSerpentModel extends GeoModel<SeaSerpentEntity> {
   public SeaSerpentModel() {
   }

   public ResourceLocation getAnimationResource(SeaSerpentEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/dagon_fish1.animation.json");
   }

   public ResourceLocation getModelResource(SeaSerpentEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/dagon_fish1.geo.json");
   }

   public ResourceLocation getTextureResource(SeaSerpentEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SeaSerpentEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("all");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
