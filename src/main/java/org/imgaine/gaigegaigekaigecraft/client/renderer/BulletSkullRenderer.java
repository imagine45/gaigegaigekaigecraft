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
      super(context, new Modelbullet_skull(context.bakeLayer(Modelbullet_skull.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(BulletSkullEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(BulletSkullEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit1_2.png");
   }
}
