package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade03Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade03Model extends GeoModel<CursedSpiritGrade03Entity> {
   public CursedSpiritGrade03Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade03Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/tamamonomae.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade03Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/tamamonomae.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade03Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade03Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
