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

public class Modelglasses_maki<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelglasses_maki"), "main");
   public final ModelPart armorHead;

   public Modelglasses_maki(ModelPart root) {
      this.armorHead = root.m_171324_("armorHead");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition armorHead = partdefinition.m_171599_("armorHead", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 55).m_171488_(0.4F, -2.0F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171480_().m_171488_(-3.4F, -2.0F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      armorHead.m_171599_("Head_r7_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(-3.768F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-3.368F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-3.568F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-14.2427F, 22.0451F, 0.6385F, 0.0333F, 0.0568F, 0.5644F));
      armorHead.m_171599_("Head_r8_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171480_().m_171488_(-0.9194F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.7194F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.1194F, -29.9197F, -4.2621F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.1194F, -29.7197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.1194F, -29.5197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.5194F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.3194F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.1194F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(25.0971F, -2.2256F, 1.6906F, 0.0658F, -0.0025F, -1.5708F));
      armorHead.m_171599_("Head_r9_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(-3.8713F, -27.2631F, -4.4635F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-28.6761F, -12.1062F, 0.0F, 0.0F, 0.0F, 2.0498F));
      armorHead.m_171599_("Head_r10_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171480_().m_171488_(-0.935F, -27.2628F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(22.7915F, -15.4919F, 1.5699F, 0.0595F, 0.0282F, -2.0498F));
      armorHead.m_171599_("Head_r11_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171480_().m_171488_(-0.1002F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.3002F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.5002F, -25.7202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.5002F, -25.9202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.5002F, -26.1202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.5002F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.7002F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-0.9002F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(25.1029F, -2.2063F, 1.6901F, 0.0658F, -0.0025F, -1.5708F));
      armorHead.m_171599_("Head_r12_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171480_().m_171488_(-1.032F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-1.232F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(-1.432F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(13.6482F, 20.0157F, 0.8542F, 0.0333F, -0.0568F, -0.5644F));
      armorHead.m_171599_("Head_r1_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171480_().m_171488_(2.768F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(2.368F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(0, 55).m_171480_().m_171488_(2.568F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(14.2427F, 22.0451F, 0.6385F, 0.0333F, -0.0568F, -0.5644F));
      armorHead.m_171599_("Head_r2_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(-0.0806F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.2806F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.8806F, -29.9197F, -4.2621F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.8806F, -29.7197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.8806F, -29.5197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.4806F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.6806F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.8806F, -29.3197F, -4.2621F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-25.0971F, -2.2256F, 1.6906F, 0.0658F, 0.0025F, 1.5708F));
      armorHead.m_171599_("Head_r3_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171480_().m_171488_(2.8713F, -27.2631F, -4.4635F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(28.6761F, -12.1062F, 0.0F, 0.0F, 0.0F, -2.0498F));
      armorHead.m_171599_("Head_r4_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(-0.065F, -27.2628F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-22.7915F, -15.4919F, 1.5699F, 0.0595F, -0.0282F, 2.0498F));
      armorHead.m_171599_("Head_r5_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(-0.8998F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.6998F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.4998F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.2998F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(-0.0998F, -26.3202F, -4.4725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-25.1029F, -2.2063F, 1.6901F, 0.0658F, 0.0025F, 1.5708F));
      armorHead.m_171599_("Head_r6_r1", CubeListBuilder.m_171558_().m_171514_(0, 55).m_171488_(0.032F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(0.232F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)).m_171514_(0, 55).m_171488_(0.432F, -26.5718F, -4.4411F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(-13.6482F, 20.0157F, 0.8542F, 0.0333F, 0.0568F, 0.5644F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorHead.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
