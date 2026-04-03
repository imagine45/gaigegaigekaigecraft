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

public class Modelskull1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelskull_1"), "main");
   public final ModelPart bone;

   public Modelskull1(ModelPart root) {
      this.bone = root.getChild("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(30, 50).addBox(-37.0F, -7.0F, 2.0F, 14.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(9, 29).addBox(-38.0F, -7.6F, 3.0F, 16.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(9, 29).addBox(-39.0F, -5.0F, 5.0F, 18.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(2, 28).addBox(-40.0F, -10.0F, 12.0F, 20.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(1, 31).addBox(-41.0F, -6.92F, 13.0F, 22.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(3, 30).addBox(-42.0F, -7.0F, 27.0F, 24.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-40.0F, -13.0F, 25.0F, 20.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(9, 29).addBox(-42.0F, -18.0F, 28.0F, 24.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(8, 28).addBox(-42.0F, -17.0F, 32.96F, 24.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(9, 29).addBox(-42.0F, -13.0F, 22.0F, 24.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-40.7F, 3.9F, 22.9F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-20.7F, 3.9F, 22.9F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-40.7F, 3.9F, 20.2F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-20.7F, 3.9F, 20.4F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-40.7F, 3.9F, 14.9F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-20.7F, 3.9F, 15.2F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-22.4F, 3.9F, 7.9F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-38.8F, 3.9F, 7.9F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-40.7F, 3.9F, 17.6F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-20.7F, 3.9F, 17.6F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-22.4F, 3.9F, 10.6F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-38.8F, 3.9F, 10.6F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-40.7F, 3.9F, 12.6F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-20.7F, 3.9F, 12.6F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 13).addBox(-22.4F, 3.9F, 5.4F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-38.8F, 3.9F, 5.4F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 29).addBox(-42.0F, -8.0F, 25.0F, 24.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 29).addBox(-42.0F, -16.0F, 25.0F, 24.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(2, 29).addBox(-41.0F, -20.0F, 33.0F, 22.0F, 19.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 49).addBox(-39.0F, -22.2F, 32.0F, 18.0F, 5.0F, 10.0F, new CubeDeformation(0.1F)).texOffs(9, 29).addBox(-39.0F, -20.0F, 41.0F, 18.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, 18.0F, -24.0F));
      bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(9, 29).addBox(-5.5F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-15.5F, -18.2F, 37.0F, 0.0F, 0.0F, -0.1309F));
      bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 8).mirror().addBox(1.5361F, 0.8699F, -2.5F, 6.0F, 5.0F, 5.0F, new CubeDeformation(-2.0F)).mirror(false), PartPose.offsetAndRotation(-5.8059F, -23.3797F, 37.0F, 0.0F, 0.0F, -1.5708F));
      bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(15, 6).addBox(-4.1F, -2.9F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(-57.9641F, -27.1158F, 37.0F, 0.0F, 0.0F, 1.5708F));
      bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(15, 8).mirror().addBox(0.8339F, 0.1639F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.5F)).mirror(false), PartPose.offsetAndRotation(-5.8059F, -23.3797F, 37.0F, 0.0F, 0.0F, -1.3963F));
      bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(27, 6).mirror().addBox(-0.0676F, -2.1276F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.5F)).mirror(false).texOffs(27, 6).mirror().addBox(-2.2578F, -2.0674F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)).mirror(false).texOffs(27, 6).mirror().addBox(-1.9578F, -1.8674F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)).mirror(false).texOffs(27, 6).mirror().addBox(-2.7169F, -1.9375F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.1922F, -4.1215F, 32.9425F, 0.4363F, 0.0F, 0.2618F));
      bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(28, 0).addBox(-3.7324F, -1.9276F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.5F)).texOffs(28, 0).addBox(-2.5422F, -1.8674F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)).texOffs(28, 0).addBox(-0.8422F, -1.6674F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)).texOffs(28, 0).addBox(0.9169F, -1.7375F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-44.0479F, -4.2448F, 32.8579F, 0.4363F, 0.0F, -0.2618F));
      bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(15, 6).addBox(-1.7954F, -2.9521F, -2.5F, 6.0F, 5.0F, 5.0F, new CubeDeformation(-1.5F)), PartPose.offsetAndRotation(-57.9641F, -27.1158F, 37.0F, 0.0F, 0.0F, 1.3963F));
      bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(15, 8).mirror().addBox(-2.3795F, -1.1032F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)).mirror(false), PartPose.offsetAndRotation(-5.8059F, -23.3797F, 37.0F, 0.0F, 0.0F, -1.0472F));
      bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(15, 6).addBox(-8.1598F, -2.05F, -2.5F, 8.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-53.2444F, -20.1411F, 37.0F, 0.0F, 0.0F, 1.0472F));
      bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(15, 8).mirror().addBox(-6.4355F, -1.0918F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(-5.8059F, -23.3797F, 37.0F, 0.0F, 0.0F, -0.6109F));
      bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(15, 6).addBox(-3.2F, -3.2F, -2.5F, 8.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-53.2444F, -20.1411F, 37.0F, 0.0F, 0.0F, 0.6109F));
      bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(15, 8).mirror().addBox(-11.2555F, 0.3824F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.8059F, -23.3797F, 37.0F, 0.0F, 0.0F, -0.2618F));
      bone.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(15, 6).addBox(-5.0F, -2.5F, -2.5F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-46.0F, -18.2F, 37.0F, 0.0F, 0.0F, 0.2618F));
      bone.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(9, 29).addBox(2.0F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-46.0F, -18.2F, 37.0F, 0.0F, 0.0F, 0.1309F));
      bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(9, 29).addBox(-11.5F, -1.5F, -6.5F, 24.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-30.5F, -14.9F, 30.5F, 0.4363F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(9, 29).addBox(-11.5F, -2.5F, -1.5F, 24.0F, 5.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-30.5F, -14.9F, 30.5F, -0.2618F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(3, 54).addBox(-8.0F, -1.5F, -2.5F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, -19.3701F, 31.9507F, -1.1781F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(2, 52).addBox(-7.5F, -2.7F, -4.9F, 16.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.5F, -15.2155F, 30.0042F, -0.6545F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(9, 29).mirror().addBox(-8.0F, -8.0F, -3.5F, 16.0F, 7.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-30.0F, -4.3686F, 5.6305F, -1.3526F, 0.0F, 0.0F));
      bone.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 43).addBox(-7.5F, -16.0F, 5.5F, 16.0F, 16.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-30.5F, -15.0F, 9.5F, -1.1345F, 0.0F, 0.0F));
      return LayerDefinition.create(meshdefinition, 64, 64);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
