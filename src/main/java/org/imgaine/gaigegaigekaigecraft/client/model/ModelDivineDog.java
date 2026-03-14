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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelDivineDog<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_divine_dog"), "main");
   public final ModelPart Head;
   public final ModelPart NeckHair;
   public final ModelPart BodyMain;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart Tail;

   public ModelDivineDog(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.NeckHair = root.m_171324_("NeckHair");
      this.BodyMain = root.m_171324_("BodyMain");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.Tail = root.m_171324_("Tail");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171488_(-1.6131F, -2.6F, -3.2685F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-0.6131F, -1.5F, -6.0685F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(10, 0).m_171488_(-1.1131F, -1.2F, -5.7685F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 28).m_171488_(-1.1131F, 0.5F, -5.2685F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171419_(0.1131F, 9.6F, -10.7315F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171480_().m_171488_(-0.2F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.2869F, -3.1F, -0.7685F, -0.2182F, 0.0F, 0.2182F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171488_(-1.8F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-0.5131F, -3.1F, -0.7685F, -0.2182F, 0.0F, -0.2182F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.4262F, -19.973F, -14.8042F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.3131F, 2.473F, 19.9357F, 0.7854F, 0.0F, 0.0F));
      PartDefinition NeckHair = partdefinition.m_171599_("NeckHair", CubeListBuilder.m_171558_(), PartPose.m_171419_(20.6985F, 3.1893F, -4.526F));
      NeckHair.m_171599_("BodyMain_r1", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.5F, -2.4F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-20.6985F, 10.3287F, -7.2363F, -1.5272F, 0.0F, 0.0F));
      NeckHair.m_171599_("BodyMain_r2", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-20.6985F, 5.4924F, -6.8375F, -0.3055F, 0.4929F, 2.6897F));
      NeckHair.m_171599_("BodyMain_r3", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-24.1011F, 8.4737F, -4.8213F, -0.7167F, 0.4882F, 1.4423F));
      NeckHair.m_171599_("BodyMain_r4", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-20.6985F, 5.4924F, -5.8375F, -0.5856F, 0.5567F, 1.9062F));
      NeckHair.m_171599_("BodyMain_r5", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-17.2958F, 8.4737F, -4.8213F, -0.7167F, -0.4882F, -1.4423F));
      NeckHair.m_171599_("BodyMain_r6", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-20.6985F, 5.4924F, -5.8375F, -0.5856F, -0.5567F, -1.9062F));
      NeckHair.m_171599_("BodyMain_r7", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-20.6985F, 5.4924F, -6.8375F, -0.8384F, 0.6142F, 1.7659F));
      NeckHair.m_171599_("BodyMain_r8", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-24.1011F, 8.4737F, -5.8213F, -0.9572F, 0.4483F, 1.3333F));
      NeckHair.m_171599_("BodyMain_r9", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171480_().m_171488_(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-23.2324F, 9.4081F, -7.318F, -1.3573F, 0.4969F, 0.6107F));
      NeckHair.m_171599_("BodyMain_r10", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-18.1646F, 9.4081F, -7.318F, -1.3573F, -0.4969F, -0.6107F));
      NeckHair.m_171599_("BodyMain_r11", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-17.2958F, 8.4737F, -5.8213F, -0.9572F, -0.4483F, -1.3333F));
      NeckHair.m_171599_("BodyMain_r12", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 1.4476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-20.6985F, 5.4924F, -6.8375F, -0.0873F, 0.0F, -3.1416F));
      NeckHair.m_171599_("BodyMain_r13", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-20.6985F, 5.4924F, -6.8375F, -0.8384F, -0.6142F, -1.7659F));
      NeckHair.m_171599_("BodyMain_r14", CubeListBuilder.m_171558_().m_171514_(16, 9).m_171488_(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-20.6985F, 5.4924F, -6.8375F, -0.3055F, -0.4929F, -2.6897F));
      PartDefinition BodyMain = partdefinition.m_171599_("BodyMain", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.5F, -15.5F, -1.0F, 5.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(1, 16).m_171488_(-2.5F, -15.5F, -8.0F, 5.0F, 7.0F, 9.0F, new CubeDeformation(0.2F)).m_171514_(0, 20).m_171488_(-3.5F, -15.0F, -9.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).m_171514_(0, 20).m_171488_(-3.0F, -14.0F, -6.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).m_171514_(8, 23).m_171488_(-2.0F, -15.5F, -10.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(0.0F, 25.0F, 0.0F));
      BodyMain.m_171599_("BodyMain_r15", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-2.5F, -2.5F, -3.5F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5F, -14.1998F, -8.3884F, -0.5236F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171480_().m_171488_(-0.6F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171419_(-2.8F, 12.3249F, -7.6021F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.5F, -5.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.0F, -2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.4F, 5.5664F, 2.4562F, 0.3927F, 0.0F, 0.0F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.4F, 9.6751F, 1.6021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171488_(-1.4F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(2.8F, 12.3249F, -7.6021F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.5F, -5.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.0F, -2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.4F, 5.5664F, 2.4562F, 0.3927F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 9.6751F, 1.6021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171480_().m_171488_(-0.6F, 10.6751F, -0.2979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171419_(-2.8F, 12.3249F, 5.0979F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.5F, -6.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.0F, -3.0F, -2.4F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.4F, 5.92F, 3.5168F, 0.3927F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-1.0F, -4.7F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.4F, 9.6751F, 1.7021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(22, 3).m_171488_(-1.4F, 10.6751F, -0.2979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(2.8F, 12.3249F, 5.0979F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.5F, -6.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.0F, -3.0F, -2.4F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.4F, 5.92F, 3.5168F, 0.3927F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r3", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-1.0F, -4.7F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 9.6751F, 1.7021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition Tail = partdefinition.m_171599_("Tail", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.1F, 9.1766F, 8.8331F));
      Tail.m_171599_("Tail_r1", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-1.0F, -1.7247F, 0.613F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).m_171514_(0, 24).m_171488_(-1.0F, -1.7247F, -4.387F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.1F, 3.6481F, 2.9539F, -0.3927F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.NeckHair.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.BodyMain.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.f_104204_ = netHeadYaw / 57.295776F;
      this.Head.f_104203_ = headPitch / 57.295776F;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.Tail.f_104204_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
