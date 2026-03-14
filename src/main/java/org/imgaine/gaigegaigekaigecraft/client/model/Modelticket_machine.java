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

public class Modelticket_machine<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelticket_machine"), "main");
   public final ModelPart ticket_machine;

   public Modelticket_machine(ModelPart root) {
      this.ticket_machine = root.m_171324_("ticket_machine");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition ticket_machine = partdefinition.m_171599_("ticket_machine", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      ticket_machine.m_171599_("bone3", CubeListBuilder.m_171558_().m_171514_(0, 102).m_171488_(-4.0F, -4.0F, 1.0F, 7.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.5F, 1.0F, -12.5F));
      PartDefinition bone2 = ticket_machine.m_171599_("bone2", CubeListBuilder.m_171558_().m_171514_(4, 62).m_171488_(-1.5F, -9.4536F, -23.2322F, 3.0F, 11.0F, 23.0F, new CubeDeformation(0.0F)).m_171514_(4, 62).m_171488_(3.5F, -9.4536F, -23.2322F, 3.0F, 11.0F, 23.0F, new CubeDeformation(0.0F)).m_171514_(0, 110).m_171480_().m_171488_(6.0F, -7.3536F, -5.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 110).m_171480_().m_171488_(6.0F, -7.3536F, -24.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 110).m_171488_(-2.0F, -7.3536F, -24.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 110).m_171488_(-2.0F, -7.3536F, -5.2322F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(39, 110).m_171488_(1.5F, -8.3536F, -27.4322F, 7.0F, 8.0F, 5.0F, new CubeDeformation(-2.1F)).m_171514_(25, 83).m_171488_(-1.5F, -7.3536F, -25.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(25, 83).m_171488_(3.5F, -7.3536F, -25.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(25, 83).m_171488_(3.5F, -7.3536F, -0.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(25, 83).m_171488_(-1.5F, -7.3536F, -0.2322F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-2.5F, -3.6464F, 11.7322F));
      bone2.m_171599_("ticket_machine_r1", CubeListBuilder.m_171558_().m_171514_(10, 78).m_171480_().m_171488_(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(10, 78).m_171488_(3.48F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.01F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      bone2.m_171599_("ticket_machine_r2", CubeListBuilder.m_171558_().m_171514_(10, 78).m_171480_().m_171488_(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(10, 78).m_171488_(3.48F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.01F, 0.0F, -23.4645F, 0.7854F, 0.0F, 0.0F));
      bone2.m_171599_("ticket_machine_r3", CubeListBuilder.m_171558_().m_171514_(0, 78).m_171488_(1.0F, -2.5F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(10, 78).m_171480_().m_171488_(-3.98F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(2.49F, -7.7839F, 0.0171F, 0.7418F, 0.0F, 0.0F));
      bone2.m_171599_("ticket_machine_r4", CubeListBuilder.m_171558_().m_171514_(10, 78).m_171480_().m_171488_(-4.0F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(24, 109).m_171488_(1.48F, -1.7F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(29, 102).m_171488_(1.48F, -1.1F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)).m_171514_(24, 109).m_171488_(1.48F, -0.4F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 78).m_171488_(0.98F, -2.5F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.51F, -7.7839F, -23.4816F, -0.7418F, 0.0F, 0.0F));
      bone2.m_171599_("ticket_machine_r5", CubeListBuilder.m_171558_().m_171514_(0, 78).m_171488_(-1.5F, -3.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.99F, -8.9706F, -2.7306F, 1.7453F, 0.0F, 0.0F));
      bone2.m_171599_("ticket_machine_r6", CubeListBuilder.m_171558_().m_171514_(0, 78).m_171488_(-1.5F, -3.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.99F, -8.9706F, -20.7339F, -1.7453F, 0.0F, 0.0F));
      PartDefinition bone = ticket_machine.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(22, 40).m_171488_(-1.0F, -4.0207F, 2.8848F, 2.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).m_171514_(10, 50).m_171488_(-1.0F, 0.0793F, 21.8848F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(10, 50).m_171488_(-1.0F, 0.0793F, -1.1152F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -12.0793F, -12.3848F));
      bone.m_171599_("ticket_machine_r7", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("ticket_machine_r8", CubeListBuilder.m_171558_().m_171514_(0, 56).m_171488_(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 7.7257F, -0.0546F, 0.7854F, 0.0F, 0.0F));
      bone.m_171599_("ticket_machine_r9", CubeListBuilder.m_171558_().m_171514_(0, 56).m_171488_(-1.0F, -0.5F, -2.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 7.7257F, 24.8241F, -0.7854F, 0.0F, 0.0F));
      bone.m_171599_("ticket_machine_r10", CubeListBuilder.m_171558_().m_171514_(0, 51).m_171488_(-1.0F, -1.5F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 24.7696F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("ticket_machine_r11", CubeListBuilder.m_171558_().m_171514_(0, 44).m_171488_(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(0.0F, -1.6869F, 2.1488F, 2.1817F, 0.0F, 0.0F));
      bone.m_171599_("ticket_machine_r12", CubeListBuilder.m_171558_().m_171514_(0, 44).m_171488_(-1.0F, -2.5F, -2.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(0.0F, -1.8097F, 23.3171F, 0.9599F, 0.0F, 0.0F));
      PartDefinition bone4 = ticket_machine.m_171599_("bone4", CubeListBuilder.m_171558_().m_171514_(11, 106).m_171488_(0.0F, -4.0207F, 2.8848F, 0.0F, 3.0F, 19.0F, new CubeDeformation(0.1F)).m_171514_(26, 106).m_171488_(0.0F, 0.0793F, 21.8848F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)).m_171514_(26, 106).m_171488_(0.0F, 0.0793F, -1.1152F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(0.0F, -12.0793F, -12.3848F));
      bone4.m_171599_("ticket_machine_r13", CubeListBuilder.m_171558_().m_171514_(26, 106).m_171488_(0.0F, -1.5F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone4.m_171599_("ticket_machine_r14", CubeListBuilder.m_171558_().m_171514_(26, 106).m_171488_(0.0F, -0.5F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 7.7257F, -0.0546F, 0.7854F, 0.0F, 0.0F));
      bone4.m_171599_("ticket_machine_r15", CubeListBuilder.m_171558_().m_171514_(26, 106).m_171488_(0.0F, -0.5F, -2.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 7.7257F, 24.8241F, -0.7854F, 0.0F, 0.0F));
      bone4.m_171599_("ticket_machine_r16", CubeListBuilder.m_171558_().m_171514_(26, 106).m_171488_(0.0F, -1.5F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, 0.0F, 24.7696F, 0.3927F, 0.0F, 0.0F));
      bone4.m_171599_("ticket_machine_r17", CubeListBuilder.m_171558_().m_171514_(26, 106).m_171488_(0.0F, -2.5F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.09F)), PartPose.m_171423_(0.0F, -1.8097F, 1.4525F, -0.9599F, 0.0F, 0.0F));
      bone4.m_171599_("ticket_machine_r18", CubeListBuilder.m_171558_().m_171514_(26, 106).m_171488_(0.0F, -2.5F, -2.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.09F)), PartPose.m_171423_(0.0F, -1.8097F, 23.3171F, 0.9599F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.ticket_machine.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
