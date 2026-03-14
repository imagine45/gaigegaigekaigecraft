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

public class Modelcursedspirit3_18<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_18"), "main");
   public final ModelPart head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit3_18(ModelPart root) {
      this.head = root.m_171324_("head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-4.0F, 11.0F, -21.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(79, 122).m_171488_(-4.0F, 10.7F, -21.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).m_171514_(79, 122).m_171488_(-4.0F, 4.2F, -21.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).m_171514_(0, 123).m_171488_(-4.0F, 9.0F, -21.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).m_171514_(8, 0).m_171488_(-7.0F, 1.0F, -20.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-3.0F, 0.0F, -20.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171480_().m_171488_(3.0F, 1.0F, -20.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(8, 0).m_171480_().m_171488_(7.0F, 2.0F, -19.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(8, 0).m_171488_(-11.0F, 2.0F, -19.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-8.0F, -6.0F, -18.0F, 16.0F, 21.0F, 19.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-6.0F, -8.0F, -16.0F, 12.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(112, 0).m_171488_(2.5F, -3.0F, -18.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(112, 0).m_171480_().m_171488_(-6.5F, -3.0F, -18.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(8, 0).m_171488_(5.0F, -3.0F, -16.0F, 5.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171480_().m_171488_(-10.0F, -3.0F, -16.0F, 5.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(8, 0).m_171488_(-4.0F, 2.0F, -21.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -10.0F, 1.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 123).m_171488_(-4.0F, -1.5F, -1.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 5.5F, -20.0F, 0.0F, 0.0F, -3.1416F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(84, 119).m_171480_().m_171488_(-3.8F, -1.5F, -6.2F, 1.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(84, 119).m_171488_(2.8F, -1.5F, -6.2F, 1.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)).m_171514_(79, 121).m_171488_(-4.0F, -1.3F, -6.2F, 8.0F, 1.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 11.2F, -18.5F, -1.5708F, 0.0F, 0.0F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-12.5F, -11.5F, 10.5F, 25.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -0.5F, 19.5F, -0.3054F, 0.0F, 0.0F));
      Body.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(15, 0).m_171480_().m_171488_(-13.5F, -10.5F, -10.5F, 28.0F, 19.0F, 21.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5F, -4.0F, 4.0F, -0.2618F, 0.0F, 0.0F));
      Body.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(17, 0).m_171480_().m_171488_(-12.5F, -13.9F, -12.5F, 26.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5F, 4.0F, 4.0F, 0.5236F, 0.0F, 0.0F));
      Body.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(17, 0).m_171488_(-13.5F, -10.5F, -10.5F, 27.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 4.0F, -11.0F, -0.2618F, 0.0F, 0.0F));
      Body.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171480_().m_171488_(-14.5F, -10.5F, -10.5F, 29.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -4.0F, -11.0F, 0.2618F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-11.3468F, -4.4608F, 2.3701F));
      RightArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.9911F, -4.9963F, -2.1253F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-12.0032F, 26.1644F, -20.0358F, -0.741F, 0.6943F, 1.0055F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-5.5164F, -4.3118F, -2.7574F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-12.0032F, 26.1644F, -20.0358F, -1.4939F, -0.5522F, -0.745F));
      RightArm.m_171599_("RightArm_r2", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-6.5145F, -3.0495F, -0.7214F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-12.0032F, 26.1644F, -20.0358F, -0.877F, -0.9552F, -0.7064F));
      RightArm.m_171599_("RightArm_r3", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-6.905F, -0.3272F, -0.5049F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-12.0032F, 26.1644F, -20.0358F, -0.8073F, -1.1064F, -0.7416F));
      RightArm.m_171599_("RightArm_r4", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-6.5043F, 2.0154F, -0.9787F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-12.0032F, 26.1644F, -20.0358F, -0.2473F, -1.0975F, -1.2875F));
      RightArm.m_171599_("RightArm_r5", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-0.6023F, -3.8774F, -1.212F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-12.0032F, 26.1644F, -20.0358F, -0.6154F, -0.7973F, -1.0399F));
      RightArm.m_171599_("RightArm_r6", CubeListBuilder.m_171558_().m_171514_(17, 0).m_171480_().m_171488_(-8.0F, -4.0F, -4.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(-3.0874F, 5.6898F, -2.6233F, -0.632F, -0.5542F, -0.9892F));
      RightArm.m_171599_("RightArm_r7", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171480_().m_171488_(-10.0F, -5.0F, -7.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.8382F, 17.536F, -7.1704F, -0.4768F, -0.4975F, -1.2665F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_(), PartPose.m_171419_(11.3468F, -4.4608F, 2.3701F));
      LeftArm.m_171599_("RightArm_r8", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-6.0089F, -4.9963F, -2.1253F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(12.0032F, 26.1644F, -20.0358F, -0.741F, -0.6943F, -1.0055F));
      LeftArm.m_171599_("LeftArm_r2", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-2.4836F, -4.3118F, -2.7574F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(12.0032F, 26.1644F, -20.0358F, -1.4939F, 0.5522F, 0.745F));
      LeftArm.m_171599_("LeftArm_r3", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(0.5145F, -3.0495F, -0.7214F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(12.0032F, 26.1644F, -20.0358F, -0.877F, 0.9552F, 0.7064F));
      LeftArm.m_171599_("LeftArm_r4", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.095F, -0.3272F, -0.5049F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(12.0032F, 26.1644F, -20.0358F, -0.8073F, 1.1064F, 0.7416F));
      LeftArm.m_171599_("LeftArm_r5", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-1.4957F, 2.0154F, -0.9787F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(12.0032F, 26.1644F, -20.0358F, -0.2473F, 1.0975F, 1.2875F));
      LeftArm.m_171599_("LeftArm_r6", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-7.3977F, -3.8774F, -1.212F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(12.0032F, 26.1644F, -20.0358F, -0.6154F, 0.7973F, 1.0399F));
      LeftArm.m_171599_("LeftArm_r7", CubeListBuilder.m_171558_().m_171514_(17, 0).m_171488_(-8.0F, -4.0F, -4.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(3.0874F, 5.6898F, -2.6233F, -0.632F, 0.5542F, 0.9892F));
      LeftArm.m_171599_("LeftArm_r8", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171488_(-6.0F, -5.0F, -7.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.8382F, 17.536F, -7.1704F, -0.4768F, 0.4975F, 1.2665F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.8281F, 4.1539F, 34.3889F));
      RightLeg.m_171599_("LeftArm_r9", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(2.3479F, -4.2851F, 3.2732F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, -1.1078F, 0.4485F, 0.804F));
      RightLeg.m_171599_("RightArm_r9", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-9.9015F, -6.5424F, 2.1692F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, -1.1083F, -0.8097F, -0.9916F));
      RightLeg.m_171599_("RightArm_r10", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-9.4198F, -2.9402F, 5.6049F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, -0.1785F, -1.1742F, -1.3266F));
      RightLeg.m_171599_("RightArm_r11", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-9.2569F, -0.2928F, 6.0482F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, 0.2052F, -1.2611F, -1.6927F));
      RightLeg.m_171599_("RightArm_r12", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-9.6857F, 1.9243F, 5.2137F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, 0.5978F, -1.0574F, -2.0418F));
      RightLeg.m_171599_("RightArm_r13", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-5.0339F, -3.9332F, 4.1577F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, -0.0382F, -0.9213F, -1.483F));
      RightLeg.m_171599_("RightArm_r14", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-3.5701F, -5.3243F, -10.2318F, 19.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, 0.0197F, -1.0476F, -1.4893F));
      RightLeg.m_171599_("RightArm_r15", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-8.7795F, -5.1083F, -2.1129F, 17.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.9882F, 10.6082F, -5.9699F, -0.0755F, 1.2592F, -1.5853F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.8281F, 4.1539F, 34.3889F));
      LeftLeg.m_171599_("RightArm_r16", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171480_().m_171488_(-10.3479F, -4.2851F, 3.2732F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, -1.1078F, -0.4485F, -0.804F));
      LeftLeg.m_171599_("LeftArm_r10", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(1.9015F, -6.5424F, 2.1692F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, -1.1083F, 0.8097F, 0.9916F));
      LeftLeg.m_171599_("LeftArm_r11", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(3.4198F, -2.9402F, 5.6049F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, -0.1785F, 1.1742F, 1.3266F));
      LeftLeg.m_171599_("LeftArm_r12", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(1.2569F, -0.2928F, 6.0482F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, 0.2052F, 1.2611F, 1.6927F));
      LeftLeg.m_171599_("LeftArm_r13", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(1.6857F, 1.9243F, 5.2137F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, 0.5978F, 1.0574F, 2.0418F));
      LeftLeg.m_171599_("LeftArm_r14", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-2.9661F, -3.9332F, 4.1577F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, -0.0382F, 0.9213F, 1.483F));
      LeftLeg.m_171599_("LeftArm_r15", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-15.4299F, -5.3243F, -10.2318F, 19.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, 0.0197F, 1.0476F, 1.4893F));
      LeftLeg.m_171599_("LeftArm_r16", CubeListBuilder.m_171558_().m_171514_(8, 0).m_171488_(-8.2205F, -5.1083F, -2.1129F, 17.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.9882F, 10.6082F, -5.9699F, -0.0755F, -1.2592F, 1.5853F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
