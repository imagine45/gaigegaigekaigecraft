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

public class Modelcursedspirit3_12<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelcursedspirit_3_12"), "main");
   public final ModelPart bone;

   public Modelcursedspirit3_12(ModelPart root) {
      this.bone = root.getChild("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 164).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 8.0F, 20.0F, new CubeDeformation(1.0F)).texOffs(0, 7).addBox(-10.0F, -59.5F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(0.1F)).texOffs(80, 172).addBox(-8.5F, -62.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(0, 131).addBox(-12.5F, -16.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(0.0F)).texOffs(0, 39).addBox(-13.5F, -48.0F, -13.5F, 27.0F, 8.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(0, 74).addBox(-16.5F, -40.0F, -16.5F, 33.0F, 24.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 131).addBox(-12.5F, -4.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-3.6957F, -18.8729F, 0.0F, 0.0F, -1.5708F, -0.5236F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-10.0F, -6.0F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-2.0278F, -49.6462F, 0.0F, 0.0F, -1.5708F, 0.3927F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(80, 172).addBox(-8.5F, -1.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.1929F, -57.5975F, 0.0F, 0.0F, -1.5708F, 0.3927F));
      bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 131).addBox(-12.5F, -4.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, -18.8729F, 3.6957F, -0.5236F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(112, 35).addBox(-10.0F, -6.0F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(0.0F, -49.6462F, 2.0278F, 0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(80, 172).addBox(-8.5F, -1.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -57.5975F, 1.1929F, 0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 131).addBox(-12.5F, -4.0F, -12.5F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(3.6957F, -18.8729F, 0.0F, 0.0F, 1.5708F, 0.5236F));
      bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-13.5F, -4.0F, -13.5F, 27.0F, 8.0F, 27.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-2.5496F, -38.2932F, 0.0F, 0.0F, 0.0F, 0.3927F));
      bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 39).addBox(-13.5F, -4.0F, -13.5F, 27.0F, 8.0F, 27.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(2.5496F, -38.2932F, 0.0F, 0.0F, 0.0F, -0.3927F));
      bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(84, 0).addBox(-13.5F, 1.3442F, -15.4313F, 27.0F, 8.0F, 27.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, -43.9697F, 2.2887F, 0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 7).addBox(-10.0F, -6.0F, -10.0F, 20.0F, 12.0F, 20.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(2.0278F, -49.6462F, 0.0F, 0.0F, 1.5708F, -0.3927F));
      bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(80, 172).addBox(-8.5F, -1.5F, -8.5F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(1.1929F, -57.5975F, 0.0F, 0.0F, 1.5708F, -0.3927F));
      bone.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 39).addBox(-13.5F, -3.9F, -13.1F, 27.0F, 8.0F, 27.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -38.478F, -2.4731F, -0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 131).addBox(-12.5F, -9.8F, -8.8F, 25.0F, 8.0F, 25.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, -12.0F, -4.0F, 0.5236F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(80, 172).addBox(-8.5F, 2.1F, -8.3F, 17.0F, 3.0F, 17.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -61.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 7).addBox(-10.0F, -2.12F, -7.99F, 20.0F, 12.0F, 20.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, -54.0F, -2.4F, -0.3927F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 192, 192);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
