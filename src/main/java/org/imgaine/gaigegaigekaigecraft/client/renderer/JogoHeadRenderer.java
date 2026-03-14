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
      super(context, new Modeljogo_head(context.m_174023_(Modeljogo_head.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(JogoHeadEntity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(JogoHeadEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/jogo2.png");
   }
}
