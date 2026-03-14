package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade323Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade323Model extends GeoModel<CursedSpiritGrade323Entity> {
   public CursedSpiritGrade323Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade323Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/rat.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade323Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/rat.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade323Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade323Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
