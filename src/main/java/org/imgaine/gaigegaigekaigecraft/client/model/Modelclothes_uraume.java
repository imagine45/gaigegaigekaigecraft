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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_uraume"), "main");
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
      this.head = root.getChild("head");
      this.body = root.getChild("body");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
      this.right_leg_leggins = root.getChild("right_leg_leggins");
      this.left_leg_leggins = root.getChild("left_leg_leggins");
      this.right_leg_boot = root.getChild("right_leg_boot");
      this.left_leg_boot = root.getChild("left_leg_boot");
      this.steve = root.getChild("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F)).texOffs(32, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.45F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(15, 15).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.261F)).texOffs(54, 53).addBox(3.0F, 0.0F, -2.0F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.301F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(-6.0398F, -4.7158F, -3.0722F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-2.6398F, 10.9373F, -0.5F, 3.0543F, 0.0F, 3.0543F));
      body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(-0.9602F, -4.7158F, -3.0722F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-2.6398F, 10.9373F, 0.5F, -0.0873F, 0.0F, -0.0873F));
      body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(-4.0F, -2.7443F, -2.9227F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.261F)).mirror(false), PartPose.offsetAndRotation(0.3386F, 14.6921F, 0.0F, 3.0543F, 0.0F, 3.098F));
      body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(48, 52).addBox(0.1784F, -4.5719F, -5.0697F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(-0.3F, 10.5373F, 0.5F, -0.0873F, -0.8727F, 0.0F));
      body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(49, 52).addBox(-1.5F, -4.5552F, -5.2608F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(-0.3F, 10.5373F, 0.0F, 0.0F, -1.5708F, -0.0873F));
      body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(0.1784F, -4.5719F, 5.0697F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-0.3F, 10.5373F, -0.5F, 0.0873F, 0.8727F, 0.0F));
      body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(48, 52).addBox(0.6809F, -5.9138F, 0.9857F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(-4.4495F, 11.9239F, 0.0F, 0.1237F, -0.8572F, -0.0324F));
      body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(0.6809F, -5.9138F, -0.9857F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-4.4495F, 11.9239F, 0.0F, -0.0495F, 0.8875F, 0.0244F));
      body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(49, 52).mirror().addBox(-1.5F, -5.9719F, -0.3213F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offsetAndRotation(-4.4495F, 11.9239F, 0.0F, 2.0496F, 1.5426F, 2.1322F));
      body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(-4.0F, -2.7443F, -2.9227F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.261F)).mirror(false), PartPose.offsetAndRotation(0.3386F, 14.6921F, 0.0F, -0.0873F, 0.0F, -0.0436F));
      body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(54, 55).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.291F)), PartPose.offsetAndRotation(3.129F, 3.9698F, 0.0F, 0.0F, 0.0F, 0.2618F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(41, 15).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      right_arm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(10, 49).mirror().addBox(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0071F, 3.883F, 1.0436F, 2.7794F, -0.7519F, -2.8883F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(41, 15).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 32).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      left_arm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(42, 32).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0071F, 3.883F, 1.0436F, 2.7794F, 0.7519F, 2.8883F));
      PartDefinition right_leg_leggins = partdefinition.addOrReplaceChild("right_leg_leggins", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 18).addBox(-1.8352F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)).texOffs(48, 0).addBox(-1.8352F, 7.7352F, -1.9F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.34F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r1", CubeListBuilder.create().texOffs(37, 1).addBox(-4.3187F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.0233F, 12.4681F, -5.1187F, 0.0F, 1.5708F, 0.1309F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r2", CubeListBuilder.create().texOffs(37, 1).addBox(-5.1059F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5415F, 12.2139F, -4.1669F, -0.1396F, 0.7854F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r3", CubeListBuilder.create().texOffs(37, 1).addBox(-1.0422F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).texOffs(37, 1).addBox(-3.7F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r4", CubeListBuilder.create().texOffs(37, 1).addBox(-0.6363F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.3624F, 12.2139F, -1.5208F, -0.1396F, -0.7854F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r5", CubeListBuilder.create().texOffs(37, 1).addBox(-0.4234F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.7654F, 12.4681F, -1.3766F, 0.0F, -1.5708F, -0.1309F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r6", CubeListBuilder.create().texOffs(37, 1).addBox(-0.6363F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.3624F, 12.2139F, 1.5208F, 0.1396F, 0.7854F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r7", CubeListBuilder.create().texOffs(37, 1).addBox(-0.0718F, -11.3883F, 7.3117F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(37, 1).addBox(-0.4234F, -11.3883F, 7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r8", CubeListBuilder.create().texOffs(37, 1).addBox(-1.9282F, -10.8844F, 11.0539F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(7.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r9", CubeListBuilder.create().texOffs(37, 1).addBox(-2.3999F, -11.8344F, 1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r10", CubeListBuilder.create().texOffs(37, 1).addBox(-3.7F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).texOffs(37, 1).addBox(-1.0422F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r11", CubeListBuilder.create().texOffs(37, 1).addBox(-5.1059F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5415F, 12.2139F, 4.1669F, 0.1396F, -0.7854F, 0.0F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r12", CubeListBuilder.create().texOffs(37, 1).addBox(-4.3187F, -11.3883F, 7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.0233F, 12.4681F, 5.1187F, 0.0F, -1.5708F, 0.1309F));
      right_leg_leggins.addOrReplaceChild("right_leg_leggins_r13", CubeListBuilder.create().texOffs(37, 1).addBox(-0.8882F, -11.8344F, -1.9915F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(37, 0).addBox(-2.3999F, -11.8344F, -1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      PartDefinition left_leg_leggins = partdefinition.addOrReplaceChild("left_leg_leggins", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 18).mirror().addBox(-2.1648F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)).mirror(false).texOffs(48, 0).mirror().addBox(-2.1648F, 7.7352F, -1.9F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.34F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r1", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.3187F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.0233F, 12.4681F, -5.1187F, 0.0F, -1.5708F, -0.1309F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r2", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.1059F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.5415F, 12.2139F, -4.1669F, -0.1396F, -0.7854F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r3", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(0.0422F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(37, 1).mirror().addBox(2.7F, -11.7799F, -1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r4", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-1.3637F, -11.7254F, -2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.3624F, 12.2139F, -1.5208F, -0.1396F, 0.7854F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r5", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-0.5766F, -11.3883F, -7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(3.7654F, 12.4681F, -1.3766F, 0.0F, 1.5708F, 0.1309F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r6", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-1.3637F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.3624F, 12.2139F, 1.5208F, 0.1396F, -0.7854F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r7", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-1.9282F, -11.3883F, 7.3117F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(3.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r8", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-0.0718F, -10.8844F, 11.0539F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-7.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r9", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(0.3999F, -11.8344F, 1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r10", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(2.7F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(37, 1).mirror().addBox(0.0422F, -11.7799F, 1.8931F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r11", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.1059F, -11.7254F, 2.0077F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.5415F, 12.2139F, 4.1669F, 0.1396F, 0.7854F, 0.0F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r12", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.3187F, -11.3883F, 7.3F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.0233F, 12.4681F, 5.1187F, 0.0F, 1.5708F, -0.1309F));
      left_leg_leggins.addOrReplaceChild("left_leg_leggins_r13", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-0.1118F, -11.8344F, -1.9915F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(37, 0).mirror().addBox(0.3999F, -11.8344F, -1.9915F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("right_leg_boot", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).texOffs(0, 20).addBox(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).texOffs(0, 20).addBox(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).texOffs(0, 15).addBox(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(0, 15).addBox(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(0, 15).addBox(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_leg_boot", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 20).mirror().addBox(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).mirror(false).texOffs(0, 20).mirror().addBox(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).mirror(false).texOffs(0, 20).mirror().addBox(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).mirror(false).texOffs(0, 15).mirror().addBox(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(0, 15).mirror().addBox(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(0, 15).mirror().addBox(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("steve", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16).mirror().addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(40, 16).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 16).mirror().addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg_leggins.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg_leggins.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg_boot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg_boot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
