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

public class Modelclothes_hakari<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_hakari"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;

   public Modelclothes_hakari(ModelPart root) {
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
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.01F)).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.53F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Head.addOrReplaceChild("headwear_r1", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, -1.5518F, -1.421F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.9152F, 2.3171F, -2.3562F, 0.0F, 0.0F));
      Head.addOrReplaceChild("headwear_r2", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, -2.4586F, -1.646F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.9152F, 0.3171F, -1.5708F, 0.0F, 0.0F));
      Head.addOrReplaceChild("headwear_r3", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, -3.1F, -1.6F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.9369F, -3.5715F, -0.7854F, 0.0F, 0.0F));
      Head.addOrReplaceChild("headwear_r4", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, -1.3F, -0.6F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.0594F, -3.6019F, 0.3927F, 0.0F, 0.0F));
      Head.addOrReplaceChild("headwear_r5", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-0.95F, -2.3201F, -2.0669F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(2.1F, -8.4152F, 1.3171F, -2.3562F, 0.0F, 0.5236F));
      Head.addOrReplaceChild("headwear_r6", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-0.95F, -2.4586F, -1.4594F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(2.1F, -8.4152F, 0.3171F, -1.5708F, 0.0F, 0.5236F));
      Head.addOrReplaceChild("headwear_r7", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-0.95F, -3.0388F, -1.5388F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(1.1109F, -6.702F, -3.5715F, -0.7854F, 0.0F, 0.5236F));
      Head.addOrReplaceChild("headwear_r8", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-0.95F, -1.22F, -0.6331F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(1.1721F, -6.808F, -3.6019F, 0.3927F, 0.0F, 0.5236F));
      Head.addOrReplaceChild("headwear_r9", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, -2.2589F, -2.1281F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(3.4F, -6.7152F, 1.3171F, -2.3562F, 0.0F, 1.0472F));
      Head.addOrReplaceChild("headwear_r10", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, -2.4586F, -1.446F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(3.4F, -6.7152F, 0.3171F, -1.5708F, 0.0F, 1.0472F));
      Head.addOrReplaceChild("headwear_r11", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.0F, -3.1F, -1.6F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(1.6868F, -5.7261F, -3.5715F, -0.7854F, 0.0F, 1.0472F));
      Head.addOrReplaceChild("headwear_r12", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.4981F, -2.9847F, -2.6656F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(3.2768F, -4.5152F, 0.4239F, -2.3562F, 0.0F, 1.4835F));
      Head.addOrReplaceChild("headwear_r13", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.4981F, -2.3519F, -1.3128F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(3.2768F, -4.5152F, 0.4239F, -1.5708F, 0.0F, 1.4835F));
      Head.addOrReplaceChild("headwear_r14", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.4981F, 1.2182F, -2.9321F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(3.2768F, -4.5152F, 0.4239F, -0.7854F, 0.0F, 1.4835F));
      Head.addOrReplaceChild("headwear_r15", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5019F, -2.9847F, -2.6656F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-3.2768F, -4.5152F, 0.4239F, -2.3562F, 0.0F, -1.4835F));
      Head.addOrReplaceChild("headwear_r16", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5019F, -2.3519F, -1.3128F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-3.2768F, -4.5152F, 0.4239F, -1.5708F, 0.0F, -1.4835F));
      Head.addOrReplaceChild("headwear_r17", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5019F, 1.2182F, -2.9321F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-3.2768F, -4.5152F, 0.4239F, -0.7854F, 0.0F, -1.4835F));
      Head.addOrReplaceChild("headwear_r18", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -2.2589F, -2.1281F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-3.4F, -6.7152F, 1.3171F, -2.3562F, 0.0F, -1.0472F));
      Head.addOrReplaceChild("headwear_r19", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -2.4586F, -1.446F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-3.4F, -6.7152F, 0.3171F, -1.5708F, 0.0F, -1.0472F));
      Head.addOrReplaceChild("headwear_r20", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -3.1F, -1.6F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.6868F, -5.7261F, -3.5715F, -0.7854F, 0.0F, -1.0472F));
      Head.addOrReplaceChild("headwear_r21", CubeListBuilder.create().texOffs(8, 0).addBox(-1.05F, -2.3201F, -2.0669F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.1F, -8.4152F, 1.3171F, -2.3562F, 0.0F, -0.5236F));
      Head.addOrReplaceChild("headwear_r22", CubeListBuilder.create().texOffs(8, 0).addBox(-1.05F, -2.4586F, -1.4594F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-2.1F, -8.4152F, 0.3171F, -1.5708F, 0.0F, -0.5236F));
      Head.addOrReplaceChild("headwear_r23", CubeListBuilder.create().texOffs(8, 0).addBox(-1.05F, -3.0388F, -1.5388F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.1109F, -6.702F, -3.5715F, -0.7854F, 0.0F, -0.5236F));
      Head.addOrReplaceChild("headwear_r24", CubeListBuilder.create().texOffs(8, 0).addBox(-1.05F, -1.22F, -0.6331F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.1721F, -6.808F, -3.6019F, 0.3927F, 0.0F, -0.5236F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.6F)).texOffs(16, 16).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(1.0F)).texOffs(0, 0).addBox(0.5F, 0.7F, -3.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      Body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(19, 22).addBox(-3.0F, 0.25F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(1.05F)).texOffs(17, 20).addBox(-4.0F, -1.25F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(1.05F)), PartPose.offsetAndRotation(0.0F, -0.5441F, 3.8555F, 0.8727F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)).texOffs(40, 16).addBox(-3.0F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)).texOffs(40, 16).addBox(-1.0F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
      PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
      PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
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
