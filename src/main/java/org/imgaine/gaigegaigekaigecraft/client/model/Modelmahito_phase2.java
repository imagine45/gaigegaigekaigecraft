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

public class Modelmahito_phase2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelmahito_phase_2"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;

   public Modelmahito_phase2(ModelPart root) {
      this.head = root.m_171324_("head");
      this.body = root.m_171324_("body");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.51F)).m_171514_(32, 32).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition head_parts = head.m_171599_("head_parts", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -5.6861F, 4.4222F, -0.1745F, 0.0F, 0.0F));
      head_parts.m_171599_("head_parts_r1", CubeListBuilder.m_171558_().m_171514_(-11, 52).m_171488_(2.5343F, -3.1866F, 5.1107F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.0006F, 10.565F, -0.3562F, 0.3911F, -0.0361F));
      head_parts.m_171599_("head_parts_r2", CubeListBuilder.m_171558_().m_171514_(-12, 51).m_171488_(2.5343F, -0.8298F, -2.2893F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.0006F, 10.565F, 0.0365F, 0.3911F, -0.0361F));
      head_parts.m_171599_("head_parts_r3", CubeListBuilder.m_171558_().m_171514_(-12, 52).m_171488_(2.5343F, -1.615F, -12.3305F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.0006F, 10.565F, 0.5164F, 0.3911F, -0.0361F));
      head_parts.m_171599_("head_parts_r4", CubeListBuilder.m_171558_().m_171514_(-11, 52).m_171488_(-8.5343F, -3.1866F, 5.1107F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.0006F, 10.565F, -0.3562F, -0.3911F, 0.0361F));
      head_parts.m_171599_("head_parts_r5", CubeListBuilder.m_171558_().m_171514_(-12, 51).m_171488_(-8.5343F, -0.8298F, -2.2893F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.0006F, 10.565F, 0.0365F, -0.3911F, 0.0361F));
      head_parts.m_171599_("head_parts_r6", CubeListBuilder.m_171558_().m_171514_(-12, 52).m_171488_(-8.5343F, -1.615F, -12.3305F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.0006F, 10.565F, 0.5164F, -0.3911F, 0.0361F));
      head_parts.m_171599_("head_parts_r7", CubeListBuilder.m_171558_().m_171514_(-11, 52).m_171488_(-3.0F, -1.0F, 2.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -7.3076F, 13.3413F, -0.2618F, 0.0F, 0.0F));
      head_parts.m_171599_("head_parts_r8", CubeListBuilder.m_171558_().m_171514_(-12, 51).m_171488_(-3.0F, -1.1602F, -0.9642F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -5.5F, 8.5F, 0.1309F, 0.0F, 0.0F));
      head_parts.m_171599_("head_parts_r9", CubeListBuilder.m_171558_().m_171514_(-12, 52).m_171488_(-3.0F, -1.2962F, -11.0025F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -5.5F, 8.5F, 0.6109F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition tail = body.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.0F, -1.9464F, 3.9481F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 8.7436F, 1.3668F, -0.5236F, 0.0F, 0.0F));
      tail.m_171599_("tail_r1", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171488_(-0.5F, 1.0F, 2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 4.7972F, 17.8149F, 0.6981F, 0.0F, 0.0F));
      tail.m_171599_("tail_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -1.75F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.4F)), PartPose.m_171423_(0.0F, 4.7972F, 17.8149F, 0.3054F, 0.0F, 0.0F));
      tail.m_171599_("tail_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.2F)), PartPose.m_171423_(0.0F, 4.7972F, 17.8149F, 0.1309F, 0.0F, 0.0F));
      tail.m_171599_("tail_r4", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.0F, -4.75F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 7.711F, 19.5676F, -0.0873F, 0.0F, 0.0F));
      tail.m_171599_("tail_r5", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.0F, -1.9352F, -1.1607F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.m_171423_(0.0F, 3.7721F, 14.3861F, -0.3491F, 0.0F, 0.0F));
      tail.m_171599_("tail_r6", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.0F, -1.874F, -3.1268F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(0.0F, 3.5721F, 14.3861F, -0.7418F, 0.0F, 0.0F));
      tail.m_171599_("tail_r7", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.0F, -1.9F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.0F, 1.9916F, 12.754F, -0.6109F, 0.0F, 0.0F));
      tail.m_171599_("tail_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -3.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 0.5473F, 9.9559F, -0.2182F, 0.0F, 0.0F));
      tail.m_171599_("tail_r9", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, 0.3705F, 2.3258F, 0.1745F, 0.0F, 0.0F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      right_arm.m_171599_("right_blade", CubeListBuilder.m_171558_().m_171514_(28, -18).m_171488_(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, 5.5F, 1.5F, -1.0392F, 0.2396F, -3.1333F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      left_arm.m_171599_("left_blade", CubeListBuilder.m_171558_().m_171514_(28, -18).m_171480_().m_171488_(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.0F, 5.5F, 1.5F, -1.0392F, -0.2396F, 3.1333F));
      partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
