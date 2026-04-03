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

public class Modelclothes_decisive_battle<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_decisive_battle"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart steve;

   public Modelclothes_decisive_battle(ModelPart root) {
      this.head = root.getChild("head");
      this.body = root.getChild("body");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
      this.steve = root.getChild("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 55).mirror().addBox(-4.5F, -0.6541F, -3.0F, 9.0F, 3.0F, 6.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(37, 60).mirror().addBox(-2.5F, -2.7411F, 2.4962F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.0689F, -0.5F, -0.3927F, -1.5708F, 0.0F));
      head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(37, 60).mirror().addBox(-2.5F, -2.7411F, -3.4962F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(1.5F, 0.0689F, -0.5F, 0.3927F, -1.5708F, 0.0F));
      head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(37, 60).mirror().addBox(-4.5F, -1.3F, -0.3F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1541F, 3.2272F, -0.3927F, 0.0F, 0.0F));
      head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(37, 60).mirror().addBox(-4.5F, -0.3F, -0.7F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1541F, -3.2272F, 0.3927F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(50, 24).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(-3.8057F, 13.5098F, -2.3311F, -0.121F, 0.05F, 0.3897F));
      body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(50, 24).mirror().addBox(-0.5F, -4.4F, -0.1F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-4.9736F, 13.6497F, -2.0086F, -3.0183F, -0.7601F, -2.953F));
      body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(50, 24).mirror().addBox(-1.5F, -3.5F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-4.8981F, 12.2775F, 0.0F, 0.0F, 1.5708F, 0.2182F));
      body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(50, 24).mirror().addBox(-1.0F, -4.5F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-4.416F, 13.4251F, 2.34F, 3.0183F, 0.7601F, -3.0839F));
      body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(50, 24).mirror().addBox(0.0F, -3.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-2.0844F, 15.2159F, 4.4432F, 2.8328F, 0.3669F, 3.125F));
      body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(50, 24).mirror().addBox(-0.5F, -3.5F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-2.1346F, 6.4371F, 2.4674F, 3.0073F, 0.3669F, 3.125F));
      body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(50, 24).mirror().addBox(-0.5F, -3.5F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.151F)).mirror(false), PartPose.offsetAndRotation(-2.1346F, 11.4371F, 3.4674F, 3.0073F, 0.3669F, 3.125F));
      body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(50, 24).addBox(-1.5F, -3.5F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(2.1346F, 6.4371F, 2.4674F, 3.0073F, -0.3669F, -3.125F));
      body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(50, 24).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(0.0F, 7.9337F, 2.7813F, 0.1745F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(50, 24).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(0.0F, 12.9337F, 3.7813F, 0.1745F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(50, 24).addBox(-1.5F, -3.5F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.151F)), PartPose.offsetAndRotation(2.1346F, 11.4371F, 3.4674F, 3.0073F, -0.3669F, -3.125F));
      body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(50, 24).addBox(-2.0F, 1.0F, -0.3F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(0.0F, 10.7904F, 3.2925F, 0.3491F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(50, 24).mirror().addBox(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(3.8057F, 13.5098F, -2.3311F, -0.121F, -0.05F, -0.3897F));
      body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(50, 24).addBox(-2.0F, -3.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(2.0844F, 15.2159F, 4.4432F, 2.8328F, -0.3669F, -3.125F));
      body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(50, 24).addBox(-1.0F, -4.5F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(4.416F, 13.4251F, 2.34F, 3.0183F, -0.7601F, 3.0839F));
      body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(50, 24).addBox(-0.5F, -4.4F, -0.1F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(4.9736F, 13.6497F, -2.0086F, -3.0183F, 0.7601F, 2.953F));
      body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(50, 24).addBox(-1.5F, -3.5F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(4.8981F, 12.2775F, 0.0F, 0.0F, -1.5708F, -0.2182F));
      body.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(58, 0).addBox(-1.7F, -2.9F, 0.4F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(1.8F, 6.5F, -2.5F, 0.0F, -0.3927F, -0.3927F));
      body.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-0.3F, -2.9F, 0.4F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-1.8F, 6.5F, -2.5F, 0.0F, 0.3927F, 0.3927F));
      body.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(58, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.5F, 4.7F, -2.0F, 0.0F, 0.0F, -0.2618F));
      body.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 4.7F, -2.0F, 0.0F, 0.0F, 0.2618F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 21).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -3.135F, 1.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(-1.0F, 2.1661F, 0.0F, 0.1745F, 0.7854F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -3.135F, -2.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(-1.0F, 2.1661F, 0.0F, -0.1745F, -0.7854F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.0F, -3.135F, 1.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.1661F, 0.0F, 0.1745F, -0.7854F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.0F, -3.135F, -2.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.1661F, 0.0F, -0.1745F, 0.7854F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.5F, -4.135F, -2.5701F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.6661F, 0.0F, 0.0F, 1.5708F, 0.1745F));
      right_arm.addOrReplaceChild("right_arm_r6", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.5F, -4.5F, -0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.6661F, 2.102F, 0.1745F, 0.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r7", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.5F, -2.229F, -1.9647F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 5.701F, 0.0F, 0.6981F, 1.5708F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r8", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 5.701F, 1.912F, -0.6981F, 0.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r9", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 5.701F, -1.912F, 0.6981F, 0.0F, 0.0F));
      right_arm.addOrReplaceChild("right_arm_r10", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(0.5F, -4.0F, 0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 2.0F, -3.0F, -0.1745F, 0.0F, 0.0F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.0F, -3.135F, 1.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(1.0F, 2.1661F, 0.0F, 0.1745F, -0.7854F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.0F, -3.135F, -2.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(1.0F, 2.1661F, 0.0F, -0.1745F, 0.7854F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r3", CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -3.135F, 1.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 2.1661F, 0.0F, 0.1745F, 0.7854F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r4", CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -3.135F, -2.6701F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 2.1661F, 0.0F, -0.1745F, -0.7854F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r5", CubeListBuilder.create().texOffs(32, 20).addBox(-1.5F, -4.135F, -2.5701F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 2.6661F, 0.0F, 0.0F, -1.5708F, -0.1745F));
      left_arm.addOrReplaceChild("left_arm_r6", CubeListBuilder.create().texOffs(32, 20).addBox(-1.5F, -4.5F, -0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 2.6661F, 2.102F, 0.1745F, 0.0F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r7", CubeListBuilder.create().texOffs(32, 20).addBox(-1.5F, -2.229F, -1.9647F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 5.701F, 0.0F, 0.6981F, -1.5708F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r8", CubeListBuilder.create().texOffs(32, 20).addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 5.701F, 1.912F, -0.6981F, 0.0F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r9", CubeListBuilder.create().texOffs(32, 20).addBox(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(1.0F, 5.701F, -1.912F, 0.6981F, 0.0F, 0.0F));
      left_arm.addOrReplaceChild("left_arm_r10", CubeListBuilder.create().texOffs(32, 20).addBox(-3.5F, -4.0F, 0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(3.0F, 2.0F, -3.0F, -0.1745F, 0.0F, 0.0F));
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
