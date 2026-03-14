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

public class Modelcockroach_warm<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcockroach_warm"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart right_arm2;
   public final ModelPart right_arm3;
   public final ModelPart left_arm;
   public final ModelPart left_arm2;
   public final ModelPart left_arm3;

   public Modelcockroach_warm(ModelPart root) {
      this.head = root.m_171324_("head");
      this.body = root.m_171324_("body");
      this.right_arm = root.m_171324_("right_arm");
      this.right_arm2 = root.m_171324_("right_arm2");
      this.right_arm3 = root.m_171324_("right_arm3");
      this.left_arm = root.m_171324_("left_arm");
      this.left_arm2 = root.m_171324_("left_arm2");
      this.left_arm3 = root.m_171324_("left_arm3");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 19.6495F, -3.7131F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(2.0996F, -3.3241F, 1.1727F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, -2.3582F, 0.4658F, 2.8627F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(2.0996F, -3.1094F, 2.8351F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, -1.1801F, 0.4658F, 2.8627F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(2.0996F, -3.0611F, 3.7988F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.45F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, -0.3947F, 0.4658F, 2.8627F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(4, 4).m_171488_(-1.5F, 1.0794F, -1.5809F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -1.5311F, -2.3161F, 2.7925F, 0.0F, 3.1416F));
      head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-3.0996F, -3.0611F, 3.7988F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.45F)), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, -0.3947F, -0.4658F, -2.8627F));
      head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-3.0996F, -3.1094F, 2.8351F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, -1.1801F, -0.4658F, -2.8627F));
      head.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-3.0996F, -3.3241F, 1.1727F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, -2.3582F, -0.4658F, -2.8627F));
      head.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(6, 6).m_171480_().m_171488_(0.2F, -1.05F, 1.3F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(6, 6).m_171480_().m_171488_(0.5F, -1.05F, 1.2F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(6, 6).m_171480_().m_171488_(0.8F, -1.05F, 1.1F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(6, 6).m_171488_(-0.2F, -1.05F, 1.3F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(6, 6).m_171488_(-0.5F, -1.05F, 1.2F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(6, 6).m_171488_(-0.8F, -1.05F, 1.1F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(3, 3).m_171488_(-1.5F, -0.55F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 3.4582F, -1.9039F, 3.1416F, 0.0F, 3.1416F));
      head.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(6, 6).m_171480_().m_171488_(0.2F, 0.5595F, 2.3722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(6, 6).m_171480_().m_171488_(0.5F, 0.5595F, 2.2722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(6, 6).m_171480_().m_171488_(0.8F, 0.5595F, 2.1722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(6, 6).m_171488_(-0.2F, 0.5595F, 2.3722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(6, 6).m_171488_(-0.5F, 0.5595F, 2.2722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(2, 2).m_171488_(-1.5F, -0.2405F, -1.5278F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.1F)).m_171514_(6, 6).m_171488_(-0.8F, 0.5595F, 2.1722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(2, 2).m_171480_().m_171488_(-2.0F, 0.2595F, -1.5278F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(2, 2).m_171488_(1.0F, 0.2595F, -1.5278F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.309F, -1.8147F, 2.7925F, 0.0F, 3.1416F));
      head.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(18, 21).m_171488_(-2.8062F, -0.4922F, 3.2219F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, 3.1416F, 0.0F, -2.4435F));
      head.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(18, 21).m_171480_().m_171488_(0.8062F, -0.4922F, 3.2219F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, 3.1416F, 0.0F, 2.4435F));
      head.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(7, 1).m_171480_().m_171488_(0.7F, -0.616F, 2.4119F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(7, 1).m_171488_(-2.7F, -0.616F, 2.4119F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(4, 4).m_171488_(-2.0F, -1.616F, -1.2881F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(1, 1).m_171488_(-2.5F, -0.616F, -1.7881F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.3874F, -1.2161F, 3.1416F, 0.0F, 3.1416F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 21.9994F, 2.5657F));
      body.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.5F, -6.9351F, -3.8067F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.6581F, 0.0F, 3.1416F));
      body.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -6.6464F, -3.3536F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -0.7132F, 2.7841F, 1.6581F, 0.0F, 3.1416F));
      body.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-2.0F, -3.0F, 0.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.0F, -5.479F, -0.9293F, 1.6581F, -0.1745F, -2.8798F));
      body.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(-2.0F, -3.0F, 0.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.0F, -5.479F, -0.9293F, 1.6581F, 0.1745F, 2.8798F));
      body.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-2.5F, -0.4521F, -3.298F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -0.7132F, 2.7841F, 1.8326F, 0.0F, 3.1416F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.9325F, 23.0843F, -2.7419F));
      right_arm.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(-0.3F, -4.474F, 0.3358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-3.5F, -0.6F, -0.5F, 1.6023F, 0.6621F, -0.8259F));
      right_arm.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(-3.4F, -0.6F, -0.5F, 0.4912F, 1.3157F, -0.7499F));
      PartDefinition right_arm2 = partdefinition.m_171599_("right_arm2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.7325F, 22.9843F, 2.4581F));
      right_arm2.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(-0.5F, -4.074F, 0.2358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-3.7F, -0.5F, -0.7F, -2.8349F, 1.5448F, 1.0324F));
      right_arm2.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(-3.6F, -0.5F, -0.7F, 0.4912F, 1.3157F, -0.7499F));
      PartDefinition right_arm3 = partdefinition.m_171599_("right_arm3", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.7325F, 23.2843F, 5.8419F));
      right_arm3.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(-0.2F, -5.574F, -1.2358F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.0F, -1.0F, 0.4F, -1.6013F, -0.6185F, -0.8275F));
      right_arm3.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171480_().m_171488_(-0.5F, -0.9092F, -1.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-3.6F, -0.8F, 0.4F, -0.4912F, -1.3157F, -0.7499F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.9325F, 23.0843F, -2.7419F));
      left_arm.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-0.7F, -4.474F, 0.3358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(3.5F, -0.6F, -0.5F, 1.6023F, -0.6621F, 0.8259F));
      left_arm.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(3.4F, -0.6F, -0.5F, 0.4912F, -1.3157F, 0.7499F));
      PartDefinition left_arm2 = partdefinition.m_171599_("left_arm2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.7325F, 22.9843F, 2.4581F));
      left_arm2.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-0.5F, -4.074F, 0.2358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(3.7F, -0.5F, -0.7F, -2.8349F, -1.5448F, -1.0324F));
      left_arm2.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(3.6F, -0.5F, -0.7F, 0.4912F, -1.3157F, 0.7499F));
      PartDefinition left_arm3 = partdefinition.m_171599_("left_arm3", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.7325F, 23.2843F, 5.8419F));
      left_arm3.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-0.8F, -5.574F, -1.2358F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.0F, -1.0F, 0.4F, -1.6013F, 0.6185F, 0.8275F));
      left_arm3.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-0.5F, -0.9092F, -1.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(3.6F, -0.8F, 0.4F, -0.4912F, 1.3157F, 0.7499F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_arm3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_arm2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_arm2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_arm3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
