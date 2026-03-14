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

public class Modelclothes_reggie<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_reggie"), "main");
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;

   public Modelclothes_reggie(ModelPart root) {
      this.armorBody = root.m_171324_("armorBody");
      this.armorRightArm = root.m_171324_("armorRightArm");
      this.armorLeftArm = root.m_171324_("armorLeftArm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition armorBody = partdefinition.m_171599_("armorBody", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).m_171514_(0, 0).m_171488_(-4.0F, 3.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      armorBody.m_171599_("Body_r1", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-5.0F, 13.3921F, 2.5698F, 0.3927F, -0.7854F, 0.0F));
      armorBody.m_171599_("Body_r2", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171480_().m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(5.0F, 13.3921F, 2.5698F, 0.3927F, 0.7854F, 0.0F));
      armorBody.m_171599_("Body_r3", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171480_().m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(5.0F, 13.3921F, -2.5698F, -0.3927F, -0.7854F, 0.0F));
      armorBody.m_171599_("Body_r4", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171480_().m_171488_(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(5.5F, 12.5921F, 0.0F, -0.7854F, -1.5708F, 0.0F));
      armorBody.m_171599_("Body_r5", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171488_(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-5.5F, 12.5921F, 0.0F, -0.7854F, 1.5708F, 0.0F));
      armorBody.m_171599_("Body_r6", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-5.0F, 13.3921F, -2.5698F, -0.3927F, 0.7854F, 0.0F));
      armorBody.m_171599_("Body_r7", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.5F, 7.3921F, 2.5698F, 0.3927F, -0.7854F, 0.0F));
      armorBody.m_171599_("Body_r8", CubeListBuilder.m_171558_().m_171514_(4, 11).m_171488_(-4.0F, 2.0F, 2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 5.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
      armorBody.m_171599_("Body_r9", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171480_().m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.5F, 7.3921F, 2.5698F, 0.3927F, 0.7854F, 0.0F));
      armorBody.m_171599_("Body_r10", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171480_().m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.5F, 7.3921F, -2.5698F, -0.3927F, -0.7854F, 0.0F));
      armorBody.m_171599_("Body_r11", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171480_().m_171488_(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(5.5F, 6.5921F, 0.0F, -0.7854F, -1.5708F, 0.0F));
      armorBody.m_171599_("Body_r12", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171488_(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-5.5F, 6.5921F, 0.0F, -0.7854F, 1.5708F, 0.0F));
      armorBody.m_171599_("Body_r13", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.5F, 7.3921F, -2.5698F, -0.3927F, 0.7854F, 0.0F));
      armorBody.m_171599_("Body_r14", CubeListBuilder.m_171558_().m_171514_(4, 11).m_171488_(-4.0F, 2.0F, -2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 5.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      armorBody.m_171599_("Body_r15", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171488_(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-5.5F, -1.4079F, 0.0F, -1.9635F, 1.5708F, 0.0F));
      armorBody.m_171599_("Body_r16", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171480_().m_171488_(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(5.5F, -1.4079F, 0.0F, -1.9635F, -1.5708F, 0.0F));
      armorBody.m_171599_("Body_r17", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171480_().m_171488_(-2.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(5.5F, 1.5921F, -0.5F, -0.3927F, -1.5708F, 0.0F));
      armorBody.m_171599_("Body_r18", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171480_().m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.5F, 2.3921F, 2.5698F, 0.3927F, 0.7854F, 0.0F));
      armorBody.m_171599_("Body_r19", CubeListBuilder.m_171558_().m_171514_(4, 11).m_171488_(-4.0F, 2.0F, 2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
      armorBody.m_171599_("Body_r20", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.5F, 2.3921F, 2.5698F, 0.3927F, -0.7854F, 0.0F));
      armorBody.m_171599_("Body_r21", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171480_().m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(4.5F, 2.3921F, -2.5698F, -0.3927F, -0.7854F, 0.0F));
      armorBody.m_171599_("Body_r22", CubeListBuilder.m_171558_().m_171514_(5, 11).m_171488_(-3.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-5.5F, 1.5921F, -0.5F, -0.3927F, 1.5708F, 0.0F));
      armorBody.m_171599_("Body_r23", CubeListBuilder.m_171558_().m_171514_(6, 11).m_171488_(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-4.5F, 2.3921F, -2.5698F, -0.3927F, 0.7854F, 0.0F));
      armorBody.m_171599_("Body_r24", CubeListBuilder.m_171558_().m_171514_(4, 11).m_171488_(-4.0F, 2.0F, -2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorRightArm", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.52F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("armorLeftArm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.52F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorBody.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
