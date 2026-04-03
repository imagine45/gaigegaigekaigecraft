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

public class Modelcursedspirit3_18<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_18"), "main");
   public final ModelPart head;
   public final ModelPart Body;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;

   public Modelcursedspirit3_18(ModelPart root) {
      this.head = root.getChild("head");
      this.Body = root.getChild("Body");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(8, 0).addBox(-4.0F, 11.0F, -21.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(79, 122).addBox(-4.0F, 10.7F, -21.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).texOffs(79, 122).addBox(-4.0F, 4.2F, -21.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).texOffs(0, 123).addBox(-4.0F, 9.0F, -21.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(8, 0).addBox(-7.0F, 1.0F, -20.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-3.0F, 0.0F, -20.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(8, 0).mirror().addBox(3.0F, 1.0F, -20.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(8, 0).mirror().addBox(7.0F, 2.0F, -19.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(8, 0).addBox(-11.0F, 2.0F, -19.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-8.0F, -6.0F, -18.0F, 16.0F, 21.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-6.0F, -8.0F, -16.0F, 12.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(112, 0).addBox(2.5F, -3.0F, -18.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(112, 0).mirror().addBox(-6.5F, -3.0F, -18.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(8, 0).addBox(5.0F, -3.0F, -16.0F, 5.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(8, 0).mirror().addBox(-10.0F, -3.0F, -16.0F, 5.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(8, 0).addBox(-4.0F, 2.0F, -21.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 1.0F));
      head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 123).addBox(-4.0F, -1.5F, -1.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 5.5F, -20.0F, 0.0F, 0.0F, -3.1416F));
      head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(84, 119).mirror().addBox(-3.8F, -1.5F, -6.2F, 1.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(84, 119).addBox(2.8F, -1.5F, -6.2F, 1.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)).texOffs(79, 121).addBox(-4.0F, -1.3F, -6.2F, 8.0F, 1.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 11.2F, -18.5F, -1.5708F, 0.0F, 0.0F));
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-12.5F, -11.5F, 10.5F, 25.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.5F, 19.5F, -0.3054F, 0.0F, 0.0F));
      Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(15, 0).mirror().addBox(-13.5F, -10.5F, -10.5F, 28.0F, 19.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -4.0F, 4.0F, -0.2618F, 0.0F, 0.0F));
      Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(17, 0).mirror().addBox(-12.5F, -13.9F, -12.5F, 26.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 4.0F, 4.0F, 0.5236F, 0.0F, 0.0F));
      Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(17, 0).addBox(-13.5F, -10.5F, -10.5F, 27.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -11.0F, -0.2618F, 0.0F, 0.0F));
      Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-14.5F, -10.5F, -10.5F, 29.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, -11.0F, 0.2618F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-11.3468F, -4.4608F, 2.3701F));
      RightArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(8, 0).addBox(-1.9911F, -4.9963F, -2.1253F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.0032F, 26.1644F, -20.0358F, -0.741F, 0.6943F, 1.0055F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-5.5164F, -4.3118F, -2.7574F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-12.0032F, 26.1644F, -20.0358F, -1.4939F, -0.5522F, -0.745F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-6.5145F, -3.0495F, -0.7214F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-12.0032F, 26.1644F, -20.0358F, -0.877F, -0.9552F, -0.7064F));
      RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-6.905F, -0.3272F, -0.5049F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-12.0032F, 26.1644F, -20.0358F, -0.8073F, -1.1064F, -0.7416F));
      RightArm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-6.5043F, 2.0154F, -0.9787F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-12.0032F, 26.1644F, -20.0358F, -0.2473F, -1.0975F, -1.2875F));
      RightArm.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-0.6023F, -3.8774F, -1.212F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0032F, 26.1644F, -20.0358F, -0.6154F, -0.7973F, -1.0399F));
      RightArm.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(17, 0).mirror().addBox(-8.0F, -4.0F, -4.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-3.0874F, 5.6898F, -2.6233F, -0.632F, -0.5542F, -0.9892F));
      RightArm.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-10.0F, -5.0F, -7.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.8382F, 17.536F, -7.1704F, -0.4768F, -0.4975F, -1.2665F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(11.3468F, -4.4608F, 2.3701F));
      LeftArm.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-6.0089F, -4.9963F, -2.1253F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(12.0032F, 26.1644F, -20.0358F, -0.741F, -0.6943F, -1.0055F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(8, 0).addBox(-2.4836F, -4.3118F, -2.7574F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(12.0032F, 26.1644F, -20.0358F, -1.4939F, 0.5522F, 0.745F));
      LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(8, 0).addBox(0.5145F, -3.0495F, -0.7214F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(12.0032F, 26.1644F, -20.0358F, -0.877F, 0.9552F, 0.7064F));
      LeftArm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(8, 0).addBox(-1.095F, -0.3272F, -0.5049F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(12.0032F, 26.1644F, -20.0358F, -0.8073F, 1.1064F, 0.7416F));
      LeftArm.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(8, 0).addBox(-1.4957F, 2.0154F, -0.9787F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(12.0032F, 26.1644F, -20.0358F, -0.2473F, 1.0975F, 1.2875F));
      LeftArm.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(8, 0).addBox(-7.3977F, -3.8774F, -1.212F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0032F, 26.1644F, -20.0358F, -0.6154F, 0.7973F, 1.0399F));
      LeftArm.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(17, 0).addBox(-8.0F, -4.0F, -4.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(3.0874F, 5.6898F, -2.6233F, -0.632F, 0.5542F, 0.9892F));
      LeftArm.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(0, 19).addBox(-6.0F, -5.0F, -7.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8382F, 17.536F, -7.1704F, -0.4768F, 0.4975F, 1.2665F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-6.8281F, 4.1539F, 34.3889F));
      RightLeg.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(8, 0).addBox(2.3479F, -4.2851F, 3.2732F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, -1.1078F, 0.4485F, 0.804F));
      RightLeg.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-9.9015F, -6.5424F, 2.1692F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, -1.1083F, -0.8097F, -0.9916F));
      RightLeg.addOrReplaceChild("RightArm_r10", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-9.4198F, -2.9402F, 5.6049F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, -0.1785F, -1.1742F, -1.3266F));
      RightLeg.addOrReplaceChild("RightArm_r11", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-9.2569F, -0.2928F, 6.0482F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, 0.2052F, -1.2611F, -1.6927F));
      RightLeg.addOrReplaceChild("RightArm_r12", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-9.6857F, 1.9243F, 5.2137F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, 0.5978F, -1.0574F, -2.0418F));
      RightLeg.addOrReplaceChild("RightArm_r13", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-5.0339F, -3.9332F, 4.1577F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, -0.0382F, -0.9213F, -1.483F));
      RightLeg.addOrReplaceChild("RightArm_r14", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-3.5701F, -5.3243F, -10.2318F, 19.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, 0.0197F, -1.0476F, -1.4893F));
      RightLeg.addOrReplaceChild("RightArm_r15", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-8.7795F, -5.1083F, -2.1129F, 17.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9882F, 10.6082F, -5.9699F, -0.0755F, 1.2592F, -1.5853F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(6.8281F, 4.1539F, 34.3889F));
      LeftLeg.addOrReplaceChild("RightArm_r16", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-10.3479F, -4.2851F, 3.2732F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, -1.1078F, -0.4485F, -0.804F));
      LeftLeg.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(8, 0).addBox(1.9015F, -6.5424F, 2.1692F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, -1.1083F, 0.8097F, 0.9916F));
      LeftLeg.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().texOffs(8, 0).addBox(3.4198F, -2.9402F, 5.6049F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, -0.1785F, 1.1742F, 1.3266F));
      LeftLeg.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().texOffs(8, 0).addBox(1.2569F, -0.2928F, 6.0482F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, 0.2052F, 1.2611F, 1.6927F));
      LeftLeg.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().texOffs(8, 0).addBox(1.6857F, 1.9243F, 5.2137F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, 0.5978F, 1.0574F, 2.0418F));
      LeftLeg.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(8, 0).addBox(-2.9661F, -3.9332F, 4.1577F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, -0.0382F, 0.9213F, 1.483F));
      LeftLeg.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(8, 0).addBox(-15.4299F, -5.3243F, -10.2318F, 19.0F, 10.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, 0.0197F, 1.0476F, 1.4893F));
      LeftLeg.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(8, 0).addBox(-8.2205F, -5.1083F, -2.1129F, 17.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9882F, 10.6082F, -5.9699F, -0.0755F, -1.2592F, 1.5853F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
