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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Modelcursedspirit3_15<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_15"), "main");
   public final ModelPart bone;
   public final ModelPart right_leg10;
   public final ModelPart right_leg9;
   public final ModelPart right_leg8;
   public final ModelPart right_leg7;
   public final ModelPart right_leg6;
   public final ModelPart right_leg5;
   public final ModelPart right_leg4;
   public final ModelPart right_leg3;
   public final ModelPart right_leg2;
   public final ModelPart right_leg1;
   public final ModelPart left_leg10;
   public final ModelPart left_leg9;
   public final ModelPart left_leg8;
   public final ModelPart left_leg7;
   public final ModelPart left_leg6;
   public final ModelPart left_leg5;
   public final ModelPart left_leg4;
   public final ModelPart left_leg3;
   public final ModelPart left_leg2;
   public final ModelPart left_leg1;

   public Modelcursedspirit3_15(ModelPart root) {
      this.bone = root.getChild("bone");
      this.right_leg10 = root.getChild("right_leg10");
      this.right_leg9 = root.getChild("right_leg9");
      this.right_leg8 = root.getChild("right_leg8");
      this.right_leg7 = root.getChild("right_leg7");
      this.right_leg6 = root.getChild("right_leg6");
      this.right_leg5 = root.getChild("right_leg5");
      this.right_leg4 = root.getChild("right_leg4");
      this.right_leg3 = root.getChild("right_leg3");
      this.right_leg2 = root.getChild("right_leg2");
      this.right_leg1 = root.getChild("right_leg1");
      this.left_leg10 = root.getChild("left_leg10");
      this.left_leg9 = root.getChild("left_leg9");
      this.left_leg8 = root.getChild("left_leg8");
      this.left_leg7 = root.getChild("left_leg7");
      this.left_leg6 = root.getChild("left_leg6");
      this.left_leg5 = root.getChild("left_leg5");
      this.left_leg4 = root.getChild("left_leg4");
      this.left_leg3 = root.getChild("left_leg3");
      this.left_leg2 = root.getChild("left_leg2");
      this.left_leg1 = root.getChild("left_leg1");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -6.5F, -16.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(-0.5F)).texOffs(0, 23).addBox(-3.0F, -6.5F, 35.5F, 6.0F, 4.0F, 5.0F, new CubeDeformation(-0.5F)).texOffs(0, 0).addBox(-4.0F, -7.0F, -13.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)).texOffs(0, 11).addBox(-4.0F, -7.0F, -8.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -7.0F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)).texOffs(0, 11).addBox(-4.0F, -7.0F, 2.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 11).addBox(-4.0F, -7.0F, 12.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.1F)).texOffs(0, 11).addBox(-4.0F, -7.0F, 22.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.3F)).texOffs(0, 0).addBox(-4.0F, -7.0F, 17.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.45F)).texOffs(0, 0).addBox(-4.0F, -7.0F, 27.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.65F)).texOffs(0, 11).addBox(-4.0F, -7.0F, 31.5F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.5F)).texOffs(0, 0).addBox(-4.0F, -7.0F, 7.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-3.0445F, -3.0179F, -1.3505F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 41.0F, 1.4835F, 0.7854F, -2.9671F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 27).addBox(-0.9555F, -3.0179F, -1.3505F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(0.0F, -4.0F, 41.0F, 1.4835F, -0.7854F, 2.9671F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -5.0F, -16.0F, -1.4835F, -0.7854F, 0.1745F));
      bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).mirror(false), PartPose.offsetAndRotation(-0.1168F, -3.1148F, -15.9692F, -1.4835F, -0.5236F, 0.1745F));
      bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 27).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(0.1168F, -3.1148F, -15.9692F, -1.4835F, 0.5236F, -0.1745F));
      bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(22, 27).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(1.0F, -5.0F, -16.0F, -1.4835F, 0.7854F, -0.1745F));
      PartDefinition right_leg10 = partdefinition.addOrReplaceChild("right_leg10", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 35.4619F));
      right_leg10.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg9 = partdefinition.addOrReplaceChild("right_leg9", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 30.4619F));
      right_leg9.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg8 = partdefinition.addOrReplaceChild("right_leg8", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 25.4619F));
      right_leg8.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg7 = partdefinition.addOrReplaceChild("right_leg7", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 20.4619F));
      right_leg7.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg6 = partdefinition.addOrReplaceChild("right_leg6", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 15.4619F));
      right_leg6.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(1.8437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg5 = partdefinition.addOrReplaceChild("right_leg5", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 10.4619F));
      right_leg5.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg4 = partdefinition.addOrReplaceChild("right_leg4", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 5.4619F));
      right_leg4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg3 = partdefinition.addOrReplaceChild("right_leg3", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, 0.4619F));
      right_leg3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, -4.5381F));
      right_leg2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create(), PartPose.offset(3.3563F, 21.2366F, -9.5381F));
      right_leg1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(22, 27).addBox(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition left_leg10 = partdefinition.addOrReplaceChild("left_leg10", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 35.4619F));
      left_leg10.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg9 = partdefinition.addOrReplaceChild("left_leg9", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 30.4619F));
      left_leg9.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg8 = partdefinition.addOrReplaceChild("left_leg8", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 25.4619F));
      left_leg8.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg7 = partdefinition.addOrReplaceChild("left_leg7", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 20.4619F));
      left_leg7.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg6 = partdefinition.addOrReplaceChild("left_leg6", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 15.4619F));
      left_leg6.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.8437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg5 = partdefinition.addOrReplaceChild("left_leg5", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 10.4619F));
      left_leg5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg4 = partdefinition.addOrReplaceChild("left_leg4", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 5.4619F));
      left_leg4.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg3 = partdefinition.addOrReplaceChild("left_leg3", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, 0.4619F));
      left_leg3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, -4.5381F));
      left_leg2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create(), PartPose.offset(-3.3563F, 21.2366F, -9.5381F));
      left_leg1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(22, 27).mirror().addBox(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.right_leg10.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg1.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg9.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg7.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg8.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg5.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg6.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg3.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg3.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg4.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg4.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg5.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg6.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg7.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg8.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg9.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg10.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
