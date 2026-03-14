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

public class Modelcursedspirit1_1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_1_1"), "main");
   public final ModelPart body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit1_1(ModelPart root) {
      this.body = root.m_171324_("body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-9.0F, -15.2F, -9.0F, 18.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-9.0F, -13.2F, 0.0F, 18.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-8.0F, -20.2F, -8.0F, 16.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(42, 43).m_171488_(-3.5F, -27.0F, -8.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(42, 43).m_171488_(-3.5F, -11.0F, -7.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(2.1F)).m_171514_(4, 3).m_171488_(-3.5F, -22.0F, -8.1F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(50, 58).m_171488_(-2.5F, -13.2795F, -11.0229F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(-5.0F, -28.8F, -3.0F, 10.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(11, 35).m_171480_().m_171488_(-5.0F, -28.8F, -6.0F, 10.0F, 2.0F, 6.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(0, 0).m_171488_(-7.5F, -27.0F, -4.0F, 15.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(16, 37).m_171488_(-3.4F, -3.0F, 0.3F, 6.0F, 1.0F, 4.0F, new CubeDeformation(-0.12F)).m_171514_(48, 0).m_171488_(-2.4F, -1.5F, -0.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)).m_171514_(43, 32).m_171488_(-3.4F, -3.0F, 0.3F, 6.0F, 7.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(6.0F, -24.0F, -6.0F, 0.0F, -0.7854F, 0.0F));
      body.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(16, 37).m_171480_().m_171488_(-2.6F, -3.0F, 0.3F, 6.0F, 1.0F, 4.0F, new CubeDeformation(-0.12F)).m_171555_(false).m_171514_(43, 32).m_171480_().m_171488_(-2.6F, -3.0F, 0.3F, 6.0F, 7.0F, 4.0F, new CubeDeformation(-0.15F)).m_171555_(false).m_171514_(48, 0).m_171488_(-1.6F, -1.5F, -0.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-6.0F, -24.0F, -6.0F, 0.0F, 0.7854F, 0.0F));
      body.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(32, 54).m_171488_(-3.0F, -4.1F, -0.9F, 6.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -15.1773F, -9.8464F, -0.1745F, 0.0F, 0.0F));
      body.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(18, 56).m_171488_(-1.5F, -1.0F, -0.5F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, -24.0F, -8.0F, -0.2618F, 0.0F, 0.0F));
      body.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(2, 59).m_171480_().m_171488_(-5.5212F, -0.5899F, -1.6961F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.3F, -18.8636F, -9.1376F, -0.5236F, 0.2618F, 0.0F));
      body.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(2, 59).m_171480_().m_171488_(-5.0212F, 0.2646F, -3.5151F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.3F, -18.8636F, -9.1376F, -0.7854F, 0.2618F, 0.0F));
      body.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(2, 59).m_171488_(4.0212F, 0.2646F, -3.5151F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.3F, -18.8636F, -9.1376F, -0.7854F, -0.2618F, 0.0F));
      body.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(2, 59).m_171488_(3.5212F, -0.5899F, -1.6961F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.3F, -18.8636F, -9.1376F, -0.5236F, -0.2618F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-13.0464F, 8.4762F, -6.2387F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171480_().m_171488_(-4.9672F, -1.2224F, -1.6244F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-5.0916F, 5.7887F, 0.4145F, 2.5882F, -1.3721F, -1.0918F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171480_().m_171488_(-5.0492F, -1.8192F, -1.7624F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-5.0916F, 5.7887F, 0.4145F, 1.9138F, -1.0057F, -0.0575F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171480_().m_171488_(-5.2705F, -0.7455F, -1.6263F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-5.0916F, 5.7887F, 0.4145F, 1.9988F, -0.8572F, -0.1141F));
      RightArm.m_171599_("RightArm_r4", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171480_().m_171488_(-3.5661F, 1.0331F, -1.2166F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-5.0916F, 5.7887F, 0.4145F, 1.712F, -0.4286F, 0.4312F));
      RightArm.m_171599_("RightArm_r5", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171480_().m_171488_(-4.8487F, 0.0076F, -1.7498F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-5.0916F, 5.7887F, 0.4145F, 1.8733F, -0.7095F, 0.1621F));
      RightArm.m_171599_("RightArm_r6", CubeListBuilder.m_171558_().m_171514_(30, 48).m_171480_().m_171488_(-2.4901F, -2.2149F, -1.5673F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.0916F, 5.7887F, 0.4145F, 2.1856F, -0.8375F, -0.4082F));
      RightArm.m_171599_("RightArm_r7", CubeListBuilder.m_171558_().m_171514_(9, 1).m_171480_().m_171488_(0.5709F, -2.1696F, -2.9701F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.0916F, 5.7887F, 0.4145F, 2.3522F, -0.5452F, -0.6963F));
      RightArm.m_171599_("RightArm_r8", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-5.3F, -1.3F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.3F)).m_171555_(false), PartPose.m_171423_(3.7022F, -0.7982F, 6.2801F, -2.1524F, -0.1159F, -0.8272F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(13.0464F, 8.4762F, -6.2387F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171488_(0.9672F, -1.2224F, -1.6244F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(5.0916F, 5.7887F, 0.4145F, 2.5882F, 1.3721F, 1.0918F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171488_(2.0492F, -1.8192F, -1.7624F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(5.0916F, 5.7887F, 0.4145F, 1.9138F, 1.0057F, 0.0575F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171488_(1.2705F, -0.7455F, -1.6263F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(5.0916F, 5.7887F, 0.4145F, 1.9988F, 0.8572F, 0.1141F));
      LeftArm.m_171599_("LeftArm_r4", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171488_(-0.4339F, 1.0331F, -1.2166F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(5.0916F, 5.7887F, 0.4145F, 1.712F, 0.4286F, -0.4312F));
      LeftArm.m_171599_("LeftArm_r5", CubeListBuilder.m_171558_().m_171514_(32, 50).m_171488_(0.8487F, 0.0076F, -1.7498F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(5.0916F, 5.7887F, 0.4145F, 1.8733F, 0.7095F, -0.1621F));
      LeftArm.m_171599_("LeftArm_r6", CubeListBuilder.m_171558_().m_171514_(30, 48).m_171488_(-1.5099F, -2.2149F, -1.5673F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0916F, 5.7887F, 0.4145F, 2.1856F, 0.8375F, 0.4082F));
      LeftArm.m_171599_("LeftArm_r7", CubeListBuilder.m_171558_().m_171514_(9, 1).m_171488_(-8.5709F, -2.1696F, -2.9701F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0916F, 5.7887F, 0.4145F, 2.3522F, 0.5452F, 0.6963F));
      LeftArm.m_171599_("LeftArm_r8", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-5.7F, -1.3F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.m_171423_(-3.7022F, -0.7982F, 6.2801F, -2.1524F, 0.1159F, 0.8272F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 22.7F, 11.0F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(20, 38).m_171488_(-0.2688F, 3.842F, 0.7479F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171514_(20, 38).m_171488_(-0.2688F, 3.842F, 1.7479F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(20, 38).m_171488_(-0.2688F, 3.842F, -0.2521F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).m_171514_(20, 38).m_171488_(-0.2688F, 3.842F, -1.3521F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171514_(17, 35).m_171488_(-0.9688F, -0.158F, -1.2521F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(7.5911F, -5.4377F, -23.4399F, -0.1551F, 0.0803F, -1.4025F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(17, 35).m_171488_(-0.8065F, -3.7353F, -1.2521F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(7.5911F, -5.4377F, -23.4399F, -0.1008F, 0.1427F, -0.9235F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-7.3F, 1.0F, -1.0F, 10.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.3914F, -4.2267F, -19.3276F, 0.0F, 0.1309F, 1.9199F));
      RightLeg.m_171599_("RightLeg_r4", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-4.0F, -2.0F, -2.6F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-5.3914F, -4.2267F, -19.3276F, 0.0F, 0.3054F, 0.1309F));
      RightLeg.m_171599_("RightLeg_r5", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-8.5498F, -3.0176F, -1.2867F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.3911F, -5.1377F, -23.1399F, 0.0F, 0.1745F, -0.3054F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171423_(-6.246F, 16.7635F, -9.142F, 0.0F, 0.0873F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(20, 38).m_171480_().m_171488_(-0.7312F, 3.842F, 0.7479F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.02F)).m_171555_(false).m_171514_(20, 38).m_171480_().m_171488_(-0.7312F, 3.842F, 1.7479F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(20, 38).m_171480_().m_171488_(-0.7312F, 3.842F, -0.2521F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false).m_171514_(20, 38).m_171480_().m_171488_(-0.7312F, 3.842F, -1.3521F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(17, 35).m_171480_().m_171488_(-1.0312F, -0.158F, -1.2521F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.9451F, -0.0012F, -1.3979F, -0.1551F, -0.0803F, 1.4025F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(17, 35).m_171480_().m_171488_(-1.1935F, -3.7353F, -1.2521F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-1.9451F, -0.0012F, -1.3979F, -0.1008F, -0.1427F, 0.9235F));
      LeftLeg.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.7F, 1.0F, -1.0F, 10.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(11.6374F, 0.9097F, 2.4144F, 0.0F, -0.1309F, -1.9199F));
      LeftLeg.m_171599_("LeftLeg_r4", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171480_().m_171488_(-4.0F, -2.0F, -2.6F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(11.6374F, 0.9097F, 2.4144F, 0.0F, -0.3054F, -0.1309F));
      LeftLeg.m_171599_("LeftLeg_r5", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171480_().m_171488_(-1.4502F, -3.0176F, -1.2867F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.8549F, -0.0012F, -1.3979F, 0.0F, -0.1745F, 0.3054F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
