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

public class Modelclothes_zenin<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraft", "modelclothes_zenin"), "main");
   public final ModelPart armorHead;
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;
   public final ModelPart armorRightBoot;
   public final ModelPart armorLeftBoot;

   public Modelclothes_zenin(ModelPart root) {
      this.armorHead = root.m_171324_("armorHead");
      this.armorBody = root.m_171324_("armorBody");
      this.armorRightArm = root.m_171324_("armorRightArm");
      this.armorLeftArm = root.m_171324_("armorLeftArm");
      this.armorRightLeg = root.m_171324_("armorRightLeg");
      this.armorLeftLeg = root.m_171324_("armorLeftLeg");
      this.armorRightBoot = root.m_171324_("armorRightBoot");
      this.armorLeftBoot = root.m_171324_("armorLeftBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition armorHead = partdefinition.m_171599_("armorHead", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorBody", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorRightArm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 48).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("armorLeftArm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 48).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      PartDefinition armorRightLeg = partdefinition.m_171599_("armorRightLeg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(37, 1).m_171488_(-1.8352F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r1", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-4.3187F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(4.0233F, 12.4681F, -5.1187F, 0.0F, 1.5708F, 0.1309F));
      armorRightLeg.m_171599_("right_leg_leggins_r2", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-5.1059F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.5415F, 12.2139F, -4.1669F, -0.1396F, 0.7854F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r3", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-1.0422F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171514_(37, 1).m_171488_(-3.7F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r4", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.6363F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.3624F, 12.2139F, -1.5208F, -0.1396F, -0.7854F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r5", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.4234F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-3.7654F, 12.4681F, -1.3766F, 0.0F, -1.5708F, -0.1309F));
      armorRightLeg.m_171599_("right_leg_leggins_r6", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.6363F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.3624F, 12.2139F, 1.5208F, 0.1396F, 0.7854F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r7", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.0718F, -11.3883F, 7.3117F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(37, 1).m_171488_(-0.4234F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(-3.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      armorRightLeg.m_171599_("right_leg_leggins_r8", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-1.9282F, -10.8844F, 11.0539F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(7.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      armorRightLeg.m_171599_("right_leg_leggins_r9", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-2.3999F, -11.8344F, 1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r10", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-3.7F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171514_(37, 1).m_171488_(-1.0422F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r11", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-5.1059F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(1.5415F, 12.2139F, 4.1669F, 0.1396F, -0.7854F, 0.0F));
      armorRightLeg.m_171599_("right_leg_leggins_r12", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-4.3187F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(4.0233F, 12.4681F, 5.1187F, 0.0F, -1.5708F, 0.1309F));
      armorRightLeg.m_171599_("right_leg_leggins_r13", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171488_(-0.8882F, -11.8344F, -1.9915F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171514_(37, 0).m_171488_(-2.3999F, -11.8344F, -1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      PartDefinition armorLeftLeg = partdefinition.m_171599_("armorLeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(37, 1).m_171480_().m_171488_(-2.1648F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r1", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.3187F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-4.0233F, 12.4681F, -5.1187F, 0.0F, -1.5708F, -0.1309F));
      armorLeftLeg.m_171599_("left_leg_leggins_r2", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.1059F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.5415F, 12.2139F, -4.1669F, -0.1396F, -0.7854F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r3", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(0.0422F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(37, 1).m_171480_().m_171488_(2.7F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r4", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-1.3637F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.3624F, 12.2139F, -1.5208F, -0.1396F, 0.7854F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r5", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-0.5766F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(3.7654F, 12.4681F, -1.3766F, 0.0F, 1.5708F, 0.1309F));
      armorLeftLeg.m_171599_("left_leg_leggins_r6", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-1.3637F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.3624F, 12.2139F, 1.5208F, 0.1396F, -0.7854F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r7", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-1.9282F, -11.3883F, 7.3117F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(37, 1).m_171480_().m_171488_(-0.5766F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(3.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      armorLeftLeg.m_171599_("left_leg_leggins_r8", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-0.0718F, -10.8844F, 11.0539F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-7.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      armorLeftLeg.m_171599_("left_leg_leggins_r9", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(0.3999F, -11.8344F, 1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r10", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(2.7F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(37, 1).m_171480_().m_171488_(0.0422F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r11", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.1059F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-1.5415F, 12.2139F, 4.1669F, 0.1396F, 0.7854F, 0.0F));
      armorLeftLeg.m_171599_("left_leg_leggins_r12", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(3.3187F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-4.0233F, 12.4681F, 5.1187F, 0.0F, 1.5708F, -0.1309F));
      armorLeftLeg.m_171599_("left_leg_leggins_r13", CubeListBuilder.m_171558_().m_171514_(37, 1).m_171480_().m_171488_(-0.1118F, -11.8344F, -1.9915F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false).m_171514_(37, 0).m_171480_().m_171488_(0.3999F, -11.8344F, -1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorRightBoot", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 20).m_171488_(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).m_171514_(0, 20).m_171488_(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171514_(0, 20).m_171488_(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171514_(0, 15).m_171488_(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).m_171514_(0, 15).m_171488_(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).m_171514_(0, 15).m_171488_(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorLeftBoot", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 20).m_171480_().m_171488_(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).m_171555_(false).m_171514_(0, 20).m_171480_().m_171488_(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171555_(false).m_171514_(0, 20).m_171480_().m_171488_(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorHead.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorBody.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
