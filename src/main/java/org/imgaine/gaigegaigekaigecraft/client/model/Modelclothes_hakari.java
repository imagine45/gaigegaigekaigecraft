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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_hakari"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;

   public Modelclothes_hakari(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.RightLeg2 = root.m_171324_("RightLeg2");
      this.LeftLeg2 = root.m_171324_("LeftLeg2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.01F)).m_171514_(32, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.53F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Head.m_171599_("headwear_r1", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.0F, -1.5518F, -1.421F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, -8.9152F, 2.3171F, -2.3562F, 0.0F, 0.0F));
      Head.m_171599_("headwear_r2", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.0F, -2.4586F, -1.646F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(0.0F, -8.9152F, 0.3171F, -1.5708F, 0.0F, 0.0F));
      Head.m_171599_("headwear_r3", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.0F, -3.1F, -1.6F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, -6.9369F, -3.5715F, -0.7854F, 0.0F, 0.0F));
      Head.m_171599_("headwear_r4", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.0F, -1.3F, -0.6F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, -7.0594F, -3.6019F, 0.3927F, 0.0F, 0.0F));
      Head.m_171599_("headwear_r5", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-0.95F, -2.3201F, -2.0669F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(2.1F, -8.4152F, 1.3171F, -2.3562F, 0.0F, 0.5236F));
      Head.m_171599_("headwear_r6", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-0.95F, -2.4586F, -1.4594F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.4F)).m_171555_(false), PartPose.m_171423_(2.1F, -8.4152F, 0.3171F, -1.5708F, 0.0F, 0.5236F));
      Head.m_171599_("headwear_r7", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-0.95F, -3.0388F, -1.5388F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(1.1109F, -6.702F, -3.5715F, -0.7854F, 0.0F, 0.5236F));
      Head.m_171599_("headwear_r8", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-0.95F, -1.22F, -0.6331F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(1.1721F, -6.808F, -3.6019F, 0.3927F, 0.0F, 0.5236F));
      Head.m_171599_("headwear_r9", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.0F, -2.2589F, -2.1281F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(3.4F, -6.7152F, 1.3171F, -2.3562F, 0.0F, 1.0472F));
      Head.m_171599_("headwear_r10", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.0F, -2.4586F, -1.446F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171423_(3.4F, -6.7152F, 0.3171F, -1.5708F, 0.0F, 1.0472F));
      Head.m_171599_("headwear_r11", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.0F, -3.1F, -1.6F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(1.6868F, -5.7261F, -3.5715F, -0.7854F, 0.0F, 1.0472F));
      Head.m_171599_("headwear_r12", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.4981F, -2.9847F, -2.6656F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(3.2768F, -4.5152F, 0.4239F, -2.3562F, 0.0F, 1.4835F));
      Head.m_171599_("headwear_r13", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.4981F, -2.3519F, -1.3128F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171423_(3.2768F, -4.5152F, 0.4239F, -1.5708F, 0.0F, 1.4835F));
      Head.m_171599_("headwear_r14", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-1.4981F, 1.2182F, -2.9321F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(3.2768F, -4.5152F, 0.4239F, -0.7854F, 0.0F, 1.4835F));
      Head.m_171599_("headwear_r15", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-0.5019F, -2.9847F, -2.6656F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-3.2768F, -4.5152F, 0.4239F, -2.3562F, 0.0F, -1.4835F));
      Head.m_171599_("headwear_r16", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-0.5019F, -2.3519F, -1.3128F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.m_171423_(-3.2768F, -4.5152F, 0.4239F, -1.5708F, 0.0F, -1.4835F));
      Head.m_171599_("headwear_r17", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-0.5019F, 1.2182F, -2.9321F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-3.2768F, -4.5152F, 0.4239F, -0.7854F, 0.0F, -1.4835F));
      Head.m_171599_("headwear_r18", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.0F, -2.2589F, -2.1281F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-3.4F, -6.7152F, 1.3171F, -2.3562F, 0.0F, -1.0472F));
      Head.m_171599_("headwear_r19", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.0F, -2.4586F, -1.446F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.m_171423_(-3.4F, -6.7152F, 0.3171F, -1.5708F, 0.0F, -1.0472F));
      Head.m_171599_("headwear_r20", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.0F, -3.1F, -1.6F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-1.6868F, -5.7261F, -3.5715F, -0.7854F, 0.0F, -1.0472F));
      Head.m_171599_("headwear_r21", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.05F, -2.3201F, -2.0669F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-2.1F, -8.4152F, 1.3171F, -2.3562F, 0.0F, -0.5236F));
      Head.m_171599_("headwear_r22", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.05F, -2.4586F, -1.4594F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(-2.1F, -8.4152F, 0.3171F, -1.5708F, 0.0F, -0.5236F));
      Head.m_171599_("headwear_r23", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.05F, -3.0388F, -1.5388F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-1.1109F, -6.702F, -3.5715F, -0.7854F, 0.0F, -0.5236F));
      Head.m_171599_("headwear_r24", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.05F, -1.22F, -0.6331F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-1.1721F, -6.808F, -3.6019F, 0.3927F, 0.0F, -0.5236F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.6F)).m_171514_(16, 16).m_171488_(-4.0F, 2.0F, -2.0F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.3F)).m_171514_(16, 16).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(1.0F)).m_171514_(0, 0).m_171488_(0.5F, 0.7F, -3.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(19, 22).m_171488_(-3.0F, 0.25F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(1.05F)).m_171514_(17, 20).m_171488_(-4.0F, -1.25F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(1.05F)), PartPose.m_171423_(0.0F, -0.5441F, 3.8555F, 0.8727F, 0.0F, 0.0F));
      partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)).m_171514_(40, 16).m_171488_(-3.0F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)).m_171514_(40, 16).m_171488_(-1.0F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      PartDefinition RightLeg2 = partdefinition.m_171599_("RightLeg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      PartDefinition LeftLeg2 = partdefinition.m_171599_("LeftLeg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
