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

public class ModelPiercing_Ox<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_piercing_ox"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg;
   public final ModelPart LeftArm;
   public final ModelPart RightArm;

   public ModelPiercing_Ox(ModelPart root) {
      this.head = root.m_171324_("head");
      this.body = root.m_171324_("body");
      this.LeftLeg = root.m_171324_("LeftLeg");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightArm = root.m_171324_("RightArm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 42).m_171488_(-7.0F, -8.0F, -12.0F, 14.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.5F, -1.0F, -18.0F, 11.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 96).m_171488_(-5.5F, -1.0F, -17.0F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.1F)).m_171514_(-2, -2).m_171488_(-5.5F, 5.4F, -18.0F, 11.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(3, 3).m_171488_(-5.5F, 3.0F, -14.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(76, 109).m_171488_(-7.5F, 0.5F, -20.0F, 15.0F, 8.0F, 11.0F, new CubeDeformation(-2.25F)).m_171514_(110, 3).m_171488_(-2.5F, -1.2F, -18.2F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(90, 0).m_171488_(6.0F, -7.9F, -11.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(90, 0).m_171488_(7.5F, -11.4F, -11.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)).m_171514_(90, 0).m_171480_().m_171488_(-11.5F, -11.4F, -11.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(90, 0).m_171480_().m_171488_(-10.0F, -7.9F, -11.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 111).m_171488_(-6.5F, -11.2F, -15.2F, 13.0F, 10.0F, 7.0F, new CubeDeformation(-2.9F)), PartPose.m_171419_(0.0F, 2.0F, -17.0F));
      head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(91, 0).m_171480_().m_171488_(-3.2F, -1.6F, -2.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-9.5F, -12.4F, -9.5F, 0.0F, 0.0F, -0.7854F));
      head.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(91, 0).m_171488_(-0.8F, -1.6F, -2.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(9.5F, -12.4F, -9.5F, 0.0F, 0.0F, 0.7854F));
      head.m_171599_("head_r3", CubeListBuilder.m_171558_().m_171514_(41, 124).m_171488_(-5.5F, -1.5F, 0.6F, 11.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 8.4F, -16.8F, 0.3927F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-12.0F, -20.0F, -23.0F, 24.0F, 20.0F, 22.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.0F, -24.0F, -22.0F, 22.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.0F, 0.0F, -22.0F, 22.0F, 18.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-9.0F, 12.0F, -21.0F, 18.0F, 9.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -14.0F, 4.0F, 1.5708F, 0.0F, 0.0F));
      body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(116, 22).m_171488_(-3.0F, -4.0F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 34.7782F, -18.7279F, -0.9553F, -0.5236F, 0.6155F));
      body.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(116, 22).m_171488_(-3.0F, -4.0F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 34.7782F, -18.7279F, -0.9553F, 0.5236F, -0.6155F));
      body.m_171599_("body_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, 1.5F, -4.5F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 27.0F, -6.0F, -0.7854F, 0.0F, 0.0F));
      body.m_171599_("body_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -9.0F, -5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 27.0F, -6.0F, -0.3927F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171488_(-1.5F, 22.0F, 1.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.m_171419_(8.0F, 0.0F, 14.0F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -7.0F, -2.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.5F, 15.884F, 5.799F, -0.2618F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.6618F, 4.5794F, 2.3108F, 0.2618F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171480_().m_171488_(-2.5F, 22.0F, 1.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171419_(-8.0F, 0.0F, 14.0F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -7.0F, -2.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-0.5F, 15.884F, 5.799F, -0.2618F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-0.6618F, 4.5794F, 2.3108F, 0.2618F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171488_(-0.5F, 20.0F, -9.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.m_171419_(10.0F, 2.0F, -6.0F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(1.6618F, 3.5794F, -0.6892F, 0.3927F, 0.0F, 0.0F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -5.0F, -1.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(2.0F, 14.0F, -3.0F, -0.5236F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(106, 0).m_171480_().m_171488_(-3.5F, 20.0F, -9.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171419_(-10.0F, 2.0F, -6.0F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-1.6618F, 3.5794F, -0.6892F, 0.3927F, 0.0F, 0.0F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.0F, -5.0F, -1.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-2.0F, 14.0F, -3.0F, -0.5236F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
