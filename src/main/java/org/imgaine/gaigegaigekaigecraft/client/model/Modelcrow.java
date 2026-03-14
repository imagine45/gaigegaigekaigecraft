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

public class Modelcrow<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcrow"), "main");
   public final ModelPart leg1;
   public final ModelPart leg0;
   public final ModelPart tail;
   public final ModelPart wing_right;
   public final ModelPart wing_left;
   public final ModelPart body;
   public final ModelPart head;

   public Modelcrow(ModelPart root) {
      this.leg1 = root.m_171324_("leg1");
      this.leg0 = root.m_171324_("leg0");
      this.tail = root.m_171324_("tail");
      this.wing_right = root.m_171324_("wing_right");
      this.wing_left = root.m_171324_("wing_left");
      this.body = root.m_171324_("body");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition leg1 = partdefinition.m_171599_("leg1", CubeListBuilder.m_171558_(), PartPose.m_171419_(-0.5F, 23.0F, 1.5F));
      leg1.m_171599_("leg1_r1", CubeListBuilder.m_171558_().m_171514_(14, 18).m_171488_(-1.5F, 3.4F, 0.2777F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5F, -4.4F, -1.2777F, 1.0472F, 0.0F, 0.0F));
      PartDefinition leg0 = partdefinition.m_171599_("leg0", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.5F, 23.0F, 1.5F));
      leg0.m_171599_("leg0_r1", CubeListBuilder.m_171558_().m_171514_(14, 18).m_171488_(0.5F, 3.4F, 0.2777F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.5F, -4.4F, -1.2777F, 1.0472F, 0.0F, 0.0F));
      PartDefinition tail = partdefinition.m_171599_("tail", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 21.1F, 3.2F));
      tail.m_171599_("tail_r1", CubeListBuilder.m_171558_().m_171514_(22, 1).m_171488_(-1.5F, -3.0F, 2.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.0099F, 3.9837F, 1.7453F, 0.0F, 0.0F));
      PartDefinition wing_right = partdefinition.m_171599_("wing_right", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.5F, 17.9F, -0.8F));
      wing_right.m_171599_("wing_right_r1", CubeListBuilder.m_171558_().m_171514_(19, 8).m_171480_().m_171488_(-0.6995F, -0.7199F, -2.0098F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.3178F, 0.1516F, 1.4069F, 0.0873F, 0.0436F, 1.5708F));
      PartDefinition wing_left = partdefinition.m_171599_("wing_left", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.5F, 17.9F, -0.8F));
      wing_left.m_171599_("wing_left_r1", CubeListBuilder.m_171558_().m_171514_(19, 8).m_171488_(-0.3005F, -0.7199F, -2.0098F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.3178F, 0.1516F, 1.4069F, 0.0873F, -0.0436F, -1.5708F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.8178F, 18.0516F, 0.6069F));
      body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(2, 8).m_171488_(-3.3178F, -2.6473F, -1.6995F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5272F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 17.7F, -1.8F));
      head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(16, 7).m_171488_(-0.5F, -0.9864F, -2.4442F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(10, 0).m_171488_(-1.0F, -2.6864F, -0.5442F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)).m_171514_(0, 1).m_171488_(-1.0F, -2.1864F, -1.0442F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 1.2661F, -1.8998F, 0.1745F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.leg1.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.leg0.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.tail.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.wing_right.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.wing_left.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / 57.295776F;
      this.head.f_104203_ = headPitch / 57.295776F;
      this.wing_left.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.wing_right.f_104205_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
