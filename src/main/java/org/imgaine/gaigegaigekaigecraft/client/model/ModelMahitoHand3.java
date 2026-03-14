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

public class ModelMahitoHand3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "model_mahito_hand_3"), "main");
   public final ModelPart hand_main;

   public ModelMahitoHand3(ModelPart root) {
      this.hand_main = root.m_171324_("hand_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition hand_main = partdefinition.m_171599_("hand_main", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 6.0F, 0.0F));
      PartDefinition hand = hand_main.m_171599_("hand", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition bone2 = hand.m_171599_("bone2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-24.0F, 18.0F, -49.0F));
      bone2.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171488_(28.0F, -7.0F, -7.0F, 8.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(20, 2).m_171488_(18.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(30, 10).m_171488_(-36.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(26, 6).m_171488_(-28.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(20, 2).m_171488_(-20.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-10.0F, -9.0F, -9.0F, 28.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(24.0F, -16.0F, 8.0F, 0.0F, 1.5708F, 0.0F));
      PartDefinition bone3 = hand.m_171599_("bone3", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.4F, 7.1F, -41.0F));
      bone3.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(10.5865F, 11.3787F, 15.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, 12.3355F, 5.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, 0.2645F, 7.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, 2.3355F, -4.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-17.6978F, -8.6213F, -4.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, -2.3562F, 0.7854F, -1.5708F));
      bone3.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(10.5865F, -15.3787F, -19.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, -4.2645F, -11.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, -16.3355F, -9.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, -6.3355F, 0.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-17.6978F, 4.6213F, 0.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, 0.7854F, 0.7854F, 1.5708F));
      bone3.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(10.5865F, 12.1565F, 14.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, 1.0423F, 6.5577F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, 13.1134F, 4.4866F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, 3.1134F, -5.5134F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-17.6978F, -7.8435F, -5.1565F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, -2.3562F, 0.7854F, -3.1416F));
      bone3.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-17.6978F, 4.5506F, 0.4494F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(10.5865F, -15.4494F, -19.5506F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, -16.4062F, -9.1938F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, -6.4062F, 0.8062F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, -4.3352F, -11.2648F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, 0.7854F, 0.7854F, 0.0F));
      PartDefinition hand2 = hand_main.m_171599_("hand2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      PartDefinition bone4 = hand2.m_171599_("bone4", CubeListBuilder.m_171558_(), PartPose.m_171419_(-24.0F, 18.0F, 49.0F));
      bone4.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(24, 4).m_171488_(28.0F, -7.0F, -7.0F, 8.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).m_171514_(20, 2).m_171488_(18.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(30, 10).m_171488_(-36.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(26, 6).m_171488_(-28.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(20, 2).m_171488_(-20.0F, -8.0F, -8.0F, 10.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-10.0F, -9.0F, -9.0F, 28.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(24.0F, -16.0F, -8.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone5 = hand2.m_171599_("bone5", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.4F, 7.1F, 41.0F));
      bone5.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(10.5865F, 11.3787F, -19.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, 12.3355F, -9.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, 0.2645F, -11.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, 2.3355F, 0.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-17.6978F, -8.6213F, 0.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, 2.3562F, -0.7854F, -1.5708F));
      bone5.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(10.5865F, -15.3787F, 15.6213F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, -4.2645F, 7.3355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, -16.3355F, 5.2645F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, -6.3355F, -4.7355F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-17.6978F, 4.6213F, -4.3787F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, -0.7854F, -0.7854F, 1.5708F));
      bone5.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(10.5865F, 12.1565F, -18.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, 1.0423F, -10.5577F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, 13.1134F, -8.4866F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, 3.1134F, 1.5134F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-17.6978F, -7.8435F, 1.1565F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, 2.3562F, -0.7854F, -3.1416F));
      bone5.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-17.6978F, 4.5506F, -4.4494F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(10.5865F, -15.4494F, 15.5506F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.5255F, -16.4062F, 5.1938F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-11.6167F, -6.4062F, -4.8062F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-4.5456F, -4.3352F, 7.2648F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4F, -5.1F, 0.0F, -0.7854F, -0.7854F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.hand_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.hand_main.f_104204_ = ageInTicks;
   }
}
