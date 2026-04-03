package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modeluzumaki;
import org.imgaine.gaigegaigekaigecraft.entity.UzumakiEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class UzumakiRenderer extends MobRenderer<UzumakiEntity, Modeluzumaki<UzumakiEntity>> {
   public UzumakiRenderer(EntityRendererProvider.Context context) {
      super(context, new Modeluzumaki(context.bakeLayer(Modeluzumaki.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(UzumakiEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(UzumakiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/uzumaki.png");
   }
}
