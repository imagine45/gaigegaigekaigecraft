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

public class Modeldagon1<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("gaigegaigekaigecraft", "modeldagon_1"), "main");
   public final ModelPart bone6;

   public Modeldagon1(ModelPart root) {
      this.bone6 = root.getChild("bone6");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(0.0F, 21.76F, 0.0F));
      PartDefinition bone5 = bone6.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.32F, 0.96F, -2.24F, -0.2618F, 0.0F, 0.0F));
      PartDefinition bone4 = bone5.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(13, 57).addBox(-7.556F, -11.7584F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 57).addBox(-7.156F, -10.1984F, -6.88F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).texOffs(16, 56).addBox(-7.196F, -10.7984F, -6.88F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(10.836F, 0.9184F, 0.0F));
      bone4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(19, 54).addBox(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 54).addBox(-4.4F, -16.4F, -7.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(14, 55).addBox(-4.4F, -12.12F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      PartDefinition bone3 = bone5.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(13, 57).addBox(-7.556F, -11.7584F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 57).addBox(-7.156F, -10.1984F, -6.56F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).texOffs(16, 56).addBox(-7.196F, -10.7984F, -6.56F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.956F, 0.9184F, 0.0F));
      bone3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(19, 54).addBox(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(15, 54).addBox(-4.4F, -16.4F, -7.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 55).addBox(-4.4F, -12.12F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      PartDefinition bone2 = bone5.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(13, 57).addBox(-7.556F, -11.7584F, -6.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 57).addBox(-7.156F, -10.1984F, -5.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).texOffs(16, 56).addBox(-7.196F, -10.7984F, -5.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.404F, 0.9184F, -11.84F, 0.0F, 3.1416F, 0.0F));
      bone2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(19, 54).addBox(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(11, 54).addBox(-4.4F, -16.4F, -6.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(15, 55).addBox(-4.4F, -12.12F, -6.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      PartDefinition bone = bone5.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(16, 57).addBox(-7.156F, -10.1984F, -7.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.32F)).texOffs(16, 56).addBox(-7.196F, -10.7984F, -7.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 57).addBox(-7.556F, -11.7584F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.156F, 0.9184F, 0.0F));
      bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(19, 54).addBox(-4.4F, -16.0F, -6.56F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
      bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(15, 54).mirror().addBox(-4.4F, -16.4F, -7.56F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offsetAndRotation(-1.4147F, -0.4152F, 0.0F, 0.0F, 0.0F, -0.1309F));
      bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(14, 55).addBox(-4.4F, -12.12F, -7.56F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-5.1538F, -0.0433F, 0.0F, 0.0F, 0.0F, 0.1745F));
      bone6.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(60, 0).addBox(-8.0F, -1.88F, -6.68F, 16.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(50, 37).addBox(-7.0F, -9.88F, -5.68F, 14.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 37).addBox(-7.0F, -21.84F, -5.68F, 14.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      bone6.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 0).addBox(-8.32F, -27.28F, -6.68F, 16.0F, 23.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(4, 39).addBox(-6.32F, -26.08F, -4.68F, 12.0F, 1.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.offset(0.32F, 3.2F, 0.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
