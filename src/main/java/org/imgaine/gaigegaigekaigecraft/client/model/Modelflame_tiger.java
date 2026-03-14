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

public class Modelflame_tiger<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelflame_tiger"), "main");
   public final ModelPart bone;

   public Modelflame_tiger(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      PartDefinition head2 = bone.m_171599_("head2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition neck = head2.m_171599_("neck", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -7.0F, -8.0F));
      PartDefinition neck2 = neck.m_171599_("neck2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, -10.0F));
      PartDefinition neck3 = neck2.m_171599_("neck3", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, -10.0F));
      PartDefinition neck4 = neck3.m_171599_("neck4", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, -10.0F));
      PartDefinition neck5 = neck4.m_171599_("neck5", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, -10.0F));
      PartDefinition head = neck5.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -50.0F, -10.0F));
      PartDefinition head_r1 = head.m_171599_("head_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-4.0F, 18.0F, 49.96F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r1_r2 = head_r1.m_171599_("head_r1_r2", CubeListBuilder.m_171558_(), PartPose.m_171423_(4.2182F, 1.0E-4F, -64.1819F, -0.1309F, 0.0F, 0.0F));
      PartDefinition head_r1_r2_r1 = head_r1_r2.m_171599_("head_r1_r2_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-0.0814F, -4.5431F, 42.051F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r1_r3 = head_r1.m_171599_("head_r1_r3", CubeListBuilder.m_171558_(), PartPose.m_171423_(4.05F, 12.8001F, -65.8501F, 0.1745F, 0.0F, 0.0F));
      PartDefinition head_r1_r3_r1 = head_r1_r3.m_171599_("head_r1_r3_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0868F, -4.0052F, 45.3363F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r2_r1 = head_r1.m_171599_("head_r2_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-15.0F, -17.9998F, -17.0F, 0.0F, 0.0F, 0.4363F));
      PartDefinition head_r2_r1_r1 = head_r2_r1.m_171599_("head_r2_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(25.3668F, 9.119F, -4.8976F, -1.5227F, 0.4359F, -0.416F));
      PartDefinition head_r1_r1 = head_r1.m_171599_("head_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(12.0F, -17.9998F, -17.0F, 0.0F, 0.0F, -0.4363F));
      PartDefinition head_r1_r1_r1 = head_r1_r1.m_171599_("head_r1_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-15.1492F, 13.8831F, -4.8976F, -1.5227F, -0.4359F, 0.416F));
      PartDefinition head_r2 = head.m_171599_("head_r2", CubeListBuilder.m_171558_(), PartPose.m_171423_(6.0F, -5.0F, 59.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r2_r2 = head_r2.m_171599_("head_r2_r2", CubeListBuilder.m_171558_(), PartPose.m_171423_(-5.8632F, -8.0554F, -44.8976F, -1.5272F, 0.0F, 0.0F));
      head_r2_r2.m_171599_("head_r3_r3_r1", CubeListBuilder.m_171558_().m_171514_(0, 129).m_171488_(-25.0F, -37.7853F, 15.4996F, 50.0F, 41.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.2368F, -2.7143F, -4.8154F, -0.0873F, 0.0F, 0.0F));
      head_r2_r2.m_171599_("head_r2_r2_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-25.0F, -19.6546F, -16.603F, 50.0F, 35.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.2368F, -2.7143F, -4.8154F, 0.5236F, 0.0F, 0.0F));
      PartDefinition head_r3 = head.m_171599_("head_r3", CubeListBuilder.m_171558_(), PartPose.m_171423_(8.0F, -69.0F, 61.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r3_r2 = head_r3.m_171599_("head_r3_r2", CubeListBuilder.m_171558_(), PartPose.m_171423_(-7.8632F, -10.0557F, -108.8976F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r6_r1 = head_r3.m_171599_("head_r6_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-15.0F, -24.3238F, 48.5452F, 2.4871F, 0.0F, 0.0F));
      PartDefinition head_r6_r1_r1 = head_r6_r1.m_171599_("head_r6_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(7.1368F, -107.1641F, 116.2225F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r5_r1 = head_r3.m_171599_("head_r5_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-15.0F, -2.3355F, 77.6293F, -2.4871F, 0.0F, 0.0F));
      PartDefinition head_r5_r1_r1 = head_r5_r1.m_171599_("head_r5_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(7.1368F, 119.6743F, 143.2827F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r4_r1 = head_r3.m_171599_("head_r4_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-14.5F, -31.0001F, -52.9998F, -0.6109F, 0.0F, 0.0F));
      PartDefinition head_r4_r1_r1 = head_r4_r1.m_171599_("head_r4_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(6.6368F, 49.2195F, -33.7738F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r3_r1 = head_r3.m_171599_("head_r3_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-14.5F, -31.0001F, -52.9998F, 0.1745F, 0.0F, 0.0F));
      PartDefinition head_r3_r1_r1 = head_r3_r1.m_171599_("head_r3_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(6.6368F, 10.9216F, -58.6852F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r4 = head.m_171599_("head_r4", CubeListBuilder.m_171558_(), PartPose.m_171423_(8.0F, -165.0F, 61.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r5 = head.m_171599_("head_r5", CubeListBuilder.m_171558_(), PartPose.m_171423_(8.0F, -133.0F, 61.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r6 = head.m_171599_("head_r6", CubeListBuilder.m_171558_(), PartPose.m_171423_(8.0F, -101.0F, 61.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r7 = head.m_171599_("head_r7", CubeListBuilder.m_171558_(), PartPose.m_171423_(8.0F, -37.0F, 61.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r7_r1 = head_r7.m_171599_("head_r7_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-7.8632F, -10.0555F, -76.8976F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r8 = head.m_171599_("head_r8", CubeListBuilder.m_171558_(), PartPose.m_171423_(4.0F, 4.0F, 90.96F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r8_r1 = head_r8.m_171599_("head_r8_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-3.95F, -28.1999F, -79.85F, 0.1745F, 0.0F, 0.0F));
      PartDefinition head_r8_r1_r1 = head_r8_r1.m_171599_("head_r8_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0868F, -4.0052F, 45.3364F, -1.5272F, 0.0F, 0.0F));
      PartDefinition head_r9 = head.m_171599_("head_r9", CubeListBuilder.m_171558_(), PartPose.m_171423_(4.0F, 16.0F, 58.96F, 1.5708F, 0.0F, 0.0F));
      PartDefinition head_r9_r1 = head_r9.m_171599_("head_r9_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-3.7818F, -8.9999F, -66.1819F, -0.1309F, 0.0F, 0.0F));
      PartDefinition head_r9_r1_r1 = head_r9_r1.m_171599_("head_r9_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-0.0814F, -4.5431F, 42.0511F, -1.5272F, 0.0F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r5_r5_r1", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-24.76F, -4.1746F, -7.8497F, 3.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(21.84F, -4.1746F, -7.8497F, 3.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-22.16F, -16.1746F, -7.8497F, 44.0F, 22.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-22.16F, -4.1746F, -9.8497F, 44.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(1, 0).m_171488_(-16.16F, -12.1746F, -13.8497F, 33.0F, 19.0F, 11.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-6.16F, -7.3327F, -15.7323F, 12.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-21.76F, 4.7913F, -7.5208F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(16.84F, 4.7913F, -7.5208F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-20.76F, 17.7913F, -6.5208F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.4F)).m_171514_(34, 89).m_171488_(17.84F, 17.7913F, -6.5208F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.4F)).m_171514_(34, 89).m_171488_(-20.76F, 13.7913F, -6.5208F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(17.84F, 13.7913F, -6.5208F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.0768F, -11.6948F, -53.9294F, 0.2618F, 0.0F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r7_r7_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-17.25F, -3.618F, -4.8126F, 34.0F, 16.0F, 27.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-26.25F, 0.8941F, -2.5226F, 53.0F, 26.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0132F, -47.0254F, -16.72F, 0.6109F, 0.0F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r6_r6_r2", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-17.25F, -5.9116F, -20.1994F, 34.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-26.25F, -0.3994F, -16.9094F, 53.0F, 25.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0132F, -47.0254F, -16.72F, 1.0908F, 0.0F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r5_r5_r2", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-17.0F, -0.0807F, -5.7775F, 34.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-26.0F, 4.4314F, -2.4875F, 53.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.2368F, -32.6212F, -32.5744F, 0.829F, 0.0F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r10_r10_r10_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.6266F, 21.1253F, -39.0877F, 10.0F, 14.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(1.3622F, 13.2122F, -32.5354F, 10.0F, 14.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(3.712F, -12.0634F, -11.6062F, 10.0F, 14.0F, 20.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(2.8478F, -2.7675F, -19.3036F, 10.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(2.055F, 5.7602F, -26.3648F, 10.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-33.4152F, -43.3514F, -1.2037F, 0.7418F, -0.9599F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r9_r9_r1", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-11.8782F, 21.9603F, -34.1372F, 11.0F, 14.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-11.1426F, 14.0473F, -27.5849F, 11.0F, 14.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-8.7928F, -11.2283F, -6.6557F, 11.0F, 14.0F, 20.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-9.657F, -1.9324F, -14.3531F, 11.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-10.4498F, 6.5952F, -21.4143F, 11.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(28.9632F, -40.6225F, -1.3791F, 0.7418F, 0.9599F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r9_r9_r2", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-6.0322F, 9.2888F, -25.1492F, 11.0F, 6.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.4598F, -84.7004F, 5.2872F, 1.0036F, 0.3054F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r8_r8_r1", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(3.3932F, 6.658F, -29.2054F, 11.0F, 6.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-17.0368F, -86.7078F, 6.9676F, 1.0036F, -0.3054F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r8_r8_r2", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(20.591F, 36.4119F, -7.8697F, 11.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-20.9312F, -84.8835F, 5.252F, 1.0036F, 0.8727F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r7_r7_r2", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-7.9615F, 11.3907F, -25.973F, 11.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-17.0368F, -86.7078F, 6.9676F, 1.0036F, -0.8727F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r7_r7_r3", CubeListBuilder.m_171558_().m_171514_(0, 66).m_171488_(-23.5F, 7.1587F, -23.1821F, 46.0F, 26.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.2632F, -64.3515F, 23.4766F, 0.1309F, 0.0F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r6_r6_r3", CubeListBuilder.m_171558_().m_171514_(95, 23).m_171488_(-2.3982F, 15.5574F, -17.7347F, 9.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(19.4632F, -53.1405F, -28.15F, 0.829F, 0.48F, 0.3054F));
      head_r9_r1_r1.m_171599_("head_r9_r5_r5_r3", CubeListBuilder.m_171558_().m_171514_(88, 28).m_171488_(-8.1245F, 15.7761F, -16.8001F, 9.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-18.7368F, -53.1405F, -28.15F, 0.829F, -0.48F, -0.3054F));
      head_r9_r1_r1.m_171599_("head_r9_r3_r3_r1", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-17.0F, 1.2396F, -20.8798F, 34.0F, 16.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.2368F, -32.6212F, -32.5744F, 0.3054F, 0.0F, 0.0F));
      head_r9_r1_r1.m_171599_("head_r9_r2_r2_r1", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(-22.1333F, -3.2533F, -18.3884F, 44.0F, 17.0F, 37.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-25.7333F, 2.7467F, -18.3884F, 4.0F, 12.0F, 37.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(21.8667F, 2.7467F, -18.3884F, 4.0F, 12.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.1035F, -22.4433F, -32.2439F, 0.1309F, 0.0F, 0.0F));
      PartDefinition jaw = head.m_171599_("jaw", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 70.0F, 58.92F, 0.6109F, 0.0F, 0.0F));
      PartDefinition jaw_r1 = jaw.m_171599_("jaw_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition jaw_r1_r1 = jaw_r1.m_171599_("jaw_r1_r1", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.1368F, 10.7342F, 29.2324F, -1.5272F, 0.0F, 0.0F));
      jaw_r1_r1.m_171599_("jaw_r5_r5_r1", CubeListBuilder.m_171558_().m_171514_(50, 0).m_171488_(21.45F, -1.618F, -18.1041F, 3.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(-24.45F, -1.618F, -19.1041F, 3.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0132F, -20.3954F, -11.3204F, -1.1781F, 0.0F, 0.0F));
      jaw_r1_r1.m_171599_("jaw_r4_r4_r1", CubeListBuilder.m_171558_().m_171514_(50, 0).m_171488_(41.4F, -1.7043F, -24.8226F, 3.0F, 10.0F, 35.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(-4.5F, -1.7043F, -25.8226F, 3.0F, 10.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-19.9368F, -3.4558F, -17.1513F, -1.8762F, 0.0F, 0.0F));
      PartDefinition ago = bone.m_171599_("ago", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, -1.6F, -21.5F, -0.2182F, 0.0F, 0.0F));
      ago.m_171599_("head_r9_r6_r6_r1", CubeListBuilder.m_171558_().m_171514_(34, 89).m_171488_(31.8F, -17.4097F, 8.1097F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-5.5F, -17.4097F, 8.1097F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(32.8F, -4.4097F, 9.1097F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.4F)).m_171514_(34, 89).m_171488_(-4.5F, -4.4097F, 9.1097F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.4F)).m_171514_(34, 89).m_171488_(32.8F, -8.4097F, 9.1097F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(34, 89).m_171488_(-4.5F, -8.4097F, 9.1097F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-15.6F, 9.755F, -21.2548F, -2.7052F, 0.0F, 0.0F));
      ago.m_171599_("jaw_r3_r3_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-21.5F, 0.4345F, -24.7069F, 43.0F, 7.0F, 28.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(-24.3F, -2.5655F, -24.7069F, 3.0F, 7.0F, 28.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(21.5F, -2.5655F, -24.7069F, 3.0F, 7.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.4749F, -2.4928F, 1.0472F, 0.0F, 0.0F));
      ago.m_171599_("jaw_r4_r4_r2", CubeListBuilder.m_171558_().m_171514_(50, 0).m_171488_(-24.3F, -1.3123F, -13.7367F, 3.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(21.5F, -1.3123F, -13.7367F, 3.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(-21.5F, 1.6877F, -14.7367F, 43.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 15.6549F, -11.6127F, 0.7854F, 0.0F, 0.0F));
      ago.m_171599_("jaw_r3_r3_r2", CubeListBuilder.m_171558_().m_171514_(50, 0).m_171488_(-24.3667F, -4.6362F, -6.0553F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(21.4333F, -4.6362F, -6.0553F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(50, 0).m_171488_(-21.5667F, -2.6362F, -8.0553F, 43.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0667F, 29.3206F, -21.5656F, 0.4363F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 212, 212);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.bone.f_104204_ = netHeadYaw / 57.295776F;
      this.bone.f_104203_ = headPitch / 57.295776F;
   }
}
