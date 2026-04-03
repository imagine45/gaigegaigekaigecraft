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

public class Modelcursedspirit3_22<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_22"), "main");
   public final ModelPart bone;
   public final ModelPart head;
   public final ModelPart left_arm;
   public final ModelPart left_leg;
   public final ModelPart left_leg2;
   public final ModelPart right_arm;
   public final ModelPart right_leg;
   public final ModelPart right_leg2;

   public Modelcursedspirit3_22(ModelPart root) {
      this.bone = root.getChild("bone");
      this.head = root.getChild("head");
      this.left_arm = root.getChild("left_arm");
      this.left_leg = root.getChild("left_leg");
      this.left_leg2 = root.getChild("left_leg2");
      this.right_arm = root.getChild("right_arm");
      this.right_leg = root.getChild("right_leg");
      this.right_leg2 = root.getChild("right_leg2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-8.25F, -3.5F, 2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false).texOffs(0, 15).mirror().addBox(-8.25F, -3.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false).texOffs(0, 15).mirror().addBox(-8.25F, -3.5F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false).texOffs(0, 15).addBox(0.25F, -3.5F, 2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).texOffs(0, 15).addBox(0.25F, -3.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).texOffs(0, 15).addBox(0.25F, -3.5F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).texOffs(0, 0).addBox(-7.0F, -3.75F, -3.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.75F)).texOffs(0, 22).addBox(-7.0F, -5.5F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-7.0F, -1.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(3.0F, -9.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.7336F, -3.3394F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.6796F, 2.8743F, -0.3655F, -0.147F, -0.3655F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 15).addBox(-3.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(-0.4619F, -10.6796F, 7.0483F, -0.3655F, -0.147F, -0.3655F));
      bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 15).addBox(-3.8336F, -4.3394F, -1.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).texOffs(16, 15).addBox(-3.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(-0.4619F, -12.6796F, 3.0483F, -0.3655F, -0.147F, -0.3655F));
      bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 15).addBox(1.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).texOffs(16, 15).addBox(1.8336F, -4.3394F, -1.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(0.4619F, -12.6796F, 3.0483F, -0.3655F, 0.147F, 0.3655F));
      bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 15).addBox(1.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(0.4619F, -10.6796F, 7.0483F, -0.3655F, 0.147F, 0.3655F));
      bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 15).addBox(-5.35F, -3.5F, 0.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).texOffs(16, 15).addBox(-5.35F, -3.5F, 2.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(-4.1533F, -13.4891F, 2.3012F, -1.5398F, 0.9314F, -1.5091F));
      bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(16, 15).addBox(3.35F, -3.5F, 0.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).texOffs(16, 15).addBox(3.35F, -3.5F, 2.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(4.1533F, -13.4891F, 2.3012F, -1.5398F, -0.9314F, 1.5091F));
      bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(16, 15).addBox(-2.55F, -3.75F, -1.55F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).texOffs(16, 15).addBox(-2.55F, -3.75F, -3.3F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(3.2294F, -13.4891F, -2.4532F, -1.3086F, 1.4193F, -1.3244F));
      bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 15).addBox(0.55F, -3.75F, -1.55F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).texOffs(16, 15).addBox(0.55F, -3.75F, -3.3F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(-3.2294F, -13.4891F, -2.4532F, -1.3086F, -1.4193F, 1.3244F));
      bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(2.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.6796F, 6.8743F, -0.3655F, 0.147F, 0.3655F));
      bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-3.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.6796F, 6.8743F, -0.3655F, -0.147F, -0.3655F));
      bone.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-2.25F, -2.75F, -3.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.25F, -2.75F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6913F, -13.4891F, -2.6272F, -1.3086F, 1.4193F, -1.3244F));
      bone.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(1.25F, -2.75F, -3.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(1.25F, -2.75F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6913F, -13.4891F, -2.6272F, -1.3086F, -1.4193F, 1.3244F));
      bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.25F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, -2.25F, 0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6913F, -13.4891F, 2.1272F, -1.5398F, 0.9314F, -1.5091F));
      bone.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -2.25F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(4.0F, -2.25F, 0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6913F, -13.4891F, 2.1272F, -1.5398F, -0.9314F, 1.5091F));
      bone.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(2.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(2.7336F, -3.3394F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.6796F, 2.8743F, -0.3655F, 0.147F, 0.3655F));
      PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, -5.1356F, -3.7542F));
      bone2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(2, 21).addBox(-2.0F, -2.0F, -5.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.7654F, 9.1491F, 0.3927F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, -2.0F, -5.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 4.0F, -0.3927F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)).texOffs(24, 21).addBox(-1.5F, -1.0F, -1.9F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -5.0F));
      head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(8, 15).mirror().addBox(-2.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.3827F, -2.0566F, -1.4651F, -0.7171F, 0.2377F, -0.0212F));
      head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(8, 15).addBox(0.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.3827F, -2.0566F, -1.4651F, -0.7171F, -0.2377F, 0.0212F));
      head.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 24).addBox(-2.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, -0.7171F, 0.2377F, -0.0212F));
      head.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 24).addBox(0.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, -0.7171F, -0.2377F, 0.0212F));
      head.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9176F, 0.0F, 0.6131F, 0.0F, 1.1781F, 0.0F));
      head.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9176F, 0.0F, 0.6131F, 0.0F, -1.1781F, 0.0F));
      head.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(24, 11).mirror().addBox(0.0F, -6.5F, -4.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.55F)).mirror(false).texOffs(24, 11).addBox(-1.0F, -6.5F, -4.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.55F)), PartPose.offsetAndRotation(0.0F, -0.9405F, 0.6285F, -0.3054F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -0.9405F, 0.6285F, 0.3927F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(24, 21).addBox(-0.4451F, -0.7354F, -0.623F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9707F, -1.1F, 0.1253F, -0.2665F, 0.3626F));
      head.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(24, 21).addBox(-1.5549F, -0.7354F, -0.623F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 2.0707F, -1.1F, 0.1806F, 0.2331F, -0.14F));
      head.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(24, 21).addBox(0.5549F, -0.7354F, -0.623F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 2.0707F, -1.1F, 0.1806F, -0.2331F, 0.14F));
      head.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(24, 21).addBox(-1.5549F, -0.7354F, -0.623F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9707F, -1.1F, 0.1253F, 0.2665F, -0.3626F));
      head.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, 1.8644F, 1.2458F, -0.3927F, 0.0F, 0.0F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(4.0F, 19.0F, -4.25F));
      left_arm.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.4709F, 2.9841F, -0.1698F, 2.4208F, -0.2331F, -2.4621F));
      left_arm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.25F, -2.3166F, -1.0228F, 2.3957F));
      PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(4.0F, 19.5F, -0.75F));
      left_leg.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 19).addBox(-1.435F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(1.6762F, 1.336F, 0.0679F, 3.0894F, 0.9309F, 3.0727F));
      left_leg.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 19).addBox(-1.8462F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6762F, 1.336F, 0.0679F, 2.9946F, 0.0269F, 1.9323F));
      PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(4.0F, 19.5F, 4.25F));
      left_leg2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 19).addBox(-1.435F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(1.6762F, 1.336F, 0.0679F, 3.0894F, 0.9309F, 3.0727F));
      left_leg2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 19).addBox(-1.8462F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6762F, 1.336F, 0.0679F, 2.9946F, 0.0269F, 1.9323F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-4.0F, 19.0F, -4.25F));
      right_arm.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.4709F, 2.9841F, -0.1698F, 2.4208F, 0.2331F, 2.4621F));
      right_arm.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.25F, -2.3166F, 1.0228F, -2.3957F));
      PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-4.0F, 19.5F, -0.75F));
      right_leg.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-0.565F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-1.6762F, 1.336F, 0.0679F, 3.0894F, -0.9309F, -3.0727F));
      right_leg.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-0.1538F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6762F, 1.336F, 0.0679F, 2.9946F, -0.0269F, -1.9323F));
      PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offset(-4.0F, 19.5F, 4.25F));
      right_leg2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-0.565F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-1.6762F, 1.336F, 0.0679F, 3.0894F, -0.9309F, -3.0727F));
      right_leg2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-0.1538F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6762F, 1.336F, 0.0679F, 2.9946F, -0.0269F, -1.9323F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
