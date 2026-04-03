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

public class Modelcursedspirit3_3<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_3"), "main");
   public final ModelPart Head;
   public final ModelPart Tail;
   public final ModelPart FinDorsal;
   public final ModelPart FinVentral;
   public final ModelPart BodyMain;

   public Modelcursedspirit3_3(ModelPart root) {
      this.Head = root.getChild("Head");
      this.Tail = root.getChild("Tail");
      this.FinDorsal = root.getChild("FinDorsal");
      this.FinVentral = root.getChild("FinVentral");
      this.BodyMain = root.getChild("BodyMain");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 8.1707F, -4.037F));
      PartDefinition HeadMain = Head.addOrReplaceChild("HeadMain", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-1.0F, 1.4054F, -6.5612F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(7, 24).mirror().addBox(-1.0F, -0.2F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(7, 24).mirror().addBox(-0.5F, -0.2F, -11.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(7, 24).mirror().addBox(-0.5F, 1.4175F, -9.1891F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(7, 24).mirror().addBox(-0.5F, 1.4175F, -10.1891F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offset(0.0F, 0.085F, -0.3209F));
      HeadMain.addOrReplaceChild("HeadMain_r1", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-2.0F, -1.5F, -3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(7, 24).mirror().addBox(-1.0F, -1.5F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(7, 24).mirror().addBox(-1.0F, -1.5F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(7, 24).mirror().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r2", CubeListBuilder.create().texOffs(7, 24).addBox(-0.0733F, -0.4976F, -2.412F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.915F, -6.6791F, 0.0F, 0.1745F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r3", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-0.9267F, -0.4976F, -2.412F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.915F, -6.6791F, 0.0F, -0.1745F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r4", CubeListBuilder.create().texOffs(7, 24).addBox(-0.7F, -0.9F, -0.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.1495F, -4.0284F, 0.0873F, -0.2618F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r5", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-0.3F, -0.9F, -0.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -0.1495F, -4.0284F, 0.0873F, 0.2618F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r6", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-0.6F, -0.5F, -1.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.2075F, -0.0773F, -9.4692F, 0.0873F, -0.1309F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r7", CubeListBuilder.create().texOffs(7, 24).addBox(-0.4F, -0.5F, -1.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2075F, -0.0773F, -9.4692F, 0.0873F, 0.1309F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r8", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-1.5F, -0.4F, -1.3F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.9054F, -2.4612F, -0.0873F, 0.0F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r9", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-1.0F, -0.5F, -5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.3275F, -0.567F, -0.3927F, 0.0F, 0.0F));
      HeadMain.addOrReplaceChild("HeadMain_r10", CubeListBuilder.create().texOffs(7, 24).mirror().addBox(-1.0F, -0.5F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.7578F, -1.6346F, -0.2618F, 0.0F, 0.0F));
      PartDefinition Eye = Head.addOrReplaceChild("Eye", CubeListBuilder.create(), PartPose.offset(0.3F, 0.085F, -0.6209F));
      Eye.addOrReplaceChild("Eye_r1", CubeListBuilder.create().texOffs(24, 4).mirror().addBox(-3.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.4363F));
      Eye.addOrReplaceChild("Eye_r2", CubeListBuilder.create().texOffs(24, 4).addBox(1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.6F, 0.0F, 0.0F, 0.0F, -0.0873F, -0.4363F));
      PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 5.0F));
      PartDefinition Tail1 = Tail.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(6, 23).mirror().addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.25F, 0.5F));
      Tail1.addOrReplaceChild("Tail1_r1", CubeListBuilder.create().texOffs(22, -2).mirror().addBox(0.0F, 6.0F, -0.8F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.75F, -2.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(9, 26).mirror().addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(16, 16).mirror().addBox(-1.0F, -1.5F, 1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(0.0F, -0.25F, 3.5F));
      PartDefinition FinCaudal = Tail2.addOrReplaceChild("FinCaudal", CubeListBuilder.create(), PartPose.offset(0.0F, 0.175F, 2.5584F));
      FinCaudal.addOrReplaceChild("FinCaudal_r1", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(0.0F, -1.5895F, -3.134F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.7653F, 2.7195F, -1.0908F, 0.0F, 0.0F));
      FinCaudal.addOrReplaceChild("FinCaudal_r2", CubeListBuilder.create().texOffs(0, -3).addBox(0.8767F, -2.7412F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7653F, 2.7195F, -0.5236F, 0.2182F, -0.3927F));
      FinCaudal.addOrReplaceChild("FinCaudal_r3", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(-0.8767F, -2.7412F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.7653F, 2.7195F, -0.5236F, -0.2182F, 0.3927F));
      FinCaudal.addOrReplaceChild("FinCaudal_r4", CubeListBuilder.create().texOffs(0, -3).addBox(0.8767F, -2.2588F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7653F, 2.7195F, 0.5236F, 0.2182F, 0.3927F));
      FinCaudal.addOrReplaceChild("FinCaudal_r5", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(0.0F, -3.4105F, -3.134F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.7653F, 2.7195F, 1.0908F, 0.0F, 0.0F));
      FinCaudal.addOrReplaceChild("FinCaudal_r6", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(-0.8767F, -2.2588F, -3.1761F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.7653F, 2.7195F, 0.5236F, -0.2182F, -0.3927F));
      PartDefinition FinDorsal = partdefinition.addOrReplaceChild("FinDorsal", CubeListBuilder.create(), PartPose.offset(-0.5F, 6.3381F, -0.0315F));
      FinDorsal.addOrReplaceChild("FinDorsal_r1", CubeListBuilder.create().texOffs(6, -9).mirror().addBox(0.0F, -2.5F, -4.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, -0.2182F, -0.3927F));
      FinDorsal.addOrReplaceChild("FinDorsal_r2", CubeListBuilder.create().texOffs(6, -9).mirror().addBox(0.0F, -2.5F, -4.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -2.2304F, -0.9239F, 0.9163F, 0.0F, 0.0F));
      FinDorsal.addOrReplaceChild("FinDorsal_r3", CubeListBuilder.create().texOffs(6, -9).addBox(0.0F, -2.5F, -4.5F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.3927F, 0.2182F, 0.3927F));
      PartDefinition FinVentral = partdefinition.addOrReplaceChild("FinVentral", CubeListBuilder.create(), PartPose.offset(1.0F, 25.5F, 3.0F));
      PartDefinition RightFinVentral = FinVentral.addOrReplaceChild("RightFinVentral", CubeListBuilder.create(), PartPose.offset(-3.2154F, -14.9618F, -5.6485F));
      RightFinVentral.addOrReplaceChild("RightFinVentral_r1", CubeListBuilder.create().texOffs(24, -4).addBox(0.0267F, -2.6016F, -2.1649F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4998F, -2.0E-4F, 0.9976F, -0.3491F, -0.7854F, 0.0F));
      RightFinVentral.addOrReplaceChild("RightFinVentral_r2", CubeListBuilder.create().texOffs(24, -4).addBox(-0.0563F, -1.5252F, -1.5984F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4998F, -2.0E-4F, 0.9976F, -0.7418F, -1.0036F, -0.0436F));
      PartDefinition LeftFinVentral = FinVentral.addOrReplaceChild("LeftFinVentral", CubeListBuilder.create(), PartPose.offset(1.2154F, -14.9618F, -5.6485F));
      LeftFinVentral.addOrReplaceChild("LeftFinVentral_r1", CubeListBuilder.create().texOffs(24, -4).mirror().addBox(-0.0267F, -2.6016F, -2.1649F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.4998F, -2.0E-4F, 0.9976F, -0.3491F, 0.7854F, 0.0F));
      LeftFinVentral.addOrReplaceChild("LeftFinVentral_r2", CubeListBuilder.create().texOffs(24, -4).mirror().addBox(0.0563F, -1.5252F, -1.5984F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.4998F, -2.0E-4F, 0.9976F, -0.7418F, 1.0036F, 0.0436F));
      partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-3.5F, -19.5F, -6.5F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 26.0F, 3.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.FinDorsal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.FinVentral.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.BodyMain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Tail.yRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * limbSwingAmount;
   }
}
