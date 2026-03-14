package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelbullet_skull;
import org.imgaine.gaigegaigekaigecraft.entity.BulletSkullEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class BulletSkullRenderer extends MobRenderer<BulletSkullEntity, Modelbullet_skull<BulletSkullEntity>> {
   public BulletSkullRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelbullet_skull(context.m_174023_(Modelbullet_skull.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(BulletSkullEntity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(BulletSkullEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit1_2.png");
   }
}
