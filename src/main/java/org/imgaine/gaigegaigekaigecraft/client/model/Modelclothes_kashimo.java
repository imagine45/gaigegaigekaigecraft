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

public class Modelclothes_kashimo<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_kashimo"), "main");
   public final ModelPart head;
   public final ModelPart bone;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart right_boot;
   public final ModelPart left_boot;
   public final ModelPart steve;

   public Modelclothes_kashimo(ModelPart root) {
      this.head = root.getChild("head");
      this.bone = this.head.getChild("bone");
      this.body = root.getChild("body");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
      this.right_leg = root.getChild("right_leg");
      this.left_leg = root.getChild("left_leg");
      this.right_boot = root.getChild("right_boot");
      this.left_boot = root.getChild("left_boot");
      this.steve = root.getChild("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.26F)).texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(29, 20).mirror().addBox(-0.6F, 1.3F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -9.5F, -0.5F, 0.0F, 0.0F, -0.2618F));
      head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(29, 20).addBox(-0.4F, 1.3F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.5F, -9.5F, -0.5F, 0.0F, 0.0F, 0.2618F));
      head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(26, 26).mirror().addBox(-3.924F, -2.4175F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.2809F, 0.0F, -0.2618F, 0.0F, -0.2618F));
      head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(26, 26).addBox(2.924F, -2.4175F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -9.2809F, 0.0F, -0.2618F, 0.0F, 0.2618F));
      PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 4.0F));
      bone.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(20, 23).addBox(1.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.1745F, -0.3927F));
      bone.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(20, 23).addBox(-2.0F, -4.5F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.offsetAndRotation(2.4319F, -3.139F, 0.6946F, 0.0F, -0.0436F, -0.7854F));
      bone.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(20, 23).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.offsetAndRotation(-0.2088F, -0.7855F, 1.7596F, 0.5472F, -0.5964F, -1.0004F));
      bone.addOrReplaceChild("head_r8", CubeListBuilder.create().texOffs(20, 23).addBox(1.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2428F, -0.6501F, -0.4932F));
      bone.addOrReplaceChild("head_r9", CubeListBuilder.create().texOffs(20, 23).mirror().addBox(-5.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.3927F));
      bone.addOrReplaceChild("head_r10", CubeListBuilder.create().texOffs(20, 23).mirror().addBox(-2.0F, -4.5F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).mirror(false), PartPose.offsetAndRotation(-2.4319F, -3.139F, 0.6946F, 0.0F, 0.0436F, 0.7854F));
      bone.addOrReplaceChild("head_r11", CubeListBuilder.create().texOffs(20, 23).mirror().addBox(-2.0F, -5.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).mirror(false), PartPose.offsetAndRotation(0.2088F, -0.7855F, 1.7596F, 0.5472F, 0.5964F, 1.0004F));
      bone.addOrReplaceChild("head_r12", CubeListBuilder.create().texOffs(20, 23).mirror().addBox(-5.0F, -4.0F, 0.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.26F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2428F, 0.6501F, 0.4932F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.261F)).texOffs(12, 16).mirror().addBox(-3.0F, -0.5F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 27).addBox(-3.5F, -3.0F, -0.5F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(0.0F, 14.0F, 3.0F, 0.1745F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(17, 27).addBox(-3.5F, -2.5F, 0.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(0.0F, 13.5944F, -2.4208F, -0.1745F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).texOffs(0, 9).addBox(-3.0F, 3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, 16).addBox(-3.0F, 1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.38F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false).texOffs(0, 9).mirror().addBox(-1.0F, 3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false).texOffs(0, 16).mirror().addBox(-1.0F, 1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.38F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.0648F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.14F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      right_leg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false).texOffs(0, 4).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.0F, 0.0436F, 0.0F));
      PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.0648F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.14F)), PartPose.offset(2.0F, 12.0F, 0.0F));
      left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(0, 4).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(0, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.0F, -0.0436F, 0.0F));
      partdefinition.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("steve", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16).mirror().addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 16).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 16).mirror().addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_boot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_boot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
