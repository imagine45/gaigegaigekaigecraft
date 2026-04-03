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

public class Modelmahito_phase2<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelmahito_phase_2"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;

   public Modelmahito_phase2(ModelPart root) {
      this.head = root.getChild("head");
      this.body = root.getChild("body");
      this.right_arm = root.getChild("right_arm");
      this.left_arm = root.getChild("left_arm");
      this.right_leg = root.getChild("right_leg");
      this.left_leg = root.getChild("left_leg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.51F)).texOffs(32, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition head_parts = head.addOrReplaceChild("head_parts", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.6861F, 4.4222F, -0.1745F, 0.0F, 0.0F));
      head_parts.addOrReplaceChild("head_parts_r1", CubeListBuilder.create().texOffs(-11, 52).addBox(2.5343F, -3.1866F, 5.1107F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0006F, 10.565F, -0.3562F, 0.3911F, -0.0361F));
      head_parts.addOrReplaceChild("head_parts_r2", CubeListBuilder.create().texOffs(-12, 51).addBox(2.5343F, -0.8298F, -2.2893F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0006F, 10.565F, 0.0365F, 0.3911F, -0.0361F));
      head_parts.addOrReplaceChild("head_parts_r3", CubeListBuilder.create().texOffs(-12, 52).addBox(2.5343F, -1.615F, -12.3305F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0006F, 10.565F, 0.5164F, 0.3911F, -0.0361F));
      head_parts.addOrReplaceChild("head_parts_r4", CubeListBuilder.create().texOffs(-11, 52).addBox(-8.5343F, -3.1866F, 5.1107F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0006F, 10.565F, -0.3562F, -0.3911F, 0.0361F));
      head_parts.addOrReplaceChild("head_parts_r5", CubeListBuilder.create().texOffs(-12, 51).addBox(-8.5343F, -0.8298F, -2.2893F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0006F, 10.565F, 0.0365F, -0.3911F, 0.0361F));
      head_parts.addOrReplaceChild("head_parts_r6", CubeListBuilder.create().texOffs(-12, 52).addBox(-8.5343F, -1.615F, -12.3305F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0006F, 10.565F, 0.5164F, -0.3911F, 0.0361F));
      head_parts.addOrReplaceChild("head_parts_r7", CubeListBuilder.create().texOffs(-11, 52).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.3076F, 13.3413F, -0.2618F, 0.0F, 0.0F));
      head_parts.addOrReplaceChild("head_parts_r8", CubeListBuilder.create().texOffs(-12, 51).addBox(-3.0F, -1.1602F, -0.9642F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 8.5F, 0.1309F, 0.0F, 0.0F));
      head_parts.addOrReplaceChild("head_parts_r9", CubeListBuilder.create().texOffs(-12, 52).addBox(-3.0F, -1.2962F, -11.0025F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 8.5F, 0.6109F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -1.9464F, 3.9481F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.7436F, 1.3668F, -0.5236F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(14, 0).addBox(-0.5F, 1.0F, 2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 4.7972F, 17.8149F, 0.6981F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.75F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.4F)), PartPose.offsetAndRotation(0.0F, 4.7972F, 17.8149F, 0.3054F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.0F, 4.7972F, 17.8149F, 0.1309F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r4", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -4.75F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 7.711F, 19.5676F, -0.0873F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r5", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -1.9352F, -1.1607F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, 3.7721F, 14.3861F, -0.3491F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r6", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -1.874F, -3.1268F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 3.5721F, 14.3861F, -0.7418F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r7", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -1.9F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 1.9916F, 12.754F, -0.6109F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -3.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.5473F, 9.9559F, -0.2182F, 0.0F, 0.0F));
      tail.addOrReplaceChild("tail_r9", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.3705F, 2.3258F, 0.1745F, 0.0F, 0.0F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
      right_arm.addOrReplaceChild("right_blade", CubeListBuilder.create().texOffs(28, -18).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 5.5F, 1.5F, -1.0392F, 0.2396F, -3.1333F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
      left_arm.addOrReplaceChild("left_blade", CubeListBuilder.create().texOffs(28, -18).mirror().addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 5.5F, 1.5F, -1.0392F, -0.2396F, 3.1333F));
      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)), PartPose.offset(-2.0F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.21F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
