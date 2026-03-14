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
      super(context, new Modelgravestone3(context.m_174023_(Modelgravestone3.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(Gravestone3Entity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(Gravestone3Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/gravestone.png");
   }
}
