package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modeldagon_fish_mini;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentMiniEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaSerpentMiniRenderer extends MobRenderer<SeaSerpentMiniEntity, Modeldagon_fish_mini<SeaSerpentMiniEntity>> {
   public SeaSerpentMiniRenderer(EntityRendererProvider.Context context) {
      super(context, new Modeldagon_fish_mini(context.bakeLayer(Modeldagon_fish_mini.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(SeaSerpentMiniEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/dagon_fish_mini.png");
   }
}
