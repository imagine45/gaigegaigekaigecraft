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

public class Modelclothes_kirara<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_kirara"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;

   public Modelclothes_kirara(ModelPart root) {
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
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.01F)).m_171514_(32, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.51F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Head.m_171599_("headwear_r1", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.2054F, -4.7158F, 0.0378F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6373F, -1.1107F, 3.8089F, 1.2743F, 0.4754F, 0.1105F));
      Head.m_171599_("headwear_r2", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-0.1887F, -3.4395F, -1.2179F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.4686F, 4.5424F, 0.4605F, -0.1218F, -0.9242F));
      Head.m_171599_("headwear_r3", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6914F, -0.0765F, 3.6743F, 0.9846F, -1.2457F, -1.3612F));
      Head.m_171599_("headwear_r4", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.2846F, -3.2247F, -0.1043F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6373F, -1.1107F, 3.8089F, 0.7097F, 0.6961F, -0.4519F));
      Head.m_171599_("headwear_r5", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(1.1502F, 1.1239F, 4.7945F, 0.2663F, 0.3226F, -0.1122F));
      Head.m_171599_("headwear_r6", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171480_().m_171488_(-1.0413F, -4.1389F, -0.1147F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.6373F, -1.1107F, 3.8089F, 1.7546F, 0.6106F, 0.7003F));
      Head.m_171599_("headwear_r7", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-2.9587F, -4.1389F, -0.1147F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6373F, -1.1107F, 3.8089F, 1.7546F, -0.6106F, -0.7003F));
      Head.m_171599_("headwear_r8", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-1.1502F, 1.1239F, 4.7945F, 0.2663F, -0.3226F, 0.1122F));
      Head.m_171599_("headwear_r9", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-1.7154F, -3.2247F, -0.1043F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6373F, -1.1107F, 3.8089F, 0.7097F, -0.6961F, 0.4519F));
      Head.m_171599_("headwear_r10", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6914F, -0.0765F, 3.6743F, 0.9846F, 1.2457F, 1.3612F));
      Head.m_171599_("headwear_r11", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-3.8113F, -3.4395F, -1.2179F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 1.4686F, 4.5424F, 0.4605F, 0.1218F, 0.9242F));
      Head.m_171599_("headwear_r12", CubeListBuilder.m_171558_().m_171514_(56, 8).m_171488_(-1.7946F, -4.7158F, 0.0378F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.6373F, -1.1107F, 3.8089F, 1.2743F, -0.4754F, -0.1105F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(16, 32).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(19, 40).m_171488_(-4.0F, -1.05F, 2.7F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 7.7893F, -4.1999F, 0.7854F, 0.0F, 0.0F));
      Body.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(19, 37).m_171488_(-4.0F, -1.5F, 0.1F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 3.47F, -2.6F, -0.3927F, 0.0F, 0.0F));
      partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(48, 48).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(40, 32).m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
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
