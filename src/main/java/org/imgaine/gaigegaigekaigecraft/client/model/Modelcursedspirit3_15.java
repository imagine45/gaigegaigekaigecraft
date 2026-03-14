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

public class Modelcursedspirit3_15<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_15"), "main");
   public final ModelPart bone;
   public final ModelPart right_leg10;
   public final ModelPart right_leg9;
   public final ModelPart right_leg8;
   public final ModelPart right_leg7;
   public final ModelPart right_leg6;
   public final ModelPart right_leg5;
   public final ModelPart right_leg4;
   public final ModelPart right_leg3;
   public final ModelPart right_leg2;
   public final ModelPart right_leg1;
   public final ModelPart left_leg10;
   public final ModelPart left_leg9;
   public final ModelPart left_leg8;
   public final ModelPart left_leg7;
   public final ModelPart left_leg6;
   public final ModelPart left_leg5;
   public final ModelPart left_leg4;
   public final ModelPart left_leg3;
   public final ModelPart left_leg2;
   public final ModelPart left_leg1;

   public Modelcursedspirit3_15(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.right_leg10 = root.m_171324_("right_leg10");
      this.right_leg9 = root.m_171324_("right_leg9");
      this.right_leg8 = root.m_171324_("right_leg8");
      this.right_leg7 = root.m_171324_("right_leg7");
      this.right_leg6 = root.m_171324_("right_leg6");
      this.right_leg5 = root.m_171324_("right_leg5");
      this.right_leg4 = root.m_171324_("right_leg4");
      this.right_leg3 = root.m_171324_("right_leg3");
      this.right_leg2 = root.m_171324_("right_leg2");
      this.right_leg1 = root.m_171324_("right_leg1");
      this.left_leg10 = root.m_171324_("left_leg10");
      this.left_leg9 = root.m_171324_("left_leg9");
      this.left_leg8 = root.m_171324_("left_leg8");
      this.left_leg7 = root.m_171324_("left_leg7");
      this.left_leg6 = root.m_171324_("left_leg6");
      this.left_leg5 = root.m_171324_("left_leg5");
      this.left_leg4 = root.m_171324_("left_leg4");
      this.left_leg3 = root.m_171324_("left_leg3");
      this.left_leg2 = root.m_171324_("left_leg2");
      this.left_leg1 = root.m_171324_("left_leg1");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-3.0F, -6.5F, -16.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(-0.5F)).m_171514_(0, 23).m_171488_(-3.0F, -6.5F, 35.5F, 6.0F, 4.0F, 5.0F, new CubeDeformation(-0.5F)).m_171514_(0, 0).m_171488_(-4.0F, -7.0F, -13.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)).m_171514_(0, 11).m_171488_(-4.0F, -7.0F, -8.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -7.0F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)).m_171514_(0, 11).m_171488_(-4.0F, -7.0F, 2.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 11).m_171488_(-4.0F, -7.0F, 12.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.1F)).m_171514_(0, 11).m_171488_(-4.0F, -7.0F, 22.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.3F)).m_171514_(0, 0).m_171488_(-4.0F, -7.0F, 17.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.45F)).m_171514_(0, 0).m_171488_(-4.0F, -7.0F, 27.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.65F)).m_171514_(0, 11).m_171488_(-4.0F, -7.0F, 31.5F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.5F)).m_171514_(0, 0).m_171488_(-4.0F, -7.0F, 7.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-3.0445F, -3.0179F, -1.3505F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(0.0F, -4.0F, 41.0F, 1.4835F, 0.7854F, -2.9671F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-0.9555F, -3.0179F, -1.3505F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(0.0F, -4.0F, 41.0F, 1.4835F, -0.7854F, 2.9671F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(-1.0F, -5.0F, -16.0F, -1.4835F, -0.7854F, 0.1745F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(-0.1168F, -3.1148F, -15.9692F, -1.4835F, -0.5236F, 0.1745F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(0.1168F, -3.1148F, -15.9692F, -1.4835F, 0.5236F, -0.1745F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(1.0F, -5.0F, -16.0F, -1.4835F, 0.7854F, -0.1745F));
      PartDefinition right_leg10 = partdefinition.m_171599_("right_leg10", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 35.4619F));
      right_leg10.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg9 = partdefinition.m_171599_("right_leg9", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 30.4619F));
      right_leg9.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg8 = partdefinition.m_171599_("right_leg8", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 25.4619F));
      right_leg8.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg7 = partdefinition.m_171599_("right_leg7", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 20.4619F));
      right_leg7.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg6 = partdefinition.m_171599_("right_leg6", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 15.4619F));
      right_leg6.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.8437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg5 = partdefinition.m_171599_("right_leg5", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 10.4619F));
      right_leg5.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg4 = partdefinition.m_171599_("right_leg4", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 5.4619F));
      right_leg4.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg3 = partdefinition.m_171599_("right_leg3", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, 0.4619F));
      right_leg3.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg2 = partdefinition.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, -4.5381F));
      right_leg2.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition right_leg1 = partdefinition.m_171599_("right_leg1", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.3563F, 21.2366F, -9.5381F));
      right_leg1.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-2.2F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, -0.2618F));
      PartDefinition left_leg10 = partdefinition.m_171599_("left_leg10", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 35.4619F));
      left_leg10.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg9 = partdefinition.m_171599_("left_leg9", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 30.4619F));
      left_leg9.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg8 = partdefinition.m_171599_("left_leg8", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 25.4619F));
      left_leg8.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg7 = partdefinition.m_171599_("left_leg7", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 20.4619F));
      left_leg7.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg6 = partdefinition.m_171599_("left_leg6", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 15.4619F));
      left_leg6.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.8437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg5 = partdefinition.m_171599_("left_leg5", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 10.4619F));
      left_leg5.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg4 = partdefinition.m_171599_("left_leg4", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 5.4619F));
      left_leg4.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg3 = partdefinition.m_171599_("left_leg3", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, 0.4619F));
      left_leg3.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg2 = partdefinition.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, -4.5381F));
      left_leg2.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-2.1437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      PartDefinition left_leg1 = partdefinition.m_171599_("left_leg1", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.3563F, 21.2366F, -9.5381F));
      left_leg1.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.8F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.6437F, 0.7634F, -0.9619F, -0.3927F, 0.0F, 0.2618F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg10.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg9.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg8.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg7.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg6.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg5.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg4.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg10.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg9.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg8.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg7.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg6.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg5.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg4.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.right_leg10.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg1.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg9.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg7.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg8.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg1.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg5.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg6.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg4.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg4.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg5.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg6.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg7.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg8.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_leg9.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg10.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
