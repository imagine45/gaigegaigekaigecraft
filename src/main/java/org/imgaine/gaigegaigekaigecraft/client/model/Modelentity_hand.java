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

public class Modelentity_hand<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelentity_hand"), "main");
   public final ModelPart hand;

   public Modelentity_hand(ModelPart root) {
      this.hand = root.m_171324_("hand");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition hand = partdefinition.m_171599_("hand", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
      hand.m_171599_("hand_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(2.4046F, -27.3425F, 3.916F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, 2.0508F, -1.309F, -1.5708F));
      hand.m_171599_("hand_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(4.0146F, -31.8742F, 1.1871F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, 1.8326F, -1.309F, -1.5708F));
      hand.m_171599_("hand_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(4.0146F, -32.6106F, -0.01F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, 1.7017F, -1.309F, -1.5708F));
      hand.m_171599_("hand_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(4.0146F, -32.6324F, -2.4694F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, 1.5272F, -1.309F, -1.5708F));
      hand.m_171599_("hand_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(4.0146F, -31.1641F, -5.8904F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, 1.309F, -1.309F, -1.5708F));
      hand.m_171599_("hand_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.9122F, -23.9435F, -4.676F, 8.0F, 24.0F, 10.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, 1.5708F, -1.5272F, -1.5708F));
      hand.m_171599_("hand_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.5555F, -23.2784F, -4.676F, 8.0F, 24.0F, 10.0F, new CubeDeformation(-2.01F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, -1.5708F, -1.4835F, 1.5708F));
      hand.m_171599_("hand_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.8631F, -28.1235F, -5.276F, 8.0F, 10.0F, 11.0F, new CubeDeformation(-2.0F)).m_171514_(0, 0).m_171488_(-5.2631F, 15.6765F, -4.676F, 10.0F, 24.0F, 10.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.4631F, -20.3765F, -0.324F, 0.0F, -1.5708F, 0.0F));
      hand.m_171599_("hand_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -12.0F, -5.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(-2.0F)), PartPose.m_171423_(0.139F, -12.5F, -0.5871F, 0.0F, -1.5708F, 3.1416F));
      return LayerDefinition.m_171565_(meshdefinition, 40, 40);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.hand.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
