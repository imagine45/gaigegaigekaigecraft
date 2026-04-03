package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelTimeCellMoonPalace;
import org.imgaine.gaigegaigekaigecraft.entity.EntityTimeCellMoonPalaceEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityTimeCellMoonPalaceRenderer extends MobRenderer<EntityTimeCellMoonPalaceEntity, ModelTimeCellMoonPalace<EntityTimeCellMoonPalaceEntity>> {
   public EntityTimeCellMoonPalaceRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelTimeCellMoonPalace(context.bakeLayer(ModelTimeCellMoonPalace.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityTimeCellMoonPalaceEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/timecellmoonpalace.png");
   }
}
