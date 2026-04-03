package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelrock_fragment;
import org.imgaine.gaigegaigekaigecraft.entity.LiquidMetalEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class LiquidMetalRenderer extends MobRenderer<LiquidMetalEntity, Modelrock_fragment<LiquidMetalEntity>> {
   public LiquidMetalRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelrock_fragment(context.bakeLayer(Modelrock_fragment.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(LiquidMetalEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(LiquidMetalEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/clear.png");
   }
}
