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

public class Modeldagon_fish_mini<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modeldagon_fish_mini"), "main");
   public final ModelPart fish;

   public Modeldagon_fish_mini(ModelPart root) {
      this.fish = root.m_171324_("fish");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition fish = partdefinition.m_171599_("fish", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 20.0F, -0.5F));
      PartDefinition head = fish.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -3.4F, -2.1F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.02F)).m_171514_(28, 0).m_171488_(0.2F, -3.0F, -2.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(28, 0).m_171480_().m_171488_(-1.2F, -3.0F, -2.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171419_(0.0F, 2.5F, -3.7F));
      head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(16, 2).m_171488_(-2.0F, -1.4701F, -8.7881F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.1F)).m_171514_(0, 0).m_171488_(-1.0F, -0.9701F, -7.8881F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -2.3557F, 3.9581F, -0.2618F, 0.0F, -3.1416F));
      head.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -4.2677F, -6.78F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(0.0F, -2.3557F, 3.9581F, 0.1745F, 0.0F, -3.1416F));
      head.m_171599_("head_r3", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, 2.9079F, -4.9821F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, -2.3557F, 3.9581F, -0.3927F, 0.0F, 0.0F));
      head.m_171599_("head_r4", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -4.4739F, -4.9914F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(0.0F, -2.3557F, 3.9581F, 0.5672F, 0.0F, 0.0F));
      head.m_171599_("head_r5", CubeListBuilder.m_171558_().m_171514_(16, 2).m_171488_(-2.0F, 3.3333F, -6.9202F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-1.05F)).m_171514_(0, 4).m_171488_(-1.0F, 2.8333F, -6.0202F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -2.3557F, 3.9581F, -0.6109F, 0.0F, 0.0F));
      PartDefinition body = fish.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -10.6244F, -7.3692F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.05F)).m_171514_(0, 21).m_171488_(-0.5F, -8.1544F, -1.0392F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)).m_171514_(24, 13).m_171488_(0.0F, -10.1544F, 1.5608F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)).m_171514_(0, 21).m_171488_(-1.0F, -10.1544F, -7.2392F, 2.0F, 6.0F, 5.0F, new CubeDeformation(-0.04F)), PartPose.m_171419_(0.0F, 8.0F, 3.5F));
      body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(24, 13).m_171480_().m_171488_(2.3574F, -2.2987F, -3.5102F, 0.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -7.8557F, -3.2419F, 0.0F, 0.3927F, 0.0F));
      body.m_171599_("body_r2", CubeListBuilder.m_171558_().m_171514_(24, 13).m_171488_(-2.3574F, -2.2987F, -3.5102F, 0.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -7.8557F, -3.2419F, 0.0F, -0.3927F, 0.0F));
      body.m_171599_("body_r3", CubeListBuilder.m_171558_().m_171514_(26, 24).m_171488_(0.0F, 3.4336F, -1.0841F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.08F)).m_171514_(0, 21).m_171488_(-1.0F, -0.2792F, -1.0701F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.07F)), PartPose.m_171423_(0.0F, -7.8557F, -3.2419F, 0.5236F, 0.0F, 0.0F));
      body.m_171599_("body_r4", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171488_(-1.0F, -2.8231F, -0.702F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.06F)), PartPose.m_171423_(0.0F, -7.8557F, -3.2419F, -0.5236F, 0.0F, 0.0F));
      PartDefinition bone = fish.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(18, 23).m_171488_(-1.0F, -1.9F, -1.9F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.89F)), PartPose.m_171419_(0.0F, -3.1544F, -1.5692F));
      bone.m_171599_("body_r5", CubeListBuilder.m_171558_().m_171514_(18, 23).m_171488_(-1.0F, -4.3205F, -2.5015F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.86F)), PartPose.m_171423_(0.0F, 3.2987F, 1.8273F, -0.8727F, 0.0F, 0.0F));
      bone.m_171599_("body_r6", CubeListBuilder.m_171558_().m_171514_(18, 23).m_171488_(-1.0F, -5.7138F, -4.7614F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.m_171423_(0.0F, 3.2987F, 1.8273F, 0.3491F, 0.0F, 0.0F));
      bone.m_171599_("body_r7", CubeListBuilder.m_171558_().m_171514_(18, 23).m_171488_(-1.0F, -4.5333F, -3.1809F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.88F)), PartPose.m_171423_(0.0F, 3.2987F, 1.8273F, -0.5236F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.fish.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.fish.f_104204_ = netHeadYaw / 57.295776F;
      this.fish.f_104203_ = headPitch / 57.295776F;
   }
}
