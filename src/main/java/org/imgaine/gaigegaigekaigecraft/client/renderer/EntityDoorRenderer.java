package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelentity_door;
import org.imgaine.gaigegaigekaigecraft.entity.EntityDoorEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityDoorRenderer extends MobRenderer<EntityDoorEntity, Modelentity_door<EntityDoorEntity>> {
   public EntityDoorRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelentity_door(context.bakeLayer(Modelentity_door.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityDoorEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/entity_door.png");
   }
}
