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
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelclothes_zenin"), "main");
   public final ModelPart armorHead;
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;
   public final ModelPart armorRightBoot;
   public final ModelPart armorLeftBoot;

   public Modelclothes_zenin(ModelPart root) {
      this.armorHead = root.getChild("armorHead");
      this.armorBody = root.getChild("armorBody");
      this.armorRightArm = root.getChild("armorRightArm");
      this.armorLeftArm = root.getChild("armorLeftArm");
      this.armorRightLeg = root.getChild("armorRightLeg");
      this.armorLeftLeg = root.getChild("armorLeftLeg");
      this.armorRightBoot = root.getChild("armorRightBoot");
      this.armorLeftBoot = root.getChild("armorLeftBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 48).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      PartDefinition armorRightLeg = partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(37, 1).addBox(-1.8352F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r1", CubeListBuilder.create().texOffs(37, 1).addBox(-4.3187F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.0233F, 12.4681F, -5.1187F, 0.0F, 1.5708F, 0.1309F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r2", CubeListBuilder.create().texOffs(37, 1).addBox(-5.1059F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5415F, 12.2139F, -4.1669F, -0.1396F, 0.7854F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r3", CubeListBuilder.create().texOffs(37, 1).addBox(-1.0422F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).texOffs(37, 1).addBox(-3.7F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r4", CubeListBuilder.create().texOffs(37, 1).addBox(-0.6363F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.3624F, 12.2139F, -1.5208F, -0.1396F, -0.7854F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r5", CubeListBuilder.create().texOffs(37, 1).addBox(-0.4234F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.7654F, 12.4681F, -1.3766F, 0.0F, -1.5708F, -0.1309F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r6", CubeListBuilder.create().texOffs(37, 1).addBox(-0.6363F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.3624F, 12.2139F, 1.5208F, 0.1396F, 0.7854F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r7", CubeListBuilder.create().texOffs(37, 1).addBox(-0.0718F, -11.3883F, 7.3117F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(37, 1).addBox(-0.4234F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r8", CubeListBuilder.create().texOffs(37, 1).addBox(-1.9282F, -10.8844F, 11.0539F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(7.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r9", CubeListBuilder.create().texOffs(37, 1).addBox(-2.3999F, -11.8344F, 1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r10", CubeListBuilder.create().texOffs(37, 1).addBox(-3.7F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).texOffs(37, 1).addBox(-1.0422F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r11", CubeListBuilder.create().texOffs(37, 1).addBox(-5.1059F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5415F, 12.2139F, 4.1669F, 0.1396F, -0.7854F, 0.0F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r12", CubeListBuilder.create().texOffs(37, 1).addBox(-4.3187F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.0233F, 12.4681F, 5.1187F, 0.0F, -1.5708F, 0.1309F));
      armorRightLeg.addOrReplaceChild("right_leg_leggins_r13", CubeListBuilder.create().texOffs(37, 1).addBox(-0.8882F, -11.8344F, -1.9915F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(37, 0).addBox(-2.3999F, -11.8344F, -1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      PartDefinition armorLeftLeg = partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(37, 1).mirror().addBox(-2.1648F, -0.0648F, -1.9F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.14F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r1", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.3187F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.0233F, 12.4681F, -5.1187F, 0.0F, -1.5708F, -0.1309F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r2", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.1059F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.5415F, 12.2139F, -4.1669F, -0.1396F, -0.7854F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r3", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(0.0422F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(37, 1).mirror().addBox(2.7F, -11.7799F, -1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1506F, -1.4885F, -0.1309F, 0.0F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r4", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-1.3637F, -11.7254F, -2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.3624F, 12.2139F, -1.5208F, -0.1396F, 0.7854F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r5", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-0.5766F, -11.3883F, -7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(3.7654F, 12.4681F, -1.3766F, 0.0F, 1.5708F, 0.1309F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r6", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-1.3637F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.3624F, 12.2139F, 1.5208F, 0.1396F, -0.7854F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r7", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-1.9282F, -11.3883F, 7.3117F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(37, 1).mirror().addBox(-0.5766F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(3.7654F, 12.4681F, 1.3766F, 0.0F, -1.5708F, 0.1309F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r8", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-0.0718F, -10.8844F, 11.0539F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-7.7654F, 12.4681F, 1.3766F, 0.0F, 1.5708F, -0.1309F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r9", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(0.3999F, -11.8344F, 1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1354F, 1.4409F, 0.1309F, 0.0F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r10", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(2.7F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(37, 1).mirror().addBox(0.0422F, -11.7799F, 1.8931F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1506F, 1.4885F, 0.1309F, 0.0F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r11", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.1059F, -11.7254F, 2.0077F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.5415F, 12.2139F, 4.1669F, 0.1396F, 0.7854F, 0.0F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r12", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(3.3187F, -11.3883F, 7.3F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.0233F, 12.4681F, 5.1187F, 0.0F, 1.5708F, -0.1309F));
      armorLeftLeg.addOrReplaceChild("left_leg_leggins_r13", CubeListBuilder.create().texOffs(37, 1).mirror().addBox(-0.1118F, -11.8344F, -1.9915F, 1.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(37, 0).mirror().addBox(0.3999F, -11.8344F, -1.9915F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 12.1354F, -1.4409F, -0.1309F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).texOffs(0, 20).addBox(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).texOffs(0, 20).addBox(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).texOffs(0, 15).addBox(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(0, 15).addBox(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(0, 15).addBox(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 20).mirror().addBox(-4.0F, 10.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-1.8F)).mirror(false).texOffs(0, 20).mirror().addBox(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).mirror(false).texOffs(0, 20).mirror().addBox(-4.0F, 10.0F, -1.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-1.81F)).mirror(false).texOffs(0, 15).mirror().addBox(0.0F, 10.99F, -1.99F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(0, 15).mirror().addBox(-2.0F, 10.9F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false).texOffs(0, 15).mirror().addBox(-2.0F, 11.0F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.19F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
