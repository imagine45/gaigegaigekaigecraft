package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelgravestone3;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone3Entity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class Gravestone3Renderer extends MobRenderer<Gravestone3Entity, Modelgravestone3<Gravestone3Entity>> {
   public Gravestone3Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelgravestone3(context.bakeLayer(Modelgravestone3.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(Gravestone3Entity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(Gravestone3Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/gravestone.png");
   }
}
