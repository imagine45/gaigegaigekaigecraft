package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade12Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade12Model extends GeoModel<CursedSpiritGrade12Entity> {
   public CursedSpiritGrade12Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade12Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_2.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade12Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_2.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade12Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade12Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
