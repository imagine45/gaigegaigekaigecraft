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

public class ModelMahitoHand4<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_mahito_hand_4"), "main");
   public final ModelPart hand_main;

   public ModelMahitoHand4(ModelPart root) {
      this.hand_main = root.m_171324_("hand_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition hand_main = partdefinition.m_171599_("hand_main", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 13.0F, -17.0F));
      PartDefinition head = hand_main.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 1.0F, -1.0F));
      head.m_171599_("haed_r1", CubeListBuilder.m_171558_().m_171514_(66, 49).m_171488_(30.0F, -7.0F, 8.4F, 9.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 29.0F, 0.0F, 1.5708F, 0.0F));
      head.m_171599_("haed_r2", CubeListBuilder.m_171558_().m_171514_(66, 49).m_171480_().m_171488_(-39.0F, -7.0F, 8.4F, 9.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 29.0F, 0.0F, -1.5708F, 0.0F));
      head.m_171599_("haed_r3", CubeListBuilder.m_171558_().m_171514_(4, 44).m_171488_(-7.5F, -0.8F, -6.5F, 15.0F, 1.0F, 13.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(0.0F, 10.6383F, -6.3074F, 1.5708F, 1.3963F, 1.5708F));
      head.m_171599_("haed_r4", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171488_(-9.0F, -1.0F, -8.5F, 17.0F, 1.0F, 17.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(0.0F, 8.5222F, -8.313F, 1.5708F, 1.3526F, 1.5708F));
      head.m_171599_("haed_r5", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-8.0F, 0.0F, -7.5F, 15.0F, 2.0F, 15.0F, new CubeDeformation(1.0F)).m_171514_(0, 40).m_171488_(-8.0F, -4.0F, -8.5F, 16.0F, 4.0F, 17.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(0.0F, -11.5222F, -8.313F, 1.5708F, 1.3526F, -1.5708F));
      head.m_171599_("haed_r6", CubeListBuilder.m_171558_().m_171514_(5, 5).m_171488_(-12.5F, -4.0F, -6.5F, 17.0F, 2.0F, 13.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(0.0F, -17.2717F, -6.5262F, 1.5708F, 1.3526F, -1.5708F));
      PartDefinition bone = head.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.5F, -6.9853F, -16.7122F));
      bone.m_171599_("haed_r7", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.0335F, -2.6942F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.5251F, -1.1243F, 2.6601F));
      bone.m_171599_("haed_r8", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.5216F, -3.0024F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.7974F, -1.2635F, 2.3682F));
      bone.m_171599_("haed_r9", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.9665F, -3.3058F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.3765F, -1.3484F, 1.7698F));
      bone.m_171599_("haed_r10", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.4784F, -3.0024F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(-9.0F, 0.0F, 0.0F, 0.7974F, 1.2635F, -2.3682F));
      bone.m_171599_("haed_r11", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.0335F, -3.3058F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(-9.0F, 0.0F, 0.0F, 1.3765F, 1.3484F, -1.7698F));
      bone.m_171599_("haed_r12", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.9665F, -2.6942F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(-9.0F, 0.0F, 0.0F, 0.5251F, 1.1243F, -2.6601F));
      bone.m_171599_("haed_r13", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.0335F, -3.3058F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 13.9707F, 1.0F, -0.5251F, -1.1243F, -2.6601F));
      bone.m_171599_("haed_r14", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.9665F, -2.6942F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 13.9707F, 1.0F, -1.3765F, -1.3484F, -1.7698F));
      bone.m_171599_("haed_r15", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.5216F, -2.9976F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 13.9707F, 1.0F, -0.7974F, -1.2635F, -2.3682F));
      bone.m_171599_("haed_r16", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.0335F, -2.6942F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(-9.0F, 13.9707F, 1.0F, -1.3765F, 1.3484F, 1.7698F));
      bone.m_171599_("haed_r17", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.4784F, -2.9976F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(-9.0F, 13.9707F, 1.0F, -0.7974F, 1.2635F, 2.3682F));
      bone.m_171599_("haed_r18", CubeListBuilder.m_171558_().m_171514_(0, 117).m_171488_(-1.9665F, -3.3058F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(-9.0F, 13.9707F, 1.0F, -0.5251F, 1.1243F, 2.6601F));
      PartDefinition body1 = hand_main.m_171599_("body1", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.9378F, -1.1068F));
      body1.m_171599_("body2_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(17.0F, -11.0F, -9.0F, 12.0F, 22.0F, 18.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-10.0F, -10.0F, -10.0F, 40.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0622F, 29.1068F, 0.0F, 1.5708F, 0.0F));
      PartDefinition body2 = body1.m_171599_("body2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -0.0311F, 32.4466F));
      body2.m_171599_("body2_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.8577F, -13.8708F, -10.0F, 40.0F, 20.0F, 20.0F, new CubeDeformation(-1.0F)), PartPose.m_171423_(0.0F, 1.0F, 32.0F, 1.5708F, 1.4835F, 1.5708F));
      PartDefinition body3 = body2.m_171599_("body3", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 27.0F));
      body3.m_171599_("body3_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-35.049F, -14.2189F, -10.0F, 40.0F, 20.0F, 20.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.0F, 1.0F, 0.0F, -1.5708F, 1.3963F, -1.5708F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.hand_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.hand_main.f_104204_ = netHeadYaw / 57.295776F;
      this.hand_main.f_104203_ = headPitch / 57.295776F;
   }
}
