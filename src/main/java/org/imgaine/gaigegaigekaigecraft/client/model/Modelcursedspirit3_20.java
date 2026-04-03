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

public class Modelcursedspirit3_20<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_20"), "main");
   public final ModelPart bone;
   public final ModelPart head;
   public final ModelPart torso;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_arm2;
   public final ModelPart left_arm2;
   public final ModelPart right_arm3;
   public final ModelPart left_arm3;

   public Modelcursedspirit3_20(ModelPart root) {
      this.bone = root.getChild("bone");
      this.head = this.bone.getChild("head");
      this.torso = this.bone.getChild("torso");
      this.right_arm = this.bone.getChild("right_arm");
      this.left_arm = this.bone.getChild("left_arm");
      this.right_arm2 = this.bone.getChild("right_arm2");
      this.left_arm2 = this.bone.getChild("left_arm2");
      this.right_arm3 = this.bone.getChild("right_arm3");
      this.left_arm3 = this.bone.getChild("left_arm3");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -3.9571F));
      PartDefinition head = bone.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 12).addBox(-1.75F, 0.4142F, -3.8284F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)).texOffs(22, 12).mirror().addBox(-2.25F, 1.5142F, -3.7284F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)).mirror(false).texOffs(0, 0).addBox(-3.0F, 0.4142F, -3.8284F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.0F, 0.4142F, -3.8284F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -3.0F));
      head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.7854F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, 1.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition torso = bone.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      torso.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(2.4825F, -3.5675F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0216F, -1.4136F, -0.3614F, -0.4215F));
      torso.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(2.1945F, -2.0F, 0.0303F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0216F, -1.5708F, 0.0F, -0.3927F));
      torso.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(2.4825F, -0.4325F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0216F, -1.728F, 0.3614F, -0.4215F));
      torso.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-5.4825F, -3.5675F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0216F, -1.4136F, 0.3614F, 0.4215F));
      torso.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-5.4825F, -0.4325F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0216F, -1.728F, -0.3614F, 0.4215F));
      torso.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 4.5F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, 2.5F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.75F, 10.0F, 2.3562F, 0.0F, 0.0F));
      torso.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(21, 14).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.1642F, 10.0F, -0.5299F, 0.7119F, -0.3655F));
      torso.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(21, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.1642F, 10.0F, -0.5299F, -0.7119F, 0.3655F));
      torso.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 20).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6893F, 9.6464F, -0.7854F, 0.0F, 0.0F));
      torso.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0216F, -1.5F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0216F, 1.5708F, 0.0F, 0.0F));
      torso.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-5.1945F, -2.0F, 0.0303F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0216F, -1.5708F, 0.0F, 0.3927F));
      PartDefinition right_arm = bone.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -3.75F, -1.0F, 0.0F, -0.3927F, 0.0F));
      right_arm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(22, 0).addBox(-0.25F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(22, 4).addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(22, 0).addBox(0.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, 0.3927F));
      right_arm.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));
      PartDefinition left_arm = bone.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -3.75F, -1.0F, 0.0F, 0.3927F, 0.0F));
      left_arm.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(22, 0).addBox(-0.75F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(22, 4).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 0).addBox(-1.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, -0.3927F));
      left_arm.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9635F));
      PartDefinition right_arm2 = bone.addOrReplaceChild("right_arm2", CubeListBuilder.create(), PartPose.offset(-4.0F, -3.75F, 3.0F));
      right_arm2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(22, 0).addBox(-0.25F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(22, 4).addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(22, 0).addBox(0.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, 0.3927F));
      right_arm2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));
      PartDefinition left_arm2 = bone.addOrReplaceChild("left_arm2", CubeListBuilder.create(), PartPose.offset(4.0F, -3.75F, 3.0F));
      left_arm2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(22, 0).addBox(-0.75F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(22, 4).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(22, 0).addBox(-1.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, -0.3927F));
      left_arm2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9635F));
      PartDefinition right_arm3 = bone.addOrReplaceChild("right_arm3", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -3.75F, 7.0F, 0.0F, 0.3927F, 0.0F));
      right_arm3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(22, 0).addBox(-0.25F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm3.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(22, 4).addBox(-0.75F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm3.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(22, 0).addBox(0.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, 0.3927F));
      right_arm3.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));
      PartDefinition left_arm3 = bone.addOrReplaceChild("left_arm3", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, -3.75F, 7.0F, 0.0F, -0.3927F, 0.0F));
      left_arm3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(22, 0).addBox(-0.75F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm3.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(22, 4).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(22, 0).addBox(-1.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, -0.3927F));
      left_arm3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9635F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_arm3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_arm2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_arm2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_arm3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
