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

public class Modelwooden_spear1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelwooden_spear_1"), "main");
   public final ModelPart body;

   public Modelwooden_spear1(ModelPart root) {
      this.body = root.m_171324_("body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 8.0F, 0.0F));
      PartDefinition body1 = body.m_171599_("body1", CubeListBuilder.m_171558_(), PartPose.m_171423_(1.7804F, -0.748F, -53.6914F, 1.5708F, 0.0F, 0.0F));
      body1.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.1899F, 0.0F, -2.1884F, -2.8798F, -0.7854F, 3.1416F));
      body1.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.1899F, 0.0F, 0.6924F, 2.8798F, 0.7854F, 3.1416F));
      body1.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.2477F, 0.0F, -0.7645F, 0.2618F, 1.5708F, 0.0F));
      body1.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.9954F, 0.0F, -2.6249F, -2.8798F, 0.3927F, 3.1416F));
      body1.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.9954F, 0.0F, 1.1289F, 2.8798F, -0.3927F, 3.1416F));
      body1.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.766F, 0.0F, -2.7782F, -2.8798F, 0.0F, 3.1416F));
      body1.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.766F, 0.0F, 1.2822F, 2.8798F, 0.0F, 3.1416F));
      body1.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.5366F, 0.0F, -2.6249F, -2.8798F, -0.3927F, 3.1416F));
      body1.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.5366F, 0.0F, 1.1289F, 2.8798F, 0.3927F, 3.1416F));
      body1.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.7796F, 0.0F, -0.7645F, 0.2618F, -1.5708F, 0.0F));
      body1.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(0.2315F, -8.0F, -0.2523F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, -1.496F, -2.8798F, 0.7854F, 3.1416F));
      body1.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(0.2315F, -8.0F, -0.7477F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.8798F, -0.7854F, 3.1416F));
      body1.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.6264F, 0.0F, -1.5351F, -2.8798F, -1.1781F, 3.1416F));
      body1.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.6264F, 0.0F, 0.0391F, 2.8798F, 1.1781F, 3.1416F));
      body1.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.3978F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, -1.496F, -2.8798F, 1.1781F, 3.1416F));
      body1.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(2, 11).m_171488_(-0.5F, -8.0F, -0.6022F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 2.8798F, -1.1781F, 3.1416F));
      PartDefinition body2 = body.m_171599_("body2", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, -9.0F, 1.5708F, 0.0F, 0.0F));
      body2.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.8265F, -4.0F, 7.7582F, 0.2618F, -0.7854F, 0.0F));
      body2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(7.8265F, -4.0F, 7.7582F, 0.2618F, 0.7854F, 0.0F));
      body2.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.5207F, -39.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-9.7069F, -4.0F, -3.9524F, -0.2618F, 0.7854F, 0.0F));
      body2.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-6.5207F, -39.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(9.7069F, -4.0F, -3.9524F, -0.2618F, -0.7854F, 0.0F));
      body2.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-11.0683F, -4.0F, 0.0683F, -0.2618F, 1.5708F, 0.0F));
      body2.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(11.0683F, -4.0F, 0.0683F, -0.2618F, -1.5708F, 0.0F));
      body2.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.2357F, -4.0F, 10.1575F, 0.2618F, -0.3927F, 0.0F));
      body2.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.2357F, -4.0F, 10.1575F, 0.2618F, 0.3927F, 0.0F));
      body2.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.2357F, -4.0F, -10.1575F, -0.2618F, 0.3927F, 0.0F));
      body2.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.2357F, -4.0F, -10.1575F, -0.2618F, -0.3927F, 0.0F));
      body2.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-10.2258F, -4.0F, 4.1673F, 0.2618F, -1.1781F, 0.0F));
      body2.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(10.2258F, -4.0F, 4.1673F, 0.2618F, 1.1781F, 0.0F));
      body2.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-9.7069F, -4.0F, -3.9524F, -0.2618F, 1.1781F, 0.0F));
      body2.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(9.7069F, -4.0F, -3.9524F, -0.2618F, -1.1781F, 0.0F));
      body2.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 11.0F, 0.2618F, 0.0F, 0.0F));
      body2.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-2.5F, -39.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, -11.0F, -0.2618F, 0.0F, 0.0F));
      PartDefinition body3 = body.m_171599_("body3", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 0.0F, 8.0F, 1.5708F, 0.0F, -0.2182F));
      body3.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.8265F, 4.0F, 7.7582F, -0.2618F, -0.7854F, 0.0F));
      body3.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(7.8265F, 4.0F, 7.7582F, -0.2618F, 0.7854F, 0.0F));
      body3.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.5207F, -14.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-9.7069F, 4.0F, -3.9524F, 0.2618F, 0.7854F, 0.0F));
      body3.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-6.5207F, -14.0F, -2.8615F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(9.7069F, 4.0F, -3.9524F, 0.2618F, -0.7854F, 0.0F));
      body3.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-11.0683F, 4.0F, 0.0683F, 0.2618F, 1.5708F, 0.0F));
      body3.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(11.0683F, 4.0F, 0.0683F, 0.2618F, -1.5708F, 0.0F));
      body3.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.2357F, 4.0F, 10.1575F, -0.2618F, -0.3927F, 0.0F));
      body3.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.2357F, 4.0F, 10.1575F, -0.2618F, 0.3927F, 0.0F));
      body3.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.2357F, 4.0F, -10.1575F, 0.2618F, 0.3927F, 0.0F));
      body3.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.2357F, 4.0F, -10.1575F, 0.2618F, -0.3927F, 0.0F));
      body3.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-10.2258F, 4.0F, 4.1673F, -0.2618F, -1.1781F, 0.0F));
      body3.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(10.2258F, 4.0F, 4.1673F, -0.2618F, 1.1781F, 0.0F));
      body3.m_171599_("cube_r45", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-9.7069F, 4.0F, -3.9524F, 0.2618F, 1.1781F, 0.0F));
      body3.m_171599_("cube_r46", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -2.0617F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(9.7069F, 4.0F, -3.9524F, 0.2618F, -1.1781F, 0.0F));
      body3.m_171599_("cube_r47", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -0.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 4.0F, 11.0F, -0.2618F, 0.0F, 0.0F));
      body3.m_171599_("cube_r48", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-2.5F, -14.0F, -1.5F, 5.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 4.0F, -11.0F, 0.2618F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.body.f_104204_ = netHeadYaw / 57.295776F;
      this.body.f_104203_ = headPitch / 57.295776F;
   }
}
