package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade17Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade17Model extends GeoModel<CursedSpiritGrade17Entity> {
   public CursedSpiritGrade17Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit2_14.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit2_14.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade17Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
