package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade16Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade16Model extends GeoModel<CursedSpiritGrade16Entity> {
   public CursedSpiritGrade16Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit1_6.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit1_6.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade16Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("face");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
