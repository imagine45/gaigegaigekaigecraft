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

public class ModelMahitoHand4<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "model_mahito_hand_4"), "main");
   public final ModelPart hand_main;

   public ModelMahitoHand4(ModelPart root) {
      this.hand_main = root.getChild("hand_main");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition hand_main = partdefinition.addOrReplaceChild("hand_main", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, -17.0F));
      PartDefinition head = hand_main.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -1.0F));
      head.addOrReplaceChild("haed_r1", CubeListBuilder.create().texOffs(66, 49).addBox(30.0F, -7.0F, 8.4F, 9.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 29.0F, 0.0F, 1.5708F, 0.0F));
      head.addOrReplaceChild("haed_r2", CubeListBuilder.create().texOffs(66, 49).mirror().addBox(-39.0F, -7.0F, 8.4F, 9.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 29.0F, 0.0F, -1.5708F, 0.0F));
      head.addOrReplaceChild("haed_r3", CubeListBuilder.create().texOffs(4, 44).addBox(-7.5F, -0.8F, -6.5F, 15.0F, 1.0F, 13.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(0.0F, 10.6383F, -6.3074F, 1.5708F, 1.3963F, 1.5708F));
      head.addOrReplaceChild("haed_r4", CubeListBuilder.create().texOffs(0, 40).addBox(-9.0F, -1.0F, -8.5F, 17.0F, 1.0F, 17.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(0.0F, 8.5222F, -8.313F, 1.5708F, 1.3526F, 1.5708F));
      head.addOrReplaceChild("haed_r5", CubeListBuilder.create().texOffs(3, 3).addBox(-8.0F, 0.0F, -7.5F, 15.0F, 2.0F, 15.0F, new CubeDeformation(1.0F)).texOffs(0, 40).addBox(-8.0F, -4.0F, -8.5F, 16.0F, 4.0F, 17.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(0.0F, -11.5222F, -8.313F, 1.5708F, 1.3526F, -1.5708F));
      head.addOrReplaceChild("haed_r6", CubeListBuilder.create().texOffs(5, 5).addBox(-12.5F, -4.0F, -6.5F, 17.0F, 2.0F, 13.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(0.0F, -17.2717F, -6.5262F, 1.5708F, 1.3526F, -1.5708F));
      PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(4.5F, -6.9853F, -16.7122F));
      bone.addOrReplaceChild("haed_r7", CubeListBuilder.create().texOffs(0, 117).addBox(-1.0335F, -2.6942F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5251F, -1.1243F, 2.6601F));
      bone.addOrReplaceChild("haed_r8", CubeListBuilder.create().texOffs(0, 117).addBox(-1.5216F, -3.0024F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7974F, -1.2635F, 2.3682F));
      bone.addOrReplaceChild("haed_r9", CubeListBuilder.create().texOffs(0, 117).addBox(-1.9665F, -3.3058F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3765F, -1.3484F, 1.7698F));
      bone.addOrReplaceChild("haed_r10", CubeListBuilder.create().texOffs(0, 117).addBox(-1.4784F, -3.0024F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.7974F, 1.2635F, -2.3682F));
      bone.addOrReplaceChild("haed_r11", CubeListBuilder.create().texOffs(0, 117).addBox(-1.0335F, -3.3058F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 1.3765F, 1.3484F, -1.7698F));
      bone.addOrReplaceChild("haed_r12", CubeListBuilder.create().texOffs(0, 117).addBox(-1.9665F, -2.6942F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.5251F, 1.1243F, -2.6601F));
      bone.addOrReplaceChild("haed_r13", CubeListBuilder.create().texOffs(0, 117).addBox(-1.0335F, -3.3058F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 13.9707F, 1.0F, -0.5251F, -1.1243F, -2.6601F));
      bone.addOrReplaceChild("haed_r14", CubeListBuilder.create().texOffs(0, 117).addBox(-1.9665F, -2.6942F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 13.9707F, 1.0F, -1.3765F, -1.3484F, -1.7698F));
      bone.addOrReplaceChild("haed_r15", CubeListBuilder.create().texOffs(0, 117).addBox(-1.5216F, -2.9976F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 13.9707F, 1.0F, -0.7974F, -1.2635F, -2.3682F));
      bone.addOrReplaceChild("haed_r16", CubeListBuilder.create().texOffs(0, 117).addBox(-1.0335F, -2.6942F, -5.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-9.0F, 13.9707F, 1.0F, -1.3765F, 1.3484F, 1.7698F));
      bone.addOrReplaceChild("haed_r17", CubeListBuilder.create().texOffs(0, 117).addBox(-1.4784F, -2.9976F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-9.0F, 13.9707F, 1.0F, -0.7974F, 1.2635F, 2.3682F));
      bone.addOrReplaceChild("haed_r18", CubeListBuilder.create().texOffs(0, 117).addBox(-1.9665F, -3.3058F, 0.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-9.0F, 13.9707F, 1.0F, -0.5251F, 1.1243F, 2.6601F));
      PartDefinition body1 = hand_main.addOrReplaceChild("body1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.9378F, -1.1068F));
      body1.addOrReplaceChild("body2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(17.0F, -11.0F, -9.0F, 12.0F, 22.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-10.0F, -10.0F, -10.0F, 40.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0622F, 29.1068F, 0.0F, 1.5708F, 0.0F));
      PartDefinition body2 = body1.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset(0.0F, -0.0311F, 32.4466F));
      body2.addOrReplaceChild("body2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.8577F, -13.8708F, -10.0F, 40.0F, 20.0F, 20.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 32.0F, 1.5708F, 1.4835F, 1.5708F));
      PartDefinition body3 = body2.addOrReplaceChild("body3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 27.0F));
      body3.addOrReplaceChild("body3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-35.049F, -14.2189F, -10.0F, 40.0F, 20.0F, 20.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -1.5708F, 1.3963F, -1.5708F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.hand_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.hand_main.yRot = netHeadYaw / 57.295776F;
      this.hand_main.xRot = headPitch / 57.295776F;
   }
}
