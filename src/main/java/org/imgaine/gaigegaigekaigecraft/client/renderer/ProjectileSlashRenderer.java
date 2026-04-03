package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.entity.model.ProjectileSlashModel;
import org.imgaine.gaigegaigekaigecraft.procedures.CanSeeSukunaSlashProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ProjectileSlashRenderer extends GeoEntityRenderer<ProjectileSlashEntity> {
   public ProjectileSlashRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new ProjectileSlashModel());
      this.shadowRadius = 0.0F;
   }

   public void render(ProjectileSlashEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
      Entity viewingPlayer = Minecraft.getInstance().player;
      Level world = entity.level();
      if (viewingPlayer == null || CanSeeSukunaSlashProcedure.execute(world, entity, viewingPlayer)) {
         super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
      }
   }

   public RenderType getRenderType(ProjectileSlashEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(PoseStack poseStack, ProjectileSlashEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(ProjectileSlashEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
