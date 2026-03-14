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

public class Modelflame_arrow<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelflame_arrow"), "main");
   public final ModelPart Body;

   public Modelflame_arrow(ModelPart root) {
      this.Body = root.m_171324_("Body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 22.0F, 0.0F));
      PartDefinition boneMain = Body.m_171599_("boneMain", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, -10.5F));
      PartDefinition bone1 = boneMain.m_171599_("bone1", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone1.m_171599_("bone1_r1", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone1.m_171599_("bone1_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone1.m_171599_("bone1_r3", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone1.m_171599_("bone1_r4", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone1.m_171599_("bone1_r5", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone2 = boneMain.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
      bone2.m_171599_("bone2_r1", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone2.m_171599_("bone2_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone2.m_171599_("bone2_r3", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone2.m_171599_("bone2_r4", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone2.m_171599_("bone2_r5", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone3 = boneMain.m_171599_("bone3", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
      bone3.m_171599_("bone3_r1", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone3.m_171599_("bone3_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone3.m_171599_("bone3_r3", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone3.m_171599_("bone3_r4", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone3.m_171599_("bone3_r5", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone4 = boneMain.m_171599_("bone4", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));
      bone4.m_171599_("bone2_r6", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone4.m_171599_("bone2_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone4.m_171599_("bone2_r8", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone4.m_171599_("bone2_r9", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone4.m_171599_("bone2_r10", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone5 = boneMain.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
      bone5.m_171599_("bone3_r6", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone5.m_171599_("bone3_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone5.m_171599_("bone3_r8", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone5.m_171599_("bone3_r9", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone5.m_171599_("bone3_r10", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone6 = boneMain.m_171599_("bone6", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));
      bone6.m_171599_("bone4_r1", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone6.m_171599_("bone4_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone6.m_171599_("bone4_r3", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone6.m_171599_("bone4_r4", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone6.m_171599_("bone4_r5", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone7 = boneMain.m_171599_("bone7", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
      bone7.m_171599_("bone5_r1", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone7.m_171599_("bone5_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone7.m_171599_("bone5_r3", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone7.m_171599_("bone5_r4", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone7.m_171599_("bone5_r5", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone8 = boneMain.m_171599_("bone8", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
      bone8.m_171599_("bone6_r1", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone8.m_171599_("bone6_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.m_171423_(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone8.m_171599_("bone6_r3", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.m_171423_(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone8.m_171599_("bone6_r4", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone8.m_171599_("bone6_r5", CubeListBuilder.m_171558_().m_171514_(2, 2).m_171488_(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      Body.m_171599_("stick", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -0.5F, 13.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(2, 2).m_171488_(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-0.5F, -0.5F, 7.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)).m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -0.5F, 1.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, -10.5F));
      return LayerDefinition.m_171565_(meshdefinition, 14, 14);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Body.f_104204_ = netHeadYaw / 57.295776F;
      this.Body.f_104203_ = headPitch / 57.295776F;
   }
}
