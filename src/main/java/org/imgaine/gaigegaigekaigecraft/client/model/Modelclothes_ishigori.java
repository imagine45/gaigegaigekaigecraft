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

public class Modelclothes_ishigori<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_ishigori"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart right_boot;
   public final ModelPart left_boot;
   public final ModelPart steve;

   public Modelclothes_ishigori(ModelPart root) {
      this.head = root.getChild("head");
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
      partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(2, 20).addBox(-3.0F, -9.0F, -4.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(9, 25).addBox(-3.0F, -9.0F, -7.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(8, 24).addBox(-2.5F, -8.5F, -8.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(7, 23).addBox(-3.0F, -6.0F, 4.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)).texOffs(20, 27).addBox(-4.0F, 12.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.351F)).texOffs(20, 27).mirror().addBox(2.0F, 12.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.351F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 26).addBox(-4.1F, -1.8F, -0.3F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 11.5F, -1.8F, 0.2182F, 0.0F, 3.1416F));
      body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(2.1F, -1.8F, -0.3F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.5F, -1.8F, 0.2182F, 0.0F, -3.1416F));
      body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.3161F, 3.466F, -1.1781F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -1.4381F, 0.1543F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.828F, -0.3704F, 2.0F, -1.5708F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -1.6448F, -0.0883F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.828F, -0.3704F, 2.0F, -1.1781F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -1.2006F, -0.2882F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.828F, -0.3704F, 2.0F, -0.7854F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -1.5399F, 0.3576F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.828F, -0.3704F, 2.0F, -1.9635F, 0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(18, 26).addBox(-0.5F, -1.4381F, 0.1543F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.828F, -0.3704F, 2.0F, -1.5708F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(18, 26).addBox(-0.5F, -1.6448F, -0.0883F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.828F, -0.3704F, 2.0F, -1.1781F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(18, 26).addBox(-0.5F, -1.2006F, -0.2882F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.828F, -0.3704F, 2.0F, -0.7854F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(18, 26).addBox(-0.5F, -1.5399F, 0.3576F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.828F, -0.3704F, 2.0F, -1.9635F, -0.7854F, 0.0F));
      body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.466F, -0.3161F, 0.0F, 0.0F, -1.5708F, -1.1781F));
      body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.466F, -0.3161F, 0.0F, 0.0F, 1.5708F, 1.1781F));
      body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.766F, -0.7161F, 0.0F, 0.0F, 1.5708F, 0.7854F));
      body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.266F, -0.2161F, 0.0F, 0.0F, 1.5708F, 1.5708F));
      body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.766F, -0.7161F, 0.0F, 0.0F, -1.5708F, -0.7854F));
      body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.266F, -0.2161F, 0.0F, 0.0F, 1.5708F, 1.9635F));
      body.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.266F, -0.2161F, 0.0F, 0.0F, -1.5708F, -1.9635F));
      body.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.266F, -0.2161F, 0.0F, 0.0F, -1.5708F, -1.5708F));
      body.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.2161F, 3.266F, -1.9635F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.2161F, 3.266F, -1.5708F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(18, 26).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.7161F, 3.766F, -0.7854F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(18, 26).addBox(-4.1F, -1.8F, 0.3F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 12.0F, 2.0F, -0.2182F, 0.0F, 3.1416F));
      body.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(18, 26).addBox(-1.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.3F, 12.4161F, -0.534F, -0.2182F, -1.5708F, 3.1416F));
      body.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-4.3F, 12.4161F, -0.534F, -0.2182F, 1.5708F, -3.1416F));
      body.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-0.9F, -1.8F, 0.3F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 2.0F, -0.2182F, 0.0F, -3.1416F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).texOffs(24, 30).addBox(-3.0F, 7.0F, -2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).texOffs(24, 30).addBox(-3.0F, 7.0F, 2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).texOffs(20, 26).addBox(-3.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)).texOffs(20, 26).addBox(1.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(1.3F, 7.4161F, 0.034F, 0.0F, -1.5708F, 2.9234F));
      right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.034F, 7.4161F, 2.3F, -0.2182F, 0.0F, -3.1416F));
      right_arm.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.966F, 7.4161F, -2.3F, 2.9234F, 0.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(-2.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.3F, 7.4161F, -0.534F, -0.2182F, 1.5708F, -3.1416F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false).texOffs(24, 30).mirror().addBox(-1.0F, 7.0F, -2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).mirror(false).texOffs(24, 30).mirror().addBox(-1.0F, 7.0F, 2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).mirror(false).texOffs(20, 26).mirror().addBox(3.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)).mirror(false).texOffs(20, 26).mirror().addBox(-1.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      left_arm.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(18, 26).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.3F, 7.4161F, 0.034F, 0.0F, 1.5708F, -2.9234F));
      left_arm.addOrReplaceChild("right_arm_r6", CubeListBuilder.create().texOffs(18, 26).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.034F, 7.4161F, 2.3F, -0.2182F, 0.0F, 3.1416F));
      left_arm.addOrReplaceChild("right_arm_r7", CubeListBuilder.create().texOffs(18, 26).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.966F, 7.4161F, -2.3F, 2.9234F, 0.0F, 0.0F));
      left_arm.addOrReplaceChild("right_arm_r8", CubeListBuilder.create().texOffs(18, 26).addBox(-1.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.3F, 7.4161F, -0.534F, -0.2182F, -1.5708F, 3.1416F));
      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.9352F, 0.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).texOffs(0, 0).addBox(-1.9352F, 5.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.0648F, 0.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).mirror(false).texOffs(0, 0).mirror().addBox(-2.0648F, 5.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      PartDefinition right_boot = partdefinition.addOrReplaceChild("right_boot", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));
      PartDefinition left_boot = partdefinition.addOrReplaceChild("left_boot", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));
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
