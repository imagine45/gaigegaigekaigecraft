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

public class ModelPiercing_Ox<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_piercing_ox"), "main");
   public final ModelPart head;
   public final ModelPart body;
   public final ModelPart LeftLeg;
   public final ModelPart RightLeg;
   public final ModelPart LeftArm;
   public final ModelPart RightArm;

   public ModelPiercing_Ox(ModelPart root) {
      this.head = root.getChild("head");
      this.body = root.getChild("body");
      this.LeftLeg = root.getChild("LeftLeg");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftArm = root.getChild("LeftArm");
      this.RightArm = root.getChild("RightArm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 42).addBox(-7.0F, -8.0F, -12.0F, 14.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.5F, -1.0F, -18.0F, 11.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 96).addBox(-5.5F, -1.0F, -17.0F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.1F)).texOffs(-2, -2).addBox(-5.5F, 5.4F, -18.0F, 11.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(3, 3).addBox(-5.5F, 3.0F, -14.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(76, 109).addBox(-7.5F, 0.5F, -20.0F, 15.0F, 8.0F, 11.0F, new CubeDeformation(-2.25F)).texOffs(110, 3).addBox(-2.5F, -1.2F, -18.2F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(90, 0).addBox(6.0F, -7.9F, -11.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(90, 0).addBox(7.5F, -11.4F, -11.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)).texOffs(90, 0).mirror().addBox(-11.5F, -11.4F, -11.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false).texOffs(90, 0).mirror().addBox(-10.0F, -7.9F, -11.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 111).addBox(-6.5F, -11.2F, -15.2F, 13.0F, 10.0F, 7.0F, new CubeDeformation(-2.9F)), PartPose.offset(0.0F, 2.0F, -17.0F));
      head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(91, 0).mirror().addBox(-3.2F, -1.6F, -2.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-9.5F, -12.4F, -9.5F, 0.0F, 0.0F, -0.7854F));
      head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(91, 0).addBox(-0.8F, -1.6F, -2.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(9.5F, -12.4F, -9.5F, 0.0F, 0.0F, 0.7854F));
      head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(41, 124).addBox(-5.5F, -1.5F, 0.6F, 11.0F, 3.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 8.4F, -16.8F, 0.3927F, 0.0F, 0.0F));
      PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0F, -23.0F, 24.0F, 20.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.0F, -24.0F, -22.0F, 22.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.0F, 0.0F, -22.0F, 22.0F, 18.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-9.0F, 12.0F, -21.0F, 18.0F, 9.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 4.0F, 1.5708F, 0.0F, 0.0F));
      body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(116, 22).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 34.7782F, -18.7279F, -0.9553F, -0.5236F, 0.6155F));
      body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(116, 22).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 34.7782F, -18.7279F, -0.9553F, 0.5236F, -0.6155F));
      body.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.5F, -4.5F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 27.0F, -6.0F, -0.7854F, 0.0F, 0.0F));
      body.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -9.0F, -5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, -6.0F, -0.3927F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(106, 0).addBox(-1.5F, 22.0F, 1.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(8.0F, 0.0F, 14.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -7.0F, -2.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.5F, 15.884F, 5.799F, -0.2618F, 0.0F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.6618F, 4.5794F, 2.3108F, 0.2618F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(106, 0).mirror().addBox(-2.5F, 22.0F, 1.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(-8.0F, 0.0F, 14.0F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -7.0F, -2.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 15.884F, 5.799F, -0.2618F, 0.0F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(-0.6618F, 4.5794F, 2.3108F, 0.2618F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, 20.0F, -9.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(10.0F, 2.0F, -6.0F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.6618F, 3.5794F, -0.6892F, 0.3927F, 0.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(2.0F, 14.0F, -3.0F, -0.5236F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(106, 0).mirror().addBox(-3.5F, 20.0F, -9.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(-10.0F, 2.0F, -6.0F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -9.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(-1.6618F, 3.5794F, -0.6892F, 0.3927F, 0.0F, 0.0F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -5.0F, -1.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 14.0F, -3.0F, -0.5236F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.yRot = netHeadYaw / 57.295776F;
      this.head.xRot = headPitch / 57.295776F;
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightArm.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.LeftArm.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
