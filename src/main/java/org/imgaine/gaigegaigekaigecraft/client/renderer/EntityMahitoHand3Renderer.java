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
      super(context, new ModelMahitoHand3(context.m_174023_(ModelMahitoHand3.LAYER_LOCATION)), 1.0F);
   }

   protected void scale(EntityMahitoHand3Entity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(EntityMahitoHand3Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/mahitohand3.png");
   }
}
