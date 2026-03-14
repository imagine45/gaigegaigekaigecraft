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

public class Modeldagon1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modeldagon_1"), "main");
   public final ModelPart bone6;

   public Modeldagon1(ModelPart root) {
      this.bone6 = root.m_171324_("bone6");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone6 = partdefinition.m_171599_("bone6", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 21.76F, 0.0F));
      PartDefinition bone5 = bone6.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171423_(-0.32F, 0.96F, -2.24F, -0.2618F, 0.0F, 0.0F));
      PartDefinition bone4 = bone5.m_171599_("bone4", CubeListBuilder.m_171558_().m_171514_(13, 57).m_171488_(-7.556F, -11.7584F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(16, 57).m_171488_(-7.156F, -10.1984F, -6.88F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).m_171514_(16, 56).m_171488_(-7.196F, -10.7984F, -6.88F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(10.836F, 0.9184F, 0.0F));
      bone4.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(19, 54).m_171488_(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone4.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(15, 54).m_171488_(-4.4F, -16.4F, -7.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone4.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(14, 55).m_171488_(-4.4F, -12.12F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      PartDefinition bone3 = bone5.m_171599_("bone3", CubeListBuilder.m_171558_().m_171514_(13, 57).m_171488_(-7.556F, -11.7584F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(16, 57).m_171488_(-7.156F, -10.1984F, -6.56F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).m_171514_(16, 56).m_171488_(-7.196F, -10.7984F, -6.56F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(7.956F, 0.9184F, 0.0F));
      bone3.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(19, 54).m_171488_(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone3.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(15, 54).m_171488_(-4.4F, -16.4F, -7.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone3.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(14, 55).m_171488_(-4.4F, -12.12F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      PartDefinition bone2 = bone5.m_171599_("bone2", CubeListBuilder.m_171558_().m_171514_(13, 57).m_171488_(-7.556F, -11.7584F, -6.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(16, 57).m_171488_(-7.156F, -10.1984F, -5.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).m_171514_(16, 56).m_171488_(-7.196F, -10.7984F, -5.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.404F, 0.9184F, -11.84F, 0.0F, 3.1416F, 0.0F));
      bone2.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(19, 54).m_171488_(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone2.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(11, 54).m_171488_(-4.4F, -16.4F, -6.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone2.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(15, 55).m_171488_(-4.4F, -12.12F, -6.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      PartDefinition bone = bone5.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(16, 57).m_171488_(-7.156F, -10.1984F, -7.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).m_171514_(16, 56).m_171488_(-7.196F, -10.7984F, -7.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(13, 57).m_171488_(-7.556F, -11.7584F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(3.156F, 0.9184F, 0.0F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(19, 54).m_171488_(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(15, 54).m_171480_().m_171488_(-4.4F, -16.4F, -7.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(14, 55).m_171488_(-4.4F, -12.12F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.m_171423_(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      bone6.m_171599_("bone8", CubeListBuilder.m_171558_().m_171514_(60, 0).m_171488_(-8.0F, -1.88F, -6.68F, 16.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)).m_171514_(50, 37).m_171488_(-7.0F, -9.88F, -5.68F, 14.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).m_171514_(0, 37).m_171488_(-7.0F, -21.84F, -5.68F, 14.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone6.m_171599_("bone7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.32F, -27.28F, -6.68F, 16.0F, 23.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(4, 39).m_171488_(-6.32F, -26.08F, -4.68F, 12.0F, 1.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.m_171419_(0.32F, 3.2F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone6.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
