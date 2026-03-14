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

public class Modelclothes_maki<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_maki"), "main");
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;

   public Modelclothes_maki(ModelPart root) {
      this.armorBody = root.m_171324_("armorBody");
      this.armorRightArm = root.m_171324_("armorRightArm");
      this.armorLeftArm = root.m_171324_("armorLeftArm");
      this.armorRightLeg = root.m_171324_("armorRightLeg");
      this.armorLeftLeg = root.m_171324_("armorLeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("armorBody", CubeListBuilder.m_171558_().m_171514_(104, 0).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(27, 13).m_171488_(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.27F)).m_171514_(29, 1).m_171488_(-4.0F, 10.8555F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.3F)).m_171514_(52, 9).m_171488_(-1.0F, 10.8555F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).m_171514_(39, 2).m_171488_(-1.0F, 10.8555F, -2.2656F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.2F)).m_171514_(22, 51).m_171488_(2.5F, 10.8555F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).m_171514_(23, 54).m_171488_(2.5F, 10.8555F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).m_171514_(24, 55).m_171488_(4.0F, 10.8555F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).m_171514_(24, 55).m_171488_(4.0F, 10.8555F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).m_171514_(29, 11).m_171488_(3.5F, 3.0F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.27F)).m_171514_(31, 12).m_171488_(3.9F, 4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.27F)).m_171514_(31, 12).m_171480_().m_171488_(-3.9F, 4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.27F)).m_171555_(false).m_171514_(29, 11).m_171480_().m_171488_(-3.5F, 3.0F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.27F)).m_171555_(false).m_171514_(24, 55).m_171480_().m_171488_(-4.0F, 10.8555F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).m_171555_(false).m_171514_(22, 51).m_171480_().m_171488_(-2.5F, 10.8555F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).m_171555_(false).m_171514_(23, 54).m_171480_().m_171488_(-2.5F, 10.8555F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.35F)).m_171555_(false).m_171514_(24, 55).m_171480_().m_171488_(-4.0F, 10.8555F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.35F)).m_171555_(false), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorRightArm", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(-8.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorLeftArm", CubeListBuilder.m_171558_().m_171514_(112, 0).m_171488_(4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorRightLeg", CubeListBuilder.m_171558_().m_171514_(0, 80).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(7, 42).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.28F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorLeftLeg", CubeListBuilder.m_171558_().m_171514_(16, 112).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(7, 42).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.28F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 128, 128);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorBody.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
