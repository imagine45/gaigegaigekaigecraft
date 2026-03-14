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

public class Modelbullet_skull<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelbullet_skull"), "main");
   public final ModelPart lower_body;

   public Modelbullet_skull(ModelPart root) {
      this.lower_body = root.m_171324_("lower_body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition lower_body = partdefinition.m_171599_("lower_body", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 9.9387F, 0.4821F));
      lower_body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(96, 0).m_171488_(-4.0F, -7.2701F, -3.7232F, 8.0F, 6.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(0.0F, 1.3139F, -0.4821F, 0.0585F, 0.0F, 0.0F));
      lower_body.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(96, 0).m_171488_(-4.0F, -2.8946F, -3.8752F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 1.3139F, -0.4821F, -2.5595F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.lower_body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.lower_body.f_104204_ = netHeadYaw / 57.295776F;
      this.lower_body.f_104203_ = headPitch / 57.295776F;
   }
}
