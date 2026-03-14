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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_22"), "main");
   public final ModelPart bone;
   public final ModelPart head;
   public final ModelPart left_arm;
   public final ModelPart left_leg;
   public final ModelPart left_leg2;
   public final ModelPart right_arm;
   public final ModelPart right_leg;
   public final ModelPart right_leg2;

   public Modelcursedspirit3_22(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.head = root.m_171324_("head");
      this.left_arm = root.m_171324_("left_arm");
      this.left_leg = root.m_171324_("left_leg");
      this.left_leg2 = root.m_171324_("left_leg2");
      this.right_arm = root.m_171324_("right_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.right_leg2 = root.m_171324_("right_leg2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-8.25F, -3.5F, 2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-8.25F, -3.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-8.25F, -3.5F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false).m_171514_(0, 15).m_171488_(0.25F, -3.5F, 2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(0, 15).m_171488_(0.25F, -3.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(0, 15).m_171488_(0.25F, -3.5F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(0, 0).m_171488_(-7.0F, -3.75F, -3.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.75F)).m_171514_(0, 22).m_171488_(-7.0F, -5.5F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-7.0F, -1.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(3.0F, -9.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.7336F, -3.3394F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-3.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -12.6796F, 2.8743F, -0.3655F, -0.147F, -0.3655F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(-3.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(-0.4619F, -10.6796F, 7.0483F, -0.3655F, -0.147F, -0.3655F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(-3.8336F, -4.3394F, -1.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171514_(16, 15).m_171488_(-3.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(-0.4619F, -12.6796F, 3.0483F, -0.3655F, -0.147F, -0.3655F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(1.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171514_(16, 15).m_171488_(1.8336F, -4.3394F, -1.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(0.4619F, -12.6796F, 3.0483F, -0.3655F, 0.147F, 0.3655F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(1.8336F, -4.3394F, -3.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(0.4619F, -10.6796F, 7.0483F, -0.3655F, 0.147F, 0.3655F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(-5.35F, -3.5F, 0.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171514_(16, 15).m_171488_(-5.35F, -3.5F, 2.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(-4.1533F, -13.4891F, 2.3012F, -1.5398F, 0.9314F, -1.5091F));
      bone.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(3.35F, -3.5F, 0.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171514_(16, 15).m_171488_(3.35F, -3.5F, 2.475F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(4.1533F, -13.4891F, 2.3012F, -1.5398F, -0.9314F, 1.5091F));
      bone.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(-2.55F, -3.75F, -1.55F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171514_(16, 15).m_171488_(-2.55F, -3.75F, -3.3F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(3.2294F, -13.4891F, -2.4532F, -1.3086F, 1.4193F, -1.3244F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(16, 15).m_171488_(0.55F, -3.75F, -1.55F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)).m_171514_(16, 15).m_171488_(0.55F, -3.75F, -3.3F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(-3.2294F, -13.4891F, -2.4532F, -1.3086F, -1.4193F, 1.3244F));
      bone.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(2.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -10.6796F, 6.8743F, -0.3655F, 0.147F, 0.3655F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -10.6796F, 6.8743F, -0.3655F, -0.147F, -0.3655F));
      bone.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.25F, -2.75F, -3.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.25F, -2.75F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.6913F, -13.4891F, -2.6272F, -1.3086F, 1.4193F, -1.3244F));
      bone.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.25F, -2.75F, -3.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(1.25F, -2.75F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.6913F, -13.4891F, -2.6272F, -1.3086F, -1.4193F, 1.3244F));
      bone.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -2.25F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.0F, -2.25F, 0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.6913F, -13.4891F, 2.1272F, -1.5398F, 0.9314F, -1.5091F));
      bone.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(4.0F, -2.25F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(4.0F, -2.25F, 0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.6913F, -13.4891F, 2.1272F, -1.5398F, -0.9314F, 1.5091F));
      bone.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(2.7336F, -3.3394F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.7336F, -3.3394F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -12.6796F, 2.8743F, -0.3655F, 0.147F, 0.3655F));
      PartDefinition bone2 = bone.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -5.1356F, -3.7542F));
      bone2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(2, 21).m_171488_(-2.0F, -2.0F, -5.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -0.7654F, 9.1491F, 0.3927F, 0.0F, 0.0F));
      bone2.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-2.0F, -2.0F, -5.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-2.0F, 0.0F, 4.0F, -0.3927F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)).m_171514_(24, 21).m_171488_(-1.5F, -1.0F, -1.9F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 17.0F, -5.0F));
      head.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(8, 15).m_171480_().m_171488_(-2.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.3827F, -2.0566F, -1.4651F, -0.7171F, 0.2377F, -0.0212F));
      head.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(8, 15).m_171488_(0.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.3827F, -2.0566F, -1.4651F, -0.7171F, -0.2377F, 0.0212F));
      head.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-2.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.75F, 0.0F, -0.7171F, 0.2377F, -0.0212F));
      head.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(0.25F, 0.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.75F, 0.0F, -0.7171F, -0.2377F, 0.0212F));
      head.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.9176F, 0.0F, 0.6131F, 0.0F, 1.1781F, 0.0F));
      head.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.9176F, 0.0F, 0.6131F, 0.0F, -1.1781F, 0.0F));
      head.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(24, 11).m_171480_().m_171488_(0.0F, -6.5F, -4.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.55F)).m_171555_(false).m_171514_(24, 11).m_171488_(-1.0F, -6.5F, -4.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(-0.55F)), PartPose.m_171423_(0.0F, -0.9405F, 0.6285F, -0.3054F, 0.0F, 0.0F));
      head.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, -0.9405F, 0.6285F, 0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(24, 21).m_171488_(-0.4451F, -0.7354F, -0.623F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 1.9707F, -1.1F, 0.1253F, -0.2665F, 0.3626F));
      head.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(24, 21).m_171488_(-1.5549F, -0.7354F, -0.623F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.4F, 2.0707F, -1.1F, 0.1806F, 0.2331F, -0.14F));
      head.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(24, 21).m_171488_(0.5549F, -0.7354F, -0.623F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.4F, 2.0707F, -1.1F, 0.1806F, -0.2331F, 0.14F));
      head.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(24, 21).m_171488_(-1.5549F, -0.7354F, -0.623F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 1.9707F, -1.1F, 0.1253F, 0.2665F, -0.3626F));
      head.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 1.8644F, 1.2458F, -0.3927F, 0.0F, 0.0F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 19.0F, -4.25F));
      left_arm.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-0.4709F, 2.9841F, -0.1698F, 2.4208F, -0.2331F, -2.4621F));
      left_arm.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.0F, 0.25F, -2.3166F, -1.0228F, 2.3957F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 19.5F, -0.75F));
      left_leg.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.435F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(1.6762F, 1.336F, 0.0679F, 3.0894F, 0.9309F, 3.0727F));
      left_leg.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.8462F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.6762F, 1.336F, 0.0679F, 2.9946F, 0.0269F, 1.9323F));
      PartDefinition left_leg2 = partdefinition.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 19.5F, 4.25F));
      left_leg2.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.435F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(1.6762F, 1.336F, 0.0679F, 3.0894F, 0.9309F, 3.0727F));
      left_leg2.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.8462F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.6762F, 1.336F, 0.0679F, 2.9946F, 0.0269F, 1.9323F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 19.0F, -4.25F));
      right_arm.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(0.4709F, 2.9841F, -0.1698F, 2.4208F, 0.2331F, 2.4621F));
      right_arm.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.0F, 0.25F, -2.3166F, 1.0228F, -2.3957F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 19.5F, -0.75F));
      right_leg.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-0.565F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-1.6762F, 1.336F, 0.0679F, 3.0894F, -0.9309F, -3.0727F));
      right_leg.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-0.1538F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.6762F, 1.336F, 0.0679F, 2.9946F, -0.0269F, -1.9323F));
      PartDefinition right_leg2 = partdefinition.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 19.5F, 4.25F));
      right_leg2.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-0.565F, -1.3293F, -0.565F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-1.6762F, 1.336F, 0.0679F, 3.0894F, -0.9309F, -3.0727F));
      right_leg2.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-0.1538F, -3.0164F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.6762F, 1.336F, 0.0679F, 2.9946F, -0.0269F, -1.9323F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
      this.right_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
