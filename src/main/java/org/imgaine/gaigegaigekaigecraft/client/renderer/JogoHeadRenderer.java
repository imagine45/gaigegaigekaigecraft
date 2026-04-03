package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modeljogo_head;
import org.imgaine.gaigegaigekaigecraft.entity.JogoHeadEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class JogoHeadRenderer extends MobRenderer<JogoHeadEntity, Modeljogo_head<JogoHeadEntity>> {
   public JogoHeadRenderer(EntityRendererProvider.Context context) {
      super(context, new Modeljogo_head(context.bakeLayer(Modeljogo_head.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(JogoHeadEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(JogoHeadEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/jogo2.png");
   }
}
