package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade39Entity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade39Renderer extends HumanoidMobRenderer<CursedSpiritGrade39Entity, HumanoidModel<CursedSpiritGrade39Entity>> {
   public CursedSpiritGrade39Renderer(EntityRendererProvider.Context context) {
      super(context, new HumanoidModel(context.m_174023_(ModelLayers.f_171162_)), 0.0F);
      this.m_115326_(new HumanoidArmorLayer(this, new HumanoidModel(context.m_174023_(ModelLayers.f_171164_)), new HumanoidModel(context.m_174023_(ModelLayers.f_171165_)), context.m_266367_()));
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade39Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_9.png");
   }
}
