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

public class Modelgravestone3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelgravestone_3"), "main");
   public final ModelPart bb_main;

   public Modelgravestone3(ModelPart root) {
      this.bb_main = root.m_171324_("bb_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bb_main = partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-32.0F, -48.0F, -32.0F, 64.0F, 96.0F, 64.0F, new CubeDeformation(0.0F)).m_171514_(16, 16).m_171488_(-24.0F, -54.0F, -24.0F, 48.0F, 108.0F, 48.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-24.0F, -38.0F, -40.0F, 48.0F, 76.0F, 80.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -24.0F, 0.0F));
      bb_main.m_171599_("bb_main_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-24.0F, -38.0F, -40.0F, 48.0F, 76.0F, 80.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone = bb_main.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 198).m_171480_().m_171488_(-44.0F, -73.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 198).m_171480_().m_171488_(36.0F, -73.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(0.0F, 44.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(23, 221).m_171480_().m_171488_(-48.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(23, 221).m_171480_().m_171488_(40.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -69.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(23, 221).m_171480_().m_171488_(-48.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(23, 221).m_171480_().m_171488_(40.8F, -4.0F, -13.5F, 8.0F, 8.0F, 27.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -69.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 198).m_171480_().m_171488_(-44.0F, -4.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 198).m_171480_().m_171488_(36.0F, -4.0F, -25.0F, 8.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -69.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone2 = bone.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(19.0F, -56.0F, 41.0F));
      bone2.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(216, 218).m_171480_().m_171488_(40.6764F, -12.0F, -18.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).m_171555_(false).m_171514_(216, 218).m_171488_(-46.6764F, -12.0F, 4.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)), PartPose.m_171423_(-19.0F, 0.0F, -41.0F, -3.1416F, -0.1745F, 3.1416F));
      bone2.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(216, 218).m_171488_(-46.6764F, -12.0F, -18.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).m_171514_(216, 218).m_171480_().m_171488_(40.6764F, -12.0F, 4.5918F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).m_171555_(false), PartPose.m_171423_(-19.0F, 0.0F, -41.0F, 0.0F, -0.1745F, 0.0F));
      bone2.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(216, 218).m_171480_().m_171488_(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, -82.0F, 0.0F, 1.3963F, 0.0F));
      bone2.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(216, 218).m_171488_(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)), PartPose.m_171423_(-38.0F, 0.0F, -82.0F, 0.0F, -1.3963F, 0.0F));
      bone2.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(216, 218).m_171480_().m_171488_(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, -1.3963F, 0.0F));
      bone2.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(216, 218).m_171488_(-3.0F, -12.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(-2.9F)), PartPose.m_171423_(-38.0F, 0.0F, 0.0F, 0.0F, 1.3963F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 256, 256);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
