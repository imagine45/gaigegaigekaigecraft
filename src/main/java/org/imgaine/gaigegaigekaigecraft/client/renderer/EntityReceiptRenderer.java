package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelreceipt;
import org.imgaine.gaigegaigekaigecraft.entity.EntityReceiptEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityReceiptRenderer extends MobRenderer<EntityReceiptEntity, Modelreceipt<EntityReceiptEntity>> {
   public EntityReceiptRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelreceipt(context.bakeLayer(Modelreceipt.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityReceiptEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/receipt.png");
   }
}
