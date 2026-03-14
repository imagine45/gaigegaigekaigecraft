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

public class Modelcursedspirit3_21<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_21"), "main");
   public final ModelPart body;
   public final ModelPart left_leg;
   public final ModelPart right_leg;
   public final ModelPart right_leg2;
   public final ModelPart left_leg2;
   public final ModelPart left_arm;
   public final ModelPart right_arm;
   public final ModelPart head;

   public Modelcursedspirit3_21(ModelPart root) {
      this.body = root.m_171324_("body");
      this.left_leg = root.m_171324_("left_leg");
      this.right_leg = root.m_171324_("right_leg");
      this.right_leg2 = root.m_171324_("right_leg2");
      this.left_leg2 = root.m_171324_("left_leg2");
      this.left_arm = root.m_171324_("left_arm");
      this.right_arm = root.m_171324_("right_arm");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(40, 48).m_171488_(-4.0F, -17.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.m_171419_(0.0F, 12.0F, -7.0F));
      body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-5.0F, -6.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, -5.6391F, 27.6136F, 2.0508F, 0.0F, 0.0F));
      body.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.m_171423_(1.0F, -1.6391F, 15.6136F, 1.6581F, 0.0F, 0.0F));
      body.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.m_171423_(1.0F, -1.2455F, 21.2706F, 1.5272F, 0.0F, 0.0F));
      body.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.m_171423_(1.0F, -1.2455F, 7.7706F, 1.3526F, 0.0F, 0.0F));
      body.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.925F)), PartPose.m_171423_(1.0F, -3.2455F, 16.2706F, 1.5272F, 0.0F, 0.0F));
      body.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -6.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.m_171423_(1.0F, -1.3891F, 23.8636F, 1.2654F, 0.0F, 0.0F));
      body.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.95F)), PartPose.m_171423_(1.0F, -3.3891F, 7.8636F, 1.6581F, 0.0F, 0.0F));
      body.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(40, 56).m_171488_(-4.0F, -6.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.m_171423_(0.0F, -0.6716F, 3.5711F, 0.6981F, 0.0F, 0.0F));
      body.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(40, 52).m_171480_().m_171488_(2.0F, -6.0F, -2.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.9F)).m_171555_(false), PartPose.m_171423_(-6.9406F, -9.6194F, 0.0F, 0.0F, 0.0F, -0.3927F));
      body.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(40, 52).m_171488_(-4.0F, -6.0F, -2.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.m_171423_(6.9406F, -9.6194F, 0.0F, 0.0F, 0.0F, 0.3927F));
      body.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(40, 48).m_171488_(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.m_171423_(0.0F, -10.6683F, 2.3393F, 0.3054F, 0.0F, 0.0F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(5.0F, 8.0F, -3.0F));
      left_leg.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171480_().m_171488_(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(5.0577F, 9.1299F, 0.0F, -0.7854F, 0.0F, 1.7453F));
      left_leg.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, 1.1781F));
      left_leg.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.3927F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-5.0F, 8.0F, -3.0F));
      right_leg.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171488_(-3.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(-4.3631F, 13.0691F, 0.0F, -0.7854F, 0.0F, -1.7453F));
      right_leg.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(-2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, -1.1781F));
      right_leg.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, -0.3927F));
      PartDefinition right_leg2 = partdefinition.m_171599_("right_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-5.0F, 8.0F, 8.0F));
      right_leg2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171488_(-3.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(-4.3631F, 13.0691F, 0.0F, -0.7854F, 0.0F, -1.7453F));
      right_leg2.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(-2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, -1.1781F));
      right_leg2.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, -0.3927F));
      PartDefinition left_leg2 = partdefinition.m_171599_("left_leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(5.0F, 8.0F, 8.0F));
      left_leg2.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171480_().m_171488_(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)).m_171555_(false), PartPose.m_171423_(5.0577F, 9.1299F, 0.0F, -0.7854F, 0.0F, 1.7453F));
      left_leg2.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.m_171423_(2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, 1.1781F));
      left_leg2.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(44, 44).m_171488_(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.3927F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.0F, -4.0F, -7.5F));
      left_arm.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(41, 48).m_171480_().m_171488_(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.0F, 1.0F, -0.5F, 0.0F, 0.0F, -0.1745F));
      left_arm.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(42, 48).m_171480_().m_171488_(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(2.7663F, 12.216F, -0.5F, 0.0F, 0.0F, 0.1309F));
      left_arm.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171480_().m_171488_(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.3953F, 26.4116F, 0.5F, -0.7854F, 0.0F, 2.9234F));
      left_arm.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171480_().m_171488_(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.4726F, 24.414F, 0.5F, -0.7854F, 0.0F, 2.5307F));
      left_arm.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171480_().m_171488_(1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(2.5577F, 20.1299F, 0.5F, -0.7854F, 0.0F, 2.138F));
      left_arm.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171488_(-1.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.14F)), PartPose.m_171423_(0.0F, 0.75F, -0.5F, -0.7854F, 0.0F, 0.3927F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.0F, -4.0F, -7.5F));
      right_arm.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171488_(-6.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(-2.5577F, 20.1299F, 0.5F, -0.7854F, 0.0F, -2.138F));
      right_arm.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171488_(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-0.4726F, 24.414F, 0.5F, -0.7854F, 0.0F, -2.5307F));
      right_arm.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 45).m_171488_(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.3953F, 26.4116F, 0.5F, -0.7854F, 0.0F, -2.9234F));
      right_arm.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171488_(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.14F)), PartPose.m_171423_(0.0F, 0.75F, -0.5F, -0.7854F, 0.0F, -0.3927F));
      right_arm.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(42, 48).m_171488_(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-2.7663F, 12.216F, -0.5F, 0.0F, 0.0F, -0.1309F));
      right_arm.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(41, 48).m_171488_(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 1.0F, -0.5F, 0.0F, 0.0F, 0.1745F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(1, 11).m_171488_(-2.7055F, -5.75F, -3.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(1, 14).m_171488_(-3.0F, -3.75F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(22, 11).m_171488_(-3.0F, 1.0F, -4.1F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(22, 11).m_171488_(-3.0F, -0.25F, -3.75F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 21).m_171488_(-3.0F, -0.75F, -4.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).m_171514_(0, 25).m_171488_(-3.0F, 0.25F, -4.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171419_(-0.2945F, -6.0F, -7.0F));
      head.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(1, 11).m_171488_(-4.0F, -5.0F, -4.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(-4.0177F, 4.4903F, -0.5F, 0.0F, 0.0F, 0.7854F));
      head.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(-3.0F, -5.0F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.175F)), PartPose.m_171423_(0.0177F, 2.4903F, -0.5F, 0.0F, 0.0F, -0.7854F));
      head.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(-4.0F, -5.0F, -3.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(-0.0177F, 2.4903F, -1.3F, 0.0F, 0.0F, 0.7854F));
      head.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(-3.5F, -0.5429F, -1.6893F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.9948F, -1.2758F, -0.2718F, 0.0F, 1.5708F, 0.3927F));
      head.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171480_().m_171488_(-2.5F, -4.4571F, -0.6893F, 5.0F, 8.0F, 2.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(3.9948F, -1.2758F, -0.2718F, 0.0F, 1.5708F, -0.3927F));
      head.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(-3.5F, -4.4571F, -0.6893F, 6.0F, 8.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-2.9948F, -1.2758F, -0.2718F, 0.0F, -1.5708F, 0.3927F));
      head.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(-3.5F, -2.5F, -0.5F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.8425F, 2.723F, -0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(1, 11).m_171488_(-2.5F, -2.5F, -0.5F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.3942F, 2.723F, 0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(1, 11).m_171488_(-2.5F, -2.5F, -0.5F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.3942F, -3.723F, -0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r45", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(-3.0F, -5.0F, -4.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, 4.5F, 1.25F, 0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r46", CubeListBuilder.m_171558_().m_171514_(56, 25).m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.6774F, -3.2362F, -2.5239F, -0.2222F, 0.0376F, -0.6077F));
      head.m_171599_("cube_r47", CubeListBuilder.m_171558_().m_171514_(1, 11).m_171488_(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.5F, -0.5F, 0.0F, 0.0F, -0.1745F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
      this.right_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg2.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
