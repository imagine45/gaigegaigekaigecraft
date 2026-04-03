package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade24Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade24Model extends GeoModel<CursedSpiritGrade24Entity> {
   public CursedSpiritGrade24Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade24Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit2_4.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade24Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit2_4.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade24Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade24Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
