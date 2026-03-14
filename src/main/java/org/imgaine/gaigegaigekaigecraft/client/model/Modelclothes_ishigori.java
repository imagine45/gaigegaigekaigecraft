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

public class Modelclothes_ishigori<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_ishigori"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart right_boot;
   public final ModelPart left_boot;
   public final ModelPart steve;

   public Modelclothes_ishigori(ModelPart root) {
      this.head = root.m_171324_("head");
      this.body = root.m_171324_("body");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.right_boot = root.m_171324_("right_boot");
      this.left_boot = root.m_171324_("left_boot");
      this.steve = root.m_171324_("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(2, 20).m_171488_(-3.0F, -9.0F, -4.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(9, 25).m_171488_(-3.0F, -9.0F, -7.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(8, 24).m_171488_(-2.5F, -8.5F, -8.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(7, 23).m_171488_(-3.0F, -6.0F, 4.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)).m_171514_(20, 27).m_171488_(-4.0F, 12.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.351F)).m_171514_(20, 27).m_171480_().m_171488_(2.0F, 12.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.351F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-4.1F, -1.8F, -0.3F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 11.5F, -1.8F, 0.2182F, 0.0F, 3.1416F));
      body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(2.1F, -1.8F, -0.3F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 11.5F, -1.8F, 0.2182F, 0.0F, -3.1416F));
      body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -0.3161F, 3.466F, -1.1781F, 0.0F, 0.0F));
      body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -1.4381F, 0.1543F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.828F, -0.3704F, 2.0F, -1.5708F, 0.7854F, 0.0F));
      body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -1.6448F, -0.0883F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.828F, -0.3704F, 2.0F, -1.1781F, 0.7854F, 0.0F));
      body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -1.2006F, -0.2882F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.828F, -0.3704F, 2.0F, -0.7854F, 0.7854F, 0.0F));
      body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -1.5399F, 0.3576F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.828F, -0.3704F, 2.0F, -1.9635F, 0.7854F, 0.0F));
      body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-0.5F, -1.4381F, 0.1543F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.828F, -0.3704F, 2.0F, -1.5708F, -0.7854F, 0.0F));
      body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-0.5F, -1.6448F, -0.0883F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.828F, -0.3704F, 2.0F, -1.1781F, -0.7854F, 0.0F));
      body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-0.5F, -1.2006F, -0.2882F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.828F, -0.3704F, 2.0F, -0.7854F, -0.7854F, 0.0F));
      body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-0.5F, -1.5399F, 0.3576F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.828F, -0.3704F, 2.0F, -1.9635F, -0.7854F, 0.0F));
      body.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.466F, -0.3161F, 0.0F, 0.0F, -1.5708F, -1.1781F));
      body.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.466F, -0.3161F, 0.0F, 0.0F, 1.5708F, 1.1781F));
      body.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.766F, -0.7161F, 0.0F, 0.0F, 1.5708F, 0.7854F));
      body.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.266F, -0.2161F, 0.0F, 0.0F, 1.5708F, 1.5708F));
      body.m_171599_("Body_r16", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.766F, -0.7161F, 0.0F, 0.0F, -1.5708F, -0.7854F));
      body.m_171599_("Body_r17", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.266F, -0.2161F, 0.0F, 0.0F, 1.5708F, 1.9635F));
      body.m_171599_("Body_r18", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.266F, -0.2161F, 0.0F, 0.0F, -1.5708F, -1.9635F));
      body.m_171599_("Body_r19", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.266F, -0.2161F, 0.0F, 0.0F, -1.5708F, -1.5708F));
      body.m_171599_("Body_r20", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -0.2161F, 3.266F, -1.9635F, 0.0F, 0.0F));
      body.m_171599_("Body_r21", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -0.2161F, 3.266F, -1.5708F, 0.0F, 0.0F));
      body.m_171599_("Body_r22", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -0.7161F, 3.766F, -0.7854F, 0.0F, 0.0F));
      body.m_171599_("Body_r23", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-4.1F, -1.8F, 0.3F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 12.0F, 2.0F, -0.2182F, 0.0F, 3.1416F));
      body.m_171599_("Body_r24", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-1.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(4.3F, 12.4161F, -0.534F, -0.2182F, -1.5708F, 3.1416F));
      body.m_171599_("Body_r25", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-4.3F, 12.4161F, -0.534F, -0.2182F, 1.5708F, -3.1416F));
      body.m_171599_("Body_r26", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-0.9F, -1.8F, 0.3F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 12.0F, 2.0F, -0.2182F, 0.0F, -3.1416F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171514_(24, 30).m_171488_(-3.0F, 7.0F, -2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).m_171514_(24, 30).m_171488_(-3.0F, 7.0F, 2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).m_171514_(20, 26).m_171488_(-3.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)).m_171514_(20, 26).m_171488_(1.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      right_arm.m_171599_("right_arm_r1", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(1.3F, 7.4161F, 0.034F, 0.0F, -1.5708F, 2.9234F));
      right_arm.m_171599_("right_arm_r2", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.034F, 7.4161F, 2.3F, -0.2182F, 0.0F, -3.1416F));
      right_arm.m_171599_("right_arm_r3", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.966F, 7.4161F, -2.3F, 2.9234F, 0.0F, 0.0F));
      right_arm.m_171599_("right_arm_r4", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171480_().m_171488_(-2.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-3.3F, 7.4161F, -0.534F, -0.2182F, 1.5708F, -3.1416F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false).m_171514_(24, 30).m_171480_().m_171488_(-1.0F, 7.0F, -2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).m_171555_(false).m_171514_(24, 30).m_171480_().m_171488_(-1.0F, 7.0F, 2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.351F)).m_171555_(false).m_171514_(20, 26).m_171480_().m_171488_(3.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)).m_171555_(false).m_171514_(20, 26).m_171480_().m_171488_(-1.0F, 7.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.301F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      left_arm.m_171599_("right_arm_r5", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-1.3F, 7.4161F, 0.034F, 0.0F, 1.5708F, -2.9234F));
      left_arm.m_171599_("right_arm_r6", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.034F, 7.4161F, 2.3F, -0.2182F, 0.0F, 3.1416F));
      left_arm.m_171599_("right_arm_r7", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.966F, 7.4161F, -2.3F, 2.9234F, 0.0F, 0.0F));
      left_arm.m_171599_("right_arm_r8", CubeListBuilder.m_171558_().m_171514_(18, 26).m_171488_(-1.5F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(3.3F, 7.4161F, -0.534F, -0.2182F, -1.5708F, 3.1416F));
      partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.9352F, 0.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).m_171514_(0, 0).m_171488_(-1.9352F, 5.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.15F)), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-2.0648F, 0.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.14F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(-2.0648F, 5.4352F, -1.9F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      PartDefinition right_boot = partdefinition.m_171599_("right_boot", CubeListBuilder.m_171558_(), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      PartDefinition left_boot = partdefinition.m_171599_("left_boot", CubeListBuilder.m_171558_(), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("steve", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(40, 16).m_171480_().m_171488_(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(40, 16).m_171488_(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171480_().m_171488_(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 16).m_171488_(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_boot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_boot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
