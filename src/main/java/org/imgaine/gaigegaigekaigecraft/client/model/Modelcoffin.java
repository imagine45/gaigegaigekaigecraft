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

public class Modelcoffin<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelcoffin"), "main");
   public final ModelPart bb_main;

   public Modelcoffin(ModelPart root) {
      this.bb_main = root.m_171324_("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bb_main = partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-10.2F, -20.1F, -8.2F, 1.0F, 48.0F, 16.0F, new CubeDeformation(-0.05F)).m_171514_(0, 0).m_171488_(-10.2F, -20.1F, -8.7F, 20.0F, 1.0F, 17.0F, new CubeDeformation(0.1F)).m_171514_(0, 0).m_171488_(-10.2F, 26.9F, -8.7F, 20.0F, 1.0F, 17.0F, new CubeDeformation(0.1F)).m_171514_(0, 0).m_171488_(8.8F, -20.1F, -8.2F, 1.0F, 48.0F, 16.0F, new CubeDeformation(-0.05F)).m_171514_(0, 0).m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.2F, -3.9F, 0.2F));
      bb_main.m_171599_("bb_main_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(7.5F, -24.0F, -12.0F, 1.0F, 48.0F, 20.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-8.5F, -24.0F, -12.0F, 1.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-8.5F, -7.0F, -12.0F, 1.0F, 31.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.2F, 3.9F, -0.2F, 0.0F, -1.5708F, 0.0F));
      bb_main.m_171599_("bb_main_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(7.5F, -20.0F, -10.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171480_().m_171488_(7.5F, -19.0F, -8.5F, 1.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(76, 76).m_171480_().m_171488_(8.0F, -17.8F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(76, 76).m_171480_().m_171488_(8.0F, -10.9F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(71, 75).m_171480_().m_171488_(8.5F, -15.7F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(71, 78).m_171480_().m_171488_(8.0F, -12.5F, -3.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(60, 28).m_171480_().m_171488_(7.0F, -20.0F, -9.5F, 1.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.3F, 3.9F, -0.2F, 0.0F, 1.5708F, 0.0F));
      bb_main.m_171599_("bb_main_r3", CubeListBuilder.m_171558_().m_171514_(71, 78).m_171488_(-9.0F, -12.5F, -3.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(71, 75).m_171488_(-9.5F, -15.7F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(76, 76).m_171488_(-9.0F, -17.8F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(76, 76).m_171488_(-9.0F, -10.9F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(60, 28).m_171488_(-8.0F, -20.0F, -9.5F, 1.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-8.5F, -19.0F, -8.5F, 1.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-8.5F, -20.0F, -10.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.7F, 3.9F, -0.2F, 0.0F, -1.5708F, 0.0F));
      bb_main.m_171599_("bb_main_r4", CubeListBuilder.m_171558_().m_171514_(69, 77).m_171488_(-9.5F, -15.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.m_171423_(-0.2F, 4.2F, -0.2F, 0.0F, -1.5708F, 0.0F));
      bb_main.m_171599_("bb_main_r5", CubeListBuilder.m_171558_().m_171514_(69, 77).m_171480_().m_171488_(8.5F, -15.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171423_(0.8F, 4.2F, -0.2F, 0.0F, 1.5708F, 0.0F));
      bb_main.m_171599_("bb_main_r6", CubeListBuilder.m_171558_().m_171514_(76, 78).m_171480_().m_171488_(8.0F, -16.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.3F, 3.9F, -0.3F, 0.0F, 1.5708F, 0.0F));
      bb_main.m_171599_("bb_main_r7", CubeListBuilder.m_171558_().m_171514_(76, 78).m_171488_(-9.0F, -16.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.7F, 3.9F, -0.3F, 0.0F, -1.5708F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 80, 80);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
