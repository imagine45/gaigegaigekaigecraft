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

public class Modelcursedspirit3_12<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_12"), "main");
   public final ModelPart bone;

   public Modelcursedspirit3_12(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 164).m_171488_(-10.0F, -8.0F, -10.0F, 20.0F, 8.0F, 20.0F, new CubeDeformation(1.0F)).m_171514_(0, 7).m_171488_(-10.0F, -59.5F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(0.1F)).m_171514_(80, 172).m_171488_(-8.5F, -62.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(0, 131).m_171488_(-12.5F, -16.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(0.0F)).m_171514_(0, 39).m_171488_(-13.5F, -48.0F, -13.5F, 27.0F, 8.0F, 27.0F, new CubeDeformation(0.0F)).m_171514_(0, 74).m_171488_(-16.5F, -40.0F, -16.5F, 33.0F, 24.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 131).m_171488_(-12.5F, -4.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(-3.6957F, -18.8729F, 0.0F, 0.0F, -1.5708F, -0.5236F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171480_().m_171488_(-10.0F, -6.0F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(-2.0278F, -49.6462F, 0.0F, 0.0F, -1.5708F, 0.3927F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(80, 172).m_171488_(-8.5F, -1.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-1.1929F, -57.5975F, 0.0F, 0.0F, -1.5708F, 0.3927F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 131).m_171488_(-12.5F, -4.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(0.0F, -18.8729F, 3.6957F, -0.5236F, 0.0F, 0.0F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(112, 35).m_171488_(-10.0F, -6.0F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(0.0F, -49.6462F, 2.0278F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(80, 172).m_171488_(-8.5F, -1.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(0.0F, -57.5975F, 1.1929F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 131).m_171488_(-12.5F, -4.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(3.6957F, -18.8729F, 0.0F, 0.0F, 1.5708F, 0.5236F));
      bone.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 39).m_171480_().m_171488_(-13.5F, -4.0F, -13.5F, 27.0F, 8.0F, 27.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(-2.5496F, -38.2932F, 0.0F, 0.0F, 0.0F, 0.3927F));
      bone.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 39).m_171488_(-13.5F, -4.0F, -13.5F, 27.0F, 8.0F, 27.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(2.5496F, -38.2932F, 0.0F, 0.0F, 0.0F, -0.3927F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(84, 0).m_171488_(-13.5F, 1.3442F, -15.4313F, 27.0F, 8.0F, 27.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(0.0F, -43.9697F, 2.2887F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171488_(-10.0F, -6.0F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(2.0278F, -49.6462F, 0.0F, 0.0F, 1.5708F, -0.3927F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(80, 172).m_171488_(-8.5F, -1.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(1.1929F, -57.5975F, 0.0F, 0.0F, 1.5708F, -0.3927F));
      bone.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 39).m_171488_(-13.5F, -3.9F, -13.1F, 27.0F, 8.0F, 27.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, -38.478F, -2.4731F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 131).m_171488_(-12.5F, -9.8F, -8.8F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(0.0F, -12.0F, -4.0F, 0.5236F, 0.0F, 0.0F));
      bone.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(80, 172).m_171488_(-8.5F, 2.1F, -8.3F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(0.0F, -61.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 7).m_171488_(-10.0F, -2.12F, -7.99F, 20.0F, 12.0F, 20.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(0.0F, -54.0F, -2.4F, -0.3927F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 192, 192);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
