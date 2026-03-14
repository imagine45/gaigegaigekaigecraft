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

public class Modelguillotine<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelguillotine"), "main");
   public final ModelPart bone;

   public Modelguillotine(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(48, 0).m_171488_(-18.0F, -107.0F, -2.0F, 36.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(32, 96).m_171488_(-17.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(32, 96).m_171488_(-5.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(32, 96).m_171488_(-5.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(32, 96).m_171488_(-17.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(32, 96).m_171480_().m_171488_(4.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 96).m_171480_().m_171488_(16.0F, -94.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 96).m_171480_().m_171488_(16.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 96).m_171480_().m_171488_(4.0F, -105.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(32, 96).m_171488_(-1.5F, -112.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-0.5F, -176.0F, -0.5F, 1.0F, 64.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(18.0F, -48.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(18.0F, 16.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-30.0F, 16.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(18.0F, -112.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-30.0F, -112.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171480_().m_171488_(18.0F, -176.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-30.0F, -176.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-30.0F, -48.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 8.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-5.0F, -32.0F, -6.0F, 12.0F, 64.0F, 12.0F, new CubeDeformation(1.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -183.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(34, 97).m_171488_(-18.0F, 4.0F, -0.5F, 46.0F, 6.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-1.0F, -80.5F, -0.5F, 0.0F, 0.0F, 0.5236F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(36, 104).m_171488_(-18.0F, -13.0F, -0.5F, 45.0F, 23.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -86.5F, -0.5F, 0.0F, 0.0F, 0.5236F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
