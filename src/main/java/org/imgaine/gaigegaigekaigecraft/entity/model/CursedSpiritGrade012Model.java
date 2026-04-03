package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade012Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade012Model extends GeoModel<CursedSpiritGrade012Entity> {
   public CursedSpiritGrade012Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade012Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/smallpox_deity_god.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade012Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/smallpox_deity_god.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade012Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade012Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bone38");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
