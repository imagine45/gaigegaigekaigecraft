package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityJacobsLadderAngelEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityJacobsLadderAngelModel extends GeoModel<EntityJacobsLadderAngelEntity> {
   public EntityJacobsLadderAngelModel() {
   }

   public ResourceLocation getAnimationResource(EntityJacobsLadderAngelEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/jacobs_ladder_angel.animation.json");
   }

   public ResourceLocation getModelResource(EntityJacobsLadderAngelEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/jacobs_ladder_angel.geo.json");
   }

   public ResourceLocation getTextureResource(EntityJacobsLadderAngelEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityJacobsLadderAngelEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
