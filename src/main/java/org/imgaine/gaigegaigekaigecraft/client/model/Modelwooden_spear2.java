package org.imgaine.gaigegaigekaigecraft.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelwooden_spear2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelwooden_spear_2"), "main");
   public final ModelPart body2;

   public Modelwooden_spear2(ModelPart root) {
      this.body2 = root.getChild("body2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));
      PartDefinition body = body2.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
      body.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(5, 4).addBox(-1.0F, -18.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 4).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 6).addBox(-2.0F, -14.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(3, 2).addBox(-2.5F, -12.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(7, 7).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(28, 0).addBox(-0.5F, -20.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));
      body.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(5, 4).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 4).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 6).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(3, 2).addBox(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(7, 7).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(28, 0).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2446F, 1.9608F, -4.1232F, 0.8007F, -0.7699F, -0.1295F));
      body.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(5, 4).mirror().addBox(-1.0F, -18.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(15, 4).mirror().addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 6).mirror().addBox(-2.0F, -14.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(3, 2).mirror().addBox(-2.5F, -12.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(7, 7).mirror().addBox(-3.0F, -10.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(28, 0).mirror().addBox(-0.5F, -20.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.7854F, 0.9163F, 0.0873F));
      body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(5, 4).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 4).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 6).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(3, 2).addBox(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(7, 7).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(28, 0).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 4.016F, 3.4918F, -1.5359F, -1.1188F, 0.9428F));
      body.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(5, 4).mirror().addBox(-1.0F, -10.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(15, 4).mirror().addBox(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 6).mirror().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(3, 2).mirror().addBox(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(7, 7).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(28, 0).mirror().addBox(-0.5F, -12.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2274F, 4.8694F, 4.0F, -1.2714F, 1.0201F, -0.7387F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.body2.yRot = netHeadYaw / 57.295776F;
      this.body2.xRot = headPitch / 57.295776F;
   }
}
