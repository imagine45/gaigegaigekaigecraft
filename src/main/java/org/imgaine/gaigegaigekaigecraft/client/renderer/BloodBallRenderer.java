package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelball;
import org.imgaine.gaigegaigekaigecraft.entity.BloodBallEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BloodBallRenderer extends MobRenderer<BloodBallEntity, Modelball<BloodBallEntity>> {
   public BloodBallRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelball(context.m_174023_(Modelball.LAYER_LOCATION)), 0.2F);
   }

   public ResourceLocation getTextureLocation(BloodBallEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/tex_darkred.png");
   }
}
