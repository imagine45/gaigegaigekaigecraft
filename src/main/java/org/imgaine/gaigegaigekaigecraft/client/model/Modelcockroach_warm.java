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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Modelcockroach_warm<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcockroach_warm"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart right_arm;
   public final ModelPart right_arm2;
   public final ModelPart right_arm3;
   public final ModelPart left_arm;
   public final ModelPart left_arm2;
   public final ModelPart left_arm3;

   public Modelcockroach_warm(ModelPart root) {
      this.head = root.getChild("head");
      this.body = root.getChild("body");
      this.right_arm = root.getChild("right_arm");
      this.right_arm2 = root.getChild("right_arm2");
      this.right_arm3 = root.getChild("right_arm3");
      this.left_arm = root.getChild("left_arm");
      this.left_arm2 = root.getChild("left_arm2");
      this.left_arm3 = root.getChild("left_arm3");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 19.6495F, -3.7131F));
      head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(2.0996F, -3.3241F, 1.1727F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, -2.3582F, 0.4658F, 2.8627F));
      head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(2.0996F, -3.1094F, 2.8351F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, -1.1801F, 0.4658F, 2.8627F));
      head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(2.0996F, -3.0611F, 3.7988F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, -0.3947F, 0.4658F, 2.8627F));
      head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 4).addBox(-1.5F, 1.0794F, -1.5809F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -1.5311F, -2.3161F, 2.7925F, 0.0F, 3.1416F));
      head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(5, 5).addBox(-3.0996F, -3.0611F, 3.7988F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, -0.3947F, -0.4658F, -2.8627F));
      head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(5, 5).addBox(-3.0996F, -3.1094F, 2.8351F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, -1.1801F, -0.4658F, -2.8627F));
      head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(5, 5).addBox(-3.0996F, -3.3241F, 1.1727F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, -2.3582F, -0.4658F, -2.8627F));
      head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(6, 6).mirror().addBox(0.2F, -1.05F, 1.3F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(6, 6).mirror().addBox(0.5F, -1.05F, 1.2F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(6, 6).mirror().addBox(0.8F, -1.05F, 1.1F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(6, 6).addBox(-0.2F, -1.05F, 1.3F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(6, 6).addBox(-0.5F, -1.05F, 1.2F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(6, 6).addBox(-0.8F, -1.05F, 1.1F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(3, 3).addBox(-1.5F, -0.55F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.4582F, -1.9039F, 3.1416F, 0.0F, 3.1416F));
      head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(6, 6).mirror().addBox(0.2F, 0.5595F, 2.3722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(6, 6).mirror().addBox(0.5F, 0.5595F, 2.2722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(6, 6).mirror().addBox(0.8F, 0.5595F, 2.1722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(6, 6).addBox(-0.2F, 0.5595F, 2.3722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(6, 6).addBox(-0.5F, 0.5595F, 2.2722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(2, 2).addBox(-1.5F, -0.2405F, -1.5278F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.1F)).texOffs(6, 6).addBox(-0.8F, 0.5595F, 2.1722F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(2, 2).mirror().addBox(-2.0F, 0.2595F, -1.5278F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(2, 2).addBox(1.0F, 0.2595F, -1.5278F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.309F, -1.8147F, 2.7925F, 0.0F, 3.1416F));
      head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(18, 21).addBox(-2.8062F, -0.4922F, 3.2219F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, 3.1416F, 0.0F, -2.4435F));
      head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(18, 21).mirror().addBox(0.8062F, -0.4922F, 3.2219F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, 3.1416F, 0.0F, 2.4435F));
      head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(7, 1).mirror().addBox(0.7F, -0.616F, 2.4119F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(7, 1).addBox(-2.7F, -0.616F, 2.4119F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(4, 4).addBox(-2.0F, -1.616F, -1.2881F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(1, 1).addBox(-2.5F, -0.616F, -1.7881F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.3874F, -1.2161F, 3.1416F, 0.0F, 3.1416F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 21.9994F, 2.5657F));
      body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(1, 1).addBox(-2.5F, -6.9351F, -3.8067F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.6581F, 0.0F, 3.1416F));
      body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.6464F, -3.3536F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -0.7132F, 2.7841F, 1.6581F, 0.0F, 3.1416F));
      body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(5, 5).addBox(-2.0F, -3.0F, 0.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.479F, -0.9293F, 1.6581F, -0.1745F, -2.8798F));
      body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-2.0F, -3.0F, 0.5F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -5.479F, -0.9293F, 1.6581F, 0.1745F, 2.8798F));
      body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(1, 1).addBox(-2.5F, -0.4521F, -3.298F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -0.7132F, 2.7841F, 1.8326F, 0.0F, 3.1416F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-0.9325F, 23.0843F, -2.7419F));
      right_arm.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-0.3F, -4.474F, 0.3358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -0.6F, -0.5F, 1.6023F, 0.6621F, -0.8259F));
      right_arm.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-3.4F, -0.6F, -0.5F, 0.4912F, 1.3157F, -0.7499F));
      PartDefinition right_arm2 = partdefinition.addOrReplaceChild("right_arm2", CubeListBuilder.create(), PartPose.offset(-0.7325F, 22.9843F, 2.4581F));
      right_arm2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-0.5F, -4.074F, 0.2358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-3.7F, -0.5F, -0.7F, -2.8349F, 1.5448F, 1.0324F));
      right_arm2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-3.6F, -0.5F, -0.7F, 0.4912F, 1.3157F, -0.7499F));
      PartDefinition right_arm3 = partdefinition.addOrReplaceChild("right_arm3", CubeListBuilder.create(), PartPose.offset(-0.7325F, 23.2843F, 5.8419F));
      right_arm3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-0.2F, -5.574F, -1.2358F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -1.0F, 0.4F, -1.6013F, -0.6185F, -0.8275F));
      right_arm3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-0.5F, -0.9092F, -1.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(-3.6F, -0.8F, 0.4F, -0.4912F, -1.3157F, -0.7499F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.9325F, 23.0843F, -2.7419F));
      left_arm.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(5, 5).addBox(-0.7F, -4.474F, 0.3358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.5F, -0.6F, -0.5F, 1.6023F, -0.6621F, 0.8259F));
      left_arm.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(5, 5).addBox(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(3.4F, -0.6F, -0.5F, 0.4912F, -1.3157F, 0.7499F));
      PartDefinition left_arm2 = partdefinition.addOrReplaceChild("left_arm2", CubeListBuilder.create(), PartPose.offset(0.7325F, 22.9843F, 2.4581F));
      left_arm2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(5, 5).addBox(-0.5F, -4.074F, 0.2358F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.7F, -0.5F, -0.7F, -2.8349F, -1.5448F, -1.0324F));
      left_arm2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(5, 5).addBox(-0.5F, -0.9092F, 0.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(3.6F, -0.5F, -0.7F, 0.4912F, -1.3157F, 0.7499F));
      PartDefinition left_arm3 = partdefinition.addOrReplaceChild("left_arm3", CubeListBuilder.create(), PartPose.offset(0.7325F, 23.2843F, 5.8419F));
      left_arm3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(5, 5).addBox(-0.8F, -5.574F, -1.2358F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 0.4F, -1.6013F, 0.6185F, 0.8275F));
      left_arm3.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(5, 5).addBox(-0.5F, -0.9092F, -1.2107F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(3.6F, -0.8F, 0.4F, -0.4912F, 1.3157F, 0.7499F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.left_arm3.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_arm2.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_arm2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_arm3.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
