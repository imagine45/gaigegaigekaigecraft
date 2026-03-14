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

public class Modelclothes_naobito<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_naobito"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg2;
   public final ModelPart LeftLeg2;

   public Modelclothes_naobito(ModelPart root) {
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
      partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(1, 21).m_171488_(-0.5F, -1.5F, 0.2F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)), PartPose.m_171423_(4.2971F, 13.1371F, 2.0F, -0.1745F, -2.1817F, 0.0F));
      Body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(1, 21).m_171488_(-2.0F, -0.7F, 4.24F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)), PartPose.m_171423_(0.0F, 13.154F, -0.5F, 0.1745F, 1.5708F, 0.0F));
      Body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(1, 21).m_171488_(-0.5F, -1.5F, -0.2F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)), PartPose.m_171423_(4.2971F, 13.1371F, -2.0F, 0.1745F, 2.1817F, 0.0F));
      Body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(1, 21).m_171480_().m_171488_(-0.5F, -1.5F, 0.2F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)).m_171555_(false), PartPose.m_171423_(-4.2971F, 13.1371F, 2.0F, -0.1745F, 2.1817F, 0.0F));
      Body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(1, 21).m_171480_().m_171488_(-0.5F, -1.5F, -0.2F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)).m_171555_(false), PartPose.m_171423_(-4.2971F, 13.1371F, -2.0F, 0.1745F, -2.1817F, 0.0F));
      Body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(1, 21).m_171480_().m_171488_(-1.0F, -0.7F, 4.24F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)).m_171555_(false), PartPose.m_171423_(0.0F, 13.154F, -0.5F, 0.1745F, -1.5708F, 0.0F));
      Body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171480_().m_171488_(-4.0F, -1.5F, 0.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)).m_171555_(false), PartPose.m_171423_(0.0F, 13.154F, 2.296F, -0.1745F, 0.0F, -3.1416F));
      Body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(4, 1).m_171488_(-4.0F, -1.1F, -0.23F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.22F)), PartPose.m_171423_(0.0F, 12.8F, -2.0F, -0.1745F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      RightArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(7, 17).m_171480_().m_171488_(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.0071F, 3.883F, 1.0436F, 2.7794F, -0.7519F, -2.8883F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(7, 17).m_171488_(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0071F, 3.883F, 1.0436F, 2.7794F, 0.7519F, 2.8883F));
      partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("RightLeg2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("LeftLeg2", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171480_().m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
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
