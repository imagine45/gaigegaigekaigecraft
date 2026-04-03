package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_18;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade318Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade318Renderer extends MobRenderer<CursedSpiritGrade318Entity, Modelcursedspirit3_18<CursedSpiritGrade318Entity>> {
   public CursedSpiritGrade318Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_18(context.bakeLayer(Modelcursedspirit3_18.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade318Entity entity, PoseStack poseStack, float f) {
      poseStack.scale(0.4F, 0.4F, 0.4F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade318Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_18.png");
   }
}
