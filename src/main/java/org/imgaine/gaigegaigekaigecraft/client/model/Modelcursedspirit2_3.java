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

public class Modelcursedspirit2_3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_2_3"), "main");
   public final ModelPart Worm;

   public Modelcursedspirit2_3(ModelPart root) {
      this.Worm = root.m_171324_("Worm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Worm = partdefinition.m_171599_("Worm", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      PartDefinition Head = Worm.m_171599_("Head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -13.7093F, -8.4062F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(0, 94).m_171488_(-13.0F, -12.7169F, -8.8739F, 26.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -6.8008F, -18.3455F, -1.9635F, 0.0F, 3.1416F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(8, 7).m_171480_().m_171488_(-15.0F, -10.0F, -9.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 7.7093F, -3.0171F, -1.9635F, 0.0F, 0.0F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(8, 7).m_171480_().m_171488_(-15.0F, -10.0F, -12.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -9.2907F, -3.0171F, -1.1781F, 0.0F, 0.0F));
      Head.m_171599_("Head_r4", CubeListBuilder.m_171558_().m_171514_(8, 7).m_171480_().m_171488_(-15.0F, -11.0F, -25.0F, 30.0F, 20.0F, 22.0F, new CubeDeformation(-2.15F)).m_171555_(false), PartPose.m_171423_(0.0F, 13.7093F, -4.0171F, -1.5708F, 0.0F, 0.0F));
      Head.m_171599_("Head_r5", CubeListBuilder.m_171558_().m_171514_(0, 94).m_171488_(-13.0F, -7.0F, -9.5F, 26.0F, 12.0F, 16.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 8.9654F, -13.3033F, -1.9635F, 0.0F, 0.0F));
      PartDefinition bone2 = Head.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.1F, 4.3506F, -10.8651F));
      bone2.m_171599_("Head_r6", CubeListBuilder.m_171558_().m_171514_(15, 123).m_171488_(1.3174F, 4.3247F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.1F, -0.0354F, -0.4243F, -1.5708F, 1.0472F, 1.5708F));
      bone2.m_171599_("Head_r7", CubeListBuilder.m_171558_().m_171514_(4, 123).m_171480_().m_171488_(-12.0F, 4.3247F, -15.8174F, 25.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.1F, -0.0354F, -0.4243F, -0.5236F, 0.0F, -3.1416F));
      bone2.m_171599_("Head_r8", CubeListBuilder.m_171558_().m_171514_(0, 94).m_171480_().m_171488_(-13.0F, -7.1753F, -0.1826F, 26.0F, 12.0F, 16.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(74, 95).m_171480_().m_171488_(-7.5F, 4.8247F, -1.1826F, 15.0F, 1.0F, 12.0F, new CubeDeformation(1.1F)).m_171555_(false), PartPose.m_171423_(0.1F, -0.0354F, -0.4243F, -2.618F, 0.0F, 0.0F));
      bone2.m_171599_("Head_r9", CubeListBuilder.m_171558_().m_171514_(15, 123).m_171480_().m_171488_(-15.3174F, 4.3247F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.1F, -0.0354F, -0.4243F, -1.5708F, -1.0472F, -1.5708F));
      PartDefinition bone = Head.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.125F, -5.8008F, -11.4661F));
      bone.m_171599_("Head_r10", CubeListBuilder.m_171558_().m_171514_(15, 123).m_171488_(-14.6924F, 4.9497F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.125F, 0.0F, 0.1768F, -1.5708F, -1.0472F, 1.5708F));
      bone.m_171599_("Head_r11", CubeListBuilder.m_171558_().m_171514_(15, 123).m_171480_().m_171488_(0.6924F, 4.9497F, -13.0F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.125F, 0.0F, 0.1768F, -1.5708F, 1.0472F, -1.5708F));
      bone.m_171599_("Head_r12", CubeListBuilder.m_171558_().m_171514_(0, 94).m_171480_().m_171488_(-13.0F, -6.5503F, -0.8076F, 26.0F, 12.0F, 16.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.125F, 0.0F, 0.1768F, -2.618F, 0.0F, 3.1416F));
      bone.m_171599_("Head_r13", CubeListBuilder.m_171558_().m_171514_(4, 123).m_171480_().m_171488_(-12.0F, 4.9497F, -15.1924F, 25.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.125F, 0.0F, 0.1768F, -0.5236F, 0.0F, 0.0F));
      PartDefinition Body2 = Worm.m_171599_("Body2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-1.4F)).m_171555_(false), PartPose.m_171419_(0.0F, -14.6206F, -11.9568F));
      Body2.m_171599_("Body2_r1", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.4F)), PartPose.m_171423_(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body2.m_171599_("Body2_r2", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.35F)), PartPose.m_171423_(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body3 = Body2.m_171599_("Body3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-1.8F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 24.0F));
      Body3.m_171599_("Body3_r1", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.8F)), PartPose.m_171423_(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body3.m_171599_("Body3_r2", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.75F)), PartPose.m_171423_(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body4 = Body3.m_171599_("Body4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.2F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 23.0F));
      Body4.m_171599_("Body4_r1", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.2F)), PartPose.m_171423_(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body4.m_171599_("Body4_r2", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.15F)), PartPose.m_171423_(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body5 = Body4.m_171599_("Body5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-15.0F, -4.1294F, -3.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.1F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 23.0F));
      Body5.m_171599_("Body5_r1", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.1F)), PartPose.m_171423_(0.375F, -3.3794F, 16.7685F, -2.8798F, 0.0F, 0.0F));
      Body5.m_171599_("Body5_r2", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-1.95F)), PartPose.m_171423_(0.0F, -3.4264F, 7.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body6 = Body5.m_171599_("Body6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-15.0F, -4.1294F, -6.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-2.5F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 24.0F));
      Body6.m_171599_("Body6_r1", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.5F)), PartPose.m_171423_(0.375F, -3.3794F, 13.7685F, -2.8798F, 0.0F, 0.0F));
      Body6.m_171599_("Body6_r2", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-2.35F)), PartPose.m_171423_(0.0F, -3.4264F, 4.0561F, 0.2618F, 0.0F, -3.1416F));
      PartDefinition Body7 = Body6.m_171599_("Body7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-15.0F, -4.1294F, -8.0661F, 30.0F, 22.0F, 30.0F, new CubeDeformation(-4.1F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 19.0F));
      Body7.m_171599_("Body7_r1", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.375F, -10.0F, -11.25F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-4.1F)), PartPose.m_171423_(0.375F, -3.3794F, 11.7685F, -2.8798F, 0.0F, 0.0F));
      Body7.m_171599_("Body7_r2", CubeListBuilder.m_171558_().m_171514_(0, 52).m_171488_(-16.0F, -10.0F, -11.0F, 32.0F, 20.0F, 22.0F, new CubeDeformation(-3.95F)), PartPose.m_171423_(0.0F, -3.4264F, 2.0561F, 0.2618F, 0.0F, -3.1416F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Worm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Worm.f_104204_ = netHeadYaw / 57.295776F;
      this.Worm.f_104203_ = headPitch / 57.295776F;
   }
}
