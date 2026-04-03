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

public class ModelDivineDog<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_divine_dog"), "main");
   public final ModelPart Head;
   public final ModelPart NeckHair;
   public final ModelPart BodyMain;
   public final ModelPart RightArm;
   public final ModelPart LeftArm;
   public final ModelPart RightLeg;
   public final ModelPart LeftLeg;
   public final ModelPart Tail;

   public ModelDivineDog(ModelPart root) {
      this.Head = root.getChild("Head");
      this.NeckHair = root.getChild("NeckHair");
      this.BodyMain = root.getChild("BodyMain");
      this.RightArm = root.getChild("RightArm");
      this.LeftArm = root.getChild("LeftArm");
      this.RightLeg = root.getChild("RightLeg");
      this.LeftLeg = root.getChild("LeftLeg");
      this.Tail = root.getChild("Tail");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 5).addBox(-1.6131F, -2.6F, -3.2685F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-0.6131F, -1.5F, -6.0685F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(10, 0).addBox(-1.1131F, -1.2F, -5.7685F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-1.1131F, 0.5F, -5.2685F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.1131F, 9.6F, -10.7315F));
      Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-0.2F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.2869F, -3.1F, -0.7685F, -0.2182F, 0.0F, 0.2182F));
      Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(26, 0).addBox(-1.8F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.5131F, -3.1F, -0.7685F, -0.2182F, 0.0F, -0.2182F));
      Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.4262F, -19.973F, -14.8042F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.3131F, 2.473F, 19.9357F, 0.7854F, 0.0F, 0.0F));
      PartDefinition NeckHair = partdefinition.addOrReplaceChild("NeckHair", CubeListBuilder.create(), PartPose.offset(20.6985F, 3.1893F, -4.526F));
      NeckHair.addOrReplaceChild("BodyMain_r1", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.5F, -2.4F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-20.6985F, 10.3287F, -7.2363F, -1.5272F, 0.0F, 0.0F));
      NeckHair.addOrReplaceChild("BodyMain_r2", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-20.6985F, 5.4924F, -6.8375F, -0.3055F, 0.4929F, 2.6897F));
      NeckHair.addOrReplaceChild("BodyMain_r3", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-24.1011F, 8.4737F, -4.8213F, -0.7167F, 0.4882F, 1.4423F));
      NeckHair.addOrReplaceChild("BodyMain_r4", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-20.6985F, 5.4924F, -5.8375F, -0.5856F, 0.5567F, 1.9062F));
      NeckHair.addOrReplaceChild("BodyMain_r5", CubeListBuilder.create().texOffs(16, 9).addBox(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-17.2958F, 8.4737F, -4.8213F, -0.7167F, -0.4882F, -1.4423F));
      NeckHair.addOrReplaceChild("BodyMain_r6", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-20.6985F, 5.4924F, -5.8375F, -0.5856F, -0.5567F, -1.9062F));
      NeckHair.addOrReplaceChild("BodyMain_r7", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-20.6985F, 5.4924F, -6.8375F, -0.8384F, 0.6142F, 1.7659F));
      NeckHair.addOrReplaceChild("BodyMain_r8", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-2.1F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-24.1011F, 8.4737F, -5.8213F, -0.9572F, 0.4483F, 1.3333F));
      NeckHair.addOrReplaceChild("BodyMain_r9", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-23.2324F, 9.4081F, -7.318F, -1.3573F, 0.4969F, 0.6107F));
      NeckHair.addOrReplaceChild("BodyMain_r10", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, -0.6F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-18.1646F, 9.4081F, -7.318F, -1.3573F, -0.4969F, -0.6107F));
      NeckHair.addOrReplaceChild("BodyMain_r11", CubeListBuilder.create().texOffs(16, 9).addBox(-0.9F, 0.4F, -2.7F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-17.2958F, 8.4737F, -5.8213F, -0.9572F, -0.4483F, -1.3333F));
      NeckHair.addOrReplaceChild("BodyMain_r12", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 1.4476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-20.6985F, 5.4924F, -6.8375F, -0.0873F, 0.0F, -3.1416F));
      NeckHair.addOrReplaceChild("BodyMain_r13", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-20.6985F, 5.4924F, -6.8375F, -0.8384F, -0.6142F, -1.7659F));
      NeckHair.addOrReplaceChild("BodyMain_r14", CubeListBuilder.create().texOffs(16, 9).addBox(-1.5F, 0.9476F, 1.4719F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-20.6985F, 5.4924F, -6.8375F, -0.3055F, -0.4929F, -2.6897F));
      PartDefinition BodyMain = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -15.5F, -1.0F, 5.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(1, 16).addBox(-2.5F, -15.5F, -8.0F, 5.0F, 7.0F, 9.0F, new CubeDeformation(0.2F)).texOffs(0, 20).addBox(-3.5F, -15.0F, -9.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).texOffs(0, 20).addBox(-3.0F, -14.0F, -6.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)).texOffs(8, 23).addBox(-2.0F, -15.5F, -10.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 25.0F, 0.0F));
      BodyMain.addOrReplaceChild("BodyMain_r15", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -2.5F, -3.5F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -14.1998F, -8.3884F, -0.5236F, 0.0F, 0.0F));
      PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(22, 3).mirror().addBox(-0.6F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-2.8F, 12.3249F, -7.6021F));
      RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.5F, -5.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.4F, 5.5664F, 2.4562F, 0.3927F, 0.0F, 0.0F));
      RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 9.6751F, 1.6021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(22, 3).addBox(-1.4F, 10.6751F, -0.3979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(2.8F, 12.3249F, -7.6021F));
      LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -5.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.4F, 5.5664F, 2.4562F, 0.3927F, 0.0F, 0.0F));
      LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -4.6F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 9.6751F, 1.6021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(22, 3).mirror().addBox(-0.6F, 10.6751F, -0.2979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-2.8F, 12.3249F, 5.0979F));
      RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.5F, -6.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, -3.0F, -2.4F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.4F, 5.92F, 3.5168F, 0.3927F, 0.0F, 0.0F));
      RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, -4.7F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 9.6751F, 1.7021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(22, 3).addBox(-1.4F, 10.6751F, -0.2979F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(2.8F, 12.3249F, 5.0979F));
      LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -6.0F, -1.4F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.7451F, 1.0349F, 0.3927F, 0.0F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -3.0F, -2.4F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.4F, 5.92F, 3.5168F, 0.3927F, 0.0F, 0.0F));
      LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -4.7F, -0.7F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 9.6751F, 1.7021F, -0.2182F, 0.0F, 0.0F));
      PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.1F, 9.1766F, 8.8331F));
      Tail.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -1.7247F, 0.613F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(0, 24).addBox(-1.0F, -1.7247F, -4.387F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 3.6481F, 2.9539F, -0.3927F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.NeckHair.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.BodyMain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.RightArm.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.Head.yRot = netHeadYaw / 57.295776F;
      this.Head.xRot = headPitch / 57.295776F;
      this.LeftArm.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.Tail.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
