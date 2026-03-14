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

public class Modelcursedspirit3_3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_3"), "main");
   public final ModelPart Head;
   public final ModelPart Tail;
   public final ModelPart FinDorsal;
   public final ModelPart FinVentral;
   public final ModelPart BodyMain;

   public Modelcursedspirit3_3(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Tail = root.m_171324_("Tail");
      this.FinDorsal = root.m_171324_("FinDorsal");
      this.FinVentral = root.m_171324_("FinVentral");
      this.BodyMain = root.m_171324_("BodyMain");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 8.1707F, -4.037F));
      PartDefinition HeadMain = Head.m_171599_("HeadMain", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-1.0F, 1.4054F, -6.5612F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-1.0F, -0.2F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-0.5F, -0.2F, -11.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-0.5F, 1.4175F, -9.1891F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-0.5F, 1.4175F, -10.1891F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.085F, -0.3209F));
      HeadMain.m_171599_("HeadMain_r1", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-2.0F, -1.5F, -3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-1.0F, -1.5F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-1.0F, -1.5F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(7, 24).m_171480_().m_171488_(-1.5F, -1.5F, -5.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
      HeadMain.m_171599_("HeadMain_r2", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171488_(-0.0733F, -0.4976F, -2.412F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 1.915F, -6.6791F, 0.0F, 0.1745F, 0.0F));
      HeadMain.m_171599_("HeadMain_r3", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-0.9267F, -0.4976F, -2.412F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.915F, -6.6791F, 0.0F, -0.1745F, 0.0F));
      HeadMain.m_171599_("HeadMain_r4", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171488_(-0.7F, -0.9F, -0.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, -0.1495F, -4.0284F, 0.0873F, -0.2618F, 0.0F));
      HeadMain.m_171599_("HeadMain_r5", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-0.3F, -0.9F, -0.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.0F, -0.1495F, -4.0284F, 0.0873F, 0.2618F, 0.0F));
      HeadMain.m_171599_("HeadMain_r6", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-0.6F, -0.5F, -1.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.2075F, -0.0773F, -9.4692F, 0.0873F, -0.1309F, 0.0F));
      HeadMain.m_171599_("HeadMain_r7", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171488_(-0.4F, -0.5F, -1.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.2075F, -0.0773F, -9.4692F, 0.0873F, 0.1309F, 0.0F));
      HeadMain.m_171599_("HeadMain_r8", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-1.5F, -0.4F, -1.3F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.9054F, -2.4612F, -0.0873F, 0.0F, 0.0F));
      HeadMain.m_171599_("HeadMain_r9", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-1.0F, -0.5F, -5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5F, 1.3275F, -0.567F, -0.3927F, 0.0F, 0.0F));
      HeadMain.m_171599_("HeadMain_r10", CubeListBuilder.m_171558_().m_171514_(7, 24).m_171480_().m_171488_(-1.0F, -0.5F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5F, 0.7578F, -1.6346F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Eye = Head.m_171599_("Eye", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.3F, 0.085F, -0.6209F));
      Eye.m_171599_("Eye_r1", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171480_().m_171488_(-3.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.4363F));
      Eye.m_171599_("Eye_r2", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171488_(1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-0.6F, 0.0F, 0.0F, 0.0F, -0.0873F, -0.4363F));
      PartDefinition Tail = partdefinition.m_171599_("Tail", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 9.0F, 5.0F));
      PartDefinition Tail1 = Tail.m_171599_("Tail1", CubeListBuilder.m_171558_().m_171514_(6, 23).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, -0.25F, 0.5F));
      Tail1.m_171599_("Tail1_r1", CubeListBuilder.m_171558_().m_171514_(22, -2).m_171480_().m_171488_(0.0F, 6.0F, -0.8F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -4.75F, -2.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition Tail2 = Tail1.m_171599_("Tail2", CubeListBuilder.m_171558_().m_171514_(9, 26).m_171480_().m_171488_(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(16, 16).m_171480_().m_171488_(-1.0F, -1.5F, 1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171419_(0.0F, -0.25F, 3.5F));
      PartDefinition FinCaudal = Tail2.m_171599_("FinCaudal", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.175F, 2.5584F));
      FinCaudal.m_171599_("FinCaudal_r1", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171480_().m_171488_(0.0F, -1.5895F, -3.134F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.7653F, 2.7195F, -1.0908F, 0.0F, 0.0F));
      FinCaudal.m_171599_("FinCaudal_r2", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171488_(0.8767F, -2.7412F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 1.7653F, 2.7195F, -0.5236F, 0.2182F, -0.3927F));
      FinCaudal.m_171599_("FinCaudal_r3", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171480_().m_171488_(-0.8767F, -2.7412F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.7653F, 2.7195F, -0.5236F, -0.2182F, 0.3927F));
      FinCaudal.m_171599_("FinCaudal_r4", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171488_(0.8767F, -2.2588F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.7653F, 2.7195F, 0.5236F, 0.2182F, 0.3927F));
      FinCaudal.m_171599_("FinCaudal_r5", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171480_().m_171488_(0.0F, -3.4105F, -3.134F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.7653F, 2.7195F, 1.0908F, 0.0F, 0.0F));
      FinCaudal.m_171599_("FinCaudal_r6", CubeListBuilder.m_171558_().m_171514_(0, -3).m_171480_().m_171488_(-0.8767F, -2.2588F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.7653F, 2.7195F, 0.5236F, -0.2182F, -0.3927F));
      PartDefinition FinDorsal = partdefinition.m_171599_("FinDorsal", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.5F, 6.3381F, -0.0315F));
      FinDorsal.m_171599_("FinDorsal_r1", CubeListBuilder.m_171558_().m_171514_(6, -9).m_171480_().m_171488_(0.0F, -2.5F, -4.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3927F, -0.2182F, -0.3927F));
      FinDorsal.m_171599_("FinDorsal_r2", CubeListBuilder.m_171558_().m_171514_(6, -9).m_171480_().m_171488_(0.0F, -2.5F, -4.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.5F, -2.2304F, -0.9239F, 0.9163F, 0.0F, 0.0F));
      FinDorsal.m_171599_("FinDorsal_r3", CubeListBuilder.m_171558_().m_171514_(6, -9).m_171488_(0.0F, -2.5F, -4.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, 0.0F, 0.0F, 0.3927F, 0.2182F, 0.3927F));
      PartDefinition FinVentral = partdefinition.m_171599_("FinVentral", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.0F, 25.5F, 3.0F));
      PartDefinition RightFinVentral = FinVentral.m_171599_("RightFinVentral", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.2154F, -14.9618F, -5.6485F));
      RightFinVentral.m_171599_("RightFinVentral_r1", CubeListBuilder.m_171558_().m_171514_(24, -4).m_171488_(0.0267F, -2.6016F, -2.1649F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4998F, -2.0E-4F, 0.9976F, -0.3491F, -0.7854F, 0.0F));
      RightFinVentral.m_171599_("RightFinVentral_r2", CubeListBuilder.m_171558_().m_171514_(24, -4).m_171488_(-0.0563F, -1.5252F, -1.5984F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.4998F, -2.0E-4F, 0.9976F, -0.7418F, -1.0036F, -0.0436F));
      PartDefinition LeftFinVentral = FinVentral.m_171599_("LeftFinVentral", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.2154F, -14.9618F, -5.6485F));
      LeftFinVentral.m_171599_("LeftFinVentral_r1", CubeListBuilder.m_171558_().m_171514_(24, -4).m_171480_().m_171488_(-0.0267F, -2.6016F, -2.1649F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.4998F, -2.0E-4F, 0.9976F, -0.3491F, 0.7854F, 0.0F));
      LeftFinVentral.m_171599_("LeftFinVentral_r2", CubeListBuilder.m_171558_().m_171514_(24, -4).m_171480_().m_171488_(0.0563F, -1.5252F, -1.5984F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.4998F, -2.0E-4F, 0.9976F, -0.7418F, 1.0036F, 0.0436F));
      partdefinition.m_171599_("BodyMain", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171480_().m_171488_(-3.5F, -19.5F, -6.5F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(1.0F, 26.0F, 3.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.FinDorsal.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.FinVentral.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.BodyMain.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Tail.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
