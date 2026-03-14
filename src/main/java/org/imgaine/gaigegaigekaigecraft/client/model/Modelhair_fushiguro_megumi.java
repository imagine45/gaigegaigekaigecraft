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

public class Modelhair_fushiguro_megumi<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelhair_fushiguro_megumi"), "main");
   public final ModelPart Head;

   public Modelhair_fushiguro_megumi(ModelPart root) {
      this.Head = root.m_171324_("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(32, 48).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.05F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-9.7201F, -28.4365F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(0.2675F, -21.4872F, -15.2874F, -1.5511F, -0.4799F, -1.5799F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.5847F, -33.4107F, 0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.3008F, -27.3477F, -17.1857F, -1.5471F, -0.7417F, -1.5868F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-8.4065F, -27.4447F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(0.3278F, -11.5028F, -18.7318F, -1.5531F, -0.1309F, -1.5731F));
      Head.m_171599_("Head_r4", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-10.7202F, -29.4361F, 0.2837F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(10.2623F, -23.8565F, -10.7406F, -0.7103F, -0.3166F, -1.9376F));
      Head.m_171599_("Head_r5", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-6.5849F, -34.4103F, 0.2837F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(11.3141F, -29.7801F, -11.8643F, -0.6233F, -0.4792F, -2.1606F));
      Head.m_171599_("Head_r6", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-9.4065F, -28.4443F, 0.2837F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(13.1519F, -13.645F, -13.3293F, -0.7629F, -0.0807F, -1.6744F));
      Head.m_171599_("Head_r7", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-11.3227F, -27.5248F, 1.6144F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(4.2565F, -21.4054F, -12.5723F, -0.9444F, -0.3498F, -1.8995F));
      Head.m_171599_("Head_r8", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-7.1903F, -32.5F, 1.6144F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(4.8975F, -26.8034F, -14.2395F, -0.8652F, -0.5562F, -2.0791F));
      Head.m_171599_("Head_r9", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-10.005F, -26.5328F, 1.6144F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(6.9167F, -11.8734F, -15.3542F, -0.9863F, -0.0617F, -1.6972F));
      Head.m_171599_("Head_r10", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-9.3903F, -32.6015F, -2.1827F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(22.9574F, -21.9238F, 4.8565F, 0.2083F, 0.1873F, -1.7694F));
      Head.m_171599_("Head_r11", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.459F, -37.4722F, -2.1827F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(25.854F, -28.2643F, 4.6667F, 0.1528F, 0.2346F, -2.0328F));
      Head.m_171599_("Head_r12", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-8.2732F, -32.5701F, -2.1827F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false).m_171514_(56, 56).m_171480_().m_171488_(-8.2732F, -31.3701F, -2.1827F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(22.9589F, -12.275F, 6.2401F, 0.2512F, 0.1233F, -1.4941F));
      Head.m_171599_("Head_r13", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(7.3903F, -32.0015F, -2.1827F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-22.3865F, -21.1853F, 4.7346F, 0.2083F, -0.1873F, 1.7694F));
      Head.m_171599_("Head_r14", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(3.459F, -36.8722F, -2.1827F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-25.3326F, -27.3809F, 4.5778F, 0.1528F, -0.2346F, 2.0328F));
      Head.m_171599_("Head_r15", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(6.2732F, -31.9701F, -2.1827F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171514_(56, 56).m_171488_(6.2732F, -30.7701F, -2.1827F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-22.378F, -11.7012F, 6.0921F, 0.2512F, -0.1233F, 1.4941F));
      Head.m_171599_("Head_r16", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-8.3557F, -29.6824F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(17.4802F, -23.8727F, 0.0F, 0.0F, 0.0F, -2.0508F));
      Head.m_171599_("Head_r17", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-4.4F, -34.4F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(19.1733F, -30.1631F, 0.0F, 0.0F, 0.0F, -2.3126F));
      Head.m_171599_("Head_r18", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-7.3192F, -30.4097F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(21.9912F, -10.3819F, 0.0F, 0.0F, 0.0F, -1.597F));
      Head.m_171599_("Head_r19", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-7.0192F, -29.1097F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(19.3116F, -17.2549F, 0.0F, 0.0F, 0.0F, -1.8588F));
      Head.m_171599_("Head_r20", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(5.9557F, -29.2824F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-17.7101F, -22.9332F, 0.0F, 0.0F, 0.0F, 2.0508F));
      Head.m_171599_("Head_r21", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(2.0F, -34.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-19.5487F, -29.198F, 0.0F, 0.0F, 0.0F, 2.3126F));
      Head.m_171599_("Head_r22", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(4.9192F, -30.0097F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-22.0018F, -9.5716F, 0.0F, 0.0F, 0.0F, 1.597F));
      Head.m_171599_("Head_r23", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(4.6192F, -28.7097F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-19.4416F, -16.3578F, 0.0F, 0.0F, 0.0F, 1.8588F));
      Head.m_171599_("Head_r24", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(5.1849F, -31.1807F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-20.7939F, -17.5227F, -11.2448F, -0.3838F, -0.0098F, 1.8083F));
      Head.m_171599_("Head_r25", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(1.2292F, -35.8983F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-23.7667F, -23.601F, -13.0403F, -0.3743F, 0.0876F, 2.0516F));
      Head.m_171599_("Head_r26", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(4.1484F, -31.9081F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-21.6165F, -2.7243F, -10.0189F, -0.3441F, -0.1738F, 1.3829F));
      Head.m_171599_("Head_r27", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(3.8484F, -30.6081F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-20.9188F, -10.3779F, -10.5467F, -0.3757F, -0.0811F, 1.6299F));
      Head.m_171599_("Head_r28", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-6.9849F, -31.2807F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(21.1312F, -17.4498F, -11.2803F, -0.3838F, 0.0098F, -1.8083F));
      Head.m_171599_("Head_r29", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-3.0292F, -35.9983F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(24.1399F, -23.5702F, -13.0942F, -0.3743F, -0.0876F, -2.0516F));
      Head.m_171599_("Head_r30", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.9484F, -32.0081F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(21.8711F, -2.6075F, -10.0176F, -0.3441F, 0.1738F, -1.3829F));
      Head.m_171599_("Head_r31", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.6484F, -30.7081F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(21.2236F, -10.2815F, -10.567F, -0.3757F, 0.0811F, -1.6299F));
      Head.m_171599_("Head_r32", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-6.1849F, -30.1807F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(12.721F, -14.1418F, -19.2878F, -0.7944F, -0.0651F, -1.7584F));
      Head.m_171599_("Head_r33", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-2.2292F, -34.8983F, 3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(15.1564F, -19.9169F, -22.4878F, -0.7647F, -0.2497F, -1.9466F));
      Head.m_171599_("Head_r34", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.1484F, -30.9081F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(13.1391F, 0.2F, -17.9014F, -0.7629F, 0.2565F, -1.4352F));
      Head.m_171599_("Head_r35", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-4.8484F, -29.6081F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(12.7201F, -7.1769F, -18.4076F, -0.794F, 0.0721F, -1.6239F));
      Head.m_171599_("Head_r36", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-3.9935F, -31.5803F, 3.5441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(3.7087F, -13.5607F, -25.5556F, -1.2279F, -0.1149F, -1.6786F));
      Head.m_171599_("Head_r37", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-0.0874F, -36.1224F, 3.5441F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.8338F, -19.6923F, -29.8801F, -1.2058F, -0.3606F, -1.7717F));
      Head.m_171599_("Head_r38", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-2.983F, -32.6209F, 3.5441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(3.9602F, 1.3929F, -23.4439F, -1.2122F, 0.3122F, -1.5231F));
      Head.m_171599_("Head_r39", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-2.6506F, -31.1414F, 3.5441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(3.76F, -6.307F, -24.3323F, -1.2295F, 0.0661F, -1.6142F));
      Head.m_171599_("Head_r40", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(1.9935F, -31.5803F, 3.5441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-3.7087F, -13.5607F, -25.5556F, -1.2279F, 0.1149F, 1.6786F));
      Head.m_171599_("Head_r41", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(-1.9126F, -36.1224F, 3.5441F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.8338F, -19.6923F, -29.8801F, -1.2058F, 0.3606F, 1.7717F));
      Head.m_171599_("Head_r42", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(0.983F, -32.6209F, 3.5441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-3.9602F, 1.3929F, -23.4439F, -1.2122F, -0.3122F, 1.5231F));
      Head.m_171599_("Head_r43", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(0.6506F, -31.1414F, 3.5441F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-3.76F, -6.307F, -24.3323F, -1.2295F, -0.0661F, 1.6142F));
      Head.m_171599_("Head_r44", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(4.1849F, -30.1807F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-12.721F, -14.1418F, -19.2878F, -0.7944F, 0.0651F, 1.7584F));
      Head.m_171599_("Head_r45", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(0.2292F, -34.8983F, 3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-15.1564F, -19.9169F, -22.4878F, -0.7647F, 0.2497F, 1.9466F));
      Head.m_171599_("Head_r46", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(3.1484F, -30.9081F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-13.1391F, 0.2F, -17.9014F, -0.7629F, -0.2565F, 1.4352F));
      Head.m_171599_("Head_r47", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(2.8484F, -29.6081F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-12.7201F, -7.1769F, -18.4076F, -0.794F, -0.0721F, 1.6239F));
      Head.m_171599_("Head_r48", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(0.9849F, -29.4807F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(4.8508F, -9.025F, -23.7524F, -1.5779F, 0.1275F, 1.6039F));
      Head.m_171599_("Head_r49", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(-2.9708F, -34.1983F, 3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.0781F, -14.6468F, -28.8822F, -1.5784F, 0.3893F, 1.6019F));
      Head.m_171599_("Head_r50", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(-0.0516F, -30.2081F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(4.3591F, 4.8549F, -20.9329F, -1.5783F, -0.3263F, 1.6072F));
      Head.m_171599_("Head_r51", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(-0.3516F, -28.9081F, 3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(4.6073F, -2.1924F, -22.1562F, -1.5779F, -0.0645F, 1.6052F));
      Head.m_171599_("Head_r52", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(6.4075F, -33.8644F, -2.3127F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-7.4844F, 8.6169F, -23.6289F, -1.2763F, -0.781F, 1.5426F));
      Head.m_171599_("Head_r53", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(2.6345F, -39.1303F, -2.3127F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-8.8107F, 7.2395F, -31.0042F, -1.3298F, -0.5284F, 1.6297F));
      Head.m_171599_("Head_r54", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(4.9007F, -32.4804F, -2.3127F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-6.6367F, 14.1745F, -14.8932F, -1.1488F, -1.0433F, 1.3829F));
      Head.m_171599_("Head_r55", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-6.2225F, -33.1787F, -3.2524F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(2.363F, 20.0277F, 12.6079F, 1.1539F, -1.2144F, -1.2175F));
      Head.m_171599_("Head_r56", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-2.5465F, -38.3366F, -3.2524F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(3.5149F, 22.6302F, 19.9411F, 1.3196F, -0.966F, -1.4029F));
      Head.m_171599_("Head_r57", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-4.6466F, -31.9335F, -3.2524F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(0.9254F, 20.6019F, 2.3836F, 0.3295F, -1.4209F, -0.3731F));
      Head.m_171599_("Head_r58", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(7.7201F, -28.4365F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-6.9408F, -21.4872F, -13.6235F, -1.0494F, 0.4241F, 1.8029F));
      Head.m_171599_("Head_r59", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(3.5847F, -33.4107F, 0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-7.8027F, -27.3477F, -15.3152F, -0.9661F, 0.646F, 1.965F));
      Head.m_171599_("Head_r60", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(6.4065F, -27.4447F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-8.5046F, -11.5029F, -16.693F, -1.0961F, 0.1166F, 1.6305F));
      Head.m_171599_("Head_r61", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(6.3622F, -33.6226F, -1.4047F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-16.4874F, 9.7498F, -18.7796F, -0.7711F, -0.8864F, 1.2847F));
      Head.m_171599_("Head_r62", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(2.5892F, -38.8884F, -1.4047F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-19.967F, 9.2367F, -25.4955F, -0.9441F, -0.6872F, 1.5272F));
      Head.m_171599_("Head_r63", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(4.8555F, -32.2386F, -1.4047F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-13.4199F, 14.1255F, -9.9481F, -0.4337F, -1.0477F, 0.8779F));
      Head.m_171599_("Head_r64", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(5.5816F, -34.6734F, -2.2063F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-24.8885F, 8.7735F, -3.9637F, -0.0702F, -0.3065F, 0.84F));
      Head.m_171599_("Head_r65", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(1.7173F, -39.8152F, -2.2063F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-32.2022F, 7.3743F, -6.1713F, -0.149F, -0.2777F, 1.1118F));
      Head.m_171599_("Head_r66", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(4.204F, -33.3909F, -2.2063F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.m_171423_(-16.5679F, 14.3126F, -0.7164F, 0.0198F, -0.3136F, 0.5467F));
      Head.m_171599_("Head_r67", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-7.3321F, -33.5216F, 0.4889F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(18.072F, 15.5753F, -3.3672F, -0.0581F, 0.2375F, -0.5393F));
      Head.m_171599_("Head_r68", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-3.6565F, -38.4307F, 0.4889F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(25.3785F, 16.2677F, -5.0588F, -0.1184F, 0.2142F, -0.8069F));
      Head.m_171599_("Head_r69", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.8268F, -32.5321F, 0.4889F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.5F)).m_171555_(false), PartPose.m_171423_(8.5192F, 18.6369F, -0.8665F, 0.0109F, 0.2441F, -0.2517F));
      Head.m_171599_("Head_r70", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.7321F, -34.0216F, -3.2111F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(17.8721F, 16.5837F, 3.676F, 0.0701F, -0.3244F, -0.5426F));
      Head.m_171599_("Head_r71", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-2.0565F, -38.9307F, -3.2111F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(25.3664F, 17.5987F, 6.009F, 0.1538F, -0.295F, -0.8158F));
      Head.m_171599_("Head_r72", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-4.9443F, -35.3439F, -3.2111F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(2.2951F, 22.1995F, -2.0246F, -0.1017F, -0.3162F, -0.0087F));
      Head.m_171599_("Head_r73", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-4.2268F, -33.0321F, -3.2111F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.5F)).m_171555_(false), PartPose.m_171423_(8.2655F, 19.1813F, 0.2558F, -0.0255F, -0.3307F, -0.2475F));
      Head.m_171599_("Head_r74", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-9.1755F, -33.6273F, -2.1256F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(20.6259F, 11.4705F, -7.0345F, -0.1337F, 0.3424F, -0.6951F));
      Head.m_171599_("Head_r75", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-5.4994F, -38.248F, -2.1256F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(27.3302F, 10.9047F, -9.5495F, -0.2194F, 0.2961F, -0.9666F));
      Head.m_171599_("Head_r76", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-9.3335F, -34.6779F, -2.1256F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false), PartPose.m_171423_(5.0448F, 20.5756F, -0.2653F, 0.0894F, 0.356F, -0.0625F));
      Head.m_171599_("Head_r77", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-7.7674F, -32.9255F, -2.1256F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(12.2509F, 16.1592F, -3.4203F, -0.0301F, 0.3654F, -0.3982F));
      Head.m_171599_("Head_r78", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171488_(6.4879F, -29.7594F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171514_(56, 56).m_171488_(6.4879F, -28.4594F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-16.5791F, -21.3048F, 0.0F, 0.0F, 0.0F, 2.0508F));
      Head.m_171599_("Head_r79", CubeListBuilder.m_171558_().m_171514_(56, 56).m_171480_().m_171488_(-8.4879F, -29.7594F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).m_171555_(false).m_171514_(56, 56).m_171480_().m_171488_(-8.4879F, -28.4594F, 0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(16.5791F, -21.3048F, 0.0F, 0.0F, 0.0F, -2.0508F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
