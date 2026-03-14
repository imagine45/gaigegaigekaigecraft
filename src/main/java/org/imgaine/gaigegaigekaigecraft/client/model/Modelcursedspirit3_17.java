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

public class Modelcursedspirit3_17<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcursedspirit_3_17"), "main");
   public final ModelPart body;

   public Modelcursedspirit3_17(ModelPart root) {
      this.body = root.m_171324_("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 20.3889F, -0.9444F));
      body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171480_().m_171488_(3.067F, -6.8792F, 0.3229F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -0.3889F, 0.4444F, 1.5456F, 0.523F, 3.0912F));
      body.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-5.067F, -6.8792F, 0.3229F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -0.3889F, 0.4444F, 1.5456F, -0.523F, -3.0912F));
      body.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(4, 2).m_171488_(-1.0F, -9.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(8, 12).m_171488_(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).m_171514_(2, 1).m_171488_(-1.5F, -5.0F, -0.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(2, 3).m_171488_(-1.5F, 2.5F, -0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.3889F, 0.4444F, 1.5708F, 0.0F, 3.1416F));
      body.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171480_().m_171488_(-1.75F, 4.5F, 0.433F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -0.3889F, 0.4444F, 1.5708F, 0.0F, -2.618F));
      body.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171480_().m_171488_(-1.25F, 4.5F, 0.433F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -0.3889F, 0.4444F, 1.5708F, 0.0F, 2.618F));
      return LayerDefinition.m_171565_(meshdefinition, 16, 16);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.body.f_104204_ = netHeadYaw / 57.295776F;
      this.body.f_104203_ = headPitch / 57.295776F;
   }
}
