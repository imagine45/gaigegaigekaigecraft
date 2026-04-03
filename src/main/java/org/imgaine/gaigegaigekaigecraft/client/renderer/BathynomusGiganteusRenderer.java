package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelbathynomus_giganteus;
import org.imgaine.gaigegaigekaigecraft.entity.BathynomusGiganteusEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class BathynomusGiganteusRenderer extends MobRenderer<BathynomusGiganteusEntity, Modelbathynomus_giganteus<BathynomusGiganteusEntity>> {
   public BathynomusGiganteusRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelbathynomus_giganteus(context.bakeLayer(Modelbathynomus_giganteus.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(BathynomusGiganteusEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(BathynomusGiganteusEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/bathynomus_giganteus.png");
   }
}
