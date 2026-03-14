package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade29Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade29Model extends GeoModel<CursedSpiritGrade29Entity> {
   public CursedSpiritGrade29Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade29Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit2_9.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade29Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit2_9.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade29Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade29Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
