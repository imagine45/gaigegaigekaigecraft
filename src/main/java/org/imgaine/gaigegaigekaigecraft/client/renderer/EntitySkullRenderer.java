package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelskull1;
import org.imgaine.gaigegaigekaigecraft.entity.EntitySkullEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntitySkullRenderer extends MobRenderer<EntitySkullEntity, Modelskull1<EntitySkullEntity>> {
   public EntitySkullRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelskull1(context.bakeLayer(Modelskull1.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntitySkullEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/skull1.png");
   }
}
