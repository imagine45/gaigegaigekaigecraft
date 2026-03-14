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

public class Modelcursedspirit3_16<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_16"), "main");
   public final ModelPart head;
   public final ModelPart body;

   public Modelcursedspirit3_16(ModelPart root) {
      this.head = root.m_171324_("head");
      this.body = root.m_171324_("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -8.0F, 1.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 2).m_171488_(-4.5F, -10.5289F, -3.5896F, 9.0F, 3.0F, 10.0F, new CubeDeformation(-0.1F)).m_171514_(0, 0).m_171480_().m_171488_(-5.5F, -8.5289F, -1.5896F, 11.0F, 12.0F, 9.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(0, 56).m_171488_(-4.0F, -1.4323F, -6.1453F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F)).m_171514_(0, 46).m_171488_(-4.5F, -0.3392F, -6.2003F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.1F)).m_171514_(0, 2).m_171488_(-4.0F, -0.3323F, -6.1453F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.4272F, -1.8994F, -0.1309F, 0.0F, 0.0F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 56).m_171488_(-4.0F, -2.4303F, -6.9692F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.15F)).m_171514_(0, 46).m_171488_(-4.5F, -2.5741F, -6.9836F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.1F)).m_171514_(0, 3).m_171488_(-4.5F, -7.5303F, -6.9692F, 9.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.4272F, -1.8994F, -0.4363F, 0.0F, 0.0F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(9, 49).m_171488_(-3.5F, -2.2003F, 0.3392F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -0.4272F, -1.8994F, 1.4399F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 3).m_171480_().m_171488_(-4.0F, -1.061F, 12.3027F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 1.0F, -15.0F));
      body.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(2, 21).m_171488_(-1.5F, -1.1078F, -7.9468F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 21.5F, 17.0F, -2.8523F, 1.1258F, -3.0032F));
      body.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(2, 21).m_171488_(-1.5F, -1.1078F, -7.9468F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 21.5F, 17.0F, -2.8523F, -1.1258F, 3.0032F));
      body.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(2, 21).m_171488_(-1.5F, -0.5F, -4.5F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 21.5F, 13.5F, 0.1745F, 0.0F, 0.0F));
      body.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-2.0F, -4.3F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 18.0F, 17.0F, 0.0873F, 0.0F, 0.0F));
      body.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(8, 5).m_171480_().m_171488_(-3.0F, -4.0F, -3.5F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 10.0F, 17.0F, 0.0873F, 0.0F, 0.0F));
      body.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 3).m_171480_().m_171488_(-5.0F, 0.939F, -2.6258F, 10.0F, 8.0F, 10.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -9.4272F, 14.1006F, -0.0436F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
   }
}
