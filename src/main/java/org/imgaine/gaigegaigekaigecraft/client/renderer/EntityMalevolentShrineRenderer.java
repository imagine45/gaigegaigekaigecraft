package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelmalevolent_shrine;
import org.imgaine.gaigegaigekaigecraft.entity.EntityMalevolentShrineEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityMalevolentShrineRenderer extends MobRenderer<EntityMalevolentShrineEntity, Modelmalevolent_shrine<EntityMalevolentShrineEntity>> {
   public EntityMalevolentShrineRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelmalevolent_shrine(context.bakeLayer(Modelmalevolent_shrine.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityMalevolentShrineEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/malevolent_shrine.png");
   }
}
