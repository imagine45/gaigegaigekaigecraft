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

public class Modelmukimuki<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelmukimuki"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart body_r1;
   public final ModelPart body_r2;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelmukimuki(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.body_r1 = this.Body.m_171324_("body_r1");
      this.body_r2 = this.Body.m_171324_("body_r2");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 12).m_171488_(-4.0F, 5.0F, -2.5F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.0F, -0.1F, -3.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(16, 32).m_171488_(-3.0F, -1.6F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      Body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(16, 24).m_171488_(-0.6F, 0.2F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-4.0F, -0.6F, 0.0F, 0.0F, 0.0F, -0.7854F));
      Body.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(16, 24).m_171488_(-1.4F, 0.2F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(4.0F, -0.6F, 0.0F, 0.0F, 0.0F, 0.7854F));
      partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171480_().m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).m_171555_(false), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(0, 24).m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.9F, 12.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.9F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
