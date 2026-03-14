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

public class Modelclothes_yorozu<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_yorozu"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart steve;

   public Modelclothes_yorozu(ModelPart root) {
      this.head = root.m_171324_("head");
      this.body = root.m_171324_("body");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.steve = root.m_171324_("steve");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(40, 33).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false).m_171514_(24, 0).m_171480_().m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 0.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(0.0F, -6.0F, 0.5F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-5.2694F, 11.1029F, -1.0F, 0.3927F, -1.5708F, 0.0F));
      body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-5.4314F, 10.9116F, 2.0F, 0.3927F, -1.1781F, 0.0F));
      body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.7314F, 10.9116F, 3.0F, 0.3927F, -0.7854F, 0.0F));
      body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(-1.0F, -5.5F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.7357F, 10.8625F, -2.8875F, -0.2115F, -0.1357F, -0.1678F));
      body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(-1.0F, -5.5F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.7357F, 10.8625F, -2.8875F, -0.2115F, 0.1357F, 0.1678F));
      body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(-1.0F, -7.0F, 0.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-3.6314F, 10.9116F, 4.0F, 0.3927F, -0.5236F, 0.0F));
      body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(-1.9F, -7.0F, -0.5F, 3.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(1.8993F, 10.9116F, 5.0F, 0.3919F, 0.1416F, -0.1073F));
      body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(-1.1F, -7.0F, -0.5F, 3.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-1.8993F, 10.9116F, 5.0F, 0.3919F, -0.1416F, 0.1073F));
      body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(-1.0F, -7.0F, 0.0F, 2.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(3.6314F, 10.9116F, 4.0F, 0.3927F, 0.5236F, 0.0F));
      body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(-4.3456F, -4.7197F, -3.0909F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 11.2116F, -2.3F, -0.2086F, 0.7769F, 0.1298F));
      body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171488_(-4.0024F, -4.2262F, -4.2824F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 11.2116F, -2.3F, -0.0614F, 1.1579F, 0.3053F));
      body.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(2.3456F, -4.7197F, -3.0909F, 2.0F, 11.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 11.2116F, -2.3F, -0.2086F, -0.7769F, -0.1298F));
      body.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(2.0024F, -4.2262F, -4.2824F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 11.2116F, -2.3F, -0.0614F, -1.1579F, -0.3053F));
      body.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(5.4314F, 10.9116F, 2.0F, 0.3927F, 1.1781F, 0.0F));
      body.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(-1.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.7314F, 10.9116F, 3.0F, 0.3927F, 0.7854F, 0.0F));
      body.m_171599_("Body_r16", CubeListBuilder.m_171558_().m_171514_(10, 20).m_171480_().m_171488_(-3.0F, -6.0F, 0.5F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(5.2694F, 11.1029F, -1.0F, 0.3927F, 1.5708F, 0.0F));
      body.m_171599_("Body_r17", CubeListBuilder.m_171558_().m_171514_(11, 23).m_171480_().m_171488_(-3.0F, -3.0F, 2.0F, 6.0F, 14.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 9.0F, 1.4F, 0.3927F, 0.0F, 0.0F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(32, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      right_arm.m_171599_("right_arm_r1", CubeListBuilder.m_171558_().m_171514_(38, 18).m_171480_().m_171488_(-1.5F, -1.0F, -1.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171423_(-1.0F, 3.6453F, 0.9964F, 0.583F, 0.6956F, 0.3999F));
      right_arm.m_171599_("right_arm_r2", CubeListBuilder.m_171558_().m_171514_(38, 18).m_171480_().m_171488_(-1.5F, -5.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171423_(-1.0F, 3.7453F, 0.9964F, 0.2444F, 0.7703F, 0.1719F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(32, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      left_arm.m_171599_("left_arm_r1", CubeListBuilder.m_171558_().m_171514_(38, 18).m_171488_(-1.5F, -1.0F, -1.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.251F)), PartPose.m_171423_(1.0F, 3.6453F, 0.9964F, 0.583F, -0.6956F, -0.3999F));
      left_arm.m_171599_("left_arm_r2", CubeListBuilder.m_171558_().m_171514_(38, 18).m_171488_(-1.5F, -5.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.251F)), PartPose.m_171423_(1.0F, 3.7453F, 0.9964F, 0.2444F, -0.7703F, -0.1719F));
      partdefinition.m_171599_("steve", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171480_().m_171488_(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 0).m_171488_(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171480_().m_171488_(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 0).m_171488_(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171488_(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.steve.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
