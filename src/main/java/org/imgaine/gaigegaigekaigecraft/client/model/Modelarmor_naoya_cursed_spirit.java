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

public class Modelarmor_naoya_cursed_spirit<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelarmor_naoya_cursed_spirit"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart steve;

   public Modelarmor_naoya_cursed_spirit(ModelPart root) {
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
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 19).m_171488_(-2.5F, 22.0F, -1.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171480_().m_171488_(-2.35F, 3.75F, -2.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.4F, 7.2F, -0.5F, 0.0F, 0.0F, -0.5236F));
      body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171488_(-0.65F, 3.75F, -2.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-0.4F, 7.2F, -0.5F, 0.0F, 0.0F, 0.5236F));
      body.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171488_(-3.0F, -1.0721F, 1.4733F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.5F, 14.1537F, -1.0F, 0.5236F, 0.0F, 0.0F));
      body.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171480_().m_171488_(-3.0F, -1.0721F, -4.4733F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.5F, 14.1537F, 1.0F, -0.5236F, 0.0F, 0.0F));
      body.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171488_(-2.5F, -4.1062F, 2.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-0.5F, 17.0799F, 0.0F, 0.5236F, -0.7854F, 0.0F));
      body.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171480_().m_171488_(-2.5F, -4.1062F, -5.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.5F, 17.0799F, 0.0F, -0.5236F, -0.7854F, 0.0F));
      body.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171480_().m_171488_(-2.5F, -4.1062F, 2.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.5F, 17.0799F, 0.0F, 0.5236F, 0.7854F, 0.0F));
      body.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(16, 20).m_171488_(-2.5F, -4.1062F, -5.0703F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-0.5F, 17.0799F, 0.0F, -0.5236F, 0.7854F, 0.0F));
      body.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.5F, -4.0F, -2.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.5613F, 20.0929F, 0.0F, 0.0F, 0.0F, 0.2618F));
      body.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-1.5F, -4.0F, -2.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.5613F, 20.0929F, 0.0F, 0.0F, 0.0F, -0.2618F));
      body.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(2, 21).m_171480_().m_171488_(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.5745F, 21.3853F, 0.0F, 0.0F, 0.0F, -1.0472F));
      body.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(2, 21).m_171488_(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.5745F, 21.3853F, 0.0F, 0.0F, 0.0F, 1.0472F));
      body.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-2.5F, -4.3968F, -1.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 20.3968F, 2.5F, -0.1745F, 0.0F, 0.0F));
      body.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-2.5F, -4.3968F, -2.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 20.3968F, -2.5F, 0.1745F, 0.0F, 0.0F));
      body.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-1.5F, -1.5644F, 2.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, 17.0799F, 0.0F, -0.1745F, -0.7854F, 0.0F));
      body.m_171599_("Body_r16", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-2.5F, -1.5644F, -5.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5F, 17.0799F, 0.0F, 0.1745F, -0.7854F, 0.0F));
      body.m_171599_("Body_r17", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-2.5F, -1.5644F, 2.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.5F, 17.0799F, 0.0F, -0.1745F, 0.7854F, 0.0F));
      body.m_171599_("Body_r18", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-1.5F, -1.5644F, -5.038F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5F, 17.0799F, 0.0F, 0.1745F, 0.7854F, 0.0F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("steve", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(40, 16).m_171480_().m_171488_(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(40, 16).m_171488_(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171480_().m_171488_(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 16).m_171488_(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
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
