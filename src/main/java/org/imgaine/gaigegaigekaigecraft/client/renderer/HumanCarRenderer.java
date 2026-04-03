package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelMahitoCar;
import org.imgaine.gaigegaigekaigecraft.entity.HumanCarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HumanCarRenderer extends MobRenderer<HumanCarEntity, ModelMahitoCar<HumanCarEntity>> {
   public HumanCarRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelMahitoCar(context.bakeLayer(ModelMahitoCar.LAYER_LOCATION)), 1.2F);
   }

   public ResourceLocation getTextureLocation(HumanCarEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/mahitocar.png");
   }
}
