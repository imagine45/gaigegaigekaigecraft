package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade110Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade110Model extends GeoModel<CursedSpiritGrade110Entity> {
   public CursedSpiritGrade110Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade110Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit1_10.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade110Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit1_10.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade110Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade110Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
