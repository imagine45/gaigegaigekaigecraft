package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelslicing_exorcism;
import org.imgaine.gaigegaigekaigecraft.entity.SlicingExorcismEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class SlicingExorcismRenderer extends MobRenderer<SlicingExorcismEntity, Modelslicing_exorcism<SlicingExorcismEntity>> {
   public SlicingExorcismRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelslicing_exorcism(context.m_174023_(Modelslicing_exorcism.LAYER_LOCATION)), 0.3F);
   }

   protected void scale(SlicingExorcismEntity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(SlicingExorcismEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/slicing_exorcism.png");
   }
}
