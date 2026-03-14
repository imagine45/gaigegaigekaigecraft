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

public class Modelwooden_spear2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelwooden_spear_2"), "main");
   public final ModelPart body2;

   public Modelwooden_spear2(ModelPart root) {
      this.body2 = root.m_171324_("body2");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body2 = partdefinition.m_171599_("body2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 16.0F, 0.0F));
      PartDefinition body = body2.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
      body.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(5, 4).m_171488_(-1.0F, -18.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(15, 4).m_171488_(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(1, 6).m_171488_(-2.0F, -14.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(3, 2).m_171488_(-2.5F, -12.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(7, 7).m_171488_(-3.0F, -10.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(28, 0).m_171488_(-0.5F, -20.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 8.0F, 0.0F));
      body.m_171599_("bone2", CubeListBuilder.m_171558_().m_171514_(5, 4).m_171488_(-1.0F, -10.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(15, 4).m_171488_(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(1, 6).m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(3, 2).m_171488_(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(7, 7).m_171488_(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(28, 0).m_171488_(-0.5F, -12.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.2446F, 1.9608F, -4.1232F, 0.8007F, -0.7699F, -0.1295F));
      body.m_171599_("bone5", CubeListBuilder.m_171558_().m_171514_(5, 4).m_171480_().m_171488_(-1.0F, -18.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(15, 4).m_171480_().m_171488_(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(1, 6).m_171480_().m_171488_(-2.0F, -14.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(3, 2).m_171480_().m_171488_(-2.5F, -12.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(7, 7).m_171480_().m_171488_(-3.0F, -10.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(28, 0).m_171480_().m_171488_(-0.5F, -20.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 9.0F, 0.0F, 0.7854F, 0.9163F, 0.0873F));
      body.m_171599_("bone3", CubeListBuilder.m_171558_().m_171514_(5, 4).m_171488_(-1.0F, -10.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(15, 4).m_171488_(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(1, 6).m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(3, 2).m_171488_(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(7, 7).m_171488_(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(28, 0).m_171488_(-0.5F, -12.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.0F, 4.016F, 3.4918F, -1.5359F, -1.1188F, 0.9428F));
      body.m_171599_("bone4", CubeListBuilder.m_171558_().m_171514_(5, 4).m_171480_().m_171488_(-1.0F, -10.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(15, 4).m_171480_().m_171488_(-1.5F, -8.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(1, 6).m_171480_().m_171488_(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(3, 2).m_171480_().m_171488_(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(7, 7).m_171480_().m_171488_(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(28, 0).m_171480_().m_171488_(-0.5F, -12.0F, -0.5F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(3.2274F, 4.8694F, 4.0F, -1.2714F, 1.0201F, -0.7387F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body2.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.body2.f_104204_ = netHeadYaw / 57.295776F;
      this.body2.f_104203_ = headPitch / 57.295776F;
   }
}
