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

public class Modeluniform_gojo_head<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modeluniform_gojo_head"), "main");
   public final ModelPart Head;

   public Modeluniform_gojo_head(ModelPart root) {
      this.Head = root.m_171324_("Head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 9).m_171488_(-4.0F, -3.8F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.1F)).m_171514_(0, 9).m_171480_().m_171488_(4.0F, -3.8F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(0, 19).m_171488_(-4.0F, -3.8F, 4.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(0, 17).m_171488_(-4.0F, -3.8F, -4.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(12, 19).m_171480_().m_171488_(-4.0F, 1.2F, -4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.5777F, -2.2324F, 0.0F, 0.0F, 0.0F, 0.6109F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(3, 17).m_171480_().m_171488_(-1.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(1.8455F, -3.3131F, -4.01F, 0.0F, 0.0F, -0.0873F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.5112F, -2.4134F, -3.51F, 0.0F, 0.0F, -0.3927F));
      Head.m_171599_("Head_r4", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.5112F, -2.4134F, -3.49F, 0.0F, 0.0F, 0.3927F));
      Head.m_171599_("Head_r5", CubeListBuilder.m_171558_().m_171514_(12, 19).m_171488_(2.0F, 1.2F, -4.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-0.5777F, -2.2324F, 0.02F, 0.0F, 0.0F, -0.6109F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 20);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
