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

public class Modelgravestone2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelgravestone_2"), "main");
   public final ModelPart bb_main;

   public Modelgravestone2(ModelPart root) {
      this.bb_main = root.m_171324_("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-5.5F, -2.0F, -5.5F, 11.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-6.0F, -15.0F, -6.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-6.0F, -23.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(4, 4).m_171488_(-4.0F, -26.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(8, 8).m_171488_(-2.0F, -29.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(2, 18).m_171488_(-3.0F, -11.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171488_(-4.0F, -17.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(6, 22).m_171488_(2.0F, -20.0F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(6, 22).m_171480_().m_171488_(-4.0F, -20.0F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(6, 22).m_171480_().m_171488_(-4.0F, -20.0F, -4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(6, 22).m_171488_(2.0F, -20.0F, -4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.bb_main.f_104204_ = netHeadYaw / 57.295776F;
      this.bb_main.f_104203_ = headPitch / 57.295776F;
   }
}
