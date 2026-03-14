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

public class Modelcursedspirit3_14<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_14"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightFeather;
   public final ModelPart LeftFeather;
   public final ModelPart RightArm1;
   public final ModelPart RightArm2;
   public final ModelPart RightArm3;
   public final ModelPart LeftArm1;
   public final ModelPart LeftArm2;
   public final ModelPart LeftArm3;

   public Modelcursedspirit3_14(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightFeather = root.m_171324_("RightFeather");
      this.LeftFeather = root.m_171324_("LeftFeather");
      this.RightArm1 = root.m_171324_("RightArm1");
      this.RightArm2 = root.m_171324_("RightArm2");
      this.RightArm3 = root.m_171324_("RightArm3");
      this.LeftArm1 = root.m_171324_("LeftArm1");
      this.LeftArm2 = root.m_171324_("LeftArm2");
      this.LeftArm3 = root.m_171324_("LeftArm3");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-3.0F, -3.5F, -7.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(1, 1).m_171488_(-4.0F, -2.5F, -8.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(8, 0).m_171488_(-3.0F, -2.5F, -9.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 7.0F, -3.0F));
      PartDefinition bone = Head.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.0F, -2.0F, -26.0F));
      PartDefinition Head_r10 = bone.m_171599_("Head_r10", CubeListBuilder.m_171558_().m_171514_(0, 57).m_171488_(-1.8F, 14.0815F, -2.3536F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 57).m_171480_().m_171488_(-6.2F, 14.0815F, -2.3536F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(6.0F, -8.0F, 8.0F, 0.7854F, 0.0F, 0.0F));
      Head_r10.m_171599_("Head_r11_r1", CubeListBuilder.m_171558_().m_171514_(0, 57).m_171488_(0.6F, -0.2138F, -1.0042F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 57).m_171480_().m_171488_(-2.6F, -0.2138F, -1.0042F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.0F, 16.3133F, -3.5854F, 0.3491F, 0.0F, 0.0F));
      PartDefinition Head_r11 = bone.m_171599_("Head_r11", CubeListBuilder.m_171558_().m_171514_(0, 57).m_171488_(3.2114F, 12.554F, -2.0433F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.7929F, -4.4645F, 6.5858F, 0.7854F, 0.0F, 0.3927F));
      Head_r11.m_171599_("Head_r12_r1", CubeListBuilder.m_171558_().m_171514_(0, 57).m_171488_(1.5769F, -0.1722F, -3.911F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.3752F, 14.7314F, -0.0036F, 0.2182F, 0.0F, 0.0F));
      PartDefinition Head_r12 = bone.m_171599_("Head_r12", CubeListBuilder.m_171558_().m_171514_(0, 57).m_171480_().m_171488_(-4.2114F, 12.554F, -2.0433F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.2071F, -4.4645F, 6.5858F, 0.7854F, 0.0F, -0.3927F));
      Head_r12.m_171599_("Head_r13_r1", CubeListBuilder.m_171558_().m_171514_(0, 57).m_171480_().m_171488_(-2.5769F, -0.1722F, -3.911F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.3752F, 14.7314F, -0.0036F, 0.2182F, 0.0F, 0.0F));
      PartDefinition eyes = Head.m_171599_("eyes", CubeListBuilder.m_171558_().m_171514_(56, 0).m_171480_().m_171488_(3.4F, -19.0F, 13.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(56, 0).m_171488_(3.4F, -19.5F, 14.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)).m_171514_(56, 0).m_171480_().m_171488_(-4.4F, -19.5F, 14.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)).m_171555_(false).m_171514_(56, 0).m_171488_(-4.4F, -19.0F, 13.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 17.0F, -20.0F));
      eyes.m_171599_("eyes_r2_r1", CubeListBuilder.m_171558_().m_171514_(56, 0).m_171488_(-5.0F, -31.0F, -19.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.02F)).m_171514_(56, 0).m_171480_().m_171488_(2.8F, -31.0F, -19.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.02F)).m_171555_(false), PartPose.m_171423_(0.6F, 0.4999F, -14.0001F, -1.5708F, 0.0F, 0.0F));
      partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -3.5145F, 1.0908F, 10.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-3.5F, -2.0F, -0.9053F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.5F, -3.0F, -0.9053F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -3.0F, 8.0947F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-6.0F, -4.0F, 11.0947F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.0F, -3.0F, 20.0947F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -1.5F, 23.0947F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.0F, -2.0F, 8.0947F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 7.0F, -4.0F));
      PartDefinition RightFeather = partdefinition.m_171599_("RightFeather", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.3848F, 4.5093F, 0.3595F));
      RightFeather.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(-4, 46).m_171488_(-19.5F, 1.0F, -2.0F, 19.0F, 0.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.5F, -1.0F, -1.0F, 0.4532F, 0.4309F, 0.2787F));
      RightFeather.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(-2, 42).m_171488_(-6.5F, 0.0F, -2.0F, 13.0F, 0.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.5F, -1.0F, -1.0F, 0.1745F, 0.0F, 0.0F));
      PartDefinition LeftFeather = partdefinition.m_171599_("LeftFeather", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.3848F, 4.5093F, 0.3595F));
      LeftFeather.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(-4, 46).m_171480_().m_171488_(0.5F, 1.0F, -2.0F, 19.0F, 0.0F, 6.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-0.5F, -1.0F, -1.0F, 0.4532F, -0.4309F, -0.2787F));
      LeftFeather.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(-2, 42).m_171480_().m_171488_(-6.5F, 0.0F, -2.0F, 13.0F, 0.0F, 4.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.5F, -1.0F, -1.0F, 0.1745F, 0.0F, 0.0F));
      PartDefinition RightArm1 = partdefinition.m_171599_("RightArm1", CubeListBuilder.m_171558_(), PartPose.m_171423_(2.9172F, 10.3978F, -2.6618F, 0.0F, 0.0F, 0.0873F));
      RightArm1.m_171599_("Body_r19_r1", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171488_(1.541F, 7.2109F, 9.4823F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.4357F, -10.5107F, -7.6864F, -0.2618F, 0.0F, 0.3927F));
      RightArm1.m_171599_("Body_r18_r1", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171488_(1.7452F, 2.5829F, 10.0089F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(4.1764F, -3.9733F, -9.3463F, -0.2618F, 0.0F, 0.0436F));
      RightArm1.m_171599_("Body_r17_r1", CubeListBuilder.m_171558_().m_171514_(42, 53).m_171488_(10.0985F, 4.0781F, 9.3002F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(4.1764F, -3.9733F, -9.3463F, -0.2756F, 0.0056F, 0.7525F));
      PartDefinition RightArm2 = partdefinition.m_171599_("RightArm2", CubeListBuilder.m_171558_(), PartPose.m_171423_(2.9172F, 10.3978F, -0.6618F, 0.1201F, -0.4205F, -0.2875F));
      RightArm2.m_171599_("Body_r20_r1", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171488_(0.9183F, 8.1891F, 8.9684F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.3216F, -11.0225F, -6.9368F, -0.2618F, 0.0F, 0.3927F));
      RightArm2.m_171599_("Body_r19_r2", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171488_(0.8824F, 3.3081F, 9.4273F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(5.0623F, -4.4851F, -8.5967F, -0.2618F, 0.0F, 0.0436F));
      RightArm2.m_171599_("Body_r18_r2", CubeListBuilder.m_171558_().m_171514_(42, 53).m_171488_(11.4123F, 2.3313F, 8.8438F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(5.0623F, -4.4851F, -8.5967F, -0.2618F, 0.0873F, 1.0472F));
      PartDefinition RightArm3 = partdefinition.m_171599_("RightArm3", CubeListBuilder.m_171558_(), PartPose.m_171423_(2.9172F, 10.3978F, 3.3382F, 0.1946F, -0.3931F, -0.4752F));
      RightArm3.m_171599_("Body_r21_r1", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171488_(-1.1457F, 8.846F, 9.1445F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.4888F, -10.8609F, -6.9368F, -0.2618F, 0.0F, 0.3927F));
      RightArm3.m_171599_("Body_r20_r2", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171488_(-1.2897F, 3.2435F, 9.41F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(7.2295F, -4.3235F, -8.5967F, -0.2618F, 0.0F, 0.0436F));
      RightArm3.m_171599_("Body_r19_r3", CubeListBuilder.m_171558_().m_171514_(42, 53).m_171488_(10.1934F, 4.0937F, 9.2056F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(7.2295F, -4.3235F, -8.5967F, -0.2618F, 0.0873F, 1.0472F));
      PartDefinition LeftArm1 = partdefinition.m_171599_("LeftArm1", CubeListBuilder.m_171558_(), PartPose.m_171423_(-2.9172F, 10.3978F, -2.6618F, 0.0F, 0.0F, -0.0873F));
      LeftArm1.m_171599_("Body_r20_r3", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171480_().m_171488_(-9.541F, 7.2109F, 9.4823F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.4357F, -10.5107F, -7.6864F, -0.2618F, 0.0F, -0.3927F));
      LeftArm1.m_171599_("Body_r19_r4", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171480_().m_171488_(-3.7452F, 2.5829F, 10.0089F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-4.1764F, -3.9733F, -9.3463F, -0.2618F, 0.0F, -0.0436F));
      LeftArm1.m_171599_("Body_r18_r3", CubeListBuilder.m_171558_().m_171514_(42, 53).m_171480_().m_171488_(-11.0985F, 4.0781F, 9.3002F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-4.1764F, -3.9733F, -9.3463F, -0.2756F, -0.0056F, -0.7525F));
      PartDefinition LeftArm2 = partdefinition.m_171599_("LeftArm2", CubeListBuilder.m_171558_(), PartPose.m_171423_(-2.9172F, 10.3978F, -0.6618F, 0.1201F, 0.4205F, 0.2875F));
      LeftArm2.m_171599_("Body_r21_r2", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171480_().m_171488_(-8.9183F, 8.1891F, 8.9684F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.3216F, -11.0225F, -6.9368F, -0.2618F, 0.0F, -0.3927F));
      LeftArm2.m_171599_("Body_r20_r4", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171480_().m_171488_(-2.8824F, 3.3081F, 9.4273F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-5.0623F, -4.4851F, -8.5967F, -0.2618F, 0.0F, -0.0436F));
      LeftArm2.m_171599_("Body_r19_r5", CubeListBuilder.m_171558_().m_171514_(42, 53).m_171480_().m_171488_(-12.4123F, 2.3313F, 8.8438F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-5.0623F, -4.4851F, -8.5967F, -0.2618F, -0.0873F, -1.0472F));
      PartDefinition LeftArm3 = partdefinition.m_171599_("LeftArm3", CubeListBuilder.m_171558_(), PartPose.m_171423_(-2.9172F, 10.3978F, 3.3382F, 0.1946F, 0.3931F, 0.4752F));
      LeftArm3.m_171599_("Body_r22_r1", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171480_().m_171488_(-6.8543F, 8.846F, 9.1445F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.4888F, -10.8609F, -6.9368F, -0.2618F, 0.0F, -0.3927F));
      LeftArm3.m_171599_("Body_r21_r3", CubeListBuilder.m_171558_().m_171514_(43, 53).m_171480_().m_171488_(-0.7103F, 3.2435F, 9.41F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-7.2295F, -4.3235F, -8.5967F, -0.2618F, 0.0F, -0.0436F));
      LeftArm3.m_171599_("Body_r20_r5", CubeListBuilder.m_171558_().m_171514_(42, 53).m_171480_().m_171488_(-11.1934F, 4.0937F, 9.2056F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-7.2295F, -4.3235F, -8.5967F, -0.2618F, -0.0873F, -1.0472F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightFeather.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftFeather.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Head.f_104204_ = netHeadYaw / 57.295776F;
      this.Head.f_104203_ = headPitch / 57.295776F;
      this.RightFeather.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftFeather.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
