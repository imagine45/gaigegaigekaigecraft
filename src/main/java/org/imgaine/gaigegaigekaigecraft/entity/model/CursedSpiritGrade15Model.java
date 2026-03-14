package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade15Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade15Model extends GeoModel<CursedSpiritGrade15Entity> {
   public CursedSpiritGrade15Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade15Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_5.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade15Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_5.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade15Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade15Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("eye");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
