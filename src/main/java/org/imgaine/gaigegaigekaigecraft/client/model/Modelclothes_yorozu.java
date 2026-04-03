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

public class Modelclothes_yorozu<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_yorozu"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart steve;

   public Modelclothes_yorozu(ModelPart root) {
      this.head = root.getChild("head");
      this.body = root.getChild("body");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
      this.steve = root.getChild("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(40, 33).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false).texOffs(24, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 0.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(10, 20).addBox(0.0F, -6.0F, 0.5F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-5.2694F, 11.1029F, -1.0F, 0.3927F, -1.5708F, 0.0F));
      body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(10, 20).addBox(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-5.4314F, 10.9116F, 2.0F, 0.3927F, -1.1781F, 0.0F));
      body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(10, 20).addBox(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.7314F, 10.9116F, 3.0F, 0.3927F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(-1.0F, -5.5F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.7357F, 10.8625F, -2.8875F, -0.2115F, -0.1357F, -0.1678F));
      body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(10, 20).addBox(-1.0F, -5.5F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.7357F, 10.8625F, -2.8875F, -0.2115F, 0.1357F, 0.1678F));
      body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(10, 20).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.6314F, 10.9116F, 4.0F, 0.3927F, -0.5236F, 0.0F));
      body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(-1.9F, -7.0F, -0.5F, 3.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(1.8993F, 10.9116F, 5.0F, 0.3919F, 0.1416F, -0.1073F));
      body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(10, 20).addBox(-1.1F, -7.0F, -0.5F, 3.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.8993F, 10.9116F, 5.0F, 0.3919F, -0.1416F, 0.1073F));
      body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(-1.0F, -7.0F, 0.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.6314F, 10.9116F, 4.0F, 0.3927F, 0.5236F, 0.0F));
      body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(10, 20).addBox(-4.3456F, -4.7197F, -3.0909F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 11.2116F, -2.3F, -0.2086F, 0.7769F, 0.1298F));
      body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(10, 20).addBox(-4.0024F, -4.2262F, -4.2824F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 11.2116F, -2.3F, -0.0614F, 1.1579F, 0.3053F));
      body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(2.3456F, -4.7197F, -3.0909F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.2116F, -2.3F, -0.2086F, -0.7769F, -0.1298F));
      body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(2.0024F, -4.2262F, -4.2824F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.2116F, -2.3F, -0.0614F, -1.1579F, -0.3053F));
      body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(5.4314F, 10.9116F, 2.0F, 0.3927F, 1.1781F, 0.0F));
      body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(4.7314F, 10.9116F, 3.0F, 0.3927F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(-3.0F, -6.0F, 0.5F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(5.2694F, 11.1029F, -1.0F, 0.3927F, 1.5708F, 0.0F));
      body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(11, 23).mirror().addBox(-3.0F, -3.0F, 2.0F, 6.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, 1.4F, 0.3927F, 0.0F, 0.0F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(38, 18).mirror().addBox(-1.5F, -1.0F, -1.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 3.6453F, 0.9964F, 0.583F, 0.6956F, 0.3999F));
      right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(38, 18).mirror().addBox(-1.5F, -5.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 3.7453F, 0.9964F, 0.2444F, 0.7703F, 0.1719F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(38, 18).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 3.6453F, 0.9964F, 0.583F, -0.6956F, -0.3999F));
      left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(38, 18).addBox(-1.5F, -5.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 3.7453F, 0.9964F, 0.2444F, -0.7703F, -0.1719F));
      partdefinition.addOrReplaceChild("steve", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 0).mirror().addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 0).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 0).mirror().addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 0).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
