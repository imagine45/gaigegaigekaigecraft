package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade25Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade25Model extends GeoModel<CursedSpiritGrade25Entity> {
   public CursedSpiritGrade25Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade25Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit2_5.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade25Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit2_5.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade25Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade25Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head2");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
