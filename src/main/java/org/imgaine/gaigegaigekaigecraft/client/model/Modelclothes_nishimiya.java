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

public class Modelclothes_nishimiya<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_nishimiya"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;

   public Modelclothes_nishimiya(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
      this.RightLeg2 = root.getChild("RightLeg2");
      this.LeftLeg2 = root.getChild("LeftLeg2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(22, 10).mirror().addBox(-4.4888F, 0.8757F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 10).mirror().addBox(-4.4888F, -1.1243F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(28, 25).mirror().addBox(-2.0921F, -1.1199F, -1.4538F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(21, 9).mirror().addBox(-3.5921F, -1.1199F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(18, 8).mirror().addBox(-1.8752F, -1.6297F, -1.9538F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false).texOffs(21, 9).mirror().addBox(3.0248F, -1.1297F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(16, 8).mirror().addBox(-0.5752F, -1.6297F, -1.9538F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, 0.6981F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(22, 10).mirror().addBox(-5.2304F, 0.0523F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.4987F, -10.1935F, -0.0462F, 1.5708F, 0.2182F, 0.6981F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(22, 10).mirror().addBox(-4.7276F, -1.2063F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, -0.0873F));
      Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(22, 10).mirror().addBox(-5.2801F, -0.8812F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.4987F, -10.1935F, -0.0462F, 1.5708F, -0.2618F, 0.6981F));
      Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(22, 10).mirror().addBox(-4.4339F, 0.4862F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, 1.3526F));
      Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(28, 25).addBox(1.0921F, -1.1199F, -1.4538F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).texOffs(22, 10).addBox(1.4888F, 0.8757F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 10).addBox(1.4888F, -1.1243F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 9).addBox(1.5921F, -1.1199F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(21, 9).addBox(-5.0248F, -1.1297F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(18, 8).addBox(-1.1248F, -1.6297F, -1.9538F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)).texOffs(16, 8).addBox(-3.4248F, -1.6297F, -1.9538F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, -0.6981F));
      Head.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(22, 10).addBox(1.7276F, -1.2063F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, 0.0873F));
      Head.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(22, 10).addBox(2.2304F, 0.0523F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4987F, -10.1935F, -0.0462F, 1.5708F, -0.2182F, -0.6981F));
      Head.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(22, 10).addBox(2.2801F, -0.8812F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4987F, -10.1935F, -0.0462F, 1.5708F, 0.2618F, -0.6981F));
      Head.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(22, 10).addBox(1.4339F, 0.4862F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, -1.3526F));
      partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(16, 32).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(16, 32).mirror().addBox(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
