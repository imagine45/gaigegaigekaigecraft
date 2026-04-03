package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade07Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade07Model extends GeoModel<CursedSpiritGrade07Entity> {
   public CursedSpiritGrade07Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade07Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit0_7.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade07Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit0_7.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade07Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade07Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
