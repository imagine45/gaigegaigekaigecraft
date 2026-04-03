package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.ModelMahitoHand3;
import org.imgaine.gaigegaigekaigecraft.entity.EntityMahitoHand3Entity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class EntityMahitoHand3Renderer extends MobRenderer<EntityMahitoHand3Entity, ModelMahitoHand3<EntityMahitoHand3Entity>> {
   public EntityMahitoHand3Renderer(EntityRendererProvider.Context context) {
      super(context, new ModelMahitoHand3(context.bakeLayer(ModelMahitoHand3.LAYER_LOCATION)), 1.0F);
   }

   protected void scale(EntityMahitoHand3Entity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(EntityMahitoHand3Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/mahitohand3.png");
   }
}
