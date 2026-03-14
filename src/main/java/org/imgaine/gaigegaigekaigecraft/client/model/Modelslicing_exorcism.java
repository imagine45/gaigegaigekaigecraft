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

public class Modelslicing_exorcism<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelslicing_exorcism"), "main");
   public final ModelPart main;

   public Modelslicing_exorcism(ModelPart root) {
      this.main = root.m_171324_("main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition main = partdefinition.m_171599_("main", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      PartDefinition body = main.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, -1.1781F, 3.1416F));
      body.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));
      body.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, -0.3927F, 3.1416F));
      body.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      body.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
      body.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 1.1781F, 3.1416F));
      body.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 0.3927F, 3.1416F));
      body.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
      body.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
      body.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
      body.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
      body.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
      body.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
      body.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
      body.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(-2, 0).m_171488_(-5.4301F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.11F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
      PartDefinition bone6 = body.m_171599_("bone6", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition bone2 = bone6.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      bone2.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone2.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171488_(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone2.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      PartDefinition bone3 = bone6.m_171599_("bone3", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
      bone3.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone3.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone3.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171488_(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone3.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      PartDefinition bone4 = bone6.m_171599_("bone4", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
      bone4.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone4.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone4.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171488_(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone4.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      PartDefinition bone5 = bone6.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      bone5.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5883F, 0.0F, -0.7976F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -1.2654F, 0.0F));
      bone5.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.0085F, 0.0F, -0.4387F, 0.0F, -0.9163F, 0.0F));
      bone5.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(1, 3).m_171488_(-0.7622F, 0.0F, -0.0584F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.2182F, 0.0F));
      bone5.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(-1, 3).m_171488_(-0.7112F, 0.0F, -0.7852F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-5.7238F, 0.0F, 0.6247F, 0.0F, -0.6109F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 4, 4);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.main.f_104204_ = ageInTicks;
   }
}
