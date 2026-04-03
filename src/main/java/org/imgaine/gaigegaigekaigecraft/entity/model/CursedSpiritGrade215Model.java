package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade215Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade215Model extends GeoModel<CursedSpiritGrade215Entity> {
   public CursedSpiritGrade215Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade215Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit2_15.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade215Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit2_15.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade215Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade215Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
