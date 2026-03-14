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

public class Modelclothes_nishimiya<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_nishimiya"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;

   public Modelclothes_nishimiya(ModelPart root) {
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
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171480_().m_171488_(-4.4888F, 0.8757F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(22, 10).m_171480_().m_171488_(-4.4888F, -1.1243F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(28, 25).m_171480_().m_171488_(-2.0921F, -1.1199F, -1.4538F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(21, 9).m_171480_().m_171488_(-3.5921F, -1.1199F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(18, 8).m_171480_().m_171488_(-1.8752F, -1.6297F, -1.9538F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)).m_171555_(false).m_171514_(21, 9).m_171480_().m_171488_(3.0248F, -1.1297F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(16, 8).m_171480_().m_171488_(-0.5752F, -1.6297F, -1.9538F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, 0.6981F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171480_().m_171488_(-5.2304F, 0.0523F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-6.4987F, -10.1935F, -0.0462F, 1.5708F, 0.2182F, 0.6981F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171480_().m_171488_(-4.7276F, -1.2063F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, -0.0873F));
      Head.m_171599_("Head_r4", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171480_().m_171488_(-5.2801F, -0.8812F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-6.4987F, -10.1935F, -0.0462F, 1.5708F, -0.2618F, 0.6981F));
      Head.m_171599_("Head_r5", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171480_().m_171488_(-4.4339F, 0.4862F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, 1.3526F));
      Head.m_171599_("Head_r6", CubeListBuilder.m_171558_().m_171514_(28, 25).m_171488_(1.0921F, -1.1199F, -1.4538F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171514_(22, 10).m_171488_(1.4888F, 0.8757F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(22, 10).m_171488_(1.4888F, -1.1243F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(21, 9).m_171488_(1.5921F, -1.1199F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(21, 9).m_171488_(-5.0248F, -1.1297F, -1.4538F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(18, 8).m_171488_(-1.1248F, -1.6297F, -1.9538F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)).m_171514_(16, 8).m_171488_(-3.4248F, -1.6297F, -1.9538F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, -0.6981F));
      Head.m_171599_("Head_r7", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171488_(1.7276F, -1.2063F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, 0.0873F));
      Head.m_171599_("Head_r8", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171488_(2.2304F, 0.0523F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.4987F, -10.1935F, -0.0462F, 1.5708F, -0.2182F, -0.6981F));
      Head.m_171599_("Head_r9", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171488_(2.2801F, -0.8812F, -1.4338F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.4987F, -10.1935F, -0.0462F, 1.5708F, 0.2618F, -0.6981F));
      Head.m_171599_("Head_r10", CubeListBuilder.m_171558_().m_171514_(22, 10).m_171488_(1.4339F, 0.4862F, -0.9538F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.4987F, -10.1935F, -0.0462F, 0.0F, 0.0F, -1.3526F));
      partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(24, 16).m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("RightLeg2", CubeListBuilder.m_171558_().m_171514_(16, 32).m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("LeftLeg2", CubeListBuilder.m_171558_().m_171514_(16, 32).m_171480_().m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
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
