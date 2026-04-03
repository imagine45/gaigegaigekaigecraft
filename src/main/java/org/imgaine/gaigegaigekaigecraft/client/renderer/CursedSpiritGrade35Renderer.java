package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_5;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade35Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade35Renderer extends MobRenderer<CursedSpiritGrade35Entity, Modelcursedspirit3_5<CursedSpiritGrade35Entity>> {
   public CursedSpiritGrade35Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_5(context.bakeLayer(Modelcursedspirit3_5.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade35Entity entity, PoseStack poseStack, float f) {
      poseStack.scale(0.5F, 0.5F, 0.5F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade35Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_5.png");
   }
}
