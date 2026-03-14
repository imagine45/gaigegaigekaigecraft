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

public class Modelcursedspirit3_11<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_11"), "main");
   public final ModelPart LH;
   public final ModelPart RH;
   public final ModelPart bone8;
   public final ModelPart cube_r5;
   public final ModelPart cube_r4;
   public final ModelPart cube_r3;
   public final ModelPart cube_r2;
   public final ModelPart cube_r1;

   public Modelcursedspirit3_11(ModelPart root) {
      this.LH = root.m_171324_("LH");
      this.RH = root.m_171324_("RH");
      this.bone8 = root.m_171324_("bone8");
      this.cube_r5 = root.m_171324_("cube_r5");
      this.cube_r4 = root.m_171324_("cube_r4");
      this.cube_r3 = root.m_171324_("cube_r3");
      this.cube_r2 = root.m_171324_("cube_r2");
      this.cube_r1 = root.m_171324_("cube_r1");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition LH = partdefinition.m_171599_("LH", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(0.8766F, -1.5F, -9.6667F, 6.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(24, 0).m_171480_().m_171488_(6.8766F, -1.5F, -5.6667F, 6.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(24, 0).m_171480_().m_171488_(3.8766F, -1.5F, -7.6667F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(24, 0).m_171480_().m_171488_(-2.5F, -1.5F, -12.5F, 4.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(10.5F, 8.5F, 1.5F));
      LH.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-12.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(12.1949F, 0.0F, -5.8578F, 0.0F, -0.4363F, 0.0F));
      LH.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-12.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(12.1949F, 0.0F, 6.8578F, 0.0F, 0.4363F, 0.0F));
      PartDefinition bone10 = LH.m_171599_("bone10", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-0.8275F, -1.5F, -5.1667F, 6.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(24, 0).m_171480_().m_171488_(0.1725F, -1.5F, -1.1667F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(24, 0).m_171480_().m_171488_(4.1725F, -1.5F, -2.1667F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(24, 0).m_171480_().m_171488_(0.1725F, -1.5F, -0.8333F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(12.7041F, 0.0F, 0.5F));
      bone10.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(0.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5092F, 0.0F, -6.3578F, 0.0F, -0.4363F, 0.0F));
      bone10.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(0.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.5092F, 0.0F, 6.3578F, 0.0F, 0.4363F, 0.0F));
      PartDefinition RH = partdefinition.m_171599_("RH", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-6.8766F, -1.5F, -9.6667F, 6.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)).m_171514_(24, 0).m_171488_(-12.8766F, -1.5F, -5.6667F, 6.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(24, 0).m_171488_(-9.8766F, -1.5F, -7.6667F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(24, 0).m_171488_(-1.5F, -1.5F, -12.5F, 4.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-10.5F, 8.5F, 1.5F));
      RH.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-0.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-12.1949F, 0.0F, -5.8578F, 0.0F, 0.4363F, 0.0F));
      RH.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-0.5F, -1.5F, -1.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-12.1949F, 0.0F, 6.8578F, 0.0F, -0.4363F, 0.0F));
      PartDefinition bone4 = RH.m_171599_("bone4", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.1725F, -1.5F, -5.1667F, 6.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(24, 0).m_171488_(-14.1725F, -1.5F, -1.1667F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(24, 0).m_171488_(-10.1725F, -1.5F, -2.1667F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(24, 0).m_171488_(-14.1725F, -1.5F, -0.8333F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-12.7041F, 0.0F, 0.5F));
      bone4.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-15.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5092F, 0.0F, -6.3578F, 0.0F, 0.4363F, 0.0F));
      bone4.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-15.5F, -1.5F, -1.5F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5092F, 0.0F, 6.3578F, 0.0F, -0.4363F, 0.0F));
      PartDefinition bone8 = partdefinition.m_171599_("bone8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-7.0F, -3.0F, -31.0F, 14.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)).m_171514_(36, 97).m_171488_(-10.0F, -5.0F, -27.0F, 20.0F, 5.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 11.0F, 16.0F));
      PartDefinition bone5 = bone8.m_171599_("bone5", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-2.0F, -2.5F, -1.4139F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -2.5F, -5.5861F));
      bone5.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-2.0F, -2.5F, -18.0F, 7.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.1561F, 0.0F, 16.5123F, 0.0F, 0.1745F, 0.0F));
      bone5.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-5.0F, -2.5F, -18.0F, 7.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.1561F, 0.0F, 16.5123F, 0.0F, -0.1745F, 0.0F));
      PartDefinition bone6 = bone5.m_171599_("bone6", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-2.0F, -2.5F, -0.9131F, 4.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 8.4993F));
      bone6.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-2.0F, -2.5F, -9.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.1561F, 0.0F, 8.013F, 0.0F, 0.1745F, 0.0F));
      bone6.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-3.0F, -2.5F, -9.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.1561F, 0.0F, 8.013F, 0.0F, -0.1745F, 0.0F));
      PartDefinition bone7 = bone6.m_171599_("bone7", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-2.0F, -2.5F, -0.8394F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 13.9262F));
      bone7.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-2.0F, -2.5F, 5.0F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.1561F, 0.0F, -5.9132F, 0.0F, 0.1745F, 0.0F));
      bone7.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-2.0F, -2.5F, 5.0F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.1561F, 0.0F, -5.9132F, 0.0F, -0.1745F, 0.0F));
      partdefinition.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(5.0F, -5.0F, -11.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.1956F, 11.0F, 10.5857F, 0.0F, -1.1345F, 0.0F));
      partdefinition.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-10.0F, -5.0F, -11.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.1956F, 11.0F, 10.5857F, 0.0F, 1.1345F, 0.0F));
      partdefinition.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-1.5F, -2.5F, -5.5F, 3.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.1665F, 9.8383F, -14.9986F, 0.2618F, 0.3054F, 0.0F));
      partdefinition.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-1.5F, -2.5F, -5.5F, 3.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-7.1665F, 9.8383F, -14.9986F, 0.2618F, -0.3054F, 0.0F));
      partdefinition.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-7.0F, -1.5F, -2.0F, 14.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(24, 0).m_171488_(-7.0F, -1.5F, -2.5F, 14.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 8.2015F, -12.0915F, 0.4712F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.LH.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RH.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone8.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r5.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r4.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r3.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.cube_r1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RH.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.LH.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
