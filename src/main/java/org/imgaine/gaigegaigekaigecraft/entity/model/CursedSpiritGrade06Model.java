package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade06Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade06Model extends GeoModel<CursedSpiritGrade06Entity> {
   public CursedSpiritGrade06Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade06Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit0_6.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade06Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit0_6.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade06Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade06Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
