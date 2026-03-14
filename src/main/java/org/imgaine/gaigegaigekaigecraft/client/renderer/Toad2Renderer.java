package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modeltoad2;
import org.imgaine.gaigegaigekaigecraft.entity.Toad2Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Toad2Renderer extends MobRenderer<Toad2Entity, Modeltoad2<Toad2Entity>> {
   public Toad2Renderer(EntityRendererProvider.Context context) {
      super(context, new Modeltoad2(context.m_174023_(Modeltoad2.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(Toad2Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/toad2.png");
   }
}
