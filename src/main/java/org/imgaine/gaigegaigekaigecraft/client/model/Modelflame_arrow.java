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

public class Modelflame_arrow<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modelflame_arrow"), "main");
   public final ModelPart Body;

   public Modelflame_arrow(ModelPart root) {
      this.Body = root.getChild("Body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));
      PartDefinition boneMain = Body.addOrReplaceChild("boneMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -10.5F));
      PartDefinition bone1 = boneMain.addOrReplaceChild("bone1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone1.addOrReplaceChild("bone1_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone1.addOrReplaceChild("bone1_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone1.addOrReplaceChild("bone1_r3", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone1.addOrReplaceChild("bone1_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone1.addOrReplaceChild("bone1_r5", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone2 = boneMain.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
      bone2.addOrReplaceChild("bone2_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("bone2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("bone2_r3", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("bone2_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone2.addOrReplaceChild("bone2_r5", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone3 = boneMain.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
      bone3.addOrReplaceChild("bone3_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("bone3_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("bone3_r3", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("bone3_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone3.addOrReplaceChild("bone3_r5", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone4 = boneMain.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));
      bone4.addOrReplaceChild("bone2_r6", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("bone2_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("bone2_r8", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("bone2_r9", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone4.addOrReplaceChild("bone2_r10", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone5 = boneMain.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
      bone5.addOrReplaceChild("bone3_r6", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("bone3_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("bone3_r8", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("bone3_r9", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone5.addOrReplaceChild("bone3_r10", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone6 = boneMain.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));
      bone6.addOrReplaceChild("bone4_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("bone4_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("bone4_r3", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("bone4_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("bone4_r5", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone7 = boneMain.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
      bone7.addOrReplaceChild("bone5_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone7.addOrReplaceChild("bone5_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone7.addOrReplaceChild("bone5_r3", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone7.addOrReplaceChild("bone5_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone7.addOrReplaceChild("bone5_r5", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      PartDefinition bone8 = boneMain.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
      bone8.addOrReplaceChild("bone6_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -0.1F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -1.1688F, 3.0303F, 0.0873F, 0.0F, 0.0F));
      bone8.addOrReplaceChild("bone6_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1F, 0.3F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(0.0F, -1.0066F, 2.0385F, 0.2618F, 0.0F, 0.0F));
      bone8.addOrReplaceChild("bone6_r3", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.17F)), PartPose.offsetAndRotation(0.0F, -1.9244F, 4.6913F, 0.4363F, 0.0F, 0.0F));
      bone8.addOrReplaceChild("bone6_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -1.0F, -2.4F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.346F, 5.2721F, 0.6109F, 0.0F, 0.0F));
      bone8.addOrReplaceChild("bone6_r5", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, -0.3F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));
      Body.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -0.5F, 13.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(2, 2).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-0.5F, -0.5F, 7.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)).texOffs(0, 0).mirror().addBox(-0.5F, -0.5F, 1.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(0.0F, 0.0F, -10.5F));
      return LayerDefinition.create(meshdefinition, 14, 14);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.Body.yRot = netHeadYaw / 57.295776F;
      this.Body.xRot = headPitch / 57.295776F;
   }
}
