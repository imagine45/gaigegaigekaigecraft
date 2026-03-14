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

public class ModelRabbitEscape<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_rabbit_escape"), "main");
   public final ModelPart Head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public ModelRabbitEscape(ModelPart root) {
      this.Head = root.m_171324_("Head");
      this.Body = root.m_171324_("Body");
      this.RightArm = root.m_171324_("RightArm");
      this.LeftArm = root.m_171324_("LeftArm");
      this.RightLeg = root.m_171324_("RightLeg");
      this.LeftLeg = root.m_171324_("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition Head = partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -1.8213F, -3.8787F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.4F)).m_171514_(0, 28).m_171488_(-1.5F, -0.1F, -6.4F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(20, 22).m_171488_(-0.5F, -0.4F, -6.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).m_171514_(0, 21).m_171488_(-2.5F, -0.1F, -4.6101F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.m_171419_(0.0F, 16.7F, 0.3F));
      Head.m_171599_("Head_r1", CubeListBuilder.m_171558_().m_171514_(26, 26).m_171480_().m_171488_(0.9292F, -12.8353F, -1.643F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-2.8799F, 5.4623F, -6.3812F, -0.5171F, -0.4326F, 0.5045F));
      Head.m_171599_("Head_r2", CubeListBuilder.m_171558_().m_171514_(26, 26).m_171488_(-2.9292F, -12.8353F, -1.643F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(2.8799F, 5.4623F, -6.3812F, -0.5171F, 0.4326F, -0.5045F));
      Head.m_171599_("Head_r3", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -9.3909F, -5.2406F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, 8.1247F, -7.2134F, -0.7854F, 0.0F, 0.0F));
      Head.m_171599_("Head_r4", CubeListBuilder.m_171558_().m_171514_(20, 16).m_171488_(0.542F, -8.8909F, -6.4462F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).m_171514_(26, 22).m_171488_(1.342F, -8.3909F, -5.6462F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.8683F, 8.5533F, -6.4191F, -0.8408F, 0.321F, -0.3389F));
      Head.m_171599_("Head_r5", CubeListBuilder.m_171558_().m_171514_(20, 16).m_171480_().m_171488_(-3.542F, -8.8909F, -6.4462F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.2F)).m_171555_(false).m_171514_(26, 22).m_171480_().m_171488_(-2.342F, -8.3909F, -5.6462F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-1.8683F, 8.5533F, -6.4191F, -0.8408F, -0.321F, 0.3389F));
      Head.m_171599_("Head_r6", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-0.389F, -9.5482F, -4.2201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(6.3321F, 3.8141F, -0.39F, 0.0F, 0.0F, -1.103F));
      Head.m_171599_("Head_r7", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -10.092F, -1.2768F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.4F)), PartPose.m_171423_(0.0F, 6.7247F, -6.8533F, -0.7854F, 0.0F, 0.0F));
      Head.m_171599_("Head_r8", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(-1.611F, -9.5482F, -4.2201F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(-6.3321F, 3.8141F, -0.39F, 0.0F, 0.0F, 1.103F));
      Head.m_171599_("Head_r9", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-2.8411F, -7.7F, -4.94F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-1.1615F, 7.6F, -0.7113F, 0.0F, -0.4625F, 0.0F));
      Head.m_171599_("Head_r10", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(0.8411F, -7.7F, -4.94F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)).m_171555_(false), PartPose.m_171423_(1.1615F, 7.6F, -0.7113F, 0.0F, 0.4625F, 0.0F));
      PartDefinition Body = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-2.5F, -6.4419F, -0.5537F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(0.0F, 22.6118F, -0.6595F));
      Body.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -6.4182F, 7.5084F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, 0.3F, 0.0F, -0.1746F, 0.0F, 0.0F));
      Body.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-2.5F, -5.8724F, 1.4105F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.m_171423_(0.0F, -1.3499F, -0.5682F, -0.3491F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(-0.4F, 4.2F, -4.819F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171419_(-3.0F, 18.8F, 0.5F));
      RightArm.m_171599_("RightArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(-3.4F, -6.1043F, 0.416F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(3.0F, 3.8858F, -3.7871F, -0.6632F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.6F, 4.2F, -4.819F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171419_(3.0F, 18.8F, 0.5F));
      LeftArm.m_171599_("LeftArm_r1", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(1.4F, -6.1043F, 0.416F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.0F, 3.8858F, -3.7871F, -0.6632F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(-0.7F, 3.3F, -1.419F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-3.3F, 19.7F, 4.9F));
      RightLeg.m_171599_("RightLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-4.0F, -4.7204F, 4.0145F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.3F, 0.1067F, -5.5871F, -0.5934F, 0.0F, 0.0F));
      RightLeg.m_171599_("RightLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-4.0F, -2.8828F, 6.4173F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(3.3F, -5.8392F, 1.0397F, -1.6057F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.3F, 3.3F, -1.419F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(3.3F, 19.7F, 4.9F));
      LeftLeg.m_171599_("LeftLeg_r1", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(2.0F, -4.7204F, 4.0145F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.3F, 0.1067F, -5.5871F, -0.5934F, 0.0F, 0.0F));
      LeftLeg.m_171599_("LeftLeg_r2", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171480_().m_171488_(2.0F, -2.8828F, 6.4173F, 2.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-3.3F, -5.8392F, 1.0397F, -1.6057F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
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
      this.RightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.f_104204_ = netHeadYaw / 57.295776F;
      this.Head.f_104203_ = headPitch / 57.295776F;
      this.LeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.RightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
