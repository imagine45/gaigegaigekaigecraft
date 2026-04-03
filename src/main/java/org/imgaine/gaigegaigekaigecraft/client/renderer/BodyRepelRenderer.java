package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.ModelMahitoHand4;
import org.imgaine.gaigegaigekaigecraft.entity.BodyRepelEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class BodyRepelRenderer extends MobRenderer<BodyRepelEntity, ModelMahitoHand4<BodyRepelEntity>> {
   public BodyRepelRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelMahitoHand4(context.bakeLayer(ModelMahitoHand4.LAYER_LOCATION)), 1.0F);
   }

   protected void scale(BodyRepelEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(BodyRepelEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/mahitohand4.png");
   }
}
