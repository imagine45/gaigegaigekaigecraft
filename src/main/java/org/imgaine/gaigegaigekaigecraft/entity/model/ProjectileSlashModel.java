package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ProjectileSlashModel extends GeoModel<ProjectileSlashEntity> {
   public ProjectileSlashModel() {
   }

   public ResourceLocation getAnimationResource(ProjectileSlashEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/projectile_slash.animation.json");
   }

   public ResourceLocation getModelResource(ProjectileSlashEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/projectile_slash.geo.json");
   }

   public ResourceLocation getTextureResource(ProjectileSlashEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ProjectileSlashEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
