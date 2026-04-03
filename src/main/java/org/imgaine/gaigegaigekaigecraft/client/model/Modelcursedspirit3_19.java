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

public class Modelcursedspirit3_19<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_19"), "main");
   public final ModelPart bone;
   public final ModelPart left_leg;
   public final ModelPart right_leg;
   public final ModelPart right_arm;
   public final ModelPart left_arm;

   public Modelcursedspirit3_19(ModelPart root) {
      this.bone = root.getChild("bone");
      this.left_leg = root.getChild("left_leg");
      this.right_leg = root.getChild("right_leg");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5858F, -1.0F, -0.4142F, 0.0F, 2.3562F, 0.0F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 3.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1213F, -1.0F, 0.1213F, 0.0F, 1.5708F, 0.0F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -3.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5858F, -1.0F, -0.4142F, 0.0F, -2.3562F, 0.0F));
      bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5858F, -1.0F, 0.6569F, 0.0F, 2.3562F, 0.0F));
      bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5858F, -1.0F, 0.6569F, 0.0F, -2.3562F, 0.0F));
      bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 3.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1213F, -1.0F, 0.1213F, 0.0F, -1.5708F, 0.0F));
      bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.2426F, 0.0F, 1.5708F, 0.0F));
      bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 4.75F, -4.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 50).addBox(-5.0F, -3.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 28).addBox(-6.0F, -10.75F, -8.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(-0.01F)).texOffs(0, 28).addBox(-6.0F, -10.75F, -4.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(-0.01F)).texOffs(0, 14).addBox(-3.0F, -15.75F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 28).addBox(-6.0F, -1.0F, -8.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(-0.001F)).texOffs(0, 28).addBox(8.0F, -1.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 37).addBox(-4.0F, -1.0F, 8.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-6.0F, -1.0F, -4.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.75F, 0.0F, 0.0F, 1.5708F, 0.0F));
      bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 28).addBox(8.0F, -1.25F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 37).addBox(-4.0F, -1.25F, 8.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 0.0F, 0.0F, -1.5708F, 0.0F));
      bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(4.4042F, -11.9257F, 0.0F, 0.0F, 0.0F, 0.7854F));
      bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-4.4042F, -11.9257F, 0.0F, 0.0F, 0.0F, -0.7854F));
      bone2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -11.9257F, 4.4042F, -0.7854F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -11.9257F, -4.4042F, 0.7854F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1602F, -10.4599F, 2.1602F, 0.3927F, 0.7854F, 0.0F));
      bone2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.6F, -2.9F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1602F, -10.4599F, 2.1602F, 0.7854F, 0.7854F, 0.0F));
      bone2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1602F, -10.4599F, 2.1602F, 0.3927F, -0.7854F, 0.0F));
      bone2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.6F, -2.9F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1602F, -10.4599F, 2.1602F, 0.7854F, -0.7854F, 0.0F));
      bone2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1602F, -10.4599F, -2.1602F, -0.3927F, 0.7854F, 0.0F));
      bone2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.6F, -3.1F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1602F, -10.4599F, -2.1602F, -0.7854F, 0.7854F, 0.0F));
      bone2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.6F, -3.1F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1602F, -10.4599F, -2.1602F, -0.7854F, -0.7854F, 0.0F));
      bone2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1602F, -10.4599F, -2.1602F, -0.3927F, -0.7854F, 0.0F));
      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 22.0F, 0.0F));
      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 22.0F, 0.0F));
      partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(56, 0).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 17.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(56, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 17.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
