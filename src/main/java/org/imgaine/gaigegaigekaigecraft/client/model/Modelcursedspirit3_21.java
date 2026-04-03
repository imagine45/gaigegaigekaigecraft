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

public class Modelcursedspirit3_21<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_21"), "main");
   public final ModelPart body;
   public final ModelPart left_leg;
   public final ModelPart right_leg;
   public final ModelPart right_leg2;
   public final ModelPart left_leg2;
   public final ModelPart left_arm;
   public final ModelPart right_arm;
   public final ModelPart head;

   public Modelcursedspirit3_21(ModelPart root) {
      this.body = root.getChild("body");
      this.left_leg = root.getChild("left_leg");
      this.right_leg = root.getChild("right_leg");
      this.right_leg2 = root.getChild("right_leg2");
      this.left_leg2 = root.getChild("left_leg2");
      this.left_arm = root.getChild("left_arm");
      this.right_arm = root.getChild("right_arm");
      this.head = root.getChild("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(40, 48).addBox(-4.0F, -17.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 12.0F, -7.0F));
      body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-5.0F, -6.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -5.6391F, 27.6136F, 2.0508F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(1.0F, -1.6391F, 15.6136F, 1.6581F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(1.0F, -1.2455F, 21.2706F, 1.5272F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.offsetAndRotation(1.0F, -1.2455F, 7.7706F, 1.3526F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.925F)), PartPose.offsetAndRotation(1.0F, -3.2455F, 16.2706F, 1.5272F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -6.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(1.0F, -1.3891F, 23.8636F, 1.2654F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -6.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.95F)), PartPose.offsetAndRotation(1.0F, -3.3891F, 7.8636F, 1.6581F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(40, 56).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(0.0F, -0.6716F, 3.5711F, 0.6981F, 0.0F, 0.0F));
      body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(40, 52).mirror().addBox(2.0F, -6.0F, -2.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.9F)).mirror(false), PartPose.offsetAndRotation(-6.9406F, -9.6194F, 0.0F, 0.0F, 0.0F, -0.3927F));
      body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(40, 52).addBox(-4.0F, -6.0F, -2.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.offsetAndRotation(6.9406F, -9.6194F, 0.0F, 0.0F, 0.0F, 0.3927F));
      body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(40, 48).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.9F)), PartPose.offsetAndRotation(0.0F, -10.6683F, 2.3393F, 0.3054F, 0.0F, 0.0F));
      PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(5.0F, 8.0F, -3.0F));
      left_leg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 45).mirror().addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(5.0577F, 9.1299F, 0.0F, -0.7854F, 0.0F, 1.7453F));
      left_leg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(44, 44).addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, 1.1781F));
      left_leg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(44, 44).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.3927F));
      PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-5.0F, 8.0F, -3.0F));
      right_leg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 45).addBox(-3.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(-4.3631F, 13.0691F, 0.0F, -0.7854F, 0.0F, -1.7453F));
      right_leg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(44, 44).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(-2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, -1.1781F));
      right_leg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(44, 44).addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, -0.3927F));
      PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offset(-5.0F, 8.0F, 8.0F));
      right_leg2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 45).addBox(-3.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)), PartPose.offsetAndRotation(-4.3631F, 13.0691F, 0.0F, -0.7854F, 0.0F, -1.7453F));
      right_leg2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(44, 44).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(-2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, -1.1781F));
      right_leg2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(44, 44).addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, -0.3927F));
      PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(5.0F, 8.0F, 8.0F));
      left_leg2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 45).mirror().addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.45F)).mirror(false), PartPose.offsetAndRotation(5.0577F, 9.1299F, 0.0F, -0.7854F, 0.0F, 1.7453F));
      left_leg2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(44, 44).addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(2.5834F, 1.9598F, 0.0F, -0.7854F, 0.0F, 1.1781F));
      left_leg2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(44, 44).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.3927F));
      PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(6.0F, -4.0F, -7.5F));
      left_arm.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(41, 48).mirror().addBox(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 1.0F, -0.5F, 0.0F, 0.0F, -0.1745F));
      left_arm.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(42, 48).mirror().addBox(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(2.7663F, 12.216F, -0.5F, 0.0F, 0.0F, 0.1309F));
      left_arm.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 45).mirror().addBox(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3953F, 26.4116F, 0.5F, -0.7854F, 0.0F, 2.9234F));
      left_arm.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 45).mirror().addBox(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.4726F, 24.414F, 0.5F, -0.7854F, 0.0F, 2.5307F));
      left_arm.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 45).mirror().addBox(1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(2.5577F, 20.1299F, 0.5F, -0.7854F, 0.0F, 2.138F));
      left_arm.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 49).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.14F)), PartPose.offsetAndRotation(0.0F, 0.75F, -0.5F, -0.7854F, 0.0F, 0.3927F));
      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-6.0F, -4.0F, -7.5F));
      right_arm.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 45).addBox(-6.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-2.5577F, 20.1299F, 0.5F, -0.7854F, 0.0F, -2.138F));
      right_arm.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 45).addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.4726F, 24.414F, 0.5F, -0.7854F, 0.0F, -2.5307F));
      right_arm.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 45).addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3953F, 26.4116F, 0.5F, -0.7854F, 0.0F, -2.9234F));
      right_arm.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.14F)), PartPose.offsetAndRotation(0.0F, 0.75F, -0.5F, -0.7854F, 0.0F, -0.3927F));
      right_arm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(42, 48).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.7663F, 12.216F, -0.5F, 0.0F, 0.0F, -0.1309F));
      right_arm.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(41, 48).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, -0.5F, 0.0F, 0.0F, 0.1745F));
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 11).addBox(-2.7055F, -5.75F, -3.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(1, 14).addBox(-3.0F, -3.75F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(22, 11).addBox(-3.0F, 1.0F, -4.1F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(22, 11).addBox(-3.0F, -0.25F, -3.75F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 21).addBox(-3.0F, -0.75F, -4.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).texOffs(0, 25).addBox(-3.0F, 0.25F, -4.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(-0.2945F, -6.0F, -7.0F));
      head.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(1, 11).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-4.0177F, 4.4903F, -0.5F, 0.0F, 0.0F, 0.7854F));
      head.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -5.0F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.175F)), PartPose.offsetAndRotation(0.0177F, 2.4903F, -0.5F, 0.0F, 0.0F, -0.7854F));
      head.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 11).addBox(-4.0F, -5.0F, -3.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-0.0177F, 2.4903F, -1.3F, 0.0F, 0.0F, 0.7854F));
      head.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 11).addBox(-3.5F, -0.5429F, -1.6893F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9948F, -1.2758F, -0.2718F, 0.0F, 1.5708F, 0.3927F));
      head.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-2.5F, -4.4571F, -0.6893F, 5.0F, 8.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(3.9948F, -1.2758F, -0.2718F, 0.0F, 1.5708F, -0.3927F));
      head.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 11).addBox(-3.5F, -4.4571F, -0.6893F, 6.0F, 8.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.9948F, -1.2758F, -0.2718F, 0.0F, -1.5708F, 0.3927F));
      head.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 11).addBox(-3.5F, -2.5F, -0.5F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8425F, 2.723F, -0.3927F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(1, 11).addBox(-2.5F, -2.5F, -0.5F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.3942F, 2.723F, 0.3927F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(1, 11).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.3942F, -3.723F, -0.3927F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -5.0F, -4.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 1.25F, 0.3927F, 0.0F, 0.0F));
      head.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(56, 25).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6774F, -3.2362F, -2.5239F, -0.2222F, 0.0376F, -0.6077F));
      head.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(1, 11).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -0.5F, 0.0F, 0.0F, -0.1745F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
