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

public class Modelclothes_uraume<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_uraume"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg_leggins;
   public final ModelPart left_leg_leggins;
   public final ModelPart right_leg_boot;
   public final ModelPart left_leg_boot;
   public final ModelPart steve;

   public Modelclothes_uraume(ModelPart root) {
      this.head = root.m_171324_("head");
      this.body = root.m_171324_("body");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.right_leg_leggins = root.m_171324_("right_leg_leggins");
      this.left_leg_leggins = root.m_171324_("left_leg_leggins");
      this.right_leg_boot = root.m_171324_("right_leg_boot");
      this.left_leg_boot = root.m_171324_("left_leg_boot");
      this.steve = root.m_171324_("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F)).m_171514_(32, 32).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.45F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(15, 15).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 32).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.261F)).m_171514_(54, 53).m_171488_(3.0F, 0.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.301F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171480_().m_171488_(-6.0398F, -4.7158F, -3.0722F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171423_(-2.6398F, 10.9373F, -0.5F, 3.0543F, 0.0F, 3.0543F));
      body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171480_().m_171488_(-0.9602F, -4.7158F, -3.0722F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171423_(-2.6398F, 10.9373F, 0.5F, -0.0873F, 0.0F, -0.0873F));
      body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171480_().m_171488_(-4.0F, -2.7443F, -2.9227F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.261F)).m_171555_(false), PartPose.m_171423_(0.3386F, 14.6921F, 0.0F, 3.0543F, 0.0F, 3.098F));
      body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171488_(0.1784F, -4.5719F, -5.0697F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.m_171423_(-0.3F, 10.5373F, 0.5F, -0.0873F, -0.8727F, 0.0F));
      body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(49, 52).m_171488_(-1.5F, -4.5552F, -5.2608F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.m_171423_(-0.3F, 10.5373F, 0.0F, 0.0F, -1.5708F, -0.0873F));
      body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171480_().m_171488_(0.1784F, -4.5719F, 5.0697F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171423_(-0.3F, 10.5373F, -0.5F, 0.0873F, 0.8727F, 0.0F));
      body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171488_(0.6809F, -5.9138F, 0.9857F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.m_171423_(-4.4495F, 11.9239F, 0.0F, 0.1237F, -0.8572F, -0.0324F));
      body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171480_().m_171488_(0.6809F, -5.9138F, -0.9857F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171423_(-4.4495F, 11.9239F, 0.0F, -0.0495F, 0.8875F, 0.0244F));
      body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(49, 52).m_171480_().m_171488_(-1.5F, -5.9719F, -0.3213F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171423_(-4.4495F, 11.9239F, 0.0F, 2.0496F, 1.5426F, 2.1322F));
      body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(48, 52).m_171480_().m_171488_(-4.0F, -2.7443F, -2.9227F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.261F)).m_171555_(false), PartPose.m_171423_(0.3386F, 14.6921F, 0.0F, -0.0873F, 0.0F, -0.0436F));
      body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(54, 55).m_171488_(-0.5F, -1.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.291F)), PartPose.m_171423_(3.129F, 3.9698F, 0.0F, 0.0F, 0.0F, 0.2618F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(41, 15).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 48).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      right_arm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(10, 49).m_171480_().m_171488_(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.0071F, 3.883F, 1.0436F, 2.7794F, -0.7519F, -2.8883F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(41, 15).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 32).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      left_arm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(42, 32).m_171488_(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0071F, 3.883F, 1.0436F, 2.7794F, 0.7519F, 2.8883F));
      PartDefinition right_leg_leggins = partdefinition.m_171599_("right_leg_leggins", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(32, 18).m_171488_(-1.8352F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)).m_171514_(48, 0).m_171488_(-1.8352F, 7.7352F, -1.9F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.34F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r1", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-4.3187F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(4.0233F, 12.4681F, -5.1187F, 0.0F, 1.5708F, 0.1309F));
      right_leg_leggins.m_171599_("right_leg_leggins_r2", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-5.1059F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.5415F, 12.2139F, -4.1669F, -0.1396F, 0.7854F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r3", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-1.0422F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171514_(37, 1).m_171488_(-3.7F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r4", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.6363F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.3624F, 12.2139F, -1.5208F, -0.1396F, -0.7854F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r5", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.4234F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-3.7654F, 12.4681F, -1.3766F, 0.0F, -1.5708F, -0.1309F));
      right_leg_leggins.m_171599_("right_leg_leggins_r6", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.6363F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.3624F, 12.2139F, 1.5208F, 0.1396F, 0.7854F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r7", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.0718F, -11.3883F, 7.3117F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(37, 1).m_171488_(-0.4234F, -11.3883F, 7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-3.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      right_leg_leggins.m_171599_("right_leg_leggins_r8", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-1.9282F, -10.8844F, 11.0539F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(7.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      right_leg_leggins.m_171599_("right_leg_leggins_r9", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-2.3999F, -11.8344F, 1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r10", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-3.7F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171514_(37, 1).m_171488_(-1.0422F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r11", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-5.1059F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.5415F, 12.2139F, 4.1669F, 0.1396F, -0.7854F, 0.0F));
      right_leg_leggins.m_171599_("right_leg_leggins_r12", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-4.3187F, -11.3883F, 7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(4.0233F, 12.4681F, 5.1187F, 0.0F, -1.5708F, 0.1309F));
      right_leg_leggins.m_171599_("right_leg_leggins_r13", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.8882F, -11.8344F, -1.9915F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(37, 0).m_171488_(-2.3999F, -11.8344F, -1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      PartDefinition left_leg_leggins = partdefinition.m_171599_("left_leg_leggins", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 18).m_171480_().m_171488_(-2.1648F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)).m_171555_(false).m_171514_(48, 0).m_171480_().m_171488_(-2.1648F, 7.7352F, -1.9F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.34F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r1", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.3187F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-4.0233F, 12.4681F, -5.1187F, 0.0F, -1.5708F, -0.1309F));
      left_leg_leggins.m_171599_("left_leg_leggins_r2", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.1059F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.5415F, 12.2139F, -4.1669F, -0.1396F, -0.7854F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r3", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(0.0422F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(37, 1).m_171480_().m_171488_(2.7F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r4", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-1.3637F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.3624F, 12.2139F, -1.5208F, -0.1396F, 0.7854F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r5", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-0.5766F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(3.7654F, 12.4681F, -1.3766F, 0.0F, 1.5708F, 0.1309F));
      left_leg_leggins.m_171599_("left_leg_leggins_r6", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-1.3637F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.3624F, 12.2139F, 1.5208F, 0.1396F, -0.7854F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r7", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-1.9282F, -11.3883F, 7.3117F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      left_leg_leggins.m_171599_("left_leg_leggins_r8", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-0.0718F, -10.8844F, 11.0539F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-7.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      left_leg_leggins.m_171599_("left_leg_leggins_r9", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(0.3999F, -11.8344F, 1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r10", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(2.7F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(37, 1).m_171480_().m_171488_(0.0422F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r11", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.1059F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.5415F, 12.2139F, 4.1669F, 0.1396F, 0.7854F, 0.0F));
      left_leg_leggins.m_171599_("left_leg_leggins_r12", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.3187F, -11.3883F, 7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-4.0233F, 12.4681F, 5.1187F, 0.0F, 1.5708F, -0.1309F));
      left_leg_leggins.m_171599_("left_leg_leggins_r13", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-0.1118F, -11.8344F, -1.9915F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(37, 0).m_171480_().m_171488_(0.3999F, -11.8344F, -1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      partdefinition.m_171599_("right_leg_boot", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 20).m_171488_(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).m_171514_(0, 20).m_171488_(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171514_(0, 20).m_171488_(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171514_(0, 15).m_171488_(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).m_171514_(0, 15).m_171488_(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).m_171514_(0, 15).m_171488_(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("left_leg_boot", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 20).m_171480_().m_171488_(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).m_171555_(false).m_171514_(0, 20).m_171480_().m_171488_(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171555_(false).m_171514_(0, 20).m_171480_().m_171488_(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("steve", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(40, 16).m_171480_().m_171488_(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(40, 16).m_171488_(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171480_().m_171488_(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 16).m_171488_(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg_leggins.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg_leggins.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg_boot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg_boot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
